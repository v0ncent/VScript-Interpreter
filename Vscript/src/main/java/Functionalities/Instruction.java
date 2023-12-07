// instruction super class to encapsulate all instructions of vscript to a type
package Functionalities;

public abstract class Instruction {
    private final InstructionManager.InstructionType instructionType;
    private final String instructionName;
    private String unparsedParams;

    public Instruction(InstructionManager.InstructionType instructionType,
                       String instructionName,
                       String unparsedParams) {
        this.instructionType = instructionType;
        this.instructionName = instructionName;
        this.unparsedParams = unparsedParams;
        InstructionManager.typeMapper.put(instructionName,instructionType);
    }

    public abstract void execute();
    protected abstract String[] parseParams(String params);

    public InstructionManager.InstructionType getInstructionType(String instruction) {
        return InstructionManager.typeMapper.get(instruction);
    }

    public Instruction cloneInstruction(Instruction instance) {
        return new Instruction(instance.instructionType, instance.instructionName, instance.unparsedParams) {
            @Override
            public void execute() {
                instance.execute();
            }

            @Override
            public String[] parseParams(String params) {
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

    public String getUnparsedParams() {
        return unparsedParams;
    }

    public void setUnparsedParams(String unparsedParams) {
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
