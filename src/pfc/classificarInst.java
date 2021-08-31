/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pfc;

import java.io.IOException;
import java.util.Random;
import weka.core.Capabilities;
import weka.core.Instance;
import weka.core.Instances;
import weka.core.CapabilitiesHandler;
import weka.classifiers.trees.J48;
import weka.core.DenseInstance;
import weka.classifiers.evaluation.Evaluation;



/**
 *
 * @author Balbicosta
 */
public class classificarInst  {
    
    public String resultado, matriz;
    public double instCor, instIncor, perCor, perIncor, kappa, meaErro,rmsErro, raErro, rrsErro;
    public int b=0, bl=0, m=0, ml=0, a=0; 
    public Instance itc = null;
    Random rad = new Random();
    
    public Instances carregarTreino(Instances itt) throws IOException, Exception {
        
        String resultado;
        
        J48 arv = new J48();
        arv.buildClassifier(itt);
        arv.setUnpruned(false);
        arv.setUseLaplace(false);
        arv.setUseMDLcorrection(false);
        arv.setSubtreeRaising(true);
        arv.setCollapseTree(true);
        arv.setReducedErrorPruning(true);
        arv.setDoNotCheckCapabilities(false);
        arv.setDoNotMakeSplitPointActualValue(false);
        arv.setMinNumObj(2);
        arv.setSaveInstanceData(false);

        Evaluation aval = new Evaluation(itt);
        itt.randomize(rad);
        Instances treino = itt.trainCV(arv.getNumFolds(), arv.getNumFolds(), rad);
        aval.setPriors(itt);
        for (int i=0; i<itt.numInstances(); i++){
            double Aval = aval.evaluateModelOnceAndRecordPrediction(arv, itt.instance(i));
        }
        return itt;
    }    
    
    public Instances carregarTeste(Instances its) throws Exception{
        
        J48 arv = new J48();
        arv.buildClassifier(its);
        arv.setUnpruned(false);
        arv.setUseLaplace(false);
        arv.setUseMDLcorrection(false);
        arv.setSubtreeRaising(true);
        arv.setCollapseTree(true);
        arv.setReducedErrorPruning(true);
        arv.setDoNotCheckCapabilities(false);
        arv.setDoNotMakeSplitPointActualValue(false);
        arv.setMinNumObj(2);
        arv.setSaveInstanceData(false);
        
        Evaluation aval = new Evaluation(its);
        Instances teste = its.testCV(arv.getNumFolds(), 2);
        for (int i=0; i<its.numInstances(); i++){
            double Aval = aval.evaluateModelOnceAndRecordPrediction(arv, its.instance(i));
        }
        
        resultado = aval.toSummaryString("\nResultado\n\n", true);
        instCor = aval.correct();
        instIncor = aval.incorrect();
        perCor = aval.pctCorrect();
        perIncor = aval.pctIncorrect();
        kappa = aval.kappa();
        meaErro = aval.meanAbsoluteError();
        rmsErro = aval.rootMeanSquaredError();
        raErro = aval.relativeAbsoluteError();
        rrsErro = aval.rootRelativeSquaredError();
        matriz = aval.toMatrixString("Matriz de Confusão"); 
        
        itc = new DenseInstance(its.numAttributes());
        itc.setDataset(its);
            for(int i=0; i<its.numInstances(); i++){
                itc = its.instance(i);
                double qtd = arv.classifyInstance(itc);
                switch ((int)qtd){
                    case 0:
                        b+=1;
                        break;
                    case 1:
                        bl+=1;
                        break;
                    case 2:
                        m+=1;
                        break;
                    case 3:
                        ml+=1;
                        break;
                    case 4:
                        a+=1;
                        break;
                    default:
                }
            }
        return its;
    }
    
    public Capabilities obterResultados() {
        weka.core.Capabilities resultado = new weka.core.Capabilities((CapabilitiesHandler) this);

        resultado.enable(weka.core.Capabilities.Capability.NOMINAL_ATTRIBUTES);
        resultado.enable(weka.core.Capabilities.Capability.NUMERIC_ATTRIBUTES);
        resultado.enable(weka.core.Capabilities.Capability.DATE_ATTRIBUTES);
        resultado.enable(weka.core.Capabilities.Capability.MISSING_VALUES);
        resultado.enable(weka.core.Capabilities.Capability.NOMINAL_CLASS);
        resultado.enable(weka.core.Capabilities.Capability.MISSING_CLASS_VALUES);

        resultado.setMinimumNumberInstances(0);
        return resultado;
    }
}
