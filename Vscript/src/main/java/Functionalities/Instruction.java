// instruction super class to encapsulate all instructions of vscript to a type
package Functionalities;

import Exceptions.SyntaxException;
import Functionalities.Instructions.MathInstruction;
import Functionalities.Instructions.Print;

public abstract class Instruction {
    private final Instruction.InstructionType instructionType;
    private final String instructionName;
    private final Object[] params;

    public Instruction(Instruction.InstructionType instructionType,
                       String instructionName,
                       Object[] params) {
        this.instructionType = instructionType;
        this.instructionName = instructionName;
        this.params = params;
    }

    public abstract void execute(Object[] params, int currentLine) throws SyntaxException;

    public Instruction cloneInstruction(Object instance) {
        if (instance.getClass() != this.getClass()) {
            return null;
        }

        final Instruction instruction = (Instruction) instance;

        return new Instruction(instruction.getInstructionType(), instruction.getInstructionName(), instruction.getParams()) {
            @Override
            public void execute(Object[] params, int currentLineCount) throws SyntaxException {
                instruction.execute(params, currentLineCount);
            }
        };
    }


    // getters / setters / override methods from object parent class
    public String getInstructionName() {
        return instructionName;
    }

    public Instruction.InstructionType getInstructionType() {
        return instructionType;
    }

    public Object[] getParams() {
        return params;
    }

    @Override
    public boolean equals(Object obj) {
        if(this.getClass() != obj.getClass()) {
            return false;
        }

        return ((Instruction) obj).instructionName.equals(this.instructionName)
                &&
                ((Instruction) obj).instructionType.equals(this.instructionType);
    }

    // Class Utility
    public enum InstructionType {
        PRINT,
        MATH
    }

    public static Instruction executionHandler(InstructionType instructionType, Object[] params) {
        switch (instructionType) {
            case PRINT -> {
                return new Print(instructionType, "print", params);
            }
            case MATH -> {
                return new MathInstruction(instructionType, "mathinstruction", params);
            }
            default -> {
                return null;
            }
        }

    }

}
