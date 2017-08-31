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

import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.clank.support.Native.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.clang.basic.*;


/// \brief Represents a reference to a non-type template parameter pack that
/// has been substituted with a non-template argument pack.
///
/// When a pack expansion in the source code contains multiple parameter packs
/// and those parameter packs correspond to different levels of template
/// parameter lists, this node is used to represent a non-type template
/// parameter pack from an outer level, which has already had its argument pack
/// substituted but that still lives within a pack expansion that itself
/// could not be instantiated. When actually performing a substitution into
/// that pack expansion (e.g., when all template parameters have corresponding
/// arguments), this type will be replaced with the appropriate underlying
/// expression at the current pack substitution index.
//<editor-fold defaultstate="collapsed" desc="clang::SubstNonTypeTemplateParmPackExpr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 3822,
 FQN="clang::SubstNonTypeTemplateParmPackExpr", NM="_ZN5clang32SubstNonTypeTemplateParmPackExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZN5clang32SubstNonTypeTemplateParmPackExprE")
//</editor-fold>
public class SubstNonTypeTemplateParmPackExpr extends /*public*/ Expr {
  /// \brief The non-type template parameter pack itself.
  /*friend*/public NonTypeTemplateParmDecl /*P*/ Param;
  
  /// \brief A pointer to the set of template arguments that this
  /// parameter pack is instantiated with.
  /*friend*/public /*const*/type$ptr<TemplateArgument/*P*/> Arguments;
  
  /// \brief The number of template arguments in \c Arguments.
  /*friend*/public /*uint*/int NumArguments;
  
  /// \brief The location of the non-type template parameter pack reference.
  /*friend*/public SourceLocation NameLoc;
  
  /*friend  class ASTReader*/
  /*friend  class ASTStmtReader*/
  //<editor-fold defaultstate="collapsed" desc="clang::SubstNonTypeTemplateParmPackExpr::SubstNonTypeTemplateParmPackExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 3838,
   FQN="clang::SubstNonTypeTemplateParmPackExpr::SubstNonTypeTemplateParmPackExpr", NM="_ZN5clang32SubstNonTypeTemplateParmPackExprC1ENS_4Stmt10EmptyShellE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZN5clang32SubstNonTypeTemplateParmPackExprC1ENS_4Stmt10EmptyShellE")
  //</editor-fold>
  /*friend*/public/*private*/ /*explicit*/ SubstNonTypeTemplateParmPackExpr(EmptyShell Empty) {
    // : Expr(SubstNonTypeTemplateParmPackExprClass, Empty), NameLoc() 
    //START JInit
    super(StmtClass.SubstNonTypeTemplateParmPackExprClass, new EmptyShell(Empty));
    this.NameLoc = new SourceLocation();
    //END JInit
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::SubstNonTypeTemplateParmPackExpr::SubstNonTypeTemplateParmPackExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp", line = 1328,
   FQN="clang::SubstNonTypeTemplateParmPackExpr::SubstNonTypeTemplateParmPackExpr", NM="_ZN5clang32SubstNonTypeTemplateParmPackExprC1ENS_8QualTypeEPNS_23NonTypeTemplateParmDeclENS_14SourceLocationERKNS_16TemplateArgumentE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZN5clang32SubstNonTypeTemplateParmPackExprC1ENS_8QualTypeEPNS_23NonTypeTemplateParmDeclENS_14SourceLocationERKNS_16TemplateArgumentE")
  //</editor-fold>
  public SubstNonTypeTemplateParmPackExpr(QualType T, 
      NonTypeTemplateParmDecl /*P*/ Param, 
      SourceLocation NameLoc, 
      final /*const*/ TemplateArgument /*&*/ ArgPack) {
    // : Expr(SubstNonTypeTemplateParmPackExprClass, T, VK_RValue, OK_Ordinary, true, true, true, true), Param(Param), Arguments(ArgPack.pack_begin()), NumArguments(ArgPack.pack_size()), NameLoc(NameLoc) 
    //START JInit
    super(StmtClass.SubstNonTypeTemplateParmPackExprClass, new QualType(T), ExprValueKind.VK_RValue, ExprObjectKind.OK_Ordinary, 
        true, true, true, true);
    this.Param = Param;
    this.Arguments = $tryClone(ArgPack.pack_begin());
    this.NumArguments = ArgPack.pack_size();
    this.NameLoc = new SourceLocation(NameLoc);
    //END JInit
  }

  
  /// \brief Retrieve the non-type template parameter pack being substituted.
  //<editor-fold defaultstate="collapsed" desc="clang::SubstNonTypeTemplateParmPackExpr::getParameterPack">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 3848,
   FQN="clang::SubstNonTypeTemplateParmPackExpr::getParameterPack", NM="_ZNK5clang32SubstNonTypeTemplateParmPackExpr16getParameterPackEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZNK5clang32SubstNonTypeTemplateParmPackExpr16getParameterPackEv")
  //</editor-fold>
  public NonTypeTemplateParmDecl /*P*/ getParameterPack() /*const*/ {
    return Param;
  }

  
  /// \brief Retrieve the location of the parameter pack name.
  //<editor-fold defaultstate="collapsed" desc="clang::SubstNonTypeTemplateParmPackExpr::getParameterPackLocation">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 3851,
   FQN="clang::SubstNonTypeTemplateParmPackExpr::getParameterPackLocation", NM="_ZNK5clang32SubstNonTypeTemplateParmPackExpr24getParameterPackLocationEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZNK5clang32SubstNonTypeTemplateParmPackExpr24getParameterPackLocationEv")
  //</editor-fold>
  public SourceLocation getParameterPackLocation() /*const*/ {
    return new SourceLocation(NameLoc);
  }

  
  /// \brief Retrieve the template argument pack containing the substituted
  /// template arguments.
  //<editor-fold defaultstate="collapsed" desc="clang::SubstNonTypeTemplateParmPackExpr::getArgumentPack">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp", line = 1338,
   FQN="clang::SubstNonTypeTemplateParmPackExpr::getArgumentPack", NM="_ZNK5clang32SubstNonTypeTemplateParmPackExpr15getArgumentPackEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZNK5clang32SubstNonTypeTemplateParmPackExpr15getArgumentPackEv")
  //</editor-fold>
  public TemplateArgument getArgumentPack() /*const*/ {
    return new TemplateArgument(llvm.makeArrayRef(Arguments, NumArguments));
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::SubstNonTypeTemplateParmPackExpr::getLocStart">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 3857,
   FQN="clang::SubstNonTypeTemplateParmPackExpr::getLocStart", NM="_ZNK5clang32SubstNonTypeTemplateParmPackExpr11getLocStartEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZNK5clang32SubstNonTypeTemplateParmPackExpr11getLocStartEv")
  //</editor-fold>
  public SourceLocation getLocStart() /*const*//* __attribute__((pure))*/ {
    return new SourceLocation(NameLoc);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::SubstNonTypeTemplateParmPackExpr::getLocEnd">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 3858,
   FQN="clang::SubstNonTypeTemplateParmPackExpr::getLocEnd", NM="_ZNK5clang32SubstNonTypeTemplateParmPackExpr9getLocEndEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZNK5clang32SubstNonTypeTemplateParmPackExpr9getLocEndEv")
  //</editor-fold>
  public SourceLocation getLocEnd() /*const*//* __attribute__((pure))*/ {
    return new SourceLocation(NameLoc);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::SubstNonTypeTemplateParmPackExpr::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 3860,
   FQN="clang::SubstNonTypeTemplateParmPackExpr::classof", NM="_ZN5clang32SubstNonTypeTemplateParmPackExpr7classofEPKNS_4StmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZN5clang32SubstNonTypeTemplateParmPackExpr7classofEPKNS_4StmtE")
  //</editor-fold>
  public static boolean classof(/*const*/ Stmt /*P*/ T) {
    return T.getStmtClass() == StmtClass.SubstNonTypeTemplateParmPackExprClass;
  }

  
  // Iterators
  //<editor-fold defaultstate="collapsed" desc="clang::SubstNonTypeTemplateParmPackExpr::children">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 3865,
   FQN="clang::SubstNonTypeTemplateParmPackExpr::children", NM="_ZN5clang32SubstNonTypeTemplateParmPackExpr8childrenEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZN5clang32SubstNonTypeTemplateParmPackExpr8childrenEv")
  //</editor-fold>
  public iterator_range<Stmt/*P*/> children() {
    return new iterator_range<Stmt/*P*/>(new StmtIterator(), new StmtIterator());
  }

  
  @Override public String toString() {
    return "" + "Param=" + Param // NOI18N
              + ", Arguments=" + Arguments // NOI18N
              + ", NumArguments=" + NumArguments // NOI18N
              + ", NameLoc=" + NameLoc // NOI18N
              + super.toString(); // NOI18N
  }
}
