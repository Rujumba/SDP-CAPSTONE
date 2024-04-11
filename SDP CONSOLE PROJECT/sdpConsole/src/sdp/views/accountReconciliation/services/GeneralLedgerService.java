package sdp.views.accountReconciliation.services;



import sdp.repository.accountRepositories.GeneralLedgerRepository;
import sdp.models.account.GeneralLedger;

import java.util.List;

public class GeneralLedgerService {
    private GeneralLedgerRepository generalLedgerRepository = new GeneralLedgerRepository();

    public List<GeneralLedger> getAllGeneralLedgerEntries(){
        return generalLedgerRepository.getAllGeneralLedgerEntries();
    }

    public void addGeneralLedger(GeneralLedger generalLedger){
        generalLedgerRepository.addGeneralLedger(generalLedger);
    }
}
