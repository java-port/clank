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

package org.clang.codegen.CodeGen.impl;

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.java.std.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import org.clang.basic.*;
import org.llvm.ir.*;
import org.clang.codegen.impl.*;
import org.clang.codegen.CodeGen.*;
import org.clang.codegen.CodeGen.swiftcall.*;
import org.clang.basic.target.TargetInfo;
import org.clang.ast.aliases.*;
import static org.clang.ast.java.AstTypesRTTI.*;
import static org.clang.ast.java.AstDeclarationsRTTI.*;
import static org.clang.codegen.java.CodegenRTTI.*;
import static org.llvm.ir.java.IrRTTI.*;
import static org.clang.ast.java.AstJavaDifferentiators.*;


/// This class organizes the cross-module state that is used while lowering
/// AST types to LLVM types.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenTypes">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenTypes.h", line = 120,
 FQN="clang::CodeGen::CodeGenTypes", NM="_ZN5clang7CodeGen12CodeGenTypesE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZN5clang7CodeGen12CodeGenTypesE")
//</editor-fold>
public class CodeGenTypes implements Destructors.ClassWithDestructor {
  private final CodeGenModule /*&*/ CGM;
  // Some of this stuff should probably be left on the CGM.
  private final ASTContext /*&*/ Context;
  private final org.llvm.ir.Module /*&*/ TheModule;
  private final /*const*/ TargetInfo /*&*/ Target;
  private final CGCXXABI /*&*/ TheCXXABI;
  
  // This should not be moved earlier, since its initialization depends on some
  // of the previous reference members being already initialized
  private final /*const*/ ABIInfo /*&*/ TheABIInfo;
  
  /// The opaque type map for Objective-C interfaces. All direct
  /// manipulation is done by the runtime interfaces, which are
  /// responsible for coercing to the appropriate type; these opaque
  /// types are never refined.
  private DenseMap</*const*/ ObjCInterfaceType /*P*/ , org.llvm.ir.Type /*P*/ > InterfaceTypes;
  
  /// Maps clang struct type with corresponding record layout info.
  private DenseMap</*const*/ org.clang.ast.Type /*P*/ , CGRecordLayout /*P*/ > CGRecordLayouts;
  
  /// Contains the LLVM IR type for any converted RecordDecl.
  private DenseMap</*const*/ org.clang.ast.Type /*P*/ , StructType /*P*/ > RecordDeclTypes;
  
  /// Hold memoized CGFunctionInfo results.
  private FoldingSet<CGFunctionInfo> FunctionInfos;
  
  /// This set keeps track of records that we're currently converting
  /// to an IR type.  For example, when converting:
  /// struct A { struct B { int x; } } when processing 'x', the 'A' and 'B'
  /// types will be in this set.
  private SmallPtrSet</*const*/ org.clang.ast.Type /*P*/ > RecordsBeingLaidOut;
  
  private SmallPtrSet</*const*/ CGFunctionInfo /*P*/ > FunctionsBeingProcessed;
  
  /// True if we didn't layout a function due to a being inside
  /// a recursive struct conversion, set this to true.
  private boolean SkippedLayout;
  
  private SmallVector</*const*/ RecordDecl /*P*/ > DeferredRecords;
  
  /// This map keeps cache of llvm::Types and maps clang::Type to
  /// corresponding llvm::Type.
  private DenseMap</*const*/ org.clang.ast.Type /*P*/ , org.llvm.ir.Type /*P*/ > TypeCache;
  
  private SmallSetT$PLess$T$P</*const*/ org.clang.ast.Type /*P*/ > RecordsWithOpaqueMemberPointers;
  
  
  /***/
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenTypes::ClangCallConvToLLVMCallConv">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp", line = 45,
   FQN="clang::CodeGen::CodeGenTypes::ClangCallConvToLLVMCallConv", NM="_ZN5clang7CodeGen12CodeGenTypes27ClangCallConvToLLVMCallConvENS_11CallingConvE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZN5clang7CodeGen12CodeGenTypes27ClangCallConvToLLVMCallConvENS_11CallingConvE")
  //</editor-fold>
  private /*uint*/int ClangCallConvToLLVMCallConv(org.clang.basic.CallingConv CC) {
    switch (CC) {
     default:
      return org.llvm.ir.CallingConv.C;
     case CC_X86StdCall:
      return org.llvm.ir.CallingConv.X86_StdCall;
     case CC_X86FastCall:
      return org.llvm.ir.CallingConv.X86_FastCall;
     case CC_X86ThisCall:
      return org.llvm.ir.CallingConv.X86_ThisCall;
     case CC_X86_64Win64:
      return org.llvm.ir.CallingConv.X86_64_Win64;
     case CC_X86_64SysV:
      return org.llvm.ir.CallingConv.X86_64_SysV;
     case CC_AAPCS:
      return org.llvm.ir.CallingConv.ARM_AAPCS;
     case CC_AAPCS_VFP:
      return org.llvm.ir.CallingConv.ARM_AAPCS_VFP;
     case CC_IntelOclBicc:
      return org.llvm.ir.CallingConv.Intel_OCL_BI;
     case CC_X86Pascal:
      // TODO: Add support for __pascal to LLVM.
      return org.llvm.ir.CallingConv.C;
     case CC_X86VectorCall:
      // TODO: Add support for __vectorcall to LLVM.
      return org.llvm.ir.CallingConv.X86_VectorCall;
     case CC_SpirFunction:
      return org.llvm.ir.CallingConv.SPIR_FUNC;
     case CC_OpenCLKernel:
      return CGM.getTargetCodeGenInfo().getOpenCLKernelCallingConv();
     case CC_PreserveMost:
      return org.llvm.ir.CallingConv.PreserveMost;
     case CC_PreserveAll:
      return org.llvm.ir.CallingConv.PreserveAll;
     case CC_Swift:
      return org.llvm.ir.CallingConv.Swift;
    }
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenTypes::CodeGenTypes">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenTypes.cpp", line = 32,
   FQN="clang::CodeGen::CodeGenTypes::CodeGenTypes", NM="_ZN5clang7CodeGen12CodeGenTypesC1ERNS0_13CodeGenModuleE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenTypes.cpp -nm=_ZN5clang7CodeGen12CodeGenTypesC1ERNS0_13CodeGenModuleE")
  //</editor-fold>
  public CodeGenTypes(final CodeGenModule /*&*/ cgm) {
    // : CGM(cgm), Context(cgm.getContext()), TheModule(cgm.getModule()), Target(cgm.getTarget()), TheCXXABI(cgm.getCXXABI()), TheABIInfo(cgm.getTargetCodeGenInfo().getABIInfo()), InterfaceTypes(), CGRecordLayouts(), RecordDeclTypes(), FunctionInfos(), RecordsBeingLaidOut(), FunctionsBeingProcessed(), DeferredRecords(), TypeCache(), RecordsWithOpaqueMemberPointers() 
    //START JInit
    this./*&*/CGM=/*&*/cgm;
    this./*&*/Context=/*&*/cgm.getContext();
    this./*&*/TheModule=/*&*/cgm.getModule();
    this./*&*/Target=/*&*/cgm.getTarget();
    this./*&*/TheCXXABI=/*&*/cgm.getCXXABI();
    this./*&*/TheABIInfo=/*&*/cgm.getTargetCodeGenInfo(/*JAVA: must pass this, because cgm uses it's Types fields which is null during this ctr call*/this).getABIInfo();
    this.InterfaceTypes = new DenseMap</*const*/ ObjCInterfaceType /*P*/ , org.llvm.ir.Type /*P*/ >(DenseMapInfo$LikePtr.$Info(), (org.llvm.ir.Type /*P*/ )null);
    this.CGRecordLayouts = new DenseMap</*const*/ org.clang.ast.Type /*P*/ , CGRecordLayout /*P*/ >(DenseMapInfo$LikePtr.$Info(), (CGRecordLayout /*P*/ )null);
    this.RecordDeclTypes = new DenseMap</*const*/ org.clang.ast.Type /*P*/ , StructType /*P*/ >(DenseMapInfo$LikePtr.$Info(), (StructType /*P*/ )null);
    this.FunctionInfos = new FoldingSet<CGFunctionInfo>(CGFunctionInfo.$Trait());
    this.RecordsBeingLaidOut = new SmallPtrSet</*const*/ org.clang.ast.Type /*P*/ >(DenseMapInfo$LikePtr.$Info(), 4);
    this.FunctionsBeingProcessed = new SmallPtrSet</*const*/ CGFunctionInfo /*P*/ >(DenseMapInfo$LikePtr.$Info(), 4);
    this.DeferredRecords = new SmallVector</*const*/ RecordDecl /*P*/ >(8, (/*const*/ RecordDecl /*P*/ )null);
    this.TypeCache = new DenseMap</*const*/ org.clang.ast.Type /*P*/ , org.llvm.ir.Type /*P*/ >(DenseMapInfo$LikePtr.$Info(), (org.llvm.ir.Type /*P*/ )null);
    this.RecordsWithOpaqueMemberPointers = new SmallSetT$PLess$T$P</*const*/ org.clang.ast.Type /*P*/ >(8);
    //END JInit
    SkippedLayout = false;
  }


  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenTypes::~CodeGenTypes">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenTypes.cpp", line = 39,
   FQN="clang::CodeGen::CodeGenTypes::~CodeGenTypes", NM="_ZN5clang7CodeGen12CodeGenTypesD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenTypes.cpp -nm=_ZN5clang7CodeGen12CodeGenTypesD0Ev")
  //</editor-fold>
  public void $destroy() {
    llvm.DeleteContainerSeconds(CGRecordLayouts);
    
    for (FoldingSetIterator<CGFunctionInfo> I = FunctionInfos.begin(), E = FunctionInfos.end(); I.$noteq(E);)  {
      /*delete*/Destructors.$destroy($AddrOf(I.$postInc(0).$star()));
    }
    //START JDestroy
    RecordsWithOpaqueMemberPointers.$destroy();
    TypeCache.$destroy();
    DeferredRecords.$destroy();
    FunctionsBeingProcessed.$destroy();
    RecordsBeingLaidOut.$destroy();
    FunctionInfos.$destroy();
    RecordDeclTypes.$destroy();
    CGRecordLayouts.$destroy();
    InterfaceTypes.$destroy();
    //END JDestroy
  }


  
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenTypes::getDataLayout">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenTypes.h", line = 173,
   FQN="clang::CodeGen::CodeGenTypes::getDataLayout", NM="_ZNK5clang7CodeGen12CodeGenTypes13getDataLayoutEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZNK5clang7CodeGen12CodeGenTypes13getDataLayoutEv")
  //</editor-fold>
  public /*const*/ DataLayout /*&*/ getDataLayout() /*const*/ {
    return TheModule.getDataLayout();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenTypes::getContext">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenTypes.h", line = 176,
   FQN="clang::CodeGen::CodeGenTypes::getContext", NM="_ZNK5clang7CodeGen12CodeGenTypes10getContextEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZNK5clang7CodeGen12CodeGenTypes10getContextEv")
  //</editor-fold>
  public ASTContext /*&*/ getContext() /*const*/ {
    return Context;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenTypes::getABIInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenTypes.h", line = 177,
   FQN="clang::CodeGen::CodeGenTypes::getABIInfo", NM="_ZNK5clang7CodeGen12CodeGenTypes10getABIInfoEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZNK5clang7CodeGen12CodeGenTypes10getABIInfoEv")
  //</editor-fold>
  public /*const*/ ABIInfo /*&*/ getABIInfo() /*const*/ {
    return TheABIInfo;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenTypes::getTarget">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenTypes.h", line = 178,
   FQN="clang::CodeGen::CodeGenTypes::getTarget", NM="_ZNK5clang7CodeGen12CodeGenTypes9getTargetEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZNK5clang7CodeGen12CodeGenTypes9getTargetEv")
  //</editor-fold>
  public /*const*/ TargetInfo /*&*/ getTarget() /*const*/ {
    return Target;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenTypes::getCXXABI">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenTypes.h", line = 179,
   FQN="clang::CodeGen::CodeGenTypes::getCXXABI", NM="_ZNK5clang7CodeGen12CodeGenTypes9getCXXABIEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZNK5clang7CodeGen12CodeGenTypes9getCXXABIEv")
  //</editor-fold>
  public CGCXXABI /*&*/ getCXXABI() /*const*/ {
    return TheCXXABI;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenTypes::getLLVMContext">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenTypes.h", line = 180,
   FQN="clang::CodeGen::CodeGenTypes::getLLVMContext", NM="_ZN5clang7CodeGen12CodeGenTypes14getLLVMContextEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZN5clang7CodeGen12CodeGenTypes14getLLVMContextEv")
  //</editor-fold>
  public LLVMContext /*&*/ getLLVMContext() {
    return TheModule.getContext();
  }

  
  /// ConvertType - Convert type T into a llvm::Type.
  
  /// ConvertType - Convert type T into a llvm::Type.
  
  /// ConvertType - Convert the specified type to its LLVM form.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenTypes::ConvertType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenTypes.cpp", line = 379,
   FQN="clang::CodeGen::CodeGenTypes::ConvertType", NM="_ZN5clang7CodeGen12CodeGenTypes11ConvertTypeENS_8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenTypes.cpp -nm=_ZN5clang7CodeGen12CodeGenTypes11ConvertTypeENS_8QualTypeE")
  //</editor-fold>
  public org.llvm.ir.Type /*P*/ ConvertType(QualType T) {
    T.$assignMove(Context.getCanonicalType(/*NO_COPY*/T).$QualType());
    
    /*const*/ org.clang.ast.Type /*P*/ Ty = T.getTypePtr();
    {
      
      // RecordTypes are cached and processed specially.
      /*const*/ RecordType /*P*/ RT = dyn_cast_RecordType(Ty);
      if ((RT != null)) {
        return ConvertRecordDeclType(RT.getDecl());
      }
    }
    
    // See if type is already cached.
    DenseMapIterator</*const*/ org.clang.ast.Type /*P*/ , org.llvm.ir.Type /*P*/ > TCI = TypeCache.find(Ty);
    // If type is found in map then use it. Otherwise, convert type T.
    if (TCI.$noteq(/*NO_ITER_COPY*/TypeCache.end())) {
      return TCI.$arrow().second;
    }
    
    // If we don't have it in the cache, convert it now.
    org.llvm.ir.Type /*P*/ ResultType = null;
    switch (Ty.getTypeClass()) {
     case Record: // Handled above.
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
      throw new llvm_unreachable("Non-canonical or dependent types aren't possible.");
     case Builtin:
      {
        switch (cast_BuiltinType(Ty).getKind()) {
         case Void:
         case ObjCId:
         case ObjCClass:
         case ObjCSel:
          // LLVM void type can only be used as the result of a function call.  Just
          // map to the same as char.
          ResultType = org.llvm.ir.Type.getInt8Ty(getLLVMContext());
          break;
         case Bool:
          // Note that we always return bool as i1 for use as a scalar type.
          ResultType = org.llvm.ir.Type.getInt1Ty(getLLVMContext());
          break;
         case Char_S:
         case Char_U:
         case SChar:
         case UChar:
         case Short:
         case UShort:
         case Int:
         case UInt:
         case Long:
         case ULong:
         case LongLong:
         case ULongLong:
         case WChar_S:
         case WChar_U:
         case Char16:
         case Char32:
          ResultType = IntegerType.get(getLLVMContext(), 
              ((/*static_cast*//*uint*/int)($ulong2uint(Context.getTypeSize(new QualType(T))))));
          break;
         case Half:
          // Half FP can either be storage-only (lowered to i16) or native.
          ResultType
             = CodeGenTypesStatics.getTypeForFormat(getLLVMContext(), Context.getFloatTypeSemantics(new QualType(T)), 
              Context.getLangOpts().NativeHalfType
                 || Context.getLangOpts().HalfArgsAndReturns);
          break;
         case Float:
         case Double:
         case LongDouble:
         case Float128:
          ResultType = CodeGenTypesStatics.getTypeForFormat(getLLVMContext(), 
              Context.getFloatTypeSemantics(new QualType(T)), 
              /* UseNativeHalf = */ false);
          break;
         case NullPtr:
          // Model std::nullptr_t as i8*
          ResultType = org.llvm.ir.Type.getInt8PtrTy(getLLVMContext());
          break;
         case UInt128:
         case Int128:
          ResultType = IntegerType.get(getLLVMContext(), 128);
          break;
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
         case OCLSampler:
         case OCLEvent:
         case OCLClkEvent:
         case OCLQueue:
         case OCLNDRange:
         case OCLReserveID:
          ResultType = CGM.getOpenCLRuntime().convertOpenCLSpecificType(Ty);
          break;
         case Dependent:
         case Overload:
         case BoundMember:
         case PseudoObject:
         case UnknownAny:
         case BuiltinFn:
         case ARCUnbridgedCast:
         case OMPArraySection:
          throw new llvm_unreachable("Unexpected placeholder builtin type!");
        }
        break;
      }
     case Auto:
      throw new llvm_unreachable("Unexpected undeduced auto type!");
     case Complex:
      {
        org.llvm.ir.Type /*P*/ EltTy = ConvertType(cast_ComplexType(Ty).getElementType());
        ResultType = StructType.get(EltTy, EltTy, null);
        break;
      }
     case LValueReference:
     case RValueReference:
      {
        /*const*/ ReferenceType /*P*/ RTy = cast_ReferenceType(Ty);
        QualType ETy = RTy.getPointeeType();
        org.llvm.ir.Type /*P*/ PointeeType = ConvertTypeForMem(new QualType(ETy));
        /*uint*/int AS = Context.getTargetAddressSpace(new QualType(ETy));
        ResultType = org.llvm.ir.PointerType.get(PointeeType, AS);
        break;
      }
     case Pointer:
      {
        /*const*/ org.clang.ast.PointerType /*P*/ PTy = cast_PointerType(Ty);
        QualType ETy = PTy.getPointeeType();
        org.llvm.ir.Type /*P*/ PointeeType = ConvertTypeForMem(new QualType(ETy));
        if (PointeeType.isVoidTy()) {
          PointeeType = org.llvm.ir.Type.getInt8Ty(getLLVMContext());
        }
        /*uint*/int AS = Context.getTargetAddressSpace(new QualType(ETy));
        ResultType = org.llvm.ir.PointerType.get(PointeeType, AS);
        break;
      }
     case VariableArray:
      {
        /*const*/ VariableArrayType /*P*/ A = cast_VariableArrayType(Ty);
        assert (A.getIndexTypeCVRQualifiers() == 0) : "FIXME: We only handle trivial array types so far!";
        // VLAs resolve to the innermost element type; this matches
        // the return of alloca, and there isn't any obviously better choice.
        ResultType = ConvertTypeForMem(A.getElementType());
        break;
      }
     case IncompleteArray:
      {
        /*const*/ IncompleteArrayType /*P*/ A = cast_IncompleteArrayType(Ty);
        assert (A.getIndexTypeCVRQualifiers() == 0) : "FIXME: We only handle trivial array types so far!";
        // int X[] -> [0 x int], unless the element type is not sized.  If it is
        // unsized (e.g. an incomplete struct) just use [0 x i8].
        ResultType = ConvertTypeForMem(A.getElementType());
        if (!ResultType.isSized()) {
          SkippedLayout = true;
          ResultType = org.llvm.ir.Type.getInt8Ty(getLLVMContext());
        }
        ResultType = org.llvm.ir.ArrayType.get(ResultType, $int2ulong(0));
        break;
      }
     case ConstantArray:
      {
        /*const*/ ConstantArrayType /*P*/ A = cast_ConstantArrayType(Ty);
        org.llvm.ir.Type /*P*/ EltTy = ConvertTypeForMem(A.getElementType());
        
        // Lower arrays of undefined struct type to arrays of i8 just to have a 
        // concrete type.
        if (!EltTy.isSized()) {
          SkippedLayout = true;
          EltTy = org.llvm.ir.Type.getInt8Ty(getLLVMContext());
        }
        
        ResultType = org.llvm.ir.ArrayType.get(EltTy, A.getSize().getZExtValue());
        break;
      }
     case ExtVector:
     case Vector:
      {
        /*const*/ org.clang.ast.VectorType /*P*/ VT = cast_VectorType(Ty);
        ResultType = org.llvm.ir.VectorType.get(ConvertType(VT.getElementType()), 
            VT.getNumElements());
        break;
      }
     case FunctionNoProto:
     case FunctionProto:
      ResultType = ConvertFunctionType(new QualType(T));
      break;
     case ObjCObject:
      ResultType = ConvertType(cast_ObjCObjectType(Ty).getBaseType());
      break;
     case ObjCInterface:
      {
        // Objective-C interfaces are always opaque (outside of the
        // runtime, which can do whatever it likes); we never refine
        // these.
        final type$ref<org.llvm.ir.Type /*P*/ /*&*/> T$1 = InterfaceTypes.ref$at(cast_ObjCInterfaceType(Ty));
        if (!(T$1.$deref() != null)) {
          T$1.$set(StructType.create(getLLVMContext()));
        }
        ResultType = T$1.$deref();
        break;
      }
     case ObjCObjectPointer:
      {
        // Protocol qualifications do not influence the LLVM type, we just return a
        // pointer to the underlying interface type. We don't need to worry about
        // recursive conversion.
        org.llvm.ir.Type /*P*/ T$1 = ConvertTypeForMem(cast_ObjCObjectPointerType(Ty).getPointeeType());
        ResultType = T$1.getPointerTo();
        break;
      }
     case Enum:
      {
        /*const*/ EnumDecl /*P*/ ED = cast_EnumType(Ty).getDecl();
        if (ED.isCompleteDefinition() || ED.isFixed()) {
          return ConvertType(ED.getIntegerType());
        }
        // Return a placeholder 'i32' type.  This can be changed later when the
        // type is defined (see UpdateCompletedType), but is likely to be the
        // "right" answer.
        ResultType = org.llvm.ir.Type.getInt32Ty(getLLVMContext());
        break;
      }
     case BlockPointer:
      {
        /*const*/ QualType FTy = cast_BlockPointerType(Ty).getPointeeType();
        org.llvm.ir.Type /*P*/ PointeeType = ConvertTypeForMem(new QualType(FTy));
        /*uint*/int AS = Context.getTargetAddressSpace(new QualType(FTy));
        ResultType = org.llvm.ir.PointerType.get(PointeeType, AS);
        break;
      }
     case MemberPointer:
      {
        /*const*/ MemberPointerType /*P*/ MPTy = cast_MemberPointerType(Ty);
        if (!getCXXABI().isMemberPointerConvertible(MPTy)) {
          RecordsWithOpaqueMemberPointers.insert(MPTy.__getClass());
          ResultType = StructType.create(getLLVMContext());
        } else {
          ResultType = getCXXABI().ConvertMemberPointerType(MPTy);
        }
        break;
      }
     case Atomic:
      {
        QualType valueType = cast_AtomicType(Ty).getValueType();
        ResultType = ConvertTypeForMem(new QualType(valueType));
        
        // Pad out to the inflated size if necessary.
        long/*uint64_t*/ valueSize = Context.getTypeSize(new QualType(valueType));
        long/*uint64_t*/ atomicSize = Context.getTypeSize(Ty);
        if (valueSize != atomicSize) {
          assert ($less_ulong(valueSize, atomicSize));
          org.llvm.ir.Type /*P*/ elts[/*2*/] = new org.llvm.ir.Type /*P*/  [/*2*/] {
            ResultType, 
            org.llvm.ir.ArrayType.get(CGM.Int8Ty, $div_ullong((atomicSize - valueSize), $int2ullong(8)))
          };
          ResultType = StructType.get(getLLVMContext(), 
              llvm.makeArrayRef(elts, true));
        }
        break;
      }
     case Pipe:
      {
        ResultType = CGM.getOpenCLRuntime().getPipeType();
        break;
      }
    }
    assert ((ResultType != null)) : "Didn't convert a type?";
    
    TypeCache.$set(Ty, ResultType);
    return ResultType;
  }


  
  /// \brief Converts the GlobalDecl into an llvm::Type. This should be used
  /// when we know the target of the function we want to convert.  This is
  /// because some functions (explicitly, those with pass_object_size
  /// parameters) may not have the same signature as their type portrays, and
  /// can only be called directly.
  
  /// \brief Converts the GlobalDecl into an llvm::Type. This should be used
  /// when we know the target of the function we want to convert.  This is
  /// because some functions (explicitly, those with pass_object_size
  /// parameters) may not have the same signature as their type portrays, and
  /// can only be called directly.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenTypes::ConvertFunctionType">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenTypes.cpp", line = 308,
   FQN="clang::CodeGen::CodeGenTypes::ConvertFunctionType", NM="_ZN5clang7CodeGen12CodeGenTypes19ConvertFunctionTypeENS_8QualTypeEPKNS_12FunctionDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenTypes.cpp -nm=_ZN5clang7CodeGen12CodeGenTypes19ConvertFunctionTypeENS_8QualTypeEPKNS_12FunctionDeclE")
  //</editor-fold>
  public org.llvm.ir.Type /*P*/ ConvertFunctionType(QualType QFT) {
    return ConvertFunctionType(QFT, 
                     (/*const*/ FunctionDecl /*P*/ )null);
  }
  public org.llvm.ir.Type /*P*/ ConvertFunctionType(QualType QFT, 
                     /*const*/ FunctionDecl /*P*/ FD/*= null*/) {
    assert (QFT.isCanonical());
    /*const*/ org.clang.ast.Type /*P*/ Ty = QFT.getTypePtr();
    /*const*/ org.clang.ast.FunctionType /*P*/ FT = cast_FunctionType(QFT.getTypePtr());
    // First, check whether we can build the full function type.  If the
    // function type depends on an incomplete type (e.g. a struct or enum), we
    // cannot lower the function type.
    if (!isFuncTypeConvertible(FT)) {
      {
        // This function's type depends on an incomplete tag type.
        
        // Force conversion of all the relevant record types, to make sure
        // we re-convert the FunctionType when appropriate.
        /*const*/ RecordType /*P*/ RT = FT.getReturnType().$arrow().getAs$RecordType();
        if ((RT != null)) {
          ConvertRecordDeclType(RT.getDecl());
        }
      }
      {
        /*const*/ FunctionProtoType /*P*/ FPT = dyn_cast_FunctionProtoType(FT);
        if ((FPT != null)) {
          for (/*uint*/int i = 0, e = FPT.getNumParams(); i != e; i++)  {
            {
              /*const*/ RecordType /*P*/ RT = FPT.getParamType(i).$arrow().getAs$RecordType();
              if ((RT != null)) {
                ConvertRecordDeclType(RT.getDecl());
              }
            }
          }
        }
      }
      
      SkippedLayout = true;
      
      // Return a placeholder type.
      return StructType.get(getLLVMContext());
    }
    
    // While we're converting the parameter types for a function, we don't want
    // to recursively convert any pointed-to structs.  Converting directly-used
    // structs is ok though.
    if (!RecordsBeingLaidOut.insert(Ty).second) {
      SkippedLayout = true;
      return StructType.get(getLLVMContext());
    }
    
    // The function type can be built; call the appropriate routines to
    // build it.
    /*const*/ CGFunctionInfo /*P*/ FI;
    {
      /*const*/ FunctionProtoType /*P*/ FPT = dyn_cast_FunctionProtoType(FT);
      if ((FPT != null)) {
        FI = /*AddrOf*/arrangeFreeFunctionType((CanQual<FunctionProtoType>)(CanQual)CanQual.<FunctionProtoType>CreateUnsafe(new QualType(FPT, 0)), FD);
      } else {
        /*const*/ FunctionNoProtoType /*P*/ FNPT = cast_FunctionNoProtoType(FT);
        FI = /*AddrOf*/arrangeFreeFunctionType((CanQual<FunctionNoProtoType>)(CanQual)CanQual.<FunctionNoProtoType>CreateUnsafe(new QualType(FNPT, 0)));
      }
    }
    
    org.llvm.ir.Type /*P*/ ResultType = null;
    // If there is something higher level prodding our CGFunctionInfo, then
    // don't recurse into it again.
    if ((FunctionsBeingProcessed.count(FI) != 0)) {
      
      ResultType = StructType.get(getLLVMContext());
      SkippedLayout = true;
    } else {
      
      // Otherwise, we're good to go, go ahead and convert it.
      ResultType = GetFunctionType($Deref(FI));
    }
    
    RecordsBeingLaidOut.erase(Ty);
    if (SkippedLayout) {
      TypeCache.clear();
    }
    if (RecordsBeingLaidOut.empty()) {
      while (!DeferredRecords.empty()) {
        ConvertRecordDeclType(DeferredRecords.pop_back_val());
      }
    }
    return ResultType;
  }


  
  /// ConvertTypeForMem - Convert type T into a llvm::Type.  This differs from
  /// ConvertType in that it is used to convert to the memory representation for
  /// a type.  For example, the scalar representation for _Bool is i1, but the
  /// memory representation is usually i8 or i32, depending on the target.
  
  /// ConvertTypeForMem - Convert type T into a llvm::Type.  This differs from
  /// ConvertType in that it is used to convert to the memory representation for
  /// a type.  For example, the scalar representation for _Bool is i1, but the
  /// memory representation is usually i8 or i32, depending on the target.
  
  /// ConvertTypeForMem - Convert type T into a llvm::Type.  This differs from
  /// ConvertType in that it is used to convert to the memory representation for
  /// a type.  For example, the scalar representation for _Bool is i1, but the
  /// memory representation is usually i8 or i32, depending on the target.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenTypes::ConvertTypeForMem">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenTypes.cpp", line = 83,
   FQN="clang::CodeGen::CodeGenTypes::ConvertTypeForMem", NM="_ZN5clang7CodeGen12CodeGenTypes17ConvertTypeForMemENS_8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenTypes.cpp -nm=_ZN5clang7CodeGen12CodeGenTypes17ConvertTypeForMemENS_8QualTypeE")
  //</editor-fold>
  public org.llvm.ir.Type /*P*/ ConvertTypeForMem(QualType T) {
    org.llvm.ir.Type /*P*/ R = ConvertType(new QualType(T));
    
    // If this is a non-bool type, don't map it.
    if (!R.isIntegerTy(1)) {
      return R;
    }
    
    // Otherwise, return an integer of the target-specified size.
    return IntegerType.get(getLLVMContext(), 
        (/*uint*/int)$ulong2uint(Context.getTypeSize(new QualType(T))));
  }


  
  /// GetFunctionType - Get the LLVM function type for \arg Info.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenTypes::GetFunctionType">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp", line = 1465,
   FQN="clang::CodeGen::CodeGenTypes::GetFunctionType", NM="_ZN5clang7CodeGen12CodeGenTypes15GetFunctionTypeERKNS0_14CGFunctionInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZN5clang7CodeGen12CodeGenTypes15GetFunctionTypeERKNS0_14CGFunctionInfoE")
  //</editor-fold>
  public org.llvm.ir.FunctionType /*P*/ GetFunctionType(final /*const*/ CGFunctionInfo /*&*/ FI) {
    ClangToLLVMArgMapping IRFunctionArgs = null;
    try {
      
      boolean Inserted = FunctionsBeingProcessed.insert($AddrOf(FI)).second;
      ///*J:(void)*/Inserted;
      assert (Inserted) : "Recursively being processed?";
      
      org.llvm.ir.Type /*P*/ resultType = null;
      final /*const*/ ABIArgInfo /*&*/ retAI = FI.getReturnInfo$Const();
      switch (retAI.getKind()) {
       case Expand:
        throw new llvm_unreachable("Invalid ABI kind for return argument");
       case Extend:
       case Direct:
        resultType = retAI.getCoerceToType();
        break;
       case InAlloca:
        if (retAI.getInAllocaSRet()) {
          // sret things on win32 aren't void, they return the sret pointer.
          QualType ret = FI.getReturnType().$QualType();
          org.llvm.ir.Type /*P*/ ty = ConvertType(new QualType(ret));
          /*uint*/int addressSpace = Context.getTargetAddressSpace(new QualType(ret));
          resultType = org.llvm.ir.PointerType.get(ty, addressSpace);
        } else {
          resultType = org.llvm.ir.Type.getVoidTy(getLLVMContext());
        }
        break;
       case Indirect:
       case Ignore:
        resultType = org.llvm.ir.Type.getVoidTy(getLLVMContext());
        break;
       case CoerceAndExpand:
        resultType = retAI.getUnpaddedCoerceAndExpandType();
        break;
      }
      
      IRFunctionArgs/*J*/= new ClangToLLVMArgMapping(getContext(), FI, true);
      SmallVector<org.llvm.ir.Type /*P*/ > ArgTypes/*J*/= new SmallVector<org.llvm.ir.Type /*P*/ >(JD$UInt_T$C$R.INSTANCE, 8, IRFunctionArgs.totalIRArgs(), (org.llvm.ir.Type /*P*/ )null);
      
      // Add type for sret argument.
      if (IRFunctionArgs.hasSRetArg()) {
        QualType Ret = FI.getReturnType().$QualType();
        org.llvm.ir.Type /*P*/ Ty = ConvertType(new QualType(Ret));
        /*uint*/int AddressSpace = Context.getTargetAddressSpace(new QualType(Ret));
        ArgTypes.$set(IRFunctionArgs.getSRetArgNo(), 
          org.llvm.ir.PointerType.get(Ty, AddressSpace));
      }
      
      // Add type for inalloca argument.
      if (IRFunctionArgs.hasInallocaArg()) {
        StructType /*P*/ ArgStruct = FI.getArgStruct();
        assert Native.$bool(ArgStruct);
        ArgTypes.$set(IRFunctionArgs.getInallocaArgNo(), ArgStruct.getPointerTo());
      }
      
      // Add in all of the required arguments.
      /*uint*/int ArgNo = 0;
      type$ptr</*const*/ CGFunctionInfoArgInfo /*P*/ > it = $tryClone(FI.arg_begin$Const());
      type$ptr</*const*/ CGFunctionInfoArgInfo /*P*/ > ie = $tryClone(it.$add(FI.getNumRequiredArgs()));
      for (; $noteq_ptr(it, ie); it.$preInc() , ++ArgNo) {
        final /*const*/ ABIArgInfo /*&*/ ArgInfo = it./*->*/$star().info;
        
        // Insert a padding type to ensure proper alignment.
        if (IRFunctionArgs.hasPaddingArg(ArgNo)) {
          ArgTypes.$set(IRFunctionArgs.getPaddingArgNo(ArgNo), 
            ArgInfo.getPaddingType());
        }
        
        /*uint*/int FirstIRArg;
        /*uint*/int NumIRArgs;
        // JAVA: std.tie(FirstIRArg, NumIRArgs).$assign(IRFunctionArgs.getIRArgs(ArgNo));
        pairUIntUInt $pair = IRFunctionArgs.getIRArgs(ArgNo);
        FirstIRArg = $pair.first;
        NumIRArgs = $pair.second;
        switch (ArgInfo.getKind()) {
         case Ignore:
         case InAlloca:
          assert (NumIRArgs == 0);
          break;
         case Indirect:
          {
            assert (NumIRArgs == 1);
            // indirect arguments are always on the stack, which is addr space #0.
            org.llvm.ir.Type /*P*/ LTy = ConvertTypeForMem(it./*->*/$star().type.$QualType());
            ArgTypes.$set(FirstIRArg, LTy.getPointerTo());
            break;
          }
         case Extend:
         case Direct:
          {
            // Fast-isel and the optimizer generally like scalar values better than
            // FCAs, so we flatten them if this is safe to do for this argument.
            org.llvm.ir.Type /*P*/ argType = ArgInfo.getCoerceToType();
            StructType /*P*/ st = dyn_cast_StructType(argType);
            if ((st != null) && ArgInfo.isDirect() && ArgInfo.getCanBeFlattened()) {
              assert (NumIRArgs == st.getNumElements());
              for (/*uint*/int i = 0, e = st.getNumElements(); i != e; ++i)  {
                ArgTypes.$set(FirstIRArg + i, st.getElementType(i));
              }
            } else {
              assert (NumIRArgs == 1);
              ArgTypes.$set(FirstIRArg, argType);
            }
            break;
          }
         case CoerceAndExpand:
          {
            type$ptr<org.llvm.ir.Type /*P*/ /*P*/> ArgTypesIter = $tryClone(ArgTypes.begin().$add(FirstIRArg));
            for (org.llvm.ir.Type /*P*/ EltTy : ArgInfo.getCoerceAndExpandTypeSequence()) {
              ArgTypesIter.$postInc().$set(EltTy);
            }
            assert ($eq_ptr(ArgTypesIter, ArgTypes.begin().$add(FirstIRArg).$add(NumIRArgs)));
            break;
          }
         case Expand:
          type$ptr<org.llvm.ir.Type /*P*/ /*P*/> ArgTypesIter = $tryClone(ArgTypes.begin().$add(FirstIRArg));
          getExpandedTypes(it./*->*/$star().type.$QualType(), ArgTypesIter);
          assert ($eq_ptr(ArgTypesIter, ArgTypes.begin().$add(FirstIRArg).$add(NumIRArgs)));
          break;
        }
      }
      
      boolean Erased = FunctionsBeingProcessed.erase($AddrOf(FI));
      ///*J:(void)*/Erased;
      assert (Erased) : "Not in set?";
      
      return org.llvm.ir.FunctionType.get(resultType, new ArrayRef<org.llvm.ir.Type /*P*/ >(ArgTypes, true), FI.isVariadic());
    } finally {
      if (IRFunctionArgs != null) { IRFunctionArgs.$destroy(); }
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenTypes::GetFunctionType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp", line = 1460,
   FQN="clang::CodeGen::CodeGenTypes::GetFunctionType", NM="_ZN5clang7CodeGen12CodeGenTypes15GetFunctionTypeENS_10GlobalDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZN5clang7CodeGen12CodeGenTypes15GetFunctionTypeENS_10GlobalDeclE")
  //</editor-fold>
  public org.llvm.ir.FunctionType /*P*/ GetFunctionType(GlobalDecl GD) {
    final /*const*/ CGFunctionInfo /*&*/ FI = arrangeGlobalDeclaration(new GlobalDecl(GD));
    return GetFunctionType(FI);
  }

  
  /// isFuncTypeConvertible - Utility to check whether a function type can
  /// be converted to an LLVM type (i.e. doesn't depend on an incomplete tag
  /// type).
  
  /// isFuncTypeConvertible - Utility to check whether a function type can
  /// be converted to an LLVM type (i.e. doesn't depend on an incomplete tag
  /// type).
  
  /// Code to verify a given function type is complete, i.e. the return type
  /// and all of the parameter types are complete.  Also check to see if we are in
  /// a RS_StructPointer context, and if so whether any struct types have been
  /// pended.  If so, we don't want to ask the ABI lowering code to handle a type
  /// that cannot be converted to an IR type.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenTypes::isFuncTypeConvertible">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenTypes.cpp", line = 225,
   FQN="clang::CodeGen::CodeGenTypes::isFuncTypeConvertible", NM="_ZN5clang7CodeGen12CodeGenTypes21isFuncTypeConvertibleEPKNS_12FunctionTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenTypes.cpp -nm=_ZN5clang7CodeGen12CodeGenTypes21isFuncTypeConvertibleEPKNS_12FunctionTypeE")
  //</editor-fold>
  public boolean isFuncTypeConvertible(/*const*/ org.clang.ast.FunctionType /*P*/ FT) {
    if (!isFuncParamTypeConvertible(FT.getReturnType())) {
      return false;
    }
    {
      
      /*const*/ FunctionProtoType /*P*/ FPT = dyn_cast_FunctionProtoType(FT);
      if ((FPT != null)) {
        for (/*uint*/int i = 0, e = FPT.getNumParams(); i != e; i++)  {
          if (!isFuncParamTypeConvertible(FPT.getParamType(i))) {
            return false;
          }
        }
      }
    }
    
    return true;
  }


  
  /// isFuncParamTypeConvertible - Return true if the specified type in a
  /// function parameter or result position can be converted to an IR type at this
  /// point.  This boils down to being whether it is complete, as well as whether
  /// we've temporarily deferred expanding the type because we're in a recursive
  /// context.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenTypes::isFuncParamTypeConvertible">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenTypes.cpp", line = 191,
   FQN="clang::CodeGen::CodeGenTypes::isFuncParamTypeConvertible", NM="_ZN5clang7CodeGen12CodeGenTypes26isFuncParamTypeConvertibleENS_8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenTypes.cpp -nm=_ZN5clang7CodeGen12CodeGenTypes26isFuncParamTypeConvertibleENS_8QualTypeE")
  //</editor-fold>
  public boolean isFuncParamTypeConvertible(QualType Ty) {
    {
      // Some ABIs cannot have their member pointers represented in IR unless
      // certain circumstances have been reached.
      /*const*/ MemberPointerType /*P*/ MPT = Ty.$arrow().getAs(MemberPointerType.class);
      if ((MPT != null)) {
        return getCXXABI().isMemberPointerConvertible(MPT);
      }
    }
    
    // If this isn't a tagged type, we can convert it!
    /*const*/ TagType /*P*/ TT = Ty.$arrow().getAs(TagType.class);
    if (!(TT != null)) {
      return true;
    }
    
    // Incomplete types cannot be converted.
    if (TT.isIncompleteType()) {
      return false;
    }
    
    // If this is an enum, then it is always safe to convert.
    /*const*/ RecordType /*P*/ RT = dyn_cast_RecordType(TT);
    if (!(RT != null)) {
      return true;
    }
    
    // Otherwise, we have to be careful.  If it is a struct that we're in the
    // process of expanding, then we can't convert the function type.  That's ok
    // though because we must be in a pointer context under the struct, so we can
    // just convert it to a dummy type.
    //
    // We decide this by checking whether ConvertRecordDeclType returns us an
    // opaque type for a struct that we know is defined.
    return CodeGenTypesStatics.isSafeToConvert(RT.getDecl(), /*Deref*/this);
  }


  
  /// Determine if a C++ inheriting constructor should have parameters matching
  /// those of its inherited constructor.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenTypes::inheritingCtorHasParams">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp", line = 248,
   FQN="clang::CodeGen::CodeGenTypes::inheritingCtorHasParams", NM="_ZN5clang7CodeGen12CodeGenTypes23inheritingCtorHasParamsERKNS_20InheritedConstructorENS_11CXXCtorTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZN5clang7CodeGen12CodeGenTypes23inheritingCtorHasParamsERKNS_20InheritedConstructorENS_11CXXCtorTypeE")
  //</editor-fold>
  public boolean inheritingCtorHasParams(final /*const*/ InheritedConstructor /*&*/ Inherited, CXXCtorType Type) {
    // Parameters are unnecessary if we're constructing a base class subobject
    // and the inherited constructor lives in a virtual base.
    return Type == CXXCtorType.Ctor_Complete
       || !Inherited.getShadowDecl().constructsVirtualBase()
       || !Target.getCXXABI().hasConstructorVariants();
  }

  
  /// GetFunctionTypeForVTable - Get the LLVM function type for use in a vtable,
  /// given a CXXMethodDecl. If the method to has an incomplete return type,
  /// and/or incomplete argument types, this will return the opaque type.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenTypes::GetFunctionTypeForVTable">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp", line = 1593,
   FQN="clang::CodeGen::CodeGenTypes::GetFunctionTypeForVTable", NM="_ZN5clang7CodeGen12CodeGenTypes24GetFunctionTypeForVTableENS_10GlobalDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZN5clang7CodeGen12CodeGenTypes24GetFunctionTypeForVTableENS_10GlobalDeclE")
  //</editor-fold>
  public org.llvm.ir.Type /*P*/ GetFunctionTypeForVTable(GlobalDecl GD) {
    /*const*/ CXXMethodDecl /*P*/ MD = cast_CXXMethodDecl(GD.getDecl());
    /*const*/ FunctionProtoType /*P*/ FPT = MD.getType().$arrow().getAs(FunctionProtoType.class);
    if (!isFuncTypeConvertible(FPT)) {
      return StructType.get(getLLVMContext());
    }
    
    /*const*/ CGFunctionInfo /*P*/ Info;
    if (isa_CXXDestructorDecl(MD)) {
      Info
         = $AddrOf(arrangeCXXStructorDeclaration(MD, CodeGenStatics.getFromDtorType(GD.getDtorType())));
    } else {
      Info = $AddrOf(arrangeCXXMethodDeclaration(MD));
    }
    return GetFunctionType($Deref(Info));
  }

  
  /// getCGRecordLayout - Return record layout info for the given record decl.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenTypes::getCGRecordLayout">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenTypes.cpp", line = 722,
   FQN="clang::CodeGen::CodeGenTypes::getCGRecordLayout", NM="_ZN5clang7CodeGen12CodeGenTypes17getCGRecordLayoutEPKNS_10RecordDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenTypes.cpp -nm=_ZN5clang7CodeGen12CodeGenTypes17getCGRecordLayoutEPKNS_10RecordDeclE")
  //</editor-fold>
  public /*const*/ CGRecordLayout /*&*/ getCGRecordLayout(/*const*/ RecordDecl /*P*/ RD) {
    /*const*/ org.clang.ast.Type /*P*/ Key = Context.getTagDeclType(RD).getTypePtr();
    
    /*const*/ CGRecordLayout /*P*/ Layout = CGRecordLayouts.lookup(Key);
    if (!(Layout != null)) {
      // Compute the type information.
      ConvertRecordDeclType(RD);
      
      // Now try again.
      Layout = CGRecordLayouts.lookup(Key);
    }
    assert ((Layout != null)) : "Unable to find record layout information for type";
    return $Deref(Layout);
  }


  
  /// UpdateCompletedType - When we find the full definition for a TagDecl,
  /// replace the 'opaque' type we previously made for it if applicable.
  
  /// UpdateCompletedType - When we find the full definition for a TagDecl,
  /// replace the 'opaque' type we previously made for it if applicable.
  
  /// UpdateCompletedType - When we find the full definition for a TagDecl,
  /// replace the 'opaque' type we previously made for it if applicable.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenTypes::UpdateCompletedType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenTypes.cpp", line = 239,
   FQN="clang::CodeGen::CodeGenTypes::UpdateCompletedType", NM="_ZN5clang7CodeGen12CodeGenTypes19UpdateCompletedTypeEPKNS_7TagDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenTypes.cpp -nm=_ZN5clang7CodeGen12CodeGenTypes19UpdateCompletedTypeEPKNS_7TagDeclE")
  //</editor-fold>
  public void UpdateCompletedType(/*const*/ TagDecl /*P*/ TD) {
    {
      // If this is an enum being completed, then we flush all non-struct types from
      // the cache.  This allows function types and other things that may be derived
      // from the enum to be recomputed.
      /*const*/ EnumDecl /*P*/ ED = dyn_cast_EnumDecl(TD);
      if ((ED != null)) {
        // Only flush the cache if we've actually already converted this type.
        if ((TypeCache.count(ED.getTypeForDecl()) != 0)) {
          // Okay, we formed some types based on this.  We speculated that the enum
          // would be lowered to i32, so we only need to flush the cache if this
          // didn't happen.
          if (!ConvertType(ED.getIntegerType()).isIntegerTy(32)) {
            TypeCache.clear();
          }
        }
        {
          // If necessary, provide the full definition of a type only used with a
          // declaration so far.
          CGDebugInfo /*P*/ DI = CGM.getModuleDebugInfo();
          if ((DI != null)) {
            DI.completeType(ED);
          }
        }
        return;
      }
    }
    
    // If we completed a RecordDecl that we previously used and converted to an
    // anonymous type, then go ahead and complete it now.
    /*const*/ RecordDecl /*P*/ RD = cast_RecordDecl(TD);
    if (RD.isDependentType()) {
      return;
    }
    
    // Only complete it if we converted it already.  If we haven't converted it
    // yet, we'll just do it lazily.
    if ((RecordDeclTypes.count(Context.getTagDeclType(RD).getTypePtr()) != 0)) {
      ConvertRecordDeclType(RD);
    }
    {
      
      // If necessary, provide the full definition of a type only used with a
      // declaration so far.
      CGDebugInfo /*P*/ DI = CGM.getModuleDebugInfo();
      if ((DI != null)) {
        DI.completeType(RD);
      }
    }
  }


  
  /// \brief Remove stale types from the type cache when an inheritance model
  /// gets assigned to a class.
  
  /// \brief Remove stale types from the type cache when an inheritance model
  /// gets assigned to a class.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenTypes::RefreshTypeCacheForClass">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenTypes.cpp", line = 275,
   FQN="clang::CodeGen::CodeGenTypes::RefreshTypeCacheForClass", NM="_ZN5clang7CodeGen12CodeGenTypes24RefreshTypeCacheForClassEPKNS_13CXXRecordDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenTypes.cpp -nm=_ZN5clang7CodeGen12CodeGenTypes24RefreshTypeCacheForClassEPKNS_13CXXRecordDeclE")
  //</editor-fold>
  public void RefreshTypeCacheForClass(/*const*/ CXXRecordDecl /*P*/ RD) {
    QualType T = Context.getRecordType(RD);
    T.$assignMove(Context.getCanonicalType(/*NO_COPY*/T).$QualType());
    
    /*const*/ org.clang.ast.Type /*P*/ Ty = T.getTypePtr();
    if ((RecordsWithOpaqueMemberPointers.count(Ty) != 0)) {
      TypeCache.clear();
      RecordsWithOpaqueMemberPointers.clear();
    }
  }


  
  // The arrangement methods are split into three families:
  //   - those meant to drive the signature and prologue/epilogue
  //     of a function declaration or definition,
  //   - those meant for the computation of the LLVM type for an abstract
  //     appearance of a function, and
  //   - those meant for performing the IR-generation of a call.
  // They differ mainly in how they deal with optional (i.e. variadic)
  // arguments, as well as unprototyped functions.
  //
  // Key points:
  // - The CGFunctionInfo for emitting a specific call site must include
  //   entries for the optional arguments.
  // - The function type used at the call site must reflect the formal
  //   signature of the declaration being called, or else the call will
  //   go awry.
  // - For the most part, unprototyped functions are called by casting to
  //   a formal signature inferred from the specific argument types used
  //   at the call-site.  However, some targets (e.g. x86-64) screw with
  //   this for compatibility reasons.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenTypes::arrangeGlobalDeclaration">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp", line = 455,
   FQN="clang::CodeGen::CodeGenTypes::arrangeGlobalDeclaration", NM="_ZN5clang7CodeGen12CodeGenTypes24arrangeGlobalDeclarationENS_10GlobalDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZN5clang7CodeGen12CodeGenTypes24arrangeGlobalDeclarationENS_10GlobalDeclE")
  //</editor-fold>
  public /*const*/ CGFunctionInfo /*&*/ arrangeGlobalDeclaration(GlobalDecl GD) {
    // FIXME: Do we need to handle ObjCMethodDecl?
    /*const*/ FunctionDecl /*P*/ FD = cast_FunctionDecl(GD.getDecl());
    {
      
      /*const*/ CXXConstructorDecl /*P*/ CD = dyn_cast_CXXConstructorDecl(FD);
      if ((CD != null)) {
        return arrangeCXXStructorDeclaration(CD, CodeGenStatics.getFromCtorType(GD.getCtorType()));
      }
    }
    {
      
      /*const*/ CXXDestructorDecl /*P*/ DD = dyn_cast_CXXDestructorDecl(FD);
      if ((DD != null)) {
        return arrangeCXXStructorDeclaration(DD, CodeGenStatics.getFromDtorType(GD.getDtorType()));
      }
    }
    
    return arrangeFunctionDeclaration(FD);
  }

  
  /// Given a function info for a declaration, return the function info
  /// for a call with the given arguments.
  ///
  /// Often this will be able to simply return the declaration info.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenTypes::arrangeCall">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp", line = 642,
   FQN="clang::CodeGen::CodeGenTypes::arrangeCall", NM="_ZN5clang7CodeGen12CodeGenTypes11arrangeCallERKNS0_14CGFunctionInfoERKNS0_11CallArgListE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZN5clang7CodeGen12CodeGenTypes11arrangeCallERKNS0_14CGFunctionInfoERKNS0_11CallArgListE")
  //</editor-fold>
  public /*const*/ CGFunctionInfo /*&*/ arrangeCall(final /*const*/ CGFunctionInfo /*&*/ signature, 
             final /*const*/ CallArgList /*&*/ args) {
    assert ($lesseq_uint(signature.arg_size(), args.size()));
    if (signature.arg_size() == args.size()) {
      return signature;
    }
    
    SmallVector<FunctionProtoType.ExtParameterInfo> paramInfos/*J*/= new SmallVector<FunctionProtoType.ExtParameterInfo>(16, new FunctionProtoType.ExtParameterInfo());
    ArrayRef<FunctionProtoType.ExtParameterInfo> sigParamInfos = signature.getExtParameterInfos();
    if (!sigParamInfos.empty()) {
      paramInfos.append_T(sigParamInfos.begin(), sigParamInfos.end());
      paramInfos.resize(args.size());
    }
    
    SmallVector<CanQual<org.clang.ast.Type>> argTypes = CGCallStatics.getArgTypesForCall(Context, args);
    assert (signature.getRequiredArgs().allowsOptionalArgs());
    return arrangeLLVMFunctionInfo(signature.getReturnType(), 
        signature.isInstanceMethod(), 
        signature.isChainCall(), 
        new ArrayRef<CanQual<org.clang.ast.Type>>(argTypes, false), 
        signature.getExtInfo(), 
        new ArrayRef<FunctionProtoType.ExtParameterInfo>(paramInfos, false), 
        signature.getRequiredArgs());
  }

  
  /// Free functions are functions that are compatible with an ordinary
  /// C function pointer type.
  
  /// Arrange the argument and result information for the declaration or
  /// definition of the given function.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenTypes::arrangeFunctionDeclaration">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp", line = 379,
   FQN="clang::CodeGen::CodeGenTypes::arrangeFunctionDeclaration", NM="_ZN5clang7CodeGen12CodeGenTypes26arrangeFunctionDeclarationEPKNS_12FunctionDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZN5clang7CodeGen12CodeGenTypes26arrangeFunctionDeclarationEPKNS_12FunctionDeclE")
  //</editor-fold>
  public /*const*/ CGFunctionInfo /*&*/ arrangeFunctionDeclaration(/*const*/ FunctionDecl /*P*/ FD) {
    {
      /*const*/ CXXMethodDecl /*P*/ MD = dyn_cast_CXXMethodDecl(FD);
      if ((MD != null)) {
        if (MD.isInstance()) {
          return arrangeCXXMethodDeclaration(MD);
        }
      }
    }
    
    CanQual<org.clang.ast.Type> FTy = FD.getType().$arrow().getCanonicalTypeUnqualified();
    assert (isa_FunctionType(FTy));
    
    // When declaring a function without a prototype, always use a
    // non-variadic type.
    if (isa_FunctionNoProtoType(FTy)) {
      CanQual<FunctionNoProtoType> noProto = ((CanProxyFunctionNoProtoType)FTy.getAs(FunctionNoProtoType.class)).$CanQual$T();
      return arrangeLLVMFunctionInfo(((CanProxyFunctionNoProtoType)noProto.$arrow(FunctionNoProtoType.class)).$arrow().getReturnType(), /*instanceMethod=*/ false, 
          /*chainCall=*/ false, new ArrayRef<CanQual<org.clang.ast.Type>>(None, false), ((CanProxyFunctionNoProtoType)noProto.$arrow(FunctionNoProtoType.class)).$arrow().getExtInfo(), /*{ */new ArrayRef<FunctionProtoType.ExtParameterInfo>(false)/* }*/, new RequiredArgs(RequiredArgs.All_t.All));
    }
    assert (isa_FunctionProtoType(FTy));
    return arrangeFreeFunctionType(((CanProxyFunctionProtoType)FTy.getAs(FunctionProtoType.class)).$CanQual$T(), FD);
  }

  
  /// Figure out the rules for calling a function with the given formal
  /// type using the given arguments.  The arguments are necessary
  /// because the function might be unprototyped, in which case it's
  /// target-dependent in crazy ways.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenTypes::arrangeFreeFunctionCall">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp", line = 555,
   FQN="clang::CodeGen::CodeGenTypes::arrangeFreeFunctionCall", NM="_ZN5clang7CodeGen12CodeGenTypes23arrangeFreeFunctionCallERKNS0_11CallArgListEPKNS_12FunctionTypeEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZN5clang7CodeGen12CodeGenTypes23arrangeFreeFunctionCallERKNS0_11CallArgListEPKNS_12FunctionTypeEb")
  //</editor-fold>
  public /*const*/ CGFunctionInfo /*&*/ arrangeFreeFunctionCall(final /*const*/ CallArgList /*&*/ args, 
                         /*const*/ org.clang.ast.FunctionType /*P*/ fnType, 
                         boolean chainCall) {
    return CGCallStatics.arrangeFreeFunctionLikeCall(/*Deref*/this, CGM, args, fnType, 
        chainCall ? 1 : 0, chainCall);
  }

  
  /// Arrange the argument and result information for a value of the
  /// given freestanding function type.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenTypes::arrangeFreeFunctionType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp", line = 159,
   FQN="clang::CodeGen::CodeGenTypes::arrangeFreeFunctionType", NM="_ZN5clang7CodeGen12CodeGenTypes23arrangeFreeFunctionTypeENS_7CanQualINS_17FunctionProtoTypeEEEPKNS_12FunctionDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZN5clang7CodeGen12CodeGenTypes23arrangeFreeFunctionTypeENS_7CanQualINS_17FunctionProtoTypeEEEPKNS_12FunctionDeclE")
  //</editor-fold>
  public /*const*/ CGFunctionInfo /*&*/ arrangeFreeFunctionType(CanQual<FunctionProtoType> FTP, 
                         /*const*/ FunctionDecl /*P*/ FD) {
    SmallVector<CanQual<org.clang.ast.Type>> argTypes/*J*/= new SmallVector<CanQual<org.clang.ast.Type>>(16, new CanQual<org.clang.ast.Type>());
    return /*::*/CGCallStatics.arrangeLLVMFunctionInfo(/*Deref*/this, /*instanceMethod=*/ false, argTypes, 
        new CanQual<FunctionProtoType>(FTP), FD);
  }

  
  /// Arrange the argument and result information for a value of the given
  /// unprototyped freestanding function type.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenTypes::arrangeFreeFunctionType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp", line = 92,
   FQN="clang::CodeGen::CodeGenTypes::arrangeFreeFunctionType", NM="_ZN5clang7CodeGen12CodeGenTypes23arrangeFreeFunctionTypeENS_7CanQualINS_19FunctionNoProtoTypeEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZN5clang7CodeGen12CodeGenTypes23arrangeFreeFunctionTypeENS_7CanQualINS_19FunctionNoProtoTypeEEE")
  //</editor-fold>
  public /*const*/ CGFunctionInfo /*&*/ arrangeFreeFunctionType(CanQual<FunctionNoProtoType> FTNP) {
    // When translating an unprototyped function type, always use a
    // variadic type.
    return arrangeLLVMFunctionInfo(((CanProxyFunctionNoProtoType)FTNP.$arrow(FunctionNoProtoType.class)).$arrow().getReturnType().getUnqualifiedType(), 
        /*instanceMethod=*/ false, 
        /*chainCall=*/ false, new ArrayRef<CanQual<org.clang.ast.Type>>(None, false), 
        ((CanProxyFunctionNoProtoType)FTNP.$arrow(FunctionNoProtoType.class)).$arrow().getExtInfo(), /*{ */new ArrayRef<FunctionProtoType.ExtParameterInfo>(false)/* }*/, new RequiredArgs(0));
  }

  
  /// A nullary function is a freestanding function of type 'void ()'.
  /// This method works for both calls and declarations.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenTypes::arrangeNullaryFunction">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp", line = 636,
   FQN="clang::CodeGen::CodeGenTypes::arrangeNullaryFunction", NM="_ZN5clang7CodeGen12CodeGenTypes22arrangeNullaryFunctionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZN5clang7CodeGen12CodeGenTypes22arrangeNullaryFunctionEv")
  //</editor-fold>
  public /*const*/ CGFunctionInfo /*&*/ arrangeNullaryFunction() {
    return arrangeLLVMFunctionInfo(new CanQual<org.clang.ast.Type>(getContext().VoidTy), /*instanceMethod=*/ false, /*chainCall=*/ false, 
        new ArrayRef<CanQual<org.clang.ast.Type>>(None, false), new org.clang.ast.FunctionType.ExtInfo(), /*{ */new ArrayRef<FunctionProtoType.ExtParameterInfo>(false)/* }*/, new RequiredArgs(RequiredArgs.All_t.All));
  }

  
  /// A builtin function is a freestanding function using the default
  /// C conventions.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenTypes::arrangeBuiltinFunctionDeclaration">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp", line = 598,
   FQN="clang::CodeGen::CodeGenTypes::arrangeBuiltinFunctionDeclaration", NM="_ZN5clang7CodeGen12CodeGenTypes33arrangeBuiltinFunctionDeclarationENS_8QualTypeERKNS0_15FunctionArgListE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZN5clang7CodeGen12CodeGenTypes33arrangeBuiltinFunctionDeclarationENS_8QualTypeERKNS0_15FunctionArgListE")
  //</editor-fold>
  public /*const*/ CGFunctionInfo /*&*/ arrangeBuiltinFunctionDeclaration(QualType resultType, 
                                   final /*const*/ FunctionArgList /*&*/ args) {
    SmallVector<CanQual<org.clang.ast.Type>> argTypes = CGCallStatics.getArgTypesForDeclaration(Context, args);
    
    return arrangeLLVMFunctionInfo(CGCallStatics.GetReturnType(new QualType(resultType)), /*instanceMethod=*/ false, /*chainCall=*/ false, 
        new ArrayRef<CanQual<org.clang.ast.Type>>(argTypes, false), new org.clang.ast.FunctionType.ExtInfo(), /*{ */new ArrayRef<FunctionProtoType.ExtParameterInfo>(false)/* }*/, new RequiredArgs(RequiredArgs.All_t.All));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenTypes::arrangeBuiltinFunctionDeclaration">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp", line = 608,
   FQN="clang::CodeGen::CodeGenTypes::arrangeBuiltinFunctionDeclaration", NM="_ZN5clang7CodeGen12CodeGenTypes33arrangeBuiltinFunctionDeclarationENS_7CanQualINS_4TypeEEEN4llvm8ArrayRefIS4_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZN5clang7CodeGen12CodeGenTypes33arrangeBuiltinFunctionDeclarationENS_7CanQualINS_4TypeEEEN4llvm8ArrayRefIS4_EE")
  //</editor-fold>
  public /*const*/ CGFunctionInfo /*&*/ arrangeBuiltinFunctionDeclaration(CanQual<org.clang.ast.Type> resultType, 
                                   ArrayRef<CanQual<org.clang.ast.Type>> argTypes) {
    return arrangeLLVMFunctionInfo(new CanQual<org.clang.ast.Type>(resultType), /*instanceMethod=*/ false, /*chainCall=*/ false, 
        new ArrayRef<CanQual<org.clang.ast.Type>>(argTypes), new org.clang.ast.FunctionType.ExtInfo(), /*{ */new ArrayRef<FunctionProtoType.ExtParameterInfo>(false)/* }*/, new RequiredArgs(RequiredArgs.All_t.All));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenTypes::arrangeBuiltinFunctionCall">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp", line = 585,
   FQN="clang::CodeGen::CodeGenTypes::arrangeBuiltinFunctionCall", NM="_ZN5clang7CodeGen12CodeGenTypes26arrangeBuiltinFunctionCallENS_8QualTypeERKNS0_11CallArgListE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZN5clang7CodeGen12CodeGenTypes26arrangeBuiltinFunctionCallENS_8QualTypeERKNS0_11CallArgListE")
  //</editor-fold>
  public /*const*/ CGFunctionInfo /*&*/ arrangeBuiltinFunctionCall(QualType resultType, 
                            final /*const*/ CallArgList /*&*/ args) {
    // FIXME: Kill copy.
    SmallVector<CanQual<org.clang.ast.Type>> argTypes/*J*/= new SmallVector<CanQual<org.clang.ast.Type>>(16, new CanQual<org.clang.ast.Type>());
    for (final /*const*/ CallArg /*&*/ Arg : args)  {
      argTypes.push_back(Context.getCanonicalParamType(new QualType(Arg.Ty)));
    }
    return arrangeLLVMFunctionInfo(CGCallStatics.GetReturnType(new QualType(resultType)), /*instanceMethod=*/ false, 
        /*chainCall=*/ false, new ArrayRef<CanQual<org.clang.ast.Type>>(argTypes, false), new org.clang.ast.FunctionType.ExtInfo(), 
        /*paramInfos=*/ /*{ */new ArrayRef<FunctionProtoType.ExtParameterInfo>(false)/* }*/, new RequiredArgs(RequiredArgs.All_t.All));
  }

  
  /// Objective-C methods are C functions with some implicit parameters.
  
  /// Arrange the argument and result information for the declaration or
  /// definition of an Objective-C method.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenTypes::arrangeObjCMethodDeclaration">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp", line = 404,
   FQN="clang::CodeGen::CodeGenTypes::arrangeObjCMethodDeclaration", NM="_ZN5clang7CodeGen12CodeGenTypes28arrangeObjCMethodDeclarationEPKNS_14ObjCMethodDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZN5clang7CodeGen12CodeGenTypes28arrangeObjCMethodDeclarationEPKNS_14ObjCMethodDeclE")
  //</editor-fold>
  public /*const*/ CGFunctionInfo /*&*/ arrangeObjCMethodDeclaration(/*const*/ ObjCMethodDecl /*P*/ MD) {
    // It happens that this is the same as a call with no optional
    // arguments, except also using the formal 'self' type.
    return arrangeObjCMessageSendSignature(MD, MD.getSelfDecl().getType());
  }

  
  /// Arrange the argument and result information for the function type
  /// through which to perform a send to the given Objective-C method,
  /// using the given receiver type.  The receiver type is not always
  /// the 'self' type of the method or even an Objective-C pointer type.
  /// This is *not* the right method for actually performing such a
  /// message send, due to the possibility of optional arguments.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenTypes::arrangeObjCMessageSendSignature">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp", line = 417,
   FQN="clang::CodeGen::CodeGenTypes::arrangeObjCMessageSendSignature", NM="_ZN5clang7CodeGen12CodeGenTypes31arrangeObjCMessageSendSignatureEPKNS_14ObjCMethodDeclENS_8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZN5clang7CodeGen12CodeGenTypes31arrangeObjCMessageSendSignatureEPKNS_14ObjCMethodDeclENS_8QualTypeE")
  //</editor-fold>
  public /*const*/ CGFunctionInfo /*&*/ arrangeObjCMessageSendSignature(/*const*/ ObjCMethodDecl /*P*/ MD, 
                                 QualType receiverType) {
    SmallVector<CanQual<org.clang.ast.Type>> argTys/*J*/= new SmallVector<CanQual<org.clang.ast.Type>>(16, new CanQual<org.clang.ast.Type>());
    argTys.push_back(Context.getCanonicalParamType(new QualType(receiverType)));
    argTys.push_back(Context.getCanonicalParamType(Context.getObjCSelType()));
    // FIXME: Kill copy?
    for (/*const*/ ParmVarDecl /*P*/ I : MD.parameters()) {
      argTys.push_back(Context.getCanonicalParamType(I.getType()));
    }
    
    org.clang.ast.FunctionType.ExtInfo einfo/*J*/= new org.clang.ast.FunctionType.ExtInfo();
    boolean IsWindows = getContext().getTargetInfo().getTriple().isOSWindows();
    einfo.$assignMove(einfo.withCallingConv(CGCallStatics.getCallingConventionForDecl(MD, IsWindows)));
    if (getContext().getLangOpts().ObjCAutoRefCount
       && MD.hasAttr(NSReturnsRetainedAttr.class)) {
      einfo.$assignMove(einfo.withProducesResult(true));
    }
    
    RequiredArgs required = (MD.isVariadic() ? new RequiredArgs(argTys.size()) : new RequiredArgs(RequiredArgs.All_t.All));
    
    return arrangeLLVMFunctionInfo(CGCallStatics.GetReturnType(MD.getReturnType()), /*instanceMethod=*/ false, 
        /*chainCall=*/ false, new ArrayRef<CanQual<org.clang.ast.Type>>(argTys, false), new org.clang.ast.FunctionType.ExtInfo(einfo), /*{ */new ArrayRef<FunctionProtoType.ExtParameterInfo>(false)/* }*/, new RequiredArgs(required));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenTypes::arrangeUnprototypedObjCMessageSend">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp", line = 444,
   FQN="clang::CodeGen::CodeGenTypes::arrangeUnprototypedObjCMessageSend", NM="_ZN5clang7CodeGen12CodeGenTypes34arrangeUnprototypedObjCMessageSendENS_8QualTypeERKNS0_11CallArgListE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZN5clang7CodeGen12CodeGenTypes34arrangeUnprototypedObjCMessageSendENS_8QualTypeERKNS0_11CallArgListE")
  //</editor-fold>
  public /*const*/ CGFunctionInfo /*&*/ arrangeUnprototypedObjCMessageSend(QualType returnType, 
                                    final /*const*/ CallArgList /*&*/ args) {
    SmallVector<CanQual<org.clang.ast.Type>> argTypes = CGCallStatics.getArgTypesForCall(Context, args);
    org.clang.ast.FunctionType.ExtInfo einfo/*J*/= new org.clang.ast.FunctionType.ExtInfo();
    
    return arrangeLLVMFunctionInfo(CGCallStatics.GetReturnType(new QualType(returnType)), /*instanceMethod=*/ false, 
        /*chainCall=*/ false, new ArrayRef<CanQual<org.clang.ast.Type>>(argTypes, false), new org.clang.ast.FunctionType.ExtInfo(einfo), /*{ */new ArrayRef<FunctionProtoType.ExtParameterInfo>(false)/* }*/, new RequiredArgs(RequiredArgs.All_t.All));
  }

  
  /// Block invocation functions are C functions with an implicit parameter.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenTypes::arrangeBlockFunctionDeclaration">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp", line = 572,
   FQN="clang::CodeGen::CodeGenTypes::arrangeBlockFunctionDeclaration", NM="_ZN5clang7CodeGen12CodeGenTypes31arrangeBlockFunctionDeclarationEPKNS_17FunctionProtoTypeERKNS0_15FunctionArgListE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZN5clang7CodeGen12CodeGenTypes31arrangeBlockFunctionDeclarationEPKNS_17FunctionProtoTypeERKNS0_15FunctionArgListE")
  //</editor-fold>
  public /*const*/ CGFunctionInfo /*&*/ arrangeBlockFunctionDeclaration(/*const*/ FunctionProtoType /*P*/ proto, 
                                 final /*const*/ FunctionArgList /*&*/ params) {
    SmallVector<FunctionProtoType.ExtParameterInfo> paramInfos = CGCallStatics.getExtParameterInfosForCall(proto, 1, params.size());
    SmallVector<CanQual<org.clang.ast.Type>> argTypes = CGCallStatics.getArgTypesForDeclaration(Context, params);
    
    return arrangeLLVMFunctionInfo(CGCallStatics.GetReturnType(proto.getReturnType()), 
        /*instanceMethod*/ false, /*chainCall*/ false, new ArrayRef<CanQual<org.clang.ast.Type>>(argTypes, false), 
        proto.getExtInfo(), new ArrayRef<FunctionProtoType.ExtParameterInfo>(paramInfos, false), 
        RequiredArgs.forPrototypePlus(proto, 1, (/*const*/ FunctionDecl /*P*/ )null));
  }

  
  /// A block function is essentially a free function with an
  /// extra implicit argument.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenTypes::arrangeBlockFunctionCall">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp", line = 565,
   FQN="clang::CodeGen::CodeGenTypes::arrangeBlockFunctionCall", NM="_ZN5clang7CodeGen12CodeGenTypes24arrangeBlockFunctionCallERKNS0_11CallArgListEPKNS_12FunctionTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZN5clang7CodeGen12CodeGenTypes24arrangeBlockFunctionCallERKNS0_11CallArgListEPKNS_12FunctionTypeE")
  //</editor-fold>
  public /*const*/ CGFunctionInfo /*&*/ arrangeBlockFunctionCall(final /*const*/ CallArgList /*&*/ args, 
                          /*const*/ org.clang.ast.FunctionType /*P*/ fnType) {
    return CGCallStatics.arrangeFreeFunctionLikeCall(/*Deref*/this, CGM, args, fnType, 1, 
        /*chainCall=*/ false);
  }

  
  /// C++ methods have some special rules and also have implicit parameters.
  
  /// Arrange the argument and result information for a declaration or
  /// definition of the given C++ non-static member function.  The
  /// member function must be an ordinary function, i.e. not a
  /// constructor or destructor.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenTypes::arrangeCXXMethodDeclaration">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp", line = 232,
   FQN="clang::CodeGen::CodeGenTypes::arrangeCXXMethodDeclaration", NM="_ZN5clang7CodeGen12CodeGenTypes27arrangeCXXMethodDeclarationEPKNS_13CXXMethodDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZN5clang7CodeGen12CodeGenTypes27arrangeCXXMethodDeclarationEPKNS_13CXXMethodDeclE")
  //</editor-fold>
  public /*const*/ CGFunctionInfo /*&*/ arrangeCXXMethodDeclaration(/*const*/ CXXMethodDecl /*P*/ MD) {
    assert (!isa_CXXConstructorDecl(MD)) : "wrong method for constructors!";
    assert (!isa_CXXDestructorDecl(MD)) : "wrong method for destructors!";
    
    CanQual<FunctionProtoType> prototype = CGCallStatics.GetFormalType(MD);
    if (MD.isInstance()) {
      // The abstract case is perfectly fine.
      /*const*/ CXXRecordDecl /*P*/ ThisType = TheCXXABI.getThisArgumentTypeForMethod(MD);
      return arrangeCXXMethodType(ThisType, prototype.getTypePtr(), MD);
    }
    
    return arrangeFreeFunctionType(new CanQual<FunctionProtoType>(prototype), MD);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenTypes::arrangeCXXStructorDeclaration">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp", line = 257,
   FQN="clang::CodeGen::CodeGenTypes::arrangeCXXStructorDeclaration", NM="_ZN5clang7CodeGen12CodeGenTypes29arrangeCXXStructorDeclarationEPKNS_13CXXMethodDeclENS0_12StructorTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZN5clang7CodeGen12CodeGenTypes29arrangeCXXStructorDeclarationEPKNS_13CXXMethodDeclENS0_12StructorTypeE")
  //</editor-fold>
  public /*const*/ CGFunctionInfo /*&*/ arrangeCXXStructorDeclaration(/*const*/ CXXMethodDecl /*P*/ MD, 
                               StructorType Type) {
    
    SmallVector<CanQual<org.clang.ast.Type>> argTypes/*J*/= new SmallVector<CanQual<org.clang.ast.Type>>(16, new CanQual<org.clang.ast.Type>());
    SmallVector<FunctionProtoType.ExtParameterInfo> paramInfos/*J*/= new SmallVector<FunctionProtoType.ExtParameterInfo>(16, new FunctionProtoType.ExtParameterInfo());
    argTypes.push_back(CGCallStatics.GetThisType(Context, MD.getParent$Const()));
    
    boolean PassParams = true;
    
    GlobalDecl GD/*J*/= new GlobalDecl();
    {
      /*const*/ CXXConstructorDecl /*P*/ CD = dyn_cast_CXXConstructorDecl(MD);
      if ((CD != null)) {
        GD.$assignMove(new GlobalDecl(JD$CXXConstructorDecl$C$P_CXXCtorType.INSTANCE, CD, CodeGenStatics.toCXXCtorType(Type)));
        {
          
          // A base class inheriting constructor doesn't get forwarded arguments
          // needed to construct a virtual base (or base class thereof).
          InheritedConstructor Inherited = CD.getInheritedConstructor();
          if (Inherited.$bool()) {
            PassParams = inheritingCtorHasParams(Inherited, CodeGenStatics.toCXXCtorType(Type));
          }
        }
      } else {
        /*const*/ CXXDestructorDecl /*P*/ DD = dyn_cast_CXXDestructorDecl(MD);
        GD.$assignMove(new GlobalDecl(JD$CXXDestructorDecl$C$P_CXXDtorType.INSTANCE, DD, CodeGenStatics.toCXXDtorType(Type)));
      }
    }
    
    CanQual<FunctionProtoType> FTP = CGCallStatics.GetFormalType(MD);
    
    // Add the formal parameters.
    if (PassParams) {
      CGCallStatics.appendParameterTypes(/*Deref*/this, argTypes, paramInfos, new CanQual<FunctionProtoType>(FTP), MD);
    }
    
    TheCXXABI.buildStructorSignature(MD, Type, argTypes);
    
    RequiredArgs required = (PassParams && MD.isVariadic() ? new RequiredArgs(argTypes.size()) : new RequiredArgs(RequiredArgs.All_t.All));
    
    org.clang.ast.FunctionType.ExtInfo extInfo = ((CanProxyFunctionProtoType)FTP.$arrow(FunctionProtoType.class)).$arrow().getExtInfo();
    CanQual<org.clang.ast.Type> resultType = new CanQual<org.clang.ast.Type>(TheCXXABI.HasThisReturn(new GlobalDecl(GD)) ? argTypes.front() : TheCXXABI.hasMostDerivedReturn(new GlobalDecl(GD)) ? CGM.getContext().VoidPtrTy : Context.VoidTy);
    return arrangeLLVMFunctionInfo(new CanQual<org.clang.ast.Type>(resultType), /*instanceMethod=*/ true, 
        /*chainCall=*/ false, new ArrayRef<CanQual<org.clang.ast.Type>>(argTypes, false), new org.clang.ast.FunctionType.ExtInfo(extInfo), 
        new ArrayRef<FunctionProtoType.ExtParameterInfo>(paramInfos, false), new RequiredArgs(required));
  }

  
  /// Arrange a call to a C++ method, passing the given arguments.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenTypes::arrangeCXXConstructorCall">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp", line = 350,
   FQN="clang::CodeGen::CodeGenTypes::arrangeCXXConstructorCall", NM="_ZN5clang7CodeGen12CodeGenTypes25arrangeCXXConstructorCallERKNS0_11CallArgListEPKNS_18CXXConstructorDeclENS_11CXXCtorTypeEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZN5clang7CodeGen12CodeGenTypes25arrangeCXXConstructorCallERKNS0_11CallArgListEPKNS_18CXXConstructorDeclENS_11CXXCtorTypeEj")
  //</editor-fold>
  public /*const*/ CGFunctionInfo /*&*/ arrangeCXXConstructorCall(final /*const*/ CallArgList /*&*/ args, 
                           /*const*/ CXXConstructorDecl /*P*/ D, 
                           CXXCtorType CtorKind, 
                           /*uint*/int ExtraArgs) {
    // FIXME: Kill copy.
    SmallVector<CanQual<org.clang.ast.Type>> ArgTypes/*J*/= new SmallVector<CanQual<org.clang.ast.Type>>(16, new CanQual<org.clang.ast.Type>());
    for (final /*const*/ CallArg /*&*/ Arg : args)  {
      ArgTypes.push_back(Context.getCanonicalParamType(new QualType(Arg.Ty)));
    }
    
    CanQual<FunctionProtoType> FPT = CGCallStatics.GetFormalType(D);
    RequiredArgs Required = RequiredArgs.forPrototypePlus(new CanQual<FunctionProtoType>(FPT), 1 + ExtraArgs, D);
    GlobalDecl GD/*J*/= new GlobalDecl(JD$CXXConstructorDecl$C$P_CXXCtorType.INSTANCE, D, CtorKind);
    CanQual<org.clang.ast.Type> ResultType = new CanQual<org.clang.ast.Type>(TheCXXABI.HasThisReturn(new GlobalDecl(GD)) ? ArgTypes.front() : TheCXXABI.hasMostDerivedReturn(new GlobalDecl(GD)) ? CGM.getContext().VoidPtrTy : Context.VoidTy);
    
    org.clang.ast.FunctionType.ExtInfo Info = ((CanProxyFunctionProtoType)FPT.$arrow(FunctionProtoType.class)).$arrow().getExtInfo();
    SmallVector<FunctionProtoType.ExtParameterInfo> ParamInfos = CGCallStatics.getExtParameterInfosForCall(FPT.getTypePtr(), 1 + ExtraArgs, 
        ArgTypes.size());
    return arrangeLLVMFunctionInfo(new CanQual<org.clang.ast.Type>(ResultType), /*instanceMethod=*/ true, 
        /*chainCall=*/ false, new ArrayRef<CanQual<org.clang.ast.Type>>(ArgTypes, false), new org.clang.ast.FunctionType.ExtInfo(Info), 
        new ArrayRef<FunctionProtoType.ExtParameterInfo>(ParamInfos, false), new RequiredArgs(Required));
  }

  
  
  /// Arrange a call to a C++ method, passing the given arguments.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenTypes::arrangeCXXMethodCall">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp", line = 617,
   FQN="clang::CodeGen::CodeGenTypes::arrangeCXXMethodCall", NM="_ZN5clang7CodeGen12CodeGenTypes20arrangeCXXMethodCallERKNS0_11CallArgListEPKNS_17FunctionProtoTypeENS0_12RequiredArgsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZN5clang7CodeGen12CodeGenTypes20arrangeCXXMethodCallERKNS0_11CallArgListEPKNS_17FunctionProtoTypeENS0_12RequiredArgsE")
  //</editor-fold>
  public /*const*/ CGFunctionInfo /*&*/ arrangeCXXMethodCall(final /*const*/ CallArgList /*&*/ args, 
                      /*const*/ FunctionProtoType /*P*/ proto, 
                      RequiredArgs required) {
    /*uint*/int numRequiredArgs = (proto.isVariadic() ? required.getNumRequiredArgs() : args.size());
    /*uint*/int numPrefixArgs = numRequiredArgs - proto.getNumParams();
    SmallVector<FunctionProtoType.ExtParameterInfo> paramInfos = CGCallStatics.getExtParameterInfosForCall(proto, numPrefixArgs, args.size());
    
    // FIXME: Kill copy.
    SmallVector<CanQual<org.clang.ast.Type>> argTypes = CGCallStatics.getArgTypesForCall(Context, args);
    
    org.clang.ast.FunctionType.ExtInfo info = proto.getExtInfo();
    return arrangeLLVMFunctionInfo(CGCallStatics.GetReturnType(proto.getReturnType()), /*instanceMethod=*/ true, 
        /*chainCall=*/ false, new ArrayRef<CanQual<org.clang.ast.Type>>(argTypes, false), new org.clang.ast.FunctionType.ExtInfo(info), new ArrayRef<FunctionProtoType.ExtParameterInfo>(paramInfos, false), new RequiredArgs(required));
  }

  
  /// Arrange a thunk that takes 'this' as the first parameter followed by
  /// varargs.  Return a void pointer, regardless of the actual return type.
  /// The body of the thunk will end in a musttail call to a function of the
  /// correct type, and the caller will bitcast the function to the correct
  /// prototype.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenTypes::arrangeMSMemberPointerThunk">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp", line = 474,
   FQN="clang::CodeGen::CodeGenTypes::arrangeMSMemberPointerThunk", NM="_ZN5clang7CodeGen12CodeGenTypes27arrangeMSMemberPointerThunkEPKNS_13CXXMethodDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZN5clang7CodeGen12CodeGenTypes27arrangeMSMemberPointerThunkEPKNS_13CXXMethodDeclE")
  //</editor-fold>
  public /*const*/ CGFunctionInfo /*&*/ arrangeMSMemberPointerThunk(/*const*/ CXXMethodDecl /*P*/ MD) {
    assert (MD.isVirtual()) : "only virtual memptrs have thunks";
    CanQual<FunctionProtoType> FTP = CGCallStatics.GetFormalType(MD);
    CanQual<org.clang.ast.Type> ArgTys[/*1*/] = new CanQual/*<org.clang.ast.Type>*/ [/*1*/] {CGCallStatics.GetThisType(Context, MD.getParent$Const())};
    return arrangeLLVMFunctionInfo(new CanQual<org.clang.ast.Type>(Context.VoidTy), /*instanceMethod=*/ false, 
        /*chainCall=*/ false, new ArrayRef<CanQual<org.clang.ast.Type>>(ArgTys, false), 
        ((CanProxyFunctionProtoType)FTP.$arrow(FunctionProtoType.class)).$arrow().getExtInfo(), /*{ */new ArrayRef<FunctionProtoType.ExtParameterInfo>(false)/* }*/, new RequiredArgs(1));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenTypes::arrangeMSCtorClosure">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp", line = 484,
   FQN="clang::CodeGen::CodeGenTypes::arrangeMSCtorClosure", NM="_ZN5clang7CodeGen12CodeGenTypes20arrangeMSCtorClosureEPKNS_18CXXConstructorDeclENS_11CXXCtorTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZN5clang7CodeGen12CodeGenTypes20arrangeMSCtorClosureEPKNS_18CXXConstructorDeclENS_11CXXCtorTypeE")
  //</editor-fold>
  public /*const*/ CGFunctionInfo /*&*/ arrangeMSCtorClosure(/*const*/ CXXConstructorDecl /*P*/ CD, 
                      CXXCtorType CT) {
    assert (CT == CXXCtorType.Ctor_CopyingClosure || CT == CXXCtorType.Ctor_DefaultClosure);
    
    CanQual<FunctionProtoType> FTP = CGCallStatics.GetFormalType(CD);
    SmallVector<CanQual<org.clang.ast.Type>> ArgTys/*J*/= new SmallVector<CanQual<org.clang.ast.Type>>(2, new CanQual<org.clang.ast.Type>());
    /*const*/ CXXRecordDecl /*P*/ RD = CD.getParent$Const();
    ArgTys.push_back(CGCallStatics.GetThisType(Context, RD));
    if (CT == CXXCtorType.Ctor_CopyingClosure) {
      ArgTys.push_back(CanQual.CreateUnsafe(((CanProxyFunctionProtoType)FTP.$arrow(FunctionProtoType.class)).$arrow().param_type_begin().$star().$QualType()));
    }
    if ($greater_uint(RD.getNumVBases(), 0)) {
      ArgTys.push_back(Context.IntTy);
    }
    org.clang.basic.CallingConv CC = Context.getDefaultCallingConvention(/*IsVariadic=*/ false, /*IsCXXMethod=*/ true);
    return arrangeLLVMFunctionInfo(new CanQual<org.clang.ast.Type>(Context.VoidTy), /*instanceMethod=*/ true, 
        /*chainCall=*/ false, new ArrayRef<CanQual<org.clang.ast.Type>>(ArgTys, false), 
        new org.clang.ast.FunctionType.ExtInfo(CC), /*{ */new ArrayRef<FunctionProtoType.ExtParameterInfo>(false)/* }*/, 
        new RequiredArgs(RequiredArgs.All_t.All));
  }

  
  /// Arrange the argument and result information for a call to an
  /// unknown C++ non-static member function of the given abstract type.
  /// (Zero value of RD means we don't have any meaningful "this" argument type,
  ///  so fall back to a generic pointer type).
  /// The member function must be an ordinary function, i.e. not a
  /// constructor or destructor.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenTypes::arrangeCXXMethodType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp", line = 211,
   FQN="clang::CodeGen::CodeGenTypes::arrangeCXXMethodType", NM="_ZN5clang7CodeGen12CodeGenTypes20arrangeCXXMethodTypeEPKNS_13CXXRecordDeclEPKNS_17FunctionProtoTypeEPKNS_13CXXMethodDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZN5clang7CodeGen12CodeGenTypes20arrangeCXXMethodTypeEPKNS_13CXXRecordDeclEPKNS_17FunctionProtoTypeEPKNS_13CXXMethodDeclE")
  //</editor-fold>
  public /*const*/ CGFunctionInfo /*&*/ arrangeCXXMethodType(/*const*/ CXXRecordDecl /*P*/ RD, 
                      /*const*/ FunctionProtoType /*P*/ FTP, 
                      /*const*/ CXXMethodDecl /*P*/ MD) {
    SmallVector<CanQual<org.clang.ast.Type>> argTypes/*J*/= new SmallVector<CanQual<org.clang.ast.Type>>(16, new CanQual<org.clang.ast.Type>());
    
    // Add the 'this' pointer.
    if ((RD != null)) {
      argTypes.push_back(CGCallStatics.GetThisType(Context, RD));
    } else {
      argTypes.push_back(Context.VoidPtrTy);
    }
    
    return /*::*/CGCallStatics.arrangeLLVMFunctionInfo(/*Deref*/this, true, argTypes, 
        ((CanProxyFunctionProtoType)FTP.getCanonicalTypeUnqualified().getAs(FunctionProtoType.class)).$CanQual$T(), MD);
  }

  
  /// "Arrange" the LLVM information for a call or type with the given
  /// signature.  This is largely an internal method; other clients
  /// should use one of the above routines, which ultimately defer to
  /// this.
  ///
  /// \param argTypes - must all actually be canonical as params
  
  /// Arrange the argument and result information for an abstract value
  /// of a given function type.  This is the method which all of the
  /// above functions ultimately defer to.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenTypes::arrangeLLVMFunctionInfo">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp", line = 671,
   FQN="clang::CodeGen::CodeGenTypes::arrangeLLVMFunctionInfo", NM="_ZN5clang7CodeGen12CodeGenTypes23arrangeLLVMFunctionInfoENS_7CanQualINS_4TypeEEEbbN4llvm8ArrayRefIS4_EENS_12FunctionType7ExtInfoENS6_INS_17FunctionProtoType16ExtParameterInfoEEENS0_12RequiredArgsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZN5clang7CodeGen12CodeGenTypes23arrangeLLVMFunctionInfoENS_7CanQualINS_4TypeEEEbbN4llvm8ArrayRefIS4_EENS_12FunctionType7ExtInfoENS6_INS_17FunctionProtoType16ExtParameterInfoEEENS0_12RequiredArgsE")
  //</editor-fold>
  public /*const*/ CGFunctionInfo /*&*/ arrangeLLVMFunctionInfo(CanQual<org.clang.ast.Type> resultType, 
                         boolean instanceMethod, 
                         boolean chainCall, 
                         ArrayRef<CanQual<org.clang.ast.Type>> argTypes, 
                         org.clang.ast.FunctionType.ExtInfo info, 
                         ArrayRef<FunctionProtoType.ExtParameterInfo> paramInfos, 
                         RequiredArgs required) {
    assert (std.all_of(argTypes.begin(), argTypes.end(), /*AddrOf*//*FPtr*/CanQual::<org.clang.ast.Type>isCanonicalAsParam));
    
    // Lookup or create unique function info.
    FoldingSetNodeID ID/*J*/= new FoldingSetNodeID();
    CGFunctionInfo.Profile(ID, instanceMethod, chainCall, info, /*NO_COPY*/paramInfos, 
        /*NO_COPY*/required, /*NO_COPY*/resultType, /*NO_COPY*/argTypes);
    
    final type$ref<type$ptr<CGFunctionInfo /*P*/>/*void P*/ > insertPos = create_type$null$ref(null);
    CGFunctionInfo /*P*/ FI = FunctionInfos.FindNodeOrInsertPos(ID, insertPos);
    if ((FI != null)) {
      return $Deref(FI);
    }
    
    /*uint*/int CC = ClangCallConvToLLVMCallConv(info.getCC());
    
    // Construct the function info.  We co-allocate the ArgInfos.
    FI = CGFunctionInfo.create(CC, instanceMethod, chainCall, info, 
        new ArrayRef<FunctionProtoType.ExtParameterInfo>(paramInfos), new CanQual<org.clang.ast.Type>(resultType), new ArrayRef<CanQual<org.clang.ast.Type>>(argTypes), new RequiredArgs(required));
    FunctionInfos.InsertNode(FI, insertPos.$deref());
    
    boolean inserted = FunctionsBeingProcessed.insert(FI).second;
    ///*J:(void)*/inserted;
    assert (inserted) : "Recursively being processed?";
    
    // Compute ABI information.
    if (info.getCC() != org.clang.basic.CallingConv.CC_Swift) {
      getABIInfo().computeInfo($Deref(FI));
    } else {
      SwiftcallGlobals.computeABIInfo(CGM, $Deref(FI));
    }
    
    // Loop over all of the computed argument and return value info.  If any of
    // them are direct or extend without a specified coerce type, specify the
    // default now.
    final ABIArgInfo /*&*/ retInfo = FI.getReturnInfo();
    if (retInfo.canHaveCoerceToType() && retInfo.getCoerceToType() == null) {
      retInfo.setCoerceToType(ConvertType(FI.getReturnType().$QualType()));
    }
    
    for (final CGFunctionInfoArgInfo /*&*/ I : FI.arguments())  {
      if (I.info.canHaveCoerceToType() && I.info.getCoerceToType() == null) {
        I.info.setCoerceToType(ConvertType(I.type.$QualType()));
      }
    }
    
    boolean erased = FunctionsBeingProcessed.erase(FI);
    ///*J:(void)*/erased;
    assert (erased) : "Not in set?";
    
    return $Deref(FI);
  }

  
  /// \brief Compute a new LLVM record layout object for the given record.
  
  /// \brief Compute a new LLVM record layout object for the given record.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenTypes::ComputeRecordLayout">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGRecordLayoutBuilder.cpp", line = 685,
   FQN="clang::CodeGen::CodeGenTypes::ComputeRecordLayout", NM="_ZN5clang7CodeGen12CodeGenTypes19ComputeRecordLayoutEPKNS_10RecordDeclEPN4llvm10StructTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGRecordLayoutBuilder.cpp -nm=_ZN5clang7CodeGen12CodeGenTypes19ComputeRecordLayoutEPKNS_10RecordDeclEPN4llvm10StructTypeE")
  //</editor-fold>
  public CGRecordLayout /*P*/ ComputeRecordLayout(/*const*/ RecordDecl /*P*/ D, 
                     StructType /*P*/ Ty) {
    CGRecordLowering Builder = null;
    try {
      Builder/*J*/= new CGRecordLowering(/*Deref*/this, D, /*Packed=*/ false);
      
      Builder.lower(/*NonVirtualBaseType=*/ false);
      
      // If we're in C++, compute the base subobject type.
      StructType /*P*/ BaseTy = null;
      if (isa_CXXRecordDecl(D) && !D.isUnion() && !D.hasAttr(FinalAttr.class)) {
        BaseTy = Ty;
        if (Builder.Layout.getNonVirtualSize().$noteq(Builder.Layout.getSize())) {
          CGRecordLowering BaseBuilder = null;
          try {
            BaseBuilder/*J*/= new CGRecordLowering(/*Deref*/this, D, /*Packed=*/ Builder.Packed);
            BaseBuilder.lower(/*NonVirtualBaseType=*/ true);
            BaseTy = StructType.create(getLLVMContext(), new ArrayRef<org.llvm.ir.Type /*P*/ >(BaseBuilder.FieldTypes, true), new StringRef(/*KEEP_STR*/$EMPTY), BaseBuilder.Packed);
            addRecordTypeName(D, BaseTy, new StringRef(/*KEEP_STR*/".base"));
            // BaseTy and Ty must agree on their packedness for getLLVMFieldNo to work
            // on both of them with the same index.
            assert (Builder.Packed == BaseBuilder.Packed) : "Non-virtual and complete types must agree on packedness";
          } finally {
            if (BaseBuilder != null) { BaseBuilder.$destroy(); }
          }
        }
      }
      
      // Fill in the struct *after* computing the base type.  Filling in the body
      // signifies that the type is no longer opaque and record layout is complete,
      // but we may need to recursively layout D while laying D out as a base type.
      Ty.setBody(new ArrayRef<org.llvm.ir.Type /*P*/ >(Builder.FieldTypes, true), Builder.Packed);
      
      CGRecordLayout /*P*/ RL = new CGRecordLayout(Ty, BaseTy, Builder.IsZeroInitializable, 
          Builder.IsZeroInitializableAsBase);
      
      RL.NonVirtualBases.swap(Builder.NonVirtualBases);
      RL.CompleteObjectVirtualBases.swap(Builder.VirtualBases);
      
      // Add all the field numbers.
      RL.FieldInfo.swap(Builder.Fields);
      
      // Add bitfield info.
      RL.BitFields.swap(Builder.BitFields);
      
      // Dump the layout, if requested.
      if (getContext().getLangOpts().DumpRecordLayouts) {
        llvm.outs().$out(/*KEEP_STR*/"\n*** Dumping IRgen Record Layout\n");
        llvm.outs().$out(/*KEEP_STR*/"Record: ");
        D.dump(llvm.outs());
        llvm.outs().$out(/*KEEP_STR*/"\nLayout: ");
        RL.print(llvm.outs());
      }
      // Verify that the computed LLVM struct size matches the AST layout size.
      final /*const*/ ASTRecordLayout /*&*/ Layout = getContext().getASTRecordLayout(D);
      
      long/*uint64_t*/ TypeSizeInBits = getContext().toBits(Layout.getSize());
      assert (TypeSizeInBits == getDataLayout().getTypeAllocSizeInBits(Ty)) : "Type size mismatch!";
      if ((BaseTy != null)) {
        CharUnits NonVirtualSize = Layout.getNonVirtualSize();
        
        long/*uint64_t*/ AlignedNonVirtualTypeSizeInBits = getContext().toBits(new CharUnits(NonVirtualSize));
        assert (AlignedNonVirtualTypeSizeInBits == getDataLayout().getTypeAllocSizeInBits(BaseTy)) : "Type size mismatch!";
      }
      
      // Verify that the LLVM and AST field offsets agree.
      StructType /*P*/ ST = dyn_cast_StructType(RL.getLLVMType());
      /*const*/ StructLayout /*P*/ SL = getDataLayout().getStructLayout(ST);
      
      final /*const*/ ASTRecordLayout /*&*/ AST_RL = getContext().getASTRecordLayout(D);
      DeclContext.specific_decl_iterator<FieldDecl> it = D.field_begin();
      for (/*uint*/int i = 0, e = AST_RL.getFieldCount(); i != e; ++i , it.$preInc()) {
        /*const*/ FieldDecl /*P*/ FD = it.$star();
        
        // For non-bit-fields, just check that the LLVM struct offset matches the
        // AST offset.
        if (!FD.isBitField()) {
          /*uint*/int FieldNo = RL.getLLVMFieldNo(FD);
          assert (AST_RL.getFieldOffset(i) == SL.getElementOffsetInBits(FieldNo)) : "Invalid field offset!";
          continue;
        }
        
        // Ignore unnamed bit-fields.
        if (!FD.getDeclName().$bool()) {
          continue;
        }
        
        // Don't inspect zero-length bitfields.
        if (FD.getBitWidthValue(getContext()) == 0) {
          continue;
        }
        
        final /*const*/ CGBitFieldInfo /*&*/ Info = RL.getBitFieldInfo(FD);
        org.llvm.ir.Type /*P*/ ElementTy = ST.getTypeAtIndex(RL.getLLVMFieldNo(FD));
        
        // Unions have overlapping elements dictating their layout, but for
        // non-unions we can verify that this section of the layout is the exact
        // expected size.
        if (D.isUnion()) {
          // For unions we verify that the start is zero and the size
          // is in-bounds. However, on BE systems, the offset may be non-zero, but
          // the size + offset should match the storage size in that case as it
          // "starts" at the back.
          if (getDataLayout().isBigEndian()) {
            assert (((/*static_cast*//*uint*/int)($16bits_uint2uint(Info.Offset) + $15bits_uint2uint(Info.Size))) == Info.StorageSize) : "Big endian union bitfield does not end at the back";
          } else {
            assert ($16bits_uint2uint(Info.Offset) == 0) : "Little endian union bitfield with a non-zero offset";
          }
          assert ($lesseq_uint_ulong(Info.StorageSize, SL.getSizeInBits())) : "Union not large enough for bitfield storage";
        } else {
          assert ($uint2ullong(Info.StorageSize) == getDataLayout().getTypeAllocSizeInBits(ElementTy)) : "Storage size does not match the element type size";
        }
        assert ($15bits_uint2uint(Info.Size) > 0) : "Empty bitfield!";
        assert ($lesseq_uint(((/*static_cast*//*uint*/int)($16bits_uint2uint(Info.Offset))) + $15bits_uint2uint(Info.Size), Info.StorageSize)) : "Bitfield outside of its allocated storage";
      }
      
      return RL;
    } finally {
      if (Builder != null) { Builder.$destroy(); }
    }
  }


  
  /// addRecordTypeName - Compute a name from the given record decl with an
  /// optional suffix and name the given LLVM type using it.
  
  /// addRecordTypeName - Compute a name from the given record decl with an
  /// optional suffix and name the given LLVM type using it.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenTypes::addRecordTypeName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenTypes.cpp", line = 47,
   FQN="clang::CodeGen::CodeGenTypes::addRecordTypeName", NM="_ZN5clang7CodeGen12CodeGenTypes17addRecordTypeNameEPKNS_10RecordDeclEPN4llvm10StructTypeENS5_9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenTypes.cpp -nm=_ZN5clang7CodeGen12CodeGenTypes17addRecordTypeNameEPKNS_10RecordDeclEPN4llvm10StructTypeENS5_9StringRefE")
  //</editor-fold>
  public void addRecordTypeName(/*const*/ RecordDecl /*P*/ RD, 
                   StructType /*P*/ Ty, 
                   StringRef suffix) {
    raw_svector_ostream OS = null;
    try {
      SmallString/*<256>*/ TypeName/*J*/= new SmallString/*<256>*/(256);
      OS/*J*/= new raw_svector_ostream(TypeName);
      OS.$out(RD.getKindName()).$out_char($$DOT);
      
      // Name the codegen type after the typedef name
      // if there is no tag type name available
      if ((RD.getIdentifier() != null)) {
        // FIXME: We should not have to check for a null decl context here.
        // Right now we do it because the implicit Obj-C decls don't have one.
        if ((RD.getDeclContext$Const() != null)) {
          RD.printQualifiedName(OS);
        } else {
          RD.printName(OS);
        }
      } else {
        /*const*/ TypedefNameDecl /*P*/ TDD = RD.getTypedefNameForAnonDecl();
        if ((TDD != null)) {
          // FIXME: We should not have to check for a null decl context here.
          // Right now we do it because the implicit Obj-C decls don't have one.
          if ((TDD.getDeclContext$Const() != null)) {
            TDD.printQualifiedName(OS);
          } else {
            TDD.printName(OS);
          }
        } else {
          OS.$out(/*KEEP_STR*/"anon");
        }
      }
      if (!suffix.empty()) {
        OS.$out(/*NO_COPY*/suffix);
      }
      
      Ty.setName(OS.str());
    } finally {
      if (OS != null) { OS.$destroy(); }
    }
  }


/*public:*/
  // These are internal details of CGT that shouldn't be used externally.
  /// ConvertRecordDeclType - Lay out a tagged decl type like struct or union.
  // These are internal details of CGT that shouldn't be used externally.
  /// ConvertRecordDeclType - Lay out a tagged decl type like struct or union.
  
  /// ConvertRecordDeclType - Lay out a tagged decl type like struct or union.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenTypes::ConvertRecordDeclType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenTypes.cpp", line = 658,
   FQN="clang::CodeGen::CodeGenTypes::ConvertRecordDeclType", NM="_ZN5clang7CodeGen12CodeGenTypes21ConvertRecordDeclTypeEPKNS_10RecordDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenTypes.cpp -nm=_ZN5clang7CodeGen12CodeGenTypes21ConvertRecordDeclTypeEPKNS_10RecordDeclE")
  //</editor-fold>
  public StructType /*P*/ ConvertRecordDeclType(/*const*/ RecordDecl /*P*/ RD) {
    // TagDecl's are not necessarily unique, instead use the (clang)
    // type connected to the decl.
    /*const*/ org.clang.ast.Type /*P*/ Key = Context.getTagDeclType(RD).getTypePtr();
    
    final type$ref<StructType /*P*/ /*&*/> Entry = RecordDeclTypes.ref$at(Key);
    
    // If we don't have a StructType at all yet, create the forward declaration.
    if (!(Entry.$deref() != null)) {
      Entry.$set(StructType.create(getLLVMContext()));
      addRecordTypeName(RD, Entry.$deref(), new StringRef(/*KEEP_STR*/$EMPTY));
    }
    StructType /*P*/ Ty = Entry.$deref();
    
    // If this is still a forward declaration, or the LLVM type is already
    // complete, there's nothing more to do.
    RD = RD.getDefinition();
    if (!(RD != null) || !RD.isCompleteDefinition() || !Ty.isOpaque()) {
      return Ty;
    }
    
    // If converting this type would cause us to infinitely loop, don't do it!
    if (!CodeGenTypesStatics.isSafeToConvert(RD, /*Deref*/this)) {
      DeferredRecords.push_back(RD);
      return Ty;
    }
    
    // Okay, this is a definition of a type.  Compile the implementation now.
    boolean InsertResult = RecordsBeingLaidOut.insert(Key).second;
    ///*J:(void)*/InsertResult;
    assert (InsertResult) : "Recursively compiling a struct?";
    {
      
      // Force conversion of non-virtual base classes recursively.
      /*const*/ CXXRecordDecl /*P*/ CRD = dyn_cast_CXXRecordDecl(RD);
      if ((CRD != null)) {
        for (final /*const*/ CXXBaseSpecifier /*&*/ I : CRD.bases$Const()) {
          if (I.isVirtual()) {
            continue;
          }
          
          ConvertRecordDeclType(I.getType().$arrow().getAs$RecordType().getDecl());
        }
      }
    }
    
    // Layout fields.
    CGRecordLayout /*P*/ Layout = ComputeRecordLayout(RD, Ty);
    CGRecordLayouts.$set(Key, Layout);
    
    // We're done laying out this struct.
    boolean EraseResult = RecordsBeingLaidOut.erase(Key);
    ///*J:(void)*/EraseResult;
    assert (EraseResult) : "struct not in RecordsBeingLaidOut set?";
    
    // If this struct blocked a FunctionType conversion, then recompute whatever
    // was derived from that.
    // FIXME: This is hugely overconservative.
    if (SkippedLayout) {
      TypeCache.clear();
    }
    
    // If we're done converting the outer-most record, then convert any deferred
    // structs as well.
    if (RecordsBeingLaidOut.empty()) {
      while (!DeferredRecords.empty()) {
        ConvertRecordDeclType(DeferredRecords.pop_back_val());
      }
    }
    
    return Ty;
  }


  
  /// getExpandedTypes - Expand the type \arg Ty into the LLVM
  /// argument types it would be passed as. See ABIArgInfo::Expand.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenTypes::getExpandedTypes">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp", line = 908,
   FQN="clang::CodeGen::CodeGenTypes::getExpandedTypes", NM="_ZN5clang7CodeGen12CodeGenTypes16getExpandedTypesENS_8QualTypeERPPN4llvm4TypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZN5clang7CodeGen12CodeGenTypes16getExpandedTypesENS_8QualTypeERPPN4llvm4TypeE")
  //</editor-fold>
  public void getExpandedTypes(QualType Ty, 
                  final type$ptr<org.llvm.ir.Type /*P*/ /*P*/> /*&*/ TI) {
    unique_ptr<TypeExpansion> Exp = null;
    try {
      Exp = CGCallStatics.getTypeExpansion(new QualType(Ty), Context);
      {
        ConstantArrayExpansion /*P*/ CAExp = dyn_cast_ConstantArrayExpansion(Exp.get());
        if ((CAExp != null)) {
          for (int i = 0, n = $ulong2int(CAExp.NumElts); i < n; i++) {
            getExpandedTypes(new QualType(CAExp.EltTy), TI);
          }
        } else {
          RecordExpansion /*P*/ RExp = dyn_cast_RecordExpansion(Exp.get());
          if ((RExp != null)) {
            for (/*const*/ CXXBaseSpecifier /*P*/ BS : RExp.Bases)  {
              getExpandedTypes(BS.getType(), TI);
            }
            for (/*const*/ FieldDecl /*P*/ FD : RExp.Fields)  {
              getExpandedTypes(FD.getType(), TI);
            }
          } else {
            ComplexExpansion /*P*/ CExp = dyn_cast_ComplexExpansion(Exp.get());
            if ((CExp != null)) {
              org.llvm.ir.Type /*P*/ EltTy = ConvertType(new QualType(CExp.EltTy));
              TI.$postInc().$set(EltTy);
              TI.$postInc().$set(EltTy);
            } else {
              assert (isa_NoExpansion(Exp.get()));
              TI.$postInc().$set(ConvertType(new QualType(Ty)));
            }
          }
        }
      }
    } finally {
      if (Exp != null) { Exp.$destroy(); }
    }
  }

  
  /// IsZeroInitializable - Return whether a type can be
  /// zero-initialized (in the C++ sense) with an LLVM zeroinitializer.
  
  /// IsZeroInitializable - Return whether a type can be
  /// zero-initialized (in the C++ sense) with an LLVM zeroinitializer.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenTypes::isZeroInitializable">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenTypes.cpp", line = 739,
   FQN="clang::CodeGen::CodeGenTypes::isZeroInitializable", NM="_ZN5clang7CodeGen12CodeGenTypes19isZeroInitializableENS_8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenTypes.cpp -nm=_ZN5clang7CodeGen12CodeGenTypes19isZeroInitializableENS_8QualTypeE")
  //</editor-fold>
  public boolean isZeroInitializable(QualType T) {
    // No need to check for member pointers when not compiling C++.
    if (!Context.getLangOpts().CPlusPlus) {
      return true;
    }
    {
      
      /*const*/ org.clang.ast.ArrayType /*P*/ AT = Context.getAsArrayType(new QualType(T));
      if ((AT != null)) {
        if (isa_IncompleteArrayType(AT)) {
          return true;
        }
        {
          /*const*/ ConstantArrayType /*P*/ CAT = dyn_cast_ConstantArrayType(AT);
          if ((CAT != null)) {
            if (Context.getConstantArrayElementCount(CAT) == $int2ullong(0)) {
              return true;
            }
          }
        }
        T.$assignMove(Context.getBaseElementType(new QualType(T)));
      }
    }
    {
      
      // Records are non-zero-initializable if they contain any
      // non-zero-initializable subobjects.
      /*const*/ RecordType /*P*/ RT = T.$arrow().getAs$RecordType();
      if ((RT != null)) {
        /*const*/ CXXRecordDecl /*P*/ RD = cast_CXXRecordDecl(RT.getDecl());
        return isZeroInitializable(RD);
      }
    }
    {
      
      // We have to ask the ABI about member pointers.
      /*const*/ MemberPointerType /*P*/ MPT = T.$arrow().getAs(MemberPointerType.class);
      if ((MPT != null)) {
        return getCXXABI().isZeroInitializable(MPT);
      }
    }
    
    // Everything else is okay.
    return true;
  }


  
  /// IsZeroInitializable - Return whether a record type can be
  /// zero-initialized (in the C++ sense) with an LLVM zeroinitializer.
  
  /// IsZeroInitializable - Return whether a record type can be
  /// zero-initialized (in the C++ sense) with an LLVM zeroinitializer.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenTypes::isZeroInitializable">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenTypes.cpp", line = 768,
   FQN="clang::CodeGen::CodeGenTypes::isZeroInitializable", NM="_ZN5clang7CodeGen12CodeGenTypes19isZeroInitializableEPKNS_10RecordDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenTypes.cpp -nm=_ZN5clang7CodeGen12CodeGenTypes19isZeroInitializableEPKNS_10RecordDeclE")
  //</editor-fold>
  public boolean isZeroInitializable(/*const*/ RecordDecl /*P*/ RD) {
    return getCGRecordLayout(RD).isZeroInitializable();
  }


  
  /// isRecordLayoutComplete - Return true if the specified type is already
  /// completely laid out.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenTypes::isRecordLayoutComplete">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenTypes.cpp", line = 98,
   FQN="clang::CodeGen::CodeGenTypes::isRecordLayoutComplete", NM="_ZNK5clang7CodeGen12CodeGenTypes22isRecordLayoutCompleteEPKNS_4TypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenTypes.cpp -nm=_ZNK5clang7CodeGen12CodeGenTypes22isRecordLayoutCompleteEPKNS_4TypeE")
  //</editor-fold>
  public boolean isRecordLayoutComplete(/*const*/ org.clang.ast.Type /*P*/ Ty) /*const*/ {
    DenseMapIterator</*const*/ org.clang.ast.Type /*P*/ , StructType /*P*/ > I = RecordDeclTypes.find$Const(Ty);
    return I.$noteq(RecordDeclTypes.end$Const()) && !I.$arrow().second.isOpaque();
  }


  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenTypes::noRecordsBeingLaidOut">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenTypes.h", line = 360,
   FQN="clang::CodeGen::CodeGenTypes::noRecordsBeingLaidOut", NM="_ZNK5clang7CodeGen12CodeGenTypes21noRecordsBeingLaidOutEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZNK5clang7CodeGen12CodeGenTypes21noRecordsBeingLaidOutEv")
  //</editor-fold>
  public boolean noRecordsBeingLaidOut() /*const*/ {
    return RecordsBeingLaidOut.empty();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenTypes::isRecordBeingLaidOut">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenTypes.h", line = 363,
   FQN="clang::CodeGen::CodeGenTypes::isRecordBeingLaidOut", NM="_ZNK5clang7CodeGen12CodeGenTypes20isRecordBeingLaidOutEPKNS_4TypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZNK5clang7CodeGen12CodeGenTypes20isRecordBeingLaidOutEPKNS_4TypeE")
  //</editor-fold>
  public boolean isRecordBeingLaidOut(/*const*/ org.clang.ast.Type /*P*/ Ty) /*const*/ {
    return (RecordsBeingLaidOut.count(Ty) != 0);
  }

  
  @Override public String toString() {
    return "" + "CGM=" + CGM // NOI18N
              + ", Context=" + "[ASTContext]" // NOI18N
              + ", TheModule=" + TheModule // NOI18N
              + ", Target=" + Target // NOI18N
              + ", TheCXXABI=" + TheCXXABI // NOI18N
              + ", TheABIInfo=" + TheABIInfo // NOI18N
              + ", InterfaceTypes=" + InterfaceTypes // NOI18N
              + ", CGRecordLayouts=" + CGRecordLayouts // NOI18N
              + ", RecordDeclTypes=" + RecordDeclTypes // NOI18N
              + ", FunctionInfos=" + FunctionInfos // NOI18N
              + ", RecordsBeingLaidOut=" + RecordsBeingLaidOut // NOI18N
              + ", FunctionsBeingProcessed=" + FunctionsBeingProcessed // NOI18N
              + ", SkippedLayout=" + SkippedLayout // NOI18N
              + ", DeferredRecords=" + "[SmallVector$RecordDecl]" // NOI18N
              + ", TypeCache=" + TypeCache // NOI18N
              + ", RecordsWithOpaqueMemberPointers=" + RecordsWithOpaqueMemberPointers; // NOI18N
  }
}
