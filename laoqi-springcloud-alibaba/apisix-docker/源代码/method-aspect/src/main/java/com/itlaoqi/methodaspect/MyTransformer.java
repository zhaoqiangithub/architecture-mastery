package com.itlaoqi.methodaspect;

import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.IllegalClassFormatException;
import java.security.ProtectionDomain;

import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.MethodVisitor;

public class MyTransformer implements ClassFileTransformer {
    @Override
    public byte[] transform(ClassLoader loader, String className, Class<?> classBeingRedefined,
            ProtectionDomain protectionDomain, byte[] classfileBuffer) throws IllegalClassFormatException {

        // Only modify classes in the "java.lang" package
        if (!className.startsWith("java/lang")) {
            return classfileBuffer;
        }

        try {
            // Use ASM to modify the bytecode of the class
            ClassReader reader = new ClassReader(classfileBuffer);
            ClassWriter writer = new ClassWriter(reader, ClassWriter.COMPUTE_MAXS);
            ClassVisitor visitor = new MyClassVisitor(writer);
            reader.accept(visitor, ClassReader.EXPAND_FRAMES);

            // Return the modified bytecode
            return writer.toByteArray();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    // A class visitor to modify method calls in the class
    private static class MyClassVisitor extends ClassVisitor {
        public MyClassVisitor(ClassWriter writer) {
            super(Opcodes.ASM7, writer);
        }

        @Override
        public MethodVisitor visitMethod(int access, String name, String descriptor, String signature,
                String[] exceptions) {
            MethodVisitor visitor = super.visitMethod(access, name, descriptor, signature, exceptions);

            // Only modify the "toString" method
            if (name.equals("toString")) {
                return new MyMethodVisitor(visitor);
            }

            return visitor;
        }
    }

    // A method visitor to modify the behavior of the "toString" method
    private static class MyMethodVisitor extends MethodVisitor {
        public MyMethodVisitor(MethodVisitor visitor) {
            super(Opcodes.ASM7, visitor);
        }

        @Override
        public void visitCode() {
            // Insert a call to the "System.out.println" method at the beginning of the method
            super.visitFieldInsn(Opcodes.GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
            super.visitLdcInsn("Modified toString method called!");
            super.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/io/PrintStream", "println", "(Ljava/lang/String;)V", false);

            super.visitCode();
        }
    }
}
