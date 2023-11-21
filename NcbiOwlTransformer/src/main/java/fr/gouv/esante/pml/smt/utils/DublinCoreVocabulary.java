package fr.gouv.esante.pml.smt.utils;

import static org.semanticweb.owlapi.util.OWLAPIPreconditions.verifyNotNull;

import java.util.Arrays;
import java.util.Set;

import javax.annotation.Nonnull;

import org.semanticweb.owlapi.model.HasIRI;
import org.semanticweb.owlapi.model.HasPrefixedName;
import org.semanticweb.owlapi.model.HasShortForm;
import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.vocab.Namespaces;

import com.google.common.base.Function;
import com.google.common.collect.Iterables;
import com.google.common.collect.Sets;

/**
 * @author Matthew Horridge, The University Of Manchester, Bio-Health
 *         Informatics Group
 * @since 2.0.0
 */
public enum DublinCoreVocabulary
        implements
        HasShortForm,
        HasIRI,
        HasPrefixedName {
//@formatter:off
    /** http://purl.org/dc/elements/1.1/contributor */ CONTRIBUTOR("contributor"),
    /** http://purl.org/dc/elements/1.1/coverage */    COVERAGE   ("coverage"   ),
    /** http://purl.org/dc/elements/1.1/creator */     CREATOR    ("creator"    ),
    /** http://purl.org/dc/elements/1.1/date */        DATE       ("date"       ),
    /** http://purl.org/dc/elements/1.1/description */ DESCRIPTION("description"),
    /** http://purl.org/dc/elements/1.1/format */      FORMAT     ("format"     ),
    /** http://purl.org/dc/elements/1.1/identifier */  IDENTIFIER ("identifier" ),
    /** http://purl.org/dc/elements/1.1/language */    LANGUAGE   ("language"   ),
    /** http://purl.org/dc/elements/1.1/publisher */   PUBLISHER  ("publisher"  ),
    /** http://purl.org/dc/elements/1.1/relation */    RELATION   ("relation"   ),
    /** http://purl.org/dc/elements/1.1/rights */      RIGHTS     ("rights"     ),
    /** http://purl.org/dc/elements/1.1/source */      SOURCE     ("source"     ),
    /** http://purl.org/dc/elements/1.1/subject */     SUBJECT    ("subject"    ),
    /** http://purl.org/dc/elements/1.1/title */       TITLE      ("title"      ),
    /** http://purl.org/dc/elements/1.1/type */        TYPE       ("type"       );
//@formatter:on
    @Nonnull
    private final String shortName;
    @Nonnull
    private final String qname;
    @Nonnull
    private final IRI iri;
    /** Dublin Core name space */
    @Nonnull
    public static final String NAME_SPACE = "http://purl.org/dc/elements/1.1/";

    DublinCoreVocabulary(@Nonnull String name) {
        shortName = name;
        qname = Namespaces.DC.getPrefixName() + ':' + name;
        iri = IRI.create(NAME_SPACE, name);
    }

    @Override
    public String getShortForm() {
        return shortName;
    }

    @Override
    public String getPrefixedName() {
        return qname;
    }

    @Override
    public IRI getIRI() {
        return iri;
    }

    /** all IRIs */
    public static final Set<IRI> ALL_URIS = Sets.newHashSet(Iterables
            .transform(Arrays.asList(values()),
                    new Function<DublinCoreVocabulary, IRI>() {

                        @Override
                        public IRI apply(DublinCoreVocabulary arg0) {
                            return verifyNotNull(arg0).getIRI();
                        }
                    }));

    @Override
    public String toString() {
        return iri.toString();
    }
}

