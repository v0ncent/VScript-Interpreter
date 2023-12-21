// instruction super class to encapsulate all instructions of vscript to a type
package Functionalities;

public abstract class Instruction {
    private final InstructionManager.InstructionType instructionType;
    private final String instructionName;
    private final Object[] params;

    public Instruction(InstructionManager.InstructionType instructionType,
                       String instructionName,
                       Object[] params) {
        this.instructionType = instructionType;
        this.instructionName = instructionName;
        this.params = params;
        InstructionManager.typeMapper.put(instructionName,instructionType);
    }

    public abstract void execute(Object[] params);

    public InstructionManager.InstructionType getInstructionType(String instruction) {
        return InstructionManager.typeMapper.get(instruction);
    }

    public Instruction cloneInstruction(Instruction instance) {
        return new Instruction(instance.getInstructionType(), instance.getInstructionName(), instance.getParams()) {
            @Override
            public void execute(Object[] params) {
                instance.execute(params);
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
}
