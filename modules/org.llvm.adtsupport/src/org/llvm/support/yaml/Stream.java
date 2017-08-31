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

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.JavaDifferentiators.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.llvm.support.yaml.impl.Scanner;


/// \brief This class represents a YAML stream potentially containing multiple
///        documents.
//<editor-fold defaultstate="collapsed" desc="llvm::yaml::Stream">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLParser.h", line = 75,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLParser.h", old_line = 76,
 FQN="llvm::yaml::Stream", NM="_ZN4llvm4yaml6StreamE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLParser.cpp -nm=_ZN4llvm4yaml6StreamE")
//</editor-fold>
public class Stream implements Destructors.ClassWithDestructor {
/*public:*/
  /// \brief This keeps a reference to the string referenced by \p Input.
  //<editor-fold defaultstate="collapsed" desc="llvm::yaml::Stream::Stream">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/YAMLParser.cpp", line = 1769,
   FQN="llvm::yaml::Stream::Stream", NM="_ZN4llvm4yaml6StreamC1ENS_9StringRefERNS_9SourceMgrEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLParser.cpp -nm=_ZN4llvm4yaml6StreamC1ENS_9StringRefERNS_9SourceMgrEb")
  //</editor-fold>
  public Stream(StringRef Input, final SourceMgr /*&*/ SM) {
    this(Input, SM, true);
  }
  public Stream(StringRef Input, final SourceMgr /*&*/ SM, boolean ShowColors/*= true*/) {
    // : scanner(new Scanner(Input, SM, ShowColors)), CurrentDoc() 
    //START JInit
    this.scanner = new std.unique_ptr<Scanner>(new Scanner(new StringRef(Input), SM, ShowColors));
    this.CurrentDoc = new std.unique_ptr<Document>();
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::yaml::Stream::Stream">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/YAMLParser.cpp", line = 1772,
   FQN="llvm::yaml::Stream::Stream", NM="_ZN4llvm4yaml6StreamC1ENS_15MemoryBufferRefERNS_9SourceMgrEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLParser.cpp -nm=_ZN4llvm4yaml6StreamC1ENS_15MemoryBufferRefERNS_9SourceMgrEb")
  //</editor-fold>
  public Stream(MemoryBufferRef InputBuffer, final SourceMgr /*&*/ SM) {
    this(InputBuffer, SM, true);
  }
  public Stream(MemoryBufferRef InputBuffer, final SourceMgr /*&*/ SM, boolean ShowColors/*= true*/) {
    // : scanner(new Scanner(InputBuffer, SM, ShowColors)), CurrentDoc() 
    //START JInit
    this.scanner = new std.unique_ptr<Scanner>(new Scanner(new MemoryBufferRef(InputBuffer), SM, ShowColors));
    this.CurrentDoc = new std.unique_ptr<Document>();
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::yaml::Stream::~Stream">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/YAMLParser.cpp", line = 1775,
   FQN="llvm::yaml::Stream::~Stream", NM="_ZN4llvm4yaml6StreamD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLParser.cpp -nm=_ZN4llvm4yaml6StreamD0Ev")
  //</editor-fold>
  public void $destroy() {
    //START JDestroy
    CurrentDoc.$destroy();
    scanner.$destroy();
    //END JDestroy
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::yaml::Stream::begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/YAMLParser.cpp", line = 1786,
   FQN="llvm::yaml::Stream::begin", NM="_ZN4llvm4yaml6Stream5beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLParser.cpp -nm=_ZN4llvm4yaml6Stream5beginEv")
  //</editor-fold>
  public document_iterator begin() {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      if (CurrentDoc.$bool()) {
        report_fatal_error($("Can only iterate over the stream once"));
      }
      
      // Skip Stream-Start.
      $c$.clean($c$.track(scanner.$arrow().getNext()));
      
      CurrentDoc.reset(new Document(/*Deref*/this));
      return new document_iterator(CurrentDoc);
    } finally {
      $c$.$destroy();
    }
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::yaml::Stream::end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/YAMLParser.cpp", line = 1797,
   FQN="llvm::yaml::Stream::end", NM="_ZN4llvm4yaml6Stream3endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLParser.cpp -nm=_ZN4llvm4yaml6Stream3endEv")
  //</editor-fold>
  public document_iterator end() {
    return new document_iterator();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::yaml::Stream::skip">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/YAMLParser.cpp", line = 1801,
   FQN="llvm::yaml::Stream::skip", NM="_ZN4llvm4yaml6Stream4skipEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLParser.cpp -nm=_ZN4llvm4yaml6Stream4skipEv")
  //</editor-fold>
  public void skip() {
    for (document_iterator i = begin(), e = end(); i.$noteq(e); i.$preInc())  {
      i.$arrow().$arrow().skip();
    }
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::yaml::Stream::failed">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/YAMLParser.cpp", line = 1777,
   FQN="llvm::yaml::Stream::failed", NM="_ZN4llvm4yaml6Stream6failedEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLParser.cpp -nm=_ZN4llvm4yaml6Stream6failedEv")
  //</editor-fold>
  public boolean failed() {
    return scanner.$arrow().failed();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::yaml::Stream::validate">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLParser.h", line = 87,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLParser.h", old_line = 88,
   FQN="llvm::yaml::Stream::validate", NM="_ZN4llvm4yaml6Stream8validateEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLParser.cpp -nm=_ZN4llvm4yaml6Stream8validateEv")
  //</editor-fold>
  public boolean validate() {
    skip();
    return !failed();
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::yaml::Stream::printError">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/YAMLParser.cpp", line = 1779,
   FQN="llvm::yaml::Stream::printError", NM="_ZN4llvm4yaml6Stream10printErrorEPNS0_4NodeERKNS_5TwineE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLParser.cpp -nm=_ZN4llvm4yaml6Stream10printErrorEPNS0_4NodeERKNS_5TwineE")
  //</editor-fold>
  public void printError(Node /*P*/ N, final /*const*/ Twine /*&*/ Msg) {
    scanner.$arrow().printError(new SMLoc(JD$Move.INSTANCE, N.getSourceRange().Start), 
        SourceMgr.DiagKind.DK_Error, 
        Msg, 
        new ArrayRef<SMRange>(N.getSourceRange(), false));
  }

/*private:*/
  /*friend*/public/*private*/ std.unique_ptr<Scanner> scanner;
  /*friend*/public/*private*/ std.unique_ptr<Document> CurrentDoc;
  
  /*friend  class Document*/
  
  @Override public String toString() {
    return "" 
              //+ "scanner=" + scanner // NOI18N
              + ", CurrentDoc=" + CurrentDoc; // NOI18N
  }
}
