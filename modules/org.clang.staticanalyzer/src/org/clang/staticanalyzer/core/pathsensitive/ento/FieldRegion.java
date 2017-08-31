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
import org.clank.support.JavaDifferentiators.*;
import static org.clank.support.NativePointer.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.clang.ast.*;
import org.clang.staticanalyzer.core.pathsensitive.ento.*;
import static org.clang.staticanalyzer.core.pathsensitive.llvm.StaticanalyzerLlvmGlobals.*;
import static org.clang.ast.AstClangGlobals.*;
import static org.clang.ast.java.AstDeclarationsRTTI.*;
import static org.clang.ast.java.AstTypesRTTI.*;

//<editor-fold defaultstate="collapsed" desc="clang::ento::FieldRegion">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/MemRegion.h", line = 923,
 FQN="clang::ento::FieldRegion", NM="_ZN5clang4ento11FieldRegionE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp -nm=_ZN5clang4ento11FieldRegionE")
//</editor-fold>
public class FieldRegion extends /*public*/ DeclRegion implements Destructors.ClassWithDestructor {
  /*friend  class MemRegionManager*/
  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::FieldRegion::FieldRegion">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/MemRegion.h", line = 926,
   FQN="clang::ento::FieldRegion::FieldRegion", NM="_ZN5clang4ento11FieldRegionC1EPKNS_9FieldDeclEPKNS0_9MemRegionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp -nm=_ZN5clang4ento11FieldRegionC1EPKNS_9FieldDeclEPKNS0_9MemRegionE")
  //</editor-fold>
  /*friend*/public/*private*/ FieldRegion(/*const*/ FieldDecl /*P*/ fd, /*const*/ MemRegion /*P*/ sReg) {
    // : DeclRegion(fd, sReg, FieldRegionKind) 
    //START JInit
    super(fd, sReg, Kind.FieldRegionKind);
    //END JInit
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::ento::FieldRegion::getDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/MemRegion.h", line = 930,
   FQN="clang::ento::FieldRegion::getDecl", NM="_ZNK5clang4ento11FieldRegion7getDeclEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp -nm=_ZNK5clang4ento11FieldRegion7getDeclEv")
  //</editor-fold>
  public /*const*/ FieldDecl /*P*/ getDecl() /*const*/ {
    return cast_FieldDecl(D);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::FieldRegion::getValueType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/MemRegion.h", line = 932,
   FQN="clang::ento::FieldRegion::getValueType", NM="_ZNK5clang4ento11FieldRegion12getValueTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp -nm=_ZNK5clang4ento11FieldRegion12getValueTypeEv")
  //</editor-fold>
  @Override public QualType getValueType() /*const*//* override*/ {
    // FIXME: We can cache this if needed.
    return getDecl().getType();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::FieldRegion::getExtent">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp", line = 193,
   FQN="clang::ento::FieldRegion::getExtent", NM="_ZNK5clang4ento11FieldRegion9getExtentERNS0_11SValBuilderE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp -nm=_ZNK5clang4ento11FieldRegion9getExtentERNS0_11SValBuilderE")
  //</editor-fold>
  @Override public DefinedOrUnknownSVal getExtent(final SValBuilder /*&*/ svalBuilder) /*const*//* override*/ {
    // Force callers to deal with bitfields explicitly.
    if (getDecl().isBitField()) {
      return new DefinedOrUnknownSVal(JD$Move.INSTANCE, new UnknownVal());
    }
    
    DefinedOrUnknownSVal Extent = super.getExtent(svalBuilder);
    
    // A zero-length array at the end of a struct often stands for dynamically-
    // allocated extra memory.
    if (Extent.isZeroConstant()) {
      QualType T = getDesugaredValueType(svalBuilder.getContext());
      if (isa_ConstantArrayType(T)) {
        return new DefinedOrUnknownSVal(JD$Move.INSTANCE, new UnknownVal());
      }
    }
    
    return Extent;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::FieldRegion::ProfileRegion">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/MemRegion.h", line = 939,
   FQN="clang::ento::FieldRegion::ProfileRegion", NM="_ZN5clang4ento11FieldRegion13ProfileRegionERN4llvm16FoldingSetNodeIDEPKNS_9FieldDeclEPKNS0_9MemRegionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp -nm=_ZN5clang4ento11FieldRegion13ProfileRegionERN4llvm16FoldingSetNodeIDEPKNS_9FieldDeclEPKNS0_9MemRegionE")
  //</editor-fold>
  public static void ProfileRegion(final FoldingSetNodeID /*&*/ ID, /*const*/ FieldDecl /*P*/ FD, 
               /*const*/ MemRegion /*P*/ superRegion) {
    DeclRegion.ProfileRegion(ID, FD, superRegion, Kind.FieldRegionKind);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::FieldRegion::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/MemRegion.h", line = 944,
   FQN="clang::ento::FieldRegion::classof", NM="_ZN5clang4ento11FieldRegion7classofEPKNS0_9MemRegionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp -nm=_ZN5clang4ento11FieldRegion7classofEPKNS0_9MemRegionE")
  //</editor-fold>
  public static boolean classof(/*const*/ MemRegion /*P*/ R) {
    return R.getKind() == Kind.FieldRegionKind;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::FieldRegion::dumpToStream">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp", line = 498,
   FQN="clang::ento::FieldRegion::dumpToStream", NM="_ZNK5clang4ento11FieldRegion12dumpToStreamERN4llvm11raw_ostreamE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp -nm=_ZNK5clang4ento11FieldRegion12dumpToStreamERN4llvm11raw_ostreamE")
  //</editor-fold>
  @Override public void dumpToStream(final raw_ostream /*&*/ os) /*const*//* override*/ {
    $out_raw_ostream_NamedDecl$C($out_raw_ostream_MemRegion$C$P(os, superRegion).$out(/*KEEP_STR*/$ARROW), $Deref(getDecl()));
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::FieldRegion::canPrintPretty">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp", line = 603,
   FQN="clang::ento::FieldRegion::canPrintPretty", NM="_ZNK5clang4ento11FieldRegion14canPrintPrettyEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp -nm=_ZNK5clang4ento11FieldRegion14canPrintPrettyEv")
  //</editor-fold>
  @Override public boolean canPrintPretty() /*const*//* override*/ {
    return true;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::FieldRegion::printPretty">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp", line = 617,
   FQN="clang::ento::FieldRegion::printPretty", NM="_ZNK5clang4ento11FieldRegion11printPrettyERN4llvm11raw_ostreamE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp -nm=_ZNK5clang4ento11FieldRegion11printPrettyERN4llvm11raw_ostreamE")
  //</editor-fold>
  @Override public void printPretty(final raw_ostream /*&*/ os) /*const*//* override*/ {
    if (canPrintPrettyAsExpr()) {
      os.$out(/*KEEP_STR*/$SGL_QUOTE);
      printPrettyAsExpr(os);
      os.$out(/*KEEP_STR*/$SGL_QUOTE);
    } else {
      os.$out(/*KEEP_STR*/"field ").$out(/*KEEP_STR*/$SGL_QUOTE).$out(getDecl().getName()).$out(/*KEEP_STR*/$SGL_QUOTE);
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::FieldRegion::canPrintPrettyAsExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp", line = 607,
   FQN="clang::ento::FieldRegion::canPrintPrettyAsExpr", NM="_ZNK5clang4ento11FieldRegion20canPrintPrettyAsExprEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp -nm=_ZNK5clang4ento11FieldRegion20canPrintPrettyAsExprEv")
  //</editor-fold>
  @Override public boolean canPrintPrettyAsExpr() /*const*//* override*/ {
    return superRegion.canPrintPrettyAsExpr();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::FieldRegion::printPrettyAsExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp", line = 611,
   FQN="clang::ento::FieldRegion::printPrettyAsExpr", NM="_ZNK5clang4ento11FieldRegion17printPrettyAsExprERN4llvm11raw_ostreamE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp -nm=_ZNK5clang4ento11FieldRegion17printPrettyAsExprERN4llvm11raw_ostreamE")
  //</editor-fold>
  @Override public void printPrettyAsExpr(final raw_ostream /*&*/ os) /*const*//* override*/ {
    assert (canPrintPrettyAsExpr());
    superRegion.printPrettyAsExpr(os);
    os.$out(/*KEEP_STR*/$DOT).$out(getDecl().getName());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::FieldRegion::~FieldRegion">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/MemRegion.h", line = 923,
   FQN="clang::ento::FieldRegion::~FieldRegion", NM="_ZN5clang4ento11FieldRegionD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp -nm=_ZN5clang4ento11FieldRegionD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
  }

  
  @Override public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
