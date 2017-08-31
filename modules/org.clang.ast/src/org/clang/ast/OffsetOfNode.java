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
import org.clank.support.JavaDifferentiators.*;
import org.clang.basic.*;
import org.clank.support.Native.NativePOD;


/// Helper class for OffsetOfExpr.

// __builtin_offsetof(type, identifier(.identifier|[expr])*)
//<editor-fold defaultstate="collapsed" desc="clang::OffsetOfNode">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 1770,
 FQN="clang::OffsetOfNode", NM="_ZN5clang12OffsetOfNodeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp -nm=_ZN5clang12OffsetOfNodeE")
//</editor-fold>
public class OffsetOfNode implements NativePOD<OffsetOfNode> {
/*public:*/
  /// \brief The kind of offsetof node we have.
  //<editor-fold defaultstate="collapsed" desc="clang::OffsetOfNode::Kind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 1773,
   FQN="clang::OffsetOfNode::Kind", NM="_ZN5clang12OffsetOfNode4KindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp -nm=_ZN5clang12OffsetOfNode4KindE")
  //</editor-fold>
  public static final class/*enum*/ Kind {
    /// \brief An index into an array.
    public static final /*uint*/int Array = 0x00;
    /// \brief A field.
    public static final /*uint*/int Field = 0x01;
    /// \brief A field in a dependent type, known only by its name.
    public static final /*uint*/int Identifier = 0x02;
    /// \brief An implicit indirection through a C++ base class, when the
    /// field found is in a base class.
    public static final /*uint*/int Base = 0x03;
  };
/*private:*/
  //<editor-fold defaultstate="collapsed" desc="clang::OffsetOfNode::(anonymous)">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 1786,
   FQN="clang::OffsetOfNode::(anonymous)", NM="_ZN5clang12OffsetOfNodeE_Unnamed_enum1",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp -nm=_ZN5clang12OffsetOfNodeE_Unnamed_enum1")
  //</editor-fold>
  /*enum ANONYMOUS_INT_CONSTANTS {*/
    public static final /*uint*/int MaskBits = 2;
    public static final /*uint*/int Mask = 0x03;
  /*}*/;
  
  /// \brief The source range that covers this part of the designator.
  private SourceRange Range;
  
  /// \brief The data describing the designator, which comes in three
  /// different forms, depending on the lower two bits.
  ///   - An unsigned index into the array of Expr*'s stored after this node
  ///     in memory, for [constant-expression] designators.
  ///   - A FieldDecl*, for references to a known field.
  ///   - An IdentifierInfo*, for references to a field with a given name
  ///     when the class type is dependent.
  ///   - A CXXBaseSpecifier*, for references that look at a field in a
  ///     base class.
  private Object/*uintptr_t*/ Data;
/*public:*/
  /// \brief Create an offsetof node that refers to an array element.
  //<editor-fold defaultstate="collapsed" desc="clang::OffsetOfNode::OffsetOfNode">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 1804,
   FQN="clang::OffsetOfNode::OffsetOfNode", NM="_ZN5clang12OffsetOfNodeC1ENS_14SourceLocationEjS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp -nm=_ZN5clang12OffsetOfNodeC1ENS_14SourceLocationEjS1_")
  //</editor-fold>
  public OffsetOfNode(SourceLocation LBracketLoc, /*uint*/int Index, 
      SourceLocation RBracketLoc) {
    // : Range(LBracketLoc, RBracketLoc), Data((Index << 2) | Array) 
    //START JInit
    this.Range = new SourceRange(/*NO_COPY*/LBracketLoc, /*NO_COPY*/RBracketLoc);
    this.Data = Index;//(Index << 2) | 
    this.DataKind = Kind.Array;
    //END JInit
  }

  
  /// \brief Create an offsetof node that refers to a field.
  //<editor-fold defaultstate="collapsed" desc="clang::OffsetOfNode::OffsetOfNode">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 1809,
   FQN="clang::OffsetOfNode::OffsetOfNode", NM="_ZN5clang12OffsetOfNodeC1ENS_14SourceLocationEPNS_9FieldDeclES1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp -nm=_ZN5clang12OffsetOfNodeC1ENS_14SourceLocationEPNS_9FieldDeclES1_")
  //</editor-fold>
  public OffsetOfNode(SourceLocation DotLoc, FieldDecl /*P*/ Field, SourceLocation NameLoc) {
    // : Range(DotLoc.isValid() ? DotLoc : NameLoc, NameLoc), Data(reinterpret_cast<uintptr_t>(Field) | OffsetOfNode::Field) 
    //START JInit
    this.Range = new SourceRange(/*NO_COPY*/DotLoc.isValid() ? DotLoc : NameLoc, /*NO_COPY*/NameLoc);
    this.Data = Field;//reinterpret_cast_Object/*uintptr_t*/(Field) | 
    this.DataKind = OffsetOfNode.Kind.Field;
    //END JInit
  }

  
  /// \brief Create an offsetof node that refers to an identifier.
  //<editor-fold defaultstate="collapsed" desc="clang::OffsetOfNode::OffsetOfNode">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 1814,
   FQN="clang::OffsetOfNode::OffsetOfNode", NM="_ZN5clang12OffsetOfNodeC1ENS_14SourceLocationEPNS_14IdentifierInfoES1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp -nm=_ZN5clang12OffsetOfNodeC1ENS_14SourceLocationEPNS_14IdentifierInfoES1_")
  //</editor-fold>
  public OffsetOfNode(SourceLocation DotLoc, IdentifierInfo /*P*/ Name, 
      SourceLocation NameLoc) {
    // : Range(DotLoc.isValid() ? DotLoc : NameLoc, NameLoc), Data(reinterpret_cast<uintptr_t>(Name) | Identifier) 
    //START JInit
    this.Range = new SourceRange(/*NO_COPY*/DotLoc.isValid() ? DotLoc : NameLoc, /*NO_COPY*/NameLoc);
    this.Data = Name;//reinterpret_cast_Object/*uintptr_t*/(Name) | 
    this.DataKind = Kind.Identifier;
    //END JInit
  }

  
  /// \brief Create an offsetof node that refers into a C++ base class.
  //<editor-fold defaultstate="collapsed" desc="clang::OffsetOfNode::OffsetOfNode">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 1820,
   FQN="clang::OffsetOfNode::OffsetOfNode", NM="_ZN5clang12OffsetOfNodeC1EPKNS_16CXXBaseSpecifierE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp -nm=_ZN5clang12OffsetOfNodeC1EPKNS_16CXXBaseSpecifierE")
  //</editor-fold>
  public /*explicit*/ OffsetOfNode(/*const*/ CXXBaseSpecifier /*P*/ Base) {
    // : Range(), Data(reinterpret_cast<uintptr_t>(Base) | OffsetOfNode::Base) 
    //START JInit
    this.Range = new SourceRange();
    this.Data = Base;//reinterpret_cast_Object/*uintptr_t*/(Base) | 
    this.DataKind = OffsetOfNode.Kind.Base;
    //END JInit
  }

  
  /// \brief Determine what kind of offsetof node this is.
  //<editor-fold defaultstate="collapsed" desc="clang::OffsetOfNode::getKind">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 1824,
   FQN="clang::OffsetOfNode::getKind", NM="_ZNK5clang12OffsetOfNode7getKindEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp -nm=_ZNK5clang12OffsetOfNode7getKindEv")
  //</editor-fold>
  public /*Kind*//*uint*/int getKind() /*const*/ {
    return DataKind;//((/*static_cast*//*Kind*//*uint*/int)(Data & Mask));
  }

  
  /// \brief For an array element node, returns the index into the array
  /// of expressions.
  //<editor-fold defaultstate="collapsed" desc="clang::OffsetOfNode::getArrayExprIndex">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 1828,
   FQN="clang::OffsetOfNode::getArrayExprIndex", NM="_ZNK5clang12OffsetOfNode17getArrayExprIndexEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp -nm=_ZNK5clang12OffsetOfNode17getArrayExprIndexEv")
  //</editor-fold>
  public /*uint*/int getArrayExprIndex() /*const*/ {
    assert (getKind() == Kind.Array);
    return (Integer)Data;// >>> 2;
  }

  
  /// \brief For a field offsetof node, returns the field.
  //<editor-fold defaultstate="collapsed" desc="clang::OffsetOfNode::getField">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 1834,
   FQN="clang::OffsetOfNode::getField", NM="_ZNK5clang12OffsetOfNode8getFieldEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp -nm=_ZNK5clang12OffsetOfNode8getFieldEv")
  //</editor-fold>
  public FieldDecl /*P*/ getField() /*const*/ {
    assert (getKind() == Kind.Field);
    return (FieldDecl)Data;//reinterpret_cast(FieldDecl /*P*/ .class, Data & ~(Object/*uintptr_t*/)Mask);
  }

  
  /// \brief For a field or identifier offsetof node, returns the name of
  /// the field.
  
  /// \brief For a field or identifier offsetof node, returns the name of
  /// the field.
  //<editor-fold defaultstate="collapsed" desc="clang::OffsetOfNode::getFieldName">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp", line = 1356,
   FQN="clang::OffsetOfNode::getFieldName", NM="_ZNK5clang12OffsetOfNode12getFieldNameEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang12OffsetOfNode12getFieldNameEv")
  //</editor-fold>
  public IdentifierInfo /*P*/ getFieldName() /*const*/ {
    assert (getKind() == Kind.Field || getKind() == Kind.Identifier);
    if (getKind() == Kind.Field) {
      return getField().getIdentifier();
    }
    
    return(IdentifierInfo)Data;//reinterpret_cast(IdentifierInfo /*P*/ .class, Data & ~(Object/*uintptr_t*/)Mask);
  }


  
  /// \brief For a base class node, returns the base specifier.
  //<editor-fold defaultstate="collapsed" desc="clang::OffsetOfNode::getBase">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 1844,
   FQN="clang::OffsetOfNode::getBase", NM="_ZNK5clang12OffsetOfNode7getBaseEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp -nm=_ZNK5clang12OffsetOfNode7getBaseEv")
  //</editor-fold>
  public CXXBaseSpecifier /*P*/ getBase() /*const*/ {
    assert (getKind() == Kind.Base);
    return (CXXBaseSpecifier)Data;//reinterpret_cast(CXXBaseSpecifier /*P*/ .class, Data & ~(Object/*uintptr_t*/)Mask);
  }

  
  /// \brief Retrieve the source range that covers this offsetof node.
  ///
  /// For an array element node, the source range contains the locations of
  /// the square brackets. For a field or identifier node, the source range
  /// contains the location of the period (if there is one) and the
  /// identifier.
  //<editor-fold defaultstate="collapsed" desc="clang::OffsetOfNode::getSourceRange">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 1855,
   FQN="clang::OffsetOfNode::getSourceRange", NM="_ZNK5clang12OffsetOfNode14getSourceRangeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp -nm=_ZNK5clang12OffsetOfNode14getSourceRangeEv")
  //</editor-fold>
  public SourceRange getSourceRange() /*const*//* __attribute__((pure))*/ {
    return new SourceRange(Range);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OffsetOfNode::getLocStart">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 1856,
   FQN="clang::OffsetOfNode::getLocStart", NM="_ZNK5clang12OffsetOfNode11getLocStartEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp -nm=_ZNK5clang12OffsetOfNode11getLocStartEv")
  //</editor-fold>
  public SourceLocation getLocStart() /*const*//* __attribute__((pure))*/ {
    return Range.getBegin();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OffsetOfNode::getLocEnd">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 1857,
   FQN="clang::OffsetOfNode::getLocEnd", NM="_ZNK5clang12OffsetOfNode9getLocEndEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp -nm=_ZNK5clang12OffsetOfNode9getLocEndEv")
  //</editor-fold>
  public SourceLocation getLocEnd() /*const*//* __attribute__((pure))*/ {
    return Range.getEnd();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OffsetOfNode::operator=">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 1770,
   FQN="clang::OffsetOfNode::operator=", NM="_ZN5clang12OffsetOfNodeaSERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp -nm=_ZN5clang12OffsetOfNodeaSERKS0_")
  //</editor-fold>
  public /*inline*/ OffsetOfNode /*&*/ $assign(final /*const*/ OffsetOfNode /*&*/ $Prm0) {
    this.Range.$assign($Prm0.Range);
    this.Data = $Prm0.Data;
    this.DataKind = $Prm0.DataKind;
    return /*Deref*/this;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OffsetOfNode::OffsetOfNode">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 1770,
   FQN="clang::OffsetOfNode::OffsetOfNode", NM="_ZN5clang12OffsetOfNodeC1EOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp -nm=_ZN5clang12OffsetOfNodeC1EOS0_")
  //</editor-fold>
  public /*inline*/ OffsetOfNode(JD$Move _dparam, final OffsetOfNode /*&&*/$Prm0) {
    // : Range(static_cast<OffsetOfNode &&>().Range), Data(static_cast<OffsetOfNode &&>().Data) 
    //START JInit
    this.Range = new SourceRange(JD$Move.INSTANCE, $Prm0.Range);
    this.Data = $Prm0.Data;
    //END JInit
    this.DataKind = $Prm0.DataKind;
  }


  //<editor-fold defaultstate="collapsed" desc="clang::OffsetOfNode::OffsetOfNode">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 1770,
   FQN="clang::OffsetOfNode::OffsetOfNode", NM="_ZN5clang12OffsetOfNodeC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang12OffsetOfNodeC1ERKS0_")
  //</editor-fold>
  public /*inline*/ OffsetOfNode(final /*const*/ OffsetOfNode /*&*/ $Prm0) {
    // : Range(.Range), Data(.Data) 
    //START JInit
    this.Range = new SourceRange($Prm0.Range);
    this.Data = $Prm0.Data;
    //END JInit
    this.DataKind = $Prm0.DataKind;
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  public OffsetOfNode() {
    this.Range = new SourceRange();
  }
  
  private byte DataKind;

  @Override public OffsetOfNode clone() {
    return new OffsetOfNode(this);
  }
  
  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return "" + "Range=" + Range // NOI18N
              + ", Data=" + Data; // NOI18N
  }
}
