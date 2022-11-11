package dao;

import javax.persistence.*;

@Entity
public class Cars {
    private int idCar;
    private String NameCar;
    private int TotalTime;

    @Id
    @Column(name = "idCar", nullable = false)
    public int getidCar() {
        return idCar;
    }

    public void setidCar(int idCar) {
        this.idCar = idCar;
    }

    @Basic
    @Column(name = "nameCar", nullable = false, length = 45)
    public String getNameCar() {
        return NameCar;
    }

    public void setnameCar(String NameCar) {
        this.NameCar = NameCar;
    }

    @Basic
    @Column(name = "TotalTime", nullable = false)
    public int getTotalTime() {
        return TotalTime;
    }

    public void setTotalTime(int TotalTime) {
        this.TotalTime = TotalTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Cars that = (Cars) o;

        if (idCar != that.idCar) return false;
        if (TotalTime != that.TotalTime) return false;
        if (NameCar != null ? !NameCar.equals(that.NameCar) : that.NameCar != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idCar;
        result = 31 * result + (NameCar != null ? NameCar.hashCode() : 0);
        result = 31 * result + TotalTime;
        return result;
    }

    @Override
    public String toString() {
        return " ProductEntity{" +
                "idproduct=" + idCar +
                ", nameproduct='" + NameCar + '\'' +
                ", price=" + TotalTime  + '\'' +
                '}' + '\n';
    }
}
