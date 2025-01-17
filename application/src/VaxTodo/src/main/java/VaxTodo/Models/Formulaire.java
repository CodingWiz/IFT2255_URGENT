package VaxTodo.Models;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.Normalizer.Form;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

import VaxTodo.Configs.Config;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.Region;

/** Used for manipulating Formulaire objects and read, write to csv file and compare between objects
 * Is a sub class of Visiteur
 * @author Mohamed H. Guelleh
 * @since v1.0.0
 */
public class Formulaire extends Visiteur {
    private final static String strDataFileFormulaire = Config.strNewDataFileFormulaires;

    private String strCarteAssuranceMaladie, strDateVisite, strCodeVaccin;
    private EnumTypeBoolean etbFirstDose, etbHadCovid, etbHasCovidSymptoms, etbHasAllergies, etbGotVaccinated;
    private EnumTypeVaccin enumTypeVaccin;
    private int intTypeDose;

    public Formulaire() {
        this.strCarteAssuranceMaladie = "";
        this.strDateVisite = "";

        // this.etbFirstDose = EnumTypeBoolean.NON;
        // this.etbHadCovid = EnumTypeBoolean.NON;
        // this.etbHasCovidSymptoms = EnumTypeBoolean.NON;
        // this.etbHasAllergies = EnumTypeBoolean.NON;
        // this.etbGotVaccinated = EnumTypeBoolean.NON;
        this.etbFirstDose = null;
        this.etbHadCovid = null;
        this.etbHasCovidSymptoms = null;
        this.etbHasAllergies = null;
        this.etbGotVaccinated = null;

        this.enumTypeVaccin = null;
        this.intTypeDose = 0;
        this.strCodeVaccin = "";
    }
    public Formulaire(String strCarteAssuranceMaladie, String strDateVisite, EnumTypeBoolean etbFirstDose, EnumTypeBoolean etbHadCovid, EnumTypeBoolean etbHasCovidSymptoms, EnumTypeBoolean etbHasAllergies, EnumTypeBoolean etbGotVaccinated, EnumTypeVaccin enumTypeVaccin, int intTypeDose, String strCodeVaccin) {
        this.strCarteAssuranceMaladie = strCarteAssuranceMaladie;
        this.strDateVisite = strDateVisite;
        this.etbFirstDose = etbFirstDose;
        this.etbHadCovid = etbHadCovid;
        this.etbHasCovidSymptoms = etbHasCovidSymptoms;
        this.etbHasAllergies = etbHasAllergies;
        this.etbGotVaccinated = etbGotVaccinated;
        this.enumTypeVaccin = enumTypeVaccin;
        this.intTypeDose = intTypeDose;
        this.strCodeVaccin = strCodeVaccin;
    }
    public Formulaire(long lngNoCompte, long lngNoTel, String strNom, String strPrenom, String strAdresse, String strCodePostal, String strVille, String strCourriel, String strDateNaissance, String strCarteAssuranceMaladie, String strDateVisite, EnumTypeBoolean etbFirstDose, EnumTypeBoolean etbHadCovid, EnumTypeBoolean etbHasCovidSymptoms, EnumTypeBoolean etbHasAllergies, EnumTypeBoolean etbGotVaccinated, EnumTypeVaccin enumTypeVaccin, int intTypeDose, String strCodeVaccin) {
        this.strCarteAssuranceMaladie = strCarteAssuranceMaladie;
        this.strDateVisite = strDateVisite;
        this.etbFirstDose = etbFirstDose;
        this.etbHadCovid = etbHadCovid;
        this.etbHasCovidSymptoms = etbHasCovidSymptoms;
        this.etbHasAllergies = etbHasAllergies;
        this.etbGotVaccinated = etbGotVaccinated;
        this.enumTypeVaccin = enumTypeVaccin;
        this.intTypeDose = intTypeDose;
        this.strCodeVaccin = strCodeVaccin;

        this.setStrDateNaissance(strDateNaissance);

        this.setLngNoCompte(lngNoCompte);
        this.setLngNoTel(lngNoTel);
        this.setStrNom(strNom);
        this.setStrPrenom(strPrenom);
        this.setStrAdresse(strAdresse);
        this.setStrCodePostal(strCodePostal);
        this.setStrVille(strVille);
        this.setStrCourriel(strCourriel);
    }

    public String getStrCarteAssuranceMaladie() {
        return this.strCarteAssuranceMaladie;
    }
    public void setStrCarteAssuranceMaladie(String strCarteAssuranceMaladie) {
        this.strCarteAssuranceMaladie = strCarteAssuranceMaladie;
    }

    public String getStrDateVisite() {
        return this.strDateVisite;
    }
    public void setStrDateVisite(String strDateVisite) {
        this.strDateVisite = strDateVisite;
    }

    public String getStrCodeVaccin() {
        return this.strCodeVaccin;
    }
    public void setStrCodeVaccin(String strCodeVaccin) {
        this.strCodeVaccin = strCodeVaccin;
    }

    public EnumTypeBoolean getEtbFirstDose() {
        return this.etbFirstDose;
    }
    public void setEtbFirstDose(EnumTypeBoolean etbFirstDose) {
        this.etbFirstDose = etbFirstDose;
    }

    public EnumTypeBoolean getEtbHadCovid() {
        return this.etbHadCovid;
    }
    public void setEtbHadCovid(EnumTypeBoolean etbHadCovid) {
        this.etbHadCovid = etbHadCovid;
    }

    public EnumTypeBoolean getEtbHasCovidSymptoms() {
        return this.etbHasCovidSymptoms;
    }
    public void setEtbHasCovidSymptoms(EnumTypeBoolean etbHasCovidSymptoms) {
        this.etbHasCovidSymptoms = etbHasCovidSymptoms;
    }

    public EnumTypeBoolean getEtbHasAllergies() {
        return this.etbHasAllergies;
    }
    public void setEtbHasAllergies(EnumTypeBoolean etbHasAllergies) {
        this.etbHasAllergies = etbHasAllergies;
    }

    public EnumTypeBoolean getEtbGotVaccinated() {
        return this.etbGotVaccinated;
    }
    public void setEtbGotVaccinated(EnumTypeBoolean etbGotVaccinated) {
        this.etbGotVaccinated = etbGotVaccinated;
    }

    public EnumTypeVaccin getEnumTypeVaccin() {
        return this.enumTypeVaccin;
    }
    public void setEnumTypeVaccin(EnumTypeVaccin enumTypeVaccin) {
        this.enumTypeVaccin = enumTypeVaccin;
    }

    public int getIntTypeDose() {
        return this.intTypeDose;
    }
    public void setIntTypeDose(int intTypeDose) {
        this.intTypeDose = intTypeDose;
    }

    public void setVisiteur(Visiteur visiteur) {
        this.strCarteAssuranceMaladie = "";
        this.strDateVisite = "";
        this.etbFirstDose = null;
        this.etbHadCovid = null;
        this.etbHasCovidSymptoms = null;
        this.etbHasAllergies = null;
        this.etbGotVaccinated = null;

        this.enumTypeVaccin = null;
        this.intTypeDose = 0;
        this.strCodeVaccin = "";

        this.setStrDateNaissance(visiteur.getStrDateNaissance());

        this.setLngNoCompte(visiteur.getLngNoCompte());
        this.setLngNoTel(visiteur.getLngNoTel());
        this.setStrNom(visiteur.getStrNom());
        this.setStrPrenom(visiteur.getStrPrenom());
        this.setStrAdresse(visiteur.getStrAdresse());
        this.setStrCodePostal(visiteur.getStrCodePostal());
        this.setStrVille(visiteur.getStrVille());
        this.setStrCourriel(visiteur.getStrCourriel());
    }

    // #! lngNoCompte, lngNoTel, strNom, strPrenom, strAdresse, strCodePostal, strVille, strCourriel, strDateNaissance, strCarteAssuranceMaladie, strDateVisite, etbFirstDose, etbHadCovid, etbHasCovidSymptoms, etbHasAllergies, etbGotVaccinated, enumTypeVaccin, intTypeDose, strCodeVaccin
    public String printInfosFormulaire() {
        return getLngNoCompte() + Config.strCSVMainSeparator + getLngNoTel() + Config.strCSVMainSeparator + getStrNom() + Config.strCSVMainSeparator + getStrPrenom() + Config.strCSVMainSeparator + getStrAdresse() + Config.strCSVMainSeparator + getStrCodePostal() + Config.strCSVMainSeparator + getStrVille() + Config.strCSVMainSeparator + getStrCourriel() + Config.strCSVMainSeparator + getStrDateNaissance() + Config.strCSVMainSeparator + getStrCarteAssuranceMaladie() + Config.strCSVMainSeparator + getStrDateVisite() + Config.strCSVMainSeparator + (getEtbFirstDose()!=null?getEtbFirstDose():"") + Config.strCSVMainSeparator + (getEtbHadCovid()!=null?getEtbHadCovid():"") + Config.strCSVMainSeparator + (getEtbHasCovidSymptoms()!=null?getEtbHasCovidSymptoms():"") + Config.strCSVMainSeparator + (getEtbHasAllergies()!=null?getEtbHasAllergies():"")+ Config.strCSVMainSeparator + (getEtbGotVaccinated()!=null?getEtbGotVaccinated():"") + Config.strCSVMainSeparator + (getEnumTypeVaccin()!=null?getEnumTypeVaccin():"") + Config.strCSVMainSeparator + getIntTypeDose() + Config.strCSVMainSeparator + getStrCodeVaccin();
    }

    @Override
    public String getListViewAccountInfos(boolean blnShowUnderline) {
        String strUnderline = "";
        if (blnShowUnderline)
            strUnderline = "---------------------------------------\n";
        // for(int i=0; i<getFullName().length()+1; i++)
        //     strUnderline += "-";

        return getFullName() + "\n" + strUnderline + "Numéro du Compte:\t" + Long.toString(getLngNoCompte()) + "\nDate de Naissance:\t\t" + getStrDateNaissance() + "\nVaccin Code QR:\t\t" + getStrCodeVaccin() + "\n";
    }

    @Override
    public String getEmailConfirmation(boolean blnShowUnderline) {
        String strUnderline = "";
        if (blnShowUnderline)
            strUnderline = "---------------------------------------\n";
        // for(int i=0; i<getFullName().length()+1; i++)
        //     strUnderline += "-";

        return getFullName() + "\n" + strUnderline + "Numéro du Compte:\t" + Long.toString(getLngNoCompte()) + (getStrCourriel().trim().isEmpty() ? "\n" : "\nDate de Naissance:\t\t" + getStrDateNaissance() + "\nVaccin Code QR:\t\t" + getStrCodeVaccin() + "\nCourriel:\t\t\t\t" + getStrCourriel().trim() + "\n");
    }

    @Override
    public String toString() {
        return "{[lngNoCompte='" + getLngNoCompte() + "'" +
                ", lngNoTel='" + getLngNoTel() + "'" +
                ", strNom='" + getStrNom() + "'" +
                ", strPrenom='" + getStrPrenom() + "'" +
                ", strAdresse='" + getStrAdresse() + "'" +
                ", strCodePostal='" + getStrCodePostal() + "'" +
                ", strVille='" + getStrVille() + "'" +
                ", strCourriel='" + getStrCourriel() + "'" +
                ", strDateNaissance='" + getStrDateNaissance() + "'" +
                "], strCarteAssuranceMaladie='" + getStrCarteAssuranceMaladie() + "'" +
                ", strDateVisite='" + getStrDateVisite() + "'" +
                ", etbFirstDose='" + getEtbFirstDose() + "'" +
                ", etbHadCovid='" + getEtbHadCovid() + "'" +
                ", etbHasCovidSymptoms='" + getEtbHasCovidSymptoms() + "'" +
                ", etbHasAllergies='" + getEtbHasAllergies() + "'" +
                ", etbGotVaccinated='" + getEtbGotVaccinated() + "'" +
                ", enumTypeVaccin='" + getEnumTypeVaccin() + "'" +
                ", intTypeDose='" + getIntTypeDose() + "'" +
                ", strCodeVaccin='" + getStrCodeVaccin() + "'" +
                "}";
    }

    @Override
    public boolean equalsExactly(Object object) {
        if (object == null || !(object instanceof Formulaire))
            return false;

        // if (object == this) {
        //     System.out.println("\nInside Equals of Same Object THIS\n");
        //     return true;
        // }

        // System.out.println("\nInside Exact Equals of Object\n");
        Formulaire f = (Formulaire) object;
        
        return this.getLngNoCompte() == f.getLngNoCompte() &&
                this.getLngNoTel() == f.getLngNoTel() &&
                this.getStrNom().trim().equals(f.getStrNom().trim()) &&
                this.getStrPrenom().trim().equals(f.getStrPrenom().trim()) &&
                this.getStrAdresse().trim().equals(f.getStrAdresse().trim()) &&
                this.getStrCodePostal().trim().equals(f.getStrCodePostal().trim()) &&
                this.getStrVille().trim().equals(f.getStrVille().trim()) && 
                this.getStrCourriel().trim().equals(f.getStrCourriel().trim()) && 
                this.getStrDateNaissance().equals(f.getStrDateNaissance()) &&
                
                this.getStrCarteAssuranceMaladie().trim().equals(f.getStrCarteAssuranceMaladie().trim()) &&
                this.getStrDateVisite().trim().equals(f.getStrDateVisite().trim()) &&

                // this.getEtbFirstDose().equals(f.getEtbFirstDose()) &&
                // this.getEtbHadCovid().equals(f.getEtbHadCovid()) &&
                // this.getEtbHasCovidSymptoms().equals(f.getEtbHasCovidSymptoms()) &&
                // this.getEtbHasAllergies().equals(f.getEtbHasAllergies()) &&
                // this.getEtbGotVaccinated().equals(f.getEtbGotVaccinated()) &&
                // this.getEnumTypeVaccin().equals(f.getEnumTypeVaccin()) &&
                this.getEtbFirstDose() == f.getEtbFirstDose() &&
                this.getEtbHadCovid() == f.getEtbHadCovid() &&
                this.getEtbHasCovidSymptoms() == f.getEtbHasCovidSymptoms() &&
                this.getEtbHasAllergies() == f.getEtbHasAllergies() &&
                this.getEtbGotVaccinated() == f.getEtbGotVaccinated() &&
                this.getEnumTypeVaccin() == f.getEnumTypeVaccin() &&

                this.getIntTypeDose() == f.getIntTypeDose();
    }

    public static class ReturnCrudDataListFormulaires {
        private ArrayList<Formulaire> arrFormulaires;
        private boolean blnAlertErrorDataFolder, blnAlertErrorDataFileFormulaire;

        public ReturnCrudDataListFormulaires() {
            this.arrFormulaires = new ArrayList<>();

            this.blnAlertErrorDataFolder = false;
            this.blnAlertErrorDataFileFormulaire = false;
        }
        public ReturnCrudDataListFormulaires(ArrayList<Formulaire> arrFormulaires) {
            this.arrFormulaires = arrFormulaires;

            this.blnAlertErrorDataFolder = false;
            this.blnAlertErrorDataFileFormulaire = false;
        }
        public ReturnCrudDataListFormulaires(boolean blnAlertErrorDataFolder, boolean blnAlertErrorDataFileFormulaire) {
            this.arrFormulaires = new ArrayList<>();

            this.blnAlertErrorDataFolder = blnAlertErrorDataFolder;
            this.blnAlertErrorDataFileFormulaire = blnAlertErrorDataFileFormulaire;
        } 
        public ReturnCrudDataListFormulaires(ArrayList<Formulaire> arrFormulaires, boolean blnAlertErrorDataFolder, boolean blnAlertErrorDataFileFormulaire) {
            this.arrFormulaires = arrFormulaires;

            this.blnAlertErrorDataFolder = blnAlertErrorDataFolder;
            this.blnAlertErrorDataFileFormulaire = blnAlertErrorDataFileFormulaire;
        }

        public ArrayList<Formulaire> getArrFormulaires() {
            return this.arrFormulaires;
        }
        public boolean getBlnAlertErrorDataFolder() {
            return this.blnAlertErrorDataFolder;
        }
        public boolean getBlnAlertErrorDataFileFormulaire() {
            return this.blnAlertErrorDataFileFormulaire;
        }

        public void setArrFormulaires(ArrayList<Formulaire> arrFormulaires) {
            this.arrFormulaires = arrFormulaires;
        }
        public void setBlnAlertErrorDataFolder(boolean blnAlertErrorDataFolder) {
            this.blnAlertErrorDataFolder = blnAlertErrorDataFolder;
        }
        public void setBlnAlertErrorDataFileFormulaire(boolean blnAlertErrorDataFileFormulaire) {
            this.blnAlertErrorDataFileFormulaire = blnAlertErrorDataFileFormulaire;
        }
    }
    public static ReturnCrudDataListFormulaires crudDataListFormulaires(Logger logger, EnumTypeCRUD enumTypeCRUD, Visiteur userInputFormulaire, boolean ...blnArrOptional) {
        System.out.println();

        if (userInputFormulaire instanceof Formulaire)
            userInputFormulaire = (Formulaire) userInputFormulaire;

        boolean blnShowVerbose = true, blnInitDataFile = false, blnInitTempFormulaire = false;
        if (blnArrOptional != null && blnArrOptional.length > 0) {
            if (blnArrOptional.length == 1)
                blnShowVerbose = blnArrOptional[0];
            else if (blnArrOptional.length == 2) {
                blnShowVerbose = blnArrOptional[0];
                blnInitDataFile = blnArrOptional[1];
            }
            else {
                blnShowVerbose = blnArrOptional[0];
                blnInitDataFile = blnArrOptional[1];
                blnInitTempFormulaire = blnArrOptional[2];
            }
        }

        // System.out.println("\n" + enumTypeCRUD + "\n");

        if (enumTypeCRUD == EnumTypeCRUD.CREATE) {
            Path pathVaxTodoDataFolder = Paths.get(strDataFileFormulaire).getParent();

            try {
                // ArrayList<Formulaire> arrFormulaires = new ArrayList<>();
                ReturnCrudDataListFormulaires returnCrudDataListFormulaires = new ReturnCrudDataListFormulaires(); //! generates error if class is not static

                // check if Data folder exist
                if (Files.isDirectory(pathVaxTodoDataFolder)) {
                    logger.log(Level.INFO, "Dossier des données EXISTE.\nEmplacement du dossier des données: '" + pathVaxTodoDataFolder.toAbsolutePath().toString() + "'\n\n");

                    // File DataFileFormulaire = new File(strFileName + "Formulaires.csv");
                    ArrayList<Formulaire> arrCheckIfFormulairesPresentInFile = crudDataListFormulaires(logger, EnumTypeCRUD.READ, null).getArrFormulaires();

                    // // System.out.println("\n" + strFileName + "Formulaires.csv\n");
                    // System.out.println("\n");
                    // // for (Formulaire e : arrCheckIfFormulairesPresentInFile)
                    // //     System.out.println(e);
                    // // System.out.println("\n\n");
                    // System.out.println("Is Regular File: " + Boolean.toString(Files.isRegularFile(Paths.get(strFileName + "Formulaires.csv"))));
                    // System.out.println("Array is Null: " + Boolean.toString(arrCheckIfFormulairesPresentInFile == null));
                    // // System.out.println("Array is Empty: " + Boolean.toString(arrCheckIfFormulairesPresentInFile.size()>0));
                    // System.out.println("\n");

                    if (Files.isRegularFile(Paths.get(strDataFileFormulaire)) && arrCheckIfFormulairesPresentInFile != null && arrCheckIfFormulairesPresentInFile.size()>0) { //DataFileFormulaire.length() > 1) {
                        logger.log(Level.INFO, "Fichier des donnés Formulaires.csv EXISTE.\n");
                    }
                    else {
                        logger.log(Level.WARNING, "Fichier des donnés Formulaires.csv INTROUVABLE ou VIDE!\nCréation d'un nouveau fichier de donnés pour les formulaires!\n" + strDataFileFormulaire /*+ "Formulaires.csv"*/ + "\n");
                        // returnCrudDataListFormulaires.setBlnAlertErrorDataFileFormulaire(crudDataListFormulaires(logger, EnumTypeCRUD.UPDATE, strFileName + "Formulaires.csv", null, true, true).getBlnAlertErrorDataFileFormulaire());
                        returnCrudDataListFormulaires = crudDataListFormulaires(logger, EnumTypeCRUD.UPDATE, null, true, true, blnInitTempFormulaire);
                    }

                    return returnCrudDataListFormulaires;
                }
                else {
                    logger.log(Level.WARNING, "Emplacement du dossier des données INTROUVABLE.\nCréation d'un nouveau dossier des données à l'emplacement:\n'" + pathVaxTodoDataFolder.toAbsolutePath().toString() + "'\n");
                    System.out.println("");

                    Files.createDirectories(pathVaxTodoDataFolder);

                    // File DataFileFormulaire = new File(strFileName + "Formulaires.csv");
                    ArrayList<Formulaire> arrCheckIfFormulairesPresentInFile = crudDataListFormulaires(logger, EnumTypeCRUD.READ, null).getArrFormulaires();

                    if (Files.isRegularFile(Paths.get(strDataFileFormulaire)) && arrCheckIfFormulairesPresentInFile != null && arrCheckIfFormulairesPresentInFile.size()>0) { //DataFileFormulaire.length() > 1) {
                        logger.log(Level.INFO, "Fichier des donnés Formulaires.csv EXISTE.\n");
                    }
                    else {
                        logger.log(Level.WARNING, "Fichier des donnés Formulaires.csv INTROUVABLE ou VIDE!\nCréation d'un nouveau fichier de donnés pour les formulaires!\n" + strDataFileFormulaire /*+ "Formulaires.csv"*/ + "\n");
                        // returnCrudDataListFormulaires.setBlnAlertErrorDataFileFormulaire(crudDataListFormulaires(logger, EnumTypeCRUD.UPDATE, strFileName + "Formulaires.csv", null, true, true).getBlnAlertErrorDataFileFormulaire());
                        returnCrudDataListFormulaires = crudDataListFormulaires(logger, EnumTypeCRUD.UPDATE, null, true, true, blnInitTempFormulaire);
                    }

                    // boolean blnAlertErrorDataFolder = true;
                    returnCrudDataListFormulaires.setBlnAlertErrorDataFolder(true);
                    return returnCrudDataListFormulaires;
                }
            }
            catch (IOException ioe) {
                // System.err.println("\n\nIO Exception for file '" + strFileName + "'\n\nError:\t" + ioe.toString());
                // logger.log(Level.SEVERE, "Failed to create new Data folder. Please RESTART APP or create a ticket and contact your system administrator.\n\nIO Exception for folder: '" + strFileName + "'\n", ioe);
                logger.log(Level.SEVERE, "ERREUR lors de la création d'un nouveau dossier des données! " + Config.strRestartAppInstruction + "\nIO Exception pour le dossier:\n'" + pathVaxTodoDataFolder.toAbsolutePath().toString() + "'\n", ioe);
                System.out.println("");

                // Alert alertError = new Alert(AlertType.ERROR, "Failed to create new Data folder. Please RESTART APP or create a ticket and contact your system administrator.\n\nIO Exception for folder:\n'" + strFileName + "'\n", ButtonType.OK);
                Alert alertError = new Alert(AlertType.ERROR, "ERREUR lors de la création d'un nouveau dossier des données! " + Config.strRestartAppInstruction + "\nIO Exception pour le dossier:\n'" + pathVaxTodoDataFolder.toAbsolutePath().toString() + "'\n", ButtonType.OK);
                alertError.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
                alertError.showAndWait();
    
                // System.exit(0);
            }
            catch (Exception e) {
                // logger.log(Level.SEVERE, "Unkown Error Encountered while creating Data folder. Please RESTART APP or create a ticket and contact your system administrator.\n\nException for folder: '" + strFileName + "'\n", e);
                logger.log(Level.SEVERE, "ERREUR INCONNUE RENCONTRÉE lors de la création d'un nouveau dossier des données! " + Config.strRestartAppInstruction + "\nException pour le dossier:\n'" + pathVaxTodoDataFolder.toAbsolutePath().toString() + "'\n", e);
                System.out.println("");

                // Alert alertError = new Alert(AlertType.ERROR, "Unkown Error Encountered while creating Data folder. Please RESTART APP or create a ticket and contact your system administrator.\n\nException for folder:\n '" + strFileName + "'", ButtonType.OK);
                Alert alertError = new Alert(AlertType.ERROR, "ERREUR INCONNUE RENCONTRÉE lors de la création d'un nouveau dossier des données! " + Config.strRestartAppInstruction + "\nException pour le dossier:\n'" + pathVaxTodoDataFolder.toAbsolutePath().toString() + "'\n", ButtonType.OK);
                // alertError.initStyle(StageStyle.UTILITY);
                alertError.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
                alertError.showAndWait();
    
                // System.exit(0);
            }
        }
        else if (enumTypeCRUD == EnumTypeCRUD.READ || enumTypeCRUD == EnumTypeCRUD.UPDATE || enumTypeCRUD == EnumTypeCRUD.DELETE || enumTypeCRUD == EnumTypeCRUD.READ_SAME) {
            ReturnCrudDataListFormulaires returnCrudDataListFormulaires = new ReturnCrudDataListFormulaires();
            ArrayList<Formulaire> arrFormulaires = new ArrayList<>();

            // System.out.println("Inside " + enumTypeCRUD);

            String tempFile = "";
            // File oldFile = null;
            File newFile = null;
            if (enumTypeCRUD == EnumTypeCRUD.READ || // ? will stay until fixed ?
                enumTypeCRUD == EnumTypeCRUD.READ_SAME ||
                enumTypeCRUD == EnumTypeCRUD.UPDATE || enumTypeCRUD == EnumTypeCRUD.DELETE) {
                tempFile = Paths.get(strDataFileFormulaire).getParent().toString() + Config.strFileSeparator + "tempFormulaires.csv"; //Config.strResourceFolder + "tempSuppressionEmpoyes.csv";
                
                // oldFile = new File(strFileName);
                newFile = new File(tempFile);

                // System.out.println("\n--->PATH OF TEMP FILE:\n" + Paths.get(tempFile) + "\n");
                // System.out.println("\n--->PATH OF NEW FILE:\n" + Paths.get(tempFile) + "\n");
                // System.out.println("\n--->PATH OF OLD FILE:\n" + Paths.get(strFileName) + "\n");

                // delete temp file if it exist
                try {
                    Files.deleteIfExists(Paths.get(tempFile));
                }
                catch (IOException ioe) {
                    logger.log(Level.SEVERE, "IMPOSSIBLE de supprimer le fichier temporaire des formulaires '" + tempFile + "'! " + Config.strRestartAppInstruction + "\nIO Exception pour le fichier: '" + tempFile + "'\n", ioe);
                    System.out.println("");
                }
            }

            int intCurrentLineNumber = 0;

            // BufferedReader bufferedReader = null;
            // PrintWriter printWriter = null;
            try (PrintWriter printWriter = new PrintWriter(new BufferedWriter(new FileWriter(tempFile, true)))) {
                // if (enumTypeCRUD == EnumTypeCRUD.UPDATE || enumTypeCRUD == EnumTypeCRUD.DELETE)
                //     printWriter = new PrintWriter(new BufferedWriter(new FileWriter(tempFile, true)));
                
                BufferedReader bufferedReader = null;

                if (blnInitDataFile && userInputFormulaire == null && enumTypeCRUD == EnumTypeCRUD.UPDATE) {
                    try {
                        // reader = new BufferedReader(new FileReader(new File(strFileName)));
                        bufferedReader = new BufferedReader(new FileReader(strDataFileFormulaire));
                    }
                    catch (FileNotFoundException fnf) {
                        // System.err.println("\n\nFile '" + strFileName + "' not found\n\nError:\t" + fnf.toString());
            
                        //System.exit(0);
        
                        // System.out.println();
                        // logger.log(Level.SEVERE, "Fichier '" + strFileName + "' INTROUVABLE. Donnez le bon fichier comme paramètre!\n", fnf);

                        Formulaire defaultFormulaire = new Formulaire(Long.parseLong("111111111111"), Long.parseLong("1234567890"), "Test-Nom", "Test-Prenom", "123 Test-Adresse", "A0A0A0", "Test-Ville", "Test-Courriel@test.com", LocalDate.now().minusDays(1).format(Config.DATE_TIME_FORMATTER).toString(), "AAAA00000000", LocalDate.now().format(Config.DATE_TIME_FORMATTER).toString(), EnumTypeBoolean.NON, EnumTypeBoolean.NON, EnumTypeBoolean.NON, EnumTypeBoolean.NON, EnumTypeBoolean.NON, null, 0, "");

                        System.out.println();
                        logger.log(Level.SEVERE, "Fichier '" + strDataFileFormulaire + "' INTROUVABLE.\nCréation d'un formulaire par défaut qui a comme information: " + defaultFormulaire + "\n");
                        // at CSV file line " + intCurrentLineNumber

                        // crudDataListFormulaires(EnumTypeCRUD.UPDATE, strFileName, defaultFormulaire, false, true);
                        
                        // if modifying formulaire, add formulaire to end of file
                        printWriter.println("#! lngNoCompte, lngNoTel, strNom, strPrenom, strAdresse, strCodePostal, strVille, strCourriel, strDateNaissance, strCarteAssuranceMaladie, strDateVisite, etbFirstDose, etbHadCovid, etbHasCovidSymptoms, etbHasAllergies, etbGotVaccinated, enumTypeVaccin, intTypeDose, strCodeVaccin");

                        if (blnInitTempFormulaire)
                            printWriter.println(defaultFormulaire.printInfosFormulaire());

                        // Damn you Windows! The OS requires that the connection is closed before deleting or renaming files!
                        printWriter.close();

                        // out.flush();

                        // delete old csv file if it exist so that newly created one can be renamed to old csv file
                        try {
                            // boolean blnDeleteOldFile = oldFile.delete();

                            // if (!blnDeleteOldFile)
                            //     logger.log(Level.SEVERE, "IMPOSSIBLE de supprimer l'ancien fichier ['" + strFileName + "']!\n");
                            // else 
                            //     logger.log(Level.INFO, "SUCCÈS pour avoir supprimer l'ancien fichier ['" + strFileName + "'].\n");

                            Files.deleteIfExists(Paths.get(strDataFileFormulaire));
                            logger.log(Level.INFO, "SUCCÈS pour avoir supprimer le fichier des formulaires ['" + strDataFileFormulaire + "'].\n");
                        }
                        catch (IOException ioe) {
                            logger.log(Level.SEVERE, "IMPOSSIBLE de supprimer le fichier des formulaires '" + strDataFileFormulaire + "'! " + Config.strRestartAppInstruction + "\nIO Exception pour le fichier: '" + strDataFileFormulaire + "'\n", ioe);
                            System.out.println("");
                        }

                        File dump = new File(strDataFileFormulaire);
                        boolean blnRenameNewFile = newFile.renameTo(dump);

                        if (!blnRenameNewFile)
                            logger.log(Level.SEVERE, "IMPOSSIBLE de renommer le fichier temporaire ['" + tempFile + "'] vers ['" + strDataFileFormulaire + "']!\n");
                        else 
                            logger.log(Level.INFO, "SUCCÈS pour avoir renommer le fichier temporaire ['" + tempFile + "'] vers ['" + strDataFileFormulaire + "'].\n");

                        // System.out.println("\n--->PATH OF OLD FILE:\n" + oldFile.getPath() + "\n");
                        // System.out.println("\n--->PATH OF DUMP FILE:\n" + dump.getPath() + "\n");
                        // System.out.println("\n--->PATH OF NEW FILE:\n" + newFile.getPath() + "\n");

                        //! boolean blnAlertErrorDataFileFormulaire = true;
                        returnCrudDataListFormulaires.setBlnAlertErrorDataFileFormulaire(true);
                        return returnCrudDataListFormulaires;
                    }
                }
                // else if (!blnInitDataFile && enumTypeCRUD == EnumTypeCRUD.UPDATE) {
                //     try {
                //         bufferedReader = new BufferedReader(new FileReader(strDataFileFormulaire));
                //     }
                //     catch (FileNotFoundException fnf) {
                //         // if updating accounts & data file doesnt exist, create a new data file & continue execution
                //         crudDataListFormulaires(logger, EnumTypeCRUD.CREATE, null);
                //         bufferedReader = new BufferedReader(new FileReader(strDataFileFormulaire));
                //     }
                // }
                else 
                    bufferedReader = new BufferedReader(new FileReader(strDataFileFormulaire));

                String strCurrentLine = null;
                // read & ignore first line since it contains comments on how to structure csv file
                strCurrentLine = bufferedReader.readLine();
                intCurrentLineNumber++;

                // print first line if updating or deleting data from file
                if (!blnInitDataFile && (enumTypeCRUD == EnumTypeCRUD.UPDATE || enumTypeCRUD == EnumTypeCRUD.DELETE))
                    printWriter.println(strCurrentLine);

                while ((strCurrentLine = bufferedReader.readLine()) != null) {
                    intCurrentLineNumber++;
                    
                    // ignore empty lines in csv file
                    if (strCurrentLine.trim().length() > 0) {
                        // (strCurrentLine.trim().split("\\s*" + Miscellaneous.strCSVSecondarySeparator + "\\s*")[0]).split("\\s*" + Miscellaneous.strCSVMainSeparator + "\\s*")
    
                        String[] arrCurrentLigne = strCurrentLine.trim().split("\\s*" + Config.strCSVMainSeparator + "\\s*");
                        // System.out.println(arrCurrentLigne.length + "\n" + Arrays.toString(arrCurrentLigne));
    
                        Formulaire formulaire = new Formulaire();

                        // read infos
                        if(arrCurrentLigne.length > 0) {
                            for(int i=0; i<arrCurrentLigne.length; i++) {
                                if (i==0) {
                                    long lngNoCompte;
                                    try {
                                        // System.out.println("\n\n'" + strInfos.split("\\s*" + Miscellaneous.strCSVMainSeparator + "\\s*")[i] + "'\n\n");
                                        lngNoCompte = Long.parseLong(arrCurrentLigne[i]);
                                    } 
                                    catch (NumberFormatException nfe) {
                                        if (blnShowVerbose) {
                                            // System.err.println("Error 'lngNoCompte' Number Format at line " + intCurrentLineNumber + ":\t" + nfe.toString());
                                            logger.log(Level.WARNING, "Error 'lngNoCompte' Number Format at line " + intCurrentLineNumber); //
                                        }
                                        lngNoCompte = 0;
                                    }
                                    catch (IndexOutOfBoundsException ioobe) {
                                        if (blnShowVerbose) {
                                            // System.err.println("Error 'lngNoCompte' Index Out Of Bound at line " + intCurrentLineNumber + ":\t" + ioobe.toString());
                                            logger.log(Level.WARNING, "Error 'lngNoCompte' Index Out Of Bound at line " + intCurrentLineNumber); // 
                                        }
                                        lngNoCompte = 0;
                                    }
                                    formulaire.setLngNoCompte(lngNoCompte);
                                }
                                else if (i==1) {
                                    long lngNoTel;
                                    try {
                                        lngNoTel = Long.parseLong(arrCurrentLigne[i]);
                                    } 
                                    catch (NumberFormatException nfe) {
                                        if (blnShowVerbose) {
                                            // System.err.println("Error 'lngNoTel' Number Format at line " + intCurrentLineNumber + ":\t" + nfe.toString());
                                            logger.log(Level.WARNING, "Error 'lngNoTel' Number Format at line " + intCurrentLineNumber); //
                                        }
                                        lngNoTel = 0;
                                    }
                                    catch (IndexOutOfBoundsException ioobe) {
                                        if (blnShowVerbose) {
                                            // System.err.println("Error 'lngNoCompte' Index Out Of Bound at line " + intCurrentLineNumber + ":\t" + ioobe.toString());
                                            logger.log(Level.WARNING, "Error 'lngNoTel' Index Out Of Bound at line " + intCurrentLineNumber); // 
                                        }
                                        lngNoTel = 0;
                                    }
                                    formulaire.setLngNoTel(lngNoTel);
                                }
                                else if (i==2) {
                                    String strNom;
                                    try {
                                        strNom = arrCurrentLigne[i];
                                    } 
                                    catch (IndexOutOfBoundsException ioobe) {
                                        if (blnShowVerbose) {
                                            // System.err.println("Error 'strNom' Index Out Of Bound at line " + intCurrentLineNumber + ":\t" + ioobe.toString());
                                            logger.log(Level.WARNING, "Error 'strNom' Index Out Of Bound at line " + intCurrentLineNumber); // 
                                        }
                                        strNom = "";
                                    }
                                    formulaire.setStrNom(strNom);
                                }
                                else if (i==3) {
                                    String strPrenom;
                                    try {
                                        strPrenom = arrCurrentLigne[i];
                                    }
                                    catch (IndexOutOfBoundsException ioobe) {
                                        if (blnShowVerbose) {
                                            // System.err.println("Error 'strPrenom' Index Out Of Bound at line " + intCurrentLineNumber + ":\t" + ioobe.toString());
                                            logger.log(Level.WARNING, "Error 'strPrenom' Index Out Of Bound at line " + intCurrentLineNumber); //
                                        }
                                        strPrenom = "";
                                    }
                                    formulaire.setStrPrenom(strPrenom);
                                }
                                else if (i==4) {
                                    String strAdresse;
                                    try {
                                        strAdresse = arrCurrentLigne[i];
                                    }
                                    catch (IndexOutOfBoundsException ioobe) {
                                        if (blnShowVerbose) {
                                            // System.err.println("Error 'strAdresse' Index Out Of Bound at line " + intCurrentLineNumber + ":\t" + ioobe.toString());
                                            logger.log(Level.WARNING, "Error 'strAdresse' Index Out Of Bound at line " + intCurrentLineNumber); //
                                        }
                                        strAdresse = "";
                                    }
                                    formulaire.setStrAdresse(strAdresse);
                                }
                                else if (i==5) {
                                    String strCodePostal;
                                    try {
                                        strCodePostal = arrCurrentLigne[i];
                                    }
                                    catch (IndexOutOfBoundsException ioobe) {
                                        if (blnShowVerbose) {
                                            // System.err.println("Error 'strCodePostal' Index Out Of Bound at line " + intCurrentLineNumber + ":\t" + ioobe.toString());
                                            logger.log(Level.WARNING, "Error 'strCodePostal' Index Out Of Bound at line " + intCurrentLineNumber); //
                                        }
                                        strCodePostal = "";
                                    }
                                    formulaire.setStrCodePostal(strCodePostal);
                                }
                                else if (i==6) {
                                    String strVille;
                                    try {
                                        strVille = arrCurrentLigne[i];
                                    }
                                    catch (IndexOutOfBoundsException ioobe) {
                                        if (blnShowVerbose) {
                                            // System.err.println("Error 'strVille' Index Out Of Bound at line " + intCurrentLineNumber + ":\t" + ioobe.toString());
                                            logger.log(Level.WARNING, "Error 'strVille' Index Out Of Bound at line " + intCurrentLineNumber); //
                                        }
                                        strVille = "";
                                    }
                                    formulaire.setStrVille(strVille);
                                }
                                else if (i==7) {
                                    String strCourriel;
                                    try {
                                        strCourriel = arrCurrentLigne[i];
                                    }
                                    catch (IndexOutOfBoundsException ioobe) {
                                        if (blnShowVerbose) {
                                            // System.err.println("Error 'strCourriel' Index Out Of Bound at line " + intCurrentLineNumber + ":\t" + ioobe.toString());
                                            logger.log(Level.WARNING, "Error 'strCourriel' Index Out Of Bound at line " + intCurrentLineNumber); //
                                        }
                                        strCourriel = "";
                                    }
                                    formulaire.setStrCourriel(strCourriel);
                                }
                                else if (i==8) {
                                    String strDateNaissance;
                                    try {
                                        LocalDate localDate = LocalDate.parse(arrCurrentLigne[i], Config.DATE_TIME_FORMATTER);
                                        strDateNaissance = localDate.toString();

                                        // System.out.println("\n\n\n----->READ LocalDate: '" + localDate.toString() + "'\n\n");

                                        if(strDateNaissance.trim().isEmpty()) {
                                            logger.log(Level.WARNING, "Error: 'strDateNaissance' is empty at line " + intCurrentLineNumber);
                                            throw new Exception("'strDateNaissance' est vide!");
                                        }

                                        Date dateNaissance = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
                                        // if(date.compareTo(LocalDate.now()) < 0) 

                                        Calendar calendarToday = Calendar.getInstance();

                                        calendarToday.clear(Calendar.HOUR); 
                                        calendarToday.clear(Calendar.MINUTE); 
                                        calendarToday.clear(Calendar.SECOND);
                                        calendarToday.clear(Calendar.MILLISECOND);
                                        calendarToday.clear(Calendar.HOUR_OF_DAY);
                                        // calendarToday.clear();

                                        calendarToday.set(Calendar.HOUR, 0);
                                        calendarToday.set(Calendar.HOUR, 0); 
                                        calendarToday.set(Calendar.MINUTE, 0); 
                                        calendarToday.set(Calendar.SECOND, 0);
                                        calendarToday.set(Calendar.MILLISECOND, 0);
                                        calendarToday.set(Calendar.HOUR_OF_DAY, 0);
                                        // calendarToday.setTimeZone(ZoneId.systemDefault());

                                        // System.out.println("\n" + ZoneId.systemDefault());
                                        // System.out.println(calendarToday.getTimeZone().getID() + "\n");

                                        Date todayDate = calendarToday.getTime();

                                        // System.out.println("\nCSV Date: " + dateRendezVous.toString() + "\nToday Date: " + todayDate.toString());
                                        // System.out.println("After Comparison: " + Boolean.toString(todayDate.compareTo(dateRendezVous) <= 0));

                                        // verifie si la date de naissance est plus grand que la date du jour
                                        if(dateNaissance.compareTo(todayDate) >= 0) {
                                            logger.log(Level.WARNING, "Error: 'strDateNaissance' est plus grand que la date d'aujourd'hui at line " + intCurrentLineNumber);
                                            throw new Exception("'dateNaissance' est plus grand que la date d'aujourd'hui!");
                                        }
                                    }
                                    catch (DateTimeParseException dtpe) {
                                        if (blnShowVerbose)
                                            logger.log(Level.WARNING, "Error: La date de naissance doit être une date valide (yyyy-mm-dd) et plus petite à la date d'aujourd'hui, 'dateNaissance' Date Time Parse Exception at line " + intCurrentLineNumber);
                                        strDateNaissance = "";
                                    }
                                    catch (IndexOutOfBoundsException ioobe) {
                                        if (blnShowVerbose)
                                            logger.log(Level.WARNING, "Error: 'dateNaissance' Index Out Of Bound at line " + intCurrentLineNumber);
                                        strDateNaissance = "";
                                    }
                                    catch (Exception e) {
                                        if (blnShowVerbose)
                                            logger.log(Level.WARNING, "Error: 'strDateNaissance' Exception at line " + intCurrentLineNumber);
                                        strDateNaissance = "";
                                    }
                                    formulaire.setStrDateNaissance(strDateNaissance);
                                }
                                // #! strCarteAssuranceMaladie, strDateVisite, etbFirstDose, etbHadCovid, etbHasCovidSymptoms, etbHasAllergies, etbGotVaccinated, enumTypeVaccin, strCodeVaccin
                                else if (i==9) {
                                    String strCarteAssuranceMaladie;
                                    try {
                                        strCarteAssuranceMaladie = arrCurrentLigne[i];
                                    }
                                    catch (IndexOutOfBoundsException ioobe) {
                                        if (blnShowVerbose) {
                                            logger.log(Level.WARNING, "Error 'strCarteAssuranceMaladie' Index Out Of Bound at line " + intCurrentLineNumber); //
                                        }
                                        strCarteAssuranceMaladie = "";
                                    }
                                    formulaire.setStrCarteAssuranceMaladie(strCarteAssuranceMaladie);
                                }
                                else if (i==10) {
                                    String strDateVisite;
                                    try {
                                        strDateVisite = arrCurrentLigne[i];

                                        if (!strDateVisite.trim().isEmpty() && strDateVisite.length() != Config.intFormatLengthDate)
                                            strDateVisite = "";
                                    }
                                    catch (IndexOutOfBoundsException ioobe) {
                                        if (blnShowVerbose) {
                                            logger.log(Level.WARNING, "Error 'strDateVisite' Index Out Of Bound at line " + intCurrentLineNumber); //
                                        }
                                        strDateVisite = "";
                                    }
                                    formulaire.setStrDateVisite(strDateVisite);
                                }
                                else if (i==11) {
                                    String strEtbFirstDose;
                                    EnumTypeBoolean etbFirstDose = null;
                                    try {
                                        strEtbFirstDose = arrCurrentLigne[i];
                                        etbFirstDose = EnumTypeBoolean.valueOf(strEtbFirstDose);
                                    }
                                    catch (IndexOutOfBoundsException ioobe) {
                                        if (blnShowVerbose) {
                                            logger.log(Level.WARNING, "Error 'strEtbFirstDose' Index Out Of Bound at line " + intCurrentLineNumber); //
                                        }
                                        strEtbFirstDose = "";
                                    }
                                    catch (IllegalArgumentException iae) {
                                        if (blnShowVerbose) {
                                            logger.log(Level.WARNING, "Error 'etbFirstDose' Illegal Argument Exception at line " + intCurrentLineNumber); //
                                        }
                                        etbFirstDose = null;
                                    }
                                    formulaire.setEtbFirstDose(etbFirstDose);
                                }
                                else if (i==12) {
                                    String strEtbHadCovid;
                                    EnumTypeBoolean etbHadCovid = null;
                                    try {
                                        strEtbHadCovid = arrCurrentLigne[i];
                                        etbHadCovid = EnumTypeBoolean.valueOf(strEtbHadCovid);
                                    }
                                    catch (IndexOutOfBoundsException ioobe) {
                                        if (blnShowVerbose) {
                                            logger.log(Level.WARNING, "Error 'strEtbHadCovid' Index Out Of Bound at line " + intCurrentLineNumber); //
                                        }
                                        strEtbHadCovid = "";
                                    }
                                    catch (IllegalArgumentException iae) {
                                        if (blnShowVerbose) {
                                            logger.log(Level.WARNING, "Error 'etbHadCovid' Illegal Argument Exception at line " + intCurrentLineNumber); //
                                        }
                                        etbHadCovid = null;
                                    }
                                    formulaire.setEtbHadCovid(etbHadCovid);
                                }
                                else if (i==13) {
                                    String strEtbHasCovidSymptoms;
                                    EnumTypeBoolean etbHasCovidSymptoms = null;
                                    try {
                                        strEtbHasCovidSymptoms = arrCurrentLigne[i];
                                        etbHasCovidSymptoms = EnumTypeBoolean.valueOf(strEtbHasCovidSymptoms);
                                    }
                                    catch (IndexOutOfBoundsException ioobe) {
                                        if (blnShowVerbose) {
                                            logger.log(Level.WARNING, "Error 'strEtbHasCovidSymptoms' Index Out Of Bound at line " + intCurrentLineNumber); //
                                        }
                                        strEtbHasCovidSymptoms = "";
                                    }
                                    catch (IllegalArgumentException iae) {
                                        if (blnShowVerbose) {
                                            logger.log(Level.WARNING, "Error 'etbHasCovidSymptoms' Illegal Argument Exception at line " + intCurrentLineNumber); //
                                        }
                                        etbHasCovidSymptoms = null;
                                    }
                                    formulaire.setEtbHasCovidSymptoms(etbHasCovidSymptoms);
                                }
                                else if (i==14) {
                                    String strEtbHasAllergies;
                                    EnumTypeBoolean etbHasAllergies = null;
                                    try {
                                        strEtbHasAllergies = arrCurrentLigne[i];
                                        etbHasAllergies = EnumTypeBoolean.valueOf(strEtbHasAllergies);
                                    }
                                    catch (IndexOutOfBoundsException ioobe) {
                                        if (blnShowVerbose) {
                                            logger.log(Level.WARNING, "Error 'strEtbHasAllergies' Index Out Of Bound at line " + intCurrentLineNumber); //
                                        }
                                        strEtbHasAllergies = "";
                                    }
                                    catch (IllegalArgumentException iae) {
                                        if (blnShowVerbose) {
                                            logger.log(Level.WARNING, "Error 'etbHasAllergies' Illegal Argument Exception at line " + intCurrentLineNumber); //
                                        }
                                        etbHasAllergies = null;
                                    }
                                    formulaire.setEtbHasAllergies(etbHasAllergies);
                                }
                                else if (i==15) {
                                    String strEtbGotVaccinated;
                                    EnumTypeBoolean etbGotVaccinated = null;
                                    try {
                                        strEtbGotVaccinated = arrCurrentLigne[i];
                                        etbGotVaccinated = EnumTypeBoolean.valueOf(strEtbGotVaccinated);
                                    }
                                    catch (IndexOutOfBoundsException ioobe) {
                                        if (blnShowVerbose) {
                                            logger.log(Level.WARNING, "Error 'strEtbGotVaccinated' Index Out Of Bound at line " + intCurrentLineNumber); //
                                        }
                                        strEtbGotVaccinated = "";
                                    }
                                    catch (IllegalArgumentException iae) {
                                        if (blnShowVerbose) {
                                            logger.log(Level.WARNING, "Error 'etbGotVaccinated' Illegal Argument Exception at line " + intCurrentLineNumber); //
                                        }
                                        etbGotVaccinated = null;
                                    }
                                    formulaire.setEtbGotVaccinated(etbGotVaccinated);
                                }
                                else if (i==16) {
                                    String strEnumTypeVaccin;
                                    EnumTypeVaccin enumTypeVaccin = null;
                                    try {
                                        strEnumTypeVaccin = arrCurrentLigne[i];
                                        enumTypeVaccin = EnumTypeVaccin.valueOf(strEnumTypeVaccin);
                                    }
                                    catch (IndexOutOfBoundsException ioobe) {
                                        if (blnShowVerbose) {
                                            logger.log(Level.WARNING, "Error 'strEnumTypeVaccin' Index Out Of Bound at line " + intCurrentLineNumber); //
                                        }
                                        strEnumTypeVaccin = "";
                                    }
                                    catch (IllegalArgumentException iae) {
                                        if (blnShowVerbose) {
                                            logger.log(Level.WARNING, "Error 'enumTypeVaccin' Illegal Argument Exception at line " + intCurrentLineNumber); //
                                        }
                                        enumTypeVaccin = null;
                                    }
                                    formulaire.setEnumTypeVaccin(enumTypeVaccin);
                                }
                                else if (i==17) {
                                    int intTypeDose;
                                    try {
                                        intTypeDose = Integer.parseInt(arrCurrentLigne[i]);
                                    } 
                                    catch (NumberFormatException nfe) {
                                        if (blnShowVerbose) {
                                            logger.log(Level.WARNING, "Error 'intTypeDose' Number Format at line " + intCurrentLineNumber); //
                                        }
                                        intTypeDose = 0;
                                    }
                                    catch (IndexOutOfBoundsException ioobe) {
                                        if (blnShowVerbose) {
                                            logger.log(Level.WARNING, "Error 'intTypeDose' Index Out Of Bound at line " + intCurrentLineNumber); // 
                                        }
                                        intTypeDose = 0;
                                    }
                                    formulaire.setIntTypeDose(intTypeDose);
                                }
                                else if (i==18) {
                                    String strCodeVaccin;
                                    try {
                                        strCodeVaccin = arrCurrentLigne[i];
                                    }
                                    catch (IndexOutOfBoundsException ioobe) {
                                        if (blnShowVerbose) {
                                            logger.log(Level.WARNING, "Error 'strCodeVaccin' Index Out Of Bound at line " + intCurrentLineNumber); //
                                        }
                                        strCodeVaccin = "";
                                    }
                                    formulaire.setStrCodeVaccin(strCodeVaccin);
                                }
                            }
                        }

                        System.out.println("\n\nFormulaire READ: " + formulaire + "\n\n");

                        if (enumTypeCRUD == EnumTypeCRUD.READ_SAME) {
                            if (formulaire.getLngNoCompte()>0 && userInputFormulaire != null && formulaire.getLngNoCompte() == userInputFormulaire.getLngNoCompte())
                                arrFormulaires.add(formulaire); 
                        }
                        else if (enumTypeCRUD == EnumTypeCRUD.READ || (blnInitDataFile && enumTypeCRUD == EnumTypeCRUD.UPDATE)) {
                            if (formulaire.getLngNoCompte()>0)
                                arrFormulaires.add(formulaire); // check if Formulaire has code identification & no compte, then it is a valid Formulaire
                        }
                        else if (!blnInitDataFile && enumTypeCRUD == EnumTypeCRUD.UPDATE) {
                            if (formulaire.getLngNoCompte()>0 && formulaire.getLngNoCompte() == userInputFormulaire.getLngNoCompte()) {
                                // System.out.println("\nSuccès: L'utilisateur '" + Long.toString(formulaire.getLngNoCompte()) + "' est trouvé dans le fichier '" + strFileName + "' à la ligne " + Integer.toString(intCurrentLineNumber));

                                arrFormulaires.add(formulaire);
                                
                                // System.out.println("Modification de ce compte dans le fichier");
                                System.out.println();
                                logger.log(Level.INFO, ("Succès: Le formulaire du visiteur '" + Long.toString(formulaire.getLngNoCompte()) + "' est trouvé dans le fichier '" + strDataFileFormulaire + "' à la ligne " + Integer.toString(intCurrentLineNumber) + "\nModification de ce compte dans le fichier\n"));
                            }
                            else
                                printWriter.println(strCurrentLine);
                        }
                        else if (enumTypeCRUD == EnumTypeCRUD.DELETE) {
                            if (formulaire.getLngNoCompte()>0 && formulaire.getLngNoCompte() == userInputFormulaire.getLngNoCompte()) {
                                // System.out.println("\nSuccès: L'utilisateur '" + Long.toString(formulaire.getLngNoCompte()) + "' est trouvé dans le fichier '" + strFileName + "' à la ligne " + Integer.toString(intCurrentLineNumber));

                                arrFormulaires.add(formulaire);

                                // System.out.println("Suppression de ce compte dans le fichier");
                                System.out.println();
                                logger.log(Level.INFO, ("Succès: Le fomulaire du visiteur '" + Long.toString(formulaire.getLngNoCompte()) + "' est trouvé dans le fichier '" + strDataFileFormulaire + "' à la ligne " + Integer.toString(intCurrentLineNumber) + "\nSuppression de ce compte dans le fichier\n"));
                            }
                            else 
                                printWriter.println(strCurrentLine);
                        }
                    }
                    // else if (!blnInitDataFile && (enumTypeCRUD == EnumTypeCRUD.UPDATE || enumTypeCRUD == EnumTypeCRUD.DELETE)) { 
                    //     // if updating or deleting Data from file, copy empty line & write into new temp file
                    //     printWriter.println(strCurrentLine);
                    // }
                }

                // Damn you Windows! The OS requires that the connection is closed before deleting or renaming files!
                bufferedReader.close();

                if (blnInitDataFile && userInputFormulaire == null && enumTypeCRUD == EnumTypeCRUD.UPDATE) {
                    if (arrFormulaires == null || arrFormulaires.size() <= 0) {
                        // System.out.println("\nEntering Inside Function\n");

                        Formulaire defaultFormulaire = new Formulaire(Long.parseLong("111111111111"), Long.parseLong("1234567890"), "Test-Nom", "Test-Prenom", "123 Test-Adresse", "A0A0A0", "Test-Ville", "Test-Courriel@test.com", LocalDate.now().minusDays(1).format(Config.DATE_TIME_FORMATTER).toString(), "AAAA00000000", LocalDate.now().format(Config.DATE_TIME_FORMATTER).toString(), EnumTypeBoolean.NON, EnumTypeBoolean.NON, EnumTypeBoolean.NON, EnumTypeBoolean.NON, EnumTypeBoolean.NON, null, 0, "");

                        System.out.println();
                        logger.log(Level.SEVERE, "Fichier des donnés Formulaires.csv VIDE (Nombre Total de Formulaires dans le fichier = '" + arrFormulaires.size() + "')\nCréation d'un formulaire par défaut qui a comme information: " + defaultFormulaire + "\n");
                        // at CSV file line " + intCurrentLineNumber

                        // crudDataListFormulaires(EnumTypeCRUD.UPDATE, strFileName, defaultFormulaire, false, true);
                        
                        // if modifying formulaire, add formulaire to end of file
                        printWriter.println("#! lngNoCompte, lngNoTel, strNom, strPrenom, strAdresse, strCodePostal, strVille, strCourriel, strDateNaissance, strCarteAssuranceMaladie, strDateVisite, etbFirstDose, etbHadCovid, etbHasCovidSymptoms, etbHasAllergies, etbGotVaccinated, enumTypeVaccin, intTypeDose, strCodeVaccin");

                        if (blnInitTempFormulaire)
                            printWriter.println(defaultFormulaire.printInfosFormulaire());

                        // Damn you Windows! The OS requires that the connection is closed before deleting or renaming files!
                        printWriter.close();
                        
                        // out.flush();
                        
                        // delete old csv file if it exist so that newly created one can be renamed to old csv file
                        try {
                            // boolean blnDeleteOldFile = oldFile.delete();

                            // if (!blnDeleteOldFile)
                            //     logger.log(Level.SEVERE, "IMPOSSIBLE de supprimer l'ancien fichier ['" + strFileName + "']!\n");
                            // else 
                            //     logger.log(Level.INFO, "SUCCÈS pour avoir supprimer l'ancien fichier ['" + strFileName + "'].\n");

                            Files.deleteIfExists(Paths.get(strDataFileFormulaire));
                            logger.log(Level.INFO, "SUCCÈS pour avoir supprimer le fichier des formulaires ['" + strDataFileFormulaire + "'].\n");
                        }
                        catch (IOException ioe) {
                            logger.log(Level.SEVERE, "IMPOSSIBLE de supprimer le fichier des formulaires '" + strDataFileFormulaire + "'! " + Config.strRestartAppInstruction + "\nIO Exception pour le fichier: '" + strDataFileFormulaire + "'\n", ioe);
                            System.out.println("");
                        }

                        File dump = new File(strDataFileFormulaire);
                        boolean blnRenameNewFile = newFile.renameTo(dump);

                        if (!blnRenameNewFile)
                            logger.log(Level.SEVERE, "IMPOSSIBLE de renommer le fichier temporaire ['" + tempFile + "'] vers ['" + strDataFileFormulaire + "']!\n");
                        else 
                            logger.log(Level.INFO, "SUCCÈS pour avoir renommer le fichier temporaire ['" + tempFile + "'] vers ['" + strDataFileFormulaire + "'].\n");

                        //! boolean blnAlertErrorDataFileFormulaire = true;
                        returnCrudDataListFormulaires.setBlnAlertErrorDataFileFormulaire(true);
                        return returnCrudDataListFormulaires;
                    }
                }
                else if (enumTypeCRUD == EnumTypeCRUD.READ || enumTypeCRUD == EnumTypeCRUD.READ_SAME) { // ? will stay until fixed ?)
                    // delete temp file that is not needed or used when reading Data from file
                    // newFile.delete();

                    printWriter.close();

                    try {
                        Files.deleteIfExists(Paths.get(tempFile));
                        logger.log(Level.INFO, "Mode Lecture: SUCCÈS pour avoir supprimer le fichier temporaire des formulaires ['" + tempFile + "'].\n");
                    }
                    catch (IOException ioe) {
                        logger.log(Level.SEVERE, "Mode Lecture: IMPOSSIBLE de supprimer le fichier temporaire des formulaires '" + tempFile + "'! " + Config.strRestartAppInstruction + "\nIO Exception pour le fichier: '" + tempFile + "'\n", ioe);
                        System.out.println("");
                    }
                }
                else if (!blnInitDataFile && (enumTypeCRUD == EnumTypeCRUD.UPDATE || enumTypeCRUD == EnumTypeCRUD.DELETE)) {
                    // if modifying formulaire, add formulaire to end of file
                    if (enumTypeCRUD == EnumTypeCRUD.UPDATE) 
                        printWriter.println(((Formulaire) userInputFormulaire).printInfosFormulaire());

                    // Damn you Windows! The OS requires that the connection is closed before deleting or renaming files!
                    printWriter.close();

                    // out.flush();
                    
                    // delete old csv file if it exist so that newly created one can be renamed to old csv file
                    try {
                        // boolean blnDeleteOldFile = oldFile.delete();

                        // if (!blnDeleteOldFile)
                        //     logger.log(Level.SEVERE, "IMPOSSIBLE de supprimer l'ancien fichier ['" + strFileName + "']!\n");
                        // else 
                        //     logger.log(Level.INFO, "SUCCÈS pour avoir supprimer l'ancien fichier ['" + strFileName + "'].\n");

                        Files.deleteIfExists(Paths.get(strDataFileFormulaire));
                        logger.log(Level.INFO, "SUCCÈS pour avoir supprimer le fichier des formulaires ['" + strDataFileFormulaire + "'].\n");
                    }
                    catch (IOException ioe) {
                        logger.log(Level.SEVERE, "IMPOSSIBLE de supprimer le fichier des formulaires '" + strDataFileFormulaire + "'! " + Config.strRestartAppInstruction + "\nIO Exception pour le fichier: '" + strDataFileFormulaire + "'\n", ioe);
                        System.out.println("");
                    }

                    File dump = new File(strDataFileFormulaire);
                    boolean blnRenameNewFile = newFile.renameTo(dump);

                    if (!blnRenameNewFile)
                        logger.log(Level.SEVERE, "IMPOSSIBLE de renommer le fichier temporaire ['" + tempFile + "'] vers ['" + strDataFileFormulaire + "']!\n");
                    else 
                        logger.log(Level.INFO, "SUCCÈS pour avoir renommer le fichier temporaire ['" + tempFile + "'] vers ['" + strDataFileFormulaire + "'].\n");

                    // System.out.println("\n\nnewFile: " + newFile.getAbsolutePath() + "\ndumpFile: " + dump.getAbsolutePath() + "\n");

                    if (enumTypeCRUD == EnumTypeCRUD.DELETE) {
                        // System.out.println("\nSuppression du compte formulaire '" + Long.toString(userInputFormulaire.getLngNoCompte()) + "' réussi!\n");
                        System.out.println();
                        logger.log(Level.INFO, "Suppression du compte formulaire '" + Long.toString(userInputFormulaire.getLngNoCompte()) + "' réussi!\n");
                    }
                    else if (enumTypeCRUD == EnumTypeCRUD.UPDATE) {
                        // System.out.println("\nModification du compte formulaire '" + Long.toString(userInputFormulaire.getLngNoCompte()) + "' réussi!\n");
                        System.out.println();
                        logger.log(Level.INFO, "Modification du compte formulaire '" + Long.toString(userInputFormulaire.getLngNoCompte()) + "' réussi!\n");
                    }

                    if (arrFormulaires == null || arrFormulaires.size() <= 0) {
                        if (enumTypeCRUD == EnumTypeCRUD.DELETE) {
                            // System.out.println("LA LISTE DES COMPTES VISITEURS SUPPRIMÉ EST VIDE!");
                            System.out.println();
                            logger.log(Level.WARNING, "LA LISTE DES FORMULAIRES SUPPRIMÉS EST VIDE!\n");
                        }
                        else if (enumTypeCRUD == EnumTypeCRUD.UPDATE) {
                            // System.out.println("LA LISTE DES COMPTES VISITEURS MODIFIÉ EST VIDE!");
                            System.out.println();
                            logger.log(Level.WARNING, "LA LISTE DES FORMULAIRES MODIFIÉS EST VIDE!\n");
                        }
                    }
                    else {
                        String strStyleListe = "";
                        if (enumTypeCRUD == EnumTypeCRUD.DELETE) {
                            strStyleListe = "Liste des formulaires supprimés dans le fichier:";
                        }
                        else if (enumTypeCRUD == EnumTypeCRUD.UPDATE) {
                            strStyleListe = "Liste des formulaires modifiés dans le fichier:";
                        }
                        
                        String strStyleListeDash = "", strStyleListeDoubleDash = "";
                        for (int j=0; j<strStyleListe.length(); j++) {
                            strStyleListeDash += "-";
                            strStyleListeDoubleDash += "=";
                        }
                        
                        String strToLog = "";
                        strToLog += (strStyleListeDoubleDash + "\n");
                        strToLog += (strStyleListe + "\n");
                        strToLog += (strStyleListeDash + "\n");
                        for (Formulaire e : arrFormulaires)
                            strToLog += (e + "\n");
                        // System.out.println();

                        logger.log(Level.INFO, "\n" + strToLog + "\n\n");
                    }
                }
                else // close file writing just in case it was not closed by above if/else
                    printWriter.close();
            }
            catch (FileNotFoundException fnf) {
                // System.err.println("\n\nFile '" + strFileName + "' not found\n\nError:\t" + fnf.toString());
    
                //System.exit(0);

                System.out.println();
                logger.log(Level.SEVERE, "Fichier '" + strDataFileFormulaire + "' INTROUVABLE. Donnez le bon fichier comme paramètre!\n", fnf);
            }
            catch (IOException io) {
                // System.err.println("\n\nIO Exception for file '" + strFileName + "'\n\nError:\t" + io.toString());
    
                //System.exit(0);

                System.out.println();
                logger.log(Level.SEVERE, "IOException pour le fichier '" + strDataFileFormulaire + "'!\n", io);
            }

            // System.out.println("\nList Formulaires.csv");
            // for (Formulaire e : arrFormulaires)
            //     System.out.println(e);
            // System.out.println("\n");
            System.out.println("");

            returnCrudDataListFormulaires.setArrFormulaires(arrFormulaires);
            return returnCrudDataListFormulaires;
        }

        return null;
    }
}
