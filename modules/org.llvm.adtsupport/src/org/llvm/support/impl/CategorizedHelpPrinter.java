/**
 * This file was converted to Java from the original LLVM source file. The original
 * source file follows the LLVM Release License, outlined below.
 * 
 * ==============================================================================
 * LLVM Release License
 * ==============================================================================
 * University of Illinois/NCSA
 * Open Source License
 * 
 * Copyright (c) 2003-2017 University of Illinois at Urbana-Champaign.
 * All rights reserved.
 * 
 * Developed by:
 * 
 *     LLVM Team
 * 
 *     University of Illinois at Urbana-Champaign
 * 
 *     http://llvm.org
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy of
 * this software and associated documentation files (the "Software"), to deal with
 * the Software without restriction, including without limitation the rights to
 * use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies
 * of the Software, and to permit persons to whom the Software is furnished to do
 * so, subject to the following conditions:
 * 
 *     * Redistributions of source code must retain the above copyright notice,
 *       this list of conditions and the following disclaimers.
 * 
 *     * Redistributions in binary form must reproduce the above copyright notice
 *       this list of conditions and the following disclaimers in the
 *       documentation and/or other materials provided with the distribution.
 * 
 *     * Neither the names of the LLVM Team, University of Illinois at
 *       Urbana-Champaign, nor the names of its contributors may be used to
 *       endorse or promote products derived from this Software without specific
 *       prior written permission.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS
 * FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT.  IN NO EVENT SHALL THE
 * CONTRIBUTORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS WITH THE
 * SOFTWARE.
 * 
 * ==============================================================================
 * Copyrights and Licenses for Third Party Software Distributed with LLVM:
 * ==============================================================================
 * The LLVM software contains code written by third parties.  Such software will
 * have its own individual LICENSE.TXT file in the directory in which it appears.
 * This file will describe the copyrights, license, and restrictions which apply
 * to that code.
 * 
 * The disclaimer of warranty in the University of Illinois Open Source License
 * applies to all code in the LLVM Distribution, and nothing in any of the
 * other licenses gives permission to use the names of the LLVM Team or the
 * University of Illinois to endorse or promote products derived from this
 * Software.
 * 
 * The following pieces of software have additional or alternate copyrights,
 * licenses, and/or restrictions:
 * 
 * Program             Directory
 * -------             ---------
 * Autoconf            llvm/autoconf
 *                     llvm/projects/ModuleMaker/autoconf
 * Google Test         llvm/utils/unittest/googletest
 * OpenBSD regex       llvm/lib/Support/{reg*, COPYRIGHT.regex}
 * pyyaml tests        llvm/test/YAMLParser/{*.data, LICENSE.TXT}
 * ARM contributions   llvm/lib/Target/ARM/LICENSE.TXT
 * md5 contributions   llvm/lib/Support/MD5.cpp llvm/include/llvm/Support/MD5.h
 */

package org.llvm.support.impl;

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.clank.java.std.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.llvm.cl.*;
import static org.llvm.support.impl.CommandLineStatics.*;
import static org.clank.support.Unsigned.$greater_uint;

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CategorizedHelpPrinter">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp", line = 1825,
 old_source = "${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp", old_line = 1536,
 FQN="(anonymous namespace)::CategorizedHelpPrinter", NM="_ZN12_GLOBAL__N_122CategorizedHelpPrinterE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp -nm=_ZN12_GLOBAL__N_122CategorizedHelpPrinterE")
//</editor-fold>
public class CategorizedHelpPrinter extends /*public*/ HelpPrinter implements Destructors.ClassWithDestructor {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CategorizedHelpPrinter::CategorizedHelpPrinter">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp", line = 1827,
   old_source = "${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp", old_line = 1538,
   FQN="(anonymous namespace)::CategorizedHelpPrinter::CategorizedHelpPrinter", NM="_ZN12_GLOBAL__N_122CategorizedHelpPrinterC1Eb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp -nm=_ZN12_GLOBAL__N_122CategorizedHelpPrinterC1Eb")
  //</editor-fold>
  public /*explicit*/ CategorizedHelpPrinter(boolean showHidden) {
    // : HelpPrinter(showHidden) 
    //START JInit
    super(showHidden);
    //END JInit
  }

  
  // Helper function for printOptions().
  // It shall return a negative value if A's name should be lexicographically
  // ordered before B's name. It returns a value greater equal zero otherwise.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CategorizedHelpPrinter::OptionCategoryCompare">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp", line = 1832,
   old_source = "${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp", old_line = 1543,
   FQN="(anonymous namespace)::CategorizedHelpPrinter::OptionCategoryCompare", NM="_ZN12_GLOBAL__N_122CategorizedHelpPrinter21OptionCategoryCompareEPKPN4llvm2cl14OptionCategoryES6_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp -nm=_ZN12_GLOBAL__N_122CategorizedHelpPrinter21OptionCategoryCompareEPKPN4llvm2cl14OptionCategoryES6_")
  //</editor-fold>
  public static int OptionCategoryCompare(OptionCategory /*P*/ A, OptionCategory /*P*/ B) {
    int Length = strcmp(A.getName(), B.getName());
    assert (Length != 0) : "Duplicate option categories";
    return Length;
  }

  
  // Make sure we inherit our base class's operator=()
  //JAVA: using HelpPrinter::operator=;
/*protected:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CategorizedHelpPrinter::printOptions">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*pre 3.9*/,
   source = "${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp", line = 1841,
   old_source = "${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp", old_line = 1552,
   FQN="(anonymous namespace)::CategorizedHelpPrinter::printOptions", NM="_ZN12_GLOBAL__N_122CategorizedHelpPrinter12printOptionsERN4llvm11SmallVectorISt4pairIPKcPNS1_2cl6OptionEELj128EEEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp -nm=_ZN12_GLOBAL__N_122CategorizedHelpPrinter12printOptionsERN4llvm11SmallVectorISt4pairIPKcPNS1_2cl6OptionEELj128EEEj")
  //</editor-fold>
  @Override protected void printOptions(final SmallVector<std.pairTypePtr</*const*/char$ptr/*char P*/ , Option /*P*/ >> /*&*/ Opts, /*size_t*/int MaxArgLen)/* override*/ {
    std.vector<OptionCategory /*P*/ > SortedCategories = null;
    std.mapPtrType<OptionCategory /*P*/ , std.vector<Option /*P*/ >> CategorizedOptions = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      SortedCategories/*J*/= new std.vector<OptionCategory /*P*/ >((OptionCategory)null);
      CategorizedOptions/*J*/= new std.mapPtrType<OptionCategory /*P*/ , std.vector<Option /*P*/ >>(new std.vector<Option>((Option) null));
      
      // Collect registered option categories into vector in preparation for
      // sorting.
      for (SmallPtrSetIterator<OptionCategory/*P*/> I = $tryClone(RegisteredOptionCategories.$arrow().begin()), 
          E = $tryClone(RegisteredOptionCategories.$arrow().end());
           I.$noteq(E); I.$preInc())  {
        SortedCategories.push_back(I.$star());
      }
      
      // Sort the different option categories alphabetically.
      assert ($greater_uint(SortedCategories.size(), 0)) : "No option categories registered!";
      array_pod_sort(SortedCategories.begin(), SortedCategories.end(), 
          /*FuncRef*/CategorizedHelpPrinter::OptionCategoryCompare);
      
      // Create map to empty vectors.
      for (std.vector.iterator</*const*/ OptionCategory /*P*/ > I = new std.vector.iterator</*const*/ OptionCategory /*P*/ >(SortedCategories.begin()), 
          E = new std.vector.iterator</*const*/ OptionCategory /*P*/ >(SortedCategories.end());
           $noteq___normal_iterator$C(I, E); I.$preInc())  {
        $c$.clean(CategorizedOptions.$at_T$C$R(I.$star()).$assignMove($c$.track(new std.vector<Option /*P*/ >((Option /*P*/ )null))));
      }
      
      // Walk through pre-sorted options and assign into categories.
      // Because the options are already alphabetically sorted the
      // options within categories will also be alphabetically sorted.
      for (/*size_t*/int I = 0, E = Opts.size(); I != E; ++I) {
        Option /*P*/ Opt = Opts.$at(I).second;
        assert CategorizedOptions.count(Opt.Category) : "Option has an unregistered category";
        CategorizedOptions.$at_T$C$R(Opt.Category).push_back_T$C$R(Opt);
      }
      
      // Now do printing.
      for (std.vector.iterator</*const*/ OptionCategory /*P*/ > Category = new std.vector.iterator</*const*/ OptionCategory /*P*/ >(SortedCategories.begin()), 
          E = new std.vector.iterator</*const*/ OptionCategory /*P*/ >(SortedCategories.end());
           $noteq___normal_iterator$C(Category, E); Category.$preInc()) {
        // Hide empty categories for -help, but show for -help-hidden.
        final /*const*/std.vector<Option /*P*/ > /*&*/ CategoryOptions = CategorizedOptions.$at_T$C$R(Category.$star());
        boolean IsEmptyCategory = CategoryOptions.empty();
        if (!ShowHidden && IsEmptyCategory) {
          continue;
        }
        
        // Print category information.
        outs().$out(/*KEEP_STR*/$LF);
        outs().$out((Category.$star()).getName()).$out(/*KEEP_STR*/$COLON_LF);
        
        // Check if description is set.
        if ($noteq_ptr((Category.$star()).getDescription(), null)) {
          outs().$out((Category.$star()).getDescription()).$out(/*KEEP_STR*/"\n\n");
        } else {
          outs().$out(/*KEEP_STR*/$LF);
        }
        
        // When using -help-hidden explicitly state if the category has no
        // options associated with it.
        if (IsEmptyCategory) {
          outs().$out(/*KEEP_STR*/"  This option category has no options.\n");
          continue;
        }
        // Loop over the options in the category and print.
        for (/*const*/ Option /*P*/ Opt : CategoryOptions)  {
          Opt.printOptionInfo(MaxArgLen);
        }
      }
    } finally {
      if (CategorizedOptions != null) { CategorizedOptions.$destroy(); }
      if (SortedCategories != null) { SortedCategories.$destroy(); }
      $c$.$destroy();
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CategorizedHelpPrinter::~CategorizedHelpPrinter">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp", line = 1825,
   old_source = "${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp", old_line = 1536,
   FQN="(anonymous namespace)::CategorizedHelpPrinter::~CategorizedHelpPrinter", NM="_ZN12_GLOBAL__N_122CategorizedHelpPrinterD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp -nm=_ZN12_GLOBAL__N_122CategorizedHelpPrinterD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
  }

  
  @Override public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
