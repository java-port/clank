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
import static org.clank.support.Casts.*;
import static org.clank.support.NativePointer.*;
import org.llvm.adt.*;
import org.clang.basic.*;


/// \brief Representation of a Microsoft __if_exists or __if_not_exists
/// statement with a dependent name.
///
/// The __if_exists statement can be used to include a sequence of statements
/// in the program only when a particular dependent name does not exist. For
/// example:
///
/// \code
/// template<typename T>
/// void call_foo(T &t) {
///   __if_exists (T::foo) {
///     t.foo(); // okay: only called when T::foo exists.
///   }
/// }
/// \endcode
///
/// Similarly, the __if_not_exists statement can be used to include the
/// statements when a particular name does not exist.
///
/// Note that this statement only captures __if_exists and __if_not_exists
/// statements whose name is dependent. All non-dependent cases are handled
/// directly in the parser, so that they don't introduce a new scope. Clang
/// introduces scopes in the dependent case to keep names inside the compound
/// statement from leaking out into the surround statements, which would
/// compromise the template instantiation model. This behavior differs from
/// Visual C++ (which never introduces a scope), but is a fairly reasonable
/// approximation of the VC++ behavior.
//<editor-fold defaultstate="collapsed" desc="clang::MSDependentExistsStmt">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtCXX.h", line = 240,
 FQN="clang::MSDependentExistsStmt", NM="_ZN5clang21MSDependentExistsStmtE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtCXX.cpp -nm=_ZN5clang21MSDependentExistsStmtE")
//</editor-fold>
public class MSDependentExistsStmt extends /*public*/ Stmt {
  /*friend*/public SourceLocation KeywordLoc;
  /*friend*/public boolean IsIfExists;
  /*friend*/public NestedNameSpecifierLoc QualifierLoc;
  /*friend*/public DeclarationNameInfo NameInfo;
  /*friend*/public Stmt /*P*/ SubStmt;
  
  /*friend  class ASTReader*/
  /*friend  class ASTStmtReader*/
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::MSDependentExistsStmt::MSDependentExistsStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtCXX.h", line = 251,
   FQN="clang::MSDependentExistsStmt::MSDependentExistsStmt", NM="_ZN5clang21MSDependentExistsStmtC1ENS_14SourceLocationEbNS_22NestedNameSpecifierLocENS_19DeclarationNameInfoEPNS_12CompoundStmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtCXX.cpp -nm=_ZN5clang21MSDependentExistsStmtC1ENS_14SourceLocationEbNS_22NestedNameSpecifierLocENS_19DeclarationNameInfoEPNS_12CompoundStmtE")
  //</editor-fold>
  public MSDependentExistsStmt(SourceLocation KeywordLoc, boolean IsIfExists, 
      NestedNameSpecifierLoc QualifierLoc, 
      DeclarationNameInfo NameInfo, 
      CompoundStmt /*P*/ SubStmt) {
    // : Stmt(MSDependentExistsStmtClass), KeywordLoc(KeywordLoc), IsIfExists(IsIfExists), QualifierLoc(QualifierLoc), NameInfo(NameInfo), SubStmt(reinterpret_cast<Stmt * >(SubStmt)) 
    //START JInit
    super(StmtClass.MSDependentExistsStmtClass);
    this.KeywordLoc = new SourceLocation(KeywordLoc);
    this.IsIfExists = IsIfExists;
    this.QualifierLoc = new NestedNameSpecifierLoc(QualifierLoc);
    this.NameInfo = new DeclarationNameInfo(NameInfo);
    this.SubStmt = reinterpret_cast(Stmt /*P*/ .class, SubStmt);
    //END JInit
  }

  
  /// \brief Retrieve the location of the __if_exists or __if_not_exists
  /// keyword.
  //<editor-fold defaultstate="collapsed" desc="clang::MSDependentExistsStmt::getKeywordLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtCXX.h", line = 262,
   FQN="clang::MSDependentExistsStmt::getKeywordLoc", NM="_ZNK5clang21MSDependentExistsStmt13getKeywordLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtCXX.cpp -nm=_ZNK5clang21MSDependentExistsStmt13getKeywordLocEv")
  //</editor-fold>
  public SourceLocation getKeywordLoc() /*const*/ {
    return new SourceLocation(KeywordLoc);
  }

  
  /// \brief Determine whether this is an __if_exists statement.
  //<editor-fold defaultstate="collapsed" desc="clang::MSDependentExistsStmt::isIfExists">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtCXX.h", line = 265,
   FQN="clang::MSDependentExistsStmt::isIfExists", NM="_ZNK5clang21MSDependentExistsStmt10isIfExistsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtCXX.cpp -nm=_ZNK5clang21MSDependentExistsStmt10isIfExistsEv")
  //</editor-fold>
  public boolean isIfExists() /*const*/ {
    return IsIfExists;
  }

  
  /// \brief Determine whether this is an __if_exists statement.
  //<editor-fold defaultstate="collapsed" desc="clang::MSDependentExistsStmt::isIfNotExists">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtCXX.h", line = 268,
   FQN="clang::MSDependentExistsStmt::isIfNotExists", NM="_ZNK5clang21MSDependentExistsStmt13isIfNotExistsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtCXX.cpp -nm=_ZNK5clang21MSDependentExistsStmt13isIfNotExistsEv")
  //</editor-fold>
  public boolean isIfNotExists() /*const*/ {
    return !IsIfExists;
  }

  
  /// \brief Retrieve the nested-name-specifier that qualifies this name, if
  /// any.
  //<editor-fold defaultstate="collapsed" desc="clang::MSDependentExistsStmt::getQualifierLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtCXX.h", line = 272,
   FQN="clang::MSDependentExistsStmt::getQualifierLoc", NM="_ZNK5clang21MSDependentExistsStmt15getQualifierLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtCXX.cpp -nm=_ZNK5clang21MSDependentExistsStmt15getQualifierLocEv")
  //</editor-fold>
  public NestedNameSpecifierLoc getQualifierLoc() /*const*/ {
    return new NestedNameSpecifierLoc(QualifierLoc);
  }

  
  /// \brief Retrieve the name of the entity we're testing for, along with
  /// location information
  //<editor-fold defaultstate="collapsed" desc="clang::MSDependentExistsStmt::getNameInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtCXX.h", line = 276,
   FQN="clang::MSDependentExistsStmt::getNameInfo", NM="_ZNK5clang21MSDependentExistsStmt11getNameInfoEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtCXX.cpp -nm=_ZNK5clang21MSDependentExistsStmt11getNameInfoEv")
  //</editor-fold>
  public DeclarationNameInfo getNameInfo() /*const*/ {
    return new DeclarationNameInfo(NameInfo);
  }

  
  /// \brief Retrieve the compound statement that will be included in the
  /// program only if the existence of the symbol matches the initial keyword.
  //<editor-fold defaultstate="collapsed" desc="clang::MSDependentExistsStmt::getSubStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtCXX.h", line = 280,
   FQN="clang::MSDependentExistsStmt::getSubStmt", NM="_ZNK5clang21MSDependentExistsStmt10getSubStmtEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtCXX.cpp -nm=_ZNK5clang21MSDependentExistsStmt10getSubStmtEv")
  //</editor-fold>
  public CompoundStmt /*P*/ getSubStmt() /*const*/ {
    return reinterpret_cast(CompoundStmt /*P*/ .class, SubStmt);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::MSDependentExistsStmt::getLocStart">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtCXX.h", line = 284,
   FQN="clang::MSDependentExistsStmt::getLocStart", NM="_ZNK5clang21MSDependentExistsStmt11getLocStartEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtCXX.cpp -nm=_ZNK5clang21MSDependentExistsStmt11getLocStartEv")
  //</editor-fold>
  public SourceLocation getLocStart() /*const*//* __attribute__((pure))*/ {
    return new SourceLocation(KeywordLoc);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::MSDependentExistsStmt::getLocEnd">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtCXX.h", line = 285,
   FQN="clang::MSDependentExistsStmt::getLocEnd", NM="_ZNK5clang21MSDependentExistsStmt9getLocEndEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtCXX.cpp -nm=_ZNK5clang21MSDependentExistsStmt9getLocEndEv")
  //</editor-fold>
  public SourceLocation getLocEnd() /*const*//* __attribute__((pure))*/ {
    return SubStmt.getLocEnd();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::MSDependentExistsStmt::children">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtCXX.h", line = 287,
   FQN="clang::MSDependentExistsStmt::children", NM="_ZN5clang21MSDependentExistsStmt8childrenEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtCXX.cpp -nm=_ZN5clang21MSDependentExistsStmt8childrenEv")
  //</editor-fold>
  public iterator_range<Stmt/*P*/> children() {
    return new iterator_range<Stmt/*P*/>(new StmtIterator(create_type$ptr($AddrOf(SubStmt))), new StmtIterator(create_type$ptr($AddrOf(SubStmt)).$add(1)));
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::MSDependentExistsStmt::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtCXX.h", line = 291,
   FQN="clang::MSDependentExistsStmt::classof", NM="_ZN5clang21MSDependentExistsStmt7classofEPKNS_4StmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtCXX.cpp -nm=_ZN5clang21MSDependentExistsStmt7classofEPKNS_4StmtE")
  //</editor-fold>
  public static boolean classof(/*const*/ Stmt /*P*/ T) {
    return T.getStmtClass() == StmtClass.MSDependentExistsStmtClass;
  }

  
  @Override public String toString() {
    return "" + "KeywordLoc=" + KeywordLoc // NOI18N
              + ", IsIfExists=" + IsIfExists // NOI18N
              + ", QualifierLoc=" + QualifierLoc // NOI18N
              + ", NameInfo=" + NameInfo // NOI18N
              + ", SubStmt=" + SubStmt // NOI18N
              + super.toString(); // NOI18N
  }
}
