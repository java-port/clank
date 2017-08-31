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

package org.clang.ast;

import static org.clank.support.Native.$AddrOf;
import org.clank.support.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.support.Casts.*;
import static org.llvm.adt.ADTAliases.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.NativePointer.*;
import org.llvm.adt.*;
import org.clang.basic.*;


/// \brief Represents a C++11 pack expansion that produces a sequence of
/// expressions.
///
/// A pack expansion expression contains a pattern (which itself is an
/// expression) followed by an ellipsis. For example:
///
/// \code
/// template<typename F, typename ...Types>
/// void forward(F f, Types &&...args) {
///   f(static_cast<Types&&>(args)...);
/// }
/// \endcode
///
/// Here, the argument to the function object \c f is a pack expansion whose
/// pattern is \c static_cast<Types&&>(args). When the \c forward function
/// template is instantiated, the pack expansion will instantiate to zero or
/// or more function arguments to the function object \c f.
//<editor-fold defaultstate="collapsed" desc="clang::PackExpansionExpr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 3581,
 FQN="clang::PackExpansionExpr", NM="_ZN5clang17PackExpansionExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZN5clang17PackExpansionExprE")
//</editor-fold>
public class PackExpansionExpr extends /*public*/ Expr {
  /*friend*/public SourceLocation EllipsisLoc;
  
  /// \brief The number of expansions that will be produced by this pack
  /// expansion expression, if known.
  ///
  /// When zero, the number of expansions is not known. Otherwise, this value
  /// is the number of expansions + 1.
  /*friend*/public /*uint*/int NumExpansions;
  
  /*friend*/public Stmt /*P*/ Pattern;
  
  /*friend  class ASTStmtReader*/
  /*friend  class ASTStmtWriter*/
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::PackExpansionExpr::PackExpansionExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 3597,
   FQN="clang::PackExpansionExpr::PackExpansionExpr", NM="_ZN5clang17PackExpansionExprC1ENS_8QualTypeEPNS_4ExprENS_14SourceLocationEN4llvm8OptionalIjEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZN5clang17PackExpansionExprC1ENS_8QualTypeEPNS_4ExprENS_14SourceLocationEN4llvm8OptionalIjEE")
  //</editor-fold>
  public PackExpansionExpr(QualType T, Expr /*P*/ Pattern, SourceLocation EllipsisLoc, 
      OptionalUInt NumExpansions) {
    // : Expr(PackExpansionExprClass, T, Pattern->getValueKind(), Pattern->getObjectKind(), /*TypeDependent=*/ true, /*ValueDependent=*/ true, /*InstantiationDependent=*/ true, /*ContainsUnexpandedParameterPack=*/ false), EllipsisLoc(EllipsisLoc), NumExpansions(NumExpansions.operator bool() ? * NumExpansions + 1 : 0), Pattern(Pattern) 
    //START JInit
    super(StmtClass.PackExpansionExprClass, new QualType(T), Pattern.getValueKind(), 
        Pattern.getObjectKind(), true, 
        true, true, 
        false);
    this.EllipsisLoc = new SourceLocation(EllipsisLoc);
    this.NumExpansions = NumExpansions.$bool() ? NumExpansions.$star() + 1 : 0;
    this.Pattern = Pattern;
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::PackExpansionExpr::PackExpansionExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 3607,
   FQN="clang::PackExpansionExpr::PackExpansionExpr", NM="_ZN5clang17PackExpansionExprC1ENS_4Stmt10EmptyShellE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZN5clang17PackExpansionExprC1ENS_4Stmt10EmptyShellE")
  //</editor-fold>
  public PackExpansionExpr(EmptyShell Empty) {
    // : Expr(PackExpansionExprClass, Empty), EllipsisLoc() 
    //START JInit
    super(StmtClass.PackExpansionExprClass, new EmptyShell(Empty));
    this.EllipsisLoc = new SourceLocation();
    //END JInit
  }

  
  /// \brief Retrieve the pattern of the pack expansion.
  //<editor-fold defaultstate="collapsed" desc="clang::PackExpansionExpr::getPattern">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 3610,
   FQN="clang::PackExpansionExpr::getPattern", NM="_ZN5clang17PackExpansionExpr10getPatternEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZN5clang17PackExpansionExpr10getPatternEv")
  //</editor-fold>
  public Expr /*P*/ getPattern() {
    return reinterpret_cast(Expr /*P*/ .class, Pattern);
  }

  
  /// \brief Retrieve the pattern of the pack expansion.
  //<editor-fold defaultstate="collapsed" desc="clang::PackExpansionExpr::getPattern">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 3613,
   FQN="clang::PackExpansionExpr::getPattern", NM="_ZNK5clang17PackExpansionExpr10getPatternEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZNK5clang17PackExpansionExpr10getPatternEv")
  //</editor-fold>
  public /*const*/ Expr /*P*/ getPattern$Const() /*const*/ {
    return reinterpret_cast(Expr /*P*/ .class, Pattern);
  }

  
  /// \brief Retrieve the location of the ellipsis that describes this pack
  /// expansion.
  //<editor-fold defaultstate="collapsed" desc="clang::PackExpansionExpr::getEllipsisLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 3617,
   FQN="clang::PackExpansionExpr::getEllipsisLoc", NM="_ZNK5clang17PackExpansionExpr14getEllipsisLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZNK5clang17PackExpansionExpr14getEllipsisLocEv")
  //</editor-fold>
  public SourceLocation getEllipsisLoc() /*const*/ {
    return new SourceLocation(EllipsisLoc);
  }

  
  /// \brief Determine the number of expansions that will be produced when
  /// this pack expansion is instantiated, if already known.
  //<editor-fold defaultstate="collapsed" desc="clang::PackExpansionExpr::getNumExpansions">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 3621,
   FQN="clang::PackExpansionExpr::getNumExpansions", NM="_ZNK5clang17PackExpansionExpr16getNumExpansionsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZNK5clang17PackExpansionExpr16getNumExpansionsEv")
  //</editor-fold>
  public OptionalUInt getNumExpansions() /*const*/ {
    if ((NumExpansions != 0)) {
      return new OptionalUInt(JD$T$RR.INSTANCE, NumExpansions - 1);
    }
    
    return new OptionalUInt(None);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::PackExpansionExpr::getLocStart">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 3628,
   FQN="clang::PackExpansionExpr::getLocStart", NM="_ZNK5clang17PackExpansionExpr11getLocStartEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZNK5clang17PackExpansionExpr11getLocStartEv")
  //</editor-fold>
  public SourceLocation getLocStart() /*const*//* __attribute__((pure))*/ {
    return Pattern.getLocStart();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::PackExpansionExpr::getLocEnd">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 3631,
   FQN="clang::PackExpansionExpr::getLocEnd", NM="_ZNK5clang17PackExpansionExpr9getLocEndEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZNK5clang17PackExpansionExpr9getLocEndEv")
  //</editor-fold>
  public SourceLocation getLocEnd() /*const*//* __attribute__((pure))*/ {
    return new SourceLocation(EllipsisLoc);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::PackExpansionExpr::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 3633,
   FQN="clang::PackExpansionExpr::classof", NM="_ZN5clang17PackExpansionExpr7classofEPKNS_4StmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZN5clang17PackExpansionExpr7classofEPKNS_4StmtE")
  //</editor-fold>
  public static boolean classof(/*const*/ Stmt /*P*/ T) {
    return T.getStmtClass() == StmtClass.PackExpansionExprClass;
  }

  
  // Iterators
  //<editor-fold defaultstate="collapsed" desc="clang::PackExpansionExpr::children">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 3638,
   FQN="clang::PackExpansionExpr::children", NM="_ZN5clang17PackExpansionExpr8childrenEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZN5clang17PackExpansionExpr8childrenEv")
  //</editor-fold>
  public iterator_range<Stmt/*P*/> children() {
    return new iterator_range<Stmt/*P*/>(new StmtIterator(create_type$ptr($AddrOf(Pattern))), new StmtIterator(create_type$ptr($AddrOf(Pattern)).$add(1)));
  }

  
  @Override public String toString() {
    return "" + "EllipsisLoc=" + EllipsisLoc // NOI18N
              + ", NumExpansions=" + NumExpansions // NOI18N
              + ", Pattern=" + Pattern // NOI18N
              + super.toString(); // NOI18N
  }
}
