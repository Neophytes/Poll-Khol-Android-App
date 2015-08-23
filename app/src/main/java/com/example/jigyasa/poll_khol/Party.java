package com.example.jigyasa.poll_khol;

import com.orm.SugarRecord;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dell pc on 22-08-2015.
 */
public class Party extends SugarRecord<Party>{
    String party_name;
    List<Manifesto> manifesto;
    List<Candidates> candidates;
    List<ProblemBox> problemBox;

    public Party(){

    }

    public Party(String party_name,List<Manifesto> manifesto, List<Candidates> candidates, List<ProblemBox> problemBox){
        this.party_name=party_name;
        this.manifesto=manifesto;
        this.candidates=candidates;
        this.problemBox=problemBox;
    }

    public static void main(){

        Manifesto manifesto1=new Manifesto("Delhi Janlokpal Bill","Aam Aadmi Party resolves to legislate the Delhi Jan Lokpal Bill after coming to power. This will ensure a time-bound investigation in matters of corruption. The Delhi Lokpal will have the power to initiate investigations and prosecution against those charged with corruption. A Citizens’ Charter shall be introduced in all government offices in Delhi. Whistleblowers will be provided protection and awarded for their contribution toward creating a just system. ");
        manifesto1.save();

        Manifesto manifesto2=new Manifesto("Swaraj Bill",": Aam Aadmi Party will legislate the Swaraj Act to devolve power directly to the people. Decisions affecting the local community will be taken by citizens and implemented by their Secretariat. A Citizen Local Area Development (C-LAD) Fund will be given to every Mohalla Sabha and Resident Welfare Association, ensuring funds and functions in the hands of the community. ");
        manifesto2.save();

        Manifesto manifesto3=new Manifesto("Full Statehood for Delhi","Acting within the constitutional framework our government will use its moral and political authority to push for full statehood for Delhi. This will ensure that institutions such as the DDA, MCD and Delhi Police will be accountable to the elected government of Delhi. This way land will be made available for the common man, there will be greater synchronization and shared purpose among civic services with regard to service delivery and the law and order machinery will be accountable to the citizens.");
        manifesto3.save();

        Manifesto manifesto4=new Manifesto("Electricity Bills to be reduced by half","An Aam Aadmi Party government will keep its promise of reducing electricity bills by half. A more efficient, transparent and accountable system to regulate and audit the power generation and distribution companies is the need of the hour and AAP will do everything within its command to achieve that. Discoms should purchase power from economical sources and wriggle out of expensive and unsustainable Power Purchase Agreements. AAP will take measures to provide relief from rising power bills, namely generating cheaper electricity, improving transmission efficiency, fixing billing defects and correcting meter defects. ");
        manifesto4.save();

        Manifesto manifesto5=new Manifesto("Delhi’s Own Power Station","We will put up Delhi's own power station at the pithead and comprehensively solve Delhi's electricity problem in the long run by being able to meet peak power consumption of 6200MW. We will also ensure that the Rajghat and Bawana plant are efficiently utilized. ");
        manifesto5.save();

        List<Manifesto> manifesto= Manifesto.listAll(Manifesto.class);

        Candidates candidates1=new Candidates("Arvind Kejriwal");
        candidates1.save();

        Candidates candidates2=new Candidates("Somnath Bharti");
        candidates2.save();

        Candidates candidates3=new Candidates("Saurabh Bharadwaj");
        candidates3.save();

        Candidates candidates4=new Candidates("Manish Sisodia");
        candidates4.save();

        List<Candidates> candidatesList= Candidates.listAll(Candidates.class);

        ProblemBox pm=new ProblemBox("KEJRIWAL","kkvkiv kgig kgeigwif kuriuur");
        pm.save();

        List<ProblemBox> problems= ProblemBox.listAll(ProblemBox.class);

        Party aap=new Party("Aam Aadmi Party",manifesto,candidatesList,problems);

        Manifesto manifesto6=new Manifesto("Price Rise","put in place strict measures and special Courts to stop hoarding and black marketing.\n" +
                "\u0001 setting up a Price Stabilisation Fund.\n" +
                "\u0001 unbundle FCI operations into procurement, storage and distribution for greater efficiency");
        manifesto6.save();

        Manifesto manifesto7=new Manifesto("Employment and Entrepreneurship","strategically develop high impact domains like Labour-intensive manufacturing (viz. textile,\n" +
                "footwear, electronics assembly, etc.) and Tourism.\n" +
                "\u0001 strengthen the traditional employment bases of agriculture and allied industries, and retail -\n" +
                "through modernization as well as stronger credit and market linkages.");
        manifesto7.save();

        Manifesto manifesto8=new Manifesto("Corruption","We will establish a system, which eliminates the scope for corruption. We will do this through:\n" +
                "\u0001 public awareness\n" +
                "\u0001 technology enabled e-Governance - minimizing the discretion in the citizen-government interface.\n" +
                "\u0001 system-based, policy-driven governance - making it transparent.");
        manifesto8.save();

        Manifesto manifesto9=new Manifesto("Poor Delivery","remove bottlenecks and missing links in all sectors, activities and services.\n" +
                "\u0001 focus on proper planning and execution for right outcomes.\n" +
                "\u0001 strive for scale and speed with futuristic vision.\n" +
                "\u0001 Build institutions for today and tomorrow");
        manifesto9.save();

        Manifesto manifesto10=new Manifesto("Decision and Policy Paralysis","The country has suffered a decade of maladministration and scams in addition to decision and policy\n" +
                "paralysis; thus bringing growth and development to a grinding halt leading to a 'Governance deficit'.\n" +
                "This situation will be changed and the engine of Government will be ignited again with strong willpower\n" +
                "and commitment to public interest.");
        manifesto10.save();

        List<Manifesto> manifestobjp= new ArrayList<Manifesto>();
        manifestobjp.add(Manifesto.findById(Manifesto.class,6L));
        manifestobjp.add(Manifesto.findById(Manifesto.class,7L));
        manifestobjp.add(Manifesto.findById(Manifesto.class,8L));
        manifestobjp.add(Manifesto.findById(Manifesto.class,9L));
        manifestobjp.add(Manifesto.findById(Manifesto.class,10L));

        Candidates candidates5=new Candidates("Kiran Bedi");
        candidates5.save();

        Candidates candidates6=new Candidates(" Jagdish Mukhi");
        candidates6.save();

        Candidates candidates7=new Candidates(" Krishna Tirath");
        candidates7.save();

        Candidates candidates8=new Candidates(" Vinod Binny");
        candidates8.save();

        List<Candidates> candidatesListbjp=new ArrayList<>();
        candidatesListbjp.add(Candidates.findById(Candidates.class,5L));
        candidatesListbjp.add(Candidates.findById(Candidates.class,6L));
        candidatesListbjp.add(Candidates.findById(Candidates.class,7L));
        candidatesListbjp.add(Candidates.findById(Candidates.class,8L));

        ProblemBox pmbjp=new ProblemBox("MODI","sfsafasdd ADS");
        pmbjp.save();

        List<ProblemBox> problemsbjp= ProblemBox.listAll(ProblemBox.class);

        Party bjp=new Party("Bhartiya Janta Party",manifestobjp,candidatesListbjp,problemsbjp);

        Manifesto manifesto11=new Manifesto("Education","Professional evening colleges to be setup in Government school buildings after the conclusion of the morning shift to make optimum use of school buildings, wherever possible. Education in colleges in two shifts. 85% seats for Delhi Students in Delhi Government colleges. 12 colleges are 100% funded by the Government. IIT and Polytechnic institutes to be run in two shifts");
        manifesto11.save();

        Manifesto manifesto12=new Manifesto("Pension","Pension amount to all deserving categories would be enhanced to Rs 2000 per month to uniformize pension for all, including widows and handicapped");
        manifesto12.save();

        Manifesto manifesto13=new Manifesto("Health Care","24-hour free diagnostic centres, with CT scan, MRI and ultrasound facilities for the poor would be run in every hospital, under the Private-Public Partnership model. NAT testing to be done in all Government hospitals.");
        manifesto13.save();

        Manifesto manifesto14=new Manifesto("Unauthorised Colonies","Regularisation of unauthorised colonies. The Congress will regularize all those unauthorized colonies which had been left out, in addition to all the unauthorized colonies regularized by the previous Congress Government in Delhi.");
        manifesto14.save();

        Manifesto manifesto15=new Manifesto("Old Age Homes","New old age homes would be constructed for different groups of people under “paid and unpaid” categories.");
        manifesto15.save();

        List<Manifesto> manifestocng= new ArrayList<Manifesto>();
        manifestocng.add(Manifesto.findById(Manifesto.class,11L));
        manifestocng.add(Manifesto.findById(Manifesto.class,12L));
        manifestocng.add(Manifesto.findById(Manifesto.class,13L));
        manifestocng.add(Manifesto.findById(Manifesto.class,14L));
        manifestocng.add(Manifesto.findById(Manifesto.class,15L));

        Candidates candidates9=new Candidates("Raj Kumar Chauhan");
        candidates9.save();

        Candidates candidates10=new Candidates("Haroon Yusuf");
        candidates10.save();

        Candidates candidates11=new Candidates("Arvinder Singh Lovel");
        candidates11.save();

        Candidates candidates12=new Candidates("Praveen Kumar Bhugra");
        candidates12.save();

        List<Candidates> candidatesListcng=new ArrayList<>();
        candidatesListcng.add(Candidates.findById(Candidates.class,9L));
        candidatesListcng.add(Candidates.findById(Candidates.class,10L));
        candidatesListcng.add(Candidates.findById(Candidates.class,11L));
        candidatesListcng.add(Candidates.findById(Candidates.class,12L));

        ProblemBox pmcng=new ProblemBox("RAHUL","asdas aasda");
        pmbjp.save();

        List<ProblemBox> problemscng= ProblemBox.listAll(ProblemBox.class);

        Party congress=new Party("Congress",manifestocng,candidatesListcng,problemscng);
        List<ProblemBox> books = ProblemBox.listAll(ProblemBox.class);


        ProblemBox.deleteAll(ProblemBox.class);
    }
}
