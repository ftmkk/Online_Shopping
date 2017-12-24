package Controller.ProductController.Search.TfIdf;

/**
 * Created by macintosh on 12/23/17.
 */

import java.util.List;

public class TfIdf
{
    // Calculates the tf of term termToCheck
    // totalterms : Array of all the words under processing document
    // termToCheck : term of which tf is to be calculated.
    // returns tf(term frequency) of term termToCheck

    public double tfCalculator(String[] totalterms, String termToCheck)
    {
        double count = 0;  //to count the overall occurrence of the term termToCheck
        for (String s : totalterms)
        {
            if (s.equalsIgnoreCase(termToCheck))
            {
                count++;
            }
        }
        return count / totalterms.length;
    }


    public double idfCalculator(List<String[]> allTerms, String termToCheck)
    {
        double count = 0;
        for (String[] ss : allTerms)
        {
            for (String s : ss)
            {
                if (s.equalsIgnoreCase(termToCheck))
                {
                    count++;
                    break;
                }
            }
        }
        return 1 + Math.log(allTerms.size() / count);
    }
}