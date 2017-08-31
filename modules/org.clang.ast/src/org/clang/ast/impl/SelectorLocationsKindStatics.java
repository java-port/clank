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
package org.clang.ast.impl;

import org.clank.support.*;
import static org.clank.support.Unsigned.*;
import org.llvm.adt.aliases.*;
import org.clang.basic.*;
import org.clang.ast.*;
import static org.clang.ast.AstClangGlobals.*;


//<editor-fold defaultstate="collapsed" desc="static type SelectorLocationsKindStatics">
@Converted(kind = Converted.Kind.AUTO,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/SelectorLocationsKind.cpp -nm=Tpl__ZN12_GLOBAL__N_118hasStandardSelLocsEN5clang8SelectorEN4llvm8ArrayRefINS0_14SourceLocationEEENS3_IPT_EES4_;Tpl__ZN12_GLOBAL__N_19getArgLocEjN4llvm8ArrayRefIPT_EE;_ZL17getStandardSelLocjN5clang8SelectorEbNS_14SourceLocationES1_;_ZN12_GLOBAL__N_19getArgLocIN5clang11ParmVarDeclEEENS1_14SourceLocationEPT_;_ZN12_GLOBAL__N_19getArgLocIN5clang4ExprEEENS1_14SourceLocationEPT_; -static-type=SelectorLocationsKindStatics -package=org.clang.ast.impl")
//</editor-fold>
public final class SelectorLocationsKindStatics {

//<editor-fold defaultstate="collapsed" desc="getStandardSelLoc">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/SelectorLocationsKind.cpp", line = 20,
 FQN="getStandardSelLoc", NM="_ZL17getStandardSelLocjN5clang8SelectorEbNS_14SourceLocationES1_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/SelectorLocationsKind.cpp -nm=_ZL17getStandardSelLocjN5clang8SelectorEbNS_14SourceLocationES1_")
//</editor-fold>
public static SourceLocation getStandardSelLoc(/*uint*/int Index, 
                 Selector Sel, 
                 boolean WithArgSpace, 
                 SourceLocation ArgLoc, 
                 SourceLocation EndLoc) {
  /*uint*/int NumSelArgs = Sel.getNumArgs();
  if (NumSelArgs == 0) {
    assert (Index == 0);
    if (EndLoc.isInvalid()) {
      return new SourceLocation();
    }
    IdentifierInfo /*P*/ II = Sel.getIdentifierInfoForSlot(0);
    /*uint*/int Len = (II != null) ? II.getLength() : 0;
    return EndLoc.getLocWithOffset(-Len);
  }
  assert ($less_uint(Index, NumSelArgs));
  if (ArgLoc.isInvalid()) {
    return new SourceLocation();
  }
  IdentifierInfo /*P*/ II = Sel.getIdentifierInfoForSlot(Index);
  /*uint*/int Len = /* selector id */ ((II != null) ? II.getLength() : 0) + /* ':' */ 1;
  if (WithArgSpace) {
    ++Len;
  }
  return ArgLoc.getLocWithOffset(-Len);
}

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::getArgLoc">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/SelectorLocationsKind.cpp", line = 50,
 FQN="(anonymous namespace)::getArgLoc", NM="_ZN12_GLOBAL__N_19getArgLocIN5clang4ExprEEENS1_14SourceLocationEPT_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/SelectorLocationsKind.cpp -nm=_ZN12_GLOBAL__N_19getArgLocIN5clang4ExprEEENS1_14SourceLocationEPT_")
//</editor-fold>
public static SourceLocation getArgLoc$Expr(Expr /*P*/ Arg) {
  return Arg.getLocStart();
}
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::getArgLoc">
@Converted(kind = Converted.Kind.MANUAL_ADDED,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/SelectorLocationsKind.cpp", line = 55)
//</editor-fold>
public static SourceLocation getArgLoc$ParmVarDecl(ParmVarDecl /*P*/ Arg) {
  SourceLocation Loc = Arg.getLocStart();
  if (Loc.isInvalid())
    return Loc;
  // -1 to point to left paren of the method parameter's type.
  return Loc.getLocWithOffset(-1);
}

/*template <typename T> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::getArgLoc">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/SelectorLocationsKind.cpp", line = 65,
 FQN="(anonymous namespace)::getArgLoc", NM="Tpl__ZN12_GLOBAL__N_19getArgLocEjN4llvm8ArrayRefIPT_EE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/SelectorLocationsKind.cpp -nm=Tpl__ZN12_GLOBAL__N_19getArgLocEjN4llvm8ArrayRefIPT_EE")
//</editor-fold>
public static </*typename*/ T> SourceLocation getArgLoc(Class<T> clazz, /*uint*/int Index, ArrayRef<T /*P*/ > Args) {
  if (clazz.isAssignableFrom(Expr.class)) {
    return Native.$less(Index, Args.size()) ? getArgLoc$Expr((Expr)Args.$at(Index)) : new SourceLocation();
  } else if (clazz.isAssignableFrom(ParmVarDecl.class)) {
    return Native.$less(Index, Args.size()) ? getArgLoc$ParmVarDecl((ParmVarDecl)Args.$at(Index)) : new SourceLocation();
  } else {
    assert false : clazz.getName();
    return new SourceLocation();
  }
}

/*template <typename T> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::hasStandardSelLocs">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/SelectorLocationsKind.cpp", line = 70,
 FQN="(anonymous namespace)::hasStandardSelLocs", NM="Tpl__ZN12_GLOBAL__N_118hasStandardSelLocsEN5clang8SelectorEN4llvm8ArrayRefINS0_14SourceLocationEEENS3_IPT_EES4_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/SelectorLocationsKind.cpp -nm=Tpl__ZN12_GLOBAL__N_118hasStandardSelLocsEN5clang8SelectorEN4llvm8ArrayRefINS0_14SourceLocationEEENS3_IPT_EES4_")
//</editor-fold>
public static </*typename*/ T> SelectorLocationsKind hasStandardSelLocs(Class<T> clazz, Selector Sel, 
                  ArrayRef<SourceLocation> SelLocs, 
                  ArrayRef<T /*P*/ > Args, 
                  SourceLocation EndLoc) {
  // Are selector locations in standard position with no space between args ?
  /*uint*/int i;
  for (i = 0; i != SelLocs.size(); ++i) {
    if (clazz.isAssignableFrom(ParmVarDecl.class)) {
      if (Native.$noteq(SelLocs.$at(i), getStandardSelectorLocParmVarDecls(i, Sel, /*WithArgSpace=*/ false, 
              (ArrayRef<ParmVarDecl>)Args, EndLoc))) {
        break;
      }
    } else if (clazz.isAssignableFrom(Expr.class)) {
      if (Native.$noteq(SelLocs.$at(i), getStandardSelectorLocExprs(i, Sel, /*WithArgSpace=*/ false, 
              (ArrayRef<Expr>)Args, EndLoc))) {
        break;
      }
    } 
  }
  if (i == SelLocs.size()) {
    return SelectorLocationsKind.SelLoc_StandardNoSpace;
  }
  
  // Are selector locations in standard position with space between args ?
  for (i = 0; i != SelLocs.size(); ++i) {
    if (clazz.isAssignableFrom(ParmVarDecl.class)) {
      if (Native.$noteq(SelLocs.$at(i), getStandardSelectorLocParmVarDecls(i, Sel, /*WithArgSpace=*/ true, 
              (ArrayRef<ParmVarDecl>)Args, EndLoc))) {
        return SelectorLocationsKind.SelLoc_NonStandard;
      }
    } else if (clazz.isAssignableFrom(Expr.class)) {
      if (Native.$noteq(SelLocs.$at(i), getStandardSelectorLocExprs(i, Sel, /*WithArgSpace=*/ true, 
              (ArrayRef<Expr>)Args, EndLoc))) {
        return SelectorLocationsKind.SelLoc_NonStandard;
      }
    } 
  }
  
  return SelectorLocationsKind.SelLoc_StandardWithSpace;
}

} // END OF class SelectorLocationsKindStatics
