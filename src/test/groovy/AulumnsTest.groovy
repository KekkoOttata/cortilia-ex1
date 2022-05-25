package groovy

import com.example.cortiliabe.data.entity.Aulumn
import com.example.cortiliabe.data.entity.Education
import com.example.cortiliabe.data.entity.Formation
import com.example.cortiliabe.data.entity.Street
import com.example.cortiliabe.repository.AulumnRepository
import com.example.cortiliabe.repository.FormationRepository
import com.example.cortiliabe.service.AulumnService
import org.apache.tomcat.jni.Address
import org.springframework.beans.factory.annotation.Autowired
import spock.lang.Specification
import static com.example.cortiliabe.util.Util.isNumeric;

class AulumnsTest extends  Specification {

    @Autowired
    AulumnService aulumnService;

    def "use case : insert and save an aulumn"(){
        given:
          ArrayList<List> streets = new ArrayList<>();
          streets.add(new Street("street",12,country))
          Formation master= new  Formation("university",2010)
          Formation phd= new  Formation("university",2020)
          Education education = new Education(master,phd)
          Aulumn aulumn = new Aulumn("test",streets,education);

        when:
          Aulumn insert = aulumnService.saveAulumn(aulumn);

        then:
        insert.getName() == aulumn.getName();
        !insert.getAddresses().isEmpty()
        for(int i = 0;i<insert.getAddresses().size();i++){
            insert.getAddresses().get(i).getStreet().matches(".*[0-9].*")
            isNumeric(insert.getAddresses().get(i).getNumber());
        }
        insert.getEducation() !=null;
    }


    def "use case: find by name "(){
        given:
          String name = nome;


        when:
         Aulumn get = aulumnService.getAulumn(name);

        then:
          get.name == name;



    }

}
