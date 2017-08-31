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

package org.llvm.support.yaml;

import static org.clank.support.Native.$Deref;
import static org.clank.support.Native.$AddrOf;
import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.JavaDifferentiators.*;


/// \brief Iterator abstraction for Documents over a Stream.
//<editor-fold defaultstate="collapsed" desc="llvm::yaml::document_iterator">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLParser.h", line = 562,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLParser.h", old_line = 563,
 FQN="llvm::yaml::document_iterator", NM="_ZN4llvm4yaml17document_iteratorE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLParser.cpp -nm=_ZN4llvm4yaml17document_iteratorE")
//</editor-fold>
public class document_iterator implements Native.NativeComparable<document_iterator> {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::yaml::document_iterator::document_iterator">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLParser.h", line = 564,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLParser.h", old_line = 565,
   FQN="llvm::yaml::document_iterator::document_iterator", NM="_ZN4llvm4yaml17document_iteratorC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLParser.cpp -nm=_ZN4llvm4yaml17document_iteratorC1Ev")
  //</editor-fold>
  public document_iterator() {
    // : Doc(null) 
    //START JInit
    this.Doc = null;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::yaml::document_iterator::document_iterator">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLParser.h", line = 565,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLParser.h", old_line = 566,
   FQN="llvm::yaml::document_iterator::document_iterator", NM="_ZN4llvm4yaml17document_iteratorC1ERSt10unique_ptrINS0_8DocumentESt14default_deleteIS3_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLParser.cpp -nm=_ZN4llvm4yaml17document_iteratorC1ERSt10unique_ptrINS0_8DocumentESt14default_deleteIS3_EE")
  //</editor-fold>
  public document_iterator(final std.unique_ptr<Document> /*&*/ D) {
    // : Doc(&D) 
    //START JInit
    this.Doc = $AddrOf(D);
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::yaml::document_iterator::operator==">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLParser.h", line = 567,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLParser.h", old_line = 568,
   FQN="llvm::yaml::document_iterator::operator==", NM="_ZN4llvm4yaml17document_iteratoreqERKS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLParser.cpp -nm=_ZN4llvm4yaml17document_iteratoreqERKS1_")
  //</editor-fold>
  public boolean $eq(final /*const*/ document_iterator /*&*/ Other) {
    if (isAtEnd() || Other.isAtEnd()) {
      return isAtEnd() && Other.isAtEnd();
    }
    
    return Doc == Other.Doc;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::yaml::document_iterator::operator!=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLParser.h", line = 573,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLParser.h", old_line = 574,
   FQN="llvm::yaml::document_iterator::operator!=", NM="_ZN4llvm4yaml17document_iteratorneERKS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLParser.cpp -nm=_ZN4llvm4yaml17document_iteratorneERKS1_")
  //</editor-fold>
  public boolean $noteq(final /*const*/ document_iterator /*&*/ Other) {
    return !(/*Deref*/this.$eq(Other));
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::yaml::document_iterator::operator++">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLParser.h", line = 575,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLParser.h", old_line = 576,
   FQN="llvm::yaml::document_iterator::operator++", NM="_ZN4llvm4yaml17document_iteratorppEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLParser.cpp -nm=_ZN4llvm4yaml17document_iteratorppEv")
  //</editor-fold>
  public document_iterator $preInc() {
    assert ((Doc != null)) : "incrementing iterator past the end.";
    if (!(/*Deref*/Doc).$arrow().skip()) {
      Doc.reset((Document)null);
    } else {
      final Stream /*&*/ S = (/*Deref*/Doc).$arrow().stream;
      Doc.reset(new Document(S));
    }
    return new document_iterator(/*Deref*/this);
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::yaml::document_iterator::operator*">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLParser.h", line = 586,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLParser.h", old_line = 587,
   FQN="llvm::yaml::document_iterator::operator*", NM="_ZN4llvm4yaml17document_iteratordeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLParser.cpp -nm=_ZN4llvm4yaml17document_iteratordeEv")
  //</editor-fold>
  public Document /*&*/ $star() {
    return $Deref(Doc.get());
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::yaml::document_iterator::operator->">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLParser.h", line = 588,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLParser.h", old_line = 589,
   FQN="llvm::yaml::document_iterator::operator->", NM="_ZN4llvm4yaml17document_iteratorptEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLParser.cpp -nm=_ZN4llvm4yaml17document_iteratorptEv")
  //</editor-fold>
  public std.unique_ptr<Document> /*&*/ $arrow() {
    return $Deref(Doc);
  }

/*private:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::yaml::document_iterator::isAtEnd">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLParser.h", line = 591,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLParser.h", old_line = 592,
   FQN="llvm::yaml::document_iterator::isAtEnd", NM="_ZNK4llvm4yaml17document_iterator7isAtEndEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLParser.cpp -nm=_ZNK4llvm4yaml17document_iterator7isAtEndEv")
  //</editor-fold>
  private boolean isAtEnd() /*const*/ {
    return !(Doc != null) || !$Deref(Doc.$bool());
  }

  
  private std.unique_ptr<Document> /*P*/ Doc;
  //<editor-fold defaultstate="collapsed" desc="llvm::yaml::document_iterator::document_iterator">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLParser.h", line = 562,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLParser.h", old_line = 563,
   FQN="llvm::yaml::document_iterator::document_iterator", NM="_ZN4llvm4yaml17document_iteratorC1ERKS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLParser.cpp -nm=_ZN4llvm4yaml17document_iteratorC1ERKS1_")
  //</editor-fold>
  public /*inline*/ document_iterator(final /*const*/ document_iterator /*&*/ $Prm0) {
    // : Doc(.Doc) 
    //START JInit
    this.Doc = $Prm0.Doc;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::yaml::document_iterator::document_iterator">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLParser.h", line = 562,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLParser.h", old_line = 563,
   FQN="llvm::yaml::document_iterator::document_iterator", NM="_ZN4llvm4yaml17document_iteratorC1EOS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLParser.cpp -nm=_ZN4llvm4yaml17document_iteratorC1EOS1_")
  //</editor-fold>
  public /*inline*/ document_iterator(JD$Move _dparam, final document_iterator /*&&*/$Prm0) {
    // : Doc(static_cast<document_iterator &&>().Doc) 
    //START JInit
    this.Doc = $Prm0.Doc;
    //END JInit
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::yaml::document_iterator::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLParser.h", line = 562,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLParser.h", old_line = 563,
   FQN="llvm::yaml::document_iterator::operator=", NM="_ZN4llvm4yaml17document_iteratoraSEOS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLTraits.cpp -nm=_ZN4llvm4yaml17document_iteratoraSEOS1_")
  //</editor-fold>
  public /*inline*/ document_iterator /*&*/ $assignMove(final document_iterator /*&&*/$Prm0) {
    this.Doc = $Prm0.Doc;
    return /*Deref*/this;
  }

  
  @Override public String toString() {
    return "" + "Doc=" + Doc; // NOI18N
  }
}
