// instruction super class to encapsulate all instructions of vscript to a type
package Functionalities;

public abstract class Instruction {
    private final InstructionManager.InstructionType instructionType;
    private final String instructionName;

    public Instruction(InstructionManager.InstructionType instructionType,
                       String instructionName) {
        this.instructionType = instructionType;
        this.instructionName = instructionName;
        InstructionManager.typeMapper.put(instructionName,instructionType);
    }

    public abstract void execute();

    public InstructionManager.InstructionType getInstructionType(String instruction) {
        return InstructionManager.typeMapper.get(instruction);
    }

    public Instruction cloneInstruction(Instruction instance) {
        return new Instruction(instance.instructionType, instance.instructionName) {
            @Override
            public void execute() {
                instance.execute();
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
