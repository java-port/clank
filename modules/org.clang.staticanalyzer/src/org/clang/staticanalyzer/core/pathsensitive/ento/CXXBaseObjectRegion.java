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

package org.clang.staticanalyzer.core.pathsensitive.ento;

import org.clank.support.*;
import static org.llvm.adt.ADTAliases.*;
import static org.clank.support.NativePointer.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.clang.ast.*;
import org.clang.staticanalyzer.core.pathsensitive.ento.*;
import static org.clang.staticanalyzer.core.pathsensitive.llvm.StaticanalyzerLlvmGlobals.*;


// CXXBaseObjectRegion represents a base object within a C++ object. It is 
// identified by the base class declaration and the region of its parent object.
//<editor-fold defaultstate="collapsed" desc="clang::ento::CXXBaseObjectRegion">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/MemRegion.h", line = 1074,
 FQN="clang::ento::CXXBaseObjectRegion", NM="_ZN5clang4ento19CXXBaseObjectRegionE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp -nm=_ZN5clang4ento19CXXBaseObjectRegionE")
//</editor-fold>
public class CXXBaseObjectRegion extends /*public*/ TypedValueRegion implements Destructors.ClassWithDestructor {
  /*friend  class MemRegionManager*/
  
  private PointerBoolPair</*const*/ CXXRecordDecl /*P*/ > Data;
  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::CXXBaseObjectRegion::CXXBaseObjectRegion">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/MemRegion.h", line = 1079,
   FQN="clang::ento::CXXBaseObjectRegion::CXXBaseObjectRegion", NM="_ZN5clang4ento19CXXBaseObjectRegionC1EPKNS_13CXXRecordDeclEbPKNS0_9MemRegionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp -nm=_ZN5clang4ento19CXXBaseObjectRegionC1EPKNS_13CXXRecordDeclEbPKNS0_9MemRegionE")
  //</editor-fold>
  /*friend*/public/*private*/ CXXBaseObjectRegion(/*const*/ CXXRecordDecl /*P*/ RD, boolean IsVirtual, 
      /*const*/ MemRegion /*P*/ SReg) {
    // : TypedValueRegion(SReg, CXXBaseObjectRegionKind), Data(RD, IsVirtual) 
    //START JInit
    super(SReg, Kind.CXXBaseObjectRegionKind);
    this.Data = new PointerBoolPair</*const*/ CXXRecordDecl /*P*/ >(RD, IsVirtual);
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::CXXBaseObjectRegion::ProfileRegion">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp", line = 406,
   FQN="clang::ento::CXXBaseObjectRegion::ProfileRegion", NM="_ZN5clang4ento19CXXBaseObjectRegion13ProfileRegionERN4llvm16FoldingSetNodeIDEPKNS_13CXXRecordDeclEbPKNS0_9MemRegionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp -nm=_ZN5clang4ento19CXXBaseObjectRegion13ProfileRegionERN4llvm16FoldingSetNodeIDEPKNS_13CXXRecordDeclEbPKNS0_9MemRegionE")
  //</editor-fold>
  /*friend*/public/*private*/ static void ProfileRegion(final FoldingSetNodeID /*&*/ ID, 
               /*const*/ CXXRecordDecl /*P*/ RD, 
               boolean IsVirtual, 
               /*const*/ MemRegion /*P*/ SReg) {
    ID.AddPointer(RD);
    ID.AddBoolean(IsVirtual);
    ID.AddPointer(SReg);
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::ento::CXXBaseObjectRegion::getDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/MemRegion.h", line = 1087,
   FQN="clang::ento::CXXBaseObjectRegion::getDecl", NM="_ZNK5clang4ento19CXXBaseObjectRegion7getDeclEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp -nm=_ZNK5clang4ento19CXXBaseObjectRegion7getDeclEv")
  //</editor-fold>
  public /*const*/ CXXRecordDecl /*P*/ getDecl() /*const*/ {
    return Data.getPointer();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::CXXBaseObjectRegion::isVirtual">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/MemRegion.h", line = 1088,
   FQN="clang::ento::CXXBaseObjectRegion::isVirtual", NM="_ZNK5clang4ento19CXXBaseObjectRegion9isVirtualEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp -nm=_ZNK5clang4ento19CXXBaseObjectRegion9isVirtualEv")
  //</editor-fold>
  public boolean isVirtual() /*const*/ {
    return Data.getInt();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::CXXBaseObjectRegion::getValueType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp", line = 236,
   FQN="clang::ento::CXXBaseObjectRegion::getValueType", NM="_ZNK5clang4ento19CXXBaseObjectRegion12getValueTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp -nm=_ZNK5clang4ento19CXXBaseObjectRegion12getValueTypeEv")
  //</editor-fold>
  @Override public QualType getValueType() /*const*//* override*/ {
    return new QualType(getDecl().getTypeForDecl(), 0);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::CXXBaseObjectRegion::dumpToStream">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp", line = 485,
   FQN="clang::ento::CXXBaseObjectRegion::dumpToStream", NM="_ZNK5clang4ento19CXXBaseObjectRegion12dumpToStreamERN4llvm11raw_ostreamE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp -nm=_ZNK5clang4ento19CXXBaseObjectRegion12dumpToStreamERN4llvm11raw_ostreamE")
  //</editor-fold>
  @Override public void dumpToStream(final raw_ostream /*&*/ os) /*const*//* override*/ {
    $out_raw_ostream_MemRegion$C$P(os.$out(/*KEEP_STR*/"base{"), superRegion).$out_char($$COMMA).$out(getDecl().getName()).$out_char($$RCURLY);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::CXXBaseObjectRegion::Profile">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp", line = 415,
   FQN="clang::ento::CXXBaseObjectRegion::Profile", NM="_ZNK5clang4ento19CXXBaseObjectRegion7ProfileERN4llvm16FoldingSetNodeIDE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp -nm=_ZNK5clang4ento19CXXBaseObjectRegion7ProfileERN4llvm16FoldingSetNodeIDE")
  //</editor-fold>
  @Override public void Profile(final FoldingSetNodeID /*&*/ ID) /*const*//* override*/ {
    ProfileRegion(ID, getDecl(), isVirtual(), superRegion);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::CXXBaseObjectRegion::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/MemRegion.h", line = 1096,
   FQN="clang::ento::CXXBaseObjectRegion::classof", NM="_ZN5clang4ento19CXXBaseObjectRegion7classofEPKNS0_9MemRegionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp -nm=_ZN5clang4ento19CXXBaseObjectRegion7classofEPKNS0_9MemRegionE")
  //</editor-fold>
  public static boolean classof(/*const*/ MemRegion /*P*/ region) {
    return region.getKind() == Kind.CXXBaseObjectRegionKind;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::CXXBaseObjectRegion::canPrintPrettyAsExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp", line = 627,
   FQN="clang::ento::CXXBaseObjectRegion::canPrintPrettyAsExpr", NM="_ZNK5clang4ento19CXXBaseObjectRegion20canPrintPrettyAsExprEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp -nm=_ZNK5clang4ento19CXXBaseObjectRegion20canPrintPrettyAsExprEv")
  //</editor-fold>
  @Override public boolean canPrintPrettyAsExpr() /*const*//* override*/ {
    return superRegion.canPrintPrettyAsExpr();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::CXXBaseObjectRegion::printPrettyAsExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp", line = 631,
   FQN="clang::ento::CXXBaseObjectRegion::printPrettyAsExpr", NM="_ZNK5clang4ento19CXXBaseObjectRegion17printPrettyAsExprERN4llvm11raw_ostreamE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp -nm=_ZNK5clang4ento19CXXBaseObjectRegion17printPrettyAsExprERN4llvm11raw_ostreamE")
  //</editor-fold>
  @Override public void printPrettyAsExpr(final raw_ostream /*&*/ os) /*const*//* override*/ {
    superRegion.printPrettyAsExpr(os);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::CXXBaseObjectRegion::~CXXBaseObjectRegion">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/MemRegion.h", line = 1074,
   FQN="clang::ento::CXXBaseObjectRegion::~CXXBaseObjectRegion", NM="_ZN5clang4ento19CXXBaseObjectRegionD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp -nm=_ZN5clang4ento19CXXBaseObjectRegionD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
  }

  
  @Override public String toString() {
    return "" + "Data=" + Data // NOI18N
              + super.toString(); // NOI18N
  }
}
