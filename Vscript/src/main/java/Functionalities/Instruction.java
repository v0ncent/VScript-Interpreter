// instruction super class to encapsulate all instructions of vscript to a type
package Functionalities;

import Functionalities.Instructions.Params.UnparsedParam;

public abstract class Instruction {
    private final InstructionManager.InstructionType instructionType;
    private final String instructionName;
    private UnparsedParam unparsedParams;

    public Instruction(InstructionManager.InstructionType instructionType,
                       String instructionName,
                       UnparsedParam unparsedParams) {
        this.instructionType = instructionType;
        this.instructionName = instructionName;
        this.unparsedParams = unparsedParams;
        InstructionManager.typeMapper.put(instructionName,instructionType);
    }

    public abstract void execute(String[] parsedParams);
    protected abstract String[] parseParams(UnparsedParam params);

    public InstructionManager.InstructionType getInstructionType(String instruction) {
        return InstructionManager.typeMapper.get(instruction);
    }

    public Instruction cloneInstruction(Instruction instance) {
        return new Instruction(instance.instructionType, instance.instructionName, instance.unparsedParams) {
            @Override
            public void execute(String[] parsedParams) {
                instance.execute(this.parseParams(instance.unparsedParams));
            }

            @Override
            public String[] parseParams(UnparsedParam params) {
                return instance.parseParams(params);
            }
        };
    }


    // getters / setters / override methods from object parent class
    public String getInstructionName() {
        return instructionName;
    }

    public InstructionManager.InstructionType getInstructionType() {
        return instructionType;
    }

    public UnparsedParam getUnparsedParams() {
        return unparsedParams;
    }

    public void setUnparsedParams(UnparsedParam unparsedParams) {
        this.unparsedParams = unparsedParams;
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
}
