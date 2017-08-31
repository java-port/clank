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

package org.llvm.linker.impl;

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.java.built_in.*;
import static org.clank.support.Casts.*;
import static org.clank.java.io.*;
import static org.clank.java.std.*;
import static org.clank.java.std_pair.*;
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
import org.llvm.support.Error;
import org.llvm.ir.*;
import org.llvm.ir.intrinsic.*;
import static org.llvm.ir.java.IrRTTI.*;
import org.llvm.ir.mdconst.*;
import org.llvm.linker.*;
import static org.llvm.linker.impl.IRMoverStatics.*;
import org.llvm.linker.java.*;
import org.llvm.linker.java.LinkerFunctionPointers.*;
import org.llvm.linker.impl.*;
import org.llvm.llvmc.*;
import org.llvm.transforms.utils.*;


/// This is responsible for keeping track of the state used for moving data
/// from SrcM to DstM.
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::IRLinker">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Linker/IRMover.cpp", line = 371,
 FQN="(anonymous namespace)::IRLinker", NM="_ZN12_GLOBAL__N_18IRLinkerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.linker/llvmToClangType ${LLVM_SRC}/llvm/lib/Linker/IRMover.cpp -nm=_ZN12_GLOBAL__N_18IRLinkerE")
//</editor-fold>
public class IRLinker implements Destructors.ClassWithDestructor {
  private final Module /*&*/ DstM;
  private std.unique_ptr<Module> SrcM;
  
  /// See IRMover::move().
  private GlobalValueValueAdder2Void AddLazyFor;
  
  private TypeMapTy TypeMap;
  private GlobalValueMaterializer GValMaterializer;
  private LocalValueMaterializer LValMaterializer;
  
  /// A metadata map that's shared between IRLinker instances.
  private final DenseMap</*const*/ Metadata /*P*/ , TrackingMDRef> /*&*/ SharedMDs;
  
  /// Mapping of values from what they used to be in Src, to what they are now
  /// in DstM.  ValueToValueMapTy is a ValueMap, which involves some overhead
  /// due to the use of Value handles which the Linker doesn't actually need,
  /// but this allows us to reuse the ValueMapper code.
  private ValueMap</*const*/ Value /*P*/ , WeakVH> ValueMap;
  private ValueMap</*const*/ Value /*P*/ , WeakVH> AliasValueMap;
  
  private DenseSet<GlobalValue /*P*/ > ValuesToLink;
  private std.vector<GlobalValue /*P*/ > Worklist;
  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::IRLinker::maybeAdd">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Linker/IRMover.cpp", line = 395,
   FQN="(anonymous namespace)::IRLinker::maybeAdd", NM="_ZN12_GLOBAL__N_18IRLinker8maybeAddEPN4llvm11GlobalValueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.linker/llvmToClangType ${LLVM_SRC}/llvm/lib/Linker/IRMover.cpp -nm=_ZN12_GLOBAL__N_18IRLinker8maybeAddEPN4llvm11GlobalValueE")
  //</editor-fold>
  private void maybeAdd(GlobalValue /*P*/ GV) {
    if (ValuesToLink.insert(GV).second) {
      Worklist.push_back_T$C$R(GV);
    }
  }

  
  /// Set to true when all global value body linking is complete (including
  /// lazy linking). Used to prevent metadata linking from creating new
  /// references.
  private boolean DoneLinkingBodies/* = false*/;
  
  /// The Error encountered during materialization. We use an Optional here to
  /// avoid needing to manage an unconsumed success value.
  private Optional<Error> FoundError;
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::IRLinker::setError">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Linker/IRMover.cpp", line = 408,
   FQN="(anonymous namespace)::IRLinker::setError", NM="_ZN12_GLOBAL__N_18IRLinker8setErrorEN4llvm5ErrorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.linker/llvmToClangType ${LLVM_SRC}/llvm/lib/Linker/IRMover.cpp -nm=_ZN12_GLOBAL__N_18IRLinker8setErrorEN4llvm5ErrorE")
  //</editor-fold>
  private void setError(Error E) {
    if (E.$bool()) {
      FoundError.$assign(std.move(E));
    }
  }

  
  /// Most of the errors produced by this module are inconvertible StringErrors.
  /// This convenience function lets us return one of those more easily.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::IRLinker::stringErr">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Linker/IRMover.cpp", line = 415,
   FQN="(anonymous namespace)::IRLinker::stringErr", NM="_ZN12_GLOBAL__N_18IRLinker9stringErrERKN4llvm5TwineE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.linker/llvmToClangType ${LLVM_SRC}/llvm/lib/Linker/IRMover.cpp -nm=_ZN12_GLOBAL__N_18IRLinker9stringErrERKN4llvm5TwineE")
  //</editor-fold>
  private Error stringErr(final /*const*/ Twine /*&*/ T) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Entry point for mapping values and alternate context for mapping aliases.
  private ValueMapper Mapper;
  private /*uint*/int AliasMCID;
  
  /// Handles cloning of a global values from the source module into
  /// the destination module, including setting the attributes and visibility.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::IRLinker::copyGlobalValueProto">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Linker/IRMover.cpp", line = 615,
   FQN="(anonymous namespace)::IRLinker::copyGlobalValueProto", NM="_ZN12_GLOBAL__N_18IRLinker20copyGlobalValueProtoEPKN4llvm11GlobalValueEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.linker/llvmToClangType ${LLVM_SRC}/llvm/lib/Linker/IRMover.cpp -nm=_ZN12_GLOBAL__N_18IRLinker20copyGlobalValueProtoEPKN4llvm11GlobalValueEb")
  //</editor-fold>
  private GlobalValue /*P*/ copyGlobalValueProto(/*const*/ GlobalValue /*P*/ SGV, 
                      boolean ForDefinition) {
    GlobalValue /*P*/ NewGV;
    {
      /*const*/ GlobalVariable /*P*/ SGVar = dyn_cast_GlobalVariable(SGV);
      if ((SGVar != null)) {
        NewGV = copyGlobalVariableProto(SGVar);
      } else {
        /*const*/ Function /*P*/ SF = dyn_cast_Function(SGV);
        if ((SF != null)) {
          NewGV = copyFunctionProto(SF);
        } else {
          if (ForDefinition) {
            NewGV = copyGlobalAliasProto(cast_GlobalAlias(SGV));
          } else {
            NewGV = new GlobalVariable(DstM, TypeMap.get(SGV.getValueType()), 
                /*isConstant*/ false, GlobalValue.LinkageTypes.ExternalLinkage, 
                /*init*/ (Constant /*P*/ )null, new Twine(SGV.getName()), 
                /*insertbefore*/ (GlobalVariable /*P*/ )null, SGV.getThreadLocalMode(), 
                SGV.getType().getAddressSpace());
          }
        }
      }
    }
    if (ForDefinition) {
      NewGV.setLinkage(SGV.getLinkage());
    } else if (SGV.hasExternalWeakLinkage()) {
      NewGV.setLinkage(GlobalValue.LinkageTypes.ExternalWeakLinkage);
    }
    
    NewGV.copyAttributesFrom(SGV);
    {
      
      GlobalObject /*P*/ NewGO = dyn_cast_GlobalObject(NewGV);
      if ((NewGO != null)) {
        // Metadata for global variables and function declarations is copied eagerly.
        if (isa_GlobalVariable(SGV) || SGV.isDeclaration()) {
          NewGO.copyMetadata(cast_GlobalObject(SGV), 0);
        }
      }
    }
    {
      
      // Remove these copied constants in case this stays a declaration, since
      // they point to the source module. If the def is linked the values will
      // be mapped in during linkFunctionBody.
      Function /*P*/ NewF = dyn_cast_Function(NewGV);
      if ((NewF != null)) {
        NewF.setPersonalityFn((Constant /*P*/ )null);
        NewF.setPrefixData((Constant /*P*/ )null);
        NewF.setPrologueData((Constant /*P*/ )null);
      }
    }
    
    return NewGV;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::IRLinker::emitWarning">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Linker/IRMover.cpp", line = 427,
   FQN="(anonymous namespace)::IRLinker::emitWarning", NM="_ZN12_GLOBAL__N_18IRLinker11emitWarningERKN4llvm5TwineE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.linker/llvmToClangType ${LLVM_SRC}/llvm/lib/Linker/IRMover.cpp -nm=_ZN12_GLOBAL__N_18IRLinker11emitWarningERKN4llvm5TwineE")
  //</editor-fold>
  private void emitWarning(final /*const*/ Twine /*&*/ Message) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      SrcM.$arrow().getContext().diagnose($c$.track(new LinkDiagnosticInfo(DiagnosticSeverity.DS_Warning, Message))); $c$.clean();
    } finally {
      $c$.$destroy();
    }
  }

  
  /// Given a global in the source module, return the global in the
  /// destination module that is being linked to, if any.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::IRLinker::getLinkedToGlobal">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Linker/IRMover.cpp", line = 433,
   FQN="(anonymous namespace)::IRLinker::getLinkedToGlobal", NM="_ZN12_GLOBAL__N_18IRLinker17getLinkedToGlobalEPKN4llvm11GlobalValueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.linker/llvmToClangType ${LLVM_SRC}/llvm/lib/Linker/IRMover.cpp -nm=_ZN12_GLOBAL__N_18IRLinker17getLinkedToGlobalEPKN4llvm11GlobalValueE")
  //</editor-fold>
  private GlobalValue /*P*/ getLinkedToGlobal(/*const*/ GlobalValue /*P*/ SrcGV) {
    // If the source has no name it can't link.  If it has local linkage,
    // there is no name match-up going on.
    if (!SrcGV.hasName() || SrcGV.hasLocalLinkage()) {
      return null;
    }
    
    // Otherwise see if we have a match in the destination module's symtab.
    GlobalValue /*P*/ DGV = DstM.getNamedValue(SrcGV.getName());
    if (!(DGV != null)) {
      return null;
    }
    
    // If we found a global with the same name in the dest module, but it has
    // internal linkage, we are really not doing any linkage here.
    if (DGV.hasLocalLinkage()) {
      return null;
    }
    
    // Otherwise, we do in fact link to the destination global.
    return DGV;
  }

  
  
  /// Loop over all of the linked values to compute type mappings.  For example,
  /// if we link "extern Foo *x" and "Foo *x = NULL", then we have two struct
  /// types 'Foo' but one got renamed when the module was loaded into the same
  /// LLVMContext.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::IRLinker::computeTypeMapping">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Linker/IRMover.cpp", line = 663,
   FQN="(anonymous namespace)::IRLinker::computeTypeMapping", NM="_ZN12_GLOBAL__N_18IRLinker18computeTypeMappingEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.linker/llvmToClangType ${LLVM_SRC}/llvm/lib/Linker/IRMover.cpp -nm=_ZN12_GLOBAL__N_18IRLinker18computeTypeMappingEv")
  //</editor-fold>
  private void computeTypeMapping() {
    std.vector<StructType /*P*/ > Types = null;
    try {
      for (final GlobalValue /*&*/ SGV : SrcM.$arrow().globals()) {
        GlobalValue /*P*/ DGV = getLinkedToGlobal(/*AddrOf*/SGV);
        if (!(DGV != null)) {
          continue;
        }
        if (!DGV.hasAppendingLinkage() || !SGV.hasAppendingLinkage()) {
          TypeMap.addTypeMapping(DGV.getType(), SGV.getType());
          continue;
        }
        
        // Unify the element type of appending arrays.
        ArrayType /*P*/ DAT = cast_ArrayType(DGV.getValueType());
        ArrayType /*P*/ SAT = cast_ArrayType(SGV.getValueType());
        TypeMap.addTypeMapping(DAT.getElementType(), SAT.getElementType());
      }
      
      for (final GlobalValue /*&*/ SGV : SrcM.$star())  {
        {
          GlobalValue /*P*/ DGV = getLinkedToGlobal(/*AddrOf*/SGV);
          if ((DGV != null)) {
            TypeMap.addTypeMapping(DGV.getType(), SGV.getType());
          }
        }
      }
      
      for (final GlobalValue /*&*/ SGV : SrcM.$arrow().aliases())  {
        {
          GlobalValue /*P*/ DGV = getLinkedToGlobal(/*AddrOf*/SGV);
          if ((DGV != null)) {
            TypeMap.addTypeMapping(DGV.getType(), SGV.getType());
          }
        }
      }
      
      // Incorporate types by name, scanning all the types in the source module.
      // At this point, the destination module may have a type "%foo = { i32 }" for
      // example.  When the source module got loaded into the same LLVMContext, if
      // it had the same type, it would have been renamed to "%foo.42 = { i32 }".
      Types = SrcM.$arrow().getIdentifiedStructTypes();
      for (StructType /*P*/ ST : Types) {
        if (!ST.hasName()) {
          continue;
        }
        
        // Check to see if there is a dot in the name followed by a digit.
        /*size_t*/int DotPos = ST.getName().rfind($$DOT);
        if (DotPos == 0 || DotPos == StringRef.npos
           || ST.getName().back() == $$DOT
           || !(isdigit($uchar2int(((/*static_cast*//*uchar*/byte)(ST.getName().$at(DotPos + 1))))) != 0)) {
          continue;
        }
        
        // Check to see if the destination module has a struct with the prefix name.
        StructType /*P*/ DST = DstM.getTypeByName(ST.getName().substr(0, DotPos));
        if (!(DST != null)) {
          continue;
        }
        
        // Don't use it if this actually came from the source module. They're in
        // the same LLVMContext after all. Also don't use it unless the type is
        // actually used in the destination module. This can happen in situations
        // like this:
        //
        //      Module A                         Module B
        //      --------                         --------
        //   %Z = type { %A }                %B = type { %C.1 }
        //   %A = type { %B.1, [7 x i8] }    %C.1 = type { i8* }
        //   %B.1 = type { %C }              %A.2 = type { %B.3, [5 x i8] }
        //   %C = type { i8* }               %B.3 = type { %C.1 }
        //
        // When we link Module B with Module A, the '%B' in Module B is
        // used. However, that would then use '%C.1'. But when we process '%C.1',
        // we prefer to take the '%C' version. So we are then left with both
        // '%C.1' and '%C' being used for the same types. This leads to some
        // variables using one type and some using the other.
        if (TypeMap.DstStructTypesSet.hasType(DST)) {
          TypeMap.addTypeMapping(DST, ST);
        }
      }
      
      // Now that we have discovered all of the type equivalences, get a body for
      // any 'opaque' types in the dest module that are now resolved.
      TypeMap.linkDefinedTypeBodies();
    } finally {
      if (Types != null) { Types.$destroy(); }
    }
  }

  
  
  /// If there were any appending global variables, link them together now.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::IRLinker::linkAppendingVarProto">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Linker/IRMover.cpp", line = 744,
   FQN="(anonymous namespace)::IRLinker::linkAppendingVarProto", NM="_ZN12_GLOBAL__N_18IRLinker21linkAppendingVarProtoEPN4llvm14GlobalVariableEPKS2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.linker/llvmToClangType ${LLVM_SRC}/llvm/lib/Linker/IRMover.cpp -nm=_ZN12_GLOBAL__N_18IRLinker21linkAppendingVarProtoEPN4llvm14GlobalVariableEPKS2_")
  //</editor-fold>
  private Expected<Constant /*P*/ > linkAppendingVarProto(GlobalVariable /*P*/ DstGV, 
                       /*const*/ GlobalVariable /*P*/ SrcGV) {
    Type /*P*/ EltTy = cast_ArrayType(TypeMap.get(SrcGV.getValueType())).
        getElementType();
    
    // FIXME: This upgrade is done during linking to support the C API.  Once the
    // old form is deprecated, we should move this upgrade to
    // llvm::UpgradeGlobalVariable() and simplify the logic here and in
    // Mapper::mapAppendingVariable() in ValueMapper.cpp.
    StringRef Name = SrcGV.getName();
    boolean IsNewStructor = false;
    boolean IsOldStructor = false;
    if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"llvm.global_ctors") || $eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"llvm.global_dtors")) {
      if (cast_StructType(EltTy).getNumElements() == 3) {
        IsNewStructor = true;
      } else {
        IsOldStructor = true;
      }
    }
    
    PointerType /*P*/ VoidPtrTy = Type.getInt8Ty(SrcGV.getContext()).getPointerTo();
    if (IsOldStructor) {
      final StructType /*&*/ ST = /*Deref*/cast_StructType(EltTy);
      Type /*P*/ Tys[/*3*/] = new Type /*P*/ [/*3*/] {ST.getElementType(0), ST.getElementType(1), VoidPtrTy};
      EltTy = StructType.get(SrcGV.getContext(), new ArrayRef<Type /*P*/ >(Tys, true), false);
    }
    
    long/*uint64_t*/ DstNumElements = 0;
    if ((DstGV != null)) {
      ArrayType /*P*/ DstTy = cast_ArrayType(DstGV.getValueType());
      DstNumElements = DstTy.getNumElements();
      if (!SrcGV.hasAppendingLinkage() || !DstGV.hasAppendingLinkage()) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          return $c$.clean(new Expected<Constant /*P*/ >($c$.track(stringErr($add_Twine$C($add_char$ptr$C_StringRef$C(/*KEEP_STR*/"Linking globals named '", SrcGV.getName()), 
                      new Twine(/*KEEP_STR*/"': can only link appending global with another appending global!"))))));
        } finally {
          $c$.$destroy();
        }
      }
      
      // Check to see that they two arrays agree on type.
      if (EltTy != DstTy.getElementType()) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          return $c$.clean(new Expected<Constant /*P*/ >($c$.track(stringErr(new Twine(/*KEEP_STR*/"Appending variables with different element types!")))));
        } finally {
          $c$.$destroy();
        }
      }
      if (DstGV.isConstant() != SrcGV.isConstant()) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          return $c$.clean(new Expected<Constant /*P*/ >($c$.track(stringErr(new Twine(/*KEEP_STR*/"Appending variables linked with different const'ness!")))));
        } finally {
          $c$.$destroy();
        }
      }
      if (DstGV.getAlignment() != SrcGV.getAlignment()) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          return $c$.clean(new Expected<Constant /*P*/ >($c$.track(stringErr(new Twine(/*KEEP_STR*/"Appending variables with different alignment need to be linked!")))));
        } finally {
          $c$.$destroy();
        }
      }
      if (DstGV.getVisibility() != SrcGV.getVisibility()) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          return $c$.clean(new Expected<Constant /*P*/ >($c$.track(stringErr(new Twine(/*KEEP_STR*/"Appending variables with different visibility need to be linked!")))));
        } finally {
          $c$.$destroy();
        }
      }
      if (DstGV.hasGlobalUnnamedAddr() != SrcGV.hasGlobalUnnamedAddr()) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          return $c$.clean(new Expected<Constant /*P*/ >($c$.track(stringErr(new Twine(/*KEEP_STR*/"Appending variables with different unnamed_addr need to be linked!")))));
        } finally {
          $c$.$destroy();
        }
      }
      if ($noteq_StringRef(DstGV.getSection(), SrcGV.getSection())) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          return $c$.clean(new Expected<Constant /*P*/ >($c$.track(stringErr(new Twine(/*KEEP_STR*/"Appending variables with different section name need to be linked!")))));
        } finally {
          $c$.$destroy();
        }
      }
    }
    
    SmallVector<Constant /*P*/ > SrcElements/*J*/= new SmallVector<Constant /*P*/ >(16, (Constant /*P*/ )null);
    getArrayElements(SrcGV.getInitializer$Const(), SrcElements);
    if (IsNewStructor) {
      SrcElements.erase(std.remove_if(SrcElements.begin(), SrcElements.end(), 
               (E) -> 
                {
                  GlobalValue /*P*/ Key = dyn_cast_GlobalValue(E.getAggregateElement(2).stripPointerCasts());
                  if (!(Key != null)) {
                    return false;
                  }
                  GlobalValue /*P*/ DGV = getLinkedToGlobal(Key);
                  return !shouldLink(DGV, /*Deref*/Key);
                }
), 
          SrcElements.end());
    }
    long/*uint64_t*/ NewSize = DstNumElements + $uint2ullong(SrcElements.size());
    ArrayType /*P*/ NewType = ArrayType.get(EltTy, NewSize);
    
    // Create the new global variable.
    GlobalVariable /*P*/ NG = new GlobalVariable(DstM, NewType, SrcGV.isConstant(), SrcGV.getLinkage(), 
        /*init*/ (Constant /*P*/ )null, /*name*/ new Twine(/*KEEP_STR*/$EMPTY), DstGV, SrcGV.getThreadLocalMode(), 
        SrcGV.getType().getAddressSpace());
    
    NG.copyAttributesFrom(SrcGV);
    forceRenaming(NG, SrcGV.getName());
    
    Constant /*P*/ Ret = ConstantExpr.getBitCast(NG, TypeMap.get(SrcGV.getType()));
    
    Mapper.scheduleMapAppendingVariable(/*Deref*/NG, 
        (DstGV != null) ? DstGV.getInitializer() : (Constant /*P*/ )null, 
        IsOldStructor, new ArrayRef<Constant /*P*/ >(SrcElements, true));
    
    // Replace any uses of the two global variables with uses of the new
    // global.
    if ((DstGV != null)) {
      DstGV.replaceAllUsesWith(ConstantExpr.getBitCast(NG, DstGV.getType()));
      DstGV.eraseFromParent();
    }
    
    return new Expected<Constant /*P*/ >(JD$Convertible.INSTANCE, Ret);
  }

  
  /// Given the GlobaValue \p SGV in the source module, and the matching
  /// GlobalValue \p DGV (if any), return true if the linker will pull \p SGV
  /// into the destination module.
  ///
  /// Note this code may call the client-provided \p AddLazyFor.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::IRLinker::shouldLink">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Linker/IRMover.cpp", line = 848,
   FQN="(anonymous namespace)::IRLinker::shouldLink", NM="_ZN12_GLOBAL__N_18IRLinker10shouldLinkEPN4llvm11GlobalValueERS2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.linker/llvmToClangType ${LLVM_SRC}/llvm/lib/Linker/IRMover.cpp -nm=_ZN12_GLOBAL__N_18IRLinker10shouldLinkEPN4llvm11GlobalValueERS2_")
  //</editor-fold>
  private boolean shouldLink(GlobalValue /*P*/ DGV, final GlobalValue /*&*/ SGV) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::IRLinker::linkGlobalValueProto">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Linker/IRMover.cpp", line = 871,
   FQN="(anonymous namespace)::IRLinker::linkGlobalValueProto", NM="_ZN12_GLOBAL__N_18IRLinker20linkGlobalValueProtoEPN4llvm11GlobalValueEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.linker/llvmToClangType ${LLVM_SRC}/llvm/lib/Linker/IRMover.cpp -nm=_ZN12_GLOBAL__N_18IRLinker20linkGlobalValueProtoEPN4llvm11GlobalValueEb")
  //</editor-fold>
  private Expected<Constant /*P*/ > linkGlobalValueProto(GlobalValue /*P*/ SGV, 
                      boolean ForAlias) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  
  /// Merge the linker flags in Src into the Dest module.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::IRLinker::linkModuleFlagsMetadata">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Linker/IRMover.cpp", line = 1011,
   FQN="(anonymous namespace)::IRLinker::linkModuleFlagsMetadata", NM="_ZN12_GLOBAL__N_18IRLinker23linkModuleFlagsMetadataEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.linker/llvmToClangType ${LLVM_SRC}/llvm/lib/Linker/IRMover.cpp -nm=_ZN12_GLOBAL__N_18IRLinker23linkModuleFlagsMetadataEv")
  //</editor-fold>
  private Error linkModuleFlagsMetadata() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  
  /// Update the initializers in the Dest module now that all globals that may be
  /// referenced are in Dest.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::IRLinker::linkGlobalInit">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Linker/IRMover.cpp", line = 946,
   FQN="(anonymous namespace)::IRLinker::linkGlobalInit", NM="_ZN12_GLOBAL__N_18IRLinker14linkGlobalInitERN4llvm14GlobalVariableES3_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.linker/llvmToClangType ${LLVM_SRC}/llvm/lib/Linker/IRMover.cpp -nm=_ZN12_GLOBAL__N_18IRLinker14linkGlobalInitERN4llvm14GlobalVariableES3_")
  //</editor-fold>
  private void linkGlobalInit(final GlobalVariable /*&*/ Dst, final GlobalVariable /*&*/ Src) {
    // Figure out what the initializer looks like in the dest module.
    Mapper.scheduleMapGlobalInitializer(Dst, /*Deref*/Src.getInitializer());
  }

  
  /// Copy the source function over into the dest function and fix up references
  /// to values. At this point we know that Dest is an external function, and
  /// that Src is not.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::IRLinker::linkFunctionBody">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Linker/IRMover.cpp", line = 954,
   FQN="(anonymous namespace)::IRLinker::linkFunctionBody", NM="_ZN12_GLOBAL__N_18IRLinker16linkFunctionBodyERN4llvm8FunctionES3_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.linker/llvmToClangType ${LLVM_SRC}/llvm/lib/Linker/IRMover.cpp -nm=_ZN12_GLOBAL__N_18IRLinker16linkFunctionBodyERN4llvm8FunctionES3_")
  //</editor-fold>
  private Error linkFunctionBody(final Function /*&*/ Dst, final Function /*&*/ Src) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::IRLinker::linkAliasBody">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Linker/IRMover.cpp", line = 981,
   FQN="(anonymous namespace)::IRLinker::linkAliasBody", NM="_ZN12_GLOBAL__N_18IRLinker13linkAliasBodyERN4llvm11GlobalAliasES3_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.linker/llvmToClangType ${LLVM_SRC}/llvm/lib/Linker/IRMover.cpp -nm=_ZN12_GLOBAL__N_18IRLinker13linkAliasBodyERN4llvm11GlobalAliasES3_")
  //</editor-fold>
  private void linkAliasBody(final GlobalAlias /*&*/ Dst, final GlobalAlias /*&*/ Src) {
    Mapper.scheduleMapGlobalAliasee(Dst, /*Deref*/Src.getAliasee(), AliasMCID);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::IRLinker::linkGlobalValueBody">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Linker/IRMover.cpp", line = 985,
   FQN="(anonymous namespace)::IRLinker::linkGlobalValueBody", NM="_ZN12_GLOBAL__N_18IRLinker19linkGlobalValueBodyERN4llvm11GlobalValueES3_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.linker/llvmToClangType ${LLVM_SRC}/llvm/lib/Linker/IRMover.cpp -nm=_ZN12_GLOBAL__N_18IRLinker19linkGlobalValueBodyERN4llvm11GlobalValueES3_")
  //</editor-fold>
  private Error linkGlobalValueBody(final GlobalValue /*&*/ Dst, final GlobalValue /*&*/ Src) {
    {
      Function /*P*/ F = dyn_cast_Function(/*AddrOf*/Src);
      if ((F != null)) {
        return linkFunctionBody(cast_Function(Dst), /*Deref*/F);
      }
    }
    {
      GlobalVariable /*P*/ GVar = dyn_cast_GlobalVariable(/*AddrOf*/Src);
      if ((GVar != null)) {
        linkGlobalInit(cast_GlobalVariable(Dst), /*Deref*/GVar);
        return Error.success();
      }
    }
    linkAliasBody(cast_GlobalAlias(Dst), cast_GlobalAlias(Src));
    return Error.success();
  }

  
  /// Functions that take care of cloning a specific global value type
  /// into the destination module.
  
  /// Loop through the global variables in the src module and merge them into the
  /// dest module.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::IRLinker::copyGlobalVariableProto">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Linker/IRMover.cpp", line = 582,
   FQN="(anonymous namespace)::IRLinker::copyGlobalVariableProto", NM="_ZN12_GLOBAL__N_18IRLinker23copyGlobalVariableProtoEPKN4llvm14GlobalVariableE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.linker/llvmToClangType ${LLVM_SRC}/llvm/lib/Linker/IRMover.cpp -nm=_ZN12_GLOBAL__N_18IRLinker23copyGlobalVariableProtoEPKN4llvm14GlobalVariableE")
  //</editor-fold>
  private GlobalVariable /*P*/ copyGlobalVariableProto(/*const*/ GlobalVariable /*P*/ SGVar) {
    // No linking to be performed or linking from the source: simply create an
    // identical version of the symbol over in the dest module... the
    // initializer will be filled in later by LinkGlobalInits.
    GlobalVariable /*P*/ NewDGV = new GlobalVariable(DstM, TypeMap.get(SGVar.getValueType()), 
        SGVar.isConstant(), GlobalValue.LinkageTypes.ExternalLinkage, 
        /*init*/ (Constant /*P*/ )null, new Twine(SGVar.getName()), 
        /*insertbefore*/ (GlobalVariable /*P*/ )null, SGVar.getThreadLocalMode(), 
        SGVar.getType().getAddressSpace());
    NewDGV.setAlignment(SGVar.getAlignment());
    return NewDGV;
  }

  
  /// Link the function in the source module into the destination module if
  /// needed, setting up mapping information.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::IRLinker::copyFunctionProto">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Linker/IRMover.cpp", line = 598,
   FQN="(anonymous namespace)::IRLinker::copyFunctionProto", NM="_ZN12_GLOBAL__N_18IRLinker17copyFunctionProtoEPKN4llvm8FunctionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.linker/llvmToClangType ${LLVM_SRC}/llvm/lib/Linker/IRMover.cpp -nm=_ZN12_GLOBAL__N_18IRLinker17copyFunctionProtoEPKN4llvm8FunctionE")
  //</editor-fold>
  private Function /*P*/ copyFunctionProto(/*const*/ Function /*P*/ SF) {
    // If there is no linkage to be performed or we are linking from the source,
    // bring SF over.
    return Function.Create(TypeMap.get(SF.getFunctionType()), 
        GlobalValue.LinkageTypes.ExternalLinkage, new Twine(SF.getName()), /*AddrOf*/DstM);
  }

  
  /// Set up prototypes for any aliases that come over from the source module.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::IRLinker::copyGlobalAliasProto">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Linker/IRMover.cpp", line = 606,
   FQN="(anonymous namespace)::IRLinker::copyGlobalAliasProto", NM="_ZN12_GLOBAL__N_18IRLinker20copyGlobalAliasProtoEPKN4llvm11GlobalAliasE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.linker/llvmToClangType ${LLVM_SRC}/llvm/lib/Linker/IRMover.cpp -nm=_ZN12_GLOBAL__N_18IRLinker20copyGlobalAliasProtoEPKN4llvm11GlobalAliasE")
  //</editor-fold>
  private GlobalValue /*P*/ copyGlobalAliasProto(/*const*/ GlobalAlias /*P*/ SGA) {
    // If there is no linkage to be performed or we're linking from the source,
    // bring over SGA.
    Type /*P*/ Ty = TypeMap.get(SGA.getValueType());
    return GlobalAlias.create(Ty, SGA.getType().getPointerAddressSpace(), 
        GlobalValue.LinkageTypes.ExternalLinkage, new Twine(SGA.getName()), 
        /*AddrOf*/DstM);
  }

  
  
  /// Insert all of the named MDNodes in Src into the Dest module.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::IRLinker::linkNamedMDNodes">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Linker/IRMover.cpp", line = 997,
   FQN="(anonymous namespace)::IRLinker::linkNamedMDNodes", NM="_ZN12_GLOBAL__N_18IRLinker16linkNamedMDNodesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.linker/llvmToClangType ${LLVM_SRC}/llvm/lib/Linker/IRMover.cpp -nm=_ZN12_GLOBAL__N_18IRLinker16linkNamedMDNodesEv")
  //</editor-fold>
  private void linkNamedMDNodes() {
    throw new UnsupportedOperationException("EmptyBody");
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::IRLinker::IRLinker">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Linker/IRMover.cpp", line = 482,
   FQN="(anonymous namespace)::IRLinker::IRLinker", NM="_ZN12_GLOBAL__N_18IRLinkerC1ERN4llvm6ModuleERNS1_8DenseMapIPKNS1_8MetadataENS1_13TrackingMDRefENS1_12DenseMapInfoIS7_EENS1_6detail12DenseMapPairIS7_S8_EEEERNS1_7IRMover23IdentifiedStructTypeSetESt10unique_ptrIS2_St14default_deleteIS2_EENS1_8ArrayRefIPNS1_11GlobalValueEEESt8functionIFvRSO_SR_IFvSS_EEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.linker/llvmToClangType ${LLVM_SRC}/llvm/lib/Linker/IRMover.cpp -nm=_ZN12_GLOBAL__N_18IRLinkerC1ERN4llvm6ModuleERNS1_8DenseMapIPKNS1_8MetadataENS1_13TrackingMDRefENS1_12DenseMapInfoIS7_EENS1_6detail12DenseMapPairIS7_S8_EEEERNS1_7IRMover23IdentifiedStructTypeSetESt10unique_ptrIS2_St14default_deleteIS2_EENS1_8ArrayRefIPNS1_11GlobalValueEEESt8functionIFvRSO_SR_IFvSS_EEEE")
  //</editor-fold>
  public IRLinker(final Module /*&*/ DstM, final DenseMap</*const*/ Metadata /*P*/ , TrackingMDRef> /*&*/ SharedMDs, 
      final IRMover.IdentifiedStructTypeSet /*&*/ Set, std.unique_ptr<Module> SrcM, 
      ArrayRef<GlobalValue /*P*/ > ValuesToLink, 
      GlobalValueValueAdder2Void AddLazyFor) {
    // : DstM(DstM), SrcM(std::move(SrcM)), AddLazyFor(std::move(AddLazyFor)), TypeMap(Set), GValMaterializer(*this), LValMaterializer(*this), SharedMDs(SharedMDs), ValueMap(), AliasValueMap(), ValuesToLink(), Worklist(), DoneLinkingBodies(false), FoundError(), Mapper(ValueMap, RF_MoveDistinctMDs | RF_IgnoreMissingLocals, &TypeMap, &GValMaterializer), AliasMCID(Mapper.registerAlternateMappingContext(AliasValueMap, &LValMaterializer)) 
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::IRLinker::~IRLinker">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Linker/IRMover.cpp", line = 497,
   FQN="(anonymous namespace)::IRLinker::~IRLinker", NM="_ZN12_GLOBAL__N_18IRLinkerD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.linker/llvmToClangType ${LLVM_SRC}/llvm/lib/Linker/IRMover.cpp -nm=_ZN12_GLOBAL__N_18IRLinkerD0Ev")
  //</editor-fold>
  public void $destroy() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::IRLinker::run">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Linker/IRMover.cpp", line = 1183,
   FQN="(anonymous namespace)::IRLinker::run", NM="_ZN12_GLOBAL__N_18IRLinker3runEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.linker/llvmToClangType ${LLVM_SRC}/llvm/lib/Linker/IRMover.cpp -nm=_ZN12_GLOBAL__N_18IRLinker3runEv")
  //</editor-fold>
  public Error run() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::IRLinker::materialize">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Linker/IRMover.cpp", line = 533,
   FQN="(anonymous namespace)::IRLinker::materialize", NM="_ZN12_GLOBAL__N_18IRLinker11materializeEPN4llvm5ValueEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.linker/llvmToClangType ${LLVM_SRC}/llvm/lib/Linker/IRMover.cpp -nm=_ZN12_GLOBAL__N_18IRLinker11materializeEPN4llvm5ValueEb")
  //</editor-fold>
  public Value /*P*/ materialize(Value /*P*/ V, boolean ForAlias) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  @Override public String toString() {
    return "" + "DstM=" + DstM // NOI18N
              + ", SrcM=" + SrcM // NOI18N
              + ", AddLazyFor=" + AddLazyFor // NOI18N
              + ", TypeMap=" + TypeMap // NOI18N
              + ", GValMaterializer=" + GValMaterializer // NOI18N
              + ", LValMaterializer=" + LValMaterializer // NOI18N
              + ", SharedMDs=" + SharedMDs // NOI18N
              + ", ValueMap=" + ValueMap // NOI18N
              + ", AliasValueMap=" + AliasValueMap // NOI18N
              + ", ValuesToLink=" + ValuesToLink // NOI18N
              + ", Worklist=" + Worklist // NOI18N
              + ", DoneLinkingBodies=" + DoneLinkingBodies // NOI18N
              + ", FoundError=" + FoundError // NOI18N
              + ", Mapper=" + Mapper // NOI18N
              + ", AliasMCID=" + AliasMCID; // NOI18N
  }
}
