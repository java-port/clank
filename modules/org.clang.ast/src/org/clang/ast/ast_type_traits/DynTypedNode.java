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

package org.clang.ast.ast_type_traits;

import static org.clank.support.Native.$AddrOf;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.support.Casts.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.clang.basic.*;
import org.clang.ast.*;
import org.clang.ast.ast_type_traits.*;
import static org.clang.ast.ast_type_traits.DynTypedNode.*;
import static org.clang.ast.QualType.*;


/// \brief A dynamically typed AST node container.
///
/// Stores an AST node in a type safe way. This allows writing code that
/// works with different kinds of AST nodes, despite the fact that they don't
/// have a common base class.
///
/// Use \c create(Node) to create a \c DynTypedNode from an AST node,
/// and \c get<T>() to retrieve the node as type T if the types match.
///
/// See \c ASTNodeKind for which node base types are currently supported;
/// You can create DynTypedNodes for all nodes in the inheritance hierarchy of
/// the supported base types.
//<editor-fold defaultstate="collapsed" desc="clang::ast_type_traits::DynTypedNode">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ASTTypeTraits.h", line = 210,
 FQN="clang::ast_type_traits::DynTypedNode", NM="_ZN5clang15ast_type_traits12DynTypedNodeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZN5clang15ast_type_traits12DynTypedNodeE")
//</editor-fold>
public class DynTypedNode implements Native.NativeComparable<DynTypedNode> {
/*public:*/
  /// \brief Creates a \c DynTypedNode from \c Node.
  /*template <typename T> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="clang::ast_type_traits::DynTypedNode::create">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ASTTypeTraits.h", line = 214,
   FQN="clang::ast_type_traits::DynTypedNode::create", NM="Tpl__ZN5clang15ast_type_traits12DynTypedNode6createERKT_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=Tpl__ZN5clang15ast_type_traits12DynTypedNode6createERKT_")
  //</editor-fold>
//  public static </*typename*/ T> DynTypedNode create(final /*const*/ T /*&*/ Node) {
//    return BaseConverter.<T>create(Node);
//  }
    public static DynTypedNode create(final /*const*/ Decl /*&*/ Node) {
      return BaseConverterDerivedFromDecl.create(Node);
    }
    public static DynTypedNode create(final /*const*/ Stmt /*&*/ Node) {
      return BaseConverterDerivedFromStmt.create(Node);
    }
    public static DynTypedNode create(final /*const*/ Type /*&*/ Node) {
      return BaseConverterDerivedFromType.create(Node);
    }
    public static DynTypedNode create(final /*const*/ TypeLoc /*&*/ Node) {
      return BaseConverterTypeLocVoid.create(TypeLoc.class, Node);
    }
    public static DynTypedNode create(final /*const*/ NestedNameSpecifierLoc /*&*/ Node) {
      return BaseConverterNestedNameSpecifierLocVoid.create(NestedNameSpecifierLoc.class, Node);
    }
    public static DynTypedNode create(final /*const*/ NestedNameSpecifier /*&*/ Node) {
      return BaseConverterNestedNameSpecifierVoid.create(NestedNameSpecifier.class, Node);
    }
    public static DynTypedNode create(final /*const*/ CXXCtorInitializer /*&*/ Node) {
      return BaseConverterCXXCtorInitializerVoid.create(CXXCtorInitializer.class, Node);
    }
    public static DynTypedNode create(final /*const*/ QualType /*&*/ Node) {
      return BaseConverterQualTypeVoid.create(QualType.class, Node);
    }
    public static DynTypedNode create(final /*const*/ TemplateArgument /*&*/ Node) {
      return BaseConverterTemplateArgumentVoid.create(TemplateArgument.class, Node);
    }

  
  /// \brief Retrieve the stored node as type \c T.
  ///
  /// Returns NULL if the stored node does not have a type that is
  /// convertible to \c T.
  ///
  /// For types that have identity via their pointer in the AST
  /// (like \c Stmt, \c Decl, \c Type and \c NestedNameSpecifier) the returned
  /// pointer points to the referenced AST node.
  /// For other types (like \c QualType) the value is stored directly
  /// in the \c DynTypedNode, and the returned pointer points at
  /// the storage inside DynTypedNode. For those nodes, do not
  /// use the pointer outside the scope of the DynTypedNode.
  /*template <typename T> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="clang::ast_type_traits::DynTypedNode::get">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ASTTypeTraits.h", line = 231,
   FQN="clang::ast_type_traits::DynTypedNode::get", NM="Tpl__ZNK5clang15ast_type_traits12DynTypedNode3getEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=Tpl__ZNK5clang15ast_type_traits12DynTypedNode3getEv")
  //</editor-fold>
//    public </*typename*/ T> /*const*/ T /*P*/ get() /*const*/ {
//      return BaseConverter.<T>get(NodeKind, Storage.buffer);
//    }
    public /*const*/ Decl /*P*/ get$Decl() /*const*/ {
      return BaseConverterDerivedFromDecl.get(Decl.class, NodeKind, Storage.buffer);
    }
    public /*const*/ Stmt /*P*/ get$Stmt() /*const*/ {
      return BaseConverterDerivedFromStmt.get(Stmt.class, NodeKind, Storage.buffer);
    }
    public /*const*/ Type /*P*/ get$Type() /*const*/ {
      return BaseConverterDerivedFromType.get(Type.class, NodeKind, Storage.buffer);
    }
    public /*const*/ TypeLoc /*P*/ get$TypeLoc() /*const*/ {
      return BaseConverterTypeLocVoid.get(TypeLoc.class, NodeKind, Storage.buffer);
    }
    public /*const*/ NestedNameSpecifierLoc /*P*/ get$NestedNameSpecifierLoc() /*const*/ {
      return BaseConverterNestedNameSpecifierLocVoid.get(NestedNameSpecifierLoc.class, NodeKind, Storage.buffer);
    }
    public /*const*/ NestedNameSpecifier /*P*/ get$NestedNameSpecifier() /*const*/ {
      return BaseConverterNestedNameSpecifierVoid.get(NestedNameSpecifier.class, NodeKind, Storage.buffer);
    }
    public /*const*/ CXXCtorInitializer /*P*/ get$CXXCtorInitializer() /*const*/ {
      return BaseConverterCXXCtorInitializerVoid.get(CXXCtorInitializer.class, NodeKind, Storage.buffer);
    }
    public /*const*/ QualType /*P*/ get$QualType() /*const*/ {
      return BaseConverterQualTypeVoid.get(QualType.class, NodeKind, Storage.buffer);
    }
    public /*const*/ TemplateArgument /*P*/ get$TemplateArgument() /*const*/ {
      return BaseConverterTemplateArgumentVoid.get(TemplateArgument.class, NodeKind, Storage.buffer);
    }

  
  /// \brief Retrieve the stored node as type \c T.
  ///
  /// Similar to \c get(), but asserts that the type is what we are expecting.
  /*template <typename T> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="clang::ast_type_traits::DynTypedNode::getUnchecked">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ASTTypeTraits.h", line = 239,
   FQN="clang::ast_type_traits::DynTypedNode::getUnchecked", NM="Tpl__ZNK5clang15ast_type_traits12DynTypedNode12getUncheckedEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=Tpl__ZNK5clang15ast_type_traits12DynTypedNode12getUncheckedEv")
  //</editor-fold>
//  public </*typename*/ T> /*const*/ T /*&*/ getUnchecked() /*const*/ {
//    return BaseConverter.<T>getUnchecked(NodeKind, Storage.buffer);
//  }
    public /*const*/ Decl /*P*/ getUnchecked$Decl() /*const*/ {
      return BaseConverterDerivedFromDecl.getUnchecked(Decl.class, NodeKind, Storage.buffer);
    }
    public /*const*/ Stmt /*P*/ getUnchecked$Stmt() /*const*/ {
      return BaseConverterDerivedFromStmt.getUnchecked(Stmt.class, NodeKind, Storage.buffer);
    }
    public /*const*/ Type /*P*/ getUnchecked$Type() /*const*/ {
      return BaseConverterDerivedFromType.getUnchecked(Type.class, NodeKind, Storage.buffer);
    }
    public /*const*/ TypeLoc /*P*/ getUnchecked$TypeLoc() /*const*/ {
      return BaseConverterTypeLocVoid.getUnchecked(TypeLoc.class, NodeKind, Storage.buffer);
    }
    public /*const*/ NestedNameSpecifierLoc /*P*/ getUnchecked$NestedNameSpecifierLoc() /*const*/ {
      return BaseConverterNestedNameSpecifierLocVoid.getUnchecked(NestedNameSpecifierLoc.class, NodeKind, Storage.buffer);
    }
    public /*const*/ NestedNameSpecifier /*P*/ getUnchecked$NestedNameSpecifier() /*const*/ {
      return BaseConverterNestedNameSpecifierVoid.getUnchecked(NestedNameSpecifier.class, NodeKind, Storage.buffer);
    }
    public /*const*/ CXXCtorInitializer /*P*/ getUnchecked$CXXCtorInitializer() /*const*/ {
      return BaseConverterCXXCtorInitializerVoid.getUnchecked(CXXCtorInitializer.class, NodeKind, Storage.buffer);
    }
    public /*const*/ QualType /*P*/ getUnchecked$QualType() /*const*/ {
      return BaseConverterQualTypeVoid.get(QualType.class, NodeKind, Storage.buffer);
    }
    public /*const*/ TemplateArgument /*P*/ getUnchecked$TemplateArgument() /*const*/ {
      return BaseConverterTemplateArgumentVoid.getUnchecked(TemplateArgument.class, NodeKind, Storage.buffer);
    }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ast_type_traits::DynTypedNode::getNodeKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ASTTypeTraits.h", line = 243,
   FQN="clang::ast_type_traits::DynTypedNode::getNodeKind", NM="_ZNK5clang15ast_type_traits12DynTypedNode11getNodeKindEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZNK5clang15ast_type_traits12DynTypedNode11getNodeKindEv")
  //</editor-fold>
  public ASTNodeKind getNodeKind() /*const*/ {
    return new ASTNodeKind(NodeKind);
  }

  
  /// \brief Returns a pointer that identifies the stored AST node.
  ///
  /// Note that this is not supported by all AST nodes. For AST nodes
  /// that don't have a pointer-defined identity inside the AST, this
  /// method returns NULL.
  //<editor-fold defaultstate="collapsed" desc="clang::ast_type_traits::DynTypedNode::getMemoizationData">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ASTTypeTraits.h", line = 250,
   FQN="clang::ast_type_traits::DynTypedNode::getMemoizationData", NM="_ZNK5clang15ast_type_traits12DynTypedNode18getMemoizationDataEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZNK5clang15ast_type_traits12DynTypedNode18getMemoizationDataEv")
  //</editor-fold>
  public /*const*/Object/*void P*/ getMemoizationData() /*const*/ {
    return NodeKind.hasPointerIdentity() ? ((type$ptr<Object>/*void P const P*/ )reinterpret_cast(type$ptr.class, Storage.buffer)).$star() : null;
  }

  
  /// \brief Prints the node to the given output stream.
  
  /// \brief Prints the node to the given output stream.
  //<editor-fold defaultstate="collapsed" desc="clang::ast_type_traits::DynTypedNode::print">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTTypeTraits.cpp", line = 108,
   FQN="clang::ast_type_traits::DynTypedNode::print", NM="_ZNK5clang15ast_type_traits12DynTypedNode5printERN4llvm11raw_ostreamERKNS_14PrintingPolicyE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTTypeTraits.cpp -nm=_ZNK5clang15ast_type_traits12DynTypedNode5printERN4llvm11raw_ostreamERKNS_14PrintingPolicyE")
  //</editor-fold>
  public void print(final raw_ostream /*&*/ OS, 
       final /*const*/ PrintingPolicy /*&*/ PP) /*const*/ {
    {
      /*const*/TemplateArgument/*P*/ TA = $tryClone(this.get$TemplateArgument());
      if (Native.$bool(TA)) {
        TA.print(PP, OS);
      } else {
        /*const*/ NestedNameSpecifier /*P*/ NNS = this.get$NestedNameSpecifier();
        if ((NNS != null)) {
          NNS.print(OS, PP);
        } else {
          /*const*/ NestedNameSpecifierLoc /*P*/ NNSL = this.get$NestedNameSpecifierLoc();
          if ((NNSL != null)) {
            NNSL.getNestedNameSpecifier().print(OS, PP);
          } else {
            /*const*/QualType /*P*/ QT = $tryClone(this.get$QualType());
            if (Native.$bool(QT)) {
              QT.print(OS, PP);
            } else {
              /*const*/ TypeLoc /*P*/ TL = this.get$TypeLoc();
              if ((TL != null)) {
                TL.getType().print(OS, PP);
              } else {
                /*const*/ Decl /*P*/ D = this.get$Decl();
                if ((D != null)) {
                  D.print(OS, PP);
                } else {
                  /*const*/ Stmt /*P*/ S = this.get$Stmt();
                  if ((S != null)) {
                    S.printPretty(OS, (PrinterHelper /*P*/ )null, PP);
                  } else {
                    /*const*/ Type /*P*/ T = this.get$Type();
                    if ((T != null)) {
                      new QualType(T, 0).print(OS, PP);
                    } else {
                      OS.$out(/*KEEP_STR*/"Unable to print values of type ").$out(NodeKind.asStringRef()).$out(/*KEEP_STR*/$LF);
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
  }


  
  /// \brief Dumps the node to the given output stream.
  
  /// \brief Dumps the node to the given output stream.
  //<editor-fold defaultstate="collapsed" desc="clang::ast_type_traits::DynTypedNode::dump">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTTypeTraits.cpp", line = 130,
   FQN="clang::ast_type_traits::DynTypedNode::dump", NM="_ZNK5clang15ast_type_traits12DynTypedNode4dumpERN4llvm11raw_ostreamERNS_13SourceManagerE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTTypeTraits.cpp -nm=_ZNK5clang15ast_type_traits12DynTypedNode4dumpERN4llvm11raw_ostreamERNS_13SourceManagerE")
  //</editor-fold>
  public void dump(final raw_ostream /*&*/ OS, final SourceManager /*&*/ SM) /*const*/ {
    {
      /*const*/ Decl /*P*/ D = this.get$Decl();
      if ((D != null)) {
        D.dump(OS);
      } else {
        /*const*/ Stmt /*P*/ S = this.get$Stmt();
        if ((S != null)) {
          S.dump(OS, SM);
        } else {
          OS.$out(/*KEEP_STR*/"Unable to dump values of type ").$out(NodeKind.asStringRef()).$out(/*KEEP_STR*/$LF);
        }
      }
    }
  }


  
  /// \brief For nodes which represent textual entities in the source code,
  /// return their SourceRange.  For all other nodes, return SourceRange().
  
  /// \brief For nodes which represent textual entities in the source code,
  /// return their SourceRange.  For all other nodes, return SourceRange().
  //<editor-fold defaultstate="collapsed" desc="clang::ast_type_traits::DynTypedNode::getSourceRange">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTTypeTraits.cpp", line = 139,
   FQN="clang::ast_type_traits::DynTypedNode::getSourceRange", NM="_ZNK5clang15ast_type_traits12DynTypedNode14getSourceRangeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTTypeTraits.cpp -nm=_ZNK5clang15ast_type_traits12DynTypedNode14getSourceRangeEv")
  //</editor-fold>
  public SourceRange getSourceRange() /*const*/ {
    {
      /*const*/ CXXCtorInitializer /*P*/ CCI = this.get$CXXCtorInitializer();
      if ((CCI != null)) {
        return CCI.getSourceRange();
      }
    }
    {
      /*const*/ NestedNameSpecifierLoc /*P*/ NNSL = this.get$NestedNameSpecifierLoc();
      if ((NNSL != null)) {
        return NNSL.getSourceRange();
      }
    }
    {
      /*const*/ TypeLoc /*P*/ TL = this.get$TypeLoc();
      if ((TL != null)) {
        return TL.getSourceRange();
      }
    }
    {
      /*const*/ Decl /*P*/ D = this.get$Decl();
      if ((D != null)) {
        return D.getSourceRange();
      }
    }
    {
      /*const*/ Stmt /*P*/ S = this.get$Stmt();
      if ((S != null)) {
        return S.getSourceRange();
      }
    }
    return new SourceRange();
  }


  
  /// @{
  /// \brief Imposes an order on \c DynTypedNode.
  ///
  /// Supports comparison of nodes that support memoization.
  /// FIXME: Implement comparsion for other node types (currently
  /// only Stmt, Decl, Type and NestedNameSpecifier return memoization data).
  //<editor-fold defaultstate="collapsed" desc="clang::ast_type_traits::DynTypedNode::operator<">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ASTTypeTraits.h", line = 272,
   FQN="clang::ast_type_traits::DynTypedNode::operator<", NM="_ZNK5clang15ast_type_traits12DynTypedNodeltERKS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZNK5clang15ast_type_traits12DynTypedNodeltERKS1_")
  //</editor-fold>
  public boolean $less(final /*const*/ DynTypedNode /*&*/ Other) /*const*/ {
    if (!NodeKind.isSame(/*NO_COPY*/Other.NodeKind)) {
      return NodeKind.$less(Other.NodeKind);
    }
    if (ASTNodeKind.getFromNodeKind(QualType.class).isSame(/*NO_COPY*/NodeKind)) {
      return this.getUnchecked$QualType().$less(Other.getUnchecked$QualType());
    }
    if (ASTNodeKind.getFromNodeKind(TypeLoc.class).isSame(/*NO_COPY*/NodeKind)) {
      TypeLoc TLA = new TypeLoc(this.getUnchecked$TypeLoc());
      TypeLoc TLB = new TypeLoc(Other.getUnchecked$TypeLoc());
      return TLA.getType().$less(TLB.getType()) || (TLA.getType().equals(TLB.getType()) && TLA.getOpaqueData().$less(TLB.getOpaqueData()));
    }
    if (ASTNodeKind.getFromNodeKind(NestedNameSpecifierLoc.class).isSame(/*NO_COPY*/NodeKind)) {
      NestedNameSpecifierLoc NNSLA = new NestedNameSpecifierLoc(this.getUnchecked$NestedNameSpecifierLoc());
      NestedNameSpecifierLoc NNSLB = new NestedNameSpecifierLoc(Other.getUnchecked$NestedNameSpecifierLoc());
      return NNSLA.$less(NNSLB);
    }
    assert ((getMemoizationData() != null) && (Other.getMemoizationData() != null));
    return getMemoizationData().hashCode() < Other.getMemoizationData().hashCode(); //getMemoizationData().$less(Other.getMemoizationData());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ast_type_traits::DynTypedNode::operator==">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ASTTypeTraits.h", line = 302,
   FQN="clang::ast_type_traits::DynTypedNode::operator==", NM="_ZNK5clang15ast_type_traits12DynTypedNodeeqERKS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZNK5clang15ast_type_traits12DynTypedNodeeqERKS1_")
  //</editor-fold>
  public boolean $eq(final /*const*/ DynTypedNode /*&*/ Other) /*const*/ {
    // DynTypedNode::create() stores the exact kind of the node in NodeKind.
    // If they contain the same node, their NodeKind must be the same.
    if (!NodeKind.isSame(/*NO_COPY*/Other.NodeKind)) {
      return false;
    }
    
    // FIXME: Implement for other types.
    if (ASTNodeKind.getFromNodeKind(QualType.class).isSame(/*NO_COPY*/NodeKind)) {
      return $eq_QualType$C(this.getUnchecked$QualType(), Other.getUnchecked$QualType());
    }
    if (ASTNodeKind.getFromNodeKind(TypeLoc.class).isSame(/*NO_COPY*/NodeKind)) {
      return TypeLoc.$eq_TypeLoc$C(this.getUnchecked$TypeLoc(), Other.getUnchecked$TypeLoc());
    }
    if (ASTNodeKind.getFromNodeKind(NestedNameSpecifierLoc.class).isSame(/*NO_COPY*/NodeKind)) {
      return NestedNameSpecifierLoc.$eq_NestedNameSpecifierLoc(/*NO_COPY*/this.getUnchecked$NestedNameSpecifierLoc(), 
          /*NO_COPY*/Other.getUnchecked$NestedNameSpecifierLoc());
    }
    assert ((getMemoizationData() != null) && (Other.getMemoizationData() != null));
    return $eq_ptr(getMemoizationData(), Other.getMemoizationData());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ast_type_traits::DynTypedNode::operator!=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ASTTypeTraits.h", line = 322,
   FQN="clang::ast_type_traits::DynTypedNode::operator!=", NM="_ZNK5clang15ast_type_traits12DynTypedNodeneERKS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZNK5clang15ast_type_traits12DynTypedNodeneERKS1_")
  //</editor-fold>
  public boolean $noteq(final /*const*/ DynTypedNode /*&*/ Other) /*const*/ {
    return !$eq(Other);
  }

  /// @}
  
  /// \brief Hooks for using DynTypedNode as a key in a DenseMap.
  //<editor-fold defaultstate="collapsed" desc="clang::ast_type_traits::DynTypedNode::DenseMapInfo">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ASTTypeTraits.h", line = 328,
   FQN="clang::ast_type_traits::DynTypedNode::DenseMapInfo", NM="_ZN5clang15ast_type_traits12DynTypedNode12DenseMapInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZN5clang15ast_type_traits12DynTypedNode12DenseMapInfoE")
  //</editor-fold>
  public static class/*struct*/ DenseMapInfo extends DenseMapInfoBase<DynTypedNode> {
    //<editor-fold defaultstate="collapsed" desc="clang::ast_type_traits::DynTypedNode::DenseMapInfo::getEmptyKey">
    @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ASTTypeTraits.h", line = 329,
     FQN="clang::ast_type_traits::DynTypedNode::DenseMapInfo::getEmptyKey", NM="_ZN5clang15ast_type_traits12DynTypedNode12DenseMapInfo11getEmptyKeyEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZN5clang15ast_type_traits12DynTypedNode12DenseMapInfo11getEmptyKeyEv")
    //</editor-fold>
    private static /*inline*/ DynTypedNode createEmptyKey() {
      DynTypedNode Node/*J*/= new DynTypedNode();
      Node.NodeKind.$assignMove(ASTNodeKind.DenseMapInfo.$Info().getEmptyKey());
      return Node;
    }

    //<editor-fold defaultstate="collapsed" desc="clang::ast_type_traits::DynTypedNode::DenseMapInfo::getTombstoneKey">
    @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ASTTypeTraits.h", line = 334,
     FQN="clang::ast_type_traits::DynTypedNode::DenseMapInfo::getTombstoneKey", NM="_ZN5clang15ast_type_traits12DynTypedNode12DenseMapInfo15getTombstoneKeyEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZN5clang15ast_type_traits12DynTypedNode12DenseMapInfo15getTombstoneKeyEv")
    //</editor-fold>
    private static /*inline*/ DynTypedNode createTombstoneKey() {
      DynTypedNode Node/*J*/= new DynTypedNode();
      Node.NodeKind.$assignMove(ASTNodeKind.DenseMapInfo.$Info().getTombstoneKey());
      return Node;
    }

    //<editor-fold defaultstate="collapsed" desc="clang::ast_type_traits::DynTypedNode::DenseMapInfo::getHashValue">
    @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ASTTypeTraits.h", line = 339,
     FQN="clang::ast_type_traits::DynTypedNode::DenseMapInfo::getHashValue", NM="_ZN5clang15ast_type_traits12DynTypedNode12DenseMapInfo12getHashValueERKS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZN5clang15ast_type_traits12DynTypedNode12DenseMapInfo12getHashValueERKS1_")
    //</editor-fold>
    public /*uint*/int getHashValueImpl(final /*const*/ DynTypedNode /*&*/ Val) {
      // FIXME: Add hashing support for the remaining types.
      if (ASTNodeKind.getFromNodeKind(TypeLoc.class).isSame(/*NO_COPY*/Val.NodeKind)) {
        TypeLoc TL = new TypeLoc(Val.getUnchecked$TypeLoc());
        return HashingGlobals.hash_combine(TL.getType().getAsOpaquePtr(), 
            TL.getOpaqueData()).$uint();
      }
      if (ASTNodeKind.getFromNodeKind(NestedNameSpecifierLoc.class).isSame(/*NO_COPY*/Val.NodeKind)) {
        NestedNameSpecifierLoc NNSL = new NestedNameSpecifierLoc(Val.getUnchecked$NestedNameSpecifierLoc());
        return HashingGlobals.hash_combine(NNSL.getNestedNameSpecifier(), 
            NNSL.getOpaqueData()).$uint();
      }
      assert Native.$bool(Val.getMemoizationData());
      return HashingGlobals.hash_value(Val.getMemoizationData()).$uint();
    }

    //<editor-fold defaultstate="collapsed" desc="clang::ast_type_traits::DynTypedNode::DenseMapInfo::isEqual">
    @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ASTTypeTraits.h", line = 357,
     FQN="clang::ast_type_traits::DynTypedNode::DenseMapInfo::isEqual", NM="_ZN5clang15ast_type_traits12DynTypedNode12DenseMapInfo7isEqualERKS1_S4_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZN5clang15ast_type_traits12DynTypedNode12DenseMapInfo7isEqualERKS1_S4_")
    //</editor-fold>
    public boolean isEqualImpl(final /*const*/ DynTypedNode /*&*/ LHS, final /*const*/ DynTypedNode /*&*/ RHS) {
      ASTNodeKind Empty = ASTNodeKind.DenseMapInfo.$Info().getEmptyKey();
      ASTNodeKind TombStone = ASTNodeKind.DenseMapInfo.$Info().getTombstoneKey();
      return (ASTNodeKind.DenseMapInfo.$Info().isEqual(LHS.NodeKind, Empty)
         && ASTNodeKind.DenseMapInfo.$Info().isEqual(RHS.NodeKind, Empty))
         || (ASTNodeKind.DenseMapInfo.$Info().isEqual(LHS.NodeKind, TombStone)
         && ASTNodeKind.DenseMapInfo.$Info().isEqual(RHS.NodeKind, TombStone))
         || LHS.$eq(RHS);
    }

    //////////////////////////////////////////////////////////////
    // EXTRA MEMBERS: BEGIN

    protected DenseMapInfo() {super(createEmptyKey(), createTombstoneKey());}

    @Override public boolean isKeyPointerLike() {return false;}

    private static final DenseMapInfo $INFO = new DenseMapInfo();

    public static DenseMapInfo $Info() {return $INFO;}

    // EXTRA MEMBERS: END
    //////////////////////////////////////////////////////////////

    
    @Override public String toString() {
      return ""; // NOI18N
    }
  };
/*private:*/
  
  /// \brief Converter that uses dyn_cast<T> from a stored BaseT*.
  /*template <typename T, typename BaseT> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="clang::ast_type_traits::DynTypedNode::DynCastPtrConverter">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ASTTypeTraits.h", line = 373,
   FQN="clang::ast_type_traits::DynTypedNode::DynCastPtrConverter", NM="_ZN5clang15ast_type_traits12DynTypedNode19DynCastPtrConverterE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZN5clang15ast_type_traits12DynTypedNode19DynCastPtrConverterE")
  //</editor-fold>
  public static class/*struct*/ DynCastPtrConverter</*typename*/ T, /*typename*/ BaseT>  {
    //<editor-fold defaultstate="collapsed" desc="clang::ast_type_traits::DynTypedNode::DynCastPtrConverter::get">
    @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ASTTypeTraits.h", line = 374,
     FQN="clang::ast_type_traits::DynTypedNode::DynCastPtrConverter::get", NM="_ZN5clang15ast_type_traits12DynTypedNode19DynCastPtrConverter3getENS0_11ASTNodeKindEPKc",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZN5clang15ast_type_traits12DynTypedNode19DynCastPtrConverter3getENS0_11ASTNodeKindEPKc")
    //</editor-fold>
    public static </*typename*/ T, /*typename*/ BaseT> /*const*/ T /*P*/ get(Class<T> classT, ASTNodeKind NodeKind, /*const*//*char*/Object Storage) {
      if (ASTNodeKind.<T>getFromNodeKind(classT).isBaseOf(NodeKind)) {
        return Native.$addr(getUnchecked(classT, NodeKind, Storage));
      }
      return null;
    }

    //<editor-fold defaultstate="collapsed" desc="clang::ast_type_traits::DynTypedNode::DynCastPtrConverter::getUnchecked">
    @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ASTTypeTraits.h", line = 379,
     FQN="clang::ast_type_traits::DynTypedNode::DynCastPtrConverter::getUnchecked", NM="_ZN5clang15ast_type_traits12DynTypedNode19DynCastPtrConverter12getUncheckedENS0_11ASTNodeKindEPKc",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZN5clang15ast_type_traits12DynTypedNode19DynCastPtrConverter12getUncheckedENS0_11ASTNodeKindEPKc")
    //</editor-fold>
    public static </*typename*/ T, /*typename*/ BaseT> /*const*/ T /*&*/ getUnchecked(Class<T> classT, ASTNodeKind NodeKind, /*const*//*char*/Object Storage) {
      assert Native.$bool(ASTNodeKind.<T>getFromNodeKind(classT).isBaseOf(NodeKind));
      return (T)Storage;//Native.$star(cast<T>(((/*static_cast*//*const*/ BaseT /*P*/ )(((/*const*/type$ptr<Object>/*void P const P*/ )reinterpret_cast(/*const*/type$ptr.class, Storage)).$star()))));
    }

    //<editor-fold defaultstate="collapsed" desc="clang::ast_type_traits::DynTypedNode::DynCastPtrConverter::create">
    @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ASTTypeTraits.h", line = 384,
     FQN="clang::ast_type_traits::DynTypedNode::DynCastPtrConverter::create", NM="_ZN5clang15ast_type_traits12DynTypedNode19DynCastPtrConverter6createERKT0_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZN5clang15ast_type_traits12DynTypedNode19DynCastPtrConverter6createERKT0_")
    //</editor-fold>
//    public static </*typename*/ T, /*typename*/ BaseT> DynTypedNode create(final /*const*/ BaseT /*&*/ Node) {
//      DynTypedNode Result/*J*/= new DynTypedNode();
//      Result.NodeKind = ASTNodeKind.getFromNode(Node);
//      /*NEW_EXPR [System]*/Result.Storage.buffer = /*new (Result.Storage.buffer)*/ $new_uint_voidPtr(Result.Storage.buffer, (type$ptr<?> New$Mem)->{
//          return ( Native.$addr(Node) );
//       });
//      return Result;
//    }
    public static DynTypedNode create(final /*const*/ Decl /*&*/ Node) {
      DynTypedNode Result/*J*/= new DynTypedNode();
      Result.NodeKind.$assignMove(ASTNodeKind.getFromNode(Node));
      /*NEW_EXPR [System]*/Result.Storage.buffer = /*new (Result.Storage.buffer)*/ $new_uint_voidPtr(Result.Storage.buffer, (type$ptr<?> New$Mem)->{
          return $AddrOf(Node);
       });
      return Result;
    }
    public static DynTypedNode create(final /*const*/ Stmt /*&*/ Node) {
      DynTypedNode Result/*J*/= new DynTypedNode();
      Result.NodeKind.$assignMove(ASTNodeKind.getFromNode(Node));
      /*NEW_EXPR [System]*/Result.Storage.buffer = /*new (Result.Storage.buffer)*/ $new_uint_voidPtr(Result.Storage.buffer, (type$ptr<?> New$Mem)->{
          return $AddrOf(Node);
       });
      return Result;
    }
    public static DynTypedNode create(final /*const*/ Type /*&*/ Node) {
      DynTypedNode Result/*J*/= new DynTypedNode();
      Result.NodeKind.$assignMove(ASTNodeKind.getFromNode(Node));
      /*NEW_EXPR [System]*/Result.Storage.buffer = /*new (Result.Storage.buffer)*/ $new_uint_voidPtr(Result.Storage.buffer, (type$ptr<?> New$Mem)->{
          return $AddrOf(Node);
       });
      return Result;
    }
    

    @Override public String toString() {
      return ""; // NOI18N
    }
  };
  
  /// \brief Converter that stores T* (by pointer).
  /*template <typename T> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="clang::ast_type_traits::DynTypedNode::PtrConverter">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ASTTypeTraits.h", line = 393,
   FQN="clang::ast_type_traits::DynTypedNode::PtrConverter", NM="_ZN5clang15ast_type_traits12DynTypedNode12PtrConverterE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZN5clang15ast_type_traits12DynTypedNode12PtrConverterE")
  //</editor-fold>
  public static class/*struct*/ PtrConverter</*typename*/ T>  {
    //<editor-fold defaultstate="collapsed" desc="clang::ast_type_traits::DynTypedNode::PtrConverter::get">
    @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ASTTypeTraits.h", line = 394,
     FQN="clang::ast_type_traits::DynTypedNode::PtrConverter::get", NM="_ZN5clang15ast_type_traits12DynTypedNode12PtrConverter3getENS0_11ASTNodeKindEPKc",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZN5clang15ast_type_traits12DynTypedNode12PtrConverter3getENS0_11ASTNodeKindEPKc")
    //</editor-fold>
    public static </*typename*/ T> /*const*/ T /*P*/ get(Class<T> clazz, ASTNodeKind NodeKind, /*const*//*char*/Object Storage) {
      if (ASTNodeKind.<T>getFromNodeKind(clazz).isSame(NodeKind)) {
        return Native.$addr(getUnchecked(clazz, NodeKind, Storage));
      }
      return null;
    }

    //<editor-fold defaultstate="collapsed" desc="clang::ast_type_traits::DynTypedNode::PtrConverter::getUnchecked">
    @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ASTTypeTraits.h", line = 399,
     FQN="clang::ast_type_traits::DynTypedNode::PtrConverter::getUnchecked", NM="_ZN5clang15ast_type_traits12DynTypedNode12PtrConverter12getUncheckedENS0_11ASTNodeKindEPKc",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZN5clang15ast_type_traits12DynTypedNode12PtrConverter12getUncheckedENS0_11ASTNodeKindEPKc")
    //</editor-fold>
    public static </*typename*/ T> /*const*/ T /*&*/ getUnchecked(Class<T> clazz, ASTNodeKind NodeKind, /*const*//*char*/Object Storage) {
      assert Native.$bool(ASTNodeKind.<T>getFromNodeKind(clazz).isSame(NodeKind));
      return Native.$star(((/*static_cast*//*const*/ T /*P*/ )(((/*const*/type$ptr<Object>/*void P const P*/ )reinterpret_cast(/*const*/type$ptr.class, Storage)).$star())));
    }

    //<editor-fold defaultstate="collapsed" desc="clang::ast_type_traits::DynTypedNode::PtrConverter::create">
    @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ASTTypeTraits.h", line = 404,
     FQN="clang::ast_type_traits::DynTypedNode::PtrConverter::create", NM="_ZN5clang15ast_type_traits12DynTypedNode12PtrConverter6createERKT_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZN5clang15ast_type_traits12DynTypedNode12PtrConverter6createERKT_")
    //</editor-fold>
    public static </*typename*/ T> DynTypedNode create(Class<T> clazz, final /*const*/ T /*&*/ Node) {
      DynTypedNode Result/*J*/= new DynTypedNode();
      Result.NodeKind = ASTNodeKind.<T>getFromNodeKind(clazz);
      /*NEW_EXPR [System]*/Result.Storage.buffer = /*new (Result.Storage.buffer)*/ $new_uint_voidPtr(Result.Storage.buffer, (type$ptr<?> New$Mem)->{
          return ( Native.$addr(Node) );
       });
      return Result;
    }

    
    @Override public String toString() {
      return ""; // NOI18N
    }
  };
  
  /// \brief Converter that stores T (by value).
  /*template <typename T> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="clang::ast_type_traits::DynTypedNode::ValueConverter">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ASTTypeTraits.h", line = 413,
   FQN="clang::ast_type_traits::DynTypedNode::ValueConverter", NM="_ZN5clang15ast_type_traits12DynTypedNode14ValueConverterE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZN5clang15ast_type_traits12DynTypedNode14ValueConverterE")
  //</editor-fold>
  public static class/*struct*/ ValueConverter</*typename*/ T>  {
    //<editor-fold defaultstate="collapsed" desc="clang::ast_type_traits::DynTypedNode::ValueConverter::get">
    @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ASTTypeTraits.h", line = 414,
     FQN="clang::ast_type_traits::DynTypedNode::ValueConverter::get", NM="_ZN5clang15ast_type_traits12DynTypedNode14ValueConverter3getENS0_11ASTNodeKindEPKc",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZN5clang15ast_type_traits12DynTypedNode14ValueConverter3getENS0_11ASTNodeKindEPKc")
    //</editor-fold>
    public static </*typename*/ T> /*const*/ T /*P*/ get(Class<T> clazz, ASTNodeKind NodeKind, /*const*//*char*/Object Storage) {
      if (ASTNodeKind.<T>getFromNodeKind(clazz).isSame(NodeKind)) {
        return (T)Storage;//reinterpret_cast(/*const*/ T /*P*/ .class, Storage);
      }
      return null;
    }

    //<editor-fold defaultstate="collapsed" desc="clang::ast_type_traits::DynTypedNode::ValueConverter::getUnchecked">
    @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ASTTypeTraits.h", line = 419,
     FQN="clang::ast_type_traits::DynTypedNode::ValueConverter::getUnchecked", NM="_ZN5clang15ast_type_traits12DynTypedNode14ValueConverter12getUncheckedENS0_11ASTNodeKindEPKc",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZN5clang15ast_type_traits12DynTypedNode14ValueConverter12getUncheckedENS0_11ASTNodeKindEPKc")
    //</editor-fold>
    public static </*typename*/ T> /*const*/ T /*&*/ getUnchecked(Class<T> clazz, ASTNodeKind NodeKind, /*const*//*char*/Object Storage) {
      assert Native.$bool(ASTNodeKind.<T>getFromNodeKind(clazz).isSame(NodeKind));
      return (T)Storage;//Native.$star(reinterpret_cast(/*const*/ T /*P*/ .class, Storage));
    }

    //<editor-fold defaultstate="collapsed" desc="clang::ast_type_traits::DynTypedNode::ValueConverter::create">
    @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ASTTypeTraits.h", line = 423,
     FQN="clang::ast_type_traits::DynTypedNode::ValueConverter::create", NM="_ZN5clang15ast_type_traits12DynTypedNode14ValueConverter6createERKT_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZN5clang15ast_type_traits12DynTypedNode14ValueConverter6createERKT_")
    //</editor-fold>
    public static </*typename*/ T> DynTypedNode create(Class<T> clazz, final /*const*/ T /*&*/ Node) {
      DynTypedNode Result/*J*/= new DynTypedNode();
      Result.NodeKind = ASTNodeKind.<T>getFromNodeKind(clazz);
      ///*FIXME: NEW_EXPR [NoNewFun]*/Result.Storage.buffer = /*new (Result.Storage.buffer)*/ new T(( Node ));
      //try {
      //  Constructor<T> constructor = clazz.getConstructor(clazz);
      //  Result.Storage.buffer = constructor.newInstance(Node);
      //} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException | SecurityException ex) {
      //  Logger.getLogger(DynTypedNode.class.getName()).log(Level.SEVERE, null, ex);
      //}
      if (TypeLoc.class.equals(clazz)) {
        Result.Storage.buffer = new TypeLoc((TypeLoc)Node);
      } else if (NestedNameSpecifierLoc.class.equals(clazz)) {
        Result.Storage.buffer = new NestedNameSpecifierLoc((NestedNameSpecifierLoc)Node);
      } else if (QualType.class.equals(clazz)) {
        Result.Storage.buffer = new QualType((QualType)Node);
      } else if (TemplateArgument.class.equals(clazz)) {
        Result.Storage.buffer = new TemplateArgument((TemplateArgument)Node);
      } else {
        throw new UnsupportedOperationException("Unsuported class "+clazz.getName());
      }
      return Result;
    }

    
    @Override public String toString() {
      return ""; // NOI18N
    }
  };
  
  private ASTNodeKind NodeKind;
  
  /// \brief Stores the data of the node.
  ///
  /// Note that we can store \c Decls, \c Stmts, \c Types,
  /// \c NestedNameSpecifiers and \c CXXCtorInitializer by pointer as they are
  /// guaranteed to be unique pointers pointing to dedicated storage in the AST.
  /// \c QualTypes, \c NestedNameSpecifierLocs, \c TypeLocs and
  /// \c TemplateArguments on the other hand do not have storage or unique
  /// pointers and thus need to be stored by value.
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC)
  private DataType Storage;
  //<editor-fold defaultstate="collapsed" desc="clang::ast_type_traits::DynTypedNode::DynTypedNode">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ASTTypeTraits.h", line = 210,
   FQN="clang::ast_type_traits::DynTypedNode::DynTypedNode", NM="_ZN5clang15ast_type_traits12DynTypedNodeC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZN5clang15ast_type_traits12DynTypedNodeC1Ev")
  //</editor-fold>
  public /*inline*/ DynTypedNode() {
    // : NodeKind(), Storage() 
    //START JInit
    this.NodeKind = new ASTNodeKind();
    this.Storage = new DataType();
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ast_type_traits::DynTypedNode::DynTypedNode">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ASTTypeTraits.h", line = 210,
   FQN="clang::ast_type_traits::DynTypedNode::DynTypedNode", NM="_ZN5clang15ast_type_traits12DynTypedNodeC1ERKS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZN5clang15ast_type_traits12DynTypedNodeC1ERKS1_")
  //</editor-fold>
  public /*inline*/ DynTypedNode(final /*const*/ DynTypedNode /*&*/ $Prm0) {
    // : NodeKind(.NodeKind), Storage(.Storage) 
    //START JInit
    this.NodeKind = new ASTNodeKind($Prm0.NodeKind);
    this.Storage = new DataType($Prm0.Storage);
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ast_type_traits::DynTypedNode::DynTypedNode">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ASTTypeTraits.h", line = 210,
   FQN="clang::ast_type_traits::DynTypedNode::DynTypedNode", NM="_ZN5clang15ast_type_traits12DynTypedNodeC1EOS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZN5clang15ast_type_traits12DynTypedNodeC1EOS1_")
  //</editor-fold>
  public /*inline*/ DynTypedNode(JD$Move _dparam, final DynTypedNode /*&&*/$Prm0) {
    // : NodeKind(static_cast<DynTypedNode &&>().NodeKind), Storage(static_cast<DynTypedNode &&>().Storage) 
    //START JInit
    this.NodeKind = new ASTNodeKind(JD$Move.INSTANCE, $Prm0.NodeKind);
    this.Storage = new DataType(JD$Move.INSTANCE, $Prm0.Storage);
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ast_type_traits::DynTypedNode::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ASTTypeTraits.h", line = 210,
   FQN="clang::ast_type_traits::DynTypedNode::operator=", NM="_ZN5clang15ast_type_traits12DynTypedNodeaSERKS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZN5clang15ast_type_traits12DynTypedNodeaSERKS1_")
  //</editor-fold>
  public /*inline*/ DynTypedNode /*&*/ $assign(final /*const*/ DynTypedNode /*&*/ $Prm0) {
    this.NodeKind.$assign($Prm0.NodeKind);
    this.Storage.$assign($Prm0.Storage);
    return /*Deref*/this;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ast_type_traits::DynTypedNode::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ASTTypeTraits.h", line = 210,
   FQN="clang::ast_type_traits::DynTypedNode::operator=", NM="_ZN5clang15ast_type_traits12DynTypedNodeaSEOS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZN5clang15ast_type_traits12DynTypedNodeaSEOS1_")
  //</editor-fold>
  public /*inline*/ DynTypedNode /*&*/ $assignMove(final DynTypedNode /*&&*/$Prm0) {
    this.NodeKind.$assignMove($Prm0.NodeKind);
    this.Storage.$assignMove($Prm0.Storage);
    return /*Deref*/this;
  }

  @Converted(kind = Converted.Kind.MANUAL_ADDED)
  public static final class DataType extends AlignedCharArrayUnion5</*const*/Object/*void P*/ , TemplateArgument, NestedNameSpecifierLoc, QualType, TypeLoc> {
    private DataType() {
    }

    public DataType(Object buffer) {
      this.buffer = buffer;
    }

    private DataType(JD$Move INSTANCE, DataType Storage) {
      this.buffer = Storage.buffer;
    }

    private void $assign(DataType Storage) {
      this.buffer = Storage.buffer;
    }

    private void $assignMove(DataType Storage) {
      this.buffer = Storage.buffer;
    }
  }

  @Override public String toString() {
    return "" + "NodeKind=" + NodeKind // NOI18N
              + ", Storage=" + Storage; // NOI18N
  }
}
