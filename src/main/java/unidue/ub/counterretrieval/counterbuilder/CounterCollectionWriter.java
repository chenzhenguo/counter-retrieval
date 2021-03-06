package unidue.ub.counterretrieval.counterbuilder;

import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import unidue.ub.counterretrieval.DataWriter;
import unidue.ub.counterretrieval.model.data.Counter;

import java.util.List;

@Component
@StepScope
public class CounterCollectionWriter implements ItemWriter<CounterCollection> {

    @Autowired
    private DataWriter dataWriter;

    @Override
    public void write(List list) {
        List<CounterCollection> counterCollections = (List<CounterCollection>) list;

        for (CounterCollection counterCollection : counterCollections) {
            List<Counter> listCounters = counterCollection.getCounters();
            dataWriter.write(listCounters);
        }
    }
}
