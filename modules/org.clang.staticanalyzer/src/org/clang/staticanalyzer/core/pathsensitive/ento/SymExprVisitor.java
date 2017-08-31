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
import org.llvm.support.*;
import org.clang.staticanalyzer.core.pathsensitive.ento.*;
import static org.clang.staticanalyzer.java.StaticanalyzerRTTI.*;


/// SymExprVisitor - this class implements a simple visitor for SymExpr
/// subclasses.
/*template <typename ImplClass, typename RetTy = void> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="clang::ento::SymExprVisitor">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/SValVisitor.h", line = 76,
 FQN="clang::ento::SymExprVisitor", NM="_ZN5clang4ento14SymExprVisitorE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ExprInspectionChecker.cpp -nm=_ZN5clang4ento14SymExprVisitorE")
//</editor-fold>
public interface/*class*/ SymExprVisitor</*typename*/ ImplClass extends SymExprVisitor<ImplClass, RetTy>, /*typename*/ RetTy/* = void*/>  {
/*public:*/
  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::SymExprVisitor::Visit">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/SValVisitor.h", line = 82,
   FQN="clang::ento::SymExprVisitor::Visit", NM="_ZN5clang4ento14SymExprVisitor5VisitEPKNS0_7SymExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ExprInspectionChecker.cpp -nm=_ZN5clang4ento14SymExprVisitor5VisitEPKNS0_7SymExprE")
  //</editor-fold>
  public default/*interface*/ RetTy Visit(/*const*/ SymExpr /*P*/ S) {
    // Dispatch to VisitSymbolFoo for each SymbolFoo.
    switch (S.getKind()) {
     case IntSymExprKind:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitIntSymExpr(cast_IntSymExpr(S));
     case SymIntExprKind:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitSymIntExpr(cast_SymIntExpr(S));
     case SymSymExprKind:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitSymSymExpr(cast_SymSymExpr(S));
     case SymbolCastKind:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitSymbolCast(cast_SymbolCast(S));
     case SymbolConjuredKind:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitSymbolConjured(cast_SymbolConjured(S));
     case SymbolDerivedKind:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitSymbolDerived(cast_SymbolDerived(S));
     case SymbolExtentKind:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitSymbolExtent(cast_SymbolExtent(S));
     case SymbolMetadataKind:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitSymbolMetadata(cast_SymbolMetadata(S));
     case SymbolRegionValueKind:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitSymbolRegionValue(cast_SymbolRegionValue(S));
    }
    throw new llvm_unreachable("Unknown SymExpr kind!");
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::SymExprVisitor::VisitBinarySymExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/Symbols.def", line = 37,
   FQN="clang::ento::SymExprVisitor::VisitBinarySymExpr", NM="_ZN5clang4ento14SymExprVisitor18VisitBinarySymExprEPKNS0_13BinarySymExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ExprInspectionChecker.cpp -nm=_ZN5clang4ento14SymExprVisitor18VisitBinarySymExprEPKNS0_13BinarySymExprE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitBinarySymExpr(/*const*/ BinarySymExpr /*P*/ S) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitSymExpr(cast_SymExpr(S));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::SymExprVisitor::VisitIntSymExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/Symbols.def", line = 38,
   FQN="clang::ento::SymExprVisitor::VisitIntSymExpr", NM="_ZN5clang4ento14SymExprVisitor15VisitIntSymExprEPKNS0_10IntSymExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ExprInspectionChecker.cpp -nm=_ZN5clang4ento14SymExprVisitor15VisitIntSymExprEPKNS0_10IntSymExprE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitIntSymExpr(/*const*/ IntSymExpr /*P*/ S) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitBinarySymExpr(cast_BinarySymExpr(S));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::SymExprVisitor::VisitSymIntExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/Symbols.def", line = 39,
   FQN="clang::ento::SymExprVisitor::VisitSymIntExpr", NM="_ZN5clang4ento14SymExprVisitor15VisitSymIntExprEPKNS0_10SymIntExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ExprInspectionChecker.cpp -nm=_ZN5clang4ento14SymExprVisitor15VisitSymIntExprEPKNS0_10SymIntExprE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitSymIntExpr(/*const*/ SymIntExpr /*P*/ S) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitBinarySymExpr(cast_BinarySymExpr(S));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::SymExprVisitor::VisitSymSymExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/Symbols.def", line = 40,
   FQN="clang::ento::SymExprVisitor::VisitSymSymExpr", NM="_ZN5clang4ento14SymExprVisitor15VisitSymSymExprEPKNS0_10SymSymExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ExprInspectionChecker.cpp -nm=_ZN5clang4ento14SymExprVisitor15VisitSymSymExprEPKNS0_10SymSymExprE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitSymSymExpr(/*const*/ SymSymExpr /*P*/ S) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitBinarySymExpr(cast_BinarySymExpr(S));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::SymExprVisitor::VisitSymbolCast">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/Symbols.def", line = 43,
   FQN="clang::ento::SymExprVisitor::VisitSymbolCast", NM="_ZN5clang4ento14SymExprVisitor15VisitSymbolCastEPKNS0_10SymbolCastE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ExprInspectionChecker.cpp -nm=_ZN5clang4ento14SymExprVisitor15VisitSymbolCastEPKNS0_10SymbolCastE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitSymbolCast(/*const*/ SymbolCast /*P*/ S) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitSymExpr(cast_SymExpr(S));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::SymExprVisitor::VisitSymbolData">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/Symbols.def", line = 45,
   FQN="clang::ento::SymExprVisitor::VisitSymbolData", NM="_ZN5clang4ento14SymExprVisitor15VisitSymbolDataEPKNS0_10SymbolDataE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ExprInspectionChecker.cpp -nm=_ZN5clang4ento14SymExprVisitor15VisitSymbolDataEPKNS0_10SymbolDataE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitSymbolData(/*const*/ SymbolData /*P*/ S) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitSymExpr(cast_SymExpr(S));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::SymExprVisitor::VisitSymbolConjured">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/Symbols.def", line = 46,
   FQN="clang::ento::SymExprVisitor::VisitSymbolConjured", NM="_ZN5clang4ento14SymExprVisitor19VisitSymbolConjuredEPKNS0_14SymbolConjuredE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ExprInspectionChecker.cpp -nm=_ZN5clang4ento14SymExprVisitor19VisitSymbolConjuredEPKNS0_14SymbolConjuredE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitSymbolConjured(/*const*/ SymbolConjured /*P*/ S) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitSymbolData(cast_SymbolData(S));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::SymExprVisitor::VisitSymbolDerived">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/Symbols.def", line = 47,
   FQN="clang::ento::SymExprVisitor::VisitSymbolDerived", NM="_ZN5clang4ento14SymExprVisitor18VisitSymbolDerivedEPKNS0_13SymbolDerivedE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ExprInspectionChecker.cpp -nm=_ZN5clang4ento14SymExprVisitor18VisitSymbolDerivedEPKNS0_13SymbolDerivedE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitSymbolDerived(/*const*/ SymbolDerived /*P*/ S) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitSymbolData(cast_SymbolData(S));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::SymExprVisitor::VisitSymbolExtent">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/Symbols.def", line = 48,
   FQN="clang::ento::SymExprVisitor::VisitSymbolExtent", NM="_ZN5clang4ento14SymExprVisitor17VisitSymbolExtentEPKNS0_12SymbolExtentE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ExprInspectionChecker.cpp -nm=_ZN5clang4ento14SymExprVisitor17VisitSymbolExtentEPKNS0_12SymbolExtentE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitSymbolExtent(/*const*/ SymbolExtent /*P*/ S) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitSymbolData(cast_SymbolData(S));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::SymExprVisitor::VisitSymbolMetadata">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/Symbols.def", line = 49,
   FQN="clang::ento::SymExprVisitor::VisitSymbolMetadata", NM="_ZN5clang4ento14SymExprVisitor19VisitSymbolMetadataEPKNS0_14SymbolMetadataE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ExprInspectionChecker.cpp -nm=_ZN5clang4ento14SymExprVisitor19VisitSymbolMetadataEPKNS0_14SymbolMetadataE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitSymbolMetadata(/*const*/ SymbolMetadata /*P*/ S) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitSymbolData(cast_SymbolData(S));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::SymExprVisitor::VisitSymbolRegionValue">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/Symbols.def", line = 50,
   FQN="clang::ento::SymExprVisitor::VisitSymbolRegionValue", NM="_ZN5clang4ento14SymExprVisitor22VisitSymbolRegionValueEPKNS0_17SymbolRegionValueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ExprInspectionChecker.cpp -nm=_ZN5clang4ento14SymExprVisitor22VisitSymbolRegionValueEPKNS0_17SymbolRegionValueE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitSymbolRegionValue(/*const*/ SymbolRegionValue /*P*/ S) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitSymbolData(cast_SymbolData(S));
  }

  
  // Base case, ignore it. :)
  //<editor-fold defaultstate="collapsed" desc="clang::ento::SymExprVisitor::VisitSymExpr">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/SValVisitor.h", line = 99,
   FQN="clang::ento::SymExprVisitor::VisitSymExpr", NM="_ZN5clang4ento14SymExprVisitor12VisitSymExprEPKNS0_7SymExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ExprInspectionChecker.cpp -nm=_ZN5clang4ento14SymExprVisitor12VisitSymExprEPKNS0_7SymExprE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitSymExpr(/*const*/ SymExpr /*P*/ S) {
    return $SymExprVisitor$RetTy();
   }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  public default/*interface*/ RetTy $SymExprVisitor$RetTy() { throw new UnsupportedOperationException("Why not overridden new RetTy()? " + this.getClass()); }
  
  public default/*interface*/ void $SymExprVisitor() { /*for derived classes*/ }

  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
}
