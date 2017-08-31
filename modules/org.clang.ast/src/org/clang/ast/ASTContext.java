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

import static org.clank.support.Native.$Deref;
import static org.clank.support.Native.$AddrOf;
import java.util.function.Supplier;
import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.support.Casts.*;
import static org.clank.java.std.*;
import static org.llvm.adt.ADTAliases.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.NativeType.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.clank.support.NativeCallback.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.basic.*;
import org.clang.lex.*;
import org.clang.ast.aliases.*;
import org.clang.ast.impl.*;
import org.clang.ast.comments.*;
import org.clang.ast.ast_type_traits.*;
import org.clang.ast.llvm.*;
import static org.clang.ast.ASTContextGlobals.*;
import static org.clang.ast.java.AstDeclarationsRTTI.*;
import static org.clang.ast.java.AstTypesRTTI.*;
import static org.clang.ast.AstClangGlobals.*;
import static org.clang.ast.CharUnitsGlobals.*;
import static org.clang.ast.QualType.*;
import static org.clang.ast.java.AstSizeofAndAlignment.*;
import static org.clang.ast.impl.ASTContextStatics.*;
import static org.clang.ast.impl.AstClangStatics.*;
import org.clang.basic.target.TargetInfo;
import static org.clang.ast.impl.RecordLayoutBuilderStatics.*;
import static org.clang.ast.java.AstExpressionsRTTI.cast_Expr;
import static org.clang.ast.java.AstExpressionsRTTI.isa_GNUNullExpr;


/// \brief Holds long-lived AST nodes (such as types and decls) that can be
/// referred to throughout the semantic analysis of a file.
//<editor-fold defaultstate="collapsed" desc="clang::ASTContext">
@Converted(kind = Converted.Kind.MANUAL,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ASTContext.h", line = 92,
 FQN="clang::ASTContext", NM="_ZN5clang10ASTContextE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZN5clang10ASTContextE")
//</editor-fold>
public class ASTContext extends /*public*/ RefCountedBase<ASTContext> implements NativeMemory.Allocator, Destructors.ClassWithDestructor {
  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::this_">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ASTContext.h", line = 93,
   FQN="clang::ASTContext::this_", NM="_ZN5clang10ASTContext5this_Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZN5clang10ASTContext5this_Ev")
  //</editor-fold>
  private ASTContext /*&*/ this_() {
    return /*Deref*/this;
  }

  
  private /*mutable */SmallVector<Type /*P*/ > Types;
  private /*mutable */FoldingSet<ExtQuals> ExtQualNodes;
  private /*mutable */FoldingSet<ComplexType> ComplexTypes;
  private /*mutable */FoldingSet<PointerType> PointerTypes;
  private /*mutable */FoldingSet<AdjustedType> AdjustedTypes;
  private /*mutable */FoldingSet<BlockPointerType> BlockPointerTypes;
  private /*mutable */FoldingSet<LValueReferenceType> LValueReferenceTypes;
  private /*mutable */FoldingSet<RValueReferenceType> RValueReferenceTypes;
  private /*mutable */FoldingSet<MemberPointerType> MemberPointerTypes;
  private /*mutable */FoldingSet<ConstantArrayType> ConstantArrayTypes;
  private /*mutable */FoldingSet<IncompleteArrayType> IncompleteArrayTypes;
  private /*mutable */std.vector<VariableArrayType /*P*/ > VariableArrayTypes;
  private /*mutable */FoldingSet<DependentSizedArrayType> DependentSizedArrayTypes;
  private /*mutable */FoldingSet<DependentSizedExtVectorType> DependentSizedExtVectorTypes;
  private /*mutable */FoldingSet<VectorType> VectorTypes;
  private /*mutable */FoldingSet<FunctionNoProtoType> FunctionNoProtoTypes;
  private /*mutable */ContextualFoldingSet<FunctionProtoType, ASTContext /*&*/ > FunctionProtoTypes;
  private /*mutable */FoldingSet<DependentTypeOfExprType> DependentTypeOfExprTypes;
  private /*mutable */FoldingSet<DependentDecltypeType> DependentDecltypeTypes;
  private /*mutable */FoldingSet<TemplateTypeParmType> TemplateTypeParmTypes;
  private /*mutable */FoldingSet<SubstTemplateTypeParmType> SubstTemplateTypeParmTypes;
  private /*mutable */FoldingSet<SubstTemplateTypeParmPackType> SubstTemplateTypeParmPackTypes;
  private /*mutable */ContextualFoldingSet<TemplateSpecializationType, ASTContext /*&*/ > TemplateSpecializationTypes;
  private /*mutable */FoldingSet<ParenType> ParenTypes;
  private /*mutable */FoldingSet<ElaboratedType> ElaboratedTypes;
  private /*mutable */FoldingSet<DependentNameType> DependentNameTypes;
  private /*mutable */ContextualFoldingSet<DependentTemplateSpecializationType, ASTContext /*&*/ > DependentTemplateSpecializationTypes;
  private FoldingSet<PackExpansionType> PackExpansionTypes;
  private /*mutable */FoldingSet<ObjCObjectTypeImpl> ObjCObjectTypes;
  private /*mutable */FoldingSet<ObjCObjectPointerType> ObjCObjectPointerTypes;
  private /*mutable */FoldingSet<DependentUnaryTransformType> DependentUnaryTransformTypes;
  private /*mutable */FoldingSet<AutoType> AutoTypes;
  private /*mutable */FoldingSet<AtomicType> AtomicTypes;
  private FoldingSet<AttributedType> AttributedTypes;
  private /*mutable */FoldingSet<PipeType> PipeTypes;
  
  private /*mutable */FoldingSet<QualifiedTemplateName> QualifiedTemplateNames;
  private /*mutable */FoldingSet<DependentTemplateName> DependentTemplateNames;
  private /*mutable */FoldingSet<SubstTemplateTemplateParmStorage> SubstTemplateTemplateParms;
  private /*mutable */ContextualFoldingSet<SubstTemplateTemplateParmPackStorage, ASTContext /*&*/ > SubstTemplateTemplateParmPacks;
  
  /// \brief The set of nested name specifiers.
  ///
  /// This set is managed by the NestedNameSpecifier class.
  /*friend*/protected/*private*/ /*mutable */FoldingSet<NestedNameSpecifier> NestedNameSpecifiers;
  /*friend*/protected/*private*/ /*mutable */NestedNameSpecifier /*P*/ GlobalNestedNameSpecifier;
  /*friend  class NestedNameSpecifier*/
  
  /// \brief A cache mapping from RecordDecls to ASTRecordLayouts.
  ///
  /// This is lazily created.  This is intentionally not serialized.
  private /*mutable */DenseMap</*const*/ RecordDecl /*P*/ , /*const*/ ASTRecordLayout /*P*/ > ASTRecordLayouts;
  private /*mutable */DenseMap</*const*/ ObjCContainerDecl /*P*/ , /*const*/ ASTRecordLayout /*P*/ > ObjCLayouts;
  
  /// \brief A cache from types to size and alignment information.
  /*typedef llvm::DenseMap<const Type *, struct TypeInfo> TypeInfoMap*/
//  public final class TypeInfoMap extends DenseMap</*const*/ Type /*P*/ ,  TypeInfo>{ };
  private /*mutable */DenseMap</*const*/ Type /*P*/ ,  TypeInfo> MemoizedTypeInfo;
  
  /// \brief A cache mapping from CXXRecordDecls to key functions.
  /*friend*/public DenseMap</*const*/ CXXRecordDecl /*P*/ , LazyDeclPtr> KeyFunctions;
  
  /// \brief Mapping from ObjCContainers to their ObjCImplementations.
  private DenseMap<ObjCContainerDecl /*P*/ , ObjCImplDecl /*P*/ > ObjCImpls;
  
  /// \brief Mapping from ObjCMethod to its duplicate declaration in the same
  /// interface.
  private DenseMap</*const*/ ObjCMethodDecl /*P*/ , /*const*/ ObjCMethodDecl /*P*/ > ObjCMethodRedecls;
  
  /// \brief Mapping from __block VarDecls to their copy initialization expr.
  private DenseMap</*const*/ VarDecl /*P*/ , Expr /*P*/ > BlockVarCopyInits;
  
  /// \brief Mapping from class scope functions specialization to their
  /// template patterns.
  private DenseMap</*const*/ FunctionDecl /*P*/ , FunctionDecl /*P*/ > ClassScopeSpecializationPattern;
  
  /// \brief Mapping from materialized temporaries with static storage duration
  /// that appear in constant initializers to their evaluated values.  These are
  /// allocated in a std::map because their address must be stable.
  private DenseMap</*const*/ MaterializeTemporaryExpr /*P*/ , APValue /*P*/ > MaterializedTemporaryValues;
  
  /// \brief Representation of a "canonical" template template parameter that
  /// is used in canonical template names.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::CanonicalTemplateTemplateParm">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ASTContext.h", line = 192,
   FQN="clang::ASTContext::CanonicalTemplateTemplateParm", NM="_ZN5clang10ASTContext29CanonicalTemplateTemplateParmE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZN5clang10ASTContext29CanonicalTemplateTemplateParmE")
  //</editor-fold>
  private static class CanonicalTemplateTemplateParm extends FoldingSetImpl.NodeImpl implements /*public*/ FoldingSetImpl.Node {
    private TemplateTemplateParmDecl /*P*/ Parm;
  /*public:*/
    //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::CanonicalTemplateTemplateParm::CanonicalTemplateTemplateParm">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ASTContext.h", line = 196,
     FQN="clang::ASTContext::CanonicalTemplateTemplateParm::CanonicalTemplateTemplateParm", NM="_ZN5clang10ASTContext29CanonicalTemplateTemplateParmC1EPNS_24TemplateTemplateParmDeclE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZN5clang10ASTContext29CanonicalTemplateTemplateParmC1EPNS_24TemplateTemplateParmDeclE")
    //</editor-fold>
    public CanonicalTemplateTemplateParm(TemplateTemplateParmDecl /*P*/ Parm) {
      // : FoldingSetNode(), Parm(Parm) 
      //START JInit
      $Node();
      this.Parm = Parm;
      //END JInit
    }

    
    //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::CanonicalTemplateTemplateParm::getParam">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ASTContext.h", line = 199,
     FQN="clang::ASTContext::CanonicalTemplateTemplateParm::getParam", NM="_ZNK5clang10ASTContext29CanonicalTemplateTemplateParm8getParamEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZNK5clang10ASTContext29CanonicalTemplateTemplateParm8getParamEv")
    //</editor-fold>
    public TemplateTemplateParmDecl /*P*/ getParam() /*const*/ {
      return Parm;
    }

    
    //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::CanonicalTemplateTemplateParm::Profile">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ASTContext.h", line = 201,
     FQN="clang::ASTContext::CanonicalTemplateTemplateParm::Profile", NM="_ZN5clang10ASTContext29CanonicalTemplateTemplateParm7ProfileERN4llvm16FoldingSetNodeIDE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZN5clang10ASTContext29CanonicalTemplateTemplateParm7ProfileERN4llvm16FoldingSetNodeIDE")
    //</editor-fold>
    public void Profile(final FoldingSetNodeID /*&*/ ID) {
      Profile(ID, Parm);
    }

    
    //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::CanonicalTemplateTemplateParm::Profile">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp", line = 548,
     FQN="clang::ASTContext::CanonicalTemplateTemplateParm::Profile", NM="_ZN5clang10ASTContext29CanonicalTemplateTemplateParm7ProfileERN4llvm16FoldingSetNodeIDEPNS_24TemplateTemplateParmDeclE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZN5clang10ASTContext29CanonicalTemplateTemplateParm7ProfileERN4llvm16FoldingSetNodeIDEPNS_24TemplateTemplateParmDeclE")
    //</editor-fold>
    public static void Profile(final FoldingSetNodeID /*&*/ ID, 
           TemplateTemplateParmDecl /*P*/ Parm) {
      ID.AddInteger_uint(Parm.getDepth());
      ID.AddInteger_uint(Parm.getPosition());
      ID.AddBoolean(Parm.isParameterPack());
      
      TemplateParameterList /*P*/ Params = Parm.getTemplateParameters();
      ID.AddInteger_uint(Params.size());
      for (type$ptr<NamedDecl /*P*/ /*const*/ /*P*/> P = $tryClone(Params.begin()), 
          /*P*/ /*const*/ /*P*/ PEnd = $tryClone(Params.end());
           $noteq_ptr(P, PEnd); P.$preInc()) {
        {
          TemplateTypeParmDecl /*P*/ TTP = dyn_cast_TemplateTypeParmDecl(P.$star());
          if ((TTP != null)) {
            ID.AddInteger_int(0);
            ID.AddBoolean(TTP.isParameterPack());
            continue;
          }
        }
        {
          
          NonTypeTemplateParmDecl /*P*/ NTTP = dyn_cast_NonTypeTemplateParmDecl(P.$star());
          if ((NTTP != null)) {
            ID.AddInteger_int(1);
            ID.AddBoolean(NTTP.isParameterPack());
            ID.AddPointer(NTTP.getType().getCanonicalType().getAsOpaquePtr());
            if (NTTP.isExpandedParameterPack()) {
              ID.AddBoolean(true);
              ID.AddInteger_uint(NTTP.getNumExpansionTypes());
              for (/*uint*/int I = 0, N = NTTP.getNumExpansionTypes(); I != N; ++I) {
                QualType T = NTTP.getExpansionType(I);
                ID.AddPointer(T.getCanonicalType().getAsOpaquePtr());
              }
            } else {
              ID.AddBoolean(false);
            }
            continue;
          }
        }
        
        TemplateTemplateParmDecl /*P*/ TTP = cast_TemplateTemplateParmDecl(P.$star());
        ID.AddInteger_int(2);
        Profile(ID, TTP);
      }
    }
    
    
    @Override public String toString() {
      return "" + "Parm=" + Parm // NOI18N
                + super.toString(); // NOI18N
    }
  };
  private /*mutable */FoldingSet<CanonicalTemplateTemplateParm> CanonTemplateTemplateParms;
  
  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::getCanonicalTemplateTemplateParmDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp", line = 588,
   FQN="clang::ASTContext::getCanonicalTemplateTemplateParmDecl", NM="_ZNK5clang10ASTContext36getCanonicalTemplateTemplateParmDeclEPNS_24TemplateTemplateParmDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZNK5clang10ASTContext36getCanonicalTemplateTemplateParmDeclEPNS_24TemplateTemplateParmDeclE")
  //</editor-fold>
  private TemplateTemplateParmDecl /*P*/ getCanonicalTemplateTemplateParmDecl(TemplateTemplateParmDecl /*P*/ TTP) /*const*/ {
    // Check if we already have a canonical template template parameter.
    FoldingSetNodeID ID/*J*/= new FoldingSetNodeID();
    CanonicalTemplateTemplateParm.Profile(ID, TTP);
    final type$ref<type$ptr<CanonicalTemplateTemplateParm /*P*/>/*void P*/ > InsertPos = create_type$null$ref(null);
    CanonicalTemplateTemplateParm /*P*/ Canonical = CanonTemplateTemplateParms.FindNodeOrInsertPos(ID, InsertPos);
    if ((Canonical != null)) {
      return Canonical.getParam();
    }
    
    // Build a canonical template parameter list.
    TemplateParameterList /*P*/ Params = TTP.getTemplateParameters();
    SmallVector<NamedDecl /*P*/ > CanonParams/*J*/= new SmallVector<NamedDecl /*P*/ >(4, (NamedDecl /*P*/ )null);
    CanonParams.reserve(Params.size());
    for (type$ptr<NamedDecl /*P*/ /*const*/ /*P*/> P = $tryClone(Params.begin()), 
        /*P*/ /*const*/ /*P*/ PEnd = $tryClone(Params.end());
         $noteq_ptr(P, PEnd); P.$preInc()) {
      {
        TemplateTypeParmDecl /*P*/ TTP$1 = dyn_cast_TemplateTypeParmDecl(P.$star());
        if ((TTP$1 != null)) {
          CanonParams.push_back(TemplateTypeParmDecl.Create(/*Deref*/this, getTranslationUnitDecl(), 
                  new SourceLocation(), 
                  new SourceLocation(), 
                  TTP$1.getDepth(), 
                  TTP$1.getIndex(), (IdentifierInfo /*P*/ )null, false, 
                  TTP$1.isParameterPack()));
        } else {
          NonTypeTemplateParmDecl /*P*/ NTTP = dyn_cast_NonTypeTemplateParmDecl(P.$star());
          if ((NTTP != null)) {
            QualType T = getCanonicalType(NTTP.getType()).$QualType();
            TypeSourceInfo /*P*/ TInfo = getTrivialTypeSourceInfo(/*NO_COPY*/T);
            NonTypeTemplateParmDecl /*P*/ Param;
            if (NTTP.isExpandedParameterPack()) {
              SmallVector<QualType> ExpandedTypes/*J*/= new SmallVector<QualType>(2, new QualType());
              SmallVector<TypeSourceInfo /*P*/ > ExpandedTInfos/*J*/= new SmallVector<TypeSourceInfo /*P*/ >(2, (TypeSourceInfo /*P*/ )null);
              for (/*uint*/int I = 0, N = NTTP.getNumExpansionTypes(); I != N; ++I) {
                ExpandedTypes.push_back(getCanonicalType(NTTP.getExpansionType(I)).$QualType());
                ExpandedTInfos.push_back(getTrivialTypeSourceInfo(/*NO_COPY*/ExpandedTypes.back()));
              }
              
              Param = NonTypeTemplateParmDecl.Create(/*Deref*/this, getTranslationUnitDecl(), 
                  new SourceLocation(), 
                  new SourceLocation(), 
                  NTTP.getDepth(), 
                  NTTP.getPosition(), (IdentifierInfo /*P*/ )null, 
                  new QualType(T), 
                  TInfo, 
                  new ArrayRef<QualType>(ExpandedTypes, false), 
                  new ArrayRef<TypeSourceInfo /*P*/ >(ExpandedTInfos, true));
            } else {
              Param = NonTypeTemplateParmDecl.Create(/*Deref*/this, getTranslationUnitDecl(), 
                  new SourceLocation(), 
                  new SourceLocation(), 
                  NTTP.getDepth(), 
                  NTTP.getPosition(), (IdentifierInfo /*P*/ )null, 
                  new QualType(T), 
                  NTTP.isParameterPack(), 
                  TInfo);
            }
            CanonParams.push_back(Param);
          } else {
            CanonParams.push_back(getCanonicalTemplateTemplateParmDecl(cast_TemplateTemplateParmDecl(P.$star())));
          }
        }
      }
    }
    
    TemplateTemplateParmDecl /*P*/ CanonTTP = TemplateTemplateParmDecl.Create(/*Deref*/this, getTranslationUnitDecl(), 
        new SourceLocation(), TTP.getDepth(), 
        TTP.getPosition(), 
        TTP.isParameterPack(), 
        (IdentifierInfo /*P*/ )null, 
        TemplateParameterList.Create(/*Deref*/this, new SourceLocation(), 
            new SourceLocation(), 
            new ArrayRef<NamedDecl /*P*/ >(CanonParams, true), 
            new SourceLocation()));
    
    // Get the new insert position for the node we care about.
    Canonical = CanonTemplateTemplateParms.FindNodeOrInsertPos(ID, InsertPos);
    assert (!(Canonical != null)) : "Shouldn't be in the map!";
    ///*J:(void)*/Canonical;
    
    // Create the canonical template template parameter entry.
    Canonical = /*NEW_EXPR [operator new] NM=_ZnwjRKN5clang10ASTContextEj*/
    /*new (*this)*/ $new_uint_ASTContext$C_uint(/*Deref*/this, (type$ptr<?> New$Mem)->{
        return new CanonicalTemplateTemplateParm(CanonTTP);
     });
    CanonTemplateTemplateParms.InsertNode(Canonical, InsertPos.$deref());
    return CanonTTP;
  }

  
  /// \brief The typedef for the __int128_t type.
  /*friend*/public /*mutable */TypedefDecl /*P*/ Int128Decl;
  
  /// \brief The typedef for the __uint128_t type.
  /*friend*/public /*mutable */TypedefDecl /*P*/ UInt128Decl;
  
  /// \brief The typedef for the target specific predefined
  /// __builtin_va_list type.
  /*friend*/public /*mutable */TypedefDecl /*P*/ BuiltinVaListDecl;
  
  /// The typedef for the predefined \c __builtin_ms_va_list type.
  /*friend*/public /*mutable */TypedefDecl /*P*/ BuiltinMSVaListDecl;
  
  /// \brief The typedef for the predefined \c id type.
  /*friend*/public /*mutable */TypedefDecl /*P*/ ObjCIdDecl;
  
  /// \brief The typedef for the predefined \c SEL type.
  /*friend*/public /*mutable */TypedefDecl /*P*/ ObjCSelDecl;
  
  /// \brief The typedef for the predefined \c Class type.
  /*friend*/public /*mutable */TypedefDecl /*P*/ ObjCClassDecl;
  
  /// \brief The typedef for the predefined \c Protocol class in Objective-C.
  /*friend*/public /*mutable */ObjCInterfaceDecl /*P*/ ObjCProtocolClassDecl;
  
  /// \brief The typedef for the predefined 'BOOL' type.
  private /*mutable */TypedefDecl /*P*/ BOOLDecl;
  
  // Typedefs which may be provided defining the structure of Objective-C
  // pseudo-builtins
  /*friend*/public QualType ObjCIdRedefinitionType;
  /*friend*/public QualType ObjCClassRedefinitionType;
  /*friend*/public QualType ObjCSelRedefinitionType;
  
  /// The identifier 'bool'.
  private /*mutable */IdentifierInfo /*P*/ BoolName/* = null*/;
  
  /// The identifier 'NSObject'.
  private IdentifierInfo /*P*/ NSObjectName/* = null*/;
  
  /// The identifier 'NSCopying'.
  private IdentifierInfo /*P*/ NSCopyingName/* = null*/;
  
  /// The identifier '__make_integer_seq'.
  private /*mutable */IdentifierInfo /*P*/ MakeIntegerSeqName/* = null*/;
  
  /// The identifier '__type_pack_element'.
  private /*mutable */IdentifierInfo /*P*/ TypePackElementName/* = null*/;
  
  private QualType ObjCConstantStringType;
  /*friend*/public /*mutable */RecordDecl /*P*/ CFConstantStringTagDecl;
  /*friend*/public /*mutable */TypedefDecl /*P*/ CFConstantStringTypeDecl;
  
  private /*mutable */QualType ObjCSuperType;
  
  private QualType ObjCNSStringType;
  
  /// \brief The typedef declaration for the Objective-C "instancetype" type.
  /*friend*/public TypedefDecl /*P*/ ObjCInstanceTypeDecl;
  
  /// \brief The type for the C FILE type.
  /*friend*/public TypeDecl /*P*/ FILEDecl;
  
  /// \brief The type for the C jmp_buf type.
  /*friend*/public TypeDecl /*P*/ jmp_bufDecl;
  
  /// \brief The type for the C sigjmp_buf type.
  /*friend*/public TypeDecl /*P*/ sigjmp_bufDecl;
  
  /// \brief The type for the C ucontext_t type.
  /*friend*/public TypeDecl /*P*/ ucontext_tDecl;
  
  /// \brief Type for the Block descriptor for Blocks CodeGen.
  ///
  /// Since this is only used for generation of debug info, it is not
  /// serialized.
  private /*mutable */RecordDecl /*P*/ BlockDescriptorType;
  
  /// \brief Type for the Block descriptor for Blocks CodeGen.
  ///
  /// Since this is only used for generation of debug info, it is not
  /// serialized.
  private /*mutable */RecordDecl /*P*/ BlockDescriptorExtendedType;
  
  /// \brief Declaration for the CUDA cudaConfigureCall function.
  private FunctionDecl /*P*/ cudaConfigureCallDecl;
  
  /// \brief Keeps track of all declaration attributes.
  ///
  /// Since so few decls have attrs, we keep them in a hash map instead of
  /// wasting space in the Decl class.
  private DenseMap</*const*/ Decl /*P*/ , SmallVector<Attr /*P*/>/*P*/ > DeclAttrs;
  
  /// \brief A mapping from non-redeclarable declarations in modules that were
  /// merged with other declarations to the canonical declaration that they were
  /// merged into.
  private DenseMap<Decl /*P*/ , Decl /*P*/ > MergedDecls;
  
  /// \brief A mapping from a defining declaration to a list of modules (other
  /// than the owning module of the declaration) that contain merged
  /// definitions of that entity.
  private DenseMap<NamedDecl /*P*/ , TinyPtrVector<Module /*P*/ >> MergedDefModules;
/*public:*/
  /// \brief A type synonym for the TemplateOrInstantiation mapping.
  /*typedef llvm::PointerUnion<VarTemplateDecl *, MemberSpecializationInfo *> TemplateOrSpecializationInfo*/
//  public final class TemplateOrSpecializationInfo extends PointerUnion<VarTemplateDecl /*P*/ , MemberSpecializationInfo /*P*/ >{ };
/*private:*/
  
  /// \brief A mapping to contain the template or declaration that
  /// a variable declaration describes or was instantiated from,
  /// respectively.
  ///
  /// For non-templates, this value will be NULL. For variable
  /// declarations that describe a variable template, this will be a
  /// pointer to a VarTemplateDecl. For static data members
  /// of class template specializations, this will be the
  /// MemberSpecializationInfo referring to the member variable that was
  /// instantiated or specialized. Thus, the mapping will keep track of
  /// the static data member templates from which static data members of
  /// class template specializations were instantiated.
  ///
  /// Given the following example:
  ///
  /// \code
  /// template<typename T>
  /// struct X {
  ///   static T value;
  /// };
  ///
  /// template<typename T>
  ///   T X<T>::value = T(17);
  ///
  /// int *x = &X<int>::value;
  /// \endcode
  ///
  /// This mapping will contain an entry that maps from the VarDecl for
  /// X<int>::value to the corresponding VarDecl for X<T>::value (within the
  /// class template X) and will be marked TSK_ImplicitInstantiation.
  private DenseMap</*const*/ VarDecl /*P*/ , PointerUnion<VarTemplateDecl /*P*/ , MemberSpecializationInfo /*P*/ >> TemplateOrInstantiation;
  
  /// \brief Keeps track of the declaration from which a UsingDecl was
  /// created during instantiation.
  ///
  /// The source declaration is always a UsingDecl, an UnresolvedUsingValueDecl,
  /// or an UnresolvedUsingTypenameDecl.
  ///
  /// For example:
  /// \code
  /// template<typename T>
  /// struct A {
  ///   void f();
  /// };
  ///
  /// template<typename T>
  /// struct B : A<T> {
  ///   using A<T>::f;
  /// };
  ///
  /// template struct B<int>;
  /// \endcode
  ///
  /// This mapping will contain an entry that maps from the UsingDecl in
  /// B<int> to the UnresolvedUsingDecl in B<T>.
  private DenseMap<UsingDecl /*P*/ , NamedDecl /*P*/ > InstantiatedFromUsingDecl;
  
  private DenseMap<UsingShadowDecl /*P*/ , UsingShadowDecl /*P*/ > InstantiatedFromUsingShadowDecl;
  
  private DenseMap<FieldDecl /*P*/ , FieldDecl /*P*/ > InstantiatedFromUnnamedFieldDecl;
  
  /// \brief Mapping that stores the methods overridden by a given C++
  /// member function.
  ///
  /// Since most C++ member functions aren't virtual and therefore
  /// don't override anything, we store the overridden functions in
  /// this map on the side rather than within the CXXMethodDecl structure.
  /*typedef llvm::TinyPtrVector<const CXXMethodDecl *> CXXMethodVector*/
//  public final class CXXMethodVector extends TinyPtrVector</*const*/ CXXMethodDecl /*P*/ >{ };
  private DenseMap</*const*/ CXXMethodDecl /*P*/ , TinyPtrVector</*const*/ CXXMethodDecl /*P*/ >> OverriddenMethods;
  
  /// \brief Mapping from each declaration context to its corresponding
  /// mangling numbering context (used for constructs like lambdas which
  /// need to be consistently numbered for the mangler).
  private DenseMap</*const*/ DeclContext /*P*/ , MangleNumberingContext /*P*/ > MangleNumberingContexts;
  
  /// \brief Side-table of mangling numbers for declarations which rarely
  /// need them (like static local vars).
  /*friend*/public MapVectorPtrUInt</*const*/ NamedDecl /*P*/ > MangleNumbers;
  /*friend*/public MapVectorPtrUInt</*const*/ VarDecl /*P*/ > StaticLocalNumbers;
  
  /// \brief Mapping that stores parameterIndex values for ParmVarDecls when
  /// that value exceeds the bitfield size of ParmVarDeclBits.ParameterIndex.
  /*typedef llvm::DenseMap<const VarDecl *, unsigned int> ParameterIndexTable*/
//  public final class ParameterIndexTable extends DenseMapTypeUInt</*const*/ VarDecl /*P*/ >{ };
  private DenseMapTypeUInt</*const*/ VarDecl /*P*/ > ParamIndices;
  
  private ImportDecl /*P*/ FirstLocalImport;
  private ImportDecl /*P*/ LastLocalImport;
  
  private TranslationUnitDecl /*P*/ TUDecl;
  /*friend*/public /*mutable */ExternCContextDecl /*P*/ ExternCContext;
  /*friend*/public /*mutable */BuiltinTemplateDecl /*P*/ MakeIntegerSeqDecl;
  /*friend*/public /*mutable */BuiltinTemplateDecl /*P*/ TypePackElementDecl;
  
  /// \brief The associated SourceManager object.a
  /*friend*/public final SourceManager /*&*/ SourceMgr;
  
  /// \brief The language options used to create the AST associated with
  ///  this ASTContext object.
  private final LangOptions /*&*/ LangOpts;
  
  /// \brief Blacklist object that is used by sanitizers to decide which
  /// entities should not be instrumented.
  private std.unique_ptr<SanitizerBlacklist> SanitizerBL;
  
  /// \brief The allocator used to create AST objects.
  ///
  /// AST objects are never destructed; rather, all memory associated with the
  /// AST objects will be released when the ASTContext itself is destroyed.
  private /*mutable */BumpPtrAllocatorImpl BumpAlloc;
  
  /// \brief Allocator for partial diagnostics.
  private PartialDiagnostic.StorageAllocator DiagAllocator;
  
  /// \brief The current C++ ABI.
  private std.unique_ptr<CXXABI> ABI;
  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::createCXXABI">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp", line = 677,
   FQN="clang::ASTContext::createCXXABI", NM="_ZN5clang10ASTContext12createCXXABIERKNS_10TargetInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZN5clang10ASTContext12createCXXABIERKNS_10TargetInfoE")
  //</editor-fold>
  private CXXABI /*P*/ createCXXABI(final /*const*/ TargetInfo /*&*/ T) {
    if (!LangOpts.CPlusPlus) {
      return null;
    }
    switch (T.getCXXABI().getKind()) {
     case GenericARM: // Same as Itanium at this level
     case iOS:
     case iOS64:
     case WatchOS:
     case GenericAArch64:
     case GenericMIPS:
     case GenericItanium:
     case WebAssembly:
      return CreateItaniumCXXABI(/*Deref*/this);
     case Microsoft:
      return CreateMicrosoftCXXABI(/*Deref*/this);
    }
    throw new llvm_unreachable("Invalid CXXABI type!");
  }

  
  /// \brief The logical -> physical address space map.
  private /*const*/LangAS.Map /*P*/ AddrSpaceMap;
  
  /// \brief Address space map mangling must be used with language specific 
  /// address spaces (e.g. OpenCL/CUDA)
  private boolean AddrSpaceMapMangling;
  
  /*friend  class ASTDeclReader*/
  /*friend  class ASTReader*/
  /*friend  class ASTWriter*/
  /*friend  class CXXRecordDecl*/
  
  private /*const*/ TargetInfo /*P*/ Target;
  private /*const*/ TargetInfo /*P*/ AuxTarget;
  private PrintingPolicy PrintingPolicy;
/*public:*/
  public final IdentifierTable /*&*/ Idents;
  public final SelectorTable /*&*/ Selectors;
  public final Builtin.Context /*&*/ BuiltinInfo;
  public /*mutable */DeclarationNameTable DeclarationNames;
  public IntrusiveRefCntPtr<ExternalASTSource> ExternalSource;
  public ASTMutationListener /*P*/ Listener;
  
  /// \brief Contains parents of a node.
  /*typedef llvm::SmallVector<ast_type_traits::DynTypedNode, 2> ParentVector*/
//  public final class ParentVector extends SmallVector<DynTypedNode>{ };
  
  /// \brief Maps from a node to its parents. This is used for nodes that have
  /// pointer identity only, which are more common and we can save space by
  /// only storing a unique pointer to them.
  /*typedef llvm::DenseMap<const void *, llvm::PointerUnion4<const Decl *, const Stmt *, ast_type_traits::DynTypedNode *, ParentVector *> > ParentMapPointers*/
//  public final class ParentMapPointers extends DenseMap</*const*/Object/*void P*/ , PointerUnion4</*const*/ Decl /*P*/ , /*const*/ Stmt /*P*/ , DynTypedNode /*P*/ , SmallVector<DynTypedNode> /*P*/>>{ };
  
  /// Parent map for nodes without pointer identity. We store a full
  /// DynTypedNode for all keys.
  /*typedef llvm::DenseMap<ast_type_traits::DynTypedNode, llvm::PointerUnion4<const Decl *, const Stmt *, ast_type_traits::DynTypedNode *, ParentVector *> > ParentMapOtherNodes*/
//  public final class ParentMapOtherNodes extends DenseMap<DynTypedNode, PointerUnion4</*const*/ Decl /*P*/ , /*const*/ Stmt /*P*/ , DynTypedNode /*P*/ , SmallVector<DynTypedNode> /*P*/>>{ };
  
  /// Container for either a single DynTypedNode or for an ArrayRef to
  /// DynTypedNode. For use with ParentMap.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::DynTypedNodeList">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ASTContext.h", line = 487,
   FQN="clang::ASTContext::DynTypedNodeList", NM="_ZN5clang10ASTContext16DynTypedNodeListE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZN5clang10ASTContext16DynTypedNodeListE")
  //</editor-fold>
  public static class DynTypedNodeList {
    /*typedef ast_type_traits::DynTypedNode DynTypedNode*/
//    public final class DynTypedNode extends DynTypedNode{ };
    private AlignedCharArrayUnion<DynTypedNode, ArrayRef<DynTypedNode> > Storage;
    private boolean IsSingleNode;
  /*public:*/
    //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::DynTypedNodeList::DynTypedNodeList">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ASTContext.h", line = 494,
     FQN="clang::ASTContext::DynTypedNodeList::DynTypedNodeList", NM="_ZN5clang10ASTContext16DynTypedNodeListC1ERKNS_15ast_type_traits12DynTypedNodeE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZN5clang10ASTContext16DynTypedNodeListC1ERKNS_15ast_type_traits12DynTypedNodeE")
    //</editor-fold>
    public DynTypedNodeList(final /*const*/ DynTypedNode /*&*/ N) {
      // : Storage(), IsSingleNode(true) 
      //START JInit
      this.Storage = new AlignedCharArrayUnion<DynTypedNode, ArrayRef<DynTypedNode> >();
      this.IsSingleNode = true;
      //END JInit
      /*NEW_EXPR [System]*/Storage.buffer = /*new (Storage.buffer)*/ $new_uint_voidPtr(Storage.buffer, (type$ptr<?> New$Mem)->{
          return new DynTypedNode(N);
       });
    }

    //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::DynTypedNodeList::DynTypedNodeList">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ASTContext.h", line = 497,
     FQN="clang::ASTContext::DynTypedNodeList::DynTypedNodeList", NM="_ZN5clang10ASTContext16DynTypedNodeListC1EN4llvm8ArrayRefINS_15ast_type_traits12DynTypedNodeEEE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZN5clang10ASTContext16DynTypedNodeListC1EN4llvm8ArrayRefINS_15ast_type_traits12DynTypedNodeEEE")
    //</editor-fold>
    public DynTypedNodeList(ArrayRef<DynTypedNode> A) {
      // : Storage(), IsSingleNode(false) 
      //START JInit
      this.Storage = new AlignedCharArrayUnion<DynTypedNode, ArrayRef<DynTypedNode> >();
      this.IsSingleNode = false;
      //END JInit
      /*NEW_EXPR [System]*/Storage.buffer = /*new (Storage.buffer)*/ $new_uint_voidPtr(Storage.buffer, (type$ptr<?> New$Mem)->{
          return new ArrayRef<DynTypedNode>(A);
       });
    }

    
    //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::DynTypedNodeList::begin">
    @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ASTContext.h", line = 501,
     FQN="clang::ASTContext::DynTypedNodeList::begin", NM="_ZNK5clang10ASTContext16DynTypedNodeList5beginEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZNK5clang10ASTContext16DynTypedNodeList5beginEv")
    //</editor-fold>
    public /*const*/ type$ptr<DynTypedNode /*P*/> begin() /*const*/ {
      if (!IsSingleNode) {
        return ((/*const*/ArrayRef<DynTypedNode> /*P*/)reinterpret_cast(/*const*/ArrayRef.class, Storage.buffer)).
            begin();
      }
      return create_type$ptr(reinterpret_cast(/*const*/ DynTypedNode /*P*/ .class, Storage.buffer));
    }

    
    //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::DynTypedNodeList::end">
    @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ASTContext.h", line = 508,
     FQN="clang::ASTContext::DynTypedNodeList::end", NM="_ZNK5clang10ASTContext16DynTypedNodeList3endEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZNK5clang10ASTContext16DynTypedNodeList3endEv")
    //</editor-fold>
    public /*const*/ type$ptr<DynTypedNode /*P*/> end() /*const*/ {
      if (!IsSingleNode) {
        return ((/*const*/ArrayRef<DynTypedNode> /*P*/)reinterpret_cast(/*const*/ArrayRef.class, Storage.buffer)).
            end();
      }
      return create_type$ptr(reinterpret_cast(/*const*/ DynTypedNode /*P*/ .class, Storage.buffer)).$add(1);
    }

    
    //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::DynTypedNodeList::size">
    @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ASTContext.h", line = 515,
     FQN="clang::ASTContext::DynTypedNodeList::size", NM="_ZNK5clang10ASTContext16DynTypedNodeList4sizeEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZNK5clang10ASTContext16DynTypedNodeList4sizeEv")
    //</editor-fold>
    public /*size_t*/int size() /*const*/ {
      return end().$sub(begin());
    }

    //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::DynTypedNodeList::empty">
    @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ASTContext.h", line = 516,
     FQN="clang::ASTContext::DynTypedNodeList::empty", NM="_ZNK5clang10ASTContext16DynTypedNodeList5emptyEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZNK5clang10ASTContext16DynTypedNodeList5emptyEv")
    //</editor-fold>
    public boolean empty() /*const*/ {
      return begin().$eq(end());
    }

    //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::DynTypedNodeList::operator[]">
    @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ASTContext.h", line = 517,
     FQN="clang::ASTContext::DynTypedNodeList::operator[]", NM="_ZNK5clang10ASTContext16DynTypedNodeListixEj",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZNK5clang10ASTContext16DynTypedNodeListixEj")
    //</editor-fold>
    public /*const*/ DynTypedNode /*&*/ $at(/*size_t*/int N) /*const*/ {
      assert ($less_uint(N, size())) : "Out of bounds!";
      return $Deref((begin().$add(N)).$star());
    }

    //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::DynTypedNodeList::DynTypedNodeList">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ASTContext.h", line = 487,
     FQN="clang::ASTContext::DynTypedNodeList::DynTypedNodeList", NM="_ZN5clang10ASTContext16DynTypedNodeListC1EOS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZN5clang10ASTContext16DynTypedNodeListC1EOS1_")
    //</editor-fold>
    public /*inline*/ DynTypedNodeList(JD$Move _dparam, final DynTypedNodeList /*&&*/$Prm0) {
      // : Storage(static_cast<DynTypedNodeList &&>().Storage), IsSingleNode(static_cast<DynTypedNodeList &&>().IsSingleNode) 
      //START JInit
      this.Storage = new AlignedCharArrayUnion<DynTypedNode, ArrayRef<DynTypedNode> >(JD$Move.INSTANCE, $Prm0.Storage);
      this.IsSingleNode = $Prm0.IsSingleNode;
      //END JInit
    }

    
    @Override public String toString() {
      return "" + "Storage=" + Storage // NOI18N
                + ", IsSingleNode=" + IsSingleNode; // NOI18N
    }
  };
  
  /// \brief Returns the parents of the given node.
  ///
  /// Note that this will lazily compute the parents of all nodes
  /// and store them for later retrieval. Thus, the first call is O(n)
  /// in the number of AST nodes.
  ///
  /// Caveats and FIXMEs:
  /// Calculating the parent map over all AST nodes will need to load the
  /// full AST. This can be undesirable in the case where the full AST is
  /// expensive to create (for example, when using precompiled header
  /// preambles). Thus, there are good opportunities for optimization here.
  /// One idea is to walk the given node downwards, looking for references
  /// to declaration contexts - once a declaration context is found, compute
  /// the parent map for the declaration context; if that can satisfy the
  /// request, loading the whole AST can be avoided. Note that this is made
  /// more complex by statements in templates having multiple parents - those
  /// problems can be solved by building closure over the templated parts of
  /// the AST, which also avoids touching large parts of the AST.
  /// Additionally, we will want to add an interface to already give a hint
  /// where to search for the parents, for example when looking at a statement
  /// inside a certain function.
  ///
  /// 'NodeT' can be one of Decl, Stmt, Type, TypeLoc,
  /// NestedNameSpecifier or NestedNameSpecifierLoc.
  /*template <typename NodeT> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::getParents">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ASTContext.h", line = 547,
   FQN="clang::ASTContext::getParents", NM="Tpl__ZN5clang10ASTContext10getParentsERKT_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=Tpl__ZN5clang10ASTContext10getParentsERKT_")
  //</editor-fold>
  //public </*typename*/ NodeT> DynTypedNodeList getParents$T(final /*const*/ NodeT /*&*/ Node) {
  //  return getParents(DynTypedNode.create(Node));
  //}
  public DynTypedNodeList getParents$T(final /*const*/ Decl /*&*/ Node) {
    return getParents(DynTypedNode.create(Node));
  }
  public DynTypedNodeList getParents$T(final /*const*/ Stmt /*&*/ Node) {
    return getParents(DynTypedNode.create(Node));
  }
  public DynTypedNodeList getParents$T(final /*const*/ Type /*&*/ Node) {
    return getParents(DynTypedNode.create(Node));
  }
  public DynTypedNodeList getParents$T(final /*const*/ TypeLoc /*&*/ Node) {
    return getParents(DynTypedNode.create(Node));
  }
  public DynTypedNodeList getParents$T(final /*const*/ NestedNameSpecifier /*&*/ Node) {
    return getParents(DynTypedNode.create(Node));
  }
  public DynTypedNodeList getParents$T(final /*const*/ NestedNameSpecifierLoc /*&*/ Node) {
    return getParents(DynTypedNode.create(Node));
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::getParents">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp", line = 9056,
   FQN="clang::ASTContext::getParents", NM="_ZN5clang10ASTContext10getParentsERKNS_15ast_type_traits12DynTypedNodeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZN5clang10ASTContext10getParentsERKNS_15ast_type_traits12DynTypedNodeE")
  //</editor-fold>
  public ASTContext.DynTypedNodeList getParents(final /*const*/ DynTypedNode /*&*/ Node) {
    if (!PointerParents.$bool()) {
      // We always need to run over the whole translation unit, as
      // hasAncestor can escape any subtree.
      std.pair<ASTContext.ParentMapPointers/*P*/ , ASTContext.ParentMapOtherNodes/*P*/ > Maps = ParentMapASTVisitor.buildMap($Deref(getTranslationUnitDecl()));
      PointerParents.reset(Maps.first);
      OtherParents.reset(Maps.second);
    }
    if (Node.getNodeKind().hasPointerIdentity()) {
      return getDynNodeFromMap(Node.getMemoizationData(), PointerParents.$star());
    }
    return getDynNodeFromMap(Node, OtherParents.$star());
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::getPrintingPolicy">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ASTContext.h", line = 553,
   FQN="clang::ASTContext::getPrintingPolicy", NM="_ZNK5clang10ASTContext17getPrintingPolicyEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZNK5clang10ASTContext17getPrintingPolicyEv")
  //</editor-fold>
  public /*const*/ PrintingPolicy /*&*/ getPrintingPolicy() /*const*/ {
    return PrintingPolicy;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::setPrintingPolicy">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ASTContext.h", line = 557,
   FQN="clang::ASTContext::setPrintingPolicy", NM="_ZN5clang10ASTContext17setPrintingPolicyERKNS_14PrintingPolicyE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZN5clang10ASTContext17setPrintingPolicyERKNS_14PrintingPolicyE")
  //</editor-fold>
  public void setPrintingPolicy(final /*const*/ PrintingPolicy /*&*/ Policy) {
    PrintingPolicy.$assign(Policy);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::getSourceManager">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ASTContext.h", line = 561,
   FQN="clang::ASTContext::getSourceManager", NM="_ZN5clang10ASTContext16getSourceManagerEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZN5clang10ASTContext16getSourceManagerEv")
  //</editor-fold>
  public SourceManager /*&*/ getSourceManager() {
    return SourceMgr;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::getSourceManager">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ASTContext.h", line = 562,
   FQN="clang::ASTContext::getSourceManager", NM="_ZNK5clang10ASTContext16getSourceManagerEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZNK5clang10ASTContext16getSourceManagerEv")
  //</editor-fold>
  public /*const*/ SourceManager /*&*/ getSourceManager$Const() /*const*/ {
    return SourceMgr;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::getAllocator">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ASTContext.h", line = 564,
   FQN="clang::ASTContext::getAllocator", NM="_ZNK5clang10ASTContext12getAllocatorEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZNK5clang10ASTContext12getAllocatorEv")
  //</editor-fold>
  public BumpPtrAllocatorImpl /*&*/ getAllocator() /*const*/ {
    return BumpAlloc;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::Allocate">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ASTContext.h", line = 568,
   FQN="clang::ASTContext::Allocate", NM="_ZNK5clang10ASTContext8AllocateEjj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZNK5clang10ASTContext8AllocateEjj")
  //</editor-fold>
  @Override public char$ptr/*void P*/ Allocate(/*size_t*/int Size) /*const*/ {
    return Allocate(Size, 8);
  }
  @Override public char$ptr/*void P*/ Allocate(/*size_t*/int Size, /*uint*/int Align/*= 8*/) /*const*/ {
    throw new UnsupportedOperationException("Please, keep the original code snippet in 'if (false)' branch and rewrite\n"
            + " using Allocate$JavaRef with sizeof == 1 and Align == 1 for Java. Or Allocate$Chars for char$ptr");
  }
  public <T> T Allocate(Class<T> clazz, /*size_t*/int Size, /*uint*/int Align/*= 8*/) /*const*/ {
    throw new UnsupportedOperationException("Please, keep the original code snippet in 'if (false)' branch and rewrite\n"
            + " using Allocate$JavaRef with sizeof == 1 and Align == 1 for Java.");
  }

  @Override public char$ptr Allocate$Chars(/*size_t*/int Size) /*const*/ {
    return Allocate$Chars(Size, 8);
  }
  @Override public char$ptr Allocate$Chars(/*size_t*/int Size, /*uint*/int Align/*= 8*/) /*const*/ {
    return BumpAlloc.Allocate(Size, Align);
  }
  
  /*template <typename T> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::Allocate">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ASTContext.h", line = 571,
   FQN="clang::ASTContext::Allocate", NM="Tpl__ZNK5clang10ASTContext8AllocateEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=Tpl__ZNK5clang10ASTContext8AllocateEj")
  //</editor-fold>
  public </*typename*/ T> T /*P*/ Allocate$T() /*const*/ {
    return Allocate$T(1);
  }
  public </*typename*/ T> T /*P*/ Allocate$T(/*size_t*/int Num/*= 1*/) /*const*/ {
    throw new UnsupportedOperationException("Please, keep the original code snippet in 'if (false)' branch and rewrite\n"
            + " using Allocate$JavaRef with sizeof == 1 and Align == 1 for Java.");
  }
  
  public type$ptr<?> Allocate$JavaRef() {
    return Allocate$JavaRef(1);
  }
  public type$ptr<?> Allocate$JavaRef(int Num) {
    // JAVA PERF: use allocator which keeps big Object[] pool and get from there
    return create_type$ptr(new$T(new Object[Num], ()->null));
  }
  public type$ptr<?> Allocate$JavaRef(int Num, std.pairIntPtr<Supplier> ... initializers) {
    return Allocate$JavaRef(Num, 0, initializers);
  }
  public type$ptr<?> Allocate$JavaRef(int Num, int Alignment) {
    // JAVA PERF: use allocator which keeps big Object[] pool and get from there
    return create_type$ptr(new$T(new Object[Num], ()->null));
  }
  public type$ptr<?> Allocate$JavaRef(int Num, int Alignment, std.pairIntPtr<Supplier> ... initializers) {
    // JAVA PERF: use allocator which keeps big Object[] pool and get from there
    type$ptr<Object> res = create_type$ptr(new Object[Num]);
    int index = 0;
    for (std.pairIntType<Supplier> numAndSupplier : initializers) {
      for (int counter = 0; counter < numAndSupplier.first; ++counter) {
        res.$set(index, numAndSupplier.second.get());
        ++index;
      }
    }
    return res;
  }
  
  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::Deallocate">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ASTContext.h", line = 574,
   FQN="clang::ASTContext::Deallocate", NM="_ZNK5clang10ASTContext10DeallocateEPv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZNK5clang10ASTContext10DeallocateEPv")
  //</editor-fold>
  public void Deallocate(Object/*void P*/ Ptr) /*const*/ {
  }

  
  /// Return the total amount of physical memory allocated for representing
  /// AST nodes and type information.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::getASTAllocatedMemory">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*return type*/,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ASTContext.h", line = 578,
   FQN="clang::ASTContext::getASTAllocatedMemory", NM="_ZNK5clang10ASTContext21getASTAllocatedMemoryEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZNK5clang10ASTContext21getASTAllocatedMemoryEv")
  //</editor-fold>
  public /*size_t*/long getASTAllocatedMemory() /*const*/ {
    return BumpAlloc.getTotalMemory();
  }

  /// Return the total memory used for various side tables.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::getSideTableAllocatedMemory">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp", line = 8714,
   FQN="clang::ASTContext::getSideTableAllocatedMemory", NM="_ZNK5clang10ASTContext27getSideTableAllocatedMemoryEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZNK5clang10ASTContext27getSideTableAllocatedMemoryEv")
  //</editor-fold>
  public /*size_t*/int getSideTableAllocatedMemory() /*const*/ {
    return ASTRecordLayouts.getMemorySize()
       + llvm.capacity_in_bytes(ObjCLayouts)
       + llvm.capacity_in_bytes(KeyFunctions)
       + llvm.capacity_in_bytes(ObjCImpls)
       + llvm.capacity_in_bytes(BlockVarCopyInits)
       + llvm.capacity_in_bytes(DeclAttrs)
       + llvm.capacity_in_bytes(TemplateOrInstantiation)
       + llvm.capacity_in_bytes(InstantiatedFromUsingDecl)
       + llvm.capacity_in_bytes(InstantiatedFromUsingShadowDecl)
       + llvm.capacity_in_bytes(InstantiatedFromUnnamedFieldDecl)
       + llvm.capacity_in_bytes(OverriddenMethods)
       + llvm.capacity_in_bytes(Types)
       + llvm.capacity_in_bytes(VariableArrayTypes)
       + llvm.capacity_in_bytes(ClassScopeSpecializationPattern);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::getDiagAllocator">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ASTContext.h", line = 584,
   FQN="clang::ASTContext::getDiagAllocator", NM="_ZN5clang10ASTContext16getDiagAllocatorEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZN5clang10ASTContext16getDiagAllocatorEv")
  //</editor-fold>
  public PartialDiagnostic.StorageAllocator /*&*/ getDiagAllocator() {
    return DiagAllocator;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::getTargetInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ASTContext.h", line = 588,
   FQN="clang::ASTContext::getTargetInfo", NM="_ZNK5clang10ASTContext13getTargetInfoEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZNK5clang10ASTContext13getTargetInfoEv")
  //</editor-fold>
  public /*const*/ TargetInfo /*&*/ getTargetInfo() /*const*/ {
    return $Deref(Target);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::getAuxTargetInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ASTContext.h", line = 589,
   FQN="clang::ASTContext::getAuxTargetInfo", NM="_ZNK5clang10ASTContext16getAuxTargetInfoEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZNK5clang10ASTContext16getAuxTargetInfoEv")
  //</editor-fold>
  public /*const*/ TargetInfo /*P*/ getAuxTargetInfo() /*const*/ {
    return AuxTarget;
  }

  
  /// getIntTypeForBitwidth -
  /// sets integer QualTy according to specified details:
  /// bitwidth, signed/unsigned.
  /// Returns empty type if there is no appropriate target types.
  
  /// getIntTypeForBitwidth -
  /// sets integer QualTy according to specified details:
  /// bitwidth, signed/unsigned.
  /// Returns empty type if there is no appropriate target types.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::getIntTypeForBitwidth">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp", line = 8735,
   FQN="clang::ASTContext::getIntTypeForBitwidth", NM="_ZNK5clang10ASTContext21getIntTypeForBitwidthEjj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZNK5clang10ASTContext21getIntTypeForBitwidthEjj")
  //</editor-fold>
  public QualType getIntTypeForBitwidth(/*uint*/int DestWidth, 
                       /*uint*/int Signed) /*const*/ {
    TargetInfo.IntType Ty = getTargetInfo().getIntTypeByWidth(DestWidth, (Signed != 0));
    CanQual<Type> QualTy = getFromTargetType(Ty.getValue());
    if (!QualTy.$bool() && DestWidth == 128) {
      return ((Signed != 0) ? Int128Ty : UnsignedInt128Ty).$QualType();
    }
    return QualTy.$QualType();
  }

  /// getRealTypeForBitwidth -
  /// sets floating point QualTy according to specified bitwidth.
  /// Returns empty type if there is no appropriate target types.
  
  /// getRealTypeForBitwidth -
  /// sets floating point QualTy according to specified bitwidth.
  /// Returns empty type if there is no appropriate target types.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::getRealTypeForBitwidth">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp", line = 8747,
   FQN="clang::ASTContext::getRealTypeForBitwidth", NM="_ZNK5clang10ASTContext22getRealTypeForBitwidthEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZNK5clang10ASTContext22getRealTypeForBitwidthEj")
  //</editor-fold>
  public QualType getRealTypeForBitwidth(/*uint*/int DestWidth) /*const*/ {
    TargetInfo.RealType Ty = getTargetInfo().getRealTypeByWidth(DestWidth);
    switch (Ty) {
     case Float:
      return FloatTy.$QualType();
     case Double:
      return DoubleTy.$QualType();
     case LongDouble:
      return LongDoubleTy.$QualType();
     case Float128:
      return Float128Ty.$QualType();
     case NoFloat:
      return new QualType();
    }
    throw new llvm_unreachable("Unhandled TargetInfo::RealType value");
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::AtomicUsesUnsupportedLibcall">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp", line = 8868,
   FQN="clang::ASTContext::AtomicUsesUnsupportedLibcall", NM="_ZNK5clang10ASTContext28AtomicUsesUnsupportedLibcallEPKNS_10AtomicExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZNK5clang10ASTContext28AtomicUsesUnsupportedLibcallEPKNS_10AtomicExprE")
  //</editor-fold>
  public boolean AtomicUsesUnsupportedLibcall(/*const*/ AtomicExpr /*P*/ E) /*const*/ {
    final /*const*/ Triple /*&*/ T = getTargetInfo().getTriple();
    if (!T.isOSDarwin()) {
      return false;
    }
    if (!(T.isiOS() && T.isOSVersionLT(7))
       && !(T.isMacOSX() && T.isOSVersionLT(10, 9))) {
      return false;
    }
    
    QualType AtomicTy = E.getPtr().getType().$arrow().getPointeeType();
    CharUnits sizeChars = getTypeSizeInChars(/*NO_COPY*/AtomicTy);
    long/*uint64_t*/ Size = sizeChars.getQuantity();
    CharUnits alignChars = getTypeAlignInChars(new QualType(AtomicTy));
    /*uint*/int Align = $long2uint(alignChars.getQuantity());
    /*uint*/int MaxInlineWidthInBits = getTargetInfo().getMaxAtomicInlineWidth();
    return (Size != $uint2ullong(Align)) || (toBits(new CharUnits(sizeChars)) > $uint2llong(MaxInlineWidthInBits));
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::getLangOpts">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ASTContext.h", line = 604,
   FQN="clang::ASTContext::getLangOpts", NM="_ZNK5clang10ASTContext11getLangOptsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZNK5clang10ASTContext11getLangOptsEv")
  //</editor-fold>
  public /*const*/ LangOptions /*&*/ getLangOpts() /*const*/ {
    return LangOpts;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::getSanitizerBlacklist">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ASTContext.h", line = 606,
   FQN="clang::ASTContext::getSanitizerBlacklist", NM="_ZNK5clang10ASTContext21getSanitizerBlacklistEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZNK5clang10ASTContext21getSanitizerBlacklistEv")
  //</editor-fold>
  public /*const*/ SanitizerBlacklist /*&*/ getSanitizerBlacklist() /*const*/ {
    return SanitizerBL.$star();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::getDiagnostics">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp", line = 1129,
   FQN="clang::ASTContext::getDiagnostics", NM="_ZNK5clang10ASTContext14getDiagnosticsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZNK5clang10ASTContext14getDiagnosticsEv")
  //</editor-fold>
  public DiagnosticsEngine /*&*/ getDiagnostics() /*const*/ {
    return SourceMgr.getDiagnostics();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::getFullLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ASTContext.h", line = 612,
   FQN="clang::ASTContext::getFullLoc", NM="_ZNK5clang10ASTContext10getFullLocENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZNK5clang10ASTContext10getFullLocENS_14SourceLocationE")
  //</editor-fold>
  public FullSourceLoc getFullLoc(SourceLocation Loc) /*const*/ {
    return new FullSourceLoc(/*NO_COPY*/Loc, SourceMgr);
  }

  
  /// \brief All comments in this translation unit.
  public RawCommentList Comments;
  
  /// \brief True if comments are already loaded from ExternalASTSource.
  public /*mutable */boolean CommentsLoaded;
  
  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::RawCommentAndCacheFlags">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ASTContext.h", line = 622,
   FQN="clang::ASTContext::RawCommentAndCacheFlags", NM="_ZN5clang10ASTContext23RawCommentAndCacheFlagsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZN5clang10ASTContext23RawCommentAndCacheFlagsE")
  //</editor-fold>
  public static class RawCommentAndCacheFlags implements NativePOD<RawCommentAndCacheFlags> {
  /*public:*/
    //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::RawCommentAndCacheFlags::Kind">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ASTContext.h", line = 624,
     FQN="clang::ASTContext::RawCommentAndCacheFlags::Kind", NM="_ZN5clang10ASTContext23RawCommentAndCacheFlags4KindE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZN5clang10ASTContext23RawCommentAndCacheFlags4KindE")
    //</editor-fold>
    public enum Kind implements Native.ComparableLower {
      /// We searched for a comment attached to the particular declaration, but
      /// didn't find any.
      ///
      /// getRaw() == 0.
      NoCommentInDecl(0),
      
      /// We have found a comment attached to this particular declaration.
      ///
      /// getRaw() != 0.
      FromDecl(NoCommentInDecl.getValue() + 1),
      
      /// This declaration does not have an attached comment, and we have
      /// searched the redeclaration chain.
      ///
      /// If getRaw() == 0, the whole redeclaration chain does not have any
      /// comments.
      ///
      /// If getRaw() != 0, it is a comment propagated from other
      /// redeclaration.
      FromRedecl(FromDecl.getValue() + 1);

      //<editor-fold defaultstate="collapsed" desc="hidden">
      public static Kind valueOf(int val) {
        Kind out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
        assert out != null : "no value for " + val;
        assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
        return out;
      }

      private static final class Values {
        private static final Kind[] VALUES;
        private static final Kind[] _VALUES; // [0] not used
        static {
          int max = 0;
          int min = 0;
          for (Kind kind : Kind.values()) {
            if (kind.value > max) { max = kind.value; }
            if (kind.value < min) { min = kind.value; }
          }
          _VALUES = new Kind[min < 0 ? (1-min) : 0];
          VALUES = new Kind[max >= 0 ? (1+max) : 0];
          for (Kind kind : Kind.values()) {
            if (kind.value < 0) {
              if (_VALUES[-kind.value] == null) {
              _VALUES[-kind.value] = kind;
            } else {
                assert true: "Must not replace " + _VALUES[-kind.value] + " by " + kind + ". Switch to int-based enum or filter valid.";
              }
            } else {
              if (VALUES[kind.value] == null) {
                VALUES[kind.value] = kind;
              } else {
                assert true: "Must not replace " + VALUES[kind.value] + " by " + kind + ". Switch to int-based enum or filter valid.";
              }
            }
          }
        }
      }

      private final /*uint*/int value;
      private Kind(int val) { this.value = (/*uint*/int)val;}
      public /*uint*/int getValue() { return value;}
      @Override public boolean $less(Object obj) { return Unsigned.$less_uint(value, ((Kind)obj).value);}
      @Override public boolean $lesseq(Object obj) { return Unsigned.$lesseq_uint(value, ((Kind)obj).value);}
      //</editor-fold>
    };
    
    //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::RawCommentAndCacheFlags::getKind">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ASTContext.h", line = 647,
     FQN="clang::ASTContext::RawCommentAndCacheFlags::getKind", NM="_ZNK5clang10ASTContext23RawCommentAndCacheFlags7getKindEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZNK5clang10ASTContext23RawCommentAndCacheFlags7getKindEv")
    //</editor-fold>
    public Kind getKind() /*const*//* __attribute__((pure))*/ {
      return Data.getInt();
    }

    
    //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::RawCommentAndCacheFlags::setKind">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ASTContext.h", line = 651,
     FQN="clang::ASTContext::RawCommentAndCacheFlags::setKind", NM="_ZN5clang10ASTContext23RawCommentAndCacheFlags7setKindENS1_4KindE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZN5clang10ASTContext23RawCommentAndCacheFlags7setKindENS1_4KindE")
    //</editor-fold>
    public void setKind(Kind K) {
      Data.setInt(K);
    }

    
    //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::RawCommentAndCacheFlags::getRaw">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ASTContext.h", line = 655,
     FQN="clang::ASTContext::RawCommentAndCacheFlags::getRaw", NM="_ZNK5clang10ASTContext23RawCommentAndCacheFlags6getRawEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZNK5clang10ASTContext23RawCommentAndCacheFlags6getRawEv")
    //</editor-fold>
    public /*const*/ RawComment /*P*/ getRaw() /*const*//* __attribute__((pure))*/ {
      return Data.getPointer();
    }

    
    //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::RawCommentAndCacheFlags::setRaw">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ASTContext.h", line = 659,
     FQN="clang::ASTContext::RawCommentAndCacheFlags::setRaw", NM="_ZN5clang10ASTContext23RawCommentAndCacheFlags6setRawEPKNS_10RawCommentE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZN5clang10ASTContext23RawCommentAndCacheFlags6setRawEPKNS_10RawCommentE")
    //</editor-fold>
    public void setRaw(/*const*/ RawComment /*P*/ RC) {
      Data.setPointer(RC);
    }

    
    //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::RawCommentAndCacheFlags::getOriginalDecl">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ASTContext.h", line = 663,
     FQN="clang::ASTContext::RawCommentAndCacheFlags::getOriginalDecl", NM="_ZNK5clang10ASTContext23RawCommentAndCacheFlags15getOriginalDeclEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZNK5clang10ASTContext23RawCommentAndCacheFlags15getOriginalDeclEv")
    //</editor-fold>
    public /*const*/ Decl /*P*/ getOriginalDecl() /*const*//* __attribute__((pure))*/ {
      return OriginalDecl;
    }

    
    //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::RawCommentAndCacheFlags::setOriginalDecl">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ASTContext.h", line = 667,
     FQN="clang::ASTContext::RawCommentAndCacheFlags::setOriginalDecl", NM="_ZN5clang10ASTContext23RawCommentAndCacheFlags15setOriginalDeclEPKNS_4DeclE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZN5clang10ASTContext23RawCommentAndCacheFlags15setOriginalDeclEPKNS_4DeclE")
    //</editor-fold>
    public void setOriginalDecl(/*const*/ Decl /*P*/ Orig) {
      OriginalDecl = Orig;
    }

  /*private:*/
    private PointerEnum2Pair</*const*/ RawComment /*P*/, Kind> Data;
    private /*const*/ Decl /*P*/ OriginalDecl;
    //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::RawCommentAndCacheFlags::RawCommentAndCacheFlags">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ASTContext.h", line = 622,
     FQN="clang::ASTContext::RawCommentAndCacheFlags::RawCommentAndCacheFlags", NM="_ZN5clang10ASTContext23RawCommentAndCacheFlagsC1ERKS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZN5clang10ASTContext23RawCommentAndCacheFlagsC1ERKS1_")
    //</editor-fold>
    public /*inline*/ RawCommentAndCacheFlags(final /*const*/ RawCommentAndCacheFlags /*&*/ $Prm0) {
      // : Data(.Data), OriginalDecl(.OriginalDecl) 
      //START JInit
      this.Data = new PointerEnum2Pair</*const*/ RawComment /*P*/, Kind>($Prm0.Data);
      this.OriginalDecl = $Prm0.OriginalDecl;
      //END JInit
    }

    //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::RawCommentAndCacheFlags::RawCommentAndCacheFlags">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ASTContext.h", line = 622,
     FQN="clang::ASTContext::RawCommentAndCacheFlags::RawCommentAndCacheFlags", NM="_ZN5clang10ASTContext23RawCommentAndCacheFlagsC1EOS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZN5clang10ASTContext23RawCommentAndCacheFlagsC1EOS1_")
    //</editor-fold>
    public /*inline*/ RawCommentAndCacheFlags(JD$Move _dparam, final RawCommentAndCacheFlags /*&&*/$Prm0) {
      // : Data(static_cast<RawCommentAndCacheFlags &&>().Data), OriginalDecl(static_cast<RawCommentAndCacheFlags &&>().OriginalDecl) 
      //START JInit
      this.Data = new PointerEnum2Pair</*const*/ RawComment /*P*/, Kind>(JD$Move.INSTANCE, $Prm0.Data);
      this.OriginalDecl = $Prm0.OriginalDecl;
      //END JInit
    }

    //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::RawCommentAndCacheFlags::RawCommentAndCacheFlags">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ASTContext.h", line = 622,
     FQN="clang::ASTContext::RawCommentAndCacheFlags::RawCommentAndCacheFlags", NM="_ZN5clang10ASTContext23RawCommentAndCacheFlagsC1Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZN5clang10ASTContext23RawCommentAndCacheFlagsC1Ev")
    //</editor-fold>
    public /*inline*/ RawCommentAndCacheFlags() {
      // : Data() 
      //START JInit
      this.Data = new PointerEnum2Pair</*const*/ RawComment /*P*/, Kind>();
      //END JInit
    }

    //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::RawCommentAndCacheFlags::operator=">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ASTContext.h", line = 622,
     FQN="clang::ASTContext::RawCommentAndCacheFlags::operator=", NM="_ZN5clang10ASTContext23RawCommentAndCacheFlagsaSERKS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZN5clang10ASTContext23RawCommentAndCacheFlagsaSERKS1_")
    //</editor-fold>
    public /*inline*/ RawCommentAndCacheFlags /*&*/ $assign(final /*const*/ RawCommentAndCacheFlags /*&*/ $Prm0) {
      this.Data.$assign($Prm0.Data);
      this.OriginalDecl = $Prm0.OriginalDecl;
      return /*Deref*/this;
    }

    //////////////////////////////////////////////////////////////
    // EXTRA MEMBERS: BEGIN

    @Override public RawCommentAndCacheFlags clone() { 
      return new RawCommentAndCacheFlags(this); 
    }

    @Override
    public boolean $eq(RawCommentAndCacheFlags other) {
      if (this == other) {
        return true;
      }
      if (other == null) {
        return false;
      }
      if (this.OriginalDecl != other.OriginalDecl) {
        return false;
      }
      if (this.Data.$noteq(other.Data)) {
        return false;
      }
      return true;
    }

    // EXTRA MEMBERS: END
    //////////////////////////////////////////////////////////////
    
    @Override public String toString() {
      return "" + "Data=" + Data // NOI18N
                + ", OriginalDecl=" + OriginalDecl; // NOI18N
    }
  };
  
  /// \brief Mapping from declarations to comments attached to any
  /// redeclaration.
  ///
  /// Raw comments are owned by Comments list.  This mapping is populated
  /// lazily.
  public /*mutable */DenseMap</*const*/ Decl /*P*/ , RawCommentAndCacheFlags> RedeclComments;
  
  /// \brief Mapping from declarations to parsed comments attached to any
  /// redeclaration.
  public /*mutable */DenseMap</*const*/ Decl /*P*/ , FullComment /*P*/ > ParsedComments;
  
  /// \brief Return the documentation comment attached to a given declaration,
  /// without looking into cache.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::getRawCommentForDeclNoCache">
  @Converted(kind = Converted.Kind.MANUAL,
   optimized = Converted.Optimization.VALUE_TYPE,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp", line = 64,
   FQN="clang::ASTContext::getRawCommentForDeclNoCache", NM="_ZNK5clang10ASTContext27getRawCommentForDeclNoCacheEPKNS_4DeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZNK5clang10ASTContext27getRawCommentForDeclNoCacheEPKNS_4DeclE")
  //</editor-fold>
  public RawComment /*P*/ getRawCommentForDeclNoCache(/*const*/ Decl /*P*/ D) /*const*/ {
    if (!CommentsLoaded && ExternalSource.$bool()) {
      ExternalSource.$arrow().ReadComments();
      ArrayRef<RawComment /*P*/ > RawComments = Comments.getComments();
      assert (std.is_sorted(RawComments.begin(), RawComments.end(), new BeforeThanCompareRawComment(SourceMgr)));
      
      CommentsLoaded = true;
    }
    assert Native.$bool(D);
    
    // User can not attach documentation to implicit declarations.
    if (D.isImplicit()) {
      return null;
    }
    {
      
      // User can not attach documentation to implicit instantiations.
      /*const*/ FunctionDecl /*P*/ FD = dyn_cast_FunctionDecl(D);
      if ((FD != null)) {
        if (FD.getTemplateSpecializationKind() == TemplateSpecializationKind.TSK_ImplicitInstantiation) {
          return null;
        }
      }
    }
    {
      
      /*const*/ VarDecl /*P*/ VD = dyn_cast_VarDecl(D);
      if ((VD != null)) {
        if (VD.isStaticDataMember()
           && VD.getTemplateSpecializationKind() == TemplateSpecializationKind.TSK_ImplicitInstantiation) {
          return null;
        }
      }
    }
    {
      
      /*const*/ CXXRecordDecl /*P*/ CRD = dyn_cast_CXXRecordDecl(D);
      if ((CRD != null)) {
        if (CRD.getTemplateSpecializationKind() == TemplateSpecializationKind.TSK_ImplicitInstantiation) {
          return null;
        }
      }
    }
    {
      
      /*const*/ ClassTemplateSpecializationDecl /*P*/ CTSD = dyn_cast_ClassTemplateSpecializationDecl(D);
      if ((CTSD != null)) {
        TemplateSpecializationKind TSK = CTSD.getSpecializationKind();
        if (TSK == TemplateSpecializationKind.TSK_ImplicitInstantiation
           || TSK == TemplateSpecializationKind.TSK_Undeclared) {
          return null;
        }
      }
    }
    {
      
      /*const*/ EnumDecl /*P*/ ED = dyn_cast_EnumDecl(D);
      if ((ED != null)) {
        if (ED.getTemplateSpecializationKind() == TemplateSpecializationKind.TSK_ImplicitInstantiation) {
          return null;
        }
      }
    }
    {
      /*const*/ TagDecl /*P*/ TD = dyn_cast_TagDecl(D);
      if ((TD != null)) {
        // When tag declaration (but not definition!) is part of the
        // decl-specifier-seq of some other declaration, it doesn't get comment
        if (TD.isEmbeddedInDeclarator() && !TD.isCompleteDefinition()) {
          return null;
        }
      }
    }
    // TODO: handle comments for function parameters properly.
    if (isa_ParmVarDecl(D)) {
      return null;
    }
    
    // TODO: we could look up template parameter documentation in the template
    // documentation.
    if (isa_TemplateTypeParmDecl(D)
       || isa_NonTypeTemplateParmDecl(D)
       || isa_TemplateTemplateParmDecl(D)) {
      return null;
    }
    
    ArrayRef<RawComment /*P*/ > RawComments = Comments.getComments();
    
    // If there are no comments anywhere, we won't find anything.
    if (RawComments.empty()) {
      return null;
    }
    
    // Find declaration location.
    // For Objective-C declarations we generally don't expect to have multiple
    // declarators, thus use declaration starting location as the "declaration
    // location".
    // For all other declarations multiple declarators are used quite frequently,
    // so we use the location of the identifier as the "declaration location".
    SourceLocation DeclLoc/*J*/= new SourceLocation();
    if (isa_ObjCMethodDecl(D) || isa_ObjCContainerDecl(D)
       || isa_ObjCPropertyDecl(D)
       || isa_RedeclarableTemplateDecl(D)
       || isa_ClassTemplateSpecializationDecl(D)) {
      DeclLoc.$assignMove(D.getLocStart());
    } else {
      DeclLoc.$assignMove(D.getLocation());
      if (DeclLoc.isMacroID()) {
        if (isa_TypedefDecl(D)) {
          // If location of the typedef name is in a macro, it is because being
          // declared via a macro. Try using declaration's starting location as
          // the "declaration location".
          DeclLoc.$assignMove(D.getLocStart());
        } else {
          /*const*/ TagDecl /*P*/ TD = dyn_cast_TagDecl(D);
          if ((TD != null)) {
            // If location of the tag decl is inside a macro, but the spelling of
            // the tag name comes from a macro argument, it looks like a special
            // macro like NS_ENUM is being used to define the tag decl.  In that
            // case, adjust the source location to the expansion loc so that we can
            // attach the comment to the tag decl.
            if (SourceMgr.isMacroArgExpansion(/*NO_COPY*/DeclLoc)
               && TD.isCompleteDefinition()) {
              DeclLoc.$assignMove(SourceMgr.getExpansionLoc(/*NO_COPY*/DeclLoc));
            }
          }
        }
      }
    }
    
    // If the declaration doesn't map directly to a location in a file, we
    // can't find the comment.
    if (DeclLoc.isInvalid() || !DeclLoc.isFileID()) {
      return null;
    }
    
    // Find the comment that occurs just after this declaration.
    type$ptr<RawComment /*P*/ /*P*/> Comment = create_type$ptr();
    {
      // When searching for comments during parsing, the comment we are looking
      // for is usually among the last two comments we parsed -- check them
      // first.
      RawComment CommentAtDeclLoc/*J*/= new RawComment(SourceMgr, new SourceRange(/*NO_COPY*/DeclLoc), false, 
          LangOpts.CommentOpts.ParseAllComments);
      BeforeThanCompareRawComment Compare/*J*/= new BeforeThanCompareRawComment(SourceMgr);
      type$ptr<RawComment /*P*/ /*P*/> MaybeBeforeDecl = $tryClone(RawComments.end().$sub(1));
      boolean Found = Compare.$call$Ptr(MaybeBeforeDecl.$star(), $AddrOf(CommentAtDeclLoc));
      if (!Found && $greatereq_uint(RawComments.size(), 2)) {
        MaybeBeforeDecl.$postDec();
        Found = Compare.$call$Ptr(MaybeBeforeDecl.$star(), $AddrOf(CommentAtDeclLoc));
      }
      if (Found) {
        Comment = $tryClone(MaybeBeforeDecl.$add(1));
        assert ($eq_ptr(Comment, std.lower_bound(RawComments.begin(), RawComments.end(), $AddrOf(CommentAtDeclLoc), new BeforeThanCompareRawComment(Compare))));
      } else {
        // Slow path.
        Comment = $tryClone(std.lower_bound(RawComments.begin(), RawComments.end(), 
            $AddrOf(CommentAtDeclLoc), new BeforeThanCompareRawComment(Compare)));
      }
    }
    
    // Decompose the location for the declaration and find the beginning of the
    // file buffer.
    std.pairTypeUInt<FileID> DeclLocDecomp = SourceMgr.getDecomposedLoc(/*NO_COPY*/DeclLoc);
    
    // First check whether we have a trailing comment.
    if ($noteq_ptr(Comment, RawComments.end())
       && (Comment.$star()).isDocumentation() && (Comment.$star()).isTrailingComment()
       && (isa_FieldDecl(D) || isa_EnumConstantDecl(D) || isa_VarDecl(D)
       || isa_ObjCMethodDecl(D) || isa_ObjCPropertyDecl(D))) {
      std.pairTypeUInt<FileID> CommentBeginDecomp = SourceMgr.getDecomposedLoc((Comment.$star()).getSourceRange().getBegin());
      // Check that Doxygen trailing comment comes after the declaration, starts
      // on the same line and in the same file as the declaration.
      if (DeclLocDecomp.first.$eq(CommentBeginDecomp.first)
         && SourceMgr.getLineNumber(/*NO_COPY*/DeclLocDecomp.first, DeclLocDecomp.second)
         == SourceMgr.getLineNumber(/*NO_COPY*/CommentBeginDecomp.first, 
          CommentBeginDecomp.second)) {
        return Comment.$star();
      }
    }
    
    // The comment just after the declaration was not a trailing comment.
    // Let's look at the previous comment.
    if ($eq_ptr(Comment, RawComments.begin())) {
      return null;
    }
    Comment.$preDec();
    
    // Check that we actually have a non-member Doxygen comment.
    if (!(Comment.$star()).isDocumentation() || (Comment.$star()).isTrailingComment()) {
      return null;
    }
    
    // Decompose the end of the comment.
    std.pairTypeUInt<FileID> CommentEndDecomp = SourceMgr.getDecomposedLoc((Comment.$star()).getSourceRange().getEnd());
    
    // If the comment and the declaration aren't in the same file, then they
    // aren't related.
    if (DeclLocDecomp.first.$noteq(CommentEndDecomp.first)) {
      return null;
    }
    
    // Get the corresponding buffer.
    bool$ptr Invalid = /*JAVA:PERF*/null;//create_bool$ptr(false);
    StringRef $Buffer = SourceMgr.getBufferData(/*NO_COPY*/DeclLocDecomp.first, 
            /*AddrOf*/Invalid);
    // JAVA: PERF
    if ($Buffer == SourceManager.INVALID_BUFFER_DATA) {
      return null;
    }
    
    /*const*/char$ptr/*char P*/ Buffer = $tryClone($Buffer.data());
    
    // Extract text between the comment and declaration.
    StringRef Text/*J*/= new StringRef(Buffer.$add(CommentEndDecomp.second), 
        DeclLocDecomp.second - CommentEndDecomp.second);
    
    // There should be no other declarations or preprocessor directives between
    // comment and declaration.
    if (Text.find_first_of(/*STRINGREF_STR*/";{}#@") != StringRef.npos) {
      return null;
    }
    
    return Comment.$star();
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::getRawCommentList">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ASTContext.h", line = 692,
   FQN="clang::ASTContext::getRawCommentList", NM="_ZN5clang10ASTContext17getRawCommentListEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZN5clang10ASTContext17getRawCommentListEv")
  //</editor-fold>
  public RawCommentList /*&*/ getRawCommentList() {
    return Comments;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::addComment">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ASTContext.h", line = 696,
   FQN="clang::ASTContext::addComment", NM="_ZN5clang10ASTContext10addCommentERKNS_10RawCommentE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZN5clang10ASTContext10addCommentERKNS_10RawCommentE")
  //</editor-fold>
  public void addComment(final /*const*/ RawComment /*&*/ RC) {
    assert (LangOpts.RetainCommentsFromSystemHeaders || !SourceMgr.isInSystemHeader(RC.getSourceRange().getBegin()));
    Comments.addComment(RC, BumpAlloc);
  }

  
  /// \brief Return the documentation comment attached to a given declaration.
  /// Returns NULL if no comment is attached.
  ///
  /// \param OriginalDecl if not NULL, is set to declaration AST node that had
  /// the comment, if the comment we found comes from a redeclaration.
  // anonymous namespace
  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::getRawCommentForAnyRedecl">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*"Native.$bool" vs "!= null"*/,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp", line = 333,
   FQN="clang::ASTContext::getRawCommentForAnyRedecl", NM="_ZNK5clang10ASTContext25getRawCommentForAnyRedeclEPKNS_4DeclEPS3_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZNK5clang10ASTContext25getRawCommentForAnyRedeclEPKNS_4DeclEPS3_")
  //</editor-fold>
  public /*const*/ RawComment /*P*/ getRawCommentForAnyRedecl(/*const*/ Decl /*P*/ D) /*const*/ {
    return getRawCommentForAnyRedecl(D, 
                           (type$ptr</*const*/ Decl /*P*/ /*P*/>)null);
  }
  public /*const*/ RawComment /*P*/ getRawCommentForAnyRedecl(/*const*/ Decl /*P*/ D, 
                           type$ptr</*const*/ Decl /*P*/ /*P*/> OriginalDecl/*= null*/) /*const*/ {
    D = adjustDeclToTemplate(D);
    {
      DenseMapIterator</*const*/ Decl /*P*/ , RawCommentAndCacheFlags> Pos = RedeclComments.find(D);
      if (Pos.$noteq(/*NO_ITER_COPY*/RedeclComments.end())) {
        final /*const*/ RawCommentAndCacheFlags /*&*/ Raw = Pos.$arrow().second;
        if (Raw.getKind() != RawCommentAndCacheFlags.Kind.NoCommentInDecl) {
          if (OriginalDecl != null) {
            OriginalDecl.$set(Raw.getOriginalDecl());
          }
          return Raw.getRaw();
        }
      }
    }
    
    // Search for comments attached to declarations in the redeclaration chain.
    /*const*/ RawComment /*P*/ RC = null;
    /*const*/ Decl /*P*/ OriginalDeclForRC = null;
    for (Decl /*P*/ I : D.decl_redecls()) {
      DenseMapIterator</*const*/ Decl /*P*/ , RawCommentAndCacheFlags> Pos = RedeclComments.find(I);
      if (Pos.$noteq(/*NO_ITER_COPY*/RedeclComments.end())) {
        final /*const*/ RawCommentAndCacheFlags /*&*/ Raw = Pos.$arrow().second;
        if (Raw.getKind() != RawCommentAndCacheFlags.Kind.NoCommentInDecl) {
          RC = Raw.getRaw();
          OriginalDeclForRC = Raw.getOriginalDecl();
          break;
        }
      } else {
        RC = getRawCommentForDeclNoCache(I);
        OriginalDeclForRC = I;
        RawCommentAndCacheFlags Raw/*J*/= new RawCommentAndCacheFlags();
        if ((RC != null)) {
          // Call order swapped to work around ICE in VS2015 RTM (Release Win32)
          // https://connect.microsoft.com/VisualStudio/feedback/details/1741530
          Raw.setKind(RawCommentAndCacheFlags.Kind.FromDecl);
          Raw.setRaw(RC);
        } else {
          Raw.setKind(RawCommentAndCacheFlags.Kind.NoCommentInDecl);
        }
        Raw.setOriginalDecl(I);
        RedeclComments.$at_T1$RR(I).$assign(Raw);
        if ((RC != null)) {
          break;
        }
      }
    }
    
    // If we found a comment, it should be a documentation comment.
    assert (!(RC != null) || RC.isDocumentation());
    if (OriginalDecl != null) {
      OriginalDecl.$set(OriginalDeclForRC);
    }
    
    // Update cache for every declaration in the redeclaration chain.
    RawCommentAndCacheFlags Raw/*J*/= new RawCommentAndCacheFlags();
    Raw.setRaw(RC);
    Raw.setKind(RawCommentAndCacheFlags.Kind.FromRedecl);
    Raw.setOriginalDecl(OriginalDeclForRC);
    
    for (Decl /*P*/ I : D.decl_redecls()) {
      final RawCommentAndCacheFlags /*&*/ R = RedeclComments.$at_T1$RR(I);
      if (R.getKind() == RawCommentAndCacheFlags.Kind.NoCommentInDecl) {
        R.$assign(Raw);
      }
    }
    
    return RC;
  }

  
  /// Return parsed documentation comment attached to a given declaration.
  /// Returns NULL if no comment is attached.
  ///
  /// \param PP the Preprocessor used with this TU.  Could be NULL if
  /// preprocessor is not available.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::getCommentForDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp", line = 441,
   FQN="clang::ASTContext::getCommentForDecl", NM="_ZNK5clang10ASTContext17getCommentForDeclEPKNS_4DeclEPKNS_12PreprocessorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZNK5clang10ASTContext17getCommentForDeclEPKNS_4DeclEPKNS_12PreprocessorE")
  //</editor-fold>
  public FullComment /*P*/ getCommentForDecl(/*const*/ Decl /*P*/ D, 
                   /*const*/ Preprocessor /*P*/ PP) /*const*/ {
    if (D.isInvalidDecl()) {
      return null;
    }
    D = adjustDeclToTemplate(D);
    
    /*const*/ Decl /*P*/ Canonical = D.getCanonicalDecl$Const();
    DenseMapIterator</*const*/ Decl /*P*/ , FullComment /*P*/ > Pos = ParsedComments.find(Canonical);
    if (Pos.$noteq(/*NO_ITER_COPY*/ParsedComments.end())) {
      if (Canonical != D) {
        FullComment /*P*/ FC = Pos.$arrow().second;
        FullComment /*P*/ CFC = cloneFullComment(FC, D);
        return CFC;
      }
      return Pos.$arrow().second;
    }
    
    type$ptr</*const*/ Decl /*P*/ > OriginalDecl = create_type$null$ptr();
    
    /*const*/ RawComment /*P*/ RC = getRawCommentForAnyRedecl(D, $AddrOf(OriginalDecl));
    if (!(RC != null)) {
      if (isa_ObjCMethodDecl(D) || isa_FunctionDecl(D)) {
        SmallVector</*const*/ NamedDecl /*P*/ > Overridden/*J*/= new SmallVector</*const*/ NamedDecl /*P*/ >(8, (/*const*/ NamedDecl /*P*/ )null);
        /*const*/ ObjCMethodDecl /*P*/ OMD = dyn_cast_ObjCMethodDecl(D);
        if ((OMD != null) && OMD.isPropertyAccessor()) {
          {
            /*const*/ ObjCPropertyDecl /*P*/ PDecl = OMD.findPropertyDecl();
            if ((PDecl != null)) {
              {
                FullComment /*P*/ FC = getCommentForDecl(PDecl, PP);
                if ((FC != null)) {
                  return cloneFullComment(FC, D);
                }
              }
            }
          }
        }
        if ((OMD != null)) {
          addRedeclaredMethods(OMD, Overridden);
        }
        getOverriddenMethods(dyn_cast_NamedDecl(D), Overridden);
        for (/*uint*/int i = 0, e = Overridden.size(); $less_uint(i, e); i++)  {
          {
            FullComment /*P*/ FC = getCommentForDecl(Overridden.$at(i), PP);
            if ((FC != null)) {
              return cloneFullComment(FC, D);
            }
          }
        }
      } else {
        /*const*/ TypedefNameDecl /*P*/ TD = dyn_cast_TypedefNameDecl(D);
        if ((TD != null)) {
          // Attach any tag type's documentation to its typedef if latter
          // does not have one of its own.
          QualType QT = TD.getUnderlyingType();
          {
            /*const*/ TagType /*P*/ TT = QT.$arrow().getAs(TagType.class);
            if ((TT != null)) {
              {
                /*const*/ Decl /*P*/ TD$1 = TT.getDecl();
                if ((TD$1 != null)) {
                  {
                    FullComment /*P*/ FC = getCommentForDecl(TD$1, PP);
                    if ((FC != null)) {
                      return cloneFullComment(FC, D);
                    }
                  }
                }
              }
            }
          }
        } else {
          /*const*/ ObjCInterfaceDecl /*P*/ IC = dyn_cast_ObjCInterfaceDecl(D);
          if ((IC != null)) {
            while ((IC.getSuperClass() != null)) {
              IC = IC.getSuperClass();
              {
                FullComment /*P*/ FC = getCommentForDecl(IC, PP);
                if ((FC != null)) {
                  return cloneFullComment(FC, D);
                }
              }
            }
          } else {
            /*const*/ ObjCCategoryDecl /*P*/ CD = dyn_cast_ObjCCategoryDecl(D);
            if ((CD != null)) {
              {
                /*const*/ ObjCInterfaceDecl /*P*/ IC$1 = CD.getClassInterface$Const();
                if ((IC$1 != null)) {
                  {
                    FullComment /*P*/ FC = getCommentForDecl(IC$1, PP);
                    if ((FC != null)) {
                      return cloneFullComment(FC, D);
                    }
                  }
                }
              }
            } else {
              /*const*/ CXXRecordDecl /*P*/ RD = dyn_cast_CXXRecordDecl(D);
              if ((RD != null)) {
                if (!((RD = RD.getDefinition()) != null)) {
                  return null;
                }
                // Check non-virtual bases.
                for (final /*const*/ CXXBaseSpecifier /*&*/ I : RD.bases$Const()) {
                  if (I.isVirtual() || (I.getAccessSpecifier() != AccessSpecifier.AS_public)) {
                    continue;
                  }
                  QualType Ty = I.getType();
                  if (Ty.isNull()) {
                    continue;
                  }
                  {
                    /*const*/ CXXRecordDecl /*P*/ NonVirtualBase = Ty.$arrow().getAsCXXRecordDecl();
                    if ((NonVirtualBase != null)) {
                      if (!((NonVirtualBase = NonVirtualBase.getDefinition()) != null)) {
                        continue;
                      }
                      {
                        
                        FullComment /*P*/ FC = getCommentForDecl((NonVirtualBase), PP);
                        if ((FC != null)) {
                          return cloneFullComment(FC, D);
                        }
                      }
                    }
                  }
                }
                // Check virtual bases.
                for (final /*const*/ CXXBaseSpecifier /*&*/ I : RD.vbases$Const()) {
                  if (I.getAccessSpecifier() != AccessSpecifier.AS_public) {
                    continue;
                  }
                  QualType Ty = I.getType();
                  if (Ty.isNull()) {
                    continue;
                  }
                  {
                    /*const*/ CXXRecordDecl /*P*/ VirtualBase = Ty.$arrow().getAsCXXRecordDecl();
                    if ((VirtualBase != null)) {
                      if (!((VirtualBase = VirtualBase.getDefinition()) != null)) {
                        continue;
                      }
                      {
                        FullComment /*P*/ FC = getCommentForDecl((VirtualBase), PP);
                        if ((FC != null)) {
                          return cloneFullComment(FC, D);
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
      return null;
    }
    
    // If the RawComment was attached to other redeclaration of this Decl, we
    // should parse the comment in context of that other Decl.  This is important
    // because comments can contain references to parameter names which can be
    // different across redeclarations.
    if (D != OriginalDecl.$star()) {
      return getCommentForDecl(OriginalDecl.$star(), PP);
    }
    
    FullComment /*P*/ FC = RC.parse(/*Deref*/this, PP, D);
    ParsedComments.$set(Canonical, FC);
    return FC;
  }

  
  /// Return parsed documentation comment attached to a given declaration.
  /// Returns NULL if no comment is attached. Does not look at any
  /// redeclarations of the declaration.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::getLocalCommentForDeclUncached">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp", line = 436,
   FQN="clang::ASTContext::getLocalCommentForDeclUncached", NM="_ZNK5clang10ASTContext30getLocalCommentForDeclUncachedEPKNS_4DeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZNK5clang10ASTContext30getLocalCommentForDeclUncachedEPKNS_4DeclE")
  //</editor-fold>
  public FullComment /*P*/ getLocalCommentForDeclUncached(/*const*/ Decl /*P*/ D) /*const*/ {
    /*const*/ RawComment /*P*/ RC = getRawCommentForDeclNoCache(D);
    return (RC != null) ? RC.parse(/*Deref*/this, (/*const*/ Preprocessor /*P*/ )null, D) : null;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::cloneFullComment">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp", line = 421,
   FQN="clang::ASTContext::cloneFullComment", NM="_ZNK5clang10ASTContext16cloneFullCommentEPNS_8comments11FullCommentEPKNS_4DeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZNK5clang10ASTContext16cloneFullCommentEPNS_8comments11FullCommentEPKNS_4DeclE")
  //</editor-fold>
  public FullComment /*P*/ cloneFullComment(FullComment /*P*/ FC, 
                  /*const*/ Decl /*P*/ D) /*const*/ {
    DeclInfo /*P*/ ThisDeclInfo = /*FIXME:NEW_EXPR [operator new] NM=_ZnwjRKN5clang10ASTContextEj*/
    /*new (*this)*/ new DeclInfo();
    ThisDeclInfo.CommentDecl = D;
    ThisDeclInfo.IsFilled = false;
    ThisDeclInfo.fill();
    ThisDeclInfo.CommentDecl = FC.getDecl();
    if (!(ThisDeclInfo.TemplateParameters != null)) {
      ThisDeclInfo.TemplateParameters = FC.getDeclInfo().TemplateParameters;
    }
    FullComment /*P*/ CFC = /*FIXME:NEW_EXPR [operator new] NM=_ZnwjRKN5clang10ASTContextEj*/
    /*new (*this)*/ new FullComment(FC.getBlocks(), 
        ThisDeclInfo);
    return CFC;
  }

/*private:*/
  private /*mutable */CommandTraits CommentCommandTraits;
  
  /// \brief Iterator that visits import declarations.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::import_iterator">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ASTContext.h", line = 731,
   FQN="clang::ASTContext::import_iterator", NM="_ZN5clang10ASTContext15import_iteratorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZN5clang10ASTContext15import_iteratorE")
  //</editor-fold>
  private static class import_iterator implements type$iterator<import_iterator,ImportDecl/*P*/> {
    private ImportDecl /*P*/ Import;
  /*public:*/
    /*typedef ImportDecl *value_type*/
//    public final class value_type extends ImportDecl /*P*/ { };
    /*typedef ImportDecl *reference*/
//    public final class reference extends ImportDecl /*P*/ { };
    /*typedef ImportDecl *pointer*/
//    public final class pointer extends ImportDecl /*P*/ { };
    /*typedef int difference_type*/;
    /*typedef std::forward_iterator_tag iterator_category*/
//    public final class iterator_category extends std.forward_iterator_tag{ };
    
    //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::import_iterator::import_iterator">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ASTContext.h", line = 741,
     FQN="clang::ASTContext::import_iterator::import_iterator", NM="_ZN5clang10ASTContext15import_iteratorC1Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZN5clang10ASTContext15import_iteratorC1Ev")
    //</editor-fold>
    public import_iterator() {
      // : Import(implicit ImportDecl * ()) 
      //START JInit
      this.Import = /*implicit-init*/((ImportDecl /*P*/ )/*zero-init*/null);
      //END JInit
    }

    //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::import_iterator::import_iterator">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ASTContext.h", line = 742,
     FQN="clang::ASTContext::import_iterator::import_iterator", NM="_ZN5clang10ASTContext15import_iteratorC1EPNS_10ImportDeclE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZN5clang10ASTContext15import_iteratorC1EPNS_10ImportDeclE")
    //</editor-fold>
    public /*explicit*/ import_iterator(ImportDecl /*P*/ Import) {
      // : Import(Import) 
      //START JInit
      this.Import = Import;
      //END JInit
    }

    
    //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::import_iterator::operator*">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ASTContext.h", line = 744,
     FQN="clang::ASTContext::import_iterator::operator*", NM="_ZNK5clang10ASTContext15import_iteratordeEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZNK5clang10ASTContext15import_iteratordeEv")
    //</editor-fold>
    public ImportDecl /*P*/ $star() /*const*/ {
      return Import;
    }

    //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::import_iterator::operator->">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ASTContext.h", line = 745,
     FQN="clang::ASTContext::import_iterator::operator->", NM="_ZNK5clang10ASTContext15import_iteratorptEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZNK5clang10ASTContext15import_iteratorptEv")
    //</editor-fold>
    public ImportDecl /*P*/ $arrow() /*const*/ {
      return Import;
    }

    
    //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::import_iterator::operator++">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ASTContext.h", line = 747,
     FQN="clang::ASTContext::import_iterator::operator++", NM="_ZN5clang10ASTContext15import_iteratorppEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZN5clang10ASTContext15import_iteratorppEv")
    //</editor-fold>
    public import_iterator /*&*/ $preInc() {
      Import = ASTContext.getNextLocalImport(Import);
      return /*Deref*/this;
    }

    
    //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::import_iterator::operator++">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ASTContext.h", line = 752,
     FQN="clang::ASTContext::import_iterator::operator++", NM="_ZN5clang10ASTContext15import_iteratorppEi",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZN5clang10ASTContext15import_iteratorppEi")
    //</editor-fold>
    public import_iterator $postInc(int $Prm0) {
      import_iterator Other/*J*/= new import_iterator(/*Deref*/this);
      (/*Deref*/this).$preInc();
      return Other;
    }

    
    /*friend*///<editor-fold defaultstate="collapsed" desc="clang::operator==">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ASTContext.h", line = 758,
     FQN="clang::operator==", NM="_ZN5clangeqENS_10ASTContext15import_iteratorES1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZN5clangeqENS_10ASTContext15import_iteratorES1_")
    //</editor-fold>
    public static boolean $eq_import_iterator(import_iterator X, import_iterator Y) {
      return X.Import == Y.Import;
    }

    
    /*friend*///<editor-fold defaultstate="collapsed" desc="clang::operator!=">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ASTContext.h", line = 762,
     FQN="clang::operator!=", NM="_ZN5clangneENS_10ASTContext15import_iteratorES1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZN5clangneENS_10ASTContext15import_iteratorES1_")
    //</editor-fold>
    public static boolean $noteq_import_iterator(import_iterator X, import_iterator Y) {
      return X.Import != Y.Import;
    }

    //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::import_iterator::import_iterator">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ASTContext.h", line = 731,
     FQN="clang::ASTContext::import_iterator::import_iterator", NM="_ZN5clang10ASTContext15import_iteratorC1ERKS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZN5clang10ASTContext15import_iteratorC1ERKS1_")
    //</editor-fold>
    public /*inline*/ import_iterator(final /*const*/ import_iterator /*&*/ $Prm0) {
      // : Import(.Import) 
      //START JInit
      this.Import = $Prm0.Import;
      //END JInit
    }

    //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::import_iterator::import_iterator">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ASTContext.h", line = 731,
     FQN="clang::ASTContext::import_iterator::import_iterator", NM="_ZN5clang10ASTContext15import_iteratorC1EOS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZN5clang10ASTContext15import_iteratorC1EOS1_")
    //</editor-fold>
    public /*inline*/ import_iterator(JD$Move _dparam, final import_iterator /*&&*/$Prm0) {
      // : Import(static_cast<import_iterator &&>().Import) 
      //START JInit
      this.Import = $Prm0.Import;
      //END JInit
    }

    //////////////////////////////////////////////////////////////
    // EXTRA MEMBERS: BEGIN

    @Override
    public import_iterator clone() {
      return new import_iterator(this);
    }

    @Override
    public boolean $eq(Object other) {
      return $eq_import_iterator(this, (import_iterator) other);
    }

    @Override
    public boolean $noteq(Object other) {
      return $noteq_import_iterator(this, (import_iterator) other);
    }
    
    // EXTRA MEMBERS: END
    //////////////////////////////////////////////////////////////
    
    @Override public String toString() {
      return "" + "Import=" + Import; // NOI18N
    }
  };
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::getCommentCommandTraits">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ASTContext.h", line = 768,
   FQN="clang::ASTContext::getCommentCommandTraits", NM="_ZNK5clang10ASTContext23getCommentCommandTraitsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZNK5clang10ASTContext23getCommentCommandTraitsEv")
  //</editor-fold>
  public CommandTraits /*&*/ getCommentCommandTraits() /*const*/ {
    return CommentCommandTraits;
  }

  
  /// \brief Retrieve the attributes for the given declaration.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::getDeclAttrs">
  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::getDeclAttrs">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*ref$at and sizeof*/,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp", line = 1133,
   FQN="clang::ASTContext::getDeclAttrs", NM="_ZN5clang10ASTContext12getDeclAttrsEPKNS_4DeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZN5clang10ASTContext12getDeclAttrsEPKNS_4DeclE")
  //</editor-fold>
  public SmallVector<Attr /*P*/>/*&*/ getDeclAttrs(/*const*/ Decl /*P*/ D) {
    final type$ref<SmallVector<Attr /*P*/>/*P*/> /*&*/ Result = DeclAttrs.ref$at(D);
    if (!(Result.$deref() != null)) {
      Object/*void P*/ Mem = Allocate$JavaRef(/*JAVA*/true ? 1 : $sizeof_SmallVector$Attr$P());
      Result.$set(/*FIXME:NEW_EXPR[System]*//*new (Mem)*/ new SmallVector<Attr /*P*/>(4, null));
    }
    
    return $Deref(Result.$deref());
  }

  
  /// \brief Erase the attributes corresponding to the given declaration.
  
  /// \brief Erase the attributes corresponding to the given declaration.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::eraseDeclAttrs">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp", line = 1144,
   FQN="clang::ASTContext::eraseDeclAttrs", NM="_ZN5clang10ASTContext14eraseDeclAttrsEPKNS_4DeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZN5clang10ASTContext14eraseDeclAttrsEPKNS_4DeclE")
  //</editor-fold>
  public void eraseDeclAttrs(/*const*/ Decl /*P*/ D) {
    DenseMapIterator</*const*/ Decl /*P*/ , SmallVector<Attr /*P*/>/*P*/ > Pos = DeclAttrs.find(D);
    if (Pos.$noteq(/*NO_ITER_COPY*/DeclAttrs.end())) {
      Pos.$arrow().second.$destroy();
      DeclAttrs.erase(new DenseMapIterator</*const*/ Decl /*P*/ , SmallVector<Attr /*P*/>/*P*/ >(Pos));
    }
  }

  
  /// \brief If this variable is an instantiated static data member of a
  /// class template specialization, returns the templated static data member
  /// from which it was instantiated.
  // FIXME: Remove ?
  
  // FIXME: Remove ?
  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::getInstantiatedFromStaticDataMember">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp", line = 1153,
   FQN="clang::ASTContext::getInstantiatedFromStaticDataMember", NM="_ZN5clang10ASTContext35getInstantiatedFromStaticDataMemberEPKNS_7VarDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZN5clang10ASTContext35getInstantiatedFromStaticDataMemberEPKNS_7VarDeclE")
  //</editor-fold>
  public MemberSpecializationInfo /*P*/ getInstantiatedFromStaticDataMember(/*const*/ VarDecl /*P*/ Var) {
    assert (Var.isStaticDataMember()) : "Not a static data member";
    return getTemplateOrSpecializationInfo(Var).dyn_cast(MemberSpecializationInfo /*P*/.class);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::getTemplateOrSpecializationInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp", line = 1160,
   FQN="clang::ASTContext::getTemplateOrSpecializationInfo", NM="_ZN5clang10ASTContext31getTemplateOrSpecializationInfoEPKNS_7VarDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZN5clang10ASTContext31getTemplateOrSpecializationInfoEPKNS_7VarDeclE")
  //</editor-fold>
  public PointerUnion<VarTemplateDecl /*P*/ , MemberSpecializationInfo /*P*/ > getTemplateOrSpecializationInfo(/*const*/ VarDecl /*P*/ Var) {
    DenseMapIterator</*const*/ VarDecl /*P*/ , PointerUnion<VarTemplateDecl /*P*/ , MemberSpecializationInfo /*P*/ >> Pos = TemplateOrInstantiation.find(Var);
    if (Pos.$eq(/*NO_ITER_COPY*/TemplateOrInstantiation.end())) {
      return new PointerUnion<VarTemplateDecl /*P*/ , MemberSpecializationInfo /*P*/ >(VarTemplateDecl /*P*/ .class);
    }
    
    return new PointerUnion<VarTemplateDecl /*P*/ , MemberSpecializationInfo /*P*/ >(Pos.$arrow().second);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::getClassScopeSpecializationPattern">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp", line = 1188,
   FQN="clang::ASTContext::getClassScopeSpecializationPattern", NM="_ZN5clang10ASTContext34getClassScopeSpecializationPatternEPKNS_12FunctionDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZN5clang10ASTContext34getClassScopeSpecializationPatternEPKNS_12FunctionDeclE")
  //</editor-fold>
  public FunctionDecl /*P*/ getClassScopeSpecializationPattern(/*const*/ FunctionDecl /*P*/ FD) {
    assert ((FD != null)) : "Specialization is 0";
    DenseMapIterator</*const*/ FunctionDecl /*P*/ , FunctionDecl /*P*/ > Pos = new DenseMapIterator</*const*/ FunctionDecl /*P*/ , FunctionDecl /*P*/ >(ClassScopeSpecializationPattern.find(FD));
    if (Pos.$eq(/*NO_ITER_COPY*/ClassScopeSpecializationPattern.end())) {
      return null;
    }
    
    return Pos.$arrow().second;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::setClassScopeSpecializationPattern">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp", line = 1199,
   FQN="clang::ASTContext::setClassScopeSpecializationPattern", NM="_ZN5clang10ASTContext34setClassScopeSpecializationPatternEPNS_12FunctionDeclES2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZN5clang10ASTContext34setClassScopeSpecializationPatternEPNS_12FunctionDeclES2_")
  //</editor-fold>
  public void setClassScopeSpecializationPattern(FunctionDecl /*P*/ FD, 
                                    FunctionDecl /*P*/ Pattern) {
    assert ((FD != null)) : "Specialization is 0";
    assert ((Pattern != null)) : "Class scope specialization pattern is 0";
    ClassScopeSpecializationPattern.$set(FD, Pattern);
  }

  
  /// \brief Note that the static data member \p Inst is an instantiation of
  /// the static data member template \p Tmpl of a class template.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::setInstantiatedFromStaticDataMember">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp", line = 1170,
   FQN="clang::ASTContext::setInstantiatedFromStaticDataMember", NM="_ZN5clang10ASTContext35setInstantiatedFromStaticDataMemberEPNS_7VarDeclES2_NS_26TemplateSpecializationKindENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZN5clang10ASTContext35setInstantiatedFromStaticDataMemberEPNS_7VarDeclES2_NS_26TemplateSpecializationKindENS_14SourceLocationE")
  //</editor-fold>
  public void setInstantiatedFromStaticDataMember(VarDecl /*P*/ Inst, VarDecl /*P*/ Tmpl, 
                                     TemplateSpecializationKind TSK) {
    setInstantiatedFromStaticDataMember(Inst, Tmpl, 
                                     TSK, 
                                     new SourceLocation());
  }
  public void setInstantiatedFromStaticDataMember(VarDecl /*P*/ Inst, VarDecl /*P*/ Tmpl, 
                                     TemplateSpecializationKind TSK, 
                                     SourceLocation PointOfInstantiation/*= SourceLocation()*/) {
    assert (Inst.isStaticDataMember()) : "Not a static data member";
    assert (Tmpl.isStaticDataMember()) : "Not a static data member";
    setTemplateOrSpecializationInfo(Inst, new PointerUnion<VarTemplateDecl /*P*/ , MemberSpecializationInfo /*P*/ >(JD$T1.INSTANCE, MemberSpecializationInfo /*P*/ .class, /*FIXME:NEW_EXPR [operator new] NM=_ZnwjRKN5clang10ASTContextEj*/
            /*new (*this)*/ new MemberSpecializationInfo(Tmpl, TSK, new SourceLocation(PointOfInstantiation))));
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::setTemplateOrSpecializationInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp", line = 1180,
   FQN="clang::ASTContext::setTemplateOrSpecializationInfo", NM="_ZN5clang10ASTContext31setTemplateOrSpecializationInfoEPNS_7VarDeclEN4llvm12PointerUnionIPNS_15VarTemplateDeclEPNS_24MemberSpecializationInfoEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZN5clang10ASTContext31setTemplateOrSpecializationInfoEPNS_7VarDeclEN4llvm12PointerUnionIPNS_15VarTemplateDeclEPNS_24MemberSpecializationInfoEEE")
  //</editor-fold>
  public void setTemplateOrSpecializationInfo(VarDecl /*P*/ Inst, 
                                 PointerUnion<VarTemplateDecl /*P*/ , MemberSpecializationInfo /*P*/ > TSI) {
    assert (!TemplateOrInstantiation.$at_T1$RR(Inst).$bool()) : "Already noted what the variable was instantiated from";
    TemplateOrInstantiation.$at_T1$RR(Inst).$assign(TSI);
  }

  
  /// \brief If the given using decl \p Inst is an instantiation of a
  /// (possibly unresolved) using decl from a template instantiation,
  /// return it.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::getInstantiatedFromUsingDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp", line = 1206,
   FQN="clang::ASTContext::getInstantiatedFromUsingDecl", NM="_ZN5clang10ASTContext28getInstantiatedFromUsingDeclEPNS_9UsingDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZN5clang10ASTContext28getInstantiatedFromUsingDeclEPNS_9UsingDeclE")
  //</editor-fold>
  public NamedDecl /*P*/ getInstantiatedFromUsingDecl(UsingDecl /*P*/ UUD) {
    DenseMapIterator<UsingDecl /*P*/ , NamedDecl /*P*/ > Pos = new DenseMapIterator<UsingDecl /*P*/ , NamedDecl /*P*/ >(InstantiatedFromUsingDecl.find(UUD));
    if (Pos.$eq(/*NO_ITER_COPY*/InstantiatedFromUsingDecl.end())) {
      return null;
    }
    
    return Pos.$arrow().second;
  }

  
  /// \brief Remember that the using decl \p Inst is an instantiation
  /// of the using decl \p Pattern of a class template.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::setInstantiatedFromUsingDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp", line = 1216,
   FQN="clang::ASTContext::setInstantiatedFromUsingDecl", NM="_ZN5clang10ASTContext28setInstantiatedFromUsingDeclEPNS_9UsingDeclEPNS_9NamedDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZN5clang10ASTContext28setInstantiatedFromUsingDeclEPNS_9UsingDeclEPNS_9NamedDeclE")
  //</editor-fold>
  public void setInstantiatedFromUsingDecl(UsingDecl /*P*/ Inst, NamedDecl /*P*/ Pattern) {
    assert ((isa_UsingDecl(Pattern) || isa_UnresolvedUsingValueDecl(Pattern) || isa_UnresolvedUsingTypenameDecl(Pattern))) : "pattern decl is not a using decl";
    assert (!(InstantiatedFromUsingDecl.$at_T1$C$R(Inst) != null)) : "pattern already exists";
    InstantiatedFromUsingDecl.$set(Inst, Pattern);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::setInstantiatedFromUsingShadowDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp", line = 1236,
   FQN="clang::ASTContext::setInstantiatedFromUsingShadowDecl", NM="_ZN5clang10ASTContext34setInstantiatedFromUsingShadowDeclEPNS_15UsingShadowDeclES2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZN5clang10ASTContext34setInstantiatedFromUsingShadowDeclEPNS_15UsingShadowDeclES2_")
  //</editor-fold>
  public void setInstantiatedFromUsingShadowDecl(UsingShadowDecl /*P*/ Inst, 
                                    UsingShadowDecl /*P*/ Pattern) {
    assert (!(InstantiatedFromUsingShadowDecl.$at_T1$C$R(Inst) != null)) : "pattern already exists";
    InstantiatedFromUsingShadowDecl.$set(Inst, Pattern);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::getInstantiatedFromUsingShadowDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp", line = 1226,
   FQN="clang::ASTContext::getInstantiatedFromUsingShadowDecl", NM="_ZN5clang10ASTContext34getInstantiatedFromUsingShadowDeclEPNS_15UsingShadowDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZN5clang10ASTContext34getInstantiatedFromUsingShadowDeclEPNS_15UsingShadowDeclE")
  //</editor-fold>
  public UsingShadowDecl /*P*/ getInstantiatedFromUsingShadowDecl(UsingShadowDecl /*P*/ Inst) {
    DenseMapIterator<UsingShadowDecl /*P*/ , UsingShadowDecl /*P*/ > Pos = new DenseMapIterator<UsingShadowDecl /*P*/ , UsingShadowDecl /*P*/ >(InstantiatedFromUsingShadowDecl.find(Inst));
    if (Pos.$eq(/*NO_ITER_COPY*/InstantiatedFromUsingShadowDecl.end())) {
      return null;
    }
    
    return Pos.$arrow().second;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::getInstantiatedFromUnnamedFieldDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp", line = 1243,
   FQN="clang::ASTContext::getInstantiatedFromUnnamedFieldDecl", NM="_ZN5clang10ASTContext35getInstantiatedFromUnnamedFieldDeclEPNS_9FieldDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZN5clang10ASTContext35getInstantiatedFromUnnamedFieldDeclEPNS_9FieldDeclE")
  //</editor-fold>
  public FieldDecl /*P*/ getInstantiatedFromUnnamedFieldDecl(FieldDecl /*P*/ Field) {
    DenseMapIterator<FieldDecl /*P*/ , FieldDecl /*P*/ > Pos = InstantiatedFromUnnamedFieldDecl.find(Field);
    if (Pos.$eq(/*NO_ITER_COPY*/InstantiatedFromUnnamedFieldDecl.end())) {
      return null;
    }
    
    return Pos.$arrow().second;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::setInstantiatedFromUnnamedFieldDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp", line = 1252,
   FQN="clang::ASTContext::setInstantiatedFromUnnamedFieldDecl", NM="_ZN5clang10ASTContext35setInstantiatedFromUnnamedFieldDeclEPNS_9FieldDeclES2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZN5clang10ASTContext35setInstantiatedFromUnnamedFieldDeclEPNS_9FieldDeclES2_")
  //</editor-fold>
  public void setInstantiatedFromUnnamedFieldDecl(FieldDecl /*P*/ Inst, 
                                     FieldDecl /*P*/ Tmpl) {
    assert (!Inst.getDeclName().$bool()) : "Instantiated field decl is not unnamed";
    assert (!Tmpl.getDeclName().$bool()) : "Template field decl is not unnamed";
    assert (!(InstantiatedFromUnnamedFieldDecl.$at_T1$C$R(Inst) != null)) : "Already noted what unnamed field was instantiated from";
    
    InstantiatedFromUnnamedFieldDecl.$set(Inst, Tmpl);
  }

  
  // Access to the set of methods overridden by the given C++ method.
  /*typedef CXXMethodVector::const_iterator overridden_cxx_method_iterator*/
//  public final class overridden_cxx_method_iterator extends type$ptr</*const*/ CXXMethodDecl /*P*/ /*const*/ /*P*/>{ };
  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::overridden_methods_begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp", line = 1262,
   FQN="clang::ASTContext::overridden_methods_begin", NM="_ZNK5clang10ASTContext24overridden_methods_beginEPKNS_13CXXMethodDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZNK5clang10ASTContext24overridden_methods_beginEPKNS_13CXXMethodDeclE")
  //</editor-fold>
  public type$ptr<CXXMethodDecl/*P*/> overridden_methods_begin(/*const*/ CXXMethodDecl /*P*/ Method) /*const*/ {
    DenseMapIterator</*const*/ CXXMethodDecl /*P*/ , TinyPtrVector</*const*/ CXXMethodDecl /*P*/ >> Pos = OverriddenMethods.find$Const(Method.getCanonicalDecl$Const());
    if (Pos.$eq(OverriddenMethods.end$Const())) {
      return null;
    }
    return Pos.$arrow().second.begin$Const();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::overridden_methods_end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp", line = 1271,
   FQN="clang::ASTContext::overridden_methods_end", NM="_ZNK5clang10ASTContext22overridden_methods_endEPKNS_13CXXMethodDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZNK5clang10ASTContext22overridden_methods_endEPKNS_13CXXMethodDeclE")
  //</editor-fold>
  public type$ptr<CXXMethodDecl/*P*/> overridden_methods_end(/*const*/ CXXMethodDecl /*P*/ Method) /*const*/ {
    DenseMapIterator</*const*/ CXXMethodDecl /*P*/ , TinyPtrVector</*const*/ CXXMethodDecl /*P*/ >> Pos = OverriddenMethods.find$Const(Method.getCanonicalDecl$Const());
    if (Pos.$eq(OverriddenMethods.end$Const())) {
      return null;
    }
    return Pos.$arrow().second.end$Const();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::overridden_methods_size">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp", line = 1280,
   FQN="clang::ASTContext::overridden_methods_size", NM="_ZNK5clang10ASTContext23overridden_methods_sizeEPKNS_13CXXMethodDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZNK5clang10ASTContext23overridden_methods_sizeEPKNS_13CXXMethodDeclE")
  //</editor-fold>
  public /*uint*/int overridden_methods_size(/*const*/ CXXMethodDecl /*P*/ Method) /*const*/ {
    DenseMapIterator</*const*/ CXXMethodDecl /*P*/ , TinyPtrVector</*const*/ CXXMethodDecl /*P*/ >> Pos = OverriddenMethods.find$Const(Method.getCanonicalDecl$Const());
    if (Pos.$eq(OverriddenMethods.end$Const())) {
      return 0;
    }
    return Pos.$arrow().second.size();
  }

  /*typedef llvm::iterator_range<overridden_cxx_method_iterator> overridden_method_range*/
//  public final class overridden_method_range extends iterator_range</*const*/ CXXMethodDecl /*P*/ /*const*/>{ };
  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::overridden_methods">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp", line = 1289,
   FQN="clang::ASTContext::overridden_methods", NM="_ZNK5clang10ASTContext18overridden_methodsEPKNS_13CXXMethodDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZNK5clang10ASTContext18overridden_methodsEPKNS_13CXXMethodDeclE")
  //</editor-fold>
  public iterator_range</*const*/ CXXMethodDecl /*P*/ /*const*/> overridden_methods(/*const*/ CXXMethodDecl /*P*/ Method) /*const*/ {
    return new iterator_range</*const*/ CXXMethodDecl /*P*/ /*const*/>(overridden_methods_begin(Method), 
        overridden_methods_end(Method));
  }

  
  /// \brief Note that the given C++ \p Method overrides the given \p
  /// Overridden method.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::addOverriddenMethod">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp", line = 1295,
   FQN="clang::ASTContext::addOverriddenMethod", NM="_ZN5clang10ASTContext19addOverriddenMethodEPKNS_13CXXMethodDeclES3_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZN5clang10ASTContext19addOverriddenMethodEPKNS_13CXXMethodDeclES3_")
  //</editor-fold>
  public void addOverriddenMethod(/*const*/ CXXMethodDecl /*P*/ Method, 
                     /*const*/ CXXMethodDecl /*P*/ Overridden) {
    assert (Method.isCanonicalDecl() && Overridden.isCanonicalDecl());
    OverriddenMethods.$at_T1$C$R(Method).push_back(Overridden);
  }

  
  /// \brief Return C++ or ObjC overridden methods for the given \p Method.
  ///
  /// An ObjC method is considered to override any method in the class's
  /// base classes, its protocols, or its categories' protocols, that has
  /// the same selector and is of the same kind (class or instance).
  /// A method in an implementation is not considered as overriding the same
  /// method in the interface or its categories.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::getOverriddenMethods">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp", line = 1301,
   FQN="clang::ASTContext::getOverriddenMethods", NM="_ZNK5clang10ASTContext20getOverriddenMethodsEPKNS_9NamedDeclERN4llvm15SmallVectorImplIS3_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZNK5clang10ASTContext20getOverriddenMethodsEPKNS_9NamedDeclERN4llvm15SmallVectorImplIS3_EE")
  //</editor-fold>
  public void getOverriddenMethods(/*const*/ NamedDecl /*P*/ D, 
                      final SmallVectorImpl</*const*/ NamedDecl /*P*/ > /*&*/ Overridden) /*const*/ {
    assert Native.$bool(D);
    {
      
      /*const*/ CXXMethodDecl /*P*/ CXXMethod = dyn_cast_CXXMethodDecl(D);
      if ((CXXMethod != null)) {
        Overridden.append_T(overridden_methods_begin(CXXMethod), 
            overridden_methods_end(CXXMethod));
        return;
      }
    }
    
    /*const*/ ObjCMethodDecl /*P*/ Method = dyn_cast_ObjCMethodDecl(D);
    if (!(Method != null)) {
      return;
    }
    
    SmallVector</*const*/ ObjCMethodDecl /*P*/ > OverDecls/*J*/= new SmallVector</*const*/ ObjCMethodDecl /*P*/ >(8, (/*const*/ ObjCMethodDecl /*P*/ )null);
    Method.getOverriddenMethods(OverDecls);
    Overridden.append_T(OverDecls.begin(), OverDecls.end());
  }

  
  /// \brief Notify the AST context that a new import declaration has been
  /// parsed or implicitly created within this translation unit.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::addedLocalImportDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp", line = 1321,
   FQN="clang::ASTContext::addedLocalImportDecl", NM="_ZN5clang10ASTContext20addedLocalImportDeclEPNS_10ImportDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZN5clang10ASTContext20addedLocalImportDeclEPNS_10ImportDeclE")
  //</editor-fold>
  public void addedLocalImportDecl(ImportDecl /*P*/ Import) {
    assert (!(Import.NextLocalImport != null)) : "Import declaration already in the chain";
    assert (!Import.isFromASTFile()) : "Non-local import declaration";
    if (!(FirstLocalImport != null)) {
      FirstLocalImport = Import;
      LastLocalImport = Import;
      return;
    }
    
    LastLocalImport.NextLocalImport = Import;
    LastLocalImport = Import;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::getNextLocalImport">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ASTContext.h", line = 852,
   FQN="clang::ASTContext::getNextLocalImport", NM="_ZN5clang10ASTContext18getNextLocalImportEPNS_10ImportDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZN5clang10ASTContext18getNextLocalImportEPNS_10ImportDeclE")
  //</editor-fold>
  public static ImportDecl /*P*/ getNextLocalImport(ImportDecl /*P*/ Import) {
    return Import.NextLocalImport;
  }

  
  /*typedef llvm::iterator_range<import_iterator> import_range*/
//  public final class import_range extends iterator_range<ImportDecl /*P*/ >{ };
  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::local_imports">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ASTContext.h", line = 857,
   FQN="clang::ASTContext::local_imports", NM="_ZNK5clang10ASTContext13local_importsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZNK5clang10ASTContext13local_importsEv")
  //</editor-fold>
  public iterator_range<ImportDecl /*P*/ > local_imports() /*const*/ {
    return new iterator_range<ImportDecl /*P*/ >(new import_iterator(FirstLocalImport), new import_iterator());
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::getPrimaryMergedDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ASTContext.h", line = 861,
   FQN="clang::ASTContext::getPrimaryMergedDecl", NM="_ZN5clang10ASTContext20getPrimaryMergedDeclEPNS_4DeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZN5clang10ASTContext20getPrimaryMergedDeclEPNS_4DeclE")
  //</editor-fold>
  public Decl /*P*/ getPrimaryMergedDecl(Decl /*P*/ D) {
    Decl /*P*/ Result = MergedDecls.lookup(D);
    return (Result != null) ? Result : D;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::setPrimaryMergedDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ASTContext.h", line = 865,
   FQN="clang::ASTContext::setPrimaryMergedDecl", NM="_ZN5clang10ASTContext20setPrimaryMergedDeclEPNS_4DeclES2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZN5clang10ASTContext20setPrimaryMergedDeclEPNS_4DeclES2_")
  //</editor-fold>
  public void setPrimaryMergedDecl(Decl /*P*/ D, Decl /*P*/ Primary) {
    MergedDecls.$set(D, Primary);
  }

  
  /// \brief Note that the definition \p ND has been merged into module \p M,
  /// and should be visible whenever \p M is visible.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::mergeDefinitionIntoModule">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp", line = 880,
   FQN="clang::ASTContext::mergeDefinitionIntoModule", NM="_ZN5clang10ASTContext25mergeDefinitionIntoModuleEPNS_9NamedDeclEPNS_6ModuleEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZN5clang10ASTContext25mergeDefinitionIntoModuleEPNS_9NamedDeclEPNS_6ModuleEb")
  //</editor-fold>
  public void mergeDefinitionIntoModule(NamedDecl /*P*/ ND, Module /*P*/ M) {
    mergeDefinitionIntoModule(ND, M, 
                           true);
  }
  public void mergeDefinitionIntoModule(NamedDecl /*P*/ ND, Module /*P*/ M, 
                           boolean NotifyListeners/*= true*/) {
    if (NotifyListeners) {
      {
        ASTMutationListener /*P*/ Listener = getASTMutationListener();
        if ((Listener != null)) {
          Listener.RedefinedHiddenDefinition(ND, M);
        }
      }
    }
    if (getLangOpts().ModulesLocalVisibility) {
      MergedDefModules.$at_T1$C$R(ND).push_back(M);
    } else {
      ND.setHidden(false);
    }
  }

  /// \brief Clean up the merged definition list. Call this if you might have
  /// added duplicates into the list.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::deduplicateMergedDefinitonsFor">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*entry in map*/,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp", line = 892,
   FQN="clang::ASTContext::deduplicateMergedDefinitonsFor", NM="_ZN5clang10ASTContext30deduplicateMergedDefinitonsForEPNS_9NamedDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZN5clang10ASTContext30deduplicateMergedDefinitonsForEPNS_9NamedDeclE")
  //</editor-fold>
  public void deduplicateMergedDefinitonsFor(NamedDecl /*P*/ ND) {
    DenseMapIterator<NamedDecl /*P*/ , TinyPtrVector<Module /*P*/ >> It = MergedDefModules.find(ND);
    if (It.$eq(/*NO_ITER_COPY*/MergedDefModules.end())) {
      return;
    }
    
    final TinyPtrVector<Module /*P*/ > /*&*/ Merged = It.$arrow().second;
    DenseSet<Module /*P*/ > Found/*J*/= new DenseSet<Module /*P*/ >(DenseMapInfo$LikePtr.$Info());
// JAVA: for (final type$ref<Module /*P*/ /*&*/> M : Merged)  {
    for (final Module /*P*/ /*&*/ M : Merged)  {
      if (!Found.insert(M).second) {
//        M.$set(null);
        assert(false) : "not implemented iteration throw TinyPtrVector elements references";
      }
    }
    Merged.erase(std.remove(Merged.begin(), Merged.end(), null), Merged.end());
  }


  
  /// \brief Get the additional modules in which the definition \p Def has
  /// been merged.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::getModulesWithMergedDefinition">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ASTContext.h", line = 879,
   FQN="clang::ASTContext::getModulesWithMergedDefinition", NM="_ZN5clang10ASTContext30getModulesWithMergedDefinitionEPNS_9NamedDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZN5clang10ASTContext30getModulesWithMergedDefinitionEPNS_9NamedDeclE")
  //</editor-fold>
  public ArrayRef<Module /*P*/ > getModulesWithMergedDefinition(NamedDecl /*P*/ Def) {
    DenseMapIterator<NamedDecl /*P*/ , TinyPtrVector<Module /*P*/ >> MergedIt = MergedDefModules.find(Def);
    if (MergedIt.$eq(/*NO_ITER_COPY*/MergedDefModules.end())) {
      return new ArrayRef<Module /*P*/ >(None, true);
    }
    return new ArrayRef<Module /*P*/ >(JD$Move.INSTANCE, MergedIt.$arrow().second.$MutableArrayRef$EltTy());
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::getTranslationUnitDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ASTContext.h", line = 886,
   FQN="clang::ASTContext::getTranslationUnitDecl", NM="_ZNK5clang10ASTContext22getTranslationUnitDeclEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZNK5clang10ASTContext22getTranslationUnitDeclEv")
  //</editor-fold>
  public TranslationUnitDecl /*P*/ getTranslationUnitDecl() /*const*/ {
    return TUDecl;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::getExternCContextDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp", line = 905,
   FQN="clang::ASTContext::getExternCContextDecl", NM="_ZNK5clang10ASTContext21getExternCContextDeclEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZNK5clang10ASTContext21getExternCContextDeclEv")
  //</editor-fold>
  public ExternCContextDecl /*P*/ getExternCContextDecl() /*const*/ {
    if (!(ExternCContext != null)) {
      ExternCContext = ExternCContextDecl.Create(/*Deref*/this, getTranslationUnitDecl());
    }
    
    return ExternCContext;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::getMakeIntegerSeqDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp", line = 922,
   FQN="clang::ASTContext::getMakeIntegerSeqDecl", NM="_ZNK5clang10ASTContext21getMakeIntegerSeqDeclEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZNK5clang10ASTContext21getMakeIntegerSeqDeclEv")
  //</editor-fold>
  public BuiltinTemplateDecl /*P*/ getMakeIntegerSeqDecl() /*const*/ {
    if (!(MakeIntegerSeqDecl != null)) {
      MakeIntegerSeqDecl = buildBuiltinTemplateDecl(BuiltinTemplateKind.BTK__make_integer_seq, 
          getMakeIntegerSeqName());
    }
    return MakeIntegerSeqDecl;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::getTypePackElementDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp", line = 930,
   FQN="clang::ASTContext::getTypePackElementDecl", NM="_ZNK5clang10ASTContext22getTypePackElementDeclEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZNK5clang10ASTContext22getTypePackElementDeclEv")
  //</editor-fold>
  public BuiltinTemplateDecl /*P*/ getTypePackElementDecl() /*const*/ {
    if (!(TypePackElementDecl != null)) {
      TypePackElementDecl = buildBuiltinTemplateDecl(BuiltinTemplateKind.BTK__type_pack_element, 
          getTypePackElementName());
    }
    return TypePackElementDecl;
  }

  
  // Builtin Types.
  public CanQual<Type> VoidTy;
  public CanQual<Type> BoolTy;
  public CanQual<Type> CharTy;
  public CanQual<Type> WCharTy; // [C++ 3.9.1p5].
  public CanQual<Type> WideCharTy; // Same as WCharTy in C++, integer type in C99.
  public CanQual<Type> WIntTy; // [C99 7.24.1], integer type unchanged by default promotions.
  public CanQual<Type> Char16Ty; // [C++0x 3.9.1p5], integer type in C99.
  public CanQual<Type> Char32Ty; // [C++0x 3.9.1p5], integer type in C99.
  public CanQual<Type> SignedCharTy;
  public CanQual<Type> ShortTy;
  public CanQual<Type> IntTy;
  public CanQual<Type> LongTy;
  public CanQual<Type> LongLongTy;
  public CanQual<Type> Int128Ty;
  public CanQual<Type> UnsignedCharTy;
  public CanQual<Type> UnsignedShortTy;
  public CanQual<Type> UnsignedIntTy;
  public CanQual<Type> UnsignedLongTy;
  public CanQual<Type> UnsignedLongLongTy;
  public CanQual<Type> UnsignedInt128Ty;
  public CanQual<Type> FloatTy;
  public CanQual<Type> DoubleTy;
  public CanQual<Type> LongDoubleTy;
  public CanQual<Type> Float128Ty;
  public CanQual<Type> HalfTy; // [OpenCL 6.1.1.1], ARM NEON
  public CanQual<Type> FloatComplexTy;
  public CanQual<Type> DoubleComplexTy;
  public CanQual<Type> LongDoubleComplexTy;
  public CanQual<Type> Float128ComplexTy;
  public CanQual<Type> VoidPtrTy;
  public CanQual<Type> NullPtrTy;
  public CanQual<Type> DependentTy;
  public CanQual<Type> OverloadTy;
  public CanQual<Type> BoundMemberTy;
  public CanQual<Type> UnknownAnyTy;
  public CanQual<Type> BuiltinFnTy;
  public CanQual<Type> PseudoObjectTy;
  public CanQual<Type> ARCUnbridgedCastTy;
  public CanQual<Type> ObjCBuiltinIdTy;
  public CanQual<Type> ObjCBuiltinClassTy;
  public CanQual<Type> ObjCBuiltinSelTy;
  public CanQual<Type> ObjCBuiltinBoolTy;
  public CanQual<Type> OCLImage1dROTy;
  public CanQual<Type> OCLImage1dArrayROTy;
  public CanQual<Type> OCLImage1dBufferROTy;
  public CanQual<Type> OCLImage2dROTy;
  public CanQual<Type> OCLImage2dArrayROTy;
  public CanQual<Type> OCLImage2dDepthROTy;
  public CanQual<Type> OCLImage2dArrayDepthROTy;
  public CanQual<Type> OCLImage2dMSAAROTy;
  public CanQual<Type> OCLImage2dArrayMSAAROTy;
  public CanQual<Type> OCLImage2dMSAADepthROTy;
  public CanQual<Type> OCLImage2dArrayMSAADepthROTy;
  public CanQual<Type> OCLImage3dROTy;
  public CanQual<Type> OCLImage1dWOTy;
  public CanQual<Type> OCLImage1dArrayWOTy;
  public CanQual<Type> OCLImage1dBufferWOTy;
  public CanQual<Type> OCLImage2dWOTy;
  public CanQual<Type> OCLImage2dArrayWOTy;
  public CanQual<Type> OCLImage2dDepthWOTy;
  public CanQual<Type> OCLImage2dArrayDepthWOTy;
  public CanQual<Type> OCLImage2dMSAAWOTy;
  public CanQual<Type> OCLImage2dArrayMSAAWOTy;
  public CanQual<Type> OCLImage2dMSAADepthWOTy;
  public CanQual<Type> OCLImage2dArrayMSAADepthWOTy;
  public CanQual<Type> OCLImage3dWOTy;
  public CanQual<Type> OCLImage1dRWTy;
  public CanQual<Type> OCLImage1dArrayRWTy;
  public CanQual<Type> OCLImage1dBufferRWTy;
  public CanQual<Type> OCLImage2dRWTy;
  public CanQual<Type> OCLImage2dArrayRWTy;
  public CanQual<Type> OCLImage2dDepthRWTy;
  public CanQual<Type> OCLImage2dArrayDepthRWTy;
  public CanQual<Type> OCLImage2dMSAARWTy;
  public CanQual<Type> OCLImage2dArrayMSAARWTy;
  public CanQual<Type> OCLImage2dMSAADepthRWTy;
  public CanQual<Type> OCLImage2dArrayMSAADepthRWTy;
  public CanQual<Type> OCLImage3dRWTy;
  public CanQual<Type> OCLSamplerTy;
  public CanQual<Type> OCLEventTy;
  public CanQual<Type> OCLClkEventTy;
  public CanQual<Type> OCLQueueTy;
  public CanQual<Type> OCLNDRangeTy;
  public CanQual<Type> OCLReserveIDTy;
  public CanQual<Type> OMPArraySectionTy;
  
  // Types for deductions in C++0x [stmt.ranged]'s desugaring. Built on demand.
  public /*mutable */QualType AutoDeductTy; // Deduction against 'auto'.
  public /*mutable */QualType AutoRRefDeductTy; // Deduction against 'auto &&'.
  
  // Decl used to help define __builtin_va_list for some targets.
  // The decl is built when constructing 'BuiltinVaListDecl'.
  public /*mutable */Decl /*P*/ VaListTagDecl;
  
  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::ASTContext">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp", line = 729,
   FQN="clang::ASTContext::ASTContext", NM="_ZN5clang10ASTContextC1ERNS_11LangOptionsERNS_13SourceManagerERNS_15IdentifierTableERNS_13SelectorTableERNS_7Builtin7ContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZN5clang10ASTContextC1ERNS_11LangOptionsERNS_13SourceManagerERNS_15IdentifierTableERNS_13SelectorTableERNS_7Builtin7ContextE")
  //</editor-fold>
  public ASTContext(final LangOptions /*&*/ LOpts, final SourceManager /*&*/ SM, 
      final IdentifierTable /*&*/ idents, final SelectorTable /*&*/ sels, 
      final Builtin.Context /*&*/ builtins) {
    // : RefCountedBase<ASTContext>(), Types(), ExtQualNodes(), ComplexTypes(), PointerTypes(), AdjustedTypes(), BlockPointerTypes(), LValueReferenceTypes(), RValueReferenceTypes(), MemberPointerTypes(), ConstantArrayTypes(), IncompleteArrayTypes(), VariableArrayTypes(), DependentSizedArrayTypes(), DependentSizedExtVectorTypes(), VectorTypes(), FunctionNoProtoTypes(), FunctionProtoTypes(this_()), DependentTypeOfExprTypes(), DependentDecltypeTypes(), TemplateTypeParmTypes(), SubstTemplateTypeParmTypes(), SubstTemplateTypeParmPackTypes(), TemplateSpecializationTypes(this_()), ParenTypes(), ElaboratedTypes(), DependentNameTypes(), DependentTemplateSpecializationTypes(this_()), PackExpansionTypes(), ObjCObjectTypes(), ObjCObjectPointerTypes(), DependentUnaryTransformTypes(), AutoTypes(), AtomicTypes(), AttributedTypes(), PipeTypes(), QualifiedTemplateNames(), DependentTemplateNames(), SubstTemplateTemplateParms(), SubstTemplateTemplateParmPacks(this_()), NestedNameSpecifiers(), GlobalNestedNameSpecifier(null), ASTRecordLayouts(), ObjCLayouts(), MemoizedTypeInfo(), KeyFunctions(), ObjCImpls(), ObjCMethodRedecls(), BlockVarCopyInits(), ClassScopeSpecializationPattern(), MaterializedTemporaryValues(), CanonTemplateTemplateParms(), Int128Decl(null), UInt128Decl(null), BuiltinVaListDecl(null), BuiltinMSVaListDecl(null), ObjCIdDecl(null), ObjCSelDecl(null), ObjCClassDecl(null), ObjCProtocolClassDecl(null), BOOLDecl(null), ObjCIdRedefinitionType(), ObjCClassRedefinitionType(), ObjCSelRedefinitionType(), BoolName(null), NSObjectName(null), NSCopyingName(null), MakeIntegerSeqName(null), TypePackElementName(null), ObjCConstantStringType(), CFConstantStringTagDecl(null), CFConstantStringTypeDecl(null), ObjCSuperType(), ObjCNSStringType(), ObjCInstanceTypeDecl(null), FILEDecl(null), jmp_bufDecl(null), sigjmp_bufDecl(null), ucontext_tDecl(null), BlockDescriptorType(null), BlockDescriptorExtendedType(null), cudaConfigureCallDecl(null), DeclAttrs(), MergedDecls(), MergedDefModules(), TemplateOrInstantiation(), InstantiatedFromUsingDecl(), InstantiatedFromUsingShadowDecl(), InstantiatedFromUnnamedFieldDecl(), OverriddenMethods(), MangleNumberingContexts(), MangleNumbers(), StaticLocalNumbers(), ParamIndices(), FirstLocalImport(implicit ImportDecl * ()), LastLocalImport(implicit ImportDecl * ()), ExternCContext(null), MakeIntegerSeqDecl(null), TypePackElementDecl(null), SourceMgr(SM), LangOpts(LOpts), SanitizerBL(new SanitizerBlacklist(LangOpts.SanitizerBlacklistFiles, SM)), BumpAlloc(), DiagAllocator(), ABI(), AddrSpaceMap(null), Target(null), AuxTarget(null), PrintingPolicy(LOpts), Idents(idents), Selectors(sels), BuiltinInfo(builtins), DeclarationNames(*this), ExternalSource(null), Listener(null), Comments(SM), CommentsLoaded(false), RedeclComments(), ParsedComments(), CommentCommandTraits(BumpAlloc, LOpts.CommentOpts), VoidTy(), BoolTy(), CharTy(), WCharTy(), WideCharTy(), WIntTy(), Char16Ty(), Char32Ty(), SignedCharTy(), ShortTy(), IntTy(), LongTy(), LongLongTy(), Int128Ty(), UnsignedCharTy(), UnsignedShortTy(), UnsignedIntTy(), UnsignedLongTy(), UnsignedLongLongTy(), UnsignedInt128Ty(), FloatTy(), DoubleTy(), LongDoubleTy(), Float128Ty(), HalfTy(), FloatComplexTy(), DoubleComplexTy(), LongDoubleComplexTy(), Float128ComplexTy(), VoidPtrTy(), NullPtrTy(), DependentTy(), OverloadTy(), BoundMemberTy(), UnknownAnyTy(), BuiltinFnTy(), PseudoObjectTy(), ARCUnbridgedCastTy(), ObjCBuiltinIdTy(), ObjCBuiltinClassTy(), ObjCBuiltinSelTy(), ObjCBuiltinBoolTy(), OCLImage1dROTy(), OCLImage1dArrayROTy(), OCLImage1dBufferROTy(), OCLImage2dROTy(), OCLImage2dArrayROTy(), OCLImage2dDepthROTy(), OCLImage2dArrayDepthROTy(), OCLImage2dMSAAROTy(), OCLImage2dArrayMSAAROTy(), OCLImage2dMSAADepthROTy(), OCLImage2dArrayMSAADepthROTy(), OCLImage3dROTy(), OCLImage1dWOTy(), OCLImage1dArrayWOTy(), OCLImage1dBufferWOTy(), OCLImage2dWOTy(), OCLImage2dArrayWOTy(), OCLImage2dDepthWOTy(), OCLImage2dArrayDepthWOTy(), OCLImage2dMSAAWOTy(), OCLImage2dArrayMSAAWOTy(), OCLImage2dMSAADepthWOTy(), OCLImage2dArrayMSAADepthWOTy(), OCLImage3dWOTy(), OCLImage1dRWTy(), OCLImage1dArrayRWTy(), OCLImage1dBufferRWTy(), OCLImage2dRWTy(), OCLImage2dArrayRWTy(), OCLImage2dDepthRWTy(), OCLImage2dArrayDepthRWTy(), OCLImage2dMSAARWTy(), OCLImage2dArrayMSAARWTy(), OCLImage2dMSAADepthRWTy(), OCLImage2dArrayMSAADepthRWTy(), OCLImage3dRWTy(), OCLSamplerTy(), OCLEventTy(), OCLClkEventTy(), OCLQueueTy(), OCLNDRangeTy(), OCLReserveIDTy(), OMPArraySectionTy(), AutoDeductTy(), AutoRRefDeductTy(), Deallocations(), LastSDM(null, 0), PointerParents(), OtherParents(), VTContext(), SectionInfos() 
    //START JInit
    super();
    this.Types = new SmallVector<Type /*P*/ >(0, (Type /*P*/ )null);
    this.ExtQualNodes = new FoldingSet<ExtQuals>(ExtQuals.$Trait());
    this.ComplexTypes = new FoldingSet<ComplexType>(ComplexType.$Trait());
    this.PointerTypes = new FoldingSet<PointerType>(PointerType.$Trait());
    this.AdjustedTypes = new FoldingSet<AdjustedType>(AdjustedType.$Trait());
    this.BlockPointerTypes = new FoldingSet<BlockPointerType>(BlockPointerType.$Trait());
    this.LValueReferenceTypes = new FoldingSet<LValueReferenceType>(LValueReferenceType.$Trait());
    this.RValueReferenceTypes = new FoldingSet<RValueReferenceType>(RValueReferenceType.$Trait());
    this.MemberPointerTypes = new FoldingSet<MemberPointerType>(MemberPointerType.$Trait());
    this.ConstantArrayTypes = new FoldingSet<ConstantArrayType>(ConstantArrayType.$Trait());
    this.IncompleteArrayTypes = new FoldingSet<IncompleteArrayType>(IncompleteArrayType.$Trait());
    this.VariableArrayTypes = new std.vector<VariableArrayType /*P*/ >((VariableArrayType /*P*/ )null);
    this.DependentSizedArrayTypes = new FoldingSet<DependentSizedArrayType>(DependentSizedArrayType.$Trait());
    this.DependentSizedExtVectorTypes = new FoldingSet<DependentSizedExtVectorType>(DependentSizedExtVectorType.$Trait());
    this.VectorTypes = new FoldingSet<VectorType>(VectorType.$Trait());
    this.FunctionNoProtoTypes = new FoldingSet<FunctionNoProtoType>(FunctionNoProtoType.$Trait());
    this.FunctionProtoTypes = new ContextualFoldingSet<FunctionProtoType, ASTContext /*&*/ >(FunctionProtoType.$ContextualTrait(), this_());
    this.DependentTypeOfExprTypes = new FoldingSet<DependentTypeOfExprType>(DependentTypeOfExprType.$Trait());
    this.DependentDecltypeTypes = new FoldingSet<DependentDecltypeType>(DependentDecltypeType.$Trait());
    this.TemplateTypeParmTypes = new FoldingSet<TemplateTypeParmType>(TemplateTypeParmType.$Trait());
    this.SubstTemplateTypeParmTypes = new FoldingSet<SubstTemplateTypeParmType>(SubstTemplateTypeParmType.$Trait());
    this.SubstTemplateTypeParmPackTypes = new FoldingSet<SubstTemplateTypeParmPackType>(SubstTemplateTypeParmPackType.$Trait());
    this.TemplateSpecializationTypes = new ContextualFoldingSet<TemplateSpecializationType, ASTContext /*&*/ >(TemplateSpecializationType.$ContextualTrait(), this_());
    this.ParenTypes = new FoldingSet<ParenType>(ParenType.$Trait());
    this.ElaboratedTypes = new FoldingSet<ElaboratedType>(ElaboratedType.$Trait());
    this.DependentNameTypes = new FoldingSet<DependentNameType>(DependentNameType.$Trait());
    this.DependentTemplateSpecializationTypes = new ContextualFoldingSet<DependentTemplateSpecializationType, ASTContext /*&*/ >(DependentTemplateSpecializationType.$ContextualTrait(), this_());
    this.PackExpansionTypes = new FoldingSet<PackExpansionType>(PackExpansionType.$Trait());
    this.ObjCObjectTypes = new FoldingSet<ObjCObjectTypeImpl>(ObjCObjectTypeImpl.$Trait());
    this.ObjCObjectPointerTypes = new FoldingSet<ObjCObjectPointerType>(ObjCObjectPointerType.$Trait());
    this.DependentUnaryTransformTypes = new FoldingSet<DependentUnaryTransformType>(DependentUnaryTransformType.$Trait());
    this.AutoTypes = new FoldingSet<AutoType>(AutoType.$Trait());
    this.AtomicTypes = new FoldingSet<AtomicType>(AtomicType.$Trait());
    this.AttributedTypes = new FoldingSet<AttributedType>(AttributedType.$Trait());
    this.PipeTypes = new FoldingSet<PipeType>(PipeType.$Trait());
    this.QualifiedTemplateNames = new FoldingSet<QualifiedTemplateName>(QualifiedTemplateName.$Trait());
    this.DependentTemplateNames = new FoldingSet<DependentTemplateName>(DependentTemplateName.$Trait());
    this.SubstTemplateTemplateParms = new FoldingSet<SubstTemplateTemplateParmStorage>(SubstTemplateTemplateParmStorage.$Trait());
    this.SubstTemplateTemplateParmPacks = new ContextualFoldingSet<SubstTemplateTemplateParmPackStorage, ASTContext /*&*/ >(SubstTemplateTemplateParmPackStorage.$ContextualTrait(), this_());
    this.NestedNameSpecifiers = new FoldingSet<NestedNameSpecifier>(NestedNameSpecifier.$Trait());
    this.GlobalNestedNameSpecifier = null;
    this.ASTRecordLayouts = new DenseMap</*const*/ RecordDecl /*P*/ , /*const*/ ASTRecordLayout /*P*/ >(DenseMapInfo$LikePtr.$Info(), (/*const*/ ASTRecordLayout /*P*/ )null);
    this.ObjCLayouts = new DenseMap</*const*/ ObjCContainerDecl /*P*/ , /*const*/ ASTRecordLayout /*P*/ >(DenseMapInfo$LikePtr.$Info(), (/*const*/ ASTRecordLayout /*P*/ )null);
    this.MemoizedTypeInfo = new DenseMap</*const*/ Type /*P*/ ,  TypeInfo>(DenseMapInfo$LikePtr.$Info(), new  TypeInfo());
    this.KeyFunctions = new DenseMap</*const*/ CXXRecordDecl /*P*/ , LazyDeclPtr>(DenseMapInfo$LikePtr.$Info(), new LazyDeclPtr());
    this.ObjCImpls = new DenseMap<ObjCContainerDecl /*P*/ , ObjCImplDecl /*P*/ >(DenseMapInfo$LikePtr.$Info(), (ObjCImplDecl /*P*/ )null);
    this.ObjCMethodRedecls = new DenseMap</*const*/ ObjCMethodDecl /*P*/ , /*const*/ ObjCMethodDecl /*P*/ >(DenseMapInfo$LikePtr.$Info(), (/*const*/ ObjCMethodDecl /*P*/ )null);
    this.BlockVarCopyInits = new DenseMap</*const*/ VarDecl /*P*/ , Expr /*P*/ >(DenseMapInfo$LikePtr.$Info(), (Expr /*P*/ )null);
    this.ClassScopeSpecializationPattern = new DenseMap</*const*/ FunctionDecl /*P*/ , FunctionDecl /*P*/ >(DenseMapInfo$LikePtr.$Info(), (FunctionDecl /*P*/ )null);
    this.MaterializedTemporaryValues = new DenseMap</*const*/ MaterializeTemporaryExpr /*P*/ , APValue /*P*/ >(DenseMapInfo$LikePtr.$Info(), (APValue /*P*/ )null);
    this.CanonTemplateTemplateParms = new FoldingSet<CanonicalTemplateTemplateParm>(CanonicalTemplateTemplateParm.$Trait());
    this.Int128Decl = null;
    this.UInt128Decl = null;
    this.BuiltinVaListDecl = null;
    this.BuiltinMSVaListDecl = null;
    this.ObjCIdDecl = null;
    this.ObjCSelDecl = null;
    this.ObjCClassDecl = null;
    this.ObjCProtocolClassDecl = null;
    this.BOOLDecl = null;
    this.ObjCIdRedefinitionType = new QualType();
    this.ObjCClassRedefinitionType = new QualType();
    this.ObjCSelRedefinitionType = new QualType();
    /*InClass*/this.BoolName = null;
    /*InClass*/this.NSObjectName = null;
    /*InClass*/this.NSCopyingName = null;
    /*InClass*/this.MakeIntegerSeqName = null;
    /*InClass*/this.TypePackElementName = null;
    this.ObjCConstantStringType = new QualType();
    this.CFConstantStringTagDecl = null;
    this.CFConstantStringTypeDecl = null;
    this.ObjCSuperType = new QualType();
    this.ObjCNSStringType = new QualType();
    this.ObjCInstanceTypeDecl = null;
    this.FILEDecl = null;
    this.jmp_bufDecl = null;
    this.sigjmp_bufDecl = null;
    this.ucontext_tDecl = null;
    this.BlockDescriptorType = null;
    this.BlockDescriptorExtendedType = null;
    this.cudaConfigureCallDecl = null;
    this.DeclAttrs = new DenseMap</*const*/ Decl /*P*/ , SmallVector<Attr /*P*/>/*P*/ >(DenseMapInfo$LikePtr.$Info(), (SmallVector<Attr /*P*/>/*P*/ )null);
    this.MergedDecls = new DenseMap<Decl /*P*/ , Decl /*P*/ >(DenseMapInfo$LikePtr.$Info(), (Decl /*P*/ )null);
    this.MergedDefModules = new DenseMap<NamedDecl /*P*/ , TinyPtrVector<Module /*P*/ >>(DenseMapInfo$LikePtr.$Info(), new TinyPtrVector<Module /*P*/ >());
    this.TemplateOrInstantiation = new DenseMap</*const*/ VarDecl /*P*/ , PointerUnion<VarTemplateDecl /*P*/ , MemberSpecializationInfo /*P*/ >>(DenseMapInfo$LikePtr.$Info(), new PointerUnion<VarTemplateDecl /*P*/ , MemberSpecializationInfo /*P*/ >(VarTemplateDecl /*P*/.class));
    this.InstantiatedFromUsingDecl = new DenseMap<UsingDecl /*P*/ , NamedDecl /*P*/ >(DenseMapInfo$LikePtr.$Info(), (NamedDecl /*P*/ )null);
    this.InstantiatedFromUsingShadowDecl = new DenseMap<UsingShadowDecl /*P*/ , UsingShadowDecl /*P*/ >(DenseMapInfo$LikePtr.$Info(), (UsingShadowDecl /*P*/ )null);
    this.InstantiatedFromUnnamedFieldDecl = new DenseMap<FieldDecl /*P*/ , FieldDecl /*P*/ >(DenseMapInfo$LikePtr.$Info(), (FieldDecl /*P*/ )null);
    this.OverriddenMethods = new DenseMap</*const*/ CXXMethodDecl /*P*/ , TinyPtrVector</*const*/ CXXMethodDecl /*P*/ >>(DenseMapInfo$LikePtr.$Info(), new TinyPtrVector</*const*/ CXXMethodDecl /*P*/ >());
    this.MangleNumberingContexts = new DenseMap</*const*/ DeclContext /*P*/ , MangleNumberingContext /*P*/ >(DenseMapInfo$LikePtr.$Info(), (MangleNumberingContext /*P*/ )null);
    this.MangleNumbers = new MapVectorPtrUInt</*const*/ NamedDecl /*P*/ >(DenseMapInfo$LikePtr.$Info(), 0);
    this.StaticLocalNumbers = new MapVectorPtrUInt</*const*/ VarDecl /*P*/ >(DenseMapInfo$LikePtr.$Info(), 0);
    this.ParamIndices = new DenseMapTypeUInt</*const*/ VarDecl /*P*/ >(DenseMapInfo$LikePtr.$Info(), 0);
    this.FirstLocalImport = /*implicit-init*/((ImportDecl /*P*/ )/*zero-init*/null);
    this.LastLocalImport = /*implicit-init*/((ImportDecl /*P*/ )/*zero-init*/null);
    this.ExternCContext = null;
    this.MakeIntegerSeqDecl = null;
    this.TypePackElementDecl = null;
    this./*&*/SourceMgr=/*&*/SM;
    this./*&*/LangOpts=/*&*/LOpts;
    this.SanitizerBL = new std.unique_ptr<SanitizerBlacklist>(new SanitizerBlacklist(LangOpts.SanitizerBlacklistFiles, SM));
    this.BumpAlloc = new BumpPtrAllocatorImpl();
    this.DiagAllocator = new PartialDiagnostic.StorageAllocator();
    this.ABI = new std.unique_ptr<CXXABI>();
    this.AddrSpaceMap = null;
    this.Target = null;
    this.AuxTarget = null;
    this.PrintingPolicy = new PrintingPolicy(LOpts);
    this./*&*/Idents=/*&*/idents;
    this./*&*/Selectors=/*&*/sels;
    this./*&*/BuiltinInfo=/*&*/builtins;
    this.DeclarationNames = new DeclarationNameTable(/*Deref*/this);
    this.ExternalSource = new IntrusiveRefCntPtr<ExternalASTSource>((ExternalASTSource /*P*/ )null);
    this.Listener = null;
    this.Comments = new RawCommentList(SM);
    this.CommentsLoaded = false;
    this.RedeclComments = new DenseMap</*const*/ Decl /*P*/ , RawCommentAndCacheFlags>(DenseMapInfo$LikePtr.$Info(), new RawCommentAndCacheFlags());
    this.ParsedComments = new DenseMap</*const*/ Decl /*P*/ , FullComment /*P*/ >(DenseMapInfo$LikePtr.$Info(), (FullComment /*P*/ )null);
    this.CommentCommandTraits = new CommandTraits(BumpAlloc, LOpts.CommentOpts);
    this.VoidTy = new CanQual<Type>();
    this.BoolTy = new CanQual<Type>();
    this.CharTy = new CanQual<Type>();
    this.WCharTy = new CanQual<Type>();
    this.WideCharTy = new CanQual<Type>();
    this.WIntTy = new CanQual<Type>();
    this.Char16Ty = new CanQual<Type>();
    this.Char32Ty = new CanQual<Type>();
    this.SignedCharTy = new CanQual<Type>();
    this.ShortTy = new CanQual<Type>();
    this.IntTy = new CanQual<Type>();
    this.LongTy = new CanQual<Type>();
    this.LongLongTy = new CanQual<Type>();
    this.Int128Ty = new CanQual<Type>();
    this.UnsignedCharTy = new CanQual<Type>();
    this.UnsignedShortTy = new CanQual<Type>();
    this.UnsignedIntTy = new CanQual<Type>();
    this.UnsignedLongTy = new CanQual<Type>();
    this.UnsignedLongLongTy = new CanQual<Type>();
    this.UnsignedInt128Ty = new CanQual<Type>();
    this.FloatTy = new CanQual<Type>();
    this.DoubleTy = new CanQual<Type>();
    this.LongDoubleTy = new CanQual<Type>();
    this.Float128Ty = new CanQual<Type>();
    this.HalfTy = new CanQual<Type>();
    this.FloatComplexTy = new CanQual<Type>();
    this.DoubleComplexTy = new CanQual<Type>();
    this.LongDoubleComplexTy = new CanQual<Type>();
    this.Float128ComplexTy = new CanQual<Type>();
    this.VoidPtrTy = new CanQual<Type>();
    this.NullPtrTy = new CanQual<Type>();
    this.DependentTy = new CanQual<Type>();
    this.OverloadTy = new CanQual<Type>();
    this.BoundMemberTy = new CanQual<Type>();
    this.UnknownAnyTy = new CanQual<Type>();
    this.BuiltinFnTy = new CanQual<Type>();
    this.PseudoObjectTy = new CanQual<Type>();
    this.ARCUnbridgedCastTy = new CanQual<Type>();
    this.ObjCBuiltinIdTy = new CanQual<Type>();
    this.ObjCBuiltinClassTy = new CanQual<Type>();
    this.ObjCBuiltinSelTy = new CanQual<Type>();
    this.ObjCBuiltinBoolTy = new CanQual<Type>();
    this.OCLImage1dROTy = new CanQual<Type>();
    this.OCLImage1dArrayROTy = new CanQual<Type>();
    this.OCLImage1dBufferROTy = new CanQual<Type>();
    this.OCLImage2dROTy = new CanQual<Type>();
    this.OCLImage2dArrayROTy = new CanQual<Type>();
    this.OCLImage2dDepthROTy = new CanQual<Type>();
    this.OCLImage2dArrayDepthROTy = new CanQual<Type>();
    this.OCLImage2dMSAAROTy = new CanQual<Type>();
    this.OCLImage2dArrayMSAAROTy = new CanQual<Type>();
    this.OCLImage2dMSAADepthROTy = new CanQual<Type>();
    this.OCLImage2dArrayMSAADepthROTy = new CanQual<Type>();
    this.OCLImage3dROTy = new CanQual<Type>();
    this.OCLImage1dWOTy = new CanQual<Type>();
    this.OCLImage1dArrayWOTy = new CanQual<Type>();
    this.OCLImage1dBufferWOTy = new CanQual<Type>();
    this.OCLImage2dWOTy = new CanQual<Type>();
    this.OCLImage2dArrayWOTy = new CanQual<Type>();
    this.OCLImage2dDepthWOTy = new CanQual<Type>();
    this.OCLImage2dArrayDepthWOTy = new CanQual<Type>();
    this.OCLImage2dMSAAWOTy = new CanQual<Type>();
    this.OCLImage2dArrayMSAAWOTy = new CanQual<Type>();
    this.OCLImage2dMSAADepthWOTy = new CanQual<Type>();
    this.OCLImage2dArrayMSAADepthWOTy = new CanQual<Type>();
    this.OCLImage3dWOTy = new CanQual<Type>();
    this.OCLImage1dRWTy = new CanQual<Type>();
    this.OCLImage1dArrayRWTy = new CanQual<Type>();
    this.OCLImage1dBufferRWTy = new CanQual<Type>();
    this.OCLImage2dRWTy = new CanQual<Type>();
    this.OCLImage2dArrayRWTy = new CanQual<Type>();
    this.OCLImage2dDepthRWTy = new CanQual<Type>();
    this.OCLImage2dArrayDepthRWTy = new CanQual<Type>();
    this.OCLImage2dMSAARWTy = new CanQual<Type>();
    this.OCLImage2dArrayMSAARWTy = new CanQual<Type>();
    this.OCLImage2dMSAADepthRWTy = new CanQual<Type>();
    this.OCLImage2dArrayMSAADepthRWTy = new CanQual<Type>();
    this.OCLImage3dRWTy = new CanQual<Type>();
    this.OCLSamplerTy = new CanQual<Type>();
    this.OCLEventTy = new CanQual<Type>();
    this.OCLClkEventTy = new CanQual<Type>();
    this.OCLQueueTy = new CanQual<Type>();
    this.OCLNDRangeTy = new CanQual<Type>();
    this.OCLReserveIDTy = new CanQual<Type>();
    this.OMPArraySectionTy = new CanQual<Type>();
    this.AutoDeductTy = new QualType();
    this.AutoRRefDeductTy = new QualType();
    this.Deallocations = new SmallVector<std.pair<VoidPtr2Void, Object/*void P*/ >>(16, new std.pairPtrPtr<VoidPtr2Void, Object/*void P*/ >());
    this.LastSDM = new PointerIntPair<StoredDeclsMap /*P*/ >((StoredDeclsMap /*P*/ )null, 0);
    this.PointerParents = new std.unique_ptr<DenseMap</*const*/Object/*void P*/ , PointerUnion4</*const*/ Decl /*P*/ , /*const*/ Stmt /*P*/ , DynTypedNode /*P*/ , SmallVector<DynTypedNode> /*P*/> > >();
    this.OtherParents = new std.unique_ptr<DenseMap<DynTypedNode, PointerUnion4</*const*/ Decl /*P*/ , /*const*/ Stmt /*P*/ , DynTypedNode /*P*/ , SmallVector<DynTypedNode> /*P*/>> >();
    this.VTContext = new std.unique_ptr<VTableContextBase>();
    this.SectionInfos = new StringMap<SectionInfo>(new SectionInfo());
    //END JInit
    TUDecl = TranslationUnitDecl.Create(/*Deref*/this);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::~ASTContext">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp", line = 755,
   FQN="clang::ASTContext::~ASTContext", NM="_ZN5clang10ASTContextD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZN5clang10ASTContextD0Ev")
  //</editor-fold>
  public void $destroy() {
    ReleaseParentMapEntries();
    
    // Release the DenseMaps associated with DeclContext objects.
    // FIXME: Is this the ideal solution?
    ReleaseDeclContextMaps();
    
    // Call all of the deallocation functions on all of their targets.
    for (final pair<VoidPtr2Void, Object/*void P*/ > /*&*/ Pair : Deallocations)  {
      (Pair.first).$call(Pair.second);
    }
    
    // ASTRecordLayout objects in ASTRecordLayouts must always be destroyed
    // because they can contain DenseMaps.
    for (DenseMapIterator</*const*/ ObjCContainerDecl /*P*/ , /*const*/ ASTRecordLayout /*P*/ > I = ObjCLayouts.begin(), E = ObjCLayouts.end(); I.$noteq(/*NO_ITER_COPY*/E);)  {
      {
        // Increment in loop to prevent using deallocated memory.
        ASTRecordLayout /*P*/ R = ((/*const_cast*/ASTRecordLayout /*P*/ )((I.$postInc(0)).$arrow().second));
        if ((R != null)) {
          R.Destroy(/*Deref*/this);
        }
      }
    }
    
    for (DenseMapIterator</*const*/ RecordDecl /*P*/ , /*const*/ ASTRecordLayout /*P*/ > I = ASTRecordLayouts.begin(), E = ASTRecordLayouts.end(); I.$noteq(/*NO_ITER_COPY*/E);) {
      {
        // Increment in loop to prevent using deallocated memory.
        ASTRecordLayout /*P*/ R = ((/*const_cast*/ASTRecordLayout /*P*/ )((I.$postInc(0)).$arrow().second));
        if ((R != null)) {
          R.Destroy(/*Deref*/this);
        }
      }
    }
    
    for (DenseMapIterator</*const*/ Decl /*P*/ , SmallVector<Attr /*P*/>/*P*/ > A = DeclAttrs.begin(), 
        AEnd = DeclAttrs.end();
         A.$noteq(/*NO_ITER_COPY*/AEnd); A.$preInc())  {
      A.$arrow().second.$destroy();
    }
    
    for (final std.pair</*const*/ MaterializeTemporaryExpr /*P*/ , APValue /*P*/ > /*&*/ MTVPair : MaterializedTemporaryValues)  {
      MTVPair.second.$destroy();
    }
    
    llvm.DeleteContainerSeconds(MangleNumberingContexts);
    //START JDestroy
    SectionInfos.$destroy();
    VTContext.$destroy();
    OtherParents.$destroy();
    PointerParents.$destroy();
    Deallocations.$destroy();
    CommentCommandTraits.$destroy();
    ParsedComments.$destroy();
    RedeclComments.$destroy();
    Comments.$destroy();
    ExternalSource.$destroy();
    DeclarationNames.$destroy();
    ABI.$destroy();
    DiagAllocator.$destroy();
    BumpAlloc.$destroy();
    SanitizerBL.$destroy();
    ParamIndices.$destroy();
    StaticLocalNumbers.$destroy();
    MangleNumbers.$destroy();
    MangleNumberingContexts.$destroy();
    OverriddenMethods.$destroy();
    InstantiatedFromUnnamedFieldDecl.$destroy();
    InstantiatedFromUsingShadowDecl.$destroy();
    InstantiatedFromUsingDecl.$destroy();
    TemplateOrInstantiation.$destroy();
    MergedDefModules.$destroy();
    MergedDecls.$destroy();
    DeclAttrs.$destroy();
    CanonTemplateTemplateParms.$destroy();
    MaterializedTemporaryValues.$destroy();
    ClassScopeSpecializationPattern.$destroy();
    BlockVarCopyInits.$destroy();
    ObjCMethodRedecls.$destroy();
    ObjCImpls.$destroy();
    KeyFunctions.$destroy();
    MemoizedTypeInfo.$destroy();
    ObjCLayouts.$destroy();
    ASTRecordLayouts.$destroy();
    NestedNameSpecifiers.$destroy();
    SubstTemplateTemplateParmPacks.$destroy();
    SubstTemplateTemplateParms.$destroy();
    DependentTemplateNames.$destroy();
    QualifiedTemplateNames.$destroy();
    PipeTypes.$destroy();
    AttributedTypes.$destroy();
    AtomicTypes.$destroy();
    AutoTypes.$destroy();
    DependentUnaryTransformTypes.$destroy();
    ObjCObjectPointerTypes.$destroy();
    ObjCObjectTypes.$destroy();
    PackExpansionTypes.$destroy();
    DependentTemplateSpecializationTypes.$destroy();
    DependentNameTypes.$destroy();
    ElaboratedTypes.$destroy();
    ParenTypes.$destroy();
    TemplateSpecializationTypes.$destroy();
    SubstTemplateTypeParmPackTypes.$destroy();
    SubstTemplateTypeParmTypes.$destroy();
    TemplateTypeParmTypes.$destroy();
    DependentDecltypeTypes.$destroy();
    DependentTypeOfExprTypes.$destroy();
    FunctionProtoTypes.$destroy();
    FunctionNoProtoTypes.$destroy();
    VectorTypes.$destroy();
    DependentSizedExtVectorTypes.$destroy();
    DependentSizedArrayTypes.$destroy();
    VariableArrayTypes.$destroy();
    IncompleteArrayTypes.$destroy();
    ConstantArrayTypes.$destroy();
    MemberPointerTypes.$destroy();
    RValueReferenceTypes.$destroy();
    LValueReferenceTypes.$destroy();
    BlockPointerTypes.$destroy();
    AdjustedTypes.$destroy();
    PointerTypes.$destroy();
    ComplexTypes.$destroy();
    ExtQualNodes.$destroy();
    Types.$destroy();
    super.$destroy();
    //END JDestroy
  }

  
  /// \brief Attach an external AST source to the AST context.
  ///
  /// The external AST source provides the ability to load parts of
  /// the abstract syntax tree as needed from some external storage,
  /// e.g., a precompiled header.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::setExternalSource">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp", line = 816,
   FQN="clang::ASTContext::setExternalSource", NM="_ZN5clang10ASTContext17setExternalSourceEN4llvm18IntrusiveRefCntPtrINS_17ExternalASTSourceEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZN5clang10ASTContext17setExternalSourceEN4llvm18IntrusiveRefCntPtrINS_17ExternalASTSourceEEE")
  //</editor-fold>
  public void setExternalSource(IntrusiveRefCntPtr<ExternalASTSource> Source) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean(ExternalSource.$assign($c$.track(new IntrusiveRefCntPtr(Source))));
    } finally {
      $c$.$destroy();
    }
  }

  
  /// \brief Retrieve a pointer to the external AST source associated
  /// with this AST context, if any.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::getExternalSource">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ASTContext.h", line = 943,
   FQN="clang::ASTContext::getExternalSource", NM="_ZNK5clang10ASTContext17getExternalSourceEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZNK5clang10ASTContext17getExternalSourceEv")
  //</editor-fold>
  public ExternalASTSource /*P*/ getExternalSource() /*const*/ {
    return ExternalSource.get();
  }

  
  /// \brief Attach an AST mutation listener to the AST context.
  ///
  /// The AST mutation listener provides the ability to track modifications to
  /// the abstract syntax tree entities committed after they were initially
  /// created.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::setASTMutationListener">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ASTContext.h", line = 952,
   FQN="clang::ASTContext::setASTMutationListener", NM="_ZN5clang10ASTContext22setASTMutationListenerEPNS_19ASTMutationListenerE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZN5clang10ASTContext22setASTMutationListenerEPNS_19ASTMutationListenerE")
  //</editor-fold>
  public void setASTMutationListener(ASTMutationListener /*P*/ Listener) {
    this.Listener = Listener;
  }

  
  /// \brief Retrieve a pointer to the AST mutation listener associated
  /// with this AST context, if any.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::getASTMutationListener">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ASTContext.h", line = 958,
   FQN="clang::ASTContext::getASTMutationListener", NM="_ZNK5clang10ASTContext22getASTMutationListenerEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZNK5clang10ASTContext22getASTMutationListenerEv")
  //</editor-fold>
  public ASTMutationListener /*P*/ getASTMutationListener() /*const*/ {
    return Listener;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::PrintStats">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp", line = 821,
   FQN="clang::ASTContext::PrintStats", NM="_ZNK5clang10ASTContext10PrintStatsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZNK5clang10ASTContext10PrintStatsEv")
  //</editor-fold>
  public void PrintStats() /*const*/ {
    llvm.errs().$out(/*KEEP_STR*/"\n*** AST Context Stats:\n");
    llvm.errs().$out(/*KEEP_STR*/"  ").$out_uint(Types.size()).$out(/*KEEP_STR*/" types total.\n");
    
    /*uint*/int counts[/*44*/] = new /*uint*/int [/*44*/] {
      0, 
      0, 
      0, 
      0, 
      0, 
      0, 
      0, 
      0, 
      0, 
      0, 
      0, 
      0, 
      0, 
      0, 
      0, 
      0, 
      0, 
      0, 
      0, 
      0, 
      0, 
      0, 
      0, 
      0, 
      0, 
      0, 
      0, 
      0, 
      0, 
      0, 
      0, 
      0, 
      0, 
      0, 
      0, 
      0, 
      0, 
      0, 
      0, 
      0, 
      0, 
      0, 
      0, 
      0 // Extra
    };
    
    for (/*uint*/int i = 0, e = Types.size(); i != e; ++i) {
      Type /*P*/ T = Types.$at(i);
      counts[(/*uint*/int)T.getTypeClass().getValue()]++;
    }

    /*uint*/int Idx = 0;
    /*uint*/int TotalBytes = 0;
    if ((counts[Idx] != 0)) {
      llvm.errs().$out(/*KEEP_STR*/"    ").$out_uint(counts[Idx]).$out(/*KEEP_STR*/$SPACE).$out(/*KEEP_STR*/"Builtin").$out(/*KEEP_STR*/" types\n");
    }
    TotalBytes += counts[Idx] * $sizeof_BuiltinType();
    ++Idx;
    if ((counts[Idx] != 0)) {
      llvm.errs().$out(/*KEEP_STR*/"    ").$out_uint(counts[Idx]).$out(/*KEEP_STR*/$SPACE).$out(/*KEEP_STR*/"Complex").$out(/*KEEP_STR*/" types\n");
    }
    TotalBytes += counts[Idx] * $sizeof_ComplexType();
    ++Idx;
    if ((counts[Idx] != 0)) {
      llvm.errs().$out(/*KEEP_STR*/"    ").$out_uint(counts[Idx]).$out(/*KEEP_STR*/$SPACE).$out(/*KEEP_STR*/"Pointer").$out(/*KEEP_STR*/" types\n");
    }
    TotalBytes += counts[Idx] * $sizeof_PointerType();
    ++Idx;
    if ((counts[Idx] != 0)) {
      llvm.errs().$out(/*KEEP_STR*/"    ").$out_uint(counts[Idx]).$out(/*KEEP_STR*/$SPACE).$out(/*KEEP_STR*/"BlockPointer").$out(/*KEEP_STR*/" types\n");
    }
    TotalBytes += counts[Idx] * $sizeof_BlockPointerType();
    ++Idx;
    if ((counts[Idx] != 0)) {
      llvm.errs().$out(/*KEEP_STR*/"    ").$out_uint(counts[Idx]).$out(/*KEEP_STR*/$SPACE).$out(/*KEEP_STR*/"LValueReference").$out(/*KEEP_STR*/" types\n");
    }
    TotalBytes += counts[Idx] * $sizeof_LValueReferenceType();
    ++Idx;
    if ((counts[Idx] != 0)) {
      llvm.errs().$out(/*KEEP_STR*/"    ").$out_uint(counts[Idx]).$out(/*KEEP_STR*/$SPACE).$out(/*KEEP_STR*/"RValueReference").$out(/*KEEP_STR*/" types\n");
    }
    TotalBytes += counts[Idx] * $sizeof_RValueReferenceType();
    ++Idx;
    if ((counts[Idx] != 0)) {
      llvm.errs().$out(/*KEEP_STR*/"    ").$out_uint(counts[Idx]).$out(/*KEEP_STR*/$SPACE).$out(/*KEEP_STR*/"MemberPointer").$out(/*KEEP_STR*/" types\n");
    }
    TotalBytes += counts[Idx] * $sizeof_MemberPointerType();
    ++Idx;
    if ((counts[Idx] != 0)) {
      llvm.errs().$out(/*KEEP_STR*/"    ").$out_uint(counts[Idx]).$out(/*KEEP_STR*/$SPACE).$out(/*KEEP_STR*/"ConstantArray").$out(/*KEEP_STR*/" types\n");
    }
    TotalBytes += counts[Idx] * $sizeof_ConstantArrayType();
    ++Idx;
    if ((counts[Idx] != 0)) {
      llvm.errs().$out(/*KEEP_STR*/"    ").$out_uint(counts[Idx]).$out(/*KEEP_STR*/$SPACE).$out(/*KEEP_STR*/"IncompleteArray").$out(/*KEEP_STR*/" types\n");
    }
    TotalBytes += counts[Idx] * $sizeof_IncompleteArrayType();
    ++Idx;
    if ((counts[Idx] != 0)) {
      llvm.errs().$out(/*KEEP_STR*/"    ").$out_uint(counts[Idx]).$out(/*KEEP_STR*/$SPACE).$out(/*KEEP_STR*/"VariableArray").$out(/*KEEP_STR*/" types\n");
    }
    TotalBytes += counts[Idx] * $sizeof_VariableArrayType();
    ++Idx;
    if ((counts[Idx] != 0)) {
      llvm.errs().$out(/*KEEP_STR*/"    ").$out_uint(counts[Idx]).$out(/*KEEP_STR*/$SPACE).$out(/*KEEP_STR*/"DependentSizedArray").$out(/*KEEP_STR*/" types\n");
    }
    TotalBytes += counts[Idx] * $sizeof_DependentSizedArrayType();
    ++Idx;
    if ((counts[Idx] != 0)) {
      llvm.errs().$out(/*KEEP_STR*/"    ").$out_uint(counts[Idx]).$out(/*KEEP_STR*/$SPACE).$out(/*KEEP_STR*/"DependentSizedExtVector").$out(/*KEEP_STR*/" types\n");
    }
    TotalBytes += counts[Idx] * $sizeof_DependentSizedExtVectorType();
    ++Idx;
    if ((counts[Idx] != 0)) {
      llvm.errs().$out(/*KEEP_STR*/"    ").$out_uint(counts[Idx]).$out(/*KEEP_STR*/$SPACE).$out(/*KEEP_STR*/"Vector").$out(/*KEEP_STR*/" types\n");
    }
    TotalBytes += counts[Idx] * $sizeof_VectorType();
    ++Idx;
    if ((counts[Idx] != 0)) {
      llvm.errs().$out(/*KEEP_STR*/"    ").$out_uint(counts[Idx]).$out(/*KEEP_STR*/$SPACE).$out(/*KEEP_STR*/"ExtVector").$out(/*KEEP_STR*/" types\n");
    }
    TotalBytes += counts[Idx] * $sizeof_ExtVectorType();
    ++Idx;
    if ((counts[Idx] != 0)) {
      llvm.errs().$out(/*KEEP_STR*/"    ").$out_uint(counts[Idx]).$out(/*KEEP_STR*/$SPACE).$out(/*KEEP_STR*/"FunctionProto").$out(/*KEEP_STR*/" types\n");
    }
    TotalBytes += counts[Idx] * $sizeof_FunctionProtoType();
    ++Idx;
    if ((counts[Idx] != 0)) {
      llvm.errs().$out(/*KEEP_STR*/"    ").$out_uint(counts[Idx]).$out(/*KEEP_STR*/$SPACE).$out(/*KEEP_STR*/"FunctionNoProto").$out(/*KEEP_STR*/" types\n");
    }
    TotalBytes += counts[Idx] * $sizeof_FunctionNoProtoType();
    ++Idx;
    if ((counts[Idx] != 0)) {
      llvm.errs().$out(/*KEEP_STR*/"    ").$out_uint(counts[Idx]).$out(/*KEEP_STR*/$SPACE).$out(/*KEEP_STR*/"UnresolvedUsing").$out(/*KEEP_STR*/" types\n");
    }
    TotalBytes += counts[Idx] * $sizeof_UnresolvedUsingType();
    ++Idx;
    if ((counts[Idx] != 0)) {
      llvm.errs().$out(/*KEEP_STR*/"    ").$out_uint(counts[Idx]).$out(/*KEEP_STR*/$SPACE).$out(/*KEEP_STR*/"Paren").$out(/*KEEP_STR*/" types\n");
    }
    TotalBytes += counts[Idx] * $sizeof_ParenType();
    ++Idx;
    if ((counts[Idx] != 0)) {
      llvm.errs().$out(/*KEEP_STR*/"    ").$out_uint(counts[Idx]).$out(/*KEEP_STR*/$SPACE).$out(/*KEEP_STR*/"Typedef").$out(/*KEEP_STR*/" types\n");
    }
    TotalBytes += counts[Idx] * $sizeof_TypedefType();
    ++Idx;
    if ((counts[Idx] != 0)) {
      llvm.errs().$out(/*KEEP_STR*/"    ").$out_uint(counts[Idx]).$out(/*KEEP_STR*/$SPACE).$out(/*KEEP_STR*/"Adjusted").$out(/*KEEP_STR*/" types\n");
    }
    TotalBytes += counts[Idx] * $sizeof_AdjustedType();
    ++Idx;
    if ((counts[Idx] != 0)) {
      llvm.errs().$out(/*KEEP_STR*/"    ").$out_uint(counts[Idx]).$out(/*KEEP_STR*/$SPACE).$out(/*KEEP_STR*/"Decayed").$out(/*KEEP_STR*/" types\n");
    }
    TotalBytes += counts[Idx] * $sizeof_DecayedType();
    ++Idx;
    if ((counts[Idx] != 0)) {
      llvm.errs().$out(/*KEEP_STR*/"    ").$out_uint(counts[Idx]).$out(/*KEEP_STR*/$SPACE).$out(/*KEEP_STR*/"TypeOfExpr").$out(/*KEEP_STR*/" types\n");
    }
    TotalBytes += counts[Idx] * $sizeof_TypeOfExprType();
    ++Idx;
    if ((counts[Idx] != 0)) {
      llvm.errs().$out(/*KEEP_STR*/"    ").$out_uint(counts[Idx]).$out(/*KEEP_STR*/$SPACE).$out(/*KEEP_STR*/"TypeOf").$out(/*KEEP_STR*/" types\n");
    }
    TotalBytes += counts[Idx] * $sizeof_TypeOfType();
    ++Idx;
    if ((counts[Idx] != 0)) {
      llvm.errs().$out(/*KEEP_STR*/"    ").$out_uint(counts[Idx]).$out(/*KEEP_STR*/$SPACE).$out(/*KEEP_STR*/"Decltype").$out(/*KEEP_STR*/" types\n");
    }
    TotalBytes += counts[Idx] * $sizeof_DecltypeType();
    ++Idx;
    if ((counts[Idx] != 0)) {
      llvm.errs().$out(/*KEEP_STR*/"    ").$out_uint(counts[Idx]).$out(/*KEEP_STR*/$SPACE).$out(/*KEEP_STR*/"UnaryTransform").$out(/*KEEP_STR*/" types\n");
    }
    TotalBytes += counts[Idx] * $sizeof_UnaryTransformType();
    ++Idx;
    if ((counts[Idx] != 0)) {
      llvm.errs().$out(/*KEEP_STR*/"    ").$out_uint(counts[Idx]).$out(/*KEEP_STR*/$SPACE).$out(/*KEEP_STR*/"Record").$out(/*KEEP_STR*/" types\n");
    }
    TotalBytes += counts[Idx] * $sizeof_RecordType();
    ++Idx;
    if ((counts[Idx] != 0)) {
      llvm.errs().$out(/*KEEP_STR*/"    ").$out_uint(counts[Idx]).$out(/*KEEP_STR*/$SPACE).$out(/*KEEP_STR*/"Enum").$out(/*KEEP_STR*/" types\n");
    }
    TotalBytes += counts[Idx] * $sizeof_EnumType();
    ++Idx;
    if ((counts[Idx] != 0)) {
      llvm.errs().$out(/*KEEP_STR*/"    ").$out_uint(counts[Idx]).$out(/*KEEP_STR*/$SPACE).$out(/*KEEP_STR*/"Elaborated").$out(/*KEEP_STR*/" types\n");
    }
    TotalBytes += counts[Idx] * $sizeof_ElaboratedType();
    ++Idx;
    if ((counts[Idx] != 0)) {
      llvm.errs().$out(/*KEEP_STR*/"    ").$out_uint(counts[Idx]).$out(/*KEEP_STR*/$SPACE).$out(/*KEEP_STR*/"Attributed").$out(/*KEEP_STR*/" types\n");
    }
    TotalBytes += counts[Idx] * $sizeof_AttributedType();
    ++Idx;
    if ((counts[Idx] != 0)) {
      llvm.errs().$out(/*KEEP_STR*/"    ").$out_uint(counts[Idx]).$out(/*KEEP_STR*/$SPACE).$out(/*KEEP_STR*/"TemplateTypeParm").$out(/*KEEP_STR*/" types\n");
    }
    TotalBytes += counts[Idx] * $sizeof_TemplateTypeParmType();
    ++Idx;
    if ((counts[Idx] != 0)) {
      llvm.errs().$out(/*KEEP_STR*/"    ").$out_uint(counts[Idx]).$out(/*KEEP_STR*/$SPACE).$out(/*KEEP_STR*/"SubstTemplateTypeParm").$out(/*KEEP_STR*/" types\n");
    }
    TotalBytes += counts[Idx] * $sizeof_SubstTemplateTypeParmType();
    ++Idx;
    if ((counts[Idx] != 0)) {
      llvm.errs().$out(/*KEEP_STR*/"    ").$out_uint(counts[Idx]).$out(/*KEEP_STR*/$SPACE).$out(/*KEEP_STR*/"SubstTemplateTypeParmPack").$out(/*KEEP_STR*/" types\n");
    }
    TotalBytes += counts[Idx] * $sizeof_SubstTemplateTypeParmPackType();
    ++Idx;
    if ((counts[Idx] != 0)) {
      llvm.errs().$out(/*KEEP_STR*/"    ").$out_uint(counts[Idx]).$out(/*KEEP_STR*/$SPACE).$out(/*KEEP_STR*/"TemplateSpecialization").$out(/*KEEP_STR*/" types\n");
    }
    TotalBytes += counts[Idx] * $sizeof_TemplateSpecializationType();
    ++Idx;
    if ((counts[Idx] != 0)) {
      llvm.errs().$out(/*KEEP_STR*/"    ").$out_uint(counts[Idx]).$out(/*KEEP_STR*/$SPACE).$out(/*KEEP_STR*/"Auto").$out(/*KEEP_STR*/" types\n");
    }
    TotalBytes += counts[Idx] * $sizeof_AutoType();
    ++Idx;
    if ((counts[Idx] != 0)) {
      llvm.errs().$out(/*KEEP_STR*/"    ").$out_uint(counts[Idx]).$out(/*KEEP_STR*/$SPACE).$out(/*KEEP_STR*/"InjectedClassName").$out(/*KEEP_STR*/" types\n");
    }
    TotalBytes += counts[Idx] * $sizeof_InjectedClassNameType();
    ++Idx;
    if ((counts[Idx] != 0)) {
      llvm.errs().$out(/*KEEP_STR*/"    ").$out_uint(counts[Idx]).$out(/*KEEP_STR*/$SPACE).$out(/*KEEP_STR*/"DependentName").$out(/*KEEP_STR*/" types\n");
    }
    TotalBytes += counts[Idx] * $sizeof_DependentNameType();
    ++Idx;
    if ((counts[Idx] != 0)) {
      llvm.errs().$out(/*KEEP_STR*/"    ").$out_uint(counts[Idx]).$out(/*KEEP_STR*/$SPACE).$out(/*KEEP_STR*/"DependentTemplateSpecialization").$out(/*KEEP_STR*/" types\n");
    }
    TotalBytes += counts[Idx] * $sizeof_DependentTemplateSpecializationType();
    ++Idx;
    if ((counts[Idx] != 0)) {
      llvm.errs().$out(/*KEEP_STR*/"    ").$out_uint(counts[Idx]).$out(/*KEEP_STR*/$SPACE).$out(/*KEEP_STR*/"PackExpansion").$out(/*KEEP_STR*/" types\n");
    }
    TotalBytes += counts[Idx] * $sizeof_PackExpansionType();
    ++Idx;
    if ((counts[Idx] != 0)) {
      llvm.errs().$out(/*KEEP_STR*/"    ").$out_uint(counts[Idx]).$out(/*KEEP_STR*/$SPACE).$out(/*KEEP_STR*/"ObjCObject").$out(/*KEEP_STR*/" types\n");
    }
    TotalBytes += counts[Idx] * $sizeof_ObjCObjectType();
    ++Idx;
    if ((counts[Idx] != 0)) {
      llvm.errs().$out(/*KEEP_STR*/"    ").$out_uint(counts[Idx]).$out(/*KEEP_STR*/$SPACE).$out(/*KEEP_STR*/"ObjCInterface").$out(/*KEEP_STR*/" types\n");
    }
    TotalBytes += counts[Idx] * $sizeof_ObjCInterfaceType();
    ++Idx;
    if ((counts[Idx] != 0)) {
      llvm.errs().$out(/*KEEP_STR*/"    ").$out_uint(counts[Idx]).$out(/*KEEP_STR*/$SPACE).$out(/*KEEP_STR*/"ObjCObjectPointer").$out(/*KEEP_STR*/" types\n");
    }
    TotalBytes += counts[Idx] * $sizeof_ObjCObjectPointerType();
    ++Idx;
    if ((counts[Idx] != 0)) {
      llvm.errs().$out(/*KEEP_STR*/"    ").$out_uint(counts[Idx]).$out(/*KEEP_STR*/$SPACE).$out(/*KEEP_STR*/"Pipe").$out(/*KEEP_STR*/" types\n");
    }
    TotalBytes += counts[Idx] * $sizeof_PipeType();
    ++Idx;
    if ((counts[Idx] != 0)) {
      llvm.errs().$out(/*KEEP_STR*/"    ").$out_uint(counts[Idx]).$out(/*KEEP_STR*/$SPACE).$out(/*KEEP_STR*/"Atomic").$out(/*KEEP_STR*/" types\n");
    }
    TotalBytes += counts[Idx] * $sizeof_AtomicType();
    ++Idx;
    
    llvm.errs().$out(/*KEEP_STR*/"Total bytes = ").$out_uint(TotalBytes).$out(/*KEEP_STR*/$LF);
    
    // Implicit special member functions.
    llvm.errs().$out_uint(NumImplicitDefaultConstructorsDeclared).$out(/*KEEP_STR*/$SLASH).$out_uint(
        NumImplicitDefaultConstructors
    ).$out(
        /*KEEP_STR*/" implicit default constructors created\n"
    );
    llvm.errs().$out_uint(NumImplicitCopyConstructorsDeclared).$out(/*KEEP_STR*/$SLASH).$out_uint(
        NumImplicitCopyConstructors
    ).$out(
        /*KEEP_STR*/" implicit copy constructors created\n"
    );
    if (getLangOpts().CPlusPlus) {
      llvm.errs().$out_uint(NumImplicitMoveConstructorsDeclared).$out(/*KEEP_STR*/$SLASH).$out_uint(
          NumImplicitMoveConstructors
      ).$out(
          /*KEEP_STR*/" implicit move constructors created\n"
      );
    }
    llvm.errs().$out_uint(NumImplicitCopyAssignmentOperatorsDeclared).$out(/*KEEP_STR*/$SLASH).$out_uint(
        NumImplicitCopyAssignmentOperators
    ).$out(
        /*KEEP_STR*/" implicit copy assignment operators created\n"
    );
    if (getLangOpts().CPlusPlus) {
      llvm.errs().$out_uint(NumImplicitMoveAssignmentOperatorsDeclared).$out(/*KEEP_STR*/$SLASH).$out_uint(
          NumImplicitMoveAssignmentOperators
      ).$out(
          /*KEEP_STR*/" implicit move assignment operators created\n"
      );
    }
    llvm.errs().$out_uint(NumImplicitDestructorsDeclared).$out(/*KEEP_STR*/$SLASH).$out_uint(
        NumImplicitDestructors
    ).$out(
        /*KEEP_STR*/" implicit destructors created\n"
    );
    if (ExternalSource.$bool()) {
      llvm.errs().$out(/*KEEP_STR*/$LF);
      ExternalSource.$arrow().PrintStats();
    }
    
    BumpAlloc.PrintStats();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::getTypes">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ASTContext.h", line = 961,
   FQN="clang::ASTContext::getTypes", NM="_ZNK5clang10ASTContext8getTypesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZNK5clang10ASTContext8getTypesEv")
  //</editor-fold>
  public /*const*/ SmallVectorImpl<Type /*P*/ > /*&*/ getTypes() /*const*/ {
    return Types;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::buildBuiltinTemplateDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp", line = 912,
   FQN="clang::ASTContext::buildBuiltinTemplateDecl", NM="_ZNK5clang10ASTContext24buildBuiltinTemplateDeclENS_19BuiltinTemplateKindEPKNS_14IdentifierInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZNK5clang10ASTContext24buildBuiltinTemplateDeclENS_19BuiltinTemplateKindEPKNS_14IdentifierInfoE")
  //</editor-fold>
  public BuiltinTemplateDecl /*P*/ buildBuiltinTemplateDecl(BuiltinTemplateKind BTK, 
                          /*const*/ IdentifierInfo /*P*/ II) /*const*/ {
    BuiltinTemplateDecl /*P*/ BuiltinTemplate = BuiltinTemplateDecl.Create(/*Deref*/this, TUDecl, new DeclarationName(II), BTK);
    BuiltinTemplate.setImplicit();
    TUDecl.addDecl(BuiltinTemplate);
    
    return BuiltinTemplate;
  }

  
  /// \brief Create a new implicit TU-level CXXRecordDecl or RecordDecl
  /// declaration.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::buildImplicitRecord">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp", line = 938,
   FQN="clang::ASTContext::buildImplicitRecord", NM="_ZNK5clang10ASTContext19buildImplicitRecordEN4llvm9StringRefENS_11TagTypeKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZNK5clang10ASTContext19buildImplicitRecordEN4llvm9StringRefENS_11TagTypeKindE")
  //</editor-fold>
  public RecordDecl /*P*/ buildImplicitRecord(StringRef Name) /*const*/ {
    return buildImplicitRecord(Name, 
                     TagTypeKind.TTK_Struct);
  }
  public RecordDecl /*P*/ buildImplicitRecord(StringRef Name, 
                     TagTypeKind TK/*= TTK_Struct*/) /*const*/ {
    SourceLocation Loc/*J*/= new SourceLocation();
    RecordDecl /*P*/ NewDecl;
    if (getLangOpts().CPlusPlus) {
      NewDecl = CXXRecordDecl.Create(/*Deref*/this, TK, getTranslationUnitDecl(), new SourceLocation(Loc), 
          new SourceLocation(Loc), $AddrOf(Idents.get(/*NO_COPY*/Name)));
    } else {
      NewDecl = RecordDecl.Create(/*Deref*/this, TK, getTranslationUnitDecl(), new SourceLocation(Loc), new SourceLocation(Loc), 
          $AddrOf(Idents.get(/*NO_COPY*/Name)));
    }
    NewDecl.setImplicit();
    NewDecl.addAttr(TypeVisibilityAttr.CreateImplicit(((/*const_cast*/ASTContext /*&*/ )(/*Deref*/this)), TypeVisibilityAttr.VisibilityType.Default));
    return NewDecl;
  }

  
  /// \brief Create a new implicit TU-level typedef declaration.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::buildImplicitTypedef">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp", line = 954,
   FQN="clang::ASTContext::buildImplicitTypedef", NM="_ZNK5clang10ASTContext20buildImplicitTypedefENS_8QualTypeEN4llvm9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZNK5clang10ASTContext20buildImplicitTypedefENS_8QualTypeEN4llvm9StringRefE")
  //</editor-fold>
  public TypedefDecl /*P*/ buildImplicitTypedef(QualType T, 
                      StringRef Name) /*const*/ {
    TypeSourceInfo /*P*/ TInfo = getTrivialTypeSourceInfo(new QualType(T));
    TypedefDecl /*P*/ NewDecl = TypedefDecl.Create(((/*const_cast*/ASTContext /*&*/ )(/*Deref*/this)), getTranslationUnitDecl(), 
        new SourceLocation(), new SourceLocation(), $AddrOf(Idents.get(/*NO_COPY*/Name)), TInfo);
    NewDecl.setImplicit();
    return NewDecl;
  }

  
  /// \brief Retrieve the declaration for the 128-bit signed integer type.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::getInt128Decl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp", line = 964,
   FQN="clang::ASTContext::getInt128Decl", NM="_ZNK5clang10ASTContext13getInt128DeclEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZNK5clang10ASTContext13getInt128DeclEv")
  //</editor-fold>
  public TypedefDecl /*P*/ getInt128Decl() /*const*/ {
    if (!(Int128Decl != null)) {
      Int128Decl = buildImplicitTypedef(Int128Ty.$QualType(), new StringRef(/*KEEP_STR*/"__int128_t"));
    }
    return Int128Decl;
  }

  
  /// \brief Retrieve the declaration for the 128-bit unsigned integer type.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::getUInt128Decl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp", line = 970,
   FQN="clang::ASTContext::getUInt128Decl", NM="_ZNK5clang10ASTContext14getUInt128DeclEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZNK5clang10ASTContext14getUInt128DeclEv")
  //</editor-fold>
  public TypedefDecl /*P*/ getUInt128Decl() /*const*/ {
    if (!(UInt128Decl != null)) {
      UInt128Decl = buildImplicitTypedef(UnsignedInt128Ty.$QualType(), new StringRef(/*KEEP_STR*/"__uint128_t"));
    }
    return UInt128Decl;
  }


  //===--------------------------------------------------------------------===//
  //                           Type Constructors
  //===--------------------------------------------------------------------===//
  /*private:*/
  /// \brief Return a type with extended qualifiers.
  
  //===----------------------------------------------------------------------===//
  //                   Type creation/memoization methods
  //===----------------------------------------------------------------------===//
  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::getExtQualType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp", line = 2147,
   FQN="clang::ASTContext::getExtQualType", NM="_ZNK5clang10ASTContext14getExtQualTypeEPKNS_4TypeENS_10QualifiersE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZNK5clang10ASTContext14getExtQualTypeEPKNS_4TypeENS_10QualifiersE")
  //</editor-fold>
  private QualType getExtQualType(/*const*/ Type /*P*/ baseType, Qualifiers quals) /*const*/ {
    /*uint*/int fastQuals = quals.getFastQualifiers();
    quals.removeFastQualifiers();
    
    // Check if we've already instantiated this type.
    FoldingSetNodeID ID/*J*/= new FoldingSetNodeID();
    ExtQuals.Profile(ID, baseType, /*NO_COPY*/quals);
    final type$ref<type$ptr<ExtQuals /*P*/>/*void P*/ > insertPos = create_type$null$ref(null);
    {
      ExtQuals /*P*/ eq = ExtQualNodes.FindNodeOrInsertPos(ID, insertPos);
      if ((eq != null)) {
        assert (eq.getQualifiers().$eq(/*NO_COPY*/quals));
        return new QualType(eq, fastQuals);
      }
    }
    
    // If the base type is not canonical, make the appropriate canonical type.
    QualType canon/*J*/= new QualType();
    if (!baseType.isCanonicalUnqualified()) {
      SplitQualType canonSplit = baseType.getCanonicalTypeInternal().split();
      canonSplit.Quals.addConsistentQualifiers(new Qualifiers(quals));
      canon.$assignMove(getExtQualType(canonSplit.Ty, new Qualifiers(canonSplit.Quals)));
      
      // Re-find the insert position.
      /*J:(void)*/ExtQualNodes.FindNodeOrInsertPos(ID, insertPos);
    }
    
    ExtQuals /*P*/ eq = /*NEW_EXPR [operator new] NM=_ZnwjRKN5clang10ASTContextEj*/
    /*new (*this, TypeAlignment)*/ $new_uint_ASTContext$C_uint(/*Deref*/this, TypeAlignment, (type$ptr<?> New$Mem)->{
        return new ExtQuals(baseType, new QualType(canon), new Qualifiers(quals));
     });
    ExtQualNodes.InsertNode(eq, insertPos.$deref());
    return new QualType(eq, fastQuals);
  }

  
  
  /// getTypeDeclType - Return the unique reference to the type for the
  /// specified type declaration.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::getTypeDeclTypeSlow">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp", line = 3189,
   FQN="clang::ASTContext::getTypeDeclTypeSlow", NM="_ZNK5clang10ASTContext19getTypeDeclTypeSlowEPKNS_8TypeDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZNK5clang10ASTContext19getTypeDeclTypeSlowEPKNS_8TypeDeclE")
  //</editor-fold>
  private QualType getTypeDeclTypeSlow(/*const*/ TypeDecl /*P*/ Decl) /*const*/ {
    assert ((Decl != null)) : "Passed null for Decl param";
    assert (!(Decl.TypeForDecl != null)) : "TypeForDecl present in slow case";
    {
      
      /*const*/ TypedefNameDecl /*P*/ Typedef = dyn_cast_TypedefNameDecl(Decl);
      if ((Typedef != null)) {
        return getTypedefType(Typedef);
      }
    }
    assert (!isa_TemplateTypeParmDecl(Decl)) : "Template type parameter types are always available.";
    {
      
      /*const*/ RecordDecl /*P*/ Record = dyn_cast_RecordDecl(Decl);
      if ((Record != null)) {
        assert (Record.isFirstDecl$Redeclarable()) : "struct/union has previous declaration";
        assert (!NeedsInjectedClassNameType(Record));
        return getRecordType(Record);
      } else {
        /*const*/ EnumDecl /*P*/ Enum = dyn_cast_EnumDecl(Decl);
        if ((Enum != null)) {
          assert (Enum.isFirstDecl$Redeclarable()) : "enum has previous declaration";
          return getEnumType(Enum);
        } else {
          /*const*/ UnresolvedUsingTypenameDecl /*P*/ Using = dyn_cast_UnresolvedUsingTypenameDecl(Decl);
          if ((Using != null)) {
            Type /*P*/ newType = /*NEW_EXPR [operator new] NM=_ZnwjRKN5clang10ASTContextEj*/
            /*new (*this, TypeAlignment)*/ $new_uint_ASTContext$C_uint(/*Deref*/this, TypeAlignment, (type$ptr<?> New$Mem)->{
                return new UnresolvedUsingType(Using);
             });
            Decl.TypeForDecl = newType;
            Types.push_back(newType);
          } else {
            throw new llvm_unreachable("TypeDecl without a type?");
          }
        }
      }
    }
    
    return new QualType(Decl.TypeForDecl, 0);
  }

/*public:*/
  /// \brief Return the uniqued reference to the type for an address space
  /// qualified type with the specified type and address space.
  ///
  /// The resulting type has a union of the qualifiers from T and the address
  /// space. If T already has an address space specifier, it is silently
  /// replaced.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::getAddrSpaceQualType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp", line = 2177,
   FQN="clang::ASTContext::getAddrSpaceQualType", NM="_ZNK5clang10ASTContext20getAddrSpaceQualTypeENS_8QualTypeEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZNK5clang10ASTContext20getAddrSpaceQualTypeENS_8QualTypeEj")
  //</editor-fold>
  public QualType getAddrSpaceQualType(QualType T, /*uint*/int AddressSpace) /*const*/ {
    QualType CanT = getCanonicalType(/*NO_COPY*/T).$QualType();
    if (CanT.getAddressSpace() == AddressSpace) {
      return new QualType(JD$Move.INSTANCE, T);
    }
    
    // If we are composing extended qualifiers together, merge together
    // into one ExtQuals node.
    QualifierCollector Quals/*J*/= new QualifierCollector();
    /*const*/ Type /*P*/ TypeNode = Quals.strip(new QualType(T));
    
    // If this type already has an address space specified, it cannot get
    // another one.
    assert (!Quals.hasAddressSpace()) : "Type cannot be in multiple addr spaces!";
    Quals.addAddressSpace(AddressSpace);
    
    return getExtQualType(TypeNode, new Qualifiers(Quals));
  }

  
  /// \brief Return the uniqued reference to the type for an Objective-C
  /// gc-qualified type.
  ///
  /// The retulting type has a union of the qualifiers from T and the gc
  /// attribute.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::getObjCGCQualType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp", line = 2197,
   FQN="clang::ASTContext::getObjCGCQualType", NM="_ZNK5clang10ASTContext17getObjCGCQualTypeENS_8QualTypeENS_10Qualifiers2GCE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZNK5clang10ASTContext17getObjCGCQualTypeENS_8QualTypeENS_10Qualifiers2GCE")
  //</editor-fold>
  public QualType getObjCGCQualType(QualType T, 
                   Qualifiers.GC GCAttr) /*const*/ {
    QualType CanT = getCanonicalType(/*NO_COPY*/T).$QualType();
    if (CanT.getObjCGCAttr() == GCAttr) {
      return new QualType(JD$Move.INSTANCE, T);
    }
    {
      
      /*const*/ PointerType /*P*/ ptr = T.$arrow().getAs(PointerType.class);
      if ((ptr != null)) {
        QualType Pointee = ptr.getPointeeType();
        if (Pointee.$arrow().isAnyPointerType()) {
          QualType ResultType = getObjCGCQualType(new QualType(Pointee), GCAttr);
          return getPointerType(/*NO_COPY*/ResultType);
        }
      }
    }
    
    // If we are composing extended qualifiers together, merge together
    // into one ExtQuals node.
    QualifierCollector Quals/*J*/= new QualifierCollector();
    /*const*/ Type /*P*/ TypeNode = Quals.strip(new QualType(T));
    
    // If this type already has an ObjCGC specified, it cannot get
    // another one.
    assert (!Quals.hasObjCGCAttr()) : "Type cannot have multiple ObjCGCs!";
    Quals.addObjCGCAttr(GCAttr);
    
    return getExtQualType(TypeNode, new Qualifiers(Quals));
  }

  
  /// \brief Return the uniqued reference to the type for a \c restrict
  /// qualified type.
  ///
  /// The resulting type has a union of the qualifiers from \p T and
  /// \c restrict.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::getRestrictType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ASTContext.h", line = 1011,
   FQN="clang::ASTContext::getRestrictType", NM="_ZNK5clang10ASTContext15getRestrictTypeENS_8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZNK5clang10ASTContext15getRestrictTypeENS_8QualTypeE")
  //</editor-fold>
  public QualType getRestrictType(QualType T) /*const*/ {
    return T.withFastQualifiers(Qualifiers.TQ.Restrict);
  }

  
  /// \brief Return the uniqued reference to the type for a \c volatile
  /// qualified type.
  ///
  /// The resulting type has a union of the qualifiers from \p T and
  /// \c volatile.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::getVolatileType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ASTContext.h", line = 1020,
   FQN="clang::ASTContext::getVolatileType", NM="_ZNK5clang10ASTContext15getVolatileTypeENS_8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZNK5clang10ASTContext15getVolatileTypeENS_8QualTypeE")
  //</editor-fold>
  public QualType getVolatileType(QualType T) /*const*/ {
    return T.withFastQualifiers(Qualifiers.TQ.Volatile);
  }

  
  /// \brief Return the uniqued reference to the type for a \c const
  /// qualified type.
  ///
  /// The resulting type has a union of the qualifiers from \p T and \c const.
  ///
  /// It can be reasonably expected that this will always be equivalent to
  /// calling T.withConst().
  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::getConstType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ASTContext.h", line = 1031,
   FQN="clang::ASTContext::getConstType", NM="_ZNK5clang10ASTContext12getConstTypeENS_8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZNK5clang10ASTContext12getConstTypeENS_8QualTypeE")
  //</editor-fold>
  public QualType getConstType(QualType T) /*const*/ {
    return T.withConst();
  }

  
  /// \brief Change the ExtInfo on a function type.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::adjustFunctionType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp", line = 2225,
   FQN="clang::ASTContext::adjustFunctionType", NM="_ZN5clang10ASTContext18adjustFunctionTypeEPKNS_12FunctionTypeENS1_7ExtInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZN5clang10ASTContext18adjustFunctionTypeEPKNS_12FunctionTypeENS1_7ExtInfoE")
  //</editor-fold>
  public /*const*/ FunctionType /*P*/ adjustFunctionType(/*const*/ FunctionType /*P*/ T, 
                    FunctionType.ExtInfo Info) {
    if (T.getExtInfo().$eq(/*NO_COPY*/Info)) {
      return T;
    }
    
    QualType Result/*J*/= new QualType();
    {
      /*const*/ FunctionNoProtoType /*P*/ FNPT = dyn_cast_FunctionNoProtoType(T);
      if ((FNPT != null)) {
        Result.$assignMove(getFunctionNoProtoType(FNPT.getReturnType(), Info));
      } else {
        /*const*/ FunctionProtoType /*P*/ FPT = cast_FunctionProtoType(T);
        FunctionProtoType.ExtProtoInfo EPI = FPT.getExtProtoInfo();
        EPI.ExtInfo.$assign(Info);
        Result.$assignMove(getFunctionType(FPT.getReturnType(), FPT.getParamTypes(), EPI));
      }
    }
    
    return cast_FunctionType(Result.getTypePtr());
  }

  
  /// Adjust the given function result type.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::getCanonicalFunctionResultType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp", line = 3027,
   FQN="clang::ASTContext::getCanonicalFunctionResultType", NM="_ZNK5clang10ASTContext30getCanonicalFunctionResultTypeENS_8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZNK5clang10ASTContext30getCanonicalFunctionResultTypeENS_8QualTypeE")
  //</editor-fold>
  public CanQual<Type> getCanonicalFunctionResultType(QualType ResultType) /*const*/ {
    CanQual<Type> CanResultType = getCanonicalType(/*NO_COPY*/ResultType);
    
    // Canonical result types do not have ARC lifetime qualifiers.
    if (CanResultType.getQualifiers().hasObjCLifetime()) {
      Qualifiers Qs = CanResultType.getQualifiers();
      Qs.removeObjCLifetime();
      return CanQual.<Type>CreateUnsafe(getQualifiedType(CanResultType.getUnqualifiedType().$QualType(), new Qualifiers(Qs)));
    }
    
    return CanResultType;
  }

  
  /// \brief Change the result type of a function type once it is deduced.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::adjustDeducedFunctionResultType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp", line = 2243,
   FQN="clang::ASTContext::adjustDeducedFunctionResultType", NM="_ZN5clang10ASTContext31adjustDeducedFunctionResultTypeEPNS_12FunctionDeclENS_8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZN5clang10ASTContext31adjustDeducedFunctionResultTypeEPNS_12FunctionDeclENS_8QualTypeE")
  //</editor-fold>
  public void adjustDeducedFunctionResultType(FunctionDecl /*P*/ FD, 
                                 QualType ResultType) {
    FD = FD.getMostRecentDecl$Redeclarable();
    while (true) {
      /*const*/ FunctionProtoType /*P*/ FPT = FD.getType().$arrow().castAs(FunctionProtoType.class);
      FunctionProtoType.ExtProtoInfo EPI = FPT.getExtProtoInfo();
      FD.setType(getFunctionType(new QualType(ResultType), FPT.getParamTypes(), EPI));
      {
        FunctionDecl /*P*/ Next = FD.getPreviousDecl$Redeclarable();
        if ((Next != null)) {
          FD = Next;
        } else {
          break;
        }
      }
    }
    {
      ASTMutationListener /*P*/ L = getASTMutationListener();
      if ((L != null)) {
        L.DeducedReturnType(FD, new QualType(ResultType));
      }
    }
  }

  
  /// \brief Change the exception specification on a function once it is
  /// delay-parsed, instantiated, or computed.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::adjustExceptionSpec">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp", line = 2287,
   FQN="clang::ASTContext::adjustExceptionSpec", NM="_ZN5clang10ASTContext19adjustExceptionSpecEPNS_12FunctionDeclERKNS_17FunctionProtoType17ExceptionSpecInfoEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZN5clang10ASTContext19adjustExceptionSpecEPNS_12FunctionDeclERKNS_17FunctionProtoType17ExceptionSpecInfoEb")
  //</editor-fold>
  public void adjustExceptionSpec(FunctionDecl /*P*/ FD, final /*const*/ FunctionProtoType.ExceptionSpecInfo /*&*/ ESI) {
    adjustExceptionSpec(FD, ESI, 
                     false);
  }
  public void adjustExceptionSpec(FunctionDecl /*P*/ FD, final /*const*/ FunctionProtoType.ExceptionSpecInfo /*&*/ ESI, 
                     boolean AsWritten/*= false*/) {
    // Update the type.
    QualType Updated = getFunctionTypeWithExceptionSpec(/*Deref*/this, FD.getType(), ESI);
    FD.setType(new QualType(Updated));
    if (!AsWritten) {
      return;
    }
    {
      
      // Update the type in the type source information too.
      TypeSourceInfo /*P*/ TSInfo = FD.getTypeSourceInfo();
      if ((TSInfo != null)) {
        // If the type and the type-as-written differ, we may need to update
        // the type-as-written too.
        if ($noteq_QualType$C(TSInfo.getType(), FD.getType())) {
          Updated.$assignMove(getFunctionTypeWithExceptionSpec(/*Deref*/this, TSInfo.getType(), ESI));
        }
        
        // FIXME: When we get proper type location information for exceptions,
        // we'll also have to rebuild the TypeSourceInfo. For now, we just patch
        // up the TypeSourceInfo;
        assert (TypeLoc.getFullDataSizeForType(/*NO_COPY*/Updated) == TypeLoc.getFullDataSizeForType(TSInfo.getType())) : "TypeLoc size mismatch from updating exception specification";
        TSInfo.overrideType(/*NO_COPY*/Updated);
      }
    }
  }

  
  /// \brief Return the uniqued reference to the type for a complex
  /// number with the specified element type.

  /// getComplexType - Return the uniqued reference to the type for a complex
  /// number with the specified element type.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::getComplexType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp", line = 2317,
   FQN="clang::ASTContext::getComplexType", NM="_ZNK5clang10ASTContext14getComplexTypeENS_8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZNK5clang10ASTContext14getComplexTypeENS_8QualTypeE")
  //</editor-fold>
  public QualType getComplexType(QualType T) /*const*/ {
    // Unique pointers, to guarantee there is only one pointer of a particular
    // structure.
    FoldingSetNodeID ID/*J*/= new FoldingSetNodeID();
    ComplexType.Profile(ID, /*NO_COPY*/T);
    
    final type$ref<type$ptr<ComplexType /*P*/>/*void P*/ > InsertPos = create_type$null$ref(null);
    {
      ComplexType /*P*/ CT = ComplexTypes.FindNodeOrInsertPos(ID, InsertPos);
      if ((CT != null)) {
        return new QualType(CT, 0);
      }
    }
    
    // If the pointee type isn't canonical, this won't be a canonical type either,
    // so fill in the canonical type field.
    QualType Canonical/*J*/= new QualType();
    if (!T.isCanonical()) {
      Canonical.$assignMove(getComplexType(getCanonicalType(/*NO_COPY*/T)).$QualType());
      
      // Get the new insert position for the node we care about.
      ComplexType /*P*/ NewIP = ComplexTypes.FindNodeOrInsertPos(ID, InsertPos);
      assert (!(NewIP != null)) : "Shouldn't be in the map!";
      ///*J:(void)*/NewIP;
    }
    ComplexType /*P*/ New = /*NEW_EXPR [operator new] NM=_ZnwjRKN5clang10ASTContextEj*/
    /*new (*this, TypeAlignment)*/ $new_uint_ASTContext$C_uint(/*Deref*/this, TypeAlignment, (type$ptr<?> New$Mem)->{
        return new ComplexType(new QualType(T), new QualType(Canonical));
     });
    Types.push_back(New);
    ComplexTypes.InsertNode(New, InsertPos.$deref());
    return new QualType(New, 0);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::getComplexType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ASTContext.h", line = 1052,
   FQN="clang::ASTContext::getComplexType", NM="_ZNK5clang10ASTContext14getComplexTypeENS_7CanQualINS_4TypeEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZNK5clang10ASTContext14getComplexTypeENS_7CanQualINS_4TypeEEE")
  //</editor-fold>
  public CanQual<Type> getComplexType(CanQual<Type> T) /*const*/ {
    return CanQual.<Type>CreateUnsafe(getComplexType((QualType)T.$QualType()));
  }

  
  /// \brief Return the uniqued reference to the type for a pointer to
  /// the specified type.
  
  /// getPointerType - Return the uniqued reference to the type for a pointer to
  /// the specified type.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::getPointerType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp", line = 2345,
   FQN="clang::ASTContext::getPointerType", NM="_ZNK5clang10ASTContext14getPointerTypeENS_8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZNK5clang10ASTContext14getPointerTypeENS_8QualTypeE")
  //</editor-fold>
  public QualType getPointerType(QualType T) /*const*/ {      
    // Unique pointers, to guarantee there is only one pointer of a particular
    // structure.
    FoldingSetNodeID ID/*J*/= new FoldingSetNodeID();
    PointerType.Profile(ID, /*NO_COPY*/T);
    
    final type$ref<type$ptr<PointerType /*P*/>/*void P*/ > InsertPos = create_type$null$ref(null);
    {
      PointerType /*P*/ PT = PointerTypes.FindNodeOrInsertPos(ID, InsertPos);
      if ((PT != null)) {
        return new QualType(PT, 0);
      }
    }
    
    // If the pointee type isn't canonical, this won't be a canonical type either,
    // so fill in the canonical type field.
    QualType Canonical/*J*/= new QualType();
    if (!T.isCanonical()) {
      Canonical.$assignMove(getPointerType(getCanonicalType(/*NO_COPY*/T)).$QualType());
      
      // Get the new insert position for the node we care about.
      PointerType /*P*/ NewIP = PointerTypes.FindNodeOrInsertPos(ID, InsertPos);
      assert (!(NewIP != null)) : "Shouldn't be in the map!";
      ///*J:(void)*/NewIP;
    }
    PointerType /*P*/ New = /*NEW_EXPR [operator new] NM=_ZnwjRKN5clang10ASTContextEj*/
    /*new (*this, TypeAlignment)*/ $new_uint_ASTContext$C_uint(/*Deref*/this, TypeAlignment, (type$ptr<?> New$Mem)->{
        return new PointerType(new QualType(T), new QualType(Canonical));
     });
    Types.push_back(New);
    PointerTypes.InsertNode(New, InsertPos.$deref());
    return new QualType(New, 0);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::getPointerType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ASTContext.h", line = 1059,
   FQN="clang::ASTContext::getPointerType", NM="_ZNK5clang10ASTContext14getPointerTypeENS_7CanQualINS_4TypeEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZNK5clang10ASTContext14getPointerTypeENS_7CanQualINS_4TypeEEE")
  //</editor-fold>
  public CanQual<Type> getPointerType(CanQual<Type> T) /*const*/ {
    return CanQual.<Type>CreateUnsafe(getPointerType((QualType)T.$QualType()));
  }

  
  /// \brief Return the uniqued reference to a type adjusted from the original
  /// type to a new type.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::getAdjustedType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp", line = 2371,
   FQN="clang::ASTContext::getAdjustedType", NM="_ZNK5clang10ASTContext15getAdjustedTypeENS_8QualTypeES1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZNK5clang10ASTContext15getAdjustedTypeENS_8QualTypeES1_")
  //</editor-fold>
  public QualType getAdjustedType(QualType Orig, QualType New) /*const*/ {
    FoldingSetNodeID ID/*J*/= new FoldingSetNodeID();
    AdjustedType.Profile(ID, /*NO_COPY*/Orig, /*NO_COPY*/New);
    final type$ref<type$ptr<AdjustedType /*P*/>/*void P*/ > InsertPos = create_type$null$ref(null);
    AdjustedType /*P*/ AT = AdjustedTypes.FindNodeOrInsertPos(ID, InsertPos);
    if ((AT != null)) {
      return new QualType(AT, 0);
    }

    QualType Canonical = getCanonicalType(/*NO_COPY*/New).$QualType();
    
    // Get the new insert position for the node we care about.
    AT = AdjustedTypes.FindNodeOrInsertPos(ID, InsertPos);
    assert (!(AT != null)) : "Shouldn't be in the map!";
    
    AT = /*NEW_EXPR [operator new] NM=_ZnwjRKN5clang10ASTContextEj*/
    /*new (*this, TypeAlignment)*/ $new_uint_ASTContext$C_uint(/*Deref*/this, TypeAlignment, (type$ptr<?> New$Mem)->{
        return new AdjustedType(Type.TypeClass.Adjusted, new QualType(Orig), new QualType(New), new QualType(Canonical));
     });
    Types.push_back(AT);
    AdjustedTypes.InsertNode(AT, InsertPos.$deref());
    return new QualType(AT, 0);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::getAdjustedType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ASTContext.h", line = 1066,
   FQN="clang::ASTContext::getAdjustedType", NM="_ZNK5clang10ASTContext15getAdjustedTypeENS_7CanQualINS_4TypeEEES3_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZNK5clang10ASTContext15getAdjustedTypeENS_7CanQualINS_4TypeEEES3_")
  //</editor-fold>
  public CanQual<Type> getAdjustedType(CanQual<Type> Orig, CanQual<Type> New) /*const*/ {
    return CanQual.<Type>CreateUnsafe(getAdjustedType((QualType)Orig.$QualType(), (QualType)New.$QualType()));
  }

  
  /// \brief Return the uniqued reference to the decayed version of the given
  /// type.  Can only be called on array and function types which decay to
  /// pointer types.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::getDecayedType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp", line = 2392,
   FQN="clang::ASTContext::getDecayedType", NM="_ZNK5clang10ASTContext14getDecayedTypeENS_8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZNK5clang10ASTContext14getDecayedTypeENS_8QualTypeE")
  //</editor-fold>
  public QualType getDecayedType(QualType T) /*const*/ {
    assert ((T.$arrow().isArrayType() || T.$arrow().isFunctionType())) : "T does not decay";
    
    QualType Decayed/*J*/= new QualType();
    
    // C99 6.7.5.3p7:
    //   A declaration of a parameter as "array of type" shall be
    //   adjusted to "qualified pointer to type", where the type
    //   qualifiers (if any) are those specified within the [ and ] of
    //   the array type derivation.
    if (T.$arrow().isArrayType()) {
      Decayed.$assignMove(getArrayDecayedType(new QualType(T)));
  }

    // C99 6.7.5.3p8:
    //   A declaration of a parameter as "function returning type"
    //   shall be adjusted to "pointer to function returning type", as
    //   in 6.3.2.1.
    if (T.$arrow().isFunctionType()) {
      Decayed.$assignMove(getPointerType(/*NO_COPY*/T));
    }
    
    FoldingSetNodeID ID/*J*/= new FoldingSetNodeID();
    AdjustedType.Profile(ID, /*NO_COPY*/T, /*NO_COPY*/Decayed);
    final type$ref<type$ptr<AdjustedType /*P*/>/*void P*/ > InsertPos = create_type$null$ref(null);
    AdjustedType /*P*/ AT = AdjustedTypes.FindNodeOrInsertPos(ID, InsertPos);
    if ((AT != null)) {
      return new QualType(AT, 0);
    }
    
    QualType Canonical = getCanonicalType(/*NO_COPY*/Decayed).$QualType();
    
    // Get the new insert position for the node we care about.
    AT = AdjustedTypes.FindNodeOrInsertPos(ID, InsertPos);
    assert (!(AT != null)) : "Shouldn't be in the map!";
    
    AT = /*NEW_EXPR [operator new] NM=_ZnwjRKN5clang10ASTContextEj*/
    /*new (*this, TypeAlignment)*/ $new_uint_ASTContext$C_uint(/*Deref*/this, TypeAlignment, (type$ptr<?> New$Mem)->{
        return new DecayedType(new QualType(T), new QualType(Decayed), new QualType(Canonical));
     });
    Types.push_back(AT);
    AdjustedTypes.InsertNode(AT, InsertPos.$deref());
    return new QualType(AT, 0);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::getDecayedType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ASTContext.h", line = 1075,
   FQN="clang::ASTContext::getDecayedType", NM="_ZNK5clang10ASTContext14getDecayedTypeENS_7CanQualINS_4TypeEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZNK5clang10ASTContext14getDecayedTypeENS_7CanQualINS_4TypeEEE")
  //</editor-fold>
  public CanQual<Type> getDecayedType(CanQual<Type> T) /*const*/ {
    return CanQual.<Type>CreateUnsafe(getDecayedType((QualType)T.$QualType()));
  }

  
  /// \brief Return the uniqued reference to the atomic type for the specified
  /// type.
  
  /// getAtomicType - Return the uniqued reference to the atomic type for
  /// the given value type.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::getAtomicType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp", line = 4063,
   FQN="clang::ASTContext::getAtomicType", NM="_ZNK5clang10ASTContext13getAtomicTypeENS_8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZNK5clang10ASTContext13getAtomicTypeENS_8QualTypeE")
  //</editor-fold>
  public QualType getAtomicType(QualType T) /*const*/ {
    // Unique pointers, to guarantee there is only one pointer of a particular
    // structure.
    FoldingSetNodeID ID/*J*/= new FoldingSetNodeID();
    AtomicType.Profile(ID, /*NO_COPY*/T);
    
    final type$ref<type$ptr<AtomicType /*P*/>/*void P*/ > InsertPos = create_type$null$ref(null);
    {
      AtomicType /*P*/ AT = AtomicTypes.FindNodeOrInsertPos(ID, InsertPos);
      if ((AT != null)) {
        return new QualType(AT, 0);
  }
    }

    // If the atomic value type isn't canonical, this won't be a canonical type
    // either, so fill in the canonical type field.
    QualType Canonical/*J*/= new QualType();
    if (!T.isCanonical()) {
      Canonical.$assignMove(getAtomicType(getCanonicalType(/*NO_COPY*/T).$QualType()));
  
      // Get the new insert position for the node we care about.
      AtomicType /*P*/ NewIP = AtomicTypes.FindNodeOrInsertPos(ID, InsertPos);
      assert (!(NewIP != null)) : "Shouldn't be in the map!";
      ///*J:(void)*/NewIP;
    }
    AtomicType /*P*/ New = /*NEW_EXPR [operator new] NM=_ZnwjRKN5clang10ASTContextEj*/
    /*new (*this, TypeAlignment)*/ $new_uint_ASTContext$C_uint(/*Deref*/this, TypeAlignment, (type$ptr<?> New$Mem)->{
        return new AtomicType(new QualType(T), new QualType(Canonical));
     });
    Types.push_back(New);
    AtomicTypes.InsertNode(New, InsertPos.$deref());
    return new QualType(New, 0);
  }

  
  /// \brief Return the uniqued reference to the type for a block of the
  /// specified type.
  
  /// getBlockPointerType - Return the uniqued reference to the type for
  /// a pointer to the specified block.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::getBlockPointerType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp", line = 2433,
   FQN="clang::ASTContext::getBlockPointerType", NM="_ZNK5clang10ASTContext19getBlockPointerTypeENS_8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZNK5clang10ASTContext19getBlockPointerTypeENS_8QualTypeE")
  //</editor-fold>
  public QualType getBlockPointerType(QualType T) /*const*/ {
    assert (T.$arrow().isFunctionType()) : "block of function types only";
    // Unique pointers, to guarantee there is only one block of a particular
    // structure.
    FoldingSetNodeID ID/*J*/= new FoldingSetNodeID();
    BlockPointerType.Profile(ID, /*NO_COPY*/T);
    
    final type$ref<type$ptr<BlockPointerType /*P*/>/*void P*/ > InsertPos = create_type$null$ref(null);
    {
      BlockPointerType /*P*/ PT = BlockPointerTypes.FindNodeOrInsertPos(ID, InsertPos);
      if ((PT != null)) {
        return new QualType(PT, 0);
  }
    }

    // If the block pointee type isn't canonical, this won't be a canonical
    // type either so fill in the canonical type field.
    QualType Canonical/*J*/= new QualType();
    if (!T.isCanonical()) {
      Canonical.$assignMove(getBlockPointerType(getCanonicalType(/*NO_COPY*/T).$QualType()));
  
      // Get the new insert position for the node we care about.
      BlockPointerType /*P*/ NewIP = BlockPointerTypes.FindNodeOrInsertPos(ID, InsertPos);
      assert (!(NewIP != null)) : "Shouldn't be in the map!";
      ///*J:(void)*/NewIP;
    }
    BlockPointerType /*P*/ New = /*NEW_EXPR [operator new] NM=_ZnwjRKN5clang10ASTContextEj*/
    /*new (*this, TypeAlignment)*/ $new_uint_ASTContext$C_uint(/*Deref*/this, TypeAlignment, (type$ptr<?> New$Mem)->{
        return new BlockPointerType(new QualType(T), new QualType(Canonical));
     });
    Types.push_back(New);
    BlockPointerTypes.InsertNode(New, InsertPos.$deref());
    return new QualType(New, 0);
  }

  
  /// Gets the struct used to keep track of the descriptor for pointer to
  /// blocks.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::getBlockDescriptorType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp", line = 4965,
   FQN="clang::ASTContext::getBlockDescriptorType", NM="_ZNK5clang10ASTContext22getBlockDescriptorTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZNK5clang10ASTContext22getBlockDescriptorTypeEv")
  //</editor-fold>
  public QualType getBlockDescriptorType() /*const*/ {
    if ((BlockDescriptorType != null)) {
      return getTagDeclType(BlockDescriptorType);
  }

    RecordDecl /*P*/ RD;
    // FIXME: Needs the FlagAppleBlock bit.
    RD = buildImplicitRecord(new StringRef(/*KEEP_STR*/"__block_descriptor"));
    RD.startDefinition();
  
    QualType FieldTypes[/*2*/] = new QualType [/*2*/] {
      UnsignedLongTy.$QualType(), 
      UnsignedLongTy.$QualType()
    };
    
    final/*static*/ type$ptr</*const*/char$ptr/*char P*//*const*//*[2]*/> FieldNames = getBlockDescriptorType$$.FieldNames;
    
    for (/*size_t*/int i = 0; $less_uint(i, 2); ++i) {
      FieldDecl /*P*/ Field = FieldDecl.Create(/*Deref*/this, RD, new SourceLocation(), new SourceLocation(), 
          $AddrOf(Idents.get(new StringRef(FieldNames.$at(i)))), new QualType(FieldTypes[i]), /*TInfo=*/ (TypeSourceInfo /*P*/ )null, 
          /*BitWidth=*/ (Expr /*P*/ )null, /*Mutable=*/ false, InClassInitStyle.ICIS_NoInit);
      Field.setAccess(AccessSpecifier.AS_public);
      RD.addDecl(Field);
    }
    
    RD.completeDefinition();
    
    BlockDescriptorType = RD;
    
    return getTagDeclType(BlockDescriptorType);
  }
  private static final class getBlockDescriptorType$$ {
    static final/*static*/ type$ptr</*const*/char$ptr/*char P*//*const*//*[2]*/> FieldNames = create_type$ptr(new /*const*/char$ptr/*char P*//*const*/ [/*2*/] {
      $("reserved"), 
      $("Size")
    });
  }

  
  /// \brief Return pipe type for the specified type.
  
  /// Return pipe type for the specified type.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::getPipeType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp", line = 3129,
   FQN="clang::ASTContext::getPipeType", NM="_ZNK5clang10ASTContext11getPipeTypeENS_8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZNK5clang10ASTContext11getPipeTypeENS_8QualTypeE")
  //</editor-fold>
  public QualType getPipeType(QualType T) /*const*/ {
    FoldingSetNodeID ID/*J*/= new FoldingSetNodeID();
    PipeType.Profile(ID, /*NO_COPY*/T);
    
    final type$ref<type$ptr<PipeType /*P*/>/*void P*/ > InsertPos = create_type$ref(null);
    {
      PipeType /*P*/ PT = PipeTypes.FindNodeOrInsertPos(ID, InsertPos);
      if ((PT != null)) {
        return new QualType(PT, 0);
  }
    }

    // If the pipe element type isn't canonical, this won't be a canonical type
    // either, so fill in the canonical type field.
    QualType Canonical/*J*/= new QualType();
    if (!T.isCanonical()) {
      Canonical.$assignMove(getPipeType(getCanonicalType(/*NO_COPY*/T).$QualType()));
  
      // Get the new insert position for the node we care about.
      PipeType /*P*/ NewIP = PipeTypes.FindNodeOrInsertPos(ID, InsertPos);
      assert (!(NewIP != null)) : "Shouldn't be in the map!";
      ///*J:(void)*/NewIP;
    }
    PipeType /*P*/ New = /*NEW_EXPR [operator new] NM=_ZnwjRKN5clang10ASTContextEj*/
    /*new (*this, TypeAlignment)*/ $new_uint_ASTContext$C_uint(/*Deref*/this, TypeAlignment, (type$ptr<?> New$Mem)->{
        return new PipeType(new QualType(T), new QualType(Canonical));
     });
    Types.push_back(New);
    PipeTypes.InsertNode(New, InsertPos.$deref());
    return new QualType(New, 0);
  }

  
  /// Gets the struct used to keep track of the extended descriptor for
  /// pointer to blocks.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::getBlockDescriptorExtendedType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp", line = 5000,
   FQN="clang::ASTContext::getBlockDescriptorExtendedType", NM="_ZNK5clang10ASTContext30getBlockDescriptorExtendedTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZNK5clang10ASTContext30getBlockDescriptorExtendedTypeEv")
  //</editor-fold>
  public QualType getBlockDescriptorExtendedType() /*const*/ {
    if ((BlockDescriptorExtendedType != null)) {
      return getTagDeclType(BlockDescriptorExtendedType);
  }

    RecordDecl /*P*/ RD;
    // FIXME: Needs the FlagAppleBlock bit.
    RD = buildImplicitRecord(new StringRef(/*KEEP_STR*/"__block_descriptor_withcopydispose"));
    RD.startDefinition();
  
    QualType FieldTypes[/*4*/] = new QualType [/*4*/] {
      UnsignedLongTy.$QualType(), 
      UnsignedLongTy.$QualType(), 
      getPointerType(/*NO_COPY*/VoidPtrTy).$QualType(), 
      getPointerType(/*NO_COPY*/VoidPtrTy).$QualType()
    };
    
    final/*static*/ type$ptr</*const*/char$ptr/*char P*//*const*//*[4]*/> FieldNames = getBlockDescriptorExtendedType$$.FieldNames;
    
    for (/*size_t*/int i = 0; $less_uint(i, 4); ++i) {
      FieldDecl /*P*/ Field = FieldDecl.Create(/*Deref*/this, RD, new SourceLocation(), new SourceLocation(), 
          $AddrOf(Idents.get(new StringRef(FieldNames.$at(i)))), new QualType(FieldTypes[i]), /*TInfo=*/ (TypeSourceInfo /*P*/ )null, 
          /*BitWidth=*/ (Expr /*P*/ )null, 
          /*Mutable=*/ false, InClassInitStyle.ICIS_NoInit);
      Field.setAccess(AccessSpecifier.AS_public);
      RD.addDecl(Field);
    }
    
    RD.completeDefinition();
    
    BlockDescriptorExtendedType = RD;
    return getTagDeclType(BlockDescriptorExtendedType);
  }
  private static final class getBlockDescriptorExtendedType$$ {
    static final/*static*/ type$ptr</*const*/char$ptr/*char P*//*const*//*[4]*/> FieldNames = create_type$ptr(new /*const*/char$ptr/*char P*//*const*/ [/*4*/] {
      $("reserved"), 
      $("Size"), 
      $("CopyFuncPtr"), 
      $("DestroyFuncPtr")
    });
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::setcudaConfigureCallDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ASTContext.h", line = 1098,
   FQN="clang::ASTContext::setcudaConfigureCallDecl", NM="_ZN5clang10ASTContext24setcudaConfigureCallDeclEPNS_12FunctionDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZN5clang10ASTContext24setcudaConfigureCallDeclEPNS_12FunctionDeclE")
  //</editor-fold>
  public void setcudaConfigureCallDecl(FunctionDecl /*P*/ FD) {
    cudaConfigureCallDecl = FD;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::getcudaConfigureCallDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ASTContext.h", line = 1101,
   FQN="clang::ASTContext::getcudaConfigureCallDecl", NM="_ZN5clang10ASTContext24getcudaConfigureCallDeclEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZN5clang10ASTContext24getcudaConfigureCallDeclEv")
  //</editor-fold>
  public FunctionDecl /*P*/ getcudaConfigureCallDecl() {
    return cudaConfigureCallDecl;
  }

  
  /// Returns true iff we need copy/dispose helpers for the given type.
  
  /// BlockRequiresCopying - Returns true if byref variable "D" of type "Ty"
  /// requires copy/dispose. Note that this must match the logic
  /// in buildByrefHelpers.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::BlockRequiresCopying">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp", line = 5042,
   FQN="clang::ASTContext::BlockRequiresCopying", NM="_ZN5clang10ASTContext20BlockRequiresCopyingENS_8QualTypeEPKNS_7VarDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZN5clang10ASTContext20BlockRequiresCopyingENS_8QualTypeEPKNS_7VarDeclE")
  //</editor-fold>
  public boolean BlockRequiresCopying(QualType Ty, 
                      /*const*/ VarDecl /*P*/ D) {
    {
      /*const*/ CXXRecordDecl /*P*/ record = Ty.$arrow().getAsCXXRecordDecl();
      if ((record != null)) {
        /*const*/ Expr /*P*/ copyExpr = getBlockVarCopyInits(D);
        if (!(copyExpr != null) && record.hasTrivialDestructor()) {
          return false;
  }

        return true;
      }
    }
    if (!Ty.$arrow().isObjCRetainableType()) {
      return false;
    }
  
    Qualifiers qs = Ty.getQualifiers();
    {
      
      // If we have lifetime, that dominates.
      Qualifiers.ObjCLifetime lifetime = qs.getObjCLifetime();
      if ((lifetime.getValue() != 0)) {
        switch (lifetime) {
         case OCL_None:
          throw new llvm_unreachable("impossible");
         case OCL_ExplicitNone:
         case OCL_Autoreleasing:
          
          // These are just bits as far as the runtime is concerned.
          return false;
         case OCL_Weak:
         case OCL_Strong:
          // ARC __strong __block variables need to be retained.
          return true;
        }
        throw new llvm_unreachable("fell out of lifetime switch!");
      }
    }
    return (Ty.$arrow().isBlockPointerType() || isObjCNSObjectType(new QualType(Ty))
       || Ty.$arrow().isObjCObjectPointerType());
  }

  
  /// Returns true, if given type has a known lifetime. HasByrefExtendedLayout is set
  /// to false in this case. If HasByrefExtendedLayout returns true, byref variable
  /// has extended lifetime. 
  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::getByrefLifetime">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp", line = 5078,
   FQN="clang::ASTContext::getByrefLifetime", NM="_ZNK5clang10ASTContext16getByrefLifetimeENS_8QualTypeERNS_10Qualifiers12ObjCLifetimeERb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZNK5clang10ASTContext16getByrefLifetimeENS_8QualTypeERNS_10Qualifiers12ObjCLifetimeERb")
  //</editor-fold>
  public boolean getByrefLifetime(QualType Ty, 
                  final type$ref<Qualifiers.ObjCLifetime /*&*/> LifeTime, 
                  final bool$ref/*bool &*/ HasByrefExtendedLayout) /*const*/ {
    if (!getLangOpts().ObjC1
       || getLangOpts().getGC() != LangOptions.GCMode.NonGC) {
      return false;
  }

    HasByrefExtendedLayout.$set(false);
    if (Ty.$arrow().isRecordType()) {
      HasByrefExtendedLayout.$set(true);
      LifeTime.$set(Qualifiers.ObjCLifetime.OCL_None);
    } else if (((LifeTime.$set(Ty.getObjCLifetime())).getValue() != 0)) {
      // Honor the ARC qualifiers.
    } else if (Ty.$arrow().isObjCObjectPointerType() || Ty.$arrow().isBlockPointerType()) {
      // The MRR rule.
      LifeTime.$set(Qualifiers.ObjCLifetime.OCL_ExplicitNone);
    } else {
      LifeTime.$set(Qualifiers.ObjCLifetime.OCL_None);
    }
    return true;
  }
  
  
  /// \brief Return the uniqued reference to the type for an lvalue reference
  /// to the specified type.
  
  /// getLValueReferenceType - Return the uniqued reference to the type for an
  /// lvalue reference to the specified type.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::getLValueReferenceType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp", line = 2465,
   FQN="clang::ASTContext::getLValueReferenceType", NM="_ZNK5clang10ASTContext22getLValueReferenceTypeENS_8QualTypeEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZNK5clang10ASTContext22getLValueReferenceTypeENS_8QualTypeEb")
  //</editor-fold>
  public QualType getLValueReferenceType(QualType T) /*const*/ {
    return getLValueReferenceType(T, true);
  }
  public QualType getLValueReferenceType(QualType T, boolean SpelledAsLValue/*= true*/) /*const*/ {
    assert ($noteq_CanQual$T_CanQual$U(getCanonicalType(/*NO_COPY*/T), /*NO_COPY*/OverloadTy)) : "Unresolved overloaded function type";
    
    // Unique pointers, to guarantee there is only one pointer of a particular
    // structure.
    FoldingSetNodeID ID/*J*/= new FoldingSetNodeID();
    ReferenceType.Profile(ID, /*NO_COPY*/T, SpelledAsLValue);
    
    final type$ref<type$ptr<LValueReferenceType /*P*/>/*void P*/ > InsertPos = create_type$null$ref(null);
    {
      LValueReferenceType /*P*/ RT = LValueReferenceTypes.FindNodeOrInsertPos(ID, InsertPos);
      if ((RT != null)) {
        return new QualType(RT, 0);
  }
    }

    /*const*/ ReferenceType /*P*/ InnerRef = T.$arrow().getAs(ReferenceType.class);
  
    // If the referencee type isn't canonical, this won't be a canonical type
    // either, so fill in the canonical type field.
    QualType Canonical/*J*/= new QualType();
    if (!SpelledAsLValue || (InnerRef != null) || !T.isCanonical()) {
      QualType PointeeType = ((InnerRef != null) ? InnerRef.getPointeeType() : new QualType(T));
      Canonical.$assignMove(getLValueReferenceType(getCanonicalType(/*NO_COPY*/PointeeType).$QualType()));
      
      // Get the new insert position for the node we care about.
      LValueReferenceType /*P*/ NewIP = LValueReferenceTypes.FindNodeOrInsertPos(ID, InsertPos);
      assert (!(NewIP != null)) : "Shouldn't be in the map!";
      ///*J:(void)*/NewIP;
    }
    
    LValueReferenceType /*P*/ New = /*NEW_EXPR [operator new] NM=_ZnwjRKN5clang10ASTContextEj*/
    /*new (*this, TypeAlignment)*/ $new_uint_ASTContext$C_uint(/*Deref*/this, TypeAlignment, (type$ptr<?> New$Mem)->{
        return new LValueReferenceType(new QualType(T), new QualType(Canonical), 
                SpelledAsLValue);
     });
    Types.push_back(New);
    LValueReferenceTypes.InsertNode(New, InsertPos.$deref());
    
    return new QualType(New, 0);
  }

  
  /// \brief Return the uniqued reference to the type for an rvalue reference
  /// to the specified type.
  
  /// getRValueReferenceType - Return the uniqued reference to the type for an
  /// rvalue reference to the specified type.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::getRValueReferenceType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp", line = 2506,
   FQN="clang::ASTContext::getRValueReferenceType", NM="_ZNK5clang10ASTContext22getRValueReferenceTypeENS_8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZNK5clang10ASTContext22getRValueReferenceTypeENS_8QualTypeE")
  //</editor-fold>
  public QualType getRValueReferenceType(QualType T) /*const*/ {
    // Unique pointers, to guarantee there is only one pointer of a particular
    // structure.
    FoldingSetNodeID ID/*J*/= new FoldingSetNodeID();
    ReferenceType.Profile(ID, /*NO_COPY*/T, false);
    
    final type$ref<type$ptr<RValueReferenceType /*P*/>/*void P*/ > InsertPos = create_type$null$ref(null);
    {
      RValueReferenceType /*P*/ RT = RValueReferenceTypes.FindNodeOrInsertPos(ID, InsertPos);
      if ((RT != null)) {
        return new QualType(RT, 0);
  }
    }

    /*const*/ ReferenceType /*P*/ InnerRef = T.$arrow().getAs(ReferenceType.class);
  
    // If the referencee type isn't canonical, this won't be a canonical type
    // either, so fill in the canonical type field.
    QualType Canonical/*J*/= new QualType();
    if ((InnerRef != null) || !T.isCanonical()) {
      QualType PointeeType = ((InnerRef != null) ? InnerRef.getPointeeType() : new QualType(T));
      Canonical.$assignMove(getRValueReferenceType(getCanonicalType(/*NO_COPY*/PointeeType).$QualType()));
      
      // Get the new insert position for the node we care about.
      RValueReferenceType /*P*/ NewIP = RValueReferenceTypes.FindNodeOrInsertPos(ID, InsertPos);
      assert (!(NewIP != null)) : "Shouldn't be in the map!";
      ///*J:(void)*/NewIP;
    }
    
    RValueReferenceType /*P*/ New = /*NEW_EXPR [operator new] NM=_ZnwjRKN5clang10ASTContextEj*/
    /*new (*this, TypeAlignment)*/ $new_uint_ASTContext$C_uint(/*Deref*/this, TypeAlignment, (type$ptr<?> New$Mem)->{
        return new RValueReferenceType(new QualType(T), new QualType(Canonical));
     });
    Types.push_back(New);
    RValueReferenceTypes.InsertNode(New, InsertPos.$deref());
    return new QualType(New, 0);
  }

  
  /// \brief Return the uniqued reference to the type for a member pointer to
  /// the specified type in the specified class.
  ///
  /// The class \p Cls is a \c Type because it could be a dependent name.
  
  /// getMemberPointerType - Return the uniqued reference to the type for a
  /// member pointer to the specified type, in the specified class.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::getMemberPointerType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp", line = 2541,
   FQN="clang::ASTContext::getMemberPointerType", NM="_ZNK5clang10ASTContext20getMemberPointerTypeENS_8QualTypeEPKNS_4TypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZNK5clang10ASTContext20getMemberPointerTypeENS_8QualTypeEPKNS_4TypeE")
  //</editor-fold>
  public QualType getMemberPointerType(QualType T, /*const*/ Type /*P*/ Cls) /*const*/ {
    // Unique pointers, to guarantee there is only one pointer of a particular
    // structure.
    FoldingSetNodeID ID/*J*/= new FoldingSetNodeID();
    MemberPointerType.Profile(ID, /*NO_COPY*/T, Cls);
    
    final type$ref<type$ptr<MemberPointerType /*P*/>/*void P*/ > InsertPos = create_type$null$ref(null);
    {
      MemberPointerType /*P*/ PT = MemberPointerTypes.FindNodeOrInsertPos(ID, InsertPos);
      if ((PT != null)) {
        return new QualType(PT, 0);
  }
    }

    // If the pointee or class type isn't canonical, this won't be a canonical
    // type either, so fill in the canonical type field.
    QualType Canonical/*J*/= new QualType();
    if (!T.isCanonical() || !Cls.isCanonicalUnqualified()) {
      Canonical.$assignMove(getMemberPointerType(getCanonicalType(/*NO_COPY*/T).$QualType(), getCanonicalType(Cls)));
  
      // Get the new insert position for the node we care about.
      MemberPointerType /*P*/ NewIP = MemberPointerTypes.FindNodeOrInsertPos(ID, InsertPos);
      assert (!(NewIP != null)) : "Shouldn't be in the map!";
      ///*J:(void)*/NewIP;
    }
    MemberPointerType /*P*/ New = /*NEW_EXPR [operator new] NM=_ZnwjRKN5clang10ASTContextEj*/
    /*new (*this, TypeAlignment)*/ $new_uint_ASTContext$C_uint(/*Deref*/this, TypeAlignment, (type$ptr<?> New$Mem)->{
        return new MemberPointerType(new QualType(T), Cls, new QualType(Canonical));
     });
    Types.push_back(New);
    MemberPointerTypes.InsertNode(New, InsertPos.$deref());
    return new QualType(New, 0);
  }

  
  /// \brief Return a non-unique reference to the type for a variable array of
  /// the specified element type.
  
  /// getVariableArrayType - Returns a non-unique reference to the type for a
  /// variable array of the specified element type.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::getVariableArrayType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp", line = 2751,
   FQN="clang::ASTContext::getVariableArrayType", NM="_ZNK5clang10ASTContext20getVariableArrayTypeENS_8QualTypeEPNS_4ExprENS_9ArrayType17ArraySizeModifierEjNS_11SourceRangeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZNK5clang10ASTContext20getVariableArrayTypeENS_8QualTypeEPNS_4ExprENS_9ArrayType17ArraySizeModifierEjNS_11SourceRangeE")
  //</editor-fold>
  public QualType getVariableArrayType(QualType EltTy, 
                      Expr /*P*/ NumElts, 
                      ArrayType.ArraySizeModifier ASM, 
                      /*uint*/int IndexTypeQuals, 
                      SourceRange Brackets) /*const*/ {
    // Since we don't unique expressions, it isn't possible to unique VLA's
    // that have an expression provided for their size.
    QualType Canon/*J*/= new QualType();
    
    // Be sure to pull qualifiers off the element type.
    if (!EltTy.isCanonical() || EltTy.hasLocalQualifiers()) {
      SplitQualType canonSplit = getCanonicalType(/*NO_COPY*/EltTy).split();
      Canon.$assignMove(getVariableArrayType(new QualType(canonSplit.Ty, 0), NumElts, ASM, 
              IndexTypeQuals, new SourceRange(Brackets)));
      Canon.$assignMove(getQualifiedType(new QualType(Canon), new Qualifiers(canonSplit.Quals)));
  }

    VariableArrayType /*P*/ New = /*NEW_EXPR [operator new] NM=_ZnwjRKN5clang10ASTContextEj*/
    /*new (*this, TypeAlignment)*/ $new_uint_ASTContext$C_uint(/*Deref*/this, TypeAlignment, (type$ptr<?> New$Mem)->{
        return new VariableArrayType(new QualType(EltTy), new QualType(Canon), NumElts, ASM, IndexTypeQuals, new SourceRange(Brackets));
     });
  
    VariableArrayTypes.push_back_T$C$R(New);
    Types.push_back(New);
    return new QualType(New, 0);
  }

  
  /// \brief Return a non-unique reference to the type for a dependently-sized
  /// array of the specified element type.
  ///
  /// FIXME: We will need these to be uniqued, or at least comparable, at some
  /// point.
  
  /// getDependentSizedArrayType - Returns a non-unique reference to
  /// the type for a dependently-sized array of the specified element
  /// type.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::getDependentSizedArrayType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp", line = 2779,
   FQN="clang::ASTContext::getDependentSizedArrayType", NM="_ZNK5clang10ASTContext26getDependentSizedArrayTypeENS_8QualTypeEPNS_4ExprENS_9ArrayType17ArraySizeModifierEjNS_11SourceRangeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZNK5clang10ASTContext26getDependentSizedArrayTypeENS_8QualTypeEPNS_4ExprENS_9ArrayType17ArraySizeModifierEjNS_11SourceRangeE")
  //</editor-fold>
  public QualType getDependentSizedArrayType(QualType elementType, 
                            Expr /*P*/ numElements, 
                            ArrayType.ArraySizeModifier ASM, 
                            /*uint*/int elementTypeQuals, 
                            SourceRange brackets) /*const*/ {
    assert ((!(numElements != null) || numElements.isTypeDependent() || numElements.isValueDependent())) : "Size must be type- or value-dependent!";
    
    // Dependently-sized array types that do not have a specified number
    // of elements will have their sizes deduced from a dependent
    // initializer.  We do no canonicalization here at all, which is okay
    // because they can't be used in most locations.
    if (!(numElements != null)) {
      DependentSizedArrayType /*P*/ newType = /*NEW_EXPR [operator new] NM=_ZnwjRKN5clang10ASTContextEj*/
      /*new (*this, TypeAlignment)*/ $new_uint_ASTContext$C_uint(/*Deref*/this, TypeAlignment, (type$ptr<?> New$Mem)->{
          return new DependentSizedArrayType(/*Deref*/this, new QualType(elementType), new QualType(), 
                  numElements, ASM, elementTypeQuals, 
                  new SourceRange(brackets));
       });
      Types.push_back(newType);
      return new QualType(newType, 0);
  }

    // Otherwise, we actually build a new type every time, but we
    // also build a canonical type.
    SplitQualType canonElementType = getCanonicalType(/*NO_COPY*/elementType).split();
  
    final type$ref<type$ptr<DependentSizedArrayType /*P*/>/*void P*/ > insertPos = create_type$null$ref(null);
    FoldingSetNodeID ID/*J*/= new FoldingSetNodeID();
    DependentSizedArrayType.Profile(ID, /*Deref*/this, 
        new QualType(canonElementType.Ty, 0), 
        ASM, elementTypeQuals, numElements);
    
    // Look for an existing type with these properties.
    DependentSizedArrayType /*P*/ canonTy = DependentSizedArrayTypes.FindNodeOrInsertPos(ID, insertPos);
    
    // If we don't have one, build one.
    if (!(canonTy != null)) {
      canonTy = /*NEW_EXPR [operator new] NM=_ZnwjRKN5clang10ASTContextEj*/
      /*new (*this, TypeAlignment)*/ $new_uint_ASTContext$C_uint(/*Deref*/this, TypeAlignment, (type$ptr<?> New$Mem)->{
          return new DependentSizedArrayType(/*Deref*/this, new QualType(canonElementType.Ty, 0), 
                  new QualType(), numElements, ASM, elementTypeQuals, 
                  new SourceRange(brackets));
       });
      DependentSizedArrayTypes.InsertNode(canonTy, insertPos.$deref());
      Types.push_back(canonTy);
    }
    
    // Apply qualifiers from the element type to the array.
    QualType canon = getQualifiedType(new QualType(canonTy, 0), 
        new Qualifiers(canonElementType.Quals));
    
    // If we didn't need extra canonicalization for the element type or the size
    // expression, then just use that as our result.
    if ($eq_QualType$C(new QualType(canonElementType.Ty, 0), elementType)
       && canonTy.getSizeExpr() == numElements) {
      return canon;
    }
    
    // Otherwise, we need to build a type which follows the spelling
    // of the element type.
    DependentSizedArrayType /*P*/ sugaredType = /*NEW_EXPR [operator new] NM=_ZnwjRKN5clang10ASTContextEj*/
    /*new (*this, TypeAlignment)*/ $new_uint_ASTContext$C_uint(/*Deref*/this, TypeAlignment, (type$ptr<?> New$Mem)->{
        return new DependentSizedArrayType(/*Deref*/this, new QualType(elementType), new QualType(canon), numElements, 
                ASM, elementTypeQuals, new SourceRange(brackets));
     });
    Types.push_back(sugaredType);
    return new QualType(sugaredType, 0);
  }

  
  /// \brief Return a unique reference to the type for an incomplete array of
  /// the specified element type.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::getIncompleteArrayType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp", line = 2847,
   FQN="clang::ASTContext::getIncompleteArrayType", NM="_ZNK5clang10ASTContext22getIncompleteArrayTypeENS_8QualTypeENS_9ArrayType17ArraySizeModifierEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZNK5clang10ASTContext22getIncompleteArrayTypeENS_8QualTypeENS_9ArrayType17ArraySizeModifierEj")
  //</editor-fold>
  public QualType getIncompleteArrayType(QualType elementType, 
                        ArrayType.ArraySizeModifier ASM, 
                        /*uint*/int elementTypeQuals) /*const*/ {
    FoldingSetNodeID ID/*J*/= new FoldingSetNodeID();
    IncompleteArrayType.Profile(ID, /*NO_COPY*/elementType, ASM, elementTypeQuals);
    
    final type$ref<type$ptr<IncompleteArrayType /*P*/>/*void P*/ > insertPos = create_type$null$ref(null);
    {
      IncompleteArrayType /*P*/ iat = IncompleteArrayTypes.FindNodeOrInsertPos(ID, insertPos);
      if ((iat != null)) {
        return new QualType(iat, 0);
  }
    }

    // If the element type isn't canonical, this won't be a canonical type
    // either, so fill in the canonical type field.  We also have to pull
    // qualifiers off the element type.
    QualType canon/*J*/= new QualType();
    if (!elementType.isCanonical() || elementType.hasLocalQualifiers()) {
      SplitQualType canonSplit = getCanonicalType(/*NO_COPY*/elementType).split();
      canon.$assignMove(getIncompleteArrayType(new QualType(canonSplit.Ty, 0), 
              ASM, elementTypeQuals));
      canon.$assignMove(getQualifiedType(new QualType(canon), new Qualifiers(canonSplit.Quals)));
  
      // Get the new insert position for the node we care about.
      IncompleteArrayType /*P*/ existing = IncompleteArrayTypes.FindNodeOrInsertPos(ID, insertPos);
      assert (!(existing != null)) : "Shouldn't be in the map!";
      ///*J:(void)*/existing;
    }
    
    IncompleteArrayType /*P*/ newType = /*NEW_EXPR [operator new] NM=_ZnwjRKN5clang10ASTContextEj*/
    /*new (*this, TypeAlignment)*/ $new_uint_ASTContext$C_uint(/*Deref*/this, TypeAlignment, (type$ptr<?> New$Mem)->{
        return new IncompleteArrayType(new QualType(elementType), new QualType(canon), ASM, elementTypeQuals);
     });
    
    IncompleteArrayTypes.InsertNode(newType, insertPos.$deref());
    Types.push_back(newType);
    return new QualType(newType, 0);
  }

  
  /// \brief Return the unique reference to the type for a constant array of
  /// the specified element type.
  
  /// getConstantArrayType - Return the unique reference to the type for an
  /// array of the specified element type.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::getConstantArrayType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp", line = 2572,
   FQN="clang::ASTContext::getConstantArrayType", NM="_ZNK5clang10ASTContext20getConstantArrayTypeENS_8QualTypeERKN4llvm5APIntENS_9ArrayType17ArraySizeModifierEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZNK5clang10ASTContext20getConstantArrayTypeENS_8QualTypeERKN4llvm5APIntENS_9ArrayType17ArraySizeModifierEj")
  //</editor-fold>
  public QualType getConstantArrayType(QualType EltTy, 
                      final /*const*/ APInt /*&*/ ArySizeIn, 
                      ArrayType.ArraySizeModifier ASM, 
                      /*uint*/int IndexTypeQuals) /*const*/ {
    assert ((EltTy.$arrow().isDependentType() || EltTy.$arrow().isIncompleteType() || EltTy.$arrow().isConstantSizeType())) : "Constant array of VLAs is illegal!";
    
    // Convert the array size into a canonical width matching the pointer size for
    // the target.
    APInt ArySize/*J*/= new APInt(ArySizeIn);
    ArySize.$assignMove(
        ArySize.zextOrTrunc($ulong2uint(Target.getPointerWidth(getTargetAddressSpace(new QualType(EltTy)))))
    );
    
    FoldingSetNodeID ID/*J*/= new FoldingSetNodeID();
    ConstantArrayType.Profile(ID, /*NO_COPY*/EltTy, ArySize, ASM, IndexTypeQuals);
    
    final type$ref<type$ptr<ConstantArrayType /*P*/>/*void P*/ > InsertPos = create_type$null$ref(null);
    {
      ConstantArrayType /*P*/ ATP = ConstantArrayTypes.FindNodeOrInsertPos(ID, InsertPos);
      if ((ATP != null)) {
        return new QualType(ATP, 0);
      }
    }
    
    // If the element type isn't canonical or has qualifiers, this won't
    // be a canonical type either, so fill in the canonical type field.
    QualType Canon/*J*/= new QualType();
    if (!EltTy.isCanonical() || EltTy.hasLocalQualifiers()) {
      SplitQualType canonSplit = getCanonicalType(/*NO_COPY*/EltTy).split();
      Canon.$assignMove(getConstantArrayType(new QualType(canonSplit.Ty, 0), ArySize, 
              ASM, IndexTypeQuals));
      Canon.$assignMove(getQualifiedType(new QualType(Canon), new Qualifiers(canonSplit.Quals)));
      
      // Get the new insert position for the node we care about.
      ConstantArrayType /*P*/ NewIP = ConstantArrayTypes.FindNodeOrInsertPos(ID, InsertPos);
      assert (!(NewIP != null)) : "Shouldn't be in the map!";
      ///*J:(void)*/NewIP;
    }
    
    ConstantArrayType /*P*/ New = /*NEW_EXPR [operator new] NM=_ZnwjRKN5clang10ASTContextEj*/
    /*new (*this, TypeAlignment)*/ $new_uint_ASTContext$C_uint(/*Deref*/this, TypeAlignment, (type$ptr<?> New$Mem)->{
        return new ConstantArrayType(new QualType(EltTy), new QualType(Canon), ArySize, ASM, IndexTypeQuals);
     });
    ConstantArrayTypes.InsertNode(New, InsertPos.$deref());
    Types.push_back(New);
    return new QualType(New, 0);
  }

  
  /// \brief Returns a vla type where known sizes are replaced with [*].
  
  /// getVariableArrayDecayedType - Turns the given type, which may be
  /// variably-modified, into the corresponding type with all the known
  /// sizes replaced with [*].
  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::getVariableArrayDecayedType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp", line = 2619,
   FQN="clang::ASTContext::getVariableArrayDecayedType", NM="_ZNK5clang10ASTContext27getVariableArrayDecayedTypeENS_8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZNK5clang10ASTContext27getVariableArrayDecayedTypeENS_8QualTypeE")
  //</editor-fold>
  public QualType getVariableArrayDecayedType(QualType type) /*const*/ {
    // Vastly most common case.
    if (!type.$arrow().isVariablyModifiedType()) {
      return new QualType(JD$Move.INSTANCE, type);
  }

    QualType result/*J*/= new QualType();
  
    SplitQualType split = type.getSplitDesugaredType();
    /*const*/ Type /*P*/ ty = split.Ty;
    switch (ty.getTypeClass()) {
     case Paren:
     case Typedef:
     case Adjusted:
     case Decayed:
     case Elaborated:
     case Attributed:
     case SubstTemplateTypeParm:
      throw new llvm_unreachable("didn't desugar past all non-canonical types?");
     case Builtin:
     case Complex:
     case Vector:
     case ExtVector:
     case DependentSizedExtVector:
     case ObjCObject:
     case ObjCInterface:
     case ObjCObjectPointer:
     case Record:
     case Enum:
     case UnresolvedUsing:
     case TypeOfExpr:
     case TypeOf:
     case Decltype:
     case UnaryTransform:
     case DependentName:
     case InjectedClassName:
     case TemplateSpecialization:
     case DependentTemplateSpecialization:
     case TemplateTypeParm:
     case SubstTemplateTypeParmPack:
     case Auto:
     case PackExpansion:
      
      // These types should never be variably-modified.
      throw new llvm_unreachable("type should never be variably-modified");
     case FunctionNoProto:
     case FunctionProto:
     case BlockPointer:
     case MemberPointer:
     case Pipe:
      
      // These types can be variably-modified but should never need to
      // further decay.
      return new QualType(JD$Move.INSTANCE, type);
     case Pointer:
      
      // These types can be variably-modified.  All these modifications
      // preserve structure except as noted by comments.
      // TODO: if we ever care about optimizing VLAs, there are no-op
      // optimizations available here.
      result.$assignMove(getPointerType(getVariableArrayDecayedType(cast_PointerType(ty).getPointeeType())));
      break;
     case LValueReference:
      {
        /*const*/ LValueReferenceType /*P*/ lv = cast_LValueReferenceType(ty);
        result.$assignMove(getLValueReferenceType(getVariableArrayDecayedType(lv.getPointeeType()), 
                lv.isSpelledAsLValue()));
        break;
      }
     case RValueReference:
      {
        /*const*/ RValueReferenceType /*P*/ lv = cast_RValueReferenceType(ty);
        result.$assignMove(getRValueReferenceType(getVariableArrayDecayedType(lv.getPointeeType())));
        break;
      }
     case Atomic:
      {
        /*const*/ AtomicType /*P*/ at = cast_AtomicType(ty);
        result.$assignMove(getAtomicType(getVariableArrayDecayedType(at.getValueType())));
        break;
      }
     case ConstantArray:
      {
        /*const*/ ConstantArrayType /*P*/ cat = cast_ConstantArrayType(ty);
        result.$assignMove(getConstantArrayType(getVariableArrayDecayedType(cat.getElementType()), 
                cat.getSize(), 
                cat.getSizeModifier(), 
                cat.getIndexTypeCVRQualifiers()));
        break;
      }
     case DependentSizedArray:
      {
        /*const*/ DependentSizedArrayType /*P*/ dat = cast_DependentSizedArrayType(ty);
        result.$assignMove(getDependentSizedArrayType(getVariableArrayDecayedType(dat.getElementType()), 
                dat.getSizeExpr(), 
                dat.getSizeModifier(), 
                dat.getIndexTypeCVRQualifiers(), 
                dat.getBracketsRange()));
        break;
      }
     case IncompleteArray:
      {
        /*const*/ IncompleteArrayType /*P*/ iat = cast_IncompleteArrayType(ty);
        result.$assignMove(getVariableArrayType(getVariableArrayDecayedType(iat.getElementType()), 
                /*size*/ (Expr /*P*/ )null, 
                ArrayType.ArraySizeModifier.Normal, 
                iat.getIndexTypeCVRQualifiers(), 
                new SourceRange()));
        break;
      }
     case VariableArray:
      {
        /*const*/ VariableArrayType /*P*/ vat = cast_VariableArrayType(ty);
        result.$assignMove(getVariableArrayType(getVariableArrayDecayedType(vat.getElementType()), 
                /*size*/ (Expr /*P*/ )null, 
                ArrayType.ArraySizeModifier.Star, 
                vat.getIndexTypeCVRQualifiers(), 
                vat.getBracketsRange()));
        break;
      }
    }
    
    // Apply the top-level qualifiers from the original.
    return getQualifiedType(new QualType(result), new Qualifiers(split.Quals));
  }

  
  /// \brief Return the unique reference to a vector type of the specified
  /// element type and size.
  ///
  /// \pre \p VectorType must be a built-in type.
  
  /// getVectorType - Return the unique reference to a vector type of
  /// the specified element type and size. VectorType must be a built-in type.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::getVectorType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp", line = 2885,
   FQN="clang::ASTContext::getVectorType", NM="_ZNK5clang10ASTContext13getVectorTypeENS_8QualTypeEjNS_10VectorType10VectorKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZNK5clang10ASTContext13getVectorTypeENS_8QualTypeEjNS_10VectorType10VectorKindE")
  //</editor-fold>
  public QualType getVectorType(QualType vecType, /*uint*/int NumElts, 
               VectorType.VectorKind VecKind) /*const*/ {
    assert (vecType.$arrow().isBuiltinType());
    
    // Check if we've already instantiated a vector of this type.
    FoldingSetNodeID ID/*J*/= new FoldingSetNodeID();
    VectorType.Profile(ID, /*NO_COPY*/vecType, NumElts, Type.TypeClass.Vector, VecKind);
    
    final type$ref<type$ptr<VectorType /*P*/>/*void P*/ > InsertPos = create_type$null$ref(null);
    {
      VectorType /*P*/ VTP = VectorTypes.FindNodeOrInsertPos(ID, InsertPos);
      if ((VTP != null)) {
        return new QualType(VTP, 0);
  }
    }

    // If the element type isn't canonical, this won't be a canonical type either,
    // so fill in the canonical type field.
    QualType Canonical/*J*/= new QualType();
    if (!vecType.isCanonical()) {
      Canonical.$assignMove(getVectorType(getCanonicalType(/*NO_COPY*/vecType).$QualType(), NumElts, VecKind));
  
      // Get the new insert position for the node we care about.
      VectorType /*P*/ NewIP = VectorTypes.FindNodeOrInsertPos(ID, InsertPos);
      assert (!(NewIP != null)) : "Shouldn't be in the map!";
      ///*J:(void)*/NewIP;
    }
    VectorType /*P*/ New = /*NEW_EXPR [operator new] NM=_ZnwjRKN5clang10ASTContextEj*/
    /*new (*this, TypeAlignment)*/ $new_uint_ASTContext$C_uint(/*Deref*/this, TypeAlignment, (type$ptr<?> New$Mem)->{
        return new VectorType(new QualType(vecType), NumElts, new QualType(Canonical), VecKind);
     });
    VectorTypes.InsertNode(New, InsertPos.$deref());
    Types.push_back(New);
    return new QualType(New, 0);
  }

  
  /// \brief Return the unique reference to an extended vector type
  /// of the specified element type and size.
  ///
  /// \pre \p VectorType must be a built-in type.
  
  /// getExtVectorType - Return the unique reference to an extended vector type of
  /// the specified element type and size. VectorType must be a built-in type.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::getExtVectorType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp", line = 2916,
   FQN="clang::ASTContext::getExtVectorType", NM="_ZNK5clang10ASTContext16getExtVectorTypeENS_8QualTypeEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZNK5clang10ASTContext16getExtVectorTypeENS_8QualTypeEj")
  //</editor-fold>
  public QualType getExtVectorType(QualType vecType, /*uint*/int NumElts) /*const*/ {
    assert (vecType.$arrow().isBuiltinType() || vecType.$arrow().isDependentType());
    
    // Check if we've already instantiated a vector of this type.
    FoldingSetNodeID ID/*J*/= new FoldingSetNodeID();
    VectorType.Profile(ID, /*NO_COPY*/vecType, NumElts, Type.TypeClass.ExtVector, 
        VectorType.VectorKind.GenericVector);
    final type$ref<type$ptr<VectorType /*P*/>/*void P*/ > InsertPos = create_type$null$ref(null);
    {
      VectorType /*P*/ VTP = VectorTypes.FindNodeOrInsertPos(ID, InsertPos);
      if ((VTP != null)) {
        return new QualType(VTP, 0);
  }
    }

    // If the element type isn't canonical, this won't be a canonical type either,
    // so fill in the canonical type field.
    QualType Canonical/*J*/= new QualType();
    if (!vecType.isCanonical()) {
      Canonical.$assignMove(getExtVectorType(getCanonicalType(/*NO_COPY*/vecType).$QualType(), NumElts));
  
      // Get the new insert position for the node we care about.
      VectorType /*P*/ NewIP = VectorTypes.FindNodeOrInsertPos(ID, InsertPos);
      assert (!(NewIP != null)) : "Shouldn't be in the map!";
      ///*J:(void)*/NewIP;
    }
    ExtVectorType /*P*/ New = /*NEW_EXPR [operator new] NM=_ZnwjRKN5clang10ASTContextEj*/
    /*new (*this, TypeAlignment)*/ $new_uint_ASTContext$C_uint(/*Deref*/this, TypeAlignment, (type$ptr<?> New$Mem)->{
        return new ExtVectorType(new QualType(vecType), NumElts, new QualType(Canonical));
     });
    VectorTypes.InsertNode(New, InsertPos.$deref());
    Types.push_back(New);
    return new QualType(New, 0);
  }

  
  /// \pre Return a non-unique reference to the type for a dependently-sized
  /// vector of the specified element type.
  ///
  /// FIXME: We will need these to be uniqued, or at least comparable, at some
  /// point.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::getDependentSizedExtVectorType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp", line = 2945,
   FQN="clang::ASTContext::getDependentSizedExtVectorType", NM="_ZNK5clang10ASTContext30getDependentSizedExtVectorTypeENS_8QualTypeEPNS_4ExprENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZNK5clang10ASTContext30getDependentSizedExtVectorTypeENS_8QualTypeEPNS_4ExprENS_14SourceLocationE")
  //</editor-fold>
  public QualType getDependentSizedExtVectorType(QualType vecType, 
                                Expr /*P*/ SizeExpr, 
                                SourceLocation AttrLoc) /*const*/ {
    FoldingSetNodeID ID/*J*/= new FoldingSetNodeID();
    DependentSizedExtVectorType.Profile(ID, /*Deref*/this, getCanonicalType(/*NO_COPY*/vecType).$QualType(), 
        SizeExpr);
    
    final type$ref<type$ptr<DependentSizedExtVectorType /*P*/>/*void P*/ > InsertPos = create_type$null$ref(null);
    DependentSizedExtVectorType /*P*/ Canon = DependentSizedExtVectorTypes.FindNodeOrInsertPos(ID, InsertPos);
    DependentSizedExtVectorType /*P*/ New;
    if ((Canon != null)) {
      // We already have a canonical version of this array type; use it as
      // the canonical type for a newly-built type.
      New = /*NEW_EXPR [operator new] NM=_ZnwjRKN5clang10ASTContextEj*/
      /*new (*this, TypeAlignment)*/ $new_uint_ASTContext$C_uint(/*Deref*/this, TypeAlignment, (type$ptr<?> New$Mem)->{
          return new DependentSizedExtVectorType(/*Deref*/this, new QualType(vecType), new QualType(Canon, 0), 
                  SizeExpr, new SourceLocation(AttrLoc));
       });
    } else {
      QualType CanonVecTy = getCanonicalType(/*NO_COPY*/vecType).$QualType();
      if ($eq_QualType$C(CanonVecTy, vecType)) {
        New = /*NEW_EXPR [operator new] NM=_ZnwjRKN5clang10ASTContextEj*/
        /*new (*this, TypeAlignment)*/ $new_uint_ASTContext$C_uint(/*Deref*/this, TypeAlignment, (type$ptr<?> New$Mem)->{
            return new DependentSizedExtVectorType(/*Deref*/this, new QualType(vecType), new QualType(), SizeExpr, 
                    new SourceLocation(AttrLoc));
         });
        
        DependentSizedExtVectorType /*P*/ CanonCheck = DependentSizedExtVectorTypes.FindNodeOrInsertPos(ID, InsertPos);
        assert (!(CanonCheck != null)) : "Dependent-sized ext_vector canonical type broken";
        ///*J:(void)*/CanonCheck;
        DependentSizedExtVectorTypes.InsertNode(New, InsertPos.$deref());
      } else {
        QualType Canon$1 = getDependentSizedExtVectorType(new QualType(CanonVecTy), SizeExpr, 
            new SourceLocation());
        New = /*NEW_EXPR [operator new] NM=_ZnwjRKN5clang10ASTContextEj*/
        /*new (*this, TypeAlignment)*/ $new_uint_ASTContext$C_uint(/*Deref*/this, TypeAlignment, (type$ptr<?> New$Mem)->{
            return new DependentSizedExtVectorType(/*Deref*/this, new QualType(vecType), new QualType(Canon$1), SizeExpr, new SourceLocation(AttrLoc));
         });
  }
    }

    Types.push_back(New);
    return new QualType(New, 0);
  }
  
  
  /// \brief Return a K&R style C function type like 'int()'.
  
  /// getFunctionNoProtoType - Return a K&R style C function type like 'int()'.
  ///
  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::getFunctionNoProtoType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp", line = 2996,
   FQN="clang::ASTContext::getFunctionNoProtoType", NM="_ZNK5clang10ASTContext22getFunctionNoProtoTypeENS_8QualTypeERKNS_12FunctionType7ExtInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZNK5clang10ASTContext22getFunctionNoProtoTypeENS_8QualTypeERKNS_12FunctionType7ExtInfoE")
  //</editor-fold>
  public QualType getFunctionNoProtoType(QualType ResultTy, 
                        final /*const*/ FunctionType.ExtInfo /*&*/ Info) /*const*/ {
    // Unique functions, to guarantee there is only one function of a particular
    // structure.
    FoldingSetNodeID ID/*J*/= new FoldingSetNodeID();
    FunctionNoProtoType.Profile(ID, /*NO_COPY*/ResultTy, /*NO_COPY*/Info);
    
    final type$ref<type$ptr<FunctionNoProtoType /*P*/>/*void P*/ > InsertPos = create_type$null$ref(null);
    {
      FunctionNoProtoType /*P*/ FT = FunctionNoProtoTypes.FindNodeOrInsertPos(ID, InsertPos);
      if ((FT != null)) {
        return new QualType(FT, 0);
  }
    }

    QualType Canonical/*J*/= new QualType();
    if (!isCanonicalResultType(new QualType(ResultTy))) {
      Canonical.$assignMove(
          getFunctionNoProtoType(getCanonicalFunctionResultType(new QualType(ResultTy)).$QualType(), Info)
      );
  
      // Get the new insert position for the node we care about.
      FunctionNoProtoType /*P*/ NewIP = FunctionNoProtoTypes.FindNodeOrInsertPos(ID, InsertPos);
      assert (!(NewIP != null)) : "Shouldn't be in the map!";
      ///*J:(void)*/NewIP;
    }
    
    FunctionNoProtoType /*P*/ New = /*NEW_EXPR [operator new] NM=_ZnwjRKN5clang10ASTContextEj*/
    /*new (*this, TypeAlignment)*/ $new_uint_ASTContext$C_uint(/*Deref*/this, TypeAlignment, (type$ptr<?> New$Mem)->{
        return new FunctionNoProtoType(new QualType(ResultTy), new QualType(Canonical), new FunctionType.ExtInfo(Info));
     });
    Types.push_back(New);
    FunctionNoProtoTypes.InsertNode(New, InsertPos.$deref());
    return new QualType(New, 0);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::getFunctionNoProtoType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ASTContext.h", line = 1189,
   FQN="clang::ASTContext::getFunctionNoProtoType", NM="_ZNK5clang10ASTContext22getFunctionNoProtoTypeENS_8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZNK5clang10ASTContext22getFunctionNoProtoTypeENS_8QualTypeE")
  //</editor-fold>
  public QualType getFunctionNoProtoType(QualType ResultTy) /*const*/ {
    return getFunctionNoProtoType(new QualType(ResultTy), new FunctionType.ExtInfo());
  }

  
  /// \brief Return a normal function type with a typed argument list.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::getFunctionType">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*allocate*/,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp", line = 3042,
   FQN="clang::ASTContext::getFunctionType", NM="_ZNK5clang10ASTContext15getFunctionTypeENS_8QualTypeEN4llvm8ArrayRefIS1_EERKNS_17FunctionProtoType12ExtProtoInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZNK5clang10ASTContext15getFunctionTypeENS_8QualTypeEN4llvm8ArrayRefIS1_EERKNS_17FunctionProtoType12ExtProtoInfoE")
  //</editor-fold>
  public QualType getFunctionType(QualType ResultTy, ArrayRef<QualType> ArgArray, 
                 final /*const*/ FunctionProtoType.ExtProtoInfo /*&*/ EPI) /*const*/ {
    /*size_t*/int NumArgs = ArgArray.size();
    
    // Unique functions, to guarantee there is only one function of a particular
    // structure.
    FoldingSetNodeID ID/*J*/= new FoldingSetNodeID();
    FunctionProtoType.Profile(ID, /*NO_COPY*/ResultTy, ArgArray.begin(), NumArgs, EPI, 
        /*Deref*/this);
    
    final type$ref<type$ptr<FunctionProtoType /*P*/>/*void P*/ > InsertPos = create_type$null$ref(null);
    {
      FunctionProtoType /*P*/ FTP = FunctionProtoTypes.FindNodeOrInsertPos(ID, InsertPos);
      if ((FTP != null)) {
        return new QualType(FTP, 0);
      }
    }

    // Determine whether the type being created is already canonical or not.
    boolean isCanonical = EPI.ExceptionSpec.Type == ExceptionSpecificationType.EST_None && isCanonicalResultType(new QualType(ResultTy))
       && !EPI.HasTrailingReturn;
    for (/*uint*/int i = 0; i != NumArgs && isCanonical; ++i)  {
      if (!ArgArray.$at(i).isCanonicalAsParam()) {
        isCanonical = false;
      }
    }
  
    // If this type isn't canonical, get the canonical version of it.
    // The exception spec is not part of the canonical type.
    QualType Canonical/*J*/= new QualType();
    if (!isCanonical) {
      SmallVector<QualType> CanonicalArgs/*J*/= new SmallVector<QualType>(16, new QualType());
      CanonicalArgs.reserve(NumArgs);
      for (/*uint*/int i = 0; i != NumArgs; ++i)  {
        CanonicalArgs.push_back(getCanonicalParamType(new QualType(ArgArray.$at(i))).$QualType());
      }
      
      FunctionProtoType.ExtProtoInfo CanonicalEPI = new FunctionProtoType.ExtProtoInfo(EPI);
      CanonicalEPI.HasTrailingReturn = false;
      CanonicalEPI.ExceptionSpec.$assignMove(new FunctionProtoType.ExceptionSpecInfo());
      
      // Adjust the canonical function result type.
      CanQual<Type> CanResultTy = getCanonicalFunctionResultType(new QualType(ResultTy));
      Canonical.$assignMove(getFunctionType(CanResultTy.$QualType(), new ArrayRef<QualType>(CanonicalArgs, false), CanonicalEPI));
      
      // Get the new insert position for the node we care about.
      FunctionProtoType /*P*/ NewIP = FunctionProtoTypes.FindNodeOrInsertPos(ID, InsertPos);
      assert (!(NewIP != null)) : "Shouldn't be in the map!";
      ///*J:(void)*/NewIP;
    }
    
    // FunctionProtoType objects are allocated with extra bytes after
    // them for three variable size arrays at the end:
    //  - parameter types
    //  - exception types
    //  - extended parameter information
    // Instead of the exception types, there could be a noexcept
    // expression, or information used to resolve the exception
    // specification.
    /*size_t*/int Size = (true/*JAVA*/ ? 1 : $sizeof_FunctionProtoType())
       + NumArgs * (true/*JAVA*/ ? 1 : $sizeof_QualType());
    if (EPI.ExceptionSpec.Type == ExceptionSpecificationType.EST_Dynamic) {
      Size += EPI.ExceptionSpec.Exceptions.size() * (true/*JAVA*/ ? 1 : $sizeof_QualType());
    } else if (EPI.ExceptionSpec.Type == ExceptionSpecificationType.EST_ComputedNoexcept) {
      Size += (true/*JAVA*/ ? 1 : $sizeof_ptr(/*Expr  */));
    } else if (EPI.ExceptionSpec.Type == ExceptionSpecificationType.EST_Uninstantiated) {
      Size += 2 * (true/*JAVA*/ ? 1 : $sizeof_ptr(/*FunctionDecl  */));
    } else if (EPI.ExceptionSpec.Type == ExceptionSpecificationType.EST_Unevaluated) {
      Size += (true/*JAVA*/ ? 1 : $sizeof_ptr(/*FunctionDecl  */));
    }
    
    // Put the ExtParameterInfos last.  If all were equal, it would make
    // more sense to put these before the exception specification, because
    // it's much easier to skip past them compared to the elaborate switch
    // required to skip the exception specification.  However, all is not
    // equal; ExtParameterInfos are used to model very uncommon features,
    // and it's better not to burden the more common paths.
    if ((EPI.ExtParameterInfos != null)) {
      Size += NumArgs * (true/*JAVA*/ ? 1 : $sizeof_ExtParameterInfo());
    }
    
    type$ptr<?> /*P*/ FTP$Mem = /*(FunctionProtoType P )*/Allocate$JavaRef(Size, (true/*JAVA*/ ? 1 : TypeAlignment));
    FunctionProtoType.ExtProtoInfo newEPI = new FunctionProtoType.ExtProtoInfo(EPI);
    FunctionProtoType /*NEW_EXPR [System]*/FTP = /*new (FTP)*/ $new_uint_voidPtr(FTP$Mem, (type$ptr<?> New$Mem)->{
        return new FunctionProtoType(New$Mem.$add(1), new QualType(ResultTy), new ArrayRef<QualType>(ArgArray), new QualType(Canonical), newEPI);
     });
    Types.push_back(FTP);
    FunctionProtoTypes.InsertNode(FTP, InsertPos.$deref());
    return new QualType(FTP, 0);
  }

  
  /// \brief Return the unique reference to the type for the specified type
  /// declaration.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::getTypeDeclType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ASTContext.h", line = 1199,
   FQN="clang::ASTContext::getTypeDeclType", NM="_ZNK5clang10ASTContext15getTypeDeclTypeEPKNS_8TypeDeclES3_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZNK5clang10ASTContext15getTypeDeclTypeEPKNS_8TypeDeclES3_")
  //</editor-fold>
  public QualType getTypeDeclType(/*const*/ TypeDecl /*P*/ Decl) /*const*/ {
    return getTypeDeclType(Decl, 
                 (/*const*/ TypeDecl /*P*/ )null);
  }
  public QualType getTypeDeclType(/*const*/ TypeDecl /*P*/ Decl, 
                 /*const*/ TypeDecl /*P*/ PrevDecl/*= null*/) /*const*/ {
    assert ((Decl != null)) : "Passed null for Decl param";
    if ((Decl.TypeForDecl != null)) {
      return new QualType(Decl.TypeForDecl, 0);
    }
    if ((PrevDecl != null)) {
      assert ((PrevDecl.TypeForDecl != null)) : "previous decl has no TypeForDecl";
      Decl.TypeForDecl = PrevDecl.TypeForDecl;
      return new QualType(PrevDecl.TypeForDecl, 0);
    }
    
    return getTypeDeclTypeSlow(Decl);
  }

  
  /// \brief Return the unique reference to the type for the specified
  /// typedef-name decl.
  
  /// getTypedefType - Return the unique reference to the type for the
  /// specified typedef name decl.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::getTypedefType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp", line = 3219,
   FQN="clang::ASTContext::getTypedefType", NM="_ZNK5clang10ASTContext14getTypedefTypeEPKNS_15TypedefNameDeclENS_8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZNK5clang10ASTContext14getTypedefTypeEPKNS_15TypedefNameDeclENS_8QualTypeE")
  //</editor-fold>
  public QualType getTypedefType(/*const*/ TypedefNameDecl /*P*/ Decl) /*const*/ {
    return getTypedefType(Decl, 
                new QualType());
  }
  public QualType getTypedefType(/*const*/ TypedefNameDecl /*P*/ Decl, 
                QualType Canonical/*= QualType()*/) /*const*/ {
    if ((Decl.TypeForDecl != null)) {
      return new QualType(Decl.TypeForDecl, 0);
    }
    if (Canonical.isNull()) {
      Canonical.$assignMove(getCanonicalType(Decl.getUnderlyingType()).$QualType());
    }
    TypedefType /*P*/ newType = /*NEW_EXPR [operator new] NM=_ZnwjRKN5clang10ASTContextEj*/
    /*new (*this, TypeAlignment)*/ $new_uint_ASTContext$C_uint(/*Deref*/this, TypeAlignment, (type$ptr<?> New$Mem)->{
        return new TypedefType(Type.TypeClass.Typedef, Decl, new QualType(Canonical));
     });
    Decl.TypeForDecl = newType;
    Types.push_back(newType);
    return new QualType(newType, 0);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::getRecordType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp", line = 3233,
   FQN="clang::ASTContext::getRecordType", NM="_ZNK5clang10ASTContext13getRecordTypeEPKNS_10RecordDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZNK5clang10ASTContext13getRecordTypeEPKNS_10RecordDeclE")
  //</editor-fold>
  public QualType getRecordType(/*const*/ RecordDecl /*P*/ Decl) /*const*/ {
    if ((Decl.TypeForDecl != null)) {
      return new QualType(Decl.TypeForDecl, 0);
    }
    {
      
      /*const*/ RecordDecl /*P*/ PrevDecl = Decl.getPreviousDecl$Const();
      if ((PrevDecl != null)) {
        if ((PrevDecl.TypeForDecl != null)) {
          return new QualType(Decl.TypeForDecl = PrevDecl.TypeForDecl, 0);
        }
      }
    }
    
    RecordType /*P*/ newType = /*NEW_EXPR [operator new] NM=_ZnwjRKN5clang10ASTContextEj*/
    /*new (*this, TypeAlignment)*/ $new_uint_ASTContext$C_uint(/*Deref*/this, TypeAlignment, (type$ptr<?> New$Mem)->{
        return new RecordType(Decl);
     });
    Decl.TypeForDecl = newType;
    Types.push_back(newType);
    return new QualType(newType, 0);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::getEnumType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp", line = 3246,
   FQN="clang::ASTContext::getEnumType", NM="_ZNK5clang10ASTContext11getEnumTypeEPKNS_8EnumDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZNK5clang10ASTContext11getEnumTypeEPKNS_8EnumDeclE")
  //</editor-fold>
  public QualType getEnumType(/*const*/ EnumDecl /*P*/ Decl) /*const*/ {
    if ((Decl.TypeForDecl != null)) {
      return new QualType(Decl.TypeForDecl, 0);
    }
    {
      
      /*const*/ EnumDecl /*P*/ PrevDecl = Decl.getPreviousDecl$Const();
      if ((PrevDecl != null)) {
        if ((PrevDecl.TypeForDecl != null)) {
          return new QualType(Decl.TypeForDecl = PrevDecl.TypeForDecl, 0);
        }
      }
    }
    
    EnumType /*P*/ newType = /*NEW_EXPR [operator new] NM=_ZnwjRKN5clang10ASTContextEj*/
    /*new (*this, TypeAlignment)*/ $new_uint_ASTContext$C_uint(/*Deref*/this, TypeAlignment, (type$ptr<?> New$Mem)->{
        return new EnumType(Decl);
     });
    Decl.TypeForDecl = newType;
    Types.push_back(newType);
    return new QualType(newType, 0);
  }

  
  
  /// getInjectedClassNameType - Return the unique reference to the
  /// injected class name type for the specified templated declaration.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::getInjectedClassNameType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp", line = 3169,
   FQN="clang::ASTContext::getInjectedClassNameType", NM="_ZNK5clang10ASTContext24getInjectedClassNameTypeEPNS_13CXXRecordDeclENS_8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZNK5clang10ASTContext24getInjectedClassNameTypeEPNS_13CXXRecordDeclENS_8QualTypeE")
  //</editor-fold>
  public QualType getInjectedClassNameType(CXXRecordDecl /*P*/ Decl, 
                          QualType TST) /*const*/ {
    assert (NeedsInjectedClassNameType(Decl));
    if ((Decl.TypeForDecl != null)) {
      assert (isa_InjectedClassNameType(Decl.TypeForDecl));
    } else {
      CXXRecordDecl /*P*/ PrevDecl = Decl.getPreviousDecl();
      if ((PrevDecl != null)) {
        assert ((PrevDecl.TypeForDecl != null)) : "previous declaration has no type";
        Decl.TypeForDecl = PrevDecl.TypeForDecl;
        assert (isa_InjectedClassNameType(Decl.TypeForDecl));
      } else {
        Type /*P*/ newType = /*NEW_EXPR [operator new] NM=_ZnwjRKN5clang10ASTContextEj*/
        /*new (*this, TypeAlignment)*/ $new_uint_ASTContext$C_uint(/*Deref*/this, TypeAlignment, (type$ptr<?> New$Mem)->{
            return new InjectedClassNameType(Decl, new QualType(TST));
         });
        Decl.TypeForDecl = newType;
        Types.push_back(newType);
      }
    }
    return new QualType(Decl.TypeForDecl, 0);
  }
  
  
  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::getAttributedType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp", line = 3259,
   FQN="clang::ASTContext::getAttributedType", NM="_ZN5clang10ASTContext17getAttributedTypeENS_14AttributedType4KindENS_8QualTypeES3_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZN5clang10ASTContext17getAttributedTypeENS_14AttributedType4KindENS_8QualTypeES3_")
  //</editor-fold>
  public QualType getAttributedType(AttributedType.Kind attrKind, 
                   QualType modifiedType, 
                   QualType equivalentType) {
    FoldingSetNodeID id/*J*/= new FoldingSetNodeID();
    AttributedType.Profile(id, attrKind, /*NO_COPY*/modifiedType, /*NO_COPY*/equivalentType);
    
    final type$ref<type$ptr<AttributedType /*P*/>/*void P*/ > insertPos = create_type$null$ref(null);
    AttributedType /*P*/ type = AttributedTypes.FindNodeOrInsertPos(id, insertPos);
    if ((type != null)) {
      return new QualType(type, 0);
  }

    QualType canon = getCanonicalType(/*NO_COPY*/equivalentType).$QualType();
    type = /*NEW_EXPR [operator new] NM=_ZnwjRKN5clang10ASTContextEj*/
    /*new (*this, TypeAlignment)*/ $new_uint_ASTContext$C_uint(/*Deref*/this, TypeAlignment, (type$ptr<?> New$Mem)->{
        return new AttributedType(new QualType(canon), attrKind, new QualType(modifiedType), new QualType(equivalentType));
     });
  
    Types.push_back(type);
    AttributedTypes.InsertNode(type, insertPos.$deref());
  
    return new QualType(type, 0);
  }

  
  
  /// \brief Retrieve a substitution-result type.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::getSubstTemplateTypeParmType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp", line = 3280,
   FQN="clang::ASTContext::getSubstTemplateTypeParmType", NM="_ZNK5clang10ASTContext28getSubstTemplateTypeParmTypeEPKNS_20TemplateTypeParmTypeENS_8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZNK5clang10ASTContext28getSubstTemplateTypeParmTypeEPKNS_20TemplateTypeParmTypeENS_8QualTypeE")
  //</editor-fold>
  public QualType getSubstTemplateTypeParmType(/*const*/ TemplateTypeParmType /*P*/ Parm, 
                              QualType Replacement) /*const*/ {
    assert (Replacement.isCanonical()) : "replacement types must always be canonical";
    
    FoldingSetNodeID ID/*J*/= new FoldingSetNodeID();
    SubstTemplateTypeParmType.Profile(ID, Parm, /*NO_COPY*/Replacement);
    final type$ref<type$ptr<SubstTemplateTypeParmType /*P*/>/*void P*/ > InsertPos = create_type$null$ref(null);
    SubstTemplateTypeParmType /*P*/ SubstParm = SubstTemplateTypeParmTypes.FindNodeOrInsertPos(ID, InsertPos);
    if (!(SubstParm != null)) {
      SubstParm = /*NEW_EXPR [operator new] NM=_ZnwjRKN5clang10ASTContextEj*/
      /*new (*this, TypeAlignment)*/ $new_uint_ASTContext$C_uint(/*Deref*/this, TypeAlignment, (type$ptr<?> New$Mem)->{
          return new SubstTemplateTypeParmType(Parm, new QualType(Replacement));
       });
      Types.push_back(SubstParm);
      SubstTemplateTypeParmTypes.InsertNode(SubstParm, InsertPos.$deref());
  }

    return new QualType(SubstParm, 0);
  }
  
  
  /// \brief Retrieve a 
  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::getSubstTemplateTypeParmPackType">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*JAVAFIX*/,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp", line = 3303,
   FQN="clang::ASTContext::getSubstTemplateTypeParmPackType", NM="_ZN5clang10ASTContext32getSubstTemplateTypeParmPackTypeEPKNS_20TemplateTypeParmTypeERKNS_16TemplateArgumentE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZN5clang10ASTContext32getSubstTemplateTypeParmPackTypeEPKNS_20TemplateTypeParmTypeERKNS_16TemplateArgumentE")
  //</editor-fold>
  public QualType getSubstTemplateTypeParmPackType(/*const*/ TemplateTypeParmType /*P*/ Parm, 
                                  final /*const*/ TemplateArgument /*&*/ ArgPack) {
    for (final /*const*/ TemplateArgument /*&*/ P : ArgPack.pack_elements()) {
      assert (P.getKind() == TemplateArgument.ArgKind.Type) : "Pack contains a non-type";
      assert (P.getAsType().isCanonical()) : "Pack contains non-canonical type";
    }

    FoldingSetNodeID ID/*J*/= new FoldingSetNodeID();
    SubstTemplateTypeParmPackType.Profile(ID, Parm, ArgPack);
    final type$ref<type$ptr<SubstTemplateTypeParmPackType /*P*/>/*void P*/ > InsertPos = create_type$null$ref(null);
    {
      SubstTemplateTypeParmPackType /*P*/ SubstParm = SubstTemplateTypeParmPackTypes.FindNodeOrInsertPos(ID, InsertPos);
      if ((SubstParm != null)) {
        return new QualType(SubstParm, 0);
      }
    }
  
    QualType Canon/*J*/= new QualType();
    if (!Parm.isCanonicalUnqualified()) {
      Canon.$assignMove(getCanonicalType(new QualType(Parm, 0)).$QualType());
      Canon.$assignMove(getSubstTemplateTypeParmPackType(cast_TemplateTypeParmType(Canon), 
              ArgPack));
      SubstTemplateTypeParmPackTypes.FindNodeOrInsertPos(ID, InsertPos);
    }
  
    SubstTemplateTypeParmPackType /*P*/ SubstParm = /*NEW_EXPR [operator new] NM=_ZnwjRKN5clang10ASTContextEj*/
    /*new (*this, TypeAlignment)*/ $new_uint_ASTContext$C_uint(/*Deref*/this, TypeAlignment, (type$ptr<?> New$Mem)->{
        return new SubstTemplateTypeParmPackType(Parm, new QualType(Canon), 
                ArgPack);
     });
    Types.push_back(SubstParm);
    // JAVAFIX: changed SubstTemplateTypeParmTypes to SubstTemplateTypeParmPackTypes
    SubstTemplateTypeParmPackTypes.InsertNode(SubstParm, InsertPos.$deref());
    return new QualType(SubstParm, 0);
  }

  
  
  /// \brief Retrieve the template type parameter type for a template
  /// parameter or parameter pack with the given depth, index, and (optionally)
  /// name.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::getTemplateTypeParmType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp", line = 3339,
   FQN="clang::ASTContext::getTemplateTypeParmType", NM="_ZNK5clang10ASTContext23getTemplateTypeParmTypeEjjbPNS_20TemplateTypeParmDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZNK5clang10ASTContext23getTemplateTypeParmTypeEjjbPNS_20TemplateTypeParmDeclE")
  //</editor-fold>
  public QualType getTemplateTypeParmType(/*uint*/int Depth, /*uint*/int Index, 
                         boolean ParameterPack) /*const*/ {
    return getTemplateTypeParmType(Depth, Index, 
                         ParameterPack, 
                         (TemplateTypeParmDecl /*P*/ )null);
  }
  public QualType getTemplateTypeParmType(/*uint*/int Depth, /*uint*/int Index, 
                         boolean ParameterPack, 
                         TemplateTypeParmDecl /*P*/ TTPDecl/*= null*/) /*const*/ {
    FoldingSetNodeID ID/*J*/= new FoldingSetNodeID();
    TemplateTypeParmType.Profile(ID, Depth, Index, ParameterPack, TTPDecl);
    final type$ref<type$ptr<TemplateTypeParmType /*P*/>/*void P*/ > InsertPos = create_type$null$ref(null);
    TemplateTypeParmType /*P*/ TypeParm = TemplateTypeParmTypes.FindNodeOrInsertPos(ID, InsertPos);
    if ((TypeParm != null)) {
      return new QualType(TypeParm, 0);
    }
    if ((TTPDecl != null)) {
      QualType Canon = getTemplateTypeParmType(Depth, Index, ParameterPack);
      TypeParm = /*NEW_EXPR [operator new] NM=_ZnwjRKN5clang10ASTContextEj*/
      /*new (*this, TypeAlignment)*/ $new_uint_ASTContext$C_uint(/*Deref*/this, TypeAlignment, (type$ptr<?> New$Mem)->{
          return new TemplateTypeParmType(TTPDecl, new QualType(Canon));
       });

      TemplateTypeParmType /*P*/ TypeCheck = TemplateTypeParmTypes.FindNodeOrInsertPos(ID, InsertPos);
      assert (!(TypeCheck != null)) : "Template type parameter canonical type broken";
      ///*J:(void)*/TypeCheck;
    } else {
      TypeParm = /*NEW_EXPR [operator new] NM=_ZnwjRKN5clang10ASTContextEj*/
      /*new (*this, TypeAlignment)*/ $new_uint_ASTContext$C_uint(/*Deref*/this, TypeAlignment, (type$ptr<?> New$Mem)->{
          return new TemplateTypeParmType(Depth, Index, ParameterPack);
       });
    }
  
    Types.push_back(TypeParm);
    TemplateTypeParmTypes.InsertNode(TypeParm, InsertPos.$deref());
    
    return new QualType(TypeParm, 0);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::getTemplateSpecializationType">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp", line = 3415,
   FQN="clang::ASTContext::getTemplateSpecializationType", NM="_ZNK5clang10ASTContext29getTemplateSpecializationTypeENS_12TemplateNameEN4llvm8ArrayRefINS_16TemplateArgumentEEENS_8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZNK5clang10ASTContext29getTemplateSpecializationTypeENS_12TemplateNameEN4llvm8ArrayRefINS_16TemplateArgumentEEENS_8QualTypeE")
  //</editor-fold>
  public QualType getTemplateSpecializationType(TemplateName Template, 
                               ArrayRef<TemplateArgument> Args) /*const*/ {
    return getTemplateSpecializationType(Template, 
                               Args, 
                               new QualType());
  }
  public QualType getTemplateSpecializationType(TemplateName Template, 
                               ArrayRef<TemplateArgument> Args, 
                               QualType Underlying/*= QualType()*/) /*const*/ {
    assert (!(Template.getAsDependentTemplateName() != null)) : "No dependent template names here!";
    {
      // Look through qualified template names.
      QualifiedTemplateName /*P*/ QTN = Template.getAsQualifiedTemplateName();
      if ((QTN != null)) {
        Template.$assignMove(new TemplateName(QTN.getTemplateDecl()));
  }
    }

    boolean IsTypeAlias = (Template.getAsTemplateDecl() != null)
       && isa_TypeAliasTemplateDecl(Template.getAsTemplateDecl());
    QualType CanonType/*J*/= new QualType();
    if (!Underlying.isNull()) {
      CanonType.$assignMove(getCanonicalType(/*NO_COPY*/Underlying).$QualType());
    } else {
      // We can get here with an alias template when the specialization contains
      // a pack expansion that does not match up with a parameter pack.
      assert ((!IsTypeAlias || hasAnyPackExpansions(new ArrayRef<TemplateArgument>(Args)))) : "Caller must compute aliased type";
      IsTypeAlias = false;
      CanonType.$assignMove(getCanonicalTemplateSpecializationType(new TemplateName(Template), new ArrayRef<TemplateArgument>(Args)));
    }
  
    // Allocate the (non-canonical) template specialization type, but don't
    // try to unique it: these types typically have location information that
    // we don't unique and don't want to lose.
    Object/*void P*/ Mem;
    if (false) {
      Mem = Allocate($sizeof_TemplateSpecializationType()
             + $sizeof_TemplateArgument() * Args.size()
             + (IsTypeAlias ? $sizeof_QualType() : 0), 
          TypeAlignment);
    } else {
      Mem = Allocate$JavaRef(/*JAVA:*/1 /*$sizeof_TemplateSpecializationType()*/
             + /*JAVA:*/1 /*$sizeof_TemplateArgument()*/ * Args.size()
             + (IsTypeAlias ? /*JAVA:*/1 /*$sizeof_QualType()*/ : 0));
    }
    boolean $IsTypeAlias = IsTypeAlias;
    TemplateSpecializationType /*P*/ Spec = /*NEW_EXPR [System]*/ /*Mem =*/ /*new (Mem)*/ $new_uint_voidPtr(Mem, (type$ptr<?> New$Mem)->{
        return new TemplateSpecializationType(New$Mem, new TemplateName(Template), new ArrayRef<TemplateArgument>(Args), new QualType(CanonType), 
                $IsTypeAlias ? new QualType(Underlying) : new QualType());
     });
    
    Types.push_back(Spec);
    return new QualType(Spec, 0);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::getCanonicalTemplateSpecializationType">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp", line = 3455,
   FQN="clang::ASTContext::getCanonicalTemplateSpecializationType", NM="_ZNK5clang10ASTContext38getCanonicalTemplateSpecializationTypeENS_12TemplateNameEN4llvm8ArrayRefINS_16TemplateArgumentEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZNK5clang10ASTContext38getCanonicalTemplateSpecializationTypeENS_12TemplateNameEN4llvm8ArrayRefINS_16TemplateArgumentEEE")
  //</editor-fold>
  public QualType getCanonicalTemplateSpecializationType(TemplateName Template, ArrayRef<TemplateArgument> Args) /*const*/ {
    assert (!(Template.getAsDependentTemplateName() != null)) : "No dependent template names here!";
    {
      
      // Look through qualified template names.
      QualifiedTemplateName /*P*/ QTN = Template.getAsQualifiedTemplateName();
      if ((QTN != null)) {
        Template.$assignMove(new TemplateName(QTN.getTemplateDecl()));
  }
    }

    // Build the canonical template specialization type.
    TemplateName CanonTemplate = getCanonicalTemplateName(new TemplateName(Template));
    SmallVector<TemplateArgument> CanonArgs/*J*/= new SmallVector<TemplateArgument>(4, new TemplateArgument());
    /*uint*/int NumArgs = Args.size();
    CanonArgs.reserve(NumArgs);
    for (final /*const*/ TemplateArgument /*&*/ Arg : Args)  {
      CanonArgs.push_back(getCanonicalTemplateArgument(Arg));
    }
  
    // Determine whether this canonical template specialization type already
    // exists.
    FoldingSetNodeID ID/*J*/= new FoldingSetNodeID();
    TemplateSpecializationType.Profile(ID, /*NO_COPY*/CanonTemplate, 
        new ArrayRef<TemplateArgument>(CanonArgs, false), /*Deref*/this);
    
    final type$ref<type$ptr<TemplateSpecializationType /*P*/>/*void P*/ > InsertPos = create_type$null$ref(null);
    TemplateSpecializationType /*P*/ Spec = TemplateSpecializationTypes.FindNodeOrInsertPos(ID, InsertPos);
    if (!(Spec != null)) {
      // Allocate a new canonical template specialization type.
      Object/*void P*/ Mem;
      if (false) {
        Mem = Allocate(($sizeof_TemplateSpecializationType()
               + $sizeof_TemplateArgument() * NumArgs), 
            TypeAlignment);
      } else {
        Mem = Allocate$JavaRef((/*JAVA:*/1 /*$sizeof_TemplateSpecializationType()*/
               + /*JAVA:*/1 /*$sizeof_TemplateArgument()*/ * NumArgs), 
            TypeAlignment);
      }
      Spec = /*NEW_EXPR [System]*/ /*Mem =*/ /*new (Mem)*/ $new_uint_voidPtr(Mem, (type$ptr<?> New$Mem)->{
          return new TemplateSpecializationType(New$Mem, new TemplateName(CanonTemplate), 
                  new ArrayRef<TemplateArgument>(CanonArgs, false), 
                  new QualType(), new QualType());
       });
      Types.push_back(Spec);
      TemplateSpecializationTypes.InsertNode(Spec, InsertPos.$deref());
    }
    assert (Spec.isDependentType()) : "Non-dependent template-id type must have a canonical type";
    return new QualType(Spec, 0);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::getTemplateSpecializationType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp", line = 3390,
   FQN="clang::ASTContext::getTemplateSpecializationType", NM="_ZNK5clang10ASTContext29getTemplateSpecializationTypeENS_12TemplateNameERKNS_24TemplateArgumentListInfoENS_8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZNK5clang10ASTContext29getTemplateSpecializationTypeENS_12TemplateNameERKNS_24TemplateArgumentListInfoENS_8QualTypeE")
  //</editor-fold>
  public QualType getTemplateSpecializationType(TemplateName Template, 
                               final /*const*/ TemplateArgumentListInfo /*&*/ Args) /*const*/ {
    return getTemplateSpecializationType(Template, 
                               Args, 
                               new QualType());
  }
  public QualType getTemplateSpecializationType(TemplateName Template, 
                               final /*const*/ TemplateArgumentListInfo /*&*/ Args, 
                               QualType Underlying/*= QualType()*/) /*const*/ {
    assert (!(Template.getAsDependentTemplateName() != null)) : "No dependent template names here!";
    
    SmallVector<TemplateArgument> ArgVec/*J*/= new SmallVector<TemplateArgument>(4, new TemplateArgument());
    ArgVec.reserve(Args.size());
    for (final /*const*/ TemplateArgumentLoc /*&*/ Arg : Args.arguments())  {
      ArgVec.push_back(Arg.getArgument());
  }

    return getTemplateSpecializationType(new TemplateName(Template), new ArrayRef<TemplateArgument>(ArgVec, false), new QualType(Underlying));
  }
  
  
  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::getTemplateSpecializationTypeInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp", line = 3369,
   FQN="clang::ASTContext::getTemplateSpecializationTypeInfo", NM="_ZNK5clang10ASTContext33getTemplateSpecializationTypeInfoENS_12TemplateNameENS_14SourceLocationERKNS_24TemplateArgumentListInfoENS_8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZNK5clang10ASTContext33getTemplateSpecializationTypeInfoENS_12TemplateNameENS_14SourceLocationERKNS_24TemplateArgumentListInfoENS_8QualTypeE")
  //</editor-fold>
  public TypeSourceInfo /*P*/ getTemplateSpecializationTypeInfo(TemplateName Name, 
                                   SourceLocation NameLoc, 
                                   final /*const*/ TemplateArgumentListInfo /*&*/ Args) /*const*/ {
    return getTemplateSpecializationTypeInfo(Name, 
                                   NameLoc, 
                                   Args, 
                                   new QualType());
  }
  public TypeSourceInfo /*P*/ getTemplateSpecializationTypeInfo(TemplateName Name, 
                                   SourceLocation NameLoc, 
                                   final /*const*/ TemplateArgumentListInfo /*&*/ Args, 
                                   QualType Underlying/*= QualType()*/) /*const*/ {
    assert (!(Name.getAsDependentTemplateName() != null)) : "No dependent template names here!";
    QualType TST = getTemplateSpecializationType(new TemplateName(Name), Args, new QualType(Underlying));
    
    TypeSourceInfo /*P*/ DI = CreateTypeSourceInfo(new QualType(TST));
    TemplateSpecializationTypeLoc TL = DI.getTypeLoc().castAs(TemplateSpecializationTypeLoc.class);
    TL.setTemplateKeywordLoc(new SourceLocation());
    TL.setTemplateNameLoc(/*NO_COPY*/NameLoc);
    TL.setLAngleLoc(Args.getLAngleLoc());
    TL.setRAngleLoc(Args.getRAngleLoc());
    for (/*uint*/int i = 0, e = TL.getNumArgs(); i != e; ++i)  {
      TL.setArgLocInfo(i, Args.$at$Const(i).getLocInfo());
  }
    return DI;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::getParenType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp", line = 3525,
   FQN="clang::ASTContext::getParenType", NM="_ZNK5clang10ASTContext12getParenTypeENS_8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZNK5clang10ASTContext12getParenTypeENS_8QualTypeE")
  //</editor-fold>
  public QualType getParenType(QualType InnerType) /*const*/ {
    FoldingSetNodeID ID/*J*/= new FoldingSetNodeID();
    ParenType.Profile(ID, /*NO_COPY*/InnerType);
    
    final type$ref<type$ptr<ParenType /*P*/>/*void P*/ > InsertPos = create_type$null$ref(null);
    ParenType /*P*/ T = ParenTypes.FindNodeOrInsertPos(ID, InsertPos);
    if ((T != null)) {
      return new QualType(T, 0);
  }

    QualType Canon = new QualType(InnerType);
    if (!Canon.isCanonical()) {
      Canon.$assignMove(getCanonicalType(/*NO_COPY*/InnerType).$QualType());
      ParenType /*P*/ CheckT = ParenTypes.FindNodeOrInsertPos(ID, InsertPos);
      assert (!(CheckT != null)) : "Paren canonical type broken";
      ///*J:(void)*/CheckT;
    }
  
    T = /*NEW_EXPR [operator new] NM=_ZnwjRKN5clang10ASTContextEj*/
    /*new (*this, TypeAlignment)*/ $new_uint_ASTContext$C_uint(/*Deref*/this, TypeAlignment, (type$ptr<?> New$Mem)->{
        return new ParenType(new QualType(InnerType), new QualType(Canon));
     });
    Types.push_back(T);
    ParenTypes.InsertNode(T, InsertPos.$deref());
    return new QualType(T, 0);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::getElaboratedType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp", line = 3499,
   FQN="clang::ASTContext::getElaboratedType", NM="_ZNK5clang10ASTContext17getElaboratedTypeENS_21ElaboratedTypeKeywordEPNS_19NestedNameSpecifierENS_8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZNK5clang10ASTContext17getElaboratedTypeENS_21ElaboratedTypeKeywordEPNS_19NestedNameSpecifierENS_8QualTypeE")
  //</editor-fold>
  public QualType getElaboratedType(ElaboratedTypeKeyword Keyword, 
                   NestedNameSpecifier /*P*/ NNS, 
                   QualType NamedType) /*const*/ {
    FoldingSetNodeID ID/*J*/= new FoldingSetNodeID();
    ElaboratedType.Profile(ID, Keyword, NNS, /*NO_COPY*/NamedType);
    
    final type$ref<type$ptr<ElaboratedType /*P*/>/*void P*/ > InsertPos = create_type$null$ref(null);
    ElaboratedType /*P*/ T = ElaboratedTypes.FindNodeOrInsertPos(ID, InsertPos);
    if ((T != null)) {
      return new QualType(T, 0);
  }

    QualType Canon = new QualType(NamedType);
    if (!Canon.isCanonical()) {
      Canon.$assignMove(getCanonicalType(/*NO_COPY*/NamedType).$QualType());
      ElaboratedType /*P*/ CheckT = ElaboratedTypes.FindNodeOrInsertPos(ID, InsertPos);
      assert (!(CheckT != null)) : "Elaborated canonical type broken";
      ///*J:(void)*/CheckT;
    }
    
    T = /*NEW_EXPR [operator new] NM=_ZnwjRKN5clang10ASTContextEj*/
    /*new (*this, TypeAlignment)*/ $new_uint_ASTContext$C_uint(/*Deref*/this, TypeAlignment, (type$ptr<?> New$Mem)->{
        return new ElaboratedType(Keyword, NNS, new QualType(NamedType), new QualType(Canon));
     });
    Types.push_back(T);
    ElaboratedTypes.InsertNode(T, InsertPos.$deref());
    return new QualType(T, 0);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::getDependentNameType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp", line = 3549,
   FQN="clang::ASTContext::getDependentNameType", NM="_ZNK5clang10ASTContext20getDependentNameTypeENS_21ElaboratedTypeKeywordEPNS_19NestedNameSpecifierEPKNS_14IdentifierInfoENS_8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZNK5clang10ASTContext20getDependentNameTypeENS_21ElaboratedTypeKeywordEPNS_19NestedNameSpecifierEPKNS_14IdentifierInfoENS_8QualTypeE")
  //</editor-fold>
  public QualType getDependentNameType(ElaboratedTypeKeyword Keyword, 
                      NestedNameSpecifier /*P*/ NNS, 
                      /*const*/ IdentifierInfo /*P*/ Name) /*const*/ {
    return getDependentNameType(Keyword, 
                      NNS, 
                      Name, 
                      new QualType());
  }
  public QualType getDependentNameType(ElaboratedTypeKeyword Keyword, 
                      NestedNameSpecifier /*P*/ NNS, 
                      /*const*/ IdentifierInfo /*P*/ Name, 
                      QualType Canon/*= QualType()*/) /*const*/ {
    if (Canon.isNull()) {
      NestedNameSpecifier /*P*/ CanonNNS = getCanonicalNestedNameSpecifier(NNS);
      ElaboratedTypeKeyword CanonKeyword = Keyword;
      if (Keyword == ElaboratedTypeKeyword.ETK_None) {
        CanonKeyword = ElaboratedTypeKeyword.ETK_Typename;
  }
      if (CanonNNS != NNS || CanonKeyword != Keyword) {
        Canon.$assignMove(getDependentNameType(CanonKeyword, CanonNNS, Name));
      }
    }

    FoldingSetNodeID ID/*J*/= new FoldingSetNodeID();
    DependentNameType.Profile(ID, Keyword, NNS, Name);
  
    final type$ref<type$ptr<DependentNameType /*P*/>/*void P*/ > InsertPos = create_type$null$ref(null);
    DependentNameType /*P*/ T = DependentNameTypes.FindNodeOrInsertPos(ID, InsertPos);
    if ((T != null)) {
      return new QualType(T, 0);
    }
    
    T = /*NEW_EXPR [operator new] NM=_ZnwjRKN5clang10ASTContextEj*/
    /*new (*this, TypeAlignment)*/ $new_uint_ASTContext$C_uint(/*Deref*/this, TypeAlignment, (type$ptr<?> New$Mem)->{
        return new DependentNameType(Keyword, NNS, Name, new QualType(Canon));
     });
    Types.push_back(T);
    DependentNameTypes.InsertNode(T, InsertPos.$deref());
    return new QualType(T, 0);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::getDependentTemplateSpecializationType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp", line = 3578,
   FQN="clang::ASTContext::getDependentTemplateSpecializationType", NM="_ZNK5clang10ASTContext38getDependentTemplateSpecializationTypeENS_21ElaboratedTypeKeywordEPNS_19NestedNameSpecifierEPKNS_14IdentifierInfoERKNS_24TemplateArgumentListInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZNK5clang10ASTContext38getDependentTemplateSpecializationTypeENS_21ElaboratedTypeKeywordEPNS_19NestedNameSpecifierEPKNS_14IdentifierInfoERKNS_24TemplateArgumentListInfoE")
  //</editor-fold>
  public QualType getDependentTemplateSpecializationType(ElaboratedTypeKeyword Keyword, 
                                        NestedNameSpecifier /*P*/ NNS, 
                                        /*const*/ IdentifierInfo /*P*/ Name, 
                                        final /*const*/ TemplateArgumentListInfo /*&*/ Args) /*const*/ {
    // TODO: avoid this copy
    SmallVector<TemplateArgument> ArgCopy/*J*/= new SmallVector<TemplateArgument>(16, new TemplateArgument());
    for (/*uint*/int I = 0, E = Args.size(); I != E; ++I)  {
      ArgCopy.push_back(Args.$at$Const(I).getArgument());
  }
    return getDependentTemplateSpecializationType(Keyword, NNS, Name, new ArrayRef<TemplateArgument>(ArgCopy, false));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::getDependentTemplateSpecializationType">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp", line = 3591,
   FQN="clang::ASTContext::getDependentTemplateSpecializationType", NM="_ZNK5clang10ASTContext38getDependentTemplateSpecializationTypeENS_21ElaboratedTypeKeywordEPNS_19NestedNameSpecifierEPKNS_14IdentifierInfoEN4llvm8ArrayRefINS_16TemplateArgumentEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZNK5clang10ASTContext38getDependentTemplateSpecializationTypeENS_21ElaboratedTypeKeywordEPNS_19NestedNameSpecifierEPKNS_14IdentifierInfoEN4llvm8ArrayRefINS_16TemplateArgumentEEE")
  //</editor-fold>
  public QualType getDependentTemplateSpecializationType(ElaboratedTypeKeyword Keyword, 
                                        NestedNameSpecifier /*P*/ NNS, 
                                        /*const*/ IdentifierInfo /*P*/ Name, 
                                        ArrayRef<TemplateArgument> Args) /*const*/ {
    assert ((!(NNS != null) || NNS.isDependent())) : "nested-name-specifier must be dependent";
    
    FoldingSetNodeID ID/*J*/= new FoldingSetNodeID();
    DependentTemplateSpecializationType.Profile(ID, /*Deref*/this, Keyword, NNS, 
        Name, /*NO_COPY*/Args);
    
    final type$ref<type$ptr<DependentTemplateSpecializationType /*P*/>/*void P*/ > InsertPos = create_type$null$ref(null);
    DependentTemplateSpecializationType /*P*/ T = DependentTemplateSpecializationTypes.FindNodeOrInsertPos(ID, InsertPos);
    if ((T != null)) {
      return new QualType(T, 0);
  }

    NestedNameSpecifier /*P*/ CanonNNS = getCanonicalNestedNameSpecifier(NNS);
  
    ElaboratedTypeKeyword CanonKeyword = Keyword;
    if (Keyword == ElaboratedTypeKeyword.ETK_None) {
      CanonKeyword = ElaboratedTypeKeyword.ETK_Typename;
    }
    
    boolean AnyNonCanonArgs = false;
    /*uint*/int NumArgs = Args.size();
    SmallVector<TemplateArgument> CanonArgs/*J*/= new SmallVector<TemplateArgument>(JD$UInt_T$C$R.INSTANCE, 16, NumArgs, new TemplateArgument());
    for (/*uint*/int I = 0; I != NumArgs; ++I) {
      CanonArgs.$at(I).$assignMove(getCanonicalTemplateArgument(Args.$at(I)));
      if (!CanonArgs.$at(I).structurallyEquals(Args.$at(I))) {
        AnyNonCanonArgs = true;
      }
    }
    
    QualType Canon/*J*/= new QualType();
    if (AnyNonCanonArgs || CanonNNS != NNS || CanonKeyword != Keyword) {
      Canon.$assignMove(getDependentTemplateSpecializationType(CanonKeyword, CanonNNS, 
              Name, 
              new ArrayRef<TemplateArgument>(CanonArgs, false)));
      
      // Find the insert position again.
      DependentTemplateSpecializationTypes.FindNodeOrInsertPos(ID, InsertPos);
    }
    Object/*void P*/ Mem;
    if (false) {
      Mem = Allocate(($sizeof_DependentTemplateSpecializationType()
             + $sizeof_TemplateArgument() * NumArgs), 
          TypeAlignment);
    } else {
      Mem = Allocate$JavaRef((/*JAVA:*/1 /*$sizeof_DependentTemplateSpecializationType()*/
             + /*JAVA:*/1 /*$sizeof_TemplateArgument()*/ * NumArgs), 
          TypeAlignment);
    }
    T = /*NEW_EXPR [System]*/ /*Mem =*/ /*new (Mem)*/ $new_uint_voidPtr(Mem, (type$ptr<?> New$Mem)->{
        return new DependentTemplateSpecializationType(Keyword, NNS, 
                Name, new ArrayRef<TemplateArgument>(Args), new QualType(Canon));
     });
    Types.push_back(T);
    DependentTemplateSpecializationTypes.InsertNode(T, InsertPos.$deref());
    return new QualType(T, 0);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::getPackExpansionType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp", line = 3644,
   FQN="clang::ASTContext::getPackExpansionType", NM="_ZN5clang10ASTContext20getPackExpansionTypeENS_8QualTypeEN4llvm8OptionalIjEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZN5clang10ASTContext20getPackExpansionTypeENS_8QualTypeEN4llvm8OptionalIjEE")
  //</editor-fold>
  public QualType getPackExpansionType(QualType Pattern, 
                      OptionalUInt NumExpansions) {
    FoldingSetNodeID ID/*J*/= new FoldingSetNodeID();
    PackExpansionType.Profile(ID, /*NO_COPY*/Pattern, new OptionalUInt(NumExpansions));
    assert (Pattern.$arrow().containsUnexpandedParameterPack()) : "Pack expansions must expand one or more parameter packs";
    final type$ref<type$ptr<PackExpansionType /*P*/>/*void P*/ > InsertPos = create_type$null$ref(null);
    PackExpansionType /*P*/ T = PackExpansionTypes.FindNodeOrInsertPos(ID, InsertPos);
    if ((T != null)) {
      return new QualType(T, 0);
  }

    QualType Canon/*J*/= new QualType();
    if (!Pattern.isCanonical()) {
      Canon.$assignMove(getCanonicalType(/*NO_COPY*/Pattern).$QualType());
      // The canonical type might not contain an unexpanded parameter pack, if it
      // contains an alias template specialization which ignores one of its
      // parameters.
      if (Canon.$arrow().containsUnexpandedParameterPack()) {
        Canon.$assignMove(getPackExpansionType(new QualType(Canon), new OptionalUInt(NumExpansions)));
  
        // Find the insert position again, in case we inserted an element into
        // PackExpansionTypes and invalidated our insert position.
        PackExpansionTypes.FindNodeOrInsertPos(ID, InsertPos);
      }
    }
  
    T = /*NEW_EXPR [operator new] NM=_ZnwjRKN5clang10ASTContextEj*/
    /*new (*this, TypeAlignment)*/ $new_uint_ASTContext$C_uint(/*Deref*/this, TypeAlignment, (type$ptr<?> New$Mem)->{
        return new PackExpansionType(new QualType(Pattern), new QualType(Canon), new OptionalUInt(NumExpansions));
     });
    Types.push_back(T);
    PackExpansionTypes.InsertNode(T, InsertPos.$deref());
    return new QualType(T, 0);
  }

  
  
  /// getObjCInterfaceType - Return the unique reference to the type for the
  /// specified ObjC interface decl. The list of protocols is optional.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::getObjCInterfaceType">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*sizeof*/,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp", line = 3899,
   FQN="clang::ASTContext::getObjCInterfaceType", NM="_ZNK5clang10ASTContext20getObjCInterfaceTypeEPKNS_17ObjCInterfaceDeclEPS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZNK5clang10ASTContext20getObjCInterfaceTypeEPKNS_17ObjCInterfaceDeclEPS1_")
  //</editor-fold>
  public QualType getObjCInterfaceType(/*const*/ ObjCInterfaceDecl /*P*/ Decl) /*const*/ {
    return getObjCInterfaceType(Decl, 
                      (ObjCInterfaceDecl /*P*/ )null);
  }
  public QualType getObjCInterfaceType(/*const*/ ObjCInterfaceDecl /*P*/ Decl, 
                      ObjCInterfaceDecl /*P*/ PrevDecl/*= null*/) /*const*/ {
    if ((Decl.TypeForDecl != null)) {
      return new QualType(Decl.TypeForDecl, 0);
    }
    if ((PrevDecl != null)) {
      assert ((PrevDecl.TypeForDecl != null)) : "previous decl has no TypeForDecl";
      Decl.TypeForDecl = PrevDecl.TypeForDecl;
      return new QualType(PrevDecl.TypeForDecl, 0);
    }
    {
      
      // Prefer the definition, if there is one.
      /*const*/ ObjCInterfaceDecl /*P*/ Def = Decl.getDefinition$Const();
      if ((Def != null)) {
        Decl = Def;
      }
    }
    
    Object/*void P*/ Mem;
    if (false) {
      Mem = Allocate($sizeof_ObjCInterfaceType(), TypeAlignment);
    } else {
      Mem = Allocate$JavaRef();
    }
    final /*const*/ ObjCInterfaceDecl /*P*/ L$Decl = Decl;
    ObjCInterfaceType /*P*/ T = /*NEW_EXPR [System]*//*Mem = *//*new (Mem)*/ $new_uint_voidPtr(Mem, (type$ptr<?> New$Mem)->{
        return new ObjCInterfaceType(L$Decl);
     });
    Decl.TypeForDecl = T;
    Types.push_back(T);
    return new QualType(T, 0);
  }

  
  /// Legacy interface: cannot provide type arguments or __kindof.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::getObjCObjectType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp", line = 3713,
   FQN="clang::ASTContext::getObjCObjectType", NM="_ZNK5clang10ASTContext17getObjCObjectTypeENS_8QualTypeEPKPNS_16ObjCProtocolDeclEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZNK5clang10ASTContext17getObjCObjectTypeENS_8QualTypeEPKPNS_16ObjCProtocolDeclEj")
  //</editor-fold>
  public QualType getObjCObjectType(QualType BaseType, 
                   type$ptr<ObjCProtocolDecl /*P*/ /*const*/ /*P*/> Protocols, 
                   /*uint*/int NumProtocols) /*const*/ {
    return getObjCObjectType(new QualType(BaseType), /*{ */new ArrayRef<QualType>(false)/* }*/, 
        llvm.makeArrayRef(Protocols, NumProtocols), 
        /*isKindOf=*/ false);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::getObjCObjectType">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*sizeof*/,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp", line = 3721,
   FQN="clang::ASTContext::getObjCObjectType", NM="_ZNK5clang10ASTContext17getObjCObjectTypeENS_8QualTypeEN4llvm8ArrayRefIS1_EENS3_IPNS_16ObjCProtocolDeclEEEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZNK5clang10ASTContext17getObjCObjectTypeENS_8QualTypeEN4llvm8ArrayRefIS1_EENS3_IPNS_16ObjCProtocolDeclEEEb")
  //</editor-fold>
  public QualType getObjCObjectType(QualType baseType, 
                   ArrayRef<QualType> typeArgs, 
                   ArrayRef<ObjCProtocolDecl /*P*/ > protocols, 
                   boolean isKindOf) /*const*/ {
    // If the base type is an interface and there aren't any protocols or
    // type arguments to add, then the interface type will do just fine.
    if (typeArgs.empty() && protocols.empty() && !isKindOf
       && isa_ObjCInterfaceType(baseType)) {
      return new QualType(JD$Move.INSTANCE, baseType);
    }
    
    // Look in the folding set for an existing type.
    FoldingSetNodeID ID/*J*/= new FoldingSetNodeID();
    ObjCObjectTypeImpl.Profile(ID, /*NO_COPY*/baseType, /*NO_COPY*/typeArgs, /*NO_COPY*/protocols, isKindOf);
    final type$ref<type$ptr<ObjCObjectTypeImpl /*P*/>/*void P*/ > InsertPos = create_type$null$ref(null);
    {
      ObjCObjectTypeImpl /*P*/ QT = ObjCObjectTypes.FindNodeOrInsertPos(ID, InsertPos);
      if ((QT != null)) {
        return new QualType(QT, 0);
      }
    }
    
    // Determine the type arguments to be used for canonicalization,
    // which may be explicitly specified here or written on the base
    // type.
    ArrayRef<QualType> effectiveTypeArgs = new ArrayRef<QualType>(typeArgs);
    if (effectiveTypeArgs.empty()) {
      {
        /*const*/ ObjCObjectType /*P*/ baseObject = baseType.$arrow().getAs(ObjCObjectType.class);
        if ((baseObject != null)) {
          effectiveTypeArgs.$assignMove(baseObject.getTypeArgs());
        }
      }
    }
    
    // Build the canonical type, which has the canonical base type and a
    // sorted-and-uniqued list of protocols and the type arguments
    // canonicalized.
    QualType canonical/*J*/= new QualType();
    boolean typeArgsAreCanonical = std.all_of(effectiveTypeArgs.begin(), 
        effectiveTypeArgs.end(), 
        /*[&]*/ (QualType type) -> {
              return type.isCanonical();
            });
    boolean protocolsSorted = areSortedAndUniqued(new ArrayRef<ObjCProtocolDecl /*P*/ >(protocols));
    if (!typeArgsAreCanonical || !protocolsSorted || !baseType.isCanonical()) {
      // Determine the canonical type arguments.
      ArrayRef<QualType> canonTypeArgs/*J*/= new ArrayRef<QualType>(false);
      SmallVector<QualType> canonTypeArgsVec/*J*/= new SmallVector<QualType>(4, new QualType());
      if (!typeArgsAreCanonical) {
        canonTypeArgsVec.reserve(effectiveTypeArgs.size());
        for (QualType typeArg : effectiveTypeArgs)  {
          canonTypeArgsVec.push_back(getCanonicalType(/*NO_COPY*/typeArg).$QualType());
        }
        canonTypeArgs.$assignMove(new ArrayRef<QualType>(canonTypeArgsVec, false));
      } else {
        canonTypeArgs.$assign(effectiveTypeArgs);
      }
      
      ArrayRef<ObjCProtocolDecl /*P*/ > canonProtocols/*J*/= new ArrayRef<ObjCProtocolDecl /*P*/ >(true);
      SmallVector<ObjCProtocolDecl /*P*/ > canonProtocolsVec/*J*/= new SmallVector<ObjCProtocolDecl /*P*/ >(8, (ObjCProtocolDecl /*P*/ )null);
      if (!protocolsSorted) {
        canonProtocolsVec.append_T(protocols.begin(), protocols.end());
        SortAndUniqueProtocols(canonProtocolsVec);
        canonProtocols.$assignMove(new ArrayRef<ObjCProtocolDecl /*P*/ >(canonProtocolsVec, true));
      } else {
        canonProtocols.$assign(protocols);
      }
      
      canonical.$assignMove(getObjCObjectType(getCanonicalType(/*NO_COPY*/baseType).$QualType(), new ArrayRef<QualType>(canonTypeArgs), 
              new ArrayRef<ObjCProtocolDecl /*P*/ >(canonProtocols), isKindOf));
      
      // Regenerate InsertPos.
      ObjCObjectTypes.FindNodeOrInsertPos(ID, InsertPos);
    }
    
    /*uint*/int size = true ? /*JAVA*/1 : $sizeof_ObjCObjectTypeImpl();
    size += typeArgs.size() * (true ? /*JAVA*/1 : $sizeof_QualType());
    size += protocols.size() * (true ? /*JAVA*/1 : $sizeof_ptr(/*ObjCProtocolDecl  */));
    Object/*void P*/ mem = Allocate$JavaRef(size, TypeAlignment);
    ObjCObjectTypeImpl /*P*/ T = /*NEW_EXPR [System]*//*mem = *//*new (mem)*/ $new_uint_voidPtr(mem, (type$ptr<?> New$Mem)->{
        return new ObjCObjectTypeImpl(new QualType(canonical), new QualType(baseType), new ArrayRef<QualType>(typeArgs), new ArrayRef<ObjCProtocolDecl /*P*/ >(protocols), 
                isKindOf);
     });
    
    Types.push_back(T);
    ObjCObjectTypes.InsertNode(T, InsertPos.$deref());
    return new QualType(T, 0);
  }

  
  
  /// ObjCObjectAdoptsQTypeProtocols - Checks that protocols in IC's
  /// protocol list adopt all protocols in QT's qualified-id protocol
  /// list.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::ObjCObjectAdoptsQTypeProtocols">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp", line = 3804,
   FQN="clang::ASTContext::ObjCObjectAdoptsQTypeProtocols", NM="_ZN5clang10ASTContext30ObjCObjectAdoptsQTypeProtocolsENS_8QualTypeEPNS_17ObjCInterfaceDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZN5clang10ASTContext30ObjCObjectAdoptsQTypeProtocolsENS_8QualTypeEPNS_17ObjCInterfaceDeclE")
  //</editor-fold>
  public boolean ObjCObjectAdoptsQTypeProtocols(QualType QT, 
                                ObjCInterfaceDecl /*P*/ IC) {
    if (!QT.$arrow().isObjCQualifiedIdType()) {
      return false;
    }
    {
      
      /*const*/ ObjCObjectPointerType /*P*/ OPT = QT.$arrow().getAs(ObjCObjectPointerType.class);
      if ((OPT != null)) {
        // If both the right and left sides have qualifiers.
        for (ObjCProtocolDecl /*P*/ Proto : OPT.quals()) {
          if (!IC.ClassImplementsProtocol(Proto, false)) {
            return false;
          }
        }
        return true;
      }
    }
    return false;
  }

  /// QIdProtocolsAdoptObjCObjectProtocols - Checks that protocols in
  /// QT's qualified-id protocol list adopt all protocols in IDecl's list
  /// of protocols.
  
  /// QIdProtocolsAdoptObjCObjectProtocols - Checks that protocols in
  /// QT's qualified-id protocol list adopt all protocols in IDecl's list
  /// of protocols.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::QIdProtocolsAdoptObjCObjectProtocols">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp", line = 3823,
   FQN="clang::ASTContext::QIdProtocolsAdoptObjCObjectProtocols", NM="_ZN5clang10ASTContext36QIdProtocolsAdoptObjCObjectProtocolsENS_8QualTypeEPNS_17ObjCInterfaceDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZN5clang10ASTContext36QIdProtocolsAdoptObjCObjectProtocolsENS_8QualTypeEPNS_17ObjCInterfaceDeclE")
  //</editor-fold>
  public boolean QIdProtocolsAdoptObjCObjectProtocols(QualType QT, 
                                      ObjCInterfaceDecl /*P*/ IDecl) {
    if (!QT.$arrow().isObjCQualifiedIdType()) {
      return false;
    }
    /*const*/ ObjCObjectPointerType /*P*/ OPT = QT.$arrow().getAs(ObjCObjectPointerType.class);
    if (!(OPT != null)) {
      return false;
    }
    if (!IDecl.hasDefinition()) {
      return false;
    }
    SmallPtrSet<ObjCProtocolDecl /*P*/ > InheritedProtocols/*J*/= new SmallPtrSet<ObjCProtocolDecl /*P*/ >(DenseMapInfo$LikePtr.$Info(), 8);
    CollectInheritedProtocols(IDecl, InheritedProtocols);
    if (InheritedProtocols.empty()) {
      return false;
    }
    // Check that if every protocol in list of id<plist> conforms to a protcol
    // of IDecl's, then bridge casting is ok.
    boolean Conforms = false;
    for (ObjCProtocolDecl /*P*/ Proto : OPT.quals()) {
      Conforms = false;
      for (ObjCProtocolDecl /*P*/ PI : InheritedProtocols) {
        if (ProtocolCompatibleWithProtocol(Proto, PI)) {
          Conforms = true;
          break;
        }
      }
      if (!Conforms) {
        break;
      }
    }
    if (Conforms) {
      return true;
    }
    
    for (ObjCProtocolDecl /*P*/ PI : InheritedProtocols) {
      // If both the right and left sides have qualifiers.
      boolean Adopts = false;
      for (ObjCProtocolDecl /*P*/ Proto : OPT.quals()) {
        // return 'true' if 'PI' is in the inheritance hierarchy of Proto
        if ((Adopts = ProtocolCompatibleWithProtocol(PI, Proto))) {
          break;
        }
      }
      if (!Adopts) {
        return false;
      }
    }
    return true;
  }

  
  /// \brief Return a ObjCObjectPointerType type for the given ObjCObjectType.
  
  /// getObjCObjectPointerType - Return a ObjCObjectPointerType type for
  /// the given object type.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::getObjCObjectPointerType">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*sizeof*/,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp", line = 3869,
   FQN="clang::ASTContext::getObjCObjectPointerType", NM="_ZNK5clang10ASTContext24getObjCObjectPointerTypeENS_8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZNK5clang10ASTContext24getObjCObjectPointerTypeENS_8QualTypeE")
  //</editor-fold>
  public QualType getObjCObjectPointerType(QualType ObjectT) /*const*/ {
    FoldingSetNodeID ID/*J*/= new FoldingSetNodeID();
    ObjCObjectPointerType.Profile(ID, /*NO_COPY*/ObjectT);
    
    final type$ref<type$ptr<ObjCObjectPointerType /*P*/>/*void P*/ > InsertPos = create_type$null$ref(null);
    {
      ObjCObjectPointerType /*P*/ QT = ObjCObjectPointerTypes.FindNodeOrInsertPos(ID, InsertPos);
      if ((QT != null)) {
        return new QualType(QT, 0);
      }
    }
    
    // Find the canonical object type.
    QualType Canonical/*J*/= new QualType();
    if (!ObjectT.isCanonical()) {
      Canonical.$assignMove(getObjCObjectPointerType(getCanonicalType(/*NO_COPY*/ObjectT).$QualType()));
      
      // Regenerate InsertPos.
      ObjCObjectPointerTypes.FindNodeOrInsertPos(ID, InsertPos);
    }
    
    // No match.
    Object/*void P*/ Mem;
    if (false) {
      Mem = Allocate($sizeof_ObjCObjectPointerType(), TypeAlignment);
    } else {
      Mem = Allocate$JavaRef();
    }
    ObjCObjectPointerType /*P*/ QType = /*NEW_EXPR [System]*//*Mem = *//*new (Mem)*/ $new_uint_voidPtr(Mem, (type$ptr<?> New$Mem)->{
        return new ObjCObjectPointerType(new QualType(Canonical), new QualType(ObjectT));
     });
    
    Types.push_back(QType);
    ObjCObjectPointerTypes.InsertNode(QType, InsertPos.$deref());
    return new QualType(QType, 0);
  }

  
  /// \brief GCC extension.
  
  /// getTypeOfExprType - Unlike many "get<Type>" functions, we can't unique
  /// TypeOfExprType AST's (since expression's are never shared). For example,
  /// multiple declarations that refer to "typeof(x)" all contain different
  /// DeclRefExpr's. This doesn't effect the type checker, since it operates
  /// on canonical type's (which are always unique).
  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::getTypeOfExprType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp", line = 3926,
   FQN="clang::ASTContext::getTypeOfExprType", NM="_ZNK5clang10ASTContext17getTypeOfExprTypeEPNS_4ExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZNK5clang10ASTContext17getTypeOfExprTypeEPNS_4ExprE")
  //</editor-fold>
  public QualType getTypeOfExprType(Expr /*P*/ tofExpr) /*const*/ {
    TypeOfExprType /*P*/ toe;
    if (tofExpr.isTypeDependent()) {
      FoldingSetNodeID ID/*J*/= new FoldingSetNodeID();
      DependentTypeOfExprType.Profile(ID, /*Deref*/this, tofExpr);
      
      final type$ref<type$ptr<DependentTypeOfExprType /*P*/>/*void P*/ > InsertPos = create_type$null$ref(null);
      DependentTypeOfExprType /*P*/ Canon = DependentTypeOfExprTypes.FindNodeOrInsertPos(ID, InsertPos);
      if ((Canon != null)) {
        // We already have a "canonical" version of an identical, dependent
        // typeof(expr) type. Use that as our canonical type.
        DependentTypeOfExprType /*P*/ $Canon = Canon;
        toe = /*NEW_EXPR [operator new] NM=_ZnwjRKN5clang10ASTContextEj*/
        /*new (*this, TypeAlignment)*/ $new_uint_ASTContext$C_uint(/*Deref*/this, TypeAlignment, (type$ptr<?> New$Mem)->{
            return new TypeOfExprType(tofExpr, 
                    new QualType((TypeOfExprType /*P*/ )$Canon, 0));
         });
      } else {
        // Build a new, canonical typeof(expr) type.
        Canon
           = /*NEW_EXPR [operator new] NM=_ZnwjRKN5clang10ASTContextEj*/
        /*new (*this, TypeAlignment)*/ $new_uint_ASTContext$C_uint(/*Deref*/this, TypeAlignment, (type$ptr<?> New$Mem)->{
            return new DependentTypeOfExprType(/*Deref*/this, tofExpr);
         });
        DependentTypeOfExprTypes.InsertNode(Canon, InsertPos.$deref());
        toe = Canon;
      }
    } else {
      QualType Canonical = getCanonicalType(tofExpr.getType()).$QualType();
      toe = /*NEW_EXPR [operator new] NM=_ZnwjRKN5clang10ASTContextEj*/
      /*new (*this, TypeAlignment)*/ $new_uint_ASTContext$C_uint(/*Deref*/this, TypeAlignment, (type$ptr<?> New$Mem)->{
          return new TypeOfExprType(tofExpr, new QualType(Canonical));
       });
    }
    Types.push_back(toe);
    return new QualType(toe, 0);
  }

  
  /// getTypeOfType -  Unlike many "get<Type>" functions, we don't unique
  /// TypeOfType nodes. The only motivation to unique these nodes would be
  /// memory savings. Since typeof(t) is fairly uncommon, space shouldn't be
  /// an issue. This doesn't affect the type checker, since it operates
  /// on canonical types (which are always unique).
  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::getTypeOfType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp", line = 3960,
   FQN="clang::ASTContext::getTypeOfType", NM="_ZNK5clang10ASTContext13getTypeOfTypeENS_8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZNK5clang10ASTContext13getTypeOfTypeENS_8QualTypeE")
  //</editor-fold>
  public QualType getTypeOfType(QualType tofType) /*const*/ {
    QualType Canonical = getCanonicalType(/*NO_COPY*/tofType).$QualType();
    TypeOfType /*P*/ tot = /*NEW_EXPR [operator new] NM=_ZnwjRKN5clang10ASTContextEj*/
    /*new (*this, TypeAlignment)*/ $new_uint_ASTContext$C_uint(/*Deref*/this, TypeAlignment, (type$ptr<?> New$Mem)->{
        return new TypeOfType(new QualType(tofType), new QualType(Canonical));
     });
    Types.push_back(tot);
    return new QualType(tot, 0);
  }

  
  /// \brief C++11 decltype.
  
  /// \brief Unlike many "get<Type>" functions, we don't unique DecltypeType
  /// nodes. This would never be helpful, since each such type has its own
  /// expression, and would not give a significant memory saving, since there
  /// is an Expr tree under each such type.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::getDecltypeType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp", line = 3971,
   FQN="clang::ASTContext::getDecltypeType", NM="_ZNK5clang10ASTContext15getDecltypeTypeEPNS_4ExprENS_8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZNK5clang10ASTContext15getDecltypeTypeEPNS_4ExprENS_8QualTypeE")
  //</editor-fold>
  public QualType getDecltypeType(Expr /*P*/ e, QualType UnderlyingType) /*const*/ {
    DecltypeType /*P*/ dt;
    
    // C++11 [temp.type]p2:
    //   If an expression e involves a template parameter, decltype(e) denotes a
    //   unique dependent type. Two such decltype-specifiers refer to the same
    //   type only if their expressions are equivalent (14.5.6.1).
    if (e.isInstantiationDependent()) {
      FoldingSetNodeID ID/*J*/= new FoldingSetNodeID();
      DependentDecltypeType.Profile(ID, /*Deref*/this, e);
      
      final type$ref<type$ptr<DependentDecltypeType /*P*/>/*void P*/ > InsertPos = create_type$null$ref(null);
      DependentDecltypeType /*P*/ Canon = DependentDecltypeTypes.FindNodeOrInsertPos(ID, InsertPos);
      if (!(Canon != null)) {
        // Build a new, canonical typeof(expr) type.
        Canon = /*NEW_EXPR [operator new] NM=_ZnwjRKN5clang10ASTContextEj*/
        /*new (*this, TypeAlignment)*/ $new_uint_ASTContext$C_uint(/*Deref*/this, TypeAlignment, (type$ptr<?> New$Mem)->{
            return new DependentDecltypeType(/*Deref*/this, e);
         });
        DependentDecltypeTypes.InsertNode(Canon, InsertPos.$deref());
      }
      DependentDecltypeType /*P*/ $Canon = Canon;
      dt = /*NEW_EXPR [operator new] NM=_ZnwjRKN5clang10ASTContextEj*/
      /*new (*this, TypeAlignment)*/ $new_uint_ASTContext$C_uint(/*Deref*/this, TypeAlignment, (type$ptr<?> New$Mem)->{
          return new DecltypeType(e, new QualType(UnderlyingType), new QualType((DecltypeType /*P*/ )$Canon, 0));
       });
    } else {
      dt = /*NEW_EXPR [operator new] NM=_ZnwjRKN5clang10ASTContextEj*/
      /*new (*this, TypeAlignment)*/ $new_uint_ASTContext$C_uint(/*Deref*/this, TypeAlignment, (type$ptr<?> New$Mem)->{
          return new DecltypeType(e, new QualType(UnderlyingType), getCanonicalType(/*NO_COPY*/UnderlyingType).$QualType());
       });
    }
    Types.push_back(dt);
    return new QualType(dt, 0);
  }

  
  /// \brief Unary type transforms
  
  /// getUnaryTransformationType - We don't unique these, since the memory
  /// savings are minimal and these are rare.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::getUnaryTransformType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp", line = 4002,
   FQN="clang::ASTContext::getUnaryTransformType", NM="_ZNK5clang10ASTContext21getUnaryTransformTypeENS_8QualTypeES1_NS_18UnaryTransformType7UTTKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZNK5clang10ASTContext21getUnaryTransformTypeENS_8QualTypeES1_NS_18UnaryTransformType7UTTKindE")
  //</editor-fold>
  public QualType getUnaryTransformType(QualType BaseType, 
                       QualType UnderlyingType, 
                       UnaryTransformType.UTTKind Kind) /*const*/ {
    UnaryTransformType /*P*/ ut = null;
    if (BaseType.$arrow().isDependentType()) {
      // Look in the folding set for an existing type.
      FoldingSetNodeID ID/*J*/= new FoldingSetNodeID();
      DependentUnaryTransformType.Profile(ID, getCanonicalType(/*NO_COPY*/BaseType).$QualType(), Kind);
      
      final type$ref<type$ptr<DependentUnaryTransformType /*P*/>/*void P*/ > InsertPos = create_type$null$ref(null);
      DependentUnaryTransformType /*P*/ Canon = DependentUnaryTransformTypes.FindNodeOrInsertPos(ID, InsertPos);
      if (!(Canon != null)) {
        // Build a new, canonical __underlying_type(type) type.
        Canon = /*NEW_EXPR [operator new] NM=_ZnwjRKN5clang10ASTContextEj*/
        /*new (*this, TypeAlignment)*/ $new_uint_ASTContext$C_uint(/*Deref*/this, TypeAlignment, (type$ptr<?> New$Mem)->{
            return new DependentUnaryTransformType(/*Deref*/this, getCanonicalType(/*NO_COPY*/BaseType).$QualType(), 
                    Kind);
         });
        DependentUnaryTransformTypes.InsertNode(Canon, InsertPos.$deref());
      }
      DependentUnaryTransformType /*P*/ $Canon = Canon;
      ut = /*NEW_EXPR [operator new] NM=_ZnwjRKN5clang10ASTContextEj*/
      /*new (*this, TypeAlignment)*/ $new_uint_ASTContext$C_uint(/*Deref*/this, TypeAlignment, (type$ptr<?> New$Mem)->{
          return new UnaryTransformType(new QualType(BaseType), 
                  new QualType(), Kind, 
                  new QualType($Canon, 0));
       });
    } else {
      QualType CanonType = getCanonicalType(/*NO_COPY*/UnderlyingType).$QualType();
      ut = /*NEW_EXPR [operator new] NM=_ZnwjRKN5clang10ASTContextEj*/
      /*new (*this, TypeAlignment)*/ $new_uint_ASTContext$C_uint(/*Deref*/this, TypeAlignment, (type$ptr<?> New$Mem)->{
          return new UnaryTransformType(new QualType(BaseType), 
                  new QualType(UnderlyingType), Kind, 
                  new QualType(CanonType));
       });
    }
    Types.push_back(ut);
    return new QualType(ut, 0);
  }

  
  /// \brief C++11 deduced auto type.
  
  /// getAutoType - Return the uniqued reference to the 'auto' type which has been
  /// deduced to the given type, or to the canonical undeduced 'auto' type, or the
  /// canonical deduced-but-dependent 'auto' type.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::getAutoType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp", line = 4040,
   FQN="clang::ASTContext::getAutoType", NM="_ZNK5clang10ASTContext11getAutoTypeENS_8QualTypeENS_15AutoTypeKeywordEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZNK5clang10ASTContext11getAutoTypeENS_8QualTypeENS_15AutoTypeKeywordEb")
  //</editor-fold>
  public QualType getAutoType(QualType DeducedType, AutoTypeKeyword Keyword, 
             boolean IsDependent) /*const*/ {
    if (DeducedType.isNull() && Keyword == AutoTypeKeyword.Auto && !IsDependent) {
      return getAutoDeductType();
  }

    // Look in the folding set for an existing type.
    final type$ref<type$ptr<AutoType /*P*/>/*void P*/ > InsertPos = create_type$null$ref(null);
    FoldingSetNodeID ID/*J*/= new FoldingSetNodeID();
    AutoType.Profile(ID, /*NO_COPY*/DeducedType, Keyword, IsDependent);
    {
      AutoType /*P*/ AT = AutoTypes.FindNodeOrInsertPos(ID, InsertPos);
      if ((AT != null)) {
        return new QualType(AT, 0);
      }
    }
  
    AutoType /*P*/ AT = /*NEW_EXPR [operator new] NM=_ZnwjRKN5clang10ASTContextEj*/
    /*new (*this, TypeAlignment)*/ $new_uint_ASTContext$C_uint(/*Deref*/this, TypeAlignment, (type$ptr<?> New$Mem)->{
        return new AutoType(new QualType(DeducedType), 
                Keyword, 
                IsDependent);
     });
    Types.push_back(AT);
    if ((InsertPos.$deref() != null)) {
      AutoTypes.InsertNode(AT, InsertPos.$deref());
    }
    return new QualType(AT, 0);
  }

  
  /// \brief C++11 deduction pattern for 'auto' type.
  
  /// getAutoDeductType - Get type pattern for deducing against 'auto'.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::getAutoDeductType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp", line = 4090,
   FQN="clang::ASTContext::getAutoDeductType", NM="_ZNK5clang10ASTContext17getAutoDeductTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZNK5clang10ASTContext17getAutoDeductTypeEv")
  //</editor-fold>
  public QualType getAutoDeductType() /*const*/ {
    if (AutoDeductTy.isNull()) {
      AutoDeductTy.$assignMove(new QualType(/*NEW_EXPR [operator new] NM=_ZnwjRKN5clang10ASTContextEj*/
              /*new (*this, TypeAlignment)*/ $new_uint_ASTContext$C_uint(/*Deref*/this, TypeAlignment, (type$ptr<?> New$Mem)->{
                  return new AutoType(new QualType(), AutoTypeKeyword.Auto, 
                          /*dependent*/ false);
               }), 
              0));
  }
    return new QualType(AutoDeductTy);
  }

  
  /// \brief C++11 deduction pattern for 'auto &&' type.
  
  /// getAutoRRefDeductType - Get type pattern for deducing against 'auto &&'.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::getAutoRRefDeductType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp", line = 4100,
   FQN="clang::ASTContext::getAutoRRefDeductType", NM="_ZNK5clang10ASTContext21getAutoRRefDeductTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZNK5clang10ASTContext21getAutoRRefDeductTypeEv")
  //</editor-fold>
  public QualType getAutoRRefDeductType() /*const*/ {
    if (AutoRRefDeductTy.isNull()) {
      AutoRRefDeductTy.$assignMove(getRValueReferenceType(getAutoDeductType()));
  }
    assert (!AutoRRefDeductTy.isNull()) : "can't build 'auto &&' pattern";
    return new QualType(AutoRRefDeductTy);
  }

  
  /// \brief Return the unique reference to the type for the specified TagDecl
  /// (struct/union/class/enum) decl.
  
  /// getTagDeclType - Return the unique reference to the type for the
  /// specified TagDecl (struct/union/class/enum) decl.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::getTagDeclType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp", line = 4109,
   FQN="clang::ASTContext::getTagDeclType", NM="_ZNK5clang10ASTContext14getTagDeclTypeEPKNS_7TagDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZNK5clang10ASTContext14getTagDeclTypeEPKNS_7TagDeclE")
  //</editor-fold>
  public QualType getTagDeclType(/*const*/ TagDecl /*P*/ Decl) /*const*/ {
    assert Native.$bool(Decl);
    // FIXME: What is the design on getTagDeclType when it requires casting
    // away const?  mutable?
    return getTypeDeclType(((/*const_cast*/TagDecl /*P*/ )(Decl)));
  }

  
  /// \brief Return the unique type for "size_t" (C99 7.17), defined in
  /// <stddef.h>.
  ///
  /// The sizeof operator requires this (C99 6.5.3.4p4).
  
  /// getSizeType - Return the unique type for "size_t" (C99 7.17), the result
  /// of the sizeof operator (C99 6.5.3.4p4). The value is target dependent and
  /// needs to agree with the definition in <stddef.h>.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::getSizeType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp", line = 4119,
   FQN="clang::ASTContext::getSizeType", NM="_ZNK5clang10ASTContext11getSizeTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZNK5clang10ASTContext11getSizeTypeEv")
  //</editor-fold>
  public CanQual<Type> getSizeType() /*const*/ {
    return getFromTargetType(Target.getSizeType().getValue());
  }

  
  /// \brief Return the unique type for "intmax_t" (C99 7.18.1.5), defined in
  /// <stdint.h>.
  
  /// getIntMaxType - Return the unique type for "intmax_t" (C99 7.18.1.5).
  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::getIntMaxType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp", line = 4124,
   FQN="clang::ASTContext::getIntMaxType", NM="_ZNK5clang10ASTContext13getIntMaxTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZNK5clang10ASTContext13getIntMaxTypeEv")
  //</editor-fold>
  public CanQual<Type> getIntMaxType() /*const*/ {
    return getFromTargetType(Target.getIntMaxType().getValue());
  }

  
  /// \brief Return the unique type for "uintmax_t" (C99 7.18.1.5), defined in
  /// <stdint.h>.
  
  /// getUIntMaxType - Return the unique type for "uintmax_t" (C99 7.18.1.5).
  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::getUIntMaxType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp", line = 4129,
   FQN="clang::ASTContext::getUIntMaxType", NM="_ZNK5clang10ASTContext14getUIntMaxTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZNK5clang10ASTContext14getUIntMaxTypeEv")
  //</editor-fold>
  public CanQual<Type> getUIntMaxType() /*const*/ {
    return getFromTargetType(Target.getUIntMaxType().getValue());
  }

  
  /// \brief Return the unique wchar_t type available in C++ (and available as
  /// __wchar_t as a Microsoft extension).
  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::getWCharType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ASTContext.h", line = 1341,
   FQN="clang::ASTContext::getWCharType", NM="_ZNK5clang10ASTContext12getWCharTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZNK5clang10ASTContext12getWCharTypeEv")
  //</editor-fold>
  public QualType getWCharType() /*const*/ {
    return WCharTy.$QualType();
  }

  
  /// \brief Return the type of wide characters. In C++, this returns the
  /// unique wchar_t type. In C99, this returns a type compatible with the type
  /// defined in <stddef.h> as defined by the target.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::getWideCharType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ASTContext.h", line = 1346,
   FQN="clang::ASTContext::getWideCharType", NM="_ZNK5clang10ASTContext15getWideCharTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZNK5clang10ASTContext15getWideCharTypeEv")
  //</editor-fold>
  public QualType getWideCharType() /*const*/ {
    return WideCharTy.$QualType();
  }

  
  /// \brief Return the type of "signed wchar_t".
  ///
  /// Used when in C++, as a GCC extension.
  
  /// getSignedWCharType - Return the type of "signed wchar_t".
  /// Used when in C++, as a GCC extension.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::getSignedWCharType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp", line = 4135,
   FQN="clang::ASTContext::getSignedWCharType", NM="_ZNK5clang10ASTContext18getSignedWCharTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZNK5clang10ASTContext18getSignedWCharTypeEv")
  //</editor-fold>
  public QualType getSignedWCharType() /*const*/ {
    // FIXME: derive from "Target" ?
    return WCharTy.$QualType();
  }

  
  /// \brief Return the type of "unsigned wchar_t".
  ///
  /// Used when in C++, as a GCC extension.
  
  /// getUnsignedWCharType - Return the type of "unsigned wchar_t".
  /// Used when in C++, as a GCC extension.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::getUnsignedWCharType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp", line = 4142,
   FQN="clang::ASTContext::getUnsignedWCharType", NM="_ZNK5clang10ASTContext20getUnsignedWCharTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZNK5clang10ASTContext20getUnsignedWCharTypeEv")
  //</editor-fold>
  public QualType getUnsignedWCharType() /*const*/ {
    // FIXME: derive from "Target" ?
    return UnsignedIntTy.$QualType();
  }

  
  /// \brief In C99, this returns a type compatible with the type
  /// defined in <stddef.h> as defined by the target.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::getWIntType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ASTContext.h", line = 1360,
   FQN="clang::ASTContext::getWIntType", NM="_ZNK5clang10ASTContext11getWIntTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZNK5clang10ASTContext11getWIntTypeEv")
  //</editor-fold>
  public QualType getWIntType() /*const*/ {
    return WIntTy.$QualType();
  }

  
  /// \brief Return a type compatible with "intptr_t" (C99 7.18.1.4),
  /// as defined by the target.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::getIntPtrType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp", line = 4147,
   FQN="clang::ASTContext::getIntPtrType", NM="_ZNK5clang10ASTContext13getIntPtrTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZNK5clang10ASTContext13getIntPtrTypeEv")
  //</editor-fold>
  public QualType getIntPtrType() /*const*/ {
    return getFromTargetType(Target.getIntPtrType().getValue()).$QualType();
  }

  
  /// \brief Return a type compatible with "uintptr_t" (C99 7.18.1.4),
  /// as defined by the target.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::getUIntPtrType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp", line = 4151,
   FQN="clang::ASTContext::getUIntPtrType", NM="_ZNK5clang10ASTContext14getUIntPtrTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZNK5clang10ASTContext14getUIntPtrTypeEv")
  //</editor-fold>
  public QualType getUIntPtrType() /*const*/ {
    return getCorrespondingUnsignedType(getIntPtrType());
  }

  
  /// \brief Return the unique type for "ptrdiff_t" (C99 7.17) defined in
  /// <stddef.h>. Pointer - pointer requires this (C99 6.5.6p9).
  
  /// getPointerDiffType - Return the unique type for "ptrdiff_t" (C99 7.17)
  /// defined in <stddef.h>. Pointer - pointer requires this (C99 6.5.6p9).
  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::getPointerDiffType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp", line = 4157,
   FQN="clang::ASTContext::getPointerDiffType", NM="_ZNK5clang10ASTContext18getPointerDiffTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZNK5clang10ASTContext18getPointerDiffTypeEv")
  //</editor-fold>
  public QualType getPointerDiffType() /*const*/ {
    return getFromTargetType(Target.getPtrDiffType(0).getValue()).$QualType();
  }

  
  /// \brief Return the unique type for "pid_t" defined in
  /// <sys/types.h>. We need this to compute the correct type for vfork().
  
  /// \brief Return the unique type for "pid_t" defined in
  /// <sys/types.h>. We need this to compute the correct type for vfork().
  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::getProcessIDType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp", line = 4163,
   FQN="clang::ASTContext::getProcessIDType", NM="_ZNK5clang10ASTContext16getProcessIDTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZNK5clang10ASTContext16getProcessIDTypeEv")
  //</editor-fold>
  public QualType getProcessIDType() /*const*/ {
    return getFromTargetType(Target.getProcessIDType().getValue()).$QualType();
  }

  
  /// \brief Return the C structure type used to represent constant CFStrings.
  
  // getCFConstantStringType - Return the type used for constant CFStrings.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::getCFConstantStringType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp", line = 4942,
   FQN="clang::ASTContext::getCFConstantStringType", NM="_ZNK5clang10ASTContext23getCFConstantStringTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZNK5clang10ASTContext23getCFConstantStringTypeEv")
  //</editor-fold>
  public QualType getCFConstantStringType() /*const*/ {
    return getTypedefType(getCFConstantStringDecl());
  }

  
  /// \brief Returns the C struct type for objc_super
  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::getObjCSuperType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp", line = 4946,
   FQN="clang::ASTContext::getObjCSuperType", NM="_ZNK5clang10ASTContext16getObjCSuperTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZNK5clang10ASTContext16getObjCSuperTypeEv")
  //</editor-fold>
  public QualType getObjCSuperType() /*const*/ {
    if (ObjCSuperType.isNull()) {
      RecordDecl /*P*/ ObjCSuperTypeDecl = buildImplicitRecord(new StringRef(/*KEEP_STR*/"objc_super"));
      TUDecl.addDecl(ObjCSuperTypeDecl);
      ObjCSuperType.$assignMove(getTagDeclType(ObjCSuperTypeDecl));
  }
    return new QualType(ObjCSuperType);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::setObjCSuperType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ASTContext.h", line = 1383,
   FQN="clang::ASTContext::setObjCSuperType", NM="_ZN5clang10ASTContext16setObjCSuperTypeENS_8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZN5clang10ASTContext16setObjCSuperTypeENS_8QualTypeE")
  //</editor-fold>
  public void setObjCSuperType(QualType ST) {
    ObjCSuperType.$assign(ST);
  }

  
  /// Get the structure type used to representation CFStrings, or NULL
  /// if it hasn't yet been built.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::getRawCFConstantStringType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ASTContext.h", line = 1387,
   FQN="clang::ASTContext::getRawCFConstantStringType", NM="_ZNK5clang10ASTContext26getRawCFConstantStringTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZNK5clang10ASTContext26getRawCFConstantStringTypeEv")
  //</editor-fold>
  public QualType getRawCFConstantStringType() /*const*/ {
    if ((CFConstantStringTypeDecl != null)) {
      return getTypedefType(CFConstantStringTypeDecl);
  }
    return new QualType();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::setCFConstantStringType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp", line = 4955,
   FQN="clang::ASTContext::setCFConstantStringType", NM="_ZN5clang10ASTContext23setCFConstantStringTypeENS_8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZN5clang10ASTContext23setCFConstantStringTypeENS_8QualTypeE")
  //</editor-fold>
  public void setCFConstantStringType(QualType T) {
    /*const*/ TypedefType /*P*/ TD = T.$arrow().getAs$TypedefType();
    assert ((TD != null)) : "Invalid CFConstantStringType";
    CFConstantStringTypeDecl = cast_TypedefDecl(TD.getDecl());
    /*const*/ RecordType /*P*/ TagType = CFConstantStringTypeDecl.getUnderlyingType().$arrow().getAs$RecordType();
    assert ((TagType != null)) : "Invalid CFConstantStringType";
    CFConstantStringTagDecl = TagType.getDecl();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::getCFConstantStringDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp", line = 4887,
   FQN="clang::ASTContext::getCFConstantStringDecl", NM="_ZNK5clang10ASTContext23getCFConstantStringDeclEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZNK5clang10ASTContext23getCFConstantStringDeclEv")
  //</editor-fold>
  public TypedefDecl /*P*/ getCFConstantStringDecl() /*const*/ {
    if (!(CFConstantStringTypeDecl != null)) {
      assert (!(CFConstantStringTagDecl != null)) : "tag and typedef should be initialized together";
      CFConstantStringTagDecl = buildImplicitRecord(new StringRef(/*KEEP_STR*/"__NSConstantString_tag"));
      CFConstantStringTagDecl.startDefinition();
      
      QualType FieldTypes[/*4*/]/*J*/= new$T(new QualType [4], ()->new QualType());
      type$ptr</*const*/char$ptr/*char P*/ /*[4]*/> FieldNames = create_type$ptr(new$T(new /*const*/char$ptr/*char P*/  [4], ()->create_char$ptr()));
      
      // const int *isa;
      FieldTypes[0].$assignMove(getPointerType(IntTy.withConst()));
      FieldNames.$set(0, $("isa"));
      // int flags;
      FieldTypes[1].$assignMove(IntTy.$QualType());
      FieldNames.$set(1, $("flags"));
      // const char *str;
      FieldTypes[2].$assignMove(getPointerType(CharTy.withConst()));
      FieldNames.$set(2, $("str"));
      // long length;
      FieldTypes[3].$assignMove(LongTy.$QualType());
      FieldNames.$set(3, $("length"));
      
      // Create fields
      for (/*uint*/int i = 0; $less_uint(i, 4); ++i) {
        FieldDecl /*P*/ Field = FieldDecl.Create(/*Deref*/this, CFConstantStringTagDecl, 
            new SourceLocation(), 
            new SourceLocation(), 
            $AddrOf(Idents.get(new StringRef(FieldNames.$at(i)))), 
            new QualType(FieldTypes[i]), /*TInfo=*/ (TypeSourceInfo /*P*/ )null, 
            /*BitWidth=*/ (Expr /*P*/ )null, 
            /*Mutable=*/ false, 
            InClassInitStyle.ICIS_NoInit);
        Field.setAccess(AccessSpecifier.AS_public);
        CFConstantStringTagDecl.addDecl(Field);
      }
      
      CFConstantStringTagDecl.completeDefinition();
      // This type is designed to be compatible with NSConstantString, but cannot
      // use the same name, since NSConstantString is an interface.
      QualType tagType = getTagDeclType(CFConstantStringTagDecl);
      CFConstantStringTypeDecl
         = buildImplicitTypedef(new QualType(tagType), new StringRef(/*KEEP_STR*/"__NSConstantString"));
    }
    
    return CFConstantStringTypeDecl;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::getCFConstantStringTagDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp", line = 4935,
   FQN="clang::ASTContext::getCFConstantStringTagDecl", NM="_ZNK5clang10ASTContext26getCFConstantStringTagDeclEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZNK5clang10ASTContext26getCFConstantStringTagDeclEv")
  //</editor-fold>
  public RecordDecl /*P*/ getCFConstantStringTagDecl() /*const*/ {
    if (!(CFConstantStringTagDecl != null)) {
      getCFConstantStringDecl(); // Build the tag and the typedef.
  }
    return CFConstantStringTagDecl;
  }

  
  // This setter/getter represents the ObjC type for an NSConstantString.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::setObjCConstantStringInterface">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp", line = 6523,
   FQN="clang::ASTContext::setObjCConstantStringInterface", NM="_ZN5clang10ASTContext30setObjCConstantStringInterfaceEPNS_17ObjCInterfaceDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZN5clang10ASTContext30setObjCConstantStringInterfaceEPNS_17ObjCInterfaceDeclE")
  //</editor-fold>
  public void setObjCConstantStringInterface(ObjCInterfaceDecl /*P*/ Decl) {
    assert (ObjCConstantStringType.isNull()) : "'NSConstantString' type already set!";
    
    ObjCConstantStringType.$assignMove(getObjCInterfaceType(Decl));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::getObjCConstantStringInterface">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ASTContext.h", line = 1398,
   FQN="clang::ASTContext::getObjCConstantStringInterface", NM="_ZNK5clang10ASTContext30getObjCConstantStringInterfaceEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZNK5clang10ASTContext30getObjCConstantStringInterfaceEv")
  //</editor-fold>
  public QualType getObjCConstantStringInterface() /*const*/ {
    return new QualType(ObjCConstantStringType);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::getObjCNSStringType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ASTContext.h", line = 1402,
   FQN="clang::ASTContext::getObjCNSStringType", NM="_ZNK5clang10ASTContext19getObjCNSStringTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZNK5clang10ASTContext19getObjCNSStringTypeEv")
  //</editor-fold>
  public QualType getObjCNSStringType() /*const*/ {
    return new QualType(ObjCNSStringType);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::setObjCNSStringType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ASTContext.h", line = 1406,
   FQN="clang::ASTContext::setObjCNSStringType", NM="_ZN5clang10ASTContext19setObjCNSStringTypeENS_8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZN5clang10ASTContext19setObjCNSStringTypeENS_8QualTypeE")
  //</editor-fold>
  public void setObjCNSStringType(QualType T) {
    ObjCNSStringType.$assign(T);
  }

  
  /// \brief Retrieve the type that \c id has been defined to, which may be
  /// different from the built-in \c id if \c id has been typedef'd.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::getObjCIdRedefinitionType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ASTContext.h", line = 1412,
   FQN="clang::ASTContext::getObjCIdRedefinitionType", NM="_ZNK5clang10ASTContext25getObjCIdRedefinitionTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZNK5clang10ASTContext25getObjCIdRedefinitionTypeEv")
  //</editor-fold>
  public QualType getObjCIdRedefinitionType() /*const*/ {
    if (ObjCIdRedefinitionType.isNull()) {
      return getObjCIdType();
  }
    return new QualType(ObjCIdRedefinitionType);
  }

  
  /// \brief Set the user-written type that redefines \c id.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::setObjCIdRedefinitionType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ASTContext.h", line = 1419,
   FQN="clang::ASTContext::setObjCIdRedefinitionType", NM="_ZN5clang10ASTContext25setObjCIdRedefinitionTypeENS_8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZN5clang10ASTContext25setObjCIdRedefinitionTypeENS_8QualTypeE")
  //</editor-fold>
  public void setObjCIdRedefinitionType(QualType RedefType) {
    ObjCIdRedefinitionType.$assign(RedefType);
  }

  
  /// \brief Retrieve the type that \c Class has been defined to, which may be
  /// different from the built-in \c Class if \c Class has been typedef'd.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::getObjCClassRedefinitionType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ASTContext.h", line = 1425,
   FQN="clang::ASTContext::getObjCClassRedefinitionType", NM="_ZNK5clang10ASTContext28getObjCClassRedefinitionTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZNK5clang10ASTContext28getObjCClassRedefinitionTypeEv")
  //</editor-fold>
  public QualType getObjCClassRedefinitionType() /*const*/ {
    if (ObjCClassRedefinitionType.isNull()) {
      return getObjCClassType();
  }
    return new QualType(ObjCClassRedefinitionType);
  }

  
  /// \brief Set the user-written type that redefines 'SEL'.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::setObjCClassRedefinitionType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ASTContext.h", line = 1432,
   FQN="clang::ASTContext::setObjCClassRedefinitionType", NM="_ZN5clang10ASTContext28setObjCClassRedefinitionTypeENS_8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZN5clang10ASTContext28setObjCClassRedefinitionTypeENS_8QualTypeE")
  //</editor-fold>
  public void setObjCClassRedefinitionType(QualType RedefType) {
    ObjCClassRedefinitionType.$assign(RedefType);
  }

  
  /// \brief Retrieve the type that 'SEL' has been defined to, which may be
  /// different from the built-in 'SEL' if 'SEL' has been typedef'd.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::getObjCSelRedefinitionType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ASTContext.h", line = 1438,
   FQN="clang::ASTContext::getObjCSelRedefinitionType", NM="_ZNK5clang10ASTContext26getObjCSelRedefinitionTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZNK5clang10ASTContext26getObjCSelRedefinitionTypeEv")
  //</editor-fold>
  public QualType getObjCSelRedefinitionType() /*const*/ {
    if (ObjCSelRedefinitionType.isNull()) {
      return getObjCSelType();
  }
    return new QualType(ObjCSelRedefinitionType);
  }

  
  /// \brief Set the user-written type that redefines 'SEL'.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::setObjCSelRedefinitionType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ASTContext.h", line = 1446,
   FQN="clang::ASTContext::setObjCSelRedefinitionType", NM="_ZN5clang10ASTContext26setObjCSelRedefinitionTypeENS_8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZN5clang10ASTContext26setObjCSelRedefinitionTypeENS_8QualTypeE")
  //</editor-fold>
  public void setObjCSelRedefinitionType(QualType RedefType) {
    ObjCSelRedefinitionType.$assign(RedefType);
  }

  
  /// Retrieve the identifier 'NSObject'.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::getNSObjectName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ASTContext.h", line = 1451,
   FQN="clang::ASTContext::getNSObjectName", NM="_ZN5clang10ASTContext15getNSObjectNameEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZN5clang10ASTContext15getNSObjectNameEv")
  //</editor-fold>
  public IdentifierInfo /*P*/ getNSObjectName() {
    if (!(NSObjectName != null)) {
      NSObjectName = $AddrOf(Idents.get(new StringRef(/*KEEP_STR*/"NSObject")));
    }
    
    return NSObjectName;
  }

  
  /// Retrieve the identifier 'NSCopying'.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::getNSCopyingName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ASTContext.h", line = 1460,
   FQN="clang::ASTContext::getNSCopyingName", NM="_ZN5clang10ASTContext16getNSCopyingNameEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZN5clang10ASTContext16getNSCopyingNameEv")
  //</editor-fold>
  public IdentifierInfo /*P*/ getNSCopyingName() {
    if (!(NSCopyingName != null)) {
      NSCopyingName = $AddrOf(Idents.get(new StringRef(/*KEEP_STR*/"NSCopying")));
    }
    
    return NSCopyingName;
  }

  
  /// Retrieve the identifier 'bool'.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::getBoolName">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*change to use char$ptr constant*/,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ASTContext.h", line = 1469,
   FQN="clang::ASTContext::getBoolName", NM="_ZNK5clang10ASTContext11getBoolNameEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZNK5clang10ASTContext11getBoolNameEv")
  //</editor-fold>
  public IdentifierInfo /*P*/ getBoolName() /*const*/ {
    if (!(BoolName != null)) {
      BoolName = $AddrOf(Idents.get(/*KEEP_STR*/$bool.$array(), $bool.$index(), strlen($bool.$array(), $bool.$index())));
    }
    return BoolName;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::getMakeIntegerSeqName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ASTContext.h", line = 1475,
   FQN="clang::ASTContext::getMakeIntegerSeqName", NM="_ZNK5clang10ASTContext21getMakeIntegerSeqNameEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZNK5clang10ASTContext21getMakeIntegerSeqNameEv")
  //</editor-fold>
  public IdentifierInfo /*P*/ getMakeIntegerSeqName() /*const*/ {
    if (!(MakeIntegerSeqName != null)) {
      MakeIntegerSeqName = $AddrOf(Idents.get(new StringRef(/*KEEP_STR*/"__make_integer_seq")));
    }
    return MakeIntegerSeqName;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::getTypePackElementName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ASTContext.h", line = 1481,
   FQN="clang::ASTContext::getTypePackElementName", NM="_ZNK5clang10ASTContext22getTypePackElementNameEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZNK5clang10ASTContext22getTypePackElementNameEv")
  //</editor-fold>
  public IdentifierInfo /*P*/ getTypePackElementName() /*const*/ {
    if (!(TypePackElementName != null)) {
      TypePackElementName = $AddrOf(Idents.get(new StringRef(/*KEEP_STR*/"__type_pack_element")));
    }
    return TypePackElementName;
  }

  
  /// \brief Retrieve the Objective-C "instancetype" type, if already known;
  /// otherwise, returns a NULL type;
  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::getObjCInstanceType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ASTContext.h", line = 1489,
   FQN="clang::ASTContext::getObjCInstanceType", NM="_ZN5clang10ASTContext19getObjCInstanceTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZN5clang10ASTContext19getObjCInstanceTypeEv")
  //</editor-fold>
  public QualType getObjCInstanceType() {
    return getTypeDeclType(getObjCInstanceTypeDecl());
  }

  
  /// \brief Retrieve the typedef declaration corresponding to the Objective-C
  /// "instancetype" type.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::getObjCInstanceTypeDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp", line = 5101,
   FQN="clang::ASTContext::getObjCInstanceTypeDecl", NM="_ZN5clang10ASTContext23getObjCInstanceTypeDeclEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZN5clang10ASTContext23getObjCInstanceTypeDeclEv")
  //</editor-fold>
  public TypedefDecl /*P*/ getObjCInstanceTypeDecl() {
    if (!(ObjCInstanceTypeDecl != null)) {
      ObjCInstanceTypeDecl
         = buildImplicitTypedef(getObjCIdType(), new StringRef(/*KEEP_STR*/"instancetype"));
    }
    return ObjCInstanceTypeDecl;
  }

  
  /// \brief Set the type for the C FILE type.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::setFILEDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ASTContext.h", line = 1498,
   FQN="clang::ASTContext::setFILEDecl", NM="_ZN5clang10ASTContext11setFILEDeclEPNS_8TypeDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZN5clang10ASTContext11setFILEDeclEPNS_8TypeDeclE")
  //</editor-fold>
  public void setFILEDecl(TypeDecl /*P*/ FILEDecl) {
    this.FILEDecl = FILEDecl;
  }

  
  /// \brief Retrieve the C FILE type.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::getFILEType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ASTContext.h", line = 1501,
   FQN="clang::ASTContext::getFILEType", NM="_ZNK5clang10ASTContext11getFILETypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZNK5clang10ASTContext11getFILETypeEv")
  //</editor-fold>
  public QualType getFILEType() /*const*/ {
    if ((FILEDecl != null)) {
      return getTypeDeclType(FILEDecl);
    }
    return new QualType();
  }

  
  /// \brief Set the type for the C jmp_buf type.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::setjmp_bufDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ASTContext.h", line = 1508,
   FQN="clang::ASTContext::setjmp_bufDecl", NM="_ZN5clang10ASTContext14setjmp_bufDeclEPNS_8TypeDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZN5clang10ASTContext14setjmp_bufDeclEPNS_8TypeDeclE")
  //</editor-fold>
  public void setjmp_bufDecl(TypeDecl /*P*/ jmp_bufDecl) {
    this.jmp_bufDecl = jmp_bufDecl;
  }

  
  /// \brief Retrieve the C jmp_buf type.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::getjmp_bufType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ASTContext.h", line = 1513,
   FQN="clang::ASTContext::getjmp_bufType", NM="_ZNK5clang10ASTContext14getjmp_bufTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZNK5clang10ASTContext14getjmp_bufTypeEv")
  //</editor-fold>
  public QualType getjmp_bufType() /*const*/ {
    if ((jmp_bufDecl != null)) {
      return getTypeDeclType(jmp_bufDecl);
    }
    return new QualType();
  }

  
  /// \brief Set the type for the C sigjmp_buf type.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::setsigjmp_bufDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ASTContext.h", line = 1520,
   FQN="clang::ASTContext::setsigjmp_bufDecl", NM="_ZN5clang10ASTContext17setsigjmp_bufDeclEPNS_8TypeDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZN5clang10ASTContext17setsigjmp_bufDeclEPNS_8TypeDeclE")
  //</editor-fold>
  public void setsigjmp_bufDecl(TypeDecl /*P*/ sigjmp_bufDecl) {
    this.sigjmp_bufDecl = sigjmp_bufDecl;
  }

  
  /// \brief Retrieve the C sigjmp_buf type.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::getsigjmp_bufType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ASTContext.h", line = 1525,
   FQN="clang::ASTContext::getsigjmp_bufType", NM="_ZNK5clang10ASTContext17getsigjmp_bufTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZNK5clang10ASTContext17getsigjmp_bufTypeEv")
  //</editor-fold>
  public QualType getsigjmp_bufType() /*const*/ {
    if ((sigjmp_bufDecl != null)) {
      return getTypeDeclType(sigjmp_bufDecl);
    }
    return new QualType();
  }

  
  /// \brief Set the type for the C ucontext_t type.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::setucontext_tDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ASTContext.h", line = 1532,
   FQN="clang::ASTContext::setucontext_tDecl", NM="_ZN5clang10ASTContext17setucontext_tDeclEPNS_8TypeDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZN5clang10ASTContext17setucontext_tDeclEPNS_8TypeDeclE")
  //</editor-fold>
  public void setucontext_tDecl(TypeDecl /*P*/ ucontext_tDecl) {
    this.ucontext_tDecl = ucontext_tDecl;
  }

  
  /// \brief Retrieve the C ucontext_t type.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::getucontext_tType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ASTContext.h", line = 1537,
   FQN="clang::ASTContext::getucontext_tType", NM="_ZNK5clang10ASTContext17getucontext_tTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZNK5clang10ASTContext17getucontext_tTypeEv")
  //</editor-fold>
  public QualType getucontext_tType() /*const*/ {
    if ((ucontext_tDecl != null)) {
      return getTypeDeclType(ucontext_tDecl);
    }
    return new QualType();
  }

  
  /// \brief The result type of logical operations, '<', '>', '!=', etc.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::getLogicalOperationType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ASTContext.h", line = 1544,
   FQN="clang::ASTContext::getLogicalOperationType", NM="_ZNK5clang10ASTContext23getLogicalOperationTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZNK5clang10ASTContext23getLogicalOperationTypeEv")
  //</editor-fold>
  public QualType getLogicalOperationType() /*const*/ {
    return (getLangOpts().CPlusPlus ? BoolTy : IntTy).$QualType();
  }

  
  /// \brief Emit the Objective-CC type encoding for the given type \p T into
  /// \p S.
  ///
  /// If \p Field is specified then record field names are also encoded.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::getObjCEncodingForType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp", line = 5465,
   FQN="clang::ASTContext::getObjCEncodingForType", NM="_ZNK5clang10ASTContext22getObjCEncodingForTypeENS_8QualTypeERSsPKNS_9FieldDeclEPS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZNK5clang10ASTContext22getObjCEncodingForTypeENS_8QualTypeERSsPKNS_9FieldDeclEPS1_")
  //</editor-fold>
  public void getObjCEncodingForType(QualType T, final std.string/*&*/ S) /*const*/ {
    getObjCEncodingForType(T, S, 
                        (/*const*/ FieldDecl /*P*/ )null, 
                        (QualType /*P*/)null);
  }
  public void getObjCEncodingForType(QualType T, final std.string/*&*/ S, 
                        /*const*/ FieldDecl /*P*/ Field/*= null*/) /*const*/ {
    getObjCEncodingForType(T, S, 
                        Field, 
                        (QualType /*P*/)null);
  }
  public void getObjCEncodingForType(QualType T, final std.string/*&*/ S, 
                        /*const*/ FieldDecl /*P*/ Field/*= null*/, 
                        QualType /*P*/ NotEncodedT/*= null*/) /*const*/ {
    // We follow the behavior of gcc, expanding structures which are
    // directly pointed to, and expanding embedded structures. Note that
    // these rules are sufficient to prevent recursive encoding of the
    // same type.
    getObjCEncodingForTypeImpl(new QualType(T), S, true, true, Field, 
        true/* outermost type */, false, false, 
        false, false, false, NotEncodedT);
  }

  
  /// \brief Emit the Objective-C property type encoding for the given
  /// type \p T into \p S.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::getObjCEncodingForPropertyType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp", line = 5477,
   FQN="clang::ASTContext::getObjCEncodingForPropertyType", NM="_ZNK5clang10ASTContext30getObjCEncodingForPropertyTypeENS_8QualTypeERSs",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZNK5clang10ASTContext30getObjCEncodingForPropertyTypeENS_8QualTypeERSs")
  //</editor-fold>
  public void getObjCEncodingForPropertyType(QualType T, 
                                final std.string/*&*/ S) /*const*/ {
    // Encode result type.
    // GCC has some special rules regarding encoding of properties which
    // closely resembles encoding of ivars.
    getObjCEncodingForTypeImpl(new QualType(T), S, true, true, (/*const*/ FieldDecl /*P*/ )null, 
        true/* outermost type */, 
        true/* encoding property */);
  }


    
  /// getLegacyIntegralTypeEncoding -
  /// Another legacy compatibility encoding: 32-bit longs are encoded as
  /// 'l' or 'L' , but not always.  For typedefs, we need to use
  /// 'i' or 'I' instead if encoding a struct field, or a pointer!
  ///
  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::getLegacyIntegralTypeEncoding">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp", line = 5453,
   FQN="clang::ASTContext::getLegacyIntegralTypeEncoding", NM="_ZNK5clang10ASTContext29getLegacyIntegralTypeEncodingERNS_8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZNK5clang10ASTContext29getLegacyIntegralTypeEncodingERNS_8QualTypeE")
  //</editor-fold>
  public void getLegacyIntegralTypeEncoding(final QualType /*&*/ PointeeTy) /*const*/ {
    if (isa_TypedefType(PointeeTy.getTypePtr())) {
      {
        /*const*/ BuiltinType /*P*/ BT = PointeeTy.$arrow().getAs$BuiltinType();
        if ((BT != null)) {
          if (BT.getKind() == BuiltinType.Kind.ULong && getIntWidth(new QualType(PointeeTy)) == 32) {
            PointeeTy.$assignMove(UnsignedIntTy.$QualType());
          } else if (BT.getKind() == BuiltinType.Kind.Long && getIntWidth(new QualType(PointeeTy)) == 32) {
            PointeeTy.$assignMove(IntTy.$QualType());
          }
        }
      }
    }
  }

  
  /// \brief Put the string version of the type qualifiers \p QT into \p S.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::getObjCEncodingForTypeQualifier">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp", line = 6107,
   FQN="clang::ASTContext::getObjCEncodingForTypeQualifier", NM="_ZNK5clang10ASTContext31getObjCEncodingForTypeQualifierENS_4Decl17ObjCDeclQualifierERSs",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZNK5clang10ASTContext31getObjCEncodingForTypeQualifierENS_4Decl17ObjCDeclQualifierERSs")
  //</editor-fold>
  public void getObjCEncodingForTypeQualifier(/*Decl::ObjCDeclQualifier*//*uint*/int QT, 
                                 final std.string/*&*/ S) /*const*/ {
    if (((QT & Decl.ObjCDeclQualifier.OBJC_TQ_In) != 0)) {
      S.$addassign_T($$n);
    }
    if (((QT & Decl.ObjCDeclQualifier.OBJC_TQ_Inout) != 0)) {
      S.$addassign_T($$N);
    }
    if (((QT & Decl.ObjCDeclQualifier.OBJC_TQ_Out) != 0)) {
      S.$addassign_T($$o);
    }
    if (((QT & Decl.ObjCDeclQualifier.OBJC_TQ_Bycopy) != 0)) {
      S.$addassign_T($$O);
    }
    if (((QT & Decl.ObjCDeclQualifier.OBJC_TQ_Byref) != 0)) {
      S.$addassign_T($$R);
    }
    if (((QT & Decl.ObjCDeclQualifier.OBJC_TQ_Oneway) != 0)) {
      S.$addassign_T($$V);
    }
  }
  

  /// \brief Emit the encoded type for the function \p Decl into \p S.
  ///
  /// This is in the same format as Objective-C method encodings.
  ///
  /// \returns true if an error occurred (e.g., because one of the parameter
  /// types is incomplete), false otherwise.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::getObjCEncodingForFunctionDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp", line = 5226,
   FQN="clang::ASTContext::getObjCEncodingForFunctionDecl", NM="_ZN5clang10ASTContext30getObjCEncodingForFunctionDeclEPKNS_12FunctionDeclERSs",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZN5clang10ASTContext30getObjCEncodingForFunctionDeclEPKNS_12FunctionDeclERSs")
  //</editor-fold>
  public boolean getObjCEncodingForFunctionDecl(/*const*/ FunctionDecl /*P*/ Decl, 
                                final std.string/*&*/ S) {
    // Encode result type.
    getObjCEncodingForType(Decl.getReturnType(), S);
    CharUnits ParmOffset/*J*/= new CharUnits();
    // Compute size of all parameters.
    for (ParmVarDecl /*P*/ PI : Decl.parameters$Const()) {
      QualType PType = PI.getType();
      CharUnits sz = getObjCEncodingTypeSize(new QualType(PType));
      if (sz.isZero()) {
        continue;
      }
      assert (sz.isPositive()) : "getObjCEncodingForFunctionDecl - Incomplete param type";
      ParmOffset.$addassign(sz);
    }
    S.$addassign(charUnitsToString(ParmOffset));
    ParmOffset.$assignMove(CharUnits.Zero());
    
    // Argument types.
    for (ParmVarDecl /*P*/ PVDecl : Decl.parameters$Const()) {
      QualType PType = PVDecl.getOriginalType();
      {
        /*const*/ ArrayType /*P*/ AT = dyn_cast_ArrayType(PType.$arrow().getCanonicalTypeInternal());
        if ((AT != null)) {
          // Use array's original type only if it has known number of
          // elements.
          if (!isa_ConstantArrayType(AT)) {
            PType.$assignMove(PVDecl.getType());
          }
        } else if (PType.$arrow().isFunctionType()) {
          PType.$assignMove(PVDecl.getType());
        }
      }
      getObjCEncodingForType(new QualType(PType), S);
      S.$addassign(charUnitsToString(ParmOffset));
      ParmOffset.$addassign(getObjCEncodingTypeSize(new QualType(PType)));
    }
    
    return false;
  }

  
  /// \brief Emit the encoded type for the method declaration \p Decl into
  /// \p S.
  ///
  /// \returns true if an error occurred (e.g., because one of the parameter
  /// types is incomplete), false otherwise.
  
  /// getObjCEncodingForMethodDecl - Return the encoded type for this method
  /// declaration.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::getObjCEncodingForMethodDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp", line = 5283,
   FQN="clang::ASTContext::getObjCEncodingForMethodDecl", NM="_ZNK5clang10ASTContext28getObjCEncodingForMethodDeclEPKNS_14ObjCMethodDeclERSsb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZNK5clang10ASTContext28getObjCEncodingForMethodDeclEPKNS_14ObjCMethodDeclERSsb")
  //</editor-fold>
  public boolean getObjCEncodingForMethodDecl(/*const*/ ObjCMethodDecl /*P*/ Decl, 
                              final std.string/*&*/ S) /*const*/ {
    return getObjCEncodingForMethodDecl(Decl, 
                              S, 
                              false);
  }
  public boolean getObjCEncodingForMethodDecl(/*const*/ ObjCMethodDecl /*P*/ Decl, 
                              final std.string/*&*/ S, 
                              boolean Extended/*= false*/) /*const*/ {
    // FIXME: This is not very efficient.
    // Encode return type.
    getObjCEncodingForMethodParameter(Decl.getObjCDeclQualifier(), 
        Decl.getReturnType(), S, Extended);
    // Compute size of all parameters.
    // Start with computing size of a pointer in number of bytes.
    // FIXME: There might(should) be a better way of doing this computation!
    SourceLocation Loc/*J*/= new SourceLocation();
    CharUnits PtrSize = getTypeSizeInChars(VoidPtrTy.$QualType());
    // The first two arguments (self and _cmd) are pointers; account for
    // their size.
    CharUnits ParmOffset = $star_long_CharUnits$C(2, PtrSize);
    for (type$ptr</*const*/ ParmVarDecl /*P*/ /*const*/ /*P*/> PI = $tryClone(Decl.param_begin$Const()), 
        /*P*/ /*const*/ /*P*/ E = $tryClone(Decl.sel_param_end()); $noteq_ptr(PI, E); PI.$preInc()) {
      QualType PType = (PI.$star()).getType();
      CharUnits sz = getObjCEncodingTypeSize(new QualType(PType));
      if (sz.isZero()) {
        continue;
      }
      assert (sz.isPositive()) : "getObjCEncodingForMethodDecl - Incomplete param type";
      ParmOffset.$addassign(sz);
    }
    S.$addassign(charUnitsToString(ParmOffset));
    S.$addassign_T$C$P(/*KEEP_STR*/"@0:");
    S.$addassign(charUnitsToString(PtrSize));
    
    // Argument types.
    ParmOffset.$assignMove($star_long_CharUnits$C(2, PtrSize));
    for (type$ptr</*const*/ ParmVarDecl /*P*/ /*const*/ /*P*/> PI = $tryClone(Decl.param_begin$Const()), 
        /*P*/ /*const*/ /*P*/ E = $tryClone(Decl.sel_param_end()); $noteq_ptr(PI, E); PI.$preInc()) {
      /*const*/ ParmVarDecl /*P*/ PVDecl = PI.$star();
      QualType PType = PVDecl.getOriginalType();
      {
        /*const*/ ArrayType /*P*/ AT = dyn_cast_ArrayType(PType.$arrow().getCanonicalTypeInternal());
        if ((AT != null)) {
          // Use array's original type only if it has known number of
          // elements.
          if (!isa_ConstantArrayType(AT)) {
            PType.$assignMove(PVDecl.getType());
          }
        } else if (PType.$arrow().isFunctionType()) {
          PType.$assignMove(PVDecl.getType());
        }
      }
      getObjCEncodingForMethodParameter(PVDecl.getObjCDeclQualifier(), 
          new QualType(PType), S, Extended);
      S.$addassign(charUnitsToString(ParmOffset));
      ParmOffset.$addassign(getObjCEncodingTypeSize(new QualType(PType)));
    }
    
    return false;
  }  

  
  /// \brief Return the encoded type for this block declaration.
  
  /// getObjCEncodingForBlock - Return the encoded type for this block
  /// declaration.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::getObjCEncodingForBlock">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp", line = 5170,
   FQN="clang::ASTContext::getObjCEncodingForBlock", NM="_ZNK5clang10ASTContext23getObjCEncodingForBlockEPKNS_9BlockExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZNK5clang10ASTContext23getObjCEncodingForBlockEPKNS_9BlockExprE")
  //</editor-fold>
  public std.string getObjCEncodingForBlock(/*const*/ BlockExpr /*P*/ Expr) /*const*/ {
    std.string S/*J*/= new std.string();
    
    /*const*/ BlockDecl /*P*/ _Decl = Expr.getBlockDecl$Const();
    QualType BlockTy = Expr.getType().$arrow().getAs(BlockPointerType.class).getPointeeType();
    // Encode result type.
    if (getLangOpts().EncodeExtendedBlockSig) {
      getObjCEncodingForMethodParameter(Decl.ObjCDeclQualifier.OBJC_TQ_None, BlockTy.$arrow().getAs(FunctionType.class).getReturnType(), S, 
          true/*Extended*/);
    } else {
      getObjCEncodingForType(BlockTy.$arrow().getAs(FunctionType.class).getReturnType(), S);
    }
    // Compute size of all parameters.
    // Start with computing size of a pointer in number of bytes.
    // FIXME: There might(should) be a better way of doing this computation!
    SourceLocation Loc/*J*/= new SourceLocation();
    CharUnits PtrSize = getTypeSizeInChars(VoidPtrTy.$QualType());
    CharUnits ParmOffset = new CharUnits(PtrSize);
    for (ParmVarDecl /*P*/ PI : _Decl.parameters$Const()) {
      QualType PType = PI.getType();
      CharUnits sz = getObjCEncodingTypeSize(new QualType(PType));
      if (sz.isZero()) {
        continue;
      }
      assert (sz.isPositive()) : "BlockExpr - Incomplete param type";
      ParmOffset.$addassign(sz);
    }
    // Size of the argument frame
    S.$addassign(charUnitsToString(ParmOffset));
    // Block pointer and offset.
    S.$addassign_T$C$P(/*KEEP_STR*/"@?0");

    // Argument types.
    ParmOffset.$assign(PtrSize);
    for (ParmVarDecl /*P*/ PVDecl : _Decl.parameters$Const()) {
      QualType PType = PVDecl.getOriginalType();
      {
        /*const*/ ArrayType /*P*/ AT = dyn_cast_ArrayType(PType.$arrow().getCanonicalTypeInternal());
        if ((AT != null)) {
          // Use array's original type only if it has known number of
          // elements.
          if (!isa_ConstantArrayType(AT)) {
            PType.$assignMove(PVDecl.getType());
          }
        } else if (PType.$arrow().isFunctionType()) {
          PType.$assignMove(PVDecl.getType());
        }
      }
      if (getLangOpts().EncodeExtendedBlockSig) {
        getObjCEncodingForMethodParameter(Decl.ObjCDeclQualifier.OBJC_TQ_None, new QualType(PType), 
            S, true/*Extended*/);
      } else {
        getObjCEncodingForType(new QualType(PType), S);
      }
      S.$addassign(charUnitsToString(ParmOffset));
      ParmOffset.$addassign(getObjCEncodingTypeSize(new QualType(PType)));
    }
  
    return S;
  }

  
  /// getObjCEncodingForPropertyDecl - Return the encoded type for
  /// this method declaration. If non-NULL, Container must be either
  /// an ObjCCategoryImplDecl or ObjCImplementationDecl; it should
  /// only be NULL when getting encodings for protocol properties.
  
  /// getObjCEncodingForPropertyDecl - Return the encoded type for this
  /// property declaration. If non-NULL, Container must be either an
  /// ObjCCategoryImplDecl or ObjCImplementationDecl; it should only be
  /// NULL when getting encodings for protocol properties.
  /// Property attributes are stored as a comma-delimited C string. The simple
  /// attributes readonly and bycopy are encoded as single characters. The
  /// parametrized attributes, getter=name, setter=name, and ivar=name, are
  /// encoded as single characters, followed by an identifier. Property types
  /// are also encoded as a parametrized attribute. The characters used to encode
  /// these attributes are defined by the following enumeration:
  /// @code
  /// enum PropertyAttributes {
  /// kPropertyReadOnly = 'R',   // property is read-only.
  /// kPropertyBycopy = 'C',     // property is a copy of the value last assigned
  /// kPropertyByref = '&',  // property is a reference to the value last assigned
  /// kPropertyDynamic = 'D',    // property is dynamic
  /// kPropertyGetter = 'G',     // followed by getter selector name
  /// kPropertySetter = 'S',     // followed by setter selector name
  /// kPropertyInstanceVariable = 'V'  // followed by instance variable  name
  /// kPropertyType = 'T'              // followed by old-style type encoding.
  /// kPropertyWeak = 'W'              // 'weak' property
  /// kPropertyStrong = 'P'            // property GC'able
  /// kPropertyNonAtomic = 'N'         // property non-atomic
  /// };
  /// @endcode
  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::getObjCEncodingForPropertyDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp", line = 5381,
   FQN="clang::ASTContext::getObjCEncodingForPropertyDecl", NM="_ZNK5clang10ASTContext30getObjCEncodingForPropertyDeclEPKNS_16ObjCPropertyDeclEPKNS_4DeclERSs",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZNK5clang10ASTContext30getObjCEncodingForPropertyDeclEPKNS_16ObjCPropertyDeclEPKNS_4DeclERSs")
  //</editor-fold>
  public void getObjCEncodingForPropertyDecl(/*const*/ ObjCPropertyDecl /*P*/ PD, 
                                /*const*/ Decl /*P*/ Container, 
                                final std.string/*&*/ S) /*const*/ {
    // Collect information from the property implementation decl(s).
    boolean Dynamic = false;
    ObjCPropertyImplDecl /*P*/ SynthesizePID = null;
    {
      
      ObjCPropertyImplDecl /*P*/ PropertyImpDecl = getObjCPropertyImplDeclForPropertyDecl(PD, Container);
      if ((PropertyImpDecl != null)) {
        if (PropertyImpDecl.getPropertyImplementation() == ObjCPropertyImplDecl.Kind.Dynamic) {
          Dynamic = true;
        } else {
          SynthesizePID = PropertyImpDecl;
        }
      }
    }

    // FIXME: This is not very efficient.
    S.$assign_T$C$P(/*KEEP_STR*/"T");
  
    // Encode result type.
    // GCC has some special rules regarding encoding of properties which
    // closely resembles encoding of ivars.
    getObjCEncodingForPropertyType(PD.getType(), S);
    if (PD.isReadOnly()) {
      S.$addassign_T$C$P(/*KEEP_STR*/",R");
      if (((PD.getPropertyAttributes() & ObjCPropertyDecl.PropertyAttributeKind.OBJC_PR_copy) != 0)) {
        S.$addassign_T$C$P(/*KEEP_STR*/",C");
      }
      if (((PD.getPropertyAttributes() & ObjCPropertyDecl.PropertyAttributeKind.OBJC_PR_retain) != 0)) {
        S.$addassign_T$C$P(/*KEEP_STR*/",&");
      }
      if (((PD.getPropertyAttributes() & ObjCPropertyDecl.PropertyAttributeKind.OBJC_PR_weak) != 0)) {
        S.$addassign_T$C$P(/*KEEP_STR*/",W");
      }
    } else {
      switch (PD.getSetterKind()) {
       case Assign:
        break;
       case Copy:
        S.$addassign_T$C$P(/*KEEP_STR*/",C");
        break;
       case Retain:
        S.$addassign_T$C$P(/*KEEP_STR*/",&");
        break;
       case Weak:
        S.$addassign_T$C$P(/*KEEP_STR*/",W");
        break;
      }
    }
  
    // It really isn't clear at all what this means, since properties
    // are "dynamic by default".
    if (Dynamic) {
      S.$addassign_T$C$P(/*KEEP_STR*/",D");
    }
    if (((PD.getPropertyAttributes() & ObjCPropertyDecl.PropertyAttributeKind.OBJC_PR_nonatomic) != 0)) {
      S.$addassign_T$C$P(/*KEEP_STR*/",N");
    }
    if (((PD.getPropertyAttributes() & ObjCPropertyDecl.PropertyAttributeKind.OBJC_PR_getter) != 0)) {
      S.$addassign_T$C$P(/*KEEP_STR*/",G");
      S.$addassign(PD.getGetterName().getAsString());
    }
    if (((PD.getPropertyAttributes() & ObjCPropertyDecl.PropertyAttributeKind.OBJC_PR_setter) != 0)) {
      S.$addassign_T$C$P(/*KEEP_STR*/",S");
      S.$addassign(PD.getSetterName().getAsString());
    }
    if ((SynthesizePID != null)) {
      /*const*/ ObjCIvarDecl /*P*/ OID = SynthesizePID.getPropertyIvarDecl();
      S.$addassign_T$C$P(/*KEEP_STR*/",V");
      S.$addassign(OID.getNameAsString());
    }
    // FIXME: OBJCGC: weak & strong
  }

  
  
  //===----------------------------------------------------------------------===//
  // ObjCQualifiedIdTypesAreCompatible - Compatibility testing for qualified id's.
  //===----------------------------------------------------------------------===//
  
  /// ProtocolCompatibleWithProtocol - return 'true' if 'lProto' is in the
  /// inheritance hierarchy of 'rProto'.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::ProtocolCompatibleWithProtocol">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp", line = 6788,
   FQN="clang::ASTContext::ProtocolCompatibleWithProtocol", NM="_ZNK5clang10ASTContext30ProtocolCompatibleWithProtocolEPNS_16ObjCProtocolDeclES2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZNK5clang10ASTContext30ProtocolCompatibleWithProtocolEPNS_16ObjCProtocolDeclES2_")
  //</editor-fold>
  public boolean ProtocolCompatibleWithProtocol(ObjCProtocolDecl /*P*/ lProto, 
                                ObjCProtocolDecl /*P*/ rProto) /*const*/ {
    if (declaresSameEntity(lProto, rProto)) {
      return true;
    }
    for (ObjCProtocolDecl /*P*/ PI : rProto.protocols())  {
      if (ProtocolCompatibleWithProtocol(lProto, PI)) {
        return true;
      }
    }
    return false;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::getObjCPropertyImplDeclForPropertyDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp", line = 5336,
   FQN="clang::ASTContext::getObjCPropertyImplDeclForPropertyDecl", NM="_ZNK5clang10ASTContext38getObjCPropertyImplDeclForPropertyDeclEPKNS_16ObjCPropertyDeclEPKNS_4DeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZNK5clang10ASTContext38getObjCPropertyImplDeclForPropertyDeclEPKNS_16ObjCPropertyDeclEPKNS_4DeclE")
  //</editor-fold>
  public ObjCPropertyImplDecl /*P*/ getObjCPropertyImplDeclForPropertyDecl(/*const*/ ObjCPropertyDecl /*P*/ PD, 
                                        /*const*/ Decl /*P*/ Container) /*const*/ {
    if (!(Container != null)) {
      return null;
    }
    {
      /*const*/ ObjCCategoryImplDecl /*P*/ CID = dyn_cast_ObjCCategoryImplDecl(Container);
      if ((CID != null)) {
        for (ObjCPropertyImplDecl /*P*/ PID : CID.property_impls())  {
          if (PID.getPropertyDecl() == PD) {
            return PID;
          }
        }
      } else {
        /*const*/ ObjCImplementationDecl /*P*/ OID = cast_ObjCImplementationDecl(Container);
        for (ObjCPropertyImplDecl /*P*/ PID : OID.property_impls())  {
          if (PID.getPropertyDecl() == PD) {
            return PID;
          }
        }
      }
    }
    return null;
  }

  
  /// \brief Return the size of type \p T for Objective-C encoding purpose,
  /// in characters.
  
  /// getObjCEncodingTypeSize returns size of type for objective-c encoding
  /// purpose.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::getObjCEncodingTypeSize">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp", line = 5120,
   FQN="clang::ASTContext::getObjCEncodingTypeSize", NM="_ZNK5clang10ASTContext23getObjCEncodingTypeSizeENS_8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZNK5clang10ASTContext23getObjCEncodingTypeSizeENS_8QualTypeE")
  //</editor-fold>
  public CharUnits getObjCEncodingTypeSize(QualType type) /*const*/ {
    if (!type.$arrow().isIncompleteArrayType() && type.$arrow().isIncompleteType()) {
      return CharUnits.Zero();
  }

    CharUnits sz = getTypeSizeInChars(/*NO_COPY*/type);
    
    // Make all integer and enum types at least as large as an int
    if (sz.isPositive() && type.$arrow().isIntegralOrEnumerationType()) {
      sz.$assign(std.max(sz, getTypeSizeInChars(IntTy.$QualType())));
    } else // Treat arrays as pointers, since that's how they're passed in.
    if (type.$arrow().isArrayType()) {
      sz.$assignMove(getTypeSizeInChars(VoidPtrTy.$QualType()));
    }
    return sz;
  }

  
  /// \brief Retrieve the typedef corresponding to the predefined \c id type
  /// in Objective-C.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::getObjCIdDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp", line = 6123,
   FQN="clang::ASTContext::getObjCIdDecl", NM="_ZNK5clang10ASTContext13getObjCIdDeclEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZNK5clang10ASTContext13getObjCIdDeclEv")
  //</editor-fold>
  public TypedefDecl /*P*/ getObjCIdDecl() /*const*/ {
    if (!(ObjCIdDecl != null)) {
      QualType T = getObjCObjectType(ObjCBuiltinIdTy.$QualType(), ((type$ptr<ObjCProtocolDecl /*P*/ /*const*/ /*P*/>)/*zero-init*/null), ((/*uint*/int)/*zero-init*/0));
      T.$assignMove(getObjCObjectPointerType(new QualType(T)));
      ObjCIdDecl = buildImplicitTypedef(new QualType(T), new StringRef(/*KEEP_STR*/"id"));
    }
    return ObjCIdDecl;
  }

  
  /// \brief Represents the Objective-CC \c id type.
  ///
  /// This is set up lazily, by Sema.  \c id is always a (typedef for a)
  /// pointer type, a pointer to a struct.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::getObjCIdType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ASTContext.h", line = 1613,
   FQN="clang::ASTContext::getObjCIdType", NM="_ZNK5clang10ASTContext13getObjCIdTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZNK5clang10ASTContext13getObjCIdTypeEv")
  //</editor-fold>
  public QualType getObjCIdType() /*const*/ {
    return getTypeDeclType(getObjCIdDecl());
  }

  
  /// \brief Retrieve the typedef corresponding to the predefined 'SEL' type
  /// in Objective-C.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::getObjCSelDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp", line = 6132,
   FQN="clang::ASTContext::getObjCSelDecl", NM="_ZNK5clang10ASTContext14getObjCSelDeclEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZNK5clang10ASTContext14getObjCSelDeclEv")
  //</editor-fold>
  public TypedefDecl /*P*/ getObjCSelDecl() /*const*/ {
    if (!(ObjCSelDecl != null)) {
      QualType T = getPointerType(/*NO_COPY*/ObjCBuiltinSelTy).$QualType();
      ObjCSelDecl = buildImplicitTypedef(new QualType(T), new StringRef(/*KEEP_STR*/"SEL"));
    }
    return ObjCSelDecl;
  }

  
  /// \brief Retrieve the type that corresponds to the predefined Objective-C
  /// 'SEL' type.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::getObjCSelType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ASTContext.h", line = 1623,
   FQN="clang::ASTContext::getObjCSelType", NM="_ZNK5clang10ASTContext14getObjCSelTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZNK5clang10ASTContext14getObjCSelTypeEv")
  //</editor-fold>
  public QualType getObjCSelType() /*const*/ {
    return getTypeDeclType(getObjCSelDecl());
  }

  
  /// \brief Retrieve the typedef declaration corresponding to the predefined
  /// Objective-C 'Class' type.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::getObjCClassDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp", line = 6140,
   FQN="clang::ASTContext::getObjCClassDecl", NM="_ZNK5clang10ASTContext16getObjCClassDeclEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZNK5clang10ASTContext16getObjCClassDeclEv")
  //</editor-fold>
  public TypedefDecl /*P*/ getObjCClassDecl() /*const*/ {
    if (!(ObjCClassDecl != null)) {
      QualType T = getObjCObjectType(ObjCBuiltinClassTy.$QualType(), ((type$ptr<ObjCProtocolDecl /*P*/ /*const*/ /*P*/>)/*zero-init*/null), ((/*uint*/int)/*zero-init*/0));
      T.$assignMove(getObjCObjectPointerType(new QualType(T)));
      ObjCClassDecl = buildImplicitTypedef(/*NO_COPY*/T, new StringRef(/*KEEP_STR*/"Class"));
    }
    return ObjCClassDecl;
  }

  
  /// \brief Represents the Objective-C \c Class type.
  ///
  /// This is set up lazily, by Sema.  \c Class is always a (typedef for a)
  /// pointer type, a pointer to a struct.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::getObjCClassType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ASTContext.h", line = 1635,
   FQN="clang::ASTContext::getObjCClassType", NM="_ZNK5clang10ASTContext16getObjCClassTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZNK5clang10ASTContext16getObjCClassTypeEv")
  //</editor-fold>
  public QualType getObjCClassType() /*const*/ {
    return getTypeDeclType(getObjCClassDecl());
  }

  
  /// \brief Retrieve the Objective-C class declaration corresponding to 
  /// the predefined \c Protocol class.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::getObjCProtocolDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp", line = 6149,
   FQN="clang::ASTContext::getObjCProtocolDecl", NM="_ZNK5clang10ASTContext19getObjCProtocolDeclEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZNK5clang10ASTContext19getObjCProtocolDeclEv")
  //</editor-fold>
  public ObjCInterfaceDecl /*P*/ getObjCProtocolDecl() /*const*/ {
    if (!(ObjCProtocolClassDecl != null)) {
      ObjCProtocolClassDecl
         = ObjCInterfaceDecl.Create(/*Deref*/this, getTranslationUnitDecl(), 
          new SourceLocation(), 
          $AddrOf(Idents.get(new StringRef(/*KEEP_STR*/"Protocol"))), 
          /*typeParamList=*/ (ObjCTypeParamList /*P*/ )null, 
          /*PrevDecl=*/ (ObjCInterfaceDecl /*P*/ )null, 
          new SourceLocation(), true);
    }
    
    return ObjCProtocolClassDecl;
  }

  
  /// \brief Retrieve declaration of 'BOOL' typedef
  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::getBOOLDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ASTContext.h", line = 1644,
   FQN="clang::ASTContext::getBOOLDecl", NM="_ZNK5clang10ASTContext11getBOOLDeclEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZNK5clang10ASTContext11getBOOLDeclEv")
  //</editor-fold>
  public TypedefDecl /*P*/ getBOOLDecl() /*const*/ {
    return BOOLDecl;
  }

  
  /// \brief Save declaration of 'BOOL' typedef
  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::setBOOLDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ASTContext.h", line = 1649,
   FQN="clang::ASTContext::setBOOLDecl", NM="_ZN5clang10ASTContext11setBOOLDeclEPNS_11TypedefDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZN5clang10ASTContext11setBOOLDeclEPNS_11TypedefDeclE")
  //</editor-fold>
  public void setBOOLDecl(TypedefDecl /*P*/ TD) {
    BOOLDecl = TD;
  }

  
  /// \brief type of 'BOOL' type.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::getBOOLType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ASTContext.h", line = 1654,
   FQN="clang::ASTContext::getBOOLType", NM="_ZNK5clang10ASTContext11getBOOLTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZNK5clang10ASTContext11getBOOLTypeEv")
  //</editor-fold>
  public QualType getBOOLType() /*const*/ {
    return getTypeDeclType(getBOOLDecl());
  }

  
  /// \brief Retrieve the type of the Objective-C \c Protocol class.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::getObjCProtoType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ASTContext.h", line = 1659,
   FQN="clang::ASTContext::getObjCProtoType", NM="_ZNK5clang10ASTContext16getObjCProtoTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZNK5clang10ASTContext16getObjCProtoTypeEv")
  //</editor-fold>
  public QualType getObjCProtoType() /*const*/ {
    return getObjCInterfaceType(getObjCProtocolDecl());
  }

  
  /// \brief Retrieve the C type declaration corresponding to the predefined
  /// \c __builtin_va_list type.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::getBuiltinVaListDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp", line = 6498,
   FQN="clang::ASTContext::getBuiltinVaListDecl", NM="_ZNK5clang10ASTContext20getBuiltinVaListDeclEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZNK5clang10ASTContext20getBuiltinVaListDeclEv")
  //</editor-fold>
  public TypedefDecl /*P*/ getBuiltinVaListDecl() /*const*/ {
    if (!(BuiltinVaListDecl != null)) {
      BuiltinVaListDecl = CreateVaListDecl(this, Target.getBuiltinVaListKind());
      assert (BuiltinVaListDecl.isImplicit());
    }
    
    return BuiltinVaListDecl;
  }

  
  /// \brief Retrieve the type of the \c __builtin_va_list type.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::getBuiltinVaListType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ASTContext.h", line = 1668,
   FQN="clang::ASTContext::getBuiltinVaListType", NM="_ZNK5clang10ASTContext20getBuiltinVaListTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZNK5clang10ASTContext20getBuiltinVaListTypeEv")
  //</editor-fold>
  public QualType getBuiltinVaListType() /*const*/ {
    return getTypeDeclType(getBuiltinVaListDecl());
  }

  
  /// \brief Retrieve the C type declaration corresponding to the predefined
  /// \c __va_list_tag type used to help define the \c __builtin_va_list type
  /// for some targets.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::getVaListTagDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp", line = 6507,
   FQN="clang::ASTContext::getVaListTagDecl", NM="_ZNK5clang10ASTContext16getVaListTagDeclEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZNK5clang10ASTContext16getVaListTagDeclEv")
  //</editor-fold>
  public Decl /*P*/ getVaListTagDecl() /*const*/ {
    // Force the creation of VaListTagDecl by building the __builtin_va_list
    // declaration.
    if (!(VaListTagDecl != null)) {
      /*J:(void)*/getBuiltinVaListDecl();
    }

    return VaListTagDecl;
  }
  
  
  /// Retrieve the C type declaration corresponding to the predefined
  /// \c __builtin_ms_va_list type.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::getBuiltinMSVaListDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp", line = 6516,
   FQN="clang::ASTContext::getBuiltinMSVaListDecl", NM="_ZNK5clang10ASTContext22getBuiltinMSVaListDeclEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZNK5clang10ASTContext22getBuiltinMSVaListDeclEv")
  //</editor-fold>
  public TypedefDecl /*P*/ getBuiltinMSVaListDecl() /*const*/ {
    if (!(BuiltinMSVaListDecl != null)) {
      BuiltinMSVaListDecl = CreateMSVaListDecl(this);
    }
    
    return BuiltinMSVaListDecl;
  }

  
  /// Retrieve the type of the \c __builtin_ms_va_list type.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::getBuiltinMSVaListType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ASTContext.h", line = 1682,
   FQN="clang::ASTContext::getBuiltinMSVaListType", NM="_ZNK5clang10ASTContext22getBuiltinMSVaListTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZNK5clang10ASTContext22getBuiltinMSVaListTypeEv")
  //</editor-fold>
  public QualType getBuiltinMSVaListType() /*const*/ {
    return getTypeDeclType(getBuiltinMSVaListDecl());
  }

  
  /// \brief Return a type with additional \c const, \c volatile, or
  /// \c restrict qualifiers.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::getCVRQualifiedType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ASTContext.h", line = 1688,
   FQN="clang::ASTContext::getCVRQualifiedType", NM="_ZNK5clang10ASTContext19getCVRQualifiedTypeENS_8QualTypeEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZNK5clang10ASTContext19getCVRQualifiedTypeENS_8QualTypeEj")
  //</editor-fold>
  public QualType getCVRQualifiedType(QualType T, /*uint*/int CVR) /*const*/ {
    return getQualifiedType(new QualType(T), Qualifiers.fromCVRMask(CVR));
  }

  
  /// \brief Un-split a SplitQualType.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::getQualifiedType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ASTContext.h", line = 1693,
   FQN="clang::ASTContext::getQualifiedType", NM="_ZNK5clang10ASTContext16getQualifiedTypeENS_13SplitQualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZNK5clang10ASTContext16getQualifiedTypeENS_13SplitQualTypeE")
  //</editor-fold>
  public QualType getQualifiedType(SplitQualType split) /*const*/ {
    return getQualifiedType(split.Ty, new Qualifiers(split.Quals));
  }

  
  /// \brief Return a type with additional qualifiers.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::getQualifiedType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ASTContext.h", line = 1698,
   FQN="clang::ASTContext::getQualifiedType", NM="_ZNK5clang10ASTContext16getQualifiedTypeENS_8QualTypeENS_10QualifiersE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZNK5clang10ASTContext16getQualifiedTypeENS_8QualTypeENS_10QualifiersE")
  //</editor-fold>
  public QualType getQualifiedType(QualType T, Qualifiers Qs) /*const*/ {
    if (!Qs.hasNonFastQualifiers()) {
      return T.withFastQualifiers(Qs.getFastQualifiers());
    }
    QualifierCollector Qc/*J*/= new QualifierCollector(new Qualifiers(Qs));
    /*const*/ Type /*P*/ Ptr = Qc.strip(new QualType(T));
    return getExtQualType(Ptr, new Qualifiers(Qc));
  }

  
  /// \brief Return a type with additional qualifiers.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::getQualifiedType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ASTContext.h", line = 1707,
   FQN="clang::ASTContext::getQualifiedType", NM="_ZNK5clang10ASTContext16getQualifiedTypeEPKNS_4TypeENS_10QualifiersE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZNK5clang10ASTContext16getQualifiedTypeEPKNS_4TypeENS_10QualifiersE")
  //</editor-fold>
  public QualType getQualifiedType(/*const*/ Type /*P*/ T, Qualifiers Qs) /*const*/ {
    if (!Qs.hasNonFastQualifiers()) {
      return new QualType(T, Qs.getFastQualifiers());
    }
    return getExtQualType(T, new Qualifiers(Qs));
  }

  
  /// \brief Return a type with the given lifetime qualifier.
  ///
  /// \pre Neither type.ObjCLifetime() nor \p lifetime may be \c OCL_None.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::getLifetimeQualifiedType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ASTContext.h", line = 1716,
   FQN="clang::ASTContext::getLifetimeQualifiedType", NM="_ZN5clang10ASTContext24getLifetimeQualifiedTypeENS_8QualTypeENS_10Qualifiers12ObjCLifetimeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZN5clang10ASTContext24getLifetimeQualifiedTypeENS_8QualTypeENS_10Qualifiers12ObjCLifetimeE")
  //</editor-fold>
  public QualType getLifetimeQualifiedType(QualType type, 
                          Qualifiers.ObjCLifetime lifetime) {
    assert (type.getObjCLifetime() == Qualifiers.ObjCLifetime.OCL_None);
    assert (lifetime != Qualifiers.ObjCLifetime.OCL_None);
    
    Qualifiers qs/*J*/= new Qualifiers();
    qs.addObjCLifetime(lifetime);
    return getQualifiedType(new QualType(type), new Qualifiers(qs));
  }

  
  /// getUnqualifiedObjCPointerType - Returns version of
  /// Objective-C pointer type with lifetime qualifier removed.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::getUnqualifiedObjCPointerType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ASTContext.h", line = 1728,
   FQN="clang::ASTContext::getUnqualifiedObjCPointerType", NM="_ZNK5clang10ASTContext29getUnqualifiedObjCPointerTypeENS_8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZNK5clang10ASTContext29getUnqualifiedObjCPointerTypeENS_8QualTypeE")
  //</editor-fold>
  public QualType getUnqualifiedObjCPointerType(QualType type) /*const*/ {
    if (!type.getTypePtr().isObjCObjectPointerType()
       || !type.getQualifiers().hasObjCLifetime()) {
      return new QualType(JD$Move.INSTANCE, type);
    }
    Qualifiers Qs = type.getQualifiers();
    Qs.removeObjCLifetime();
    return getQualifiedType(type.getUnqualifiedType(), new Qualifiers(Qs));
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::getNameForTemplate">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp", line = 4287,
   FQN="clang::ASTContext::getNameForTemplate", NM="_ZNK5clang10ASTContext18getNameForTemplateENS_12TemplateNameENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZNK5clang10ASTContext18getNameForTemplateENS_12TemplateNameENS_14SourceLocationE")
  //</editor-fold>
  public DeclarationNameInfo getNameForTemplate(TemplateName Name, 
                    SourceLocation NameLoc) /*const*/ {
    switch (Name.getKind()) {
     case QualifiedTemplate:
     case Template:
      // DNInfo work in progress: CHECKME: what about DNLoc?
      return new DeclarationNameInfo(Name.getAsTemplateDecl().getDeclName(), 
          new SourceLocation(NameLoc));
     case OverloadedTemplate:
      {
        OverloadedTemplateStorage /*P*/ Storage = Name.getAsOverloadedTemplate();
        // DNInfo work in progress: CHECKME: what about DNLoc?
        return new DeclarationNameInfo((Storage.begin().$star()).getDeclName(), new SourceLocation(NameLoc));
      }
     case DependentTemplate:
      {
        DependentTemplateName /*P*/ DTN = Name.getAsDependentTemplateName();
        DeclarationName DName/*J*/= new DeclarationName();
        if (DTN.isIdentifier()) {
          DName.$assignMove(DeclarationNames.getIdentifier(DTN.getIdentifier()));
          return new DeclarationNameInfo(new DeclarationName(DName), new SourceLocation(NameLoc));
        } else {
          DName.$assignMove(DeclarationNames.getCXXOperatorName(DTN.getOperator()));
          // DNInfo work in progress: FIXME: source locations?
          DeclarationNameLoc DNLoc/*J*/= new DeclarationNameLoc();
          DNLoc.Unnamed_field.CXXOperatorName.BeginOpNameLoc = new SourceLocation().getRawEncoding();
          DNLoc.Unnamed_field.CXXOperatorName.EndOpNameLoc = new SourceLocation().getRawEncoding();
          return new DeclarationNameInfo(new DeclarationName(DName), new SourceLocation(NameLoc), new DeclarationNameLoc(DNLoc));
        }
      }
     case SubstTemplateTemplateParm:
      {
        SubstTemplateTemplateParmStorage /*P*/ subst = Name.getAsSubstTemplateTemplateParm();
        return new DeclarationNameInfo(subst.getParameter().getDeclName(), 
            new SourceLocation(NameLoc));
      }
     case SubstTemplateTemplateParmPack:
      {
        SubstTemplateTemplateParmPackStorage /*P*/ subst = Name.getAsSubstTemplateTemplateParmPack();
        return new DeclarationNameInfo(subst.getParameterPack().getDeclName(), 
            new SourceLocation(NameLoc));
      }
    }
    throw new llvm_unreachable("bad template name kind!");
  }

  
  
  /// \brief Retrieve the template name that corresponds to a non-empty
  /// lookup.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::getOverloadedTemplateName">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*Alloc*/,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp", line = 6532,
   FQN="clang::ASTContext::getOverloadedTemplateName", NM="_ZNK5clang10ASTContext25getOverloadedTemplateNameENS_21UnresolvedSetIteratorES1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZNK5clang10ASTContext25getOverloadedTemplateNameENS_21UnresolvedSetIteratorES1_")
  //</editor-fold>
  public TemplateName getOverloadedTemplateName(UnresolvedSetIterator Begin, 
                           UnresolvedSetIterator End) /*const*/ {
    /*uint*/int size = End.$sub(Begin);
    assert ($greater_uint(size, 1)) : "set is not overloaded!";
    
    Object/*void P*/ memory = Allocate$JavaRef(1/*$sizeof_OverloadedTemplateStorage()*/
           + size * 1/*$sizeof_ptr(FunctionTemplateDecl)*/);
    OverloadedTemplateStorage /*P*/ OT = ((/*JCast*/OverloadedTemplateStorage /*P*/ )(/*NEW_EXPR [System]*/memory = /*new (memory)*/ $new_uint_voidPtr(memory, (type$ptr<?> New$Mem)->{
        return new OverloadedTemplateStorage(size);
     })));
    
    type$ptr<NamedDecl /*P*/ /*P*/> Storage = $tryClone(OT.getStorage());
    for (UnresolvedSetIterator I = new UnresolvedSetIterator(Begin); I.$noteq(End); I.$preInc()) {
      NamedDecl /*P*/ D = I.$star();
      assert (isa_FunctionTemplateDecl(D) || (isa_UsingShadowDecl(D) && isa_FunctionTemplateDecl(D.getUnderlyingDecl())));
      Storage.$postInc().$set(D);
    }
    
    return new TemplateName(OT);
  }
  
  
  
  /// \brief Retrieve the template name that represents a qualified
  /// template name such as \c std::vector.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::getQualifiedTemplateName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp", line = 6556,
   FQN="clang::ASTContext::getQualifiedTemplateName", NM="_ZNK5clang10ASTContext24getQualifiedTemplateNameEPNS_19NestedNameSpecifierEbPNS_12TemplateDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZNK5clang10ASTContext24getQualifiedTemplateNameEPNS_19NestedNameSpecifierEbPNS_12TemplateDeclE")
  //</editor-fold>
  public TemplateName getQualifiedTemplateName(NestedNameSpecifier /*P*/ NNS, 
                          boolean TemplateKeyword, 
                          TemplateDecl /*P*/ Template) /*const*/ {
    assert ((NNS != null)) : "Missing nested-name-specifier in qualified template name";
    
    // FIXME: Canonicalization?
    FoldingSetNodeID ID/*J*/= new FoldingSetNodeID();
    QualifiedTemplateName.Profile(ID, NNS, TemplateKeyword, Template);
    
    final type$ref<type$ptr<QualifiedTemplateName /*P*/>/*void P*/ > InsertPos = create_type$null$ref(null);
    QualifiedTemplateName /*P*/ QTN = QualifiedTemplateNames.FindNodeOrInsertPos(ID, InsertPos);
    if (!(QTN != null)) {
      QTN = /*NEW_EXPR [operator new] NM=_ZnwjRKN5clang10ASTContextEj*/
      /*new (*this, llvm::alignOf<QualifiedTemplateName>())*/ $new_uint_ASTContext$C_uint(/*Deref*/this, alignOf(QualifiedTemplateName.class), (type$ptr<?> New$Mem)->{
          return new QualifiedTemplateName(NNS, TemplateKeyword, Template);
       });
      QualifiedTemplateNames.InsertNode(QTN, InsertPos.$deref());
    }

    return new TemplateName(QTN);
  }
  
  
  
  /// \brief Retrieve the template name that represents a dependent
  /// template name such as \c MetaFun::template apply.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::getDependentTemplateName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp", line = 6580,
   FQN="clang::ASTContext::getDependentTemplateName", NM="_ZNK5clang10ASTContext24getDependentTemplateNameEPNS_19NestedNameSpecifierEPKNS_14IdentifierInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZNK5clang10ASTContext24getDependentTemplateNameEPNS_19NestedNameSpecifierEPKNS_14IdentifierInfoE")
  //</editor-fold>
  public TemplateName getDependentTemplateName(NestedNameSpecifier /*P*/ NNS, 
                          /*const*/ IdentifierInfo /*P*/ Name) /*const*/ {
    assert ((!(NNS != null) || NNS.isDependent())) : "Nested name specifier must be dependent";
    
    FoldingSetNodeID ID/*J*/= new FoldingSetNodeID();
    DependentTemplateName.Profile(ID, NNS, Name);
    
    final type$ref<type$ptr<DependentTemplateName /*P*/>/*void P*/ > InsertPos = create_type$null$ref(null);
    DependentTemplateName /*P*/ QTN = DependentTemplateNames.FindNodeOrInsertPos(ID, InsertPos);
    if ((QTN != null)) {
      return new TemplateName(QTN);
    }

    NestedNameSpecifier /*P*/ CanonNNS = getCanonicalNestedNameSpecifier(NNS);
    if (CanonNNS == NNS) {
      QTN = /*NEW_EXPR [operator new] NM=_ZnwjRKN5clang10ASTContextEj*/
      /*new (*this, llvm::alignOf<DependentTemplateName>())*/ $new_uint_ASTContext$C_uint(/*Deref*/this, alignOf(DependentTemplateName.class), (type$ptr<?> New$Mem)->{
          return new DependentTemplateName(NNS, Name);
       });
    } else {
      TemplateName Canon = getDependentTemplateName(CanonNNS, Name);
      QTN = /*NEW_EXPR [operator new] NM=_ZnwjRKN5clang10ASTContextEj*/
      /*new (*this, llvm::alignOf<DependentTemplateName>())*/ $new_uint_ASTContext$C_uint(/*Deref*/this, alignOf(DependentTemplateName.class), (type$ptr<?> New$Mem)->{
          return new DependentTemplateName(NNS, Name, new TemplateName(Canon));
       });
      DependentTemplateName /*P*/ CheckQTN = DependentTemplateNames.FindNodeOrInsertPos(ID, InsertPos);
      assert (!(CheckQTN != null)) : "Dependent type name canonicalization broken";
      ///*J:(void)*/CheckQTN;
    }
  
    DependentTemplateNames.InsertNode(QTN, InsertPos.$deref());
    return new TemplateName(QTN);
  }

  
  /// \brief Retrieve the template name that represents a dependent
  /// template name such as \c MetaFun::template operator+.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::getDependentTemplateName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp", line = 6616,
   FQN="clang::ASTContext::getDependentTemplateName", NM="_ZNK5clang10ASTContext24getDependentTemplateNameEPNS_19NestedNameSpecifierENS_22OverloadedOperatorKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZNK5clang10ASTContext24getDependentTemplateNameEPNS_19NestedNameSpecifierENS_22OverloadedOperatorKindE")
  //</editor-fold>
  public TemplateName getDependentTemplateName(NestedNameSpecifier /*P*/ NNS, 
                          OverloadedOperatorKind Operator) /*const*/ {
    assert ((!(NNS != null) || NNS.isDependent())) : "Nested name specifier must be dependent";
    
    FoldingSetNodeID ID/*J*/= new FoldingSetNodeID();
    DependentTemplateName.Profile(ID, NNS, Operator);
    
    final type$ref<type$ptr<DependentTemplateName /*P*/>/*void P*/ > InsertPos = create_type$null$ref(null);
    DependentTemplateName /*P*/ QTN = DependentTemplateNames.FindNodeOrInsertPos(ID, InsertPos);
    if ((QTN != null)) {
      return new TemplateName(QTN);
    }

    NestedNameSpecifier /*P*/ CanonNNS = getCanonicalNestedNameSpecifier(NNS);
    if (CanonNNS == NNS) {
      QTN = /*NEW_EXPR [operator new] NM=_ZnwjRKN5clang10ASTContextEj*/
      /*new (*this, llvm::alignOf<DependentTemplateName>())*/ $new_uint_ASTContext$C_uint(/*Deref*/this, alignOf(DependentTemplateName.class), (type$ptr<?> New$Mem)->{
          return new DependentTemplateName(NNS, Operator);
       });
    } else {
      TemplateName Canon = getDependentTemplateName(CanonNNS, Operator);
      QTN = /*NEW_EXPR [operator new] NM=_ZnwjRKN5clang10ASTContextEj*/
      /*new (*this, llvm::alignOf<DependentTemplateName>())*/ $new_uint_ASTContext$C_uint(/*Deref*/this, alignOf(DependentTemplateName.class), (type$ptr<?> New$Mem)->{
          return new DependentTemplateName(NNS, Operator, new TemplateName(Canon));
       });
      
      DependentTemplateName /*P*/ CheckQTN = DependentTemplateNames.FindNodeOrInsertPos(ID, InsertPos);
      assert (!(CheckQTN != null)) : "Dependent template name canonicalization broken";
      ///*J:(void)*/CheckQTN;
    }
    
    DependentTemplateNames.InsertNode(QTN, InsertPos.$deref());
    return new TemplateName(QTN);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::getSubstTemplateTemplateParm">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp", line = 6651,
   FQN="clang::ASTContext::getSubstTemplateTemplateParm", NM="_ZNK5clang10ASTContext28getSubstTemplateTemplateParmEPNS_24TemplateTemplateParmDeclENS_12TemplateNameE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZNK5clang10ASTContext28getSubstTemplateTemplateParmEPNS_24TemplateTemplateParmDeclENS_12TemplateNameE")
  //</editor-fold>
  public TemplateName getSubstTemplateTemplateParm(TemplateTemplateParmDecl /*P*/ param, 
                              TemplateName replacement) /*const*/ {
    FoldingSetNodeID ID/*J*/= new FoldingSetNodeID();
    SubstTemplateTemplateParmStorage.Profile(ID, param, /*NO_COPY*/replacement);
    
    final type$ref<type$ptr<SubstTemplateTemplateParmStorage /*P*/>/*void P*/ > insertPos = create_type$null$ref(null);
    SubstTemplateTemplateParmStorage /*P*/ subst = SubstTemplateTemplateParms.FindNodeOrInsertPos(ID, insertPos);
    if (!(subst != null)) {
      subst = /*NEW_EXPR [operator new] NM=_ZnwjRKN5clang10ASTContextEj*/
      /*new (*this)*/ $new_uint_ASTContext$C_uint(/*Deref*/this, (type$ptr<?> New$Mem)->{
          return new SubstTemplateTemplateParmStorage(param, new TemplateName(replacement));
       });
      SubstTemplateTemplateParms.InsertNode(subst, insertPos.$deref());
    }

    return new TemplateName(subst);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::getSubstTemplateTemplateParmPack">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp", line = 6669,
   FQN="clang::ASTContext::getSubstTemplateTemplateParmPack", NM="_ZNK5clang10ASTContext32getSubstTemplateTemplateParmPackEPNS_24TemplateTemplateParmDeclERKNS_16TemplateArgumentE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZNK5clang10ASTContext32getSubstTemplateTemplateParmPackEPNS_24TemplateTemplateParmDeclERKNS_16TemplateArgumentE")
  //</editor-fold>
  public TemplateName getSubstTemplateTemplateParmPack(TemplateTemplateParmDecl /*P*/ Param, 
                                  final /*const*/ TemplateArgument /*&*/ ArgPack) /*const*/ {
    final ASTContext /*&*/ Self = ((/*const_cast*/ASTContext /*&*/ )(/*Deref*/this));
    FoldingSetNodeID ID/*J*/= new FoldingSetNodeID();
    SubstTemplateTemplateParmPackStorage.Profile(ID, Self, Param, ArgPack);
    
    final type$ref<type$ptr<SubstTemplateTemplateParmPackStorage /*P*/>/*void P*/ > InsertPos = create_type$null$ref(null);
    SubstTemplateTemplateParmPackStorage /*P*/ Subst = SubstTemplateTemplateParmPacks.FindNodeOrInsertPos(ID, InsertPos);
    if (!(Subst != null)) {
      Subst = /*NEW_EXPR [operator new] NM=_ZnwjRKN5clang10ASTContextEj*/
      /*new (*this)*/ $new_uint_ASTContext$C_uint(/*Deref*/this, (type$ptr<?> New$Mem)->{
          return new SubstTemplateTemplateParmPackStorage(Param, 
                  ArgPack.pack_size(), 
                  ArgPack.pack_begin());
       });
      SubstTemplateTemplateParmPacks.InsertNode(Subst, InsertPos.$deref());
    }

    return new TemplateName(Subst);
  }
  
  
  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::GetBuiltinTypeError">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ASTContext.h", line = 1756,
   FQN="clang::ASTContext::GetBuiltinTypeError", NM="_ZN5clang10ASTContext19GetBuiltinTypeErrorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZN5clang10ASTContext19GetBuiltinTypeErrorE")
  //</editor-fold>
  public enum GetBuiltinTypeError implements Native.ComparableLower {
    GE_None(0), ///< No error
    GE_Missing_stdio(GE_None.getValue() + 1), ///< Missing a type from <stdio.h>
    GE_Missing_setjmp(GE_Missing_stdio.getValue() + 1), ///< Missing a type from <setjmp.h>
    GE_Missing_ucontext(GE_Missing_setjmp.getValue() + 1); ///< Missing a type from <ucontext.h>

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static GetBuiltinTypeError valueOf(int val) {
      GetBuiltinTypeError out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final GetBuiltinTypeError[] VALUES;
      private static final GetBuiltinTypeError[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (GetBuiltinTypeError kind : GetBuiltinTypeError.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new GetBuiltinTypeError[min < 0 ? (1-min) : 0];
        VALUES = new GetBuiltinTypeError[max >= 0 ? (1+max) : 0];
        for (GetBuiltinTypeError kind : GetBuiltinTypeError.values()) {
          if (kind.value < 0) {
            if (_VALUES[-kind.value] == null) {
              _VALUES[-kind.value] = kind;
            } else {
              assert true: "Must not replace " + _VALUES[-kind.value] + " by " + kind + ". Switch to int-based enum or filter valid.";
            }
          } else {
            if (VALUES[kind.value] == null) {
              VALUES[kind.value] = kind;
            } else {
              assert true: "Must not replace " + VALUES[kind.value] + " by " + kind + ". Switch to int-based enum or filter valid.";
            }
          }
        }
      }
    }

    private final /*uint*/int value;
    private GetBuiltinTypeError(int val) { this.value = (/*uint*/int)val;}
    public /*uint*/int getValue() { return value;}
    @Override public boolean $less(Object obj) { return Unsigned.$less_uint(value, ((GetBuiltinTypeError)obj).value);}
    @Override public boolean $lesseq(Object obj) { return Unsigned.$lesseq_uint(value, ((GetBuiltinTypeError)obj).value);}
    //</editor-fold>
  };
  
  /// \brief Return the type for the specified builtin.
  ///
  /// If \p IntegerConstantArgs is non-null, it is filled in with a bitmask of
  /// arguments to the builtin that are required to be integer constant
  /// expressions.
  
  /// GetBuiltinType - Return the type for the specified builtin.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::GetBuiltinType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp", line = 8344,
   FQN="clang::ASTContext::GetBuiltinType", NM="_ZNK5clang10ASTContext14GetBuiltinTypeEjRNS0_19GetBuiltinTypeErrorEPj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZNK5clang10ASTContext14GetBuiltinTypeEjRNS0_19GetBuiltinTypeErrorEPj")
  //</editor-fold>
  public QualType GetBuiltinType(/*uint*/int Id, 
                final type$ref<GetBuiltinTypeError /*&*/> Error) /*const*/ {
    return GetBuiltinType(Id, 
                Error, 
                (uint$ptr/*uint P*/ )null);
  }
  public QualType GetBuiltinType(/*uint*/int Id, 
                final type$ref<GetBuiltinTypeError /*&*/> Error, 
                uint$ptr/*uint P*/ IntegerConstantArgs/*= null*/) /*const*/ {
    /*const*/char$ptr/*char P*/ TypeStr = $tryClone(BuiltinInfo.getTypeString(Id));
    
    SmallVector<QualType> ArgTypes/*J*/= new SmallVector<QualType>(8, new QualType());
    
    bool$ref RequiresICE = create_bool$ref(false);
    Error.$set(GetBuiltinTypeError.GE_None);
    QualType ResType = DecodeTypeFromStr(TypeStr, /*Deref*/this, Error, 
        RequiresICE, true);
    if (Error.$deref() != GetBuiltinTypeError.GE_None) {
      return new QualType();
    }
    assert (!RequiresICE.$deref()) : "Result of intrinsic cannot be required to be an ICE";
    while ((TypeStr.$at(0) != 0) && TypeStr.$at(0) != $$DOT) {
      QualType Ty = DecodeTypeFromStr(TypeStr, /*Deref*/this, Error, RequiresICE, true);
      if (Error.$deref() != GetBuiltinTypeError.GE_None) {
        return new QualType();
      }
      
      // If this argument is required to be an IntegerConstantExpression and the
      // caller cares, fill in the bitmask we return.
      if (RequiresICE.$deref() && Native.$bool(IntegerConstantArgs)) {
        IntegerConstantArgs.$set$orassign(0, 1 << ArgTypes.size()); 
      }
      
      // Do array -> pointer decay.  The builtin should use the decayed type.
      if (Ty.$arrow().isArrayType()) {
        Ty.$assignMove(getArrayDecayedType(new QualType(Ty)));
      }
      
      ArgTypes.push_back(Ty);
    }
    if (Id == Builtin.ID.BI__GetExceptionInfo.getValue()) {
      return new QualType();
    }
    assert ((TypeStr.$at(0) != $$DOT || TypeStr.$at(1) == 0)) : "'.' should only occur at end of builtin type list!";
    
    FunctionType.ExtInfo EI/*J*/= new FunctionType.ExtInfo(CallingConv.CC_C);
    if (BuiltinInfo.isNoReturn(Id)) {
      EI.$assignMove(EI.withNoReturn(true));
    }
    
    boolean Variadic = (TypeStr.$at(0) == $$DOT);
    
    // We really shouldn't be making a no-proto type here, especially in C++.
    if (ArgTypes.empty() && Variadic) {
      return getFunctionNoProtoType(new QualType(ResType), EI);
    }
    
    FunctionProtoType.ExtProtoInfo EPI/*J*/= new FunctionProtoType.ExtProtoInfo();
    EPI.ExtInfo.$assign(EI);
    EPI.Variadic = Variadic;
    
    return getFunctionType(new QualType(ResType), new ArrayRef<QualType>(ArgTypes, false), EPI);
  }
/*private:*/
  
  /// getFromTargetType - Given one of the integer types provided by
  /// TargetInfo, produce the corresponding type. The unsigned @p Type
  /// is actually a value of type @c TargetInfo::IntType.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::getFromTargetType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp", line = 6693,
   FQN="clang::ASTContext::getFromTargetType", NM="_ZNK5clang10ASTContext17getFromTargetTypeEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZNK5clang10ASTContext17getFromTargetTypeEj")
  //</editor-fold>
  private CanQual<Type> getFromTargetType(/*uint*/int Type) /*const*/ {
    switch (TargetInfo.IntType.valueOf(Type)) {
     case NoInt:
      return new CanQual<Type>();
     case SignedChar:
      return new CanQual<Type>(SignedCharTy);
     case UnsignedChar:
      return new CanQual<Type>(UnsignedCharTy);
     case SignedShort:
      return new CanQual<Type>(ShortTy);
     case UnsignedShort:
      return new CanQual<Type>(UnsignedShortTy);
     case SignedInt:
      return new CanQual<Type>(IntTy);
     case UnsignedInt:
      return new CanQual<Type>(UnsignedIntTy);
     case SignedLong:
      return new CanQual<Type>(LongTy);
     case UnsignedLong:
      return new CanQual<Type>(UnsignedLongTy);
     case SignedLongLong:
      return new CanQual<Type>(LongLongTy);
     case UnsignedLongLong:
      return new CanQual<Type>(UnsignedLongLongTy);
    }
    throw new llvm_unreachable("Unhandled TargetInfo::IntType value");
  }

  
  /// getTypeInfoImpl - Return the size of the specified type, in bits.  This
  /// method does not work on incomplete types.
  ///
  /// FIXME: Pointers into different addr spaces could have different sizes and
  /// alignment requirements: getPointerInfo should take an AddrSpace, this
  /// should take a QualType, &c.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::getTypeInfoImpl">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION/*unfold std.tie*/,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp", line = 1524,
   FQN="clang::ASTContext::getTypeInfoImpl", NM="_ZNK5clang10ASTContext15getTypeInfoImplEPKNS_4TypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZNK5clang10ASTContext15getTypeInfoImplEPKNS_4TypeE")
  //</editor-fold>
  private TypeInfo getTypeInfoImpl(/*const*/ Type /*P*/ T) /*const*/ {
    long/*uint64_t*/ Width = $int2ulong(0);
    /*uint*/int Align = 8;
    boolean AlignIsRequired = false;
    switch (T.getTypeClass()) {
     case DependentSizedArray:
     case DependentSizedExtVector:
     case UnresolvedUsing:
     case TypeOfExpr:
      assert (!T.isDependentType()) : "should not see dependent types here";
      return getTypeInfo(cast_TypeOfExprType(T).desugar().getTypePtr());
     case TypeOf:
      assert (!T.isDependentType()) : "should not see dependent types here";
      return getTypeInfo(cast_TypeOfType(T).desugar().getTypePtr());
     case Decltype:
      assert (!T.isDependentType()) : "should not see dependent types here";
      return getTypeInfo(cast_DecltypeType(T).desugar().getTypePtr());
     case UnaryTransform:
      assert (!T.isDependentType()) : "should not see dependent types here";
      return getTypeInfo(cast_UnaryTransformType(T).desugar().getTypePtr());
     case TemplateTypeParm:
     case SubstTemplateTypeParmPack:
     case TemplateSpecialization:
      assert (!T.isDependentType()) : "should not see dependent types here";
      return getTypeInfo(cast_TemplateSpecializationType(T).desugar().getTypePtr());
     case InjectedClassName:
     case DependentName:
     case DependentTemplateSpecialization:
     case PackExpansion:
      assert (!T.isDependentType()) : "should not see dependent types here";
      return getTypeInfo(cast_PackExpansionType(T).desugar().getTypePtr());    
// JAVA: unreacheable    throw new llvm_unreachable("Should not see dependent types");
     case FunctionNoProto:
     case FunctionProto:
      // GCC extension: alignof(function) = 32 bits
      Width = $int2ulong(0);
      Align = 32;
      break;
     case IncompleteArray:
     case VariableArray:
      Width = $int2ulong(0);
      Align = getTypeAlign(cast_ArrayType(T).getElementType());
      break;
     case ConstantArray:
      {
        /*const*/ ConstantArrayType /*P*/ CAT = cast_ConstantArrayType(T);
        
        TypeInfo EltInfo = getTypeInfo(CAT.getElementType());
        long/*uint64_t*/ Size = CAT.getSize().getZExtValue();
        assert ((Size == $int2ullong(0) || $lesseq_ulong_ullong(EltInfo.Width, $div_ulong((long/*uint64_t*/)$int2ulong((-1)), Size)))) : "Overflow in array type bit size evaluation";
        Width = EltInfo.Width * Size;
        Align = EltInfo.Align;
        if (!getTargetInfo().getCXXABI().isMicrosoft()
           || getTargetInfo().getPointerWidth(0) == $int2ullong(64)) {
          Width = llvm.alignTo(Width, $uint2ulong(Align));
        }
        break;
      }
     case ExtVector:
     case Vector:
      {
        /*const*/ VectorType /*P*/ VT = cast_VectorType(T);
        TypeInfo EltInfo = getTypeInfo(VT.getElementType());
        Width = EltInfo.Width * $uint2ullong(VT.getNumElements());
        Align = $ulong2uint(Width);
        // If the alignment is not a power of 2, round up to the next power of 2.
        // This happens for non-power-of-2 length vectors.
        if (((Align & (Align - 1)) != 0)) {
          Align = $ulong2uint(llvm.NextPowerOf2($uint2ulong(Align)));
          Width = llvm.alignTo(Width, $uint2ulong(Align));
        }
        // Adjust the alignment based on the target max.
        long/*uint64_t*/ TargetVectorAlign = $uint2ulong(Target.getMaxVectorAlign());
        if ((TargetVectorAlign != 0) && $less_ulong_uint(TargetVectorAlign, Align)) {
          Align = $ulong2uint(TargetVectorAlign);
        }
        break;
      }
     case Builtin:
      switch (cast_BuiltinType(T).getKind()) {
       default:
        throw new llvm_unreachable("Unknown builtin type!");
       case Void:
        // GCC extension: alignof(void) = 8 bits.
        Width = $int2ulong(0);
        Align = 8;
        break;
       case Bool:
        Width = $uint2ulong(Target.getBoolWidth());
        Align = Target.getBoolAlign();
        break;
       case Char_S:
       case Char_U:
       case UChar:
       case SChar:
        Width = $uint2ulong(Target.getCharWidth());
        Align = Target.getCharAlign();
        break;
       case WChar_S:
       case WChar_U:
        Width = $uint2ulong(Target.getWCharWidth());
        Align = Target.getWCharAlign();
        break;
       case Char16:
        Width = $uint2ulong(Target.getChar16Width());
        Align = Target.getChar16Align();
        break;
       case Char32:
        Width = $uint2ulong(Target.getChar32Width());
        Align = Target.getChar32Align();
        break;
       case UShort:
       case Short:
        Width = $uint2ulong(Target.getShortWidth());
        Align = Target.getShortAlign();
        break;
       case UInt:
       case Int:
        Width = $uint2ulong(Target.getIntWidth());
        Align = Target.getIntAlign();
        break;
       case ULong:
       case Long:
        Width = $uint2ulong(Target.getLongWidth());
        Align = Target.getLongAlign();
        break;
       case ULongLong:
       case LongLong:
        Width = $uint2ulong(Target.getLongLongWidth());
        Align = Target.getLongLongAlign();
        break;
       case Int128:
       case UInt128:
        Width = $int2ulong(128);
        Align = 128; // int128_t is 128-bit aligned on all targets.
        break;
       case Half:
        Width = $uint2ulong(Target.getHalfWidth());
        Align = Target.getHalfAlign();
        break;
       case Float:
        Width = $uint2ulong(Target.getFloatWidth());
        Align = Target.getFloatAlign();
        break;
       case Double:
        Width = $uint2ulong(Target.getDoubleWidth());
        Align = Target.getDoubleAlign();
        break;
       case LongDouble:
        Width = $uint2ulong(Target.getLongDoubleWidth());
        Align = Target.getLongDoubleAlign();
        break;
       case Float128:
        Width = $uint2ulong(Target.getFloat128Width());
        Align = Target.getFloat128Align();
        break;
       case NullPtr:
        Width = Target.getPointerWidth(0); // C++ 3.9.1p11: sizeof(nullptr_t)
        Align = $ulong2uint(Target.getPointerAlign(0)); //   == sizeof(void*)
        break;
       case ObjCId:
       case ObjCClass:
       case ObjCSel:
        Width = Target.getPointerWidth(0);
        Align = $ulong2uint(Target.getPointerAlign(0));
        break;
       case OCLSampler:
        // Samplers are modeled as integers.
        Width = $uint2ulong(Target.getIntWidth());
        Align = Target.getIntAlign();
        break;
       case OCLEvent:
       case OCLClkEvent:
       case OCLQueue:
       case OCLNDRange:
       case OCLReserveID:
       case OCLImage1dRO:
       case OCLImage1dArrayRO:
       case OCLImage1dBufferRO:
       case OCLImage2dRO:
       case OCLImage2dArrayRO:
       case OCLImage2dDepthRO:
       case OCLImage2dArrayDepthRO:
       case OCLImage2dMSAARO:
       case OCLImage2dArrayMSAARO:
       case OCLImage2dMSAADepthRO:
       case OCLImage2dArrayMSAADepthRO:
       case OCLImage3dRO:
       case OCLImage1dWO:
       case OCLImage1dArrayWO:
       case OCLImage1dBufferWO:
       case OCLImage2dWO:
       case OCLImage2dArrayWO:
       case OCLImage2dDepthWO:
       case OCLImage2dArrayDepthWO:
       case OCLImage2dMSAAWO:
       case OCLImage2dArrayMSAAWO:
       case OCLImage2dMSAADepthWO:
       case OCLImage2dArrayMSAADepthWO:
       case OCLImage3dWO:
       case OCLImage1dRW:
       case OCLImage1dArrayRW:
       case OCLImage1dBufferRW:
       case OCLImage2dRW:
       case OCLImage2dArrayRW:
       case OCLImage2dDepthRW:
       case OCLImage2dArrayDepthRW:
       case OCLImage2dMSAARW:
       case OCLImage2dArrayMSAARW:
       case OCLImage2dMSAADepthRW:
       case OCLImage2dArrayMSAADepthRW:
       case OCLImage3dRW:
        
        // Currently these types are pointers to opaque types.
        Width = Target.getPointerWidth(0);
        Align = $ulong2uint(Target.getPointerAlign(0));
        break;
      }
      break;
     case ObjCObjectPointer:
      Width = Target.getPointerWidth(0);
      Align = $ulong2uint(Target.getPointerAlign(0));
      break;
     case BlockPointer:
      {
        /*uint*/int AS = getTargetAddressSpace(cast_BlockPointerType(T).getPointeeType());
        Width = Target.getPointerWidth(AS);
        Align = $ulong2uint(Target.getPointerAlign(AS));
        break;
      }
     case LValueReference:
     case RValueReference:
      {
        // alignof and sizeof should never enter this code path here, so we go
        // the pointer route.
        /*uint*/int AS = getTargetAddressSpace(cast_ReferenceType(T).getPointeeType());
        Width = Target.getPointerWidth(AS);
        Align = $ulong2uint(Target.getPointerAlign(AS));
        break;
      }
     case Pointer:
      {
        /*uint*/int AS = getTargetAddressSpace(cast_PointerType(T).getPointeeType());
        Width = Target.getPointerWidth(AS);
        Align = $ulong2uint(Target.getPointerAlign(AS));
        break;
      }
     case MemberPointer:
      {
        /*const*/ MemberPointerType /*P*/ MPT = cast_MemberPointerType(T);
        // JAVA: unfold std.tie
//        std.tie(Width, Align).$assign(ABI.$arrow().getMemberPointerWidthAndAlign(MPT));
          std.pairULongUInt $Pair = ABI.$arrow().getMemberPointerWidthAndAlign(MPT);
          Width = $Pair.first;
          Align = $Pair.second;
        break;
      }
     case Complex:
      {
        // Complex types have the same alignment as their elements, but twice the
        // size.
        TypeInfo EltInfo = getTypeInfo(cast_ComplexType(T).getElementType());
        Width = EltInfo.Width * $int2ullong(2);
        Align = EltInfo.Align;
        break;
      }
     case ObjCObject:
      return getTypeInfo(cast_ObjCObjectType(T).getBaseType().getTypePtr());
     case Adjusted:
     case Decayed:
      return getTypeInfo(cast_AdjustedType(T).getAdjustedType().getTypePtr());
     case ObjCInterface:
      {
        /*const*/ ObjCInterfaceType /*P*/ ObjCI = cast_ObjCInterfaceType(T);
        final /*const*/ ASTRecordLayout /*&*/ Layout = getASTObjCInterfaceLayout(ObjCI.getDecl());
        Width = toBits(Layout.getSize());
        Align = $long2uint(toBits(Layout.getAlignment()));
        break;
      }
     case Record:
     case Enum:
      {
        /*const*/ TagType /*P*/ TT = cast_TagType(T);
        if (TT.getDecl().isInvalidDecl()) {
          Width = $int2ulong(8);
          Align = 8;
          break;
        }
        {
          
          /*const*/ EnumType /*P*/ ET = dyn_cast_EnumType(TT);
          if ((ET != null)) {
            /*const*/ EnumDecl /*P*/ ED = ET.getDecl();
            TypeInfo Info = getTypeInfo(ED.getIntegerType().$arrow().getUnqualifiedDesugaredType());
            {
              /*uint*/int AttrAlign = ED.getMaxAlignment();
              if ((AttrAlign != 0)) {
                Info.Align = AttrAlign;
                Info.AlignIsRequired = true;
              }
            }
            return Info;
          }
        }
        
        /*const*/ RecordType /*P*/ RT = cast_RecordType(TT);
        /*const*/ RecordDecl /*P*/ RD = RT.getDecl();
        final /*const*/ ASTRecordLayout /*&*/ Layout = getASTRecordLayout(RD);
        Width = toBits(Layout.getSize());
        Align = $long2uint(toBits(Layout.getAlignment()));
        AlignIsRequired = RD.hasAttr(AlignedAttr.class);
        break;
      }
     case SubstTemplateTypeParm:
      return getTypeInfo(cast_SubstTemplateTypeParmType(T).
              getReplacementType().getTypePtr());
     case Auto:
      {
        /*const*/ AutoType /*P*/ A = cast_AutoType(T);
        assert (!A.getDeducedType().isNull()) : "cannot request the size of an undeduced or dependent auto type";
        return getTypeInfo(A.getDeducedType().getTypePtr());
      }
     case Paren:
      return getTypeInfo(cast_ParenType(T).getInnerType().getTypePtr());
     case Typedef:
      {
        /*const*/ TypedefNameDecl /*P*/ Typedef = cast_TypedefType(T).getDecl();
        TypeInfo Info = getTypeInfo(Typedef.getUnderlyingType().getTypePtr());
        {
          // If the typedef has an aligned attribute on it, it overrides any computed
          // alignment we have.  This violates the GCC documentation (which says that
          // attribute(aligned) can only round up) but matches its implementation.
          /*uint*/int AttrAlign = Typedef.getMaxAlignment();
          if ((AttrAlign != 0)) {
            Align = AttrAlign;
            AlignIsRequired = true;
          } else {
            Align = Info.Align;
            AlignIsRequired = Info.AlignIsRequired;
          }
        }
        Width = Info.Width;
        break;
      }
     case Elaborated:
      return getTypeInfo(cast_ElaboratedType(T).getNamedType().getTypePtr());
     case Attributed:
      return getTypeInfo(cast_AttributedType(T).getEquivalentType().getTypePtr());
     case Atomic:
      {
        // Start with the base type information.
        TypeInfo Info = getTypeInfo(cast_AtomicType(T).getValueType());
        Width = Info.Width;
        Align = Info.Align;
        
        // If the size of the type doesn't exceed the platform's max
        // atomic promotion width, make the size and alignment more
        // favorable to atomic operations:
        if (Width != $int2ullong(0) && $lesseq_ulong_uint(Width, Target.getMaxAtomicPromoteWidth())) {
          // Round the size up to a power of 2.
          if (!llvm.isPowerOf2_64(Width)) {
            Width = llvm.NextPowerOf2(Width);
          }
          
          // Set the alignment equal to the size.
          Align = ((/*static_cast*//*uint*/int)($ulong2uint(Width)));
        }
      }
      break;
     case Pipe:
      {
        TypeInfo Info = getTypeInfo(cast_PipeType(T).getElementType());
        Width = Info.Width;
        Align = Info.Align;
      }
    }
    assert (llvm.isPowerOf2_32(Align)) : "Alignment must be power of 2";
    return new TypeInfo(Width, Align, AlignIsRequired);
  }


  //===--------------------------------------------------------------------===//
  //                         Type Predicates.
  //===--------------------------------------------------------------------===//
  /*public:*/
  /// \brief Return one of the GCNone, Weak or Strong Objective-C garbage
  /// collection attributes.
  
  //===----------------------------------------------------------------------===//
  //                        Type Predicates.
  //===----------------------------------------------------------------------===//
  
  /// getObjCGCAttr - Returns one of GCNone, Weak or Strong objc's
  /// garbage collection attribute.
  ///
  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::getObjCGCAttrKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp", line = 6718,
   FQN="clang::ASTContext::getObjCGCAttrKind", NM="_ZNK5clang10ASTContext17getObjCGCAttrKindENS_8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZNK5clang10ASTContext17getObjCGCAttrKindENS_8QualTypeE")
  //</editor-fold>
  public Qualifiers.GC getObjCGCAttrKind(QualType Ty) /*const*/ {
    if (getLangOpts().getGC() == LangOptions.GCMode.NonGC) {
      return Qualifiers.GC.GCNone;
  }
    assert Native.$bool(getLangOpts().ObjC1);
    Qualifiers.GC GCAttrs = Ty.getObjCGCAttr();

    // Default behaviour under objective-C's gc is for ObjC pointers
    // (or pointers to them) be treated as though they were declared
    // as __strong.
    if (GCAttrs == Qualifiers.GC.GCNone) {
      if (Ty.$arrow().isObjCObjectPointerType() || Ty.$arrow().isBlockPointerType()) {
        return Qualifiers.GC.Strong;
      } else if (Ty.$arrow().isPointerType()) {
        return getObjCGCAttrKind(Ty.$arrow().getAs(PointerType.class).getPointeeType());
      }
    } else {
      QualType CT = Ty.$arrow().getCanonicalTypeInternal();
      {
        /*const*/ ArrayType /*P*/ AT;
        while (((/*P*/ AT = dyn_cast_ArrayType(CT)) != null)) {
          CT.$assignMove(AT.getElementType());
        }
      }
      assert (CT.$arrow().isAnyPointerType() || CT.$arrow().isBlockPointerType());
    }
    return GCAttrs;
  }
  
  
  /// \brief Return true if the given vector types are of the same unqualified
  /// type or if they are equivalent to the same GCC vector type.
  ///
  /// \note This ignores whether they are target-specific (AltiVec or Neon)
  /// types.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::areCompatibleVectorTypes">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp", line = 6759,
   FQN="clang::ASTContext::areCompatibleVectorTypes", NM="_ZN5clang10ASTContext24areCompatibleVectorTypesENS_8QualTypeES1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZN5clang10ASTContext24areCompatibleVectorTypesENS_8QualTypeES1_")
  //</editor-fold>
  public boolean areCompatibleVectorTypes(QualType FirstVec, 
                          QualType SecondVec) {
    assert (FirstVec.$arrow().isVectorType()) : "FirstVec should be a vector type";
    assert (SecondVec.$arrow().isVectorType()) : "SecondVec should be a vector type";
    if (hasSameUnqualifiedType(new QualType(FirstVec), new QualType(SecondVec))) {
      return true;
    }

    // Treat Neon vector types and most AltiVec vector types as if they are the
    // equivalent GCC vector types.
    /*const*/ VectorType /*P*/ First = FirstVec.$arrow().getAs(VectorType.class);
    /*const*/ VectorType /*P*/ Second = SecondVec.$arrow().getAs(VectorType.class);
    if (First.getNumElements() == Second.getNumElements()
       && hasSameType(First.getElementType(), Second.getElementType())
       && First.getVectorKind() != VectorType.VectorKind.AltiVecPixel
       && First.getVectorKind() != VectorType.VectorKind.AltiVecBool
       && Second.getVectorKind() != VectorType.VectorKind.AltiVecPixel
       && Second.getVectorKind() != VectorType.VectorKind.AltiVecBool) {
      return true;
    }
  
    return false;
  }

  
  /// \brief Return true if this is an \c NSObject object with its \c NSObject
  /// attribute set.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::isObjCNSObjectType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ASTContext.h", line = 1793,
   FQN="clang::ASTContext::isObjCNSObjectType", NM="_ZN5clang10ASTContext18isObjCNSObjectTypeENS_8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZN5clang10ASTContext18isObjCNSObjectTypeENS_8QualTypeE")
  //</editor-fold>
  public static boolean isObjCNSObjectType(QualType Ty) {
    return Ty.$arrow().isObjCNSObjectType();
  }

  
  //===--------------------------------------------------------------------===//
  //                         Type Sizing and Analysis
  //===--------------------------------------------------------------------===//
  
  /// \brief Return the APFloat 'semantics' for the specified scalar floating
  /// point type.
  
  //===----------------------------------------------------------------------===//
  //                         Type Sizing and Analysis
  //===----------------------------------------------------------------------===//
  
  /// getFloatTypeSemantics - Return the APFloat 'semantics' for the specified
  /// scalar floating point type.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::getFloatTypeSemantics">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp", line = 1340,
   FQN="clang::ASTContext::getFloatTypeSemantics", NM="_ZNK5clang10ASTContext21getFloatTypeSemanticsENS_8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZNK5clang10ASTContext21getFloatTypeSemanticsENS_8QualTypeE")
  //</editor-fold>
  public /*const*/ fltSemantics /*&*/ getFloatTypeSemantics(QualType T) /*const*/ {
    /*const*/ BuiltinType /*P*/ BT = T.$arrow().getAs$BuiltinType();
    assert ((BT != null)) : "Not a floating point type!";
    switch (BT.getKind()) {
     default:
      throw new llvm_unreachable("Not a floating point type!");
     case Half:
      return Target.getHalfFormat();
     case Float:
      return Target.getFloatFormat();
     case Double:
      return Target.getDoubleFormat();
     case LongDouble:
      return Target.getLongDoubleFormat();
     case Float128:
      return Target.getFloat128Format();
    }
  }

  
  /// \brief Get the size and alignment of the specified complete type in bits.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::getTypeInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp", line = 1507,
   FQN="clang::ASTContext::getTypeInfo", NM="_ZNK5clang10ASTContext11getTypeInfoEPKNS_4TypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZNK5clang10ASTContext11getTypeInfoEPKNS_4TypeE")
  //</editor-fold>
  public TypeInfo getTypeInfo(/*const*/ Type /*P*/ T) /*const*/ {
    DenseMapIterator</*const*/ Type /*P*/ , TypeInfo> I = MemoizedTypeInfo.find(T);
    if (I.$noteq(/*NO_ITER_COPY*/MemoizedTypeInfo.end())) {
      return new TypeInfo(I.$arrow().second);
    }
    
    // This call can invalidate MemoizedTypeInfo[T], so we need a second lookup.
    TypeInfo TI = getTypeInfoImpl(T);
    MemoizedTypeInfo.$at_T1$C$R(T).$assign(TI);
    return TI;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::getTypeInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ASTContext.h", line = 1807,
   FQN="clang::ASTContext::getTypeInfo", NM="_ZNK5clang10ASTContext11getTypeInfoENS_8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZNK5clang10ASTContext11getTypeInfoENS_8QualTypeE")
  //</editor-fold>
  public TypeInfo getTypeInfo(QualType T) /*const*/ {
    return getTypeInfo(T.getTypePtr());
  }

  
  /// \brief Get default simd alignment of the specified complete type in bits.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::getOpenMPDefaultSimdAlign">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp", line = 1846,
   FQN="clang::ASTContext::getOpenMPDefaultSimdAlign", NM="_ZNK5clang10ASTContext25getOpenMPDefaultSimdAlignENS_8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZNK5clang10ASTContext25getOpenMPDefaultSimdAlignENS_8QualTypeE")
  //</editor-fold>
  public /*uint*/int getOpenMPDefaultSimdAlign(QualType T) /*const*/ {
    /*uint*/int SimdAlign = getTargetInfo().getSimdDefaultAlign();
    // Target ppc64 with QPX: simd default alignment for pointer to double is 32.
    if ((getTargetInfo().getTriple().getArch() == Triple.ArchType.ppc64
       || getTargetInfo().getTriple().getArch() == Triple.ArchType.ppc64le)
       && $eq_StringRef(getTargetInfo().getABI(), /*STRINGREF_STR*/"elfv1-qpx")
       && T.$arrow().isSpecificBuiltinType(BuiltinType.Kind.Double.getValue())) {
      SimdAlign = 256;
    }
    return SimdAlign;
  }

  
  /// \brief Return the size of the specified (complete) type \p T, in bits.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::getTypeSize">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ASTContext.h", line = 1813,
   FQN="clang::ASTContext::getTypeSize", NM="_ZNK5clang10ASTContext11getTypeSizeENS_8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZNK5clang10ASTContext11getTypeSizeENS_8QualTypeE")
  //</editor-fold>
  public long/*uint64_t*/ getTypeSize(QualType T) /*const*/ {
    return getTypeInfo(new QualType(T)).Width;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::getTypeSize">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ASTContext.h", line = 1814,
   FQN="clang::ASTContext::getTypeSize", NM="_ZNK5clang10ASTContext11getTypeSizeEPKNS_4TypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZNK5clang10ASTContext11getTypeSizeEPKNS_4TypeE")
  //</editor-fold>
  public long/*uint64_t*/ getTypeSize(/*const*/ Type /*P*/ T) /*const*/ {
    return getTypeInfo(T).Width;
  }

  
  /// \brief Return the size of the character type, in bits.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::getCharWidth">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ASTContext.h", line = 1817,
   FQN="clang::ASTContext::getCharWidth", NM="_ZNK5clang10ASTContext12getCharWidthEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZNK5clang10ASTContext12getCharWidthEv")
  //</editor-fold>
  public long/*uint64_t*/ getCharWidth() /*const*/ {
    return getTypeSize(CharTy.$QualType());
  }

  
  /// \brief Convert a size in bits to a size in characters.
  
  /// toCharUnitsFromBits - Convert a size in bits to a size in characters.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::toCharUnitsFromBits">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp", line = 1858,
   FQN="clang::ASTContext::toCharUnitsFromBits", NM="_ZNK5clang10ASTContext19toCharUnitsFromBitsEx",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZNK5clang10ASTContext19toCharUnitsFromBitsEx")
  //</editor-fold>
  public CharUnits toCharUnitsFromBits(long/*int64_t*/ BitSize) /*const*/ {
    return CharUnits.fromQuantity($div_ullong_ulong(BitSize, getCharWidth()));
  }

  
  /// \brief Convert a size in characters to a size in bits.
  
  /// toBits - Convert a size in characters to a size in characters.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::toBits">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp", line = 1863,
   FQN="clang::ASTContext::toBits", NM="_ZNK5clang10ASTContext6toBitsENS_9CharUnitsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZNK5clang10ASTContext6toBitsENS_9CharUnitsE")
  //</editor-fold>
  public long/*int64_t*/ toBits(CharUnits CharSize) /*const*/ {
    return CharSize.getQuantity() * getCharWidth();
  }

  
  /// \brief Return the size of the specified (complete) type \p T, in
  /// characters.
  
  /// getTypeSizeInChars - Return the size of the specified type, in characters.
  /// This method does not work on incomplete types.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::getTypeSizeInChars">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp", line = 1869,
   FQN="clang::ASTContext::getTypeSizeInChars", NM="_ZNK5clang10ASTContext18getTypeSizeInCharsENS_8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZNK5clang10ASTContext18getTypeSizeInCharsENS_8QualTypeE")
  //</editor-fold>
  public CharUnits getTypeSizeInChars(QualType T) /*const*/ {
    return new CharUnits(JD$Move.INSTANCE, getTypeInfoInChars(new QualType(T)).first);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::getTypeSizeInChars">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp", line = 1872,
   FQN="clang::ASTContext::getTypeSizeInChars", NM="_ZNK5clang10ASTContext18getTypeSizeInCharsEPKNS_4TypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZNK5clang10ASTContext18getTypeSizeInCharsEPKNS_4TypeE")
  //</editor-fold>
  public CharUnits getTypeSizeInChars(/*const*/ Type /*P*/ T) /*const*/ {
    return new CharUnits(JD$Move.INSTANCE, getTypeInfoInChars(T).first);
  }

  
  /// \brief Return the ABI-specified alignment of a (complete) type \p T, in
  /// bits.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::getTypeAlign">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ASTContext.h", line = 1834,
   FQN="clang::ASTContext::getTypeAlign", NM="_ZNK5clang10ASTContext12getTypeAlignENS_8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZNK5clang10ASTContext12getTypeAlignENS_8QualTypeE")
  //</editor-fold>
  public /*uint*/int getTypeAlign(QualType T) /*const*/ {
    return getTypeInfo(new QualType(T)).Align;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::getTypeAlign">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ASTContext.h", line = 1835,
   FQN="clang::ASTContext::getTypeAlign", NM="_ZNK5clang10ASTContext12getTypeAlignEPKNS_4TypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZNK5clang10ASTContext12getTypeAlignEPKNS_4TypeE")
  //</editor-fold>
  public /*uint*/int getTypeAlign(/*const*/ Type /*P*/ T) /*const*/ {
    return getTypeInfo(T).Align;
  }

  
  /// \brief Return the ABI-specified alignment of a (complete) type \p T, in 
  /// characters.
  
  /// getTypeAlignInChars - Return the ABI-specified alignment of a type, in 
  /// characters. This method does not work on incomplete types.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::getTypeAlignInChars">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp", line = 1878,
   FQN="clang::ASTContext::getTypeAlignInChars", NM="_ZNK5clang10ASTContext19getTypeAlignInCharsENS_8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZNK5clang10ASTContext19getTypeAlignInCharsENS_8QualTypeE")
  //</editor-fold>
  public CharUnits getTypeAlignInChars(QualType T) /*const*/ {
    return toCharUnitsFromBits($uint2long(getTypeAlign(new QualType(T))));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::getTypeAlignInChars">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp", line = 1881,
   FQN="clang::ASTContext::getTypeAlignInChars", NM="_ZNK5clang10ASTContext19getTypeAlignInCharsEPKNS_4TypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZNK5clang10ASTContext19getTypeAlignInCharsEPKNS_4TypeE")
  //</editor-fold>
  public CharUnits getTypeAlignInChars(/*const*/ Type /*P*/ T) /*const*/ {
    return toCharUnitsFromBits($uint2long(getTypeAlign(T)));
  }

  
  // getTypeInfoDataSizeInChars - Return the size of a type, in chars. If the
  // type is a record, its data size is returned.
  
  // getTypeInfoDataSizeInChars - Return the size of a type, in
  // chars. If the type is a record, its data size is returned.  This is
  // the size of the memcpy that's performed when assigning this type
  // using a trivial copy/move assignment operator.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::getTypeInfoDataSizeInChars">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp", line = 1448,
   FQN="clang::ASTContext::getTypeInfoDataSizeInChars", NM="_ZNK5clang10ASTContext26getTypeInfoDataSizeInCharsENS_8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZNK5clang10ASTContext26getTypeInfoDataSizeInCharsENS_8QualTypeE")
  //</editor-fold>
  public std.pair<CharUnits, CharUnits> getTypeInfoDataSizeInChars(QualType T) /*const*/ {
    std.pair<CharUnits, CharUnits> sizeAndAlign = getTypeInfoInChars(new QualType(T));
    
    // In C++, objects can sometimes be allocated into the tail padding
    // of a base-class subobject.  We decide whether that's possible
    // during class layout, so here we can just trust the layout results.
    if (getLangOpts().CPlusPlus) {
      {
        /*const*/ RecordType /*P*/ RT = T.$arrow().getAs$RecordType();
        if ((RT != null)) {
          final /*const*/ ASTRecordLayout /*&*/ layout = getASTRecordLayout(RT.getDecl());
          sizeAndAlign.first.$assignMove(layout.getDataSize());
        }
      }
    }

    return sizeAndAlign;
  }
  
  
  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::getTypeInfoInChars">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp", line = 1485,
   FQN="clang::ASTContext::getTypeInfoInChars", NM="_ZNK5clang10ASTContext18getTypeInfoInCharsEPKNS_4TypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZNK5clang10ASTContext18getTypeInfoInCharsEPKNS_4TypeE")
  //</editor-fold>
  public std.pairTypeType<CharUnits, CharUnits> getTypeInfoInChars(/*const*/ Type /*P*/ T) /*const*/ {
    {
      /*const*/ ConstantArrayType /*P*/ CAT = dyn_cast_ConstantArrayType(T);
      if ((CAT != null)) {
        return getConstantArrayInfoInChars(/*Deref*/this, CAT);
      }
    }
    TypeInfo Info = getTypeInfo(T);
    return std.make_pair(toCharUnitsFromBits(Info.Width), 
        toCharUnitsFromBits($uint2long(Info.Align)));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::getTypeInfoInChars">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp", line = 1494,
   FQN="clang::ASTContext::getTypeInfoInChars", NM="_ZNK5clang10ASTContext18getTypeInfoInCharsENS_8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZNK5clang10ASTContext18getTypeInfoInCharsENS_8QualTypeE")
  //</editor-fold>
  public std.pairTypeType<CharUnits, CharUnits> getTypeInfoInChars(QualType T) /*const*/ {
    return getTypeInfoInChars(T.getTypePtr());
  }

  
  /// \brief Determine if the alignment the type has was required using an
  /// alignment attribute.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::isAlignmentRequired">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp", line = 1499,
   FQN="clang::ASTContext::isAlignmentRequired", NM="_ZNK5clang10ASTContext19isAlignmentRequiredEPKNS_4TypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZNK5clang10ASTContext19isAlignmentRequiredEPKNS_4TypeE")
  //</editor-fold>
  public boolean isAlignmentRequired(/*const*/ Type /*P*/ T) /*const*/ {
    return getTypeInfo(T).AlignIsRequired;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::isAlignmentRequired">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp", line = 1503,
   FQN="clang::ASTContext::isAlignmentRequired", NM="_ZNK5clang10ASTContext19isAlignmentRequiredENS_8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZNK5clang10ASTContext19isAlignmentRequiredENS_8QualTypeE")
  //</editor-fold>
  public boolean isAlignmentRequired(QualType T) /*const*/ {
    return isAlignmentRequired(T.getTypePtr());
  }

  
  /// \brief Return the "preferred" alignment of the specified type \p T for
  /// the current target, in bits.
  ///
  /// This can be different than the ABI alignment in cases where it is
  /// beneficial for performance to overalign a data type.
  
  /// getPreferredTypeAlign - Return the "preferred" alignment of the specified
  /// type for the current target in bits.  This can be different than the ABI
  /// alignment in cases where it is beneficial for performance to overalign
  /// a data type.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::getPreferredTypeAlign">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp", line = 1889,
   FQN="clang::ASTContext::getPreferredTypeAlign", NM="_ZNK5clang10ASTContext21getPreferredTypeAlignEPKNS_4TypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZNK5clang10ASTContext21getPreferredTypeAlignEPKNS_4TypeE")
  //</editor-fold>
  public /*uint*/int getPreferredTypeAlign(/*const*/ Type /*P*/ T) /*const*/ {
    TypeInfo TI = getTypeInfo(T);
    /*uint*/int ABIAlign = TI.Align;
    
    T = T.getBaseElementTypeUnsafe();
    
    // The preferred alignment of member pointers is that of a pointer.
    if (T.isMemberPointerType()) {
      return getPreferredTypeAlign(getPointerDiffType().getTypePtr());
    }
    if (!Target.allowsLargerPreferedTypeAlignment()) {
      return ABIAlign;
    }
    {

      // Double and long long should be naturally aligned if possible.
      /*const*/ ComplexType /*P*/ CT = T.getAs(ComplexType.class);
      if ((CT != null)) {
        T = CT.getElementType().getTypePtr();
      }
    }
    {
      /*const*/ EnumType /*P*/ ET = T.getAs$EnumType();
      if ((ET != null)) {
        T = ET.getDecl().getIntegerType().getTypePtr();
      }
    }
    if (T.isSpecificBuiltinType(BuiltinType.Kind.Double.getValue())
       || T.isSpecificBuiltinType(BuiltinType.Kind.LongLong.getValue())
       || T.isSpecificBuiltinType(BuiltinType.Kind.ULongLong.getValue())) {
      // Don't increase the alignment if an alignment attribute was specified on a
      // typedef declaration.
      if (!TI.AlignIsRequired) {
        return std.max(ABIAlign, (/*uint*/int)$ulong2uint(getTypeSize(T)));
      }
    }
  
    return ABIAlign;
  }

  
  /// \brief Return the default alignment for __attribute__((aligned)) on
  /// this target, to be used if no alignment value is specified.
  
  /// getTargetDefaultAlignForAttributeAligned - Return the default alignment
  /// for __attribute__((aligned)) on this target, to be used if no alignment
  /// value is specified.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::getTargetDefaultAlignForAttributeAligned">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp", line = 1921,
   FQN="clang::ASTContext::getTargetDefaultAlignForAttributeAligned", NM="_ZNK5clang10ASTContext40getTargetDefaultAlignForAttributeAlignedEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZNK5clang10ASTContext40getTargetDefaultAlignForAttributeAlignedEv")
  //</editor-fold>
  public /*uint*/int getTargetDefaultAlignForAttributeAligned() /*const*/ {
    return getTargetInfo().getDefaultAlignForAttributeAligned();
  }

  
  /// \brief Return the alignment in bits that should be given to a
  /// global variable with type \p T.
  
  /// getAlignOfGlobalVar - Return the alignment in bits that should be given
  /// to a global variable of the specified type.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::getAlignOfGlobalVar">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp", line = 1927,
   FQN="clang::ASTContext::getAlignOfGlobalVar", NM="_ZNK5clang10ASTContext19getAlignOfGlobalVarENS_8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZNK5clang10ASTContext19getAlignOfGlobalVarENS_8QualTypeE")
  //</editor-fold>
  public /*uint*/int getAlignOfGlobalVar(QualType T) /*const*/ {
    return std.max(getTypeAlign(new QualType(T)), getTargetInfo().getMinGlobalAlign());
  }

  
  /// \brief Return the alignment in characters that should be given to a
  /// global variable with type \p T.
  
  /// getAlignOfGlobalVarInChars - Return the alignment in characters that
  /// should be given to a global variable of the specified type.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::getAlignOfGlobalVarInChars">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp", line = 1933,
   FQN="clang::ASTContext::getAlignOfGlobalVarInChars", NM="_ZNK5clang10ASTContext26getAlignOfGlobalVarInCharsENS_8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZNK5clang10ASTContext26getAlignOfGlobalVarInCharsENS_8QualTypeE")
  //</editor-fold>
  public CharUnits getAlignOfGlobalVarInChars(QualType T) /*const*/ {
    return toCharUnitsFromBits($uint2long(getAlignOfGlobalVar(new QualType(T))));
  }

  
  /// \brief Return a conservative estimate of the alignment of the specified
  /// decl \p D.
  ///
  /// \pre \p D must not be a bitfield type, as bitfields do not have a valid
  /// alignment.
  ///
  /// If \p ForAlignof, references are treated like their underlying type
  /// and  large arrays don't get any special treatment. If not \p ForAlignof
  /// it computes the value expected by CodeGen: references are treated like
  /// pointers and large arrays get extra alignment.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::getDeclAlign">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp", line = 1353,
   FQN="clang::ASTContext::getDeclAlign", NM="_ZNK5clang10ASTContext12getDeclAlignEPKNS_4DeclEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZNK5clang10ASTContext12getDeclAlignEPKNS_4DeclEb")
  //</editor-fold>
  public CharUnits getDeclAlign(/*const*/ Decl /*P*/ D) /*const*/ {
    return getDeclAlign(D, false);
  }
  public CharUnits getDeclAlign(/*const*/ Decl /*P*/ D, boolean ForAlignof/*= false*/) /*const*/ {
    /*uint*/int Align = Target.getCharWidth();
    
    boolean UseAlignAttrOnly = false;
    {
      /*uint*/int AlignFromAttr = D.getMaxAlignment();
      if ((AlignFromAttr != 0)) {
        Align = AlignFromAttr;
        
        // __attribute__((aligned)) can increase or decrease alignment
        // *except* on a struct or struct member, where it only increases
        // alignment unless 'packed' is also specified.
        //
        // It is an error for alignas to decrease alignment, so we can
        // ignore that possibility;  Sema should diagnose it.
        if (isa_FieldDecl(D)) {
          UseAlignAttrOnly = D.hasAttr(PackedAttr.class)
             || cast_FieldDecl(D).getParent$Const().hasAttr(PackedAttr.class);
        } else {
          UseAlignAttrOnly = true;
    }
      } else if (isa_FieldDecl(D)) {
        UseAlignAttrOnly
           = D.hasAttr(PackedAttr.class)
           || cast_FieldDecl(D).getParent$Const().hasAttr(PackedAttr.class);
      }
    }

    // If we're using the align attribute only, just ignore everything
    // else about the declaration and its type.
    if (UseAlignAttrOnly) {
      // do nothing
    } else {
      /*const*/ ValueDecl /*P*/ VD = dyn_cast_ValueDecl(D);
      if ((VD != null)) {
        QualType T = VD.getType();
        {
          /*const*/ ReferenceType /*P*/ RT = T.$arrow().getAs(ReferenceType.class);
          if ((RT != null)) {
            if (ForAlignof) {
              T.$assignMove(RT.getPointeeType());
            } else {
              T.$assignMove(getPointerType(RT.getPointeeType()));
            }
          }
        }
        QualType BaseT = getBaseElementType(new QualType(T));
        if (!BaseT.$arrow().isIncompleteType() && !T.$arrow().isFunctionType()) {
          {
            // Adjust alignments of declarations with array type by the
            // large-array alignment on the target.
            /*const*/ ArrayType /*P*/ arrayType = getAsArrayType(new QualType(T));
            if ((arrayType != null)) {
              /*uint*/int MinWidth = Target.getLargeArrayMinWidth();
              if (!ForAlignof && (MinWidth != 0)) {
                if (isa_VariableArrayType(arrayType)) {
                  Align = std.max(Align, Target.getLargeArrayAlign());
                } else if (isa_ConstantArrayType(arrayType)
                   && $lesseq_uint_ulong(MinWidth, getTypeSize(cast_ConstantArrayType(arrayType)))) {
                  Align = std.max(Align, Target.getLargeArrayAlign());
                }
              }
            }
          }
          Align = std.max(Align, getPreferredTypeAlign(T.getTypePtr()));
          {
            /*const*/ VarDecl /*P*/ VD$1 = dyn_cast_VarDecl(D);
            if ((VD$1 != null)) {
              if (VD$1.hasGlobalStorage() && !ForAlignof) {
                Align = std.max(Align, getTargetInfo().getMinGlobalAlign());
              }
            }
          }
        }
        {
  
          // Fields can be subject to extra alignment constraints, like if
          // the field is packed, the struct is packed, or the struct has a
          // a max-field-alignment constraint (#pragma pack).  So calculate
          // the actual alignment of the field within the struct, and then
          // (as we're expected to) constrain that by the alignment of the type.
          /*const*/ FieldDecl /*P*/ Field = dyn_cast_FieldDecl(VD);
          if ((Field != null)) {
            /*const*/ RecordDecl /*P*/ Parent = Field.getParent$Const();
            // We can only produce a sensible answer if the record is valid.
            if (!Parent.isInvalidDecl()) {
              final /*const*/ ASTRecordLayout /*&*/ Layout = getASTRecordLayout(Parent);
              
              // Start with the record's overall alignment.
              /*uint*/int FieldAlign = $long2uint(toBits(Layout.getAlignment()));
              
              // Use the GCD of that and the offset within the record.
              long/*uint64_t*/ Offset = Layout.getFieldOffset(Field.getFieldIndex());
              if ($greater_ulong_ullong(Offset, $int2ullong(0))) {
                // Alignment is always a power of 2, so the GCD will be a power of 2,
                // which means we get to do this crazy thing instead of Euclid's.
                long/*uint64_t*/ LowBitOfOffset = Offset & (~Offset + $int2ullong(1));
                if ($less_ulong_uint(LowBitOfOffset, FieldAlign)) {
                  FieldAlign = ((/*static_cast*//*uint*/int)($ulong2uint(LowBitOfOffset)));
                }
              }
              
              Align = std.min_uint(Align, FieldAlign);
            }
          }
        }
      }
    }
    
    return toCharUnitsFromBits($uint2long(Align));
  }

  
  /// \brief Get or compute information about the layout of the specified
  /// record (struct/union/class) \p D, which indicates its size and field
  /// position information.
  
  /// \brief Get or compute information about the layout of the specified
  /// record (struct/union/class) \p D, which indicates its size and field
  /// position information.
  
  /// getASTRecordLayout - Get or compute information about the layout of the
  /// specified record (struct/union/class), which indicates its size and field
  /// position information.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::getASTRecordLayout">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/RecordLayoutBuilder.cpp", line = 2922,
   FQN="clang::ASTContext::getASTRecordLayout", NM="_ZNK5clang10ASTContext18getASTRecordLayoutEPKNS_10RecordDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/RecordLayoutBuilder.cpp -nm=_ZNK5clang10ASTContext18getASTRecordLayoutEPKNS_10RecordDeclE")
  //</editor-fold>
  public /*const*/ ASTRecordLayout /*&*/ getASTRecordLayout(/*const*/ RecordDecl /*P*/ D) /*const*/ {
    // These asserts test different things.  A record has a definition
    // as soon as we begin to parse the definition.  That definition is
    // not a complete definition (which is what isDefinition() tests)
    // until we *finish* parsing the definition.
    if (D.hasExternalLexicalStorage() && !(D.getDefinition() != null)) {
      getExternalSource().CompleteType(((/*const_cast*/RecordDecl /*P*/ )(D)));
    }
    
    D = D.getDefinition();
    assert ((D != null)) : "Cannot get layout of forward declarations!";
    assert (!D.isInvalidDecl()) : "Cannot get layout of invalid decl!";
    assert (D.isCompleteDefinition()) : "Cannot layout type before complete!";
    
    // Look up this layout, if already laid out, return what we have.
    // Note that we can't save a reference to the entry because this function
    // is recursive.
    /*const*/ ASTRecordLayout /*P*/ Entry = ASTRecordLayouts.$at_T1$C$R(D);
    if ((Entry != null)) {
      return $Deref(Entry);
    }
    
    /*const*/ ASTRecordLayout /*P*/ NewEntry = null;
    if (isMsLayout(/*Deref*/this)) {
      MicrosoftRecordLayoutBuilder $BuilderToDestroy = null;
      try {
        MicrosoftRecordLayoutBuilder Builder/*J*/= $BuilderToDestroy = new MicrosoftRecordLayoutBuilder(/*Deref*/this);
        {
          /*const*/ CXXRecordDecl /*P*/ RD = dyn_cast_CXXRecordDecl(D);
          if ((RD != null)) {
            Builder.cxxLayout(RD);
            NewEntry = /*NEW_EXPR [operator new] NM=_ZnwjRKN5clang10ASTContextEj*/
            /*new (*this)*/ $new_uint_ASTContext$C_uint(/*Deref*/this, (type$ptr<?> New$Mem)->{
                return new ASTRecordLayout(/*Deref*/this, new CharUnits(Builder.Size), new CharUnits(Builder.Alignment), new CharUnits(Builder.RequiredAlignment), 
                        Builder.HasOwnVFPtr, Builder.HasOwnVFPtr || (Builder.PrimaryBase != null), 
                        new CharUnits(Builder.VBPtrOffset), new CharUnits(Builder.DataSize), new ArrayRefULong(Builder.FieldOffsets), 
                        new CharUnits(Builder.NonVirtualSize), new CharUnits(Builder.Alignment), CharUnits.Zero(), 
                        Builder.PrimaryBase, false, Builder.SharedVBPtrBase, 
                        Builder.EndsWithZeroSizedObject, Builder.LeadsWithZeroSizedBase, 
                        Builder.Bases, Builder.VBases);
             });
          } else {
            Builder.layout(D);
            NewEntry = /*NEW_EXPR [operator new] NM=_ZnwjRKN5clang10ASTContextEj*/
            /*new (*this)*/ $new_uint_ASTContext$C_uint(/*Deref*/this, (type$ptr<?> New$Mem)->{
                return new ASTRecordLayout(/*Deref*/this, new CharUnits(Builder.Size), new CharUnits(Builder.Alignment), new CharUnits(Builder.RequiredAlignment), 
                        new CharUnits(Builder.Size), new ArrayRefULong(Builder.FieldOffsets));
             });
          }
        }
      } finally {
        if ($BuilderToDestroy != null) { $BuilderToDestroy.$destroy(); }
      }
    } else {
      {
        /*const*/ CXXRecordDecl /*P*/ RD = dyn_cast_CXXRecordDecl(D);
        if ((RD != null)) {
          EmptySubobjectMap $EmptySubobjectsToDestroy = null;
          ItaniumRecordLayoutBuilder $BuilderToDestroy = null;
          try {
            EmptySubobjectMap EmptySubobjects/*J*/= $EmptySubobjectsToDestroy = new EmptySubobjectMap(/*Deref*/this, RD);
            ItaniumRecordLayoutBuilder Builder/*J*/= $BuilderToDestroy = new ItaniumRecordLayoutBuilder(/*Deref*/this, $AddrOf(EmptySubobjects));
            Builder.Layout(RD);
            
            // In certain situations, we are allowed to lay out objects in the
            // tail-padding of base classes.  This is ABI-dependent.
            // FIXME: this should be stored in the record layout.
            boolean skipTailPadding = mustSkipTailPadding(getTargetInfo().getCXXABI(), RD);
            
            // FIXME: This should be done in FinalizeLayout.
            CharUnits DataSize = skipTailPadding ? Builder.getSize() : Builder.getDataSize();
            CharUnits NonVirtualSize = new CharUnits(skipTailPadding ? DataSize : Builder.NonVirtualSize);
            NewEntry = /*NEW_EXPR [operator new] NM=_ZnwjRKN5clang10ASTContextEj*/
            /*new (*this)*/ $new_uint_ASTContext$C_uint(/*Deref*/this, (type$ptr<?> New$Mem)->{
                return new ASTRecordLayout(/*Deref*/this, Builder.getSize(), new CharUnits(Builder.Alignment), 
                        /*RequiredAlignment : used by MS-ABI)*/
                        new CharUnits(Builder.Alignment), Builder.HasOwnVFPtr, RD.isDynamicClass(), 
                        CharUnits.fromQuantity(-1), new CharUnits(DataSize), new ArrayRefULong(Builder.FieldOffsets), 
                        new CharUnits(NonVirtualSize), new CharUnits(Builder.NonVirtualAlignment), 
                        new CharUnits(EmptySubobjects.SizeOfLargestEmptySubobject), Builder.PrimaryBase, 
                        Builder.PrimaryBaseIsVirtual, (/*const*/ CXXRecordDecl /*P*/ )null, false, false, Builder.Bases, 
                        Builder.VBases);
             });
          } finally {
            if ($BuilderToDestroy != null) { $BuilderToDestroy.$destroy(); }
            if ($EmptySubobjectsToDestroy != null) { $EmptySubobjectsToDestroy.$destroy(); }
          }
        } else {
          ItaniumRecordLayoutBuilder $BuilderToDestroy = null;
          try {
            ItaniumRecordLayoutBuilder Builder/*J*/= $BuilderToDestroy = new ItaniumRecordLayoutBuilder(/*Deref*/this, /*EmptySubobjects=*/ (EmptySubobjectMap /*P*/ )null);
            Builder.Layout(D);
            
            NewEntry = /*NEW_EXPR [operator new] NM=_ZnwjRKN5clang10ASTContextEj*/
            /*new (*this)*/ $new_uint_ASTContext$C_uint(/*Deref*/this, (type$ptr<?> New$Mem)->{
                return new ASTRecordLayout(/*Deref*/this, Builder.getSize(), new CharUnits(Builder.Alignment), 
                        /*RequiredAlignment : used by MS-ABI)*/
                        new CharUnits(Builder.Alignment), Builder.getSize(), new ArrayRefULong(Builder.FieldOffsets));
             });
          } finally {
            if ($BuilderToDestroy != null) { $BuilderToDestroy.$destroy(); }
          }
        }
      }
    }
    
    ASTRecordLayouts.$set(D, NewEntry);
    if (getLangOpts().DumpRecordLayouts) {
      llvm.outs().$out(/*KEEP_STR*/"\n*** Dumping AST Record Layout\n");
      DumpRecordLayout(D, llvm.outs(), getLangOpts().DumpRecordLayoutsSimple);
    }
    
    return $Deref(NewEntry);
  }
  
  /// \brief Get or compute information about the layout of the specified
  /// Objective-C interface.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::getASTObjCInterfaceLayout">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp", line = 2132,
   FQN="clang::ASTContext::getASTObjCInterfaceLayout", NM="_ZNK5clang10ASTContext25getASTObjCInterfaceLayoutEPKNS_17ObjCInterfaceDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZNK5clang10ASTContext25getASTObjCInterfaceLayoutEPKNS_17ObjCInterfaceDeclE")
  //</editor-fold>
  public /*const*/ ASTRecordLayout /*&*/ getASTObjCInterfaceLayout(/*const*/ ObjCInterfaceDecl /*P*/ D) /*const*/ {
    return getObjCLayout(D, (/*const*/ ObjCImplementationDecl /*P*/ )null);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::DumpRecordLayout">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/RecordLayoutBuilder.cpp", line = 3289,
   FQN="clang::ASTContext::DumpRecordLayout", NM="_ZNK5clang10ASTContext16DumpRecordLayoutEPKNS_10RecordDeclERN4llvm11raw_ostreamEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/RecordLayoutBuilder.cpp -nm=_ZNK5clang10ASTContext16DumpRecordLayoutEPKNS_10RecordDeclERN4llvm11raw_ostreamEb")
  //</editor-fold>
  public void DumpRecordLayout(/*const*/ RecordDecl /*P*/ RD, 
                  final raw_ostream /*&*/ OS) /*const*/ {
    DumpRecordLayout(RD, 
                  OS, 
                  false);
  }
  public void DumpRecordLayout(/*const*/ RecordDecl /*P*/ RD, 
                  final raw_ostream /*&*/ OS, 
                  boolean Simple/*= false*/) /*const*/ {
    if (!Simple) {
      /*::*/RecordLayoutBuilderStatics.DumpRecordLayout(OS, RD, /*Deref*/this, new CharUnits(), 0, (/*const*/char$ptr/*char P*/ )null, 
          /*PrintSizeInfo*/ true, 
          /*IncludeVirtualBases=*/ true);
      return;
    }

    // The "simple" format is designed to be parsed by the
    // layout-override testing code.  There shouldn't be any external
    // uses of this format --- when LLDB overrides a layout, it sets up
    // the data structures directly --- so feel free to adjust this as
    // you like as long as you also update the rudimentary parser for it
    // in libFrontend.
    final /*const*/ ASTRecordLayout /*&*/ Info = getASTRecordLayout(RD);
    OS.$out(/*KEEP_STR*/"Type: ").$out(getTypeDeclType(RD).getAsString()).$out(/*KEEP_STR*/$LF);
    OS.$out(/*KEEP_STR*/"\nLayout: ");
    OS.$out(/*KEEP_STR*/"<ASTRecordLayout\n");
    OS.$out(/*KEEP_STR*/"  Size:").$out_llong(toBits(Info.getSize())).$out(/*KEEP_STR*/$LF);
    if (!isMsLayout(/*Deref*/this)) {
      OS.$out(/*KEEP_STR*/"  DataSize:").$out_llong(toBits(Info.getDataSize())).$out(/*KEEP_STR*/$LF);
    }
    OS.$out(/*KEEP_STR*/"  Alignment:").$out_llong(toBits(Info.getAlignment())).$out(/*KEEP_STR*/$LF);
    OS.$out(/*KEEP_STR*/"  FieldOffsets: [");
    for (/*uint*/int i = 0, e = Info.getFieldCount(); i != e; ++i) {
      if ((i != 0)) {
        OS.$out(/*KEEP_STR*/$COMMA_SPACE);
      }
      OS.$out_ullong(Info.getFieldOffset(i));
    }
    OS.$out(/*KEEP_STR*/"]>\n");
  }

  
  
  /// \brief Get or compute information about the layout of the specified
  /// Objective-C implementation.
  ///
  /// This may differ from the interface if synthesized ivars are present.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::getASTObjCImplementationLayout">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp", line = 2137,
   FQN="clang::ASTContext::getASTObjCImplementationLayout", NM="_ZNK5clang10ASTContext30getASTObjCImplementationLayoutEPKNS_22ObjCImplementationDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZNK5clang10ASTContext30getASTObjCImplementationLayoutEPKNS_22ObjCImplementationDeclE")
  //</editor-fold>
  public /*const*/ ASTRecordLayout /*&*/ getASTObjCImplementationLayout(/*const*/ ObjCImplementationDecl /*P*/ D) /*const*/ {
    return getObjCLayout(D.getClassInterface$Const(), D);
  }

  
  /// \brief Get our current best idea for the key function of the
  /// given record decl, or NULL if there isn't one.
  ///
  /// The key function is, according to the Itanium C++ ABI section 5.2.3:
  ///   ...the first non-pure virtual function that is not inline at the
  ///   point of class definition.
  ///
  /// Other ABIs use the same idea.  However, the ARM C++ ABI ignores
  /// virtual functions that are defined 'inline', which means that
  /// the result of this computation can change.
  
  /// \brief Get our current best idea for the key function of the
  /// given record decl, or NULL if there isn't one.
  ///
  /// The key function is, according to the Itanium C++ ABI section 5.2.3:
  ///   ...the first non-pure virtual function that is not inline at the
  ///   point of class definition.
  ///
  /// Other ABIs use the same idea.  However, the ARM C++ ABI ignores
  /// virtual functions that are defined 'inline', which means that
  /// the result of this computation can change.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::getCurrentKeyFunction">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/RecordLayoutBuilder.cpp", line = 3010,
   FQN="clang::ASTContext::getCurrentKeyFunction", NM="_ZN5clang10ASTContext21getCurrentKeyFunctionEPKNS_13CXXRecordDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/RecordLayoutBuilder.cpp -nm=_ZN5clang10ASTContext21getCurrentKeyFunctionEPKNS_13CXXRecordDeclE")
  //</editor-fold>
  public /*const*/ CXXMethodDecl /*P*/ getCurrentKeyFunction(/*const*/ CXXRecordDecl /*P*/ RD) {
    if (!getTargetInfo().getCXXABI().hasKeyFunctions()) {
      return null;
    }
    assert ((RD.getDefinition() != null)) : "Cannot get key function for forward decl!";
    RD = cast_CXXRecordDecl(RD.getDefinition());

    // Beware:
    //  1) computing the key function might trigger deserialization, which might
    //     invalidate iterators into KeyFunctions
    //  2) 'get' on the LazyDeclPtr might also trigger deserialization and
    //     invalidate the LazyDeclPtr within the map itself
    LazyDeclPtr Entry = new LazyDeclPtr(KeyFunctions.$at_T1$C$R(RD));
    /*const*/ Decl /*P*/ Result = Entry.$bool() ? Entry.get(getExternalSource()) : computeKeyFunction(/*Deref*/this, RD);

    // Store it back if it changed.
    if (Entry.isOffset() || Entry.isValid() != ((boolean)((Result != null)))) {
      KeyFunctions.$at_T1$C$R(RD).$assign(((/*const_cast*/Decl /*P*/ )(Result)));
    }
  
    return cast_or_null_CXXMethodDecl(Result);
  }


  
  /// \brief Observe that the given method cannot be a key function.
  /// Checks the key-function cache for the method's class and clears it
  /// if matches the given declaration.
  ///
  /// This is used in ABIs where out-of-line definitions marked
  /// inline are not considered to be key functions.
  ///
  /// \param method should be the declaration from the class definition
  
  /// \brief Observe that the given method cannot be a key function.
  /// Checks the key-function cache for the method's class and clears it
  /// if matches the given declaration.
  ///
  /// This is used in ABIs where out-of-line definitions marked
  /// inline are not considered to be key functions.
  ///
  /// \param method should be the declaration from the class definition
  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::setNonKeyFunction">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/RecordLayoutBuilder.cpp", line = 3033,
   FQN="clang::ASTContext::setNonKeyFunction", NM="_ZN5clang10ASTContext17setNonKeyFunctionEPKNS_13CXXMethodDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/RecordLayoutBuilder.cpp -nm=_ZN5clang10ASTContext17setNonKeyFunctionEPKNS_13CXXMethodDeclE")
  //</editor-fold>
  public void setNonKeyFunction(/*const*/ CXXMethodDecl /*P*/ Method) {
    assert (Method == Method.getFirstDecl$Const()) : "not working with method declaration from class definition";
    
    // Look up the cache entry.  Since we're working with the first
    // declaration, its parent must be the class definition, which is
    // the correct key for the KeyFunctions hash.
    final /*const*/DenseMap</*const*/ CXXRecordDecl /*P*/ , LazyDeclPtr>/*&*/ Map = KeyFunctions;
    DenseMapIterator<CXXRecordDecl, LazyDeclPtr> I = Map.find$Const(Method.getParent$Const());
    
    // If it's not cached, there's nothing to do.
    if (I.$eq(Map.end$Const())) {
      return;
  }

    // If it is cached, check whether it's the target method, and if so,
    // remove it from the cache. Note, the call to 'get' might invalidate
    // the iterator and the LazyDeclPtr object within the map.
    LazyDeclPtr Ptr = new LazyDeclPtr(I.$arrow().second);
    if (Ptr.get(getExternalSource()) == Method) {
      // FIXME: remember that we did this for module / chained PCH state?
      KeyFunctions.erase(Method.getParent$Const());
    }
  }

  
  
  /// Loading virtual member pointers using the virtual inheritance model
  /// always results in an adjustment using the vbtable even if the index is
  /// zero.
  ///
  /// This is usually OK because the first slot in the vbtable points
  /// backwards to the top of the MDC.  However, the MDC might be reusing a
  /// vbptr from an nv-base.  In this case, the first slot in the vbtable
  /// points to the start of the nv-base which introduced the vbptr and *not*
  /// the MDC.  Modify the NonVirtualBaseAdjustment to account for this.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::getOffsetOfBaseWithVBPtr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp", line = 1937,
   FQN="clang::ASTContext::getOffsetOfBaseWithVBPtr", NM="_ZNK5clang10ASTContext24getOffsetOfBaseWithVBPtrEPKNS_13CXXRecordDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZNK5clang10ASTContext24getOffsetOfBaseWithVBPtrEPKNS_13CXXRecordDeclE")
  //</editor-fold>
  public CharUnits getOffsetOfBaseWithVBPtr(/*const*/ CXXRecordDecl /*P*/ RD) /*const*/ {
    CharUnits Offset = CharUnits.Zero();
    /*const*/ ASTRecordLayout /*P*/ Layout = $AddrOf(getASTRecordLayout(RD));
    {
      /*const*/ CXXRecordDecl /*P*/ Base;
      while (((/*P*/ Base = Layout.getBaseSharingVBPtr()) != null)) {
        Offset.$addassign(Layout.getBaseClassOffset(Base));
        Layout = $AddrOf(getASTRecordLayout(Base));
  }
    }
    return Offset;
  }

  
  /// Get the offset of a FieldDecl or IndirectFieldDecl, in bits.
  
  /// Get the offset of a FieldDecl or IndirectFieldDecl, in bits.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::getFieldOffset">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/RecordLayoutBuilder.cpp", line = 3061,
   FQN="clang::ASTContext::getFieldOffset", NM="_ZNK5clang10ASTContext14getFieldOffsetEPKNS_9ValueDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/RecordLayoutBuilder.cpp -nm=_ZNK5clang10ASTContext14getFieldOffsetEPKNS_9ValueDeclE")
  //</editor-fold>
  public long/*uint64_t*/ getFieldOffset(/*const*/ ValueDecl /*P*/ VD) /*const*/ {
    long/*uint64_t*/ OffsetInBits;
    {
      /*const*/ FieldDecl /*P*/ FD = dyn_cast_FieldDecl(VD);
      if ((FD != null)) {
        OffsetInBits = /*::*/RecordLayoutBuilderStatics.getFieldOffset(/*Deref*/this, FD);
      } else {
        /*const*/ IndirectFieldDecl /*P*/ IFD = cast_IndirectFieldDecl(VD);
        
        OffsetInBits = $int2ulong(0);
        for (/*const*/ NamedDecl /*P*/ ND : IFD.chain())  {
          OffsetInBits += /*::*/RecordLayoutBuilderStatics.getFieldOffset(/*Deref*/this, cast_FieldDecl(ND));
    }
      }
    }

    return OffsetInBits;
  }

  
  
  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::isNearlyEmpty">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp", line = 8680,
   FQN="clang::ASTContext::isNearlyEmpty", NM="_ZNK5clang10ASTContext13isNearlyEmptyEPKNS_13CXXRecordDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZNK5clang10ASTContext13isNearlyEmptyEPKNS_13CXXRecordDeclE")
  //</editor-fold>
  public boolean isNearlyEmpty(/*const*/ CXXRecordDecl /*P*/ RD) /*const*/ {
    // Pass through to the C++ ABI object
    return ABI.$arrow().isNearlyEmpty(RD);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::getVTableContext">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp", line = 8685,
   FQN="clang::ASTContext::getVTableContext", NM="_ZN5clang10ASTContext16getVTableContextEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZN5clang10ASTContext16getVTableContextEv")
  //</editor-fold>
  public VTableContextBase /*P*/ getVTableContext() {
    if (!(VTContext.get() != null)) {
      if (Target.getCXXABI().isMicrosoft()) {
        VTContext.reset(new MicrosoftVTableContext(/*Deref*/this));
      } else {
        VTContext.reset(new ItaniumVTableContext(/*Deref*/this));
      }
    }
    return VTContext.get();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::createMangleContext">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp", line = 8695,
   FQN="clang::ASTContext::createMangleContext", NM="_ZN5clang10ASTContext19createMangleContextEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZN5clang10ASTContext19createMangleContextEv")
  //</editor-fold>
  public MangleContext /*P*/ createMangleContext() {
    switch (Target.getCXXABI().getKind()) {
     case GenericAArch64:
     case GenericItanium:
     case GenericARM:
     case GenericMIPS:
     case iOS:
     case iOS64:
     case WebAssembly:
     case WatchOS:
      return ItaniumMangleContext.create(/*Deref*/this, getDiagnostics());
     case Microsoft:
      return MicrosoftMangleContext.create(/*Deref*/this, getDiagnostics());
  }
    throw new llvm_unreachable("Unsupported ABI");
  }

  
  
  /// DeepCollectObjCIvars -
  /// This routine first collects all declared, but not synthesized, ivars in
  /// super class and then collects all ivars, including those synthesized for
  /// current class. This routine is used for implementation of current class
  /// when all ivars, declared and synthesized are known.
  ///
  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::DeepCollectObjCIvars">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp", line = 1953,
   FQN="clang::ASTContext::DeepCollectObjCIvars", NM="_ZNK5clang10ASTContext20DeepCollectObjCIvarsEPKNS_17ObjCInterfaceDeclEbRN4llvm15SmallVectorImplIPKNS_12ObjCIvarDeclEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZNK5clang10ASTContext20DeepCollectObjCIvarsEPKNS_17ObjCInterfaceDeclEbRN4llvm15SmallVectorImplIPKNS_12ObjCIvarDeclEEE")
  //</editor-fold>
  public void DeepCollectObjCIvars(/*const*/ ObjCInterfaceDecl /*P*/ OI, 
                      boolean leafClass, 
                      final SmallVectorImpl</*const*/ ObjCIvarDecl /*P*/ > /*&*/ Ivars) /*const*/ {
    {
      /*const*/ ObjCInterfaceDecl /*P*/ SuperClass = OI.getSuperClass();
      if ((SuperClass != null)) {
        DeepCollectObjCIvars(SuperClass, false, Ivars);
  }
    }
    if (!leafClass) {
      for (/*const*/ ObjCIvarDecl /*P*/ I : OI.ivars())  {
        Ivars.push_back(I);
      }
    } else {
      ObjCInterfaceDecl /*P*/ IDecl = ((/*const_cast*/ObjCInterfaceDecl /*P*/ )(OI));
      for (/*const*/ ObjCIvarDecl /*P*/ Iv = IDecl.all_declared_ivar_begin(); (Iv != null);
           Iv = Iv.getNextIvar$Const())  {
        Ivars.push_back(Iv);
      }
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::CountNonClassIvars">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp", line = 2004,
   FQN="clang::ASTContext::CountNonClassIvars", NM="_ZNK5clang10ASTContext18CountNonClassIvarsEPKNS_17ObjCInterfaceDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZNK5clang10ASTContext18CountNonClassIvarsEPKNS_17ObjCInterfaceDeclE")
  //</editor-fold>
  public /*uint*/int CountNonClassIvars(/*const*/ ObjCInterfaceDecl /*P*/ OI) /*const*/ {
    /*uint*/int count = 0;
    // Count ivars declared in class extension.
    for (/*const*/ ObjCCategoryDecl /*P*/ Ext : OI.known_extensions())  {
      count += Ext.ivar_size();
    }
    {

      // Count ivar defined in this class's implementation.  This
      // includes synthesized ivars.
      ObjCImplementationDecl /*P*/ ImplDecl = OI.getImplementation();
      if ((ImplDecl != null)) {
        count += ImplDecl.ivar_size();
      }
    }
  
    return count;
  }

  /// CollectInheritedProtocols - Collect all protocols in current class and
  /// those inherited by it.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::CollectInheritedProtocols">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp", line = 1971,
   FQN="clang::ASTContext::CollectInheritedProtocols", NM="_ZN5clang10ASTContext25CollectInheritedProtocolsEPKNS_4DeclERN4llvm11SmallPtrSetIPNS_16ObjCProtocolDeclELj8EEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZN5clang10ASTContext25CollectInheritedProtocolsEPKNS_4DeclERN4llvm11SmallPtrSetIPNS_16ObjCProtocolDeclELj8EEE")
  //</editor-fold>
  public void CollectInheritedProtocols(/*const*/ Decl /*P*/ CDecl, 
                           final SmallPtrSet<ObjCProtocolDecl /*P*/ > /*&*/ Protocols) {
    {
      /*const*/ ObjCInterfaceDecl /*P*/ OI = dyn_cast_ObjCInterfaceDecl(CDecl);
      if ((OI != null)) {
        // We can use protocol_iterator here instead of
        // all_referenced_protocol_iterator since we are walking all categories.    
        for (ObjCProtocolDecl /*P*/ Proto : OI.all_referenced_protocols()) {
          CollectInheritedProtocols(Proto, Protocols);
    }

        // Categories of this Interface.
        for (/*const*/ ObjCCategoryDecl /*P*/ Cat : OI.visible_categories())  {
          CollectInheritedProtocols(Cat, Protocols);
        }
        {
  
          ObjCInterfaceDecl /*P*/ SD = OI.getSuperClass();
          if ((SD != null)) {
            while ((SD != null)) {
              CollectInheritedProtocols(SD, Protocols);
              SD = SD.getSuperClass();
            }
          }
        }
      } else {
        /*const*/ ObjCCategoryDecl /*P*/ OC = dyn_cast_ObjCCategoryDecl(CDecl);
        if ((OC != null)) {
          for (ObjCProtocolDecl /*P*/ Proto : OC.protocols()) {
            CollectInheritedProtocols(Proto, Protocols);
          }
        } else {
          /*const*/ ObjCProtocolDecl /*P*/ OP = dyn_cast_ObjCProtocolDecl(CDecl);
          if ((OP != null)) {
            // Insert the protocol.
            if (!Protocols.insert(((/*const_cast*/ObjCProtocolDecl /*P*/ )(OP.getCanonicalDecl$Const()))).second) {
              return;
            }
            
            for (ObjCProtocolDecl /*P*/ Proto : OP.protocols())  {
              CollectInheritedProtocols(Proto, Protocols);
            }
          }
        }
      }
    }
  }

  //===--------------------------------------------------------------------===//
  //                            Type Operators
  //===--------------------------------------------------------------------===//
  
  /// \brief Return the canonical (structural) type corresponding to the
  /// specified potentially non-canonical type \p T.
  ///
  /// The non-canonical version of a type may have many "decorated" versions of
  /// types.  Decorators can include typedefs, 'typeof' operators, etc. The
  /// returned type is guaranteed to be free of any of these, allowing two
  /// canonical types to be compared for exact equality with a simple pointer
  /// comparison.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::getCanonicalType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ASTContext.h", line = 1966,
   FQN="clang::ASTContext::getCanonicalType", NM="_ZNK5clang10ASTContext16getCanonicalTypeENS_8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZNK5clang10ASTContext16getCanonicalTypeENS_8QualTypeE")
  //</editor-fold>
  public CanQual<Type> getCanonicalType(QualType T) /*const*/ {
    return CanQual.<Type>CreateUnsafe(T.getCanonicalType());
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::getCanonicalType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ASTContext.h", line = 1970,
   FQN="clang::ASTContext::getCanonicalType", NM="_ZNK5clang10ASTContext16getCanonicalTypeEPKNS_4TypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZNK5clang10ASTContext16getCanonicalTypeEPKNS_4TypeE")
  //</editor-fold>
  public /*const*/ Type /*P*/ getCanonicalType(/*const*/ Type /*P*/ T) /*const*/ {
    return T.getCanonicalTypeInternal().getTypePtr();
  }

  
  /// \brief Return the canonical parameter type corresponding to the specific
  /// potentially non-canonical one.
  ///
  /// Qualifiers are stripped off, functions are turned into function
  /// pointers, and arrays decay one level into pointers.
  
  //===----------------------------------------------------------------------===//
  //                              Type Operators
  //===----------------------------------------------------------------------===//
  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::getCanonicalParamType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp", line = 4171,
   FQN="clang::ASTContext::getCanonicalParamType", NM="_ZNK5clang10ASTContext21getCanonicalParamTypeENS_8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZNK5clang10ASTContext21getCanonicalParamTypeENS_8QualTypeE")
  //</editor-fold>
  public CanQual<Type> getCanonicalParamType(QualType T) /*const*/ {
    // Push qualifiers into arrays, and then discard any remaining
    // qualifiers.
    T.$assignMove(getCanonicalType(/*NO_COPY*/T).$QualType());
    T.$assignMove(getVariableArrayDecayedType(new QualType(T)));
    /*const*/ Type /*P*/ Ty = T.getTypePtr();
    QualType Result/*J*/= new QualType();
    if (isa_ArrayType(Ty)) {
      Result.$assignMove(getArrayDecayedType(new QualType(Ty, 0)));
    } else if (isa_FunctionType(Ty)) {
      Result.$assignMove(getPointerType(new QualType(Ty, 0)));
    } else {
      Result.$assignMove(new QualType(Ty, 0));
    }
    
    return CanQual.<Type>CreateUnsafe(new QualType(Result));
  }

  
  /// \brief Determine whether the given types \p T1 and \p T2 are equivalent.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::hasSameType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ASTContext.h", line = 1982,
   FQN="clang::ASTContext::hasSameType", NM="_ZNK5clang10ASTContext11hasSameTypeENS_8QualTypeES1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZNK5clang10ASTContext11hasSameTypeENS_8QualTypeES1_")
  //</editor-fold>
  public boolean hasSameType(QualType T1, QualType T2) /*const*/ {
    return $eq_CanQual$T_CanQual$U(getCanonicalType(/*NO_COPY*/T1), getCanonicalType(/*NO_COPY*/T2));
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::hasSameType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ASTContext.h", line = 1986,
   FQN="clang::ASTContext::hasSameType", NM="_ZNK5clang10ASTContext11hasSameTypeEPKNS_4TypeES3_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZNK5clang10ASTContext11hasSameTypeEPKNS_4TypeES3_")
  //</editor-fold>
  public boolean hasSameType(/*const*/ Type /*P*/ T1, /*const*/ Type /*P*/ T2) /*const*/ {
    return getCanonicalType(T1) == getCanonicalType(T2);
  }

  
  /// \brief Return this type as a completely-unqualified array type,
  /// capturing the qualifiers in \p Quals.
  ///
  /// This will remove the minimal amount of sugaring from the types, similar
  /// to the behavior of QualType::getUnqualifiedType().
  ///
  /// \param T is the qualified type, which may be an ArrayType
  ///
  /// \param Quals will receive the full set of qualifiers that were
  /// applied to the array.
  ///
  /// \returns if this is an array type, the completely unqualified array type
  /// that corresponds to it. Otherwise, returns T.getUnqualifiedType().
  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::getUnqualifiedArrayType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp", line = 4189,
   FQN="clang::ASTContext::getUnqualifiedArrayType", NM="_ZN5clang10ASTContext23getUnqualifiedArrayTypeENS_8QualTypeERNS_10QualifiersE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZN5clang10ASTContext23getUnqualifiedArrayTypeENS_8QualTypeERNS_10QualifiersE")
  //</editor-fold>
  public QualType getUnqualifiedArrayType(QualType type, 
                         final Qualifiers /*&*/ quals) {
    SplitQualType splitType = type.getSplitUnqualifiedType();
    
    // FIXME: getSplitUnqualifiedType() actually walks all the way to
    // the unqualified desugared type and then drops it on the floor.
    // We then have to strip that sugar back off with
    // getUnqualifiedDesugaredType(), which is silly.
    /*const*/ ArrayType /*P*/ AT = dyn_cast_ArrayType(splitType.Ty.getUnqualifiedDesugaredType());
    
    // If we don't have an array, just use the results in splitType.
    if (!(AT != null)) {
      quals.$assign(splitType.Quals);
      return new QualType(splitType.Ty, 0);
    }
    
    // Otherwise, recurse on the array's element type.
    QualType elementType = AT.getElementType();
    QualType unqualElementType = getUnqualifiedArrayType(new QualType(elementType), quals);
    
    // If that didn't change the element type, AT has no qualifiers, so we
    // can just use the results in splitType.
    if ($eq_QualType$C(elementType, unqualElementType)) {
      assert (quals.empty()); // from the recursive call
      quals.$assign(splitType.Quals);
      return new QualType(splitType.Ty, 0);
    }
    
    // Otherwise, add in the qualifiers from the outermost type, then
    // build the type back up.
    quals.addConsistentQualifiers(new Qualifiers(splitType.Quals));
    {
      
      /*const*/ ConstantArrayType /*P*/ CAT = dyn_cast_ConstantArrayType(AT);
      if ((CAT != null)) {
        return getConstantArrayType(new QualType(unqualElementType), CAT.getSize(), 
            CAT.getSizeModifier(), 0);
      }
    }
    {
      
      /*const*/ IncompleteArrayType /*P*/ IAT = dyn_cast_IncompleteArrayType(AT);
      if ((IAT != null)) {
        return getIncompleteArrayType(new QualType(unqualElementType), IAT.getSizeModifier(), 0);
      }
    }
    {
      
      /*const*/ VariableArrayType /*P*/ VAT = dyn_cast_VariableArrayType(AT);
      if ((VAT != null)) {
        return getVariableArrayType(new QualType(unqualElementType), 
            VAT.getSizeExpr(), 
            VAT.getSizeModifier(), 
            VAT.getIndexTypeCVRQualifiers(), 
            VAT.getBracketsRange());
      }
    }
    
    /*const*/ DependentSizedArrayType /*P*/ DSAT = cast_DependentSizedArrayType(AT);
    return getDependentSizedArrayType(new QualType(unqualElementType), DSAT.getSizeExpr(), 
        DSAT.getSizeModifier(), 0, 
        new SourceRange());
  }

  
  /// \brief Determine whether the given types are equivalent after
  /// cvr-qualifiers have been removed.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::hasSameUnqualifiedType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ASTContext.h", line = 2007,
   FQN="clang::ASTContext::hasSameUnqualifiedType", NM="_ZNK5clang10ASTContext22hasSameUnqualifiedTypeENS_8QualTypeES1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZNK5clang10ASTContext22hasSameUnqualifiedTypeENS_8QualTypeES1_")
  //</editor-fold>
  public boolean hasSameUnqualifiedType(QualType T1, QualType T2) /*const*/ {
    return getCanonicalType(/*NO_COPY*/T1).getTypePtr()
       == getCanonicalType(/*NO_COPY*/T2).getTypePtr();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::hasSameNullabilityTypeQualifier">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ASTContext.h", line = 2012,
   FQN="clang::ASTContext::hasSameNullabilityTypeQualifier", NM="_ZNK5clang10ASTContext31hasSameNullabilityTypeQualifierENS_8QualTypeES1_b",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZNK5clang10ASTContext31hasSameNullabilityTypeQualifierENS_8QualTypeES1_b")
  //</editor-fold>
  public boolean hasSameNullabilityTypeQualifier(QualType SubT, QualType SuperT, 
                                 boolean IsParam) /*const*/ {
    Optional<NullabilityKind> SubTnullability = SubT.$arrow().getNullability(/*Deref*/this);
    Optional<NullabilityKind> SuperTnullability = SuperT.$arrow().getNullability(/*Deref*/this);
    if (SubTnullability.hasValue() == SuperTnullability.hasValue()) {
      // Neither has nullability; return true
      if (!SubTnullability.$bool()) {
        return true;
      }
      // Both have nullability qualifier.
      if (SubTnullability.$star() == SuperTnullability.$star()
         || SubTnullability.$star() == NullabilityKind.Unspecified
         || SuperTnullability.$star() == NullabilityKind.Unspecified) {
        return true;
      }
      if (IsParam) {
        // Ok for the superclass method parameter to be "nonnull" and the subclass
        // method parameter to be "nullable"
        return (SuperTnullability.$star() == NullabilityKind.NonNull
           && SubTnullability.$star() == NullabilityKind.Nullable);
      } else {
        // For the return type, it's okay for the superclass method to specify
        // "nullable" and the subclass method specify "nonnull"
        return (SuperTnullability.$star() == NullabilityKind.Nullable
           && SubTnullability.$star() == NullabilityKind.NonNull);
      }
    }
    return true;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::ObjCMethodsAreEqual">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp", line = 9070,
   FQN="clang::ASTContext::ObjCMethodsAreEqual", NM="_ZN5clang10ASTContext19ObjCMethodsAreEqualEPKNS_14ObjCMethodDeclES3_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZN5clang10ASTContext19ObjCMethodsAreEqualEPKNS_14ObjCMethodDeclES3_")
  //</editor-fold>
  public boolean ObjCMethodsAreEqual(/*const*/ ObjCMethodDecl /*P*/ MethodDecl, 
                     /*const*/ ObjCMethodDecl /*P*/ MethodImpl) {
    // No point trying to match an unavailable/deprecated mothod.
    if (MethodDecl.hasAttr(UnavailableAttr.class)
       || MethodDecl.hasAttr(DeprecatedAttr.class)) {
      return false;
    }
    if (MethodDecl.getObjCDeclQualifier()
       != MethodImpl.getObjCDeclQualifier()) {
      return false;
    }
    if (!hasSameType(MethodDecl.getReturnType(), MethodImpl.getReturnType())) {
      return false;
    }
    if (MethodDecl.param_size() != MethodImpl.param_size()) {
      return false;
    }
    
    for (type$ptr</*const*/ ParmVarDecl /*P*/ /*const*/ /*P*/> IM = $tryClone(MethodImpl.param_begin$Const()), 
        /*P*/ /*const*/ /*P*/ IF = $tryClone(MethodDecl.param_begin$Const()), /*P*/ /*const*/ /*P*/ EM = $tryClone(MethodImpl.param_end$Const()), 
        /*P*/ /*const*/ /*P*/ EF = $tryClone(MethodDecl.param_end$Const());
         $noteq_ptr(IM, EM) && $noteq_ptr(IF, EF); IM.$preInc() , IF.$preInc()) {
      /*const*/ ParmVarDecl /*P*/ DeclVar = (IF.$star());
      /*const*/ ParmVarDecl /*P*/ ImplVar = (IM.$star());
      if (ImplVar.getObjCDeclQualifier() != DeclVar.getObjCDeclQualifier()) {
        return false;
      }
      if (!hasSameType(DeclVar.getType(), ImplVar.getType())) {
        return false;
      }
    }
    return (MethodDecl.isVariadic() == MethodImpl.isVariadic());
  }

  
  
  /// UnwrapSimilarPointerTypes - If T1 and T2 are pointer types  that
  /// may be similar (C++ 4.4), replaces T1 and T2 with the type that
  /// they point to and return true. If T1 and T2 aren't pointer types
  /// or pointer-to-member types, or if they are not similar at this
  /// level, returns false and leaves T1 and T2 unchanged. Top-level
  /// qualifiers on T1 and T2 are ignored. This function will typically
  /// be called in a loop that successively "unwraps" pointer and
  /// pointer-to-member types to compare them at each level.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::UnwrapSimilarPointerTypes">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp", line = 4253,
   FQN="clang::ASTContext::UnwrapSimilarPointerTypes", NM="_ZN5clang10ASTContext25UnwrapSimilarPointerTypesERNS_8QualTypeES2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZN5clang10ASTContext25UnwrapSimilarPointerTypesERNS_8QualTypeES2_")
  //</editor-fold>
  public boolean UnwrapSimilarPointerTypes(final QualType /*&*/ T1, final QualType /*&*/ T2) {
    /*const*/ PointerType /*P*/ T1PtrType = T1.$arrow().getAs(PointerType.class);
    /*const*/ PointerType /*P*/ T2PtrType = T2.$arrow().getAs(PointerType.class);
    if ((T1PtrType != null) && (T2PtrType != null)) {
      T1.$assignMove(T1PtrType.getPointeeType());
      T2.$assignMove(T2PtrType.getPointeeType());
      return true;
    }
    
    /*const*/ MemberPointerType /*P*/ T1MPType = T1.$arrow().getAs(MemberPointerType.class);
    /*const*/ MemberPointerType /*P*/ T2MPType = T2.$arrow().getAs(MemberPointerType.class);
    if ((T1MPType != null) && (T2MPType != null)
       && hasSameUnqualifiedType(new QualType(T1MPType.__getClass(), 0), 
        new QualType(T2MPType.__getClass(), 0))) {
      T1.$assignMove(T1MPType.getPointeeType());
      T2.$assignMove(T2MPType.getPointeeType());
      return true;
    }
    if (getLangOpts().ObjC1) {
      /*const*/ ObjCObjectPointerType /*P*/ T1OPType = T1.$arrow().getAs(ObjCObjectPointerType.class);
      /*const*/ ObjCObjectPointerType /*P*/ T2OPType = T2.$arrow().getAs(ObjCObjectPointerType.class);
      if ((T1OPType != null) && (T2OPType != null)) {
        T1.$assignMove(T1OPType.getPointeeType());
        T2.$assignMove(T2OPType.getPointeeType());
        return true;
      }
    }
    
    // FIXME: Block pointers, too?
    return false;
  }

  
  /// \brief Retrieves the "canonical" nested name specifier for a
  /// given nested name specifier.
  ///
  /// The canonical nested name specifier is a nested name specifier
  /// that uniquely identifies a type or namespace within the type
  /// system. For example, given:
  ///
  /// \code
  /// namespace N {
  ///   struct S {
  ///     template<typename T> struct X { typename T* type; };
  ///   };
  /// }
  ///
  /// template<typename T> struct Y {
  ///   typename N::S::X<T>::type member;
  /// };
  /// \endcode
  ///
  /// Here, the nested-name-specifier for N::S::X<T>:: will be
  /// S::X<template-param-0-0>, since 'S' and 'X' are uniquely defined
  /// by declarations in the type system and the canonical type for
  /// the template type parameter 'T' is template-param-0-0.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::getCanonicalNestedNameSpecifier">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp", line = 4437,
   FQN="clang::ASTContext::getCanonicalNestedNameSpecifier", NM="_ZNK5clang10ASTContext31getCanonicalNestedNameSpecifierEPNS_19NestedNameSpecifierE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZNK5clang10ASTContext31getCanonicalNestedNameSpecifierEPNS_19NestedNameSpecifierE")
  //</editor-fold>
  public NestedNameSpecifier /*P*/ getCanonicalNestedNameSpecifier(NestedNameSpecifier /*P*/ NNS) /*const*/ {
    if (!(NNS != null)) {
      return null;
    }
    switch (NNS.getKind()) {
     case Identifier:
      // Canonicalize the prefix but keep the identifier the same.
      return NestedNameSpecifier.Create(/*Deref*/this, 
          getCanonicalNestedNameSpecifier(NNS.getPrefix()), 
          NNS.getAsIdentifier());
     case Namespace:
      // A namespace is canonical; build a nested-name-specifier with
      // this namespace and no prefix.
      return NestedNameSpecifier.Create(/*Deref*/this, (NestedNameSpecifier /*P*/ )null, 
          NNS.getAsNamespace().getOriginalNamespace());
     case NamespaceAlias:
      // A namespace is canonical; build a nested-name-specifier with
      // this namespace and no prefix.
      return NestedNameSpecifier.Create(/*Deref*/this, (NestedNameSpecifier /*P*/ )null, 
          NNS.getAsNamespaceAlias().getNamespace().
              getOriginalNamespace());
     case TypeSpec:
     case TypeSpecWithTemplate:
      {
        QualType T = getCanonicalType(new QualType(NNS.getAsType(), 0)).$QualType();
        {
          
          // If we have some kind of dependent-named type (e.g., "typename T::type"),
          // break it apart into its prefix and identifier, then reconsititute those
          // as the canonical nested-name-specifier. This is required to canonicalize
          // a dependent nested-name-specifier involving typedefs of dependent-name
          // types, e.g.,
          //   typedef typename T::type T1;
          //   typedef typename T1::type T2;
          /*const*/ DependentNameType /*P*/ DNT = T.$arrow().getAs(DependentNameType.class);
          if ((DNT != null)) {
            return NestedNameSpecifier.Create(/*Deref*/this, DNT.getQualifier(), 
                ((/*const_cast*/IdentifierInfo /*P*/ )(DNT.getIdentifier())));
          }
        }
        
        // Otherwise, just canonicalize the type, and force it to be a TypeSpec.
        // FIXME: Why are TypeSpec and TypeSpecWithTemplate distinct in the
        // first place?
        return NestedNameSpecifier.Create(/*Deref*/this, (NestedNameSpecifier /*P*/ )null, false, 
            ((/*const_cast*/Type /*P*/ )(T.getTypePtr())));
      }
     case Global:
     case Super:
      // The global specifier and __super specifer are canonical and unique.
      return NNS;
    }
    throw new llvm_unreachable("Invalid NestedNameSpecifier::Kind!");
  }

  
  /// \brief Retrieves the default calling convention for the current target.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::getDefaultCallingConvention">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp", line = 8652,
   FQN="clang::ASTContext::getDefaultCallingConvention", NM="_ZNK5clang10ASTContext27getDefaultCallingConventionEbb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZNK5clang10ASTContext27getDefaultCallingConventionEbb")
  //</editor-fold>
  public CallingConv getDefaultCallingConvention(boolean IsVariadic, 
                             boolean IsCXXMethod) /*const*/ {
    // Pass through to the C++ ABI object
    if (IsCXXMethod) {
      return ABI.$arrow().getDefaultMethodCallConv(IsVariadic);
    }
    switch (LangOpts.getDefaultCallingConv()) {
     case DCC_None:
      break;
     case DCC_CDecl:
      return CallingConv.CC_C;
     case DCC_FastCall:
      if (getTargetInfo().hasFeature(new StringRef(/*KEEP_STR*/"sse2"))) {
        return CallingConv.CC_X86FastCall;
      }
      break;
     case DCC_StdCall:
      if (!IsVariadic) {
        return CallingConv.CC_X86StdCall;
      }
      break;
     case DCC_VectorCall:
      // __vectorcall cannot be applied to variadic functions.
      if (!IsVariadic) {
        return CallingConv.CC_X86VectorCall;
      }
      break;
    }
    return Target.getDefaultCallingConv(TargetInfo.CallingConvMethodType.CCMT_Unknown);
  }

  
  /// \brief Retrieves the "canonical" template name that refers to a
  /// given template.
  ///
  /// The canonical template name is the simplest expression that can
  /// be used to refer to a given template. For most templates, this
  /// expression is just the template declaration itself. For example,
  /// the template std::vector can be referred to via a variety of
  /// names---std::vector, \::std::vector, vector (if vector is in
  /// scope), etc.---but all of these names map down to the same
  /// TemplateDecl, which is used to form the canonical template name.
  ///
  /// Dependent template names are more interesting. Here, the
  /// template name could be something like T::template apply or
  /// std::allocator<T>::template rebind, where the nested name
  /// specifier itself is dependent. In this case, the canonical
  /// template name uses the shortest form of the dependent
  /// nested-name-specifier, which itself contains all canonical
  /// types, values, and templates.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::getCanonicalTemplateName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp", line = 4337,
   FQN="clang::ASTContext::getCanonicalTemplateName", NM="_ZNK5clang10ASTContext24getCanonicalTemplateNameENS_12TemplateNameE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZNK5clang10ASTContext24getCanonicalTemplateNameENS_12TemplateNameE")
  //</editor-fold>
  public TemplateName getCanonicalTemplateName(TemplateName Name) /*const*/ {
    switch (Name.getKind()) {
     case QualifiedTemplate:
     case Template:
      {
        TemplateDecl /*P*/ Template = Name.getAsTemplateDecl();
        {
          TemplateTemplateParmDecl /*P*/ TTP = dyn_cast_TemplateTemplateParmDecl(Template);
          if ((TTP != null)) {
            Template = getCanonicalTemplateTemplateParmDecl(TTP);
          }
        }
        
        // The canonical template name is the canonical template declaration.
        return new TemplateName(cast_TemplateDecl(Template.getCanonicalDecl()));
      }
     case OverloadedTemplate:
      throw new llvm_unreachable("cannot canonicalize overloaded template");
     case DependentTemplate:
      {
        DependentTemplateName /*P*/ DTN = Name.getAsDependentTemplateName();
        assert ((DTN != null)) : "Non-dependent template names must refer to template decls.";
        return new TemplateName(DTN.CanonicalTemplateName);
      }
     case SubstTemplateTemplateParm:
      {
        SubstTemplateTemplateParmStorage /*P*/ subst = Name.getAsSubstTemplateTemplateParm();
        return getCanonicalTemplateName(subst.getReplacement());
      }
     case SubstTemplateTemplateParmPack:
      {
        SubstTemplateTemplateParmPackStorage /*P*/ subst = Name.getAsSubstTemplateTemplateParmPack();
        TemplateTemplateParmDecl /*P*/ canonParameter = getCanonicalTemplateTemplateParmDecl(subst.getParameterPack());
        TemplateArgument canonArgPack = getCanonicalTemplateArgument(subst.getArgumentPack());
        return getSubstTemplateTemplateParmPack(canonParameter, canonArgPack);
      }
    }
    throw new llvm_unreachable("bad template name!");
  }

  
  /// \brief Determine whether the given template names refer to the same
  /// template.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::hasSameTemplateName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp", line = 4379,
   FQN="clang::ASTContext::hasSameTemplateName", NM="_ZN5clang10ASTContext19hasSameTemplateNameENS_12TemplateNameES1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZN5clang10ASTContext19hasSameTemplateNameENS_12TemplateNameES1_")
  //</editor-fold>
  public boolean hasSameTemplateName(TemplateName X, TemplateName Y) {
    X.$assignMove(getCanonicalTemplateName(new TemplateName(X)));
    Y.$assignMove(getCanonicalTemplateName(new TemplateName(Y)));
    return $eq_ptr(X.getAsVoidPointer(), Y.getAsVoidPointer());
  }

  
  /// \brief Retrieve the "canonical" template argument.
  ///
  /// The canonical template argument is the simplest template argument
  /// (which may be a type, value, expression, or declaration) that
  /// expresses the value of the argument.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::getCanonicalTemplateArgument">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp", line = 4385,
   FQN="clang::ASTContext::getCanonicalTemplateArgument", NM="_ZNK5clang10ASTContext28getCanonicalTemplateArgumentERKNS_16TemplateArgumentE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZNK5clang10ASTContext28getCanonicalTemplateArgumentERKNS_16TemplateArgumentE")
  //</editor-fold>
  public TemplateArgument getCanonicalTemplateArgument(final /*const*/ TemplateArgument /*&*/ Arg) /*const*/ {
    switch (Arg.getKind()) {
     case Null:
      return new TemplateArgument(Arg);
     case Expression:
      return new TemplateArgument(Arg);
     case Declaration:
      {
        ValueDecl /*P*/ D = cast_ValueDecl(Arg.getAsDecl().getCanonicalDecl());
        return new TemplateArgument(D, Arg.getParamTypeForDecl());
      }
     case NullPtr:
      return new TemplateArgument(getCanonicalType(Arg.getNullPtrType()).$QualType(), 
          /*isNullPtr*/ true);
     case Template:
      return new TemplateArgument(getCanonicalTemplateName(Arg.getAsTemplate()));
     case TemplateExpansion:
      return new TemplateArgument(getCanonicalTemplateName(Arg.getAsTemplateOrTemplatePattern()), 
          Arg.getNumTemplateExpansions());
     case Integral:
      return new TemplateArgument(Arg, getCanonicalType(Arg.getIntegralType()).$QualType());
     case Type:
      return new TemplateArgument(getCanonicalType(Arg.getAsType()).$QualType());
     case Pack:
      {
        if (Arg.pack_size() == 0) {
          return new TemplateArgument(Arg);
        }
        
        type$ptr<TemplateArgument/*P*/> CanonArgs = create_const_type$ptr(/*NEW_EXPR [operator new[]] NM=_ZnajRKN5clang10ASTContextEj*/
        /*new (*this)*/ /*FIXME 2: $array_new_uint_ASTContext$C_uint*/new TemplateArgument [Arg.pack_size()]);
        /*uint*/int Idx = 0;
        for (type$ptr<TemplateArgument>/*pack_iterator*/ A = $tryClone(Arg.pack_begin()), 
            /*P*/ AEnd = $tryClone(Arg.pack_end());
             $noteq_ptr(A, AEnd); /*J:(void)*/A.$preInc() , ++Idx)  {
          CanonArgs.$set(Idx, getCanonicalTemplateArgument(A.$star()));
        }
        
        return new TemplateArgument(llvm.makeArrayRef(CanonArgs, Arg.pack_size()));
      }
    }
    
    // Silence GCC warning
    throw new llvm_unreachable("Unhandled template argument kind");
  }

  
  /// Type Query functions.  If the type is an instance of the specified class,
  /// return the Type pointer for the underlying maximally pretty type.  This
  /// is a member of ASTContext because this may need to do some amount of
  /// canonicalization, e.g. to move type qualifiers into the element type.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::getAsArrayType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp", line = 4493,
   FQN="clang::ASTContext::getAsArrayType", NM="_ZNK5clang10ASTContext14getAsArrayTypeENS_8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZNK5clang10ASTContext14getAsArrayTypeENS_8QualTypeE")
  //</editor-fold>
  public /*const*/ ArrayType /*P*/ getAsArrayType(QualType T) /*const*/ {
    // Handle the non-qualified case efficiently.
    if (!T.hasLocalQualifiers()) {
      {
        // Handle the common positive case fast.
        /*const*/ ArrayType /*P*/ AT = dyn_cast_ArrayType(T);
        if ((AT != null)) {
          return AT;
        }
      }
    }
    
    // Handle the common negative case fast.
    if (!isa_ArrayType(T.getCanonicalType())) {
      return null;
    }
    
    // Apply any qualifiers from the array type to the element type.  This
    // implements C99 6.7.3p8: "If the specification of an array type includes
    // any type qualifiers, the element type is so qualified, not the array type."
    
    // If we get here, we either have type qualifiers on the type, or we have
    // sugar such as a typedef in the way.  If we have type qualifiers on the type
    // we must propagate them down into the element type.
    SplitQualType split = T.getSplitDesugaredType();
    Qualifiers qs = new Qualifiers(split.Quals);
    
    // If we have a simple case, just return now.
    /*const*/ ArrayType /*P*/ ATy = dyn_cast_ArrayType(split.Ty);
    if (!(ATy != null) || qs.empty()) {
      return ATy;
    }
    
    // Otherwise, we have an array and we have qualifiers on it.  Push the
    // qualifiers into the array element type and return a new array type.
    QualType NewEltTy = getQualifiedType(ATy.getElementType(), new Qualifiers(qs));
    {
      
      /*const*/ ConstantArrayType /*P*/ CAT = dyn_cast_ConstantArrayType(ATy);
      if ((CAT != null)) {
        return cast_ArrayType(getConstantArrayType(new QualType(NewEltTy), CAT.getSize(), 
    CAT.getSizeModifier(), 
    CAT.getIndexTypeCVRQualifiers()));
      }
    }
    {
      /*const*/ IncompleteArrayType /*P*/ IAT = dyn_cast_IncompleteArrayType(ATy);
      if ((IAT != null)) {
        return cast_ArrayType(getIncompleteArrayType(new QualType(NewEltTy), 
    IAT.getSizeModifier(), 
    IAT.getIndexTypeCVRQualifiers()));
      }
    }
    {
      
      /*const*/ DependentSizedArrayType /*P*/ DSAT = dyn_cast_DependentSizedArrayType(ATy);
      if ((DSAT != null)) {
        return cast_ArrayType(getDependentSizedArrayType(new QualType(NewEltTy), 
    DSAT.getSizeExpr(), 
    DSAT.getSizeModifier(), 
    DSAT.getIndexTypeCVRQualifiers(), 
    DSAT.getBracketsRange()));
      }
    }
    
    /*const*/ VariableArrayType /*P*/ VAT = cast_VariableArrayType(ATy);
    return cast_ArrayType(getVariableArrayType(new QualType(NewEltTy), 
    VAT.getSizeExpr(), 
    VAT.getSizeModifier(), 
    VAT.getIndexTypeCVRQualifiers(), 
    VAT.getBracketsRange()));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::getAsConstantArrayType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ASTContext.h", line = 2114,
   FQN="clang::ASTContext::getAsConstantArrayType", NM="_ZNK5clang10ASTContext22getAsConstantArrayTypeENS_8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZNK5clang10ASTContext22getAsConstantArrayTypeENS_8QualTypeE")
  //</editor-fold>
  public /*const*/ ConstantArrayType /*P*/ getAsConstantArrayType(QualType T) /*const*/ {
    return dyn_cast_or_null_ConstantArrayType(getAsArrayType(new QualType(T)));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::getAsVariableArrayType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ASTContext.h", line = 2117,
   FQN="clang::ASTContext::getAsVariableArrayType", NM="_ZNK5clang10ASTContext22getAsVariableArrayTypeENS_8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZNK5clang10ASTContext22getAsVariableArrayTypeENS_8QualTypeE")
  //</editor-fold>
  public /*const*/ VariableArrayType /*P*/ getAsVariableArrayType(QualType T) /*const*/ {
    return dyn_cast_or_null_VariableArrayType(getAsArrayType(new QualType(T)));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::getAsIncompleteArrayType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ASTContext.h", line = 2120,
   FQN="clang::ASTContext::getAsIncompleteArrayType", NM="_ZNK5clang10ASTContext24getAsIncompleteArrayTypeENS_8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZNK5clang10ASTContext24getAsIncompleteArrayTypeENS_8QualTypeE")
  //</editor-fold>
  public /*const*/ IncompleteArrayType /*P*/ getAsIncompleteArrayType(QualType T) /*const*/ {
    return dyn_cast_or_null_IncompleteArrayType(getAsArrayType(new QualType(T)));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::getAsDependentSizedArrayType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ASTContext.h", line = 2123,
   FQN="clang::ASTContext::getAsDependentSizedArrayType", NM="_ZNK5clang10ASTContext28getAsDependentSizedArrayTypeENS_8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZNK5clang10ASTContext28getAsDependentSizedArrayTypeENS_8QualTypeE")
  //</editor-fold>
  public /*const*/ DependentSizedArrayType /*P*/ getAsDependentSizedArrayType(QualType T) /*const*/ {
    return dyn_cast_or_null_DependentSizedArrayType(getAsArrayType(new QualType(T)));
  }

  
  /// \brief Return the innermost element type of an array type.
  ///
  /// For example, will return "int" for int[m][n]
  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::getBaseElementType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp", line = 4596,
   FQN="clang::ASTContext::getBaseElementType", NM="_ZNK5clang10ASTContext18getBaseElementTypeEPKNS_9ArrayTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZNK5clang10ASTContext18getBaseElementTypeEPKNS_9ArrayTypeE")
  //</editor-fold>
  public QualType getBaseElementType(/*const*/ ArrayType /*P*/ array) /*const*/ {
    return getBaseElementType(array.getElementType());
  }

  
  /// \brief Return the innermost element type of a type (which needn't
  /// actually be an array type).
  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::getBaseElementType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp", line = 4600,
   FQN="clang::ASTContext::getBaseElementType", NM="_ZNK5clang10ASTContext18getBaseElementTypeENS_8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZNK5clang10ASTContext18getBaseElementTypeENS_8QualTypeE")
  //</editor-fold>
  public QualType getBaseElementType(QualType type) /*const*/ {
    Qualifiers qs/*J*/= new Qualifiers();
    while (true) {
      SplitQualType split = type.getSplitDesugaredType();
      /*const*/ ArrayType /*P*/ array = split.Ty.getAsArrayTypeUnsafe();
      if (!(array != null)) {
        break;
      }
      
      type.$assignMove(array.getElementType());
      qs.addConsistentQualifiers(new Qualifiers(split.Quals));
    }
    
    return getQualifiedType(new QualType(type), new Qualifiers(qs));
  }
  
  /// \brief Return number of constant array elements.
  
  /// getConstantArrayElementCount - Returns number of constant array elements.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::getConstantArrayElementCount">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp", line = 4615,
   FQN="clang::ASTContext::getConstantArrayElementCount", NM="_ZNK5clang10ASTContext28getConstantArrayElementCountEPKNS_17ConstantArrayTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZNK5clang10ASTContext28getConstantArrayElementCountEPKNS_17ConstantArrayTypeE")
  //</editor-fold>
  public long/*uint64_t*/ getConstantArrayElementCount(/*const*/ ConstantArrayType /*P*/ CA) /*const*/ {
    long/*uint64_t*/ ElementCount = $int2ulong(1);
    do {
      ElementCount *= CA.getSize().getZExtValue();
      CA = dyn_cast_or_null_ConstantArrayType(CA.getElementType().$arrow().getAsArrayTypeUnsafe());
    } while ((CA != null));
    return ElementCount;
  }

  
  /// \brief Perform adjustment on the parameter type of a function.
  ///
  /// This routine adjusts the given parameter type @p T to the actual
  /// parameter type used by semantic analysis (C99 6.7.5.3p[7,8],
  /// C++ [dcl.fct]p3). The adjusted parameter type is returned.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::getAdjustedParameterType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp", line = 4551,
   FQN="clang::ASTContext::getAdjustedParameterType", NM="_ZNK5clang10ASTContext24getAdjustedParameterTypeENS_8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZNK5clang10ASTContext24getAdjustedParameterTypeENS_8QualTypeE")
  //</editor-fold>
  public QualType getAdjustedParameterType(QualType T) /*const*/ {
    if (T.$arrow().isArrayType() || T.$arrow().isFunctionType()) {
      return getDecayedType(/*NO_COPY*/T);
    }
    return new QualType(JD$Move.INSTANCE, T);
  }

  
  /// \brief Retrieve the parameter type as adjusted for use in the signature
  /// of a function, decaying array and function types and removing top-level
  /// cv-qualifiers.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::getSignatureParameterType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp", line = 4557,
   FQN="clang::ASTContext::getSignatureParameterType", NM="_ZNK5clang10ASTContext25getSignatureParameterTypeENS_8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZNK5clang10ASTContext25getSignatureParameterTypeENS_8QualTypeE")
  //</editor-fold>
  public QualType getSignatureParameterType(QualType T) /*const*/ {
    T.$assignMove(getVariableArrayDecayedType(new QualType(T)));
    T.$assignMove(getAdjustedParameterType(new QualType(T)));
    return T.getUnqualifiedType();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::getExceptionObjectType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp", line = 4563,
   FQN="clang::ASTContext::getExceptionObjectType", NM="_ZNK5clang10ASTContext22getExceptionObjectTypeENS_8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZNK5clang10ASTContext22getExceptionObjectTypeENS_8QualTypeE")
  //</editor-fold>
  public QualType getExceptionObjectType(QualType T) /*const*/ {
    // C++ [except.throw]p3:
    //   A throw-expression initializes a temporary object, called the exception
    //   object, the type of which is determined by removing any top-level
    //   cv-qualifiers from the static type of the operand of throw and adjusting
    //   the type from "array of T" or "function returning T" to "pointer to T"
    //   or "pointer to function returning T", [...]
    T.$assignMove(getVariableArrayDecayedType(new QualType(T)));
    if (T.$arrow().isArrayType() || T.$arrow().isFunctionType()) {
      T.$assignMove(getDecayedType(/*NO_COPY*/T));
    }
    return T.getUnqualifiedType();
  }

  
  /// \brief Return the properly qualified result of decaying the specified
  /// array type to a pointer.
  ///
  /// This operation is non-trivial when handling typedefs etc.  The canonical
  /// type of \p T must be an array type, this returns a pointer to a properly
  /// qualified element of the array.
  ///
  /// See C99 6.7.5.3p7 and C99 6.3.2.1p3.
  
  /// getArrayDecayedType - Return the properly qualified result of decaying the
  /// specified array type to a pointer.  This operation is non-trivial when
  /// handling typedefs etc.  The canonical type of "T" must be an array type,
  /// this returns a pointer to a properly qualified element of the array.
  ///
  /// See C99 6.7.5.3p7 and C99 6.3.2.1p3.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::getArrayDecayedType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp", line = 4582,
   FQN="clang::ASTContext::getArrayDecayedType", NM="_ZNK5clang10ASTContext19getArrayDecayedTypeENS_8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZNK5clang10ASTContext19getArrayDecayedTypeENS_8QualTypeE")
  //</editor-fold>
  public QualType getArrayDecayedType(QualType Ty) /*const*/ {
    // Get the element type with 'getAsArrayType' so that we don't lose any
    // typedefs in the element type of the array.  This also handles propagation
    // of type qualifiers from the array type into the element type if present
    // (C99 6.7.3p8).
    /*const*/ ArrayType /*P*/ PrettyArrayType = getAsArrayType(new QualType(Ty));
    assert ((PrettyArrayType != null)) : "Not an array type!";
    
    QualType PtrTy = getPointerType(PrettyArrayType.getElementType());
    
    // int x[restrict 4] ->  int *restrict
    return getQualifiedType(new QualType(PtrTy), PrettyArrayType.getIndexTypeQualifiers());
  }

  
  /// \brief Return the type that \p PromotableType will promote to: C99
  /// 6.3.1.1p2, assuming that \p PromotableType is a promotable integer type.
  
  /// getPromotedIntegerType - Returns the type that Promotable will
  /// promote to: C99 6.3.1.1p2, assuming that Promotable is a promotable
  /// integer type.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::getPromotedIntegerType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp", line = 4771,
   FQN="clang::ASTContext::getPromotedIntegerType", NM="_ZNK5clang10ASTContext22getPromotedIntegerTypeENS_8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZNK5clang10ASTContext22getPromotedIntegerTypeENS_8QualTypeE")
  //</editor-fold>
  public QualType getPromotedIntegerType(QualType Promotable) /*const*/ {
    assert (!Promotable.isNull());
    assert (Promotable.$arrow().isPromotableIntegerType());
    {
      /*const*/ EnumType /*P*/ ET = Promotable.$arrow().getAs$EnumType();
      if ((ET != null)) {
        return ET.getDecl().getPromotionType();
      }
    }
    {

      /*const*/ BuiltinType /*P*/ BT = Promotable.$arrow().getAs$BuiltinType();
      if ((BT != null)) {
        // C++ [conv.prom]: A prvalue of type char16_t, char32_t, or wchar_t
        // (3.9.1) can be converted to a prvalue of the first of the following
        // types that can represent all the values of its underlying type:
        // int, unsigned int, long int, unsigned long int, long long int, or
        // unsigned long long int [...]
        // FIXME: Is there some better way to compute this?
        if (BT.getKind() == BuiltinType.Kind.WChar_S
           || BT.getKind() == BuiltinType.Kind.WChar_U
           || BT.getKind() == BuiltinType.Kind.Char16
           || BT.getKind() == BuiltinType.Kind.Char32) {
          boolean FromIsSigned = BT.getKind() == BuiltinType.Kind.WChar_S;
          long/*uint64_t*/ FromSize = getTypeSize(BT);
          QualType PromoteTypes[/*6*/] = new QualType [/*6*/] {
            IntTy.$QualType(), UnsignedIntTy.$QualType(), LongTy.$QualType(), UnsignedLongTy.$QualType(), 
            LongLongTy.$QualType(), UnsignedLongLongTy.$QualType()};
          for (/*size_t*/int Idx = 0; $less_uint(Idx, llvm.array_lengthof(PromoteTypes)); ++Idx) {
            long/*uint64_t*/ ToSize = getTypeSize(new QualType(PromoteTypes[Idx]));
            if ($less_ulong(FromSize, ToSize)
               || (FromSize == ToSize
               && FromIsSigned == PromoteTypes[Idx].$arrow().isSignedIntegerType())) {
              return new QualType(PromoteTypes[Idx]);
            }
          }
          throw new llvm_unreachable("char type should fit into long long");
        }
      }
    }
  
    // At this point, we should have a signed or unsigned integer type.
    if (Promotable.$arrow().isSignedIntegerType()) {
      return IntTy.$QualType();
    }
    long/*uint64_t*/ PromotableSize = $uint2ulong(getIntWidth(new QualType(Promotable)));
    long/*uint64_t*/ IntSize = $uint2ulong(getIntWidth(IntTy.$QualType()));
    assert (Promotable.$arrow().isUnsignedIntegerType() && $lesseq_ulong(PromotableSize, IntSize));
    return ((PromotableSize != IntSize) ? IntTy : UnsignedIntTy).$QualType();
  }

  
  /// \brief Recurses in pointer/array types until it finds an Objective-C
  /// retainable type and returns its ownership.
  
  /// \brief Recurses in pointer/array types until it finds an objc retainable
  /// type and returns its ownership.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::getInnerObjCOwnership">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp", line = 4814,
   FQN="clang::ASTContext::getInnerObjCOwnership", NM="_ZNK5clang10ASTContext21getInnerObjCOwnershipENS_8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZNK5clang10ASTContext21getInnerObjCOwnershipENS_8QualTypeE")
  //</editor-fold>
  public Qualifiers.ObjCLifetime getInnerObjCOwnership(QualType T) /*const*/ {
    while (!T.isNull()) {
      if (T.getObjCLifetime() != Qualifiers.ObjCLifetime.OCL_None) {
        return T.getObjCLifetime();
      }
      if (T.$arrow().isArrayType()) {
        T.$assignMove(getBaseElementType(new QualType(T)));
      } else {
        /*const*/ PointerType /*P*/ PT = T.$arrow().getAs(PointerType.class);
        if ((PT != null)) {
          T.$assignMove(PT.getPointeeType());
        } else {
          /*const*/ ReferenceType /*P*/ RT = T.$arrow().getAs(ReferenceType.class);
          if ((RT != null)) {
            T.$assignMove(RT.getPointeeType());
          } else {
            break;
          }
        }
      }
    }

    return Qualifiers.ObjCLifetime.OCL_None;
  }
  
  
  /// \brief Whether this is a promotable bitfield reference according
  /// to C99 6.3.1.1p2, bullet 2 (and GCC extensions).
  ///
  /// \returns the type this bit-field will promote to, or NULL if no
  /// promotion occurs.
  
  /// \brief Whether this is a promotable bitfield reference according
  /// to C99 6.3.1.1p2, bullet 2 (and GCC extensions).
  ///
  /// \returns the type this bit-field will promote to, or NULL if no
  /// promotion occurs.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::isPromotableBitField">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp", line = 4724,
   FQN="clang::ASTContext::isPromotableBitField", NM="_ZNK5clang10ASTContext20isPromotableBitFieldEPNS_4ExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZNK5clang10ASTContext20isPromotableBitFieldEPNS_4ExprE")
  //</editor-fold>
  public QualType isPromotableBitField(Expr /*P*/ E) /*const*/ {
    if (E.isTypeDependent() || E.isValueDependent()) {
      return new QualType();
    }

    // FIXME: We should not do this unless E->refersToBitField() is true. This
    // matters in C where getSourceBitField() will find bit-fields for various
    // cases where the source expression is not a bit-field designator.
    FieldDecl /*P*/ Field = E.getSourceBitField(); // FIXME: conditional bit-fields?
    if (!(Field != null)) {
      return new QualType();
    }
  
    QualType FT = Field.getType();
    
    long/*uint64_t*/ BitWidth = $uint2ulong(Field.getBitWidthValue(/*Deref*/this));
    long/*uint64_t*/ IntSize = getTypeSize(IntTy.$QualType());
    // C++ [conv.prom]p5:
    //   A prvalue for an integral bit-field can be converted to a prvalue of type
    //   int if int can represent all the values of the bit-field; otherwise, it
    //   can be converted to unsigned int if unsigned int can represent all the
    //   values of the bit-field. If the bit-field is larger yet, no integral
    //   promotion applies to it.
    // C11 6.3.1.1/2:
    //   [For a bit-field of type _Bool, int, signed int, or unsigned int:]
    //   If an int can represent all values of the original type (as restricted by
    //   the width, for a bit-field), the value is converted to an int; otherwise,
    //   it is converted to an unsigned int.
    //
    // FIXME: C does not permit promotion of a 'long : 3' bitfield to int.
    //        We perform that promotion here to match GCC and C++.
    if ($less_ulong(BitWidth, IntSize)) {
      return IntTy.$QualType();
    }
    if (BitWidth == IntSize) {
      return (FT.$arrow().isSignedIntegerType() ? IntTy : UnsignedIntTy).$QualType();
    }
    
    // Types bigger than int are not subject to promotions, and therefore act
    // like the base type. GCC has some weird bugs in this area that we
    // deliberately do not follow (GCC follows a pre-standard resolution to
    // C's DR315 which treats bit-width as being part of the type, and this leaks
    // into their semantics in some cases).
    return new QualType();
  }

  
  /// \brief Return the highest ranked integer type, see C99 6.3.1.8p1. 
  ///
  /// If \p LHS > \p RHS, returns 1.  If \p LHS == \p RHS, returns 0.  If
  /// \p LHS < \p RHS, return -1.
  
  /// getIntegerTypeOrder - Returns the highest ranked integer type:
  /// C99 6.3.1.8p1.  If LHS > RHS, return 1.  If LHS == RHS, return 0. If
  /// LHS < RHS, return -1.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::getIntegerTypeOrder">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp", line = 4842,
   FQN="clang::ASTContext::getIntegerTypeOrder", NM="_ZNK5clang10ASTContext19getIntegerTypeOrderENS_8QualTypeES1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZNK5clang10ASTContext19getIntegerTypeOrderENS_8QualTypeES1_")
  //</editor-fold>
  public int getIntegerTypeOrder(QualType LHS, QualType RHS) /*const*/ {
    /*const*/ Type /*P*/ LHSC = getCanonicalType(/*NO_COPY*/LHS).getTypePtr();
    /*const*/ Type /*P*/ RHSC = getCanonicalType(/*NO_COPY*/RHS).getTypePtr();
    {
      
      // Unwrap enums to their underlying type.
      /*const*/ EnumType /*P*/ ET = dyn_cast_EnumType(LHSC);
      if ((ET != null)) {
        LHSC = getIntegerTypeForEnum(ET);
      }
    }
    {
      /*const*/ EnumType /*P*/ ET = dyn_cast_EnumType(RHSC);
      if ((ET != null)) {
        RHSC = getIntegerTypeForEnum(ET);
      }
    }
    if (LHSC == RHSC) {
      return 0;
    }

    boolean LHSUnsigned = LHSC.isUnsignedIntegerType();
    boolean RHSUnsigned = RHSC.isUnsignedIntegerType();
  
    /*uint*/int LHSRank = getIntegerRank(LHSC);
    /*uint*/int RHSRank = getIntegerRank(RHSC);
    if (LHSUnsigned == RHSUnsigned) { // Both signed or both unsigned.
      if (LHSRank == RHSRank) {
        return 0;
      }
      return $greater_uint(LHSRank, RHSRank) ? 1 : -1;
    }
    
    // Otherwise, the LHS is signed and the RHS is unsigned or visa versa.
    if (LHSUnsigned) {
      // If the unsigned [LHS] type is larger, return it.
      if ($greatereq_uint(LHSRank, RHSRank)) {
        return 1;
      }
      
      // If the signed type can represent all values of the unsigned type, it
      // wins.  Because we are dealing with 2's complement and types that are
      // powers of two larger than each other, this is always safe.
      return -1;
    }
    
    // If the unsigned [RHS] type is larger, return it.
    if ($greatereq_uint(RHSRank, LHSRank)) {
      return -1;
    }
    
    // If the signed type can represent all values of the unsigned type, it
    // wins.  Because we are dealing with 2's complement and types that are
    // powers of two larger than each other, this is always safe.
    return 1;
  }

  
  /// \brief Compare the rank of the two specified floating point types,
  /// ignoring the domain of the type (i.e. 'double' == '_Complex double').
  ///
  /// If \p LHS > \p RHS, returns 1.  If \p LHS == \p RHS, returns 0.  If
  /// \p LHS < \p RHS, return -1.
  
  /// getFloatingTypeOrder - Compare the rank of the two specified floating
  /// point types, ignoring the domain of the type (i.e. 'double' ==
  /// '_Complex double').  If LHS > RHS, return 1.  If LHS == RHS, return 0. If
  /// LHS < RHS, return -1.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::getFloatingTypeOrder">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp", line = 4675,
   FQN="clang::ASTContext::getFloatingTypeOrder", NM="_ZNK5clang10ASTContext20getFloatingTypeOrderENS_8QualTypeES1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZNK5clang10ASTContext20getFloatingTypeOrderENS_8QualTypeES1_")
  //</editor-fold>
  public int getFloatingTypeOrder(QualType LHS, QualType RHS) /*const*/ {
    FloatingRank LHSR = getFloatingRank(new QualType(LHS));
    FloatingRank RHSR = getFloatingRank(new QualType(RHS));
    if (LHSR == RHSR) {
      return 0;
  }
    if (LHSR.getValue() > RHSR.getValue()) {
      return 1;
    }
    return -1;
  }

  
  /// \brief Return a real floating point or a complex type (based on
  /// \p typeDomain/\p typeSize).
  ///
  /// \param typeDomain a real floating point or complex type.
  /// \param typeSize a real floating point or complex type.
  
  /// getFloatingTypeOfSizeWithinDomain - Returns a real floating
  /// point or a complex type (based on typeDomain/typeSize).
  /// 'typeDomain' is a real floating point or complex type.
  /// 'typeSize' is a real floating point or complex type.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::getFloatingTypeOfSizeWithinDomain">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp", line = 4647,
   FQN="clang::ASTContext::getFloatingTypeOfSizeWithinDomain", NM="_ZNK5clang10ASTContext33getFloatingTypeOfSizeWithinDomainENS_8QualTypeES1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZNK5clang10ASTContext33getFloatingTypeOfSizeWithinDomainENS_8QualTypeES1_")
  //</editor-fold>
  public QualType getFloatingTypeOfSizeWithinDomain(QualType Size, 
                                   QualType Domain) /*const*/ {
    FloatingRank EltRank = getFloatingRank(new QualType(Size));
    if (Domain.$arrow().isComplexType()) {
      switch (EltRank) {
       case HalfRank:
        throw new llvm_unreachable("Complex half is not supported");
       case FloatRank:
        return FloatComplexTy.$QualType();
       case DoubleRank:
        return DoubleComplexTy.$QualType();
       case LongDoubleRank:
        return LongDoubleComplexTy.$QualType();
       case Float128Rank:
        return Float128ComplexTy.$QualType();
  }
    }
    assert (Domain.$arrow().isRealFloatingType()) : "Unknown domain!";
    switch (EltRank) {
     case HalfRank:
      return HalfTy.$QualType();
     case FloatRank:
      return FloatTy.$QualType();
     case DoubleRank:
      return DoubleTy.$QualType();
     case LongDoubleRank:
      return LongDoubleTy.$QualType();
     case Float128Rank:
      return Float128Ty.$QualType();
    }
    throw new llvm_unreachable("getFloatingRank(): illegal value for rank");
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::getTargetAddressSpace">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ASTContext.h", line = 2200,
   FQN="clang::ASTContext::getTargetAddressSpace", NM="_ZNK5clang10ASTContext21getTargetAddressSpaceENS_8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZNK5clang10ASTContext21getTargetAddressSpaceENS_8QualTypeE")
  //</editor-fold>
  public /*uint*/int getTargetAddressSpace(QualType T) /*const*/ {
    return getTargetAddressSpace(T.getQualifiers());
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::getTargetAddressSpace">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ASTContext.h", line = 2204,
   FQN="clang::ASTContext::getTargetAddressSpace", NM="_ZNK5clang10ASTContext21getTargetAddressSpaceENS_10QualifiersE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZNK5clang10ASTContext21getTargetAddressSpaceENS_10QualifiersE")
  //</editor-fold>
  public /*uint*/int getTargetAddressSpace(Qualifiers Q) /*const*/ {
    return getTargetAddressSpace(Q.getAddressSpace());
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::getTargetAddressSpace">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ASTContext.h", line = 2208,
   FQN="clang::ASTContext::getTargetAddressSpace", NM="_ZNK5clang10ASTContext21getTargetAddressSpaceEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZNK5clang10ASTContext21getTargetAddressSpaceEj")
  //</editor-fold>
  public /*uint*/int getTargetAddressSpace(/*uint*/int AS) /*const*/ {
    if ($less_uint(AS, LangAS.ID.Offset) || $greatereq_uint(AS, LangAS.ID.Offset + LangAS.ID.Count)) {
      return AS;
    } else {
      return AddrSpaceMap.$at(AS - LangAS.ID.Offset);
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::addressSpaceMapManglingFor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ASTContext.h", line = 2215,
   FQN="clang::ASTContext::addressSpaceMapManglingFor", NM="_ZNK5clang10ASTContext26addressSpaceMapManglingForEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZNK5clang10ASTContext26addressSpaceMapManglingForEj")
  //</editor-fold>
  public boolean addressSpaceMapManglingFor(/*uint*/int AS) /*const*/ {
    return AddrSpaceMapMangling
       || $less_uint(AS, LangAS.ID.Offset)
       || $greatereq_uint(AS, LangAS.ID.Offset + LangAS.ID.Count);
  }

/*private:*/
  // Helper for integer ordering
  
  /// getIntegerRank - Return an integer conversion rank (C99 6.3.1.1p1). This
  /// routine will assert if passed a built-in type that isn't an integer or enum,
  /// or if it is not canonicalized.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::getIntegerRank">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp", line = 4689,
   FQN="clang::ASTContext::getIntegerRank", NM="_ZNK5clang10ASTContext14getIntegerRankEPKNS_4TypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZNK5clang10ASTContext14getIntegerRankEPKNS_4TypeE")
  //</editor-fold>
  private /*uint*/int getIntegerRank(/*const*/ Type /*P*/ T) /*const*/ {
    assert (T.isCanonicalUnqualified()) : "T should be canonicalized";
    switch (cast_BuiltinType(T).getKind()) {
     default:
      throw new llvm_unreachable("getIntegerRank(): not a built-in integer");
     case Bool:
      return 1 + (getIntWidth(BoolTy.$QualType()) << 3);
     case Char_S:
     case Char_U:
     case SChar:
     case UChar:
      return 2 + (getIntWidth(CharTy.$QualType()) << 3);
     case Short:
     case UShort:
      return 3 + (getIntWidth(ShortTy.$QualType()) << 3);
     case Int:
     case UInt:
      return 4 + (getIntWidth(IntTy.$QualType()) << 3);
     case Long:
     case ULong:
      return 5 + (getIntWidth(LongTy.$QualType()) << 3);
     case LongLong:
     case ULongLong:
      return 6 + (getIntWidth(LongLongTy.$QualType()) << 3);
     case Int128:
     case UInt128:
      return 7 + (getIntWidth(Int128Ty.$QualType()) << 3);
    }
  }

/*public:*/
  
  //===--------------------------------------------------------------------===//
  //                    Type Compatibility Predicates
  //===--------------------------------------------------------------------===//
  
  /// Compatibility predicates used to check assignment expressions.
  
  /// typesAreCompatible - C99 6.7.3p9: For two qualified types to be compatible,
  /// both shall have the identically qualified version of a compatible type.
  /// C99 6.2.7p1: Two types have compatible types if their types are the
  /// same. See 6.7.[2,3,5] for additional rules.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::typesAreCompatible">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp", line = 7387,
   FQN="clang::ASTContext::typesAreCompatible", NM="_ZN5clang10ASTContext18typesAreCompatibleENS_8QualTypeES1_b",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZN5clang10ASTContext18typesAreCompatibleENS_8QualTypeES1_b")
  //</editor-fold>
  public boolean typesAreCompatible(QualType LHS, QualType RHS) {
    return typesAreCompatible(LHS, RHS, 
                    false);
  }
  public boolean typesAreCompatible(QualType LHS, QualType RHS, 
                    boolean CompareUnqualified/*= false*/) {
    if (getLangOpts().CPlusPlus) {
      return hasSameType(new QualType(LHS), new QualType(RHS));
    }
    
    return !mergeTypes(new QualType(LHS), new QualType(RHS), false, CompareUnqualified).isNull();
  }
 // C99 6.2.7p1
  
  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::propertyTypesAreCompatible">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp", line = 7395,
   FQN="clang::ASTContext::propertyTypesAreCompatible", NM="_ZN5clang10ASTContext26propertyTypesAreCompatibleENS_8QualTypeES1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZN5clang10ASTContext26propertyTypesAreCompatibleENS_8QualTypeES1_")
  //</editor-fold>
  public boolean propertyTypesAreCompatible(QualType LHS, QualType RHS) {
    return typesAreCompatible(new QualType(LHS), new QualType(RHS));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::typesAreBlockPointerCompatible">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp", line = 7399,
   FQN="clang::ASTContext::typesAreBlockPointerCompatible", NM="_ZN5clang10ASTContext30typesAreBlockPointerCompatibleENS_8QualTypeES1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZN5clang10ASTContext30typesAreBlockPointerCompatibleENS_8QualTypeES1_")
  //</editor-fold>
  public boolean typesAreBlockPointerCompatible(QualType LHS, QualType RHS) {
    return !mergeTypes(new QualType(LHS), new QualType(RHS), true).isNull();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::isObjCIdType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ASTContext.h", line = 2238,
   FQN="clang::ASTContext::isObjCIdType", NM="_ZNK5clang10ASTContext12isObjCIdTypeENS_8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZNK5clang10ASTContext12isObjCIdTypeENS_8QualTypeE")
  //</editor-fold>
  public boolean isObjCIdType(QualType T) /*const*/ {
    return $eq_QualType$C(T, getObjCIdType());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::isObjCClassType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ASTContext.h", line = 2241,
   FQN="clang::ASTContext::isObjCClassType", NM="_ZNK5clang10ASTContext15isObjCClassTypeENS_8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZNK5clang10ASTContext15isObjCClassTypeENS_8QualTypeE")
  //</editor-fold>
  public boolean isObjCClassType(QualType T) /*const*/ {
    return $eq_QualType$C(T, getObjCClassType());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::isObjCSelType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ASTContext.h", line = 2244,
   FQN="clang::ASTContext::isObjCSelType", NM="_ZNK5clang10ASTContext13isObjCSelTypeENS_8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZNK5clang10ASTContext13isObjCSelTypeENS_8QualTypeE")
  //</editor-fold>
  public boolean isObjCSelType(QualType T) /*const*/ {
    return $eq_QualType$C(T, getObjCSelType());
  }

  
  /// ObjCQualifiedIdTypesAreCompatible - We know that one of lhs/rhs is an
  /// ObjCQualifiedIDType.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::ObjCQualifiedIdTypesAreCompatible">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp", line = 6823,
   FQN="clang::ASTContext::ObjCQualifiedIdTypesAreCompatible", NM="_ZN5clang10ASTContext33ObjCQualifiedIdTypesAreCompatibleENS_8QualTypeES1_b",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZN5clang10ASTContext33ObjCQualifiedIdTypesAreCompatibleENS_8QualTypeES1_b")
  //</editor-fold>
  public boolean ObjCQualifiedIdTypesAreCompatible(QualType lhs, QualType rhs, 
                                   boolean compare) {
    // Allow id<P..> and an 'id' or void* type in all cases.
    if (lhs.$arrow().isVoidPointerType()
       || lhs.$arrow().isObjCIdType() || lhs.$arrow().isObjCClassType()) {
      return true;
    } else if (rhs.$arrow().isVoidPointerType()
       || rhs.$arrow().isObjCIdType() || rhs.$arrow().isObjCClassType()) {
      return true;
    }
    {

      /*const*/ ObjCObjectPointerType /*P*/ lhsQID = lhs.$arrow().getAsObjCQualifiedIdType();
      if ((lhsQID != null)) {
        /*const*/ ObjCObjectPointerType /*P*/ rhsOPT = rhs.$arrow().getAs(ObjCObjectPointerType.class);
        if (!(rhsOPT != null)) {
          return false;
        }
        if (rhsOPT.qual_empty()) {
          {
            // If the RHS is a unqualified interface pointer "NSString*",
            // make sure we check the class hierarchy.
            ObjCInterfaceDecl /*P*/ rhsID = rhsOPT.getInterfaceDecl();
            if ((rhsID != null)) {
              for (ObjCProtocolDecl /*P*/ I : lhsQID.quals()) {
                // when comparing an id<P> on lhs with a static type on rhs,
                // see if static class implements all of id's protocols, directly or
                // through its super class and categories.
                if (!rhsID.ClassImplementsProtocol(I, true)) {
                  return false;
                }
              }
            }
          }
          // If there are no qualifiers and no interface, we have an 'id'.
          return true;
        }
        // Both the right and left sides have qualifiers.
        for (ObjCProtocolDecl /*P*/ lhsProto : lhsQID.quals()) {
          boolean match = false;
  
          // when comparing an id<P> on lhs with a static type on rhs,
          // see if static class implements all of id's protocols, directly or
          // through its super class and categories.
          for (ObjCProtocolDecl /*P*/ rhsProto : rhsOPT.quals()) {
            if (ProtocolCompatibleWithProtocol(lhsProto, rhsProto)
               || (compare && ProtocolCompatibleWithProtocol(rhsProto, lhsProto))) {
              match = true;
              break;
            }
          }
          {
            // If the RHS is a qualified interface pointer "NSString<P>*",
            // make sure we check the class hierarchy.
            ObjCInterfaceDecl /*P*/ rhsID = rhsOPT.getInterfaceDecl();
            if ((rhsID != null)) {
              for (ObjCProtocolDecl /*P*/ I : lhsQID.quals()) {
                // when comparing an id<P> on lhs with a static type on rhs,
                // see if static class implements all of id's protocols, directly or
                // through its super class and categories.
                if (rhsID.ClassImplementsProtocol(I, true)) {
                  match = true;
                  break;
                }
              }
            }
          }
          if (!match) {
            return false;
          }
        }
  
        return true;
      }
    }
    
    /*const*/ ObjCObjectPointerType /*P*/ rhsQID = rhs.$arrow().getAsObjCQualifiedIdType();
    assert ((rhsQID != null)) : "One of the LHS/RHS should be id<x>";
    {
      
      /*const*/ ObjCObjectPointerType /*P*/ lhsOPT = lhs.$arrow().getAsObjCInterfacePointerType();
      if ((lhsOPT != null)) {
        // If both the right and left sides have qualifiers.
        for (ObjCProtocolDecl /*P*/ lhsProto : lhsOPT.quals()) {
          boolean match = false;
          
          // when comparing an id<P> on rhs with a static type on lhs,
          // see if static class implements all of id's protocols, directly or
          // through its super class and categories.
          // First, lhs protocols in the qualifier list must be found, direct
          // or indirect in rhs's qualifier list or it is a mismatch.
          for (ObjCProtocolDecl /*P*/ rhsProto : rhsQID.quals()) {
            if (ProtocolCompatibleWithProtocol(lhsProto, rhsProto)
               || (compare && ProtocolCompatibleWithProtocol(rhsProto, lhsProto))) {
              match = true;
              break;
            }
          }
          if (!match) {
            return false;
          }
        }
        {
          
          // Static class's protocols, or its super class or category protocols
          // must be found, direct or indirect in rhs's qualifier list or it is a mismatch.
          ObjCInterfaceDecl /*P*/ lhsID = lhsOPT.getInterfaceDecl();
          if ((lhsID != null)) {
            SmallPtrSet<ObjCProtocolDecl /*P*/ > LHSInheritedProtocols/*J*/= new SmallPtrSet<ObjCProtocolDecl /*P*/ >(DenseMapInfo$LikePtr.$Info(), 8);
            CollectInheritedProtocols(lhsID, LHSInheritedProtocols);
            // This is rather dubious but matches gcc's behavior. If lhs has
            // no type qualifier and its class has no static protocol(s)
            // assume that it is mismatch.
            if (LHSInheritedProtocols.empty() && lhsOPT.qual_empty()) {
              return false;
            }
            for (ObjCProtocolDecl /*P*/ lhsProto : LHSInheritedProtocols) {
              boolean match = false;
              for (ObjCProtocolDecl /*P*/ rhsProto : rhsQID.quals()) {
                if (ProtocolCompatibleWithProtocol(lhsProto, rhsProto)
                   || (compare && ProtocolCompatibleWithProtocol(rhsProto, lhsProto))) {
                  match = true;
                  break;
                }
              }
              if (!match) {
                return false;
              }
            }
          }
        }
        return true;
      }
    }
    return false;
  }

  
  
  /// ObjCQualifiedClassTypesAreCompatible - compare  Class<pr,...> and
  /// Class<pr1, ...>.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::ObjCQualifiedClassTypesAreCompatible">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp", line = 6801,
   FQN="clang::ASTContext::ObjCQualifiedClassTypesAreCompatible", NM="_ZN5clang10ASTContext36ObjCQualifiedClassTypesAreCompatibleENS_8QualTypeES1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZN5clang10ASTContext36ObjCQualifiedClassTypesAreCompatibleENS_8QualTypeES1_")
  //</editor-fold>
  public boolean ObjCQualifiedClassTypesAreCompatible(QualType lhs, 
                                      QualType rhs) {
    /*const*/ ObjCObjectPointerType /*P*/ lhsQID = lhs.$arrow().getAs(ObjCObjectPointerType.class);
    /*const*/ ObjCObjectPointerType /*P*/ rhsOPT = rhs.$arrow().getAs(ObjCObjectPointerType.class);
    assert (((lhsQID != null) && (rhsOPT != null))) : "ObjCQualifiedClassTypesAreCompatible";
    
    for (ObjCProtocolDecl /*P*/ lhsProto : lhsQID.quals()) {
      boolean match = false;
      for (ObjCProtocolDecl /*P*/ rhsProto : rhsOPT.quals()) {
        if (ProtocolCompatibleWithProtocol(lhsProto, rhsProto)) {
          match = true;
          break;
  }
      }
      if (!match) {
        return false;
      }
    }
    return true;
  }

  
  // Check the safety of assignment from LHS to RHS
  
  /// canAssignObjCInterfaces - Return true if the two interface types are
  /// compatible for assignment from RHS to LHS.  This handles validation of any
  /// protocol qualifiers on the LHS or RHS.
  ///
  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::canAssignObjCInterfaces">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp", line = 6944,
   FQN="clang::ASTContext::canAssignObjCInterfaces", NM="_ZN5clang10ASTContext23canAssignObjCInterfacesEPKNS_21ObjCObjectPointerTypeES3_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZN5clang10ASTContext23canAssignObjCInterfacesEPKNS_21ObjCObjectPointerTypeES3_")
  //</editor-fold>
  public boolean canAssignObjCInterfaces(/*const*/ ObjCObjectPointerType /*P*/ LHSOPT, 
                         /*const*/ ObjCObjectPointerType /*P*/ RHSOPT) {
    /*const*/ ObjCObjectType /*P*/ LHS = LHSOPT.getObjectType();
    /*const*/ ObjCObjectType /*P*/ RHS = RHSOPT.getObjectType();
    
    // If either type represents the built-in 'id' or 'Class' types, return true.
    if (LHS.isObjCUnqualifiedIdOrClass()
       || RHS.isObjCUnqualifiedIdOrClass()) {
      return true;
    }

    // Function object that propagates a successful result or handles
    // __kindof types.
    Bool2Bool finish = /*[&, &RHS, this, &RHSOPT, &LHSOPT]*/ (boolean succeeded) -> {
          if (succeeded) {
            return true;
          }
          if (!RHS.isKindOfType()) {
            return false;
          }
          
          // Strip off __kindof and protocol qualifiers, then check whether
          // we can assign the other way.
          return canAssignObjCInterfaces(RHSOPT.stripObjCKindOfTypeAndQuals(/*Deref*/this), 
              LHSOPT.stripObjCKindOfTypeAndQuals(/*Deref*/this));
        };
    if (LHS.isObjCQualifiedId() || RHS.isObjCQualifiedId()) {
      return finish.$call(/*KEEP_BOOL*/ObjCQualifiedIdTypesAreCompatible(new QualType(LHSOPT, 0), 
              new QualType(RHSOPT, 0), 
              false));
    }
    if (LHS.isObjCQualifiedClass() && RHS.isObjCQualifiedClass()) {
      return finish.$call(/*KEEP_BOOL*/ObjCQualifiedClassTypesAreCompatible(new QualType(LHSOPT, 0), 
              new QualType(RHSOPT, 0)));
    }
    
    // If we have 2 user-defined types, fall into that path.
    if ((LHS.getInterface() != null) && (RHS.getInterface() != null)) {
      return finish.$call(/*KEEP_BOOL*/canAssignObjCInterfaces(LHS, RHS));
    }
    
    return false;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::canAssignObjCInterfaces">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp", line = 7303,
   FQN="clang::ASTContext::canAssignObjCInterfaces", NM="_ZN5clang10ASTContext23canAssignObjCInterfacesEPKNS_14ObjCObjectTypeES3_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZN5clang10ASTContext23canAssignObjCInterfacesEPKNS_14ObjCObjectTypeES3_")
  //</editor-fold>
  public boolean canAssignObjCInterfaces(/*const*/ ObjCObjectType /*P*/ LHS, 
                         /*const*/ ObjCObjectType /*P*/ RHS) {
    assert ((LHS.getInterface() != null)) : "LHS is not an interface type";
    assert ((RHS.getInterface() != null)) : "RHS is not an interface type";
    
    // Verify that the base decls are compatible: the RHS must be a subclass of
    // the LHS.
    ObjCInterfaceDecl /*P*/ LHSInterface = LHS.getInterface();
    boolean IsSuperClass = LHSInterface.isSuperClassOf(RHS.getInterface());
    if (!IsSuperClass) {
      return false;
    }

    // If the LHS has protocol qualifiers, determine whether all of them are
    // satisfied by the RHS (i.e., the RHS has a superset of the protocols in the
    // LHS).
    if ($greater_uint(LHS.getNumProtocols(), 0)) {
      // OK if conversion of LHS to SuperClass results in narrowing of types
      // ; i.e., SuperClass may implement at least one of the protocols
      // in LHS's protocol list. Example, SuperObj<P1> = lhs<P1,P2> is ok.
      // But not SuperObj<P1,P2,P3> = lhs<P1,P2>.
      SmallPtrSet<ObjCProtocolDecl /*P*/ > SuperClassInheritedProtocols/*J*/= new SmallPtrSet<ObjCProtocolDecl /*P*/ >(DenseMapInfo$LikePtr.$Info(), 8);
      CollectInheritedProtocols(RHS.getInterface(), SuperClassInheritedProtocols);
      // Also, if RHS has explicit quelifiers, include them for comparing with LHS's
      // qualifiers.
      for (ObjCProtocolDecl /*P*/ RHSPI : RHS.quals())  {
        CollectInheritedProtocols(RHSPI, SuperClassInheritedProtocols);
      }
      // If there is no protocols associated with RHS, it is not a match.
      if (SuperClassInheritedProtocols.empty()) {
        return false;
      }
  
      for (/*const*/ ObjCProtocolDecl /*P*/ LHSProto : LHS.quals()) {
        boolean SuperImplementsProtocol = false;
        for (ObjCProtocolDecl /*P*/ SuperClassProto : SuperClassInheritedProtocols)  {
          if ((SuperClassProto.lookupProtocolNamed(LHSProto.getIdentifier()) != null)) {
            SuperImplementsProtocol = true;
            break;
          }
        }
        if (!SuperImplementsProtocol) {
          return false;
        }
      }
    }
    
    // If the LHS is specialized, we may need to check type arguments.
    if (LHS.isSpecialized()) {
      // Follow the superclass chain until we've matched the LHS class in the
      // hierarchy. This substitutes type arguments through.
      /*const*/ ObjCObjectType /*P*/ RHSSuper = RHS;
      while (!declaresSameEntity(RHSSuper.getInterface(), LHSInterface)) {
        RHSSuper = RHSSuper.getSuperClassType().$arrow().castAs(ObjCObjectType.class);
      }
      
      // If the RHS is specializd, compare type arguments.
      if (RHSSuper.isSpecialized()
         && !sameObjCTypeArgs(/*Deref*/this, LHS.getInterface(), 
          LHS.getTypeArgs(), RHSSuper.getTypeArgs(), 
          /*stripKindOf=*/ true)) {
        return false;
      }
    }
    
    return true;
  }

  
  /// canAssignObjCInterfacesInBlockPointer - This routine is specifically written
  /// for providing type-safety for objective-c pointers used to pass/return 
  /// arguments in block literals. When passed as arguments, passing 'A*' where
  /// 'id' is expected is not OK. Passing 'Sub *" where 'Super *" is expected is
  /// not OK. For the return type, the opposite is not OK.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::canAssignObjCInterfacesInBlockPointer">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp", line = 6993,
   FQN="clang::ASTContext::canAssignObjCInterfacesInBlockPointer", NM="_ZN5clang10ASTContext37canAssignObjCInterfacesInBlockPointerEPKNS_21ObjCObjectPointerTypeES3_b",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZN5clang10ASTContext37canAssignObjCInterfacesInBlockPointerEPKNS_21ObjCObjectPointerTypeES3_b")
  //</editor-fold>
  public boolean canAssignObjCInterfacesInBlockPointer(/*const*/ ObjCObjectPointerType /*P*/ LHSOPT, 
                                       /*const*/ ObjCObjectPointerType /*P*/ RHSOPT, 
                                       boolean BlockReturnType) {
    
    // Function object that propagates a successful result or handles
    // __kindof types.
    Bool2Bool finish = /*[&, &BlockReturnType, &RHSOPT, &LHSOPT, this]*/ (boolean succeeded) -> {
          if (succeeded) {
            return true;
          }

          /*const*/ ObjCObjectPointerType /*P*/ Expected = BlockReturnType ? RHSOPT : LHSOPT;
          if (!Expected.isKindOfType()) {
            return false;
          }
          
          // Strip off __kindof and protocol qualifiers, then check whether
          // we can assign the other way.
          return canAssignObjCInterfacesInBlockPointer(RHSOPT.stripObjCKindOfTypeAndQuals(/*Deref*/this), 
              LHSOPT.stripObjCKindOfTypeAndQuals(/*Deref*/this), 
              BlockReturnType);
        };
    if (RHSOPT.isObjCBuiltinType() || LHSOPT.isObjCIdType()) {
      return true;
    }
    if (LHSOPT.isObjCBuiltinType()) {
      return finish.$call(/*KEEP_BOOL*/RHSOPT.isObjCBuiltinType()
             || RHSOPT.isObjCQualifiedIdType());
    }
    if (LHSOPT.isObjCQualifiedIdType() || RHSOPT.isObjCQualifiedIdType()) {
      return finish.$call(/*KEEP_BOOL*/ObjCQualifiedIdTypesAreCompatible(new QualType(LHSOPT, 0), 
              new QualType(RHSOPT, 0), 
              false));
    }
    
    /*const*/ ObjCInterfaceType /*P*/ LHS = LHSOPT.getInterfaceType();
    /*const*/ ObjCInterfaceType /*P*/ RHS = RHSOPT.getInterfaceType();
    if ((LHS != null) && (RHS != null)) { // We have 2 user-defined types.
      if (LHS != RHS) {
        if (LHS.getDecl().isSuperClassOf(RHS.getDecl())) {
          return finish.$call(/*KEEP_BOOL*/BlockReturnType);
        }
        if (RHS.getDecl().isSuperClassOf(LHS.getDecl())) {
          return finish.$call(/*KEEP_BOOL*/!BlockReturnType);
        }
      } else {
        return true;
      }
    }
    return false;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::areComparableObjCPointerTypes">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp", line = 7365,
   FQN="clang::ASTContext::areComparableObjCPointerTypes", NM="_ZN5clang10ASTContext29areComparableObjCPointerTypesENS_8QualTypeES1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZN5clang10ASTContext29areComparableObjCPointerTypesENS_8QualTypeES1_")
  //</editor-fold>
  public boolean areComparableObjCPointerTypes(QualType LHS, QualType RHS) {
    // get the "pointed to" types
    /*const*/ ObjCObjectPointerType /*P*/ LHSOPT = LHS.$arrow().getAs(ObjCObjectPointerType.class);
    /*const*/ ObjCObjectPointerType /*P*/ RHSOPT = RHS.$arrow().getAs(ObjCObjectPointerType.class);
    if (!(LHSOPT != null) || !(RHSOPT != null)) {
      return false;
  }

    return canAssignObjCInterfaces(LHSOPT, RHSOPT)
       || canAssignObjCInterfaces(RHSOPT, LHSOPT);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::areCommonBaseCompatible">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp", line = 7180,
   FQN="clang::ASTContext::areCommonBaseCompatible", NM="_ZN5clang10ASTContext23areCommonBaseCompatibleEPKNS_21ObjCObjectPointerTypeES3_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZN5clang10ASTContext23areCommonBaseCompatibleEPKNS_21ObjCObjectPointerTypeES3_")
  //</editor-fold>
  public QualType areCommonBaseCompatible(/*const*/ ObjCObjectPointerType /*P*/ Lptr, 
                         /*const*/ ObjCObjectPointerType /*P*/ Rptr) {
    /*const*/ ObjCObjectType /*P*/ LHS = Lptr.getObjectType();
    /*const*/ ObjCObjectType /*P*/ RHS = Rptr.getObjectType();
    /*const*/ ObjCInterfaceDecl /*P*/ LDecl = LHS.getInterface();
    /*const*/ ObjCInterfaceDecl /*P*/ RDecl = RHS.getInterface();
    if (!(LDecl != null) || !(RDecl != null)) {
      return new QualType();
    }

    // When either LHS or RHS is a kindof type, we should return a kindof type.
    // For example, for common base of kindof(ASub1) and kindof(ASub2), we return
    // kindof(A).
    boolean anyKindOf = LHS.isKindOfType() || RHS.isKindOfType();
    
    // Follow the left-hand side up the class hierarchy until we either hit a
    // root or find the RHS. Record the ancestors in case we don't find it.
    SmallDenseMap</*const*/ ObjCInterfaceDecl /*P*/ , /*const*/ ObjCObjectType /*P*/ > LHSAncestors/*J*/= new SmallDenseMap</*const*/ ObjCInterfaceDecl /*P*/ , /*const*/ ObjCObjectType /*P*/ >(DenseMapInfo$LikePtr.$Info(), 4, (/*const*/ ObjCObjectType /*P*/ )null);
    while (true) {
      // Record this ancestor. We'll need this if the common type isn't in the
      // path from the LHS to the root.
      LHSAncestors.$set(LHS.getInterface().getCanonicalDecl(), LHS);
      if (declaresSameEntity(LHS.getInterface(), RDecl)) {
        // Get the type arguments.
        ArrayRef<QualType> LHSTypeArgs = LHS.getTypeArgsAsWritten();
        boolean anyChanges = false;
        if (LHS.isSpecialized() && RHS.isSpecialized()) {
          // Both have type arguments, compare them.
          if (!sameObjCTypeArgs(/*Deref*/this, LHS.getInterface(), 
              LHS.getTypeArgs(), RHS.getTypeArgs(), 
              /*stripKindOf=*/ true)) {
            return new QualType();
          }
        } else if (LHS.isSpecialized() != RHS.isSpecialized()) {
          // If only one has type arguments, the result will not have type
          // arguments.
          LHSTypeArgs.$assignMove(/*{ */new ArrayRef<QualType>(false)/* }*/);
          anyChanges = true;
        }
        
        // Compute the intersection of protocols.
        SmallVector<ObjCProtocolDecl /*P*/ > Protocols/*J*/= new SmallVector<ObjCProtocolDecl /*P*/ >(8, (ObjCProtocolDecl /*P*/ )null);
        getIntersectionOfProtocols(/*Deref*/this, LHS.getInterface(), Lptr, Rptr, 
            Protocols);
        if (!Protocols.empty()) {
          anyChanges = true;
        }
        
        // If anything in the LHS will have changed, build a new result type.
        // If we need to return a kindof type but LHS is not a kindof type, we
        // build a new result type.
        if (anyChanges || LHS.isKindOfType() != anyKindOf) {
          QualType Result = getObjCInterfaceType(LHS.getInterface());
          Result.$assignMove(getObjCObjectType(new QualType(Result), new ArrayRef<QualType>(LHSTypeArgs), new ArrayRef<ObjCProtocolDecl /*P*/ >(Protocols, true), 
                  anyKindOf || LHS.isKindOfType()));
          return getObjCObjectPointerType(new QualType(Result));
        }
        
        return getObjCObjectPointerType(new QualType(LHS, 0));
      }
      
      // Find the superclass.
      QualType LHSSuperType = LHS.getSuperClassType();
      if (LHSSuperType.isNull()) {
        break;
      }
      
      LHS = LHSSuperType.$arrow().castAs(ObjCObjectType.class);
    }
    
    // We didn't find anything by following the LHS to its root; now check
    // the RHS against the cached set of ancestors.
    while (true) {
      DenseMapIterator</*const*/ ObjCInterfaceDecl /*P*/ , /*const*/ ObjCObjectType /*P*/ > KnownLHS = LHSAncestors.find(RHS.getInterface().getCanonicalDecl());
      if (KnownLHS.$noteq(/*NO_ITER_COPY*/LHSAncestors.end())) {
        LHS = KnownLHS.$arrow().second;
        
        // Get the type arguments.
        ArrayRef<QualType> RHSTypeArgs = RHS.getTypeArgsAsWritten();
        boolean anyChanges = false;
        if (LHS.isSpecialized() && RHS.isSpecialized()) {
          // Both have type arguments, compare them.
          if (!sameObjCTypeArgs(/*Deref*/this, LHS.getInterface(), 
              LHS.getTypeArgs(), RHS.getTypeArgs(), 
              /*stripKindOf=*/ true)) {
            return new QualType();
          }
        } else if (LHS.isSpecialized() != RHS.isSpecialized()) {
          // If only one has type arguments, the result will not have type
          // arguments.
          RHSTypeArgs.$assignMove(/*{ */new ArrayRef<QualType>(false)/* }*/);
          anyChanges = true;
        }
        
        // Compute the intersection of protocols.
        SmallVector<ObjCProtocolDecl /*P*/ > Protocols/*J*/= new SmallVector<ObjCProtocolDecl /*P*/ >(8, (ObjCProtocolDecl /*P*/ )null);
        getIntersectionOfProtocols(/*Deref*/this, RHS.getInterface(), Lptr, Rptr, 
            Protocols);
        if (!Protocols.empty()) {
          anyChanges = true;
        }
        
        // If we need to return a kindof type but RHS is not a kindof type, we
        // build a new result type.
        if (anyChanges || RHS.isKindOfType() != anyKindOf) {
          QualType Result = getObjCInterfaceType(RHS.getInterface());
          Result.$assignMove(getObjCObjectType(new QualType(Result), new ArrayRef<QualType>(RHSTypeArgs), new ArrayRef<ObjCProtocolDecl /*P*/ >(Protocols, true), 
                  anyKindOf || RHS.isKindOfType()));
          return getObjCObjectPointerType(new QualType(Result));
        }
        
        return getObjCObjectPointerType(new QualType(RHS, 0));
      }
      
      // Find the superclass of the RHS.
      QualType RHSSuperType = RHS.getSuperClassType();
      if (RHSSuperType.isNull()) {
        break;
      }
      
      RHS = RHSSuperType.$arrow().castAs(ObjCObjectType.class);
    }
    
    return new QualType();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::canBindObjCObjectType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp", line = 7377,
   FQN="clang::ASTContext::canBindObjCObjectType", NM="_ZN5clang10ASTContext21canBindObjCObjectTypeENS_8QualTypeES1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZN5clang10ASTContext21canBindObjCObjectTypeENS_8QualTypeES1_")
  //</editor-fold>
  public boolean canBindObjCObjectType(QualType To, QualType From) {
    return canAssignObjCInterfaces(getObjCObjectPointerType(new QualType(To)).$arrow().getAs(ObjCObjectPointerType.class), 
        getObjCObjectPointerType(new QualType(From)).$arrow().getAs(ObjCObjectPointerType.class));
  }

  
  // Functions for calculating composite types
  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::mergeTypes">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp", line = 7627,
   FQN="clang::ASTContext::mergeTypes", NM="_ZN5clang10ASTContext10mergeTypesENS_8QualTypeES1_bbb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZN5clang10ASTContext10mergeTypesENS_8QualTypeES1_bbb")
  //</editor-fold>
  public QualType mergeTypes(QualType LHS, QualType RHS) {
    return mergeTypes(LHS, RHS, 
            false, 
            false, false);
  }
  public QualType mergeTypes(QualType LHS, QualType RHS, 
            boolean OfBlockPointer/*= false*/) {
    return mergeTypes(LHS, RHS, 
            OfBlockPointer, 
            false, false);
  }
  public QualType mergeTypes(QualType LHS, QualType RHS, 
            boolean OfBlockPointer/*= false*/, 
            boolean Unqualified/*= false*/) {
    return mergeTypes(LHS, RHS, 
            OfBlockPointer, 
            Unqualified, false);
  }
  public QualType mergeTypes(QualType LHS, QualType RHS, 
            boolean OfBlockPointer/*= false*/, 
            boolean Unqualified/*= false*/, boolean BlockReturnType/*= false*/) {
    // C++ [expr]: If an expression initially has the type "reference to T", the
    // type is adjusted to "T" prior to any further analysis, the expression
    // designates the object or function denoted by the reference, and the
    // expression is an lvalue unless the reference is an rvalue reference and
    // the expression is a function call (possibly inside parentheses).
    assert (!(LHS.$arrow().getAs(ReferenceType.class) != null)) : "LHS is a reference type?";
    assert (!(RHS.$arrow().getAs(ReferenceType.class) != null)) : "RHS is a reference type?";
    if (Unqualified) {
      LHS.$assignMove(LHS.getUnqualifiedType());
      RHS.$assignMove(RHS.getUnqualifiedType());
    }
    
    QualType LHSCan = getCanonicalType(/*NO_COPY*/LHS).$QualType();
    QualType RHSCan = getCanonicalType(/*NO_COPY*/RHS).$QualType();
    
    // If two types are identical, they are compatible.
    if ($eq_QualType$C(LHSCan, RHSCan)) {
      return new QualType(JD$Move.INSTANCE, LHS);
    }
    
    // If the qualifiers are different, the types aren't compatible... mostly.
    Qualifiers LQuals = LHSCan.getLocalQualifiers();
    Qualifiers RQuals = RHSCan.getLocalQualifiers();
    if (LQuals.$noteq(/*NO_COPY*/RQuals)) {
      if (getLangOpts().OpenCL) {
        if ($noteq_QualType$C(LHSCan.getUnqualifiedType(), RHSCan.getUnqualifiedType())
           || LQuals.getCVRQualifiers() != RQuals.getCVRQualifiers()) {
          return new QualType();
        }
        if (LQuals.isAddressSpaceSupersetOf(new Qualifiers(RQuals))) {
          return new QualType(JD$Move.INSTANCE, LHS);
        }
        if (RQuals.isAddressSpaceSupersetOf(new Qualifiers(LQuals))) {
          return new QualType(JD$Move.INSTANCE, RHS);
        }
      }
      // If any of these qualifiers are different, we have a type
      // mismatch.
      if (LQuals.getCVRQualifiers() != RQuals.getCVRQualifiers()
         || LQuals.getAddressSpace() != RQuals.getAddressSpace()
         || LQuals.getObjCLifetime() != RQuals.getObjCLifetime()) {
        return new QualType();
      }
      
      // Exactly one GC qualifier difference is allowed: __strong is
      // okay if the other type has no GC qualifier but is an Objective
      // C object pointer (i.e. implicitly strong by default).  We fix
      // this by pretending that the unqualified type was actually
      // qualified __strong.
      Qualifiers.GC GC_L = LQuals.getObjCGCAttr();
      Qualifiers.GC GC_R = RQuals.getObjCGCAttr();
      assert ((GC_L != GC_R)) : "unequal qualifier sets had only equal elements";
      if (GC_L == Qualifiers.GC.Weak || GC_R == Qualifiers.GC.Weak) {
        return new QualType();
      }
      if (GC_L == Qualifiers.GC.Strong && RHSCan.$arrow().isObjCObjectPointerType()) {
        return mergeTypes(new QualType(LHS), getObjCGCQualType(new QualType(RHS), Qualifiers.GC.Strong));
      }
      if (GC_R == Qualifiers.GC.Strong && LHSCan.$arrow().isObjCObjectPointerType()) {
        return mergeTypes(getObjCGCQualType(new QualType(LHS), Qualifiers.GC.Strong), new QualType(RHS));
      }
      return new QualType();
    }
    
    // Okay, qualifiers are equal.
    Type.TypeClass LHSClass = LHSCan.$arrow().getTypeClass();
    Type.TypeClass RHSClass = RHSCan.$arrow().getTypeClass();
    
    // We want to consider the two function types to be the same for these
    // comparisons, just force one to the other.
    if (LHSClass == Type.TypeClass.FunctionProto) {
      LHSClass = Type.TypeClass.FunctionNoProto;
    }
    if (RHSClass == Type.TypeClass.FunctionProto) {
      RHSClass = Type.TypeClass.FunctionNoProto;
    }
    
    // Same as above for arrays
    if (LHSClass == Type.TypeClass.VariableArray || LHSClass == Type.TypeClass.IncompleteArray) {
      LHSClass = Type.TypeClass.ConstantArray;
    }
    if (RHSClass == Type.TypeClass.VariableArray || RHSClass == Type.TypeClass.IncompleteArray) {
      RHSClass = Type.TypeClass.ConstantArray;
    }
    
    // ObjCInterfaces are just specialized ObjCObjects.
    if (LHSClass == Type.TypeClass.ObjCInterface) {
      LHSClass = Type.TypeClass.ObjCObject;
    }
    if (RHSClass == Type.TypeClass.ObjCInterface) {
      RHSClass = Type.TypeClass.ObjCObject;
    }
    
    // Canonicalize ExtVector -> Vector.
    if (LHSClass == Type.TypeClass.ExtVector) {
      LHSClass = Type.TypeClass.Vector;
    }
    if (RHSClass == Type.TypeClass.ExtVector) {
      RHSClass = Type.TypeClass.Vector;
    }
    
    // If the canonical type classes don't match.
    if (LHSClass != RHSClass) {
      {
        // Note that we only have special rules for turning block enum
        // returns into block int returns, not vice-versa.
        /*const*/ EnumType /*P*/ ETy = LHS.$arrow().getAs$EnumType();
        if ((ETy != null)) {
          return mergeEnumWithInteger(/*Deref*/this, ETy, new QualType(RHS), false);
        }
      }
      {
        /*const*/ EnumType /*P*/ ETy = RHS.$arrow().getAs$EnumType();
        if ((ETy != null)) {
          return mergeEnumWithInteger(/*Deref*/this, ETy, new QualType(LHS), BlockReturnType);
        }
      }
      // allow block pointer type to match an 'id' type.
      if (OfBlockPointer && !BlockReturnType) {
        if (LHS.$arrow().isObjCIdType() && RHS.$arrow().isBlockPointerType()) {
          return new QualType(JD$Move.INSTANCE, LHS);
        }
        if (RHS.$arrow().isObjCIdType() && LHS.$arrow().isBlockPointerType()) {
          return new QualType(JD$Move.INSTANCE, RHS);
        }
      }
      
      return new QualType();
    }
    
    // The canonical type classes match.
    switch (LHSClass) {
     case DependentSizedArray:
     case DependentSizedExtVector:
     case UnresolvedUsing:
     case Paren:
     case Typedef:
     case Adjusted:
     case Decayed:
     case TypeOfExpr:
     case TypeOf:
     case Decltype:
     case UnaryTransform:
     case Elaborated:
     case Attributed:
     case TemplateTypeParm:
     case SubstTemplateTypeParm:
     case SubstTemplateTypeParmPack:
     case TemplateSpecialization:
     case InjectedClassName:
     case DependentName:
     case DependentTemplateSpecialization:
     case PackExpansion:
      throw new llvm_unreachable("Non-canonical and dependent types shouldn't get here");
     case Auto:
     case LValueReference:
     case RValueReference:
     case MemberPointer:
      throw new llvm_unreachable("C++ should never be in mergeTypes");
     case ObjCInterface:
     case IncompleteArray:
     case VariableArray:
     case FunctionProto:
     case ExtVector:
      throw new llvm_unreachable("Types are eliminated above");
     case Pointer:
      {
        // Merge two pointer types, while trying to preserve typedef info
        QualType LHSPointee = LHS.$arrow().getAs(PointerType.class).getPointeeType();
        QualType RHSPointee = RHS.$arrow().getAs(PointerType.class).getPointeeType();
        if (Unqualified) {
          LHSPointee.$assignMove(LHSPointee.getUnqualifiedType());
          RHSPointee.$assignMove(RHSPointee.getUnqualifiedType());
        }
        QualType ResultType = mergeTypes(new QualType(LHSPointee), new QualType(RHSPointee), false, 
            Unqualified);
        if (ResultType.isNull()) {
          return new QualType();
        }
        if ($eq_CanQual$T_CanQual$U(getCanonicalType(/*NO_COPY*/LHSPointee), getCanonicalType(/*NO_COPY*/ResultType))) {
          return new QualType(JD$Move.INSTANCE, LHS);
        }
        if ($eq_CanQual$T_CanQual$U(getCanonicalType(/*NO_COPY*/RHSPointee), getCanonicalType(/*NO_COPY*/ResultType))) {
          return new QualType(JD$Move.INSTANCE, RHS);
        }
        return getPointerType(/*NO_COPY*/ResultType);
      }
     case BlockPointer:
      {
        // Merge two block pointer types, while trying to preserve typedef info
        QualType LHSPointee = LHS.$arrow().getAs(BlockPointerType.class).getPointeeType();
        QualType RHSPointee = RHS.$arrow().getAs(BlockPointerType.class).getPointeeType();
        if (Unqualified) {
          LHSPointee.$assignMove(LHSPointee.getUnqualifiedType());
          RHSPointee.$assignMove(RHSPointee.getUnqualifiedType());
        }
        QualType ResultType = mergeTypes(new QualType(LHSPointee), new QualType(RHSPointee), OfBlockPointer, 
            Unqualified);
        if (ResultType.isNull()) {
          return new QualType();
        }
        if ($eq_CanQual$T_CanQual$U(getCanonicalType(/*NO_COPY*/LHSPointee), getCanonicalType(/*NO_COPY*/ResultType))) {
          return new QualType(JD$Move.INSTANCE, LHS);
        }
        if ($eq_CanQual$T_CanQual$U(getCanonicalType(/*NO_COPY*/RHSPointee), getCanonicalType(/*NO_COPY*/ResultType))) {
          return new QualType(JD$Move.INSTANCE, RHS);
        }
        return getBlockPointerType(new QualType(ResultType));
      }
     case Atomic:
      {
        // Merge two pointer types, while trying to preserve typedef info
        QualType LHSValue = LHS.$arrow().getAs(AtomicType.class).getValueType();
        QualType RHSValue = RHS.$arrow().getAs(AtomicType.class).getValueType();
        if (Unqualified) {
          LHSValue.$assignMove(LHSValue.getUnqualifiedType());
          RHSValue.$assignMove(RHSValue.getUnqualifiedType());
        }
        QualType ResultType = mergeTypes(new QualType(LHSValue), new QualType(RHSValue), false, 
            Unqualified);
        if (ResultType.isNull()) {
          return new QualType();
        }
        if ($eq_CanQual$T_CanQual$U(getCanonicalType(/*NO_COPY*/LHSValue), getCanonicalType(/*NO_COPY*/ResultType))) {
          return new QualType(JD$Move.INSTANCE, LHS);
        }
        if ($eq_CanQual$T_CanQual$U(getCanonicalType(/*NO_COPY*/RHSValue), getCanonicalType(/*NO_COPY*/ResultType))) {
          return new QualType(JD$Move.INSTANCE, RHS);
        }
        return getAtomicType(new QualType(ResultType));
      }
     case ConstantArray:
      {
        /*const*/ ConstantArrayType /*P*/ LCAT = getAsConstantArrayType(new QualType(LHS));
        /*const*/ ConstantArrayType /*P*/ RCAT = getAsConstantArrayType(new QualType(RHS));
        if ((LCAT != null) && (RCAT != null) && RCAT.getSize().$noteq(LCAT.getSize())) {
          return new QualType();
        }
        
        QualType LHSElem = getAsArrayType(new QualType(LHS)).getElementType();
        QualType RHSElem = getAsArrayType(new QualType(RHS)).getElementType();
        if (Unqualified) {
          LHSElem.$assignMove(LHSElem.getUnqualifiedType());
          RHSElem.$assignMove(RHSElem.getUnqualifiedType());
        }
        
        QualType ResultType = mergeTypes(new QualType(LHSElem), new QualType(RHSElem), false, Unqualified);
        if (ResultType.isNull()) {
          return new QualType();
        }
        if ((LCAT != null) && $eq_CanQual$T_CanQual$U(getCanonicalType(/*NO_COPY*/LHSElem), getCanonicalType(/*NO_COPY*/ResultType))) {
          return new QualType(JD$Move.INSTANCE, LHS);
        }
        if ((RCAT != null) && $eq_CanQual$T_CanQual$U(getCanonicalType(/*NO_COPY*/RHSElem), getCanonicalType(/*NO_COPY*/ResultType))) {
          return new QualType(JD$Move.INSTANCE, RHS);
        }
        if ((LCAT != null)) {
          return getConstantArrayType(new QualType(ResultType), LCAT.getSize(), 
              ArrayType.ArraySizeModifier.valueOf(0), 0);
        }
        if ((RCAT != null)) {
          return getConstantArrayType(new QualType(ResultType), RCAT.getSize(), 
              ArrayType.ArraySizeModifier.valueOf(0), 0);
        }
        /*const*/ VariableArrayType /*P*/ LVAT = getAsVariableArrayType(new QualType(LHS));
        /*const*/ VariableArrayType /*P*/ RVAT = getAsVariableArrayType(new QualType(RHS));
        if ((LVAT != null) && $eq_CanQual$T_CanQual$U(getCanonicalType(/*NO_COPY*/LHSElem), getCanonicalType(/*NO_COPY*/ResultType))) {
          return new QualType(JD$Move.INSTANCE, LHS);
        }
        if ((RVAT != null) && $eq_CanQual$T_CanQual$U(getCanonicalType(/*NO_COPY*/RHSElem), getCanonicalType(/*NO_COPY*/ResultType))) {
          return new QualType(JD$Move.INSTANCE, RHS);
        }
        if ((LVAT != null)) {
          // FIXME: This isn't correct! But tricky to implement because
          // the array's size has to be the size of LHS, but the type
          // has to be different.
          return new QualType(JD$Move.INSTANCE, LHS);
        }
        if ((RVAT != null)) {
          // FIXME: This isn't correct! But tricky to implement because
          // the array's size has to be the size of RHS, but the type
          // has to be different.
          return new QualType(JD$Move.INSTANCE, RHS);
        }
        if ($eq_CanQual$T_CanQual$U(getCanonicalType(/*NO_COPY*/LHSElem), getCanonicalType(/*NO_COPY*/ResultType))) {
          return new QualType(JD$Move.INSTANCE, LHS);
        }
        if ($eq_CanQual$T_CanQual$U(getCanonicalType(/*NO_COPY*/RHSElem), getCanonicalType(/*NO_COPY*/ResultType))) {
          return new QualType(JD$Move.INSTANCE, RHS);
        }
        return getIncompleteArrayType(new QualType(ResultType), 
            ArrayType.ArraySizeModifier.valueOf(0), 0);
      }
     case FunctionNoProto:
      return mergeFunctionTypes(new QualType(LHS), new QualType(RHS), OfBlockPointer, Unqualified);
     case Record:
     case Enum:
      return new QualType();
     case Builtin:
      // Only exactly equal builtin types are compatible, which is tested above.
      return new QualType();
     case Complex:
      // Distinct complex types are incompatible.
      return new QualType();
     case Vector:
      // FIXME: The merged type should be an ExtVector!
      if (areCompatVectorTypes(LHSCan.$arrow().getAs(VectorType.class), 
          RHSCan.$arrow().getAs(VectorType.class))) {
        return new QualType(JD$Move.INSTANCE, LHS);
      }
      return new QualType();
     case ObjCObject:
      {
        // Check if the types are assignment compatible.
        // FIXME: This should be type compatibility, e.g. whether
        // "LHS x; RHS x;" at global scope is legal.
        /*const*/ ObjCObjectType /*P*/ LHSIface = LHS.$arrow().getAs(ObjCObjectType.class);
        /*const*/ ObjCObjectType /*P*/ RHSIface = RHS.$arrow().getAs(ObjCObjectType.class);
        if (canAssignObjCInterfaces(LHSIface, RHSIface)) {
          return new QualType(JD$Move.INSTANCE, LHS);
        }
        
        return new QualType();
      }
     case ObjCObjectPointer:
      {
        if (OfBlockPointer) {
          if (canAssignObjCInterfacesInBlockPointer(LHS.$arrow().getAs(ObjCObjectPointerType.class), 
              RHS.$arrow().getAs(ObjCObjectPointerType.class), 
              BlockReturnType)) {
            return new QualType(JD$Move.INSTANCE, LHS);
          }
          return new QualType();
        }
        if (canAssignObjCInterfaces(LHS.$arrow().getAs(ObjCObjectPointerType.class), 
            RHS.$arrow().getAs(ObjCObjectPointerType.class))) {
          return new QualType(JD$Move.INSTANCE, LHS);
        }
        
        return new QualType();
      }
     case Pipe:
      {
        // Merge two pointer types, while trying to preserve typedef info
        QualType LHSValue = LHS.$arrow().getAs(PipeType.class).getElementType();
        QualType RHSValue = RHS.$arrow().getAs(PipeType.class).getElementType();
        if (Unqualified) {
          LHSValue.$assignMove(LHSValue.getUnqualifiedType());
          RHSValue.$assignMove(RHSValue.getUnqualifiedType());
        }
        QualType ResultType = mergeTypes(new QualType(LHSValue), new QualType(RHSValue), false, 
            Unqualified);
        if (ResultType.isNull()) {
          return new QualType();
        }
        if ($eq_CanQual$T_CanQual$U(getCanonicalType(/*NO_COPY*/LHSValue), getCanonicalType(/*NO_COPY*/ResultType))) {
          return new QualType(JD$Move.INSTANCE, LHS);
        }
        if ($eq_CanQual$T_CanQual$U(getCanonicalType(/*NO_COPY*/RHSValue), getCanonicalType(/*NO_COPY*/ResultType))) {
          return new QualType(JD$Move.INSTANCE, RHS);
        }
        return getPipeType(new QualType(ResultType));
      }
    }
    throw new llvm_unreachable("Invalid Type::Class!");
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::mergeFunctionTypes">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp", line = 7445,
   FQN="clang::ASTContext::mergeFunctionTypes", NM="_ZN5clang10ASTContext18mergeFunctionTypesENS_8QualTypeES1_bb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZN5clang10ASTContext18mergeFunctionTypesENS_8QualTypeES1_bb")
  //</editor-fold>
  public QualType mergeFunctionTypes(QualType lhs, QualType rhs) {
    return mergeFunctionTypes(lhs, rhs, 
                    false, 
                    false);
  }
  public QualType mergeFunctionTypes(QualType lhs, QualType rhs, 
                    boolean OfBlockPointer/*= false*/) {
    return mergeFunctionTypes(lhs, rhs, 
                    OfBlockPointer, 
                    false);
  }
  public QualType mergeFunctionTypes(QualType lhs, QualType rhs, 
                    boolean OfBlockPointer/*= false*/, 
                    boolean Unqualified/*= false*/) {
    /*const*/ FunctionType /*P*/ lbase = lhs.$arrow().getAs(FunctionType.class);
    /*const*/ FunctionType /*P*/ rbase = rhs.$arrow().getAs(FunctionType.class);
    /*const*/ FunctionProtoType /*P*/ lproto = dyn_cast_FunctionProtoType(lbase);
    /*const*/ FunctionProtoType /*P*/ rproto = dyn_cast_FunctionProtoType(rbase);
    boolean allLTypes = true;
    boolean allRTypes = true;
    
    // Check return type
    QualType retType/*J*/= new QualType();
    if (OfBlockPointer) {
      QualType RHS = rbase.getReturnType();
      QualType LHS = lbase.getReturnType();
      boolean UnqualifiedResult = Unqualified;
      if (!UnqualifiedResult) {
        UnqualifiedResult = (!RHS.hasQualifiers() && LHS.hasQualifiers());
      }
      retType.$assignMove(mergeTypes(new QualType(LHS), new QualType(RHS), true, UnqualifiedResult, true));
    } else {
      retType.$assignMove(mergeTypes(lbase.getReturnType(), rbase.getReturnType(), false, 
              Unqualified));
    }
    if (retType.isNull()) {
      return new QualType();
    }
    if (Unqualified) {
      retType.$assignMove(retType.getUnqualifiedType());
    }

    CanQual<Type> LRetType = getCanonicalType(lbase.getReturnType());
    CanQual<Type> RRetType = getCanonicalType(rbase.getReturnType());
    if (Unqualified) {
      LRetType.$assignMove(LRetType.getUnqualifiedType());
      RRetType.$assignMove(RRetType.getUnqualifiedType());
    }
    if ($noteq_CanQual$T_CanQual$U(getCanonicalType(/*NO_COPY*/retType), /*NO_COPY*/LRetType)) {
      allLTypes = false;
    }
    if ($noteq_CanQual$T_CanQual$U(getCanonicalType(/*NO_COPY*/retType), /*NO_COPY*/RRetType)) {
      allRTypes = false;
    }
  
    // FIXME: double check this
    // FIXME: should we error if lbase->getRegParmAttr() != 0 &&
    //                           rbase->getRegParmAttr() != 0 &&
    //                           lbase->getRegParmAttr() != rbase->getRegParmAttr()?
    FunctionType.ExtInfo lbaseInfo = lbase.getExtInfo();
    FunctionType.ExtInfo rbaseInfo = rbase.getExtInfo();
    
    // Compatible functions must have compatible calling conventions
    if (lbaseInfo.getCC() != rbaseInfo.getCC()) {
      return new QualType();
    }
    
    // Regparm is part of the calling convention.
    if (lbaseInfo.getHasRegParm() != rbaseInfo.getHasRegParm()) {
      return new QualType();
    }
    if (lbaseInfo.getRegParm() != rbaseInfo.getRegParm()) {
      return new QualType();
    }
    if (lbaseInfo.getProducesResult() != rbaseInfo.getProducesResult()) {
      return new QualType();
    }
    
    // FIXME: some uses, e.g. conditional exprs, really want this to be 'both'.
    boolean NoReturn = lbaseInfo.getNoReturn() || rbaseInfo.getNoReturn();
    if (lbaseInfo.getNoReturn() != NoReturn) {
      allLTypes = false;
    }
    if (rbaseInfo.getNoReturn() != NoReturn) {
      allRTypes = false;
    }
    
    FunctionType.ExtInfo einfo = lbaseInfo.withNoReturn(NoReturn);
    if ((lproto != null) && (rproto != null)) { // two C99 style function prototypes
      assert (!lproto.hasExceptionSpec() && !rproto.hasExceptionSpec()) : "C++ shouldn't be here";
      // Compatible functions must have the same number of parameters
      if (lproto.getNumParams() != rproto.getNumParams()) {
        return new QualType();
      }
      
      // Variadic and non-variadic functions aren't compatible
      if (lproto.isVariadic() != rproto.isVariadic()) {
        return new QualType();
      }
      if (lproto.getTypeQuals() != rproto.getTypeQuals()) {
        return new QualType();
      }
      if (!doFunctionTypesMatchOnExtParameterInfos(rproto, lproto)) {
        return new QualType();
      }
      
      // Check parameter type compatibility
      SmallVector<QualType> types/*J*/= new SmallVector<QualType>(10, new QualType());
      for (/*uint*/int i = 0, n = lproto.getNumParams(); $less_uint(i, n); i++) {
        QualType lParamType = lproto.getParamType(i).getUnqualifiedType();
        QualType rParamType = rproto.getParamType(i).getUnqualifiedType();
        QualType paramType = mergeFunctionParameterTypes(new QualType(lParamType), new QualType(rParamType), OfBlockPointer, Unqualified);
        if (paramType.isNull()) {
          return new QualType();
        }
        if (Unqualified) {
          paramType.$assignMove(paramType.getUnqualifiedType());
        }
        
        types.push_back(paramType);
        if (Unqualified) {
          lParamType.$assignMove(lParamType.getUnqualifiedType());
          rParamType.$assignMove(rParamType.getUnqualifiedType());
        }
        if ($noteq_CanQual$T_CanQual$U(getCanonicalType(/*NO_COPY*/paramType), getCanonicalType(/*NO_COPY*/lParamType))) {
          allLTypes = false;
        }
        if ($noteq_CanQual$T_CanQual$U(getCanonicalType(/*NO_COPY*/paramType), getCanonicalType(/*NO_COPY*/rParamType))) {
          allRTypes = false;
        }
      }
      if (allLTypes) {
        return new QualType(JD$Move.INSTANCE, lhs);
      }
      if (allRTypes) {
        return new QualType(JD$Move.INSTANCE, rhs);
      }
      
      FunctionProtoType.ExtProtoInfo EPI = lproto.getExtProtoInfo();
      EPI.ExtInfo.$assign(einfo);
      return getFunctionType(new QualType(retType), new ArrayRef<QualType>(types, false), EPI);
    }
    if ((lproto != null)) {
      allRTypes = false;
    }
    if ((rproto != null)) {
      allLTypes = false;
    }
    
    /*const*/ FunctionProtoType /*P*/ proto = (lproto != null) ? lproto : rproto;
    if ((proto != null)) {
      assert (!proto.hasExceptionSpec()) : "C++ shouldn't be here";
      if (proto.isVariadic()) {
        return new QualType();
      }
      // Check that the types are compatible with the types that
      // would result from default argument promotions (C99 6.7.5.3p15).
      // The only types actually affected are promotable integer
      // types and floats, which would be passed as a different
      // type depending on whether the prototype is visible.
      for (/*uint*/int i = 0, n = proto.getNumParams(); $less_uint(i, n); ++i) {
        QualType paramTy = proto.getParamType(i);
        {
          
          // Look at the converted type of enum types, since that is the type used
          // to pass enum values.
          /*const*/ EnumType /*P*/ Enum = paramTy.$arrow().getAs$EnumType();
          if ((Enum != null)) {
            paramTy.$assignMove(Enum.getDecl().getIntegerType());
            if (paramTy.isNull()) {
              return new QualType();
            }
          }
        }
        if (paramTy.$arrow().isPromotableIntegerType()
           || $eq_CanQual$T_CanQual$U(getCanonicalType(/*NO_COPY*/paramTy).getUnqualifiedType(), /*NO_COPY*/FloatTy)) {
          return new QualType();
        }
      }
      if (allLTypes) {
        return new QualType(JD$Move.INSTANCE, lhs);
      }
      if (allRTypes) {
        return new QualType(JD$Move.INSTANCE, rhs);
      }
      
      FunctionProtoType.ExtProtoInfo EPI = proto.getExtProtoInfo();
      EPI.ExtInfo.$assign(einfo);
      return getFunctionType(new QualType(retType), proto.getParamTypes(), EPI);
    }
    if (allLTypes) {
      return new QualType(JD$Move.INSTANCE, lhs);
    }
    if (allRTypes) {
      return new QualType(JD$Move.INSTANCE, rhs);
    }
    return getFunctionNoProtoType(new QualType(retType), einfo);
  }

  
  /// mergeFunctionParameterTypes - merge two types which appear as function
  /// parameter types
  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::mergeFunctionParameterTypes">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp", line = 7426,
   FQN="clang::ASTContext::mergeFunctionParameterTypes", NM="_ZN5clang10ASTContext27mergeFunctionParameterTypesENS_8QualTypeES1_bb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZN5clang10ASTContext27mergeFunctionParameterTypesENS_8QualTypeES1_bb")
  //</editor-fold>
  public QualType mergeFunctionParameterTypes(QualType lhs, QualType rhs) {
    return mergeFunctionParameterTypes(lhs, rhs, 
                             false, 
                             false);
  }
  public QualType mergeFunctionParameterTypes(QualType lhs, QualType rhs, 
                             boolean OfBlockPointer/*= false*/) {
    return mergeFunctionParameterTypes(lhs, rhs, 
                             OfBlockPointer, 
                             false);
  }
  public QualType mergeFunctionParameterTypes(QualType lhs, QualType rhs, 
                             boolean OfBlockPointer/*= false*/, 
                             boolean Unqualified/*= false*/) {
    // GNU extension: two types are compatible if they appear as a function
    // argument, one of the types is a transparent union type and the other
    // type is compatible with a union member
    QualType lmerge = mergeTransparentUnionType(new QualType(lhs), new QualType(rhs), OfBlockPointer, 
        Unqualified);
    if (!lmerge.isNull()) {
      return lmerge;
    }

    QualType rmerge = mergeTransparentUnionType(new QualType(rhs), new QualType(lhs), OfBlockPointer, 
        Unqualified);
    if (!rmerge.isNull()) {
      return rmerge;
    }
  
    return mergeTypes(new QualType(lhs), new QualType(rhs), OfBlockPointer, Unqualified);
  }

  
  /// mergeTransparentUnionType - if T is a transparent union type and a member
  /// of T is compatible with SubType, return the merged type, else return
  /// QualType()
  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::mergeTransparentUnionType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp", line = 7406,
   FQN="clang::ASTContext::mergeTransparentUnionType", NM="_ZN5clang10ASTContext25mergeTransparentUnionTypeENS_8QualTypeES1_bb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZN5clang10ASTContext25mergeTransparentUnionTypeENS_8QualTypeES1_bb")
  //</editor-fold>
  public QualType mergeTransparentUnionType(QualType T, QualType SubType) {
    return mergeTransparentUnionType(T, SubType, 
                           false, 
                           false);
  }
  public QualType mergeTransparentUnionType(QualType T, QualType SubType, 
                           boolean OfBlockPointer/*= false*/) {
    return mergeTransparentUnionType(T, SubType, 
                           OfBlockPointer, 
                           false);
  }
  public QualType mergeTransparentUnionType(QualType T, QualType SubType, 
                           boolean OfBlockPointer/*= false*/, 
                           boolean Unqualified/*= false*/) {
    {
      /*const*/ RecordType /*P*/ UT = T.$arrow().getAsUnionType();
      if ((UT != null)) {
        RecordDecl /*P*/ UD = UT.getDecl();
        if (UD.hasAttr(TransparentUnionAttr.class)) {
          for (/*const*/ FieldDecl /*P*/ I : UD.fields()) {
            QualType ET = I.getType().getUnqualifiedType();
            QualType MT = mergeTypes(new QualType(ET), new QualType(SubType), OfBlockPointer, Unqualified);
            if (!MT.isNull()) {
              return MT;
            }
          }
        }
      }
    }

    return new QualType();
  }
  
  
  
  /// mergeObjCGCQualifiers - This routine merges ObjC's GC attribute of 'LHS' and
  /// 'RHS' attributes and returns the merged version; including for function
  /// return types.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::mergeObjCGCQualifiers">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp", line = 7956,
   FQN="clang::ASTContext::mergeObjCGCQualifiers", NM="_ZN5clang10ASTContext21mergeObjCGCQualifiersENS_8QualTypeES1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZN5clang10ASTContext21mergeObjCGCQualifiersENS_8QualTypeES1_")
  //</editor-fold>
  public QualType mergeObjCGCQualifiers(QualType LHS, QualType RHS) {
    QualType LHSCan = getCanonicalType(/*NO_COPY*/LHS).$QualType();
    QualType RHSCan = getCanonicalType(/*NO_COPY*/RHS).$QualType();
    // If two types are identical, they are compatible.
    if ($eq_QualType$C(LHSCan, RHSCan)) {
      return new QualType(JD$Move.INSTANCE, LHS);
    }
    if (RHSCan.$arrow().isFunctionType()) {
      if (!LHSCan.$arrow().isFunctionType()) {
        return new QualType();
      }
      QualType OldReturnType = cast_FunctionType(RHSCan.getTypePtr()).getReturnType();
      QualType NewReturnType = cast_FunctionType(LHSCan.getTypePtr()).getReturnType();
      QualType ResReturnType = mergeObjCGCQualifiers(new QualType(NewReturnType), new QualType(OldReturnType));
      if (ResReturnType.isNull()) {
        return new QualType();
      }
      if ($eq_QualType$C(ResReturnType, NewReturnType) || $eq_QualType$C(ResReturnType, OldReturnType)) {
        // id foo(); ... __strong id foo(); or: __strong id foo(); ... id foo();
        // In either case, use OldReturnType to build the new function type.
        /*const*/ FunctionType /*P*/ F = LHS.$arrow().getAs(FunctionType.class);
        {
          /*const*/ FunctionProtoType /*P*/ FPT = cast_FunctionProtoType(F);
          if ((FPT != null)) {
            FunctionProtoType.ExtProtoInfo EPI = FPT.getExtProtoInfo();
            EPI.ExtInfo.$assignMove(getFunctionExtInfo(new QualType(LHS)));
            QualType ResultType = getFunctionType(new QualType(OldReturnType), FPT.getParamTypes(), EPI);
            return ResultType;
          }
        }
      }
      return new QualType();
    }

    // If the qualifiers are different, the types can still be merged.
    Qualifiers LQuals = LHSCan.getLocalQualifiers();
    Qualifiers RQuals = RHSCan.getLocalQualifiers();
    if (LQuals.$noteq(/*NO_COPY*/RQuals)) {
      // If any of these qualifiers are different, we have a type mismatch.
      if (LQuals.getCVRQualifiers() != RQuals.getCVRQualifiers()
         || LQuals.getAddressSpace() != RQuals.getAddressSpace()) {
        return new QualType();
      }
  
      // Exactly one GC qualifier difference is allowed: __strong is
      // okay if the other type has no GC qualifier but is an Objective
      // C object pointer (i.e. implicitly strong by default).  We fix
      // this by pretending that the unqualified type was actually
      // qualified __strong.
      Qualifiers.GC GC_L = LQuals.getObjCGCAttr();
      Qualifiers.GC GC_R = RQuals.getObjCGCAttr();
      assert ((GC_L != GC_R)) : "unequal qualifier sets had only equal elements";
      if (GC_L == Qualifiers.GC.Weak || GC_R == Qualifiers.GC.Weak) {
        return new QualType();
      }
      if (GC_L == Qualifiers.GC.Strong) {
        return new QualType(JD$Move.INSTANCE, LHS);
      }
      if (GC_R == Qualifiers.GC.Strong) {
        return new QualType(JD$Move.INSTANCE, RHS);
      }
      return new QualType();
    }
    if (LHSCan.$arrow().isObjCObjectPointerType() && RHSCan.$arrow().isObjCObjectPointerType()) {
      QualType LHSBaseQT = LHS.$arrow().getAs(ObjCObjectPointerType.class).getPointeeType();
      QualType RHSBaseQT = RHS.$arrow().getAs(ObjCObjectPointerType.class).getPointeeType();
      QualType ResQT = mergeObjCGCQualifiers(new QualType(LHSBaseQT), new QualType(RHSBaseQT));
      if ($eq_QualType$C(ResQT, LHSBaseQT)) {
        return new QualType(JD$Move.INSTANCE, LHS);
      }
      if ($eq_QualType$C(ResQT, RHSBaseQT)) {
        return new QualType(JD$Move.INSTANCE, RHS);
      }
    }
    return new QualType();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::doFunctionTypesMatchOnExtParameterInfos">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp", line = 7926,
   FQN="clang::ASTContext::doFunctionTypesMatchOnExtParameterInfos", NM="_ZN5clang10ASTContext39doFunctionTypesMatchOnExtParameterInfosEPKNS_17FunctionProtoTypeES3_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZN5clang10ASTContext39doFunctionTypesMatchOnExtParameterInfosEPKNS_17FunctionProtoTypeES3_")
  //</editor-fold>
  public boolean doFunctionTypesMatchOnExtParameterInfos(/*const*/ FunctionProtoType /*P*/ firstFnType, 
                                         /*const*/ FunctionProtoType /*P*/ secondFnType) {
    // Fast path: if the first type doesn't have ext parameter infos,
    // we match if and only if they second type also doesn't have them.
    if (!firstFnType.hasExtParameterInfos()) {
      return !secondFnType.hasExtParameterInfos();
    }

    // Otherwise, we can only match if the second type has them.
    if (!secondFnType.hasExtParameterInfos()) {
      return false;
    }
  
    ArrayRef<FunctionProtoType.ExtParameterInfo> firstEPI = firstFnType.getExtParameterInfos();
    ArrayRef<FunctionProtoType.ExtParameterInfo> secondEPI = secondFnType.getExtParameterInfos();
    assert (firstEPI.size() == secondEPI.size());
    
    for (/*size_t*/int i = 0, n = firstEPI.size(); i != n; ++i) {
      if (FunctionProtoType.ExtParameterInfo.$noteq_ExtParameterInfo(/*NO_COPY*/firstEPI.$at(i), /*NO_COPY*/secondEPI.$at(i))) {
        return false;
      }
    }
    return true;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::ResetObjCLayout">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp", line = 7949,
   FQN="clang::ASTContext::ResetObjCLayout", NM="_ZN5clang10ASTContext15ResetObjCLayoutEPKNS_17ObjCContainerDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZN5clang10ASTContext15ResetObjCLayoutEPKNS_17ObjCContainerDeclE")
  //</editor-fold>
  public void ResetObjCLayout(/*const*/ ObjCContainerDecl /*P*/ CD) {
    ObjCLayouts.$set(CD, null);
  }

  
  //===--------------------------------------------------------------------===//
  //                    Integer Predicates
  //===--------------------------------------------------------------------===//
  
  // The width of an integer, as defined in C99 6.2.6.2. This is the number
  // of bits in an integer type excluding any padding bits.
  
  //===----------------------------------------------------------------------===//
  //                         Integer Predicates
  //===----------------------------------------------------------------------===//
  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::getIntWidth">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp", line = 8032,
   FQN="clang::ASTContext::getIntWidth", NM="_ZNK5clang10ASTContext11getIntWidthENS_8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZNK5clang10ASTContext11getIntWidthENS_8QualTypeE")
  //</editor-fold>
  public /*uint*/int getIntWidth(QualType T) /*const*/ {
    {
      /*const*/ EnumType /*P*/ ET = T.$arrow().getAs$EnumType();
      if ((ET != null)) {
        T.$assignMove(ET.getDecl().getIntegerType());
      }
    }
    if (T.$arrow().isBooleanType()) {
      return 1;
    }
    // For builtin types, just use the standard type sizing method
    return (/*uint*/int)$ulong2uint(getTypeSize(new QualType(T)));
  }

  
  // Per C99 6.2.5p6, for every signed integer type, there is a corresponding
  // unsigned integer type.  This method takes a signed type, and returns the
  // corresponding unsigned integer type.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::getCorrespondingUnsignedType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp", line = 8041,
   FQN="clang::ASTContext::getCorrespondingUnsignedType", NM="_ZNK5clang10ASTContext28getCorrespondingUnsignedTypeENS_8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZNK5clang10ASTContext28getCorrespondingUnsignedTypeENS_8QualTypeE")
  //</editor-fold>
  public QualType getCorrespondingUnsignedType(QualType T) /*const*/ {
    assert (T.$arrow().hasSignedIntegerRepresentation()) : "Unexpected type";
    {
      
      // Turn <4 x signed int> -> <4 x unsigned int>
      /*const*/ VectorType /*P*/ VTy = T.$arrow().getAs(VectorType.class);
      if ((VTy != null)) {
        return getVectorType(getCorrespondingUnsignedType(VTy.getElementType()), 
            VTy.getNumElements(), VTy.getVectorKind());
      }
    }
    {
      
      // For enums, we return the unsigned version of the base type.
      /*const*/ EnumType /*P*/ ETy = T.$arrow().getAs$EnumType();
      if ((ETy != null)) {
        T.$assignMove(ETy.getDecl().getIntegerType());
      }
    }
    
    /*const*/ BuiltinType /*P*/ BTy = T.$arrow().getAs$BuiltinType();
    assert ((BTy != null)) : "Unexpected signed integer type";
    switch (BTy.getKind()) {
     case Char_S:
     case SChar:
      return UnsignedCharTy.$QualType();
     case Short:
      return UnsignedShortTy.$QualType();
     case Int:
      return UnsignedIntTy.$QualType();
     case Long:
      return UnsignedLongTy.$QualType();
     case LongLong:
      return UnsignedLongLongTy.$QualType();
     case Int128:
      return UnsignedInt128Ty.$QualType();
     default:
      throw new llvm_unreachable("Unexpected signed integer type");
    }
  }

  
  //===--------------------------------------------------------------------===//
  //                    Integer Values
  //===--------------------------------------------------------------------===//
  
  /// \brief Make an APSInt of the appropriate width and signedness for the
  /// given \p Value and integer \p Type.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::MakeIntValue">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ASTContext.h", line = 2305,
   FQN="clang::ASTContext::MakeIntValue", NM="_ZNK5clang10ASTContext12MakeIntValueEyNS_8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZNK5clang10ASTContext12MakeIntValueEyNS_8QualTypeE")
  //</editor-fold>
  public APSInt MakeIntValue(long/*uint64_t*/ Value, QualType Type) /*const*/ {
    // If Type is a signed integer type larger than 64 bits, we need to be sure
    // to sign extend Res appropriately.
    APSInt Res/*J*/= new APSInt(64, !Type.$arrow().isSignedIntegerOrEnumerationType());
    Res.$assign(Value);
    /*uint*/int Width = getIntWidth(new QualType(Type));
    if (Width != Res.getBitWidth()) {
      return Res.extOrTrunc(Width);
    }
    return Res;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::isSentinelNullExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp", line = 2018,
   FQN="clang::ASTContext::isSentinelNullExpr", NM="_ZN5clang10ASTContext18isSentinelNullExprEPKNS_4ExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZN5clang10ASTContext18isSentinelNullExprEPKNS_4ExprE")
  //</editor-fold>
  public boolean isSentinelNullExpr(/*const*/ Expr /*P*/ E) {
    if (!(E != null)) {
      return false;
    }
    
    // nullptr_t is always treated as null.
    if (E.getType().$arrow().isNullPtrType()) {
      return true;
    }
    if (E.getType().$arrow().isAnyPointerType()
       && (E.IgnoreParenCasts$Const().isNullPointerConstant(/*Deref*/this, 
        Expr.NullPointerConstantValueDependence.NPC_ValueDependentIsNull).getValue() != 0)) {
      return true;
    }
    
    // Unfortunately, __null has type 'int'.
    if (isa_GNUNullExpr(E)) {
      return true;
    }
    
    return false;
  }

  
  /// \brief Get the implementation of the ObjCInterfaceDecl \p D, or NULL if
  /// none exists.
  
  /// \brief Get the implementation of ObjCInterfaceDecl,or NULL if none exists.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::getObjCImplementation">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp", line = 2037,
   FQN="clang::ASTContext::getObjCImplementation", NM="_ZN5clang10ASTContext21getObjCImplementationEPNS_17ObjCInterfaceDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZN5clang10ASTContext21getObjCImplementationEPNS_17ObjCInterfaceDeclE")
  //</editor-fold>
  public ObjCImplementationDecl /*P*/ getObjCImplementation(ObjCInterfaceDecl /*P*/ D) {
    DenseMapIterator<ObjCContainerDecl /*P*/ , ObjCImplDecl /*P*/ > I = ObjCImpls.find(D);
    if (I.$noteq(/*NO_ITER_COPY*/ObjCImpls.end())) {
      return cast_ObjCImplementationDecl(I.$arrow().second);
    }
    return null;
  }

  /// \brief Get the implementation of the ObjCCategoryDecl \p D, or NULL if
  /// none exists.
  /// \brief Get the implementation of ObjCCategoryDecl, or NULL if none exists.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::getObjCImplementation">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp", line = 2045,
   FQN="clang::ASTContext::getObjCImplementation", NM="_ZN5clang10ASTContext21getObjCImplementationEPNS_16ObjCCategoryDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZN5clang10ASTContext21getObjCImplementationEPNS_16ObjCCategoryDeclE")
  //</editor-fold>
  public ObjCCategoryImplDecl /*P*/ getObjCImplementation(ObjCCategoryDecl /*P*/ D) {
    DenseMapIterator<ObjCContainerDecl /*P*/ , ObjCImplDecl /*P*/ > I = ObjCImpls.find(D);
    if (I.$noteq(/*NO_ITER_COPY*/ObjCImpls.end())) {
      return cast_ObjCCategoryImplDecl(I.$arrow().second);
    }
    return null;
  }

  
  /// \brief Return true if there is at least one \@implementation in the TU.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::AnyObjCImplementation">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ASTContext.h", line = 2326,
   FQN="clang::ASTContext::AnyObjCImplementation", NM="_ZN5clang10ASTContext21AnyObjCImplementationEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZN5clang10ASTContext21AnyObjCImplementationEv")
  //</editor-fold>
  public boolean AnyObjCImplementation() {
    return !ObjCImpls.empty();
  }

  
  /// \brief Set the implementation of ObjCInterfaceDecl.
  
  /// \brief Set the implementation of ObjCInterfaceDecl.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::setObjCImplementation">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp", line = 2054,
   FQN="clang::ASTContext::setObjCImplementation", NM="_ZN5clang10ASTContext21setObjCImplementationEPNS_17ObjCInterfaceDeclEPNS_22ObjCImplementationDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZN5clang10ASTContext21setObjCImplementationEPNS_17ObjCInterfaceDeclEPNS_22ObjCImplementationDeclE")
  //</editor-fold>
  public void setObjCImplementation(ObjCInterfaceDecl /*P*/ IFaceD, 
                       ObjCImplementationDecl /*P*/ ImplD) {
    assert ((IFaceD != null) && (ImplD != null)) : "Passed null params";
    ObjCImpls.$set(IFaceD, ImplD);
  }

  /// \brief Set the implementation of ObjCCategoryDecl.
  /// \brief Set the implementation of ObjCCategoryDecl.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::setObjCImplementation">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp", line = 2060,
   FQN="clang::ASTContext::setObjCImplementation", NM="_ZN5clang10ASTContext21setObjCImplementationEPNS_16ObjCCategoryDeclEPNS_20ObjCCategoryImplDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZN5clang10ASTContext21setObjCImplementationEPNS_16ObjCCategoryDeclEPNS_20ObjCCategoryImplDeclE")
  //</editor-fold>
  public void setObjCImplementation(ObjCCategoryDecl /*P*/ CatD, 
                       ObjCCategoryImplDecl /*P*/ ImplD) {
    assert ((CatD != null) && (ImplD != null)) : "Passed null params";
    ObjCImpls.$set(CatD, ImplD);
  }

  
  /// \brief Get the duplicate declaration of a ObjCMethod in the same
  /// interface, or null if none exists.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::getObjCMethodRedeclaration">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp", line = 2066,
   FQN="clang::ASTContext::getObjCMethodRedeclaration", NM="_ZNK5clang10ASTContext26getObjCMethodRedeclarationEPKNS_14ObjCMethodDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZNK5clang10ASTContext26getObjCMethodRedeclarationEPKNS_14ObjCMethodDeclE")
  //</editor-fold>
  public /*const*/ ObjCMethodDecl /*P*/ getObjCMethodRedeclaration(/*const*/ ObjCMethodDecl /*P*/ MD) /*const*/ {
    return ObjCMethodRedecls.lookup(MD);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::setObjCMethodRedeclaration">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp", line = 2071,
   FQN="clang::ASTContext::setObjCMethodRedeclaration", NM="_ZN5clang10ASTContext26setObjCMethodRedeclarationEPKNS_14ObjCMethodDeclES3_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZN5clang10ASTContext26setObjCMethodRedeclarationEPKNS_14ObjCMethodDeclES3_")
  //</editor-fold>
  public void setObjCMethodRedeclaration(/*const*/ ObjCMethodDecl /*P*/ MD, 
                            /*const*/ ObjCMethodDecl /*P*/ Redecl) {
    assert (!(getObjCMethodRedeclaration(MD) != null)) : "MD already has a redeclaration";
    ObjCMethodRedecls.$set(MD, Redecl);
  }

  
  /// \brief Returns the Objective-C interface that \p ND belongs to if it is
  /// an Objective-C method/property/ivar etc. that is part of an interface,
  /// otherwise returns null.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::getObjContainingInterface">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp", line = 2077,
   FQN="clang::ASTContext::getObjContainingInterface", NM="_ZNK5clang10ASTContext25getObjContainingInterfaceEPKNS_9NamedDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZNK5clang10ASTContext25getObjContainingInterfaceEPKNS_9NamedDeclE")
  //</editor-fold>
  public /*const*/ ObjCInterfaceDecl /*P*/ getObjContainingInterface(/*const*/ NamedDecl /*P*/ ND) /*const*/ {
    {
      /*const*/ ObjCInterfaceDecl /*P*/ ID = dyn_cast_ObjCInterfaceDecl(ND.getDeclContext$Const());
      if ((ID != null)) {
        return ID;
      }
    }
    {
      /*const*/ ObjCCategoryDecl /*P*/ CD = dyn_cast_ObjCCategoryDecl(ND.getDeclContext$Const());
      if ((CD != null)) {
        return CD.getClassInterface$Const();
      }
    }
    {
      /*const*/ ObjCImplDecl /*P*/ IMD = dyn_cast_ObjCImplDecl(ND.getDeclContext$Const());
      if ((IMD != null)) {
        return IMD.getClassInterface$Const();
      }
    }
    
    return null;
  }

  
  /// \brief Set the copy inialization expression of a block var decl.
  
  /// \brief Set the copy inialization expression of a block var decl.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::setBlockVarCopyInits">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp", line = 2104,
   FQN="clang::ASTContext::setBlockVarCopyInits", NM="_ZN5clang10ASTContext20setBlockVarCopyInitsEPNS_7VarDeclEPNS_4ExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZN5clang10ASTContext20setBlockVarCopyInitsEPNS_7VarDeclEPNS_4ExprE")
  //</editor-fold>
  public void setBlockVarCopyInits(VarDecl /*P*/ VD, Expr /*P*/ Init) {
    assert ((VD != null) && (Init != null)) : "Passed null params";
    assert (VD.hasAttr(BlocksAttr.class)) : "setBlockVarCopyInits - not __block var";
    BlockVarCopyInits.$set(VD, Init);
  }

  /// \brief Get the copy initialization expression of the VarDecl \p VD, or
  /// NULL if none exists.
  
  /// \brief Get the copy initialization expression of VarDecl,or NULL if 
  /// none exists.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::getBlockVarCopyInits">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp", line = 2094,
   FQN="clang::ASTContext::getBlockVarCopyInits", NM="_ZN5clang10ASTContext20getBlockVarCopyInitsEPKNS_7VarDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZN5clang10ASTContext20getBlockVarCopyInitsEPKNS_7VarDeclE")
  //</editor-fold>
  public Expr /*P*/ getBlockVarCopyInits(/*const*/ VarDecl /*P*/ VD) {
    assert ((VD != null)) : "Passed null params";
    assert (VD.hasAttr(BlocksAttr.class)) : "getBlockVarCopyInits - not __block var";
    DenseMapIterator</*const*/ VarDecl /*P*/ , Expr /*P*/ > I = BlockVarCopyInits.find(VD);
    return (I.$noteq(/*NO_ITER_COPY*/BlockVarCopyInits.end())) ? cast_Expr(I.$arrow().second) : null;
  }

  
  /// \brief Allocate an uninitialized TypeSourceInfo.
  ///
  /// The caller should initialize the memory held by TypeSourceInfo using
  /// the TypeLoc wrappers.
  ///
  /// \param T the type that will be the basis for type source info. This type
  /// should refer to how the declarator was written in source code, not to
  /// what type semantic analysis resolved the declarator to.
  ///
  /// \param Size the size of the type info to create, or 0 if the size
  /// should be calculated based on the type.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::CreateTypeSourceInfo">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*java allocation*/,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp", line = 2111,
   FQN="clang::ASTContext::CreateTypeSourceInfo", NM="_ZNK5clang10ASTContext20CreateTypeSourceInfoENS_8QualTypeEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZNK5clang10ASTContext20CreateTypeSourceInfoENS_8QualTypeEj")
  //</editor-fold>
  public TypeSourceInfo /*P*/ CreateTypeSourceInfo(QualType T) /*const*/ {
    return CreateTypeSourceInfo(T, 
                      0);
  }
  public TypeSourceInfo /*P*/ CreateTypeSourceInfo(QualType T, 
                      /*uint*/int DataSize/*= 0*/) /*const*/ {
    if (!(DataSize != 0)) {
      DataSize = TypeLoc.getFullDataSizeForType(new QualType(T));
    } else {
      assert (DataSize == TypeLoc.getFullDataSizeForType(T)) : "incorrect data size provided to CreateTypeSourceInfo!";
    }
    
    if (false) {
      TypeSourceInfo /*P*/ TInfo = (TypeSourceInfo /*P*/ )BumpAlloc.Allocate($sizeof_TypeSourceInfo() + DataSize, 8);
      /*FIXME:NEW_EXPR[System]*/TInfo = /*new (TInfo)*/ new TypeSourceInfo(new QualType(T), null);
      return TInfo;
    } else {
      // allocate in the Object[] of ASTContext to allow TypeSourceInfo and associated TypeLoc to find each other
      // alignment 1 is OK?
      TypeSourceInfo /*P*/ TInfo = null;
      type$ptr /*P*/ TInfoMem = this.Allocate$JavaRef(/*$sizeof_TypeSourceInfo()*/1 + DataSize/*, 8*/);
      assert TInfoMem.$at(0) == null;      
      // IMPORTANT: we need to allocate all objects in advance, because we replaced real sizeof by count
      type$ptr<?> TypeLoc$Data = (type$ptr<?>)TInfoMem.$add(1);
      int TotalInited = TypeLoc.javaPrepareMemory(T, TypeLoc$Data);
      assert TotalInited == DataSize : "Must be equal " + TotalInited + " vs. " + DataSize;
      TInfoMem.$set(/*FIXME:NEW_EXPR[System]*/TInfo = /*new (TInfo)*/ new TypeSourceInfo(T, TypeLoc$Data));
      return TInfo;
    }
  }
  
  
  /// \brief Allocate a TypeSourceInfo where all locations have been
  /// initialized to a given location, which defaults to the empty
  /// location.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::getTrivialTypeSourceInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp", line = 2125,
   FQN="clang::ASTContext::getTrivialTypeSourceInfo", NM="_ZNK5clang10ASTContext24getTrivialTypeSourceInfoENS_8QualTypeENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZNK5clang10ASTContext24getTrivialTypeSourceInfoENS_8QualTypeENS_14SourceLocationE")
  //</editor-fold>
  public TypeSourceInfo /*P*/ getTrivialTypeSourceInfo(QualType T) /*const*/ {
    return getTrivialTypeSourceInfo(T, 
                          new SourceLocation());
  }
  public TypeSourceInfo /*P*/ getTrivialTypeSourceInfo(QualType T, 
                          SourceLocation L/*= SourceLocation()*/) /*const*/ {
    TypeSourceInfo /*P*/ DI = CreateTypeSourceInfo(new QualType(T));
    DI.getTypeLoc().initialize(((/*const_cast*/ASTContext /*&*/ )(/*Deref*/this)), new SourceLocation(L));
    return DI;
  }

  
  /// \brief Add a deallocation callback that will be invoked when the 
  /// ASTContext is destroyed.
  ///
  /// \param Callback A callback function that will be invoked on destruction.
  ///
  /// \param Data Pointer data that will be provided to the callback function
  /// when it is called.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::AddDeallocation">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp", line = 812,
   FQN="clang::ASTContext::AddDeallocation", NM="_ZN5clang10ASTContext15AddDeallocationEPFvPvES1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZN5clang10ASTContext15AddDeallocationEPFvPvES1_")
  //</editor-fold>
  public void AddDeallocation(VoidPtr2Void Callback, Object/*void P*/ Data) {
    Deallocations.push_back(/*{ */new std.pairPtrPtr<VoidPtr2Void, Object/*void P*/ >(JD$T$RR_T1$RR.INSTANCE, Callback, Data)/* }*/);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::GetGVALinkageForFunction">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp", line = 8475,
   FQN="clang::ASTContext::GetGVALinkageForFunction", NM="_ZNK5clang10ASTContext24GetGVALinkageForFunctionEPKNS_12FunctionDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZNK5clang10ASTContext24GetGVALinkageForFunctionEPKNS_12FunctionDeclE")
  //</editor-fold>
  public GVALinkage GetGVALinkageForFunction(/*const*/ FunctionDecl /*P*/ FD) /*const*/ {
    return adjustGVALinkageForAttributes(/*Deref*/this, basicGVALinkageForFunction(/*Deref*/this, FD), FD);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::GetGVALinkageForVariable">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp", line = 8549,
   FQN="clang::ASTContext::GetGVALinkageForVariable", NM="_ZN5clang10ASTContext24GetGVALinkageForVariableEPKNS_7VarDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZN5clang10ASTContext24GetGVALinkageForVariableEPKNS_7VarDeclE")
  //</editor-fold>
  public GVALinkage GetGVALinkageForVariable(/*const*/ VarDecl /*P*/ VD) {
    return adjustGVALinkageForAttributes(/*Deref*/this, basicGVALinkageForVariable(/*Deref*/this, VD), VD);
  }

  
  /// \brief Determines if the decl can be CodeGen'ed or deserialized from PCH
  /// lazily, only when used; this is only relevant for function or file scoped
  /// var definitions.
  ///
  /// \returns true if the function/var must be CodeGen'ed/deserialized even if
  /// it is not used.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::DeclMustBeEmitted">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp", line = 8554,
   FQN="clang::ASTContext::DeclMustBeEmitted", NM="_ZN5clang10ASTContext17DeclMustBeEmittedEPKNS_4DeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZN5clang10ASTContext17DeclMustBeEmittedEPKNS_4DeclE")
  //</editor-fold>
  public boolean DeclMustBeEmitted(/*const*/ Decl /*P*/ D) {
    {
      /*const*/ VarDecl /*P*/ VD = dyn_cast_VarDecl(D);
      if ((VD != null)) {
        if (!VD.isFileVarDecl()) {
          return false;
        }
        // Global named register variables (GNU extension) are never emitted.
        if (VD.getStorageClass() == StorageClass.SC_Register) {
          return false;
        }
        if ((VD.getDescribedVarTemplate() != null)
           || isa_VarTemplatePartialSpecializationDecl(VD)) {
          return false;
        }
      } else {
        /*const*/ FunctionDecl /*P*/ FD = dyn_cast_FunctionDecl(D);
        if ((FD != null)) {
          // We never need to emit an uninstantiated function template.
          if (FD.getTemplatedKind() == FunctionDecl.TemplatedKind.TK_FunctionTemplate) {
            return false;
          }
        } else if (isa_PragmaCommentDecl(D)) {
          return true;
        } else if (isa_OMPThreadPrivateDecl(D)
           || D.hasAttr(OMPDeclareTargetDeclAttr.class)) {
          return true;
        } else if (isa_PragmaDetectMismatchDecl(D)) {
          return true;
        } else if (isa_OMPThreadPrivateDecl(D)) {
          return !D.getDeclContext$Const().isDependentContext();
        } else if (isa_OMPDeclareReductionDecl(D)) {
          return !D.getDeclContext$Const().isDependentContext();
        } else {
          return false;
        }
      }
    }
    
    // If this is a member of a class template, we do not need to emit it.
    if (D.getDeclContext$Const().isDependentContext()) {
      return false;
    }
    
    // Weak references don't produce any output by themselves.
    if (D.hasAttr(WeakRefAttr.class)) {
      return false;
    }
    
    // Aliases and used decls are required.
    if (D.hasAttr(AliasAttr.class) || D.hasAttr(UsedAttr.class)) {
      return true;
    }
    {
      
      /*const*/ FunctionDecl /*P*/ FD = dyn_cast_FunctionDecl(D);
      if ((FD != null)) {
        // Forward declarations aren't required.
        if (!FD.doesThisDeclarationHaveABody()) {
          return FD.doesDeclarationForceExternallyVisibleDefinition();
        }
        
        // Constructors and destructors are required.
        if (FD.hasAttr(ConstructorAttr.class) || FD.hasAttr(DestructorAttr.class)) {
          return true;
        }
        
        // The key function for a class is required.  This rule only comes
        // into play when inline functions can be key functions, though.
        if (getTargetInfo().getCXXABI().canKeyFunctionBeInline()) {
          {
            /*const*/ CXXMethodDecl /*P*/ MD = dyn_cast_CXXMethodDecl(FD);
            if ((MD != null)) {
              /*const*/ CXXRecordDecl /*P*/ RD = MD.getParent$Const();
              if (MD.isOutOfLine() && RD.isDynamicClass()) {
                /*const*/ CXXMethodDecl /*P*/ KeyFunc = getCurrentKeyFunction(RD);
                if ((KeyFunc != null) && KeyFunc.getCanonicalDecl$Const() == MD.getCanonicalDecl$Const()) {
                  return true;
                }
              }
            }
          }
        }
        
        GVALinkage Linkage = GetGVALinkageForFunction(FD);
        
        // static, static inline, always_inline, and extern inline functions can
        // always be deferred.  Normal inline functions can be deferred in C99/C++.
        // Implicit template instantiations can also be deferred in C++.
        if (Linkage == GVALinkage.GVA_Internal || Linkage == GVALinkage.GVA_AvailableExternally
           || Linkage == GVALinkage.GVA_DiscardableODR) {
          return false;
        }
        return true;
      }
    }
    
    /*const*/ VarDecl /*P*/ VD = cast_VarDecl(D);
    assert (VD.isFileVarDecl()) : "Expected file scoped var";
    if (VD.isThisDeclarationADefinition() == VarDecl.DefinitionKind.DeclarationOnly
       && !isMSStaticDataMemberInlineDefinition(VD)) {
      return false;
    }
    
    // Variables that can be needed in other TUs are required.
    GVALinkage L = GetGVALinkageForVariable(VD);
    if (L != GVALinkage.GVA_Internal && L != GVALinkage.GVA_AvailableExternally
       && L != GVALinkage.GVA_DiscardableODR) {
      return true;
    }
    
    // Variables that have destruction with side-effects are required.
    if ((VD.getType().isDestructedType().getValue() != 0)) {
      return true;
    }
    
    // Variables that have initialization with side-effects are required.
    if ((VD.getInit$Const() != null) && VD.getInit$Const().HasSideEffects(/*Deref*/this)
       && !(VD.evaluateValue() != null)) {
      return true;
    }
    
    return false;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::getCopyConstructorForExceptionObject">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp", line = 8798,
   FQN="clang::ASTContext::getCopyConstructorForExceptionObject", NM="_ZN5clang10ASTContext36getCopyConstructorForExceptionObjectEPNS_13CXXRecordDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZN5clang10ASTContext36getCopyConstructorForExceptionObjectEPNS_13CXXRecordDeclE")
  //</editor-fold>
  public /*const*/ CXXConstructorDecl /*P*/ getCopyConstructorForExceptionObject(CXXRecordDecl /*P*/ RD) {
    return ABI.$arrow().getCopyConstructorForExceptionObject(cast_CXXRecordDecl(RD.getFirstDecl()));
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::addCopyConstructorForExceptionObject">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp", line = 8804,
   FQN="clang::ASTContext::addCopyConstructorForExceptionObject", NM="_ZN5clang10ASTContext36addCopyConstructorForExceptionObjectEPNS_13CXXRecordDeclEPNS_18CXXConstructorDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZN5clang10ASTContext36addCopyConstructorForExceptionObjectEPNS_13CXXRecordDeclEPNS_18CXXConstructorDeclE")
  //</editor-fold>
  public void addCopyConstructorForExceptionObject(CXXRecordDecl /*P*/ RD, 
                                      CXXConstructorDecl /*P*/ CD) {
    ABI.$arrow().addCopyConstructorForExceptionObject(cast_CXXRecordDecl(RD.getFirstDecl()), 
        cast_CXXConstructorDecl(CD.getFirstDecl()));
    /*JAVA:return*/return;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::addDefaultArgExprForConstructor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp", line = 8811,
   FQN="clang::ASTContext::addDefaultArgExprForConstructor", NM="_ZN5clang10ASTContext31addDefaultArgExprForConstructorEPKNS_18CXXConstructorDeclEjPNS_4ExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZN5clang10ASTContext31addDefaultArgExprForConstructorEPKNS_18CXXConstructorDeclEjPNS_4ExprE")
  //</editor-fold>
  public void addDefaultArgExprForConstructor(/*const*/ CXXConstructorDecl /*P*/ CD, 
                                 /*uint*/int ParmIdx, Expr /*P*/ DAE) {
    ABI.$arrow().addDefaultArgExprForConstructor(cast_CXXConstructorDecl(CD.getFirstDecl$Const()), ParmIdx, DAE);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::getDefaultArgExprForConstructor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp", line = 8817,
   FQN="clang::ASTContext::getDefaultArgExprForConstructor", NM="_ZN5clang10ASTContext31getDefaultArgExprForConstructorEPKNS_18CXXConstructorDeclEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZN5clang10ASTContext31getDefaultArgExprForConstructorEPKNS_18CXXConstructorDeclEj")
  //</editor-fold>
  public Expr /*P*/ getDefaultArgExprForConstructor(/*const*/ CXXConstructorDecl /*P*/ CD, 
                                 /*uint*/int ParmIdx) {
    return ABI.$arrow().getDefaultArgExprForConstructor(cast_CXXConstructorDecl(CD.getFirstDecl$Const()), ParmIdx);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::addTypedefNameForUnnamedTagDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp", line = 8823,
   FQN="clang::ASTContext::addTypedefNameForUnnamedTagDecl", NM="_ZN5clang10ASTContext31addTypedefNameForUnnamedTagDeclEPNS_7TagDeclEPNS_15TypedefNameDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZN5clang10ASTContext31addTypedefNameForUnnamedTagDeclEPNS_7TagDeclEPNS_15TypedefNameDeclE")
  //</editor-fold>
  public void addTypedefNameForUnnamedTagDecl(TagDecl /*P*/ TD, 
                                 TypedefNameDecl /*P*/ DD) {
    ABI.$arrow().addTypedefNameForUnnamedTagDecl(TD, DD);
    /*JAVA:return*/return;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::getTypedefNameForUnnamedTagDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp", line = 8828,
   FQN="clang::ASTContext::getTypedefNameForUnnamedTagDecl", NM="_ZN5clang10ASTContext31getTypedefNameForUnnamedTagDeclEPKNS_7TagDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZN5clang10ASTContext31getTypedefNameForUnnamedTagDeclEPKNS_7TagDeclE")
  //</editor-fold>
  public TypedefNameDecl /*P*/ getTypedefNameForUnnamedTagDecl(/*const*/ TagDecl /*P*/ TD) {
    return ABI.$arrow().getTypedefNameForUnnamedTagDecl(TD);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::addDeclaratorForUnnamedTagDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp", line = 8833,
   FQN="clang::ASTContext::addDeclaratorForUnnamedTagDecl", NM="_ZN5clang10ASTContext30addDeclaratorForUnnamedTagDeclEPNS_7TagDeclEPNS_14DeclaratorDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZN5clang10ASTContext30addDeclaratorForUnnamedTagDeclEPNS_7TagDeclEPNS_14DeclaratorDeclE")
  //</editor-fold>
  public void addDeclaratorForUnnamedTagDecl(TagDecl /*P*/ TD, 
                                DeclaratorDecl /*P*/ DD) {
    ABI.$arrow().addDeclaratorForUnnamedTagDecl(TD, DD);
    /*JAVA:return*/return;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::getDeclaratorForUnnamedTagDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp", line = 8838,
   FQN="clang::ASTContext::getDeclaratorForUnnamedTagDecl", NM="_ZN5clang10ASTContext30getDeclaratorForUnnamedTagDeclEPKNS_7TagDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZN5clang10ASTContext30getDeclaratorForUnnamedTagDeclEPKNS_7TagDeclE")
  //</editor-fold>
  public DeclaratorDecl /*P*/ getDeclaratorForUnnamedTagDecl(/*const*/ TagDecl /*P*/ TD) {
    return ABI.$arrow().getDeclaratorForUnnamedTagDecl(TD);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::setManglingNumber">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp", line = 8765,
   FQN="clang::ASTContext::setManglingNumber", NM="_ZN5clang10ASTContext17setManglingNumberEPKNS_9NamedDeclEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZN5clang10ASTContext17setManglingNumberEPKNS_9NamedDeclEj")
  //</editor-fold>
  public void setManglingNumber(/*const*/ NamedDecl /*P*/ ND, /*uint*/int Number) {
    if ($greater_uint(Number, 1)) {
      MangleNumbers.$set(ND, Number);
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::getManglingNumber">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp", line = 8770,
   FQN="clang::ASTContext::getManglingNumber", NM="_ZNK5clang10ASTContext17getManglingNumberEPKNS_9NamedDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZNK5clang10ASTContext17getManglingNumberEPKNS_9NamedDeclE")
  //</editor-fold>
  public /*uint*/int getManglingNumber(/*const*/ NamedDecl /*P*/ ND) /*const*/ {
    std.vector.iterator</*const*/std.pairPtrUInt</*const*/ NamedDecl /*P*/ >> I = MangleNumbers.find$Const(ND);
    return $noteq___normal_iterator$C(I, MangleNumbers.end$Const()) ? I.$arrow().second : 1;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::setStaticLocalNumber">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp", line = 8775,
   FQN="clang::ASTContext::setStaticLocalNumber", NM="_ZN5clang10ASTContext20setStaticLocalNumberEPKNS_7VarDeclEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZN5clang10ASTContext20setStaticLocalNumberEPKNS_7VarDeclEj")
  //</editor-fold>
  public void setStaticLocalNumber(/*const*/ VarDecl /*P*/ VD, /*uint*/int Number) {
    if ($greater_uint(Number, 1)) {
      StaticLocalNumbers.$set(VD, Number);
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::getStaticLocalNumber">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp", line = 8780,
   FQN="clang::ASTContext::getStaticLocalNumber", NM="_ZNK5clang10ASTContext20getStaticLocalNumberEPKNS_7VarDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZNK5clang10ASTContext20getStaticLocalNumberEPKNS_7VarDeclE")
  //</editor-fold>
  public /*uint*/int getStaticLocalNumber(/*const*/ VarDecl /*P*/ VD) /*const*/ {
    std.vector.iterator</*const*/std.pairPtrUInt</*const*/ VarDecl /*P*/ >> I = StaticLocalNumbers.find$Const(VD);
    return $noteq___normal_iterator$C(I, StaticLocalNumbers.end$Const()) ? I.$arrow().second : 1;
  }

  
  /// \brief Retrieve the context for computing mangling numbers in the given
  /// DeclContext.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::getManglingNumberContext">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp", line = 8785,
   FQN="clang::ASTContext::getManglingNumberContext", NM="_ZN5clang10ASTContext24getManglingNumberContextEPKNS_11DeclContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZN5clang10ASTContext24getManglingNumberContextEPKNS_11DeclContextE")
  //</editor-fold>
  public MangleNumberingContext /*&*/ getManglingNumberContext(/*const*/ DeclContext /*P*/ DC) {
    assert Native.$bool(LangOpts.CPlusPlus); // We don't need mangling numbers for plain C.
    final type$ref<MangleNumberingContext /*P*/ /*&*/> MCtx = MangleNumberingContexts.ref$at(DC);
    if (!(MCtx.$deref() != null)) {
      MCtx.$set(createMangleNumberingContext());
    }
    return $Deref(MCtx.$deref());
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::createMangleNumberingContext">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp", line = 8794,
   FQN="clang::ASTContext::createMangleNumberingContext", NM="_ZNK5clang10ASTContext28createMangleNumberingContextEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZNK5clang10ASTContext28createMangleNumberingContextEv")
  //</editor-fold>
  public MangleNumberingContext /*P*/ createMangleNumberingContext() /*const*/ {
    return ABI.$arrow().createMangleNumberingContext();
  }

  
  /// \brief Used by ParmVarDecl to store on the side the
  /// index of the parameter when it exceeds the size of the normal bitfield.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::setParameterIndex">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp", line = 8842,
   FQN="clang::ASTContext::setParameterIndex", NM="_ZN5clang10ASTContext17setParameterIndexEPKNS_11ParmVarDeclEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZN5clang10ASTContext17setParameterIndexEPKNS_11ParmVarDeclEj")
  //</editor-fold>
  public void setParameterIndex(/*const*/ ParmVarDecl /*P*/ D, /*uint*/int index) {
    ParamIndices.$set(D, index);
  }

  
  /// \brief Used by ParmVarDecl to retrieve on the side the
  /// index of the parameter when it exceeds the size of the normal bitfield.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::getParameterIndex">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp", line = 8846,
   FQN="clang::ASTContext::getParameterIndex", NM="_ZNK5clang10ASTContext17getParameterIndexEPKNS_11ParmVarDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZNK5clang10ASTContext17getParameterIndexEPKNS_11ParmVarDeclE")
  //</editor-fold>
  public /*uint*/int getParameterIndex(/*const*/ ParmVarDecl /*P*/ D) /*const*/ {
    DenseMapIteratorTypeUInt</*const*/ VarDecl /*P*/ /*P*/> I = ParamIndices.find$Const(D);
    assert (I.$noteq(ParamIndices.end$Const())) : "ParmIndices lacks entry set by ParmVarDecl";
    return I.$arrow().second;
  }

  
  /// \brief Get the storage for the constant value of a materialized temporary
  /// of static storage duration.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::getMaterializedTemporaryValue">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp", line = 8853,
   FQN="clang::ASTContext::getMaterializedTemporaryValue", NM="_ZN5clang10ASTContext29getMaterializedTemporaryValueEPKNS_24MaterializeTemporaryExprEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZN5clang10ASTContext29getMaterializedTemporaryValueEPKNS_24MaterializeTemporaryExprEb")
  //</editor-fold>
  public APValue /*P*/ getMaterializedTemporaryValue(/*const*/ MaterializeTemporaryExpr /*P*/ E, 
                               boolean MayCreate) {
    assert ((E != null) && E.getStorageDuration() == StorageDuration.SD_Static) : "don't need to cache the computed value for this temporary";
    if (MayCreate) {
      final type$ref<APValue /*P*/ /*&*/> MTVI = MaterializedTemporaryValues.ref$at(E);
      if (!(MTVI.$deref() != null)) {
        MTVI.$set(/*NEW_EXPR [operator new] NM=_ZnwjRKN5clang10ASTContextEj*/
        /*new (*this)*/ $new_uint_ASTContext$C_uint(/*Deref*/this, (type$ptr<?> New$Mem)->{
            return new APValue();
         }));
      }
      return MTVI.$deref();
    }
    
    return MaterializedTemporaryValues.lookup(E);
  }

  
  //===--------------------------------------------------------------------===//
  //                    Statistics
  //===--------------------------------------------------------------------===//
  
  /// \brief The number of implicitly-declared default constructors.
  public static /*uint*/int NumImplicitDefaultConstructors;
  
  /// \brief The number of implicitly-declared default constructors for 
  /// which declarations were built.
  public static /*uint*/int NumImplicitDefaultConstructorsDeclared;
  
  /// \brief The number of implicitly-declared copy constructors.
  public static /*uint*/int NumImplicitCopyConstructors;
  
  /// \brief The number of implicitly-declared copy constructors for 
  /// which declarations were built.
  public static /*uint*/int NumImplicitCopyConstructorsDeclared;
  
  /// \brief The number of implicitly-declared move constructors.
  public static /*uint*/int NumImplicitMoveConstructors;
  
  /// \brief The number of implicitly-declared move constructors for
  /// which declarations were built.
  public static /*uint*/int NumImplicitMoveConstructorsDeclared;
  
  /// \brief The number of implicitly-declared copy assignment operators.
  public static /*uint*/int NumImplicitCopyAssignmentOperators;
  
  /// \brief The number of implicitly-declared copy assignment operators for 
  /// which declarations were built.
  public static /*uint*/int NumImplicitCopyAssignmentOperatorsDeclared;
  
  /// \brief The number of implicitly-declared move assignment operators.
  public static /*uint*/int NumImplicitMoveAssignmentOperators;
  
  /// \brief The number of implicitly-declared move assignment operators for 
  /// which declarations were built.
  public static /*uint*/int NumImplicitMoveAssignmentOperatorsDeclared;
  
  /// \brief The number of implicitly-declared destructors.
  public static /*uint*/int NumImplicitDestructors;
  
  /// \brief The number of implicitly-declared destructors for which 
  /// declarations were built.
  public static /*uint*/int NumImplicitDestructorsDeclared;
/*private:*/
  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::ASTContext">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ASTContext.h", line = 2488,
   FQN="clang::ASTContext::ASTContext", NM="_ZN5clang10ASTContextC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZN5clang10ASTContextC1ERKS0_")
  //</editor-fold>
  private ASTContext(final /*const*/ ASTContext /*&*/ $Prm0) { throw new UnsupportedOperationException("Deleted");}

  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ASTContext.h", line = 2489,
   FQN="clang::ASTContext::operator=", NM="_ZN5clang10ASTContextaSERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZN5clang10ASTContextaSERKS0_")
  //</editor-fold>
  private void $assign(final /*const*/ ASTContext /*&*/ $Prm0) { throw new UnsupportedOperationException("Deleted");}

/*public:*/
  /// \brief Initialize built-in types.
  ///
  /// This routine may only be invoked once for a given ASTContext object.
  /// It is normally invoked after ASTContext construction.
  ///
  /// \param Target The target
  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::InitBuiltinTypes">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp", line = 982,
   FQN="clang::ASTContext::InitBuiltinTypes", NM="_ZN5clang10ASTContext16InitBuiltinTypesERKNS_10TargetInfoEPS2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZN5clang10ASTContext16InitBuiltinTypesERKNS_10TargetInfoEPS2_")
  //</editor-fold>
  public void InitBuiltinTypes(final /*const*/ TargetInfo /*&*/ Target) {
    InitBuiltinTypes(Target, 
                  (/*const*/ TargetInfo /*P*/ )null);
  }
  public void InitBuiltinTypes(final /*const*/ TargetInfo /*&*/ Target, 
                  /*const*/ TargetInfo /*P*/ AuxTarget/*= null*/) {
    assert ((!(this.Target != null) || this.Target == $AddrOf(Target))) : "Incorrect target reinitialization";
    assert (VoidTy.isNull()) : "Context reinitialized?";
    
    this.Target = $AddrOf(Target);
    this.AuxTarget = AuxTarget;
    
    ABI.reset(createCXXABI(Target));
    AddrSpaceMap = $tryClone(getAddressSpaceMap(Target, LangOpts));
    AddrSpaceMapMangling = isAddrSpaceMapManglingEnabled(Target, LangOpts);
    
    // C99 6.2.5p19.
    InitBuiltinType(VoidTy, BuiltinType.Kind.Void);
    
    // C99 6.2.5p2.
    InitBuiltinType(BoolTy, BuiltinType.Kind.Bool);
    // C99 6.2.5p3.
    if (LangOpts.CharIsSigned) {
      InitBuiltinType(CharTy, BuiltinType.Kind.Char_S);
    } else {
      InitBuiltinType(CharTy, BuiltinType.Kind.Char_U);
    }
    // C99 6.2.5p4.
    InitBuiltinType(SignedCharTy, BuiltinType.Kind.SChar);
    InitBuiltinType(ShortTy, BuiltinType.Kind.Short);
    InitBuiltinType(IntTy, BuiltinType.Kind.Int);
    InitBuiltinType(LongTy, BuiltinType.Kind.Long);
    InitBuiltinType(LongLongTy, BuiltinType.Kind.LongLong);
    
    // C99 6.2.5p6.
    InitBuiltinType(UnsignedCharTy, BuiltinType.Kind.UChar);
    InitBuiltinType(UnsignedShortTy, BuiltinType.Kind.UShort);
    InitBuiltinType(UnsignedIntTy, BuiltinType.Kind.UInt);
    InitBuiltinType(UnsignedLongTy, BuiltinType.Kind.ULong);
    InitBuiltinType(UnsignedLongLongTy, BuiltinType.Kind.ULongLong);
    
    // C99 6.2.5p10.
    InitBuiltinType(FloatTy, BuiltinType.Kind.Float);
    InitBuiltinType(DoubleTy, BuiltinType.Kind.Double);
    InitBuiltinType(LongDoubleTy, BuiltinType.Kind.LongDouble);
    
    // GNU extension, __float128 for IEEE quadruple precision
    InitBuiltinType(Float128Ty, BuiltinType.Kind.Float128);
    
    // GNU extension, 128-bit integers.
    InitBuiltinType(Int128Ty, BuiltinType.Kind.Int128);
    InitBuiltinType(UnsignedInt128Ty, BuiltinType.Kind.UInt128);
    
    // C++ 3.9.1p5
    if (TargetInfo.isTypeSigned(Target.getWCharType())) {
      InitBuiltinType(WCharTy, BuiltinType.Kind.WChar_S);
    } else { // -fshort-wchar makes wchar_t be unsigned.
      InitBuiltinType(WCharTy, BuiltinType.Kind.WChar_U);
    }
    if (LangOpts.CPlusPlus && LangOpts.WChar) {
      WideCharTy.$assign(WCharTy);
    } else {
      // C99 (or C++ using -fno-wchar).
      WideCharTy.$assignMove(getFromTargetType(Target.getWCharType().getValue()));
    }
    
    WIntTy.$assignMove(getFromTargetType(Target.getWIntType().getValue()));
    if (LangOpts.CPlusPlus) { // C++0x 3.9.1p5, extension for C++
      InitBuiltinType(Char16Ty, BuiltinType.Kind.Char16);
    } else { // C99
      Char16Ty.$assignMove(getFromTargetType(Target.getChar16Type().getValue()));
    }
    if (LangOpts.CPlusPlus) { // C++0x 3.9.1p5, extension for C++
      InitBuiltinType(Char32Ty, BuiltinType.Kind.Char32);
    } else { // C99
      Char32Ty.$assignMove(getFromTargetType(Target.getChar32Type().getValue()));
    }
    
    // Placeholder type for type-dependent expressions whose type is
    // completely unknown. No code should ever check a type against
    // DependentTy and users should never see it; however, it is here to
    // help diagnose failures to properly check for type-dependent
    // expressions.
    InitBuiltinType(DependentTy, BuiltinType.Kind.Dependent);
    
    // Placeholder type for functions.
    InitBuiltinType(OverloadTy, BuiltinType.Kind.Overload);
    
    // Placeholder type for bound members.
    InitBuiltinType(BoundMemberTy, BuiltinType.Kind.BoundMember);
    
    // Placeholder type for pseudo-objects.
    InitBuiltinType(PseudoObjectTy, BuiltinType.Kind.PseudoObject);
    
    // "any" type; useful for debugger-like clients.
    InitBuiltinType(UnknownAnyTy, BuiltinType.Kind.UnknownAny);
    
    // Placeholder type for unbridged ARC casts.
    InitBuiltinType(ARCUnbridgedCastTy, BuiltinType.Kind.ARCUnbridgedCast);
    
    // Placeholder type for builtin functions.
    InitBuiltinType(BuiltinFnTy, BuiltinType.Kind.BuiltinFn);
    
    // Placeholder type for OMP array sections.
    if ((LangOpts.OpenMP != 0)) {
      InitBuiltinType(OMPArraySectionTy, BuiltinType.Kind.OMPArraySection);
    }
    
    // C99 6.2.5p11.
    FloatComplexTy.$assignMove(getComplexType(new CanQual<Type>(FloatTy)));
    DoubleComplexTy.$assignMove(getComplexType(new CanQual<Type>(DoubleTy)));
    LongDoubleComplexTy.$assignMove(getComplexType(new CanQual<Type>(LongDoubleTy)));
    Float128ComplexTy.$assignMove(getComplexType(new CanQual<Type>(Float128Ty)));
    
    // Builtin types for 'id', 'Class', and 'SEL'.
    InitBuiltinType(ObjCBuiltinIdTy, BuiltinType.Kind.ObjCId);
    InitBuiltinType(ObjCBuiltinClassTy, BuiltinType.Kind.ObjCClass);
    InitBuiltinType(ObjCBuiltinSelTy, BuiltinType.Kind.ObjCSel);
    if (LangOpts.OpenCL) {
      InitBuiltinType(OCLImage1dROTy, BuiltinType.Kind.OCLImage1dRO);
      InitBuiltinType(OCLImage1dArrayROTy, BuiltinType.Kind.OCLImage1dArrayRO);
      InitBuiltinType(OCLImage1dBufferROTy, BuiltinType.Kind.OCLImage1dBufferRO);
      InitBuiltinType(OCLImage2dROTy, BuiltinType.Kind.OCLImage2dRO);
      InitBuiltinType(OCLImage2dArrayROTy, BuiltinType.Kind.OCLImage2dArrayRO);
      InitBuiltinType(OCLImage2dDepthROTy, BuiltinType.Kind.OCLImage2dDepthRO);
      InitBuiltinType(OCLImage2dArrayDepthROTy, BuiltinType.Kind.OCLImage2dArrayDepthRO);
      InitBuiltinType(OCLImage2dMSAAROTy, BuiltinType.Kind.OCLImage2dMSAARO);
      InitBuiltinType(OCLImage2dArrayMSAAROTy, BuiltinType.Kind.OCLImage2dArrayMSAARO);
      InitBuiltinType(OCLImage2dMSAADepthROTy, BuiltinType.Kind.OCLImage2dMSAADepthRO);
      InitBuiltinType(OCLImage2dArrayMSAADepthROTy, BuiltinType.Kind.OCLImage2dArrayMSAADepthRO);
      InitBuiltinType(OCLImage3dROTy, BuiltinType.Kind.OCLImage3dRO);
      InitBuiltinType(OCLImage1dWOTy, BuiltinType.Kind.OCLImage1dWO);
      InitBuiltinType(OCLImage1dArrayWOTy, BuiltinType.Kind.OCLImage1dArrayWO);
      InitBuiltinType(OCLImage1dBufferWOTy, BuiltinType.Kind.OCLImage1dBufferWO);
      InitBuiltinType(OCLImage2dWOTy, BuiltinType.Kind.OCLImage2dWO);
      InitBuiltinType(OCLImage2dArrayWOTy, BuiltinType.Kind.OCLImage2dArrayWO);
      InitBuiltinType(OCLImage2dDepthWOTy, BuiltinType.Kind.OCLImage2dDepthWO);
      InitBuiltinType(OCLImage2dArrayDepthWOTy, BuiltinType.Kind.OCLImage2dArrayDepthWO);
      InitBuiltinType(OCLImage2dMSAAWOTy, BuiltinType.Kind.OCLImage2dMSAAWO);
      InitBuiltinType(OCLImage2dArrayMSAAWOTy, BuiltinType.Kind.OCLImage2dArrayMSAAWO);
      InitBuiltinType(OCLImage2dMSAADepthWOTy, BuiltinType.Kind.OCLImage2dMSAADepthWO);
      InitBuiltinType(OCLImage2dArrayMSAADepthWOTy, BuiltinType.Kind.OCLImage2dArrayMSAADepthWO);
      InitBuiltinType(OCLImage3dWOTy, BuiltinType.Kind.OCLImage3dWO);
      InitBuiltinType(OCLImage1dRWTy, BuiltinType.Kind.OCLImage1dRW);
      InitBuiltinType(OCLImage1dArrayRWTy, BuiltinType.Kind.OCLImage1dArrayRW);
      InitBuiltinType(OCLImage1dBufferRWTy, BuiltinType.Kind.OCLImage1dBufferRW);
      InitBuiltinType(OCLImage2dRWTy, BuiltinType.Kind.OCLImage2dRW);
      InitBuiltinType(OCLImage2dArrayRWTy, BuiltinType.Kind.OCLImage2dArrayRW);
      InitBuiltinType(OCLImage2dDepthRWTy, BuiltinType.Kind.OCLImage2dDepthRW);
      InitBuiltinType(OCLImage2dArrayDepthRWTy, BuiltinType.Kind.OCLImage2dArrayDepthRW);
      InitBuiltinType(OCLImage2dMSAARWTy, BuiltinType.Kind.OCLImage2dMSAARW);
      InitBuiltinType(OCLImage2dArrayMSAARWTy, BuiltinType.Kind.OCLImage2dArrayMSAARW);
      InitBuiltinType(OCLImage2dMSAADepthRWTy, BuiltinType.Kind.OCLImage2dMSAADepthRW);
      InitBuiltinType(OCLImage2dArrayMSAADepthRWTy, BuiltinType.Kind.OCLImage2dArrayMSAADepthRW);
      InitBuiltinType(OCLImage3dRWTy, BuiltinType.Kind.OCLImage3dRW);
      
      InitBuiltinType(OCLSamplerTy, BuiltinType.Kind.OCLSampler);
      InitBuiltinType(OCLEventTy, BuiltinType.Kind.OCLEvent);
      InitBuiltinType(OCLClkEventTy, BuiltinType.Kind.OCLClkEvent);
      InitBuiltinType(OCLQueueTy, BuiltinType.Kind.OCLQueue);
      InitBuiltinType(OCLNDRangeTy, BuiltinType.Kind.OCLNDRange);
      InitBuiltinType(OCLReserveIDTy, BuiltinType.Kind.OCLReserveID);
    }
    
    // Builtin type for __objc_yes and __objc_no
    ObjCBuiltinBoolTy.$assign((Target.useSignedCharForObjCBool() ? SignedCharTy : BoolTy));
    
    ObjCConstantStringType.$assignMove(new QualType());
    
    ObjCSuperType.$assignMove(new QualType());
    
    // void * type
    VoidPtrTy.$assignMove(getPointerType(new CanQual<Type>(VoidTy)));
    
    // nullptr type (C++0x 2.14.7)
    InitBuiltinType(NullPtrTy, BuiltinType.Kind.NullPtr);
    
    // half type (OpenCL 6.1.1.1) / ARM NEON __fp16
    InitBuiltinType(HalfTy, BuiltinType.Kind.Half);
    
    // Builtin type used to help define __builtin_va_list.
    VaListTagDecl = null;
  }

/*private:*/
  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::InitBuiltinType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp", line = 976,
   FQN="clang::ASTContext::InitBuiltinType", NM="_ZN5clang10ASTContext15InitBuiltinTypeERNS_7CanQualINS_4TypeEEENS_11BuiltinType4KindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZN5clang10ASTContext15InitBuiltinTypeERNS_7CanQualINS_4TypeEEENS_11BuiltinType4KindE")
  //</editor-fold>
  private void InitBuiltinType(final CanQual<Type> /*&*/ R, BuiltinType.Kind K) {
    BuiltinType /*P*/ Ty = /*NEW_EXPR [operator new] NM=_ZnwjRKN5clang10ASTContextEj*/
    /*new (*this, TypeAlignment)*/ $new_uint_ASTContext$C_uint(/*Deref*/this, TypeAlignment, (type$ptr<?> New$Mem)->{
        return new BuiltinType(K);
     });
    R.$assignMove(CanQual.<Type>CreateUnsafe(new QualType(Ty, 0)));
    Types.push_back(Ty);
  }

  
  // Return the Objective-C type encoding for a given type.
  
  // FIXME: Use SmallString for accumulating string.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::getObjCEncodingForTypeImpl">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp", line = 5593,
   FQN="clang::ASTContext::getObjCEncodingForTypeImpl", NM="_ZNK5clang10ASTContext26getObjCEncodingForTypeImplENS_8QualTypeERSsbbPKNS_9FieldDeclEbbbbbbPS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZNK5clang10ASTContext26getObjCEncodingForTypeImplENS_8QualTypeERSsbbPKNS_9FieldDeclEbbbbbbPS1_")
  //</editor-fold>
  private void getObjCEncodingForTypeImpl(QualType T, final std.string/*&*/ S, 
                            boolean ExpandPointedToStructures, 
                            boolean ExpandStructures, 
                            /*const*/ FieldDecl /*P*/ FD) /*const*/ {
    getObjCEncodingForTypeImpl(T, S, 
                            ExpandPointedToStructures, 
                            ExpandStructures, 
                            FD, 
                            false, 
                            false, 
                            false, 
                            false, 
                            false, 
                            false, 
                            (QualType /*P*/)null);
  }
  private void getObjCEncodingForTypeImpl(QualType T, final std.string/*&*/ S, 
                            boolean ExpandPointedToStructures, 
                            boolean ExpandStructures, 
                            /*const*/ FieldDecl /*P*/ FD, 
                            boolean OutermostType/*= false*/) /*const*/ {
    getObjCEncodingForTypeImpl(T, S, 
                            ExpandPointedToStructures, 
                            ExpandStructures, 
                            FD, 
                            OutermostType, 
                            false, 
                            false, 
                            false, 
                            false, 
                            false, 
                            (QualType /*P*/)null);
  }
  private void getObjCEncodingForTypeImpl(QualType T, final std.string/*&*/ S, 
                            boolean ExpandPointedToStructures, 
                            boolean ExpandStructures, 
                            /*const*/ FieldDecl /*P*/ FD, 
                            boolean OutermostType/*= false*/, 
                            boolean EncodingProperty/*= false*/) /*const*/ {
    getObjCEncodingForTypeImpl(T, S, 
                            ExpandPointedToStructures, 
                            ExpandStructures, 
                            FD, 
                            OutermostType, 
                            EncodingProperty, 
                            false, 
                            false, 
                            false, 
                            false, 
                            (QualType /*P*/)null);
  }
  private void getObjCEncodingForTypeImpl(QualType T, final std.string/*&*/ S, 
                            boolean ExpandPointedToStructures, 
                            boolean ExpandStructures, 
                            /*const*/ FieldDecl /*P*/ FD, 
                            boolean OutermostType/*= false*/, 
                            boolean EncodingProperty/*= false*/, 
                            boolean StructField/*= false*/) /*const*/ {
    getObjCEncodingForTypeImpl(T, S, 
                            ExpandPointedToStructures, 
                            ExpandStructures, 
                            FD, 
                            OutermostType, 
                            EncodingProperty, 
                            StructField, 
                            false, 
                            false, 
                            false, 
                            (QualType /*P*/)null);
  }
  private void getObjCEncodingForTypeImpl(QualType T, final std.string/*&*/ S, 
                            boolean ExpandPointedToStructures, 
                            boolean ExpandStructures, 
                            /*const*/ FieldDecl /*P*/ FD, 
                            boolean OutermostType/*= false*/, 
                            boolean EncodingProperty/*= false*/, 
                            boolean StructField/*= false*/, 
                            boolean EncodeBlockParameters/*= false*/) /*const*/ {
    getObjCEncodingForTypeImpl(T, S, 
                            ExpandPointedToStructures, 
                            ExpandStructures, 
                            FD, 
                            OutermostType, 
                            EncodingProperty, 
                            StructField, 
                            EncodeBlockParameters, 
                            false, 
                            false, 
                            (QualType /*P*/ )null);
  }
  private void getObjCEncodingForTypeImpl(QualType T, final std.string/*&*/ S, 
                            boolean ExpandPointedToStructures, 
                            boolean ExpandStructures, 
                            /*const*/ FieldDecl /*P*/ FD, 
                            boolean OutermostType/*= false*/, 
                            boolean EncodingProperty/*= false*/, 
                            boolean StructField/*= false*/, 
                            boolean EncodeBlockParameters/*= false*/, 
                            boolean EncodeClassNames/*= false*/) /*const*/ {
    getObjCEncodingForTypeImpl(T, S, 
                            ExpandPointedToStructures, 
                            ExpandStructures, 
                            FD, 
                            OutermostType, 
                            EncodingProperty, 
                            StructField, 
                            EncodeBlockParameters, 
                            EncodeClassNames, 
                            false, 
                            (QualType /*P*/)null);
  }
  private void getObjCEncodingForTypeImpl(QualType T, final std.string/*&*/ S, 
                            boolean ExpandPointedToStructures, 
                            boolean ExpandStructures, 
                            /*const*/ FieldDecl /*P*/ FD, 
                            boolean OutermostType/*= false*/, 
                            boolean EncodingProperty/*= false*/, 
                            boolean StructField/*= false*/, 
                            boolean EncodeBlockParameters/*= false*/, 
                            boolean EncodeClassNames/*= false*/, 
                            boolean EncodePointerToObjCTypedef/*= false*/) /*const*/ {
    getObjCEncodingForTypeImpl(T, S, 
                            ExpandPointedToStructures, 
                            ExpandStructures, 
                            FD, 
                            OutermostType, 
                            EncodingProperty, 
                            StructField, 
                            EncodeBlockParameters, 
                            EncodeClassNames, 
                            EncodePointerToObjCTypedef, 
                            (QualType /*P*/)null);
  }
  private void getObjCEncodingForTypeImpl(QualType T, final std.string/*&*/ S, 
                            boolean ExpandPointedToStructures, 
                            boolean ExpandStructures, 
                            /*const*/ FieldDecl /*P*/ FD, 
                            boolean OutermostType/*= false*/, 
                            boolean EncodingProperty/*= false*/, 
                            boolean StructField/*= false*/, 
                            boolean EncodeBlockParameters/*= false*/, 
                            boolean EncodeClassNames/*= false*/, 
                            boolean EncodePointerToObjCTypedef/*= false*/, 
                            QualType /*P*/ NotEncodedT/*= null*/) /*const*/ {
    CanQual<Type> CT = getCanonicalType(/*NO_COPY*/T);
    switch (((CanProxyType)CT.$arrow()).$arrow().getTypeClass()) {
     case Builtin:
     case Enum:
      if ((FD != null) && FD.isBitField()) {
        EncodeBitField(this, S, new QualType(T), FD);
        /*JAVA:return*/return;
      }
      {
        /*const*/ BuiltinType /*P*/ BT = dyn_cast_BuiltinType(CT);
        if ((BT != null)) {
          S.$addassign_T(getObjCEncodingForPrimitiveKind(this, BT.getKind()));
        } else {
          S.$addassign_T(ObjCEncodingForEnumType(this, cast_EnumType(CT)));
        }
      }
      return;
     case Complex:
      {
        /*const*/ ComplexType /*P*/ CT$1 = T.$arrow().castAs(ComplexType.class);
        S.$addassign_T($$j);
        getObjCEncodingForTypeImpl(CT$1.getElementType(), S, false, false, (/*const*/ FieldDecl /*P*/ )null);
        return;
      }
     case Atomic:
      {
        /*const*/ AtomicType /*P*/ AT = T.$arrow().castAs(AtomicType.class);
        S.$addassign_T($$A);
        getObjCEncodingForTypeImpl(AT.getValueType(), S, false, false, (/*const*/ FieldDecl /*P*/ )null);
        return;
      }
     case Pointer:
     case LValueReference:
     case RValueReference:
      {
        QualType PointeeTy/*J*/= new QualType();
        if (isa_PointerType(CT)) {
          /*const*/ PointerType /*P*/ PT = T.$arrow().castAs(PointerType.class);
          if (PT.isObjCSelType()) {
            S.$addassign_T($$COLON);
            return;
          }
          PointeeTy.$assignMove(PT.getPointeeType());
        } else {
          PointeeTy.$assignMove(T.$arrow().castAs(ReferenceType.class).getPointeeType());
        }
        
        boolean isReadOnly = false;
        // For historical/compatibility reasons, the read-only qualifier of the
        // pointee gets emitted _before_ the '^'.  The read-only qualifier of
        // the pointer itself gets ignored, _unless_ we are looking at a typedef!
        // Also, do not emit the 'r' for anything but the outermost type!
        if (isa_TypedefType(T.getTypePtr())) {
          if (OutermostType && T.isConstQualified()) {
            isReadOnly = true;
            S.$addassign_T($$r);
          }
        } else if (OutermostType) {
          QualType P = new QualType(PointeeTy);
          while ((P.$arrow().getAs(PointerType.class) != null)) {
            P.$assignMove(P.$arrow().getAs(PointerType.class).getPointeeType());
          }
          if (P.isConstQualified()) {
            isReadOnly = true;
            S.$addassign_T($$r);
          }
        }
        if (isReadOnly) {
          // Another legacy compatibility encoding. Some ObjC qualifier and type
          // combinations need to be rearranged.
          // Rewrite "in const" from "nr" to "rn"
          if (new StringRef(S).endswith(/*STRINGREF_STR*/"nr")) {
            S.replace(S.end().$sub(2), S.end(), $("rn"));
          }
        }
        if (PointeeTy.$arrow().isCharType()) {
          // char pointer types should be encoded as '*' unless it is a
          // type that has been typedef'd to 'BOOL'.
          if (!isTypeTypedefedAsBOOL(new QualType(PointeeTy))) {
            S.$addassign_T($$STAR);
            return;
          }
        } else {
          /*const*/ RecordType /*P*/ RTy = PointeeTy.$arrow().getAs$RecordType();
          if ((RTy != null)) {
            // GCC binary compat: Need to convert "struct objc_class *" to "#".
            if (RTy.getDecl().getIdentifier() == $AddrOf(Idents.get(new StringRef(/*KEEP_STR*/"objc_class")))) {
              S.$addassign_T($$HASH);
              return;
            }
            // GCC binary compat: Need to convert "struct objc_object *" to "@".
            if (RTy.getDecl().getIdentifier() == $AddrOf(Idents.get(new StringRef(/*KEEP_STR*/"objc_object")))) {
              S.$addassign_T($$AT);
              return;
            }
            // fall through...
          }
        }
        S.$addassign_T($$CARET);
        getLegacyIntegralTypeEncoding(PointeeTy);
        
        getObjCEncodingForTypeImpl(new QualType(PointeeTy), S, false, ExpandPointedToStructures, 
            (/*const*/ FieldDecl /*P*/ )null, false, false, false, false, false, false, 
            NotEncodedT);
        return;
      }
     case ConstantArray:
     case IncompleteArray:
     case VariableArray:
      {
        /*const*/ ArrayType /*P*/ AT = cast_ArrayType(CT);
        if (isa_IncompleteArrayType(AT) && !StructField) {
          // Incomplete arrays are encoded as a pointer to the array element.
          S.$addassign_T($$CARET);
          
          getObjCEncodingForTypeImpl(AT.getElementType(), S, 
              false, ExpandStructures, FD);
        } else {
          S.$addassign_T($$LSQUARE);
          {
            
            /*const*/ ConstantArrayType /*P*/ CAT = dyn_cast_ConstantArrayType(AT);
            if ((CAT != null)) {
              S.$addassign(llvm.utostr(CAT.getSize().getZExtValue()));
            } else {
              //Variable length arrays are encoded as a regular array with 0 elements.
              assert ((isa_VariableArrayType(AT) || isa_IncompleteArrayType(AT))) : "Unknown array type!";
              S.$addassign_T($$0);
            }
          }
          
          getObjCEncodingForTypeImpl(AT.getElementType(), S, 
              false, ExpandStructures, FD, 
              false, false, false, false, false, false, 
              NotEncodedT);
          S.$addassign_T($$RSQUARE);
        }
        return;
      }
     case FunctionNoProto:
     case FunctionProto:
      S.$addassign_T($$QMARK);
      return;
     case Record:
      {
        RecordDecl /*P*/ RDecl = cast_RecordType(CT).getDecl();
        S.$addassign_T(RDecl.isUnion() ? $$LPAREN : $$LCURLY);
        {
          // Anonymous structures print as '?'
          /*const*/ IdentifierInfo /*P*/ II = RDecl.getIdentifier();
          if ((II != null)) {
            $addassign_string_StringRef(S, II.getName());
            {
              ClassTemplateSpecializationDecl /*P*/ Spec = dyn_cast_ClassTemplateSpecializationDecl(RDecl);
              if ((Spec != null)) {
                raw_string_ostream OS = null;
                try {
                  final /*const*/ TemplateArgumentList /*&*/ TemplateArgs = Spec.getTemplateArgs();
                  OS/*J*/= new raw_string_ostream(S);
                  TemplateSpecializationType.PrintTemplateArgumentList1(OS, 
                      TemplateArgs.asArray(), 
                      (/*Deref*/this).getPrintingPolicy());
                } finally {
                  if (OS != null) { OS.$destroy(); }
                }
              }
            }
          } else {
            S.$addassign_T($$QMARK);
          }
        }
        if (ExpandStructures) {
          S.$addassign_T($$EQ);
          if (!RDecl.isUnion()) {
            getObjCEncodingForStructureImpl(RDecl, S, FD, true, NotEncodedT);
          } else {
            for (/*const*/ FieldDecl /*P*/ Field : RDecl.fields()) {
              if ((FD != null)) {
                S.$addassign_T($$DBL_QUOTE);
                S.$addassign(Field.getNameAsString());
                S.$addassign_T($$DBL_QUOTE);
              }
              
              // Special case bit-fields.
              if (Field.isBitField()) {
                getObjCEncodingForTypeImpl(Field.getType(), S, false, true, 
                    Field);
              } else {
                QualType qt = Field.getType();
                getLegacyIntegralTypeEncoding(qt);
                getObjCEncodingForTypeImpl(new QualType(qt), S, false, true, 
                    FD, /*OutermostType*/ false, 
                    /*EncodingProperty*/ false, 
                    /*StructField*/ true, 
                    false, false, false, NotEncodedT);
              }
            }
          }
        }
        S.$addassign_T(RDecl.isUnion() ? $$RPAREN : $$RCURLY);
        return;
      }
     case BlockPointer:
      {
        /*const*/ BlockPointerType /*P*/ BT = T.$arrow().castAs(BlockPointerType.class);
        S.$addassign_T$C$P(/*KEEP_STR*/"@?"); // Unlike a pointer-to-function, which is "^?".
        if (EncodeBlockParameters) {
          /*const*/ FunctionType /*P*/ FT = BT.getPointeeType().$arrow().castAs(FunctionType.class);
          
          S.$addassign_T($$LT);
          // Block return type
          getObjCEncodingForTypeImpl(FT.getReturnType(), S, ExpandPointedToStructures, ExpandStructures, 
              FD, false/* OutermostType */, EncodingProperty, 
              false/* StructField */, EncodeBlockParameters, EncodeClassNames, false, 
              NotEncodedT);
          // Block self
          S.$addassign_T$C$P(/*KEEP_STR*/"@?");
          {
            // Block parameters
            /*const*/ FunctionProtoType /*P*/ FPT = dyn_cast_FunctionProtoType(FT);
            if ((FPT != null)) {
              for (final /*const*/ QualType /*&*/ I : FPT.param_types())  {
                getObjCEncodingForTypeImpl(new QualType(I), S, ExpandPointedToStructures, ExpandStructures, FD, 
                    false/* OutermostType */, EncodingProperty, 
                    false/* StructField */, EncodeBlockParameters, EncodeClassNames, 
                    false, NotEncodedT);
              }
            }
          }
          S.$addassign_T($$GT);
        }
        return;
      }
     case ObjCObject:
      {
        // hack to match legacy encoding of *id and *Class
        QualType Ty = getObjCObjectPointerType(CT.$QualType());
        if (Ty.$arrow().isObjCIdType()) {
          S.$addassign_T$C$P(/*KEEP_STR*/"{objc_object=}");
          return;
        } else if (Ty.$arrow().isObjCClassType()) {
          S.$addassign_T$C$P(/*KEEP_STR*/"{objc_class=}");
          return;
        }
      }
     case ObjCInterface:
      {
        // Ignore protocol qualifiers when mangling at this level.
        // @encode(class_name)
        ObjCInterfaceDecl /*P*/ OI = T.$arrow().castAs(ObjCObjectType.class).getInterface();
        S.$addassign_T($$LCURLY);
        $addassign_string_StringRef(S, OI.getObjCRuntimeNameAsString());
        S.$addassign_T($$EQ);
        SmallVector</*const*/ ObjCIvarDecl /*P*/ > Ivars/*J*/= new SmallVector</*const*/ ObjCIvarDecl /*P*/ >(32, (/*const*/ ObjCIvarDecl /*P*/ )null);
        DeepCollectObjCIvars(OI, true, Ivars);
        for (/*uint*/int i = 0, e = Ivars.size(); i != e; ++i) {
          /*const*/ FieldDecl /*P*/ Field = cast_FieldDecl(Ivars.$at(i));
          if (Field.isBitField()) {
            getObjCEncodingForTypeImpl(Field.getType(), S, false, true, Field);
          } else {
            getObjCEncodingForTypeImpl(Field.getType(), S, false, true, FD, 
                false, false, false, false, false, 
                EncodePointerToObjCTypedef, 
                NotEncodedT);
          }
        }
        S.$addassign_T($$RCURLY);
        return;
      }
     case ObjCObjectPointer:
      {
        /*const*/ ObjCObjectPointerType /*P*/ OPT = T.$arrow().castAs(ObjCObjectPointerType.class);
        if (OPT.isObjCIdType()) {
          S.$addassign_T($$AT);
          return;
        }
        if (OPT.isObjCClassType() || OPT.isObjCQualifiedClassType()) {
          // FIXME: Consider if we need to output qualifiers for 'Class<p>'.
          // Since this is a binary compatibility issue, need to consult with runtime
          // folks. Fortunately, this is a *very* obsure construct.
          S.$addassign_T($$HASH);
          return;
        }
        if (OPT.isObjCQualifiedIdType()) {
          getObjCEncodingForTypeImpl(getObjCIdType(), S, 
              ExpandPointedToStructures, 
              ExpandStructures, FD);
          if ((FD != null) || EncodingProperty || EncodeClassNames) {
            // Note that we do extended encoding of protocol qualifer list
            // Only when doing ivar or property encoding.
            S.$addassign_T($$DBL_QUOTE);
            for (/*const*/ ObjCProtocolDecl /*P*/ I : OPT.quals()) {
              S.$addassign_T($$LT);
              $addassign_string_StringRef(S, I.getObjCRuntimeNameAsString());
              S.$addassign_T($$GT);
            }
            S.$addassign_T($$DBL_QUOTE);
          }
          return;
        }
        
        QualType PointeeTy = OPT.getPointeeType();
        if (!EncodingProperty
           && isa_TypedefType(PointeeTy.getTypePtr())
           && !EncodePointerToObjCTypedef) {
          // Another historical/compatibility reason.
          // We encode the underlying type which comes out as
          // {...};
          S.$addassign_T($$CARET);
          if ((FD != null) && (OPT.getInterfaceDecl() != null)) {
            // Prevent recursive encoding of fields in some rare cases.
            ObjCInterfaceDecl /*P*/ OI = OPT.getInterfaceDecl();
            SmallVector</*const*/ ObjCIvarDecl /*P*/ > Ivars/*J*/= new SmallVector</*const*/ ObjCIvarDecl /*P*/ >(32, (/*const*/ ObjCIvarDecl /*P*/ )null);
            DeepCollectObjCIvars(OI, true, Ivars);
            for (/*uint*/int i = 0, e = Ivars.size(); i != e; ++i) {
              if (cast_FieldDecl(Ivars.$at(i)) == FD) {
                S.$addassign_T($$LCURLY);
                $addassign_string_StringRef(S, OI.getObjCRuntimeNameAsString());
                S.$addassign_T($$RCURLY);
                return;
              }
            }
          }
          getObjCEncodingForTypeImpl(new QualType(PointeeTy), S, 
              false, ExpandPointedToStructures, 
              (/*const*/ FieldDecl /*P*/ )null, 
              false, false, false, false, false, 
              /*EncodePointerToObjCTypedef*/ true);
          return;
        }
        
        S.$addassign_T($$AT);
        if ((OPT.getInterfaceDecl() != null)
           && ((FD != null) || EncodingProperty || EncodeClassNames)) {
          S.$addassign_T($$DBL_QUOTE);
          $addassign_string_StringRef(S, OPT.getInterfaceDecl().getObjCRuntimeNameAsString());
          for (/*const*/ ObjCProtocolDecl /*P*/ I : OPT.quals()) {
            S.$addassign_T($$LT);
            $addassign_string_StringRef(S, I.getObjCRuntimeNameAsString());
            S.$addassign_T($$GT);
          }
          S.$addassign_T($$DBL_QUOTE);
        }
        return;
      }
     case MemberPointer:
     case Vector:
     case ExtVector:
      {
        if ((NotEncodedT != null)) {
          /*Deref*/NotEncodedT.$assign(T);
        }
        return;
      }
     case Auto:
      
      // We could see an undeduced auto type here during error recovery.
      // Just ignore it.
      return;
     case Pipe:
     case DependentSizedArray:
     case DependentSizedExtVector:
     case UnresolvedUsing:
     case Paren:
     case Typedef:
     case Adjusted:
     case Decayed:
     case TypeOfExpr:
     case TypeOf:
     case Decltype:
     case UnaryTransform:
     case Elaborated:
     case Attributed:
     case TemplateTypeParm:
     case SubstTemplateTypeParm:
     case SubstTemplateTypeParmPack:
     case TemplateSpecialization:
     case InjectedClassName:
     case DependentName:
     case DependentTemplateSpecialization:
     case PackExpansion:
      throw new llvm_unreachable("@encode for dependent type!");
    }
    throw new llvm_unreachable("bad type kind!");
  }

  
  // Adds the encoding of the structure's members.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::getObjCEncodingForStructureImpl">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp", line = 5964,
   FQN="clang::ASTContext::getObjCEncodingForStructureImpl", NM="_ZNK5clang10ASTContext31getObjCEncodingForStructureImplEPNS_10RecordDeclERSsPKNS_9FieldDeclEbPNS_8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZNK5clang10ASTContext31getObjCEncodingForStructureImplEPNS_10RecordDeclERSsPKNS_9FieldDeclEbPNS_8QualTypeE")
  //</editor-fold>
  private void getObjCEncodingForStructureImpl(RecordDecl /*P*/ RDecl, 
                                 final std.string/*&*/ S, 
                                 /*const*/ FieldDecl /*P*/ FD) /*const*/ {
    getObjCEncodingForStructureImpl(RDecl, 
                                 S, 
                                 FD, 
                                 true, 
                                 (QualType /*P*/)null);
  }
  private void getObjCEncodingForStructureImpl(RecordDecl /*P*/ RDecl, 
                                 final std.string/*&*/ S, 
                                 /*const*/ FieldDecl /*P*/ FD, 
                                 boolean includeVBases/*= true*/) /*const*/ {
    getObjCEncodingForStructureImpl(RDecl, 
                                 S, 
                                 FD, 
                                 includeVBases, 
                                 (QualType /*P*/)null);
  }
  private void getObjCEncodingForStructureImpl(RecordDecl /*P*/ RDecl, 
                                 final std.string/*&*/ S, 
                                 /*const*/ FieldDecl /*P*/ FD, 
                                 boolean includeVBases/*= true*/, 
                                 QualType /*P*/ NotEncodedT/*= null*/) /*const*/ {
    std.multimapULongType<NamedDecl /*P*/ > FieldOrBaseOffsets = null;
    try {
      assert ((RDecl != null)) : "Expected non-null RecordDecl";
      assert (!RDecl.isUnion()) : "Should not be called for unions";
      if (!(RDecl.getDefinition() != null) || RDecl.getDefinition().isInvalidDecl()) {
        return;
      }
      
      CXXRecordDecl /*P*/ CXXRec = dyn_cast_CXXRecordDecl(RDecl);
      FieldOrBaseOffsets/*J*/= new std.multimapULongType<NamedDecl /*P*/ >(null);
      final /*const*/ ASTRecordLayout /*&*/ layout = getASTRecordLayout(RDecl);
      if ((CXXRec != null)) {
        for (final /*const*/ CXXBaseSpecifier /*&*/ BI : CXXRec.bases()) {
          if (!BI.isVirtual()) {
            CXXRecordDecl /*P*/ base = BI.getType().$arrow().getAsCXXRecordDecl();
            if (base.isEmpty()) {
              continue;
            }
            long/*uint64_t*/ offs = toBits(layout.getBaseClassOffset(base));
            FieldOrBaseOffsets.insert$T(FieldOrBaseOffsets.upper_bound(offs), 
                std.make_pair_ullong_Ptr(offs, base));
          }
        }
      }
      
      /*uint*/int i = 0;
      for (FieldDecl /*P*/ Field : RDecl.fields()) {
        long/*uint64_t*/ offs = layout.getFieldOffset(i);
        FieldOrBaseOffsets.insert$T(FieldOrBaseOffsets.upper_bound(offs), 
            std.make_pair_ullong_Ptr(offs, Field));
        ++i;
      }
      if ((CXXRec != null) && includeVBases) {
        for (final /*const*/ CXXBaseSpecifier /*&*/ BI : CXXRec.vbases()) {
          CXXRecordDecl /*P*/ base = BI.getType().$arrow().getAsCXXRecordDecl();
          if (base.isEmpty()) {
            continue;
          }
          long/*uint64_t*/ offs = toBits(layout.getVBaseClassOffset(base));
          if ($greatereq_ulong(offs, ((long/*uint64_t*/)(toBits(layout.getNonVirtualSize()))))
             && FieldOrBaseOffsets.find(offs).$eq(FieldOrBaseOffsets.end())) {
            FieldOrBaseOffsets.insert$T(FieldOrBaseOffsets.end(), 
                std.make_pair_ullong_Ptr(offs, base));
          }
        }
      }
      
      CharUnits size/*J*/= new CharUnits();
      if ((CXXRec != null)) {
        size.$assignMove(includeVBases ? layout.getSize() : layout.getNonVirtualSize());
      } else {
        size.$assignMove(layout.getSize());
      }
      long/*uint64_t*/ CurOffs = $int2ulong(0);
      type$iterator<?, std_pair.pairULongType<NamedDecl /*P*/>> CurLayObj = FieldOrBaseOffsets.begin();
      if ((CXXRec != null) && CXXRec.isDynamicClass()
         && (CurLayObj.$eq(FieldOrBaseOffsets.end()) || CurLayObj.$arrow().first != $int2ullong(0))) {
        if ((FD != null)) {
          S.$addassign_T$C$P(/*KEEP_STR*/"\"_vptr$");
          std.string recname = CXXRec.getNameAsString();
          if (recname.empty()) {
            recname.$assign_T$C$P(/*KEEP_STR*/"?");
          }
          S.$addassign(recname);
          S.$addassign_T($$DBL_QUOTE);
        }
        S.$addassign_T$C$P(/*KEEP_STR*/"^^?");
        CurOffs += getTypeSize(VoidPtrTy.$QualType());
      }
      if (!RDecl.hasFlexibleArrayMember()) {
        // Mark the end of the structure.
        long/*uint64_t*/ offs = toBits(new CharUnits(size));
        FieldOrBaseOffsets.insert$T(FieldOrBaseOffsets.upper_bound(offs), 
            std.make_pair_ullong_Ptr(offs, (CXXRecordDecl)null));
      }
      
      for (; CurLayObj.$noteq(FieldOrBaseOffsets.end()); CurLayObj.$preInc()) {
        assert ($lesseq_ulong_ullong(CurOffs, CurLayObj.$arrow().first));
        if ($less_ulong_ullong(CurOffs, CurLayObj.$arrow().first)) {
          long/*uint64_t*/ padding = CurLayObj.$arrow().first - CurOffs;
          // FIXME: There doesn't seem to be a way to indicate in the encoding that
          // packing/alignment of members is different that normal, in which case
          // the encoding will be out-of-sync with the real layout.
          // If the runtime switches to just consider the size of types without
          // taking into account alignment, we could make padding explicit in the
          // encoding (e.g. using arrays of chars). The encoding strings would be
          // longer then though.
          CurOffs += padding;
        }
        
        NamedDecl /*P*/ dcl = CurLayObj.$arrow().second;
        if (!(dcl != null)) {
          break; // reached end of structure.
        }
        {
          
          CXXRecordDecl /*P*/ base = dyn_cast_CXXRecordDecl(dcl);
          if ((base != null)) {
            // We expand the bases without their virtual bases since those are going
            // in the initial structure. Note that this differs from gcc which
            // expands virtual bases each time one is encountered in the hierarchy,
            // making the encoding type bigger than it really is.
            getObjCEncodingForStructureImpl(base, S, FD, /*includeVBases*/ false, 
                NotEncodedT);
            assert (!base.isEmpty());
            CurOffs += toBits(getASTRecordLayout(base).getNonVirtualSize());
          } else {
            FieldDecl /*P*/ field = cast_FieldDecl(dcl);
            if ((FD != null)) {
              S.$addassign_T($$DBL_QUOTE);
              S.$addassign(field.getNameAsString());
              S.$addassign_T($$DBL_QUOTE);
            }
            if (field.isBitField()) {
              EncodeBitField(this, S, field.getType(), field);
              CurOffs += $uint2ullong(field.getBitWidthValue(/*Deref*/this));
            } else {
              QualType qt = field.getType();
              getLegacyIntegralTypeEncoding(qt);
              getObjCEncodingForTypeImpl(new QualType(qt), S, false, true, FD, 
                  /*OutermostType*/ false, 
                  /*EncodingProperty*/ false, 
                  /*StructField*/ true, 
                  false, false, false, NotEncodedT);
              CurOffs += getTypeSize(field.getType());
            }
          }
        }
      }
    } finally {
      if (FieldOrBaseOffsets != null) { FieldOrBaseOffsets.$destroy(); }
    }
  }

/*public:*/
  // Adds the encoding of a method parameter or return type.
  
  /// getObjCEncodingForMethodParameter - Return the encoded type for a single
  /// method parameter or return type. If Extended, include class names and 
  /// block object types.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::getObjCEncodingForMethodParameter">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp", line = 5267,
   FQN="clang::ASTContext::getObjCEncodingForMethodParameter", NM="_ZNK5clang10ASTContext33getObjCEncodingForMethodParameterENS_4Decl17ObjCDeclQualifierENS_8QualTypeERSsb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZNK5clang10ASTContext33getObjCEncodingForMethodParameterENS_4Decl17ObjCDeclQualifierENS_8QualTypeERSsb")
  //</editor-fold>
  public void getObjCEncodingForMethodParameter(/*Decl::ObjCDeclQualifier*//*uint*/int QT, 
                                   QualType T, final std.string/*&*/ S, 
                                   boolean Extended) /*const*/ {
    // Encode type qualifer, 'in', 'inout', etc. for the parameter.
    getObjCEncodingForTypeQualifier(QT, S);
    // Encode parameter type.
    getObjCEncodingForTypeImpl(new QualType(T), S, true, true, (/*const*/ FieldDecl /*P*/ )null, 
        true/*OutermostType*/, 
        false/*EncodingProperty*/, 
        false/*StructField*/, 
        Extended/*EncodeBlockParameters*/, 
        Extended/*EncodeClassNames*/);
  }

  
  /// \brief Returns true if this is an inline-initialized static data member
  /// which is treated as a definition for MSVC compatibility.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::isMSStaticDataMemberInlineDefinition">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp", line = 5135,
   FQN="clang::ASTContext::isMSStaticDataMemberInlineDefinition", NM="_ZNK5clang10ASTContext36isMSStaticDataMemberInlineDefinitionEPKNS_7VarDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZNK5clang10ASTContext36isMSStaticDataMemberInlineDefinitionEPKNS_7VarDeclE")
  //</editor-fold>
  public boolean isMSStaticDataMemberInlineDefinition(/*const*/ VarDecl /*P*/ VD) /*const*/ {
    return getTargetInfo().getCXXABI().isMicrosoft()
       && VD.isStaticDataMember()
       && VD.getType().$arrow().isIntegralOrEnumerationType()
       && !VD.getFirstDecl$Const().isOutOfLine() && VD.getFirstDecl$Const().hasInit();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::InlineVariableDefinitionKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ASTContext.h", line = 2532,
   FQN="clang::ASTContext::InlineVariableDefinitionKind", NM="_ZN5clang10ASTContext28InlineVariableDefinitionKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZN5clang10ASTContext28InlineVariableDefinitionKindE")
  //</editor-fold>
  public enum /*class */InlineVariableDefinitionKind/* : int*/ implements Native.ComparableLower {
    None(0), ///< Not an inline variable.
    Weak(None.getValue() + 1), ///< Weak definition of inline variable.
    WeakUnknown(Weak.getValue() + 1), ///< Weak for now, might become strong later in this TU.
    Strong(WeakUnknown.getValue() + 1); ///< Strong definition.

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static InlineVariableDefinitionKind valueOf(int val) {
      InlineVariableDefinitionKind out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final InlineVariableDefinitionKind[] VALUES;
      private static final InlineVariableDefinitionKind[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (InlineVariableDefinitionKind kind : InlineVariableDefinitionKind.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new InlineVariableDefinitionKind[min < 0 ? (1-min) : 0];
        VALUES = new InlineVariableDefinitionKind[max >= 0 ? (1+max) : 0];
        for (InlineVariableDefinitionKind kind : InlineVariableDefinitionKind.values()) {
          if (kind.value < 0) {
            if (_VALUES[-kind.value] == null) {
              _VALUES[-kind.value] = kind;
            } else {
              assert true: "Must not replace " + _VALUES[-kind.value] + " by " + kind + ". Switch to int-based enum or filter valid.";
            }
          } else {
            if (VALUES[kind.value] == null) {
              VALUES[kind.value] = kind;
            } else {
              assert true: "Must not replace " + VALUES[kind.value] + " by " + kind + ". Switch to int-based enum or filter valid.";
            }
          }
        }
      }
    }

    private final int value;
    private InlineVariableDefinitionKind(int val) { this.value = (int)val;}
    public int getValue() { return value;}
    @Override public boolean $less(Object obj) { return Unsigned.$less_int(value, ((InlineVariableDefinitionKind)obj).value);}
    @Override public boolean $lesseq(Object obj) { return Unsigned.$lesseq_int(value, ((InlineVariableDefinitionKind)obj).value);}
    //</editor-fold>
  };
  /// \brief Determine whether a definition of this inline variable should
  /// be treated as a weak or strong definition. For compatibility with
  /// C++14 and before, for a constexpr static data member, if there is an
  /// out-of-line declaration of the member, we may promote it from weak to
  /// strong.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::getInlineVariableDefinitionKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp", line = 5142,
   FQN="clang::ASTContext::getInlineVariableDefinitionKind", NM="_ZNK5clang10ASTContext31getInlineVariableDefinitionKindEPKNS_7VarDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZNK5clang10ASTContext31getInlineVariableDefinitionKindEPKNS_7VarDeclE")
  //</editor-fold>
  public ASTContext.InlineVariableDefinitionKind getInlineVariableDefinitionKind(/*const*/ VarDecl /*P*/ VD) /*const*/ {
    if (!VD.isInline()) {
      return InlineVariableDefinitionKind.None;
    }
    
    // In almost all cases, it's a weak definition.
    /*const*/ VarDecl /*P*/ First = VD.getFirstDecl$Const();
    if (!First.isConstexpr() || First.isInlineSpecified()
       || !VD.isStaticDataMember()) {
      return InlineVariableDefinitionKind.Weak;
    }
    
    // If there's a file-context declaration in this translation unit, it's a
    // non-discardable definition.
    for (VarDecl /*P*/ D : VD.redeclarable_redecls())  {
      if (D.getLexicalDeclContext().isFileContext()) {
        return InlineVariableDefinitionKind.Strong;
      }
    }
    
    // If we've not seen one yet, we don't know.
    return InlineVariableDefinitionKind.WeakUnknown;
  }

/*private:*/
  
  /// getObjCLayout - Get or compute information about the layout of the
  /// given interface.
  ///
  /// \param Impl - If given, also include the layout of the interface's
  /// implementation. This may differ by including synthesized ivars.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::getObjCLayout">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/RecordLayoutBuilder.cpp", line = 3081,
   FQN="clang::ASTContext::getObjCLayout", NM="_ZNK5clang10ASTContext13getObjCLayoutEPKNS_17ObjCInterfaceDeclEPKNS_22ObjCImplementationDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/RecordLayoutBuilder.cpp -nm=_ZNK5clang10ASTContext13getObjCLayoutEPKNS_17ObjCInterfaceDeclEPKNS_22ObjCImplementationDeclE")
  //</editor-fold>
  private /*const*/ ASTRecordLayout /*&*/ getObjCLayout(/*const*/ ObjCInterfaceDecl /*P*/ D, 
               /*const*/ ObjCImplementationDecl /*P*/ Impl) /*const*/ {
    ItaniumRecordLayoutBuilder Builder = null;
    try {
      // Retrieve the definition
      if (D.hasExternalLexicalStorage() && !(D.getDefinition$Const() != null)) {
        getExternalSource().CompleteType(((/*const_cast*/ObjCInterfaceDecl /*P*/ )(D)));
      }
      D = D.getDefinition$Const();
      assert ((D != null) && D.isThisDeclarationADefinition()) : "Invalid interface decl!";
      
      // Look up this layout, if already laid out, return what we have.
      /*const*/ ObjCContainerDecl /*P*/ Key = (Impl != null) ? (/*const*/ ObjCContainerDecl /*P*/ )Impl : (/*const*/ ObjCContainerDecl /*P*/ )D;
      {
        /*const*/ ASTRecordLayout /*P*/ Entry = ObjCLayouts.$at_T1$C$R(Key);
        if ((Entry != null)) {
          return $Deref(Entry);
        }
      }
      
      // Add in synthesized ivar count if laying out an implementation.
      if ((Impl != null)) {
        /*uint*/int SynthCount = CountNonClassIvars(D);
        // If there aren't any synthesized ivars then reuse the interface
        // entry. Note we can't cache this because we simply free all
        // entries later; however we shouldn't look up implementations
        // frequently.
        if (SynthCount == 0) {
          return getObjCLayout(D, (/*const*/ ObjCImplementationDecl /*P*/ )null);
        }
      }
      
      Builder/*J*/= new ItaniumRecordLayoutBuilder(/*Deref*/this, /*EmptySubobjects=*/ (EmptySubobjectMap /*P*/ )null);
      Builder.Layout(D);
      final ItaniumRecordLayoutBuilder L$Builder = Builder;
      /*const*/ ASTRecordLayout /*P*/ NewEntry = /*NEW_EXPR [operator new] NM=_ZnwjRKN5clang10ASTContextEj*/
      /*new (*this)*/ $new_uint_ASTContext$C_uint(/*Deref*/this, (type$ptr<?> New$Mem)->{
          return new ASTRecordLayout(/*Deref*/this, L$Builder.getSize(), 
                  new CharUnits(L$Builder.Alignment), 
                  /*RequiredAlignment : used by MS-ABI)*/
                  new CharUnits(L$Builder.Alignment), 
                  L$Builder.getDataSize(), 
                  new ArrayRefULong(L$Builder.FieldOffsets));
       });
      
      ObjCLayouts.$set(Key, NewEntry);
      
      return $Deref(NewEntry);
    } finally {
      if (Builder != null) { Builder.$destroy(); }
    }
  }


  
  /// \brief A set of deallocations that should be performed when the
  /// ASTContext is destroyed.
  // FIXME: We really should have a better mechanism in the ASTContext to
  // manage running destructors for types which do variable sized allocation
  // within the AST. In some places we thread the AST bump pointer allocator
  // into the datastructures which avoids this mess during deallocation but is
  // wasteful of memory, and here we require a lot of error prone book keeping
  // in order to track and run destructors while we're tearing things down.
  /*typedef llvm::SmallVector<std::pair<void (*)(void *), void *>, 16> DeallocationFunctionsAndArguments*/
//  public final class DeallocationFunctionsAndArguments extends SmallVector<std.pair<VoidPtr2Void, Object/*void P*/ >>{ };
  private SmallVector<std.pair<VoidPtr2Void, Object/*void P*/ >> Deallocations;
  
  // FIXME: This currently contains the set of StoredDeclMaps used
  // by DeclContext objects.  This probably should not be in ASTContext,
  // but we include it here so that ASTContext can quickly deallocate them.
  /*friend*/protected/*private*/ PointerIntPair<StoredDeclsMap /*P*/ > LastSDM;
  
  /*friend  class DeclContext*/
  /*friend  class DeclarationNameTable*/
  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::ReleaseDeclContextMaps">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp", line = 1716,
   FQN="clang::ASTContext::ReleaseDeclContextMaps", NM="_ZN5clang10ASTContext22ReleaseDeclContextMapsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp -nm=_ZN5clang10ASTContext22ReleaseDeclContextMapsEv")
  //</editor-fold>
  private void ReleaseDeclContextMaps() {
    // It's okay to delete DependentStoredDeclsMaps via a StoredDeclsMap
    // pointer because the subclass doesn't add anything that needs to
    // be deleted.
    StoredDeclsMap.DestroyAll(LastSDM.getPointer(), (LastSDM.getInt() != 0));
  }


  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::ReleaseParentMapEntries">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp", line = 794,
   FQN="clang::ASTContext::ReleaseParentMapEntries", NM="_ZN5clang10ASTContext23ReleaseParentMapEntriesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZN5clang10ASTContext23ReleaseParentMapEntriesEv")
  //</editor-fold>
  private void ReleaseParentMapEntries() {
    if (!PointerParents.$bool()) {
      return;
    }
    for (final /*const*/ std.pair</*const*/Object/*void P*/ , PointerUnion4</*const*/ Decl /*P*/ , /*const*/ Stmt /*P*/ , DynTypedNode /*P*/ , SmallVector<DynTypedNode> /*P*/> > /*&*/ Entry : PointerParents.$star()) {
      if ((Entry.second.is(DynTypedNode /*P*/.class) != 0)) {
        /*delete*/Destructors.$destroy(Entry.second.get(DynTypedNode /*P*/.class));
      } else if ((Entry.second.is(SmallVector /*P*/.class) != 0)) {
        if (Entry.second.get(SmallVector /*P*/.class) != null) { Entry.second.get(SmallVector /*P*/.class).$destroy();};
      }
    }
    for (final /*const*/std.pair<DynTypedNode, PointerUnion4</*const*/ Decl /*P*/ , /*const*/ Stmt /*P*/ , DynTypedNode /*P*/ , SmallVector<DynTypedNode> /*P*/>> /*&*/ Entry : OtherParents.$star()) {
      if ((Entry.second.is(DynTypedNode /*P*/.class) != 0)) {
        /*delete*/Destructors.$destroy(Entry.second.get(DynTypedNode /*P*/.class));
      } else if ((Entry.second.is(SmallVector /*P*/.class) != 0)) {
        if (Entry.second.get(SmallVector /*P*/.class) != null) { Entry.second.get(SmallVector /*P*/.class).$destroy();};
      }
    }
  }

  
  private std.unique_ptr<DenseMap</*const*/Object/*void P*/ , PointerUnion4</*const*/ Decl /*P*/ , /*const*/ Stmt /*P*/ , DynTypedNode /*P*/ , SmallVector<DynTypedNode> /*P*/> > > PointerParents;
  private std.unique_ptr<DenseMap<DynTypedNode, PointerUnion4</*const*/ Decl /*P*/ , /*const*/ Stmt /*P*/ , DynTypedNode /*P*/ , SmallVector<DynTypedNode> /*P*/> > > OtherParents;
  
  private std.unique_ptr<VTableContextBase> VTContext;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::PragmaSectionFlag">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ASTContext.h", line = 2579,
   FQN="clang::ASTContext::PragmaSectionFlag", NM="_ZN5clang10ASTContext17PragmaSectionFlagE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZN5clang10ASTContext17PragmaSectionFlagE")
  //</editor-fold>
  public static final class/*enum*/ PragmaSectionFlag/* : unsigned int*/ {
    public static final /*uint*/int PSF_None = 0;
    public static final /*uint*/int PSF_Read = 0x1;
    public static final /*uint*/int PSF_Write = 0x2;
    public static final /*uint*/int PSF_Execute = 0x4;
    public static final /*uint*/int PSF_Implicit = 0x8;
    public static final /*uint*/int PSF_Invalid = 0x80000000/*U*/;
  };
  
  //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::SectionInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ASTContext.h", line = 2588,
   FQN="clang::ASTContext::SectionInfo", NM="_ZN5clang10ASTContext11SectionInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZN5clang10ASTContext11SectionInfoE")
  //</editor-fold>
  public static class/*struct*/ SectionInfo implements NativeCloneable<SectionInfo> {
    public DeclaratorDecl /*P*/ Decl;
    public SourceLocation PragmaSectionLocation;
    public int SectionFlags;
    //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::SectionInfo::SectionInfo">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ASTContext.h", line = 2592,
     FQN="clang::ASTContext::SectionInfo::SectionInfo", NM="_ZN5clang10ASTContext11SectionInfoC1Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZN5clang10ASTContext11SectionInfoC1Ev")
    //</editor-fold>
    public SectionInfo() {
      // : PragmaSectionLocation() 
      //START JInit
      this.PragmaSectionLocation = new SourceLocation();
      //END JInit
    }

    //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::SectionInfo::SectionInfo">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ASTContext.h", line = 2593,
     FQN="clang::ASTContext::SectionInfo::SectionInfo", NM="_ZN5clang10ASTContext11SectionInfoC1EPNS_14DeclaratorDeclENS_14SourceLocationEi",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZN5clang10ASTContext11SectionInfoC1EPNS_14DeclaratorDeclENS_14SourceLocationEi")
    //</editor-fold>
    public SectionInfo(DeclaratorDecl /*P*/ Decl, 
        SourceLocation PragmaSectionLocation, 
        int SectionFlags) {
      // : Decl(Decl), PragmaSectionLocation(PragmaSectionLocation), SectionFlags(SectionFlags) 
      //START JInit
      this.Decl = Decl;
      this.PragmaSectionLocation = new SourceLocation(PragmaSectionLocation);
      this.SectionFlags = SectionFlags;
      //END JInit
    }

    //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::SectionInfo::~SectionInfo">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ASTContext.h", line = 2588,
     FQN="clang::ASTContext::SectionInfo::~SectionInfo", NM="_ZN5clang10ASTContext11SectionInfoD0Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaAttr.cpp -nm=_ZN5clang10ASTContext11SectionInfoD0Ev")
    //</editor-fold>
    public /*inline*/ void $destroy() {
    }

    //<editor-fold defaultstate="collapsed" desc="clang::ASTContext::SectionInfo::operator=">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ASTContext.h", line = 2588,
     FQN="clang::ASTContext::SectionInfo::operator=", NM="_ZN5clang10ASTContext11SectionInfoaSEOS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaAttr.cpp -nm=_ZN5clang10ASTContext11SectionInfoaSEOS1_")
    //</editor-fold>
    public /*inline*/ SectionInfo /*&*/ $assignMove(final SectionInfo /*&&*/$Prm0) {
      this.Decl = $Prm0.Decl;
      this.PragmaSectionLocation.$assignMove($Prm0.PragmaSectionLocation);
      this.SectionFlags = $Prm0.SectionFlags;
      return /*Deref*/this;
    }

    @Override
    public SectionInfo clone() {
      return new SectionInfo(this.Decl, this.PragmaSectionLocation, this.SectionFlags);
    }
    
    @Override public String toString() {
      return "" + "Decl=" + Decl // NOI18N
                + ", PragmaSectionLocation=" + PragmaSectionLocation // NOI18N
                + ", SectionFlags=" + SectionFlags; // NOI18N
    }
  };
  
  public StringMap<SectionInfo> SectionInfos;
  
  @Override public String toString() {
    return "ASTContext "  
//              + "Types=" + Types // NOI18N
//              + ", ExtQualNodes=" + ExtQualNodes // NOI18N
//              + ", ComplexTypes=" + ComplexTypes // NOI18N
//              + ", PointerTypes=" + PointerTypes // NOI18N
//              + ", AdjustedTypes=" + AdjustedTypes // NOI18N
//              + ", BlockPointerTypes=" + BlockPointerTypes // NOI18N
//              + ", LValueReferenceTypes=" + LValueReferenceTypes // NOI18N
//              + ", RValueReferenceTypes=" + RValueReferenceTypes // NOI18N
//              + ", MemberPointerTypes=" + MemberPointerTypes // NOI18N
//              + ", ConstantArrayTypes=" + ConstantArrayTypes // NOI18N
//              + ", IncompleteArrayTypes=" + IncompleteArrayTypes // NOI18N
//              + ", VariableArrayTypes=" + VariableArrayTypes // NOI18N
//              + ", DependentSizedArrayTypes=" + DependentSizedArrayTypes // NOI18N
//              + ", DependentSizedExtVectorTypes=" + DependentSizedExtVectorTypes // NOI18N
//              + ", VectorTypes=" + VectorTypes // NOI18N
//              + ", FunctionNoProtoTypes=" + FunctionNoProtoTypes // NOI18N
//              + ", FunctionProtoTypes=" + "[ContextualFoldingSet$FunctionProtoType$ASTContext]" // NOI18N
//              + ", DependentTypeOfExprTypes=" + DependentTypeOfExprTypes // NOI18N
//              + ", DependentDecltypeTypes=" + DependentDecltypeTypes // NOI18N
//              + ", TemplateTypeParmTypes=" + TemplateTypeParmTypes // NOI18N
//              + ", SubstTemplateTypeParmTypes=" + SubstTemplateTypeParmTypes // NOI18N
//              + ", SubstTemplateTypeParmPackTypes=" + SubstTemplateTypeParmPackTypes // NOI18N
//              + ", TemplateSpecializationTypes=" + "[ContextualFoldingSet$TemplateSpecializationType$ASTContext]" // NOI18N
//              + ", ParenTypes=" + ParenTypes // NOI18N
//              + ", ElaboratedTypes=" + ElaboratedTypes // NOI18N
//              + ", DependentNameTypes=" + DependentNameTypes // NOI18N
//              + ", DependentTemplateSpecializationTypes=" + "[ContextualFoldingSet$DependentTemplateSpecializationType$ASTContext]" // NOI18N
//              + ", PackExpansionTypes=" + PackExpansionTypes // NOI18N
//              + ", ObjCObjectTypes=" + ObjCObjectTypes // NOI18N
//              + ", ObjCObjectPointerTypes=" + ObjCObjectPointerTypes // NOI18N
//              + ", DependentUnaryTransformTypes=" + DependentUnaryTransformTypes // NOI18N
//              + ", AutoTypes=" + AutoTypes // NOI18N
//              + ", AtomicTypes=" + AtomicTypes // NOI18N
//              + ", AttributedTypes=" + AttributedTypes // NOI18N
//              + ", PipeTypes=" + PipeTypes // NOI18N
//              + ", QualifiedTemplateNames=" + QualifiedTemplateNames // NOI18N
//              + ", DependentTemplateNames=" + DependentTemplateNames // NOI18N
//              + ", SubstTemplateTemplateParms=" + SubstTemplateTemplateParms // NOI18N
//              + ", SubstTemplateTemplateParmPacks=" + "[ContextualFoldingSet$SubstTemplateTemplateParmPackStorage$ASTContext]" // NOI18N
//              + ", NestedNameSpecifiers=" + NestedNameSpecifiers // NOI18N
//              + ", GlobalNestedNameSpecifier=" + GlobalNestedNameSpecifier // NOI18N
//              + ", ASTRecordLayouts=" + ASTRecordLayouts // NOI18N
//              + ", ObjCLayouts=" + ObjCLayouts // NOI18N
//              + ", MemoizedTypeInfo=" + MemoizedTypeInfo // NOI18N
//              + ", KeyFunctions=" + KeyFunctions // NOI18N
//              + ", ObjCImpls=" + ObjCImpls // NOI18N
//              + ", ObjCMethodRedecls=" + ObjCMethodRedecls // NOI18N
//              + ", BlockVarCopyInits=" + BlockVarCopyInits // NOI18N
//              + ", ClassScopeSpecializationPattern=" + ClassScopeSpecializationPattern // NOI18N
//              + ", MaterializedTemporaryValues=" + MaterializedTemporaryValues // NOI18N
//              + ", CanonTemplateTemplateParms=" + CanonTemplateTemplateParms // NOI18N
//              + ", Int128Decl=" + Int128Decl // NOI18N
//              + ", UInt128Decl=" + UInt128Decl // NOI18N
//              + ", BuiltinVaListDecl=" + BuiltinVaListDecl // NOI18N
//              + ", BuiltinMSVaListDecl=" + BuiltinMSVaListDecl // NOI18N
//              + ", ObjCIdDecl=" + ObjCIdDecl // NOI18N
//              + ", ObjCSelDecl=" + ObjCSelDecl // NOI18N
//              + ", ObjCClassDecl=" + ObjCClassDecl // NOI18N
//              + ", ObjCProtocolClassDecl=" + ObjCProtocolClassDecl // NOI18N
//              + ", BOOLDecl=" + BOOLDecl // NOI18N
//              + ", ObjCIdRedefinitionType=" + ObjCIdRedefinitionType // NOI18N
//              + ", ObjCClassRedefinitionType=" + ObjCClassRedefinitionType // NOI18N
//              + ", ObjCSelRedefinitionType=" + ObjCSelRedefinitionType // NOI18N
//              + ", BoolName=" + BoolName // NOI18N
//              + ", NSObjectName=" + NSObjectName // NOI18N
//              + ", NSCopyingName=" + NSCopyingName // NOI18N
//              + ", MakeIntegerSeqName=" + MakeIntegerSeqName // NOI18N
//              + ", TypePackElementName=" + TypePackElementName // NOI18N
//              + ", ObjCConstantStringType=" + ObjCConstantStringType // NOI18N
//              + ", CFConstantStringTagDecl=" + CFConstantStringTagDecl // NOI18N
//              + ", CFConstantStringTypeDecl=" + CFConstantStringTypeDecl // NOI18N
//              + ", ObjCSuperType=" + ObjCSuperType // NOI18N
//              + ", ObjCNSStringType=" + ObjCNSStringType // NOI18N
//              + ", ObjCInstanceTypeDecl=" + ObjCInstanceTypeDecl // NOI18N
//              + ", FILEDecl=" + FILEDecl // NOI18N
//              + ", jmp_bufDecl=" + jmp_bufDecl // NOI18N
//              + ", sigjmp_bufDecl=" + sigjmp_bufDecl // NOI18N
//              + ", ucontext_tDecl=" + ucontext_tDecl // NOI18N
//              + ", BlockDescriptorType=" + BlockDescriptorType // NOI18N
//              + ", BlockDescriptorExtendedType=" + BlockDescriptorExtendedType // NOI18N
//              + ", cudaConfigureCallDecl=" + cudaConfigureCallDecl // NOI18N
//              + ", DeclAttrs=" + DeclAttrs // NOI18N
//              + ", MergedDecls=" + MergedDecls // NOI18N
//              + ", MergedDefModules=" + MergedDefModules // NOI18N
//              + ", TemplateOrInstantiation=" + TemplateOrInstantiation // NOI18N
//              + ", InstantiatedFromUsingDecl=" + InstantiatedFromUsingDecl // NOI18N
//              + ", InstantiatedFromUsingShadowDecl=" + InstantiatedFromUsingShadowDecl // NOI18N
//              + ", InstantiatedFromUnnamedFieldDecl=" + InstantiatedFromUnnamedFieldDecl // NOI18N
//              + ", OverriddenMethods=" + OverriddenMethods // NOI18N
//              + ", MangleNumberingContexts=" + "[DenseMap$DeclContext$MangleNumberingContext]" // NOI18N
//              + ", MangleNumbers=" + MangleNumbers // NOI18N
//              + ", StaticLocalNumbers=" + StaticLocalNumbers // NOI18N
//              + ", ParamIndices=" + ParamIndices // NOI18N
//              + ", FirstLocalImport=" + FirstLocalImport // NOI18N
//              + ", LastLocalImport=" + LastLocalImport // NOI18N
//              + ", TUDecl=" + TUDecl // NOI18N
//              + ", ExternCContext=" + ExternCContext // NOI18N
//              + ", MakeIntegerSeqDecl=" + MakeIntegerSeqDecl // NOI18N
//              + ", TypePackElementDecl=" + TypePackElementDecl // NOI18N
//              + ", SourceMgr=" + "[SourceManager]" // NOI18N
//              + ", LangOpts=" + LangOpts // NOI18N
//              + ", SanitizerBL=" + SanitizerBL // NOI18N
//              + ", BumpAlloc=" + "[BumpPtrAllocatorImpl]" // NOI18N
//              + ", DiagAllocator=" + "[StorageAllocator]" // NOI18N
//              + ", ABI=" + ABI // NOI18N
//              + ", AddrSpaceMap=" + AddrSpaceMap // NOI18N
//              + ", AddrSpaceMapMangling=" + AddrSpaceMapMangling // NOI18N
//              + ", Target=" + Target // NOI18N
//              + ", AuxTarget=" + AuxTarget // NOI18N
//              + ", PrintingPolicy=" + PrintingPolicy // NOI18N
//              + ", Idents=" + Idents // NOI18N
//              + ", Selectors=" + Selectors // NOI18N
//              + ", BuiltinInfo=" + "[Context]" // NOI18N
//              + ", DeclarationNames=" + DeclarationNames // NOI18N
//              + ", ExternalSource=" + "[IntrusiveRefCntPtr$ExternalASTSource]" // NOI18N
//              + ", Listener=" + Listener // NOI18N
//              + ", Comments=" + Comments // NOI18N
//              + ", CommentsLoaded=" + CommentsLoaded // NOI18N
//              + ", RedeclComments=" + RedeclComments // NOI18N
//              + ", ParsedComments=" + ParsedComments // NOI18N
//              + ", CommentCommandTraits=" + CommentCommandTraits // NOI18N
//              + ", VoidTy=" + VoidTy // NOI18N
//              + ", BoolTy=" + BoolTy // NOI18N
//              + ", CharTy=" + CharTy // NOI18N
//              + ", WCharTy=" + WCharTy // NOI18N
//              + ", WideCharTy=" + WideCharTy // NOI18N
//              + ", WIntTy=" + WIntTy // NOI18N
//              + ", Char16Ty=" + Char16Ty // NOI18N
//              + ", Char32Ty=" + Char32Ty // NOI18N
//              + ", SignedCharTy=" + SignedCharTy // NOI18N
//              + ", ShortTy=" + ShortTy // NOI18N
//              + ", IntTy=" + IntTy // NOI18N
//              + ", LongTy=" + LongTy // NOI18N
//              + ", LongLongTy=" + LongLongTy // NOI18N
//              + ", Int128Ty=" + Int128Ty // NOI18N
//              + ", UnsignedCharTy=" + UnsignedCharTy // NOI18N
//              + ", UnsignedShortTy=" + UnsignedShortTy // NOI18N
//              + ", UnsignedIntTy=" + UnsignedIntTy // NOI18N
//              + ", UnsignedLongTy=" + UnsignedLongTy // NOI18N
//              + ", UnsignedLongLongTy=" + UnsignedLongLongTy // NOI18N
//              + ", UnsignedInt128Ty=" + UnsignedInt128Ty // NOI18N
//              + ", FloatTy=" + FloatTy // NOI18N
//              + ", DoubleTy=" + DoubleTy // NOI18N
//              + ", LongDoubleTy=" + LongDoubleTy // NOI18N
//              + ", Float128Ty=" + Float128Ty // NOI18N
//              + ", HalfTy=" + HalfTy // NOI18N
//              + ", FloatComplexTy=" + FloatComplexTy // NOI18N
//              + ", DoubleComplexTy=" + DoubleComplexTy // NOI18N
//              + ", LongDoubleComplexTy=" + LongDoubleComplexTy // NOI18N
//              + ", Float128ComplexTy=" + Float128ComplexTy // NOI18N
//              + ", VoidPtrTy=" + VoidPtrTy // NOI18N
//              + ", NullPtrTy=" + NullPtrTy // NOI18N
//              + ", DependentTy=" + DependentTy // NOI18N
//              + ", OverloadTy=" + OverloadTy // NOI18N
//              + ", BoundMemberTy=" + BoundMemberTy // NOI18N
//              + ", UnknownAnyTy=" + UnknownAnyTy // NOI18N
//              + ", BuiltinFnTy=" + BuiltinFnTy // NOI18N
//              + ", PseudoObjectTy=" + PseudoObjectTy // NOI18N
//              + ", ARCUnbridgedCastTy=" + ARCUnbridgedCastTy // NOI18N
//              + ", ObjCBuiltinIdTy=" + ObjCBuiltinIdTy // NOI18N
//              + ", ObjCBuiltinClassTy=" + ObjCBuiltinClassTy // NOI18N
//              + ", ObjCBuiltinSelTy=" + ObjCBuiltinSelTy // NOI18N
//              + ", ObjCBuiltinBoolTy=" + ObjCBuiltinBoolTy // NOI18N
//              + ", OCLImage1dROTy=" + OCLImage1dROTy // NOI18N
//              + ", OCLImage1dArrayROTy=" + OCLImage1dArrayROTy // NOI18N
//              + ", OCLImage1dBufferROTy=" + OCLImage1dBufferROTy // NOI18N
//              + ", OCLImage2dROTy=" + OCLImage2dROTy // NOI18N
//              + ", OCLImage2dArrayROTy=" + OCLImage2dArrayROTy // NOI18N
//              + ", OCLImage2dDepthROTy=" + OCLImage2dDepthROTy // NOI18N
//              + ", OCLImage2dArrayDepthROTy=" + OCLImage2dArrayDepthROTy // NOI18N
//              + ", OCLImage2dMSAAROTy=" + OCLImage2dMSAAROTy // NOI18N
//              + ", OCLImage2dArrayMSAAROTy=" + OCLImage2dArrayMSAAROTy // NOI18N
//              + ", OCLImage2dMSAADepthROTy=" + OCLImage2dMSAADepthROTy // NOI18N
//              + ", OCLImage2dArrayMSAADepthROTy=" + OCLImage2dArrayMSAADepthROTy // NOI18N
//              + ", OCLImage3dROTy=" + OCLImage3dROTy // NOI18N
//              + ", OCLImage1dWOTy=" + OCLImage1dWOTy // NOI18N
//              + ", OCLImage1dArrayWOTy=" + OCLImage1dArrayWOTy // NOI18N
//              + ", OCLImage1dBufferWOTy=" + OCLImage1dBufferWOTy // NOI18N
//              + ", OCLImage2dWOTy=" + OCLImage2dWOTy // NOI18N
//              + ", OCLImage2dArrayWOTy=" + OCLImage2dArrayWOTy // NOI18N
//              + ", OCLImage2dDepthWOTy=" + OCLImage2dDepthWOTy // NOI18N
//              + ", OCLImage2dArrayDepthWOTy=" + OCLImage2dArrayDepthWOTy // NOI18N
//              + ", OCLImage2dMSAAWOTy=" + OCLImage2dMSAAWOTy // NOI18N
//              + ", OCLImage2dArrayMSAAWOTy=" + OCLImage2dArrayMSAAWOTy // NOI18N
//              + ", OCLImage2dMSAADepthWOTy=" + OCLImage2dMSAADepthWOTy // NOI18N
//              + ", OCLImage2dArrayMSAADepthWOTy=" + OCLImage2dArrayMSAADepthWOTy // NOI18N
//              + ", OCLImage3dWOTy=" + OCLImage3dWOTy // NOI18N
//              + ", OCLImage1dRWTy=" + OCLImage1dRWTy // NOI18N
//              + ", OCLImage1dArrayRWTy=" + OCLImage1dArrayRWTy // NOI18N
//              + ", OCLImage1dBufferRWTy=" + OCLImage1dBufferRWTy // NOI18N
//              + ", OCLImage2dRWTy=" + OCLImage2dRWTy // NOI18N
//              + ", OCLImage2dArrayRWTy=" + OCLImage2dArrayRWTy // NOI18N
//              + ", OCLImage2dDepthRWTy=" + OCLImage2dDepthRWTy // NOI18N
//              + ", OCLImage2dArrayDepthRWTy=" + OCLImage2dArrayDepthRWTy // NOI18N
//              + ", OCLImage2dMSAARWTy=" + OCLImage2dMSAARWTy // NOI18N
//              + ", OCLImage2dArrayMSAARWTy=" + OCLImage2dArrayMSAARWTy // NOI18N
//              + ", OCLImage2dMSAADepthRWTy=" + OCLImage2dMSAADepthRWTy // NOI18N
//              + ", OCLImage2dArrayMSAADepthRWTy=" + OCLImage2dArrayMSAADepthRWTy // NOI18N
//              + ", OCLImage3dRWTy=" + OCLImage3dRWTy // NOI18N
//              + ", OCLSamplerTy=" + OCLSamplerTy // NOI18N
//              + ", OCLEventTy=" + OCLEventTy // NOI18N
//              + ", OCLClkEventTy=" + OCLClkEventTy // NOI18N
//              + ", OCLQueueTy=" + OCLQueueTy // NOI18N
//              + ", OCLNDRangeTy=" + OCLNDRangeTy // NOI18N
//              + ", OCLReserveIDTy=" + OCLReserveIDTy // NOI18N
//              + ", OMPArraySectionTy=" + OMPArraySectionTy // NOI18N
//              + ", AutoDeductTy=" + AutoDeductTy // NOI18N
//              + ", AutoRRefDeductTy=" + AutoRRefDeductTy // NOI18N
//              + ", VaListTagDecl=" + VaListTagDecl // NOI18N
//              + ", Deallocations=" + Deallocations // NOI18N
//              + ", LastSDM=" + LastSDM // NOI18N
//              + ", PointerParents=" + PointerParents // NOI18N
//              + ", OtherParents=" + OtherParents // NOI18N
//              + ", VTContext=" + VTContext // NOI18N
//              + ", SectionInfos=" + SectionInfos // NOI18N
              + super.toString(); // NOI18N
  }
  
  public static final class ParentMapPointers extends 
          DenseMap</*const*/Object/*void P*/ , 
                   PointerUnion4</*const*/ Decl /*P*/ , /*const*/ Stmt /*P*/ , DynTypedNode /*P*/ , SmallVector<DynTypedNode> /*P*/>
                  > {
    public ParentMapPointers() {
      super(DenseMapInfo$LikePtr.$Info(), new PointerUnion4</*const*/ Decl /*P*/ , /*const*/ Stmt /*P*/ , DynTypedNode /*P*/ , SmallVector<DynTypedNode> /*P*/>(Decl.class));
    }
  }
  
  public static final class ParentMapOtherNodes extends 
           DenseMap<DynTypedNode,               
                    PointerUnion4</*const*/ Decl /*P*/ , /*const*/ Stmt /*P*/ , DynTypedNode /*P*/ , SmallVector<DynTypedNode> /*P*/>
                   > {
    public ParentMapOtherNodes() {
      super(DenseMapInfoDynTypedNode.$Info(), new PointerUnion4</*const*/ Decl /*P*/ , /*const*/ Stmt /*P*/ , DynTypedNode /*P*/ , SmallVector<DynTypedNode> /*P*/>(Decl.class));
    }
  }
}
