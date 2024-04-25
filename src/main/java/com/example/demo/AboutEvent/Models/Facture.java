package com.example.demo.AboutEvent.Models;

import com.example.demo.base.model.AbstractBaseEntity;
import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.*;

import jakarta.persistence.*;

import java.util.Objects;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="FACTURE")
public class Facture extends AbstractBaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="FACTURE_ID")
    private Integer idFacture;

    @Column(name="CONTENU")
    private String contenu;

<<<<<<< Updated upstream
    /*Scanner scanner = new Scanner(System.in);

    public Facture(Scanner scanner) {
        System.out.println("Donner l'ID de la facture:");
        this.idFacture = scanner.nextInt();
        scanner.nextLine(); // Pour consommer la nouvelle ligne restante après nextInt()

        String aa = "           --------------------";

        String input = "";
        while (!input.equalsIgnoreCase("DP") && !input.equalsIgnoreCase("RV")) {
            System.out.println("Dépense ou revenu? (DP pour dépense, RV pour revenu) :");
            input = scanner.nextLine();
        }

        String message = String.format("*** id : %d, type : %s", this.idFacture, input);
        aa += "\n" + message + "\n" + "           --------------------" + "\nItems :\n";

        double totalAmount = 0.0;
        input = "";
        while (!input.equalsIgnoreCase("N")) {
            System.out.println("\nDescription : ");
            String description = scanner.nextLine();

            System.out.println("\nMontant : ");
            double amount = scanner.nextDouble();
            scanner.nextLine(); // Pour consommer la nouvelle ligne restante après nextDouble()

            totalAmount += amount;
            message = String.format("Item : %s, Montant : %.2f", description, amount);
            aa += "\n" + message;

            System.out.println("Tapez 'N' si la facture est terminée, sinon appuyez sur Entrée pour continuer : ");
            input = scanner.nextLine().trim();
        }

        aa += String.format("\nMONTANT TOTAL : %.2f", totalAmount);
        this.contenu = aa;
    }
*/
=======
>>>>>>> Stashed changes

    @ManyToOne
    @JsonBackReference
    private Event event;
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Facture facture = (Facture) o;
        return Objects.equals(idFacture, facture.idFacture) && Objects.equals(contenu, facture.contenu);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idFacture, contenu);
    }

}
