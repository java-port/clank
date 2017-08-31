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
import static org.clang.basic.BasicClangGlobals.*;
import org.llvm.ir.*;
import org.clang.codegen.impl.*;
import org.clang.codegen.CodeGen.*;
import org.clang.codegen.java.ClangCodeGenFunctionPointers.*;
import org.clang.codegen.java.ClangCodeGenJavaDifferentiators.*;
import org.llvm.ir.ArrayType;
import org.llvm.ir.FunctionType;
import org.llvm.ir.PointerType;
import org.llvm.ir.Type;
import org.clang.ast.BinaryOperator;
import org.clang.ast.DeclContext.specific_decl_iterator;
import static org.clang.ast.java.AstRTTI.*;
import static org.clang.ast.java.AstExpressionsRTTI.*;
import static org.clang.ast.java.AstDeclarationsRTTI.*;
import static org.clang.codegen.java.CodegenRTTI.*;
import static org.llvm.ir.java.IrRTTI.*;
import static org.clang.ast.java.AstJavaDifferentiators.*;
import static org.clang.ast.java.AstStatementsRTTI.*;
import org.clang.basic.codegenoptions.DebugInfoKind;
import static org.clang.codegen.impl.CGOpenMPRuntimeStatics.*;
import static org.llvm.bitcode.BitcodeLlvmGlobals.*;

//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGOpenMPRuntime">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.h", line = 108,
 FQN="clang::CodeGen::CGOpenMPRuntime", NM="_ZN5clang7CodeGen15CGOpenMPRuntimeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp -nm=_ZN5clang7CodeGen15CGOpenMPRuntimeE")
//</editor-fold>
public class CGOpenMPRuntime implements Destructors.ClassWithDestructor {
/*protected:*/
  protected final CodeGenModule /*&*/ CGM;
  
  /// \brief Creates offloading entry for the provided entry ID \a ID,
  /// address \a Addr and size \a Size.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGOpenMPRuntime::createOffloadEntry">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp", line = 2888,
   FQN="clang::CodeGen::CGOpenMPRuntime::createOffloadEntry", NM="_ZN5clang7CodeGen15CGOpenMPRuntime18createOffloadEntryEPN4llvm8ConstantES4_y",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp -nm=_ZN5clang7CodeGen15CGOpenMPRuntime18createOffloadEntryEPN4llvm8ConstantES4_y")
  //</editor-fold>
  protected void createOffloadEntry(Constant /*P*/ ID, 
                    Constant /*P*/ Addr, long/*uint64_t*/ Size) {
    StringRef Name = Addr.getName();
    StructType /*P*/ TgtOffloadEntryType = cast_StructType(CGM.getTypes().ConvertTypeForMem(getTgtOffloadEntryQTy()));
    final LLVMContext /*&*/ C = CGM.getModule().getContext();
    final org.llvm.ir.Module /*&*/ M = CGM.getModule();
    
    // Make sure the address has the right type.
    Constant /*P*/ AddrPtr = ConstantExpr.getBitCast(ID, CGM.Unnamed_field9.VoidPtrTy);
    
    // Create constant string with the name.
    Constant /*P*/ StrPtrInit = ConstantDataArray.getString(C, new StringRef(Name));
    
    GlobalVariable /*P*/ Str = /*NEW_EXPR [GlobalVariable::new]*/GlobalVariable.$new_GlobalVariable((type$ptr<?> New$Mem)->{
        return new GlobalVariable(M, StrPtrInit.getType(), /*isConstant=*/ true, 
                GlobalValue.LinkageTypes.InternalLinkage, StrPtrInit, 
                new Twine(/*KEEP_STR*/".omp_offloading.entry_name"));
     });
    Str.setUnnamedAddr(GlobalValue.UnnamedAddr.Global);
    Constant /*P*/ StrPtr = ConstantExpr.getBitCast(Str, CGM.Unnamed_field9.Int8PtrTy);
    
    // Create the entry struct.
    Constant /*P*/ EntryInit = ConstantStruct.get(TgtOffloadEntryType, AddrPtr, StrPtr, 
        ConstantInt.get(CGM.Unnamed_field8.SizeTy, Size), null);
    GlobalVariable /*P*/ Entry = /*NEW_EXPR [GlobalVariable::new]*/GlobalVariable.$new_GlobalVariable((type$ptr<?> New$Mem)->{
        return new GlobalVariable(M, TgtOffloadEntryType, true, GlobalValue.LinkageTypes.ExternalLinkage, 
                EntryInit, new Twine(/*KEEP_STR*/".omp_offloading.entry"));
     });
    
    // The entry has to be created in the section the linker expects it to be.
    Entry.setSection(new StringRef(/*KEEP_STR*/".omp_offloading.entries"));
    // We can't have any padding between symbols, so we need to have 1-byte
    // alignment.
    Entry.setAlignment(1);
  }

  
  /// \brief Helper to emit outlined function for 'target' directive.
  /// \param D Directive to emit.
  /// \param ParentName Name of the function that encloses the target region.
  /// \param OutlinedFn Outlined function value to be defined by this call.
  /// \param OutlinedFnID Outlined function ID value to be defined by this call.
  /// \param IsOffloadEntry True if the outlined function is an offload entry.
  /// \param CodeGen Lambda codegen specific to an accelerator device.
  /// An oulined function may not be an entry if, e.g. the if clause always
  /// evaluates to false.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGOpenMPRuntime::emitTargetOutlinedFunctionHelper">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp", line = 4787,
   FQN="clang::CodeGen::CGOpenMPRuntime::emitTargetOutlinedFunctionHelper", NM="_ZN5clang7CodeGen15CGOpenMPRuntime32emitTargetOutlinedFunctionHelperERKNS_22OMPExecutableDirectiveEN4llvm9StringRefERPNS5_8FunctionERPNS5_8ConstantEbRKNS0_15RegionCodeGenTyE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp -nm=_ZN5clang7CodeGen15CGOpenMPRuntime32emitTargetOutlinedFunctionHelperERKNS_22OMPExecutableDirectiveEN4llvm9StringRefERPNS5_8FunctionERPNS5_8ConstantEbRKNS0_15RegionCodeGenTyE")
  //</editor-fold>
  protected void emitTargetOutlinedFunctionHelper(final /*const*/ OMPExecutableDirective /*&*/ D, StringRef ParentName, 
                                  final type$ref<Function /*P*/ /*&*/> OutlinedFn, final type$ref<Constant /*P*/ /*&*/> OutlinedFnID, 
                                  boolean IsOffloadEntry, final /*const*/ RegionCodeGenTy /*&*/ CodeGen) {
    CodeGenFunction CGF = null;
    CGOpenMPTargetRegionInfo CGInfo = null;
    CodeGenFunction.CGCapturedStmtRAII CapInfoRAII = null;
    try {
      // Create a unique name for the entry function using the source location
      // information of the current target region. The name will be something like:
      //
      // __omp_offloading_DD_FFFF_PP_lBB
      //
      // where DD_FFFF is an ID unique to the file (device and file IDs), PP is the
      // mangled name of the function that encloses the target region and BB is the
      // line number of the target region.
      uint$ref DeviceID = create_uint$ref();
      uint$ref FileID = create_uint$ref();
      uint$ref Line = create_uint$ref();
      CGOpenMPRuntimeStatics.getTargetEntryUniqueInfo(CGM.getContext(), D.getLocStart(), DeviceID, FileID, 
          Line);
      SmallString/*<64>*/ EntryFnName/*J*/= new SmallString/*<64>*/(64);
      {
        raw_svector_ostream OS = null;
        try {
          OS/*J*/= new raw_svector_ostream(EntryFnName);
          OS.$out(/*KEEP_STR*/"__omp_offloading").$out(llvm.format_uint(/*KEEP_STR*/"_%x", DeviceID.$deref())).$out(
              llvm.format_uint(/*KEEP_STR*/"_%x_", FileID.$deref())
          ).$out(/*NO_COPY*/ParentName).$out(/*KEEP_STR*/"_l").$out_uint(Line.$deref());
        } finally {
          if (OS != null) { OS.$destroy(); }
        }
      }
      
      final /*const*/ CapturedStmt /*&*/ CS = $Deref(cast_CapturedStmt(D.getAssociatedStmt()));
      
      CGF/*J*/= new CodeGenFunction(CGM, true);
      CGInfo/*J*/= new CGOpenMPTargetRegionInfo(CS, CodeGen, EntryFnName.$StringRef());
      CapInfoRAII/*J*/= new CodeGenFunction.CGCapturedStmtRAII(CGF, $AddrOf(CGInfo));
      
      OutlinedFn.$set(CGF.GenerateOpenMPCapturedStmtFunction(CS));
      
      // If this target outline function is not an offload entry, we don't need to
      // register it.
      if (!IsOffloadEntry) {
        return;
      }
      
      // The target region ID is used by the runtime library to identify the current
      // target region, so it only has to be unique and not necessarily point to
      // anything. It could be the pointer to the outlined function that implements
      // the target region, but we aren't using that so that the compiler doesn't
      // need to keep that, and could therefore inline the host function if proven
      // worthwhile during optimization. In the other hand, if emitting code for the
      // device, the ID has to be the function address so that it can retrieved from
      // the offloading entry and launched by the runtime library. We also mark the
      // outlined function to have external linkage in case we are emitting code for
      // the device, because these functions will be entry points to the device.
      if (CGM.getLangOpts().OpenMPIsDevice) {
        OutlinedFnID.$set(ConstantExpr.getBitCast(OutlinedFn.$deref(), CGM.Unnamed_field9.Int8PtrTy));
        OutlinedFn.$deref().setLinkage(GlobalValue.LinkageTypes.ExternalLinkage);
      } else {
        OutlinedFnID.$set(/*NEW_EXPR [GlobalVariable::new]*/GlobalVariable.$new_GlobalVariable((type$ptr<?> New$Mem)->{
            return new GlobalVariable(CGM.getModule(), CGM.Int8Ty, /*isConstant=*/ true, 
                    GlobalValue.LinkageTypes.PrivateLinkage, 
                    Constant.getNullValue(CGM.Int8Ty), new Twine(/*KEEP_STR*/".omp_offload.region_id"));
         }));
      }
      
      // Register the information for the entry associated with this target region.
      OffloadEntriesInfoManager.registerTargetRegionEntryInfo(DeviceID.$deref(), FileID.$deref(), new StringRef(ParentName), Line.$deref(), OutlinedFn.$deref(), OutlinedFnID.$deref());
    } finally {
      if (CapInfoRAII != null) { CapInfoRAII.$destroy(); }
      if (CGInfo != null) { CGInfo.$destroy(); }
      if (CGF != null) { CGF.$destroy(); }
    }
  }

/*private:*/
  /// \brief Default const ident_t object used for initialization of all other
  /// ident_t objects.
  private Constant /*P*/ DefaultOpenMPPSource/* = null*/;
  /// \brief Map of flags and corresponding default locations.
  // JAVA: typedef llvm::DenseMap<unsigned int, llvm::Value *> OpenMPDefaultLocMapTy
//  public final class OpenMPDefaultLocMapTy extends DenseMapUIntType<Value /*P*/ >{ };
  private DenseMapUIntType<Value /*P*/ > OpenMPDefaultLocMap;
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGOpenMPRuntime::getOrCreateDefaultLocation">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp", line = 895,
   FQN="clang::CodeGen::CGOpenMPRuntime::getOrCreateDefaultLocation", NM="_ZN5clang7CodeGen15CGOpenMPRuntime26getOrCreateDefaultLocationEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp -nm=_ZN5clang7CodeGen15CGOpenMPRuntime26getOrCreateDefaultLocationEj")
  //</editor-fold>
  private Address getOrCreateDefaultLocation(/*uint*/int Flags) {
    CharUnits Align = CGOpenMPRuntimeStatics.getIdentAlign(CGM);
    Value /*P*/ Entry = OpenMPDefaultLocMap.lookup(Flags);
    if (!(Entry != null)) {
      if (!(DefaultOpenMPPSource != null)) {
        // Initialize default location for psource field of ident_t structure of
        // all ident_t objects. Format is ";file;function;line;column;;".
        // Taken from
        // http://llvm.org/svn/llvm-project/openmp/trunk/runtime/src/kmp_str.c
        DefaultOpenMPPSource
           = CGM.GetAddrOfConstantCString(new std.string(JD$T$C$P_T2$C$R.INSTANCE, /*KEEP_STR*/";unknown;unknown;0;0;;")).getPointer();
        DefaultOpenMPPSource
           = ConstantExpr.getBitCast(DefaultOpenMPPSource, CGM.Unnamed_field9.Int8PtrTy);
      }
      GlobalVariable /*P*/ DefaultOpenMPLocation = /*NEW_EXPR [GlobalVariable::new]*/GlobalVariable.$new_GlobalVariable((type$ptr<?> New$Mem)->{
          return new GlobalVariable(CGM.getModule(), IdentTy, /*isConstant*/ true, 
                  GlobalValue.LinkageTypes.PrivateLinkage, /*Initializer*/ (Constant /*P*/ )null);
       });
      DefaultOpenMPLocation.setUnnamedAddr(GlobalValue.UnnamedAddr.Global);
      DefaultOpenMPLocation.setAlignment($long2uint(Align.getQuantity()));
      
      Constant /*P*/ Zero = ConstantInt.get(CGM.Int32Ty, $int2ulong(0), true);
      Constant /*P*/ Values[/*5*/] = new Constant /*P*/  [/*5*/] {
        Zero, 
        ConstantInt.get(CGM.Int32Ty, $uint2ulong(Flags)), 
        Zero, Zero, DefaultOpenMPPSource};
      Constant /*P*/ Init = ConstantStruct.get(IdentTy, new ArrayRef<Constant /*P*/ >(Values, true));
      DefaultOpenMPLocation.setInitializer(Init);
      OpenMPDefaultLocMap.$set(Flags, Entry = DefaultOpenMPLocation);
    }
    return new Address(Entry, new CharUnits(Align));
  }

  
  private StructType /*P*/ IdentTy/* = null*/;
  /// \brief Map for SourceLocation and OpenMP runtime library debug locations.
  // JAVA: typedef llvm::DenseMap<unsigned int, llvm::Value *> OpenMPDebugLocMapTy
//  public final class OpenMPDebugLocMapTy extends DenseMapUIntType<Value /*P*/ >{ };
  private DenseMapUIntType<Value /*P*/ > OpenMPDebugLocMap;
  /// \brief The type for a microtask which gets passed to __kmpc_fork_call().
  /// Original representation is:
  /// typedef void (kmpc_micro)(kmp_int32 global_tid, kmp_int32 bound_tid,...);
  private org.llvm.ir.FunctionType /*P*/ Kmpc_MicroTy/* = null*/;
  /// \brief Stores debug location and ThreadID for the function.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGOpenMPRuntime::DebugLocThreadIdTy">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.h", line = 151,
   FQN="clang::CodeGen::CGOpenMPRuntime::DebugLocThreadIdTy", NM="_ZN5clang7CodeGen15CGOpenMPRuntime18DebugLocThreadIdTyE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp -nm=_ZN5clang7CodeGen15CGOpenMPRuntime18DebugLocThreadIdTyE")
  //</editor-fold>
  private static class/*struct*/ DebugLocThreadIdTy implements NativeCloneable<DebugLocThreadIdTy>, NativeMoveable<DebugLocThreadIdTy> {
    public Value /*P*/ DebugLoc;
    public Value /*P*/ ThreadID;
    //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGOpenMPRuntime::DebugLocThreadIdTy::DebugLocThreadIdTy">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.h", line = 151,
     FQN="clang::CodeGen::CGOpenMPRuntime::DebugLocThreadIdTy::DebugLocThreadIdTy", NM="_ZN5clang7CodeGen15CGOpenMPRuntime18DebugLocThreadIdTyC1EOS2_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp -nm=_ZN5clang7CodeGen15CGOpenMPRuntime18DebugLocThreadIdTyC1EOS2_")
    //</editor-fold>
    public /*inline*/ DebugLocThreadIdTy(JD$Move _dparam, final DebugLocThreadIdTy /*&&*/$Prm0) {
      // : DebugLoc(static_cast<DebugLocThreadIdTy &&>().DebugLoc), ThreadID(static_cast<DebugLocThreadIdTy &&>().ThreadID) 
      //START JInit
      this.DebugLoc = $Prm0.DebugLoc;
      this.ThreadID = $Prm0.ThreadID;
      //END JInit
    }

    //////////////////////////////////////////////////////////////
    // EXTRA MEMBERS: BEGIN

    //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGOpenMPRuntime::DebugLocThreadIdTy::DebugLocThreadIdTy">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.h", line = 151,
     FQN="clang::CodeGen::CGOpenMPRuntime::DebugLocThreadIdTy::DebugLocThreadIdTy", NM="_ZN5clang7CodeGen15CGOpenMPRuntime18DebugLocThreadIdTyC1ERKS2_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp -nm=_ZN5clang7CodeGen15CGOpenMPRuntime18DebugLocThreadIdTyC1ERKS2_")
    //</editor-fold>
    public /*inline*/ DebugLocThreadIdTy(final /*const*/ DebugLocThreadIdTy /*&*/ $Prm0) {
      // : DebugLoc(.DebugLoc), ThreadID(.ThreadID) 
      //START JInit
      this.DebugLoc = $Prm0.DebugLoc;
      this.ThreadID = $Prm0.ThreadID;
      //END JInit
    }
    
    public DebugLocThreadIdTy() { 
    }

    @Override public DebugLocThreadIdTy clone() {
      return new DebugLocThreadIdTy(this);
    }

    @Override public DebugLocThreadIdTy move() {
      return new DebugLocThreadIdTy(JD$Move.INSTANCE, this);
    }


    // EXTRA MEMBERS: END
    //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
      return "" + "DebugLoc=" + DebugLoc // NOI18N
                + ", ThreadID=" + ThreadID; // NOI18N
    }
  };
  /// \brief Map of local debug location, ThreadId and functions.
  // JAVA: typedef llvm::DenseMap<llvm::Function *, DebugLocThreadIdTy> OpenMPLocThreadIDMapTy
//  public final class OpenMPLocThreadIDMapTy extends DenseMap<Function /*P*/ , DebugLocThreadIdTy>{ };
  private DenseMap<Function /*P*/ , DebugLocThreadIdTy> OpenMPLocThreadIDMap;
  /// Map of UDRs and corresponding combiner/initializer.
  // JAVA: typedef llvm::DenseMap<const OMPDeclareReductionDecl *, std::pair<llvm::Function *, llvm::Function *> > UDRMapTy
//  public final class UDRMapTy extends DenseMap</*const*/ OMPDeclareReductionDecl /*P*/ , std.pair<Function /*P*/ , Function /*P*/ >>{ };
  private DenseMap</*const*/ OMPDeclareReductionDecl /*P*/ , std.pair<Function /*P*/ , Function /*P*/ >> UDRMap;
  /// Map of functions and locally defined UDRs.
  // JAVA: typedef llvm::DenseMap<llvm::Function *, SmallVector<const OMPDeclareReductionDecl *, 4> > FunctionUDRMapTy
//  public final class FunctionUDRMapTy extends DenseMap<Function /*P*/ , SmallVector</*const*/ OMPDeclareReductionDecl /*P*/ >>{ };
  private DenseMap<Function /*P*/ , SmallVector</*const*/ OMPDeclareReductionDecl /*P*/ >> FunctionUDRMap;
  private IdentifierInfo /*P*/ In/* = null*/;
  private IdentifierInfo /*P*/ Out/* = null*/;
  private IdentifierInfo /*P*/ Priv/* = null*/;
  private IdentifierInfo /*P*/ Orig/* = null*/;
  /// \brief Type kmp_critical_name, originally defined as typedef kmp_int32
  /// kmp_critical_name[8];
  private org.llvm.ir.ArrayType /*P*/ KmpCriticalNameTy;
  /// \brief An ordered map of auto-generated variables to their unique names.
  /// It stores variables with the following names: 1) ".gomp_critical_user_" +
  /// <critical_section_name> + ".var" for "omp critical" directives; 2)
  /// <mangled_name_for_global_var> + ".cache." for cache for threadprivate
  /// variables.
  private StringMap<AssertingVH<Constant>/*, BumpPtrAllocatorImpl*/> InternalVars;
  /// \brief Type typedef kmp_int32 (* kmp_routine_entry_t)(kmp_int32, void *);
  private org.llvm.ir.Type /*P*/ KmpRoutineEntryPtrTy/* = null*/;
  private QualType KmpRoutineEntryPtrQTy;
  /// \brief Type typedef struct kmp_task {
  ///    void *              shareds; /**< pointer to block of pointers to
  ///    shared vars   */
  ///    kmp_routine_entry_t routine; /**< pointer to routine to call for
  ///    executing task */
  ///    kmp_int32           part_id; /**< part id for the task */
  ///    kmp_routine_entry_t destructors; /* pointer to function to invoke
  ///    deconstructors of firstprivate C++ objects */
  /// } kmp_task_t;
  private QualType KmpTaskTQTy;
  /// \brief Type typedef struct kmp_depend_info {
  ///    kmp_intptr_t               base_addr;
  ///    size_t                     len;
  ///    struct {
  ///             bool                   in:1;
  ///             bool                   out:1;
  ///    } flags;
  /// } kmp_depend_info_t;
  private QualType KmpDependInfoTy;
  /// struct kmp_dim {  // loop bounds info casted to kmp_int64
  ///  kmp_int64 lo; // lower
  ///  kmp_int64 up; // upper
  ///  kmp_int64 st; // stride
  /// };
  private QualType KmpDimTy;
  /// \brief Type struct __tgt_offload_entry{
  ///   void      *addr;       // Pointer to the offload entry info.
  ///                          // (function or global)
  ///   char      *name;       // Name of the function or global.
  ///   size_t     size;       // Size of the entry info (0 if it a function).
  /// };
  private QualType TgtOffloadEntryQTy;
  /// struct __tgt_device_image{
  /// void   *ImageStart;       // Pointer to the target code start.
  /// void   *ImageEnd;         // Pointer to the target code end.
  /// // We also add the host entries to the device image, as it may be useful
  /// // for the target runtime to have access to that information.
  /// __tgt_offload_entry  *EntriesBegin;   // Begin of the table with all
  ///                                       // the entries.
  /// __tgt_offload_entry  *EntriesEnd;     // End of the table with all the
  ///                                       // entries (non inclusive).
  /// };
  private QualType TgtDeviceImageQTy;
  /// struct __tgt_bin_desc{
  ///   int32_t              NumDevices;      // Number of devices supported.
  ///   __tgt_device_image   *DeviceImages;   // Arrays of device images
  ///                                         // (one per device).
  ///   __tgt_offload_entry  *EntriesBegin;   // Begin of the table with all the
  ///                                         // entries.
  ///   __tgt_offload_entry  *EntriesEnd;     // End of the table with all the
  ///                                         // entries (non inclusive).
  /// };
  private QualType TgtBinaryDescriptorQTy;
  /// \brief Entity that registers the offloading constants that were emitted so
  /// far.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGOpenMPRuntime::OffloadEntriesInfoManagerTy">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.h", line = 241,
   FQN="clang::CodeGen::CGOpenMPRuntime::OffloadEntriesInfoManagerTy", NM="_ZN5clang7CodeGen15CGOpenMPRuntime27OffloadEntriesInfoManagerTyE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp -nm=_ZN5clang7CodeGen15CGOpenMPRuntime27OffloadEntriesInfoManagerTyE")
  //</editor-fold>
  /*friend*/public/*private*/ static class OffloadEntriesInfoManagerTy implements Destructors.ClassWithDestructor {
    private final CodeGenModule /*&*/ CGM;
    
    /// \brief Number of entries registered so far.
    private /*uint*/int OffloadingEntriesNum;
  /*public:*/
    /// \brief Base class of the entries info.
    //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGOpenMPRuntime::OffloadEntriesInfoManagerTy::OffloadEntryInfo">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.h", line = 249,
     FQN="clang::CodeGen::CGOpenMPRuntime::OffloadEntriesInfoManagerTy::OffloadEntryInfo", NM="_ZN5clang7CodeGen15CGOpenMPRuntime27OffloadEntriesInfoManagerTy16OffloadEntryInfoE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp -nm=_ZN5clang7CodeGen15CGOpenMPRuntime27OffloadEntriesInfoManagerTy16OffloadEntryInfoE")
    //</editor-fold>
    public static class OffloadEntryInfo implements NativePOD<OffloadEntryInfo>, NativeMoveable<OffloadEntryInfo> {
    /*public:*/
      /// \brief Kind of a given entry. Currently, only target regions are
      /// supported.
      //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGOpenMPRuntime::OffloadEntriesInfoManagerTy::OffloadEntryInfo::OffloadingEntryInfoKinds">
      @Converted(kind = Converted.Kind.AUTO,
       source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.h", line = 253,
       FQN="clang::CodeGen::CGOpenMPRuntime::OffloadEntriesInfoManagerTy::OffloadEntryInfo::OffloadingEntryInfoKinds", NM="_ZN5clang7CodeGen15CGOpenMPRuntime27OffloadEntriesInfoManagerTy16OffloadEntryInfo24OffloadingEntryInfoKindsE",
       cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp -nm=_ZN5clang7CodeGen15CGOpenMPRuntime27OffloadEntriesInfoManagerTy16OffloadEntryInfo24OffloadingEntryInfoKindsE")
      //</editor-fold>
      public enum OffloadingEntryInfoKinds/* : unsigned int*/ implements Native.NativeUIntEnum {
        // Entry is a target region.
        OFFLOAD_ENTRY_INFO_TARGET_REGION(0),
        // Invalid entry info.
        OFFLOAD_ENTRY_INFO_INVALID(~0/*U*/);

        //<editor-fold defaultstate="collapsed" desc="hidden">
        public static OffloadingEntryInfoKinds valueOf(int val) {
          OffloadingEntryInfoKinds out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
          assert out != null : "no value for " + val;
          assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
          return out;
        }

        private static final class Values {
          private static final OffloadingEntryInfoKinds[] VALUES;
          private static final OffloadingEntryInfoKinds[] _VALUES; // [0] not used
          static {
            int max = 0;
            int min = 0;
            for (OffloadingEntryInfoKinds kind : OffloadingEntryInfoKinds.values()) {
              if (kind.value > max) { max = kind.value; }
              if (kind.value < min) { min = kind.value; }
            }
            _VALUES = new OffloadingEntryInfoKinds[min < 0 ? (1-min) : 0];
            VALUES = new OffloadingEntryInfoKinds[max >= 0 ? (1+max) : 0];
            for (OffloadingEntryInfoKinds kind : OffloadingEntryInfoKinds.values()) {
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
        private OffloadingEntryInfoKinds(int val) { this.value = (/*uint*/int)val;}
        @Override public final /*uint*/int getValue() { return value;}
        //</editor-fold>
      };
      
      //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGOpenMPRuntime::OffloadEntriesInfoManagerTy::OffloadEntryInfo::OffloadEntryInfo">
      @Converted(kind = Converted.Kind.AUTO,
       source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.h", line = 260,
       FQN="clang::CodeGen::CGOpenMPRuntime::OffloadEntriesInfoManagerTy::OffloadEntryInfo::OffloadEntryInfo", NM="_ZN5clang7CodeGen15CGOpenMPRuntime27OffloadEntriesInfoManagerTy16OffloadEntryInfoC1Ev",
       cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp -nm=_ZN5clang7CodeGen15CGOpenMPRuntime27OffloadEntriesInfoManagerTy16OffloadEntryInfoC1Ev")
      //</editor-fold>
      public OffloadEntryInfo() {
        // : Order(~0uU), Kind(OFFLOAD_ENTRY_INFO_INVALID) 
        //START JInit
        this.Order = ~0/*U*/;
        this.Kind = OffloadingEntryInfoKinds.OFFLOAD_ENTRY_INFO_INVALID;
        //END JInit
      }

      //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGOpenMPRuntime::OffloadEntriesInfoManagerTy::OffloadEntryInfo::OffloadEntryInfo">
      @Converted(kind = Converted.Kind.AUTO,
       source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.h", line = 261,
       FQN="clang::CodeGen::CGOpenMPRuntime::OffloadEntriesInfoManagerTy::OffloadEntryInfo::OffloadEntryInfo", NM="_ZN5clang7CodeGen15CGOpenMPRuntime27OffloadEntriesInfoManagerTy16OffloadEntryInfoC1ENS3_24OffloadingEntryInfoKindsEj",
       cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp -nm=_ZN5clang7CodeGen15CGOpenMPRuntime27OffloadEntriesInfoManagerTy16OffloadEntryInfoC1ENS3_24OffloadingEntryInfoKindsEj")
      //</editor-fold>
      public /*explicit*/ OffloadEntryInfo(OffloadingEntryInfoKinds Kind, /*uint*/int Order) {
        // : Order(Order), Kind(Kind) 
        //START JInit
        this.Order = Order;
        this.Kind = Kind;
        //END JInit
      }

      
      //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGOpenMPRuntime::OffloadEntriesInfoManagerTy::OffloadEntryInfo::isValid">
      @Converted(kind = Converted.Kind.AUTO,
       source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.h", line = 264,
       FQN="clang::CodeGen::CGOpenMPRuntime::OffloadEntriesInfoManagerTy::OffloadEntryInfo::isValid", NM="_ZNK5clang7CodeGen15CGOpenMPRuntime27OffloadEntriesInfoManagerTy16OffloadEntryInfo7isValidEv",
       cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp -nm=_ZNK5clang7CodeGen15CGOpenMPRuntime27OffloadEntriesInfoManagerTy16OffloadEntryInfo7isValidEv")
      //</editor-fold>
      public boolean isValid() /*const*/ {
        return Order != ~0/*U*/;
      }

      //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGOpenMPRuntime::OffloadEntriesInfoManagerTy::OffloadEntryInfo::getOrder">
      @Converted(kind = Converted.Kind.AUTO,
       source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.h", line = 265,
       FQN="clang::CodeGen::CGOpenMPRuntime::OffloadEntriesInfoManagerTy::OffloadEntryInfo::getOrder", NM="_ZNK5clang7CodeGen15CGOpenMPRuntime27OffloadEntriesInfoManagerTy16OffloadEntryInfo8getOrderEv",
       cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp -nm=_ZNK5clang7CodeGen15CGOpenMPRuntime27OffloadEntriesInfoManagerTy16OffloadEntryInfo8getOrderEv")
      //</editor-fold>
      public /*uint*/int getOrder() /*const*/ {
        return Order;
      }

      //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGOpenMPRuntime::OffloadEntriesInfoManagerTy::OffloadEntryInfo::getKind">
      @Converted(kind = Converted.Kind.AUTO,
       source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.h", line = 266,
       FQN="clang::CodeGen::CGOpenMPRuntime::OffloadEntriesInfoManagerTy::OffloadEntryInfo::getKind", NM="_ZNK5clang7CodeGen15CGOpenMPRuntime27OffloadEntriesInfoManagerTy16OffloadEntryInfo7getKindEv",
       cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp -nm=_ZNK5clang7CodeGen15CGOpenMPRuntime27OffloadEntriesInfoManagerTy16OffloadEntryInfo7getKindEv")
      //</editor-fold>
      public OffloadingEntryInfoKinds getKind() /*const*/ {
        return Kind;
      }

      //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGOpenMPRuntime::OffloadEntriesInfoManagerTy::OffloadEntryInfo::classof">
      @Converted(kind = Converted.Kind.AUTO,
       source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.h", line = 267,
       FQN="clang::CodeGen::CGOpenMPRuntime::OffloadEntriesInfoManagerTy::OffloadEntryInfo::classof", NM="_ZN5clang7CodeGen15CGOpenMPRuntime27OffloadEntriesInfoManagerTy16OffloadEntryInfo7classofEPKS3_",
       cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp -nm=_ZN5clang7CodeGen15CGOpenMPRuntime27OffloadEntriesInfoManagerTy16OffloadEntryInfo7classofEPKS3_")
      //</editor-fold>
      public static boolean classof(/*const*/ OffloadEntryInfo /*P*/ Info) {
        return true;
      }

    /*protected:*/
      // \brief Order this entry was emitted.
      protected /*uint*/int Order;
      
      protected OffloadingEntryInfoKinds Kind;
      //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGOpenMPRuntime::OffloadEntriesInfoManagerTy::OffloadEntryInfo::OffloadEntryInfo">
      @Converted(kind = Converted.Kind.AUTO,
       source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.h", line = 249,
       FQN="clang::CodeGen::CGOpenMPRuntime::OffloadEntriesInfoManagerTy::OffloadEntryInfo::OffloadEntryInfo", NM="_ZN5clang7CodeGen15CGOpenMPRuntime27OffloadEntriesInfoManagerTy16OffloadEntryInfoC1EOS3_",
       cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp -nm=_ZN5clang7CodeGen15CGOpenMPRuntime27OffloadEntriesInfoManagerTy16OffloadEntryInfoC1EOS3_")
      //</editor-fold>
      public /*inline*/ OffloadEntryInfo(JD$Move _dparam, final OffloadEntryInfo /*&&*/$Prm0) {
        // : Order(static_cast<OffloadEntryInfo &&>().Order), Kind(static_cast<OffloadEntryInfo &&>().Kind) 
        //START JInit
        this.Order = $Prm0.Order;
        this.Kind = $Prm0.Kind;
        //END JInit
      }

      //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGOpenMPRuntime::OffloadEntriesInfoManagerTy::OffloadEntryInfo::operator=">
      @Converted(kind = Converted.Kind.AUTO,
       source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.h", line = 249,
       FQN="clang::CodeGen::CGOpenMPRuntime::OffloadEntriesInfoManagerTy::OffloadEntryInfo::operator=", NM="_ZN5clang7CodeGen15CGOpenMPRuntime27OffloadEntriesInfoManagerTy16OffloadEntryInfoaSERKS3_",
       cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp -nm=_ZN5clang7CodeGen15CGOpenMPRuntime27OffloadEntriesInfoManagerTy16OffloadEntryInfoaSERKS3_")
      //</editor-fold>
      public /*inline*/ OffloadEntryInfo /*&*/ $assign(final /*const*/ OffloadEntryInfo /*&*/ $Prm0) {
        this.Order = $Prm0.Order;
        this.Kind = $Prm0.Kind;
        return /*Deref*/this;
      }

      //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGOpenMPRuntime::OffloadEntriesInfoManagerTy::OffloadEntryInfo::operator=">
      @Converted(kind = Converted.Kind.AUTO,
       source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.h", line = 249,
       FQN="clang::CodeGen::CGOpenMPRuntime::OffloadEntriesInfoManagerTy::OffloadEntryInfo::operator=", NM="_ZN5clang7CodeGen15CGOpenMPRuntime27OffloadEntriesInfoManagerTy16OffloadEntryInfoaSEOS3_",
       cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp -nm=_ZN5clang7CodeGen15CGOpenMPRuntime27OffloadEntriesInfoManagerTy16OffloadEntryInfoaSEOS3_")
      //</editor-fold>
      public /*inline*/ OffloadEntryInfo /*&*/ $assignMove(final OffloadEntryInfo /*&&*/$Prm0) {
        this.Order = $Prm0.Order;
        this.Kind = $Prm0.Kind;
        return /*Deref*/this;
      }

      //////////////////////////////////////////////////////////////
      // EXTRA MEMBERS: BEGIN

      //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGOpenMPRuntime::OffloadEntriesInfoManagerTy::OffloadEntryInfo::OffloadEntryInfo">
      @Converted(kind = Converted.Kind.AUTO,
       source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.h", line = 249,
       FQN="clang::CodeGen::CGOpenMPRuntime::OffloadEntriesInfoManagerTy::OffloadEntryInfo::OffloadEntryInfo", NM="_ZN5clang7CodeGen15CGOpenMPRuntime27OffloadEntriesInfoManagerTy16OffloadEntryInfoC1ERKS3_",
       cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp -nm=_ZN5clang7CodeGen15CGOpenMPRuntime27OffloadEntriesInfoManagerTy16OffloadEntryInfoC1ERKS3_")
      //</editor-fold>
      public /*inline*/ OffloadEntryInfo(final /*const*/ OffloadEntryInfo /*&*/ $Prm0) {
        // : Order(.Order), Kind(.Kind) 
        //START JInit
        this.Order = $Prm0.Order;
        this.Kind = $Prm0.Kind;
        //END JInit
      }
      
      @Override
      public OffloadEntryInfo clone() {
        assert this.getClass() == OffloadEntryInfo.class : "Why not overridden in " + this.getClass();
        return new OffloadEntryInfo(this);
      }

      @Override
      public OffloadEntryInfo move() {
        assert this.getClass() == OffloadEntryInfo.class : "Why not overridden in " + this.getClass();
        return new OffloadEntryInfo(JD$Move.INSTANCE, this);
      }
      

      // EXTRA MEMBERS: END
      //////////////////////////////////////////////////////////////
      
      @Override public String toString() {
        return "" + "Order=" + Order // NOI18N
                  + ", Kind=" + Kind; // NOI18N
      }
    };
    
    /// \brief Return true if a there are no entries defined.
    // anonymous namespace
    //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGOpenMPRuntime::OffloadEntriesInfoManagerTy::empty">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp", line = 2687,
     FQN="clang::CodeGen::CGOpenMPRuntime::OffloadEntriesInfoManagerTy::empty", NM="_ZNK5clang7CodeGen15CGOpenMPRuntime27OffloadEntriesInfoManagerTy5emptyEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp -nm=_ZNK5clang7CodeGen15CGOpenMPRuntime27OffloadEntriesInfoManagerTy5emptyEv")
    //</editor-fold>
    public boolean empty() /*const*/ {
      // FIXME: Add other entries type when they become supported.
      return OffloadEntriesTargetRegion.empty();
    }

    /// \brief Return number of entries defined so far.
    //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGOpenMPRuntime::OffloadEntriesInfoManagerTy::size">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.h", line = 279,
     FQN="clang::CodeGen::CGOpenMPRuntime::OffloadEntriesInfoManagerTy::size", NM="_ZNK5clang7CodeGen15CGOpenMPRuntime27OffloadEntriesInfoManagerTy4sizeEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp -nm=_ZNK5clang7CodeGen15CGOpenMPRuntime27OffloadEntriesInfoManagerTy4sizeEv")
    //</editor-fold>
    public /*uint*/int size() /*const*/ {
      return OffloadingEntriesNum;
    }

    //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGOpenMPRuntime::OffloadEntriesInfoManagerTy::OffloadEntriesInfoManagerTy">
    @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.h", line = 280,
     FQN="clang::CodeGen::CGOpenMPRuntime::OffloadEntriesInfoManagerTy::OffloadEntriesInfoManagerTy", NM="_ZN5clang7CodeGen15CGOpenMPRuntime27OffloadEntriesInfoManagerTyC1ERNS0_13CodeGenModuleE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp -nm=_ZN5clang7CodeGen15CGOpenMPRuntime27OffloadEntriesInfoManagerTyC1ERNS0_13CodeGenModuleE")
    //</editor-fold>
    public OffloadEntriesInfoManagerTy(final CodeGenModule /*&*/ CGM) {
      // : CGM(CGM), OffloadingEntriesNum(0), OffloadEntriesTargetRegion() 
      //START JInit
      this./*&*/CGM=/*&*/CGM;
      this.OffloadingEntriesNum = 0;
      this.OffloadEntriesTargetRegion = new DenseMapUIntType<DenseMapUIntType<StringMap<DenseMapUIntType<OffloadEntryInfoTargetRegion>>>>(DenseMapInfoUInt.$Info(), 
              new DenseMapUIntType<StringMap<DenseMapUIntType<OffloadEntryInfoTargetRegion>>>(DenseMapInfoUInt.$Info(), 
                      new StringMap<DenseMapUIntType<OffloadEntryInfoTargetRegion>>(
                              new DenseMapUIntType<OffloadEntryInfoTargetRegion>(DenseMapInfoUInt.$Info(), 
                                      new OffloadEntryInfoTargetRegion()))));
      //END JInit
    }

    
    ///
    /// Target region entries related.
    ///
    /// \brief Target region entries info.
    //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGOpenMPRuntime::OffloadEntriesInfoManagerTy::OffloadEntryInfoTargetRegion">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.h", line = 287,
     FQN="clang::CodeGen::CGOpenMPRuntime::OffloadEntriesInfoManagerTy::OffloadEntryInfoTargetRegion", NM="_ZN5clang7CodeGen15CGOpenMPRuntime27OffloadEntriesInfoManagerTy28OffloadEntryInfoTargetRegionE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp -nm=_ZN5clang7CodeGen15CGOpenMPRuntime27OffloadEntriesInfoManagerTy28OffloadEntryInfoTargetRegionE")
    //</editor-fold>
    public static class OffloadEntryInfoTargetRegion extends /*public*/ OffloadEntryInfo {
      // \brief Address of the entity that has to be mapped for offloading.
      private Constant /*P*/ Addr;
      // \brief Address that can be used as the ID of the entry.
      private Constant /*P*/ ID;
    /*public:*/
      //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGOpenMPRuntime::OffloadEntriesInfoManagerTy::OffloadEntryInfoTargetRegion::OffloadEntryInfoTargetRegion">
      @Converted(kind = Converted.Kind.AUTO,
       source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.h", line = 294,
       FQN="clang::CodeGen::CGOpenMPRuntime::OffloadEntriesInfoManagerTy::OffloadEntryInfoTargetRegion::OffloadEntryInfoTargetRegion", NM="_ZN5clang7CodeGen15CGOpenMPRuntime27OffloadEntriesInfoManagerTy28OffloadEntryInfoTargetRegionC1Ev",
       cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp -nm=_ZN5clang7CodeGen15CGOpenMPRuntime27OffloadEntriesInfoManagerTy28OffloadEntryInfoTargetRegionC1Ev")
      //</editor-fold>
      public OffloadEntryInfoTargetRegion() {
        // : OffloadEntryInfo(OFFLOAD_ENTRY_INFO_TARGET_REGION, ~0uU), Addr(null), ID(null) 
        //START JInit
        super(OffloadingEntryInfoKinds.OFFLOAD_ENTRY_INFO_TARGET_REGION, ~0/*U*/);
        this.Addr = null;
        this.ID = null;
        //END JInit
      }

      //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGOpenMPRuntime::OffloadEntriesInfoManagerTy::OffloadEntryInfoTargetRegion::OffloadEntryInfoTargetRegion">
      @Converted(kind = Converted.Kind.AUTO,
       source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.h", line = 297,
       FQN="clang::CodeGen::CGOpenMPRuntime::OffloadEntriesInfoManagerTy::OffloadEntryInfoTargetRegion::OffloadEntryInfoTargetRegion", NM="_ZN5clang7CodeGen15CGOpenMPRuntime27OffloadEntriesInfoManagerTy28OffloadEntryInfoTargetRegionC1EjPN4llvm8ConstantES6_",
       cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp -nm=_ZN5clang7CodeGen15CGOpenMPRuntime27OffloadEntriesInfoManagerTy28OffloadEntryInfoTargetRegionC1EjPN4llvm8ConstantES6_")
      //</editor-fold>
      public /*explicit*/ OffloadEntryInfoTargetRegion(/*uint*/int Order, 
          Constant /*P*/ Addr, 
          Constant /*P*/ ID) {
        // : OffloadEntryInfo(OFFLOAD_ENTRY_INFO_TARGET_REGION, Order), Addr(Addr), ID(ID) 
        //START JInit
        super(OffloadingEntryInfoKinds.OFFLOAD_ENTRY_INFO_TARGET_REGION, Order);
        this.Addr = Addr;
        this.ID = ID;
        //END JInit
      }

      
      //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGOpenMPRuntime::OffloadEntriesInfoManagerTy::OffloadEntryInfoTargetRegion::getAddress">
      @Converted(kind = Converted.Kind.AUTO,
       source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.h", line = 303,
       FQN="clang::CodeGen::CGOpenMPRuntime::OffloadEntriesInfoManagerTy::OffloadEntryInfoTargetRegion::getAddress", NM="_ZNK5clang7CodeGen15CGOpenMPRuntime27OffloadEntriesInfoManagerTy28OffloadEntryInfoTargetRegion10getAddressEv",
       cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp -nm=_ZNK5clang7CodeGen15CGOpenMPRuntime27OffloadEntriesInfoManagerTy28OffloadEntryInfoTargetRegion10getAddressEv")
      //</editor-fold>
      public Constant /*P*/ getAddress() /*const*/ {
        return Addr;
      }

      //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGOpenMPRuntime::OffloadEntriesInfoManagerTy::OffloadEntryInfoTargetRegion::getID">
      @Converted(kind = Converted.Kind.AUTO,
       source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.h", line = 304,
       FQN="clang::CodeGen::CGOpenMPRuntime::OffloadEntriesInfoManagerTy::OffloadEntryInfoTargetRegion::getID", NM="_ZNK5clang7CodeGen15CGOpenMPRuntime27OffloadEntriesInfoManagerTy28OffloadEntryInfoTargetRegion5getIDEv",
       cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp -nm=_ZNK5clang7CodeGen15CGOpenMPRuntime27OffloadEntriesInfoManagerTy28OffloadEntryInfoTargetRegion5getIDEv")
      //</editor-fold>
      public Constant /*P*/ getID() /*const*/ {
        return ID;
      }

      //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGOpenMPRuntime::OffloadEntriesInfoManagerTy::OffloadEntryInfoTargetRegion::setAddress">
      @Converted(kind = Converted.Kind.AUTO,
       source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.h", line = 305,
       FQN="clang::CodeGen::CGOpenMPRuntime::OffloadEntriesInfoManagerTy::OffloadEntryInfoTargetRegion::setAddress", NM="_ZN5clang7CodeGen15CGOpenMPRuntime27OffloadEntriesInfoManagerTy28OffloadEntryInfoTargetRegion10setAddressEPN4llvm8ConstantE",
       cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp -nm=_ZN5clang7CodeGen15CGOpenMPRuntime27OffloadEntriesInfoManagerTy28OffloadEntryInfoTargetRegion10setAddressEPN4llvm8ConstantE")
      //</editor-fold>
      public void setAddress(Constant /*P*/ V) {
        assert (!(Addr != null)) : "Address as been set before!";
        Addr = V;
      }

      //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGOpenMPRuntime::OffloadEntriesInfoManagerTy::OffloadEntryInfoTargetRegion::setID">
      @Converted(kind = Converted.Kind.AUTO,
       source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.h", line = 309,
       FQN="clang::CodeGen::CGOpenMPRuntime::OffloadEntriesInfoManagerTy::OffloadEntryInfoTargetRegion::setID", NM="_ZN5clang7CodeGen15CGOpenMPRuntime27OffloadEntriesInfoManagerTy28OffloadEntryInfoTargetRegion5setIDEPN4llvm8ConstantE",
       cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp -nm=_ZN5clang7CodeGen15CGOpenMPRuntime27OffloadEntriesInfoManagerTy28OffloadEntryInfoTargetRegion5setIDEPN4llvm8ConstantE")
      //</editor-fold>
      public void setID(Constant /*P*/ V) {
        assert (!(ID != null)) : "ID as been set before!";
        ID = V;
      }

      //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGOpenMPRuntime::OffloadEntriesInfoManagerTy::OffloadEntryInfoTargetRegion::classof">
      @Converted(kind = Converted.Kind.AUTO,
       source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.h", line = 313,
       FQN="clang::CodeGen::CGOpenMPRuntime::OffloadEntriesInfoManagerTy::OffloadEntryInfoTargetRegion::classof", NM="_ZN5clang7CodeGen15CGOpenMPRuntime27OffloadEntriesInfoManagerTy28OffloadEntryInfoTargetRegion7classofEPKNS2_16OffloadEntryInfoE",
       cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp -nm=_ZN5clang7CodeGen15CGOpenMPRuntime27OffloadEntriesInfoManagerTy28OffloadEntryInfoTargetRegion7classofEPKNS2_16OffloadEntryInfoE")
      //</editor-fold>
      public static boolean classof(/*const*/ OffloadEntryInfo /*P*/ Info) {
        return Info.getKind() == OffloadingEntryInfoKinds.OFFLOAD_ENTRY_INFO_TARGET_REGION;
      }

      //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGOpenMPRuntime::OffloadEntriesInfoManagerTy::OffloadEntryInfoTargetRegion::OffloadEntryInfoTargetRegion">
      @Converted(kind = Converted.Kind.AUTO,
       source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.h", line = 287,
       FQN="clang::CodeGen::CGOpenMPRuntime::OffloadEntriesInfoManagerTy::OffloadEntryInfoTargetRegion::OffloadEntryInfoTargetRegion", NM="_ZN5clang7CodeGen15CGOpenMPRuntime27OffloadEntriesInfoManagerTy28OffloadEntryInfoTargetRegionC1EOS3_",
       cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp -nm=_ZN5clang7CodeGen15CGOpenMPRuntime27OffloadEntriesInfoManagerTy28OffloadEntryInfoTargetRegionC1EOS3_")
      //</editor-fold>
      public /*inline*/ OffloadEntryInfoTargetRegion(JD$Move _dparam, final OffloadEntryInfoTargetRegion /*&&*/$Prm0) {
        // : OffloadEntryInfo(static_cast<OffloadEntryInfoTargetRegion &&>()), Addr(static_cast<OffloadEntryInfoTargetRegion &&>().Addr), ID(static_cast<OffloadEntryInfoTargetRegion &&>().ID) 
        //START JInit
        super(JD$Move.INSTANCE, $Prm0);
        this.Addr = $Prm0.Addr;
        this.ID = $Prm0.ID;
        //END JInit
      }

      //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGOpenMPRuntime::OffloadEntriesInfoManagerTy::OffloadEntryInfoTargetRegion::operator=">
      @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
       source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.h", line = 287,
       FQN="clang::CodeGen::CGOpenMPRuntime::OffloadEntriesInfoManagerTy::OffloadEntryInfoTargetRegion::operator=", NM="_ZN5clang7CodeGen15CGOpenMPRuntime27OffloadEntriesInfoManagerTy28OffloadEntryInfoTargetRegionaSERKS3_",
       cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp -nm=_ZN5clang7CodeGen15CGOpenMPRuntime27OffloadEntriesInfoManagerTy28OffloadEntryInfoTargetRegionaSERKS3_")
      //</editor-fold>
      public /*inline*/ OffloadEntryInfoTargetRegion /*&*/ $assign(final /*const*/ OffloadEntryInfo /*&*/ _$Prm0) {
        /*J:ToBase*/super.$assign(_$Prm0);
        OffloadEntryInfoTargetRegion $Prm0 = (OffloadEntryInfoTargetRegion)_$Prm0;
        this.Addr = $Prm0.Addr;
        this.ID = $Prm0.ID;
        return /*Deref*/this;
      }

      //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGOpenMPRuntime::OffloadEntriesInfoManagerTy::OffloadEntryInfoTargetRegion::operator=">
      @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
       source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.h", line = 287,
       FQN="clang::CodeGen::CGOpenMPRuntime::OffloadEntriesInfoManagerTy::OffloadEntryInfoTargetRegion::operator=", NM="_ZN5clang7CodeGen15CGOpenMPRuntime27OffloadEntriesInfoManagerTy28OffloadEntryInfoTargetRegionaSEOS3_",
       cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp -nm=_ZN5clang7CodeGen15CGOpenMPRuntime27OffloadEntriesInfoManagerTy28OffloadEntryInfoTargetRegionaSEOS3_")
      //</editor-fold>
      public /*inline*/ OffloadEntryInfoTargetRegion /*&*/ $assignMove(final OffloadEntryInfo /*&&*/_$Prm0) {
        /*J:ToBase*/super.$assignMove(_$Prm0);
        OffloadEntryInfoTargetRegion $Prm0 = (OffloadEntryInfoTargetRegion)_$Prm0;
        this.Addr = $Prm0.Addr;
        this.ID = $Prm0.ID;
        return /*Deref*/this;
      }

      //////////////////////////////////////////////////////////////
      // EXTRA MEMBERS: BEGIN
      
      //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGOpenMPRuntime::OffloadEntriesInfoManagerTy::OffloadEntryInfoTargetRegion::OffloadEntryInfoTargetRegion">
      @Converted(kind = Converted.Kind.AUTO,
       source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.h", line = 287,
       FQN="clang::CodeGen::CGOpenMPRuntime::OffloadEntriesInfoManagerTy::OffloadEntryInfoTargetRegion::OffloadEntryInfoTargetRegion", NM="_ZN5clang7CodeGen15CGOpenMPRuntime27OffloadEntriesInfoManagerTy28OffloadEntryInfoTargetRegionC1ERKS3_",
       cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp -nm=_ZN5clang7CodeGen15CGOpenMPRuntime27OffloadEntriesInfoManagerTy28OffloadEntryInfoTargetRegionC1ERKS3_")
      //</editor-fold>
      public /*inline*/ OffloadEntryInfoTargetRegion(final /*const*/ OffloadEntryInfoTargetRegion /*&*/ $Prm0) {
        // : OffloadEntryInfo(), Addr(.Addr), ID(.ID) 
        //START JInit
        super($Prm0);
        this.Addr = $Prm0.Addr;
        this.ID = $Prm0.ID;
        //END JInit
      }
      
      @Override
      public OffloadEntryInfoTargetRegion clone() {
        assert this.getClass() == OffloadEntryInfoTargetRegion.class : "Why not overridden in " + this.getClass();
        return new OffloadEntryInfoTargetRegion(this);
      }

      @Override
      public OffloadEntryInfoTargetRegion move() {
        assert this.getClass() == OffloadEntryInfoTargetRegion.class : "Why not overridden in " + this.getClass();
        return new OffloadEntryInfoTargetRegion(JD$Move.INSTANCE, this);
      }
      
      
      // EXTRA MEMBERS: END
      //////////////////////////////////////////////////////////////
      
      @Override public String toString() {
        return "" + "Addr=" + Addr // NOI18N
                  + ", ID=" + ID // NOI18N
                  + super.toString(); // NOI18N
      }
    };
    /// \brief Initialize target region entry.
    
    /// \brief Initialize target region entry.
    //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGOpenMPRuntime::OffloadEntriesInfoManagerTy::initializeTargetRegionEntryInfo">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp", line = 2693,
     FQN="clang::CodeGen::CGOpenMPRuntime::OffloadEntriesInfoManagerTy::initializeTargetRegionEntryInfo", NM="_ZN5clang7CodeGen15CGOpenMPRuntime27OffloadEntriesInfoManagerTy31initializeTargetRegionEntryInfoEjjN4llvm9StringRefEjj",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp -nm=_ZN5clang7CodeGen15CGOpenMPRuntime27OffloadEntriesInfoManagerTy31initializeTargetRegionEntryInfoEjjN4llvm9StringRefEjj")
    //</editor-fold>
    public void initializeTargetRegionEntryInfo(/*uint*/int DeviceID, /*uint*/int FileID, 
                                   StringRef ParentName, /*uint*/int LineNum, 
                                   /*uint*/int Order) {
      assert (CGM.getLangOpts().OpenMPIsDevice) : "Initialization of entries is only required for the device code generation.";
      OffloadEntriesTargetRegion.$at_T1$C$R(DeviceID).$at_T1$C$R(FileID).$at(/*NO_COPY*/ParentName).$at_T1$C$R(LineNum).$assignMove(
          new OffloadEntryInfoTargetRegion(Order, /*Addr=*/ (Constant /*P*/ )null, /*ID=*/ (Constant /*P*/ )null)
      );
      ++OffloadingEntriesNum;
    }

    /// \brief Register target region entry.
    //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGOpenMPRuntime::OffloadEntriesInfoManagerTy::registerTargetRegionEntryInfo">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp", line = 2705,
     FQN="clang::CodeGen::CGOpenMPRuntime::OffloadEntriesInfoManagerTy::registerTargetRegionEntryInfo", NM="_ZN5clang7CodeGen15CGOpenMPRuntime27OffloadEntriesInfoManagerTy29registerTargetRegionEntryInfoEjjN4llvm9StringRefEjPNS3_8ConstantES6_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp -nm=_ZN5clang7CodeGen15CGOpenMPRuntime27OffloadEntriesInfoManagerTy29registerTargetRegionEntryInfoEjjN4llvm9StringRefEjPNS3_8ConstantES6_")
    //</editor-fold>
    public void registerTargetRegionEntryInfo(/*uint*/int DeviceID, /*uint*/int FileID, 
                                 StringRef ParentName, /*uint*/int LineNum, 
                                 Constant /*P*/ Addr, Constant /*P*/ ID) {
      // If we are emitting code for a target, the entry is already initialized,
      // only has to be registered.
      if (CGM.getLangOpts().OpenMPIsDevice) {
        assert (hasTargetRegionEntryInfo(DeviceID, FileID, new StringRef(ParentName), LineNum)) : "Entry must exist.";
        final OffloadEntryInfoTargetRegion /*&*/ Entry = OffloadEntriesTargetRegion.$at_T1$C$R(DeviceID).$at_T1$C$R(FileID).$at(/*NO_COPY*/ParentName).$at_T1$C$R(LineNum);
        assert (Entry.isValid()) : "Entry not initialized!";
        Entry.setAddress(Addr);
        Entry.setID(ID);
        return;
      } else {
        OffloadEntryInfoTargetRegion Entry/*J*/= new OffloadEntryInfoTargetRegion(OffloadingEntriesNum++, Addr, ID);
        OffloadEntriesTargetRegion.$at_T1$C$R(DeviceID).$at_T1$C$R(FileID).$at(/*NO_COPY*/ParentName).$at_T1$C$R(LineNum).$assign(Entry);
      }
    }

    /// \brief Return true if a target region entry with the provided
    /// information exists.
    //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGOpenMPRuntime::OffloadEntriesInfoManagerTy::hasTargetRegionEntryInfo">
    @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp", line = 2726,
     FQN="clang::CodeGen::CGOpenMPRuntime::OffloadEntriesInfoManagerTy::hasTargetRegionEntryInfo", NM="_ZNK5clang7CodeGen15CGOpenMPRuntime27OffloadEntriesInfoManagerTy24hasTargetRegionEntryInfoEjjN4llvm9StringRefEj",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp -nm=_ZNK5clang7CodeGen15CGOpenMPRuntime27OffloadEntriesInfoManagerTy24hasTargetRegionEntryInfoEjjN4llvm9StringRefEj")
    //</editor-fold>
    public boolean hasTargetRegionEntryInfo(/*uint*/int DeviceID, /*uint*/int FileID, StringRef ParentName, 
                            /*uint*/int LineNum) /*const*/ {
      DenseMapIteratorUIntType<DenseMapUIntType<StringMap<DenseMapUIntType<OffloadEntryInfoTargetRegion>>>> PerDevice = OffloadEntriesTargetRegion.find$Const(DeviceID);
      if (PerDevice.$eq(OffloadEntriesTargetRegion.end$Const())) {
        return false;
      }
      DenseMapIteratorUIntType<StringMap<DenseMapUIntType<OffloadEntryInfoTargetRegion>>> PerFile = PerDevice.$arrow().second.find$Const(FileID);
      if (PerFile.$eq(PerDevice.$arrow().second.end$Const())) {
        return false;
      }
      StringMapIterator<DenseMapUIntType<OffloadEntryInfoTargetRegion>> PerParentName = PerFile.$arrow().second.find$Const(/*NO_COPY*/ParentName);
      if (PerParentName.$eq(PerFile.$arrow().second.end$Const())) {
        return false;
      }
      DenseMapIteratorUIntType<OffloadEntryInfoTargetRegion> PerLine = PerParentName.$arrow().second.find$Const(LineNum);
      if (PerLine.$eq(PerParentName.$arrow().second.end$Const())) {
        return false;
      }
      // Fail if this entry is already registered.
      if ((PerLine.$arrow().second.getAddress() != null) || (PerLine.$arrow().second.getID() != null)) {
        return false;
      }
      return true;
    }

    /// brief Applies action \a Action on all registered entries.
    // JAVA: typedef llvm::function_ref<void (unsigned int, unsigned int, StringRef, unsigned int, OffloadEntryInfoTargetRegion &)> OffloadTargetRegionEntryInfoActTy
//    public final class OffloadTargetRegionEntryInfoActTy extends OffloadTargetRegionEntryInfoActTy{ };
    //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGOpenMPRuntime::OffloadEntriesInfoManagerTy::actOnTargetRegionEntriesInfo">
    @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp", line = 2747,
     FQN="clang::CodeGen::CGOpenMPRuntime::OffloadEntriesInfoManagerTy::actOnTargetRegionEntriesInfo", NM="_ZN5clang7CodeGen15CGOpenMPRuntime27OffloadEntriesInfoManagerTy28actOnTargetRegionEntriesInfoERKN4llvm12function_refIFvjjNS3_9StringRefEjRNS2_28OffloadEntryInfoTargetRegionEEEE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp -nm=_ZN5clang7CodeGen15CGOpenMPRuntime27OffloadEntriesInfoManagerTy28actOnTargetRegionEntriesInfoERKN4llvm12function_refIFvjjNS3_9StringRefEjRNS2_28OffloadEntryInfoTargetRegionEEEE")
    //</editor-fold>
    public void actOnTargetRegionEntriesInfo(final /*const*/OffloadTargetRegionEntryInfoActTy/*&*/ Action) {
      // Scan all target region entries and perform the provided action.
      for (final pairUIntType<DenseMapUIntType<StringMap<DenseMapUIntType<OffloadEntryInfoTargetRegion>>>> D : OffloadEntriesTargetRegion) {
        for (final pairUIntType<StringMap<DenseMapUIntType<OffloadEntryInfoTargetRegion>>> F : D.second)  {
          for (final StringMapEntry<DenseMapUIntType<OffloadEntryInfoTargetRegion>> P : F.second)  {
            for (final pairUIntType<OffloadEntryInfoTargetRegion> L : P.second) {
              Action.$call(D.first, F.first, P.first(), L.first, L.second);
            }
          }
        }
      }
    }

  /*private:*/
    // Storage for target region entries kind. The storage is to be indexed by
    // file ID, device ID, parent function name and line number.
    // JAVA: typedef llvm::DenseMap<unsigned int, OffloadEntryInfoTargetRegion> OffloadEntriesTargetRegionPerLine
//    public final class OffloadEntriesTargetRegionPerLine extends DenseMapUIntType<OffloadEntryInfoTargetRegion>{ };
    // JAVA: typedef llvm::StringMap<OffloadEntriesTargetRegionPerLine> OffloadEntriesTargetRegionPerParentName
//    public final class OffloadEntriesTargetRegionPerParentName extends StringMap<DenseMapUIntType<OffloadEntryInfoTargetRegion>>{ };
    // JAVA: typedef llvm::DenseMap<unsigned int, OffloadEntriesTargetRegionPerParentName> OffloadEntriesTargetRegionPerFile
//    public final class OffloadEntriesTargetRegionPerFile extends DenseMapUIntType<StringMap<DenseMapUIntType<OffloadEntryInfoTargetRegion>>>{ };
    // JAVA: typedef llvm::DenseMap<unsigned int, OffloadEntriesTargetRegionPerFile> OffloadEntriesTargetRegionPerDevice
//    public final class OffloadEntriesTargetRegionPerDevice extends DenseMapUIntType<DenseMapUIntType<StringMap<DenseMapUIntType<OffloadEntryInfoTargetRegion>>>>{ };
    // JAVA: typedef OffloadEntriesTargetRegionPerDevice OffloadEntriesTargetRegionTy
//    public final class OffloadEntriesTargetRegionTy extends DenseMapUIntType<DenseMapUIntType<StringMap<DenseMapUIntType<OffloadEntryInfoTargetRegion>>>>{ };
    private DenseMapUIntType<DenseMapUIntType<StringMap<DenseMapUIntType<OffloadEntryInfoTargetRegion>>>> OffloadEntriesTargetRegion;
    //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGOpenMPRuntime::OffloadEntriesInfoManagerTy::~OffloadEntriesInfoManagerTy">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.h", line = 241,
     FQN="clang::CodeGen::CGOpenMPRuntime::OffloadEntriesInfoManagerTy::~OffloadEntriesInfoManagerTy", NM="_ZN5clang7CodeGen15CGOpenMPRuntime27OffloadEntriesInfoManagerTyD0Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp -nm=_ZN5clang7CodeGen15CGOpenMPRuntime27OffloadEntriesInfoManagerTyD0Ev")
    //</editor-fold>
    public /*inline*/ void $destroy() {
      //START JDestroy
      OffloadEntriesTargetRegion.$destroy();
      //END JDestroy
    }

    
    @Override public String toString() {
      return "" + "CGM=" + CGM // NOI18N
                + ", OffloadingEntriesNum=" + OffloadingEntriesNum // NOI18N
                + ", OffloadEntriesTargetRegion=" + OffloadEntriesTargetRegion; // NOI18N
    }
  };
  private OffloadEntriesInfoManagerTy OffloadEntriesInfoManager;
  
  /// \brief Creates and registers offloading binary descriptor for the current
  /// compilation unit. The function that does the registration is returned.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGOpenMPRuntime::createOffloadingBinaryDescriptorRegistration">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp", line = 2781,
   FQN="clang::CodeGen::CGOpenMPRuntime::createOffloadingBinaryDescriptorRegistration", NM="_ZN5clang7CodeGen15CGOpenMPRuntime44createOffloadingBinaryDescriptorRegistrationEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp -nm=_ZN5clang7CodeGen15CGOpenMPRuntime44createOffloadingBinaryDescriptorRegistrationEv")
  //</editor-fold>
  private Function /*P*/ createOffloadingBinaryDescriptorRegistration() {
    ImplicitParamDecl RegUnregVar = null;
    try {
      
      // If we don't have entries or if we are emitting code for the device, we
      // don't need to do anything.
      if (CGM.getLangOpts().OpenMPIsDevice || OffloadEntriesInfoManager.empty()) {
        return null;
      }
      
      final org.llvm.ir.Module /*&*/ M = CGM.getModule();
      final ASTContext /*&*/ C = CGM.getContext();
      
      // Get list of devices we care about
      final /*constconst*/vector<Triple> /*&*/ Devices = CGM.getLangOpts().OMPTargetTriples;
      
      // We should be creating an offloading descriptor only if there are devices
      // specified.
      assert (!Devices.empty()) : "No OpenMP offloading devices??";
      
      // Create the external variables that will point to the begin and end of the
      // host entries section. These will be defined by the linker.
      org.llvm.ir.Type /*P*/ OffloadEntryTy = CGM.getTypes().ConvertTypeForMem(getTgtOffloadEntryQTy());
      GlobalVariable /*P*/ HostEntriesBegin = /*NEW_EXPR [GlobalVariable::new]*/GlobalVariable.$new_GlobalVariable((type$ptr<?> New$Mem)->{
          return new GlobalVariable(M, OffloadEntryTy, /*isConstant=*/ true, 
                  GlobalValue.LinkageTypes.ExternalLinkage, /*Initializer=*/ (Constant /*P*/ )null, 
                  new Twine(/*KEEP_STR*/".omp_offloading.entries_begin"));
       });
      GlobalVariable /*P*/ HostEntriesEnd = /*NEW_EXPR [GlobalVariable::new]*/GlobalVariable.$new_GlobalVariable((type$ptr<?> New$Mem)->{
          return new GlobalVariable(M, OffloadEntryTy, /*isConstant=*/ true, 
                  GlobalValue.LinkageTypes.ExternalLinkage, /*Initializer=*/ (Constant /*P*/ )null, 
                  new Twine(/*KEEP_STR*/".omp_offloading.entries_end"));
       });
      
      // Create all device images
      SmallVector<Constant /*P*/ > DeviceImagesEntires/*J*/= new SmallVector<Constant /*P*/ >(4, (Constant /*P*/ )null);
      StructType /*P*/ DeviceImageTy = cast_StructType(CGM.getTypes().ConvertTypeForMem(getTgtDeviceImageQTy()));
      
      for (/*uint*/int i = 0; $less_uint(i, Devices.size()); ++i) {
        StringRef T = new StringRef(Devices.$at$Const(i).getTriple());
        GlobalVariable /*P*/ ImgBegin = /*NEW_EXPR [GlobalVariable::new]*/GlobalVariable.$new_GlobalVariable((type$ptr<?> New$Mem)->{
            return new GlobalVariable(M, CGM.Int8Ty, /*isConstant=*/ true, GlobalValue.LinkageTypes.ExternalLinkage, 
                    /*Initializer=*/ (Constant /*P*/ )null, 
                    $add_Twine$C(new Twine(/*KEEP_STR*/".omp_offloading.img_start."), new Twine(T)));
         });
        GlobalVariable /*P*/ ImgEnd = /*NEW_EXPR [GlobalVariable::new]*/GlobalVariable.$new_GlobalVariable((type$ptr<?> New$Mem)->{
            return new GlobalVariable(M, CGM.Int8Ty, /*isConstant=*/ true, GlobalValue.LinkageTypes.ExternalLinkage, 
                    /*Initializer=*/ (Constant /*P*/ )null, $add_Twine$C(new Twine(/*KEEP_STR*/".omp_offloading.img_end."), new Twine(T)));
         });
        
        Constant /*P*/ Dev = ConstantStruct.get(DeviceImageTy, ImgBegin, ImgEnd, 
            HostEntriesBegin, HostEntriesEnd, null);
        DeviceImagesEntires.push_back(Dev);
      }
      
      // Create device images global array.
      org.llvm.ir.ArrayType /*P*/ DeviceImagesInitTy = org.llvm.ir.ArrayType.get(DeviceImageTy, $uint2ulong(DeviceImagesEntires.size()));
      Constant /*P*/ DeviceImagesInit = ConstantArray.get(DeviceImagesInitTy, new ArrayRef<Constant /*P*/ >(DeviceImagesEntires, true));
      
      GlobalVariable /*P*/ DeviceImages = /*NEW_EXPR [GlobalVariable::new]*/GlobalVariable.$new_GlobalVariable((type$ptr<?> New$Mem)->{
          return new GlobalVariable(M, DeviceImagesInitTy, /*isConstant=*/ true, 
                  GlobalValue.LinkageTypes.InternalLinkage, DeviceImagesInit, 
                  new Twine(/*KEEP_STR*/".omp_offloading.device_images"));
       });
      DeviceImages.setUnnamedAddr(GlobalValue.UnnamedAddr.Global);
      
      // This is a Zero array to be used in the creation of the constant expressions
      Constant /*P*/ Index[/*2*/] = new Constant /*P*/  [/*2*/] {
        Constant.getNullValue(CGM.Int32Ty), 
        Constant.getNullValue(CGM.Int32Ty)};
      
      // Create the target region descriptor.
      StructType /*P*/ BinaryDescriptorTy = cast_StructType(CGM.getTypes().ConvertTypeForMem(getTgtBinaryDescriptorQTy()));
      Constant /*P*/ TargetRegionsDescriptorInit = ConstantStruct.get(BinaryDescriptorTy, ConstantInt.get(CGM.Int32Ty, $uint2ulong(Devices.size())), 
          ConstantExpr.getGetElementPtr_Type$P_Constant$P_ArrayRef$Constant$P_bool_Type$P(DeviceImagesInitTy, DeviceImages, 
              new ArrayRef<Constant /*P*/ >(Index, true)), 
          HostEntriesBegin, HostEntriesEnd, null);
      
      GlobalVariable /*P*/ Desc = /*NEW_EXPR [GlobalVariable::new]*/GlobalVariable.$new_GlobalVariable((type$ptr<?> New$Mem)->{
          return new GlobalVariable(M, BinaryDescriptorTy, /*isConstant=*/ true, 
                  GlobalValue.LinkageTypes.InternalLinkage, TargetRegionsDescriptorInit, 
                  new Twine(/*KEEP_STR*/".omp_offloading.descriptor"));
       });
      
      // Emit code to register or unregister the descriptor at execution
      // startup or closing, respectively.
      
      // Create a variable to drive the registration and unregistration of the
      // descriptor, so we can reuse the logic that emits Ctors and Dtors.
      IdentifierInfo /*P*/ IdentInfo = $AddrOf(C.Idents.get(new StringRef(/*KEEP_STR*/".omp_offloading.reg_unreg_var")));
      RegUnregVar/*J*/= new ImplicitParamDecl(C, C.getTranslationUnitDecl(), new SourceLocation(), 
          IdentInfo, C.CharTy.$QualType());
      CodeGenFunctionPrePostActionTy2Void callable1 = /*[&, this, &Desc]*/ (final CodeGenFunction /*&*/ CGF, final PrePostActionTy /*&*/ $Prm1) -> {
                    CGF.EmitCallOrInvoke(createRuntimeFunction(OpenMPRTLFunction.OMPRTL__tgt_unregister_lib.getValue()), 
                        new ArrayRef<Value /*P*/ >(Desc, true));
                  };
      Function /*P*/ UnRegFn = CGOpenMPRuntimeStatics.createOffloadingBinaryDescriptorFunction(CGM, new StringRef(/*KEEP_STR*/".omp_offloading.descriptor_unreg"), 
          new RegionCodeGenTy(JD$NotSameRegionCodeGenTy.INSTANCE, callable1));
      ImplicitParamDecl RegUnregVar_final = RegUnregVar;
      CodeGenFunctionPrePostActionTy2Void callable2 = /*[&, this, &Desc, &RegUnregVar, &UnRegFn]*/ (final CodeGenFunction /*&*/ CGF, final PrePostActionTy /*&*/ $Prm1) -> {
                    CGF.EmitCallOrInvoke(createRuntimeFunction(OpenMPRTLFunction.OMPRTL__tgt_register_lib.getValue()), 
                        new ArrayRef<Value /*P*/ >(Desc, true));
                    CGM.getCXXABI().registerGlobalDtor(CGF, RegUnregVar_final, UnRegFn, Desc);
                  };
      Function /*P*/ RegFn = CGOpenMPRuntimeStatics.createOffloadingBinaryDescriptorFunction(CGM, new StringRef(/*KEEP_STR*/".omp_offloading.descriptor_reg"), 
          new RegionCodeGenTy(JD$NotSameRegionCodeGenTy.INSTANCE, callable2));
      return RegFn;
    } finally {
      if (RegUnregVar != null) { RegUnregVar.$destroy(); }
    }
  }

  
  /// \brief Creates all the offload entries in the current compilation unit
  /// along with the associated metadata.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGOpenMPRuntime::createOffloadEntriesAndInfoMetadata">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp", line = 2924,
   FQN="clang::CodeGen::CGOpenMPRuntime::createOffloadEntriesAndInfoMetadata", NM="_ZN5clang7CodeGen15CGOpenMPRuntime35createOffloadEntriesAndInfoMetadataEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp -nm=_ZN5clang7CodeGen15CGOpenMPRuntime35createOffloadEntriesAndInfoMetadataEv")
  //</editor-fold>
  private void createOffloadEntriesAndInfoMetadata() {
    // Emit the offloading entries and metadata so that the device codegen side
    // can
    // easily figure out what to emit. The produced metadata looks like this:
    //
    // !omp_offload.info = !{!1, ...}
    //
    // Right now we only generate metadata for function that contain target
    // regions.
    
    // If we do not have entries, we dont need to do anything.
    if (OffloadEntriesInfoManager.empty()) {
      return;
    }
    
    final org.llvm.ir.Module /*&*/ M = CGM.getModule();
    final LLVMContext /*&*/ C = M.getContext();
    SmallVector<OffloadEntriesInfoManagerTy.OffloadEntryInfo /*P*/ > OrderedEntries/*J*/= new SmallVector<OffloadEntriesInfoManagerTy.OffloadEntryInfo /*P*/ >(JD$UInt_T$C$R.INSTANCE, 16, OffloadEntriesInfoManager.size(), (OffloadEntriesInfoManagerTy.OffloadEntryInfo /*P*/ )null);
    
    // Create the offloading info metadata node.
    NamedMDNode /*P*/ MD = M.getOrInsertNamedMetadata(new StringRef(/*KEEP_STR*/"omp_offload.info"));
    
    // Auxiliar methods to create metadata values and strings.
    UInt2ConstantAsMetadata getMDInt = /*[&, &C]*/ (/*uint*/int v) -> {
          return ConstantAsMetadata.get(ConstantInt.get(org.llvm.ir.Type.getInt32Ty(C), $uint2ulong(v)));
        };
    
    StringRef2MDString getMDString = /*[&, &C]*/ (StringRef v) -> {
          return MDString.get(C, new StringRef(v));
        };
    
    // Create function that emits metadata for each target region entry;
    final OffloadTargetRegionEntryInfoActTy TargetRegionMetadataEmitter = /*[&, &getMDInt, &getMDString, &OrderedEntries, &MD, &C]*/ (/*uint*/int DeviceID, /*uint*/int FileID, StringRef ParentName, /*uint*/int Line, final OffloadEntriesInfoManagerTy.OffloadEntryInfoTargetRegion /*&*/ E) -> {
          SmallVector<Metadata /*P*/ > Ops/*J*/= new SmallVector<Metadata /*P*/ >(32, (Metadata /*P*/ )null);
          // Generate metadata for target regions. Each entry of this metadata
          // contains:
          // - Entry 0 -> Kind of this type of metadata (0).
          // - Entry 1 -> Device ID of the file where the entry was identified.
          // - Entry 2 -> File ID of the file where the entry was identified.
          // - Entry 3 -> Mangled name of the function where the entry was identified.
          // - Entry 4 -> Line in the file where the entry was identified.
          // - Entry 5 -> Order the entry was created.
          // The first element of the metadata node is the kind.
          Ops.push_back(getMDInt.$call(E.getKind().getValue()));
          Ops.push_back(getMDInt.$call(DeviceID));
          Ops.push_back(getMDInt.$call(FileID));
          Ops.push_back(getMDString.$call(new StringRef(ParentName)));
          Ops.push_back(getMDInt.$call(Line));
          Ops.push_back(getMDInt.$call(E.getOrder()));
          
          // Save this entry in the right position of the ordered entries array.
          OrderedEntries.$set(E.getOrder(), $AddrOf(E));
          
          // Add metadata to the named metadata node.
          MD.addOperand(MDNode.get(C, new ArrayRef<Metadata /*P*/ >(Ops, true)));
        };
    
    OffloadEntriesInfoManager.actOnTargetRegionEntriesInfo(/*FuncArg*/TargetRegionMetadataEmitter);
    
    for (CGOpenMPRuntime.OffloadEntriesInfoManagerTy.OffloadEntryInfo /*P*/ E : OrderedEntries) {
      assert ((E != null)) : "All ordered entries must exist!";
      {
        CGOpenMPRuntime.OffloadEntriesInfoManagerTy.OffloadEntryInfoTargetRegion /*P*/ CE = (OffloadEntriesInfoManagerTy.OffloadEntryInfoTargetRegion)E;//dyn_cast_OffloadEntriesInfoManagerTy.OffloadEntryInfoTargetRegion(E);
        if ((CE != null)) {
          assert ((CE.getID() != null) && (CE.getAddress() != null)) : "Entry ID and Addr are invalid!";
          createOffloadEntry(CE.getID(), CE.getAddress(), /*Size=*/ $int2ulong(0));
        } else {
          throw new llvm_unreachable("Unsupported entry kind.");
        }
      }
    }
  }

  
  /// \brief Loads all the offload entries information from the host IR
  /// metadata.
  
  /// \brief Loads all the offload entries information from the host IR
  /// metadata.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGOpenMPRuntime::loadOffloadInfoMetadata">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp", line = 3000,
   FQN="clang::CodeGen::CGOpenMPRuntime::loadOffloadInfoMetadata", NM="_ZN5clang7CodeGen15CGOpenMPRuntime23loadOffloadInfoMetadataEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp -nm=_ZN5clang7CodeGen15CGOpenMPRuntime23loadOffloadInfoMetadataEv")
  //</editor-fold>
  private void loadOffloadInfoMetadata() {
    ErrorOr<unique_ptr<MemoryBuffer> > Buf = null;
    LLVMContext C = null;
    ErrorOr<unique_ptr<org.llvm.ir.Module> > ME = null;
    try {
      // If we are in target mode, load the metadata from the host IR. This code has
      // to match the metadaata creation in createOffloadEntriesAndInfoMetadata().
      if (!CGM.getLangOpts().OpenMPIsDevice) {
        return;
      }
      if (CGM.getLangOpts().OMPHostIRFile.empty()) {
        return;
      }
      
      Buf = MemoryBuffer.getFile(new Twine(CGM.getLangOpts().OMPHostIRFile));
      if (Buf.getError().$bool()) {
        return;
      }
      
      C/*J*/= new LLVMContext();
      ME = parseBitcodeFile(Buf.get().$arrow().getMemBufferRef(), C);
      if (ME.getError().$bool()) {
        return;
      }
      
      NamedMDNode /*P*/ MD = ME.get().$arrow().getNamedMetadata(new Twine(/*KEEP_STR*/"omp_offload.info"));
      if (!(MD != null)) {
        return;
      }
      
      for (MDNode /*P*/ I : MD.operands()) {
        MDNode /*P*/ MN = cast_MDNode(I);
        
        UInt2UInt64 getMDInt = /*[&, &MN]*/ (/*uint*/int Idx) -> {
              ConstantAsMetadata /*P*/ V = cast_ConstantAsMetadata(MN.getOperand(Idx).$star());
              return cast_ConstantInt(V.getValue()).getZExtValue();
            };
        
        UInt2StringRef getMDString = /*[&, &MN]*/ (/*uint*/int Idx) -> {
              MDString /*P*/ V = cast_MDString(MN.getOperand(Idx));
              return V.getString();
            };
        switch (CGOpenMPRuntime.OffloadEntriesInfoManagerTy.OffloadEntryInfo.OffloadingEntryInfoKinds.valueOf((int)getMDInt.$call(0))) {
         default:
          throw new llvm_unreachable("Unexpected metadata!");
  //        break;
         case OFFLOAD_ENTRY_INFO_TARGET_REGION:
          OffloadEntriesInfoManager.initializeTargetRegionEntryInfo(/*DeviceID=*/ $ulong2uint(getMDInt.$call(1)), /*FileID=*/ $ulong2uint(getMDInt.$call(2)), 
              /*ParentName=*/ getMDString.$call(3), /*Line=*/ $ulong2uint(getMDInt.$call(4)), 
              /*Order=*/ $ulong2uint(getMDInt.$call(5)));
          break;
        }
      }
    } finally {
      if (ME != null) { ME.$destroy(); }
      if (C != null) { C.$destroy(); }
      if (Buf != null) { Buf.$destroy(); }
    }
  }

  
  /// \brief Returns __tgt_offload_entry type.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGOpenMPRuntime::getTgtOffloadEntryQTy">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp", line = 3076,
   FQN="clang::CodeGen::CGOpenMPRuntime::getTgtOffloadEntryQTy", NM="_ZN5clang7CodeGen15CGOpenMPRuntime21getTgtOffloadEntryQTyEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp -nm=_ZN5clang7CodeGen15CGOpenMPRuntime21getTgtOffloadEntryQTyEv")
  //</editor-fold>
  private QualType getTgtOffloadEntryQTy() {
    
    // Make sure the type of the entry is already created. This is the type we
    // have to create:
    // struct __tgt_offload_entry{
    //   void      *addr;       // Pointer to the offload entry info.
    //                          // (function or global)
    //   char      *name;       // Name of the function or global.
    //   size_t     size;       // Size of the entry info (0 if it a function).
    // };
    if (TgtOffloadEntryQTy.isNull()) {
      final ASTContext /*&*/ C = CGM.getContext();
      RecordDecl /*P*/ RD = C.buildImplicitRecord(new StringRef(/*KEEP_STR*/"__tgt_offload_entry"));
      RD.startDefinition();
      CGOpenMPRuntimeStatics.addFieldToRecordDecl(C, RD, C.VoidPtrTy.$QualType());
      CGOpenMPRuntimeStatics.addFieldToRecordDecl(C, RD, C.getPointerType(/*NO_COPY*/C.CharTy).$QualType());
      CGOpenMPRuntimeStatics.addFieldToRecordDecl(C, RD, C.getSizeType().$QualType());
      RD.completeDefinition();
      TgtOffloadEntryQTy.$assignMove(C.getRecordType(RD));
    }
    return new QualType(TgtOffloadEntryQTy);
  }

  
  /// \brief Returns __tgt_device_image type.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGOpenMPRuntime::getTgtDeviceImageQTy">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp", line = 3099,
   FQN="clang::CodeGen::CGOpenMPRuntime::getTgtDeviceImageQTy", NM="_ZN5clang7CodeGen15CGOpenMPRuntime20getTgtDeviceImageQTyEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp -nm=_ZN5clang7CodeGen15CGOpenMPRuntime20getTgtDeviceImageQTyEv")
  //</editor-fold>
  private QualType getTgtDeviceImageQTy() {
    // These are the types we need to build:
    // struct __tgt_device_image{
    // void   *ImageStart;       // Pointer to the target code start.
    // void   *ImageEnd;         // Pointer to the target code end.
    // // We also add the host entries to the device image, as it may be useful
    // // for the target runtime to have access to that information.
    // __tgt_offload_entry  *EntriesBegin;   // Begin of the table with all
    //                                       // the entries.
    // __tgt_offload_entry  *EntriesEnd;     // End of the table with all the
    //                                       // entries (non inclusive).
    // };
    if (TgtDeviceImageQTy.isNull()) {
      final ASTContext /*&*/ C = CGM.getContext();
      RecordDecl /*P*/ RD = C.buildImplicitRecord(new StringRef(/*KEEP_STR*/"__tgt_device_image"));
      RD.startDefinition();
      CGOpenMPRuntimeStatics.addFieldToRecordDecl(C, RD, C.VoidPtrTy.$QualType());
      CGOpenMPRuntimeStatics.addFieldToRecordDecl(C, RD, C.VoidPtrTy.$QualType());
      CGOpenMPRuntimeStatics.addFieldToRecordDecl(C, RD, C.getPointerType(getTgtOffloadEntryQTy()));
      CGOpenMPRuntimeStatics.addFieldToRecordDecl(C, RD, C.getPointerType(getTgtOffloadEntryQTy()));
      RD.completeDefinition();
      TgtDeviceImageQTy.$assignMove(C.getRecordType(RD));
    }
    return new QualType(TgtDeviceImageQTy);
  }

  
  /// \brief Returns __tgt_bin_desc type.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGOpenMPRuntime::getTgtBinaryDescriptorQTy">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp", line = 3125,
   FQN="clang::CodeGen::CGOpenMPRuntime::getTgtBinaryDescriptorQTy", NM="_ZN5clang7CodeGen15CGOpenMPRuntime25getTgtBinaryDescriptorQTyEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp -nm=_ZN5clang7CodeGen15CGOpenMPRuntime25getTgtBinaryDescriptorQTyEv")
  //</editor-fold>
  private QualType getTgtBinaryDescriptorQTy() {
    // struct __tgt_bin_desc{
    //   int32_t              NumDevices;      // Number of devices supported.
    //   __tgt_device_image   *DeviceImages;   // Arrays of device images
    //                                         // (one per device).
    //   __tgt_offload_entry  *EntriesBegin;   // Begin of the table with all the
    //                                         // entries.
    //   __tgt_offload_entry  *EntriesEnd;     // End of the table with all the
    //                                         // entries (non inclusive).
    // };
    if (TgtBinaryDescriptorQTy.isNull()) {
      final ASTContext /*&*/ C = CGM.getContext();
      RecordDecl /*P*/ RD = C.buildImplicitRecord(new StringRef(/*KEEP_STR*/"__tgt_bin_desc"));
      RD.startDefinition();
      CGOpenMPRuntimeStatics.addFieldToRecordDecl(C, RD, C.getIntTypeForBitwidth(/*DestWidth=*/ 32, /*Signed=*/ /*true*/1));
      CGOpenMPRuntimeStatics.addFieldToRecordDecl(C, RD, C.getPointerType(getTgtDeviceImageQTy()));
      CGOpenMPRuntimeStatics.addFieldToRecordDecl(C, RD, C.getPointerType(getTgtOffloadEntryQTy()));
      CGOpenMPRuntimeStatics.addFieldToRecordDecl(C, RD, C.getPointerType(getTgtOffloadEntryQTy()));
      RD.completeDefinition();
      TgtBinaryDescriptorQTy.$assignMove(C.getRecordType(RD));
    }
    return new QualType(TgtBinaryDescriptorQTy);
  }

  
  /// \brief Start scanning from statement \a S and and emit all target regions
  /// found along the way.
  /// \param S Starting statement.
  /// \param ParentName Name of the function declaration that is being scanned.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGOpenMPRuntime::scanForTargetRegionsFunctions">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp", line = 5890,
   FQN="clang::CodeGen::CGOpenMPRuntime::scanForTargetRegionsFunctions", NM="_ZN5clang7CodeGen15CGOpenMPRuntime29scanForTargetRegionsFunctionsEPKNS_4StmtEN4llvm9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp -nm=_ZN5clang7CodeGen15CGOpenMPRuntime29scanForTargetRegionsFunctionsEPKNS_4StmtEN4llvm9StringRefE")
  //</editor-fold>
  private void scanForTargetRegionsFunctions(/*const*/ Stmt /*P*/ S, 
                               StringRef ParentName) {
    if (!(S != null)) {
      return;
    }
    
    // If we find a OMP target directive, codegen the outline function and
    // register the result.
    // FIXME: Add other directives with target when they become supported.
    boolean isTargetDirective = isa_OMPTargetDirective(S);
    if (isTargetDirective) {
      /*const*/ OMPExecutableDirective /*P*/ E = cast_OMPExecutableDirective(S);
      uint$ref DeviceID = create_uint$ref();
      uint$ref FileID = create_uint$ref();
      uint$ref Line = create_uint$ref();
      CGOpenMPRuntimeStatics.getTargetEntryUniqueInfo(CGM.getContext(), E.getLocStart(), DeviceID, 
          FileID, Line);
      
      // Is this a target region that should not be emitted as an entry point? If
      // so just signal we are done with this target region.
      if (!OffloadEntriesInfoManager.hasTargetRegionEntryInfo(DeviceID.$deref(), FileID.$deref(), 
          new StringRef(ParentName), Line.$deref())) {
        return;
      }
      
      //std.tie(Fn, Addr).$assign(tmp);
      final pair<Function, Constant> tmp = CodeGenFunction.EmitOMPTargetDirectiveOutlinedFunction(CGM, cast_OMPTargetDirective(/*Deref*/E), new StringRef(ParentName), 
              /*isOffloadEntry=*/ true);
      Function /*P*/ Fn = tmp.first;
      Constant /*P*/ Addr = tmp.second;
      assert ((Fn != null) && (Addr != null)) : "Target region emission failed.";
      return;
    }
    {
      
      /*const*/ OMPExecutableDirective /*P*/ E = dyn_cast_OMPExecutableDirective(S);
      if ((E != null)) {
        if (!E.hasAssociatedStmt()) {
          return;
        }
        
        scanForTargetRegionsFunctions(cast_CapturedStmt(E.getAssociatedStmt()).getCapturedStmt(), 
            new StringRef(ParentName));
        return;
      }
    }
    {
      
      // If this is a lambda function, look into its body.
      /*const*/ LambdaExpr /*P*/ L = dyn_cast_LambdaExpr(S);
      if ((L != null)) {
        S = L.getBody();
      }
    }
    
    // Keep looking for target regions recursively.
    for (/*const*/ Stmt /*P*/ II : S.children$Const())  {
      scanForTargetRegionsFunctions(II, new StringRef(ParentName));
    }
  }

  
  /// \brief Build type kmp_routine_entry_t (if not built yet).
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGOpenMPRuntime::emitKmpRoutineEntryT">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp", line = 3053,
   FQN="clang::CodeGen::CGOpenMPRuntime::emitKmpRoutineEntryT", NM="_ZN5clang7CodeGen15CGOpenMPRuntime20emitKmpRoutineEntryTENS_8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp -nm=_ZN5clang7CodeGen15CGOpenMPRuntime20emitKmpRoutineEntryTENS_8QualTypeE")
  //</editor-fold>
  private void emitKmpRoutineEntryT(QualType KmpInt32Ty) {
    if (!(KmpRoutineEntryPtrTy != null)) {
      // Build typedef kmp_int32 (* kmp_routine_entry_t)(kmp_int32, void *); type.
      final ASTContext /*&*/ C = CGM.getContext();
      QualType KmpRoutineEntryTyArgs[/*2*/] = new QualType [/*2*/] {KmpInt32Ty, C.VoidPtrTy.$QualType()};
      FunctionProtoType.ExtProtoInfo EPI/*J*/= new FunctionProtoType.ExtProtoInfo();
      KmpRoutineEntryPtrQTy.$assignMove(C.getPointerType(C.getFunctionType(new QualType(KmpInt32Ty), new ArrayRef<QualType>(KmpRoutineEntryTyArgs, false), EPI)));
      KmpRoutineEntryPtrTy = CGM.getTypes().ConvertType(new QualType(KmpRoutineEntryPtrQTy));
    }
  }

  
  /// \brief Emits object of ident_t type with info for source location.
  /// \param Flags Flags for OpenMP location.
  ///
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGOpenMPRuntime::emitUpdateLocation">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp", line = 926,
   FQN="clang::CodeGen::CGOpenMPRuntime::emitUpdateLocation", NM="_ZN5clang7CodeGen15CGOpenMPRuntime18emitUpdateLocationERNS0_15CodeGenFunctionENS_14SourceLocationEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp -nm=_ZN5clang7CodeGen15CGOpenMPRuntime18emitUpdateLocationERNS0_15CodeGenFunctionENS_14SourceLocationEj")
  //</editor-fold>
  private Value /*P*/ emitUpdateLocation(final CodeGenFunction /*&*/ CGF, 
                    SourceLocation Loc) {
    return emitUpdateLocation(CGF, 
                    Loc, 
                    0);
  }
  private Value /*P*/ emitUpdateLocation(final CodeGenFunction /*&*/ CGF, 
                    SourceLocation Loc, 
                    /*uint*/int Flags/*= 0*/) {
    Flags |= OpenMPLocationFlags.OMP_IDENT_KMPC;
    // If no debug info is generated - return global default location.
    if (CGM.getCodeGenOpts().getDebugInfo() == DebugInfoKind.NoDebugInfo
       || Loc.isInvalid()) {
      return getOrCreateDefaultLocation(Flags).getPointer();
    }
    assert ((CGF.CurFn != null)) : "No function in current CodeGenFunction.";
    
    Address LocValue = Address.invalid();
    DenseMapIterator<Function /*P*/ , DebugLocThreadIdTy> I = OpenMPLocThreadIDMap.find(CGF.CurFn);
    if (I.$noteq(/*NO_ITER_COPY*/OpenMPLocThreadIDMap.end())) {
      LocValue.$assignMove(new Address(I.$arrow().second.DebugLoc, CGOpenMPRuntimeStatics.getIdentAlign(CGF.CGM)));
    }
    
    // OpenMPLocThreadIDMap may have null DebugLoc and non-null ThreadID, if
    // GetOpenMPThreadID was called before this routine.
    if (!LocValue.isValid()) {
      CGBuilderTy.InsertPointGuard IPG = null;
      try {
        // Generate "ident_t .kmpc_loc.addr;"
        Address AI = CGF.CreateTempAlloca(IdentTy, CGOpenMPRuntimeStatics.getIdentAlign(CGF.CGM), 
            new Twine(/*KEEP_STR*/".kmpc_loc.addr"));
        final std.pair<Function /*P*/ , DebugLocThreadIdTy> /*&*/ Elem = OpenMPLocThreadIDMap.FindAndConstruct(CGF.CurFn);
        Elem.second.DebugLoc = AI.getPointer();
        LocValue.$assign(AI);
        
        IPG/*J*/= new CGBuilderTy.InsertPointGuard(CGF.Builder);
        CGF.Builder.SetInsertPoint(CGF.AllocaInsertPt.$T$P());
        CGF.Builder.CreateMemCpy(new Address(LocValue), getOrCreateDefaultLocation(Flags), 
            CGM.getSize(CGOpenMPRuntimeStatics.getIdentSize(CGF.CGM)));
      } finally {
        if (IPG != null) { IPG.$destroy(); }
      }
    }
    
    // char **psource = &.kmpc_loc_<flags>.addr.psource;
    Address PSource = CGOpenMPRuntimeStatics.createIdentFieldGEP(CGF, new Address(LocValue), IdentFieldIndex.IdentField_PSource);
    
    Value /*P*/ OMPDebugLoc = OpenMPDebugLocMap.lookup(Loc.getRawEncoding());
    if (OMPDebugLoc == null) {
      raw_svector_ostream OS2 = null;
      try {
        SmallString/*<128>*/ Buffer2/*J*/= new SmallString/*<128>*/(128);
        OS2/*J*/= new raw_svector_ostream(Buffer2);
        // Build debug location
        PresumedLoc PLoc = CGF.getContext().getSourceManager().getPresumedLoc(/*NO_COPY*/Loc);
        OS2.$out(/*KEEP_STR*/$SEMI).$out(PLoc.getFilename()).$out(/*KEEP_STR*/$SEMI);
        {
          /*const*/ FunctionDecl /*P*/ FD = dyn_cast_or_null_FunctionDecl(CGF.CurFuncDecl);
          if ((FD != null)) {
            OS2.$out(FD.getQualifiedNameAsString());
          }
        }
        OS2.$out(/*KEEP_STR*/$SEMI).$out_uint(PLoc.getLine()).$out(/*KEEP_STR*/$SEMI).$out_uint(PLoc.getColumn()).$out(/*KEEP_STR*/";;");
        OMPDebugLoc = CGF.Builder.CreateGlobalStringPtr(OS2.str());
        OpenMPDebugLocMap.$set(Loc.getRawEncoding(), OMPDebugLoc);
      } finally {
        if (OS2 != null) { OS2.$destroy(); }
      }
    }
    // *psource = ";<File>;<Function>;<Line>;<Column>;;";
    CGF.Builder.CreateStore(OMPDebugLoc, new Address(PSource));
    
    // Our callers always pass this to a runtime function, so for
    // convenience, go ahead and return a naked pointer.
    return LocValue.getPointer();
  }

  
  /// \brief Returns pointer to ident_t type.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGOpenMPRuntime::getIdentTyPointerTy">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp", line = 1039,
   FQN="clang::CodeGen::CGOpenMPRuntime::getIdentTyPointerTy", NM="_ZN5clang7CodeGen15CGOpenMPRuntime19getIdentTyPointerTyEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp -nm=_ZN5clang7CodeGen15CGOpenMPRuntime19getIdentTyPointerTyEv")
  //</editor-fold>
  private org.llvm.ir.Type /*P*/ getIdentTyPointerTy() {
    if (!(IdentTy != null)) {
    }
    return org.llvm.ir.PointerType.getUnqual(IdentTy);
  }

  
  /// \brief Returns pointer to kmpc_micro type.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGOpenMPRuntime::getKmpc_MicroPointerTy">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp", line = 1045,
   FQN="clang::CodeGen::CGOpenMPRuntime::getKmpc_MicroPointerTy", NM="_ZN5clang7CodeGen15CGOpenMPRuntime22getKmpc_MicroPointerTyEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp -nm=_ZN5clang7CodeGen15CGOpenMPRuntime22getKmpc_MicroPointerTyEv")
  //</editor-fold>
  private org.llvm.ir.Type /*P*/ getKmpc_MicroPointerTy() {
    if (!(Kmpc_MicroTy != null)) {
      // Build void (*kmpc_micro)(kmp_int32 *global_tid, kmp_int32 *bound_tid,...)
      org.llvm.ir.Type /*P*/ MicroParams[/*2*/] = new org.llvm.ir.Type /*P*/  [/*2*/] {
        org.llvm.ir.PointerType.getUnqual(CGM.Int32Ty), 
        org.llvm.ir.PointerType.getUnqual(CGM.Int32Ty)};
      Kmpc_MicroTy = org.llvm.ir.FunctionType.get(CGM.VoidTy, new ArrayRef<org.llvm.ir.Type /*P*/ >(MicroParams, true), true);
    }
    return org.llvm.ir.PointerType.getUnqual(Kmpc_MicroTy);
  }

  
  /// \brief Returns specified OpenMP runtime function.
  /// \param Function OpenMP runtime function.
  /// \return Specified function.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGOpenMPRuntime::createRuntimeFunction">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp", line = 1055,
   FQN="clang::CodeGen::CGOpenMPRuntime::createRuntimeFunction", NM="_ZN5clang7CodeGen15CGOpenMPRuntime21createRuntimeFunctionEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp -nm=_ZN5clang7CodeGen15CGOpenMPRuntime21createRuntimeFunctionEj")
  //</editor-fold>
  private Constant /*P*/ createRuntimeFunction(/*uint*/int Function) {
    Constant /*P*/ RTLFn = null;
    switch (/*static_cast*/OpenMPRTLFunction.valueOf(Function)) {
     case OMPRTL__kmpc_fork_call:
      {
        // Build void __kmpc_fork_call(ident_t *loc, kmp_int32 argc, kmpc_micro
        // microtask, ...);
        org.llvm.ir.Type /*P*/ TypeParams[/*3*/] = new org.llvm.ir.Type /*P*/  [/*3*/] {
          getIdentTyPointerTy(), CGM.Int32Ty, 
          getKmpc_MicroPointerTy()};
        org.llvm.ir.FunctionType /*P*/ FnTy = org.llvm.ir.FunctionType.get(CGM.VoidTy, new ArrayRef<org.llvm.ir.Type /*P*/ >(TypeParams, true), /*isVarArg*/ true);
        RTLFn = CGM.CreateRuntimeFunction(FnTy, new StringRef(/*KEEP_STR*/"__kmpc_fork_call"));
        break;
      }
     case OMPRTL__kmpc_global_thread_num:
      {
        // Build kmp_int32 __kmpc_global_thread_num(ident_t *loc);
        org.llvm.ir.Type /*P*/ TypeParams[/*1*/] = new org.llvm.ir.Type /*P*/  [/*1*/] {getIdentTyPointerTy()};
        org.llvm.ir.FunctionType /*P*/ FnTy = org.llvm.ir.FunctionType.get(CGM.Int32Ty, new ArrayRef<org.llvm.ir.Type /*P*/ >(TypeParams, true), /*isVarArg*/ false);
        RTLFn = CGM.CreateRuntimeFunction(FnTy, new StringRef(/*KEEP_STR*/"__kmpc_global_thread_num"));
        break;
      }
     case OMPRTL__kmpc_threadprivate_cached:
      {
        // Build void *__kmpc_threadprivate_cached(ident_t *loc,
        // kmp_int32 global_tid, void *data, size_t size, void ***cache);
        org.llvm.ir.Type /*P*/ TypeParams[/*5*/] = new org.llvm.ir.Type /*P*/  [/*5*/] {
          getIdentTyPointerTy(), CGM.Int32Ty, 
          CGM.Unnamed_field9.VoidPtrTy, CGM.Unnamed_field8.SizeTy, 
          CGM.Unnamed_field9.VoidPtrTy.getPointerTo().getPointerTo()};
        org.llvm.ir.FunctionType /*P*/ FnTy = org.llvm.ir.FunctionType.get(CGM.Unnamed_field9.VoidPtrTy, new ArrayRef<org.llvm.ir.Type /*P*/ >(TypeParams, true), /*isVarArg*/ false);
        RTLFn = CGM.CreateRuntimeFunction(FnTy, new StringRef(/*KEEP_STR*/"__kmpc_threadprivate_cached"));
        break;
      }
     case OMPRTL__kmpc_critical:
      {
        // Build void __kmpc_critical(ident_t *loc, kmp_int32 global_tid,
        // kmp_critical_name *crit);
        org.llvm.ir.Type /*P*/ TypeParams[/*3*/] = new org.llvm.ir.Type /*P*/  [/*3*/] {
          getIdentTyPointerTy(), CGM.Int32Ty, 
          org.llvm.ir.PointerType.getUnqual(KmpCriticalNameTy)};
        org.llvm.ir.FunctionType /*P*/ FnTy = org.llvm.ir.FunctionType.get(CGM.VoidTy, new ArrayRef<org.llvm.ir.Type /*P*/ >(TypeParams, true), /*isVarArg*/ false);
        RTLFn = CGM.CreateRuntimeFunction(FnTy, new StringRef(/*KEEP_STR*/"__kmpc_critical"));
        break;
      }
     case OMPRTL__kmpc_critical_with_hint:
      {
        // Build void __kmpc_critical_with_hint(ident_t *loc, kmp_int32 global_tid,
        // kmp_critical_name *crit, uintptr_t hint);
        org.llvm.ir.Type /*P*/ TypeParams[/*4*/] = new org.llvm.ir.Type /*P*/  [/*4*/] {
          getIdentTyPointerTy(), CGM.Int32Ty, 
          org.llvm.ir.PointerType.getUnqual(KmpCriticalNameTy), 
          CGM.Unnamed_field8.IntPtrTy};
        org.llvm.ir.FunctionType /*P*/ FnTy = org.llvm.ir.FunctionType.get(CGM.VoidTy, new ArrayRef<org.llvm.ir.Type /*P*/ >(TypeParams, true), /*isVarArg*/ false);
        RTLFn = CGM.CreateRuntimeFunction(FnTy, new StringRef(/*KEEP_STR*/"__kmpc_critical_with_hint"));
        break;
      }
     case OMPRTL__kmpc_threadprivate_register:
      {
        // Build void __kmpc_threadprivate_register(ident_t *, void *data,
        // kmpc_ctor ctor, kmpc_cctor cctor, kmpc_dtor dtor);
        // typedef void *(*kmpc_ctor)(void *);
        org.llvm.ir.PointerType /*P*/ KmpcCtorTy = org.llvm.ir.FunctionType.get(CGM.Unnamed_field9.VoidPtrTy, new ArrayRef<org.llvm.ir.Type /*P*/ >(CGM.Unnamed_field9.VoidPtrTy, true), 
            /*isVarArg*/ false).getPointerTo();
        // typedef void *(*kmpc_cctor)(void *, void *);
        org.llvm.ir.Type /*P*/ KmpcCopyCtorTyArgs[/*2*/] = new org.llvm.ir.Type /*P*/  [/*2*/] {CGM.Unnamed_field9.VoidPtrTy, CGM.Unnamed_field9.VoidPtrTy};
        org.llvm.ir.PointerType /*P*/ KmpcCopyCtorTy = org.llvm.ir.FunctionType.get(CGM.Unnamed_field9.VoidPtrTy, new ArrayRef<org.llvm.ir.Type /*P*/ >(KmpcCopyCtorTyArgs, true), 
            /*isVarArg*/ false).getPointerTo();
        // typedef void (*kmpc_dtor)(void *);
        org.llvm.ir.PointerType /*P*/ KmpcDtorTy = org.llvm.ir.FunctionType.get(CGM.VoidTy, new ArrayRef<org.llvm.ir.Type /*P*/ >(CGM.Unnamed_field9.VoidPtrTy, true), /*isVarArg*/ false).
            getPointerTo();
        org.llvm.ir.Type /*P*/ FnTyArgs[/*5*/] = new org.llvm.ir.Type /*P*/  [/*5*/] {
          getIdentTyPointerTy(), CGM.Unnamed_field9.VoidPtrTy, KmpcCtorTy, 
          KmpcCopyCtorTy, KmpcDtorTy};
        org.llvm.ir.FunctionType /*P*/ FnTy = org.llvm.ir.FunctionType.get(CGM.VoidTy, new ArrayRef<org.llvm.ir.Type /*P*/ >(FnTyArgs, true), 
            /*isVarArg*/ false);
        RTLFn = CGM.CreateRuntimeFunction(FnTy, new StringRef(/*KEEP_STR*/"__kmpc_threadprivate_register"));
        break;
      }
     case OMPRTL__kmpc_end_critical:
      {
        // Build void __kmpc_end_critical(ident_t *loc, kmp_int32 global_tid,
        // kmp_critical_name *crit);
        org.llvm.ir.Type /*P*/ TypeParams[/*3*/] = new org.llvm.ir.Type /*P*/  [/*3*/] {
          getIdentTyPointerTy(), CGM.Int32Ty, 
          org.llvm.ir.PointerType.getUnqual(KmpCriticalNameTy)};
        org.llvm.ir.FunctionType /*P*/ FnTy = org.llvm.ir.FunctionType.get(CGM.VoidTy, new ArrayRef<org.llvm.ir.Type /*P*/ >(TypeParams, true), /*isVarArg*/ false);
        RTLFn = CGM.CreateRuntimeFunction(FnTy, new StringRef(/*KEEP_STR*/"__kmpc_end_critical"));
        break;
      }
     case OMPRTL__kmpc_cancel_barrier:
      {
        // Build kmp_int32 __kmpc_cancel_barrier(ident_t *loc, kmp_int32
        // global_tid);
        org.llvm.ir.Type /*P*/ TypeParams[/*2*/] = new org.llvm.ir.Type /*P*/  [/*2*/] {getIdentTyPointerTy(), CGM.Int32Ty};
        org.llvm.ir.FunctionType /*P*/ FnTy = org.llvm.ir.FunctionType.get(CGM.Int32Ty, new ArrayRef<org.llvm.ir.Type /*P*/ >(TypeParams, true), /*isVarArg*/ false);
        RTLFn = CGM.CreateRuntimeFunction(FnTy, /*Name*/ new StringRef(/*KEEP_STR*/"__kmpc_cancel_barrier"));
        break;
      }
     case OMPRTL__kmpc_barrier:
      {
        // Build void __kmpc_barrier(ident_t *loc, kmp_int32 global_tid);
        org.llvm.ir.Type /*P*/ TypeParams[/*2*/] = new org.llvm.ir.Type /*P*/  [/*2*/] {getIdentTyPointerTy(), CGM.Int32Ty};
        org.llvm.ir.FunctionType /*P*/ FnTy = org.llvm.ir.FunctionType.get(CGM.VoidTy, new ArrayRef<org.llvm.ir.Type /*P*/ >(TypeParams, true), /*isVarArg*/ false);
        RTLFn = CGM.CreateRuntimeFunction(FnTy, /*Name*/ new StringRef(/*KEEP_STR*/"__kmpc_barrier"));
        break;
      }
     case OMPRTL__kmpc_for_static_fini:
      {
        // Build void __kmpc_for_static_fini(ident_t *loc, kmp_int32 global_tid);
        org.llvm.ir.Type /*P*/ TypeParams[/*2*/] = new org.llvm.ir.Type /*P*/  [/*2*/] {getIdentTyPointerTy(), CGM.Int32Ty};
        org.llvm.ir.FunctionType /*P*/ FnTy = org.llvm.ir.FunctionType.get(CGM.VoidTy, new ArrayRef<org.llvm.ir.Type /*P*/ >(TypeParams, true), /*isVarArg*/ false);
        RTLFn = CGM.CreateRuntimeFunction(FnTy, new StringRef(/*KEEP_STR*/"__kmpc_for_static_fini"));
        break;
      }
     case OMPRTL__kmpc_push_num_threads:
      {
        // Build void __kmpc_push_num_threads(ident_t *loc, kmp_int32 global_tid,
        // kmp_int32 num_threads)
        org.llvm.ir.Type /*P*/ TypeParams[/*3*/] = new org.llvm.ir.Type /*P*/  [/*3*/] {
          getIdentTyPointerTy(), CGM.Int32Ty, 
          CGM.Int32Ty};
        org.llvm.ir.FunctionType /*P*/ FnTy = org.llvm.ir.FunctionType.get(CGM.VoidTy, new ArrayRef<org.llvm.ir.Type /*P*/ >(TypeParams, true), /*isVarArg*/ false);
        RTLFn = CGM.CreateRuntimeFunction(FnTy, new StringRef(/*KEEP_STR*/"__kmpc_push_num_threads"));
        break;
      }
     case OMPRTL__kmpc_serialized_parallel:
      {
        // Build void __kmpc_serialized_parallel(ident_t *loc, kmp_int32
        // global_tid);
        org.llvm.ir.Type /*P*/ TypeParams[/*2*/] = new org.llvm.ir.Type /*P*/  [/*2*/] {getIdentTyPointerTy(), CGM.Int32Ty};
        org.llvm.ir.FunctionType /*P*/ FnTy = org.llvm.ir.FunctionType.get(CGM.VoidTy, new ArrayRef<org.llvm.ir.Type /*P*/ >(TypeParams, true), /*isVarArg*/ false);
        RTLFn = CGM.CreateRuntimeFunction(FnTy, new StringRef(/*KEEP_STR*/"__kmpc_serialized_parallel"));
        break;
      }
     case OMPRTL__kmpc_end_serialized_parallel:
      {
        // Build void __kmpc_end_serialized_parallel(ident_t *loc, kmp_int32
        // global_tid);
        org.llvm.ir.Type /*P*/ TypeParams[/*2*/] = new org.llvm.ir.Type /*P*/  [/*2*/] {getIdentTyPointerTy(), CGM.Int32Ty};
        org.llvm.ir.FunctionType /*P*/ FnTy = org.llvm.ir.FunctionType.get(CGM.VoidTy, new ArrayRef<org.llvm.ir.Type /*P*/ >(TypeParams, true), /*isVarArg*/ false);
        RTLFn = CGM.CreateRuntimeFunction(FnTy, new StringRef(/*KEEP_STR*/"__kmpc_end_serialized_parallel"));
        break;
      }
     case OMPRTL__kmpc_flush:
      {
        // Build void __kmpc_flush(ident_t *loc);
        org.llvm.ir.Type /*P*/ TypeParams[/*1*/] = new org.llvm.ir.Type /*P*/  [/*1*/] {getIdentTyPointerTy()};
        org.llvm.ir.FunctionType /*P*/ FnTy = org.llvm.ir.FunctionType.get(CGM.VoidTy, new ArrayRef<org.llvm.ir.Type /*P*/ >(TypeParams, true), /*isVarArg*/ false);
        RTLFn = CGM.CreateRuntimeFunction(FnTy, new StringRef(/*KEEP_STR*/"__kmpc_flush"));
        break;
      }
     case OMPRTL__kmpc_master:
      {
        // Build kmp_int32 __kmpc_master(ident_t *loc, kmp_int32 global_tid);
        org.llvm.ir.Type /*P*/ TypeParams[/*2*/] = new org.llvm.ir.Type /*P*/  [/*2*/] {getIdentTyPointerTy(), CGM.Int32Ty};
        org.llvm.ir.FunctionType /*P*/ FnTy = org.llvm.ir.FunctionType.get(CGM.Int32Ty, new ArrayRef<org.llvm.ir.Type /*P*/ >(TypeParams, true), /*isVarArg=*/ false);
        RTLFn = CGM.CreateRuntimeFunction(FnTy, /*Name=*/ new StringRef(/*KEEP_STR*/"__kmpc_master"));
        break;
      }
     case OMPRTL__kmpc_end_master:
      {
        // Build void __kmpc_end_master(ident_t *loc, kmp_int32 global_tid);
        org.llvm.ir.Type /*P*/ TypeParams[/*2*/] = new org.llvm.ir.Type /*P*/  [/*2*/] {getIdentTyPointerTy(), CGM.Int32Ty};
        org.llvm.ir.FunctionType /*P*/ FnTy = org.llvm.ir.FunctionType.get(CGM.VoidTy, new ArrayRef<org.llvm.ir.Type /*P*/ >(TypeParams, true), /*isVarArg=*/ false);
        RTLFn = CGM.CreateRuntimeFunction(FnTy, /*Name=*/ new StringRef(/*KEEP_STR*/"__kmpc_end_master"));
        break;
      }
     case OMPRTL__kmpc_omp_taskyield:
      {
        // Build kmp_int32 __kmpc_omp_taskyield(ident_t *, kmp_int32 global_tid,
        // int end_part);
        org.llvm.ir.Type /*P*/ TypeParams[/*3*/] = new org.llvm.ir.Type /*P*/  [/*3*/] {getIdentTyPointerTy(), CGM.Int32Ty, CGM.IntTy};
        org.llvm.ir.FunctionType /*P*/ FnTy = org.llvm.ir.FunctionType.get(CGM.Int32Ty, new ArrayRef<org.llvm.ir.Type /*P*/ >(TypeParams, true), /*isVarArg=*/ false);
        RTLFn = CGM.CreateRuntimeFunction(FnTy, /*Name=*/ new StringRef(/*KEEP_STR*/"__kmpc_omp_taskyield"));
        break;
      }
     case OMPRTL__kmpc_single:
      {
        // Build kmp_int32 __kmpc_single(ident_t *loc, kmp_int32 global_tid);
        org.llvm.ir.Type /*P*/ TypeParams[/*2*/] = new org.llvm.ir.Type /*P*/  [/*2*/] {getIdentTyPointerTy(), CGM.Int32Ty};
        org.llvm.ir.FunctionType /*P*/ FnTy = org.llvm.ir.FunctionType.get(CGM.Int32Ty, new ArrayRef<org.llvm.ir.Type /*P*/ >(TypeParams, true), /*isVarArg=*/ false);
        RTLFn = CGM.CreateRuntimeFunction(FnTy, /*Name=*/ new StringRef(/*KEEP_STR*/"__kmpc_single"));
        break;
      }
     case OMPRTL__kmpc_end_single:
      {
        // Build void __kmpc_end_single(ident_t *loc, kmp_int32 global_tid);
        org.llvm.ir.Type /*P*/ TypeParams[/*2*/] = new org.llvm.ir.Type /*P*/  [/*2*/] {getIdentTyPointerTy(), CGM.Int32Ty};
        org.llvm.ir.FunctionType /*P*/ FnTy = org.llvm.ir.FunctionType.get(CGM.VoidTy, new ArrayRef<org.llvm.ir.Type /*P*/ >(TypeParams, true), /*isVarArg=*/ false);
        RTLFn = CGM.CreateRuntimeFunction(FnTy, /*Name=*/ new StringRef(/*KEEP_STR*/"__kmpc_end_single"));
        break;
      }
     case OMPRTL__kmpc_omp_task_alloc:
      {
        // Build kmp_task_t *__kmpc_omp_task_alloc(ident_t *, kmp_int32 gtid,
        // kmp_int32 flags, size_t sizeof_kmp_task_t, size_t sizeof_shareds,
        // kmp_routine_entry_t *task_entry);
        assert (KmpRoutineEntryPtrTy != null) : "Type kmp_routine_entry_t must be created.";
        org.llvm.ir.Type /*P*/ TypeParams[/*6*/] = new org.llvm.ir.Type /*P*/  [/*6*/] {
          getIdentTyPointerTy(), CGM.Int32Ty, CGM.Int32Ty, 
          CGM.Unnamed_field8.SizeTy, CGM.Unnamed_field8.SizeTy, KmpRoutineEntryPtrTy};
        // Return void * and then cast to particular kmp_task_t type.
        org.llvm.ir.FunctionType /*P*/ FnTy = org.llvm.ir.FunctionType.get(CGM.Unnamed_field9.VoidPtrTy, new ArrayRef<org.llvm.ir.Type /*P*/ >(TypeParams, true), /*isVarArg=*/ false);
        RTLFn = CGM.CreateRuntimeFunction(FnTy, /*Name=*/ new StringRef(/*KEEP_STR*/"__kmpc_omp_task_alloc"));
        break;
      }
     case OMPRTL__kmpc_omp_task:
      {
        // Build kmp_int32 __kmpc_omp_task(ident_t *, kmp_int32 gtid, kmp_task_t
        // *new_task);
        org.llvm.ir.Type /*P*/ TypeParams[/*3*/] = new org.llvm.ir.Type /*P*/  [/*3*/] {
          getIdentTyPointerTy(), CGM.Int32Ty, 
          CGM.Unnamed_field9.VoidPtrTy};
        org.llvm.ir.FunctionType /*P*/ FnTy = org.llvm.ir.FunctionType.get(CGM.Int32Ty, new ArrayRef<org.llvm.ir.Type /*P*/ >(TypeParams, true), /*isVarArg=*/ false);
        RTLFn = CGM.CreateRuntimeFunction(FnTy, /*Name=*/ new StringRef(/*KEEP_STR*/"__kmpc_omp_task"));
        break;
      }
     case OMPRTL__kmpc_copyprivate:
      {
        // Build void __kmpc_copyprivate(ident_t *loc, kmp_int32 global_tid,
        // size_t cpy_size, void *cpy_data, void(*cpy_func)(void *, void *),
        // kmp_int32 didit);
        org.llvm.ir.Type /*P*/ CpyTypeParams[/*2*/] = new org.llvm.ir.Type /*P*/  [/*2*/] {CGM.Unnamed_field9.VoidPtrTy, CGM.Unnamed_field9.VoidPtrTy};
        org.llvm.ir.FunctionType /*P*/ CpyFnTy = org.llvm.ir.FunctionType.get(CGM.VoidTy, new ArrayRef<org.llvm.ir.Type /*P*/ >(CpyTypeParams, true), /*isVarArg=*/ false);
        org.llvm.ir.Type /*P*/ TypeParams[/*6*/] = new org.llvm.ir.Type /*P*/  [/*6*/] {
          getIdentTyPointerTy(), CGM.Int32Ty, CGM.Unnamed_field8.SizeTy, 
          CGM.Unnamed_field9.VoidPtrTy, CpyFnTy.getPointerTo(), 
          CGM.Int32Ty};
        org.llvm.ir.FunctionType /*P*/ FnTy = org.llvm.ir.FunctionType.get(CGM.VoidTy, new ArrayRef<org.llvm.ir.Type /*P*/ >(TypeParams, true), /*isVarArg=*/ false);
        RTLFn = CGM.CreateRuntimeFunction(FnTy, /*Name=*/ new StringRef(/*KEEP_STR*/"__kmpc_copyprivate"));
        break;
      }
     case OMPRTL__kmpc_reduce:
      {
        // Build kmp_int32 __kmpc_reduce(ident_t *loc, kmp_int32 global_tid,
        // kmp_int32 num_vars, size_t reduce_size, void *reduce_data, void
        // (*reduce_func)(void *lhs_data, void *rhs_data), kmp_critical_name *lck);
        org.llvm.ir.Type /*P*/ ReduceTypeParams[/*2*/] = new org.llvm.ir.Type /*P*/  [/*2*/] {CGM.Unnamed_field9.VoidPtrTy, CGM.Unnamed_field9.VoidPtrTy};
        org.llvm.ir.FunctionType /*P*/ ReduceFnTy = org.llvm.ir.FunctionType.get(CGM.VoidTy, new ArrayRef<org.llvm.ir.Type /*P*/ >(ReduceTypeParams, true), 
            /*isVarArg=*/ false);
        org.llvm.ir.Type /*P*/ TypeParams[/*7*/] = new org.llvm.ir.Type /*P*/  [/*7*/] {
          getIdentTyPointerTy(), CGM.Int32Ty, CGM.Int32Ty, CGM.Unnamed_field8.SizeTy, 
          CGM.Unnamed_field9.VoidPtrTy, ReduceFnTy.getPointerTo(), 
          org.llvm.ir.PointerType.getUnqual(KmpCriticalNameTy)};
        org.llvm.ir.FunctionType /*P*/ FnTy = org.llvm.ir.FunctionType.get(CGM.Int32Ty, new ArrayRef<org.llvm.ir.Type /*P*/ >(TypeParams, true), /*isVarArg=*/ false);
        RTLFn = CGM.CreateRuntimeFunction(FnTy, /*Name=*/ new StringRef(/*KEEP_STR*/"__kmpc_reduce"));
        break;
      }
     case OMPRTL__kmpc_reduce_nowait:
      {
        // Build kmp_int32 __kmpc_reduce_nowait(ident_t *loc, kmp_int32
        // global_tid, kmp_int32 num_vars, size_t reduce_size, void *reduce_data,
        // void (*reduce_func)(void *lhs_data, void *rhs_data), kmp_critical_name
        // *lck);
        org.llvm.ir.Type /*P*/ ReduceTypeParams[/*2*/] = new org.llvm.ir.Type /*P*/  [/*2*/] {CGM.Unnamed_field9.VoidPtrTy, CGM.Unnamed_field9.VoidPtrTy};
        org.llvm.ir.FunctionType /*P*/ ReduceFnTy = org.llvm.ir.FunctionType.get(CGM.VoidTy, new ArrayRef<org.llvm.ir.Type /*P*/ >(ReduceTypeParams, true), 
            /*isVarArg=*/ false);
        org.llvm.ir.Type /*P*/ TypeParams[/*7*/] = new org.llvm.ir.Type /*P*/  [/*7*/] {
          getIdentTyPointerTy(), CGM.Int32Ty, CGM.Int32Ty, CGM.Unnamed_field8.SizeTy, 
          CGM.Unnamed_field9.VoidPtrTy, ReduceFnTy.getPointerTo(), 
          org.llvm.ir.PointerType.getUnqual(KmpCriticalNameTy)};
        org.llvm.ir.FunctionType /*P*/ FnTy = org.llvm.ir.FunctionType.get(CGM.Int32Ty, new ArrayRef<org.llvm.ir.Type /*P*/ >(TypeParams, true), /*isVarArg=*/ false);
        RTLFn = CGM.CreateRuntimeFunction(FnTy, /*Name=*/ new StringRef(/*KEEP_STR*/"__kmpc_reduce_nowait"));
        break;
      }
     case OMPRTL__kmpc_end_reduce:
      {
        // Build void __kmpc_end_reduce(ident_t *loc, kmp_int32 global_tid,
        // kmp_critical_name *lck);
        org.llvm.ir.Type /*P*/ TypeParams[/*3*/] = new org.llvm.ir.Type /*P*/  [/*3*/] {
          getIdentTyPointerTy(), CGM.Int32Ty, 
          org.llvm.ir.PointerType.getUnqual(KmpCriticalNameTy)};
        org.llvm.ir.FunctionType /*P*/ FnTy = org.llvm.ir.FunctionType.get(CGM.VoidTy, new ArrayRef<org.llvm.ir.Type /*P*/ >(TypeParams, true), /*isVarArg=*/ false);
        RTLFn = CGM.CreateRuntimeFunction(FnTy, /*Name=*/ new StringRef(/*KEEP_STR*/"__kmpc_end_reduce"));
        break;
      }
     case OMPRTL__kmpc_end_reduce_nowait:
      {
        // Build __kmpc_end_reduce_nowait(ident_t *loc, kmp_int32 global_tid,
        // kmp_critical_name *lck);
        org.llvm.ir.Type /*P*/ TypeParams[/*3*/] = new org.llvm.ir.Type /*P*/  [/*3*/] {
          getIdentTyPointerTy(), CGM.Int32Ty, 
          org.llvm.ir.PointerType.getUnqual(KmpCriticalNameTy)};
        org.llvm.ir.FunctionType /*P*/ FnTy = org.llvm.ir.FunctionType.get(CGM.VoidTy, new ArrayRef<org.llvm.ir.Type /*P*/ >(TypeParams, true), /*isVarArg=*/ false);
        RTLFn
           = CGM.CreateRuntimeFunction(FnTy, /*Name=*/ new StringRef(/*KEEP_STR*/"__kmpc_end_reduce_nowait"));
        break;
      }
     case OMPRTL__kmpc_omp_task_begin_if0:
      {
        // Build void __kmpc_omp_task(ident_t *, kmp_int32 gtid, kmp_task_t
        // *new_task);
        org.llvm.ir.Type /*P*/ TypeParams[/*3*/] = new org.llvm.ir.Type /*P*/  [/*3*/] {
          getIdentTyPointerTy(), CGM.Int32Ty, 
          CGM.Unnamed_field9.VoidPtrTy};
        org.llvm.ir.FunctionType /*P*/ FnTy = org.llvm.ir.FunctionType.get(CGM.VoidTy, new ArrayRef<org.llvm.ir.Type /*P*/ >(TypeParams, true), /*isVarArg=*/ false);
        RTLFn
           = CGM.CreateRuntimeFunction(FnTy, /*Name=*/ new StringRef(/*KEEP_STR*/"__kmpc_omp_task_begin_if0"));
        break;
      }
     case OMPRTL__kmpc_omp_task_complete_if0:
      {
        // Build void __kmpc_omp_task(ident_t *, kmp_int32 gtid, kmp_task_t
        // *new_task);
        org.llvm.ir.Type /*P*/ TypeParams[/*3*/] = new org.llvm.ir.Type /*P*/  [/*3*/] {
          getIdentTyPointerTy(), CGM.Int32Ty, 
          CGM.Unnamed_field9.VoidPtrTy};
        org.llvm.ir.FunctionType /*P*/ FnTy = org.llvm.ir.FunctionType.get(CGM.VoidTy, new ArrayRef<org.llvm.ir.Type /*P*/ >(TypeParams, true), /*isVarArg=*/ false);
        RTLFn = CGM.CreateRuntimeFunction(FnTy, 
            /*Name=*/ new StringRef(/*KEEP_STR*/"__kmpc_omp_task_complete_if0"));
        break;
      }
     case OMPRTL__kmpc_ordered:
      {
        // Build void __kmpc_ordered(ident_t *loc, kmp_int32 global_tid);
        org.llvm.ir.Type /*P*/ TypeParams[/*2*/] = new org.llvm.ir.Type /*P*/  [/*2*/] {getIdentTyPointerTy(), CGM.Int32Ty};
        org.llvm.ir.FunctionType /*P*/ FnTy = org.llvm.ir.FunctionType.get(CGM.VoidTy, new ArrayRef<org.llvm.ir.Type /*P*/ >(TypeParams, true), /*isVarArg=*/ false);
        RTLFn = CGM.CreateRuntimeFunction(FnTy, new StringRef(/*KEEP_STR*/"__kmpc_ordered"));
        break;
      }
     case OMPRTL__kmpc_end_ordered:
      {
        // Build void __kmpc_end_ordered(ident_t *loc, kmp_int32 global_tid);
        org.llvm.ir.Type /*P*/ TypeParams[/*2*/] = new org.llvm.ir.Type /*P*/  [/*2*/] {getIdentTyPointerTy(), CGM.Int32Ty};
        org.llvm.ir.FunctionType /*P*/ FnTy = org.llvm.ir.FunctionType.get(CGM.VoidTy, new ArrayRef<org.llvm.ir.Type /*P*/ >(TypeParams, true), /*isVarArg=*/ false);
        RTLFn = CGM.CreateRuntimeFunction(FnTy, new StringRef(/*KEEP_STR*/"__kmpc_end_ordered"));
        break;
      }
     case OMPRTL__kmpc_omp_taskwait:
      {
        // Build kmp_int32 __kmpc_omp_taskwait(ident_t *loc, kmp_int32 global_tid);
        org.llvm.ir.Type /*P*/ TypeParams[/*2*/] = new org.llvm.ir.Type /*P*/  [/*2*/] {getIdentTyPointerTy(), CGM.Int32Ty};
        org.llvm.ir.FunctionType /*P*/ FnTy = org.llvm.ir.FunctionType.get(CGM.Int32Ty, new ArrayRef<org.llvm.ir.Type /*P*/ >(TypeParams, true), /*isVarArg=*/ false);
        RTLFn = CGM.CreateRuntimeFunction(FnTy, new StringRef(/*KEEP_STR*/"__kmpc_omp_taskwait"));
        break;
      }
     case OMPRTL__kmpc_taskgroup:
      {
        // Build void __kmpc_taskgroup(ident_t *loc, kmp_int32 global_tid);
        org.llvm.ir.Type /*P*/ TypeParams[/*2*/] = new org.llvm.ir.Type /*P*/  [/*2*/] {getIdentTyPointerTy(), CGM.Int32Ty};
        org.llvm.ir.FunctionType /*P*/ FnTy = org.llvm.ir.FunctionType.get(CGM.VoidTy, new ArrayRef<org.llvm.ir.Type /*P*/ >(TypeParams, true), /*isVarArg=*/ false);
        RTLFn = CGM.CreateRuntimeFunction(FnTy, new StringRef(/*KEEP_STR*/"__kmpc_taskgroup"));
        break;
      }
     case OMPRTL__kmpc_end_taskgroup:
      {
        // Build void __kmpc_end_taskgroup(ident_t *loc, kmp_int32 global_tid);
        org.llvm.ir.Type /*P*/ TypeParams[/*2*/] = new org.llvm.ir.Type /*P*/  [/*2*/] {getIdentTyPointerTy(), CGM.Int32Ty};
        org.llvm.ir.FunctionType /*P*/ FnTy = org.llvm.ir.FunctionType.get(CGM.VoidTy, new ArrayRef<org.llvm.ir.Type /*P*/ >(TypeParams, true), /*isVarArg=*/ false);
        RTLFn = CGM.CreateRuntimeFunction(FnTy, new StringRef(/*KEEP_STR*/"__kmpc_end_taskgroup"));
        break;
      }
     case OMPRTL__kmpc_push_proc_bind:
      {
        // Build void __kmpc_push_proc_bind(ident_t *loc, kmp_int32 global_tid,
        // int proc_bind)
        org.llvm.ir.Type /*P*/ TypeParams[/*3*/] = new org.llvm.ir.Type /*P*/  [/*3*/] {getIdentTyPointerTy(), CGM.Int32Ty, CGM.IntTy};
        org.llvm.ir.FunctionType /*P*/ FnTy = org.llvm.ir.FunctionType.get(CGM.VoidTy, new ArrayRef<org.llvm.ir.Type /*P*/ >(TypeParams, true), /*isVarArg*/ false);
        RTLFn = CGM.CreateRuntimeFunction(FnTy, new StringRef(/*KEEP_STR*/"__kmpc_push_proc_bind"));
        break;
      }
     case OMPRTL__kmpc_omp_task_with_deps:
      {
        // Build kmp_int32 __kmpc_omp_task_with_deps(ident_t *, kmp_int32 gtid,
        // kmp_task_t *new_task, kmp_int32 ndeps, kmp_depend_info_t *dep_list,
        // kmp_int32 ndeps_noalias, kmp_depend_info_t *noalias_dep_list);
        org.llvm.ir.Type /*P*/ TypeParams[/*7*/] = new org.llvm.ir.Type /*P*/  [/*7*/] {
          getIdentTyPointerTy(), CGM.Int32Ty, CGM.Unnamed_field9.VoidPtrTy, CGM.Int32Ty, 
          CGM.Unnamed_field9.VoidPtrTy, CGM.Int32Ty, CGM.Unnamed_field9.VoidPtrTy};
        org.llvm.ir.FunctionType /*P*/ FnTy = org.llvm.ir.FunctionType.get(CGM.Int32Ty, new ArrayRef<org.llvm.ir.Type /*P*/ >(TypeParams, true), /*isVarArg=*/ false);
        RTLFn
           = CGM.CreateRuntimeFunction(FnTy, /*Name=*/ new StringRef(/*KEEP_STR*/"__kmpc_omp_task_with_deps"));
        break;
      }
     case OMPRTL__kmpc_omp_wait_deps:
      {
        // Build void __kmpc_omp_wait_deps(ident_t *, kmp_int32 gtid,
        // kmp_int32 ndeps, kmp_depend_info_t *dep_list, kmp_int32 ndeps_noalias,
        // kmp_depend_info_t *noalias_dep_list);
        org.llvm.ir.Type /*P*/ TypeParams[/*6*/] = new org.llvm.ir.Type /*P*/  [/*6*/] {
          getIdentTyPointerTy(), CGM.Int32Ty, 
          CGM.Int32Ty, CGM.Unnamed_field9.VoidPtrTy, 
          CGM.Int32Ty, CGM.Unnamed_field9.VoidPtrTy};
        org.llvm.ir.FunctionType /*P*/ FnTy = org.llvm.ir.FunctionType.get(CGM.VoidTy, new ArrayRef<org.llvm.ir.Type /*P*/ >(TypeParams, true), /*isVarArg=*/ false);
        RTLFn = CGM.CreateRuntimeFunction(FnTy, /*Name=*/ new StringRef(/*KEEP_STR*/"__kmpc_omp_wait_deps"));
        break;
      }
     case OMPRTL__kmpc_cancellationpoint:
      {
        // Build kmp_int32 __kmpc_cancellationpoint(ident_t *loc, kmp_int32
        // global_tid, kmp_int32 cncl_kind)
        org.llvm.ir.Type /*P*/ TypeParams[/*3*/] = new org.llvm.ir.Type /*P*/  [/*3*/] {getIdentTyPointerTy(), CGM.Int32Ty, CGM.IntTy};
        org.llvm.ir.FunctionType /*P*/ FnTy = org.llvm.ir.FunctionType.get(CGM.Int32Ty, new ArrayRef<org.llvm.ir.Type /*P*/ >(TypeParams, true), /*isVarArg*/ false);
        RTLFn = CGM.CreateRuntimeFunction(FnTy, new StringRef(/*KEEP_STR*/"__kmpc_cancellationpoint"));
        break;
      }
     case OMPRTL__kmpc_cancel:
      {
        // Build kmp_int32 __kmpc_cancel(ident_t *loc, kmp_int32 global_tid,
        // kmp_int32 cncl_kind)
        org.llvm.ir.Type /*P*/ TypeParams[/*3*/] = new org.llvm.ir.Type /*P*/  [/*3*/] {getIdentTyPointerTy(), CGM.Int32Ty, CGM.IntTy};
        org.llvm.ir.FunctionType /*P*/ FnTy = org.llvm.ir.FunctionType.get(CGM.Int32Ty, new ArrayRef<org.llvm.ir.Type /*P*/ >(TypeParams, true), /*isVarArg*/ false);
        RTLFn = CGM.CreateRuntimeFunction(FnTy, new StringRef(/*KEEP_STR*/"__kmpc_cancel"));
        break;
      }
     case OMPRTL__kmpc_push_num_teams:
      {
        // Build void kmpc_push_num_teams (ident_t loc, kmp_int32 global_tid,
        // kmp_int32 num_teams, kmp_int32 num_threads)
        org.llvm.ir.Type /*P*/ TypeParams[/*4*/] = new org.llvm.ir.Type /*P*/  [/*4*/] {
          getIdentTyPointerTy(), CGM.Int32Ty, CGM.Int32Ty, 
          CGM.Int32Ty};
        org.llvm.ir.FunctionType /*P*/ FnTy = org.llvm.ir.FunctionType.get(CGM.Int32Ty, new ArrayRef<org.llvm.ir.Type /*P*/ >(TypeParams, true), /*isVarArg*/ false);
        RTLFn = CGM.CreateRuntimeFunction(FnTy, new StringRef(/*KEEP_STR*/"__kmpc_push_num_teams"));
        break;
      }
     case OMPRTL__kmpc_fork_teams:
      {
        // Build void __kmpc_fork_teams(ident_t *loc, kmp_int32 argc, kmpc_micro
        // microtask, ...);
        org.llvm.ir.Type /*P*/ TypeParams[/*3*/] = new org.llvm.ir.Type /*P*/  [/*3*/] {
          getIdentTyPointerTy(), CGM.Int32Ty, 
          getKmpc_MicroPointerTy()};
        org.llvm.ir.FunctionType /*P*/ FnTy = org.llvm.ir.FunctionType.get(CGM.VoidTy, new ArrayRef<org.llvm.ir.Type /*P*/ >(TypeParams, true), /*isVarArg*/ true);
        RTLFn = CGM.CreateRuntimeFunction(FnTy, new StringRef(/*KEEP_STR*/"__kmpc_fork_teams"));
        break;
      }
     case OMPRTL__kmpc_taskloop:
      {
        // Build void __kmpc_taskloop(ident_t *loc, int gtid, kmp_task_t *task, int
        // if_val, kmp_uint64 *lb, kmp_uint64 *ub, kmp_int64 st, int nogroup, int
        // sched, kmp_uint64 grainsize, void *task_dup);
        org.llvm.ir.Type /*P*/ TypeParams[/*11*/] = new org.llvm.ir.Type /*P*/  [/*11*/] {
          getIdentTyPointerTy(), 
          CGM.IntTy, 
          CGM.Unnamed_field9.VoidPtrTy, 
          CGM.IntTy, 
          CGM.Int64Ty.getPointerTo(), 
          CGM.Int64Ty.getPointerTo(), 
          CGM.Int64Ty, 
          CGM.IntTy, 
          CGM.IntTy, 
          CGM.Int64Ty, 
          CGM.Unnamed_field9.VoidPtrTy};
        org.llvm.ir.FunctionType /*P*/ FnTy = org.llvm.ir.FunctionType.get(CGM.VoidTy, new ArrayRef<org.llvm.ir.Type /*P*/ >(TypeParams, true), /*isVarArg=*/ false);
        RTLFn = CGM.CreateRuntimeFunction(FnTy, /*Name=*/ new StringRef(/*KEEP_STR*/"__kmpc_taskloop"));
        break;
      }
     case OMPRTL__kmpc_doacross_init:
      {
        // Build void __kmpc_doacross_init(ident_t *loc, kmp_int32 gtid, kmp_int32
        // num_dims, struct kmp_dim *dims);
        org.llvm.ir.Type /*P*/ TypeParams[/*4*/] = new org.llvm.ir.Type /*P*/  [/*4*/] {
          getIdentTyPointerTy(), 
          CGM.Int32Ty, 
          CGM.Int32Ty, 
          CGM.Unnamed_field9.VoidPtrTy};
        org.llvm.ir.FunctionType /*P*/ FnTy = org.llvm.ir.FunctionType.get(CGM.VoidTy, new ArrayRef<org.llvm.ir.Type /*P*/ >(TypeParams, true), /*isVarArg=*/ false);
        RTLFn = CGM.CreateRuntimeFunction(FnTy, /*Name=*/ new StringRef(/*KEEP_STR*/"__kmpc_doacross_init"));
        break;
      }
     case OMPRTL__kmpc_doacross_fini:
      {
        // Build void __kmpc_doacross_fini(ident_t *loc, kmp_int32 gtid);
        org.llvm.ir.Type /*P*/ TypeParams[/*2*/] = new org.llvm.ir.Type /*P*/  [/*2*/] {getIdentTyPointerTy(), CGM.Int32Ty};
        org.llvm.ir.FunctionType /*P*/ FnTy = org.llvm.ir.FunctionType.get(CGM.VoidTy, new ArrayRef<org.llvm.ir.Type /*P*/ >(TypeParams, true), /*isVarArg=*/ false);
        RTLFn = CGM.CreateRuntimeFunction(FnTy, /*Name=*/ new StringRef(/*KEEP_STR*/"__kmpc_doacross_fini"));
        break;
      }
     case OMPRTL__kmpc_doacross_post:
      {
        // Build void __kmpc_doacross_post(ident_t *loc, kmp_int32 gtid, kmp_int64
        // *vec);
        org.llvm.ir.Type /*P*/ TypeParams[/*3*/] = new org.llvm.ir.Type /*P*/  [/*3*/] {
          getIdentTyPointerTy(), CGM.Int32Ty, 
          CGM.Int64Ty.getPointerTo()};
        org.llvm.ir.FunctionType /*P*/ FnTy = org.llvm.ir.FunctionType.get(CGM.VoidTy, new ArrayRef<org.llvm.ir.Type /*P*/ >(TypeParams, true), /*isVarArg=*/ false);
        RTLFn = CGM.CreateRuntimeFunction(FnTy, /*Name=*/ new StringRef(/*KEEP_STR*/"__kmpc_doacross_post"));
        break;
      }
     case OMPRTL__kmpc_doacross_wait:
      {
        // Build void __kmpc_doacross_wait(ident_t *loc, kmp_int32 gtid, kmp_int64
        // *vec);
        org.llvm.ir.Type /*P*/ TypeParams[/*3*/] = new org.llvm.ir.Type /*P*/  [/*3*/] {
          getIdentTyPointerTy(), CGM.Int32Ty, 
          CGM.Int64Ty.getPointerTo()};
        org.llvm.ir.FunctionType /*P*/ FnTy = org.llvm.ir.FunctionType.get(CGM.VoidTy, new ArrayRef<org.llvm.ir.Type /*P*/ >(TypeParams, true), /*isVarArg=*/ false);
        RTLFn = CGM.CreateRuntimeFunction(FnTy, /*Name=*/ new StringRef(/*KEEP_STR*/"__kmpc_doacross_wait"));
        break;
      }
     case OMPRTL__tgt_target:
      {
        // Build int32_t __tgt_target(int32_t device_id, void *host_ptr, int32_t
        // arg_num, void** args_base, void **args, size_t *arg_sizes, int32_t
        // *arg_types);
        org.llvm.ir.Type /*P*/ TypeParams[/*7*/] = new org.llvm.ir.Type /*P*/  [/*7*/] {
          CGM.Int32Ty, 
          CGM.Unnamed_field9.VoidPtrTy, 
          CGM.Int32Ty, 
          CGM.Unnamed_field10.VoidPtrPtrTy, 
          CGM.Unnamed_field10.VoidPtrPtrTy, 
          CGM.Unnamed_field8.SizeTy.getPointerTo(), 
          CGM.Int32Ty.getPointerTo()};
        org.llvm.ir.FunctionType /*P*/ FnTy = org.llvm.ir.FunctionType.get(CGM.Int32Ty, new ArrayRef<org.llvm.ir.Type /*P*/ >(TypeParams, true), /*isVarArg*/ false);
        RTLFn = CGM.CreateRuntimeFunction(FnTy, new StringRef(/*KEEP_STR*/"__tgt_target"));
        break;
      }
     case OMPRTL__tgt_target_teams:
      {
        // Build int32_t __tgt_target_teams(int32_t device_id, void *host_ptr,
        // int32_t arg_num, void** args_base, void **args, size_t *arg_sizes,
        // int32_t *arg_types, int32_t num_teams, int32_t thread_limit);
        org.llvm.ir.Type /*P*/ TypeParams[/*9*/] = new org.llvm.ir.Type /*P*/  [/*9*/] {
          CGM.Int32Ty, 
          CGM.Unnamed_field9.VoidPtrTy, 
          CGM.Int32Ty, 
          CGM.Unnamed_field10.VoidPtrPtrTy, 
          CGM.Unnamed_field10.VoidPtrPtrTy, 
          CGM.Unnamed_field8.SizeTy.getPointerTo(), 
          CGM.Int32Ty.getPointerTo(), 
          CGM.Int32Ty, 
          CGM.Int32Ty};
        org.llvm.ir.FunctionType /*P*/ FnTy = org.llvm.ir.FunctionType.get(CGM.Int32Ty, new ArrayRef<org.llvm.ir.Type /*P*/ >(TypeParams, true), /*isVarArg*/ false);
        RTLFn = CGM.CreateRuntimeFunction(FnTy, new StringRef(/*KEEP_STR*/"__tgt_target_teams"));
        break;
      }
     case OMPRTL__tgt_register_lib:
      {
        // Build void __tgt_register_lib(__tgt_bin_desc *desc);
        QualType ParamTy = CGM.getContext().getPointerType(getTgtBinaryDescriptorQTy());
        org.llvm.ir.Type /*P*/ TypeParams[/*1*/] = new org.llvm.ir.Type /*P*/  [/*1*/] {CGM.getTypes().ConvertTypeForMem(new QualType(ParamTy))};
        org.llvm.ir.FunctionType /*P*/ FnTy = org.llvm.ir.FunctionType.get(CGM.Int32Ty, new ArrayRef<org.llvm.ir.Type /*P*/ >(TypeParams, true), /*isVarArg*/ false);
        RTLFn = CGM.CreateRuntimeFunction(FnTy, new StringRef(/*KEEP_STR*/"__tgt_register_lib"));
        break;
      }
     case OMPRTL__tgt_unregister_lib:
      {
        // Build void __tgt_unregister_lib(__tgt_bin_desc *desc);
        QualType ParamTy = CGM.getContext().getPointerType(getTgtBinaryDescriptorQTy());
        org.llvm.ir.Type /*P*/ TypeParams[/*1*/] = new org.llvm.ir.Type /*P*/  [/*1*/] {CGM.getTypes().ConvertTypeForMem(new QualType(ParamTy))};
        org.llvm.ir.FunctionType /*P*/ FnTy = org.llvm.ir.FunctionType.get(CGM.Int32Ty, new ArrayRef<org.llvm.ir.Type /*P*/ >(TypeParams, true), /*isVarArg*/ false);
        RTLFn = CGM.CreateRuntimeFunction(FnTy, new StringRef(/*KEEP_STR*/"__tgt_unregister_lib"));
        break;
      }
     case OMPRTL__tgt_target_data_begin:
      {
        // Build void __tgt_target_data_begin(int32_t device_id, int32_t arg_num,
        // void** args_base, void **args, size_t *arg_sizes, int32_t *arg_types);
        org.llvm.ir.Type /*P*/ TypeParams[/*6*/] = new org.llvm.ir.Type /*P*/  [/*6*/] {
          CGM.Int32Ty, 
          CGM.Int32Ty, 
          CGM.Unnamed_field10.VoidPtrPtrTy, 
          CGM.Unnamed_field10.VoidPtrPtrTy, 
          CGM.Unnamed_field8.SizeTy.getPointerTo(), 
          CGM.Int32Ty.getPointerTo()};
        org.llvm.ir.FunctionType /*P*/ FnTy = org.llvm.ir.FunctionType.get(CGM.VoidTy, new ArrayRef<org.llvm.ir.Type /*P*/ >(TypeParams, true), /*isVarArg*/ false);
        RTLFn = CGM.CreateRuntimeFunction(FnTy, new StringRef(/*KEEP_STR*/"__tgt_target_data_begin"));
        break;
      }
     case OMPRTL__tgt_target_data_end:
      {
        // Build void __tgt_target_data_end(int32_t device_id, int32_t arg_num,
        // void** args_base, void **args, size_t *arg_sizes, int32_t *arg_types);
        org.llvm.ir.Type /*P*/ TypeParams[/*6*/] = new org.llvm.ir.Type /*P*/  [/*6*/] {
          CGM.Int32Ty, 
          CGM.Int32Ty, 
          CGM.Unnamed_field10.VoidPtrPtrTy, 
          CGM.Unnamed_field10.VoidPtrPtrTy, 
          CGM.Unnamed_field8.SizeTy.getPointerTo(), 
          CGM.Int32Ty.getPointerTo()};
        org.llvm.ir.FunctionType /*P*/ FnTy = org.llvm.ir.FunctionType.get(CGM.VoidTy, new ArrayRef<org.llvm.ir.Type /*P*/ >(TypeParams, true), /*isVarArg*/ false);
        RTLFn = CGM.CreateRuntimeFunction(FnTy, new StringRef(/*KEEP_STR*/"__tgt_target_data_end"));
        break;
      }
     case OMPRTL__tgt_target_data_update:
      {
        // Build void __tgt_target_data_update(int32_t device_id, int32_t arg_num,
        // void** args_base, void **args, size_t *arg_sizes, int32_t *arg_types);
        org.llvm.ir.Type /*P*/ TypeParams[/*6*/] = new org.llvm.ir.Type /*P*/  [/*6*/] {
          CGM.Int32Ty, 
          CGM.Int32Ty, 
          CGM.Unnamed_field10.VoidPtrPtrTy, 
          CGM.Unnamed_field10.VoidPtrPtrTy, 
          CGM.Unnamed_field8.SizeTy.getPointerTo(), 
          CGM.Int32Ty.getPointerTo()};
        org.llvm.ir.FunctionType /*P*/ FnTy = org.llvm.ir.FunctionType.get(CGM.VoidTy, new ArrayRef<org.llvm.ir.Type /*P*/ >(TypeParams, true), /*isVarArg*/ false);
        RTLFn = CGM.CreateRuntimeFunction(FnTy, new StringRef(/*KEEP_STR*/"__tgt_target_data_update"));
        break;
      }
    }
    assert ((RTLFn != null)) : "Unable to find OpenMP runtime function";
    return RTLFn;
  }

  
  /// \brief Returns __kmpc_for_static_init_* runtime function for the specified
  /// size \a IVSize and sign \a IVSigned.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGOpenMPRuntime::createForStaticInitFunction">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp", line = 1636,
   FQN="clang::CodeGen::CGOpenMPRuntime::createForStaticInitFunction", NM="_ZN5clang7CodeGen15CGOpenMPRuntime27createForStaticInitFunctionEjb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp -nm=_ZN5clang7CodeGen15CGOpenMPRuntime27createForStaticInitFunctionEjb")
  //</editor-fold>
  private Constant /*P*/ createForStaticInitFunction(/*uint*/int IVSize, 
                             boolean IVSigned) {
    assert ((IVSize == 32 || IVSize == 64)) : "IV size is not compatible with the omp runtime";
    /*const*/char$ptr/*char P*/ Name = $tryClone(IVSize == 32 ? (IVSigned ? $("__kmpc_for_static_init_4") : $("__kmpc_for_static_init_4u")) : (IVSigned ? $("__kmpc_for_static_init_8") : $("__kmpc_for_static_init_8u")));
    IntegerType /*P*/ ITy = IVSize == 32 ? CGM.Int32Ty : CGM.Int64Ty;
    org.llvm.ir.PointerType /*P*/ PtrTy = org.llvm.ir.PointerType.getUnqual(ITy);
    org.llvm.ir.Type /*P*/ TypeParams[/*9*/] = new org.llvm.ir.Type /*P*/  [/*9*/] {
      getIdentTyPointerTy(),  // loc
      CGM.Int32Ty,  // tid
      CGM.Int32Ty,  // schedtype
      org.llvm.ir.PointerType.getUnqual(CGM.Int32Ty),  // p_lastiter
      PtrTy,  // p_lower
      PtrTy,  // p_upper
      PtrTy,  // p_stride
      ITy,  // incr
      ITy // chunk
    };
    org.llvm.ir.FunctionType /*P*/ FnTy = org.llvm.ir.FunctionType.get(CGM.VoidTy, new ArrayRef<org.llvm.ir.Type /*P*/ >(TypeParams, true), /*isVarArg*/ false);
    return CGM.CreateRuntimeFunction(FnTy, new StringRef(Name));
  }

  
  /// \brief Returns __kmpc_dispatch_init_* runtime function for the specified
  /// size \a IVSize and sign \a IVSigned.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGOpenMPRuntime::createDispatchInitFunction">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp", line = 1662,
   FQN="clang::CodeGen::CGOpenMPRuntime::createDispatchInitFunction", NM="_ZN5clang7CodeGen15CGOpenMPRuntime26createDispatchInitFunctionEjb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp -nm=_ZN5clang7CodeGen15CGOpenMPRuntime26createDispatchInitFunctionEjb")
  //</editor-fold>
  private Constant /*P*/ createDispatchInitFunction(/*uint*/int IVSize, 
                            boolean IVSigned) {
    assert ((IVSize == 32 || IVSize == 64)) : "IV size is not compatible with the omp runtime";
    /*const*/char$ptr/*char P*/ Name = $tryClone(IVSize == 32 ? (IVSigned ? $("__kmpc_dispatch_init_4") : $("__kmpc_dispatch_init_4u")) : (IVSigned ? $("__kmpc_dispatch_init_8") : $("__kmpc_dispatch_init_8u")));
    IntegerType /*P*/ ITy = IVSize == 32 ? CGM.Int32Ty : CGM.Int64Ty;
    org.llvm.ir.Type /*P*/ TypeParams[/*7*/] = new org.llvm.ir.Type /*P*/  [/*7*/] {
      getIdentTyPointerTy(),  // loc
      CGM.Int32Ty,  // tid
      CGM.Int32Ty,  // schedtype
      ITy,  // lower
      ITy,  // upper
      ITy,  // stride
      ITy // chunk
    };
    org.llvm.ir.FunctionType /*P*/ FnTy = org.llvm.ir.FunctionType.get(CGM.VoidTy, new ArrayRef<org.llvm.ir.Type /*P*/ >(TypeParams, true), /*isVarArg*/ false);
    return CGM.CreateRuntimeFunction(FnTy, new StringRef(Name));
  }

  
  /// \brief Returns __kmpc_dispatch_next_* runtime function for the specified
  /// size \a IVSize and sign \a IVSigned.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGOpenMPRuntime::createDispatchNextFunction">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp", line = 1701,
   FQN="clang::CodeGen::CGOpenMPRuntime::createDispatchNextFunction", NM="_ZN5clang7CodeGen15CGOpenMPRuntime26createDispatchNextFunctionEjb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp -nm=_ZN5clang7CodeGen15CGOpenMPRuntime26createDispatchNextFunctionEjb")
  //</editor-fold>
  private Constant /*P*/ createDispatchNextFunction(/*uint*/int IVSize, 
                            boolean IVSigned) {
    assert ((IVSize == 32 || IVSize == 64)) : "IV size is not compatible with the omp runtime";
    /*const*/char$ptr/*char P*/ Name = $tryClone(IVSize == 32 ? (IVSigned ? $("__kmpc_dispatch_next_4") : $("__kmpc_dispatch_next_4u")) : (IVSigned ? $("__kmpc_dispatch_next_8") : $("__kmpc_dispatch_next_8u")));
    IntegerType /*P*/ ITy = IVSize == 32 ? CGM.Int32Ty : CGM.Int64Ty;
    org.llvm.ir.PointerType /*P*/ PtrTy = org.llvm.ir.PointerType.getUnqual(ITy);
    org.llvm.ir.Type /*P*/ TypeParams[/*6*/] = new org.llvm.ir.Type /*P*/  [/*6*/] {
      getIdentTyPointerTy(),  // loc
      CGM.Int32Ty,  // tid
      org.llvm.ir.PointerType.getUnqual(CGM.Int32Ty),  // p_lastiter
      PtrTy,  // p_lower
      PtrTy,  // p_upper
      PtrTy // p_stride
    };
    org.llvm.ir.FunctionType /*P*/ FnTy = org.llvm.ir.FunctionType.get(CGM.Int32Ty, new ArrayRef<org.llvm.ir.Type /*P*/ >(TypeParams, true), /*isVarArg*/ false);
    return CGM.CreateRuntimeFunction(FnTy, new StringRef(Name));
  }

  
  /// \brief Returns __kmpc_dispatch_fini_* runtime function for the specified
  /// size \a IVSize and sign \a IVSigned.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGOpenMPRuntime::createDispatchFiniFunction">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp", line = 1684,
   FQN="clang::CodeGen::CGOpenMPRuntime::createDispatchFiniFunction", NM="_ZN5clang7CodeGen15CGOpenMPRuntime26createDispatchFiniFunctionEjb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp -nm=_ZN5clang7CodeGen15CGOpenMPRuntime26createDispatchFiniFunctionEjb")
  //</editor-fold>
  private Constant /*P*/ createDispatchFiniFunction(/*uint*/int IVSize, 
                            boolean IVSigned) {
    assert ((IVSize == 32 || IVSize == 64)) : "IV size is not compatible with the omp runtime";
    /*const*/char$ptr/*char P*/ Name = $tryClone(IVSize == 32 ? (IVSigned ? $("__kmpc_dispatch_fini_4") : $("__kmpc_dispatch_fini_4u")) : (IVSigned ? $("__kmpc_dispatch_fini_8") : $("__kmpc_dispatch_fini_8u")));
    org.llvm.ir.Type /*P*/ TypeParams[/*2*/] = new org.llvm.ir.Type /*P*/  [/*2*/] {
      getIdentTyPointerTy(),  // loc
      CGM.Int32Ty // tid
    };
    org.llvm.ir.FunctionType /*P*/ FnTy = org.llvm.ir.FunctionType.get(CGM.VoidTy, new ArrayRef<org.llvm.ir.Type /*P*/ >(TypeParams, true), /*isVarArg=*/ false);
    return CGM.CreateRuntimeFunction(FnTy, new StringRef(Name));
  }

  
  /// \brief If the specified mangled name is not in the module, create and
  /// return threadprivate cache object. This object is a pointer's worth of
  /// storage that's reserved for use by the OpenMP runtime.
  /// \param VD Threadprivate variable.
  /// \return Cache variable for the specified threadprivate.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGOpenMPRuntime::getOrCreateThreadPrivateCache">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp", line = 1724,
   FQN="clang::CodeGen::CGOpenMPRuntime::getOrCreateThreadPrivateCache", NM="_ZN5clang7CodeGen15CGOpenMPRuntime29getOrCreateThreadPrivateCacheEPKNS_7VarDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp -nm=_ZN5clang7CodeGen15CGOpenMPRuntime29getOrCreateThreadPrivateCacheEPKNS_7VarDeclE")
  //</editor-fold>
  private Constant /*P*/ getOrCreateThreadPrivateCache(/*const*/ VarDecl /*P*/ VD) {
    assert (!CGM.getLangOpts().OpenMPUseTLS || !CGM.getContext().getTargetInfo().isTLSSupported());
    // Lookup the entry, lazily creating it if necessary.
    return getOrCreateInternalVariable(CGM.Unnamed_field10.Int8PtrPtrTy, 
        $add_Twine$C(new Twine(CGM.getMangledName(new GlobalDecl(VD))), new Twine(/*KEEP_STR*/".cache.")));
  }

  
  /// \brief Emits address of the word in a memory where current thread id is
  /// stored.
  
  // If we're inside an (outlined) parallel region, use the region info's
  // thread-ID variable (it is passed in a first argument of the outlined function
  // as "kmp_int32 *gtid"). Otherwise, if we're not inside parallel region, but in
  // regular serial code region, get thread ID by calling kmp_int32
  // kmpc_global_thread_num(ident_t *loc), stash this thread ID in a temporary and
  // return the address of that temp.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGOpenMPRuntime::emitThreadIDAddress">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp", line = 1995,
   FQN="clang::CodeGen::CGOpenMPRuntime::emitThreadIDAddress", NM="_ZN5clang7CodeGen15CGOpenMPRuntime19emitThreadIDAddressERNS0_15CodeGenFunctionENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp -nm=_ZN5clang7CodeGen15CGOpenMPRuntime19emitThreadIDAddressERNS0_15CodeGenFunctionENS_14SourceLocationE")
  //</editor-fold>
  protected/*private*/ Address emitThreadIDAddress(final CodeGenFunction /*&*/ CGF, 
                     SourceLocation Loc) {
    {
      CGOpenMPRegionInfo /*P*/ OMPRegionInfo = dyn_cast_or_null_CGOpenMPRegionInfo(CGF.CapturedStmtInfo);
      if ((OMPRegionInfo != null)) {
        if ((OMPRegionInfo.getThreadIDVariable() != null)) {
          return OMPRegionInfo.getThreadIDVariableLValue(CGF).getAddress();
        }
      }
    }
    
    Value /*P*/ ThreadID = getThreadID(CGF, new SourceLocation(Loc));
    QualType Int32Ty = CGF.getContext().getIntTypeForBitwidth(/*DestWidth*/ 32, /*Signed*/ /*true*/1);
    Address ThreadIDTemp = CGF.CreateMemTemp(new QualType(Int32Ty), /*Name*/ new Twine(/*KEEP_STR*/".threadid_temp."));
    CGF.EmitStoreOfScalar(ThreadID, 
        CGF.MakeAddrLValue(new Address(ThreadIDTemp), new QualType(Int32Ty)));
    
    return ThreadIDTemp;
  }

  
  /// \brief Gets thread id value for the current thread.
  ///
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGOpenMPRuntime::getThreadID">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp", line = 984,
   FQN="clang::CodeGen::CGOpenMPRuntime::getThreadID", NM="_ZN5clang7CodeGen15CGOpenMPRuntime11getThreadIDERNS0_15CodeGenFunctionENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp -nm=_ZN5clang7CodeGen15CGOpenMPRuntime11getThreadIDERNS0_15CodeGenFunctionENS_14SourceLocationE")
  //</editor-fold>
  private Value /*P*/ getThreadID(final CodeGenFunction /*&*/ CGF, 
             SourceLocation Loc) {
    CGBuilderTy.InsertPointGuard IPG = null;
    try {
      assert ((CGF.CurFn != null)) : "No function in current CodeGenFunction.";
      
      Value /*P*/ ThreadID = null;
      // Check whether we've already cached a load of the thread id in this
      // function.
      DenseMapIterator<Function /*P*/ , DebugLocThreadIdTy> I = OpenMPLocThreadIDMap.find(CGF.CurFn);
      if (I.$noteq(/*NO_ITER_COPY*/OpenMPLocThreadIDMap.end())) {
        ThreadID = I.$arrow().second.ThreadID;
        if (ThreadID != null) {
          return ThreadID;
        }
      }
      {
        CGOpenMPRegionInfo /*P*/ OMPRegionInfo = dyn_cast_or_null_CGOpenMPRegionInfo(CGF.CapturedStmtInfo);
        if ((OMPRegionInfo != null)) {
          if ((OMPRegionInfo.getThreadIDVariable() != null)) {
            // Check if this an outlined function with thread id passed as argument.
            LValue LVal = OMPRegionInfo.getThreadIDVariableLValue(CGF);
            ThreadID = CGF.EmitLoadOfLValue(new LValue(LVal), new SourceLocation(Loc)).getScalarVal();
            // If value loaded in entry block, cache it and use it everywhere in
            // function.
            if (CGF.Builder.GetInsertBlock() == CGF.AllocaInsertPt.$arrow_AssertingVH().getParent()) {
              final std.pair<Function /*P*/ , DebugLocThreadIdTy> /*&*/ Elem = OpenMPLocThreadIDMap.FindAndConstruct(CGF.CurFn);
              Elem.second.ThreadID = ThreadID;
            }
            return ThreadID;
          }
        }
      }
      
      // This is not an outlined function region - need to call __kmpc_int32
      // kmpc_global_thread_num(ident_t *loc).
      // Generate thread id value and cache this value for use across the
      // function.
      IPG/*J*/= new CGBuilderTy.InsertPointGuard(CGF.Builder);
      CGF.Builder.SetInsertPoint(CGF.AllocaInsertPt.$T$P());
      ThreadID
         = CGF.EmitRuntimeCall(createRuntimeFunction(OpenMPRTLFunction.OMPRTL__kmpc_global_thread_num.getValue()), 
          new ArrayRef<Value /*P*/ >(emitUpdateLocation(CGF, new SourceLocation(Loc)), true));
      final std.pair<Function /*P*/ , DebugLocThreadIdTy> /*&*/ Elem = OpenMPLocThreadIDMap.FindAndConstruct(CGF.CurFn);
      Elem.second.ThreadID = ThreadID;
      return ThreadID;
    } finally {
      if (IPG != null) { IPG.$destroy(); }
    }
  }

  
  /// \brief Gets (if variable with the given name already exist) or creates
  /// internal global variable with the specified Name. The created variable has
  /// linkage CommonLinkage by default and is initialized by null value.
  /// \param Ty Type of the global variable. If it is exist already the type
  /// must be the same.
  /// \param Name Name of the variable.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGOpenMPRuntime::getOrCreateInternalVariable">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*make_pair*/,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp", line = 2012,
   FQN="clang::CodeGen::CGOpenMPRuntime::getOrCreateInternalVariable", NM="_ZN5clang7CodeGen15CGOpenMPRuntime27getOrCreateInternalVariableEPN4llvm4TypeERKNS2_5TwineE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp -nm=_ZN5clang7CodeGen15CGOpenMPRuntime27getOrCreateInternalVariableEPN4llvm4TypeERKNS2_5TwineE")
  //</editor-fold>
  private Constant /*P*/ getOrCreateInternalVariable(org.llvm.ir.Type /*P*/ Ty, 
                             final /*const*/ Twine /*&*/ Name) {
    raw_svector_ostream Out = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      SmallString/*<256>*/ Buffer/*J*/= new SmallString/*<256>*/(256);
      Out/*J*/= new raw_svector_ostream(Buffer);
      $out_raw_ostream_Twine$C(Out, Name);
      StringRef RuntimeName = Out.str();
      final StringMapEntry<AssertingVH<Constant> > /*&*/ Elem = $c$.clean(InternalVars.insert($c$.track(std.make_pair_T_nullptr_t2T(RuntimeName, new AssertingVH<Constant>((Constant)null)))).first.$star());
      if (((Elem.second.$T$P()) != null)) {
        assert (Elem.second.$arrow_AssertingVH().getType().getPointerElementType() == Ty) : "OMP internal variable has different type than requested";
        return $AddrOf(Elem.second.$star_AssertingVH());
      }
      
      return Elem.second.$assign_ValueTy(/*NEW_EXPR [GlobalVariable::new]*/GlobalVariable.$new_GlobalVariable((type$ptr<?> New$Mem)->{
              return new GlobalVariable(CGM.getModule(), Ty, /*IsConstant*/ false, 
                      GlobalValue.LinkageTypes.CommonLinkage, Constant.getNullValue(Ty), 
                      new Twine(Elem.first()));
           }));
    } finally {
      if (Out != null) { Out.$destroy(); }
      $c$.$destroy();
    }
  }

  
  /// \brief Set of threadprivate variables with the generated initializer.
  private SmallPtrSet</*const*/ VarDecl /*P*/ > ThreadPrivateWithDefinition;
  
  /// \brief Emits initialization code for the threadprivate variables.
  /// \param VDAddr Address of the global variable \a VD.
  /// \param Ctor Pointer to a global init function for \a VD.
  /// \param CopyCtor Pointer to a global copy function for \a VD.
  /// \param Dtor Pointer to a global destructor function for \a VD.
  /// \param Loc Location of threadprivate declaration.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGOpenMPRuntime::emitThreadPrivateVarInit">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp", line = 1752,
   FQN="clang::CodeGen::CGOpenMPRuntime::emitThreadPrivateVarInit", NM="_ZN5clang7CodeGen15CGOpenMPRuntime24emitThreadPrivateVarInitERNS0_15CodeGenFunctionENS0_7AddressEPN4llvm5ValueES7_S7_NS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp -nm=_ZN5clang7CodeGen15CGOpenMPRuntime24emitThreadPrivateVarInitERNS0_15CodeGenFunctionENS0_7AddressEPN4llvm5ValueES7_S7_NS_14SourceLocationE")
  //</editor-fold>
  private void emitThreadPrivateVarInit(final CodeGenFunction /*&*/ CGF, Address VDAddr, Value /*P*/ Ctor, 
                          Value /*P*/ CopyCtor, Value /*P*/ Dtor, SourceLocation Loc) {
    // Call kmp_int32 __kmpc_global_thread_num(&loc) to init OpenMP runtime
    // library.
    Value /*P*/ OMPLoc = emitUpdateLocation(CGF, new SourceLocation(Loc));
    CGF.EmitRuntimeCall(createRuntimeFunction(OpenMPRTLFunction.OMPRTL__kmpc_global_thread_num.getValue()), 
        new ArrayRef<Value /*P*/ >(OMPLoc, true));
    // Call __kmpc_threadprivate_register(&loc, &var, ctor, cctor/*NULL*/, dtor)
    // to register constructor/destructor for variable.
    Value /*P*/ Args[/*5*/] = new Value /*P*/  [/*5*/] {
      OMPLoc, 
      CGF.Builder.CreatePointerCast(VDAddr.getPointer(), 
          CGM.Unnamed_field9.VoidPtrTy), 
      Ctor, CopyCtor, Dtor};
    CGF.EmitRuntimeCall(createRuntimeFunction(OpenMPRTLFunction.OMPRTL__kmpc_threadprivate_register.getValue()), new ArrayRef<Value /*P*/ >(Args, true));
  }

  
  /// \brief Returns corresponding lock object for the specified critical region
  /// name. If the lock object does not exist it is created, otherwise the
  /// reference to the existing copy is returned.
  /// \param CriticalName Name of the critical region.
  ///
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGOpenMPRuntime::getCriticalRegionLock">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp", line = 2032,
   FQN="clang::CodeGen::CGOpenMPRuntime::getCriticalRegionLock", NM="_ZN5clang7CodeGen15CGOpenMPRuntime21getCriticalRegionLockEN4llvm9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp -nm=_ZN5clang7CodeGen15CGOpenMPRuntime21getCriticalRegionLockEN4llvm9StringRefE")
  //</editor-fold>
  private Value /*P*/ getCriticalRegionLock(StringRef CriticalName) {
    Twine Name/*J*/= new Twine(/*KEEP_STR*/".gomp_critical_user_", CriticalName);
    return getOrCreateInternalVariable(KmpCriticalNameTy, Name.concat(new Twine(/*KEEP_STR*/".var")));
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGOpenMPRuntime::TaskResultTy">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.h", line = 460,
   FQN="clang::CodeGen::CGOpenMPRuntime::TaskResultTy", NM="_ZN5clang7CodeGen15CGOpenMPRuntime12TaskResultTyE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp -nm=_ZN5clang7CodeGen15CGOpenMPRuntime12TaskResultTyE")
  //</editor-fold>
  private static class/*struct*/ TaskResultTy {
    public Value /*P*/ NewTask/* = null*/;
    public Value /*P*/ TaskEntry/* = null*/;
    public Value /*P*/ NewTaskNewTaskTTy/* = null*/;
    public LValue TDBase;
    public RecordDecl /*P*/ KmpTaskTQTyRD/* = null*/;
    public Value /*P*/ TaskDupFn/* = null*/;
    //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGOpenMPRuntime::TaskResultTy::TaskResultTy">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.h", line = 460,
     FQN="clang::CodeGen::CGOpenMPRuntime::TaskResultTy::TaskResultTy", NM="_ZN5clang7CodeGen15CGOpenMPRuntime12TaskResultTyC1Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp -nm=_ZN5clang7CodeGen15CGOpenMPRuntime12TaskResultTyC1Ev")
    //</editor-fold>
    public /*inline*/ TaskResultTy() {
      // : NewTask(null), TaskEntry(null), NewTaskNewTaskTTy(null), TDBase(), KmpTaskTQTyRD(null), TaskDupFn(null) 
      //START JInit
      /*InClass*/this.NewTask = null;
      /*InClass*/this.TaskEntry = null;
      /*InClass*/this.NewTaskNewTaskTTy = null;
      this.TDBase = new LValue();
      /*InClass*/this.KmpTaskTQTyRD = null;
      /*InClass*/this.TaskDupFn = null;
      //END JInit
    }

    //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGOpenMPRuntime::TaskResultTy::TaskResultTy">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.h", line = 460,
     FQN="clang::CodeGen::CGOpenMPRuntime::TaskResultTy::TaskResultTy", NM="_ZN5clang7CodeGen15CGOpenMPRuntime12TaskResultTyC1EOS2_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp -nm=_ZN5clang7CodeGen15CGOpenMPRuntime12TaskResultTyC1EOS2_")
    //</editor-fold>
    public /*inline*/ TaskResultTy(JD$Move _dparam, final TaskResultTy /*&&*/$Prm0) {
      // : NewTask(static_cast<TaskResultTy &&>().NewTask), TaskEntry(static_cast<TaskResultTy &&>().TaskEntry), NewTaskNewTaskTTy(static_cast<TaskResultTy &&>().NewTaskNewTaskTTy), TDBase(static_cast<TaskResultTy &&>().TDBase), KmpTaskTQTyRD(static_cast<TaskResultTy &&>().KmpTaskTQTyRD), TaskDupFn(static_cast<TaskResultTy &&>().TaskDupFn) 
      //START JInit
      this.NewTask = $Prm0.NewTask;
      this.TaskEntry = $Prm0.TaskEntry;
      this.NewTaskNewTaskTTy = $Prm0.NewTaskNewTaskTTy;
      this.TDBase = new LValue(JD$Move.INSTANCE, $Prm0.TDBase);
      this.KmpTaskTQTyRD = $Prm0.KmpTaskTQTyRD;
      this.TaskDupFn = $Prm0.TaskDupFn;
      //END JInit
    }

    
    @Override public String toString() {
      return "" + "NewTask=" + NewTask // NOI18N
                + ", TaskEntry=" + TaskEntry // NOI18N
                + ", NewTaskNewTaskTTy=" + NewTaskNewTaskTTy // NOI18N
                + ", TDBase=" + TDBase // NOI18N
                + ", KmpTaskTQTyRD=" + "[RecordDecl]" // NOI18N
                + ", TaskDupFn=" + TaskDupFn; // NOI18N
    }
  };
  /// Emit task region for the task directive. The task region is emitted in
  /// several steps:
  /// 1. Emit a call to kmp_task_t *__kmpc_omp_task_alloc(ident_t *, kmp_int32
  /// gtid, kmp_int32 flags, size_t sizeof_kmp_task_t, size_t sizeof_shareds,
  /// kmp_routine_entry_t *task_entry). Here task_entry is a pointer to the
  /// function:
  /// kmp_int32 .omp_task_entry.(kmp_int32 gtid, kmp_task_t *tt) {
  ///   TaskFunction(gtid, tt->part_id, tt->shareds);
  ///   return 0;
  /// }
  /// 2. Copy a list of shared variables to field shareds of the resulting
  /// structure kmp_task_t returned by the previous call (if any).
  /// 3. Copy a pointer to destructions function to field destructions of the
  /// resulting structure kmp_task_t.
  /// \param D Current task directive.
  /// \param TaskFunction An LLVM function with type void (*)(i32 /*gtid*/, i32
  /// /*part_id*/, captured_struct */*__context*/);
  /// \param SharedsTy A type which contains references the shared variables.
  /// \param Shareds Context with the list of shared variables from the \p
  /// TaskFunction.
  /// \param Data Additional data for task generation like tiednsee, final
  /// state, list of privates etc.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGOpenMPRuntime::emitTaskInit">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp", line = 3681,
   FQN="clang::CodeGen::CGOpenMPRuntime::emitTaskInit", NM="_ZN5clang7CodeGen15CGOpenMPRuntime12emitTaskInitERNS0_15CodeGenFunctionENS_14SourceLocationERKNS_22OMPExecutableDirectiveEPN4llvm5ValueENS_8QualTypeENS0_7AddressERKNS0_13OMPTaskDataTyE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp -nm=_ZN5clang7CodeGen15CGOpenMPRuntime12emitTaskInitERNS0_15CodeGenFunctionENS_14SourceLocationERKNS_22OMPExecutableDirectiveEPN4llvm5ValueENS_8QualTypeENS0_7AddressERKNS0_13OMPTaskDataTyE")
  //</editor-fold>
  private CGOpenMPRuntime.TaskResultTy emitTaskInit(final CodeGenFunction /*&*/ CGF, SourceLocation Loc, 
              final /*const*/ OMPExecutableDirective /*&*/ D, 
              Value /*P*/ TaskFunction, QualType SharedsTy, 
              Address Shareds, final /*const*/ OMPTaskDataTy /*&*/ Data) {
    final ASTContext /*&*/ C = CGM.getContext();
    SmallVector<std.pairTypeType<CharUnits, PrivateHelpersTy>> Privates/*J*/= new SmallVector<std.pairTypeType<CharUnits, PrivateHelpersTy>>(4, new std.pairTypeType<CharUnits, PrivateHelpersTy>(new CharUnits(), new PrivateHelpersTy()));
    // Aggregate privates and sort them by the alignment.
    type$ptr</*const*/ Expr /*P*/ /*const*/ /*P*/> I = $tryClone(Data.PrivateCopies.begin$Const());
    for (/*const*/ Expr /*P*/ E : Data.PrivateVars) {
      /*const*/ VarDecl /*P*/ VD = cast_VarDecl(cast_DeclRefExpr(E).getDecl$Const());
      Privates.push_back(std.make_pair($Move(C.getDeclAlign(VD)), 
              $Move(new PrivateHelpersTy(VD, cast_VarDecl(cast_DeclRefExpr(I.$star()).getDecl$Const()), 
                  /*PrivateElemInit=*/ (/*const*/ VarDecl /*P*/ )null))));
      I.$preInc();
    }
    I = $tryClone(Data.FirstprivateCopies.begin$Const());
    type$ptr</*const*/ Expr /*P*/ /*const*/ /*P*/> IElemInitRef = $tryClone(Data.FirstprivateInits.begin$Const());
    for (/*const*/ Expr /*P*/ E : Data.FirstprivateVars) {
      /*const*/ VarDecl /*P*/ VD = cast_VarDecl(cast_DeclRefExpr(E).getDecl$Const());
      Privates.push_back(std.make_pair($Move(C.getDeclAlign(VD)), 
              $Move(new PrivateHelpersTy(VD, cast_VarDecl(cast_DeclRefExpr(I.$star()).getDecl$Const()), 
                  cast_VarDecl(cast_DeclRefExpr(IElemInitRef.$star()).getDecl$Const())))));
      I.$preInc();
      IElemInitRef.$preInc();
    }
    I = $tryClone(Data.LastprivateCopies.begin$Const());
    for (/*const*/ Expr /*P*/ E : Data.LastprivateVars) {
      /*const*/ VarDecl /*P*/ VD = cast_VarDecl(cast_DeclRefExpr(E).getDecl$Const());
      Privates.push_back(std.make_pair($Move(C.getDeclAlign(VD)),
              $Move(new PrivateHelpersTy(VD, cast_VarDecl(cast_DeclRefExpr(I.$star()).getDecl$Const()), 
                  /*PrivateElemInit=*/ (/*const*/ VarDecl /*P*/ )null))));
      I.$preInc();
    }
    llvm.array_pod_sort(Privates.begin(), Privates.end(), 
        /*FuncRef*/CGOpenMPRuntimeStatics::array_pod_sort_comparator);
    QualType KmpInt32Ty = C.getIntTypeForBitwidth(/*DestWidth=*/ 32, /*Signed=*/ 1);
    // Build type kmp_routine_entry_t (if not built yet).
    emitKmpRoutineEntryT(new QualType(KmpInt32Ty));
    // Build type kmp_task_t (if not built yet).
    if (KmpTaskTQTy.isNull()) {
      KmpTaskTQTy.$assignMove(C.getRecordType(CGOpenMPRuntimeStatics.createKmpTaskTRecordDecl(CGM, D.getDirectiveKind(), new QualType(KmpInt32Ty), new QualType(KmpRoutineEntryPtrQTy))));
    }
    RecordDecl /*P*/ KmpTaskTQTyRD = cast_RecordDecl(KmpTaskTQTy.$arrow().getAsTagDecl());
    // Build particular struct kmp_task_t for the given task.
    RecordDecl /*P*/ KmpTaskTWithPrivatesQTyRD = CGOpenMPRuntimeStatics.createKmpTaskTWithPrivatesRecordDecl(CGM, new QualType(KmpTaskTQTy), new ArrayRef<std.pairTypeType<CharUnits, PrivateHelpersTy>>(Privates, false));
    QualType KmpTaskTWithPrivatesQTy = C.getRecordType(KmpTaskTWithPrivatesQTyRD);
    QualType KmpTaskTWithPrivatesPtrQTy = C.getPointerType(/*NO_COPY*/KmpTaskTWithPrivatesQTy);
    org.llvm.ir.Type /*P*/ KmpTaskTWithPrivatesTy = CGF.ConvertType(new QualType(KmpTaskTWithPrivatesQTy));
    org.llvm.ir.PointerType /*P*/ KmpTaskTWithPrivatesPtrTy = KmpTaskTWithPrivatesTy.getPointerTo();
    Value /*P*/ KmpTaskTWithPrivatesTySize = CGF.getTypeSize(new QualType(KmpTaskTWithPrivatesQTy));
    QualType SharedsPtrTy = C.getPointerType(/*NO_COPY*/SharedsTy);
    
    // Emit initial values for private copies (if any).
    Value /*P*/ TaskPrivatesMap = null;
    Type /*P*/ TaskPrivatesMapTy = std.next(cast_Function(TaskFunction).getArgumentList().begin(), 
        3).$arrow().
        getType();
    if (!Privates.empty()) {
      DeclContext.specific_decl_iterator<FieldDecl> FI = std.next(KmpTaskTWithPrivatesQTyRD.field_begin());
      TaskPrivatesMap = CGOpenMPRuntimeStatics.emitTaskPrivateMappingFunction(CGM, new SourceLocation(Loc), new ArrayRef</*const*/ Expr /*P*/ >(Data.PrivateVars, true), new ArrayRef</*const*/ Expr /*P*/ >(Data.FirstprivateVars, true), new ArrayRef</*const*/ Expr /*P*/ >(Data.LastprivateVars, true), 
          FI.$arrow().getType(), new ArrayRef<std.pairTypeType<CharUnits, PrivateHelpersTy>>(Privates, false));
      TaskPrivatesMap = CGF.Builder.CreatePointerBitCastOrAddrSpaceCast(TaskPrivatesMap, TaskPrivatesMapTy);
    } else {
      TaskPrivatesMap = ConstantPointerNull.get(cast_PointerType(TaskPrivatesMapTy));
    }
    // Build a proxy function kmp_int32 .omp_task_entry.(kmp_int32 gtid,
    // kmp_task_t *tt);
    Value /*P*/ TaskEntry = CGOpenMPRuntimeStatics.emitProxyTaskFunction(CGM, new SourceLocation(Loc), D.getDirectiveKind(), new QualType(KmpInt32Ty), new QualType(KmpTaskTWithPrivatesPtrQTy), 
        new QualType(KmpTaskTWithPrivatesQTy), new QualType(KmpTaskTQTy), new QualType(SharedsPtrTy), TaskFunction, 
        TaskPrivatesMap);
    
    // Build call kmp_task_t * __kmpc_omp_task_alloc(ident_t *, kmp_int32 gtid,
    // kmp_int32 flags, size_t sizeof_kmp_task_t, size_t sizeof_shareds,
    // kmp_routine_entry_t *task_entry);
    // Task flags. Format is taken from
    // http://llvm.org/svn/llvm-project/openmp/trunk/runtime/src/kmp.h,
    // description of kmp_tasking_flags struct.
    /*enum ANONYMOUS_INT_CONSTANTS {*/
      final /*uint*/int TiedFlag = 0x1;
      final /*uint*/int FinalFlag = 0x2;
      final /*uint*/int DestructorsFlag = 0x8;
      final /*uint*/int PriorityFlag = 0x20;
    /*}*/;
    /*uint*/int Flags = Data.Tied ? TiedFlag : 0;
    boolean NeedsCleanup = false;
    if (!Privates.empty()) {
      NeedsCleanup = CGOpenMPRuntimeStatics.checkDestructorsRequired(KmpTaskTWithPrivatesQTyRD);
      if (NeedsCleanup) {
        Flags = Flags | DestructorsFlag;
      }
    }
    if (Data.Priority.getInt()) {
      Flags = Flags | PriorityFlag;
    }
    Value /*P*/ TaskFlags = (Data.Final.getPointer() != null) ? CGF.Builder.CreateSelect(Data.Final.getPointer(), 
        CGF.Builder.getInt32(FinalFlag), 
        CGF.Builder.getInt32(/*C=*/ 0)) : CGF.Builder.getInt32(Data.Final.getInt() ? FinalFlag : 0);
    TaskFlags = CGF.Builder.CreateOr(TaskFlags, CGF.Builder.getInt32(Flags));
    ConstantInt /*P*/ SharedsSize = CGM.getSize(C.getTypeSizeInChars(/*NO_COPY*/SharedsTy));
    Value /*P*/ AllocArgs[/*6*/] = new Value /*P*/  [/*6*/] {
      emitUpdateLocation(CGF, new SourceLocation(Loc)), 
      getThreadID(CGF, new SourceLocation(Loc)), TaskFlags, 
      KmpTaskTWithPrivatesTySize, SharedsSize, 
      CGF.Builder.CreatePointerBitCastOrAddrSpaceCast(TaskEntry, KmpRoutineEntryPtrTy)
    };
    CallInst /*P*/ NewTask = CGF.EmitRuntimeCall(createRuntimeFunction(OpenMPRTLFunction.OMPRTL__kmpc_omp_task_alloc.getValue()), new ArrayRef<Value /*P*/ >(AllocArgs, true));
    Value /*P*/ NewTaskNewTaskTTy = CGF.Builder.CreatePointerBitCastOrAddrSpaceCast(NewTask, KmpTaskTWithPrivatesPtrTy);
    LValue Base = CGF.MakeNaturalAlignAddrLValue(NewTaskNewTaskTTy, 
        new QualType(KmpTaskTWithPrivatesQTy));
    LValue TDBase = CGF.EmitLValueForField(new LValue(Base), KmpTaskTWithPrivatesQTyRD.field_begin().$star());
    // Fill the data in the resulting kmp_task_t record.
    // Copy shareds if there are any.
    Address KmpTaskSharedsPtr = Address.invalid();
    if (!SharedsTy.$arrow().getAsStructureType().getDecl().field_empty()) {
      KmpTaskSharedsPtr.$assignMove(
          new Address(CGF.EmitLoadOfScalar(CGF.EmitLValueForField(new LValue(TDBase), std.next(KmpTaskTQTyRD.field_begin(), 
                          KmpTaskTFields.KmpTaskTShareds.getValue()).$star()), 
                  new SourceLocation(Loc)), 
              CGF.getNaturalTypeAlignment(new QualType(SharedsTy)))
      );
      CGF.EmitAggregateCopy(new Address(KmpTaskSharedsPtr), new Address(Shareds), new QualType(SharedsTy));
    }
    // Emit initial values for private copies (if any).
    TaskResultTy Result/*J*/= new TaskResultTy();
    if (!Privates.empty()) {
      CGOpenMPRuntimeStatics.emitPrivatesInit(CGF, D, new Address(KmpTaskSharedsPtr), new LValue(Base), KmpTaskTWithPrivatesQTyRD, 
          new QualType(SharedsTy), new QualType(SharedsPtrTy), Data, new ArrayRef<std.pairTypeType<CharUnits, PrivateHelpersTy>>(Privates, false), 
          /*ForDup=*/ false);
      if (isOpenMPTaskLoopDirective(D.getDirectiveKind())
         && (!Data.LastprivateVars.empty() || CGOpenMPRuntimeStatics.checkInitIsRequired(CGF, new ArrayRef<std.pairTypeType<CharUnits, PrivateHelpersTy>>(Privates, false)))) {
        Result.TaskDupFn = CGOpenMPRuntimeStatics.emitTaskDupFunction(CGM, new SourceLocation(Loc), D, new QualType(KmpTaskTWithPrivatesPtrQTy), KmpTaskTWithPrivatesQTyRD, 
            KmpTaskTQTyRD, new QualType(SharedsTy), new QualType(SharedsPtrTy), Data, new ArrayRef<std.pairTypeType<CharUnits, PrivateHelpersTy>>(Privates, false), 
            /*WithLastIter=*/ !Data.LastprivateVars.empty());
      }
    }
    // Fields of union "kmp_cmplrdata_t" for destructors and priority.
    /*enum ANONYMOUS_INT_CONSTANTS {*/
      final /*uint*/int Priority = 0;
      final /*uint*/int Destructors = 1;
    /*}*/;
    // Provide pointer to function with destructors for privates.
    DeclContext.specific_decl_iterator<FieldDecl> FI = std.next(KmpTaskTQTyRD.field_begin(), KmpTaskTFields.Data1.getValue());
    RecordDecl /*P*/ KmpCmplrdataUD = (FI.$star()).getType().$arrow().getAsUnionType().getDecl();
    if (NeedsCleanup) {
      Value /*P*/ DestructorFn = CGOpenMPRuntimeStatics.emitDestructorsFunction(CGM, new SourceLocation(Loc), new QualType(KmpInt32Ty), new QualType(KmpTaskTWithPrivatesPtrQTy), 
          new QualType(KmpTaskTWithPrivatesQTy));
      LValue Data1LV = CGF.EmitLValueForField(new LValue(TDBase), FI.$star());
      LValue DestructorsLV = CGF.EmitLValueForField(new LValue(Data1LV), std.next(KmpCmplrdataUD.field_begin(), Destructors).$star());
      CGF.EmitStoreOfScalar(CGF.Builder.CreatePointerBitCastOrAddrSpaceCast(DestructorFn, KmpRoutineEntryPtrTy), 
          new LValue(DestructorsLV));
    }
    // Set priority.
    if (Data.Priority.getInt()) {
      LValue Data2LV = CGF.EmitLValueForField(new LValue(TDBase), std.next(KmpTaskTQTyRD.field_begin(), KmpTaskTFields.Data2.getValue()).$star());
      LValue PriorityLV = CGF.EmitLValueForField(new LValue(Data2LV), std.next(KmpCmplrdataUD.field_begin(), Priority).$star());
      CGF.EmitStoreOfScalar(Data.Priority.getPointer(), new LValue(PriorityLV));
    }
    Result.NewTask = NewTask;
    Result.TaskEntry = TaskEntry;
    Result.NewTaskNewTaskTTy = NewTaskNewTaskTTy;
    Result.TDBase.$assign(TDBase);
    Result.KmpTaskTQTyRD = KmpTaskTQTyRD;
    return Result;
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGOpenMPRuntime::CGOpenMPRuntime">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp", line = 723,
   FQN="clang::CodeGen::CGOpenMPRuntime::CGOpenMPRuntime", NM="_ZN5clang7CodeGen15CGOpenMPRuntimeC1ERNS0_13CodeGenModuleE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp -nm=_ZN5clang7CodeGen15CGOpenMPRuntimeC1ERNS0_13CodeGenModuleE")
  //</editor-fold>
  public CGOpenMPRuntime(final CodeGenModule /*&*/ CGM) {
    // : CGM(CGM), DefaultOpenMPPSource(null), OpenMPDefaultLocMap(), IdentTy(null), OpenMPDebugLocMap(), Kmpc_MicroTy(null), OpenMPLocThreadIDMap(), UDRMap(), FunctionUDRMap(), In(null), Out(null), Priv(null), Orig(null), InternalVars(), KmpRoutineEntryPtrTy(null), KmpRoutineEntryPtrQTy(), KmpTaskTQTy(), KmpDependInfoTy(), KmpDimTy(), TgtOffloadEntryQTy(), TgtDeviceImageQTy(), TgtBinaryDescriptorQTy(), OffloadEntriesInfoManager(CGM), ThreadPrivateWithDefinition() 
    //START JInit
    this./*&*/CGM=/*&*/CGM;
    /*InClass*/this.DefaultOpenMPPSource = null;
    this.OpenMPDefaultLocMap = new DenseMapUIntType<Value /*P*/ >(DenseMapInfoUInt.$Info(), (Value /*P*/ )null);
    /*InClass*/this.IdentTy = null;
    this.OpenMPDebugLocMap = new DenseMapUIntType<Value /*P*/ >(DenseMapInfoUInt.$Info(), (Value /*P*/ )null);
    /*InClass*/this.Kmpc_MicroTy = null;
    this.OpenMPLocThreadIDMap = new DenseMap<Function /*P*/ , DebugLocThreadIdTy>(DenseMapInfo$LikePtr.$Info(), new DebugLocThreadIdTy());
    this.UDRMap = new DenseMap</*const*/ OMPDeclareReductionDecl /*P*/ , std.pair<Function /*P*/ , Function /*P*/ >>(DenseMapInfo$LikePtr.$Info(), new std.pairPtrPtr<Function /*P*/ , Function /*P*/ >());
    this.FunctionUDRMap = new DenseMap<Function /*P*/ , SmallVector</*const*/ OMPDeclareReductionDecl /*P*/ >>(DenseMapInfo$LikePtr.$Info(),
            new SmallVector</*const*/ OMPDeclareReductionDecl /*P*/ >(4, (OMPDeclareReductionDecl/*P*/)null));
    /*InClass*/this.In = null;
    /*InClass*/this.Out = null;
    /*InClass*/this.Priv = null;
    /*InClass*/this.Orig = null;
    this.InternalVars = new StringMap<AssertingVH<Constant>/*, BumpPtrAllocatorImpl*/>(new AssertingVH<Constant>());
    /*InClass*/this.KmpRoutineEntryPtrTy = null;
    this.KmpRoutineEntryPtrQTy = new QualType();
    this.KmpTaskTQTy = new QualType();
    this.KmpDependInfoTy = new QualType();
    this.KmpDimTy = new QualType();
    this.TgtOffloadEntryQTy = new QualType();
    this.TgtDeviceImageQTy = new QualType();
    this.TgtBinaryDescriptorQTy = new QualType();
    this.OffloadEntriesInfoManager = new OffloadEntriesInfoManagerTy(CGM);
    this.ThreadPrivateWithDefinition = new SmallPtrSet</*const*/ VarDecl /*P*/ >(DenseMapInfo$LikePtr.$Info(), 4);
    //END JInit
    IdentTy = StructType.create(new StringRef(/*KEEP_STR*/"ident_t"), CGM.Int32Ty/* reserved_1 */, CGM.Int32Ty/* flags */, 
        CGM.Int32Ty/* reserved_2 */, CGM.Int32Ty/* reserved_3 */, 
        CGM.Unnamed_field9/* psource */.Int8PtrTy, null);
    KmpCriticalNameTy = org.llvm.ir.ArrayType.get(CGM.Int32Ty, /*NumElements*/ $int2ulong(8));
    
    loadOffloadInfoMetadata();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGOpenMPRuntime::~CGOpenMPRuntime">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.h", line = 497,
   FQN="clang::CodeGen::CGOpenMPRuntime::~CGOpenMPRuntime", NM="_ZN5clang7CodeGen15CGOpenMPRuntimeD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp -nm=_ZN5clang7CodeGen15CGOpenMPRuntimeD0Ev")
  //</editor-fold>
  public /*virtual*/ void $destroy() {
    //START JDestroy
    ThreadPrivateWithDefinition.$destroy();
    OffloadEntriesInfoManager.$destroy();
    InternalVars.$destroy();
    FunctionUDRMap.$destroy();
    UDRMap.$destroy();
    OpenMPLocThreadIDMap.$destroy();
    OpenMPDebugLocMap.$destroy();
    OpenMPDefaultLocMap.$destroy();
    //END JDestroy
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGOpenMPRuntime::clear">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp", line = 734,
   FQN="clang::CodeGen::CGOpenMPRuntime::clear", NM="_ZN5clang7CodeGen15CGOpenMPRuntime5clearEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp -nm=_ZN5clang7CodeGen15CGOpenMPRuntime5clearEv")
  //</editor-fold>
  public void clear() {
    InternalVars.clear();
  }

  
  /// Emit code for the specified user defined reduction construct.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGOpenMPRuntime::emitUserDefinedReduction">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp", line = 782,
   FQN="clang::CodeGen::CGOpenMPRuntime::emitUserDefinedReduction", NM="_ZN5clang7CodeGen15CGOpenMPRuntime24emitUserDefinedReductionEPNS0_15CodeGenFunctionEPKNS_23OMPDeclareReductionDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp -nm=_ZN5clang7CodeGen15CGOpenMPRuntime24emitUserDefinedReductionEPNS0_15CodeGenFunctionEPKNS_23OMPDeclareReductionDeclE")
  //</editor-fold>
  public void emitUserDefinedReduction(CodeGenFunction /*P*/ CGF, /*const*/ OMPDeclareReductionDecl /*P*/ D) {
    if ($greater_uint(UDRMap.count(D), 0)) {
      return;
    }
    final ASTContext /*&*/ C = CGM.getContext();
    if (!(In != null) || !(Out != null)) {
      In = $AddrOf(C.Idents.get(new StringRef(/*KEEP_STR*/"omp_in")));
      Out = $AddrOf(C.Idents.get(new StringRef(/*KEEP_STR*/"omp_out")));
    }
    Function /*P*/ Combiner = CGOpenMPRuntimeStatics.emitCombinerOrInitializer(CGM, D.getType(), D.getCombiner$Const(), cast_VarDecl(D.lookup(new DeclarationName(In)).front()), 
        cast_VarDecl(D.lookup(new DeclarationName(Out)).front()), 
        /*IsCombiner=*/ true);
    Function /*P*/ Initializer = null;
    {
      /*const*/ Expr /*P*/ Init = D.getInitializer$Const();
      if ((Init != null)) {
        if (!(Priv != null) || !(Orig != null)) {
          Priv = $AddrOf(C.Idents.get(new StringRef(/*KEEP_STR*/"omp_priv")));
          Orig = $AddrOf(C.Idents.get(new StringRef(/*KEEP_STR*/"omp_orig")));
        }
        Initializer = CGOpenMPRuntimeStatics.emitCombinerOrInitializer(CGM, D.getType(), Init, cast_VarDecl(D.lookup(new DeclarationName(Orig)).front()), 
            cast_VarDecl(D.lookup(new DeclarationName(Priv)).front()), 
            /*IsCombiner=*/ false);
      }
    }
    UDRMap.insert_pair$KeyT$ValueT(std.make_pair_Ptr_T(D, $Move(std.make_pair_Ptr_Ptr(Combiner, Initializer))));
    if ((CGF != null)) {
      final std.pair<Function /*P*/ , SmallVector</*const*/ OMPDeclareReductionDecl /*P*/ >> /*&*/ Decls = FunctionUDRMap.FindAndConstruct(CGF.CurFn);
      Decls.second.push_back(D);
    }
  }

  /// Get combiner/initializer for the specified user-defined reduction, if any.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGOpenMPRuntime::getUserDefinedReduction">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp", line = 813,
   FQN="clang::CodeGen::CGOpenMPRuntime::getUserDefinedReduction", NM="_ZN5clang7CodeGen15CGOpenMPRuntime23getUserDefinedReductionEPKNS_23OMPDeclareReductionDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp -nm=_ZN5clang7CodeGen15CGOpenMPRuntime23getUserDefinedReductionEPKNS_23OMPDeclareReductionDeclE")
  //</editor-fold>
  public std.pair<Function /*P*/ , Function /*P*/ > getUserDefinedReduction(/*const*/ OMPDeclareReductionDecl /*P*/ D) {
    DenseMapIterator</*const*/ OMPDeclareReductionDecl /*P*/ , std.pair<Function /*P*/ , Function /*P*/ >> I = UDRMap.find(D);
    if (I.$noteq(/*NO_ITER_COPY*/UDRMap.end())) {
      return new std.pairPtrPtr<Function /*P*/ , Function /*P*/ >(I.$arrow().second);
    }
    emitUserDefinedReduction(/*CGF=*/ (CodeGenFunction /*P*/ )null, D);
    return UDRMap.lookup(D);
  }

  /// \brief Emits outlined function for the specified OpenMP parallel directive
  /// \a D. This outlined function has type void(*)(kmp_int32 *ThreadID,
  /// kmp_int32 BoundID, struct context_vars*).
  /// \param D OpenMP directive.
  /// \param ThreadIDVar Variable for thread id in the current OpenMP region.
  /// \param InnermostKind Kind of innermost directive (for simple directives it
  /// is a directive itself, for combined - its innermost directive).
  /// \param CodeGen Code generation sequence for the \a D directive.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGOpenMPRuntime::emitParallelOrTeamsOutlinedFunction">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp", line = 841,
   FQN="clang::CodeGen::CGOpenMPRuntime::emitParallelOrTeamsOutlinedFunction", NM="_ZN5clang7CodeGen15CGOpenMPRuntime35emitParallelOrTeamsOutlinedFunctionERKNS_22OMPExecutableDirectiveEPKNS_7VarDeclENS_19OpenMPDirectiveKindERKNS0_15RegionCodeGenTyE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp -nm=_ZN5clang7CodeGen15CGOpenMPRuntime35emitParallelOrTeamsOutlinedFunctionERKNS_22OMPExecutableDirectiveEPKNS_7VarDeclENS_19OpenMPDirectiveKindERKNS0_15RegionCodeGenTyE")
  //</editor-fold>
  public Value /*P*/ emitParallelOrTeamsOutlinedFunction(final /*const*/ OMPExecutableDirective /*&*/ D, /*const*/ VarDecl /*P*/ ThreadIDVar, 
                                     OpenMPDirectiveKind InnermostKind, final /*const*/ RegionCodeGenTy /*&*/ CodeGen) {
    CodeGenFunction CGF = null;
    CGOpenMPOutlinedRegionInfo CGInfo = null;
    CodeGenFunction.CGCapturedStmtRAII CapInfoRAII = null;
    try {
      assert (ThreadIDVar.getType().$arrow().isPointerType()) : "thread id variable must be of type kmp_int32 *";
      /*const*/ CapturedStmt /*P*/ CS = cast_CapturedStmt(D.getAssociatedStmt());
      CGF/*J*/= new CodeGenFunction(CGM, true);
      boolean HasCancel = false;
      {
        /*const*/ OMPParallelDirective /*P*/ OPD = dyn_cast_OMPParallelDirective($AddrOf(D));
        if ((OPD != null)) {
          HasCancel = OPD.hasCancel();
        } else {
          /*const*/ OMPParallelSectionsDirective /*P*/ OPSD = dyn_cast_OMPParallelSectionsDirective($AddrOf(D));
          if ((OPSD != null)) {
            HasCancel = OPSD.hasCancel();
          } else {
            /*const*/ OMPParallelForDirective /*P*/ OPFD = dyn_cast_OMPParallelForDirective($AddrOf(D));
            if ((OPFD != null)) {
              HasCancel = OPFD.hasCancel();
            }
          }
        }
      }
      CGInfo/*J*/= new CGOpenMPOutlinedRegionInfo($Deref(CS), ThreadIDVar, CodeGen, InnermostKind, 
          HasCancel);
      CapInfoRAII/*J*/= new CodeGenFunction.CGCapturedStmtRAII(CGF, $AddrOf(CGInfo));
      return CGF.GenerateOpenMPCapturedStmtFunction($Deref(CS));
    } finally {
      if (CapInfoRAII != null) { CapInfoRAII.$destroy(); }
      if (CGInfo != null) { CGInfo.$destroy(); }
      if (CGF != null) { CGF.$destroy(); }
    }
  }

  
  /// \brief Emits outlined function for the OpenMP task directive \a D. This
  /// outlined function has type void(*)(kmp_int32 ThreadID, struct task_t*
  /// TaskT).
  /// \param D OpenMP directive.
  /// \param ThreadIDVar Variable for thread id in the current OpenMP region.
  /// \param PartIDVar Variable for partition id in the current OpenMP untied
  /// task region.
  /// \param TaskTVar Variable for task_t argument.
  /// \param InnermostKind Kind of innermost directive (for simple directives it
  /// is a directive itself, for combined - its innermost directive).
  /// \param CodeGen Code generation sequence for the \a D directive.
  /// \param Tied true if task is generated for tied task, false otherwise.
  /// \param NumberOfParts Number of parts in untied task. Ignored for tied
  /// tasks.
  ///
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGOpenMPRuntime::emitTaskOutlinedFunction">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp", line = 861,
   FQN="clang::CodeGen::CGOpenMPRuntime::emitTaskOutlinedFunction", NM="_ZN5clang7CodeGen15CGOpenMPRuntime24emitTaskOutlinedFunctionERKNS_22OMPExecutableDirectiveEPKNS_7VarDeclES7_S7_NS_19OpenMPDirectiveKindERKNS0_15RegionCodeGenTyEbRj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp -nm=_ZN5clang7CodeGen15CGOpenMPRuntime24emitTaskOutlinedFunctionERKNS_22OMPExecutableDirectiveEPKNS_7VarDeclES7_S7_NS_19OpenMPDirectiveKindERKNS0_15RegionCodeGenTyEbRj")
  //</editor-fold>
  public Value /*P*/ emitTaskOutlinedFunction(final /*const*/ OMPExecutableDirective /*&*/ D, /*const*/ VarDecl /*P*/ ThreadIDVar, 
                          /*const*/ VarDecl /*P*/ PartIDVar, /*const*/ VarDecl /*P*/ TaskTVar, 
                          OpenMPDirectiveKind InnermostKind, final /*const*/ RegionCodeGenTy /*&*/ CodeGen, 
                          boolean Tied, final uint$ref/*uint &*/ NumberOfParts) {
    CGOpenMPTaskOutlinedRegionInfo.UntiedTaskActionTy Action = null;
    CodeGenFunction CGF = null;
    CGOpenMPTaskOutlinedRegionInfo CGInfo = null;
    CodeGenFunction.CGCapturedStmtRAII CapInfoRAII = null;
    try {
      VarDecl L$TaskTVar = TaskTVar;
      final CodeGenFunctionPrePostActionTy2Void UntiedCodeGen = /*[this, &D, =L$TaskTVar(TaskTVar)]*/ (final CodeGenFunction /*&*/ CGF$1, final PrePostActionTy /*&*/ $Prm1) -> {
            Value /*P*/ ThreadID = getThreadID(CGF$1, D.getLocStart());
            Value /*P*/ UpLoc = emitUpdateLocation(CGF$1, D.getLocStart());
            Value /*P*/ TaskArgs[/*3*/] = new Value /*P*/  [/*3*/] {
              UpLoc, ThreadID, 
              CGF$1.EmitLoadOfPointerLValue(CGF$1.GetAddrOfLocalVar(L$TaskTVar), 
                  L$TaskTVar.getType().$arrow().castAs(org.clang.ast.PointerType.class)).
                  getPointer()
            };
            CGF$1.EmitRuntimeCall(createRuntimeFunction(OpenMPRTLFunction.OMPRTL__kmpc_omp_task.getValue()), new ArrayRef<Value /*P*/ >(TaskArgs, true));
          };
      Action/*J*/= new CGOpenMPTaskOutlinedRegionInfo.UntiedTaskActionTy(Tied, PartIDVar, 
          new RegionCodeGenTy(JD$NotSameRegionCodeGenTy.INSTANCE, UntiedCodeGen));
      CodeGen.setAction(Action);
      assert (!ThreadIDVar.getType().$arrow().isPointerType()) : "thread id variable must be of type kmp_int32 for tasks";
      CapturedStmt /*P*/ CS = cast_CapturedStmt(D.getAssociatedStmt());
      /*const*/ OMPTaskDirective /*P*/ TD = dyn_cast_OMPTaskDirective($AddrOf(D));
      CGF/*J*/= new CodeGenFunction(CGM, true);
      CGInfo/*J*/= new CGOpenMPTaskOutlinedRegionInfo($Deref(CS), ThreadIDVar, CodeGen, 
          InnermostKind, 
          (TD != null) ? TD.hasCancel() : false, Action);
      CapInfoRAII/*J*/= new CodeGenFunction.CGCapturedStmtRAII(CGF, $AddrOf(CGInfo));
      Function /*P*/ Res = CGF.GenerateCapturedStmtFunction($Deref(CS));
      if (!Tied) {
        NumberOfParts.$set(Action.getNumberOfParts());
      }
      return Res;
    } finally {
      if (CapInfoRAII != null) { CapInfoRAII.$destroy(); }
      if (CGInfo != null) { CGInfo.$destroy(); }
      if (CGF != null) { CGF.$destroy(); }
      if (Action != null) { Action.$destroy(); }
    }
  }

  
  /// \brief Cleans up references to the objects in finished function.
  ///
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGOpenMPRuntime::functionFinished">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp", line = 1027,
   FQN="clang::CodeGen::CGOpenMPRuntime::functionFinished", NM="_ZN5clang7CodeGen15CGOpenMPRuntime16functionFinishedERNS0_15CodeGenFunctionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp -nm=_ZN5clang7CodeGen15CGOpenMPRuntime16functionFinishedERNS0_15CodeGenFunctionE")
  //</editor-fold>
  public void functionFinished(final CodeGenFunction /*&*/ CGF) {
    assert ((CGF.CurFn != null)) : "No function in current CodeGenFunction.";
    if ((OpenMPLocThreadIDMap.count(CGF.CurFn) != 0)) {
      OpenMPLocThreadIDMap.erase(CGF.CurFn);
    }
    if ($greater_uint(FunctionUDRMap.count(CGF.CurFn), 0)) {
      for (/*const*/ OMPDeclareReductionDecl /*P*/ D : FunctionUDRMap.$at_T1$C$R(CGF.CurFn)) {
        UDRMap.erase(D);
      }
      FunctionUDRMap.erase(CGF.CurFn);
    }
  }

  
  /// \brief Emits code for parallel or serial call of the \a OutlinedFn with
  /// variables captured in a record which address is stored in \a
  /// CapturedStruct.
  /// \param OutlinedFn Outlined function to be run in parallel threads. Type of
  /// this function is void(*)(kmp_int32 *, kmp_int32, struct context_vars*).
  /// \param CapturedVars A pointer to the record with the references to
  /// variables used in \a OutlinedFn function.
  /// \param IfCond Condition in the associated 'if' clause, if it was
  /// specified, nullptr otherwise.
  ///
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGOpenMPRuntime::emitParallelCall">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp", line = 1931,
   FQN="clang::CodeGen::CGOpenMPRuntime::emitParallelCall", NM="_ZN5clang7CodeGen15CGOpenMPRuntime16emitParallelCallERNS0_15CodeGenFunctionENS_14SourceLocationEPN4llvm5ValueENS5_8ArrayRefIS7_EEPKNS_4ExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp -nm=_ZN5clang7CodeGen15CGOpenMPRuntime16emitParallelCallERNS0_15CodeGenFunctionENS_14SourceLocationEPN4llvm5ValueENS5_8ArrayRefIS7_EEPKNS_4ExprE")
  //</editor-fold>
  public void emitParallelCall(final CodeGenFunction /*&*/ CGF, SourceLocation Loc, 
                  Value /*P*/ OutlinedFn, 
                  ArrayRef<Value /*P*/ > CapturedVars, 
                  /*const*/ Expr /*P*/ IfCond) {
    if (!CGF.HaveInsertPoint()) {
      return;
    }
    Value /*P*/ RTLoc = emitUpdateLocation(CGF, new SourceLocation(Loc));
    Value L$RTLoc = RTLoc;
    ArrayRef<Value /*P*/ >L$CapturedVars = CapturedVars;
    Value L$OutlinedFn = OutlinedFn;
    final CodeGenFunctionPrePostActionTy2Void ThenGen = /*[=L$OutlinedFn(OutlinedFn), =L$CapturedVars(CapturedVars), =L$RTLoc(RTLoc)]*/ (final CodeGenFunction /*&*/ CGF$1, final PrePostActionTy /*&*/ $Prm1) -> {
          // Build call __kmpc_fork_call(loc, n, microtask, var1, .., varn);
          final CGOpenMPRuntime /*&*/ RT = CGF$1.CGM.getOpenMPRuntime();
          Value /*P*/ Args[/*3*/] = new Value /*P*/  [/*3*/] {
            L$RTLoc, 
            CGF$1.Builder.getInt32(L$CapturedVars.size()),  // Number of captured vars
            CGF$1.Builder.CreateBitCast(L$OutlinedFn, RT.getKmpc_MicroPointerTy())};
          SmallVector<Value /*P*/ > RealArgs/*J*/= new SmallVector<Value /*P*/ >(16, (Value /*P*/ )null);
          RealArgs.append_T(std.begin(Args), std.end(Args));
          RealArgs.append_T(L$CapturedVars.begin(), L$CapturedVars.end());
          
          Constant /*P*/ RTLFn = RT.createRuntimeFunction(OpenMPRTLFunction.OMPRTL__kmpc_fork_call.getValue());
          CGF$1.EmitRuntimeCall(RTLFn, new ArrayRef<Value /*P*/ >(RealArgs, true));
        };
    SourceLocation L$Loc = Loc;
    final CodeGenFunctionPrePostActionTy2Void ElseGen = /*[=L$OutlinedFn(OutlinedFn), =L$CapturedVars(CapturedVars), =L$RTLoc(RTLoc), =L$Loc(Loc)]*/ (final CodeGenFunction /*&*/ CGF$1, final PrePostActionTy /*&*/ $Prm1) -> {
          final CGOpenMPRuntime /*&*/ RT = CGF$1.CGM.getOpenMPRuntime();
          Value /*P*/ ThreadID = RT.getThreadID(CGF$1, new SourceLocation(L$Loc));
          // Build calls:
          // __kmpc_serialized_parallel(&Loc, GTid);
          Value /*P*/ Args[/*2*/] = new Value /*P*/  [/*2*/] {L$RTLoc, ThreadID};
          CGF$1.EmitRuntimeCall(RT.createRuntimeFunction(OpenMPRTLFunction.OMPRTL__kmpc_serialized_parallel.getValue()), new ArrayRef<Value /*P*/ >(Args, true));
          
          // OutlinedFn(&GTid, &zero, CapturedStruct);
          Address ThreadIDAddr = RT.emitThreadIDAddress(CGF$1, new SourceLocation(L$Loc));
          Address ZeroAddr = CGF$1.CreateTempAlloca(CGF$1.Int32Ty, CharUnits.fromQuantity(4), 
              /*Name*/ new Twine(/*KEEP_STR*/".zero.addr"));
          CGF$1.InitTempAlloca(new Address(ZeroAddr), CGF$1.Builder.getInt32(/*C*/ 0));
          SmallVector<Value /*P*/ > OutlinedFnArgs/*J*/= new SmallVector<Value /*P*/ >(16, (Value /*P*/ )null);
          OutlinedFnArgs.push_back(ThreadIDAddr.getPointer());
          OutlinedFnArgs.push_back(ZeroAddr.getPointer());
          OutlinedFnArgs.append_T(L$CapturedVars.begin(), L$CapturedVars.end());
          CGF$1.EmitCallOrInvoke(L$OutlinedFn, new ArrayRef<Value /*P*/ >(OutlinedFnArgs, true));
          
          // __kmpc_end_serialized_parallel(&Loc, GTid);
          Value /*P*/ EndArgs[/*2*/] = new Value /*P*/  [/*2*/] {RT.emitUpdateLocation(CGF$1, new SourceLocation(L$Loc)), ThreadID};
          CGF$1.EmitRuntimeCall(RT.createRuntimeFunction(OpenMPRTLFunction.OMPRTL__kmpc_end_serialized_parallel.getValue()), 
              new ArrayRef<Value /*P*/ >(EndArgs, true));
        };
    if ((IfCond != null)) {
      CGOpenMPRuntimeStatics.emitOMPIfClause(CGF, IfCond, new RegionCodeGenTy(JD$NotSameRegionCodeGenTy.INSTANCE, ThenGen), new RegionCodeGenTy(JD$NotSameRegionCodeGenTy.INSTANCE, ElseGen));
    } else {
      RegionCodeGenTy ThenRCG/*J*/= new RegionCodeGenTy(JD$NotSameRegionCodeGenTy.INSTANCE, ThenGen);
      ThenRCG.$call(CGF);
    }
  }

  
  /// \brief Emits a critical region.
  /// \param CriticalName Name of the critical region.
  /// \param CriticalOpGen Generator for the statement associated with the given
  /// critical region.
  /// \param Hint Value of the 'hint' clause (optional).
  // anonymous namespace
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGOpenMPRuntime::emitCriticalRegion">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp", line = 2075,
   FQN="clang::CodeGen::CGOpenMPRuntime::emitCriticalRegion", NM="_ZN5clang7CodeGen15CGOpenMPRuntime18emitCriticalRegionERNS0_15CodeGenFunctionEN4llvm9StringRefERKNS0_15RegionCodeGenTyENS_14SourceLocationEPKNS_4ExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp -nm=_ZN5clang7CodeGen15CGOpenMPRuntime18emitCriticalRegionERNS0_15CodeGenFunctionEN4llvm9StringRefERKNS0_15RegionCodeGenTyENS_14SourceLocationEPKNS_4ExprE")
  //</editor-fold>
  public void emitCriticalRegion(final CodeGenFunction /*&*/ CGF, 
                    StringRef CriticalName, 
                    final /*const*/ RegionCodeGenTy /*&*/ CriticalOpGen, 
                    SourceLocation Loc) {
    emitCriticalRegion(CGF, 
                    CriticalName, 
                    CriticalOpGen, 
                    Loc, (/*const*/ Expr /*P*/ )null);
  }
  public void emitCriticalRegion(final CodeGenFunction /*&*/ CGF, 
                    StringRef CriticalName, 
                    final /*const*/ RegionCodeGenTy /*&*/ CriticalOpGen, 
                    SourceLocation Loc, /*const*/ Expr /*P*/ Hint/*= null*/) {
    CommonActionTy Action = null;
    try {
      // __kmpc_critical[_with_hint](ident_t *, gtid, Lock[, hint]);
      // CriticalOpGen();
      // __kmpc_end_critical(ident_t *, gtid, Lock);
      // Prepare arguments and build a call to __kmpc_critical
      if (!CGF.HaveInsertPoint()) {
        return;
      }
      Value /*P*/ Args[/*3*/] = new Value /*P*/  [/*3*/] {
        emitUpdateLocation(CGF, new SourceLocation(Loc)), getThreadID(CGF, new SourceLocation(Loc)), 
        getCriticalRegionLock(new StringRef(CriticalName))};
      SmallVector<Value /*P*/ > EnterArgs/*J*/= new SmallVector<Value /*P*/ >(JD$T.INSTANCE, 4, std.begin(Args), 
          std.end(Args), (Value /*P*/ )null);
      if ((Hint != null)) {
        EnterArgs.push_back(CGF.Builder.CreateIntCast(CGF.EmitScalarExpr(Hint), CGM.Unnamed_field8.IntPtrTy, /*isSigned=*/ false));
      }
      Action/*J*/= new CommonActionTy(createRuntimeFunction(((Hint != null) ? OpenMPRTLFunction.OMPRTL__kmpc_critical_with_hint : OpenMPRTLFunction.OMPRTL__kmpc_critical).getValue()), 
          new ArrayRef<Value /*P*/ >(EnterArgs, true), createRuntimeFunction(OpenMPRTLFunction.OMPRTL__kmpc_end_critical.getValue()), new ArrayRef<Value /*P*/ >(Args, true));
      CriticalOpGen.setAction(Action);
      emitInlinedDirective(CGF, OpenMPDirectiveKind.OMPD_critical, CriticalOpGen);
    } finally {
      if (Action != null) { Action.$destroy(); }
    }
  }

  
  /// \brief Emits a master region.
  /// \param MasterOpGen Generator for the statement associated with the given
  /// master region.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGOpenMPRuntime::emitMasterRegion">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp", line = 2101,
   FQN="clang::CodeGen::CGOpenMPRuntime::emitMasterRegion", NM="_ZN5clang7CodeGen15CGOpenMPRuntime16emitMasterRegionERNS0_15CodeGenFunctionERKNS0_15RegionCodeGenTyENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp -nm=_ZN5clang7CodeGen15CGOpenMPRuntime16emitMasterRegionERNS0_15CodeGenFunctionERKNS0_15RegionCodeGenTyENS_14SourceLocationE")
  //</editor-fold>
  public void emitMasterRegion(final CodeGenFunction /*&*/ CGF, 
                  final /*const*/ RegionCodeGenTy /*&*/ MasterOpGen, 
                  SourceLocation Loc) {
    CommonActionTy Action = null;
    try {
      if (!CGF.HaveInsertPoint()) {
        return;
      }
      // if(__kmpc_master(ident_t *, gtid)) {
      //   MasterOpGen();
      //   __kmpc_end_master(ident_t *, gtid);
      // }
      // Prepare arguments and build a call to __kmpc_master
      Value /*P*/ Args[/*2*/] = new Value /*P*/  [/*2*/] {emitUpdateLocation(CGF, new SourceLocation(Loc)), getThreadID(CGF, new SourceLocation(Loc))};
      Action/*J*/= new CommonActionTy(createRuntimeFunction(OpenMPRTLFunction.OMPRTL__kmpc_master.getValue()), new ArrayRef<Value /*P*/ >(Args, true), 
          createRuntimeFunction(OpenMPRTLFunction.OMPRTL__kmpc_end_master.getValue()), new ArrayRef<Value /*P*/ >(Args, true), 
          /*Conditional=*/ true);
      MasterOpGen.setAction(Action);
      emitInlinedDirective(CGF, OpenMPDirectiveKind.OMPD_master, MasterOpGen);
      Action.Done(CGF);
    } finally {
      if (Action != null) { Action.$destroy(); }
    }
  }

  
  /// \brief Emits code for a taskyield directive.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGOpenMPRuntime::emitTaskyieldCall">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp", line = 2120,
   FQN="clang::CodeGen::CGOpenMPRuntime::emitTaskyieldCall", NM="_ZN5clang7CodeGen15CGOpenMPRuntime17emitTaskyieldCallERNS0_15CodeGenFunctionENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp -nm=_ZN5clang7CodeGen15CGOpenMPRuntime17emitTaskyieldCallERNS0_15CodeGenFunctionENS_14SourceLocationE")
  //</editor-fold>
  public void emitTaskyieldCall(final CodeGenFunction /*&*/ CGF, 
                   SourceLocation Loc) {
    if (!CGF.HaveInsertPoint()) {
      return;
    }
    // Build call __kmpc_omp_taskyield(loc, thread_id, 0);
    Value /*P*/ Args[/*3*/] = new Value /*P*/  [/*3*/] {
      emitUpdateLocation(CGF, new SourceLocation(Loc)), getThreadID(CGF, new SourceLocation(Loc)), 
      ConstantInt.get(CGM.IntTy, /*V=*/ $int2ulong(0), /*isSigned=*/ true)};
    CGF.EmitRuntimeCall(createRuntimeFunction(OpenMPRTLFunction.OMPRTL__kmpc_omp_taskyield.getValue()), new ArrayRef<Value /*P*/ >(Args, true));
    {
      CGOpenMPRegionInfo /*P*/ Region = dyn_cast_or_null_CGOpenMPRegionInfo(CGF.CapturedStmtInfo);
      if ((Region != null)) {
        Region.emitUntiedSwitch(CGF);
      }
    }
  }

  
  /// \brief Emit a taskgroup region.
  /// \param TaskgroupOpGen Generator for the statement associated with the
  /// given taskgroup region.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGOpenMPRuntime::emitTaskgroupRegion">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp", line = 2133,
   FQN="clang::CodeGen::CGOpenMPRuntime::emitTaskgroupRegion", NM="_ZN5clang7CodeGen15CGOpenMPRuntime19emitTaskgroupRegionERNS0_15CodeGenFunctionERKNS0_15RegionCodeGenTyENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp -nm=_ZN5clang7CodeGen15CGOpenMPRuntime19emitTaskgroupRegionERNS0_15CodeGenFunctionERKNS0_15RegionCodeGenTyENS_14SourceLocationE")
  //</editor-fold>
  public void emitTaskgroupRegion(final CodeGenFunction /*&*/ CGF, 
                     final /*const*/ RegionCodeGenTy /*&*/ TaskgroupOpGen, 
                     SourceLocation Loc) {
    CommonActionTy Action = null;
    try {
      if (!CGF.HaveInsertPoint()) {
        return;
      }
      // __kmpc_taskgroup(ident_t *, gtid);
      // TaskgroupOpGen();
      // __kmpc_end_taskgroup(ident_t *, gtid);
      // Prepare arguments and build a call to __kmpc_taskgroup
      Value /*P*/ Args[/*2*/] = new Value /*P*/  [/*2*/] {emitUpdateLocation(CGF, new SourceLocation(Loc)), getThreadID(CGF, new SourceLocation(Loc))};
      Action/*J*/= new CommonActionTy(createRuntimeFunction(OpenMPRTLFunction.OMPRTL__kmpc_taskgroup.getValue()), new ArrayRef<Value /*P*/ >(Args, true), 
          createRuntimeFunction(OpenMPRTLFunction.OMPRTL__kmpc_end_taskgroup.getValue()), 
          new ArrayRef<Value /*P*/ >(Args, true));
      TaskgroupOpGen.setAction(Action);
      emitInlinedDirective(CGF, OpenMPDirectiveKind.OMPD_taskgroup, TaskgroupOpGen);
    } finally {
      if (Action != null) { Action.$destroy(); }
    }
  }

  
  /// \brief Emits a single region.
  /// \param SingleOpGen Generator for the statement associated with the given
  /// single region.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGOpenMPRuntime::emitSingleRegion">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp", line = 2212,
   FQN="clang::CodeGen::CGOpenMPRuntime::emitSingleRegion", NM="_ZN5clang7CodeGen15CGOpenMPRuntime16emitSingleRegionERNS0_15CodeGenFunctionERKNS0_15RegionCodeGenTyENS_14SourceLocationEN4llvm8ArrayRefIPKNS_4ExprEEESD_SD_SD_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp -nm=_ZN5clang7CodeGen15CGOpenMPRuntime16emitSingleRegionERNS0_15CodeGenFunctionERKNS0_15RegionCodeGenTyENS_14SourceLocationEN4llvm8ArrayRefIPKNS_4ExprEEESD_SD_SD_")
  //</editor-fold>
  public void emitSingleRegion(final CodeGenFunction /*&*/ CGF, 
                  final /*const*/ RegionCodeGenTy /*&*/ SingleOpGen, 
                  SourceLocation Loc, 
                  ArrayRef</*const*/ Expr /*P*/ > CopyprivateVars, 
                  ArrayRef</*const*/ Expr /*P*/ > SrcExprs, 
                  ArrayRef</*const*/ Expr /*P*/ > DstExprs, 
                  ArrayRef</*const*/ Expr /*P*/ > AssignmentOps) {
    CommonActionTy Action = null;
    try {
      if (!CGF.HaveInsertPoint()) {
        return;
      }
      assert (CopyprivateVars.size() == SrcExprs.size() && CopyprivateVars.size() == DstExprs.size() && CopyprivateVars.size() == AssignmentOps.size());
      final ASTContext /*&*/ C = CGM.getContext();
      // int32 did_it = 0;
      // if(__kmpc_single(ident_t *, gtid)) {
      //   SingleOpGen();
      //   __kmpc_end_single(ident_t *, gtid);
      //   did_it = 1;
      // }
      // call __kmpc_copyprivate(ident_t *, gtid, <buf_size>, <copyprivate list>,
      // <copy_func>, did_it);
      Address DidIt = Address.invalid();
      if (!CopyprivateVars.empty()) {
        // int32 did_it = 0;
        QualType KmpInt32Ty = C.getIntTypeForBitwidth(/*DestWidth=*/ 32, /*Signed=*/ 1);
        DidIt.$assignMove(CGF.CreateMemTemp(new QualType(KmpInt32Ty), new Twine(/*KEEP_STR*/".omp.copyprivate.did_it")));
        CGF.Builder.CreateStore(CGF.Builder.getInt32(0), new Address(DidIt));
      }
      // Prepare arguments and build a call to __kmpc_single
      Value /*P*/ Args[/*2*/] = new Value /*P*/  [/*2*/] {emitUpdateLocation(CGF, new SourceLocation(Loc)), getThreadID(CGF, new SourceLocation(Loc))};
      Action/*J*/= new CommonActionTy(createRuntimeFunction(OpenMPRTLFunction.OMPRTL__kmpc_single.getValue()), new ArrayRef<Value /*P*/ >(Args, true), 
          createRuntimeFunction(OpenMPRTLFunction.OMPRTL__kmpc_end_single.getValue()), new ArrayRef<Value /*P*/ >(Args, true), 
          /*Conditional=*/ true);
      SingleOpGen.setAction(Action);
      emitInlinedDirective(CGF, OpenMPDirectiveKind.OMPD_single, SingleOpGen);
      if (DidIt.isValid()) {
        // did_it = 1;
        CGF.Builder.CreateStore(CGF.Builder.getInt32(1), new Address(DidIt));
      }
      Action.Done(CGF);
      // call __kmpc_copyprivate(ident_t *, gtid, <buf_size>, <copyprivate list>,
      // <copy_func>, did_it);
      if (DidIt.isValid()) {
        APInt ArraySize/*J*/= new APInt(JD$UInt_ULong.INSTANCE/*unsigned int numBits=*/ , 32, $uint2ulong(CopyprivateVars.size()));
        QualType CopyprivateArrayTy = C.getConstantArrayType(C.VoidPtrTy.$QualType(), ArraySize, org.clang.ast.ArrayType.ArraySizeModifier.Normal, 
            /*IndexTypeQuals=*/ 0);
        // Create a list of all private variables for copyprivate.
        Address CopyprivateList = CGF.CreateMemTemp(new QualType(CopyprivateArrayTy), new Twine(/*KEEP_STR*/".omp.copyprivate.cpr_list"));
        for (/*uint*/int I = 0, E = CopyprivateVars.size(); $less_uint(I, E); ++I) {
          Address Elem = CGF.Builder.CreateConstArrayGEP(new Address(CopyprivateList), $uint2ulong(I), CGF.getPointerSize());
          CGF.Builder.CreateStore(CGF.Builder.CreatePointerBitCastOrAddrSpaceCast(CGF.EmitLValue(CopyprivateVars.$at(I)).getPointer(), CGF.Unnamed_field9.VoidPtrTy), 
              new Address(Elem));
        }
        // Build function that copies private values from single region to all other
        // threads in the corresponding parallel region.
        Value /*P*/ CpyFn = CGOpenMPRuntimeStatics.emitCopyprivateCopyFunction(CGM, CGF.ConvertTypeForMem(new QualType(CopyprivateArrayTy)).getPointerTo(), 
            new ArrayRef</*const*/ Expr /*P*/ >(CopyprivateVars), new ArrayRef</*const*/ Expr /*P*/ >(SrcExprs), new ArrayRef</*const*/ Expr /*P*/ >(DstExprs), new ArrayRef</*const*/ Expr /*P*/ >(AssignmentOps));
        Value /*P*/ BufSize = CGF.getTypeSize(new QualType(CopyprivateArrayTy));
        Address CL = CGF.Builder.CreatePointerBitCastOrAddrSpaceCast(new Address(CopyprivateList), 
            CGF.Unnamed_field9.VoidPtrTy);
        LoadInst /*P*/ DidItVal = CGF.Builder.CreateLoad(new Address(DidIt));
        Value /*P*/ Args$1[/*6*/] = new Value /*P*/  [/*6*/] {
          emitUpdateLocation(CGF, new SourceLocation(Loc)),  // ident_t *<loc>
          getThreadID(CGF, new SourceLocation(Loc)),  // i32 <gtid>
          BufSize,  // size_t <buf_size>
          CL.getPointer(),  // void *<copyprivate list>
          CpyFn,  // void (*) (void *, void *) <copy_func>
          DidItVal // i32 did_it
        };
        CGF.EmitRuntimeCall(createRuntimeFunction(OpenMPRTLFunction.OMPRTL__kmpc_copyprivate.getValue()), new ArrayRef<Value /*P*/ >(Args$1, true));
      }
    } finally {
      if (Action != null) { Action.$destroy(); }
    }
  }

  
  /// \brief Emit an ordered region.
  /// \param OrderedOpGen Generator for the statement associated with the given
  /// ordered region.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGOpenMPRuntime::emitOrderedRegion">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp", line = 2293,
   FQN="clang::CodeGen::CGOpenMPRuntime::emitOrderedRegion", NM="_ZN5clang7CodeGen15CGOpenMPRuntime17emitOrderedRegionERNS0_15CodeGenFunctionERKNS0_15RegionCodeGenTyENS_14SourceLocationEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp -nm=_ZN5clang7CodeGen15CGOpenMPRuntime17emitOrderedRegionERNS0_15CodeGenFunctionERKNS0_15RegionCodeGenTyENS_14SourceLocationEb")
  //</editor-fold>
  public void emitOrderedRegion(final CodeGenFunction /*&*/ CGF, 
                   final /*const*/ RegionCodeGenTy /*&*/ OrderedOpGen, 
                   SourceLocation Loc, boolean IsThreads) {
    if (!CGF.HaveInsertPoint()) {
      return;
    }
    // __kmpc_ordered(ident_t *, gtid);
    // OrderedOpGen();
    // __kmpc_end_ordered(ident_t *, gtid);
    // Prepare arguments and build a call to __kmpc_ordered
    if (IsThreads) {
      CommonActionTy Action = null;
      try {
        Value /*P*/ Args[/*2*/] = new Value /*P*/  [/*2*/] {emitUpdateLocation(CGF, new SourceLocation(Loc)), getThreadID(CGF, new SourceLocation(Loc))};
        Action/*J*/= new CommonActionTy(createRuntimeFunction(OpenMPRTLFunction.OMPRTL__kmpc_ordered.getValue()), new ArrayRef<Value /*P*/ >(Args, true), 
            createRuntimeFunction(OpenMPRTLFunction.OMPRTL__kmpc_end_ordered.getValue()), 
            new ArrayRef<Value /*P*/ >(Args, true));
        OrderedOpGen.setAction(Action);
        emitInlinedDirective(CGF, OpenMPDirectiveKind.OMPD_ordered, OrderedOpGen);
        return;
      } finally {
        if (Action != null) { Action.$destroy(); }
      }
    }
    emitInlinedDirective(CGF, OpenMPDirectiveKind.OMPD_ordered, OrderedOpGen);
  }

  
  /// \brief Emit an implicit/explicit barrier for OpenMP threads.
  /// \param Kind Directive for which this implicit barrier call must be
  /// generated. Must be OMPD_barrier for explicit barrier generation.
  /// \param EmitChecks true if need to emit checks for cancellation barriers.
  /// \param ForceSimpleCall true simple barrier call must be emitted, false if
  /// runtime class decides which one to emit (simple or with cancellation
  /// checks).
  ///
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGOpenMPRuntime::emitBarrierCall">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp", line = 2314,
   FQN="clang::CodeGen::CGOpenMPRuntime::emitBarrierCall", NM="_ZN5clang7CodeGen15CGOpenMPRuntime15emitBarrierCallERNS0_15CodeGenFunctionENS_14SourceLocationENS_19OpenMPDirectiveKindEbb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp -nm=_ZN5clang7CodeGen15CGOpenMPRuntime15emitBarrierCallERNS0_15CodeGenFunctionENS_14SourceLocationENS_19OpenMPDirectiveKindEbb")
  //</editor-fold>
  public void emitBarrierCall(final CodeGenFunction /*&*/ CGF, SourceLocation Loc, 
                 OpenMPDirectiveKind Kind) {
    emitBarrierCall(CGF, Loc, 
                 Kind, true, 
                 false);
  }
  public void emitBarrierCall(final CodeGenFunction /*&*/ CGF, SourceLocation Loc, 
                 OpenMPDirectiveKind Kind, boolean EmitChecks/*= true*/) {
    emitBarrierCall(CGF, Loc, 
                 Kind, EmitChecks, 
                 false);
  }
  public void emitBarrierCall(final CodeGenFunction /*&*/ CGF, SourceLocation Loc, 
                 OpenMPDirectiveKind Kind, boolean EmitChecks/*= true*/, 
                 boolean ForceSimpleCall/*= false*/) {
    if (!CGF.HaveInsertPoint()) {
      return;
    }
    // Build call __kmpc_cancel_barrier(loc, thread_id);
    // Build call __kmpc_barrier(loc, thread_id);
    /*uint*/int Flags;
    if (Kind == OpenMPDirectiveKind.OMPD_for) {
      Flags = OpenMPLocationFlags.OMP_IDENT_BARRIER_IMPL_FOR;
    } else if (Kind == OpenMPDirectiveKind.OMPD_sections) {
      Flags = OpenMPLocationFlags.OMP_IDENT_BARRIER_IMPL_SECTIONS;
    } else if (Kind == OpenMPDirectiveKind.OMPD_single) {
      Flags = OpenMPLocationFlags.OMP_IDENT_BARRIER_IMPL_SINGLE;
    } else if (Kind == OpenMPDirectiveKind.OMPD_barrier) {
      Flags = OpenMPLocationFlags.OMP_IDENT_BARRIER_EXPL;
    } else {
      Flags = OpenMPLocationFlags.OMP_IDENT_BARRIER_IMPL;
    }
    // Build call __kmpc_cancel_barrier(loc, thread_id) or __kmpc_barrier(loc,
    // thread_id);
    Value /*P*/ Args[/*2*/] = new Value /*P*/  [/*2*/] {
      emitUpdateLocation(CGF, new SourceLocation(Loc), Flags), 
      getThreadID(CGF, new SourceLocation(Loc))};
    {
      CGOpenMPRegionInfo /*P*/ OMPRegionInfo = dyn_cast_or_null_CGOpenMPRegionInfo(CGF.CapturedStmtInfo);
      if ((OMPRegionInfo != null)) {
        if (!ForceSimpleCall && OMPRegionInfo.hasCancel()) {
          CallInst /*P*/ Result = CGF.EmitRuntimeCall(createRuntimeFunction(OpenMPRTLFunction.OMPRTL__kmpc_cancel_barrier.getValue()), new ArrayRef<Value /*P*/ >(Args, true));
          if (EmitChecks) {
            // if (__kmpc_cancel_barrier()) {
            //   exit from construct;
            // }
            BasicBlock /*P*/ ExitBB = CGF.createBasicBlock(new Twine(/*KEEP_STR*/".cancel.exit"));
            BasicBlock /*P*/ ContBB = CGF.createBasicBlock(new Twine(/*KEEP_STR*/".cancel.continue"));
            Value /*P*/ Cmp = CGF.Builder.CreateIsNotNull(Result);
            CGF.Builder.CreateCondBr(Cmp, ExitBB, ContBB);
            CGF.EmitBlock(ExitBB);
            //   exit from construct;
            CodeGenFunction.JumpDest CancelDestination = CGF.getOMPCancelDestination(OMPRegionInfo.getDirectiveKind());
            CGF.EmitBranchThroughCleanup(new CodeGenFunction.JumpDest(CancelDestination));
            CGF.EmitBlock(ContBB, /*IsFinished=*/ true);
          }
          return;
        }
      }
    }
    CGF.EmitRuntimeCall(createRuntimeFunction(OpenMPRTLFunction.OMPRTL__kmpc_barrier.getValue()), new ArrayRef<Value /*P*/ >(Args, true));
  }

  
  /// \brief Check if the specified \a ScheduleKind is static non-chunked.
  /// This kind of worksharing directive is emitted without outer loop.
  /// \param ScheduleKind Schedule kind specified in the 'schedule' clause.
  /// \param Chunked True if chunk is specified in the clause.
  ///
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGOpenMPRuntime::isStaticNonchunked">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp", line = 2391,
   FQN="clang::CodeGen::CGOpenMPRuntime::isStaticNonchunked", NM="_ZNK5clang7CodeGen15CGOpenMPRuntime18isStaticNonchunkedENS_24OpenMPScheduleClauseKindEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp -nm=_ZNK5clang7CodeGen15CGOpenMPRuntime18isStaticNonchunkedENS_24OpenMPScheduleClauseKindEb")
  //</editor-fold>
  public boolean isStaticNonchunked_OpenMPScheduleClauseKind_bool(/*OpenMPScheduleClauseKind*/int ScheduleKind, 
                                                  boolean Chunked) /*const*/ {
    /*OpenMPSchedType*//*uint*/int Schedule = CGOpenMPRuntimeStatics.getRuntimeSchedule(ScheduleKind, Chunked, /*Ordered=*/ false);
    return Schedule == OpenMPSchedType.OMP_sch_static;
  }

  
  /// \brief Check if the specified \a ScheduleKind is static non-chunked.
  /// This kind of distribute directive is emitted without outer loop.
  /// \param ScheduleKind Schedule kind specified in the 'dist_schedule' clause.
  /// \param Chunked True if chunk is specified in the clause.
  ///
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGOpenMPRuntime::isStaticNonchunked">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp", line = 2397,
   FQN="clang::CodeGen::CGOpenMPRuntime::isStaticNonchunked", NM="_ZNK5clang7CodeGen15CGOpenMPRuntime18isStaticNonchunkedENS_28OpenMPDistScheduleClauseKindEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp -nm=_ZNK5clang7CodeGen15CGOpenMPRuntime18isStaticNonchunkedENS_28OpenMPDistScheduleClauseKindEb")
  //</editor-fold>
  public boolean isStaticNonchunked_OpenMPDistScheduleClauseKind_bool(/*OpenMPDistScheduleClauseKind*/int ScheduleKind, boolean Chunked) /*const*/ {
    /*OpenMPSchedType*//*uint*/int Schedule = CGOpenMPRuntimeStatics.getRuntimeSchedule(ScheduleKind, Chunked);
    return Schedule == OpenMPSchedType.OMP_dist_sch_static;
  }

  
  /// \brief Check if the specified \a ScheduleKind is dynamic.
  /// This kind of worksharing directive is emitted without outer loop.
  /// \param ScheduleKind Schedule Kind specified in the 'schedule' clause.
  ///
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGOpenMPRuntime::isDynamic">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp", line = 2404,
   FQN="clang::CodeGen::CGOpenMPRuntime::isDynamic", NM="_ZNK5clang7CodeGen15CGOpenMPRuntime9isDynamicENS_24OpenMPScheduleClauseKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp -nm=_ZNK5clang7CodeGen15CGOpenMPRuntime9isDynamicENS_24OpenMPScheduleClauseKindE")
  //</editor-fold>
  public boolean isDynamic(/*OpenMPScheduleClauseKind*/int ScheduleKind) /*const*/ {
    /*OpenMPSchedType*//*uint*/int Schedule = CGOpenMPRuntimeStatics.getRuntimeSchedule(ScheduleKind, /*Chunked=*/ false, /*Ordered=*/ false);
    assert (Schedule != OpenMPSchedType.OMP_sch_static_chunked) : "cannot be chunked here";
    return Schedule != OpenMPSchedType.OMP_sch_static;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGOpenMPRuntime::emitForDispatchInit">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp", line = 2448,
   FQN="clang::CodeGen::CGOpenMPRuntime::emitForDispatchInit", NM="_ZN5clang7CodeGen15CGOpenMPRuntime19emitForDispatchInitERNS0_15CodeGenFunctionENS_14SourceLocationERKNS_16OpenMPScheduleTyEjbbPN4llvm5ValueESA_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp -nm=_ZN5clang7CodeGen15CGOpenMPRuntime19emitForDispatchInitERNS0_15CodeGenFunctionENS_14SourceLocationERKNS_16OpenMPScheduleTyEjbbPN4llvm5ValueESA_")
  //</editor-fold>
  public void emitForDispatchInit(final CodeGenFunction /*&*/ CGF, 
                     SourceLocation Loc, 
                     final /*const*/ OpenMPScheduleTy /*&*/ ScheduleKind, 
                     /*uint*/int IVSize, boolean IVSigned, 
                     boolean Ordered, Value /*P*/ UB) {
    emitForDispatchInit(CGF, 
                     Loc, 
                     ScheduleKind, 
                     IVSize, IVSigned, 
                     Ordered, UB, 
                     (Value /*P*/ )null);
  }
  public void emitForDispatchInit(final CodeGenFunction /*&*/ CGF, 
                     SourceLocation Loc, 
                     final /*const*/ OpenMPScheduleTy /*&*/ ScheduleKind, 
                     /*uint*/int IVSize, boolean IVSigned, 
                     boolean Ordered, Value /*P*/ UB, 
                     Value /*P*/ Chunk/*= null*/) {
    if (!CGF.HaveInsertPoint()) {
      return;
    }
    /*OpenMPSchedType*//*uint*/int Schedule = CGOpenMPRuntimeStatics.getRuntimeSchedule(ScheduleKind.Schedule, Chunk != (Value /*P*/ )null, Ordered);
    assert (Ordered || (Schedule != OpenMPSchedType.OMP_sch_static && Schedule != OpenMPSchedType.OMP_sch_static_chunked && Schedule != OpenMPSchedType.OMP_ord_static && Schedule != OpenMPSchedType.OMP_ord_static_chunked && Schedule != OpenMPSchedType.OMP_sch_static_balanced_chunked));
    // Call __kmpc_dispatch_init(
    //          ident_t *loc, kmp_int32 tid, kmp_int32 schedule,
    //          kmp_int[32|64] lower, kmp_int[32|64] upper,
    //          kmp_int[32|64] stride, kmp_int[32|64] chunk);
    
    // If the Chunk was not specified in the clause - use default value 1.
    if (Chunk == null) {
      Chunk = CGF.Builder.getIntN(IVSize, $int2ulong(1));
    }
    Value /*P*/ Args[/*7*/] = new Value /*P*/  [/*7*/] {
      emitUpdateLocation(CGF, new SourceLocation(Loc)), getThreadID(CGF, new SourceLocation(Loc)), 
      CGF.Builder.getInt32(CGOpenMPRuntimeStatics.addMonoNonMonoModifier(Schedule, ScheduleKind.M1, ScheduleKind.M2)),  // Schedule type
      CGF.Builder.getIntN(IVSize, $int2ulong(0)),  // Lower
      UB,  // Upper
      CGF.Builder.getIntN(IVSize, $int2ulong(1)),  // Stride
      Chunk // Chunk
    };
    CGF.EmitRuntimeCall(createDispatchInitFunction(IVSize, IVSigned), new ArrayRef<Value /*P*/ >(Args, true));
  }

  
  /// \brief Call the appropriate runtime routine to initialize it before start
  /// of loop.
  ///
  /// Depending on the loop schedule, it is nesessary to call some runtime
  /// routine before start of the OpenMP loop to get the loop upper / lower
  /// bounds \a LB and \a UB and stride \a ST.
  ///
  /// \param CGF Reference to current CodeGenFunction.
  /// \param Loc Clang source location.
  /// \param ScheduleKind Schedule kind, specified by the 'schedule' clause.
  /// \param IVSize Size of the iteration variable in bits.
  /// \param IVSigned Sign of the interation variable.
  /// \param Ordered true if loop is ordered, false otherwise.
  /// \param IL Address of the output variable in which the flag of the
  /// last iteration is returned.
  /// \param LB Address of the output variable in which the lower iteration
  /// number is returned.
  /// \param UB Address of the output variable in which the upper iteration
  /// number is returned.
  /// \param ST Address of the output variable in which the stride value is
  /// returned nesessary to generated the static_chunked scheduled loop.
  /// \param Chunk Value of the chunk for the static_chunked scheduled loop.
  /// For the default (nullptr) value, the chunk 1 will be used.
  ///
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGOpenMPRuntime::emitForStaticInit">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp", line = 2529,
   FQN="clang::CodeGen::CGOpenMPRuntime::emitForStaticInit", NM="_ZN5clang7CodeGen15CGOpenMPRuntime17emitForStaticInitERNS0_15CodeGenFunctionENS_14SourceLocationERKNS_16OpenMPScheduleTyEjbbNS0_7AddressES8_S8_S8_PN4llvm5ValueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp -nm=_ZN5clang7CodeGen15CGOpenMPRuntime17emitForStaticInitERNS0_15CodeGenFunctionENS_14SourceLocationERKNS_16OpenMPScheduleTyEjbbNS0_7AddressES8_S8_S8_PN4llvm5ValueE")
  //</editor-fold>
  public void emitForStaticInit(final CodeGenFunction /*&*/ CGF, 
                   SourceLocation Loc, 
                   final /*const*/ OpenMPScheduleTy /*&*/ ScheduleKind, 
                   /*uint*/int IVSize, boolean IVSigned, 
                   boolean Ordered, Address IL, Address LB, 
                   Address UB, Address ST) {
    emitForStaticInit(CGF, 
                   Loc, 
                   ScheduleKind, 
                   IVSize, IVSigned, 
                   Ordered, IL, LB, 
                   UB, ST, 
                   (Value /*P*/ )null);
  }
  public void emitForStaticInit(final CodeGenFunction /*&*/ CGF, 
                   SourceLocation Loc, 
                   final /*const*/ OpenMPScheduleTy /*&*/ ScheduleKind, 
                   /*uint*/int IVSize, boolean IVSigned, 
                   boolean Ordered, Address IL, Address LB, 
                   Address UB, Address ST, 
                   Value /*P*/ Chunk/*= null*/) {
    /*OpenMPSchedType*//*uint*/int ScheduleNum = CGOpenMPRuntimeStatics.getRuntimeSchedule(ScheduleKind.Schedule, Chunk != (Value /*P*/ )null, Ordered);
    Value /*P*/ UpdatedLocation = emitUpdateLocation(CGF, new SourceLocation(Loc));
    Value /*P*/ ThreadId = getThreadID(CGF, new SourceLocation(Loc));
    Constant /*P*/ StaticInitFunction = createForStaticInitFunction(IVSize, IVSigned);
    CGOpenMPRuntimeStatics.emitForStaticInitCall(CGF, UpdatedLocation, ThreadId, StaticInitFunction, 
        ScheduleNum, ScheduleKind.M1, ScheduleKind.M2, IVSize, 
        Ordered, new Address(IL), new Address(LB), new Address(UB), new Address(ST), Chunk);
  }

  
  ///
  /// \param CGF Reference to current CodeGenFunction.
  /// \param Loc Clang source location.
  /// \param SchedKind Schedule kind, specified by the 'dist_schedule' clause.
  /// \param IVSize Size of the iteration variable in bits.
  /// \param IVSigned Sign of the interation variable.
  /// \param Ordered true if loop is ordered, false otherwise.
  /// \param IL Address of the output variable in which the flag of the
  /// last iteration is returned.
  /// \param LB Address of the output variable in which the lower iteration
  /// number is returned.
  /// \param UB Address of the output variable in which the upper iteration
  /// number is returned.
  /// \param ST Address of the output variable in which the stride value is
  /// returned nesessary to generated the static_chunked scheduled loop.
  /// \param Chunk Value of the chunk for the static_chunked scheduled loop.
  /// For the default (nullptr) value, the chunk 1 will be used.
  ///
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGOpenMPRuntime::emitDistributeStaticInit">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp", line = 2546,
   FQN="clang::CodeGen::CGOpenMPRuntime::emitDistributeStaticInit", NM="_ZN5clang7CodeGen15CGOpenMPRuntime24emitDistributeStaticInitERNS0_15CodeGenFunctionENS_14SourceLocationENS_28OpenMPDistScheduleClauseKindEjbbNS0_7AddressES6_S6_S6_PN4llvm5ValueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp -nm=_ZN5clang7CodeGen15CGOpenMPRuntime24emitDistributeStaticInitERNS0_15CodeGenFunctionENS_14SourceLocationENS_28OpenMPDistScheduleClauseKindEjbbNS0_7AddressES6_S6_S6_PN4llvm5ValueE")
  //</editor-fold>
  public void emitDistributeStaticInit(final CodeGenFunction /*&*/ CGF, SourceLocation Loc, 
                          /*OpenMPDistScheduleClauseKind*/int SchedKind, /*uint*/int IVSize, boolean IVSigned, 
                          boolean Ordered, Address IL, Address LB, Address UB, Address ST) {
    emitDistributeStaticInit(CGF, Loc, 
                          SchedKind, IVSize, IVSigned, 
                          Ordered, IL, LB, UB, ST, 
                          (Value /*P*/ )null);
  }
  public void emitDistributeStaticInit(final CodeGenFunction /*&*/ CGF, SourceLocation Loc, 
                          /*OpenMPDistScheduleClauseKind*/int SchedKind, /*uint*/int IVSize, boolean IVSigned, 
                          boolean Ordered, Address IL, Address LB, Address UB, Address ST, 
                          Value /*P*/ Chunk/*= null*/) {
    /*OpenMPSchedType*//*uint*/int ScheduleNum = CGOpenMPRuntimeStatics.getRuntimeSchedule(SchedKind, Chunk != (Value /*P*/ )null);
    Value /*P*/ UpdatedLocation = emitUpdateLocation(CGF, new SourceLocation(Loc));
    Value /*P*/ ThreadId = getThreadID(CGF, new SourceLocation(Loc));
    Constant /*P*/ StaticInitFunction = createForStaticInitFunction(IVSize, IVSigned);
    CGOpenMPRuntimeStatics.emitForStaticInitCall(CGF, UpdatedLocation, ThreadId, StaticInitFunction, 
        ScheduleNum, OpenMPScheduleClauseModifier.OMPC_SCHEDULE_MODIFIER_unknown, 
        OpenMPScheduleClauseModifier.OMPC_SCHEDULE_MODIFIER_unknown, IVSize, Ordered, new Address(IL), new Address(LB), 
        new Address(UB), new Address(ST), Chunk);
  }

  
  /// \brief Call the appropriate runtime routine to notify that we finished
  /// iteration of the ordered loop with the dynamic scheduling.
  ///
  /// \param CGF Reference to current CodeGenFunction.
  /// \param Loc Clang source location.
  /// \param IVSize Size of the iteration variable in bits.
  /// \param IVSigned Sign of the interation variable.
  ///
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGOpenMPRuntime::emitForOrderedIterationEnd">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp", line = 2571,
   FQN="clang::CodeGen::CGOpenMPRuntime::emitForOrderedIterationEnd", NM="_ZN5clang7CodeGen15CGOpenMPRuntime26emitForOrderedIterationEndERNS0_15CodeGenFunctionENS_14SourceLocationEjb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp -nm=_ZN5clang7CodeGen15CGOpenMPRuntime26emitForOrderedIterationEndERNS0_15CodeGenFunctionENS_14SourceLocationEjb")
  //</editor-fold>
  public void emitForOrderedIterationEnd(final CodeGenFunction /*&*/ CGF, 
                            SourceLocation Loc, 
                            /*uint*/int IVSize, 
                            boolean IVSigned) {
    if (!CGF.HaveInsertPoint()) {
      return;
    }
    // Call __kmpc_for_dynamic_fini_(4|8)[u](ident_t *loc, kmp_int32 tid);
    Value /*P*/ Args[/*2*/] = new Value /*P*/  [/*2*/] {emitUpdateLocation(CGF, new SourceLocation(Loc)), getThreadID(CGF, new SourceLocation(Loc))};
    CGF.EmitRuntimeCall(createDispatchFiniFunction(IVSize, IVSigned), new ArrayRef<Value /*P*/ >(Args, true));
  }

  
  /// \brief Call the appropriate runtime routine to notify that we finished
  /// all the work with current loop.
  ///
  /// \param CGF Reference to current CodeGenFunction.
  /// \param Loc Clang source location.
  ///
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGOpenMPRuntime::emitForStaticFinish">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp", line = 2561,
   FQN="clang::CodeGen::CGOpenMPRuntime::emitForStaticFinish", NM="_ZN5clang7CodeGen15CGOpenMPRuntime19emitForStaticFinishERNS0_15CodeGenFunctionENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp -nm=_ZN5clang7CodeGen15CGOpenMPRuntime19emitForStaticFinishERNS0_15CodeGenFunctionENS_14SourceLocationE")
  //</editor-fold>
  public void emitForStaticFinish(final CodeGenFunction /*&*/ CGF, 
                     SourceLocation Loc) {
    if (!CGF.HaveInsertPoint()) {
      return;
    }
    // Call __kmpc_for_static_fini(ident_t *loc, kmp_int32 tid);
    Value /*P*/ Args[/*2*/] = new Value /*P*/  [/*2*/] {emitUpdateLocation(CGF, new SourceLocation(Loc)), getThreadID(CGF, new SourceLocation(Loc))};
    CGF.EmitRuntimeCall(createRuntimeFunction(OpenMPRTLFunction.OMPRTL__kmpc_for_static_fini.getValue()), 
        new ArrayRef<Value /*P*/ >(Args, true));
  }

  
  /// Call __kmpc_dispatch_next(
  ///          ident_t *loc, kmp_int32 tid, kmp_int32 *p_lastiter,
  ///          kmp_int[32|64] *p_lower, kmp_int[32|64] *p_upper,
  ///          kmp_int[32|64] *p_stride);
  /// \param IVSize Size of the iteration variable in bits.
  /// \param IVSigned Sign of the interation variable.
  /// \param IL Address of the output variable in which the flag of the
  /// last iteration is returned.
  /// \param LB Address of the output variable in which the lower iteration
  /// number is returned.
  /// \param UB Address of the output variable in which the upper iteration
  /// number is returned.
  /// \param ST Address of the output variable in which the stride value is
  /// returned.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGOpenMPRuntime::emitForNext">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp", line = 2582,
   FQN="clang::CodeGen::CGOpenMPRuntime::emitForNext", NM="_ZN5clang7CodeGen15CGOpenMPRuntime11emitForNextERNS0_15CodeGenFunctionENS_14SourceLocationEjbNS0_7AddressES5_S5_S5_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp -nm=_ZN5clang7CodeGen15CGOpenMPRuntime11emitForNextERNS0_15CodeGenFunctionENS_14SourceLocationEjbNS0_7AddressES5_S5_S5_")
  //</editor-fold>
  public Value /*P*/ emitForNext(final CodeGenFunction /*&*/ CGF, 
             SourceLocation Loc, /*uint*/int IVSize, 
             boolean IVSigned, Address IL, 
             Address LB, Address UB, 
             Address ST) {
    // Call __kmpc_dispatch_next(
    //          ident_t *loc, kmp_int32 tid, kmp_int32 *p_lastiter,
    //          kmp_int[32|64] *p_lower, kmp_int[32|64] *p_upper,
    //          kmp_int[32|64] *p_stride);
    Value /*P*/ Args[/*6*/] = new Value /*P*/  [/*6*/] {
      emitUpdateLocation(CGF, new SourceLocation(Loc)), 
      getThreadID(CGF, new SourceLocation(Loc)), 
      IL.getPointer(),  // &isLastIter
      LB.getPointer(),  // &Lower
      UB.getPointer(),  // &Upper
      ST.getPointer() // &Stride
    };
    Value /*P*/ Call = CGF.EmitRuntimeCall(createDispatchNextFunction(IVSize, IVSigned), new ArrayRef<Value /*P*/ >(Args, true));
    return CGF.EmitScalarConversion(Call, CGF.getContext().getIntTypeForBitwidth(32, /* Signed */ /*true*/1), 
        CGF.getContext().BoolTy.$QualType(), new SourceLocation(Loc));
  }

  
  /// \brief Emits call to void __kmpc_push_num_threads(ident_t *loc, kmp_int32
  /// global_tid, kmp_int32 num_threads) to generate code for 'num_threads'
  /// clause.
  /// \param NumThreads An integer value of threads.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGOpenMPRuntime::emitNumThreadsClause">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp", line = 2606,
   FQN="clang::CodeGen::CGOpenMPRuntime::emitNumThreadsClause", NM="_ZN5clang7CodeGen15CGOpenMPRuntime20emitNumThreadsClauseERNS0_15CodeGenFunctionEPN4llvm5ValueENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp -nm=_ZN5clang7CodeGen15CGOpenMPRuntime20emitNumThreadsClauseERNS0_15CodeGenFunctionEPN4llvm5ValueENS_14SourceLocationE")
  //</editor-fold>
  public void emitNumThreadsClause(final CodeGenFunction /*&*/ CGF, 
                      Value /*P*/ NumThreads, 
                      SourceLocation Loc) {
    if (!CGF.HaveInsertPoint()) {
      return;
    }
    // Build call __kmpc_push_num_threads(&loc, global_tid, num_threads)
    Value /*P*/ Args[/*3*/] = new Value /*P*/  [/*3*/] {
      emitUpdateLocation(CGF, new SourceLocation(Loc)), getThreadID(CGF, new SourceLocation(Loc)), 
      CGF.Builder.CreateIntCast(NumThreads, CGF.Int32Ty, /*isSigned*/ true)};
    CGF.EmitRuntimeCall(createRuntimeFunction(OpenMPRTLFunction.OMPRTL__kmpc_push_num_threads.getValue()), 
        new ArrayRef<Value /*P*/ >(Args, true));
  }

  
  /// \brief Emit call to void __kmpc_push_proc_bind(ident_t *loc, kmp_int32
  /// global_tid, int proc_bind) to generate code for 'proc_bind' clause.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGOpenMPRuntime::emitProcBindClause">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp", line = 2619,
   FQN="clang::CodeGen::CGOpenMPRuntime::emitProcBindClause", NM="_ZN5clang7CodeGen15CGOpenMPRuntime18emitProcBindClauseERNS0_15CodeGenFunctionENS_24OpenMPProcBindClauseKindENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp -nm=_ZN5clang7CodeGen15CGOpenMPRuntime18emitProcBindClauseERNS0_15CodeGenFunctionENS_24OpenMPProcBindClauseKindENS_14SourceLocationE")
  //</editor-fold>
  public void emitProcBindClause(final CodeGenFunction /*&*/ CGF, 
                    OpenMPProcBindClauseKind ProcBind, 
                    SourceLocation Loc) {
    if (!CGF.HaveInsertPoint()) {
      return;
    }
    // Constants for proc bind value accepted by the runtime.
    final class/*enum*/ ProcBindTy {
      private static final /*uint*/int ProcBindFalse = 0;
      private static final /*uint*/int ProcBindTrue = ProcBindFalse + 1;
      private static final /*uint*/int ProcBindMaster = ProcBindTrue + 1;
      private static final /*uint*/int ProcBindClose = ProcBindMaster + 1;
      private static final /*uint*/int ProcBindSpread = ProcBindClose + 1;
      private static final /*uint*/int ProcBindIntel = ProcBindSpread + 1;
      private static final /*uint*/int ProcBindDefault = ProcBindIntel + 1;
    }/* ProcBindTy*//*uint*/int RuntimeProcBind = 0;
    switch (ProcBind) {
     case OMPC_PROC_BIND_master:
      RuntimeProcBind = ProcBindTy.ProcBindMaster;
      break;
     case OMPC_PROC_BIND_close:
      RuntimeProcBind = ProcBindTy.ProcBindClose;
      break;
     case OMPC_PROC_BIND_spread:
      RuntimeProcBind = ProcBindTy.ProcBindSpread;
      break;
     case OMPC_PROC_BIND_unknown:
      throw new llvm_unreachable("Unsupported proc_bind value.");
    }
    // Build call __kmpc_push_proc_bind(&loc, global_tid, proc_bind)
    Value /*P*/ Args[/*3*/] = new Value /*P*/  [/*3*/] {
      emitUpdateLocation(CGF, new SourceLocation(Loc)), getThreadID(CGF, new SourceLocation(Loc)), 
      ConstantInt.get(CGM.IntTy, $uint2ulong(RuntimeProcBind), /*isSigned=*/ true)};
    CGF.EmitRuntimeCall(createRuntimeFunction(OpenMPRTLFunction.OMPRTL__kmpc_push_proc_bind.getValue()), new ArrayRef<Value /*P*/ >(Args, true));
  }

  
  /// \brief Returns address of the threadprivate variable for the current
  /// thread.
  /// \param VD Threadprivate variable.
  /// \param VDAddr Address of the global variable \a VD.
  /// \param Loc Location of the reference to threadprivate var.
  /// \return Address of the threadprivate variable for the current thread.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGOpenMPRuntime::getAddrOfThreadPrivate">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp", line = 1733,
   FQN="clang::CodeGen::CGOpenMPRuntime::getAddrOfThreadPrivate", NM="_ZN5clang7CodeGen15CGOpenMPRuntime22getAddrOfThreadPrivateERNS0_15CodeGenFunctionEPKNS_7VarDeclENS0_7AddressENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp -nm=_ZN5clang7CodeGen15CGOpenMPRuntime22getAddrOfThreadPrivateERNS0_15CodeGenFunctionEPKNS_7VarDeclENS0_7AddressENS_14SourceLocationE")
  //</editor-fold>
  public Address getAddrOfThreadPrivate(final CodeGenFunction /*&*/ CGF, 
                        /*const*/ VarDecl /*P*/ VD, 
                        Address VDAddr, 
                        SourceLocation Loc) {
    if (CGM.getLangOpts().OpenMPUseTLS
       && CGM.getContext().getTargetInfo().isTLSSupported()) {
      return new Address(JD$Move.INSTANCE, VDAddr);
    }
    
    org.llvm.ir.Type /*P*/ VarTy = VDAddr.getElementType();
    Value /*P*/ Args[/*5*/] = new Value /*P*/  [/*5*/] {
      emitUpdateLocation(CGF, new SourceLocation(Loc)), getThreadID(CGF, new SourceLocation(Loc)), 
      CGF.Builder.CreatePointerCast(VDAddr.getPointer(), 
          CGM.Unnamed_field9.Int8PtrTy), 
      CGM.getSize(CGM.GetTargetTypeStoreSize(VarTy)), 
      getOrCreateThreadPrivateCache(VD)};
    return new Address(CGF.EmitRuntimeCall(createRuntimeFunction(OpenMPRTLFunction.OMPRTL__kmpc_threadprivate_cached.getValue()), new ArrayRef<Value /*P*/ >(Args, true)), 
        VDAddr.getAlignment());
  }

  
  /// \brief Emit a code for initialization of threadprivate variable. It emits
  /// a call to runtime library which adds initial value to the newly created
  /// threadprivate variable (if it is not constant) and registers destructor
  /// for the variable (if any).
  /// \param VD Threadprivate variable.
  /// \param VDAddr Address of the global variable \a VD.
  /// \param Loc Location of threadprivate declaration.
  /// \param PerformInit true if initialization expression is not constant.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGOpenMPRuntime::emitThreadPrivateVarDefinition">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp", line = 1770,
   FQN="clang::CodeGen::CGOpenMPRuntime::emitThreadPrivateVarDefinition", NM="_ZN5clang7CodeGen15CGOpenMPRuntime30emitThreadPrivateVarDefinitionEPKNS_7VarDeclENS0_7AddressENS_14SourceLocationEbPNS0_15CodeGenFunctionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp -nm=_ZN5clang7CodeGen15CGOpenMPRuntime30emitThreadPrivateVarDefinitionEPKNS_7VarDeclENS0_7AddressENS_14SourceLocationEbPNS0_15CodeGenFunctionE")
  //</editor-fold>
  public Function /*P*/ emitThreadPrivateVarDefinition(/*const*/ VarDecl /*P*/ VD, Address VDAddr, SourceLocation Loc, 
                                boolean PerformInit) {
    return emitThreadPrivateVarDefinition(VD, VDAddr, Loc, 
                                PerformInit, (CodeGenFunction /*P*/ )null);
  }
  public Function /*P*/ emitThreadPrivateVarDefinition(/*const*/ VarDecl /*P*/ VD, Address VDAddr, SourceLocation Loc, 
                                boolean PerformInit, CodeGenFunction /*P*/ CGF/*= null*/) {
    if (CGM.getLangOpts().OpenMPUseTLS
       && CGM.getContext().getTargetInfo().isTLSSupported()) {
      return null;
    }
    
    VD = VD.getDefinition$Const(CGM.getContext());
    if ((VD != null) && ThreadPrivateWithDefinition.count(VD) == 0) {
      ThreadPrivateWithDefinition.insert(VD);
      QualType ASTTy = VD.getType();
      
      Value /*P*/ Ctor = null;
      Value /*P*/ CopyCtor = null;
      Value /*P*/ Dtor = null;
      /*const*/ Expr /*P*/ Init = VD.getAnyInitializer();
      if (CGM.getLangOpts().CPlusPlus && PerformInit) {
        CodeGenFunction CtorCGF = null;
        FunctionArgList Args = null;
        ImplicitParamDecl Dst = null;
        try {
          // Generate function that re-emits the declaration's initializer into the
          // threadprivate copy of the variable VD
          CtorCGF/*J*/= new CodeGenFunction(CGM);
          Args/*J*/= new FunctionArgList();
          Dst/*J*/= new ImplicitParamDecl(CGM.getContext(), /*DC=*/ (DeclContext /*P*/ )null, new SourceLocation(), 
              /*Id=*/ (IdentifierInfo /*P*/ )null, CGM.getContext().VoidPtrTy.$QualType());
          Args.push_back($AddrOf(Dst));
          
          final /*const*/ CGFunctionInfo /*&*/ FI = CGM.getTypes().arrangeBuiltinFunctionDeclaration(CGM.getContext().VoidPtrTy.$QualType(), Args);
          org.llvm.ir.FunctionType /*P*/ FTy = CGM.getTypes().GetFunctionType(FI);
          Function /*P*/ Fn = CGM.CreateGlobalInitOrDestructFunction(FTy, new Twine(/*KEEP_STR*/".__kmpc_global_ctor_."), FI, new SourceLocation(Loc));
          CtorCGF.StartFunction(new GlobalDecl(), CGM.getContext().VoidPtrTy.$QualType(), Fn, FI, 
              Args, new SourceLocation());
          Value /*P*/ ArgVal = CtorCGF.EmitLoadOfScalar(CtorCGF.GetAddrOfLocalVar($AddrOf(Dst)), /*Volatile=*/ false, 
              CGM.getContext().VoidPtrTy.$QualType(), Dst.getLocation());
          Address Arg = new Address(ArgVal, VDAddr.getAlignment());
          Arg.$assignMove(CtorCGF.Builder.CreateElementBitCast(new Address(Arg), 
                  CtorCGF.ConvertTypeForMem(new QualType(ASTTy))));
          CtorCGF.EmitAnyExprToMem(Init, new Address(Arg), Init.getType().getQualifiers(), 
              /*IsInitializer=*/ true);
          ArgVal = CtorCGF.EmitLoadOfScalar(CtorCGF.GetAddrOfLocalVar($AddrOf(Dst)), /*Volatile=*/ false, 
              CGM.getContext().VoidPtrTy.$QualType(), Dst.getLocation());
          CtorCGF.Builder.CreateStore(ArgVal, new Address(CtorCGF.ReturnValue));
          CtorCGF.FinishFunction();
          Ctor = Fn;
        } finally {
          if (Dst != null) { Dst.$destroy(); }
          if (Args != null) { Args.$destroy(); }
          if (CtorCGF != null) { CtorCGF.$destroy(); }
        }
      }
      if (VD.getType().isDestructedType() != QualType.DestructionKind.DK_none) {
        CodeGenFunction DtorCGF = null;
        FunctionArgList Args = null;
        ImplicitParamDecl Dst = null;
        ApplyDebugLocation NL = null;
        ApplyDebugLocation AL = null;
        try {
          // Generate function that emits destructor call for the threadprivate copy
          // of the variable VD
          DtorCGF/*J*/= new CodeGenFunction(CGM);
          Args/*J*/= new FunctionArgList();
          Dst/*J*/= new ImplicitParamDecl(CGM.getContext(), /*DC=*/ (DeclContext /*P*/ )null, new SourceLocation(), 
              /*Id=*/ (IdentifierInfo /*P*/ )null, CGM.getContext().VoidPtrTy.$QualType());
          Args.push_back($AddrOf(Dst));
          
          final /*const*/ CGFunctionInfo /*&*/ FI = CGM.getTypes().arrangeBuiltinFunctionDeclaration(CGM.getContext().VoidTy.$QualType(), Args);
          org.llvm.ir.FunctionType /*P*/ FTy = CGM.getTypes().GetFunctionType(FI);
          Function /*P*/ Fn = CGM.CreateGlobalInitOrDestructFunction(FTy, new Twine(/*KEEP_STR*/".__kmpc_global_dtor_."), FI, new SourceLocation(Loc));
          NL = ApplyDebugLocation.CreateEmpty(DtorCGF);
          DtorCGF.StartFunction(new GlobalDecl(), CGM.getContext().VoidTy.$QualType(), Fn, FI, Args, 
              new SourceLocation());
          // Create a scope with an artificial location for the body of this function.
          AL = ApplyDebugLocation.CreateArtificial(DtorCGF);
          Value /*P*/ ArgVal = DtorCGF.EmitLoadOfScalar(DtorCGF.GetAddrOfLocalVar($AddrOf(Dst)), 
              /*Volatile=*/ false, CGM.getContext().VoidPtrTy.$QualType(), Dst.getLocation());
          DtorCGF.emitDestroy(new Address(ArgVal, VDAddr.getAlignment()), new QualType(ASTTy), 
              DtorCGF.getDestroyer(ASTTy.isDestructedType()), 
              DtorCGF.needsEHCleanup(ASTTy.isDestructedType()));
          DtorCGF.FinishFunction();
          Dtor = Fn;
        } finally {
          if (AL != null) { AL.$destroy(); }
          if (NL != null) { NL.$destroy(); }
          if (Dst != null) { Dst.$destroy(); }
          if (Args != null) { Args.$destroy(); }
          if (DtorCGF != null) { DtorCGF.$destroy(); }
        }
      }
      // Do not emit init function if it is not required.
      if (!(Ctor != null) && !(Dtor != null)) {
        return null;
      }
      
      org.llvm.ir.Type /*P*/ CopyCtorTyArgs[/*2*/] = new org.llvm.ir.Type /*P*/  [/*2*/] {CGM.Unnamed_field9.VoidPtrTy, CGM.Unnamed_field9.VoidPtrTy};
      org.llvm.ir.PointerType /*P*/ CopyCtorTy = org.llvm.ir.FunctionType.get(CGM.Unnamed_field9.VoidPtrTy, new ArrayRef<org.llvm.ir.Type /*P*/ >(CopyCtorTyArgs, true), 
          /*isVarArg=*/ false).getPointerTo();
      // Copying constructor for the threadprivate variable.
      // Must be NULL - reserved by runtime, but currently it requires that this
      // parameter is always NULL. Otherwise it fires assertion.
      CopyCtor = Constant.getNullValue(CopyCtorTy);
      if (Ctor == null) {
        org.llvm.ir.PointerType /*P*/ CtorTy = org.llvm.ir.FunctionType.get(CGM.Unnamed_field9.VoidPtrTy, new ArrayRef<org.llvm.ir.Type /*P*/ >(CGM.Unnamed_field9.VoidPtrTy, true), 
            /*isVarArg=*/ false).getPointerTo();
        Ctor = Constant.getNullValue(CtorTy);
      }
      if (Dtor == null) {
        org.llvm.ir.PointerType /*P*/ DtorTy = org.llvm.ir.FunctionType.get(CGM.VoidTy, new ArrayRef<org.llvm.ir.Type /*P*/ >(CGM.Unnamed_field9.VoidPtrTy, true), 
            /*isVarArg=*/ false).getPointerTo();
        Dtor = Constant.getNullValue(DtorTy);
      }
      if (!(CGF != null)) {
        CodeGenFunction InitCGF = null;
        FunctionArgList ArgList = null;
        try {
          org.llvm.ir.FunctionType /*P*/ InitFunctionTy = org.llvm.ir.FunctionType.get(CGM.VoidTy, /*isVarArg*/ false);
          Function /*P*/ InitFunction = CGM.CreateGlobalInitOrDestructFunction(InitFunctionTy, new Twine(/*KEEP_STR*/".__omp_threadprivate_init_."), 
              CGM.getTypes().arrangeNullaryFunction());
          InitCGF/*J*/= new CodeGenFunction(CGM);
          ArgList/*J*/= new FunctionArgList();
          InitCGF.StartFunction(new GlobalDecl(), CGM.getContext().VoidTy.$QualType(), InitFunction, 
              CGM.getTypes().arrangeNullaryFunction(), ArgList, 
              new SourceLocation(Loc));
          emitThreadPrivateVarInit(InitCGF, new Address(VDAddr), Ctor, CopyCtor, Dtor, new SourceLocation(Loc));
          InitCGF.FinishFunction();
          return InitFunction;
        } finally {
          if (ArgList != null) { ArgList.$destroy(); }
          if (InitCGF != null) { InitCGF.$destroy(); }
        }
      }
      emitThreadPrivateVarInit($Deref(CGF), new Address(VDAddr), Ctor, CopyCtor, Dtor, new SourceLocation(Loc));
    }
    return null;
  }

  
  /// \brief Emit flush of the variables specified in 'omp flush' directive.
  /// \param Vars List of variables to flush.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGOpenMPRuntime::emitFlush">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp", line = 2654,
   FQN="clang::CodeGen::CGOpenMPRuntime::emitFlush", NM="_ZN5clang7CodeGen15CGOpenMPRuntime9emitFlushERNS0_15CodeGenFunctionEN4llvm8ArrayRefIPKNS_4ExprEEENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp -nm=_ZN5clang7CodeGen15CGOpenMPRuntime9emitFlushERNS0_15CodeGenFunctionEN4llvm8ArrayRefIPKNS_4ExprEEENS_14SourceLocationE")
  //</editor-fold>
  public void emitFlush(final CodeGenFunction /*&*/ CGF, ArrayRef</*const*/ Expr /*P*/ > $Prm1, 
           SourceLocation Loc) {
    if (!CGF.HaveInsertPoint()) {
      return;
    }
    // Build call void __kmpc_flush(ident_t *loc)
    CGF.EmitRuntimeCall(createRuntimeFunction(OpenMPRTLFunction.OMPRTL__kmpc_flush.getValue()), 
        new ArrayRef<Value /*P*/ >(emitUpdateLocation(CGF, new SourceLocation(Loc)), true));
  }

  
  /// \brief Emit task region for the task directive. The task region is
  /// emitted in several steps:
  /// 1. Emit a call to kmp_task_t *__kmpc_omp_task_alloc(ident_t *, kmp_int32
  /// gtid, kmp_int32 flags, size_t sizeof_kmp_task_t, size_t sizeof_shareds,
  /// kmp_routine_entry_t *task_entry). Here task_entry is a pointer to the
  /// function:
  /// kmp_int32 .omp_task_entry.(kmp_int32 gtid, kmp_task_t *tt) {
  ///   TaskFunction(gtid, tt->part_id, tt->shareds);
  ///   return 0;
  /// }
  /// 2. Copy a list of shared variables to field shareds of the resulting
  /// structure kmp_task_t returned by the previous call (if any).
  /// 3. Copy a pointer to destructions function to field destructions of the
  /// resulting structure kmp_task_t.
  /// 4. Emit a call to kmp_int32 __kmpc_omp_task(ident_t *, kmp_int32 gtid,
  /// kmp_task_t *new_task), where new_task is a resulting structure from
  /// previous items.
  /// \param D Current task directive.
  /// \param TaskFunction An LLVM function with type void (*)(i32 /*gtid*/, i32
  /// /*part_id*/, captured_struct */*__context*/);
  /// \param SharedsTy A type which contains references the shared variables.
  /// \param Shareds Context with the list of shared variables from the \p
  /// TaskFunction.
  /// \param IfCond Not a nullptr if 'if' clause was specified, nullptr
  /// otherwise.
  /// \param Data Additional data for task generation like tiednsee, final
  /// state, list of privates etc.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGOpenMPRuntime::emitTaskCall">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp", line = 3866,
   FQN="clang::CodeGen::CGOpenMPRuntime::emitTaskCall", NM="_ZN5clang7CodeGen15CGOpenMPRuntime12emitTaskCallERNS0_15CodeGenFunctionENS_14SourceLocationERKNS_22OMPExecutableDirectiveEPN4llvm5ValueENS_8QualTypeENS0_7AddressEPKNS_4ExprERKNS0_13OMPTaskDataTyE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp -nm=_ZN5clang7CodeGen15CGOpenMPRuntime12emitTaskCallERNS0_15CodeGenFunctionENS_14SourceLocationERKNS_22OMPExecutableDirectiveEPN4llvm5ValueENS_8QualTypeENS0_7AddressEPKNS_4ExprERKNS0_13OMPTaskDataTyE")
  //</editor-fold>
  public void emitTaskCall(final CodeGenFunction /*&*/ CGF, SourceLocation Loc, 
              final /*const*/ OMPExecutableDirective /*&*/ D, 
              Value /*P*/ TaskFunction, 
              QualType SharedsTy, Address Shareds, 
              /*const*/ Expr /*P*/ IfCond, 
              final /*const*/ OMPTaskDataTy /*&*/ Data) {
    if (!CGF.HaveInsertPoint()) {
      return;
    }
    
    TaskResultTy Result = emitTaskInit(CGF, new SourceLocation(Loc), D, TaskFunction, new QualType(SharedsTy), new Address(Shareds), Data);
    Value /*P*/ NewTask = Result.NewTask;
    Value /*P*/ TaskEntry = Result.TaskEntry;
    Value /*P*/ NewTaskNewTaskTTy = Result.NewTaskNewTaskTTy;
    LValue TDBase = new LValue(Result.TDBase);
    RecordDecl /*P*/ KmpTaskTQTyRD = Result.KmpTaskTQTyRD;
    final ASTContext /*&*/ C = CGM.getContext();
    // Process list of dependences.
    Address DependenciesArray = Address.invalid();
    /*uint*/int NumDependencies = Data.Dependences.size();
    if ((NumDependencies != 0)) {
      // Dependence kind for RTL.
      final class/*enum*/ RTLDependenceKindTy {
        private static final /*uint*/int DepIn = 0x01;
        private static final /*uint*/int DepInOut = 0x3;
      };
      final class/*enum*/ RTLDependInfoFieldsTy {
        private static final /*uint*/int BaseAddr = 0;
        private static final /*uint*/int Len = BaseAddr + 1;
        private static final /*uint*/int Flags = Len + 1;
      };
      RecordDecl /*P*/ KmpDependInfoRD;
      QualType FlagsTy = C.getIntTypeForBitwidth($ulong2uint(C.getTypeSize(C.BoolTy.$QualType())), /*Signed=*/ /*false*/0);
      org.llvm.ir.Type /*P*/ LLVMFlagsTy = CGF.ConvertTypeForMem(new QualType(FlagsTy));
      if (KmpDependInfoTy.isNull()) {
        KmpDependInfoRD = C.buildImplicitRecord(new StringRef(/*KEEP_STR*/"kmp_depend_info"));
        KmpDependInfoRD.startDefinition();
        CGOpenMPRuntimeStatics.addFieldToRecordDecl(C, KmpDependInfoRD, C.getIntPtrType());
        CGOpenMPRuntimeStatics.addFieldToRecordDecl(C, KmpDependInfoRD, C.getSizeType().$QualType());
        CGOpenMPRuntimeStatics.addFieldToRecordDecl(C, KmpDependInfoRD, new QualType(FlagsTy));
        KmpDependInfoRD.completeDefinition();
        KmpDependInfoTy.$assignMove(C.getRecordType(KmpDependInfoRD));
      } else {
        KmpDependInfoRD = cast_RecordDecl(KmpDependInfoTy.$arrow().getAsTagDecl());
      }
      CharUnits DependencySize = C.getTypeSizeInChars(/*NO_COPY*/KmpDependInfoTy);
      // Define type kmp_depend_info[<Dependences.size()>];
      QualType KmpDependInfoArrayTy = C.getConstantArrayType(new QualType(KmpDependInfoTy), new APInt(JD$UInt_ULong.INSTANCE/*numBits=*/ , 64, $uint2ulong(NumDependencies)), 
          org.clang.ast.ArrayType.ArraySizeModifier.Normal, /*IndexTypeQuals=*/ 0);
      // kmp_depend_info[<Dependences.size()>] deps;
      DependenciesArray.$assignMove(
          CGF.CreateMemTemp(new QualType(KmpDependInfoArrayTy), new Twine(/*KEEP_STR*/".dep.arr.addr"))
      );
      for (/*uint*/int i = 0; $less_uint(i, NumDependencies); ++i) {
        /*const*/ Expr /*P*/ E = Data.Dependences.$at$Const(i).second;
        LValue Addr = CGF.EmitLValue(E);
        Value /*P*/ Size;
        QualType Ty = E.getType();
        {
          /*const*/ OMPArraySectionExpr /*P*/ ASE = dyn_cast_OMPArraySectionExpr(E.IgnoreParenImpCasts$Const());
          if ((ASE != null)) {
            LValue UpAddrLVal = CGF.EmitOMPArraySectionExpr(ASE, /*LowerBound=*/ false);
            Value /*P*/ UpAddr = CGF.Builder.CreateConstGEP1_32(UpAddrLVal.getPointer(), /*Idx0=*/ 1);
            Value /*P*/ LowIntPtr = CGF.Builder.CreatePtrToInt(Addr.getPointer(), CGM.Unnamed_field8.SizeTy);
            Value /*P*/ UpIntPtr = CGF.Builder.CreatePtrToInt(UpAddr, CGM.Unnamed_field8.SizeTy);
            Size = CGF.Builder.CreateNUWSub(UpIntPtr, LowIntPtr);
          } else {
            Size = CGF.getTypeSize(new QualType(Ty));
          }
        }
        LValue Base = CGF.MakeAddrLValue(CGF.Builder.CreateConstArrayGEP(new Address(DependenciesArray), $uint2ulong(i), new CharUnits(DependencySize)), 
            new QualType(KmpDependInfoTy));
        // deps[i].base_addr = &<Dependences[i].second>;
        LValue BaseAddrLVal = CGF.EmitLValueForField(new LValue(Base), std.next(KmpDependInfoRD.field_begin(), RTLDependInfoFieldsTy.BaseAddr).$star());
        CGF.EmitStoreOfScalar(CGF.Builder.CreatePtrToInt(Addr.getPointer(), CGF.Unnamed_field8.IntPtrTy), 
            new LValue(BaseAddrLVal));
        // deps[i].len = sizeof(<Dependences[i].second>);
        LValue LenLVal = CGF.EmitLValueForField(new LValue(Base), std.next(KmpDependInfoRD.field_begin(), RTLDependInfoFieldsTy.Len).$star());
        CGF.EmitStoreOfScalar(Size, new LValue(LenLVal));
        // deps[i].flags = <Dependences[i].first>;
        /*RTLDependenceKindTy*//*uint*/int DepKind = 0;
        switch (Data.Dependences.$at$Const(i).first) {
         case OMPC_DEPEND_in:
          DepKind = RTLDependenceKindTy.DepIn;
          break;
         case OMPC_DEPEND_out:
         case OMPC_DEPEND_inout:
          // Out and InOut dependencies must use the same code.
          DepKind = RTLDependenceKindTy.DepInOut;
          break;
         case OMPC_DEPEND_source:
         case OMPC_DEPEND_sink:
         case OMPC_DEPEND_unknown:
          throw new llvm_unreachable("Unknown task dependence type");
        }
        LValue FlagsLVal = CGF.EmitLValueForField(new LValue(Base), std.next(KmpDependInfoRD.field_begin(), RTLDependInfoFieldsTy.Flags).$star());
        CGF.EmitStoreOfScalar(ConstantInt.get(LLVMFlagsTy, $uint2ulong(DepKind)), 
            new LValue(FlagsLVal));
      }
      DependenciesArray.$assignMove(CGF.Builder.CreatePointerBitCastOrAddrSpaceCast(CGF.Builder.CreateStructGEP(new Address(DependenciesArray), 0, CharUnits.Zero()), 
              CGF.Unnamed_field9.VoidPtrTy));
    }
    
    // NOTE: routine and part_id fields are intialized by __kmpc_omp_task_alloc()
    // libcall.
    // Build kmp_int32 __kmpc_omp_task_with_deps(ident_t *, kmp_int32 gtid,
    // kmp_task_t *new_task, kmp_int32 ndeps, kmp_depend_info_t *dep_list,
    // kmp_int32 ndeps_noalias, kmp_depend_info_t *noalias_dep_list) if dependence
    // list is not empty
    Value /*P*/ ThreadID = getThreadID(CGF, new SourceLocation(Loc));
    Value /*P*/ UpLoc = emitUpdateLocation(CGF, new SourceLocation(Loc));
    Value /*P*/ TaskArgs[/*3*/] = new Value /*P*/  [/*3*/] {UpLoc, ThreadID, NewTask};
    Value /*P*/ DepTaskArgs[/*7*/] = new Value /*P*/  [7];
    if ((NumDependencies != 0)) {
      DepTaskArgs[0] = UpLoc;
      DepTaskArgs[1] = ThreadID;
      DepTaskArgs[2] = NewTask;
      DepTaskArgs[3] = CGF.Builder.getInt32(NumDependencies);
      DepTaskArgs[4] = DependenciesArray.getPointer();
      DepTaskArgs[5] = CGF.Builder.getInt32(0);
      DepTaskArgs[6] = ConstantPointerNull.get(CGF.Unnamed_field9.VoidPtrTy);
    }
    RecordDecl L$KmpTaskTQTyRD = KmpTaskTQTyRD;
    LValue L$TDBase = TDBase;
    int L$NumDependencies = NumDependencies;
    final CodeGenFunctionPrePostActionTy2Void ThenCodeGen = /*[this, =L$Loc(Loc), &Data, =L$TDBase(TDBase), =L$KmpTaskTQTyRD(KmpTaskTQTyRD), =L$NumDependencies(NumDependencies), &TaskArgs, &DepTaskArgs]*/ (final CodeGenFunction /*&*/ CGF$1, final PrePostActionTy /*&*/ $Prm1) -> {
          if (!Data.Tied) {
            DeclContext.specific_decl_iterator<FieldDecl> PartIdFI = std.next(L$KmpTaskTQTyRD.field_begin(), KmpTaskTFields.KmpTaskTPartId.getValue());
            LValue PartIdLVal = CGF$1.EmitLValueForField(new LValue(L$TDBase), PartIdFI.$star());
            CGF$1.EmitStoreOfScalar(CGF$1.Builder.getInt32(0), new LValue(PartIdLVal));
          }
          if ((L$NumDependencies != 0)) {
            CGF$1.EmitRuntimeCall(createRuntimeFunction(OpenMPRTLFunction.OMPRTL__kmpc_omp_task_with_deps.getValue()), new ArrayRef<Value /*P*/ >(DepTaskArgs, true));
          } else {
            CGF$1.EmitRuntimeCall(createRuntimeFunction(OpenMPRTLFunction.OMPRTL__kmpc_omp_task.getValue()), 
                new ArrayRef<Value /*P*/ >(TaskArgs, true));
          }
          {
            // Check if parent region is untied and build return for untied task;
            CGOpenMPRegionInfo /*P*/ Region = dyn_cast_or_null_CGOpenMPRegionInfo(CGF$1.CapturedStmtInfo);
            if ((Region != null)) {
              Region.emitUntiedSwitch(CGF$1);
            }
          }
        };
    
    Value /*P*/ DepWaitTaskArgs[/*6*/] = new Value /*P*/  [6];
    if ((NumDependencies != 0)) {
      DepWaitTaskArgs[0] = UpLoc;
      DepWaitTaskArgs[1] = ThreadID;
      DepWaitTaskArgs[2] = CGF.Builder.getInt32(NumDependencies);
      DepWaitTaskArgs[3] = DependenciesArray.getPointer();
      DepWaitTaskArgs[4] = CGF.Builder.getInt32(0);
      DepWaitTaskArgs[5] = ConstantPointerNull.get(CGF.Unnamed_field9.VoidPtrTy);
    }
    Value L$ThreadID = ThreadID;
    Value L$NewTaskNewTaskTTy = NewTaskNewTaskTTy;
    Value L$TaskEntry = TaskEntry;
    final CodeGenFunctionPrePostActionTy2Void ElseCodeGen = /*[&TaskArgs, =L$ThreadID(ThreadID), =L$NewTaskNewTaskTTy(NewTaskNewTaskTTy), =L$TaskEntry(TaskEntry), =L$NumDependencies(NumDependencies), &DepWaitTaskArgs]*/ (final CodeGenFunction /*&*/ CGF$1, final PrePostActionTy /*&*/ $Prm1) -> {
          CodeGenFunction.RunCleanupsScope LocalScope = null;
          CommonActionTy Action = null;
          try {
            final CGOpenMPRuntime /*&*/ RT = CGF$1.CGM.getOpenMPRuntime();
            LocalScope/*J*/= new CodeGenFunction.RunCleanupsScope(CGF$1);
            // Build void __kmpc_omp_wait_deps(ident_t *, kmp_int32 gtid,
            // kmp_int32 ndeps, kmp_depend_info_t *dep_list, kmp_int32
            // ndeps_noalias, kmp_depend_info_t *noalias_dep_list); if dependence info
            // is specified.
            if ((L$NumDependencies != 0)) {
              CGF$1.EmitRuntimeCall(RT.createRuntimeFunction(OpenMPRTLFunction.OMPRTL__kmpc_omp_wait_deps.getValue()), 
                  new ArrayRef<Value /*P*/ >(DepWaitTaskArgs, true));
            }
            // Call proxy_task_entry(gtid, new_task);
            final CodeGenFunctionPrePostActionTy2Void CodeGen = /*[=L$L$TaskEntry(L$TaskEntry), =L$L$ThreadID(L$ThreadID), =L$L$NewTaskNewTaskTTy(L$NewTaskNewTaskTTy)]*/ (final CodeGenFunction /*&*/ CGF$2, final PrePostActionTy /*&*/ Action$1) -> {
                  Action$1.Enter(CGF$2);
                  Value /*P*/ OutlinedFnArgs[/*2*/] = new Value /*P*/  [/*2*/] {L$ThreadID, L$NewTaskNewTaskTTy};
                  CGF$2.EmitCallOrInvoke(L$TaskEntry, new ArrayRef<Value /*P*/ >(OutlinedFnArgs, true));
                };
            
            // Build void __kmpc_omp_task_begin_if0(ident_t *, kmp_int32 gtid,
            // kmp_task_t *new_task);
            // Build void __kmpc_omp_task_complete_if0(ident_t *, kmp_int32 gtid,
            // kmp_task_t *new_task);
            RegionCodeGenTy RCG/*J*/= new RegionCodeGenTy(JD$NotSameRegionCodeGenTy.INSTANCE, CodeGen);
            Action/*J*/= new CommonActionTy(RT.createRuntimeFunction(OpenMPRTLFunction.OMPRTL__kmpc_omp_task_begin_if0.getValue()), new ArrayRef<Value /*P*/ >(TaskArgs, true), 
                RT.createRuntimeFunction(OpenMPRTLFunction.OMPRTL__kmpc_omp_task_complete_if0.getValue()), new ArrayRef<Value /*P*/ >(TaskArgs, true));
            RCG.setAction(Action);
            RCG.$call(CGF$1);
          } finally {
            if (Action != null) { Action.$destroy(); }
            if (LocalScope != null) { LocalScope.$destroy(); }
          }
        };
    if ((IfCond != null)) {
      CGOpenMPRuntimeStatics.emitOMPIfClause(CGF, IfCond, new RegionCodeGenTy(JD$NotSameRegionCodeGenTy.INSTANCE, ThenCodeGen), new RegionCodeGenTy(JD$NotSameRegionCodeGenTy.INSTANCE, ElseCodeGen));
    } else {
      RegionCodeGenTy ThenRCG/*J*/= new RegionCodeGenTy(JD$NotSameRegionCodeGenTy.INSTANCE, ThenCodeGen);
      ThenRCG.$call(CGF);
    }
  }

  
  /// Emit task region for the taskloop directive. The taskloop region is
  /// emitted in several steps:
  /// 1. Emit a call to kmp_task_t *__kmpc_omp_task_alloc(ident_t *, kmp_int32
  /// gtid, kmp_int32 flags, size_t sizeof_kmp_task_t, size_t sizeof_shareds,
  /// kmp_routine_entry_t *task_entry). Here task_entry is a pointer to the
  /// function:
  /// kmp_int32 .omp_task_entry.(kmp_int32 gtid, kmp_task_t *tt) {
  ///   TaskFunction(gtid, tt->part_id, tt->shareds);
  ///   return 0;
  /// }
  /// 2. Copy a list of shared variables to field shareds of the resulting
  /// structure kmp_task_t returned by the previous call (if any).
  /// 3. Copy a pointer to destructions function to field destructions of the
  /// resulting structure kmp_task_t.
  /// 4. Emit a call to void __kmpc_taskloop(ident_t *loc, int gtid, kmp_task_t
  /// *task, int if_val, kmp_uint64 *lb, kmp_uint64 *ub, kmp_int64 st, int
  /// nogroup, int sched, kmp_uint64 grainsize, void *task_dup ), where new_task
  /// is a resulting structure from
  /// previous items.
  /// \param D Current task directive.
  /// \param TaskFunction An LLVM function with type void (*)(i32 /*gtid*/, i32
  /// /*part_id*/, captured_struct */*__context*/);
  /// \param SharedsTy A type which contains references the shared variables.
  /// \param Shareds Context with the list of shared variables from the \p
  /// TaskFunction.
  /// \param IfCond Not a nullptr if 'if' clause was specified, nullptr
  /// otherwise.
  /// \param Data Additional data for task generation like tiednsee, final
  /// state, list of privates etc.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGOpenMPRuntime::emitTaskLoopCall">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp", line = 4056,
   FQN="clang::CodeGen::CGOpenMPRuntime::emitTaskLoopCall", NM="_ZN5clang7CodeGen15CGOpenMPRuntime16emitTaskLoopCallERNS0_15CodeGenFunctionENS_14SourceLocationERKNS_16OMPLoopDirectiveEPN4llvm5ValueENS_8QualTypeENS0_7AddressEPKNS_4ExprERKNS0_13OMPTaskDataTyE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp -nm=_ZN5clang7CodeGen15CGOpenMPRuntime16emitTaskLoopCallERNS0_15CodeGenFunctionENS_14SourceLocationERKNS_16OMPLoopDirectiveEPN4llvm5ValueENS_8QualTypeENS0_7AddressEPKNS_4ExprERKNS0_13OMPTaskDataTyE")
  //</editor-fold>
  public void emitTaskLoopCall(final CodeGenFunction /*&*/ CGF, SourceLocation Loc, 
                  final /*const*/ OMPLoopDirective /*&*/ D, 
                  Value /*P*/ TaskFunction, 
                  QualType SharedsTy, Address Shareds, 
                  /*const*/ Expr /*P*/ IfCond, 
                  final /*const*/ OMPTaskDataTy /*&*/ Data) {
    if (!CGF.HaveInsertPoint()) {
      return;
    }
    TaskResultTy Result = emitTaskInit(CGF, new SourceLocation(Loc), D, TaskFunction, new QualType(SharedsTy), new Address(Shareds), Data);
    // NOTE: routine and part_id fields are intialized by __kmpc_omp_task_alloc()
    // libcall.
    // Call to void __kmpc_taskloop(ident_t *loc, int gtid, kmp_task_t *task, int
    // if_val, kmp_uint64 *lb, kmp_uint64 *ub, kmp_int64 st, int nogroup, int
    // sched, kmp_uint64 grainsize, void *task_dup);
    Value /*P*/ ThreadID = getThreadID(CGF, new SourceLocation(Loc));
    Value /*P*/ UpLoc = emitUpdateLocation(CGF, new SourceLocation(Loc));
    Value /*P*/ IfVal;
    if ((IfCond != null)) {
      IfVal = CGF.Builder.CreateIntCast(CGF.EvaluateExprAsBool(IfCond), CGF.IntTy, 
          /*isSigned=*/ true);
    } else {
      IfVal = ConstantInt.getSigned(CGF.IntTy, /*V=*/ 1);
    }
    
    LValue LBLVal = CGF.EmitLValueForField(new LValue(Result.TDBase), 
        std.next(Result.KmpTaskTQTyRD.field_begin(), KmpTaskTFields.KmpTaskTLowerBound.getValue()).$star());
    VarDecl /*P*/ LBVar = cast_VarDecl(cast_DeclRefExpr(D.getLowerBoundVariable()).getDecl());
    CGF.EmitAnyExprToMem(LBVar.getInit(), LBLVal.getAddress(), new Qualifiers(LBLVal.getQuals()), 
        /*IsInitializer=*/ true);
    LValue UBLVal = CGF.EmitLValueForField(new LValue(Result.TDBase), 
        std.next(Result.KmpTaskTQTyRD.field_begin(), KmpTaskTFields.KmpTaskTUpperBound.getValue()).$star());
    VarDecl /*P*/ UBVar = cast_VarDecl(cast_DeclRefExpr(D.getUpperBoundVariable()).getDecl());
    CGF.EmitAnyExprToMem(UBVar.getInit(), UBLVal.getAddress(), new Qualifiers(UBLVal.getQuals()), 
        /*IsInitializer=*/ true);
    LValue StLVal = CGF.EmitLValueForField(new LValue(Result.TDBase), 
        std.next(Result.KmpTaskTQTyRD.field_begin(), KmpTaskTFields.KmpTaskTStride.getValue()).$star());
    VarDecl /*P*/ StVar = cast_VarDecl(cast_DeclRefExpr(D.getStrideVariable()).getDecl());
    CGF.EmitAnyExprToMem(StVar.getInit(), StLVal.getAddress(), new Qualifiers(StLVal.getQuals()), 
        /*IsInitializer=*/ true);
    /*enum ANONYMOUS_INT_CONSTANTS {*/
      final /*uint*/int NoSchedule = 0;
      final /*uint*/int Grainsize = 1;
      final /*uint*/int NumTasks = 2;
    /*}*/;
    Value /*P*/ TaskArgs[/*11*/] = new Value /*P*/  [/*11*/] {
      UpLoc, ThreadID, Result.NewTask, IfVal, LBLVal.getPointer(), 
      UBLVal.getPointer(), CGF.EmitLoadOfScalar(new LValue(StLVal), new SourceLocation()), 
      ConstantInt.getSigned(CGF.IntTy, Data.Nogroup ? 1 : 0), 
      ConstantInt.getSigned(CGF.IntTy, $uint2long((Data.Schedule.getPointer() != null) ? Data.Schedule.getInt() ? NumTasks : Grainsize : NoSchedule)), 
      (Data.Schedule.getPointer() != null) ? CGF.Builder.CreateIntCast(Data.Schedule.getPointer(), CGF.Int64Ty, 
          /*isSigned=*/ false) : ConstantInt.get(CGF.Int64Ty, /*V=*/ $int2ulong(0)), 
      (Result.TaskDupFn != null) ? CGF.Builder.CreatePointerBitCastOrAddrSpaceCast(Result.TaskDupFn, 
          CGF.Unnamed_field9.VoidPtrTy) : ConstantPointerNull.get(CGF.Unnamed_field9.VoidPtrTy)
    };
    CGF.EmitRuntimeCall(createRuntimeFunction(OpenMPRTLFunction.OMPRTL__kmpc_taskloop.getValue()), new ArrayRef<Value /*P*/ >(TaskArgs, true));
  }

  
  /// \brief Emit code for the directive that does not require outlining.
  ///
  /// \param InnermostKind Kind of innermost directive (for simple directives it
  /// is a directive itself, for combined - its innermost directive).
  /// \param CodeGen Code generation sequence for the \a D directive.
  /// \param HasCancel true if region has inner cancel directive, false
  /// otherwise.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGOpenMPRuntime::emitInlinedDirective">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp", line = 4634,
   FQN="clang::CodeGen::CGOpenMPRuntime::emitInlinedDirective", NM="_ZN5clang7CodeGen15CGOpenMPRuntime20emitInlinedDirectiveERNS0_15CodeGenFunctionENS_19OpenMPDirectiveKindERKNS0_15RegionCodeGenTyEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp -nm=_ZN5clang7CodeGen15CGOpenMPRuntime20emitInlinedDirectiveERNS0_15CodeGenFunctionENS_19OpenMPDirectiveKindERKNS0_15RegionCodeGenTyEb")
  //</editor-fold>
  public void emitInlinedDirective(final CodeGenFunction /*&*/ CGF, 
                      OpenMPDirectiveKind InnerKind, 
                      final /*const*/ RegionCodeGenTy /*&*/ CodeGen) {
    emitInlinedDirective(CGF, 
                      InnerKind, 
                      CodeGen, 
                      false);
  }
  public void emitInlinedDirective(final CodeGenFunction /*&*/ CGF, 
                      OpenMPDirectiveKind InnerKind, 
                      final /*const*/ RegionCodeGenTy /*&*/ CodeGen, 
                      boolean HasCancel/*= false*/) {
    InlinedOpenMPRegionRAII Region = null;
    try {
      if (!CGF.HaveInsertPoint()) {
        return;
      }
      Region/*J*/= new InlinedOpenMPRegionRAII(CGF, CodeGen, InnerKind, HasCancel);
      CGF.CapturedStmtInfo.EmitBody(CGF, /*S=*/ (/*const*/ Stmt /*P*/ )null);
    } finally {
      if (Region != null) { Region.$destroy(); }
    }
  }

  /// \brief Emit a code for reduction clause. Next code should be emitted for
  /// reduction:
  /// \code
  ///
  /// static kmp_critical_name lock = { 0 };
  ///
  /// void reduce_func(void *lhs[<n>], void *rhs[<n>]) {
  ///  ...
  ///  *(Type<i>*)lhs[i] = RedOp<i>(*(Type<i>*)lhs[i], *(Type<i>*)rhs[i]);
  ///  ...
  /// }
  ///
  /// ...
  /// void *RedList[<n>] = {&<RHSExprs>[0], ..., &<RHSExprs>[<n>-1]};
  /// switch (__kmpc_reduce{_nowait}(<loc>, <gtid>, <n>, sizeof(RedList),
  /// RedList, reduce_func, &<lock>)) {
  /// case 1:
  ///  ...
  ///  <LHSExprs>[i] = RedOp<i>(*<LHSExprs>[i], *<RHSExprs>[i]);
  ///  ...
  /// __kmpc_end_reduce{_nowait}(<loc>, <gtid>, &<lock>);
  /// break;
  /// case 2:
  ///  ...
  ///  Atomic(<LHSExprs>[i] = RedOp<i>(*<LHSExprs>[i], *<RHSExprs>[i]));
  ///  ...
  /// break;
  /// default:;
  /// }
  /// \endcode
  ///
  /// \param Privates List of private copies for original reduction arguments.
  /// \param LHSExprs List of LHS in \a ReductionOps reduction operations.
  /// \param RHSExprs List of RHS in \a ReductionOps reduction operations.
  /// \param ReductionOps List of reduction operations in form 'LHS binop RHS'
  /// or 'operator binop(LHS, RHS)'.
  /// \param WithNowait true if parent directive has also nowait clause, false
  /// otherwise.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGOpenMPRuntime::emitReduction">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp", line = 4328,
   FQN="clang::CodeGen::CGOpenMPRuntime::emitReduction", NM="_ZN5clang7CodeGen15CGOpenMPRuntime13emitReductionERNS0_15CodeGenFunctionENS_14SourceLocationEN4llvm8ArrayRefIPKNS_4ExprEEESA_SA_SA_bb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp -nm=_ZN5clang7CodeGen15CGOpenMPRuntime13emitReductionERNS0_15CodeGenFunctionENS_14SourceLocationEN4llvm8ArrayRefIPKNS_4ExprEEESA_SA_SA_bb")
  //</editor-fold>
  public void emitReduction(final CodeGenFunction /*&*/ CGF, SourceLocation Loc, 
               ArrayRef</*const*/ Expr /*P*/ > Privates, 
               ArrayRef</*const*/ Expr /*P*/ > LHSExprs, 
               ArrayRef</*const*/ Expr /*P*/ > RHSExprs, 
               ArrayRef</*const*/ Expr /*P*/ > ReductionOps, 
               boolean WithNowait, boolean SimpleReduction) {
    CommonActionTy Action = null;
    try {
      if (!CGF.HaveInsertPoint()) {
        return;
      }
      // Next code should be emitted for reduction:
      //
      // static kmp_critical_name lock = { 0 };
      //
      // void reduce_func(void *lhs[<n>], void *rhs[<n>]) {
      //  *(Type0*)lhs[0] = ReductionOperation0(*(Type0*)lhs[0], *(Type0*)rhs[0]);
      //  ...
      //  *(Type<n>-1*)lhs[<n>-1] = ReductionOperation<n>-1(*(Type<n>-1*)lhs[<n>-1],
      //  *(Type<n>-1*)rhs[<n>-1]);
      // }
      //
      // ...
      // void *RedList[<n>] = {&<RHSExprs>[0], ..., &<RHSExprs>[<n>-1]};
      // switch (__kmpc_reduce{_nowait}(<loc>, <gtid>, <n>, sizeof(RedList),
      // RedList, reduce_func, &<lock>)) {
      // case 1:
      //  ...
      //  <LHSExprs>[i] = RedOp<i>(*<LHSExprs>[i], *<RHSExprs>[i]);
      //  ...
      // __kmpc_end_reduce{_nowait}(<loc>, <gtid>, &<lock>);
      // break;
      // case 2:
      //  ...
      //  Atomic(<LHSExprs>[i] = RedOp<i>(*<LHSExprs>[i], *<RHSExprs>[i]));
      //  ...
      // [__kmpc_end_reduce(<loc>, <gtid>, &<lock>);]
      // break;
      // default:;
      // }
      //
      // if SimpleReduction is true, only the next code is generated:
      //  ...
      //  <LHSExprs>[i] = RedOp<i>(*<LHSExprs>[i], *<RHSExprs>[i]);
      //  ...
      final ASTContext /*&*/ C = CGM.getContext();
      if (SimpleReduction) {
        CodeGenFunction.RunCleanupsScope Scope = null;
        try {
          Scope/*J*/= new CodeGenFunction.RunCleanupsScope(CGF);
          type$ptr</*const*/ Expr /*P*/ /*const*/ /*P*/> IPriv = $tryClone(Privates.begin());
          type$ptr</*const*/ Expr /*P*/ /*const*/ /*P*/> ILHS = $tryClone(LHSExprs.begin());
          type$ptr</*const*/ Expr /*P*/ /*const*/ /*P*/> IRHS = $tryClone(RHSExprs.begin());
          for (/*const*/ Expr /*P*/ E : ReductionOps) {
            CGOpenMPRuntimeStatics.emitSingleReductionCombiner(CGF, E, IPriv.$star(), cast_DeclRefExpr(ILHS.$star()), 
                cast_DeclRefExpr(IRHS.$star()));
            IPriv.$preInc();
            ILHS.$preInc();
            IRHS.$preInc();
          }
          return;
        } finally {
          if (Scope != null) { Scope.$destroy(); }
        }
      }
      
      // 1. Build a list of reduction variables.
      // void *RedList[<n>] = {<ReductionVars>[0], ..., <ReductionVars>[<n>-1]};
      /*size_t*/int Size = RHSExprs.size();
      for (/*const*/ Expr /*P*/ E : Privates) {
        if (E.getType().$arrow().isVariablyModifiedType()) {
          // Reserve place for array size.
          ++Size;
        }
      }
      APInt ArraySize/*J*/= new APInt(JD$UInt_ULong.INSTANCE/*unsigned int numBits=*/ , 32, $uint2ulong(Size));
      QualType ReductionArrayTy = C.getConstantArrayType(C.VoidPtrTy.$QualType(), ArraySize, org.clang.ast.ArrayType.ArraySizeModifier.Normal, 
          /*IndexTypeQuals=*/ 0);
      Address ReductionList = CGF.CreateMemTemp(new QualType(ReductionArrayTy), new Twine(/*KEEP_STR*/".omp.reduction.red_list"));
      type$ptr</*const*/ Expr /*P*/ /*const*/ /*P*/> IPriv = $tryClone(Privates.begin());
      /*uint*/int Idx = 0;
      for (/*uint*/int I = 0, E = RHSExprs.size(); $less_uint(I, E); ++I , IPriv.$preInc() , ++Idx) {
        Address Elem = CGF.Builder.CreateConstArrayGEP(new Address(ReductionList), $uint2ulong(Idx), CGF.getPointerSize());
        CGF.Builder.CreateStore(CGF.Builder.CreatePointerBitCastOrAddrSpaceCast(CGF.EmitLValue(RHSExprs.$at(I)).getPointer(), CGF.Unnamed_field9.VoidPtrTy), 
            new Address(Elem));
        if ((IPriv.$star()).getType().$arrow().isVariablyModifiedType()) {
          // Store array size.
          ++Idx;
          Elem.$assignMove(CGF.Builder.CreateConstArrayGEP(new Address(ReductionList), $uint2ulong(Idx), 
                  CGF.getPointerSize()));
          Value /*P*/ Size$1 = CGF.Builder.CreateIntCast(CGF.getVLASize(CGF.getContext().getAsVariableArrayType((IPriv.$star()).getType())).
                  first, 
              CGF.Unnamed_field8.SizeTy, /*isSigned=*/ false);
          CGF.Builder.CreateStore(CGF.Builder.CreateIntToPtr(Size$1, CGF.Unnamed_field9.VoidPtrTy), 
              new Address(Elem));
        }
      }
      
      // 2. Emit reduce_func().
      Value /*P*/ ReductionFn = CGOpenMPRuntimeStatics.emitReductionFunction(CGM, CGF.ConvertTypeForMem(new QualType(ReductionArrayTy)).getPointerTo(), new ArrayRef</*const*/ Expr /*P*/ >(Privates), 
          new ArrayRef</*const*/ Expr /*P*/ >(LHSExprs), new ArrayRef</*const*/ Expr /*P*/ >(RHSExprs), new ArrayRef</*const*/ Expr /*P*/ >(ReductionOps));
      
      // 3. Create static kmp_critical_name lock = { 0 };
      Value /*P*/ Lock = getCriticalRegionLock(new StringRef(/*KEEP_STR*/".reduction"));
      
      // 4. Build res = __kmpc_reduce{_nowait}(<loc>, <gtid>, <n>, sizeof(RedList),
      // RedList, reduce_func, &<lock>);
      Value /*P*/ IdentTLoc = emitUpdateLocation(CGF, new SourceLocation(Loc), OpenMPLocationFlags.OMP_ATOMIC_REDUCE);
      Value /*P*/ ThreadId = getThreadID(CGF, new SourceLocation(Loc));
      Value /*P*/ ReductionArrayTySize = CGF.getTypeSize(new QualType(ReductionArrayTy));
      Value /*P*/ RL = CGF.Builder.CreatePointerBitCastOrAddrSpaceCast(ReductionList.getPointer(), 
          CGF.Unnamed_field9.VoidPtrTy);
      Value /*P*/ Args[/*7*/] = new Value /*P*/  [/*7*/] {
        IdentTLoc,  // ident_t *<loc>
        ThreadId,  // i32 <gtid>
        CGF.Builder.getInt32(RHSExprs.size()),  // i32 <n>
        ReductionArrayTySize,  // size_type sizeof(RedList)
        RL,  // void *RedList
        ReductionFn,  // void (*) (void *, void *) <reduce_func>
        Lock // kmp_critical_name *&<lock>
      };
      CallInst /*P*/ Res = CGF.EmitRuntimeCall(createRuntimeFunction((WithNowait ? OpenMPRTLFunction.OMPRTL__kmpc_reduce_nowait : OpenMPRTLFunction.OMPRTL__kmpc_reduce).getValue()), 
          new ArrayRef<Value /*P*/ >(Args, true));
      
      // 5. Build switch(res)
      BasicBlock /*P*/ DefaultBB = CGF.createBasicBlock(new Twine(/*KEEP_STR*/".omp.reduction.default"));
      SwitchInst /*P*/ SwInst = CGF.Builder.CreateSwitch(Res, DefaultBB, /*NumCases=*/ 2);
      
      // 6. Build case 1:
      //  ...
      //  <LHSExprs>[i] = RedOp<i>(*<LHSExprs>[i], *<RHSExprs>[i]);
      //  ...
      // __kmpc_end_reduce{_nowait}(<loc>, <gtid>, &<lock>);
      // break;
      BasicBlock /*P*/ Case1BB = CGF.createBasicBlock(new Twine(/*KEEP_STR*/".omp.reduction.case1"));
      SwInst.addCase(CGF.Builder.getInt32(1), Case1BB);
      CGF.EmitBlock(Case1BB);
      
      // Add emission of __kmpc_end_reduce{_nowait}(<loc>, <gtid>, &<lock>);
      Value /*P*/ EndArgs[/*3*/] = new Value /*P*/  [/*3*/] {
        IdentTLoc,  // ident_t *<loc>
        ThreadId,  // i32 <gtid>
        Lock // kmp_critical_name *&<lock>
      };
      final CodeGenFunctionPrePostActionTy2Void CodeGen = /*[&Privates, &LHSExprs, &RHSExprs, &ReductionOps]*/ (final CodeGenFunction /*&*/ CGF$1, final PrePostActionTy /*&*/ Action$1) -> {
            type$ptr</*const*/ Expr /*P*/ /*const*/ /*P*/> IPriv$1 = $tryClone(Privates.begin());
            type$ptr</*const*/ Expr /*P*/ /*const*/ /*P*/> ILHS = $tryClone(LHSExprs.begin());
            type$ptr</*const*/ Expr /*P*/ /*const*/ /*P*/> IRHS = $tryClone(RHSExprs.begin());
            for (/*const*/ Expr /*P*/ E : ReductionOps) {
              CGOpenMPRuntimeStatics.emitSingleReductionCombiner(CGF$1, E, IPriv$1.$star(), cast_DeclRefExpr(ILHS.$star()), 
                  cast_DeclRefExpr(IRHS.$star()));
              IPriv$1.$preInc();
              ILHS.$preInc();
              IRHS.$preInc();
            }
          };
      RegionCodeGenTy RCG/*J*/= new RegionCodeGenTy(JD$NotSameRegionCodeGenTy.INSTANCE, CodeGen);
      Action/*J*/= new CommonActionTy((Value /*P*/ )null, new ArrayRef<Value /*P*/ >(llvm.None, true), 
          createRuntimeFunction((WithNowait ? OpenMPRTLFunction.OMPRTL__kmpc_end_reduce_nowait : OpenMPRTLFunction.OMPRTL__kmpc_end_reduce).getValue()), 
          new ArrayRef<Value /*P*/ >(EndArgs, true));
      RCG.setAction(Action);
      RCG.$call(CGF);
      
      CGF.EmitBranch(DefaultBB);
      
      // 7. Build case 2:
      //  ...
      //  Atomic(<LHSExprs>[i] = RedOp<i>(*<LHSExprs>[i], *<RHSExprs>[i]));
      //  ...
      // break;
      BasicBlock /*P*/ Case2BB = CGF.createBasicBlock(new Twine(/*KEEP_STR*/".omp.reduction.case2"));
      SwInst.addCase(CGF.Builder.getInt32(2), Case2BB);
      CGF.EmitBlock(Case2BB);
      
      final CodeGenFunctionPrePostActionTy2Void AtomicCodeGen = /*[=L$Loc(Loc), &Privates, &LHSExprs, &RHSExprs, &ReductionOps]*/ (final CodeGenFunction /*&*/ CGF$1, final PrePostActionTy /*&*/ Action$1) -> {
            type$ptr</*const*/ Expr /*P*/ /*const*/ /*P*/> ILHS = $tryClone(LHSExprs.begin());
            type$ptr</*const*/ Expr /*P*/ /*const*/ /*P*/> IRHS = $tryClone(RHSExprs.begin());
            type$ptr</*const*/ Expr /*P*/ /*const*/ /*P*/> IPriv$1 = $tryClone(Privates.begin());
            for (/*const*/ Expr /*P*/ E : ReductionOps) {
              /*const*/ Expr /*P*/ XExpr = null;
              /*const*/ Expr /*P*/ EExpr = null;
              /*const*/ Expr /*P*/ UpExpr = null;
              BinaryOperatorKind BO = BinaryOperatorKind.BO_Comma;
              {
                /*const*/ org.clang.ast.BinaryOperator /*P*/ BO$1 = dyn_cast_BinaryOperator(E);
                if ((BO$1 != null)) {
                  if (BO$1.getOpcode() == BinaryOperatorKind.BO_Assign) {
                    XExpr = BO$1.getLHS();
                    UpExpr = BO$1.getRHS();
                  }
                }
              }
              // Try to emit update expression as a simple atomic.
              /*const*/ Expr /*P*/ RHSExpr = UpExpr;
              if ((RHSExpr != null)) {
                {
                  // Analyze RHS part of the whole expression.
                  /*const*/ AbstractConditionalOperator /*P*/ ACO = dyn_cast_AbstractConditionalOperator(RHSExpr.IgnoreParenImpCasts$Const());
                  if ((ACO != null)) {
                    // If this is a conditional operator, analyze its condition for
                    // min/max reduction operator.
                    RHSExpr = ACO.getCond();
                  }
                }
                {
                  /*const*/ org.clang.ast.BinaryOperator /*P*/ BORHS = dyn_cast_BinaryOperator(RHSExpr.IgnoreParenImpCasts$Const());
                  if ((BORHS != null)) {
                    EExpr = BORHS.getRHS();
                    BO = BORHS.getOpcode();
                  }
                }
              }
              if ((XExpr != null)) {
                /*const*/ VarDecl /*P*/ VD = cast_VarDecl(cast_DeclRefExpr(ILHS.$star()).getDecl$Const());
                BinaryOperatorKind L$BO = BO;
                SourceLocation L$Loc = Loc;
                VarDecl L$VD = VD;
                final CodeGenFunction.ThreeExpr2Void/*const*/ AtomicRedGen = /*[=L$BO(BO), =L$VD(VD), =L$IPriv$1(IPriv$1), =L$L$Loc(L$Loc)]*/ (final CodeGenFunction /*&*/ CGF$2, /*const*/ Expr /*P*/ XExpr$1, /*const*/ Expr /*P*/ EExpr$1, /*const*/ Expr /*P*/ UpExpr$1) -> {
                      LValue X = CGF$2.EmitLValue(XExpr$1);
                      RValue E$1/*J*/= new RValue();
                      if ((EExpr$1 != null)) {
                        E$1.$assignMove(CGF$2.EmitAnyExpr(EExpr$1));
                      }
                      CGF$2.EmitOMPAtomicSimpleUpdateExpr(new LValue(X), new RValue(E$1), L$BO, /*IsXLHSInRHSPart=*/ true, 
                          AtomicOrdering.Monotonic, new SourceLocation(L$Loc), 
                          /*FuncArg*//*[&CGF, =L$UpExpr$1(UpExpr$1), =L$L$VD(L$VD), =L$IPriv$1(IPriv$1), =L$L$Loc(L$Loc)]*/ (RValue XRValue) -> {
                                CodeGenFunction.OMPPrivateScope PrivateScope = null;
                                try {
                                  PrivateScope/*J*/= new CodeGenFunction.OMPPrivateScope(CGF$2);
                                  RValue L$XRValue = XRValue;
                                  PrivateScope.addPrivate(L$VD, /*FuncArg*//*[&CGF, =L$L$VD(L$VD), =L$XRValue(XRValue), =L$L$Loc(L$Loc)]*/ () -> {
                                            Address LHSTemp = CGF$2.CreateMemTemp(L$VD.getType());
                                            CGF$2.emitOMPSimpleStore(CGF$2.MakeAddrLValue(new Address(LHSTemp), L$VD.getType()), new RValue(L$XRValue), 
                                                L$VD.getType().getNonReferenceType(), new SourceLocation(L$Loc));
                                            return LHSTemp;
                                          });
                                  /*J:(void)*/PrivateScope.Privatize();
                                  return CGF$2.EmitAnyExpr(UpExpr$1);
                                } finally {
                                  if (PrivateScope != null) { PrivateScope.$destroy(); }
                                }
                              });
                    };
                if ((IPriv$1.$star()).getType().$arrow().isArrayType()) {
                  // Emit atomic reduction for array section.
                  /*const*/ VarDecl /*P*/ RHSVar = cast_VarDecl(cast_DeclRefExpr(IRHS.$star()).getDecl$Const());
                  CGOpenMPRuntimeStatics.EmitOMPAggregateReduction(CGF$1, (IPriv$1.$star()).getType(), VD, RHSVar, 
                      /*FuncArg*/AtomicRedGen, XExpr, EExpr, UpExpr);
                } else {
                  // Emit atomic reduction for array subscript or single variable.
                  AtomicRedGen.$call(CGF$1, XExpr, EExpr, UpExpr);
                }
              } else {
                // Emit as a critical region.
                Expr L$E = E;
                SourceLocation L$Loc = Loc;
                final CodeGenFunction.ThreeExpr2Void/*const*/ CritRedGen = /*[=L$E(E), =L$L$Loc(L$Loc)]*/ (final CodeGenFunction /*&*/ CGF$2, /*const*/ Expr /*P*/ $Prm1, /*const*/ Expr /*P*/ $Prm2, /*const*/ Expr /*P*/ $Prm3) -> {
                      final CGOpenMPRuntime /*&*/ RT = CGF$2.CGM.getOpenMPRuntime();
                      CodeGenFunctionPrePostActionTy2Void caller = /*[=, =L$L$E(L$E)]*/ (final CodeGenFunction /*&*/ CGF$3, final PrePostActionTy /*&*/ Action$2) -> {
                        Action$2.Enter(CGF$3);
                        CGOpenMPRuntimeStatics.emitReductionCombiner(CGF$3, L$E);
                      };
                      RT.emitCriticalRegion(CGF$2, new StringRef(/*KEEP_STR*/".atomic_reduction"), 
                          new RegionCodeGenTy(JD$NotSameRegionCodeGenTy.INSTANCE, caller), 
                          new SourceLocation(L$Loc));
                    };
                if ((IPriv$1.$star()).getType().$arrow().isArrayType()) {
                  /*const*/ VarDecl /*P*/ LHSVar = cast_VarDecl(cast_DeclRefExpr(ILHS.$star()).getDecl$Const());
                  /*const*/ VarDecl /*P*/ RHSVar = cast_VarDecl(cast_DeclRefExpr(IRHS.$star()).getDecl$Const());
                  CGOpenMPRuntimeStatics.EmitOMPAggregateReduction(CGF$1, (IPriv$1.$star()).getType(), LHSVar, RHSVar, 
                      /*FuncArg*/CritRedGen);
                } else {
                  CritRedGen.$call(CGF$1, (/*const*/ Expr /*P*/ )null, (/*const*/ Expr /*P*/ )null, (/*const*/ Expr /*P*/ )null);
                }
              }
              ILHS.$preInc();
              IRHS.$preInc();
              IPriv$1.$preInc();
            }
          };
      RegionCodeGenTy AtomicRCG/*J*/= new RegionCodeGenTy(JD$NotSameRegionCodeGenTy.INSTANCE, AtomicCodeGen);
      if (!WithNowait) {
        CommonActionTy Action$1 = null;
        try {
          // Add emission of __kmpc_end_reduce(<loc>, <gtid>, &<lock>);
          Value /*P*/ EndArgs$1[/*3*/] = new Value /*P*/  [/*3*/] {
            IdentTLoc,  // ident_t *<loc>
            ThreadId,  // i32 <gtid>
            Lock // kmp_critical_name *&<lock>
          };
          Action$1/*J*/= new CommonActionTy((Value /*P*/ )null, new ArrayRef<Value /*P*/ >(llvm.None, true), 
              createRuntimeFunction(OpenMPRTLFunction.OMPRTL__kmpc_end_reduce.getValue()), 
              new ArrayRef<Value /*P*/ >(EndArgs$1, true));
          AtomicRCG.setAction(Action$1);
          AtomicRCG.$call(CGF);
        } finally {
          if (Action$1 != null) { Action$1.$destroy(); }
        }
      } else {
        AtomicRCG.$call(CGF);
      }
      
      CGF.EmitBranch(DefaultBB);
      CGF.EmitBlock(DefaultBB, /*IsFinished=*/ true);
    } finally {
      if (Action != null) { Action.$destroy(); }
    }
  }

  
  /// \brief Emit code for 'taskwait' directive.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGOpenMPRuntime::emitTaskwaitCall">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp", line = 4621,
   FQN="clang::CodeGen::CGOpenMPRuntime::emitTaskwaitCall", NM="_ZN5clang7CodeGen15CGOpenMPRuntime16emitTaskwaitCallERNS0_15CodeGenFunctionENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp -nm=_ZN5clang7CodeGen15CGOpenMPRuntime16emitTaskwaitCallERNS0_15CodeGenFunctionENS_14SourceLocationE")
  //</editor-fold>
  public void emitTaskwaitCall(final CodeGenFunction /*&*/ CGF, 
                  SourceLocation Loc) {
    if (!CGF.HaveInsertPoint()) {
      return;
    }
    // Build call kmp_int32 __kmpc_omp_taskwait(ident_t *loc, kmp_int32
    // global_tid);
    Value /*P*/ Args[/*2*/] = new Value /*P*/  [/*2*/] {emitUpdateLocation(CGF, new SourceLocation(Loc)), getThreadID(CGF, new SourceLocation(Loc))};
    // Ignore return result until untied tasks are supported.
    CGF.EmitRuntimeCall(createRuntimeFunction(OpenMPRTLFunction.OMPRTL__kmpc_omp_taskwait.getValue()), new ArrayRef<Value /*P*/ >(Args, true));
    {
      CGOpenMPRegionInfo /*P*/ Region = dyn_cast_or_null_CGOpenMPRegionInfo(CGF.CapturedStmtInfo);
      if ((Region != null)) {
        Region.emitUntiedSwitch(CGF);
      }
    }
  }

  
  /// \brief Emit code for 'cancellation point' construct.
  /// \param CancelRegion Region kind for which the cancellation point must be
  /// emitted.
  ///
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGOpenMPRuntime::emitCancellationPointCall">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp", line = 4669,
   FQN="clang::CodeGen::CGOpenMPRuntime::emitCancellationPointCall", NM="_ZN5clang7CodeGen15CGOpenMPRuntime25emitCancellationPointCallERNS0_15CodeGenFunctionENS_14SourceLocationENS_19OpenMPDirectiveKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp -nm=_ZN5clang7CodeGen15CGOpenMPRuntime25emitCancellationPointCallERNS0_15CodeGenFunctionENS_14SourceLocationENS_19OpenMPDirectiveKindE")
  //</editor-fold>
  public void emitCancellationPointCall(final CodeGenFunction /*&*/ CGF, SourceLocation Loc, 
                           OpenMPDirectiveKind CancelRegion) {
    if (!CGF.HaveInsertPoint()) {
      return;
    }
    {
      // Build call kmp_int32 __kmpc_cancellationpoint(ident_t *loc, kmp_int32
      // global_tid, kmp_int32 cncl_kind);
      CGOpenMPRegionInfo /*P*/ OMPRegionInfo = dyn_cast_or_null_CGOpenMPRegionInfo(CGF.CapturedStmtInfo);
      if ((OMPRegionInfo != null)) {
        if (OMPRegionInfo.hasCancel()) {
          Value /*P*/ Args[/*3*/] = new Value /*P*/  [/*3*/] {
            emitUpdateLocation(CGF, new SourceLocation(Loc)), getThreadID(CGF, new SourceLocation(Loc)), 
            CGF.Builder.getInt32(CGOpenMPRuntimeStatics.getCancellationKind(CancelRegion).getValue())};
          // Ignore return result until untied tasks are supported.
          CallInst /*P*/ Result = CGF.EmitRuntimeCall(createRuntimeFunction(OpenMPRTLFunction.OMPRTL__kmpc_cancellationpoint.getValue()), new ArrayRef<Value /*P*/ >(Args, true));
          // if (__kmpc_cancellationpoint()) {
          //  __kmpc_cancel_barrier();
          //   exit from construct;
          // }
          BasicBlock /*P*/ ExitBB = CGF.createBasicBlock(new Twine(/*KEEP_STR*/".cancel.exit"));
          BasicBlock /*P*/ ContBB = CGF.createBasicBlock(new Twine(/*KEEP_STR*/".cancel.continue"));
          Value /*P*/ Cmp = CGF.Builder.CreateIsNotNull(Result);
          CGF.Builder.CreateCondBr(Cmp, ExitBB, ContBB);
          CGF.EmitBlock(ExitBB);
          // __kmpc_cancel_barrier();
          emitBarrierCall(CGF, new SourceLocation(Loc), OpenMPDirectiveKind.OMPD_unknown, /*EmitChecks=*/ false);
          // exit from construct;
          CodeGenFunction.JumpDest CancelDest = CGF.getOMPCancelDestination(OMPRegionInfo.getDirectiveKind());
          CGF.EmitBranchThroughCleanup(new CodeGenFunction.JumpDest(CancelDest));
          CGF.EmitBlock(ContBB, /*IsFinished=*/ true);
        }
      }
    }
  }

  
  /// \brief Emit code for 'cancel' construct.
  /// \param IfCond Condition in the associated 'if' clause, if it was
  /// specified, nullptr otherwise.
  /// \param CancelRegion Region kind for which the cancel must be emitted.
  ///
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGOpenMPRuntime::emitCancelCall">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp", line = 4705,
   FQN="clang::CodeGen::CGOpenMPRuntime::emitCancelCall", NM="_ZN5clang7CodeGen15CGOpenMPRuntime14emitCancelCallERNS0_15CodeGenFunctionENS_14SourceLocationEPKNS_4ExprENS_19OpenMPDirectiveKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp -nm=_ZN5clang7CodeGen15CGOpenMPRuntime14emitCancelCallERNS0_15CodeGenFunctionENS_14SourceLocationEPKNS_4ExprENS_19OpenMPDirectiveKindE")
  //</editor-fold>
  public void emitCancelCall(final CodeGenFunction /*&*/ CGF, SourceLocation Loc, 
                /*const*/ Expr /*P*/ IfCond, 
                OpenMPDirectiveKind CancelRegion) {
    if (!CGF.HaveInsertPoint()) {
      return;
    }
    {
      // Build call kmp_int32 __kmpc_cancel(ident_t *loc, kmp_int32 global_tid,
      // kmp_int32 cncl_kind);
      CGOpenMPRegionInfo /*P*/ OMPRegionInfo = dyn_cast_or_null_CGOpenMPRegionInfo(CGF.CapturedStmtInfo);
      if ((OMPRegionInfo != null)) {
        SourceLocation L$Loc = Loc;
        OpenMPDirectiveKind L$CancelRegion = CancelRegion;
        CGOpenMPRegionInfo L$OMPRegionInfo = OMPRegionInfo;
        final CodeGenFunctionPrePostActionTy2Void ThenGen = /*[=L$Loc(Loc), =L$CancelRegion(CancelRegion), =L$OMPRegionInfo(OMPRegionInfo)]*/ (final CodeGenFunction /*&*/ CGF$1, final PrePostActionTy /*&*/ $Prm1) -> {
              final CGOpenMPRuntime /*&*/ RT = CGF$1.CGM.getOpenMPRuntime();
              Value /*P*/ Args[/*3*/] = new Value /*P*/  [/*3*/] {
                RT.emitUpdateLocation(CGF$1, new SourceLocation(L$Loc)), RT.getThreadID(CGF$1, new SourceLocation(L$Loc)), 
                CGF$1.Builder.getInt32(CGOpenMPRuntimeStatics.getCancellationKind(L$CancelRegion).getValue())};
              // Ignore return result until untied tasks are supported.
              CallInst /*P*/ Result = CGF$1.EmitRuntimeCall(RT.createRuntimeFunction(OpenMPRTLFunction.OMPRTL__kmpc_cancel.getValue()), new ArrayRef<Value /*P*/ >(Args, true));
              // if (__kmpc_cancel()) {
              //  __kmpc_cancel_barrier();
              //   exit from construct;
              // }
              BasicBlock /*P*/ ExitBB = CGF$1.createBasicBlock(new Twine(/*KEEP_STR*/".cancel.exit"));
              BasicBlock /*P*/ ContBB = CGF$1.createBasicBlock(new Twine(/*KEEP_STR*/".cancel.continue"));
              Value /*P*/ Cmp = CGF$1.Builder.CreateIsNotNull(Result);
              CGF$1.Builder.CreateCondBr(Cmp, ExitBB, ContBB);
              CGF$1.EmitBlock(ExitBB);
              // __kmpc_cancel_barrier();
              RT.emitBarrierCall(CGF$1, new SourceLocation(L$Loc), OpenMPDirectiveKind.OMPD_unknown, /*EmitChecks=*/ false);
              // exit from construct;
              CodeGenFunction.JumpDest CancelDest = CGF$1.getOMPCancelDestination(L$OMPRegionInfo.getDirectiveKind());
              CGF$1.EmitBranchThroughCleanup(new CodeGenFunction.JumpDest(CancelDest));
              CGF$1.EmitBlock(ContBB, /*IsFinished=*/ true);
            };
        if ((IfCond != null)) {
          CodeGenFunctionPrePostActionTy2Void caller = /*[]*/ (final CodeGenFunction /*&*/ $Prm0, final PrePostActionTy /*&*/ $Prm1) -> {
          };
          emitOMPIfClause(CGF, IfCond, new RegionCodeGenTy(JD$NotSameRegionCodeGenTy.INSTANCE, ThenGen), 
              new RegionCodeGenTy(JD$NotSameRegionCodeGenTy.INSTANCE, caller));
        } else {
          RegionCodeGenTy ThenRCG/*J*/= new RegionCodeGenTy(JD$NotSameRegionCodeGenTy.INSTANCE, ThenGen);
          ThenRCG.$call(CGF);
        }
      }
    }
  }

  
  /// \brief Emit outilined function for 'target' directive.
  /// \param D Directive to emit.
  /// \param ParentName Name of the function that encloses the target region.
  /// \param OutlinedFn Outlined function value to be defined by this call.
  /// \param OutlinedFnID Outlined function ID value to be defined by this call.
  /// \param IsOffloadEntry True if the outlined function is an offload entry.
  /// \param CodeGen Code generation sequence for the \a D directive.
  /// An oulined function may not be an entry if, e.g. the if clause always
  /// evaluates to false.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGOpenMPRuntime::emitTargetOutlinedFunction">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp", line = 4777,
   FQN="clang::CodeGen::CGOpenMPRuntime::emitTargetOutlinedFunction", NM="_ZN5clang7CodeGen15CGOpenMPRuntime26emitTargetOutlinedFunctionERKNS_22OMPExecutableDirectiveEN4llvm9StringRefERPNS5_8FunctionERPNS5_8ConstantEbRKNS0_15RegionCodeGenTyE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp -nm=_ZN5clang7CodeGen15CGOpenMPRuntime26emitTargetOutlinedFunctionERKNS_22OMPExecutableDirectiveEN4llvm9StringRefERPNS5_8FunctionERPNS5_8ConstantEbRKNS0_15RegionCodeGenTyE")
  //</editor-fold>
  public void emitTargetOutlinedFunction(final /*const*/ OMPExecutableDirective /*&*/ D, StringRef ParentName, 
                            final type$ref<Function /*P*/ /*&*/> OutlinedFn, final type$ref<Constant /*P*/ /*&*/> OutlinedFnID, 
                            boolean IsOffloadEntry, final /*const*/ RegionCodeGenTy /*&*/ CodeGen) {
    assert (!ParentName.empty()) : "Invalid target region parent name!";
    
    emitTargetOutlinedFunctionHelper(D, new StringRef(ParentName), OutlinedFn, OutlinedFnID, 
        IsOffloadEntry, CodeGen);
  }

  
  /// \brief Emit the target offloading code associated with \a D. The emitted
  /// code attempts offloading the execution to the device, an the event of
  /// a failure it executes the host version outlined in \a OutlinedFn.
  /// \param D Directive to emit.
  /// \param OutlinedFn Host version of the code to be offloaded.
  /// \param OutlinedFnID ID of host version of the code to be offloaded.
  /// \param IfCond Expression evaluated in if clause associated with the target
  /// directive, or null if no if clause is used.
  /// \param Device Expression evaluated in device clause associated with the
  /// target directive, or null if no device clause is used.
  /// \param CapturedVars Values captured in the current region.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGOpenMPRuntime::emitTargetCall">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp", line = 5695,
   FQN="clang::CodeGen::CGOpenMPRuntime::emitTargetCall", NM="_ZN5clang7CodeGen15CGOpenMPRuntime14emitTargetCallERNS0_15CodeGenFunctionERKNS_22OMPExecutableDirectiveEPN4llvm5ValueES9_PKNS_4ExprESC_NS7_8ArrayRefIS9_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp -nm=_ZN5clang7CodeGen15CGOpenMPRuntime14emitTargetCallERNS0_15CodeGenFunctionERKNS_22OMPExecutableDirectiveEPN4llvm5ValueES9_PKNS_4ExprESC_NS7_8ArrayRefIS9_EE")
  //</editor-fold>
  public void emitTargetCall(final CodeGenFunction /*&*/ CGF, 
                final /*const*/ OMPExecutableDirective /*&*/ D, 
                Value /*P*/ OutlinedFn, 
                Value /*P*/ OutlinedFnID, 
                /*const*/ Expr /*P*/ IfCond, /*const*/ Expr /*P*/ Device, 
                ArrayRef<Value /*P*/ > CapturedVars) {
    MappableExprsHandler MEHandler = null;
    try {
      if (!CGF.HaveInsertPoint()) {
        return;
      }
      assert ((OutlinedFn != null)) : "Invalid outlined function!";
      
      final ASTContext /*&*/ Ctx = CGF.getContext();
      
      // Fill up the arrays with all the captured variables.
      SmallVector<Value /*P*/ > KernelArgs/*J*/= new SmallVector<Value /*P*/ >(16, (Value /*P*/ )null);
      SmallVector<Value /*P*/ > BasePointers/*J*/= new SmallVector<Value /*P*/ >(16, (Value /*P*/ )null);
      SmallVector<Value /*P*/ > Pointers/*J*/= new SmallVector<Value /*P*/ >(16, (Value /*P*/ )null);
      SmallVector<Value /*P*/ > Sizes/*J*/= new SmallVector<Value /*P*/ >(16, (Value /*P*/ )null);
      SmallVectorUInt MapTypes/*J*/= new SmallVectorUInt(16, 0);
      
      SmallVector<Value /*P*/ > CurBasePointers/*J*/= new SmallVector<Value /*P*/ >(16, (Value /*P*/ )null);
      SmallVector<Value /*P*/ > CurPointers/*J*/= new SmallVector<Value /*P*/ >(16, (Value /*P*/ )null);
      SmallVector<Value /*P*/ > CurSizes/*J*/= new SmallVector<Value /*P*/ >(16, (Value /*P*/ )null);
      SmallVectorUInt CurMapTypes/*J*/= new SmallVectorUInt(16, 0);
      
      // Get mappable expression information.
      MEHandler/*J*/= new MappableExprsHandler(D, CGF);
      
      final /*const*/ CapturedStmt /*&*/ CS = $Deref(cast_CapturedStmt(D.getAssociatedStmt()));
      DeclContext.specific_decl_iterator<FieldDecl> RI = CS.getCapturedRecordDecl().field_begin();
      type$ptr<Value /*P*/ /*const*/ /*P*/> CV = $tryClone(CapturedVars.begin());
      for (type$ptr</*const*/ CapturedStmt.Capture /*P*/ > CI = $tryClone(CS.capture_begin$Const()), 
          /*P*/ CE = $tryClone(CS.capture_end());
           $noteq_ptr(CI, CE); CI.$preInc() , RI.$preInc() , CV.$preInc()) {
        StringRef Name/*J*/= new StringRef();
        QualType Ty/*J*/= new QualType();
        
        CurBasePointers.clear();
        CurPointers.clear();
        CurSizes.clear();
        CurMapTypes.clear();
        
        // VLA sizes are passed to the outlined region by copy and do not have map
        // information associated.
        if (CI./*->*/$star().capturesVariableArrayType()) {
          CurBasePointers.push_back(CV.$star());
          CurPointers.push_back(CV.$star());
          CurSizes.push_back(CGF.getTypeSize(RI.$arrow().getType()));
          // Copy to the device as an argument. No need to retrieve it.
          CurMapTypes.push_back(MappableExprsHandler.OpenMPOffloadMappingFlags.OMP_MAP_PRIVATE_VAL
                 | MappableExprsHandler.OpenMPOffloadMappingFlags.OMP_MAP_FIRST_REF);
        } else {
          // If we have any information in the map clause, we use it, otherwise we
          // just do a default mapping.
          MEHandler.generateInfoForCapture(CI.$star(), CurBasePointers, CurPointers, 
              CurSizes, CurMapTypes);
          if (CurBasePointers.empty()) {
            MEHandler.generateDefaultMapInfo(CI.$star(), $Deref(RI.$star()), CV.$star(), CurBasePointers, 
                CurPointers, CurSizes, CurMapTypes);
          }
        }
        // We expect to have at least an element of information for this capture.
        assert (!CurBasePointers.empty()) : "Non-existing map pointer for capture!";
        assert (CurBasePointers.size() == CurPointers.size() && CurBasePointers.size() == CurSizes.size() && CurBasePointers.size() == CurMapTypes.size()) : "Inconsistent map information sizes!";
        
        // The kernel args are always the first elements of the base pointers
        // associated with a capture.
        KernelArgs.push_back(CurBasePointers.front());
        // We need to append the results of this capture to what we already have.
        BasePointers.append_T(CurBasePointers.begin(), CurBasePointers.end());
        Pointers.append_T(CurPointers.begin(), CurPointers.end());
        Sizes.append_T(CurSizes.begin(), CurSizes.end());
        MapTypes.append_T(CurMapTypes.begin(), CurMapTypes.end());
      }
      
      // Keep track on whether the host function has to be executed.
      QualType OffloadErrorQType = Ctx.getIntTypeForBitwidth(/*DestWidth=*/ 32, /*Signed=*/ /*true*/1);
      LValue OffloadError = CGF.MakeAddrLValue(CGF.CreateMemTemp(new QualType(OffloadErrorQType), new Twine(/*KEEP_STR*/".run_host_version")), 
          new QualType(OffloadErrorQType));
      CGF.EmitStoreOfScalar(Constant.getNullValue(CGM.Int32Ty), 
          new LValue(OffloadError));
      
      // Fill up the pointer arrays and transfer execution to the device.
      Value L$OutlinedFnID = OutlinedFnID;
      Expr L$Device = Device;
      LValue L$OffloadError = OffloadError;
      final CodeGenFunctionPrePostActionTy2Void ThenGen = /*[&Ctx, &BasePointers, &Pointers, &Sizes, &MapTypes, =L$Device(Device), =L$OutlinedFnID(OutlinedFnID), =L$OffloadError(OffloadError), =L$OffloadErrorQType(OffloadErrorQType), &D]*/ (final CodeGenFunction /*&*/ CGF$1, final PrePostActionTy /*&*/ $Prm1) -> {
            final CGOpenMPRuntime /*&*/ RT = CGF$1.CGM.getOpenMPRuntime();
            // Emit the offloading arrays.
            type$ref<Value /*P*/ > BasePointersArray = create_type$ref();
            type$ref<Value /*P*/ > PointersArray = create_type$ref();
            type$ref<Value /*P*/ > SizesArray = create_type$ref();
            type$ref<Value /*P*/ > MapTypesArray = create_type$ref();
            CGOpenMPRuntimeStatics.emitOffloadingArrays(CGF$1, BasePointersArray, PointersArray, SizesArray, 
                MapTypesArray, BasePointers, Pointers, Sizes, 
                MapTypes);
            CGOpenMPRuntimeStatics.emitOffloadingArraysArgument(CGF$1, BasePointersArray, PointersArray, 
                SizesArray, MapTypesArray, BasePointersArray.$deref(), 
                PointersArray.$deref(), SizesArray.$deref(), MapTypesArray.$deref(), 
                BasePointers.size());
            
            // On top of the arrays that were filled up, the target offloading call
            // takes as arguments the device id as well as the host pointer. The host
            // pointer is used by the runtime library to identify the current target
            // region, so it only has to be unique and not necessarily point to
            // anything. It could be the pointer to the outlined function that
            // implements the target region, but we aren't using that so that the
            // compiler doesn't need to keep that, and could therefore inline the host
            // function if proven worthwhile during optimization.
            
            // From this point on, we need to have an ID of the target region defined.
            assert ((L$OutlinedFnID != null)) : "Invalid outlined function ID!";
            
            // Emit device ID if any.
            Value /*P*/ DeviceID;
            if ((L$Device != null)) {
              DeviceID = CGF$1.Builder.CreateIntCast(CGF$1.EmitScalarExpr(L$Device), 
                  CGF$1.Int32Ty, /*isSigned=*/ true);
            } else {
              DeviceID = CGF$1.Builder.getInt32(OpenMPOffloadingReservedDeviceIDs.OMP_DEVICEID_UNDEF.getValue());
            }
            
            // Emit the number of elements in the offloading arrays.
            Value /*P*/ PointerNum = CGF$1.Builder.getInt32(BasePointers.size());
            
            // Return value of the runtime offloading call.
            Value /*P*/ Return;
            
            Value /*P*/ NumTeams = CGOpenMPRuntimeStatics.emitNumTeamsClauseForTargetDirective(RT, CGF$1, D);
            Value /*P*/ ThreadLimit = CGOpenMPRuntimeStatics.emitThreadLimitClauseForTargetDirective(RT, CGF$1, D);
            
            // If we have NumTeams defined this means that we have an enclosed teams
            // region. Therefore we also expect to have ThreadLimit defined. These two
            // values should be defined in the presence of a teams directive, regardless
            // of having any clauses associated. If the user is using teams but no
            // clauses, these two values will be the default that should be passed to
            // the runtime library - a 32-bit integer with the value zero.
            if ((NumTeams != null)) {
              assert ((ThreadLimit != null)) : "Thread limit expression should be available along with number of teams.";
              Value /*P*/ OffloadingArgs[/*9*/] = new Value /*P*/  [/*9*/] {
                DeviceID, L$OutlinedFnID, PointerNum, 
                BasePointersArray.$deref(), PointersArray.$deref(), SizesArray.$deref(), 
                MapTypesArray.$deref(), NumTeams, ThreadLimit};
              Return = CGF$1.EmitRuntimeCall(RT.createRuntimeFunction(OpenMPRTLFunction.OMPRTL__tgt_target_teams.getValue()), new ArrayRef<Value /*P*/ >(OffloadingArgs, true));
            } else {
              Value /*P*/ OffloadingArgs[/*7*/] = new Value /*P*/  [/*7*/] {
                DeviceID, L$OutlinedFnID, PointerNum, BasePointersArray.$deref(), 
                PointersArray.$deref(), SizesArray.$deref(), MapTypesArray.$deref()};
              Return = CGF$1.EmitRuntimeCall(RT.createRuntimeFunction(OpenMPRTLFunction.OMPRTL__tgt_target.getValue()), 
                  new ArrayRef<Value /*P*/ >(OffloadingArgs, true));
            }
            
            CGF$1.EmitStoreOfScalar(Return, new LValue(L$OffloadError));
          };
      
      // Notify that the host version must be executed.
      final CodeGenFunctionPrePostActionTy2Void ElseGen = /*[=L$OffloadError(OffloadError)]*/ (final CodeGenFunction /*&*/ CGF$1, final PrePostActionTy /*&*/ $Prm1) -> {
            CGF$1.EmitStoreOfScalar(ConstantInt.get(CGF$1.Int32Ty, /*V=*/ $uint2ulong(-1/*U*/)), 
                new LValue(L$OffloadError));
          };
      
      // If we have a target function ID it means that we need to support
      // offloading, otherwise, just execute on the host. We need to execute on host
      // regardless of the conditional in the if clause if, e.g., the user do not
      // specify target triples.
      if ((OutlinedFnID != null)) {
        if ((IfCond != null)) {
          CGOpenMPRuntimeStatics.emitOMPIfClause(CGF, IfCond, new RegionCodeGenTy(JD$NotSameRegionCodeGenTy.INSTANCE, ThenGen), new RegionCodeGenTy(JD$NotSameRegionCodeGenTy.INSTANCE, ElseGen));
        } else {
          RegionCodeGenTy ThenRCG/*J*/= new RegionCodeGenTy(JD$NotSameRegionCodeGenTy.INSTANCE, ThenGen);
          ThenRCG.$call(CGF);
        }
      } else {
        RegionCodeGenTy ElseRCG/*J*/= new RegionCodeGenTy(JD$NotSameRegionCodeGenTy.INSTANCE, ElseGen);
        ElseRCG.$call(CGF);
      }
      
      // Check the error code and execute the host version if required.
      BasicBlock /*P*/ OffloadFailedBlock = CGF.createBasicBlock(new Twine(/*KEEP_STR*/"omp_offload.failed"));
      BasicBlock /*P*/ OffloadContBlock = CGF.createBasicBlock(new Twine(/*KEEP_STR*/"omp_offload.cont"));
      Value /*P*/ OffloadErrorVal = CGF.EmitLoadOfScalar(new LValue(OffloadError), new SourceLocation());
      Value /*P*/ Failed = CGF.Builder.CreateIsNotNull(OffloadErrorVal);
      CGF.Builder.CreateCondBr(Failed, OffloadFailedBlock, OffloadContBlock);
      
      CGF.EmitBlock(OffloadFailedBlock);
      CGF.Builder.CreateCall_Value$P_ArrayRef$Value$P_Twine$C_MDNode$P(OutlinedFn, new ArrayRef<Value /*P*/ >(KernelArgs, true));
      CGF.EmitBranch(OffloadContBlock);
      
      CGF.EmitBlock(OffloadContBlock, /*IsFinished=*/ true);
    } finally {
      if (MEHandler != null) { MEHandler.$destroy(); }
    }
  }

  
  /// \brief Emit the target regions enclosed in \a GD function definition or
  /// the function itself in case it is a valid device function. Returns true if
  /// \a GD was dealt with successfully.
  /// \param GD Function to scan.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGOpenMPRuntime::emitTargetFunctions">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp", line = 5943,
   FQN="clang::CodeGen::CGOpenMPRuntime::emitTargetFunctions", NM="_ZN5clang7CodeGen15CGOpenMPRuntime19emitTargetFunctionsENS_10GlobalDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp -nm=_ZN5clang7CodeGen15CGOpenMPRuntime19emitTargetFunctionsENS_10GlobalDeclE")
  //</editor-fold>
  public boolean emitTargetFunctions(GlobalDecl GD) {
    final /*const*/ FunctionDecl /*&*/ FD = $Deref(cast_FunctionDecl(GD.getDecl()));
    
    // If emitting code for the host, we do not process FD here. Instead we do
    // the normal code generation.
    if (!CGM.getLangOpts().OpenMPIsDevice) {
      return false;
    }
    
    // Try to detect target regions in the function.
    scanForTargetRegionsFunctions(FD.getBody(), CGM.getMangledName(new GlobalDecl(GD)));
    
    // We should not emit any function othen that the ones created during the
    // scanning. Therefore, we signal that this function is completely dealt
    // with.
    return true;
  }

  
  /// \brief Emit the global variable if it is a valid device global variable.
  /// Returns true if \a GD was dealt with successfully.
  /// \param GD Variable declaration to emit.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGOpenMPRuntime::emitTargetGlobalVariable">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp", line = 5960,
   FQN="clang::CodeGen::CGOpenMPRuntime::emitTargetGlobalVariable", NM="_ZN5clang7CodeGen15CGOpenMPRuntime24emitTargetGlobalVariableENS_10GlobalDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp -nm=_ZN5clang7CodeGen15CGOpenMPRuntime24emitTargetGlobalVariableENS_10GlobalDeclE")
  //</editor-fold>
  public boolean emitTargetGlobalVariable(GlobalDecl GD) {
    if (!CGM.getLangOpts().OpenMPIsDevice) {
      return false;
    }
    
    // Check if there are Ctors/Dtors in this declaration and look for target
    // regions in it. We use the complete variant to produce the kernel name
    // mangling.
    QualType RDTy = cast_VarDecl(GD.getDecl()).getType();
    {
      CXXRecordDecl /*P*/ RD = RDTy.$arrow().getBaseElementTypeUnsafe().getAsCXXRecordDecl();
      if ((RD != null)) {
        for (CXXConstructorDecl /*P*/ Ctor : RD.ctors()) {
          StringRef ParentName = CGM.getMangledName(new GlobalDecl(JD$CXXConstructorDecl$C$P_CXXCtorType.INSTANCE, Ctor, CXXCtorType.Ctor_Complete));
          scanForTargetRegionsFunctions(Ctor.getBody(), new StringRef(ParentName));
        }
        CXXDestructorDecl /*P*/ Dtor = RD.getDestructor();
        if ((Dtor != null)) {
          StringRef ParentName = CGM.getMangledName(new GlobalDecl(JD$CXXDestructorDecl$C$P_CXXDtorType.INSTANCE, Dtor, CXXDtorType.Dtor_Complete));
          scanForTargetRegionsFunctions(Dtor.getBody(), new StringRef(ParentName));
        }
      }
    }
    
    // If we are in target mode we do not emit any global (declare target is not
    // implemented yet). Therefore we signal that GD was processed in this case.
    return true;
  }

  
  /// \brief Emit the global \a GD if it is meaningful for the target. Returns
  /// if it was emitted succesfully.
  /// \param GD Global to scan.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGOpenMPRuntime::emitTargetGlobal">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp", line = 5987,
   FQN="clang::CodeGen::CGOpenMPRuntime::emitTargetGlobal", NM="_ZN5clang7CodeGen15CGOpenMPRuntime16emitTargetGlobalENS_10GlobalDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp -nm=_ZN5clang7CodeGen15CGOpenMPRuntime16emitTargetGlobalENS_10GlobalDeclE")
  //</editor-fold>
  public boolean emitTargetGlobal(GlobalDecl GD) {
    /*const*/ Decl /*P*/ VD = GD.getDecl();
    if (isa_FunctionDecl(VD)) {
      return emitTargetFunctions(new GlobalDecl(GD));
    }
    
    return emitTargetGlobalVariable(new GlobalDecl(GD));
  }

  
  /// \brief Creates the offloading descriptor in the event any target region
  /// was emitted in the current module and return the function that registers
  /// it.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGOpenMPRuntime::emitRegistrationFunction">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp", line = 5995,
   FQN="clang::CodeGen::CGOpenMPRuntime::emitRegistrationFunction", NM="_ZN5clang7CodeGen15CGOpenMPRuntime24emitRegistrationFunctionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp -nm=_ZN5clang7CodeGen15CGOpenMPRuntime24emitRegistrationFunctionEv")
  //</editor-fold>
  public Function /*P*/ emitRegistrationFunction() {
    // If we have offloading in the current module, we need to emit the entries
    // now and register the offloading descriptor.
    createOffloadEntriesAndInfoMetadata();
    
    // Create and register the offloading binary descriptors. This is the main
    // entity that captures all the information about offloading in the current
    // compilation unit.
    return createOffloadingBinaryDescriptorRegistration();
  }

  
  /// \brief Emits code for teams call of the \a OutlinedFn with
  /// variables captured in a record which address is stored in \a
  /// CapturedStruct.
  /// \param OutlinedFn Outlined function to be run by team masters. Type of
  /// this function is void(*)(kmp_int32 *, kmp_int32, struct context_vars*).
  /// \param CapturedVars A pointer to the record with the references to
  /// variables used in \a OutlinedFn function.
  ///
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGOpenMPRuntime::emitTeamsCall">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp", line = 6006,
   FQN="clang::CodeGen::CGOpenMPRuntime::emitTeamsCall", NM="_ZN5clang7CodeGen15CGOpenMPRuntime13emitTeamsCallERNS0_15CodeGenFunctionERKNS_22OMPExecutableDirectiveENS_14SourceLocationEPN4llvm5ValueENS8_8ArrayRefISA_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp -nm=_ZN5clang7CodeGen15CGOpenMPRuntime13emitTeamsCallERNS0_15CodeGenFunctionERKNS_22OMPExecutableDirectiveENS_14SourceLocationEPN4llvm5ValueENS8_8ArrayRefISA_EE")
  //</editor-fold>
  public void emitTeamsCall(final CodeGenFunction /*&*/ CGF, 
               final /*const*/ OMPExecutableDirective /*&*/ D, 
               SourceLocation Loc, 
               Value /*P*/ OutlinedFn, 
               ArrayRef<Value /*P*/ > CapturedVars) {
    CodeGenFunction.RunCleanupsScope Scope = null;
    try {
      if (!CGF.HaveInsertPoint()) {
        return;
      }
      
      Value /*P*/ RTLoc = emitUpdateLocation(CGF, new SourceLocation(Loc));
      Scope/*J*/= new CodeGenFunction.RunCleanupsScope(CGF);
      
      // Build call __kmpc_fork_teams(loc, n, microtask, var1, .., varn);
      Value /*P*/ Args[/*3*/] = new Value /*P*/  [/*3*/] {
        RTLoc, 
        CGF.Builder.getInt32(CapturedVars.size()),  // Number of captured vars
        CGF.Builder.CreateBitCast(OutlinedFn, getKmpc_MicroPointerTy())};
      SmallVector<Value /*P*/ > RealArgs/*J*/= new SmallVector<Value /*P*/ >(16, (Value /*P*/ )null);
      RealArgs.append_T(std.begin(Args), std.end(Args));
      RealArgs.append_T(CapturedVars.begin(), CapturedVars.end());
      
      Constant /*P*/ RTLFn = createRuntimeFunction(OpenMPRTLFunction.OMPRTL__kmpc_fork_teams.getValue());
      CGF.EmitRuntimeCall(RTLFn, new ArrayRef<Value /*P*/ >(RealArgs, true));
    } finally {
      if (Scope != null) { Scope.$destroy(); }
    }
  }

  
  /// \brief Emits call to void __kmpc_push_num_teams(ident_t *loc, kmp_int32
  /// global_tid, kmp_int32 num_teams, kmp_int32 thread_limit) to generate code
  /// for num_teams clause.
  /// \param NumTeams An integer expression of teams.
  /// \param ThreadLimit An integer expression of threads.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGOpenMPRuntime::emitNumTeamsClause">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp", line = 6030,
   FQN="clang::CodeGen::CGOpenMPRuntime::emitNumTeamsClause", NM="_ZN5clang7CodeGen15CGOpenMPRuntime18emitNumTeamsClauseERNS0_15CodeGenFunctionEPKNS_4ExprES6_NS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp -nm=_ZN5clang7CodeGen15CGOpenMPRuntime18emitNumTeamsClauseERNS0_15CodeGenFunctionEPKNS_4ExprES6_NS_14SourceLocationE")
  //</editor-fold>
  public void emitNumTeamsClause(final CodeGenFunction /*&*/ CGF, 
                    /*const*/ Expr /*P*/ NumTeams, 
                    /*const*/ Expr /*P*/ ThreadLimit, 
                    SourceLocation Loc) {
    if (!CGF.HaveInsertPoint()) {
      return;
    }
    
    Value /*P*/ RTLoc = emitUpdateLocation(CGF, new SourceLocation(Loc));
    
    Value /*P*/ NumTeamsVal = ((NumTeams) != null) ? CGF.Builder.CreateIntCast(CGF.EmitScalarExpr(NumTeams), 
        CGF.CGM.Int32Ty, /* isSigned = */ true) : CGF.Builder.getInt32(0);
    
    Value /*P*/ ThreadLimitVal = ((ThreadLimit) != null) ? CGF.Builder.CreateIntCast(CGF.EmitScalarExpr(ThreadLimit), 
        CGF.CGM.Int32Ty, /* isSigned = */ true) : CGF.Builder.getInt32(0);
    
    // Build call __kmpc_push_num_teamss(&loc, global_tid, num_teams, thread_limit)
    Value /*P*/ PushNumTeamsArgs[/*4*/] = new Value /*P*/  [/*4*/] {
      RTLoc, getThreadID(CGF, new SourceLocation(Loc)), NumTeamsVal, 
      ThreadLimitVal};
    CGF.EmitRuntimeCall(createRuntimeFunction(OpenMPRTLFunction.OMPRTL__kmpc_push_num_teams.getValue()), 
        new ArrayRef<Value /*P*/ >(PushNumTeamsArgs, true));
  }

  
  /// \brief Emit the target data mapping code associated with \a D.
  /// \param D Directive to emit.
  /// \param IfCond Expression evaluated in if clause associated with the target
  /// directive, or null if no if clause is used.
  /// \param Device Expression evaluated in device clause associated with the
  /// target directive, or null if no device clause is used.
  /// \param CodeGen Function that emits the enclosed region.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGOpenMPRuntime::emitTargetDataCalls">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp", line = 6058,
   FQN="clang::CodeGen::CGOpenMPRuntime::emitTargetDataCalls", NM="_ZN5clang7CodeGen15CGOpenMPRuntime19emitTargetDataCallsERNS0_15CodeGenFunctionERKNS_22OMPExecutableDirectiveEPKNS_4ExprES9_RKNS0_15RegionCodeGenTyE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp -nm=_ZN5clang7CodeGen15CGOpenMPRuntime19emitTargetDataCallsERNS0_15CodeGenFunctionERKNS_22OMPExecutableDirectiveEPKNS_4ExprES9_RKNS0_15RegionCodeGenTyE")
  //</editor-fold>
  public void emitTargetDataCalls(final CodeGenFunction /*&*/ CGF, 
                     final /*const*/ OMPExecutableDirective /*&*/ D, 
                     /*const*/ Expr /*P*/ IfCond, 
                     /*const*/ Expr /*P*/ Device, 
                     final /*const*/ RegionCodeGenTy /*&*/ CodeGen) {
    if (!CGF.HaveInsertPoint()) {
      return;
    }
    
    type$ref<Value /*P*/ > BasePointersArray = create_type$null$ref(null);
    type$ref<Value /*P*/ > PointersArray = create_type$null$ref(null);
    type$ref<Value /*P*/ > SizesArray = create_type$null$ref(null);
    type$ref<Value /*P*/ > MapTypesArray = create_type$null$ref(null);
    uint$ref/*uint*/ NumOfPtrs = create_uint$ref(0);
    
    // Generate the code for the opening of the data environment. Capture all the
    // arguments of the runtime call by reference because they are used in the
    // closing of the region.
    Expr L$Device = Device;
    final CodeGenFunctionPrePostActionTy2Void BeginThenGen = /*[&D, &CGF, &BasePointersArray, &PointersArray, &SizesArray, &MapTypesArray, =L$Device(Device), &NumOfPtrs]*/ (final CodeGenFunction /*&*/ CGF$1, final PrePostActionTy /*&*/ $Prm1) -> {
          MappableExprsHandler MCHandler = null;
          try {
            // Fill up the arrays with all the mapped variables.
            SmallVector<Value /*P*/ > BasePointers/*J*/= new SmallVector<Value /*P*/ >(16, (Value /*P*/ )null);
            SmallVector<Value /*P*/ > Pointers/*J*/= new SmallVector<Value /*P*/ >(16, (Value /*P*/ )null);
            SmallVector<Value /*P*/ > Sizes/*J*/= new SmallVector<Value /*P*/ >(16, (Value /*P*/ )null);
            SmallVectorUInt MapTypes/*J*/= new SmallVectorUInt(16, 0);
            
            // Get map clause information.
            MCHandler/*J*/= new MappableExprsHandler(D, CGF$1);
            MCHandler.generateAllInfo(BasePointers, Pointers, Sizes, MapTypes);
            NumOfPtrs.$assign(BasePointers.size());
            
            // Fill up the arrays and create the arguments.
            CGOpenMPRuntimeStatics.emitOffloadingArrays(CGF$1, BasePointersArray, PointersArray, SizesArray, 
                MapTypesArray, BasePointers, Pointers, Sizes, 
                MapTypes);
            
            type$ref<Value /*P*/ > BasePointersArrayArg = create_type$null$ref(null);
            type$ref<Value /*P*/ > PointersArrayArg = create_type$null$ref(null);
            type$ref<Value /*P*/ > SizesArrayArg = create_type$null$ref(null);
            type$ref<Value /*P*/ > MapTypesArrayArg = create_type$null$ref(null);
            CGOpenMPRuntimeStatics.emitOffloadingArraysArgument(CGF$1, BasePointersArrayArg, PointersArrayArg, 
                SizesArrayArg, MapTypesArrayArg, 
                BasePointersArray.$deref(), PointersArray.$deref(), SizesArray.$deref(), 
                MapTypesArray.$deref(), NumOfPtrs.$deref());
            
            // Emit device ID if any.
            Value /*P*/ DeviceID = null;
            if ((L$Device != null)) {
              DeviceID = CGF$1.Builder.CreateIntCast(CGF$1.EmitScalarExpr(L$Device), 
                  CGF$1.Int32Ty, /*isSigned=*/ true);
            } else {
              DeviceID = CGF$1.Builder.getInt32(OpenMPOffloadingReservedDeviceIDs.OMP_DEVICEID_UNDEF.getValue());
            }
            
            // Emit the number of elements in the offloading arrays.
            ConstantInt /*P*/ PointerNum = CGF$1.Builder.getInt32(NumOfPtrs.$deref());
            
            Value /*P*/ OffloadingArgs[/*6*/] = new Value /*P*/  [/*6*/] {
              DeviceID, PointerNum, BasePointersArrayArg.$deref(), 
              PointersArrayArg.$deref(), SizesArrayArg.$deref(), MapTypesArrayArg.$deref()};
            final CGOpenMPRuntime /*&*/ RT = CGF$1.CGM.getOpenMPRuntime();
            CGF$1.EmitRuntimeCall(RT.createRuntimeFunction(OpenMPRTLFunction.OMPRTL__tgt_target_data_begin.getValue()), 
                new ArrayRef<Value /*P*/ >(OffloadingArgs, true));
          } finally {
            if (MCHandler != null) { MCHandler.$destroy(); }
          }
        };
    
    // Generate code for the closing of the data region.
    final CodeGenFunctionPrePostActionTy2Void EndThenGen = /*[&CGF, &BasePointersArray, &PointersArray, &SizesArray, &MapTypesArray, =L$Device(Device), &NumOfPtrs]*/ (final CodeGenFunction /*&*/ CGF$1, final PrePostActionTy /*&*/ $Prm1) -> {
          assert ((BasePointersArray.$deref() != null) && (PointersArray.$deref() != null) && (SizesArray.$deref() != null) && (MapTypesArray.$deref() != null) && (NumOfPtrs.$deref() != 0)) : "Invalid data environment closing arguments.";
          
          type$ref<Value /*P*/ > BasePointersArrayArg = create_type$null$ref(null);
          type$ref<Value /*P*/ > PointersArrayArg = create_type$null$ref(null);
          type$ref<Value /*P*/ > SizesArrayArg = create_type$null$ref(null);
          type$ref<Value /*P*/ > MapTypesArrayArg = create_type$null$ref(null);
          CGOpenMPRuntimeStatics.emitOffloadingArraysArgument(CGF$1, BasePointersArrayArg, PointersArrayArg, 
              SizesArrayArg, MapTypesArrayArg, 
              BasePointersArray.$deref(), PointersArray.$deref(), SizesArray.$deref(), 
              MapTypesArray.$deref(), NumOfPtrs.$deref());
          
          // Emit device ID if any.
          Value /*P*/ DeviceID = null;
          if ((L$Device != null)) {
            DeviceID = CGF$1.Builder.CreateIntCast(CGF$1.EmitScalarExpr(L$Device), 
                CGF$1.Int32Ty, /*isSigned=*/ true);
          } else {
            DeviceID = CGF$1.Builder.getInt32(OpenMPOffloadingReservedDeviceIDs.OMP_DEVICEID_UNDEF.getValue());
          }
          
          // Emit the number of elements in the offloading arrays.
          ConstantInt /*P*/ PointerNum = CGF$1.Builder.getInt32(NumOfPtrs.$deref());
          
          Value /*P*/ OffloadingArgs[/*6*/] = new Value /*P*/  [/*6*/] {
            DeviceID, PointerNum, BasePointersArrayArg.$deref(), 
            PointersArrayArg.$deref(), SizesArrayArg.$deref(), MapTypesArrayArg.$deref()};
          final CGOpenMPRuntime /*&*/ RT = CGF$1.CGM.getOpenMPRuntime();
          CGF$1.EmitRuntimeCall(RT.createRuntimeFunction(OpenMPRTLFunction.OMPRTL__tgt_target_data_end.getValue()), 
              new ArrayRef<Value /*P*/ >(OffloadingArgs, true));
        };
    
    // In the event we get an if clause, we don't have to take any action on the
    // else side.
    final CodeGenFunctionPrePostActionTy2Void ElseGen = /*[]*/ (final CodeGenFunction /*&*/ CGF$1, final PrePostActionTy /*&*/ $Prm1) -> {
        };
    if ((IfCond != null)) {
      CGOpenMPRuntimeStatics.emitOMPIfClause(CGF, IfCond, new RegionCodeGenTy(JD$NotSameRegionCodeGenTy.INSTANCE, BeginThenGen), new RegionCodeGenTy(JD$NotSameRegionCodeGenTy.INSTANCE, ElseGen));
    } else {
      RegionCodeGenTy BeginThenRCG/*J*/= new RegionCodeGenTy(JD$NotSameRegionCodeGenTy.INSTANCE, BeginThenGen);
      BeginThenRCG.$call(CGF);
    }
    
    CGM.getOpenMPRuntime().emitInlinedDirective(CGF, OpenMPDirectiveKind.OMPD_target_data, CodeGen);
    if ((IfCond != null)) {
      CGOpenMPRuntimeStatics.emitOMPIfClause(CGF, IfCond, new RegionCodeGenTy(JD$NotSameRegionCodeGenTy.INSTANCE, EndThenGen), new RegionCodeGenTy(JD$NotSameRegionCodeGenTy.INSTANCE, ElseGen));
    } else {
      RegionCodeGenTy EndThenRCG/*J*/= new RegionCodeGenTy(JD$NotSameRegionCodeGenTy.INSTANCE, EndThenGen);
      EndThenRCG.$call(CGF);
    }
  }

  
  /// \brief Emit the data mapping/movement code associated with the directive
  /// \a D that should be of the form 'target [{enter|exit} data | update]'.
  /// \param D Directive to emit.
  /// \param IfCond Expression evaluated in if clause associated with the target
  /// directive, or null if no if clause is used.
  /// \param Device Expression evaluated in device clause associated with the
  /// target directive, or null if no device clause is used.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGOpenMPRuntime::emitTargetDataStandAloneCall">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp", line = 6179,
   FQN="clang::CodeGen::CGOpenMPRuntime::emitTargetDataStandAloneCall", NM="_ZN5clang7CodeGen15CGOpenMPRuntime28emitTargetDataStandAloneCallERNS0_15CodeGenFunctionERKNS_22OMPExecutableDirectiveEPKNS_4ExprES9_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp -nm=_ZN5clang7CodeGen15CGOpenMPRuntime28emitTargetDataStandAloneCallERNS0_15CodeGenFunctionERKNS_22OMPExecutableDirectiveEPKNS_4ExprES9_")
  //</editor-fold>
  public void emitTargetDataStandAloneCall(final CodeGenFunction /*&*/ CGF, final /*const*/ OMPExecutableDirective /*&*/ D, /*const*/ Expr /*P*/ IfCond, 
                              /*const*/ Expr /*P*/ Device) {
    if (!CGF.HaveInsertPoint()) {
      return;
    }
    assert ((isa_OMPTargetEnterDataDirective(D) || isa_OMPTargetExitDataDirective(D) || isa_OMPTargetUpdateDirective(D))) : "Expecting either target enter, exit data, or update directives.";
    
    // Generate the code for the opening of the data environment.
    Expr L$Device = Device;
    final CodeGenFunctionPrePostActionTy2Void ThenGen = /*[&D, &CGF, =L$Device(Device)]*/ (final CodeGenFunction /*&*/ CGF$1, final PrePostActionTy /*&*/ $Prm1) -> {
          MappableExprsHandler MEHandler = null;
          try {
            // Fill up the arrays with all the mapped variables.
            SmallVector<Value /*P*/ > BasePointers/*J*/= new SmallVector<Value /*P*/ >(16, (Value /*P*/ )null);
            SmallVector<Value /*P*/ > Pointers/*J*/= new SmallVector<Value /*P*/ >(16, (Value /*P*/ )null);
            SmallVector<Value /*P*/ > Sizes/*J*/= new SmallVector<Value /*P*/ >(16, (Value /*P*/ )null);
            SmallVectorUInt MapTypes/*J*/= new SmallVectorUInt(16, 0);
            
            // Get map clause information.
            MEHandler/*J*/= new MappableExprsHandler(D, CGF$1);
            MEHandler.generateAllInfo(BasePointers, Pointers, Sizes, MapTypes);
            
            type$ref<Value /*P*/ > BasePointersArrayArg = create_type$null$ref(null);
            type$ref<Value /*P*/ > PointersArrayArg = create_type$null$ref(null);
            type$ref<Value /*P*/ > SizesArrayArg = create_type$null$ref(null);
            type$ref<Value /*P*/ > MapTypesArrayArg = create_type$null$ref(null);
            
            // Fill up the arrays and create the arguments.
            CGOpenMPRuntimeStatics.emitOffloadingArrays(CGF$1, BasePointersArrayArg, PointersArrayArg, 
                SizesArrayArg, MapTypesArrayArg, BasePointers, 
                Pointers, Sizes, MapTypes);
            CGOpenMPRuntimeStatics.emitOffloadingArraysArgument(CGF$1, BasePointersArrayArg, PointersArrayArg, SizesArrayArg, 
                MapTypesArrayArg, BasePointersArrayArg.$deref(), PointersArrayArg.$deref(), SizesArrayArg.$deref(), 
                MapTypesArrayArg.$deref(), BasePointers.size());
            
            // Emit device ID if any.
            Value /*P*/ DeviceID = null;
            if ((L$Device != null)) {
              DeviceID = CGF$1.Builder.CreateIntCast(CGF$1.EmitScalarExpr(L$Device), 
                  CGF$1.Int32Ty, /*isSigned=*/ true);
            } else {
              DeviceID = CGF$1.Builder.getInt32(OpenMPOffloadingReservedDeviceIDs.OMP_DEVICEID_UNDEF.getValue());
            }
            
            // Emit the number of elements in the offloading arrays.
            ConstantInt /*P*/ PointerNum = CGF$1.Builder.getInt32(BasePointers.size());
            
            Value /*P*/ OffloadingArgs[/*6*/] = new Value /*P*/  [/*6*/] {
              DeviceID, PointerNum, BasePointersArrayArg.$deref(), 
              PointersArrayArg.$deref(), SizesArrayArg.$deref(), MapTypesArrayArg.$deref()};
            
            final CGOpenMPRuntime /*&*/ RT = CGF$1.CGM.getOpenMPRuntime();
            // Select the right runtime function call for each expected standalone
            // directive.
            OpenMPRTLFunction RTLFn;
            switch (D.getDirectiveKind()) {
             default:
              throw new llvm_unreachable("Unexpected standalone target data directive.");
//              break;
             case OMPD_target_enter_data:
              RTLFn = OpenMPRTLFunction.OMPRTL__tgt_target_data_begin;
              break;
             case OMPD_target_exit_data:
              RTLFn = OpenMPRTLFunction.OMPRTL__tgt_target_data_end;
              break;
             case OMPD_target_update:
              RTLFn = OpenMPRTLFunction.OMPRTL__tgt_target_data_update;
              break;
            }
            CGF$1.EmitRuntimeCall(RT.createRuntimeFunction(RTLFn.getValue()), new ArrayRef<Value /*P*/ >(OffloadingArgs, true));
          } finally {
            if (MEHandler != null) { MEHandler.$destroy(); }
          }
        };
    
    // In the event we get an if clause, we don't have to take any action on the
    // else side.
    final CodeGenFunctionPrePostActionTy2Void ElseGen = /*[]*/ (final CodeGenFunction /*&*/ CGF$1, final PrePostActionTy /*&*/ $Prm1) -> {
        };
    if ((IfCond != null)) {
      CGOpenMPRuntimeStatics.emitOMPIfClause(CGF, IfCond, new RegionCodeGenTy(JD$NotSameRegionCodeGenTy.INSTANCE, ThenGen), new RegionCodeGenTy(JD$NotSameRegionCodeGenTy.INSTANCE, ElseGen));
    } else {
      RegionCodeGenTy ThenGenRCG/*J*/= new RegionCodeGenTy(JD$NotSameRegionCodeGenTy.INSTANCE, ThenGen);
      ThenGenRCG.$call(CGF);
    }
  }

  
  /// Marks function \a Fn with properly mangled versions of vector functions.
  /// \param FD Function marked as 'declare simd'.
  /// \param Fn LLVM function that must be marked with 'declare simd'
  /// attributes.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGOpenMPRuntime::emitDeclareSimdFunction">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp", line = 6399,
   FQN="clang::CodeGen::CGOpenMPRuntime::emitDeclareSimdFunction", NM="_ZN5clang7CodeGen15CGOpenMPRuntime23emitDeclareSimdFunctionEPKNS_12FunctionDeclEPN4llvm8FunctionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp -nm=_ZN5clang7CodeGen15CGOpenMPRuntime23emitDeclareSimdFunctionEPKNS_12FunctionDeclEPN4llvm8FunctionE")
  //</editor-fold>
  public void emitDeclareSimdFunction(/*const*/ FunctionDecl /*P*/ FD, 
                         Function /*P*/ Fn) {
    final ASTContext /*&*/ C = CGM.getContext();
    FD = FD.getCanonicalDecl$Const();
    // Map params to their positions in function decl.
    DenseMapTypeUInt</*const*/ Decl /*P*/ > ParamPositions/*J*/= new DenseMapTypeUInt</*const*/ Decl /*P*/ >(DenseMapInfo$LikePtr.$Info(), 0);
    if (isa_CXXMethodDecl(FD)) {
      ParamPositions.insert_pair$KeyT$ValueT(/*{ */new std.pairPtrUInt</*const*/ Decl /*P*/ >(JD$T$RR_T1$RR.INSTANCE, FD, 0)/* }*/);
    }
    /*uint*/int ParamPos = ParamPositions.size();
    for (ParmVarDecl /*P*/ P : FD.parameters$Const()) {
      ParamPositions.insert_pair$KeyT$ValueT(/*{ */new std.pairPtrUInt</*const*/ Decl /*P*/ >(JD$T$RR_T1$RR.INSTANCE, P.getCanonicalDecl(), ParamPos)/* }*/);
      ++ParamPos;
    }
    for (OMPDeclareSimdDeclAttr /*P*/ Attr : FD.specific_attrs(OMPDeclareSimdDeclAttr.class)) {
      SmallVector<ParamAttrTy> ParamAttrs = null;
      try {
        ParamAttrs/*J*/= new SmallVector<ParamAttrTy>(JD$UInt_T$C$R.INSTANCE, 8, ParamPositions.size(), new ParamAttrTy());
        // Mark uniform parameters.
        for (Expr /*P*/ E : Attr.uniforms()) {
          E = E.IgnoreParenImpCasts();
          /*uint*/int Pos;
          if (isa_CXXThisExpr(E)) {
            Pos = ParamPositions.$at_T1$RR(FD);
          } else {
            VarDecl /*P*/ PVD = cast_ParmVarDecl(cast_DeclRefExpr(E).getDecl()).
                getCanonicalDecl();
            Pos = ParamPositions.$at_T1$RR(PVD);
          }
          ParamAttrs.$at(Pos).Kind = ParamKindTy.Uniform;
        }
        // Get alignment info.
        type$ptr<Expr>/*alignments_iterator*/ NI = $tryClone(Attr.alignments_begin());
        for (Expr /*P*/ E : Attr.aligneds()) {
          E = E.IgnoreParenImpCasts();
          /*uint*/int Pos;
          QualType ParmTy/*J*/= new QualType();
          if (isa_CXXThisExpr(E)) {
            Pos = ParamPositions.$at_T1$RR(FD);
            ParmTy.$assignMove(E.getType());
          } else {
            VarDecl /*P*/ PVD = cast_ParmVarDecl(cast_DeclRefExpr(E).getDecl()).
                getCanonicalDecl();
            Pos = ParamPositions.$at_T1$RR(PVD);
            ParmTy.$assignMove(PVD.getType());
          }
          ParamAttrs.$at(Pos).Alignment.$assignMove(
              ((NI.$star()) != null) ? (NI.$star()).EvaluateKnownConstInt(C) : APSInt.getUnsigned(C.toCharUnitsFromBits($uint2long(C.getOpenMPDefaultSimdAlign(new QualType(ParmTy)))).
                      getQuantity())
          );
          NI.$preInc();
        }
        // Mark linear parameters.
        type$ptr<Expr>/*steps_iterator*/ SI = $tryClone(Attr.steps_begin());
        uint$ptr/*uint P*/ MI = $tryClone(Attr.modifiers_begin());
        for (Expr /*P*/ E : Attr.linears()) {
          E = E.IgnoreParenImpCasts();
          /*uint*/int Pos;
          if (isa_CXXThisExpr(E)) {
            Pos = ParamPositions.$at_T1$RR(FD);
          } else {
            VarDecl /*P*/ PVD = cast_ParmVarDecl(cast_DeclRefExpr(E).getDecl()).
                getCanonicalDecl();
            Pos = ParamPositions.$at_T1$RR(PVD);
          }
          final ParamAttrTy /*&*/ ParamAttr = ParamAttrs.$at(Pos);
          ParamAttr.Kind = ParamKindTy.Linear;
          if ((SI.$star() != null)) {
            if (!(SI.$star()).EvaluateAsInt(ParamAttr.StrideOrArg, C, 
                Expr.SideEffectsKind.SE_AllowSideEffects)) {
              {
                DeclRefExpr /*P*/ DRE = cast_DeclRefExpr((SI.$star()).IgnoreParenImpCasts());
                if ((DRE != null)) {
                  {
                    ParmVarDecl /*P*/ StridePVD = cast_ParmVarDecl(DRE.getDecl());
                    if ((StridePVD != null)) {
                      ParamAttr.Kind = ParamKindTy.LinearWithVarStride;
                      ParamAttr.StrideOrArg.$assignMove(APSInt.getUnsigned($uint2ulong(ParamPositions.$at_T1$RR(StridePVD.getCanonicalDecl()))));
                    }
                  }
                }
              }
            }
          }
          SI.$preInc();
          MI.$preInc();
        }
        APSInt VLENVal/*J*/= new APSInt();
        {
          /*const*/ Expr /*P*/ VLEN = Attr.getSimdlen();
          if ((VLEN != null)) {
            VLENVal.$assignMove(VLEN.EvaluateKnownConstInt(C));
          }
        }
        OMPDeclareSimdDeclAttr.BranchStateTy State = Attr.getBranchState();
        if (CGM.getTriple().getArch() == Triple.ArchType.x86
           || CGM.getTriple().getArch() == Triple.ArchType.x86_64) {
          CGOpenMPRuntimeStatics.emitX86DeclareSimdFunction(FD, Fn, new APSInt(VLENVal), new ArrayRef<ParamAttrTy>(ParamAttrs, false), State);
        }
      } finally {
        if (ParamAttrs != null) { ParamAttrs.$destroy(); }
      }
    }
  }

  
  /// Emit initialization for doacross loop nesting support.
  /// \param D Loop-based construct used in doacross nesting construct.
  // namespace
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGOpenMPRuntime::emitDoacrossInit">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp", line = 6513,
   FQN="clang::CodeGen::CGOpenMPRuntime::emitDoacrossInit", NM="_ZN5clang7CodeGen15CGOpenMPRuntime16emitDoacrossInitERNS0_15CodeGenFunctionERKNS_16OMPLoopDirectiveE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp -nm=_ZN5clang7CodeGen15CGOpenMPRuntime16emitDoacrossInitERNS0_15CodeGenFunctionERKNS_16OMPLoopDirectiveE")
  //</editor-fold>
  public void emitDoacrossInit(final CodeGenFunction /*&*/ CGF, 
                  final /*const*/ OMPLoopDirective /*&*/ D) {
    if (!CGF.HaveInsertPoint()) {
      return;
    }
    
    final ASTContext /*&*/ C = CGM.getContext();
    QualType Int64Ty = C.getIntTypeForBitwidth(/*DestWidth=*/ 64, /*Signed=*/ /*true*/1);
    RecordDecl /*P*/ RD;
    if (KmpDimTy.isNull()) {
      // Build struct kmp_dim {  // loop bounds info casted to kmp_int64
      //  kmp_int64 lo; // lower
      //  kmp_int64 up; // upper
      //  kmp_int64 st; // stride
      // };
      RD = C.buildImplicitRecord(new StringRef(/*KEEP_STR*/"kmp_dim"));
      RD.startDefinition();
      CGOpenMPRuntimeStatics.addFieldToRecordDecl(C, RD, new QualType(Int64Ty));
      CGOpenMPRuntimeStatics.addFieldToRecordDecl(C, RD, new QualType(Int64Ty));
      CGOpenMPRuntimeStatics.addFieldToRecordDecl(C, RD, new QualType(Int64Ty));
      RD.completeDefinition();
      KmpDimTy.$assignMove(C.getRecordType(RD));
    } else {
      RD = cast_RecordDecl(KmpDimTy.$arrow().getAsTagDecl());
    }
    
    Address DimsAddr = CGF.CreateMemTemp(new QualType(KmpDimTy), new Twine(/*KEEP_STR*/"dims"));
    CGF.EmitNullInitialization(new Address(DimsAddr), new QualType(KmpDimTy));
    /*enum ANONYMOUS_INT_CONSTANTS {*/
      final /*uint*/int LowerFD = 0;
      final /*uint*/int UpperFD = LowerFD + 1;
      final /*uint*/int StrideFD = UpperFD + 1;
    /*}*/;
    // Fill dims with data.
    LValue DimsLVal = CGF.MakeAddrLValue(new Address(DimsAddr), new QualType(KmpDimTy));
    // dims.upper = num_iterations;
    LValue UpperLVal = CGF.EmitLValueForField(new LValue(DimsLVal), std.next(RD.field_begin(), UpperFD).$star());
    Value /*P*/ NumIterVal = CGF.EmitScalarConversion(CGF.EmitScalarExpr(D.getNumIterations()), D.getNumIterations().getType(), 
        new QualType(Int64Ty), D.getNumIterations().getExprLoc());
    CGF.EmitStoreOfScalar(NumIterVal, new LValue(UpperLVal));
    // dims.stride = 1;
    LValue StrideLVal = CGF.EmitLValueForField(new LValue(DimsLVal), std.next(RD.field_begin(), StrideFD).$star());
    CGF.EmitStoreOfScalar(ConstantInt.getSigned(CGM.Int64Ty, /*V=*/ 1), 
        new LValue(StrideLVal));
    
    // Build call void __kmpc_doacross_init(ident_t *loc, kmp_int32 gtid,
    // kmp_int32 num_dims, struct kmp_dim * dims);
    Value /*P*/ Args[/*4*/] = new Value /*P*/  [/*4*/] {
      emitUpdateLocation(CGF, D.getLocStart()), 
      getThreadID(CGF, D.getLocStart()), 
      ConstantInt.getSigned(CGM.Int32Ty, 1), 
      CGF.Builder.CreatePointerBitCastOrAddrSpaceCast(DimsAddr.getPointer(), CGM.Unnamed_field9.VoidPtrTy)
    };
    
    Value /*P*/ RTLFn = createRuntimeFunction(OpenMPRTLFunction.OMPRTL__kmpc_doacross_init.getValue());
    CGF.EmitRuntimeCall(RTLFn, new ArrayRef<Value /*P*/ >(Args, true));
    Value /*P*/ FiniArgs[/*2*/] = new Value /*P*/  [/*2*/] {emitUpdateLocation(CGF, D.getLocEnd()), getThreadID(CGF, D.getLocEnd())};
    Value /*P*/ FiniRTLFn = createRuntimeFunction(OpenMPRTLFunction.OMPRTL__kmpc_doacross_fini.getValue());
    CGF.EHStack.<DoacrossCleanupTy>pushCleanup$T(CleanupKind.NormalAndEHCleanup, () -> new DoacrossCleanupTy(FiniRTLFn, 
        llvm.makeArrayRef(FiniArgs, true)));
  }

  
  /// Emit code for doacross ordered directive with 'depend' clause.
  /// \param C 'depend' clause with 'sink|source' dependency kind.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGOpenMPRuntime::emitDoacrossOrdered">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp", line = 6572,
   FQN="clang::CodeGen::CGOpenMPRuntime::emitDoacrossOrdered", NM="_ZN5clang7CodeGen15CGOpenMPRuntime19emitDoacrossOrderedERNS0_15CodeGenFunctionEPKNS_15OMPDependClauseE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp -nm=_ZN5clang7CodeGen15CGOpenMPRuntime19emitDoacrossOrderedERNS0_15CodeGenFunctionEPKNS_15OMPDependClauseE")
  //</editor-fold>
  public void emitDoacrossOrdered(final CodeGenFunction /*&*/ CGF, 
                     /*const*/ OMPDependClause /*P*/ C) {
    QualType Int64Ty = CGM.getContext().getIntTypeForBitwidth(/*DestWidth=*/ 64, /*Signed=*/ 1);
    /*const*/ Expr /*P*/ CounterVal = C.getCounterValue$Const();
    assert Native.$bool(CounterVal);
    Value /*P*/ CntVal = CGF.EmitScalarConversion(CGF.EmitScalarExpr(CounterVal), 
        CounterVal.getType(), new QualType(Int64Ty), 
        CounterVal.getExprLoc());
    Address CntAddr = CGF.CreateMemTemp(new QualType(Int64Ty), new Twine(/*KEEP_STR*/".cnt.addr"));
    CGF.EmitStoreOfScalar(CntVal, new Address(CntAddr), /*Volatile=*/ false, new QualType(Int64Ty));
    Value /*P*/ Args[/*3*/] = new Value /*P*/  [/*3*/] {
      emitUpdateLocation(CGF, C.getLocStart()), 
      getThreadID(CGF, C.getLocStart()), 
      CntAddr.getPointer()};
    Value /*P*/ RTLFn;
    if (C.getDependencyKind() == OpenMPDependClauseKind.OMPC_DEPEND_source) {
      RTLFn = createRuntimeFunction(OpenMPRTLFunction.OMPRTL__kmpc_doacross_post.getValue());
    } else {
      assert (C.getDependencyKind() == OpenMPDependClauseKind.OMPC_DEPEND_sink);
      RTLFn = createRuntimeFunction(OpenMPRTLFunction.OMPRTL__kmpc_doacross_wait.getValue());
    }
    CGF.EmitRuntimeCall(RTLFn, new ArrayRef<Value /*P*/ >(Args, true));
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  // typedef llvm::function_ref<void(unsigned, unsigned, StringRef, unsigned,
  //                                    OffloadEntryInfoTargetRegion &)>
  @FunctionalInterface public static interface OffloadTargetRegionEntryInfoActTy {
    void $call(/*uint*/int u1, /*uint*/int u2, StringRef s, /*uint*/int u3, 
            OffloadEntriesInfoManagerTy.OffloadEntryInfoTargetRegion /*&*/reg);
  } 


  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return "" + "CGM=" + CGM // NOI18N
              + ", DefaultOpenMPPSource=" + DefaultOpenMPPSource // NOI18N
              + ", OpenMPDefaultLocMap=" + OpenMPDefaultLocMap // NOI18N
              + ", IdentTy=" + IdentTy // NOI18N
              + ", OpenMPDebugLocMap=" + OpenMPDebugLocMap // NOI18N
              + ", Kmpc_MicroTy=" + Kmpc_MicroTy // NOI18N
              + ", OpenMPLocThreadIDMap=" + OpenMPLocThreadIDMap // NOI18N
              + ", UDRMap=" + UDRMap // NOI18N
              + ", FunctionUDRMap=" + FunctionUDRMap // NOI18N
              + ", In=" + In // NOI18N
              + ", Out=" + Out // NOI18N
              + ", Priv=" + Priv // NOI18N
              + ", Orig=" + Orig // NOI18N
              + ", KmpCriticalNameTy=" + KmpCriticalNameTy // NOI18N
              + ", InternalVars=" + InternalVars // NOI18N
              + ", KmpRoutineEntryPtrTy=" + KmpRoutineEntryPtrTy // NOI18N
              + ", KmpRoutineEntryPtrQTy=" + KmpRoutineEntryPtrQTy // NOI18N
              + ", KmpTaskTQTy=" + KmpTaskTQTy // NOI18N
              + ", KmpDependInfoTy=" + KmpDependInfoTy // NOI18N
              + ", KmpDimTy=" + KmpDimTy // NOI18N
              + ", TgtOffloadEntryQTy=" + TgtOffloadEntryQTy // NOI18N
              + ", TgtDeviceImageQTy=" + TgtDeviceImageQTy // NOI18N
              + ", TgtBinaryDescriptorQTy=" + TgtBinaryDescriptorQTy // NOI18N
              + ", OffloadEntriesInfoManager=" + OffloadEntriesInfoManager // NOI18N
              + ", ThreadPrivateWithDefinition=" + "[SmallPtrSet$VarDecl]"; // NOI18N
  }
}
