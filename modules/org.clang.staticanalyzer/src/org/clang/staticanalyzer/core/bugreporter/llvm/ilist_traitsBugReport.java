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

package org.clang.staticanalyzer.core.bugreporter.llvm;

import static org.clank.support.Native.$AddrOf;
import org.clank.support.*;
import org.llvm.adt.*;
import org.clang.staticanalyzer.core.bugreporter.ento.*;
import org.clank.support.aliases.type$ref;

//<editor-fold defaultstate="collapsed" desc="llvm::ilist_traits<clang::ento::BugReport>">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/BugReporter/BugReporter.h", line = 318,
 FQN="llvm::ilist_traits<clang::ento::BugReport>", NM="_ZN4llvm12ilist_traitsIN5clang4ento9BugReportEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp -nm=_ZN4llvm12ilist_traitsIN5clang4ento9BugReportEEE")
//</editor-fold>
public class/*struct*/ ilist_traitsBugReport implements /*public*/ ilist_default_traits<BugReport> {
  //<editor-fold defaultstate="collapsed" desc="llvm::ilist_traits<clang::ento::BugReport>::createSentinel">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/BugReporter/BugReporter.h", line = 320,
   FQN="llvm::ilist_traits<clang::ento::BugReport>::createSentinel", NM="_ZNK4llvm12ilist_traitsIN5clang4ento9BugReportEE14createSentinelEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp -nm=_ZNK4llvm12ilist_traitsIN5clang4ento9BugReportEE14createSentinelEv")
  //</editor-fold>
  public BugReport /*P*/ createSentinel() /*const*/ {
    return ((/*static_cast*/BugReport /*P*/ )($AddrOf(Sentinel)));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ilist_traits<clang::ento::BugReport>::destroySentinel">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/BugReporter/BugReporter.h", line = 323,
   FQN="llvm::ilist_traits<clang::ento::BugReport>::destroySentinel", NM="_ZNK4llvm12ilist_traitsIN5clang4ento9BugReportEE15destroySentinelEPS3_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp -nm=_ZNK4llvm12ilist_traitsIN5clang4ento9BugReportEE15destroySentinelEPS3_")
  //</editor-fold>
  public void destroySentinel(BugReport /*P*/ $Prm0) /*const*/ {
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::ilist_traits<clang::ento::BugReport>::provideInitialHead">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/BugReporter/BugReporter.h", line = 325,
   FQN="llvm::ilist_traits<clang::ento::BugReport>::provideInitialHead", NM="_ZNK4llvm12ilist_traitsIN5clang4ento9BugReportEE18provideInitialHeadEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp -nm=_ZNK4llvm12ilist_traitsIN5clang4ento9BugReportEE18provideInitialHeadEv")
  //</editor-fold>
  public BugReport /*P*/ provideInitialHead() /*const*/ {
    return createSentinel();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ilist_traits<clang::ento::BugReport>::ensureHead">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/BugReporter/BugReporter.h", line = 328,
   FQN="llvm::ilist_traits<clang::ento::BugReport>::ensureHead", NM="_ZNK4llvm12ilist_traitsIN5clang4ento9BugReportEE10ensureHeadEPS3_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp -nm=_ZNK4llvm12ilist_traitsIN5clang4ento9BugReportEE10ensureHeadEPS3_")
  //</editor-fold>
  public @Override BugReport /*P*/ ensureHead(type$ref<BugReport> /*P*/ $Prm0) /*const*/ {
    return createSentinel();
  }

/*private:*/
  private /*mutable */ilist_half_node<BugReport> Sentinel;
  //<editor-fold defaultstate="collapsed" desc="llvm::ilist_traits<clang::ento::BugReport>::ilist_traits">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/BugReporter/BugReporter.h", line = 318,
   FQN="llvm::ilist_traits<clang::ento::BugReport>::ilist_traits", NM="_ZN4llvm12ilist_traitsIN5clang4ento9BugReportEEC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp -nm=_ZN4llvm12ilist_traitsIN5clang4ento9BugReportEEC1Ev")
  //</editor-fold>
  public /*inline*/ ilist_traitsBugReport() {
    // : ilist_default_traits<BugReport>(), Sentinel() 
    //START JInit
    $ilist_default_traits();
    this.Sentinel = new ilist_half_node$BugReport();
    //END JInit
  }

  private static final class ilist_half_node$BugReport implements ilist_half_node<BugReport> {

    private ilist_half_node$BugReport() {
      this.ilist_half_node$Flds = $ilist_half_node$Fields();
    }    
              
    private final ilist_half_node$Fields ilist_half_node$Flds;
    @Override public final ilist_half_node$Fields $ilist_half_node$Fields() { return ilist_half_node$Flds; }              
  }
  
  @Override public String toString() {
    return "" + "Sentinel=" + Sentinel // NOI18N
              + super.toString(); // NOI18N
  }
}
