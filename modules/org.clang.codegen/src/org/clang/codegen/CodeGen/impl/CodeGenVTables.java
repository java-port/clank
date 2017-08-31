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
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import org.clang.basic.*;
import org.llvm.ir.*;
import org.clang.codegen.CodeGen.*;
import static org.clang.ast.java.AstRTTI.*;
import static org.clang.ast.java.AstDeclarationsRTTI.*;
import static org.llvm.ir.java.IrRTTI.*;
import static org.clang.ast.java.AstJavaDifferentiators.*;
import org.clang.ast.llvm.DenseMapInfoBaseSubobject;
import org.clang.codegen.impl.CGVTTStatics;
import org.clang.codegen.impl.CGVTablesStatics;

//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenVTables">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGVTables.h", line = 31,
 FQN="clang::CodeGen::CodeGenVTables", NM="_ZN5clang7CodeGen14CodeGenVTablesE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGVTT.cpp -nm=_ZN5clang7CodeGen14CodeGenVTablesE")
//</editor-fold>
public class CodeGenVTables implements Destructors.ClassWithDestructor {
  private final CodeGenModule /*&*/ CGM;
  
  private VTableContextBase /*P*/ VTContext;
  
  /// VTableAddressPointsMapTy - Address points for a single vtable.
  // JAVA: typedef llvm::DenseMap<BaseSubobject, uint64_t> VTableAddressPointsMapTy
//  public final class VTableAddressPointsMapTy extends DenseMapTypeULong<BaseSubobject>{ };
  
  // JAVA: typedef std::pair<const CXXRecordDecl *, BaseSubobject> BaseSubobjectPairTy
//  public final class BaseSubobjectPairTy extends std.pair</*const*/ CXXRecordDecl /*P*/ , BaseSubobject>{ };
  // JAVA: typedef llvm::DenseMap<BaseSubobjectPairTy, uint64_t> SubVTTIndiciesMapTy
//  public final class SubVTTIndiciesMapTy extends DenseMapTypeULong<std.pair</*const*/ CXXRecordDecl /*P*/ , BaseSubobject>>{ };
  
  /// SubVTTIndicies - Contains indices into the various sub-VTTs.
  private DenseMapTypeULong<std.pair</*const*/ CXXRecordDecl /*P*/ , BaseSubobject>> SubVTTIndicies;
  
  // JAVA: typedef llvm::DenseMap<BaseSubobjectPairTy, uint64_t> SecondaryVirtualPointerIndicesMapTy
//  public final class SecondaryVirtualPointerIndicesMapTy extends DenseMapTypeULong<std.pair</*const*/ CXXRecordDecl /*P*/ , BaseSubobject>>{ };
  
  /// SecondaryVirtualPointerIndices - Contains the secondary virtual pointer
  /// indices.
  private DenseMapTypeULong<std.pair</*const*/ CXXRecordDecl /*P*/ , BaseSubobject>> SecondaryVirtualPointerIndices;
  
  /// emitThunk - Emit a single thunk.
  
  /// emitThunk - Emit a single thunk.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenVTables::emitThunk">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGVTables.cpp", line = 410,
   FQN="clang::CodeGen::CodeGenVTables::emitThunk", NM="_ZN5clang7CodeGen14CodeGenVTables9emitThunkENS_10GlobalDeclERKNS_9ThunkInfoEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGVTables.cpp -nm=_ZN5clang7CodeGen14CodeGenVTables9emitThunkENS_10GlobalDeclERKNS_9ThunkInfoEb")
  //</editor-fold>
  private void emitThunk(GlobalDecl GD, final /*const*/ ThunkInfo /*&*/ Thunk, 
           boolean ForVTable) {
    final /*const*/ CGFunctionInfo /*&*/ FnInfo = CGM.getTypes().arrangeGlobalDeclaration(new GlobalDecl(GD));
    
    // FIXME: re-use FnInfo in this computation.
    Constant /*P*/ C = CGM.GetAddrOfThunk(new GlobalDecl(GD), Thunk);
    GlobalValue /*P*/ Entry;
    {
      
      // Strip off a bitcast if we got one back.
      ConstantExpr /*P*/ CE = dyn_cast_ConstantExpr(C);
      if ((CE != null)) {
        assert (CE.getOpcode() == Instruction.CastOps.BitCast);
        Entry = cast_GlobalValue(CE.getOperand_Constant(0));
      } else {
        Entry = cast_GlobalValue(C);
      }
    }
    
    // There's already a declaration with the same name, check if it has the same
    // type or if we need to replace it.
    if (Entry.getType().getElementType()
       != CGM.getTypes().GetFunctionTypeForVTable(new GlobalDecl(GD))) {
      GlobalValue /*P*/ OldThunkFn = Entry;
      
      // If the types mismatch then we have to rewrite the definition.
      assert (OldThunkFn.isDeclaration()) : "Shouldn't replace non-declaration";
      
      // Remove the name from the old thunk function and get a new thunk.
      OldThunkFn.setName(new Twine(new StringRef()));
      Entry = cast_GlobalValue(CGM.GetAddrOfThunk(new GlobalDecl(GD), Thunk));
      
      // If needed, replace the old thunk with a bitcast.
      if (!OldThunkFn.use_empty()) {
        Constant /*P*/ NewPtrForOldDecl = ConstantExpr.getBitCast(Entry, OldThunkFn.getType());
        OldThunkFn.replaceAllUsesWith(NewPtrForOldDecl);
      }
      
      // Remove the old thunk.
      OldThunkFn.eraseFromParent();
    }
    
    Function /*P*/ ThunkFn = cast_Function(Entry);
    boolean ABIHasKeyFunctions = CGM.getTarget().getCXXABI().hasKeyFunctions();
    boolean UseAvailableExternallyLinkage = ForVTable && ABIHasKeyFunctions;
    if (!ThunkFn.isDeclaration()) {
      if (!ABIHasKeyFunctions || UseAvailableExternallyLinkage) {
        // There is already a thunk emitted for this function, do nothing.
        return;
      }
      
      CGVTablesStatics.setThunkProperties(CGM, Thunk, ThunkFn, ForVTable, new GlobalDecl(GD));
      return;
    }
    
    CGM.SetLLVMFunctionAttributesForDefinition(GD.getDecl(), ThunkFn);
    if (ThunkFn.isVarArg()) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        // Varargs thunks are special; we can't just generate a call because
        // we can't copy the varargs.  Our implementation is rather
        // expensive/sucky at the moment, so don't generate the thunk unless
        // we have to.
        // FIXME: Do something better here; GenerateVarArgsThunk is extremely ugly.
        if (UseAvailableExternallyLinkage) {
          return;
        }
        $c$.clean(ThunkFn
           = $c$.track(new CodeGenFunction(CGM)).GenerateVarArgsThunk(ThunkFn, FnInfo, new GlobalDecl(GD), Thunk));
      } finally {
        $c$.$destroy();
      }
    } else {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        // Normal thunk body generation.
        $c$.track(new CodeGenFunction(CGM)).generateThunk(ThunkFn, FnInfo, new GlobalDecl(GD), Thunk); $c$.clean();
      } finally {
        $c$.$destroy();
      }
    }
    
    CGVTablesStatics.setThunkProperties(CGM, Thunk, ThunkFn, ForVTable, new GlobalDecl(GD));
  }


  
  /// maybeEmitThunkForVTable - Emit the given thunk for the vtable if needed by
  /// the ABI.
  
  /// maybeEmitThunkForVTable - Emit the given thunk for the vtable if needed by
  /// the ABI.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenVTables::maybeEmitThunkForVTable">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGVTables.cpp", line = 485,
   FQN="clang::CodeGen::CodeGenVTables::maybeEmitThunkForVTable", NM="_ZN5clang7CodeGen14CodeGenVTables23maybeEmitThunkForVTableENS_10GlobalDeclERKNS_9ThunkInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGVTables.cpp -nm=_ZN5clang7CodeGen14CodeGenVTables23maybeEmitThunkForVTableENS_10GlobalDeclERKNS_9ThunkInfoE")
  //</editor-fold>
  private void maybeEmitThunkForVTable(GlobalDecl GD, 
                         final /*const*/ ThunkInfo /*&*/ Thunk) {
    // If the ABI has key functions, only the TU with the key function should emit
    // the thunk. However, we can allow inlining of thunks if we emit them with
    // available_externally linkage together with vtables when optimizations are
    // enabled.
    if (CGM.getTarget().getCXXABI().hasKeyFunctions()
       && !($2bits_uint2uint(CGM.getCodeGenOpts().OptimizationLevel) != 0)) {
      return;
    }
    
    // We can't emit thunks for member functions with incomplete types.
    /*const*/ CXXMethodDecl /*P*/ MD = cast_CXXMethodDecl(GD.getDecl());
    if (!CGM.getTypes().isFuncTypeConvertible(MD.getType().$arrow().castAs(org.clang.ast.FunctionType.class))) {
      return;
    }
    
    emitThunk(new GlobalDecl(GD), Thunk, /*ForVTable=*/ true);
  }


/*public:*/
  /// CreateVTableInitializer - Create a vtable initializer for the given record
  /// decl.
  /// \param Components - The vtable components; this is really an array of
  /// VTableComponents.
  /// CreateVTableInitializer - Create a vtable initializer for the given record
  /// decl.
  /// \param Components - The vtable components; this is really an array of
  /// VTableComponents.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenVTables::CreateVTableInitializer">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGVTables.cpp", line = 523,
   FQN="clang::CodeGen::CodeGenVTables::CreateVTableInitializer", NM="_ZN5clang7CodeGen14CodeGenVTables23CreateVTableInitializerEPKNS_13CXXRecordDeclEPKNS_15VTableComponentEjPKSt4pairIyNS_9ThunkInfoEEjPN4llvm8ConstantE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGVTables.cpp -nm=_ZN5clang7CodeGen14CodeGenVTables23CreateVTableInitializerEPKNS_13CXXRecordDeclEPKNS_15VTableComponentEjPKSt4pairIyNS_9ThunkInfoEEjPN4llvm8ConstantE")
  //</editor-fold>
  public Constant /*P*/ CreateVTableInitializer(/*const*/ CXXRecordDecl /*P*/ RD, /*const*/ type$ptr<VTableComponent /*P*/> Components, 
                         /*uint*/int NumComponents, /*const*/type$ptr<std.pairULongType<ThunkInfo> /*P*/> VTableThunks, 
                         /*uint*/int NumVTableThunks, Constant /*P*/ RTTI) {
    SmallVector<Constant /*P*/ > Inits/*J*/= new SmallVector<Constant /*P*/ >(64, (Constant /*P*/ )null);
    
    org.llvm.ir.Type /*P*/ Int8PtrTy = CGM.Unnamed_field9.Int8PtrTy;
    
    org.llvm.ir.Type /*P*/ PtrDiffTy = CGM.getTypes().ConvertType(CGM.getContext().getPointerDiffType());
    
    /*uint*/int NextVTableThunkIndex = 0;
    
    Constant /*P*/ PureVirtualFn = null;
    Constant /*P*/ DeletedVirtualFn = null;
    
    for (/*uint*/int I = 0; I != NumComponents; ++I) {
      VTableComponent Component = new VTableComponent(Components.$at(I));
      
      Constant /*P*/ Init = null;
      switch (Component.getKind()) {
       case CK_VCallOffset:
        Init = ConstantInt.get(PtrDiffTy, 
            Component.getVCallOffset().getQuantity());
        Init = ConstantExpr.getIntToPtr(Init, Int8PtrTy);
        break;
       case CK_VBaseOffset:
        Init = ConstantInt.get(PtrDiffTy, 
            Component.getVBaseOffset().getQuantity());
        Init = ConstantExpr.getIntToPtr(Init, Int8PtrTy);
        break;
       case CK_OffsetToTop:
        Init = ConstantInt.get(PtrDiffTy, 
            Component.getOffsetToTop().getQuantity());
        Init = ConstantExpr.getIntToPtr(Init, Int8PtrTy);
        break;
       case CK_RTTI:
        Init = ConstantExpr.getBitCast(RTTI, Int8PtrTy);
        break;
       case CK_FunctionPointer:
       case CK_CompleteDtorPointer:
       case CK_DeletingDtorPointer:
        {
          GlobalDecl GD/*J*/= new GlobalDecl();
          
          // Get the right global decl.
          switch (Component.getKind()) {
           default:
            throw new llvm_unreachable("Unexpected vtable component kind");
           case CK_FunctionPointer:
            GD.$assignMove(new GlobalDecl(Component.getFunctionDecl()));
            break;
           case CK_CompleteDtorPointer:
            GD.$assignMove(new GlobalDecl(JD$CXXDestructorDecl$C$P_CXXDtorType.INSTANCE, Component.getDestructorDecl(), CXXDtorType.Dtor_Complete));
            break;
           case CK_DeletingDtorPointer:
            GD.$assignMove(new GlobalDecl(JD$CXXDestructorDecl$C$P_CXXDtorType.INSTANCE, Component.getDestructorDecl(), CXXDtorType.Dtor_Deleting));
            break;
          }
          if (CGM.getLangOpts().CUDA) {
            // Emit NULL for methods we can't codegen on this
            // side. Otherwise we'd end up with vtable with unresolved
            // references.
            /*const*/ CXXMethodDecl /*P*/ MD = cast_CXXMethodDecl(GD.getDecl());
            // OK on device side: functions w/ __device__ attribute
            // OK on host side: anything except __device__-only functions.
            boolean CanEmitMethod = CGM.getLangOpts().CUDAIsDevice ? MD.hasAttr(CUDADeviceAttr.class) : (MD.hasAttr(CUDAHostAttr.class)
               || !MD.hasAttr(CUDADeviceAttr.class));
            if (!CanEmitMethod) {
              Init = ConstantExpr.getNullValue(Int8PtrTy);
              break;
            }
            // Method is acceptable, continue processing as usual.
          }
          if (cast_CXXMethodDecl(GD.getDecl()).isPure()) {
            // We have a pure virtual member function.
            if (!(PureVirtualFn != null)) {
              org.llvm.ir.FunctionType /*P*/ Ty = org.llvm.ir.FunctionType.get(CGM.VoidTy, /*isVarArg=*/ false);
              StringRef PureCallName = CGM.getCXXABI().GetPureVirtualCallName();
              PureVirtualFn = CGM.CreateRuntimeFunction(Ty, new StringRef(PureCallName));
              {
                Function /*P*/ F = dyn_cast_Function(PureVirtualFn);
                if ((F != null)) {
                  F.setUnnamedAddr(GlobalValue.UnnamedAddr.Global);
                }
              }
              PureVirtualFn = ConstantExpr.getBitCast(PureVirtualFn, 
                  CGM.Unnamed_field9.Int8PtrTy);
            }
            Init = PureVirtualFn;
          } else if (cast_CXXMethodDecl(GD.getDecl()).isDeleted()) {
            if (!(DeletedVirtualFn != null)) {
              org.llvm.ir.FunctionType /*P*/ Ty = org.llvm.ir.FunctionType.get(CGM.VoidTy, /*isVarArg=*/ false);
              StringRef DeletedCallName = CGM.getCXXABI().GetDeletedVirtualCallName();
              DeletedVirtualFn = CGM.CreateRuntimeFunction(Ty, new StringRef(DeletedCallName));
              {
                Function /*P*/ F = dyn_cast_Function(DeletedVirtualFn);
                if ((F != null)) {
                  F.setUnnamedAddr(GlobalValue.UnnamedAddr.Global);
                }
              }
              DeletedVirtualFn = ConstantExpr.getBitCast(DeletedVirtualFn, 
                  CGM.Unnamed_field9.Int8PtrTy);
            }
            Init = DeletedVirtualFn;
          } else {
            // Check if we should use a thunk.
            if ($less_uint(NextVTableThunkIndex, NumVTableThunks)
               && VTableThunks.$at(NextVTableThunkIndex).first == $uint2ullong(I)) {
              final /*const*/ ThunkInfo /*&*/ Thunk = VTableThunks.$at(NextVTableThunkIndex).second;
              
              maybeEmitThunkForVTable(new GlobalDecl(GD), Thunk);
              Init = CGM.GetAddrOfThunk(new GlobalDecl(GD), Thunk);
              
              NextVTableThunkIndex++;
            } else {
              org.llvm.ir.Type /*P*/ Ty = CGM.getTypes().GetFunctionTypeForVTable(new GlobalDecl(GD));
              
              Init = CGM.GetAddrOfFunction(new GlobalDecl(GD), Ty, /*ForVTable=*/ true);
            }
            
            Init = ConstantExpr.getBitCast(Init, Int8PtrTy);
          }
          break;
        }
       case CK_UnusedFunctionPointer:
        Init = ConstantExpr.getNullValue(Int8PtrTy);
        break;
      }
      /*JSKIP;*/
      
      Inits.push_back(Init);
    }
    
    org.llvm.ir.ArrayType /*P*/ ArrayType = org.llvm.ir.ArrayType.get(Int8PtrTy, $uint2ulong(NumComponents));
    return ConstantArray.get(ArrayType, new ArrayRef<Constant /*P*/ >(Inits, true));
  }


  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenVTables::CodeGenVTables">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGVTables.cpp", line = 32,
   FQN="clang::CodeGen::CodeGenVTables::CodeGenVTables", NM="_ZN5clang7CodeGen14CodeGenVTablesC1ERNS0_13CodeGenModuleE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGVTables.cpp -nm=_ZN5clang7CodeGen14CodeGenVTablesC1ERNS0_13CodeGenModuleE")
  //</editor-fold>
  public CodeGenVTables(final CodeGenModule /*&*/ CGM) {
    // : CGM(CGM), VTContext(CGM.getContext().getVTableContext()), SubVTTIndicies(), SecondaryVirtualPointerIndices() 
    //START JInit
    this./*&*/CGM=/*&*/CGM;
    this.VTContext = CGM.getContext().getVTableContext();
    this.SubVTTIndicies = new DenseMapTypeULong<std.pair</*const*/ CXXRecordDecl /*P*/ , BaseSubobject>>(new DenseMapInfoPair(DenseMapInfo$LikePtr.<CXXRecordDecl>$Info(), DenseMapInfoBaseSubobject.$Info()), (long/*uint64_t*/)0);
    this.SecondaryVirtualPointerIndices = new DenseMapTypeULong<std.pair</*const*/ CXXRecordDecl /*P*/ , BaseSubobject>>(new DenseMapInfoPair(DenseMapInfo$LikePtr.<CXXRecordDecl>$Info(), DenseMapInfoBaseSubobject.$Info()), (long/*uint64_t*/)0);
    //END JInit
  }


  
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenVTables::getItaniumVTableContext">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGVTables.h", line = 71,
   FQN="clang::CodeGen::CodeGenVTables::getItaniumVTableContext", NM="_ZN5clang7CodeGen14CodeGenVTables23getItaniumVTableContextEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGVTT.cpp -nm=_ZN5clang7CodeGen14CodeGenVTables23getItaniumVTableContextEv")
  //</editor-fold>
  public ItaniumVTableContext /*&*/ getItaniumVTableContext() {
    return $Deref(cast_ItaniumVTableContext(VTContext));
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenVTables::getMicrosoftVTableContext">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGVTables.h", line = 75,
   FQN="clang::CodeGen::CodeGenVTables::getMicrosoftVTableContext", NM="_ZN5clang7CodeGen14CodeGenVTables25getMicrosoftVTableContextEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGVTT.cpp -nm=_ZN5clang7CodeGen14CodeGenVTables25getMicrosoftVTableContextEv")
  //</editor-fold>
  public MicrosoftVTableContext /*&*/ getMicrosoftVTableContext() {
    return $Deref(cast_MicrosoftVTableContext(VTContext));
  }

  
  /// getSubVTTIndex - Return the index of the sub-VTT for the base class of the
  /// given record decl.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenVTables::getSubVTTIndex">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGVTT.cpp", line = 128,
   FQN="clang::CodeGen::CodeGenVTables::getSubVTTIndex", NM="_ZN5clang7CodeGen14CodeGenVTables14getSubVTTIndexEPKNS_13CXXRecordDeclENS_13BaseSubobjectE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGVTT.cpp -nm=_ZN5clang7CodeGen14CodeGenVTables14getSubVTTIndexEPKNS_13CXXRecordDeclENS_13BaseSubobjectE")
  //</editor-fold>
  public long/*uint64_t*/ getSubVTTIndex(/*const*/ CXXRecordDecl /*P*/ RD, 
                BaseSubobject Base) {
    VTTBuilder Builder = null;
    try {
      std.pair</*const*/ CXXRecordDecl /*P*/ , BaseSubobject> ClassSubobjectPair/*J*/= new std.pairPtrType</*const*/ CXXRecordDecl /*P*/ , BaseSubobject>(JD$T$RR_T1$RR.INSTANCE, RD, Base);
      
      DenseMapIteratorTypeULong<std.pair</*const*/ CXXRecordDecl /*P*/ , BaseSubobject>> I = SubVTTIndicies.find(ClassSubobjectPair);
      if (I.$noteq(/*NO_ITER_COPY*/SubVTTIndicies.end())) {
        return I.$arrow().second;
      }
      
      Builder/*J*/= new VTTBuilder(CGM.getContext(), RD, /*GenerateDefinition=*/ false);
      
      for (DenseMapIteratorTypeULong<BaseSubobject> I$1 = Builder.getSubVTTIndicies().begin$Const(), 
          E = Builder.getSubVTTIndicies().end$Const(); I$1.$noteq(E); I$1.$preInc()) {
        // Insert all indices.
        std.pair</*const*/ CXXRecordDecl /*P*/ , BaseSubobject> ClassSubobjectPair$1/*J*/= new std.pairPtrType</*const*/ CXXRecordDecl /*P*/ , BaseSubobject>(JD$T$RR_T1$C$R.INSTANCE, RD, I$1.$arrow().first);
        
        SubVTTIndicies.insert_pair$KeyT$ValueT(std.make_pair_T_ulong($Clone(ClassSubobjectPair$1), I$1.$arrow().second));
      }
      
      I.$assignMove(SubVTTIndicies.find(ClassSubobjectPair));
      assert (I.$noteq(/*NO_ITER_COPY*/SubVTTIndicies.end())) : "Did not find index!";
      
      return I.$arrow().second;
    } finally {
      if (Builder != null) { Builder.$destroy(); }
    }
  }

  
  /// getSecondaryVirtualPointerIndex - Return the index in the VTT where the
  /// virtual pointer for the given subobject is located.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenVTables::getSecondaryVirtualPointerIndex">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGVTT.cpp", line = 153,
   FQN="clang::CodeGen::CodeGenVTables::getSecondaryVirtualPointerIndex", NM="_ZN5clang7CodeGen14CodeGenVTables31getSecondaryVirtualPointerIndexEPKNS_13CXXRecordDeclENS_13BaseSubobjectE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGVTT.cpp -nm=_ZN5clang7CodeGen14CodeGenVTables31getSecondaryVirtualPointerIndexEPKNS_13CXXRecordDeclENS_13BaseSubobjectE")
  //</editor-fold>
  public long/*uint64_t*/ getSecondaryVirtualPointerIndex(/*const*/ CXXRecordDecl /*P*/ RD, 
                                 BaseSubobject Base) {
    VTTBuilder Builder = null;
    try {
      DenseMapIteratorTypeULong<std.pair</*const*/ CXXRecordDecl /*P*/ , BaseSubobject>> I = SecondaryVirtualPointerIndices.find(std.make_pair_Ptr_T(RD, Base));
      if (I.$noteq(/*NO_ITER_COPY*/SecondaryVirtualPointerIndices.end())) {
        return I.$arrow().second;
      }
      
      Builder/*J*/= new VTTBuilder(CGM.getContext(), RD, /*GenerateDefinition=*/ false);
      
      // Insert all secondary vpointer indices.
      for (DenseMapIteratorTypeULong<BaseSubobject> I$1 = Builder.getSecondaryVirtualPointerIndices().begin$Const(), 
          E = Builder.getSecondaryVirtualPointerIndices().end$Const(); I$1.$noteq(E); I$1.$preInc()) {
        std.pair</*const*/ CXXRecordDecl /*P*/ , BaseSubobject> Pair = std.make_pair_Ptr_T(RD, $Clone(I$1.$arrow().first));
        
        SecondaryVirtualPointerIndices.insert_pair$KeyT$ValueT(std.make_pair_T_ulong($Clone(Pair), I$1.$arrow().second));
      }
      
      I.$assignMove(SecondaryVirtualPointerIndices.find(std.make_pair_Ptr_T(RD, $Clone(Base))));
      assert (I.$noteq(/*NO_ITER_COPY*/SecondaryVirtualPointerIndices.end())) : "Did not find index!";
      
      return I.$arrow().second;
    } finally {
      if (Builder != null) { Builder.$destroy(); }
    }
  }

  
  /// GenerateConstructionVTable - Generate a construction vtable for the given 
  /// base subobject.
  
  /// GenerateConstructionVTable - Generate a construction vtable for the given 
  /// base subobject.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenVTables::GenerateConstructionVTable">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGVTables.cpp", line = 659,
   FQN="clang::CodeGen::CodeGenVTables::GenerateConstructionVTable", NM="_ZN5clang7CodeGen14CodeGenVTables26GenerateConstructionVTableEPKNS_13CXXRecordDeclERKNS_13BaseSubobjectEbN4llvm11GlobalValue12LinkageTypesERNS8_8DenseMapIS5_yNS8_12DenseMapInfoIS5_EENS8_6detail12DenseMapPairIS5_yEEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGVTables.cpp -nm=_ZN5clang7CodeGen14CodeGenVTables26GenerateConstructionVTableEPKNS_13CXXRecordDeclERKNS_13BaseSubobjectEbN4llvm11GlobalValue12LinkageTypesERNS8_8DenseMapIS5_yNS8_12DenseMapInfoIS5_EENS8_6detail12DenseMapPairIS5_yEEEE")
  //</editor-fold>
  public GlobalVariable /*P*/ GenerateConstructionVTable(/*const*/ CXXRecordDecl /*P*/ RD, 
                            final /*const*/ BaseSubobject /*&*/ Base, 
                            boolean BaseIsVirtual, 
                            GlobalVariable.LinkageTypes Linkage, 
                            final DenseMapTypeULong<BaseSubobject> /*&*/ AddressPoints) {
    std.unique_ptr<VTableLayout> VTLayout = null;
    raw_svector_ostream Out = null;
    try {
      {
        CGDebugInfo /*P*/ DI = CGM.getModuleDebugInfo();
        if ((DI != null)) {
          DI.completeClassData(Base.getBase());
        }
      }
      
      VTLayout/*J*/= new std.unique_ptr<VTableLayout>(getItaniumVTableContext().createConstructionVTableLayout(Base.getBase(), Base.getBaseOffset(), BaseIsVirtual, RD));
      
      // Add the address points.
      AddressPoints.$assign(VTLayout.$arrow().getAddressPoints());
      
      // Get the mangled construction vtable name.
      SmallString/*<256>*/ OutName/*J*/= new SmallString/*<256>*/(256);
      Out/*J*/= new raw_svector_ostream(OutName);
      cast_ItaniumMangleContext(CGM.getCXXABI().getMangleContext()).
          mangleCXXCtorVTable(RD, Base.getBaseOffset().getQuantity(), 
          Base.getBase(), Out);
      StringRef Name = OutName.str();
      
      org.llvm.ir.ArrayType /*P*/ ArrayType = org.llvm.ir.ArrayType.get(CGM.Unnamed_field9.Int8PtrTy, VTLayout.$arrow().getNumVTableComponents());
      
      // Construction vtable symbols are not part of the Itanium ABI, so we cannot
      // guarantee that they actually will be available externally. Instead, when
      // emitting an available_externally VTT, we provide references to an internal
      // linkage construction vtable. The ABI only requires complete-object vtables
      // to be the same for all instances of a type, not construction vtables.
      if (Linkage == GlobalVariable.LinkageTypes.AvailableExternallyLinkage) {
        Linkage = GlobalVariable.LinkageTypes.InternalLinkage;
      }
      
      // Create the variable that will hold the construction vtable.
      GlobalVariable /*P*/ VTable = CGM.CreateOrReplaceCXXRuntimeVariable(new StringRef(Name), ArrayType, Linkage);
      CGM.setGlobalVisibility(VTable, RD);
      
      // V-tables are always unnamed_addr.
      VTable.setUnnamedAddr(GlobalValue.UnnamedAddr.Global);
      
      Constant /*P*/ RTTI = CGM.GetAddrOfRTTIDescriptor(CGM.getContext().getTagDeclType(Base.getBase()));
      
      // Create and set the initializer.
      Constant /*P*/ Init = CreateVTableInitializer(Base.getBase(), VTLayout.$arrow().vtable_component_begin(), 
          $ulong2uint(VTLayout.$arrow().getNumVTableComponents()), VTLayout.$arrow().vtable_thunk_begin(), 
          $ulong2uint(VTLayout.$arrow().getNumVTableThunks()), RTTI);
      VTable.setInitializer(Init);
      
      CGM.EmitVTableTypeMetadata(VTable, $Deref(VTLayout.get()));
      
      return VTable;
    } finally {
      if (Out != null) { Out.$destroy(); }
      if (VTLayout != null) { VTLayout.$destroy(); }
    }
  }


  
  /// GetAddrOfVTT - Get the address of the VTT for the given record decl.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenVTables::GetAddrOfVTT">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGVTT.cpp", line = 104,
   FQN="clang::CodeGen::CodeGenVTables::GetAddrOfVTT", NM="_ZN5clang7CodeGen14CodeGenVTables12GetAddrOfVTTEPKNS_13CXXRecordDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGVTT.cpp -nm=_ZN5clang7CodeGen14CodeGenVTables12GetAddrOfVTTEPKNS_13CXXRecordDeclE")
  //</editor-fold>
  public GlobalVariable /*P*/ GetAddrOfVTT(/*const*/ CXXRecordDecl /*P*/ RD) {
    raw_svector_ostream Out = null;
    VTTBuilder Builder = null;
    try {
      assert ((RD.getNumVBases() != 0)) : "Only classes with virtual bases need a VTT";
      
      SmallString/*<256>*/ OutName/*J*/= new SmallString/*<256>*/(256);
      Out/*J*/= new raw_svector_ostream(OutName);
      cast_ItaniumMangleContext(CGM.getCXXABI().getMangleContext()).
          mangleCXXVTT(RD, Out);
      StringRef Name = OutName.str();
      
      // This will also defer the definition of the VTT.
      /*J:(void)*/CGM.getCXXABI().getAddrOfVTable(RD, new CharUnits());
      
      Builder/*J*/= new VTTBuilder(CGM.getContext(), RD, /*GenerateDefinition=*/ false);
      
      org.llvm.ir.ArrayType /*P*/ ArrayType = org.llvm.ir.ArrayType.get(CGM.Unnamed_field9.Int8PtrTy, $uint2ulong(Builder.getVTTComponents().size()));
      
      GlobalVariable /*P*/ GV = CGM.CreateOrReplaceCXXRuntimeVariable(new StringRef(Name), ArrayType, 
          GlobalValue.LinkageTypes.ExternalLinkage);
      GV.setUnnamedAddr(GlobalValue.UnnamedAddr.Global);
      return GV;
    } finally {
      if (Builder != null) { Builder.$destroy(); }
      if (Out != null) { Out.$destroy(); }
    }
  }

  
  /// EmitVTTDefinition - Emit the definition of the given vtable.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenVTables::EmitVTTDefinition">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGVTT.cpp", line = 41,
   FQN="clang::CodeGen::CodeGenVTables::EmitVTTDefinition", NM="_ZN5clang7CodeGen14CodeGenVTables17EmitVTTDefinitionEPN4llvm14GlobalVariableENS2_11GlobalValue12LinkageTypesEPKNS_13CXXRecordDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGVTT.cpp -nm=_ZN5clang7CodeGen14CodeGenVTables17EmitVTTDefinitionEPN4llvm14GlobalVariableENS2_11GlobalValue12LinkageTypesEPKNS_13CXXRecordDeclE")
  //</editor-fold>
  public void EmitVTTDefinition(GlobalVariable /*P*/ VTT, 
                   GlobalVariable.LinkageTypes Linkage, 
                   /*const*/ CXXRecordDecl /*P*/ RD) {
    VTTBuilder Builder = null;
    try {
      Builder/*J*/= new VTTBuilder(CGM.getContext(), RD, /*GenerateDefinition=*/ true);
      
      org.llvm.ir.Type /*P*/ Int8PtrTy = CGM.Unnamed_field9.Int8PtrTy;
      org.llvm.ir.Type /*P*/ Int32Ty = CGM.Int32Ty;
      org.llvm.ir.ArrayType /*P*/ ArrayType = org.llvm.ir.ArrayType.get(Int8PtrTy, $uint2ulong(Builder.getVTTComponents().size()));
      
      SmallVector<GlobalVariable /*P*/ > VTables/*J*/= new SmallVector<GlobalVariable /*P*/ >(8, (GlobalVariable /*P*/ )null);
      SmallVector<DenseMapTypeULong<BaseSubobject>> VTableAddressPoints/*J*/= new SmallVector<DenseMapTypeULong<BaseSubobject>>(8,
              new DenseMapTypeULong<BaseSubobject>(DenseMapInfoBaseSubobject.$Info(),0));
      for (type$ptr</*const*/ VTTVTable /*P*/> i = $tryClone(Builder.getVTTVTables().begin$Const()), 
          /*P*/ e = $tryClone(Builder.getVTTVTables().end$Const()); Native.$noteq_iter(i, e); i.$preInc()) {
        VTableAddressPoints.push_back_T$RR(new DenseMapTypeULong<BaseSubobject>(DenseMapInfoBaseSubobject.$Info(), 0));
        VTables.push_back(CGVTTStatics.GetAddrOfVTTVTable(/*Deref*/this, CGM, RD, /*Deref*/i.$star(), Linkage, 
                VTableAddressPoints.back()));
      }
      
      SmallVector<Constant /*P*/ > VTTComponents/*J*/= new SmallVector<Constant /*P*/ >(8, (Constant /*P*/ )null);
      for (type$ptr</*const*/ VTTComponent /*P*/> i = $tryClone(Builder.getVTTComponents().begin$Const()), 
          /*P*/ e = $tryClone(Builder.getVTTComponents().end$Const()); Native.$noteq_iter(i, e); i.$preInc()) {
        final /*const*/ VTTVTable /*&*/ VTTVT = Builder.getVTTVTables().$at$Const($ulong2uint(i.$star().VTableIndex));
        GlobalVariable /*P*/ VTable = VTables.$at($ulong2uint(i.$star().VTableIndex));
        long/*uint64_t*/ AddressPoint;
        if (VTTVT.getBase() == RD) {
          // Just get the address point for the regular vtable.
          AddressPoint
             = getItaniumVTableContext().getVTableLayout(RD).getAddressPoint(new BaseSubobject(i.$star().VTableBase));
          assert (AddressPoint != $int2ullong(0)) : "Did not find vtable address point!";
        } else {
          AddressPoint = VTableAddressPoints.$at($ulong2uint(i.$star().VTableIndex)).lookup(i.$star().VTableBase);
          assert (AddressPoint != $int2ullong(0)) : "Did not find ctor vtable address point!";
        }
        
        Value /*P*/ Idxs[/*2*/] = new Value /*P*/  [/*2*/] {
          ConstantInt.get(Int32Ty, $int2ulong(0)), 
          ConstantInt.get(Int32Ty, AddressPoint)
        };
        
        Constant /*P*/ Init = ConstantExpr.getInBoundsGetElementPtr_Type$P_Constant$P_ArrayRef$Value$P(VTable.getValueType(), VTable, new ArrayRef<Value /*P*/ >(Idxs, true));
        
        Init = ConstantExpr.getBitCast(Init, Int8PtrTy);
        
        VTTComponents.push_back(Init);
      }
      
      Constant /*P*/ Init = ConstantArray.get(ArrayType, new ArrayRef<Constant /*P*/ >(VTTComponents, true));
      
      VTT.setInitializer(Init);
      
      // Set the correct linkage.
      VTT.setLinkage(Linkage);
      if (CGM.supportsCOMDAT() && VTT.isWeakForLinker()) {
        VTT.setComdat(CGM.getModule().getOrInsertComdat(VTT.getName()));
      }
      
      // Set the right visibility.
      CGM.setGlobalVisibility(VTT, RD);
    } finally {
      if (Builder != null) { Builder.$destroy(); }
    }
  }

  
  /// EmitThunks - Emit the associated thunks for the given global decl.
  
  /// EmitThunks - Emit the associated thunks for the given global decl.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenVTables::EmitThunks">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGVTables.cpp", line = 504,
   FQN="clang::CodeGen::CodeGenVTables::EmitThunks", NM="_ZN5clang7CodeGen14CodeGenVTables10EmitThunksENS_10GlobalDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGVTables.cpp -nm=_ZN5clang7CodeGen14CodeGenVTables10EmitThunksENS_10GlobalDeclE")
  //</editor-fold>
  public void EmitThunks(GlobalDecl GD) {
    /*const*/ CXXMethodDecl /*P*/ MD = cast_CXXMethodDecl(GD.getDecl()).getCanonicalDecl$Const();
    
    // We don't need to generate thunks for the base destructor.
    if (isa_CXXDestructorDecl(MD) && GD.getDtorType() == CXXDtorType.Dtor_Base) {
      return;
    }
    
    /*const*/SmallVector<ThunkInfo> /*P*/ ThunkInfoVector = VTContext.getThunkInfo(new GlobalDecl(GD));
    if (!(ThunkInfoVector != null)) {
      return;
    }
    
    for (final /*const*/ ThunkInfo /*&*/ Thunk : $Deref(ThunkInfoVector))  {
      emitThunk(new GlobalDecl(GD), Thunk, /*ForVTable=*/ false);
    }
  }


  
  /// GenerateClassData - Generate all the class data required to be
  /// generated upon definition of a KeyFunction.  This includes the
  /// vtable, the RTTI data structure (if RTTI is enabled) and the VTT
  /// (if the class has virtual bases).
  
  /// GenerateClassData - Generate all the class data required to be
  /// generated upon definition of a KeyFunction.  This includes the
  /// vtable, the RTTI data structure (if RTTI is enabled) and the VTT
  /// (if the class has virtual bases).
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenVTables::GenerateClassData">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGVTables.cpp", line = 822,
   FQN="clang::CodeGen::CodeGenVTables::GenerateClassData", NM="_ZN5clang7CodeGen14CodeGenVTables17GenerateClassDataEPKNS_13CXXRecordDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGVTables.cpp -nm=_ZN5clang7CodeGen14CodeGenVTables17GenerateClassDataEPKNS_13CXXRecordDeclE")
  //</editor-fold>
  public void GenerateClassData(/*const*/ CXXRecordDecl /*P*/ RD) {
    {
      CGDebugInfo /*P*/ DI = CGM.getModuleDebugInfo();
      if ((DI != null)) {
        DI.completeClassData(RD);
      }
    }
    if ((RD.getNumVBases() != 0)) {
      CGM.getCXXABI().emitVirtualInheritanceTables(RD);
    }
    
    CGM.getCXXABI().emitVTableDefinitions(/*Deref*/this, RD);
  }


  
  /// At this point in the translation unit, does it appear that can we
  /// rely on the vtable being defined elsewhere in the program?
  ///
  /// The response is really only definitive when called at the end of
  /// the translation unit.
  ///
  /// The only semantic restriction here is that the object file should
  /// not contain a vtable definition when that vtable is defined
  /// strongly elsewhere.  Otherwise, we'd just like to avoid emitting
  /// vtables when unnecessary.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenVTables::isVTableExternal">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGVTables.cpp", line = 843,
   FQN="clang::CodeGen::CodeGenVTables::isVTableExternal", NM="_ZN5clang7CodeGen14CodeGenVTables16isVTableExternalEPKNS_13CXXRecordDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGVTables.cpp -nm=_ZN5clang7CodeGen14CodeGenVTables16isVTableExternalEPKNS_13CXXRecordDeclE")
  //</editor-fold>
  public boolean isVTableExternal(/*const*/ CXXRecordDecl /*P*/ RD) {
    assert (RD.isDynamicClass()) : "Non-dynamic classes have no VTable.";
    
    // We always synthesize vtables if they are needed in the MS ABI. MSVC doesn't
    // emit them even if there is an explicit template instantiation.
    if (CGM.getTarget().getCXXABI().isMicrosoft()) {
      return false;
    }
    
    // If we have an explicit instantiation declaration (and not a
    // definition), the vtable is defined elsewhere.
    TemplateSpecializationKind TSK = RD.getTemplateSpecializationKind();
    if (TSK == TemplateSpecializationKind.TSK_ExplicitInstantiationDeclaration) {
      return true;
    }
    
    // Otherwise, if the class is an instantiated template, the
    // vtable must be defined here.
    if (TSK == TemplateSpecializationKind.TSK_ImplicitInstantiation
       || TSK == TemplateSpecializationKind.TSK_ExplicitInstantiationDefinition) {
      return false;
    }
    
    // Otherwise, if the class doesn't have a key function (possibly
    // anymore), the vtable must be defined here.
    /*const*/ CXXMethodDecl /*P*/ keyFunction = CGM.getContext().getCurrentKeyFunction(RD);
    if (!(keyFunction != null)) {
      return false;
    }
    
    // Otherwise, if we don't have a definition of the key function, the
    // vtable must be defined somewhere else.
    return !keyFunction.hasBody();
  }


  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenVTables::~CodeGenVTables">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGVTables.h", line = 31,
   FQN="clang::CodeGen::CodeGenVTables::~CodeGenVTables", NM="_ZN5clang7CodeGen14CodeGenVTablesD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp -nm=_ZN5clang7CodeGen14CodeGenVTablesD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    //START JDestroy
    SecondaryVirtualPointerIndices.$destroy();
    SubVTTIndicies.$destroy();
    //END JDestroy
  }


  
  @Override public String toString() {
    return "" + "CGM=" + CGM // NOI18N
              + ", VTContext=" + VTContext // NOI18N
              + ", SubVTTIndicies=" + SubVTTIndicies // NOI18N
              + ", SecondaryVirtualPointerIndices=" + SecondaryVirtualPointerIndices; // NOI18N
  }
}
