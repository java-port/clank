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

package org.clang.codegen.impl;

import org.clank.support.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import org.llvm.ir.*;
import org.clang.codegen.CodeGen.impl.*;
import org.clank.support.aliases.type$ptr;


/// \brief An ephemeral helper class for building MS RTTI types.  It caches some
/// calls to the module and information about the most derived class in a
/// hierarchy.
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MSRTTIBuilder">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/MicrosoftCXXABI.cpp", line = 3396,
 FQN="(anonymous namespace)::MSRTTIBuilder", NM="_ZN12_GLOBAL__N_113MSRTTIBuilderE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/MicrosoftCXXABI.cpp -nm=_ZN12_GLOBAL__N_113MSRTTIBuilderE")
//</editor-fold>
public class/*struct*/ MSRTTIBuilder {
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MSRTTIBuilder::(anonymous)">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/MicrosoftCXXABI.cpp", line = 3397,
   FQN="(anonymous namespace)::MSRTTIBuilder::(anonymous)", NM="_ZN12_GLOBAL__N_113MSRTTIBuilderE_Unnamed_enum",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/MicrosoftCXXABI.cpp -nm=_ZN12_GLOBAL__N_113MSRTTIBuilderE_Unnamed_enum")
  //</editor-fold>
  public enum Unnamed_enum implements Native.NativeUIntEnum {
    HasBranchingHierarchy(1),
    HasVirtualBranchingHierarchy(2),
    HasAmbiguousBases(4);

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static Unnamed_enum valueOf(int val) {
      Unnamed_enum out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final Unnamed_enum[] VALUES;
      private static final Unnamed_enum[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (Unnamed_enum kind : Unnamed_enum.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new Unnamed_enum[min < 0 ? (1-min) : 0];
        VALUES = new Unnamed_enum[max >= 0 ? (1+max) : 0];
        for (Unnamed_enum kind : Unnamed_enum.values()) {
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
    private Unnamed_enum(int val) { this.value = (/*uint*/int)val;}
    @Override public final /*uint*/int getValue() { return value;}
    //</editor-fold>
  };
  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MSRTTIBuilder::MSRTTIBuilder">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/MicrosoftCXXABI.cpp", line = 3403,
   FQN="(anonymous namespace)::MSRTTIBuilder::MSRTTIBuilder", NM="_ZN12_GLOBAL__N_113MSRTTIBuilderC1ERNS_15MicrosoftCXXABIEPKN5clang13CXXRecordDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/MicrosoftCXXABI.cpp -nm=_ZN12_GLOBAL__N_113MSRTTIBuilderC1ERNS_15MicrosoftCXXABIEPKN5clang13CXXRecordDeclE")
  //</editor-fold>
  public MSRTTIBuilder(final MicrosoftCXXABI /*&*/ ABI, /*const*/ CXXRecordDecl /*P*/ RD) {
    // : CGM(ABI.CGM), Context(CGM.getContext()), VMContext(CGM.getLLVMContext()), Module(CGM.getModule()), RD(RD), Linkage(getLinkageForRTTI(CGM.getContext().getTagDeclType(RD))), ABI(ABI) 
    //START JInit
    this./*&*/CGM=/*&*/ABI.CGM;
    this./*&*/Context=/*&*/CGM.getContext();
    this./*&*/VMContext=/*&*/CGM.getLLVMContext();
    this./*&*/Module=/*&*/CGM.getModule();
    this.RD = RD;
    this.Linkage = MicrosoftCXXABIStatics.getLinkageForRTTI(CGM.getContext().getTagDeclType(RD));
    this./*&*/ABI=/*&*/ABI;
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MSRTTIBuilder::getBaseClassDescriptor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/MicrosoftCXXABI.cpp", line = 3546,
   FQN="(anonymous namespace)::MSRTTIBuilder::getBaseClassDescriptor", NM="_ZN12_GLOBAL__N_113MSRTTIBuilder22getBaseClassDescriptorERKNS_11MSRTTIClassE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/MicrosoftCXXABI.cpp -nm=_ZN12_GLOBAL__N_113MSRTTIBuilder22getBaseClassDescriptorERKNS_11MSRTTIClassE")
  //</editor-fold>
  public GlobalVariable /*P*/ getBaseClassDescriptor(final /*const*/ MSRTTIClass /*&*/ Class) {
    // Compute the fields for the BaseClassDescriptor.  They are computed up front
    // because they are mangled into the name of the object.
    /*uint32_t*/int OffsetInVBTable = 0;
    int/*int32_t*/ VBPtrOffset = -1;
    if ((Class.VirtualRoot != null)) {
      final MicrosoftVTableContext /*&*/ VTableContext = CGM.getMicrosoftVTableContext();
      OffsetInVBTable = VTableContext.getVBTableIndex(RD, Class.VirtualRoot) * 4;
      VBPtrOffset = $long2int(Context.getASTRecordLayout(RD).getVBPtrOffset().getQuantity());
    }
    
    SmallString/*<256>*/ MangledName/*J*/= new SmallString/*<256>*/(256);
    {
      raw_svector_ostream Out = null;
      try {
        Out/*J*/= new raw_svector_ostream(MangledName);
        ABI.getMangleContext().mangleCXXRTTIBaseClassDescriptor(Class.RD, Class.OffsetInVBase, VBPtrOffset, OffsetInVBTable, 
            Class.Flags, Out);
      } finally {
        if (Out != null) { Out.$destroy(); }
      }
    }
    {
      
      // Check to see if we've already declared this object.
      GlobalVariable /*P*/ BCD = Module.getNamedGlobal(MangledName.$StringRef());
      if ((BCD != null)) {
        return BCD;
      }
    }
    
    // Forward-declare the base class descriptor.
    StructType /*P*/ Type = ABI.getBaseClassDescriptorType();
    GlobalVariable /*P*/ BCD = /*NEW_EXPR [GlobalVariable::new]*/GlobalVariable.$new_GlobalVariable((type$ptr<?> New$Mem)->{
        return new GlobalVariable(Module, Type, /*Constant=*/ true, Linkage, 
        /*Initializer=*/ (Constant /*P*/ )null, new Twine(MangledName));
     });
    if (BCD.isWeakForLinker()) {
      BCD.setComdat(CGM.getModule().getOrInsertComdat(BCD.getName()));
    }
    
    // Initialize the BaseClassDescriptor.
    Constant /*P*/ Fields[/*7*/] = new Constant /*P*/  [/*7*/] {
      ABI.getImageRelativeConstant(ABI.getAddrOfRTTIDescriptor(Context.getTypeDeclType(Class.RD))), 
      ConstantInt.get(CGM.IntTy, $uint2ulong(Class.NumBases)), 
      ConstantInt.get(CGM.IntTy, $uint2ulong(Class.OffsetInVBase)), 
      ConstantInt.get(CGM.IntTy, $int2ulong(VBPtrOffset)), 
      ConstantInt.get(CGM.IntTy, $uint2ulong(OffsetInVBTable)), 
      ConstantInt.get(CGM.IntTy, $uint2ulong(Class.Flags)), 
      ABI.getImageRelativeConstant(new MSRTTIBuilder(ABI, Class.RD).getClassHierarchyDescriptor())
    };
    BCD.setInitializer(ConstantStruct.get(Type, new ArrayRef<Constant /*P*/ >(Fields, true)));
    return BCD;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MSRTTIBuilder::getBaseClassArray">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/MicrosoftCXXABI.cpp", line = 3513,
   FQN="(anonymous namespace)::MSRTTIBuilder::getBaseClassArray", NM="_ZN12_GLOBAL__N_113MSRTTIBuilder17getBaseClassArrayERN4llvm15SmallVectorImplINS_11MSRTTIClassEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/MicrosoftCXXABI.cpp -nm=_ZN12_GLOBAL__N_113MSRTTIBuilder17getBaseClassArrayERN4llvm15SmallVectorImplINS_11MSRTTIClassEEE")
  //</editor-fold>
  public GlobalVariable /*P*/ getBaseClassArray(final SmallVectorImpl<MSRTTIClass> /*&*/ Classes) {
    SmallString/*<256>*/ MangledName/*J*/= new SmallString/*<256>*/(256);
    {
      raw_svector_ostream Out = null;
      try {
        Out/*J*/= new raw_svector_ostream(MangledName);
        ABI.getMangleContext().mangleCXXRTTIBaseClassArray(RD, Out);
      } finally {
        if (Out != null) { Out.$destroy(); }
      }
    }
    
    // Forward-declare the base class array.
    // cl.exe pads the base class array with 1 (in 32 bit mode) or 4 (in 64 bit
    // mode) bytes of padding.  We provide a pointer sized amount of padding by
    // adding +1 to Classes.size().  The sections have pointer alignment and are
    // marked pick-any so it shouldn't matter.
    org.llvm.ir.Type /*P*/ PtrType = ABI.getImageRelativeType(ABI.getBaseClassDescriptorType().getPointerTo());
    org.llvm.ir.ArrayType /*P*/ ArrType = org.llvm.ir.ArrayType.get(PtrType, $uint2ulong(Classes.size() + 1));
    GlobalVariable /*P*/ BCA = /*NEW_EXPR [GlobalVariable::new]*/GlobalVariable.$new_GlobalVariable((type$ptr<?> New$Mem)->{
        return new GlobalVariable(Module, ArrType, 
        /*Constant=*/ true, Linkage, 
        /*Initializer=*/ (Constant /*P*/ )null, new Twine(MangledName));
     });
    if (BCA.isWeakForLinker()) {
      BCA.setComdat(CGM.getModule().getOrInsertComdat(BCA.getName()));
    }
    
    // Initialize the BaseClassArray.
    SmallVector<Constant /*P*/ > BaseClassArrayData/*J*/= new SmallVector<Constant /*P*/ >(8, (Constant /*P*/ )null);
    for (final MSRTTIClass /*&*/ Class : Classes)  {
      BaseClassArrayData.push_back(ABI.getImageRelativeConstant(getBaseClassDescriptor(Class)));
    }
    BaseClassArrayData.push_back(Constant.getNullValue(PtrType));
    BCA.setInitializer(ConstantArray.get(ArrType, new ArrayRef<Constant /*P*/ >(BaseClassArrayData, true)));
    return BCA;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MSRTTIBuilder::getClassHierarchyDescriptor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/MicrosoftCXXABI.cpp", line = 3458,
   FQN="(anonymous namespace)::MSRTTIBuilder::getClassHierarchyDescriptor", NM="_ZN12_GLOBAL__N_113MSRTTIBuilder27getClassHierarchyDescriptorEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/MicrosoftCXXABI.cpp -nm=_ZN12_GLOBAL__N_113MSRTTIBuilder27getClassHierarchyDescriptorEv")
  //</editor-fold>
  public GlobalVariable /*P*/ getClassHierarchyDescriptor() {
    SmallString/*<256>*/ MangledName/*J*/= new SmallString/*<256>*/(256);
    {
      raw_svector_ostream Out = null;
      try {
        Out/*J*/= new raw_svector_ostream(MangledName);
        ABI.getMangleContext().mangleCXXRTTIClassHierarchyDescriptor(RD, Out);
      } finally {
        if (Out != null) { Out.$destroy(); }
      }
    }
    {
      
      // Check to see if we've already declared this ClassHierarchyDescriptor.
      GlobalVariable /*P*/ CHD = Module.getNamedGlobal(MangledName.$StringRef());
      if ((CHD != null)) {
        return CHD;
      }
    }
    
    // Serialize the class hierarchy and initialize the CHD Fields.
    SmallVector<MSRTTIClass> Classes/*J*/= new SmallVector<MSRTTIClass>(8, new MSRTTIClass());
    MicrosoftCXXABIStatics.serializeClassHierarchy(Classes, RD);
    Classes.front().initialize(/*Parent=*/ (/*const*/ MSRTTIClass /*P*/ )null, /*Specifier=*/ (/*const*/ CXXBaseSpecifier /*P*/ )null);
    MicrosoftCXXABIStatics.detectAmbiguousBases(Classes);
    int Flags = 0;
    for (MSRTTIClass Class : Classes) {
      if ($greater_uint(Class.RD.getNumBases(), 1)) {
        Flags |= Unnamed_enum.HasBranchingHierarchy.getValue();
      }
      // Note: cl.exe does not calculate "HasAmbiguousBases" correctly.  We
      // believe the field isn't actually used.
      if (((Class.Flags & MSRTTIClass.Unnamed_enum.IsAmbiguous.getValue()) != 0)) {
        Flags |= Unnamed_enum.HasAmbiguousBases.getValue();
      }
    }
    if (((Flags & Unnamed_enum.HasBranchingHierarchy.getValue()) != 0) && RD.getNumVBases() != 0) {
      Flags |= Unnamed_enum.HasVirtualBranchingHierarchy.getValue();
    }
    // These gep indices are used to get the address of the first element of the
    // base class array.
    Value /*P*/ GEPIndices[/*2*/] = new Value /*P*/  [/*2*/] {
      ConstantInt.get(CGM.IntTy, $int2ulong(0)), 
      ConstantInt.get(CGM.IntTy, $int2ulong(0))};
    
    // Forward-declare the class hierarchy descriptor
    StructType /*P*/ Type = ABI.getClassHierarchyDescriptorType();
    GlobalVariable /*P*/ CHD = /*NEW_EXPR [GlobalVariable::new]*/GlobalVariable.$new_GlobalVariable((type$ptr<?> New$Mem)->{
        return new GlobalVariable(Module, Type, /*Constant=*/ true, Linkage, 
        /*Initializer=*/ (Constant /*P*/ )null, 
        new Twine(MangledName));
     });
    if (CHD.isWeakForLinker()) {
      CHD.setComdat(CGM.getModule().getOrInsertComdat(CHD.getName()));
    }
    
    GlobalVariable /*P*/ Bases = getBaseClassArray(Classes);
    
    // Initialize the base class ClassHierarchyDescriptor.
    Constant /*P*/ Fields[/*4*/] = new Constant /*P*/  [/*4*/] {
      ConstantInt.get(CGM.IntTy, $int2ulong(0)),  // Unknown
      ConstantInt.get(CGM.IntTy, $int2ulong(Flags)), 
      ConstantInt.get(CGM.IntTy, $uint2ulong(Classes.size())), 
      ABI.getImageRelativeConstant(ConstantExpr.getInBoundsGetElementPtr_Type$P_Constant$P_ArrayRef$Value$P(Bases.getValueType(), Bases, 
              new ArrayRef<Value /*P*/ >(GEPIndices, true)))
    };
    CHD.setInitializer(ConstantStruct.get(Type, new ArrayRef<Constant /*P*/ >(Fields, true)));
    return CHD;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MSRTTIBuilder::getCompleteObjectLocator">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/MicrosoftCXXABI.cpp", line = 3594,
   FQN="(anonymous namespace)::MSRTTIBuilder::getCompleteObjectLocator", NM="_ZN12_GLOBAL__N_113MSRTTIBuilder24getCompleteObjectLocatorEPKN5clang8VPtrInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/MicrosoftCXXABI.cpp -nm=_ZN12_GLOBAL__N_113MSRTTIBuilder24getCompleteObjectLocatorEPKN5clang8VPtrInfoE")
  //</editor-fold>
  public GlobalVariable /*P*/ getCompleteObjectLocator(/*const*/ VPtrInfo /*P*/ Info) {
    SmallString/*<256>*/ MangledName/*J*/= new SmallString/*<256>*/(256);
    {
      raw_svector_ostream Out = null;
      try {
        Out/*J*/= new raw_svector_ostream(MangledName);
        ABI.getMangleContext().mangleCXXRTTICompleteObjectLocator(RD, new ArrayRef</*const*/ CXXRecordDecl /*P*/ >(Info.MangledPath, true), Out);
      } finally {
        if (Out != null) { Out.$destroy(); }
      }
    }
    {
      
      // Check to see if we've already computed this complete object locator.
      GlobalVariable /*P*/ COL = Module.getNamedGlobal(MangledName.$StringRef());
      if ((COL != null)) {
        return COL;
      }
    }
    
    // Compute the fields of the complete object locator.
    int OffsetToTop = $long2int(Info.FullOffsetInMDC.getQuantity());
    int VFPtrOffset = 0;
    {
      // The offset includes the vtordisp if one exists.
      /*const*/ CXXRecordDecl /*P*/ VBase = Info.getVBaseWithVPtr();
      if ((VBase != null)) {
        if (Context.getASTRecordLayout(RD).
            getVBaseOffsetsMap().
            find$Const(VBase).$arrow().
            second.hasVtorDisp()) {
          VFPtrOffset = $llong2int(Info.NonVirtualOffset.getQuantity() + 4);
        }
      }
    }
    
    // Forward-declare the complete object locator.
    StructType /*P*/ Type = ABI.getCompleteObjectLocatorType();
    GlobalVariable /*P*/ COL = /*NEW_EXPR [GlobalVariable::new]*/GlobalVariable.$new_GlobalVariable((type$ptr<?> New$Mem)->{
        return new GlobalVariable(Module, Type, /*Constant=*/ true, Linkage, 
        /*Initializer=*/ (Constant /*P*/ )null, new Twine(MangledName));
     });
    
    // Initialize the CompleteObjectLocator.
    Constant /*P*/ Fields[/*6*/] = new Constant /*P*/  [/*6*/] {
      ConstantInt.get(CGM.IntTy, (ABI.isImageRelative() ? 1 : 0)), 
      ConstantInt.get(CGM.IntTy, $int2ulong(OffsetToTop)), 
      ConstantInt.get(CGM.IntTy, $int2ulong(VFPtrOffset)), 
      ABI.getImageRelativeConstant(CGM.GetAddrOfRTTIDescriptor(Context.getTypeDeclType(RD))), 
      ABI.getImageRelativeConstant(getClassHierarchyDescriptor()), 
      ABI.getImageRelativeConstant(COL)
    };
    ArrayRef<Constant /*P*/ > FieldsRef/*J*/= new ArrayRef<Constant /*P*/ >(Fields, true);
    if (!ABI.isImageRelative()) {
      FieldsRef.$assignMove(FieldsRef.drop_back());
    }
    COL.setInitializer(ConstantStruct.get(Type, new ArrayRef<Constant /*P*/ >(FieldsRef)));
    if (COL.isWeakForLinker()) {
      COL.setComdat(CGM.getModule().getOrInsertComdat(COL.getName()));
    }
    return COL;
  }

  
  public final CodeGenModule /*&*/ CGM;
  public final ASTContext /*&*/ Context;
  public final LLVMContext /*&*/ VMContext;
  public final org.llvm.ir.Module /*&*/ Module;
  public /*const*/ CXXRecordDecl /*P*/ RD;
  public GlobalVariable.LinkageTypes Linkage;
  public final MicrosoftCXXABI /*&*/ ABI;
  
  @Override public String toString() {
    return "" + "CGM=" + CGM // NOI18N
              + ", Context=" + "[ASTContext]" // NOI18N
              + ", VMContext=" + "[LLVMContext]" // NOI18N
              + ", Module=" + Module // NOI18N
              + ", RD=" + "[CXXRecordDecl]" // NOI18N
              + ", Linkage=" + Linkage // NOI18N
              + ", ABI=" + ABI; // NOI18N
  }
}
