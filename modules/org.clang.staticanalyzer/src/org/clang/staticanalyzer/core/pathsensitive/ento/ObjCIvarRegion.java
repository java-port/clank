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

import static org.clank.support.Native.$Deref;
import org.clank.support.*;
import static org.clank.support.NativePointer.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.clang.ast.*;
import org.clang.staticanalyzer.core.pathsensitive.ento.*;
import static org.clang.staticanalyzer.core.pathsensitive.llvm.StaticanalyzerLlvmGlobals.*;
import static org.clang.ast.AstClangGlobals.*;
import static org.clang.ast.java.AstDeclarationsRTTI.*;

//<editor-fold defaultstate="collapsed" desc="clang::ento::ObjCIvarRegion">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/MemRegion.h", line = 956,
 FQN="clang::ento::ObjCIvarRegion", NM="_ZN5clang4ento14ObjCIvarRegionE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp -nm=_ZN5clang4ento14ObjCIvarRegionE")
//</editor-fold>
public class ObjCIvarRegion extends /*public*/ DeclRegion implements Destructors.ClassWithDestructor {
  
  /*friend  class MemRegionManager*/
  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::ObjCIvarRegion::ObjCIvarRegion">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp", line = 225,
   FQN="clang::ento::ObjCIvarRegion::ObjCIvarRegion", NM="_ZN5clang4ento14ObjCIvarRegionC1EPKNS_12ObjCIvarDeclEPKNS0_9MemRegionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp -nm=_ZN5clang4ento14ObjCIvarRegionC1EPKNS_12ObjCIvarDeclEPKNS0_9MemRegionE")
  //</editor-fold>
  /*friend*/public/*private*/ ObjCIvarRegion(/*const*/ ObjCIvarDecl /*P*/ ivd, /*const*/ MemRegion /*P*/ sReg) {
    // : DeclRegion(ivd, sReg, ObjCIvarRegionKind) 
    //START JInit
    super(ivd, sReg, Kind.ObjCIvarRegionKind);
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::ObjCIvarRegion::ProfileRegion">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp", line = 311,
   FQN="clang::ento::ObjCIvarRegion::ProfileRegion", NM="_ZN5clang4ento14ObjCIvarRegion13ProfileRegionERN4llvm16FoldingSetNodeIDEPKNS_12ObjCIvarDeclEPKNS0_9MemRegionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp -nm=_ZN5clang4ento14ObjCIvarRegion13ProfileRegionERN4llvm16FoldingSetNodeIDEPKNS_12ObjCIvarDeclEPKNS0_9MemRegionE")
  //</editor-fold>
  /*friend*/public/*private*/ static void ProfileRegion(final FoldingSetNodeID /*&*/ ID, 
               /*const*/ ObjCIvarDecl /*P*/ ivd, 
               /*const*/ MemRegion /*P*/ superRegion) {
    DeclRegion.ProfileRegion(ID, ivd, superRegion, Kind.ObjCIvarRegionKind);
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::ento::ObjCIvarRegion::getDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp", line = 228,
   FQN="clang::ento::ObjCIvarRegion::getDecl", NM="_ZNK5clang4ento14ObjCIvarRegion7getDeclEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp -nm=_ZNK5clang4ento14ObjCIvarRegion7getDeclEv")
  //</editor-fold>
  public /*const*/ ObjCIvarDecl /*P*/ getDecl() /*const*/ {
    return cast_ObjCIvarDecl(D);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::ObjCIvarRegion::getValueType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp", line = 232,
   FQN="clang::ento::ObjCIvarRegion::getValueType", NM="_ZNK5clang4ento14ObjCIvarRegion12getValueTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp -nm=_ZNK5clang4ento14ObjCIvarRegion12getValueTypeEv")
  //</editor-fold>
  @Override public QualType getValueType() /*const*//* override*/ {
    return getDecl().getType();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::ObjCIvarRegion::canPrintPrettyAsExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp", line = 595,
   FQN="clang::ento::ObjCIvarRegion::canPrintPrettyAsExpr", NM="_ZNK5clang4ento14ObjCIvarRegion20canPrintPrettyAsExprEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp -nm=_ZNK5clang4ento14ObjCIvarRegion20canPrintPrettyAsExprEv")
  //</editor-fold>
  @Override public boolean canPrintPrettyAsExpr() /*const*//* override*/ {
    return true;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::ObjCIvarRegion::printPrettyAsExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp", line = 599,
   FQN="clang::ento::ObjCIvarRegion::printPrettyAsExpr", NM="_ZNK5clang4ento14ObjCIvarRegion17printPrettyAsExprERN4llvm11raw_ostreamE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp -nm=_ZNK5clang4ento14ObjCIvarRegion17printPrettyAsExprERN4llvm11raw_ostreamE")
  //</editor-fold>
  @Override public void printPrettyAsExpr(final raw_ostream /*&*/ os) /*const*//* override*/ {
    os.$out(getDecl().getName());
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::ObjCIvarRegion::dumpToStream">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp", line = 502,
   FQN="clang::ento::ObjCIvarRegion::dumpToStream", NM="_ZNK5clang4ento14ObjCIvarRegion12dumpToStreamERN4llvm11raw_ostreamE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp -nm=_ZNK5clang4ento14ObjCIvarRegion12dumpToStreamERN4llvm11raw_ostreamE")
  //</editor-fold>
  @Override public void dumpToStream(final raw_ostream /*&*/ os) /*const*//* override*/ {
    $out_raw_ostream_NamedDecl$C($out_raw_ostream_MemRegion$C$P(os.$out(/*KEEP_STR*/"ivar{"), superRegion).$out_char($$COMMA), $Deref(getDecl())).$out_char($$RCURLY);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::ObjCIvarRegion::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/MemRegion.h", line = 974,
   FQN="clang::ento::ObjCIvarRegion::classof", NM="_ZN5clang4ento14ObjCIvarRegion7classofEPKNS0_9MemRegionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp -nm=_ZN5clang4ento14ObjCIvarRegion7classofEPKNS0_9MemRegionE")
  //</editor-fold>
  public static boolean classof(/*const*/ MemRegion /*P*/ R) {
    return R.getKind() == Kind.ObjCIvarRegionKind;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::ObjCIvarRegion::~ObjCIvarRegion">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/MemRegion.h", line = 956,
   FQN="clang::ento::ObjCIvarRegion::~ObjCIvarRegion", NM="_ZN5clang4ento14ObjCIvarRegionD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp -nm=_ZN5clang4ento14ObjCIvarRegionD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
  }

  
  @Override public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
