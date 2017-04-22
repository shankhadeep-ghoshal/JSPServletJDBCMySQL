package PureJavaPackage;

/**
 * Created by Echo01 on 4/8/2017.
 */
public class sh1Class implements java.io.Serializable {
    private int id;
    private String firstname;
    private String lastname;
    private int physics;
    private int chemistry;
    private int maths;
    private int pti;
    private int cti;
    private int mti;
    private int teniaid;

    public sh1Class() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getPhysics() {
        return physics;
    }

    public void setPhysics(int physics) {
        this.physics = physics;
    }

    public int getChemistry() {
        return chemistry;
    }

    public void setChemistry(int chemistry) {
        this.chemistry = chemistry;
    }

    public int getMaths() {
        return maths;
    }

    public void setMaths(int maths) {
        this.maths = maths;
    }

    public int getPti() {
        return pti;
    }

    public void setPti(int pti) {
        this.pti = pti;
    }

    public int getCti() {
        return cti;
    }

    public void setCti(int cti) {
        this.cti = cti;
    }

    public int getMti() {
        return mti;
    }

    public void setMti(int mti) {
        this.mti = mti;
    }

    public int getTeniaid() {
        return teniaid;
    }

    public void setTeniaid(int teniaid) {
        this.teniaid = teniaid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof sh1Class)) return false;

        sh1Class sh1Class = (sh1Class) o;

        if (getId() != sh1Class.getId()) return false;
        if (getPhysics() != sh1Class.getPhysics()) return false;
        if (getChemistry() != sh1Class.getChemistry()) return false;
        if (getMaths() != sh1Class.getMaths()) return false;
        if (getPti() != sh1Class.getPti()) return false;
        if (getCti() != sh1Class.getCti()) return false;
        if (getMti() != sh1Class.getMti()) return false;
        if (getTeniaid() != sh1Class.getTeniaid()) return false;
        if (!getFirstname().equals(sh1Class.getFirstname())) return false;
        return getLastname().equals(sh1Class.getLastname());
    }

    @Override
    public int hashCode() {
        int result = getId();
        result = 31 * result + getFirstname().hashCode();
        result = 31 * result + getLastname().hashCode();
        result = 31 * result + getPhysics();
        result = 31 * result + getChemistry();
        result = 31 * result + getMaths();
        result = 31 * result + getPti();
        result = 31 * result + getCti();
        result = 31 * result + getMti();
        result = 31 * result + getTeniaid();
        return result;
    }

    public String toString() {
        return "sh1Class{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", physics=" + physics +
                ", chemistry=" + chemistry +
                ", maths=" + maths +
                ", pti=" + pti +
                ", cti=" + cti +
                ", mti=" + mti +
                ", teniaid=" + teniaid +
                '}';
    }
}

