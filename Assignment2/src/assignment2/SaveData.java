/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignment2;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author optim
 */
@Entity
@Table(name = "SAVEGAME")
@NamedQueries({
    @NamedQuery(name = "SaveData.findAll", query = "SELECT s FROM SaveData s"),
    @NamedQuery(name = "SaveData.findBySaveFile", query = "SELECT s FROM SaveData s WHERE s.saveFile = :saveFile"),
    @NamedQuery(name = "SaveData.findByNumOfPlants", query = "SELECT s FROM SaveData s WHERE s.numOfPlants = :numOfPlants"),
    @NamedQuery(name = "SaveData.findByNumOfWeeks", query = "SELECT s FROM SaveData s WHERE s.numOfWeeks = :numOfWeeks"),
    @NamedQuery(name = "SaveData.findByNumOfGrowlight", query = "SELECT s FROM SaveData s WHERE s.numOfGrowlight = :numOfGrowlight"),
    @NamedQuery(name = "SaveData.findByNumOfFertiliser", query = "SELECT s FROM SaveData s WHERE s.numOfFertiliser = :numOfFertiliser"),
    @NamedQuery(name = "SaveData.findByMoney", query = "SELECT s FROM SaveData s WHERE s.money = :money")})
public class SaveData implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "SAVE_FILE")
    private Integer saveFile;
    @Basic(optional = false)
    @Column(name = "NUM_OF_PLANTS")
    private int numOfPlants;
    @Basic(optional = false)
    @Column(name = "NUM_OF_WEEKS")
    private int numOfWeeks;
    @Basic(optional = false)
    @Column(name = "NUM_OF_GROWLIGHT")
    private int numOfGrowlight;
    @Basic(optional = false)
    @Column(name = "NUM_OF_FERTILISER")
    private int numOfFertiliser;
    @Basic(optional = false)
    @Column(name = "MONEY")
    private double money;

    public SaveData() {
    }

    public SaveData(Integer saveFile) {
        this.saveFile = saveFile;
    }

    public SaveData(Integer saveFile, int numOfPlants, int numOfWeeks, int numOfGrowlight, int numOfFertiliser, double money) {
        this.saveFile = saveFile;
        this.numOfPlants = numOfPlants;
        this.numOfWeeks = numOfWeeks;
        this.numOfGrowlight = numOfGrowlight;
        this.numOfFertiliser = numOfFertiliser;
        this.money = money;
    }

    public Integer getSaveFile() {
        return saveFile;
    }

    public void setSaveFile(Integer saveFile) {
        this.saveFile = saveFile;
    }

    public int getNumOfPlants() {
        return numOfPlants;
    }

    public void setNumOfPlants(int numOfPlants) {
        this.numOfPlants = numOfPlants;
    }

    public int getNumOfWeeks() {
        return numOfWeeks;
    }

    public void setNumOfWeeks(int numOfWeeks) {
        this.numOfWeeks = numOfWeeks;
    }

    public int getNumOfGrowlight() {
        return numOfGrowlight;
    }

    public void setNumOfGrowlight(int numOfGrowlight) {
        this.numOfGrowlight = numOfGrowlight;
    }

    public int getNumOfFertiliser() {
        return numOfFertiliser;
    }

    public void setNumOfFertiliser(int numOfFertiliser) {
        this.numOfFertiliser = numOfFertiliser;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (saveFile != null ? saveFile.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SaveData)) {
            return false;
        }
        SaveData other = (SaveData) object;
        if ((this.saveFile == null && other.saveFile != null) || (this.saveFile != null && !this.saveFile.equals(other.saveFile))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "assignment2.SaveData[ saveFile=" + saveFile + " ]";
    }
    
}
