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

package org.llvm.ir.impl;

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.llvm.adt.*;
import org.llvm.adt.ADTFunctionPointers.SMDiagnosticHandler;
import org.llvm.adt.aliases.*;
import org.llvm.ir.*;
import org.llvm.ir.java.IRFunctionPointers.DiagnosticInfoHandler;
import org.llvm.ir.java.IRFunctionPointers.YieldCallbackTy;
import org.llvm.support.*;
import static org.llvm.support.llvm.*;

//<editor-fold defaultstate="collapsed" desc="llvm::LLVMContextImpl">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/LLVMContextImpl.h", line = 1034,
 FQN="llvm::LLVMContextImpl", NM="_ZN4llvm15LLVMContextImplE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/LLVMContextImpl.cpp -nm=_ZN4llvm15LLVMContextImplE")
//</editor-fold>
public class LLVMContextImpl implements Destructors.ClassWithDestructor {
/*public:*/
  /// OwnedModules - The set of modules instantiated in this context, and which
  /// will be automatically deleted if this context is deleted.
  public SmallPtrSet<Module /*P*/ > OwnedModules;
  
  public SMDiagnosticHandler InlineAsmDiagHandler;
  public Object/*void P*/ InlineAsmDiagContext;
  
  public DiagnosticInfoHandler DiagnosticHandler;
  public Object/*void P*/ DiagnosticContext;
  public boolean RespectDiagnosticFilters;
  public boolean DiagnosticHotnessRequested;
  
  public YieldCallbackTy YieldCallback;
  public Object/*void P*/ YieldOpaqueHandle;
  
  // JAVA: typedef DenseMap<APInt, ConstantInt *, DenseMapAPIntKeyInfo> IntMapTy
//  public final class IntMapTy extends DenseMap<APInt, ConstantInt /*P*/ >{ };
  public DenseMap<APInt, ConstantInt /*P*/ > IntConstants;
  
  // JAVA: typedef DenseMap<APFloat, ConstantFP *, DenseMapAPFloatKeyInfo> FPMapTy
//  public final class FPMapTy extends DenseMap<APFloat, ConstantFP /*P*/ >{ };
  public DenseMap<APFloat, ConstantFP /*P*/ > FPConstants;
  
  public FoldingSet<AttributeImpl> AttrsSet;
  public FoldingSet<AttributeSetImpl> AttrsLists;
  public FoldingSet<AttributeSetNode> AttrsSetNodes;
  
  public StringMap<MDString/*, BumpPtrAllocatorImpl*/> MDStringCache;
  public DenseMap<Value /*P*/ , ValueAsMetadata /*P*/ > ValuesAsMetadata;
  public DenseMap<Metadata /*P*/ , MetadataAsValue /*P*/ > MetadataAsValues;
  
  public DenseMap</*const*/ Value /*P*/ , StringMapEntry<Value /*P*/ > /*P*/ > ValueNames;
  public DenseSet<MDTuple /*P*/ > MDTuples;
  public DenseSet<DILocation /*P*/ > DILocations;
  public DenseSet<DIExpression /*P*/ > DIExpressions;
  public DenseSet<GenericDINode /*P*/ > GenericDINodes;
  public DenseSet<DISubrange /*P*/ > DISubranges;
  public DenseSet<DIEnumerator /*P*/ > DIEnumerators;
  public DenseSet<DIBasicType /*P*/ > DIBasicTypes;
  public DenseSet<DIDerivedType /*P*/ > DIDerivedTypes;
  public DenseSet<DICompositeType /*P*/ > DICompositeTypes;
  public DenseSet<DISubroutineType /*P*/ > DISubroutineTypes;
  public DenseSet<DIFile /*P*/ > DIFiles;
  public DenseSet<DISubprogram /*P*/ > DISubprograms;
  public DenseSet<DILexicalBlock /*P*/ > DILexicalBlocks;
  public DenseSet<DILexicalBlockFile /*P*/ > DILexicalBlockFiles;
  public DenseSet<DINamespace /*P*/ > DINamespaces;
  public DenseSet<DIModule /*P*/ > DIModules;
  public DenseSet<DITemplateTypeParameter /*P*/ > DITemplateTypeParameters;
  public DenseSet<DITemplateValueParameter /*P*/ > DITemplateValueParameters;
  public DenseSet<DIGlobalVariable /*P*/ > DIGlobalVariables;
  public DenseSet<DILocalVariable /*P*/ > DILocalVariables;
  public DenseSet<DIObjCProperty /*P*/ > DIObjCPropertys;
  public DenseSet<DIImportedEntity /*P*/ > DIImportedEntitys;
  public DenseSet<DIMacro /*P*/ > DIMacros;
  public DenseSet<DIMacroFile /*P*/ > DIMacroFiles;
  
  // Optional map for looking up composite types by identifier.
  public Optional<DenseMap</*const*/ MDString /*P*/ , DICompositeType /*P*/ > > DITypeMap;
  
  // MDNodes may be uniqued or not uniqued.  When they're not uniqued, they
  // aren't in the MDNodeSet, but they're still shared between objects, so no
  // one object can destroy them.  Keep track of them here so we can delete
  // them on context teardown.
  public std.vector<MDNode /*P*/ > DistinctMDNodes;
  
  public DenseMap<Type /*P*/ , ConstantAggregateZero /*P*/ > CAZConstants;
  
  // JAVA: typedef ConstantUniqueMap<ConstantArray> ArrayConstantsTy
//  public final class ArrayConstantsTy extends ConstantUniqueMap<ConstantArray>{ };
  public ConstantUniqueMapConstantArray ArrayConstants;
  
  // JAVA: typedef ConstantUniqueMap<ConstantStruct> StructConstantsTy
//  public final class StructConstantsTy extends ConstantUniqueMap<ConstantStruct>{ };
  public ConstantUniqueMapConstantStruct StructConstants;
  
  // JAVA: typedef ConstantUniqueMap<ConstantVector> VectorConstantsTy
//  public final class VectorConstantsTy extends ConstantUniqueMap<ConstantVector>{ };
  public ConstantUniqueMapConstantVector VectorConstants;
  
  public DenseMap<PointerType /*P*/ , ConstantPointerNull /*P*/ > CPNConstants;
  
  public DenseMap<Type /*P*/ , UndefValue /*P*/ > UVConstants;
  
  public StringMap<ConstantDataSequential /*P*/ > CDSConstants;
  
  public DenseMap<std.pair</*const*/ Function /*P*/ , /*const*/ BasicBlock /*P*/ >, BlockAddress /*P*/ > BlockAddresses;
  public ConstantUniqueMapConstantExpr ExprConstants;
  
  public ConstantUniqueMapInlineAsm InlineAsms;
  
  public ConstantInt /*P*/ TheTrueVal;
  public ConstantInt /*P*/ TheFalseVal;
  
  public std.unique_ptr<ConstantTokenNone> TheNoneToken;
  
  // Basic type instances.
  public Type VoidTy;
  public Type LabelTy;
  public Type HalfTy;
  public Type FloatTy;
  public Type DoubleTy;
  public Type MetadataTy;
  public Type TokenTy;
  public Type X86_FP80Ty;
  public Type FP128Ty;
  public Type PPC_FP128Ty;
  public Type X86_MMXTy;
  public IntegerType Int1Ty;
  public IntegerType Int8Ty;
  public IntegerType Int16Ty;
  public IntegerType Int32Ty;
  public IntegerType Int64Ty;
  public IntegerType Int128Ty;
  
  /// TypeAllocator - All dynamically allocated types are allocated from this.
  /// They live forever until the context is torn down.
  public BumpPtrAllocatorImpl TypeAllocator;
  
  public DenseMapUIntType<IntegerType /*P*/ > IntegerTypes;
  
  // JAVA: typedef DenseSet<FunctionType *, FunctionTypeKeyInfo> FunctionTypeSet
//  public final class FunctionTypeSet extends DenseSet<FunctionType /*P*/ >{ };
  public DenseSet<FunctionType /*P*/ > FunctionTypes;
  // JAVA: typedef DenseSet<StructType *, AnonStructTypeKeyInfo> StructTypeSet
//  public final class StructTypeSet extends DenseSet<StructType /*P*/ >{ };
  public DenseSet<StructType /*P*/ > AnonStructTypes;
  public StringMap<StructType /*P*/ > NamedStructTypes;
  public /*uint*/int NamedStructTypesUniqueID;
  
  public DenseMap<std.pairTypeULong<Type /*P*/ >, ArrayType /*P*/ > ArrayTypes;
  public DenseMap<std.pairTypeUInt<Type /*P*/ >, VectorType /*P*/ > VectorTypes;
  public DenseMap<Type /*P*/ , PointerType /*P*/ > PointerTypes; // Pointers in AddrSpace = 0
  public DenseMap<std.pairTypeUInt<Type /*P*/ >, PointerType /*P*/ > ASPointerTypes;
  
  /// ValueHandles - This map keeps track of all of the value handles that are
  /// watching a Value*.  The Value::HasValueHandle bit is used to know
  /// whether or not a value has an entry in this map.
  // JAVA: typedef DenseMap<Value *, ValueHandleBase *> ValueHandlesTy
//  public final class ValueHandlesTy extends DenseMap<Value /*P*/ , ValueHandleBase /*P*/ >{ };
  public DenseMap<Value /*P*/ , ValueHandleBase /*P*/ > ValueHandles;
  
  /// CustomMDKindNames - Map to hold the metadata string to ID mapping.
  public StringMapUInt CustomMDKindNames;
  
  /// Collection of per-instruction metadata used in this context.
  public DenseMap</*const*/ Instruction /*P*/ , MDAttachmentMap> InstructionMetadata;
  
  /// Collection of per-GlobalObject metadata used in this context.
  public DenseMap</*const*/ GlobalObject /*P*/ , MDGlobalAttachmentMap> GlobalObjectMetadata;
  
  /// DiscriminatorTable - This table maps file:line locations to an
  /// integer representing the next DWARF path discriminator to assign to
  /// instructions in different blocks at the same location.
  public DenseMapTypeUInt<std.pairTypeUInt</*const*/char$ptr/*char P*/>> DiscriminatorTable;
  
  //<editor-fold defaultstate="collapsed" desc="llvm::LLVMContextImpl::getOrAddScopeRecordIdxEntry">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/LLVMContextImpl.h", line = 1153,
   FQN="llvm::LLVMContextImpl::getOrAddScopeRecordIdxEntry", NM="_ZN4llvm15LLVMContextImpl27getOrAddScopeRecordIdxEntryEPNS_6MDNodeEi",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/LLVMContextImpl.cpp -nm=_ZN4llvm15LLVMContextImpl27getOrAddScopeRecordIdxEntryEPNS_6MDNodeEi")
  //</editor-fold>
  public int getOrAddScopeRecordIdxEntry(MDNode /*P*/ N, int ExistingIdx) {
    throw new UnsupportedOperationException("<<<DeclJavaPrinter::VisitFunctionDecl NULL BODY IN USED Translation Unit>>>");
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::LLVMContextImpl::getOrAddScopeInlinedAtIdxEntry">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/LLVMContextImpl.h", line = 1154,
   FQN="llvm::LLVMContextImpl::getOrAddScopeInlinedAtIdxEntry", NM="_ZN4llvm15LLVMContextImpl30getOrAddScopeInlinedAtIdxEntryEPNS_6MDNodeES2_i",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/LLVMContextImpl.cpp -nm=_ZN4llvm15LLVMContextImpl30getOrAddScopeInlinedAtIdxEntryEPNS_6MDNodeES2_i")
  //</editor-fold>
  public int getOrAddScopeInlinedAtIdxEntry(MDNode /*P*/ Scope, MDNode /*P*/ IA, int ExistingIdx) {
    throw new UnsupportedOperationException("<<<DeclJavaPrinter::VisitFunctionDecl NULL BODY IN USED Translation Unit>>>");
  }


  
  /// \brief A set of interned tags for operand bundles.  The StringMap maps
  /// bundle tags to their IDs.
  ///
  /// \see LLVMContext::getOperandBundleTagID
  public StringMapUInt BundleTagCache;
  
  //<editor-fold defaultstate="collapsed" desc="llvm::LLVMContextImpl::getOrInsertBundleTag">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/LLVMContextImpl.cpp", line = 199,
   FQN="llvm::LLVMContextImpl::getOrInsertBundleTag", NM="_ZN4llvm15LLVMContextImpl20getOrInsertBundleTagENS_9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/LLVMContextImpl.cpp -nm=_ZN4llvm15LLVMContextImpl20getOrInsertBundleTagENS_9StringRefE")
  //</editor-fold>
  public StringMapEntryUInt /*P*/ getOrInsertBundleTag(StringRef Tag) {
    /*uint32_t*/int NewIdx = BundleTagCache.size();
    return /*AddrOf*/(BundleTagCache.insert(std.make_pair_T_uint(Tag, NewIdx)).first).$star();
  }
  
  //<editor-fold defaultstate="collapsed" desc="llvm::LLVMContextImpl::getOperandBundleTags">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/LLVMContextImpl.cpp", line = 204,
   FQN="llvm::LLVMContextImpl::getOperandBundleTags", NM="_ZNK4llvm15LLVMContextImpl20getOperandBundleTagsERNS_15SmallVectorImplINS_9StringRefEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/LLVMContextImpl.cpp -nm=_ZNK4llvm15LLVMContextImpl20getOperandBundleTagsERNS_15SmallVectorImplINS_9StringRefEEE")
  //</editor-fold>
  public void getOperandBundleTags(final SmallVectorImpl<StringRef> /*&*/ Tags) /*const*/ {
    Tags.resize(BundleTagCache.size());
    for (final /*const*/StringMapEntryUInt/*&*/ T : BundleTagCache)  {
      Tags.$at(T.second).$assignMove(T.first());
    }
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::LLVMContextImpl::getOperandBundleTagID">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/LLVMContextImpl.cpp", line = 210,
   FQN="llvm::LLVMContextImpl::getOperandBundleTagID", NM="_ZNK4llvm15LLVMContextImpl21getOperandBundleTagIDENS_9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/LLVMContextImpl.cpp -nm=_ZNK4llvm15LLVMContextImpl21getOperandBundleTagIDENS_9StringRefE")
  //</editor-fold>
  public /*uint32_t*/int getOperandBundleTagID(StringRef Tag) /*const*/ {
    StringMapIteratorUInt I = BundleTagCache.find$Const(/*NO_COPY*/Tag);
    assert (I.$noteq(BundleTagCache.end$Const())) : "Unknown tag!";
    return I.$arrow().second;
  }

  
  /// Maintain the GC name for each function.
  ///
  /// This saves allocating an additional word in Function for programs which
  /// do not use GC (i.e., most programs) at the cost of increased overhead for
  /// clients which do use GC.
  public DenseMap</*const*/ Function /*P*/ , std.string> GCNames;
  
  /// Flag to indicate if Value (other than GlobalValue) retains their name or
  /// not.
  public boolean DiscardValueNames/* = false*/;
  
  //<editor-fold defaultstate="collapsed" desc="llvm::LLVMContextImpl::LLVMContextImpl">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/lib/IR/LLVMContextImpl.cpp", line = 24,
   FQN="llvm::LLVMContextImpl::LLVMContextImpl", NM="_ZN4llvm15LLVMContextImplC1ERNS_11LLVMContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/LLVMContextImpl.cpp -nm=_ZN4llvm15LLVMContextImplC1ERNS_11LLVMContextE")
  //</editor-fold>
  public LLVMContextImpl(final LLVMContext /*&*/ C) {
    // : OwnedModules(), IntConstants(), FPConstants(), AttrsSet(), AttrsLists(), AttrsSetNodes(), MDStringCache(), ValuesAsMetadata(), MetadataAsValues(), ValueNames(), MDTuples(), DILocations(), DIExpressions(), GenericDINodes(), DISubranges(), DIEnumerators(), DIBasicTypes(), DIDerivedTypes(), DICompositeTypes(), DISubroutineTypes(), DIFiles(), DISubprograms(), DILexicalBlocks(), DILexicalBlockFiles(), DINamespaces(), DIModules(), DITemplateTypeParameters(), DITemplateValueParameters(), DIGlobalVariables(), DILocalVariables(), DIObjCPropertys(), DIImportedEntitys(), DIMacros(), DIMacroFiles(), DITypeMap(), DistinctMDNodes(), CAZConstants(), ArrayConstants(), StructConstants(), VectorConstants(), CPNConstants(), UVConstants(), CDSConstants(), BlockAddresses(), ExprConstants(), InlineAsms(), TheTrueVal(null), TheFalseVal(null), TheNoneToken(), VoidTy(C, Type::VoidTyID), LabelTy(C, Type::LabelTyID), HalfTy(C, Type::HalfTyID), FloatTy(C, Type::FloatTyID), DoubleTy(C, Type::DoubleTyID), MetadataTy(C, Type::MetadataTyID), TokenTy(C, Type::TokenTyID), X86_FP80Ty(C, Type::X86_FP80TyID), FP128Ty(C, Type::FP128TyID), PPC_FP128Ty(C, Type::PPC_FP128TyID), X86_MMXTy(C, Type::X86_MMXTyID), Int1Ty(C, 1), Int8Ty(C, 8), Int16Ty(C, 16), Int32Ty(C, 32), Int64Ty(C, 64), Int128Ty(C, 128), TypeAllocator(), IntegerTypes(), FunctionTypes(), AnonStructTypes(), NamedStructTypes(), ArrayTypes(), VectorTypes(), PointerTypes(), ASPointerTypes(), ValueHandles(), CustomMDKindNames(), InstructionMetadata(), GlobalObjectMetadata(), DiscriminatorTable(), BundleTagCache(), GCNames(), DiscardValueNames(false) 
    //START JInit
    this.OwnedModules = new SmallPtrSet<Module /*P*/ >(DenseMapInfo$LikePtr.$Info(), 4);
    this.IntConstants = new DenseMap<APInt, ConstantInt /*P*/ >(DenseMapAPIntKeyInfo.$Info(), (ConstantInt /*P*/ )null);
    this.FPConstants = new DenseMap<APFloat, ConstantFP /*P*/ >(DenseMapAPFloatKeyInfo.$Info(), (ConstantFP /*P*/ )null);
    this.AttrsSet = new FoldingSet<AttributeImpl>(AttributeImpl.$Trait());
    this.AttrsLists = new FoldingSet<AttributeSetImpl>(AttributeSetImpl.$Trait());
    this.AttrsSetNodes = new FoldingSet<AttributeSetNode>(AttributeSetNode.$Trait());
    this.MDStringCache = new StringMap<MDString/*, BumpPtrAllocatorImpl*/>(MDString.$Empty());
    this.ValuesAsMetadata = new DenseMap<Value /*P*/ , ValueAsMetadata /*P*/ >(DenseMapInfo$LikePtr.$Info(), (ValueAsMetadata /*P*/ )null);
    this.MetadataAsValues = new DenseMap<Metadata /*P*/ , MetadataAsValue /*P*/ >(DenseMapInfo$LikePtr.$Info(), (MetadataAsValue /*P*/ )null);
    this.ValueNames = new DenseMap</*const*/ Value /*P*/ , StringMapEntry<Value /*P*/ > /*P*/ >(DenseMapInfo$LikePtr.$Info(), (StringMapEntry<Value /*P*/ > /*P*/ )null);
    this.MDTuples = new DenseSet<MDTuple /*P*/ >(MDNodeInfo.$Info$MDTuple());
    this.DILocations = new DenseSet<DILocation /*P*/ >(MDNodeInfo.$Info$DILocation());
    this.DIExpressions = new DenseSet<DIExpression /*P*/ >(MDNodeInfo.$Info$DIExpression());
    this.GenericDINodes = new DenseSet<GenericDINode /*P*/ >(MDNodeInfo.$Info$GenericDINode());
    this.DISubranges = new DenseSet<DISubrange /*P*/ >(MDNodeInfo.$Info$DISubrange());
    this.DIEnumerators = new DenseSet<DIEnumerator /*P*/ >(MDNodeInfo.$Info$DIEnumerator());
    this.DIBasicTypes = new DenseSet<DIBasicType /*P*/ >(MDNodeInfo.$Info$DIBasicType());
    this.DIDerivedTypes = new DenseSet<DIDerivedType /*P*/ >(MDNodeInfo.$Info$DIDerivedType());
    this.DICompositeTypes = new DenseSet<DICompositeType /*P*/ >(MDNodeInfo.$Info$DICompositeType());
    this.DISubroutineTypes = new DenseSet<DISubroutineType /*P*/ >(MDNodeInfo.$Info$DISubroutineType());
    this.DIFiles = new DenseSet<DIFile /*P*/ >(MDNodeInfo.$Info$DIFile());
    this.DISubprograms = new DenseSet<DISubprogram /*P*/ >(MDNodeInfo.$Info$DISubprogram());
    this.DILexicalBlocks = new DenseSet<DILexicalBlock /*P*/ >(MDNodeInfo.$Info$DILexicalBlock());
    this.DILexicalBlockFiles = new DenseSet<DILexicalBlockFile /*P*/ >(MDNodeInfo.$Info$DILexicalBlockFile());
    this.DINamespaces = new DenseSet<DINamespace /*P*/ >(MDNodeInfo.$Info$DINamespace());
    this.DIModules = new DenseSet<DIModule /*P*/ >(MDNodeInfo.$Info$DIModule());
    this.DITemplateTypeParameters = new DenseSet<DITemplateTypeParameter /*P*/ >(MDNodeInfo.$Info$DITemplateTypeParameter());
    this.DITemplateValueParameters = new DenseSet<DITemplateValueParameter /*P*/ >(MDNodeInfo.$Info$DITemplateValueParameter());
    this.DIGlobalVariables = new DenseSet<DIGlobalVariable /*P*/ >(MDNodeInfo.$Info$DIGlobalVariable());
    this.DILocalVariables = new DenseSet<DILocalVariable /*P*/ >(MDNodeInfo.$Info$DILocalVariable());
    this.DIObjCPropertys = new DenseSet<DIObjCProperty /*P*/ >(MDNodeInfo.$Info$DIObjCProperty());
    this.DIImportedEntitys = new DenseSet<DIImportedEntity /*P*/ >(MDNodeInfo.$Info$DIImportedEntity());
    this.DIMacros = new DenseSet<DIMacro /*P*/ >(MDNodeInfo.$Info$DIMacro());
    this.DIMacroFiles = new DenseSet<DIMacroFile /*P*/ >(MDNodeInfo.$Info$DIMacroFile());
    this.DITypeMap = new Optional<DenseMap</*const*/ MDString /*P*/ , DICompositeType /*P*/ > >();
    this.DistinctMDNodes = new std.vector<MDNode /*P*/ >((MDNode /*P*/ )null);
    this.CAZConstants = new DenseMap<Type /*P*/ , ConstantAggregateZero /*P*/ >(DenseMapInfo$LikePtr.$Info(), (ConstantAggregateZero /*P*/ )null);
    this.ArrayConstants = new ConstantUniqueMapConstantArray();
    this.StructConstants = new ConstantUniqueMapConstantStruct();
    this.VectorConstants = new ConstantUniqueMapConstantVector();
    this.CPNConstants = new DenseMap<PointerType /*P*/ , ConstantPointerNull /*P*/ >(DenseMapInfo$LikePtr.$Info(), (ConstantPointerNull /*P*/ )null);
    this.UVConstants = new DenseMap<Type /*P*/ , UndefValue /*P*/ >(DenseMapInfo$LikePtr.$Info(), (UndefValue /*P*/ )null);
    this.CDSConstants = new StringMap<ConstantDataSequential /*P*/ >((ConstantDataSequential /*P*/ )null);
    this.BlockAddresses = new DenseMap<std.pair</*const*/ Function /*P*/ , /*const*/ BasicBlock /*P*/ >, BlockAddress /*P*/ >(
            new DenseMapInfoPair</*const*/ Function /*P*/ , /*const*/ BasicBlock /*P*/ >(
                    DenseMapInfo$LikePtr.$Info(), DenseMapInfo$LikePtr.$Info()), (BlockAddress /*P*/ )null);
    this.ExprConstants = new ConstantUniqueMapConstantExpr();
    this.InlineAsms = new ConstantUniqueMapInlineAsm();
    this.TheTrueVal = null;
    this.TheFalseVal = null;
    this.TheNoneToken = new std.unique_ptr<ConstantTokenNone>();
    this.VoidTy = new Type(C, Type.TypeID.VoidTyID);
    this.LabelTy = new Type(C, Type.TypeID.LabelTyID);
    this.HalfTy = new Type(C, Type.TypeID.HalfTyID);
    this.FloatTy = new Type(C, Type.TypeID.FloatTyID);
    this.DoubleTy = new Type(C, Type.TypeID.DoubleTyID);
    this.MetadataTy = new Type(C, Type.TypeID.MetadataTyID);
    this.TokenTy = new Type(C, Type.TypeID.TokenTyID);
    this.X86_FP80Ty = new Type(C, Type.TypeID.X86_FP80TyID);
    this.FP128Ty = new Type(C, Type.TypeID.FP128TyID);
    this.PPC_FP128Ty = new Type(C, Type.TypeID.PPC_FP128TyID);
    this.X86_MMXTy = new Type(C, Type.TypeID.X86_MMXTyID);
    this.Int1Ty = new IntegerType(C, 1);
    this.Int8Ty = new IntegerType(C, 8);
    this.Int16Ty = new IntegerType(C, 16);
    this.Int32Ty = new IntegerType(C, 32);
    this.Int64Ty = new IntegerType(C, 64);
    this.Int128Ty = new IntegerType(C, 128);
    this.TypeAllocator = new BumpPtrAllocatorImpl();
    this.IntegerTypes = new DenseMapUIntType<IntegerType /*P*/ >(DenseMapInfoUInt.$Info(), (IntegerType /*P*/ )null);
    this.FunctionTypes = new DenseSet<FunctionType /*P*/ >(FunctionTypeKeyInfo.$Info());
    this.AnonStructTypes = new DenseSet<StructType /*P*/ >(AnonStructTypeKeyInfo.$Info());
    this.NamedStructTypes = new StringMap<StructType /*P*/ >((StructType /*P*/ )null);
    this.ArrayTypes = new DenseMap<std.pairTypeULong<Type /*P*/ >, ArrayType /*P*/ >(DenseMapInfoPairTypePtrULong.$Info(), (ArrayType /*P*/ )null);
    this.VectorTypes = new DenseMap<std.pairTypeUInt<Type /*P*/ >, VectorType /*P*/ >(DenseMapInfoPairTypePtrUInt.$Info(), (VectorType /*P*/ )null);
    this.PointerTypes = new DenseMap<Type /*P*/ , PointerType /*P*/ >(DenseMapInfo$LikePtr.$Info(), (PointerType /*P*/ )null);
    this.ASPointerTypes = new DenseMap<std.pairTypeUInt<Type /*P*/ >, PointerType /*P*/ >(DenseMapInfoPairTypePtrUInt.$Info(), (PointerType /*P*/ )null);
    this.ValueHandles = new DenseMap<Value /*P*/ , ValueHandleBase /*P*/ >(DenseMapInfo$LikePtr.$Info(), (ValueHandleBase /*P*/ )null);
    this.CustomMDKindNames = new StringMapUInt((/*uint*/int)0);
    this.InstructionMetadata = new DenseMap</*const*/ Instruction /*P*/ , MDAttachmentMap>(DenseMapInfo$LikePtr.$Info(), new MDAttachmentMap());
    this.GlobalObjectMetadata = new DenseMap</*const*/ GlobalObject /*P*/ , MDGlobalAttachmentMap>(DenseMapInfo$LikePtr.$Info(), new MDGlobalAttachmentMap());
    this.DiscriminatorTable = new DenseMapTypeUInt<std.pairTypeUInt</*const*/char$ptr/*char P*/>>(DenseMapInfoPairTypePtrUInt.$Info(), 0);
    this.BundleTagCache = new StringMapUInt((/*uint32_t*/int)0);
    this.GCNames = new DenseMap</*const*/ Function /*P*/ , std.string>(DenseMapInfo$LikePtr.$Info(), new std.string());
    /*InClass*/this.DiscardValueNames = false;
    //END JInit
    InlineAsmDiagHandler = null;
    InlineAsmDiagContext = null;
    DiagnosticHandler = null;
    DiagnosticContext = null;
    RespectDiagnosticFilters = false;
    DiagnosticHotnessRequested = false;
    YieldCallback = null;
    YieldOpaqueHandle = null;
    NamedStructTypesUniqueID = 0;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::LLVMContextImpl::~LLVMContextImpl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/LLVMContextImpl.cpp", line = 54,
   FQN="llvm::LLVMContextImpl::~LLVMContextImpl", NM="_ZN4llvm15LLVMContextImplD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/LLVMContextImpl.cpp -nm=_ZN4llvm15LLVMContextImplD0Ev")
  //</editor-fold>
  public void $destroy() {
    // NOTE: We need to delete the contents of OwnedModules, but Module's dtor
    // will call LLVMContextImpl::removeModule, thus invalidating iterators into
    // the container. Avoid iterators during this operation:
    while (!OwnedModules.empty()) {
      /*delete*/Destructors.$destroy((Destructors.ClassWithDestructor)OwnedModules.begin().$star());
    }
    
    // Drop references for MDNodes.  Do this before Values get deleted to avoid
    // unnecessary RAUW when nodes are still unresolved.
    for (MDNode /*P*/ I : DistinctMDNodes)  {
      I.dropAllReferences();
    }
    for (MDTuple /*P*/ I : MDTuples)  {
      I.dropAllReferences();
    }
    for (DILocation /*P*/ I : DILocations)  {
      I.dropAllReferences();
    }
    for (DIExpression /*P*/ I : DIExpressions)  {
      I.dropAllReferences();
    }
    for (GenericDINode /*P*/ I : GenericDINodes)  {
      I.dropAllReferences();
    }
    for (DISubrange /*P*/ I : DISubranges)  {
      I.dropAllReferences();
    }
    for (DIEnumerator /*P*/ I : DIEnumerators)  {
      I.dropAllReferences();
    }
    for (DIBasicType /*P*/ I : DIBasicTypes)  {
      I.dropAllReferences();
    }
    for (DIDerivedType /*P*/ I : DIDerivedTypes)  {
      I.dropAllReferences();
    }
    for (DICompositeType /*P*/ I : DICompositeTypes)  {
      I.dropAllReferences();
    }
    for (DISubroutineType /*P*/ I : DISubroutineTypes)  {
      I.dropAllReferences();
    }
    for (DIFile /*P*/ I : DIFiles)  {
      I.dropAllReferences();
    }
    for (DISubprogram /*P*/ I : DISubprograms)  {
      I.dropAllReferences();
    }
    for (DILexicalBlock /*P*/ I : DILexicalBlocks)  {
      I.dropAllReferences();
    }
    for (DILexicalBlockFile /*P*/ I : DILexicalBlockFiles)  {
      I.dropAllReferences();
    }
    for (DINamespace /*P*/ I : DINamespaces)  {
      I.dropAllReferences();
    }
    for (DIModule /*P*/ I : DIModules)  {
      I.dropAllReferences();
    }
    for (DITemplateTypeParameter /*P*/ I : DITemplateTypeParameters)  {
      I.dropAllReferences();
    }
    for (DITemplateValueParameter /*P*/ I : DITemplateValueParameters)  {
      I.dropAllReferences();
    }
    for (DIGlobalVariable /*P*/ I : DIGlobalVariables)  {
      I.dropAllReferences();
    }
    for (DILocalVariable /*P*/ I : DILocalVariables)  {
      I.dropAllReferences();
    }
    for (DIObjCProperty /*P*/ I : DIObjCPropertys)  {
      I.dropAllReferences();
    }
    for (DIImportedEntity /*P*/ I : DIImportedEntitys)  {
      I.dropAllReferences();
    }
    for (DIMacro /*P*/ I : DIMacros)  {
      I.dropAllReferences();
    }
    for (DIMacroFile /*P*/ I : DIMacroFiles)  {
      I.dropAllReferences();
    }
    
    // Also drop references that come from the Value bridges.
    for (final std.pair<Value /*P*/ , ValueAsMetadata /*P*/ > /*&*/ Pair : ValuesAsMetadata)  {
      Pair.second.dropUsers();
    }
    for (final std.pair<Metadata /*P*/ , MetadataAsValue /*P*/ > /*&*/ Pair : MetadataAsValues)  {
      Pair.second.dropUse();
    }
    
    // Destroy MDNodes.
    for (MDNode /*P*/ I : DistinctMDNodes)  {
      I.deleteAsSubclass();
    }
    for (MDTuple /*P*/ I : MDTuples)  {
      /*delete*/Destructors.$destroy((Destructors.ClassWithDestructor)I);
    }
    for (DILocation /*P*/ I : DILocations)  {
      /*delete*/Destructors.$destroy((Destructors.ClassWithDestructor)I);
    }
    for (DIExpression /*P*/ I : DIExpressions)  {
      /*delete*/Destructors.$destroy((Destructors.ClassWithDestructor)I);
    }
    for (GenericDINode /*P*/ I : GenericDINodes)  {
      /*delete*/Destructors.$destroy((Destructors.ClassWithDestructor)I);
    }
    for (DISubrange /*P*/ I : DISubranges)  {
      /*delete*/Destructors.$destroy((Destructors.ClassWithDestructor)I);
    }
    for (DIEnumerator /*P*/ I : DIEnumerators)  {
      /*delete*/Destructors.$destroy((Destructors.ClassWithDestructor)I);
    }
    for (DIBasicType /*P*/ I : DIBasicTypes)  {
      /*delete*/Destructors.$destroy((Destructors.ClassWithDestructor)I);
    }
    for (DIDerivedType /*P*/ I : DIDerivedTypes)  {
      /*delete*/Destructors.$destroy((Destructors.ClassWithDestructor)I);
    }
    for (DICompositeType /*P*/ I : DICompositeTypes)  {
      /*delete*/Destructors.$destroy((Destructors.ClassWithDestructor)I);
    }
    for (DISubroutineType /*P*/ I : DISubroutineTypes)  {
      /*delete*/Destructors.$destroy((Destructors.ClassWithDestructor)I);
    }
    for (DIFile /*P*/ I : DIFiles)  {
      /*delete*/Destructors.$destroy((Destructors.ClassWithDestructor)I);
    }
    for (DISubprogram /*P*/ I : DISubprograms)  {
      /*delete*/Destructors.$destroy((Destructors.ClassWithDestructor)I);
    }
    for (DILexicalBlock /*P*/ I : DILexicalBlocks)  {
      /*delete*/Destructors.$destroy((Destructors.ClassWithDestructor)I);
    }
    for (DILexicalBlockFile /*P*/ I : DILexicalBlockFiles)  {
      /*delete*/Destructors.$destroy((Destructors.ClassWithDestructor)I);
    }
    for (DINamespace /*P*/ I : DINamespaces)  {
      /*delete*/Destructors.$destroy((Destructors.ClassWithDestructor)I);
    }
    for (DIModule /*P*/ I : DIModules)  {
      /*delete*/Destructors.$destroy((Destructors.ClassWithDestructor)I);
    }
    for (DITemplateTypeParameter /*P*/ I : DITemplateTypeParameters)  {
      /*delete*/Destructors.$destroy((Destructors.ClassWithDestructor)I);
    }
    for (DITemplateValueParameter /*P*/ I : DITemplateValueParameters)  {
      /*delete*/Destructors.$destroy((Destructors.ClassWithDestructor)I);
    }
    for (DIGlobalVariable /*P*/ I : DIGlobalVariables)  {
      /*delete*/Destructors.$destroy((Destructors.ClassWithDestructor)I);
    }
    for (DILocalVariable /*P*/ I : DILocalVariables)  {
      /*delete*/Destructors.$destroy((Destructors.ClassWithDestructor)I);
    }
    for (DIObjCProperty /*P*/ I : DIObjCPropertys)  {
      /*delete*/Destructors.$destroy((Destructors.ClassWithDestructor)I);
    }
    for (DIImportedEntity /*P*/ I : DIImportedEntitys)  {
      /*delete*/Destructors.$destroy((Destructors.ClassWithDestructor)I);
    }
    for (DIMacro /*P*/ I : DIMacros)  {
      /*delete*/Destructors.$destroy((Destructors.ClassWithDestructor)I);
    }
    for (DIMacroFile /*P*/ I : DIMacroFiles)  {
      /*delete*/Destructors.$destroy((Destructors.ClassWithDestructor)I);
    }
    
    // Free the constants.
    for (ConstantExpr /*P*/ I : ExprConstants)  {
      I.dropAllReferences();
    }
    for (ConstantArray /*P*/ I : ArrayConstants)  {
      I.dropAllReferences();
    }
    for (ConstantStruct /*P*/ I : StructConstants)  {
      I.dropAllReferences();
    }
    for (ConstantVector /*P*/ I : VectorConstants)  {
      I.dropAllReferences();
    }
    ExprConstants.freeConstants();
    ArrayConstants.freeConstants();
    StructConstants.freeConstants();
    VectorConstants.freeConstants();
    DeleteContainerSeconds(CAZConstants);
    DeleteContainerSeconds(CPNConstants);
    DeleteContainerSeconds(UVConstants);
    InlineAsms.freeConstants();
    DeleteContainerSeconds(IntConstants);
    DeleteContainerSeconds(FPConstants);
    
    for (final StringMapEntry<ConstantDataSequential /*P*/ > /*&*/ CDSConstant : CDSConstants)  {
      /*delete*/Destructors.$destroy((Destructors.ClassWithDestructor)CDSConstant.second);
    }
    CDSConstants.clear();
    
    // Destroy attributes.
    for (FoldingSetIterator<AttributeImpl> I = AttrsSet.begin(), 
        E = AttrsSet.end(); I.$noteq(E);) {
      FoldingSetIterator<AttributeImpl> Elem = I.$postInc(0);
      /*delete*/Destructors.$destroy((Destructors.ClassWithDestructor)/*AddrOf*/Elem.$star());
    }
    
    // Destroy attribute lists.
    for (FoldingSetIterator<AttributeSetImpl> I = AttrsLists.begin(), 
        E = AttrsLists.end(); I.$noteq(E);) {
      FoldingSetIterator<AttributeSetImpl> Elem = I.$postInc(0);
      /*delete*/Destructors.$destroy(/*AddrOf*/Elem.$star());
    }
    
    // Destroy attribute node lists.
    for (FoldingSetIterator<AttributeSetNode> I = AttrsSetNodes.begin(), 
        E = AttrsSetNodes.end(); I.$noteq(E);) {
      FoldingSetIterator<AttributeSetNode> Elem = I.$postInc(0);
      /*delete*/Destructors.$destroy(/*AddrOf*/Elem.$star());
    }
    {
      SmallVector<MetadataAsValue /*P*/ > MDVs/*J*/= new SmallVector<MetadataAsValue /*P*/ >(8, (MetadataAsValue /*P*/ )null);
      MDVs.reserve(MetadataAsValues.size());
      for (final std.pair<Metadata /*P*/ , MetadataAsValue /*P*/ > /*&*/ Pair : MetadataAsValues)  {
        MDVs.push_back(Pair.second);
      }
      MetadataAsValues.clear();
      for (MetadataAsValue /*P*/ V : MDVs)  {
        /*delete*/Destructors.$destroy((Destructors.ClassWithDestructor)V);
      }
    }
    
    // Destroy ValuesAsMetadata.
    for (final std.pair<Value /*P*/ , ValueAsMetadata /*P*/ > /*&*/ Pair : ValuesAsMetadata)  {
      /*delete*/Destructors.$destroy((Destructors.ClassWithDestructor)Pair.second);
    }
    //START JDestroy
    GCNames.$destroy();
    BundleTagCache.$destroy();
    DiscriminatorTable.$destroy();
    GlobalObjectMetadata.$destroy();
    InstructionMetadata.$destroy();
    CustomMDKindNames.$destroy();
    ValueHandles.$destroy();
    ASPointerTypes.$destroy();
    PointerTypes.$destroy();
    VectorTypes.$destroy();
    ArrayTypes.$destroy();
    NamedStructTypes.$destroy();
    AnonStructTypes.$destroy();
    FunctionTypes.$destroy();
    IntegerTypes.$destroy();
    TypeAllocator.$destroy();
    TheNoneToken.$destroy();
    InlineAsms.$destroy();
    ExprConstants.$destroy();
    BlockAddresses.$destroy();
    CDSConstants.$destroy();
    UVConstants.$destroy();
    CPNConstants.$destroy();
    VectorConstants.$destroy();
    StructConstants.$destroy();
    ArrayConstants.$destroy();
    CAZConstants.$destroy();
    DistinctMDNodes.$destroy();
    DITypeMap.$destroy();
    DIMacroFiles.$destroy();
    DIMacros.$destroy();
    DIImportedEntitys.$destroy();
    DIObjCPropertys.$destroy();
    DILocalVariables.$destroy();
    DIGlobalVariables.$destroy();
    DITemplateValueParameters.$destroy();
    DITemplateTypeParameters.$destroy();
    DIModules.$destroy();
    DINamespaces.$destroy();
    DILexicalBlockFiles.$destroy();
    DILexicalBlocks.$destroy();
    DISubprograms.$destroy();
    DIFiles.$destroy();
    DISubroutineTypes.$destroy();
    DICompositeTypes.$destroy();
    DIDerivedTypes.$destroy();
    DIBasicTypes.$destroy();
    DIEnumerators.$destroy();
    DISubranges.$destroy();
    GenericDINodes.$destroy();
    DIExpressions.$destroy();
    DILocations.$destroy();
    MDTuples.$destroy();
    ValueNames.$destroy();
    MetadataAsValues.$destroy();
    ValuesAsMetadata.$destroy();
    MDStringCache.$destroy();
    AttrsSetNodes.$destroy();
    AttrsLists.$destroy();
    AttrsSet.$destroy();
    FPConstants.$destroy();
    IntConstants.$destroy();
    OwnedModules.$destroy();
    //END JDestroy
  }

  
  /// Destroy the ConstantArrays if they are not used.
  //<editor-fold defaultstate="collapsed" desc="llvm::LLVMContextImpl::dropTriviallyDeadConstantArrays">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/IR/LLVMContextImpl.cpp", line = 145,
   FQN="llvm::LLVMContextImpl::dropTriviallyDeadConstantArrays", NM="_ZN4llvm15LLVMContextImpl31dropTriviallyDeadConstantArraysEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/LLVMContextImpl.cpp -nm=_ZN4llvm15LLVMContextImpl31dropTriviallyDeadConstantArraysEv")
  //</editor-fold>
  public void dropTriviallyDeadConstantArrays() {
    boolean Changed;
    do {
      Changed = false;

      for (DenseSet.iterator<ConstantArray> I = ArrayConstants.begin(), E = ArrayConstants.end(); I.$noteq(E);) {
        ConstantArray /*P*/ C = I.$postInc(0).$star();
        if (C.use_empty()) {
          Changed = true;
          C.destroyConstant();
        }
      }
    } while (Changed);
  }

  
  /// \brief Access the object which manages optimization bisection for failure
  /// analysis.
  //<editor-fold defaultstate="collapsed" desc="llvm::LLVMContextImpl::getOptBisect">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/IR/LLVMContextImpl.cpp", line = 250,
   FQN="llvm::LLVMContextImpl::getOptBisect", NM="_ZN4llvm15LLVMContextImpl12getOptBisectEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/LLVMContextImpl.cpp -nm=_ZN4llvm15LLVMContextImpl12getOptBisectEv")
  //</editor-fold>
  public OptBisect /*&*/ getOptBisect() {
    return LLVMContextImplStatics.OptBisector.$star();
  }

  
  @Override public String toString() {
    return "" + "OwnedModules=" + OwnedModules // NOI18N
              + ", InlineAsmDiagHandler=" + "[SMDiagnosticHandler]" // NOI18N
              + ", InlineAsmDiagContext=" + NativeTrace.getIdentityStr(InlineAsmDiagContext) // NOI18N
              + ", DiagnosticHandler=" + "[DiagnosticInfoHandler]" // NOI18N
              + ", DiagnosticContext=" + NativeTrace.getIdentityStr(DiagnosticContext) // NOI18N
              + ", RespectDiagnosticFilters=" + RespectDiagnosticFilters // NOI18N
              + ", DiagnosticHotnessRequested=" + DiagnosticHotnessRequested // NOI18N
              + ", YieldCallback=" + YieldCallback // NOI18N
              + ", YieldOpaqueHandle=" + NativeTrace.getIdentityStr(YieldOpaqueHandle) // NOI18N
              + ", IntConstants=" + IntConstants // NOI18N
              + ", FPConstants=" + FPConstants // NOI18N
              + ", AttrsSet=" + AttrsSet // NOI18N
              + ", AttrsLists=" + AttrsLists // NOI18N
              + ", AttrsSetNodes=" + AttrsSetNodes // NOI18N
              + ", MDStringCache=" + MDStringCache // NOI18N
              + ", ValuesAsMetadata=" + ValuesAsMetadata // NOI18N
              + ", MetadataAsValues=" + MetadataAsValues // NOI18N
              + ", ValueNames=" + ValueNames // NOI18N
              + ", MDTuples=" + MDTuples // NOI18N
              + ", DILocations=" + DILocations // NOI18N
              + ", DIExpressions=" + DIExpressions // NOI18N
              + ", GenericDINodes=" + GenericDINodes // NOI18N
              + ", DISubranges=" + DISubranges // NOI18N
              + ", DIEnumerators=" + DIEnumerators // NOI18N
              + ", DIBasicTypes=" + DIBasicTypes // NOI18N
              + ", DIDerivedTypes=" + DIDerivedTypes // NOI18N
              + ", DICompositeTypes=" + DICompositeTypes // NOI18N
              + ", DISubroutineTypes=" + DISubroutineTypes // NOI18N
              + ", DIFiles=" + DIFiles // NOI18N
              + ", DISubprograms=" + DISubprograms // NOI18N
              + ", DILexicalBlocks=" + DILexicalBlocks // NOI18N
              + ", DILexicalBlockFiles=" + DILexicalBlockFiles // NOI18N
              + ", DINamespaces=" + DINamespaces // NOI18N
              + ", DIModules=" + DIModules // NOI18N
              + ", DITemplateTypeParameters=" + DITemplateTypeParameters // NOI18N
              + ", DITemplateValueParameters=" + DITemplateValueParameters // NOI18N
              + ", DIGlobalVariables=" + DIGlobalVariables // NOI18N
              + ", DILocalVariables=" + DILocalVariables // NOI18N
              + ", DIObjCPropertys=" + DIObjCPropertys // NOI18N
              + ", DIImportedEntitys=" + DIImportedEntitys // NOI18N
              + ", DIMacros=" + DIMacros // NOI18N
              + ", DIMacroFiles=" + DIMacroFiles // NOI18N
              + ", DITypeMap=" + DITypeMap // NOI18N
              + ", DistinctMDNodes=" + DistinctMDNodes // NOI18N
              + ", CAZConstants=" + CAZConstants // NOI18N
              + ", ArrayConstants=" + ArrayConstants // NOI18N
              + ", StructConstants=" + StructConstants // NOI18N
              + ", VectorConstants=" + VectorConstants // NOI18N
              + ", CPNConstants=" + CPNConstants // NOI18N
              + ", UVConstants=" + UVConstants // NOI18N
              + ", CDSConstants=" + CDSConstants // NOI18N
              + ", BlockAddresses=" + BlockAddresses // NOI18N
              + ", ExprConstants=" + "[ConstantUniqueMap$ConstantExpr]" // NOI18N
              + ", InlineAsms=" + InlineAsms // NOI18N
              + ", TheTrueVal=" + TheTrueVal // NOI18N
              + ", TheFalseVal=" + TheFalseVal // NOI18N
              + ", TheNoneToken=" + TheNoneToken // NOI18N
              + ", VoidTy=" + VoidTy // NOI18N
              + ", LabelTy=" + LabelTy // NOI18N
              + ", HalfTy=" + HalfTy // NOI18N
              + ", FloatTy=" + FloatTy // NOI18N
              + ", DoubleTy=" + DoubleTy // NOI18N
              + ", MetadataTy=" + MetadataTy // NOI18N
              + ", TokenTy=" + TokenTy // NOI18N
              + ", X86_FP80Ty=" + X86_FP80Ty // NOI18N
              + ", FP128Ty=" + FP128Ty // NOI18N
              + ", PPC_FP128Ty=" + PPC_FP128Ty // NOI18N
              + ", X86_MMXTy=" + X86_MMXTy // NOI18N
              + ", Int1Ty=" + Int1Ty // NOI18N
              + ", Int8Ty=" + Int8Ty // NOI18N
              + ", Int16Ty=" + Int16Ty // NOI18N
              + ", Int32Ty=" + Int32Ty // NOI18N
              + ", Int64Ty=" + Int64Ty // NOI18N
              + ", Int128Ty=" + Int128Ty // NOI18N
              + ", TypeAllocator=" + "[BumpPtrAllocatorImpl]" // NOI18N
              + ", IntegerTypes=" + IntegerTypes // NOI18N
              + ", FunctionTypes=" + FunctionTypes // NOI18N
              + ", AnonStructTypes=" + AnonStructTypes // NOI18N
              + ", NamedStructTypes=" + NamedStructTypes // NOI18N
              + ", NamedStructTypesUniqueID=" + NamedStructTypesUniqueID // NOI18N
              + ", ArrayTypes=" + ArrayTypes // NOI18N
              + ", VectorTypes=" + VectorTypes // NOI18N
              + ", PointerTypes=" + PointerTypes // NOI18N
              + ", ASPointerTypes=" + ASPointerTypes // NOI18N
              + ", ValueHandles=" + ValueHandles // NOI18N
              + ", CustomMDKindNames=" + CustomMDKindNames // NOI18N
              + ", InstructionMetadata=" + InstructionMetadata // NOI18N
              + ", GlobalObjectMetadata=" + GlobalObjectMetadata // NOI18N
              + ", DiscriminatorTable=" + DiscriminatorTable // NOI18N
              + ", BundleTagCache=" + BundleTagCache // NOI18N
              + ", GCNames=" + GCNames // NOI18N
              + ", DiscardValueNames=" + DiscardValueNames; // NOI18N
  }
}