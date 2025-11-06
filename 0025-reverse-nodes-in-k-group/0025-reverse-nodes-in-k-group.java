/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

public class Solution {

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 1) return head; // Si la liste est vide ou k = 1, rien à faire

        // Création d'un noeud fictif (dummy) pour simplifier la gestion du head
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        // groupPrev pointe sur le noeud avant le groupe actuel à inverser
        ListNode groupPrev = dummy;

        // Boucle principale : on traite chaque groupe de k noeuds
        while (true) {
            // Étape 1 : trouver le k-ième noeud à partir de groupPrev
            ListNode kth = getKthNode(groupPrev, k);
            if (kth == null) break; // Moins de k noeuds restants → on arrête

            // Étape 2 : sauvegarder le noeud qui suit le k-ième (sera utilisé pour reconnecter après inversion)
            ListNode groupNext = kth.next;

            // Étape 3 : inverser le groupe de noeuds entre groupPrev.next et kth
            // Utilisation de trois pointeurs classiques pour inverser une liste
            ListNode prev = groupNext; // initialisation : après le groupe
            ListNode curr = groupPrev.next; // début du groupe

            // Inversion du groupe
            while (curr != groupNext) {
                ListNode temp = curr.next; // sauvegarder le noeud suivant
                curr.next = prev;          // inverser le pointeur
                prev = curr;               // avancer prev
                curr = temp;               // avancer curr
            }

            // Étape 4 : reconnecter le groupe inversé avec le reste de la liste
            ListNode temp = groupPrev.next; // sauvegarder l'ancien début du groupe (qui devient la fin)
            groupPrev.next = kth;           // connecter le début du groupe inversé
            groupPrev = temp;               // avancer groupPrev pour le prochain groupe
        }

        return dummy.next; // retourner la nouvelle tête de la liste
    }

    // Fonction aide : retourne le k-ième noeud à partir du noeud courant
    private ListNode getKthNode(ListNode curr, int k) {
        while (curr != null && k > 0) {
            curr = curr.next;
            k--;
        }
        return curr; // retourne null si moins de k noeuds restants
    }

   

}
