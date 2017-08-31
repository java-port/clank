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
import org.llvm.adt.aliases.*;
import org.clang.basic.*;
import org.clang.ast.*;
import static org.clang.ast.impl.SelectorLocationsKindStatics.*;


//<editor-fold defaultstate="collapsed" desc="static type SelectorLocationsKindClangGlobals">
@Converted(kind = Converted.Kind.AUTO,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/SelectorLocationsKind.cpp -nm=_ZN5clang22getStandardSelectorLocEjNS_8SelectorEbN4llvm8ArrayRefIPNS_11ParmVarDeclEEENS_14SourceLocationE;_ZN5clang22getStandardSelectorLocEjNS_8SelectorEbN4llvm8ArrayRefIPNS_4ExprEEENS_14SourceLocationE;_ZN5clang23hasStandardSelectorLocsENS_8SelectorEN4llvm8ArrayRefINS_14SourceLocationEEENS2_IPNS_11ParmVarDeclEEES3_;_ZN5clang23hasStandardSelectorLocsENS_8SelectorEN4llvm8ArrayRefINS_14SourceLocationEEENS2_IPNS_4ExprEEES3_; -static-type=SelectorLocationsKindClangGlobals -package=org.clang.ast.impl")
//</editor-fold>
public final class SelectorLocationsKindClangGlobals {


/// \brief Returns true if all \p SelLocs are in a "standard" location.
// anonymous namespace
//<editor-fold defaultstate="collapsed" desc="clang::hasStandardSelectorLocs">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/SelectorLocationsKind.cpp", line = 96,
 FQN="clang::hasStandardSelectorLocs", NM="_ZN5clang23hasStandardSelectorLocsENS_8SelectorEN4llvm8ArrayRefINS_14SourceLocationEEENS2_IPNS_4ExprEEES3_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/SelectorLocationsKind.cpp -nm=_ZN5clang23hasStandardSelectorLocsENS_8SelectorEN4llvm8ArrayRefINS_14SourceLocationEEENS2_IPNS_4ExprEEES3_")
//</editor-fold>
public static SelectorLocationsKind hasStandardSelectorLocsExprs(Selector Sel, 
                            ArrayRef<SourceLocation> SelLocs, 
                            ArrayRef<Expr /*P*/ > Args, 
                            SourceLocation EndLoc) {
  return hasStandardSelLocs(Expr.class, new Selector(Sel), new ArrayRef<SourceLocation>(SelLocs), new ArrayRef<Expr /*P*/ >(Args), new SourceLocation(EndLoc));
}


/// \brief Get the "standard" location of a selector identifier, e.g:
/// For nullary selectors, immediately before ']': "[foo release]"
///
/// \param WithArgSpace if true the standard location is with a space apart
/// before arguments: "[foo first: 1 second: 2]"
/// If false: "[foo first:1 second:2]"
//<editor-fold defaultstate="collapsed" desc="clang::getStandardSelectorLoc">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/SelectorLocationsKind.cpp", line = 104,
 FQN="clang::getStandardSelectorLoc", NM="_ZN5clang22getStandardSelectorLocEjNS_8SelectorEbN4llvm8ArrayRefIPNS_4ExprEEENS_14SourceLocationE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/SelectorLocationsKind.cpp -nm=_ZN5clang22getStandardSelectorLocEjNS_8SelectorEbN4llvm8ArrayRefIPNS_4ExprEEENS_14SourceLocationE")
//</editor-fold>
public static SourceLocation getStandardSelectorLocExprs(/*uint*/int Index, 
                           Selector Sel, 
                           boolean WithArgSpace, 
                           ArrayRef<Expr /*P*/ > Args, 
                           SourceLocation EndLoc) {
  return getStandardSelLoc(Index, new Selector(Sel), WithArgSpace, 
      getArgLoc(Expr.class, Index, new ArrayRef<Expr /*P*/ >(Args)), new SourceLocation(EndLoc));
}


/// \brief Returns true if all \p SelLocs are in a "standard" location.
//<editor-fold defaultstate="collapsed" desc="clang::hasStandardSelectorLocs">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/SelectorLocationsKind.cpp", line = 113,
 FQN="clang::hasStandardSelectorLocs", NM="_ZN5clang23hasStandardSelectorLocsENS_8SelectorEN4llvm8ArrayRefINS_14SourceLocationEEENS2_IPNS_11ParmVarDeclEEES3_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/SelectorLocationsKind.cpp -nm=_ZN5clang23hasStandardSelectorLocsENS_8SelectorEN4llvm8ArrayRefINS_14SourceLocationEEENS2_IPNS_11ParmVarDeclEEES3_")
//</editor-fold>
public static SelectorLocationsKind hasStandardSelectorLocsParmVarDecls(Selector Sel, 
                                   ArrayRef<SourceLocation> SelLocs, 
                                   ArrayRef<ParmVarDecl /*P*/ > Args, 
                                   SourceLocation EndLoc) {
  return hasStandardSelLocs(ParmVarDecl.class, new Selector(Sel), new ArrayRef<SourceLocation>(SelLocs), new ArrayRef<ParmVarDecl /*P*/ >(Args), new SourceLocation(EndLoc));
}


/// \brief Get the "standard" location of a selector identifier, e.g:
/// For nullary selectors, immediately before ']': "[foo release]"
///
/// \param WithArgSpace if true the standard location is with a space apart
/// before arguments: "-(id)first: (int)x second: (int)y;"
/// If false: "-(id)first:(int)x second:(int)y;"
//<editor-fold defaultstate="collapsed" desc="clang::getStandardSelectorLoc">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/SelectorLocationsKind.cpp", line = 121,
 FQN="clang::getStandardSelectorLoc", NM="_ZN5clang22getStandardSelectorLocEjNS_8SelectorEbN4llvm8ArrayRefIPNS_11ParmVarDeclEEENS_14SourceLocationE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/SelectorLocationsKind.cpp -nm=_ZN5clang22getStandardSelectorLocEjNS_8SelectorEbN4llvm8ArrayRefIPNS_11ParmVarDeclEEENS_14SourceLocationE")
//</editor-fold>
public static SourceLocation getStandardSelectorLocParmVarDecls(/*uint*/int Index, 
                                  Selector Sel, 
                                  boolean WithArgSpace, 
                                  ArrayRef<ParmVarDecl /*P*/ > Args, 
                                  SourceLocation EndLoc) {
  return getStandardSelLoc(Index, new Selector(Sel), WithArgSpace, 
      getArgLoc(ParmVarDecl.class, Index, new ArrayRef<ParmVarDecl /*P*/ >(Args)), new SourceLocation(EndLoc));
}

} // END OF class SelectorLocationsKindClangGlobals
