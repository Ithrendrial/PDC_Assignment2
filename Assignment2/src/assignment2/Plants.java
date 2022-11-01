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
@Table(name = "PLANTS")
@NamedQueries({
    @NamedQuery(name = "Plants.findAll", query = "SELECT p FROM Plants p"),
    @NamedQuery(name = "Plants.findByPlandId", query = "SELECT p FROM Plants p WHERE p.plandId = :plandId"),
    @NamedQuery(name = "Plants.findBySpecies", query = "SELECT p FROM Plants p WHERE p.species = :species"),
    @NamedQuery(name = "Plants.findByPriceweight", query = "SELECT p FROM Plants p WHERE p.priceweight = :priceweight"),
    @NamedQuery(name = "Plants.findByTier1", query = "SELECT p FROM Plants p WHERE p.tier1 = :tier1"),
    @NamedQuery(name = "Plants.findByTier2", query = "SELECT p FROM Plants p WHERE p.tier2 = :tier2"),
    @NamedQuery(name = "Plants.findByTier3", query = "SELECT p FROM Plants p WHERE p.tier3 = :tier3"),
    @NamedQuery(name = "Plants.findByTier4", query = "SELECT p FROM Plants p WHERE p.tier4 = :tier4"),
    @NamedQuery(name = "Plants.findByTier5", query = "SELECT p FROM Plants p WHERE p.tier5 = :tier5"),
    @NamedQuery(name = "Plants.findByTier6", query = "SELECT p FROM Plants p WHERE p.tier6 = :tier6"),
    @NamedQuery(name = "Plants.findByTier7", query = "SELECT p FROM Plants p WHERE p.tier7 = :tier7"),
    @NamedQuery(name = "Plants.findByTier8", query = "SELECT p FROM Plants p WHERE p.tier8 = :tier8"),
    @NamedQuery(name = "Plants.findByTier9", query = "SELECT p FROM Plants p WHERE p.tier9 = :tier9"),
    @NamedQuery(name = "Plants.findByTier10", query = "SELECT p FROM Plants p WHERE p.tier10 = :tier10")})
public class Plants implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "PLAND_ID")
    private Integer plandId;
    @Basic(optional = false)
    @Column(name = "SPECIES")
    private String species;
    @Basic(optional = false)
    @Column(name = "PRICEWEIGHT")
    private int priceweight;
    @Basic(optional = false)
    @Column(name = "TIER1")
    private int tier1;
    @Basic(optional = false)
    @Column(name = "TIER2")
    private int tier2;
    @Basic(optional = false)
    @Column(name = "TIER3")
    private int tier3;
    @Basic(optional = false)
    @Column(name = "TIER4")
    private int tier4;
    @Basic(optional = false)
    @Column(name = "TIER5")
    private int tier5;
    @Basic(optional = false)
    @Column(name = "TIER6")
    private int tier6;
    @Basic(optional = false)
    @Column(name = "TIER7")
    private int tier7;
    @Basic(optional = false)
    @Column(name = "TIER8")
    private int tier8;
    @Basic(optional = false)
    @Column(name = "TIER9")
    private int tier9;
    @Basic(optional = false)
    @Column(name = "TIER10")
    private int tier10;

    public Plants() {
    }

    public Plants(Integer plandId) {
        this.plandId = plandId;
    }

    public Plants(Integer plandId, String species, int priceweight, int tier1, int tier2, int tier3, int tier4, int tier5, int tier6, int tier7, int tier8, int tier9, int tier10) {
        this.plandId = plandId;
        this.species = species;
        this.priceweight = priceweight;
        this.tier1 = tier1;
        this.tier2 = tier2;
        this.tier3 = tier3;
        this.tier4 = tier4;
        this.tier5 = tier5;
        this.tier6 = tier6;
        this.tier7 = tier7;
        this.tier8 = tier8;
        this.tier9 = tier9;
        this.tier10 = tier10;
    }

    public Integer getPlandId() {
        return plandId;
    }

    public void setPlandId(Integer plandId) {
        this.plandId = plandId;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public int getPriceweight() {
        return priceweight;
    }

    public void setPriceweight(int priceweight) {
        this.priceweight = priceweight;
    }

    public int getTier1() {
        return tier1;
    }

    public void setTier1(int tier1) {
        this.tier1 = tier1;
    }

    public int getTier2() {
        return tier2;
    }

    public void setTier2(int tier2) {
        this.tier2 = tier2;
    }

    public int getTier3() {
        return tier3;
    }

    public void setTier3(int tier3) {
        this.tier3 = tier3;
    }

    public int getTier4() {
        return tier4;
    }

    public void setTier4(int tier4) {
        this.tier4 = tier4;
    }

    public int getTier5() {
        return tier5;
    }

    public void setTier5(int tier5) {
        this.tier5 = tier5;
    }

    public int getTier6() {
        return tier6;
    }

    public void setTier6(int tier6) {
        this.tier6 = tier6;
    }

    public int getTier7() {
        return tier7;
    }

    public void setTier7(int tier7) {
        this.tier7 = tier7;
    }

    public int getTier8() {
        return tier8;
    }

    public void setTier8(int tier8) {
        this.tier8 = tier8;
    }

    public int getTier9() {
        return tier9;
    }

    public void setTier9(int tier9) {
        this.tier9 = tier9;
    }

    public int getTier10() {
        return tier10;
    }

    public void setTier10(int tier10) {
        this.tier10 = tier10;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (plandId != null ? plandId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Plants)) {
            return false;
        }
        Plants other = (Plants) object;
        if ((this.plandId == null && other.plandId != null) || (this.plandId != null && !this.plandId.equals(other.plandId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "assignment2.Plants[ plandId=" + plandId + " ]";
    }
    
}
