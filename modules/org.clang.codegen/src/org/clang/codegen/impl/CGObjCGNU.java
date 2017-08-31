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

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.java.std.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import org.clang.basic.*;
import org.llvm.ir.*;
import org.clang.codegen.CodeGen.*;
import org.clang.codegen.CodeGen.impl.*;
import static org.clang.ast.AstClangGlobals.*;
import static org.clang.ast.java.AstDeclarationsRTTI.*;
import static org.llvm.ir.java.IrRTTI.*;
import org.clang.basic.llvm.DenseMapInfoSelector;
import static org.clang.codegen.impl.CGObjCGNUStatics.*;


/// GNU Objective-C runtime code generation.  This class implements the parts of
/// Objective-C support that are specific to the GNU family of runtimes (GCC,
/// GNUstep and ObjFW).
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGObjCGNU">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCGNU.cpp", line = 96,
 FQN="(anonymous namespace)::CGObjCGNU", NM="_ZN12_GLOBAL__N_19CGObjCGNUE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCGNU.cpp -nm=_ZN12_GLOBAL__N_19CGObjCGNUE")
//</editor-fold>
public abstract class CGObjCGNU extends /*public*/ CGObjCRuntime implements Destructors.ClassWithDestructor {
/*protected:*/
  /// The LLVM module into which output is inserted
  protected final org.llvm.ir.Module /*&*/ TheModule;
  /// strut objc_super.  Used for sending messages to super.  This structure
  /// contains the receiver (object) and the expected class.
  protected StructType /*P*/ ObjCSuperTy;
  /// struct objc_super*.  The type of the argument to the superclass message
  /// lookup functions.  
  protected org.llvm.ir.PointerType /*P*/ PtrToObjCSuperTy;
  /// LLVM type for selectors.  Opaque pointer (i8*) unless a header declaring
  /// SEL is included in a header somewhere, in which case it will be whatever
  /// type is declared in that header, most likely {i8*, i8*}.
  protected org.llvm.ir.PointerType /*P*/ SelectorTy;
  /// LLVM i8 type.  Cached here to avoid repeatedly getting it in all of the
  /// places where it's used
  protected IntegerType /*P*/ Int8Ty;
  /// Pointer to i8 - LLVM type of char*, for all of the places where the
  /// runtime needs to deal with C strings.
  protected org.llvm.ir.PointerType /*P*/ PtrToInt8Ty;
  /// Instance Method Pointer type.  This is a pointer to a function that takes,
  /// at a minimum, an object and a selector, and is the generic type for
  /// Objective-C methods.  Due to differences between variadic / non-variadic
  /// calling conventions, it must always be cast to the correct type before
  /// actually being used.
  protected org.llvm.ir.PointerType /*P*/ IMPTy;
  /// Type of an untyped Objective-C object.  Clang treats id as a built-in type
  /// when compiling Objective-C code, so this may be an opaque pointer (i8*),
  /// but if the runtime header declaring it is included then it may be a
  /// pointer to a structure.
  protected org.llvm.ir.PointerType /*P*/ IdTy;
  /// Pointer to a pointer to an Objective-C object.  Used in the new ABI
  /// message lookup function and some GC-related functions.
  protected org.llvm.ir.PointerType /*P*/ PtrToIdTy;
  /// The clang type of id.  Used when using the clang CGCall infrastructure to
  /// call Objective-C methods.
  protected CanQual<org.clang.ast.Type> ASTIdTy;
  /// LLVM type for C int type.
  protected IntegerType /*P*/ IntTy;
  /// LLVM type for an opaque pointer.  This is identical to PtrToInt8Ty, but is
  /// used in the code to document the difference between i8* meaning a pointer
  /// to a C string and i8* meaning a pointer to some opaque type.
  protected org.llvm.ir.PointerType /*P*/ PtrTy;
  /// LLVM type for C long type.  The runtime uses this in a lot of places where
  /// it should be using intptr_t, but we can't fix this without breaking
  /// compatibility with GCC...
  protected IntegerType /*P*/ LongTy;
  /// LLVM type for C size_t.  Used in various runtime data structures.
  protected IntegerType /*P*/ SizeTy;
  /// LLVM type for C intptr_t.  
  protected IntegerType /*P*/ IntPtrTy;
  /// LLVM type for C ptrdiff_t.  Mainly used in property accessor functions.
  protected IntegerType /*P*/ PtrDiffTy;
  /// LLVM type for C int*.  Used for GCC-ABI-compatible non-fragile instance
  /// variables.
  protected org.llvm.ir.PointerType /*P*/ PtrToIntTy;
  /// LLVM type for Objective-C BOOL type.
  protected org.llvm.ir.Type /*P*/ BoolTy;
  /// 32-bit integer type, to save us needing to look it up every time it's used.
  protected IntegerType /*P*/ Int32Ty;
  /// 64-bit integer type, to save us needing to look it up every time it's used.
  protected IntegerType /*P*/ Int64Ty;
  /// Metadata kind used to tie method lookups to message sends.  The GNUstep
  /// runtime provides some LLVM passes that can use this to do things like
  /// automatic IMP caching and speculative inlining.
  protected /*uint*/int msgSendMDKind;
  
  /// Helper function that generates a constant string and returns a pointer to
  /// the start of the string.  The result of this function can be used anywhere
  /// where the C code specifies const char*.  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGObjCGNU::MakeConstantString">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCGNU.cpp", line = 166,
   FQN="(anonymous namespace)::CGObjCGNU::MakeConstantString", NM="_ZN12_GLOBAL__N_19CGObjCGNU18MakeConstantStringERKSsS2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCGNU.cpp -nm=_ZN12_GLOBAL__N_19CGObjCGNU18MakeConstantStringERKSsS2_")
  //</editor-fold>
  protected Constant /*P*/ MakeConstantString(final /*const*/std.string/*&*/ Str) {
    return MakeConstantString(Str, 
                    new std.string(JD$T$C$P_T2$C$R.INSTANCE, /*KEEP_STR*/$EMPTY));
  }
  protected Constant /*P*/ MakeConstantString(final /*const*/std.string/*&*/ Str, 
                    final /*const*/std.string/*&*/ Name/*= ""*/) {
    ConstantAddress Array = CGM.GetAddrOfConstantCString(Str, Name.c_str());
    return ConstantExpr.getGetElementPtr_Type$P_Constant$P_ArrayRef$Constant$P_bool_Type$P(Array.getElementType(), 
        Array.getPointer(), new ArrayRef<Constant /*P*/ >(Zeros, true));
  }

  
  /// Emits a linkonce_odr string, whose name is the prefix followed by the
  /// string value.  This allows the linker to combine the strings between
  /// different modules.  Used for EH typeinfo names, selector strings, and a
  /// few other things.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGObjCGNU::ExportUniqueString">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCGNU.cpp", line = 177,
   FQN="(anonymous namespace)::CGObjCGNU::ExportUniqueString", NM="_ZN12_GLOBAL__N_19CGObjCGNU18ExportUniqueStringERKSsSs",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCGNU.cpp -nm=_ZN12_GLOBAL__N_19CGObjCGNU18ExportUniqueStringERKSsSs")
  //</editor-fold>
  protected Constant /*P*/ ExportUniqueString(final /*const*/std.string/*&*/ Str, 
                    /*const*/std.string prefix) {
    std.string name = $add_string$C(prefix, Str);
    GlobalVariable /*P*/ ConstStr = TheModule.getGlobalVariable(new StringRef(name));
    if (!(ConstStr != null)) {
      Constant /*P*/ value = ConstantDataArray.getString(VMContext, new StringRef(Str));
      ConstStr = /*NEW_EXPR [GlobalVariable::new]*/GlobalVariable.$new_GlobalVariable((type$ptr<?> New$Mem)->{
          return new GlobalVariable(TheModule, value.getType(), true, 
          GlobalValue.LinkageTypes.LinkOnceODRLinkage, value, new Twine($add_string$C(prefix, Str)));
       });
    }
    return ConstantExpr.getGetElementPtr_Type$P_Constant$P_ArrayRef$Constant$P_bool_Type$P(ConstStr.getValueType(), 
        ConstStr, new ArrayRef<Constant /*P*/ >(Zeros, true));
  }

  
  /// Generates a global structure, initialized by the elements in the vector.
  /// The element types must match the types of the structure elements in the
  /// first argument.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGObjCGNU::MakeGlobal">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCGNU.cpp", line = 193,
   FQN="(anonymous namespace)::CGObjCGNU::MakeGlobal", NM="_ZN12_GLOBAL__N_19CGObjCGNU10MakeGlobalEPN4llvm10StructTypeENS1_8ArrayRefIPNS1_8ConstantEEEN5clang9CharUnitsENS1_9StringRefENS1_11GlobalValue12LinkageTypesE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCGNU.cpp -nm=_ZN12_GLOBAL__N_19CGObjCGNU10MakeGlobalEPN4llvm10StructTypeENS1_8ArrayRefIPNS1_8ConstantEEEN5clang9CharUnitsENS1_9StringRefENS1_11GlobalValue12LinkageTypesE")
  //</editor-fold>
  protected GlobalVariable /*P*/ MakeGlobal_StructType$P_ArrayRef$Constant$P_CharUnits_StringRef_LinkageTypes(StructType /*P*/ Ty, 
                                                                              ArrayRef<Constant /*P*/ > V, 
                                                                              CharUnits Align) {
    return MakeGlobal_StructType$P_ArrayRef$Constant$P_CharUnits_StringRef_LinkageTypes(Ty, 
                                                                              V, 
                                                                              Align, 
                                                                              new StringRef(/*KEEP_STR*/$EMPTY), 
                                                                              GlobalValue.LinkageTypes.InternalLinkage);
  }
  protected GlobalVariable /*P*/ MakeGlobal_StructType$P_ArrayRef$Constant$P_CharUnits_StringRef_LinkageTypes(StructType /*P*/ Ty, 
                                                                              ArrayRef<Constant /*P*/ > V, 
                                                                              CharUnits Align, 
                                                                              StringRef Name/*= ""*/) {
    return MakeGlobal_StructType$P_ArrayRef$Constant$P_CharUnits_StringRef_LinkageTypes(Ty, 
                                                                              V, 
                                                                              Align, 
                                                                              Name, 
                                                                              GlobalValue.LinkageTypes.InternalLinkage);
  }
  protected GlobalVariable /*P*/ MakeGlobal_StructType$P_ArrayRef$Constant$P_CharUnits_StringRef_LinkageTypes(StructType /*P*/ Ty, 
                                                                              ArrayRef<Constant /*P*/ > V, 
                                                                              CharUnits Align, 
                                                                              StringRef Name/*= ""*/, 
                                                                              GlobalValue.LinkageTypes linkage/*= GlobalValue::InternalLinkage*/) {
    Constant /*P*/ C = ConstantStruct.get(Ty, new ArrayRef<Constant /*P*/ >(V));
    GlobalVariable /*P*/ GV = /*NEW_EXPR [GlobalVariable::new]*/GlobalVariable.$new_GlobalVariable((type$ptr<?> New$Mem)->{
        return new GlobalVariable(TheModule, Ty, false, 
        linkage, C, new Twine(Name));
     });
    GV.setAlignment($long2uint(Align.getQuantity()));
    return GV;
  }

  
  /// Generates a global array.  The vector must contain the same number of
  /// elements that the array type declares, of the type specified as the array
  /// element type.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGObjCGNU::MakeGlobal">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCGNU.cpp", line = 209,
   FQN="(anonymous namespace)::CGObjCGNU::MakeGlobal", NM="_ZN12_GLOBAL__N_19CGObjCGNU10MakeGlobalEPN4llvm9ArrayTypeENS1_8ArrayRefIPNS1_8ConstantEEEN5clang9CharUnitsENS1_9StringRefENS1_11GlobalValue12LinkageTypesE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCGNU.cpp -nm=_ZN12_GLOBAL__N_19CGObjCGNU10MakeGlobalEPN4llvm9ArrayTypeENS1_8ArrayRefIPNS1_8ConstantEEEN5clang9CharUnitsENS1_9StringRefENS1_11GlobalValue12LinkageTypesE")
  //</editor-fold>
  protected GlobalVariable /*P*/ MakeGlobal_ArrayType$P_ArrayRef$Constant$P_CharUnits_StringRef_LinkageTypes(org.llvm.ir.ArrayType /*P*/ Ty, 
                                                                             ArrayRef<Constant /*P*/ > V, 
                                                                             CharUnits Align) {
    return MakeGlobal_ArrayType$P_ArrayRef$Constant$P_CharUnits_StringRef_LinkageTypes(Ty, 
                                                                             V, 
                                                                             Align, 
                                                                             new StringRef(/*KEEP_STR*/$EMPTY), 
                                                                             GlobalValue.LinkageTypes.InternalLinkage);
  }
  protected GlobalVariable /*P*/ MakeGlobal_ArrayType$P_ArrayRef$Constant$P_CharUnits_StringRef_LinkageTypes(org.llvm.ir.ArrayType /*P*/ Ty, 
                                                                             ArrayRef<Constant /*P*/ > V, 
                                                                             CharUnits Align, 
                                                                             StringRef Name/*= ""*/) {
    return MakeGlobal_ArrayType$P_ArrayRef$Constant$P_CharUnits_StringRef_LinkageTypes(Ty, 
                                                                             V, 
                                                                             Align, 
                                                                             Name, 
                                                                             GlobalValue.LinkageTypes.InternalLinkage);
  }
  protected GlobalVariable /*P*/ MakeGlobal_ArrayType$P_ArrayRef$Constant$P_CharUnits_StringRef_LinkageTypes(org.llvm.ir.ArrayType /*P*/ Ty, 
                                                                             ArrayRef<Constant /*P*/ > V, 
                                                                             CharUnits Align, 
                                                                             StringRef Name/*= ""*/, 
                                                                             GlobalValue.LinkageTypes linkage/*= GlobalValue::InternalLinkage*/) {
    Constant /*P*/ C = ConstantArray.get(Ty, new ArrayRef<Constant /*P*/ >(V));
    GlobalVariable /*P*/ GV = /*NEW_EXPR [GlobalVariable::new]*/GlobalVariable.$new_GlobalVariable((type$ptr<?> New$Mem)->{
        return new GlobalVariable(TheModule, Ty, false, 
        linkage, C, new Twine(Name));
     });
    GV.setAlignment($long2uint(Align.getQuantity()));
    return GV;
  }

  
  /// Generates a global array, inferring the array type from the specified
  /// element type and the size of the initialiser.  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGObjCGNU::MakeGlobalArray">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCGNU.cpp", line = 224,
   FQN="(anonymous namespace)::CGObjCGNU::MakeGlobalArray", NM="_ZN12_GLOBAL__N_19CGObjCGNU15MakeGlobalArrayEPN4llvm4TypeENS1_8ArrayRefIPNS1_8ConstantEEEN5clang9CharUnitsENS1_9StringRefENS1_11GlobalValue12LinkageTypesE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCGNU.cpp -nm=_ZN12_GLOBAL__N_19CGObjCGNU15MakeGlobalArrayEPN4llvm4TypeENS1_8ArrayRefIPNS1_8ConstantEEEN5clang9CharUnitsENS1_9StringRefENS1_11GlobalValue12LinkageTypesE")
  //</editor-fold>
  protected GlobalVariable /*P*/ MakeGlobalArray(org.llvm.ir.Type /*P*/ Ty, 
                 ArrayRef<Constant /*P*/ > V, 
                 CharUnits Align) {
    return MakeGlobalArray(Ty, 
                 V, 
                 Align, 
                 new StringRef(/*KEEP_STR*/$EMPTY), 
                 GlobalValue.LinkageTypes.InternalLinkage);
  }
  protected GlobalVariable /*P*/ MakeGlobalArray(org.llvm.ir.Type /*P*/ Ty, 
                 ArrayRef<Constant /*P*/ > V, 
                 CharUnits Align, 
                 StringRef Name/*= ""*/) {
    return MakeGlobalArray(Ty, 
                 V, 
                 Align, 
                 Name, 
                 GlobalValue.LinkageTypes.InternalLinkage);
  }
  protected GlobalVariable /*P*/ MakeGlobalArray(org.llvm.ir.Type /*P*/ Ty, 
                 ArrayRef<Constant /*P*/ > V, 
                 CharUnits Align, 
                 StringRef Name/*= ""*/, 
                 GlobalValue.LinkageTypes linkage/*= GlobalValue::InternalLinkage*/) {
    org.llvm.ir.ArrayType /*P*/ ArrayTy = org.llvm.ir.ArrayType.get(Ty, $uint2ulong(V.size()));
    return MakeGlobal_ArrayType$P_ArrayRef$Constant$P_CharUnits_StringRef_LinkageTypes(ArrayTy, new ArrayRef<Constant /*P*/ >(V), new CharUnits(Align), new StringRef(Name), linkage);
  }

  
  /// Returns a property name and encoding string.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGObjCGNU::MakePropertyEncodingString">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCGNU.cpp", line = 235,
   FQN="(anonymous namespace)::CGObjCGNU::MakePropertyEncodingString", NM="_ZN12_GLOBAL__N_19CGObjCGNU26MakePropertyEncodingStringEPKN5clang16ObjCPropertyDeclEPKNS1_4DeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCGNU.cpp -nm=_ZN12_GLOBAL__N_19CGObjCGNU26MakePropertyEncodingStringEPKN5clang16ObjCPropertyDeclEPKNS1_4DeclE")
  //</editor-fold>
  protected Constant /*P*/ MakePropertyEncodingString(/*const*/ ObjCPropertyDecl /*P*/ PD, 
                            /*const*/ Decl /*P*/ Container) {
    final /*const*/ ObjCRuntime /*&*/ R = CGM.getLangOpts().ObjCRuntime;
    if ((R.getKind() == ObjCRuntime.Kind.GNUstep)
       && (VersionTuple.$greatereq_VersionTuple$C(R.getVersion(), new VersionTuple(1, 6)))) {
      std.string NameAndAttributes/*J*/= new std.string();
      std.string TypeStr/*J*/= new std.string();
      CGM.getContext().getObjCEncodingForPropertyDecl(PD, Container, TypeStr);
      NameAndAttributes.$addassign_T($$TERM);
      NameAndAttributes.$addassign_T($uint2char(TypeStr.length() + 3));
      NameAndAttributes.$addassign(TypeStr);
      NameAndAttributes.$addassign_T($$TERM);
      NameAndAttributes.$addassign(PD.getNameAsString());
      return MakeConstantString(NameAndAttributes);
    }
    return MakeConstantString(PD.getNameAsString());
  }

  
  /// Push the property attributes into two structure fields. 
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGObjCGNU::PushPropertyAttributes">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCGNU.cpp", line = 254,
   FQN="(anonymous namespace)::CGObjCGNU::PushPropertyAttributes", NM="_ZN12_GLOBAL__N_19CGObjCGNU22PushPropertyAttributesERSt6vectorIPN4llvm8ConstantESaIS4_EEPN5clang16ObjCPropertyDeclEbb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCGNU.cpp -nm=_ZN12_GLOBAL__N_19CGObjCGNU22PushPropertyAttributesERSt6vectorIPN4llvm8ConstantESaIS4_EEPN5clang16ObjCPropertyDeclEbb")
  //</editor-fold>
  protected void PushPropertyAttributes(final std.vector<Constant /*P*/ > /*&*/ Fields, 
                        ObjCPropertyDecl /*P*/ property) {
    PushPropertyAttributes(Fields, 
                        property, true, 
                        true);
  }
  protected void PushPropertyAttributes(final std.vector<Constant /*P*/ > /*&*/ Fields, 
                        ObjCPropertyDecl /*P*/ property, boolean isSynthesized/*= true*/) {
    PushPropertyAttributes(Fields, 
                        property, isSynthesized, 
                        true);
  }
  protected void PushPropertyAttributes(final std.vector<Constant /*P*/ > /*&*/ Fields, 
                        ObjCPropertyDecl /*P*/ property, boolean isSynthesized/*= true*/, 
                        boolean isDynamic/*= true*/) {
    int attrs = property.getPropertyAttributes();
    // For read-only properties, clear the copy and retain flags
    if (((attrs & ObjCPropertyDecl.PropertyAttributeKind.OBJC_PR_readonly) != 0)) {
      attrs &= ~ObjCPropertyDecl.PropertyAttributeKind.OBJC_PR_copy;
      attrs &= ~ObjCPropertyDecl.PropertyAttributeKind.OBJC_PR_retain;
      attrs &= ~ObjCPropertyDecl.PropertyAttributeKind.OBJC_PR_weak;
      attrs &= ~ObjCPropertyDecl.PropertyAttributeKind.OBJC_PR_strong;
    }
    // The first flags field has the same attribute values as clang uses internally
    Fields.push_back_T$RR(ConstantInt.get(Int8Ty, $int2ulong(attrs & 0xff)));
    attrs >>= 8;
    attrs <<= 2;
    // For protocol properties, synthesized and dynamic have no meaning, so we
    // reuse these flags to indicate that this is a protocol property (both set
    // has no meaning, as a property can't be both synthesized and dynamic)
    attrs |= isSynthesized ? (1 << 0) : 0;
    attrs |= isDynamic ? (1 << 1) : 0;
    // The second field is the next four fields left shifted by two, with the
    // low bit set to indicate whether the field is synthesized or dynamic.
    Fields.push_back_T$RR(ConstantInt.get(Int8Ty, $int2ulong(attrs & 0xff)));
    // Two padding fields
    Fields.push_back_T$RR(ConstantInt.get(Int8Ty, $int2ulong(0)));
    Fields.push_back_T$RR(ConstantInt.get(Int8Ty, $int2ulong(0)));
  }

  
  /// Ensures that the value has the required type, by inserting a bitcast if
  /// required.  This function lets us avoid inserting bitcasts that are
  /// redundant.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGObjCGNU::EnforceType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCGNU.cpp", line = 285,
   FQN="(anonymous namespace)::CGObjCGNU::EnforceType", NM="_ZN12_GLOBAL__N_19CGObjCGNU11EnforceTypeERN5clang7CodeGen11CGBuilderTyEPN4llvm5ValueEPNS5_4TypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCGNU.cpp -nm=_ZN12_GLOBAL__N_19CGObjCGNU11EnforceTypeERN5clang7CodeGen11CGBuilderTyEPN4llvm5ValueEPNS5_4TypeE")
  //</editor-fold>
  protected Value /*P*/ EnforceType(final CGBuilderTy /*&*/ B, Value /*P*/ V, org.llvm.ir.Type /*P*/ Ty) {
    if (V.getType() == Ty) {
      return V;
    }
    return B.CreateBitCast(V, Ty);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGObjCGNU::EnforceType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCGNU.cpp", line = 289,
   FQN="(anonymous namespace)::CGObjCGNU::EnforceType", NM="_ZN12_GLOBAL__N_19CGObjCGNU11EnforceTypeERN5clang7CodeGen11CGBuilderTyENS2_7AddressEPN4llvm4TypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCGNU.cpp -nm=_ZN12_GLOBAL__N_19CGObjCGNU11EnforceTypeERN5clang7CodeGen11CGBuilderTyENS2_7AddressEPN4llvm4TypeE")
  //</editor-fold>
  protected Address EnforceType(final CGBuilderTy /*&*/ B, Address V, org.llvm.ir.Type /*P*/ Ty) {
    if (V.getType() == Ty) {
      return new Address(JD$Move.INSTANCE, V);
    }
    return B.CreateBitCast(new Address(V), Ty);
  }

  
  // Some zeros used for GEPs in lots of places.
  protected Constant /*P*/ Zeros[/*2*/] = new Constant /*P*/  [2];
  /// Null pointer value.  Mainly used as a terminator in various arrays.
  protected Constant /*P*/ NULLPtr;
  /// LLVM context.
  protected final LLVMContext /*&*/ VMContext;
/*private:*/
  /// Placeholder for the class.  Lots of things refer to the class before we've
  /// actually emitted it.  We use this alias as a placeholder, and then replace
  /// it with a pointer to the class structure before finally emitting the
  /// module.
  private GlobalAlias /*P*/ ClassPtrAlias;
  /// Placeholder for the metaclass.  Lots of things refer to the class before
  /// we've / actually emitted it.  We use this alias as a placeholder, and then
  /// replace / it with a pointer to the metaclass structure before finally
  /// emitting the / module.
  private GlobalAlias /*P*/ MetaClassPtrAlias;
  /// All of the classes that have been generated for this compilation units.
  private std.vector<Constant /*P*/ > Classes;
  /// All of the categories that have been generated for this compilation units.
  private std.vector<Constant /*P*/ > Categories;
  /// All of the Objective-C constant strings that have been generated for this
  /// compilation units.
  private std.vector<Constant /*P*/ > ConstantStrings;
  /// Map from string values to Objective-C constant strings in the output.
  /// Used to prevent emitting Objective-C strings more than once.  This should
  /// not be required at all - CodeGenModule should manage this list.
  private StringMap<Constant /*P*/ > ObjCStrings;
  /// All of the protocols that have been declared.
  private StringMap<Constant /*P*/ > ExistingProtocols;
  /// For each variant of a selector, we store the type encoding and a
  /// placeholder value.  For an untyped selector, the type will be the empty
  /// string.  Selector references are all done via the module's selector table,
  /// so we create an alias as a placeholder and then replace it with the real
  /// value later.
  // JAVA: typedef std::pair<std::string, llvm::GlobalAlias *> TypedSelector
//  public final class TypedSelector extends std.pairTypePtr<std.string, GlobalAlias /*P*/ >{ };
  /// Type of the selector map.  This is roughly equivalent to the structure
  /// used in the GNUstep runtime, which maintains a list of all of the valid
  /// types for a selector in a table.
  // JAVA: typedef llvm::DenseMap<Selector, SmallVector<TypedSelector, 2> > SelectorMap
//  public final class SelectorMap extends DenseMap<Selector, SmallVector<std.pairTypePtr<std.string, GlobalAlias /*P*/ >>>{ };
  /// A map from selectors to selector types.  This allows us to emit all
  /// selectors of the same name and type together.
  private DenseMap<Selector, SmallVector<std.pairTypePtr<std.string, GlobalAlias /*P*/ >>> SelectorTable;
  
  /// Selectors related to memory management.  When compiling in GC mode, we
  /// omit these.
  private Selector RetainSel;
  private Selector ReleaseSel;
  private Selector AutoreleaseSel;
  /// Runtime functions used for memory management in GC mode.  Note that clang
  /// supports code generation for calling these functions, but neither GNU
  /// runtime actually supports this API properly yet.
  private LazyRuntimeFunction IvarAssignFn;
  private LazyRuntimeFunction StrongCastAssignFn;
  private LazyRuntimeFunction MemMoveFn;
  private LazyRuntimeFunction WeakReadFn;
  private LazyRuntimeFunction WeakAssignFn;
  private LazyRuntimeFunction GlobalAssignFn;
  
  // JAVA: typedef std::pair<std::string, std::string> ClassAliasPair
//  public final class ClassAliasPair extends std.pairTypeType<std.string, std.string>{ };
  /// All classes that have aliases set for them.
  private std.vector<std.pairTypeType<std.string, std.string>> ClassAliases;
/*protected:*/
  /// Function used for throwing Objective-C exceptions.
  protected LazyRuntimeFunction ExceptionThrowFn;
  /// Function used for rethrowing exceptions, used at the end of \@finally or
  /// \@synchronize blocks.
  protected LazyRuntimeFunction ExceptionReThrowFn;
  /// Function called when entering a catch function.  This is required for
  /// differentiating Objective-C exceptions and foreign exceptions.
  protected LazyRuntimeFunction EnterCatchFn;
  /// Function called when exiting from a catch block.  Used to do exception
  /// cleanup.
  protected LazyRuntimeFunction ExitCatchFn;
  /// Function called when entering an \@synchronize block.  Acquires the lock.
  protected LazyRuntimeFunction SyncEnterFn;
  /// Function called when exiting an \@synchronize block.  Releases the lock.
  protected LazyRuntimeFunction SyncExitFn;
/*private:*/
  /// Function called if fast enumeration detects that the collection is
  /// modified during the update.
  private LazyRuntimeFunction EnumerationMutationFn;
  /// Function for implementing synthesized property getters that return an
  /// object.
  private LazyRuntimeFunction GetPropertyFn;
  /// Function for implementing synthesized property setters that return an
  /// object.
  private LazyRuntimeFunction SetPropertyFn;
  /// Function used for non-object declared property getters.
  private LazyRuntimeFunction GetStructPropertyFn;
  /// Function used for non-object declared property setters.
  private LazyRuntimeFunction SetStructPropertyFn;
  
  /// The version of the runtime that this class targets.  Must match the
  /// version in the runtime.
  private int RuntimeVersion;
  /// The version of the protocol class.  Used to differentiate between ObjC1
  /// and ObjC2 protocols.  Objective-C 1 protocols can not contain optional
  /// components and can not contain declared properties.  We always emit
  /// Objective-C 2 property structures, but we have to pretend that they're
  /// Objective-C 1 property structures when targeting the GCC runtime or it
  /// will abort.
  private /*const*/int ProtocolVersion;
  
  /// Generates an instance variable list structure.  This is a structure
  /// containing a size and an array of structures containing instance variable
  /// metadata.  This is used purely for introspection in the fragile ABI.  In
  /// the non-fragile ABI, it's used for instance variable fixup.
  
  /// Generates an IvarList.  Used in construction of a objc_class.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGObjCGNU::GenerateIvarList">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCGNU.cpp", line = 1600,
   FQN="(anonymous namespace)::CGObjCGNU::GenerateIvarList", NM="_ZN12_GLOBAL__N_19CGObjCGNU16GenerateIvarListEN4llvm8ArrayRefIPNS1_8ConstantEEES5_S5_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCGNU.cpp -nm=_ZN12_GLOBAL__N_19CGObjCGNU16GenerateIvarListEN4llvm8ArrayRefIPNS1_8ConstantEEES5_S5_")
  //</editor-fold>
  private Constant /*P*/ GenerateIvarList(ArrayRef<Constant /*P*/ > IvarNames, 
                  ArrayRef<Constant /*P*/ > IvarTypes, 
                  ArrayRef<Constant /*P*/ > IvarOffsets) {
    std.vector<Constant /*P*/ > Ivars = null;
    try {
      if (IvarNames.size() == 0) {
        return NULLPtr;
      }
      // Get the method structure type.
      StructType /*P*/ ObjCIvarTy = StructType.get(PtrToInt8Ty, 
          PtrToInt8Ty, 
          IntTy, 
          null);
      Ivars/*J*/= new std.vector<Constant /*P*/ >((Constant /*P*/ )null);
      for (/*uint*/int i = 0, e = IvarNames.size(); $less_uint(i, e); i++) {
        Ivars.push_back_T$RR(ConstantStruct.get(ObjCIvarTy, /*{ */new ArrayRef<Constant /*P*/ >(new Constant /*P*/ /*const*/ [/*3*/] {IvarNames.$at(i), IvarTypes.$at(i), IvarOffsets.$at(i)}, true)/* }*/));
      }
      
      // Array of method structures
      org.llvm.ir.ArrayType /*P*/ ObjCIvarArrayTy = org.llvm.ir.ArrayType.get(ObjCIvarTy, 
          $uint2ulong(IvarNames.size()));
      
      Constant /*P*/ Elements[/*2*/] = new Constant /*P*/  [/*2*/] {
        ConstantInt.get(IntTy, $int2ulong((int)IvarNames.size())), 
        ConstantArray.get(ObjCIvarArrayTy, new ArrayRef<Constant /*P*/ >(Ivars, true))};
      // Structure containing array and array count
      StructType /*P*/ ObjCIvarListTy = StructType.get(IntTy, 
          ObjCIvarArrayTy, 
          null);
      
      // Create an instance of the structure
      return MakeGlobal_StructType$P_ArrayRef$Constant$P_CharUnits_StringRef_LinkageTypes(ObjCIvarListTy, new ArrayRef<Constant /*P*/ >(Elements, true), CGM.getPointerAlign(), 
          new StringRef(/*KEEP_STR*/".objc_ivar_list"));
    } finally {
      if (Ivars != null) { Ivars.$destroy(); }
    }
  }

  
  /// Generates a method list structure.  This is a structure containing a size
  /// and an array of structures containing method metadata.
  ///
  /// This structure is used by both classes and categories, and contains a next
  /// pointer allowing them to be chained together in a linked list.
  
  /// Generates a MethodList.  Used in construction of a objc_class and
  /// objc_category structures.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGObjCGNU::GenerateMethodList">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCGNU.cpp", line = 1545,
   FQN="(anonymous namespace)::CGObjCGNU::GenerateMethodList", NM="_ZN12_GLOBAL__N_19CGObjCGNU18GenerateMethodListEN4llvm9StringRefES2_NS1_8ArrayRefIN5clang8SelectorEEENS3_IPNS1_8ConstantEEEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCGNU.cpp -nm=_ZN12_GLOBAL__N_19CGObjCGNU18GenerateMethodListEN4llvm9StringRefES2_NS1_8ArrayRefIN5clang8SelectorEEENS3_IPNS1_8ConstantEEEb")
  //</editor-fold>
  private Constant /*P*/ GenerateMethodList(StringRef ClassName, 
                    StringRef CategoryName, 
                    ArrayRef<Selector> MethodSels, 
                    ArrayRef<Constant /*P*/ > MethodTypes, 
                    boolean isClassMethodList) {
    std.vector<Constant /*P*/ > Methods = null;
    try {
      if (MethodSels.empty()) {
        return NULLPtr;
      }
      // Get the method structure type.
      StructType /*P*/ ObjCMethodTy = StructType.get(PtrToInt8Ty,  // Really a selector, but the runtime creates it us.
          PtrToInt8Ty,  // Method types
          IMPTy,  //Method pointer
          null);
      Methods/*J*/= new std.vector<Constant /*P*/ >((Constant /*P*/ )null);
      for (/*uint*/int i = 0, e = MethodTypes.size(); $less_uint(i, e); ++i) {
        Constant /*P*/ Method = TheModule.getFunction(new StringRef(SymbolNameForMethod(new StringRef(ClassName), new StringRef(CategoryName), 
                    new Selector(MethodSels.$at(i)), 
                    isClassMethodList)));
        assert ((Method != null)) : "Can't generate metadata for method that doesn't exist";
        Constant /*P*/ C = MakeConstantString(MethodSels.$at(i).getAsString());
        Method = ConstantExpr.getBitCast(Method, 
            IMPTy);
        Methods.push_back_T$RR(ConstantStruct.get(ObjCMethodTy, /*{ */new ArrayRef<Constant /*P*/ >(new Constant /*P*/ /*const*/ [/*3*/] {C, MethodTypes.$at(i), Method}, true)/* }*/));
      }
      
      // Array of method structures
      org.llvm.ir.ArrayType /*P*/ ObjCMethodArrayTy = org.llvm.ir.ArrayType.get(ObjCMethodTy, 
          $uint2ulong(Methods.size()));
      Constant /*P*/ MethodArray = ConstantArray.get(ObjCMethodArrayTy, 
          new ArrayRef<Constant /*P*/ >(Methods, true));
      
      // Structure containing list pointer, array and array count
      StructType /*P*/ ObjCMethodListTy = StructType.create(VMContext);
      org.llvm.ir.Type /*P*/ NextPtrTy = org.llvm.ir.PointerType.getUnqual(ObjCMethodListTy);
      ObjCMethodListTy.setBody(NextPtrTy, 
          IntTy, 
          ObjCMethodArrayTy, 
          null);
      
      Methods.clear();
      Methods.push_back_T$RR(ConstantPointerNull.get(org.llvm.ir.PointerType.getUnqual(ObjCMethodListTy)));
      Methods.push_back_T$RR(ConstantInt.get(Int32Ty, $uint2ulong(MethodTypes.size())));
      Methods.push_back_T$C$R(MethodArray);
      
      // Create an instance of the structure
      return MakeGlobal_StructType$P_ArrayRef$Constant$P_CharUnits_StringRef_LinkageTypes(ObjCMethodListTy, new ArrayRef<Constant /*P*/ >(Methods, true), CGM.getPointerAlign(), 
          new StringRef(/*KEEP_STR*/".objc_method_list"));
    } finally {
      if (Methods != null) { Methods.$destroy(); }
    }
  }

  
  /// Emits an empty protocol.  This is used for \@protocol() where no protocol
  /// is found.  The runtime will (hopefully) fix up the pointer to refer to the
  /// real protocol.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGObjCGNU::GenerateEmptyProtocol">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCGNU.cpp", line = 1795,
   FQN="(anonymous namespace)::CGObjCGNU::GenerateEmptyProtocol", NM="_ZN12_GLOBAL__N_19CGObjCGNU21GenerateEmptyProtocolERKSs",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCGNU.cpp -nm=_ZN12_GLOBAL__N_19CGObjCGNU21GenerateEmptyProtocolERKSs")
  //</editor-fold>
  private Constant /*P*/ GenerateEmptyProtocol(final /*const*/std.string/*&*/ ProtocolName) {
    SmallVector<std.string> EmptyStringVector/*J*/= new SmallVector<std.string>(0, new std.string());
    SmallVector<Constant /*P*/ > EmptyConstantVector/*J*/= new SmallVector<Constant /*P*/ >(0, (Constant /*P*/ )null);
    
    Constant /*P*/ ProtocolList = GenerateProtocolList(new ArrayRef<std.string>(EmptyStringVector, false));
    Constant /*P*/ MethodList = GenerateProtocolMethodList(new ArrayRef<Constant /*P*/ >(EmptyConstantVector, true), new ArrayRef<Constant /*P*/ >(EmptyConstantVector, true));
    // Protocols are objects containing lists of the methods implemented and
    // protocols adopted.
    StructType /*P*/ ProtocolTy = StructType.get(IdTy, 
        PtrToInt8Ty, 
        ProtocolList.getType(), 
        MethodList.getType(), 
        MethodList.getType(), 
        MethodList.getType(), 
        MethodList.getType(), 
        null);
    // The isa pointer must be set to a magic number so the runtime knows it's
    // the correct layout.
    Constant /*P*/ Elements[/*7*/] = new Constant /*P*/  [/*7*/] {
      ConstantExpr.getIntToPtr(ConstantInt.get(Int32Ty, $int2ulong(ProtocolVersion)), IdTy), 
      MakeConstantString(ProtocolName, new std.string(JD$T$C$P_T2$C$R.INSTANCE, /*KEEP_STR*/".objc_protocol_name")), ProtocolList, 
      MethodList, MethodList, MethodList, MethodList};
    return MakeGlobal_StructType$P_ArrayRef$Constant$P_CharUnits_StringRef_LinkageTypes(ProtocolTy, new ArrayRef<Constant /*P*/ >(Elements, true), CGM.getPointerAlign(), 
        new StringRef(/*KEEP_STR*/".objc_protocol"));
  }

  
  /// Generates a list of property metadata structures.  This follows the same
  /// pattern as method and instance variable metadata lists.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGObjCGNU::GeneratePropertyList">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCGNU.cpp", line = 2120,
   FQN="(anonymous namespace)::CGObjCGNU::GeneratePropertyList", NM="_ZN12_GLOBAL__N_19CGObjCGNU20GeneratePropertyListEPKN5clang22ObjCImplementationDeclERN4llvm15SmallVectorImplINS1_8SelectorEEERNS6_IPNS5_8ConstantEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCGNU.cpp -nm=_ZN12_GLOBAL__N_19CGObjCGNU20GeneratePropertyListEPKN5clang22ObjCImplementationDeclERN4llvm15SmallVectorImplINS1_8SelectorEEERNS6_IPNS5_8ConstantEEE")
  //</editor-fold>
  private Constant /*P*/ GeneratePropertyList(/*const*/ ObjCImplementationDecl /*P*/ OID, 
                      final SmallVectorImpl<Selector> /*&*/ InstanceMethodSels, 
                      final SmallVectorImpl<Constant /*P*/ > /*&*/ InstanceMethodTypes) {
    std.vector<Constant /*P*/ > Properties = null;
    try {
      final ASTContext /*&*/ Context = CGM.getContext();
      // Property metadata: name, attributes, attributes2, padding1, padding2,
      // setter name, setter types, getter name, getter types.
      StructType /*P*/ PropertyMetadataTy = StructType.get(PtrToInt8Ty, Int8Ty, Int8Ty, Int8Ty, Int8Ty, PtrToInt8Ty, 
          PtrToInt8Ty, PtrToInt8Ty, PtrToInt8Ty, null);
      Properties/*J*/= new std.vector<Constant /*P*/ >((Constant /*P*/ )null);
      
      // Add all of the property methods need adding to the method list and to the
      // property metadata list.
      for (ObjCPropertyImplDecl /*P*/ propertyImpl : OID.property_impls()) {
        std.vector<Constant /*P*/ > Fields = null;
        try {
          Fields/*J*/= new std.vector<Constant /*P*/ >((Constant /*P*/ )null);
          ObjCPropertyDecl /*P*/ property = propertyImpl.getPropertyDecl();
          boolean isSynthesized = (propertyImpl.getPropertyImplementation()
             == ObjCPropertyImplDecl.Kind.Synthesize);
          boolean isDynamic = (propertyImpl.getPropertyImplementation()
             == ObjCPropertyImplDecl.Kind.Dynamic);
          
          Fields.push_back_T$RR(MakePropertyEncodingString(property, OID));
          PushPropertyAttributes(Fields, property, isSynthesized, isDynamic);
          {
            ObjCMethodDecl /*P*/ getter = property.getGetterMethodDecl();
            if ((getter != null)) {
              std.string TypeStr/*J*/= new std.string();
              Context.getObjCEncodingForMethodDecl(getter, TypeStr);
              Constant /*P*/ TypeEncoding = MakeConstantString(TypeStr);
              if (isSynthesized) {
                InstanceMethodTypes.push_back(TypeEncoding);
                InstanceMethodSels.push_back(getter.getSelector());
              }
              Fields.push_back_T$RR(MakeConstantString(getter.getSelector().getAsString()));
              Fields.push_back_T$C$R(TypeEncoding);
            } else {
              Fields.push_back_T$C$R(NULLPtr);
              Fields.push_back_T$C$R(NULLPtr);
            }
          }
          {
            ObjCMethodDecl /*P*/ setter = property.getSetterMethodDecl();
            if ((setter != null)) {
              std.string TypeStr/*J*/= new std.string();
              Context.getObjCEncodingForMethodDecl(setter, TypeStr);
              Constant /*P*/ TypeEncoding = MakeConstantString(TypeStr);
              if (isSynthesized) {
                InstanceMethodTypes.push_back(TypeEncoding);
                InstanceMethodSels.push_back(setter.getSelector());
              }
              Fields.push_back_T$RR(MakeConstantString(setter.getSelector().getAsString()));
              Fields.push_back_T$C$R(TypeEncoding);
            } else {
              Fields.push_back_T$C$R(NULLPtr);
              Fields.push_back_T$C$R(NULLPtr);
            }
          }
          Properties.push_back_T$RR(ConstantStruct.get(PropertyMetadataTy, new ArrayRef<Constant /*P*/ >(Fields, true)));
        } finally {
          if (Fields != null) { Fields.$destroy(); }
        }
      }
      org.llvm.ir.ArrayType /*P*/ PropertyArrayTy = org.llvm.ir.ArrayType.get(PropertyMetadataTy, $uint2ulong(Properties.size()));
      Constant /*P*/ PropertyArray = ConstantArray.get(PropertyArrayTy, 
          new ArrayRef<Constant /*P*/ >(Properties, true));
      Constant /*P*/ PropertyListInitFields[/*3*/] = new Constant /*P*/  [/*3*/] {ConstantInt.get(IntTy, $uint2ulong(Properties.size())), NULLPtr, PropertyArray};
      
      Constant /*P*/ PropertyListInit = ConstantStruct.getAnon(new ArrayRef<Constant /*P*/ >(PropertyListInitFields, true));
      return /*NEW_EXPR [GlobalVariable::new]*/GlobalVariable.$new_GlobalVariable((type$ptr<?> New$Mem)->{
      return new GlobalVariable(TheModule, PropertyListInit.getType(), false, 
          GlobalValue.LinkageTypes.InternalLinkage, PropertyListInit, 
          new Twine(/*KEEP_STR*/".objc_property_list"));
       });
    } finally {
      if (Properties != null) { Properties.$destroy(); }
    }
  }

  
  /// Generates a list of referenced protocols.  Classes, categories, and
  /// protocols all use this structure.
  
  // Create the protocol list structure used in classes, categories and so on
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGObjCGNU::GenerateProtocolList">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCGNU.cpp", line = 1754,
   FQN="(anonymous namespace)::CGObjCGNU::GenerateProtocolList", NM="_ZN12_GLOBAL__N_19CGObjCGNU20GenerateProtocolListEN4llvm8ArrayRefISsEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCGNU.cpp -nm=_ZN12_GLOBAL__N_19CGObjCGNU20GenerateProtocolListEN4llvm8ArrayRefISsEE")
  //</editor-fold>
  private Constant /*P*/ GenerateProtocolList(ArrayRef<std.string> Protocols) {
    std.vector<Constant /*P*/ > Elements = null;
    try {
      org.llvm.ir.ArrayType /*P*/ ProtocolArrayTy = org.llvm.ir.ArrayType.get(PtrToInt8Ty, 
          $uint2ulong(Protocols.size()));
      StructType /*P*/ ProtocolListTy = StructType.get(PtrTy,  //Should be a recurisve pointer, but it's always NULL here.
          SizeTy, 
          ProtocolArrayTy, 
          null);
      Elements/*J*/= new std.vector<Constant /*P*/ >((Constant /*P*/ )null);
      for (type$ptr<string> iter = $tryClone(Protocols.begin()), /*P*/ endIter = $tryClone(Protocols.end());
           Native.$noteq_ptr(iter, endIter); iter.$postInc()) {
        Constant /*P*/ protocol = null;
        StringMapIterator<Constant /*P*/ > value = ExistingProtocols.find(new StringRef($Deref(iter)));
        if (value.$eq(ExistingProtocols.end())) {
          protocol = GenerateEmptyProtocol($Deref(iter));
        } else {
          protocol = value.$arrow().getValue();
        }
        Constant /*P*/ Ptr = ConstantExpr.getBitCast(protocol, 
            PtrToInt8Ty);
        Elements.push_back_T$C$R(Ptr);
      }
      Constant /*P*/ ProtocolArray = ConstantArray.get(ProtocolArrayTy, 
          new ArrayRef<Constant /*P*/ >(Elements, true));
      Elements.clear();
      Elements.push_back_T$C$R(NULLPtr);
      Elements.push_back_T$RR(ConstantInt.get(LongTy, $uint2ulong(Protocols.size())));
      Elements.push_back_T$C$R(ProtocolArray);
      return MakeGlobal_StructType$P_ArrayRef$Constant$P_CharUnits_StringRef_LinkageTypes(ProtocolListTy, new ArrayRef<Constant /*P*/ >(Elements, true), CGM.getPointerAlign(), 
          new StringRef(/*KEEP_STR*/".objc_protocol_list"));
    } finally {
      if (Elements != null) { Elements.$destroy(); }
    }
  }

  
  /// To ensure that all protocols are seen by the runtime, we add a category on
  /// a class defined in the runtime, declaring no methods, but adopting the
  /// protocols.  This is a horribly ugly hack, but it allows us to collect all
  /// of the protocols without changing the ABI.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGObjCGNU::GenerateProtocolHolderCategory">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCGNU.cpp", line = 1979,
   FQN="(anonymous namespace)::CGObjCGNU::GenerateProtocolHolderCategory", NM="_ZN12_GLOBAL__N_19CGObjCGNU30GenerateProtocolHolderCategoryEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCGNU.cpp -nm=_ZN12_GLOBAL__N_19CGObjCGNU30GenerateProtocolHolderCategoryEv")
  //</editor-fold>
  private void GenerateProtocolHolderCategory() {
    std.vector<Constant /*P*/ > Elements = null;
    std.vector<Constant /*P*/ > ProtocolElements = null;
    try {
      // Collect information about instance methods
      SmallVector<Selector> MethodSels/*J*/= new SmallVector<Selector>(1, new Selector());
      SmallVector<Constant /*P*/ > MethodTypes/*J*/= new SmallVector<Constant /*P*/ >(1, (Constant /*P*/ )null);
      
      Elements/*J*/= new std.vector<Constant /*P*/ >((Constant /*P*/ )null);
      /*const*/std.string ClassName = new std.string(JD$T$C$P_T2$C$R.INSTANCE, /*KEEP_STR*/"__ObjC_Protocol_Holder_Ugly_Hack");
      /*const*/std.string CategoryName = new std.string(JD$T$C$P_T2$C$R.INSTANCE, /*KEEP_STR*/"AnotherHack");
      Elements.push_back_T$RR(MakeConstantString(CategoryName));
      Elements.push_back_T$RR(MakeConstantString(ClassName));
      // Instance method list
      Elements.push_back_T$RR(ConstantExpr.getBitCast(GenerateMethodList(new StringRef(ClassName), new StringRef(CategoryName), new ArrayRef<Selector>(MethodSels, false), new ArrayRef<Constant /*P*/ >(MethodTypes, true), false), PtrTy));
      // Class method list
      Elements.push_back_T$RR(ConstantExpr.getBitCast(GenerateMethodList(new StringRef(ClassName), new StringRef(CategoryName), new ArrayRef<Selector>(MethodSels, false), new ArrayRef<Constant /*P*/ >(MethodTypes, true), true), PtrTy));
      // Protocol list
      org.llvm.ir.ArrayType /*P*/ ProtocolArrayTy = org.llvm.ir.ArrayType.get(PtrTy, 
          $uint2ulong(ExistingProtocols.size()));
      StructType /*P*/ ProtocolListTy = StructType.get(PtrTy,  //Should be a recurisve pointer, but it's always NULL here.
          SizeTy, 
          ProtocolArrayTy, 
          null);
      ProtocolElements/*J*/= new std.vector<Constant /*P*/ >((Constant /*P*/ )null);
      for (StringMapIterator<Constant /*P*/ > iter = ExistingProtocols.begin(), endIter = ExistingProtocols.end();
           iter.$noteq(endIter); iter.$postInc(0)) {
        Constant /*P*/ Ptr = ConstantExpr.getBitCast(iter.$arrow().getValue(), 
            PtrTy);
        ProtocolElements.push_back_T$C$R(Ptr);
      }
      Constant /*P*/ ProtocolArray = ConstantArray.get(ProtocolArrayTy, 
          new ArrayRef<Constant /*P*/ >(ProtocolElements, true));
      ProtocolElements.clear();
      ProtocolElements.push_back_T$C$R(NULLPtr);
      ProtocolElements.push_back_T$RR(ConstantInt.get(LongTy, 
              $uint2ulong(ExistingProtocols.size())));
      ProtocolElements.push_back_T$C$R(ProtocolArray);
      Elements.push_back_T$RR(ConstantExpr.getBitCast(MakeGlobal_StructType$P_ArrayRef$Constant$P_CharUnits_StringRef_LinkageTypes(ProtocolListTy, 
                  new ArrayRef<Constant /*P*/ >(ProtocolElements, true), CGM.getPointerAlign(), 
                  new StringRef(/*KEEP_STR*/".objc_protocol_list")), PtrTy));
      Categories.push_back_T$RR(ConstantExpr.getBitCast(MakeGlobal_StructType$P_ArrayRef$Constant$P_CharUnits_StringRef_LinkageTypes(StructType.get(PtrToInt8Ty, PtrToInt8Ty, 
                      PtrTy, PtrTy, PtrTy, null), new ArrayRef<Constant /*P*/ >(Elements, true), CGM.getPointerAlign()), 
              PtrTy));
    } finally {
      if (ProtocolElements != null) { ProtocolElements.$destroy(); }
      if (Elements != null) { Elements.$destroy(); }
    }
  }

  
  /// Generates a class structure.
  
  /// Generate a class structure
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGObjCGNU::GenerateClassStructure">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCGNU.cpp", line = 1636,
   FQN="(anonymous namespace)::CGObjCGNU::GenerateClassStructure", NM="_ZN12_GLOBAL__N_19CGObjCGNU22GenerateClassStructureEPN4llvm8ConstantES3_jPKcS3_S3_S3_S3_S3_S3_S3_S3_S3_b",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCGNU.cpp -nm=_ZN12_GLOBAL__N_19CGObjCGNU22GenerateClassStructureEPN4llvm8ConstantES3_jPKcS3_S3_S3_S3_S3_S3_S3_S3_S3_b")
  //</editor-fold>
  private Constant /*P*/ GenerateClassStructure(Constant /*P*/ MetaClass, 
                        Constant /*P*/ SuperClass, 
                        /*uint*/int info, 
                        /*const*/char$ptr/*char P*/ Name, 
                        Constant /*P*/ Version, 
                        Constant /*P*/ InstanceSize, 
                        Constant /*P*/ IVars, 
                        Constant /*P*/ Methods, 
                        Constant /*P*/ Protocols, 
                        Constant /*P*/ IvarOffsets, 
                        Constant /*P*/ Properties, 
                        Constant /*P*/ StrongIvarBitmap, 
                        Constant /*P*/ WeakIvarBitmap) {
    return GenerateClassStructure(MetaClass, 
                        SuperClass, 
                        info, 
                        Name, 
                        Version, 
                        InstanceSize, 
                        IVars, 
                        Methods, 
                        Protocols, 
                        IvarOffsets, 
                        Properties, 
                        StrongIvarBitmap, 
                        WeakIvarBitmap, 
                        false);
  }
  private Constant /*P*/ GenerateClassStructure(Constant /*P*/ MetaClass, 
                        Constant /*P*/ SuperClass, 
                        /*uint*/int info, 
                        /*const*/char$ptr/*char P*/ Name, 
                        Constant /*P*/ Version, 
                        Constant /*P*/ InstanceSize, 
                        Constant /*P*/ IVars, 
                        Constant /*P*/ Methods, 
                        Constant /*P*/ Protocols, 
                        Constant /*P*/ IvarOffsets, 
                        Constant /*P*/ Properties, 
                        Constant /*P*/ StrongIvarBitmap, 
                        Constant /*P*/ WeakIvarBitmap, 
                        boolean isMeta/*= false*/) {
    std.vector<Constant /*P*/ > Elements = null;
    try {
      // Set up the class structure
      // Note:  Several of these are char*s when they should be ids.  This is
      // because the runtime performs this translation on load.
      //
      // Fields marked New ABI are part of the GNUstep runtime.  We emit them
      // anyway; the classes will still work with the GNU runtime, they will just
      // be ignored.
      StructType /*P*/ ClassTy = StructType.get(PtrToInt8Ty,  // isa 
          PtrToInt8Ty,  // super_class
          PtrToInt8Ty,  // name
          LongTy,  // version
          LongTy,  // info
          LongTy,  // instance_size
          IVars.getType(),  // ivars
          Methods.getType(),  // methods
          // These are all filled in by the runtime, so we pretend
          PtrTy,  // dtable
          PtrTy,  // subclass_list
          PtrTy,  // sibling_class
          PtrTy,  // protocols
          PtrTy,  // gc_object_type
          // New ABI:
          LongTy,  // abi_version
          IvarOffsets.getType(),  // ivar_offsets
          Properties.getType(),  // properties
          IntPtrTy,  // strong_pointers
          IntPtrTy,  // weak_pointers
          null);
      Constant /*P*/ Zero = ConstantInt.get(LongTy, $int2ulong(0));
      // Fill in the structure
      Elements/*J*/= new std.vector<Constant /*P*/ >((Constant /*P*/ )null);
      Elements.push_back_T$RR(ConstantExpr.getBitCast(MetaClass, PtrToInt8Ty));
      Elements.push_back_T$C$R(SuperClass);
      Elements.push_back_T$RR(MakeConstantString(new std.string(JD$T$C$P_T2$C$R.INSTANCE, Name), new std.string(JD$T$C$P_T2$C$R.INSTANCE, /*KEEP_STR*/".class_name")));
      Elements.push_back_T$C$R(Zero);
      Elements.push_back_T$RR(ConstantInt.get(LongTy, $uint2ulong(info)));
      if (isMeta) {
        DataLayout td = null;
        try {
          td/*J*/= new DataLayout($AddrOf(TheModule));
          Elements.push_back_T$RR(ConstantInt.get(LongTy, 
                  $div_ulong(td.getTypeSizeInBits(ClassTy)
                    , CGM.getContext().getCharWidth())));
        } finally {
          if (td != null) { td.$destroy(); }
        }
      } else {
        Elements.push_back_T$C$R(InstanceSize);
      }
      Elements.push_back_T$C$R(IVars);
      Elements.push_back_T$C$R(Methods);
      Elements.push_back_T$C$R(NULLPtr);
      Elements.push_back_T$C$R(NULLPtr);
      Elements.push_back_T$C$R(NULLPtr);
      Elements.push_back_T$RR(ConstantExpr.getBitCast(Protocols, PtrTy));
      Elements.push_back_T$C$R(NULLPtr);
      Elements.push_back_T$RR(ConstantInt.get(LongTy, $int2ulong(1)));
      Elements.push_back_T$C$R(IvarOffsets);
      Elements.push_back_T$C$R(Properties);
      Elements.push_back_T$C$R(StrongIvarBitmap);
      Elements.push_back_T$C$R(WeakIvarBitmap);
      // Create an instance of the structure
      // This is now an externally visible symbol, so that we can speed up class
      // messages in the next ABI.  We may already have some weak references to
      // this, so check and fix them properly.
      std.string ClassSym/*J*/= $add_T$C$P_string((isMeta ? $("_OBJC_METACLASS_") : $("_OBJC_CLASS_")), 
          new std.string(JD$T$C$P_T2$C$R.INSTANCE, Name));
      GlobalVariable /*P*/ ClassRef = TheModule.getNamedGlobal(new StringRef(ClassSym));
      Constant /*P*/ Class = MakeGlobal_StructType$P_ArrayRef$Constant$P_CharUnits_StringRef_LinkageTypes(ClassTy, new ArrayRef<Constant /*P*/ >(Elements, true), CGM.getPointerAlign(), new StringRef(ClassSym), 
          GlobalValue.LinkageTypes.ExternalLinkage);
      if ((ClassRef != null)) {
        ClassRef.replaceAllUsesWith(ConstantExpr.getBitCast(Class, 
                ClassRef.getType()));
        ClassRef.removeFromParent();
        Class.setName(new Twine(ClassSym));
      }
      return Class;
    } finally {
      if (Elements != null) { Elements.$destroy(); }
    }
  }

  
  /// Generates a method list.  This is used by protocols to define the required
  /// and optional methods.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGObjCGNU::GenerateProtocolMethodList">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCGNU.cpp", line = 1727,
   FQN="(anonymous namespace)::CGObjCGNU::GenerateProtocolMethodList", NM="_ZN12_GLOBAL__N_19CGObjCGNU26GenerateProtocolMethodListEN4llvm8ArrayRefIPNS1_8ConstantEEES5_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCGNU.cpp -nm=_ZN12_GLOBAL__N_19CGObjCGNU26GenerateProtocolMethodListEN4llvm8ArrayRefIPNS1_8ConstantEEES5_")
  //</editor-fold>
  private Constant /*P*/ GenerateProtocolMethodList(ArrayRef<Constant /*P*/ > MethodNames, 
                            ArrayRef<Constant /*P*/ > MethodTypes) {
    std.vector<Constant /*P*/ > Methods = null;
    try {
      // Get the method structure type.
      StructType /*P*/ ObjCMethodDescTy = StructType.get(PtrToInt8Ty,  // Really a selector, but the runtime does the casting for us.
          PtrToInt8Ty, 
          null);
      Methods/*J*/= new std.vector<Constant /*P*/ >((Constant /*P*/ )null);
      for (/*uint*/int i = 0, e = MethodTypes.size(); $less_uint(i, e); i++) {
        Methods.push_back_T$RR(ConstantStruct.get(ObjCMethodDescTy, /*{ */new ArrayRef<Constant /*P*/ >(new Constant /*P*/ /*const*/ [/*2*/] {MethodNames.$at(i), MethodTypes.$at(i)}, true)/* }*/));
      }
      org.llvm.ir.ArrayType /*P*/ ObjCMethodArrayTy = org.llvm.ir.ArrayType.get(ObjCMethodDescTy, 
          $uint2ulong(MethodNames.size()));
      Constant /*P*/ Array = ConstantArray.get(ObjCMethodArrayTy, 
          new ArrayRef<Constant /*P*/ >(Methods, true));
      StructType /*P*/ ObjCMethodDescListTy = StructType.get(IntTy, ObjCMethodArrayTy, null);
      Methods.clear();
      Methods.push_back_T$RR(ConstantInt.get(IntTy, $uint2ulong(MethodNames.size())));
      Methods.push_back_T$C$R(Array);
      return MakeGlobal_StructType$P_ArrayRef$Constant$P_CharUnits_StringRef_LinkageTypes(ObjCMethodDescListTy, new ArrayRef<Constant /*P*/ >(Methods, true), CGM.getPointerAlign(), 
          new StringRef(/*KEEP_STR*/".objc_method_list"));
    } finally {
      if (Methods != null) { Methods.$destroy(); }
    }
  }

  
  /// Returns a selector with the specified type encoding.  An empty string is
  /// used to return an untyped selector (with the types field set to NULL).
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGObjCGNU::GetSelector">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCGNU.cpp", line = 1116,
   FQN="(anonymous namespace)::CGObjCGNU::GetSelector", NM="_ZN12_GLOBAL__N_19CGObjCGNU11GetSelectorERN5clang7CodeGen15CodeGenFunctionENS1_8SelectorERKSs",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCGNU.cpp -nm=_ZN12_GLOBAL__N_19CGObjCGNU11GetSelectorERN5clang7CodeGen15CodeGenFunctionENS1_8SelectorERKSs")
  //</editor-fold>
  private Value /*P*/ GetSelector(final CodeGenFunction /*&*/ CGF, Selector Sel, 
             final /*const*/std.string/*&*/ TypeEncoding) {
    final SmallVectorImpl<std.pairTypePtr<std.string, GlobalAlias /*P*/ > > /*&*/ Types = SelectorTable.$at_T1$C$R(Sel);
    GlobalAlias /*P*/ SelValue = null;
    
    for (type$ptr<std.pairTypePtr<std.string, GlobalAlias /*P*/ >> i = $tryClone(Types.begin()), 
        /*P*/ e = $tryClone(Types.end()); $noteq_ptr(i, e); i.$postInc()) {
      if ($eq_str$C(i./*->*/$star().first, TypeEncoding)) {
        SelValue = i./*->*/$star().second;
        break;
      }
    }
    if (!(SelValue != null)) {
      SelValue = GlobalAlias.create(SelectorTy.getElementType(), 0, GlobalValue.LinkageTypes.PrivateLinkage, 
          new Twine($add_T$C$P_string(/*KEEP_STR*/".objc_selector_", Sel.getAsString())), $AddrOf(TheModule));
      Types.emplace_back(new std.pairTypePtr<std.string, GlobalAlias /*P*/ >($Clone(TypeEncoding), SelValue));
    }
    
    return SelValue;
  }

  
  /// Returns the variable used to store the offset of an instance variable.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGObjCGNU::ObjCIvarOffsetVariable">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCGNU.cpp", line = 2828,
   FQN="(anonymous namespace)::CGObjCGNU::ObjCIvarOffsetVariable", NM="_ZN12_GLOBAL__N_19CGObjCGNU22ObjCIvarOffsetVariableEPKN5clang17ObjCInterfaceDeclEPKNS1_12ObjCIvarDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCGNU.cpp -nm=_ZN12_GLOBAL__N_19CGObjCGNU22ObjCIvarOffsetVariableEPKN5clang17ObjCInterfaceDeclEPKNS1_12ObjCIvarDeclE")
  //</editor-fold>
  private GlobalVariable /*P*/ ObjCIvarOffsetVariable(/*const*/ ObjCInterfaceDecl /*P*/ ID, 
                        /*const*/ ObjCIvarDecl /*P*/ Ivar) {
    /*const*/std.string Name = $add_string($add_string_T($add_T$C$P_string(/*KEEP_STR*/"__objc_ivar_offset_", ID.getNameAsString()), 
            $$DOT), Ivar.getNameAsString());
    // Emit the variable and initialize it with what we think the correct value
    // is.  This allows code compiled with non-fragile ivars to work correctly
    // when linked against code which isn't (most of the time).
    GlobalVariable /*P*/ IvarOffsetPointer = TheModule.getNamedGlobal(new StringRef(Name));
    if (!(IvarOffsetPointer != null)) {
      // This will cause a run-time crash if we accidentally use it.  A value of
      // 0 would seem more sensible, but will silently overwrite the isa pointer
      // causing a great deal of confusion.
      long/*uint64_t*/ Offset = $int2ulong(-1);
      // We can't call ComputeIvarBaseOffset() here if we have the
      // implementation, because it will create an invalid ASTRecordLayout object
      // that we are then stuck with forever, so we only initialize the ivar
      // offset variable with a guess if we only have the interface.  The
      // initializer will be reset later anyway, when we are generating the class
      // description.
      if (!(CGM.getContext().getObjCImplementation(((/*const_cast*/ObjCInterfaceDecl /*P*/ )(ID))) != null)) {
        Offset = ComputeIvarBaseOffset_1(CGM, ID, Ivar);
      }
      
      ConstantInt /*P*/ OffsetGuess = ConstantInt.get(Int32Ty, Offset, 
          /*isSigned*/ true);
      // Don't emit the guess in non-PIC code because the linker will not be able
      // to replace it with the real version for a library.  In non-PIC code you
      // must compile with the fragile ABI if you want to use ivars from a
      // GCC-compiled class.
      if (($2bits_uint2uint(CGM.getLangOpts().PICLevel) != 0)) {
        GlobalVariable /*P*/ IvarOffsetGV = /*NEW_EXPR [GlobalVariable::new]*/GlobalVariable.$new_GlobalVariable((type$ptr<?> New$Mem)->{
            return new GlobalVariable(TheModule, 
            Int32Ty, false, 
            GlobalValue.LinkageTypes.PrivateLinkage, OffsetGuess, new Twine($add_string$C_T$C$P(Name, /*KEEP_STR*/".guess")));
         });
        IvarOffsetPointer = /*NEW_EXPR [GlobalVariable::new]*/GlobalVariable.$new_GlobalVariable((type$ptr<?> New$Mem)->{
            return new GlobalVariable(TheModule, 
            IvarOffsetGV.getType(), false, GlobalValue.LinkageTypes.LinkOnceAnyLinkage, 
            IvarOffsetGV, new Twine(Name));
         });
      } else {
        IvarOffsetPointer = /*NEW_EXPR [GlobalVariable::new]*/GlobalVariable.$new_GlobalVariable((type$ptr<?> New$Mem)->{
            return new GlobalVariable(TheModule, 
            org.llvm.ir.Type.getInt32PtrTy(VMContext), false, 
            GlobalValue.LinkageTypes.ExternalLinkage, (Constant /*P*/ )null, new Twine(Name));
         });
      }
    }
    return IvarOffsetPointer;
  }

/// Emits a reference to a class.  This allows the linker to object if there
  /// is no class of the matching name.
  /*protected:*/
  // end anonymous namespace
  
  /// Emits a reference to a dummy variable which is emitted with each class.
  /// This ensures that a linker error will be generated when trying to link
  /// together modules where a referenced class is not defined.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGObjCGNU::EmitClassRef">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCGNU.cpp", line = 902,
   FQN="(anonymous namespace)::CGObjCGNU::EmitClassRef", NM="_ZN12_GLOBAL__N_19CGObjCGNU12EmitClassRefERKSs",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCGNU.cpp -nm=_ZN12_GLOBAL__N_19CGObjCGNU12EmitClassRefERKSs")
  //</editor-fold>
  protected void EmitClassRef(final /*const*/std.string/*&*/ className) {
    std.string symbolRef = $add_T$C$P_string$C(/*KEEP_STR*/"__objc_class_ref_", className);
    // Don't emit two copies of the same symbol
    if ((TheModule.getGlobalVariable(new StringRef(symbolRef)) != null)) {
      return;
    }
    std.string symbolName = $add_T$C$P_string$C(/*KEEP_STR*/"__objc_class_name_", className);
    GlobalVariable /*P*/ ClassSymbol = TheModule.getGlobalVariable(new StringRef(symbolName));
    if (!(ClassSymbol != null)) {
      ClassSymbol = /*NEW_EXPR [GlobalVariable::new]*/GlobalVariable.$new_GlobalVariable((type$ptr<?> New$Mem)->{
          return new GlobalVariable(TheModule, LongTy, false, 
          GlobalValue.LinkageTypes.ExternalLinkage, 
          (Constant /*P*/ )null, new Twine(symbolName));
       });
    }
    GlobalVariable /*P*/ ClassSymbol_final = ClassSymbol;
    /*NEW_EXPR [GlobalVariable::new]*/GlobalVariable.$new_GlobalVariable((type$ptr<?> New$Mem)->{
        return new GlobalVariable(TheModule, ClassSymbol_final.getType(), true, 
        GlobalValue.LinkageTypes.WeakAnyLinkage, ClassSymbol_final, new Twine(symbolRef));
     });
  }

  
  /// Emits a pointer to the named class
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGObjCGNU::GetClassNamed">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCGNU.cpp", line = 1053,
   FQN="(anonymous namespace)::CGObjCGNU::GetClassNamed", NM="_ZN12_GLOBAL__N_19CGObjCGNU13GetClassNamedERN5clang7CodeGen15CodeGenFunctionERKSsb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCGNU.cpp -nm=_ZN12_GLOBAL__N_19CGObjCGNU13GetClassNamedERN5clang7CodeGen15CodeGenFunctionERKSsb")
  //</editor-fold>
  protected Value /*P*/ GetClassNamed(final CodeGenFunction /*&*/ CGF, 
               final /*const*/std.string/*&*/ Name, boolean isWeak) {
    Constant /*P*/ ClassName = MakeConstantString(Name);
    // With the incompatible ABI, this will need to be replaced with a direct
    // reference to the class symbol.  For the compatible nonfragile ABI we are
    // still performing this lookup at run time but emitting the symbol for the
    // class externally so that we can make the switch later.
    //
    // Libobjc2 contains an LLVM pass that replaces calls to objc_lookup_class
    // with memoized versions or with static references if it's safe to do so.
    if (!isWeak) {
      EmitClassRef(Name);
    }
    
    Constant /*P*/ ClassLookupFn = CGM.CreateRuntimeFunction(org.llvm.ir.FunctionType.get(IdTy, new ArrayRef<org.llvm.ir.Type /*P*/ >(PtrToInt8Ty, true), true), 
        new StringRef(/*KEEP_STR*/"objc_lookup_class"));
    return CGF.EmitNounwindRuntimeCall(ClassLookupFn, new ArrayRef<Value /*P*/ >(ClassName, true));
  }

  
  /// Looks up the method for sending a message to the specified object.  This
  /// mechanism differs between the GCC and GNU runtimes, so this method must be
  /// overridden in subclasses.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGObjCGNU::LookupIMP">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCGNU.cpp", line = 480,
   FQN="(anonymous namespace)::CGObjCGNU::LookupIMP", NM="_ZN12_GLOBAL__N_19CGObjCGNU9LookupIMPERN5clang7CodeGen15CodeGenFunctionERPN4llvm5ValueES7_PNS5_6MDNodeERNS2_13CGObjCRuntime15MessageSendInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCGNU.cpp -nm=_ZN12_GLOBAL__N_19CGObjCGNU9LookupIMPERN5clang7CodeGen15CodeGenFunctionERPN4llvm5ValueES7_PNS5_6MDNodeERNS2_13CGObjCRuntime15MessageSendInfoE")
  //</editor-fold>
  protected abstract /*virtual*/ Value /*P*/ LookupIMP(final CodeGenFunction /*&*/ CGF, 
           final type$ref<Value /*P*/ /*&*/> Receiver, 
           Value /*P*/ cmd, 
           MDNode /*P*/ node, 
           final CGObjCRuntime.MessageSendInfo /*&*/ MSI)/* = 0*/;

  
  /// Looks up the method for sending a message to a superclass.  This
  /// mechanism differs between the GCC and GNU runtimes, so this method must
  /// be overridden in subclasses.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGObjCGNU::LookupIMPSuper">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCGNU.cpp", line = 489,
   FQN="(anonymous namespace)::CGObjCGNU::LookupIMPSuper", NM="_ZN12_GLOBAL__N_19CGObjCGNU14LookupIMPSuperERN5clang7CodeGen15CodeGenFunctionENS2_7AddressEPN4llvm5ValueERNS2_13CGObjCRuntime15MessageSendInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCGNU.cpp -nm=_ZN12_GLOBAL__N_19CGObjCGNU14LookupIMPSuperERN5clang7CodeGen15CodeGenFunctionENS2_7AddressEPN4llvm5ValueERNS2_13CGObjCRuntime15MessageSendInfoE")
  //</editor-fold>
  protected abstract /*virtual*/ Value /*P*/ LookupIMPSuper(final CodeGenFunction /*&*/ CGF, 
                Address ObjCSuper, 
                Value /*P*/ cmd, 
                final CGObjCRuntime.MessageSendInfo /*&*/ MSI)/* = 0*/;

  
  /// Libobjc2 uses a bitfield representation where small(ish) bitfields are
  /// stored in a 64-bit value with the low bit set to 1 and the remaining 63
  /// bits set to their values, LSB first, while larger ones are stored in a
  /// structure of this / form:
  /// 
  /// struct { int32_t length; int32_t values[length]; };
  ///
  /// The values in the array are stored in host-endian format, with the least
  /// significant bit being assumed to come first in the bitfield.  Therefore,
  /// a bitfield with the 64th bit set will be (int64_t)&{ 2, [0, 1<<31] },
  /// while a bitfield / with the 63rd bit set will be 1<<64.
  
  /// Libobjc2 uses a bitfield representation where small(ish) bitfields are
  /// stored in a 64-bit value with the low bit set to 1 and the remaining 63
  /// bits set to their values, LSB first, while larger ones are stored in a
  /// structure of this / form:
  /// 
  /// struct { int32_t length; int32_t values[length]; };
  ///
  /// The values in the array are stored in host-endian format, with the least
  /// significant bit being assumed to come first in the bitfield.  Therefore, a
  /// bitfield with the 64th bit set will be (int64_t)&{ 2, [0, 1<<31] }, while a
  /// bitfield / with the 63rd bit set will be 1<<64.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGObjCGNU::MakeBitField">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCGNU.cpp", line = 2038,
   FQN="(anonymous namespace)::CGObjCGNU::MakeBitField", NM="_ZN12_GLOBAL__N_19CGObjCGNU12MakeBitFieldEN4llvm8ArrayRefIbEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCGNU.cpp -nm=_ZN12_GLOBAL__N_19CGObjCGNU12MakeBitFieldEN4llvm8ArrayRefIbEE")
  //</editor-fold>
  protected Constant /*P*/ MakeBitField(ArrayRefBool bits) {
    int bitCount = bits.size();
    int ptrBits = CGM.getDataLayout().getPointerSizeInBits();
    if (bitCount < ptrBits) {
      long/*uint64_t*/ val = $int2ulong(1);
      for (int i = 0; i < bitCount; ++i) {
        if (bits.$at(i)) {
          val |= 1L/*ULL*/ << (i + 1);
        }
      }
      return ConstantInt.get(IntPtrTy, val);
    }
    SmallVector<Constant /*P*/ > values/*J*/= new SmallVector<Constant /*P*/ >(8, (Constant /*P*/ )null);
    int v = 0;
    while (v < bitCount) {
      int/*int32_t*/ word = 0;
      for (int i = 0; (i < 32) && (v < bitCount); ++i) {
        if (bits.$at(v)) {
          word |= 1 << i;
        }
        v++;
      }
      values.push_back(ConstantInt.get(Int32Ty, $int2ulong(word)));
    }
    org.llvm.ir.ArrayType /*P*/ arrayTy = org.llvm.ir.ArrayType.get(Int32Ty, $uint2ulong(values.size()));
    Constant /*P*/ array = ConstantArray.get(arrayTy, new ArrayRef<Constant /*P*/ >(values, true));
    Constant /*P*/ fields[/*2*/] = new Constant /*P*/  [/*2*/] {
      ConstantInt.get(Int32Ty, $uint2ulong(values.size())), 
      array};
    Constant /*P*/ GS = MakeGlobal_StructType$P_ArrayRef$Constant$P_CharUnits_StringRef_LinkageTypes(StructType.get(Int32Ty, arrayTy, 
            null), new ArrayRef<Constant /*P*/ >(fields, true), CharUnits.fromQuantity(4));
    Constant /*P*/ ptr = ConstantExpr.getPtrToInt(GS, IntPtrTy);
    return ptr;
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGObjCGNU::CGObjCGNU">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCGNU.cpp", line = 928,
   FQN="(anonymous namespace)::CGObjCGNU::CGObjCGNU", NM="_ZN12_GLOBAL__N_19CGObjCGNUC1ERN5clang7CodeGen13CodeGenModuleEjj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCGNU.cpp -nm=_ZN12_GLOBAL__N_19CGObjCGNUC1ERN5clang7CodeGen13CodeGenModuleEjj")
  //</editor-fold>
  public CGObjCGNU(final CodeGenModule /*&*/ cgm, /*uint*/int runtimeABIVersion, 
      /*uint*/int protocolClassVersion) {
    // : CGObjCRuntime(cgm), TheModule(CGM.getModule()), ASTIdTy(), VMContext(cgm.getLLVMContext()), ClassPtrAlias(null), MetaClassPtrAlias(null), Classes(), Categories(), ConstantStrings(), ObjCStrings(), ExistingProtocols(), SelectorTable(), RetainSel(), ReleaseSel(), AutoreleaseSel(), IvarAssignFn(), StrongCastAssignFn(), MemMoveFn(), WeakReadFn(), WeakAssignFn(), GlobalAssignFn(), ClassAliases(), ExceptionThrowFn(), ExceptionReThrowFn(), EnterCatchFn(), ExitCatchFn(), SyncEnterFn(), SyncExitFn(), EnumerationMutationFn(), GetPropertyFn(), SetPropertyFn(), GetStructPropertyFn(), SetStructPropertyFn(), RuntimeVersion(runtimeABIVersion), ProtocolVersion(protocolClassVersion) 
    //START JInit
    super(cgm);
    this./*&*/TheModule=/*&*/CGM.getModule();
    this.ASTIdTy = new CanQual<org.clang.ast.Type>();
    this./*&*/VMContext=/*&*/cgm.getLLVMContext();
    this.ClassPtrAlias = null;
    this.MetaClassPtrAlias = null;
    this.Classes = new std.vector<Constant /*P*/ >((Constant /*P*/ )null);
    this.Categories = new std.vector<Constant /*P*/ >((Constant /*P*/ )null);
    this.ConstantStrings = new std.vector<Constant /*P*/ >((Constant /*P*/ )null);
    this.ObjCStrings = new StringMap<Constant /*P*/ >((Constant /*P*/ )null);
    this.ExistingProtocols = new StringMap<Constant /*P*/ >((Constant /*P*/ )null);
    this.SelectorTable = new DenseMap<Selector, SmallVector<std.pairTypePtr<std.string, GlobalAlias /*P*/ >>>(DenseMapInfoSelector.$Info(), new SmallVector<std.pairTypePtr<std.string, GlobalAlias /*P*/ >>(2, new std.pairTypePtr(new std.string(), null)));
    this.RetainSel = new Selector();
    this.ReleaseSel = new Selector();
    this.AutoreleaseSel = new Selector();
    this.IvarAssignFn = new LazyRuntimeFunction();
    this.StrongCastAssignFn = new LazyRuntimeFunction();
    this.MemMoveFn = new LazyRuntimeFunction();
    this.WeakReadFn = new LazyRuntimeFunction();
    this.WeakAssignFn = new LazyRuntimeFunction();
    this.GlobalAssignFn = new LazyRuntimeFunction();
    this.ClassAliases = new std.vector<std.pairTypeType<std.string, std.string>>(new std.pairTypeType<std.string, std.string>(std.string.EMPTY, std.string.EMPTY));
    this.ExceptionThrowFn = new LazyRuntimeFunction();
    this.ExceptionReThrowFn = new LazyRuntimeFunction();
    this.EnterCatchFn = new LazyRuntimeFunction();
    this.ExitCatchFn = new LazyRuntimeFunction();
    this.SyncEnterFn = new LazyRuntimeFunction();
    this.SyncExitFn = new LazyRuntimeFunction();
    this.EnumerationMutationFn = new LazyRuntimeFunction();
    this.GetPropertyFn = new LazyRuntimeFunction();
    this.SetPropertyFn = new LazyRuntimeFunction();
    this.GetStructPropertyFn = new LazyRuntimeFunction();
    this.SetStructPropertyFn = new LazyRuntimeFunction();
    this.RuntimeVersion = runtimeABIVersion;
    this.ProtocolVersion = protocolClassVersion;
    //END JInit
    
    msgSendMDKind = VMContext.getMDKindID(new StringRef(/*KEEP_STR*/"GNUObjCMessageSend"));
    
    final CodeGenTypes /*&*/ Types = CGM.getTypes();
    IntTy = cast_IntegerType(Types.ConvertType(CGM.getContext().IntTy.$QualType()));
    LongTy = cast_IntegerType(Types.ConvertType(CGM.getContext().LongTy.$QualType()));
    SizeTy = cast_IntegerType(Types.ConvertType(CGM.getContext().getSizeType().$QualType()));
    PtrDiffTy = cast_IntegerType(Types.ConvertType(CGM.getContext().getPointerDiffType()));
    BoolTy = CGM.getTypes().ConvertType(CGM.getContext().BoolTy.$QualType());
    
    Int8Ty = org.llvm.ir.Type.getInt8Ty(VMContext);
    // C string type.  Used in lots of places.
    PtrToInt8Ty = org.llvm.ir.PointerType.getUnqual(Int8Ty);
    
    Zeros[0] = ConstantInt.get(LongTy, $int2ulong(0));
    Zeros[1] = Zeros[0];
    NULLPtr = ConstantPointerNull.get(PtrToInt8Ty);
    // Get the selector Type.
    QualType selTy = CGM.getContext().getObjCSelType();
    if (QualType.$eq_QualType$C(new QualType(), selTy)) {
      SelectorTy = PtrToInt8Ty;
    } else {
      SelectorTy = cast_PointerType(CGM.getTypes().ConvertType(new QualType(selTy)));
    }
    
    PtrToIntTy = org.llvm.ir.PointerType.getUnqual(IntTy);
    PtrTy = PtrToInt8Ty;
    
    Int32Ty = org.llvm.ir.Type.getInt32Ty(VMContext);
    Int64Ty = org.llvm.ir.Type.getInt64Ty(VMContext);
    
    IntPtrTy
       = CGM.getDataLayout().getPointerSizeInBits() == 32 ? Int32Ty : Int64Ty;
    
    // Object type
    QualType UnqualIdTy = CGM.getContext().getObjCIdType();
    ASTIdTy.$assignMove(new CanQual<org.clang.ast.Type>());
    if (QualType.$noteq_QualType$C(UnqualIdTy, new QualType())) {
      ASTIdTy.$assignMove(CGM.getContext().getCanonicalType(/*NO_COPY*/UnqualIdTy));
      IdTy = cast_PointerType(CGM.getTypes().ConvertType(ASTIdTy.$QualType()));
    } else {
      IdTy = PtrToInt8Ty;
    }
    PtrToIdTy = org.llvm.ir.PointerType.getUnqual(IdTy);
    
    ObjCSuperTy = StructType.get(IdTy, IdTy, null);
    PtrToObjCSuperTy = org.llvm.ir.PointerType.getUnqual(ObjCSuperTy);
    
    org.llvm.ir.Type /*P*/ VoidTy = org.llvm.ir.Type.getVoidTy(VMContext);
    
    // void objc_exception_throw(id);
    ExceptionThrowFn.init($AddrOf(CGM), $("objc_exception_throw"), VoidTy, IdTy, null);
    ExceptionReThrowFn.init($AddrOf(CGM), $("objc_exception_throw"), VoidTy, IdTy, null);
    // int objc_sync_enter(id);
    SyncEnterFn.init($AddrOf(CGM), $("objc_sync_enter"), IntTy, IdTy, null);
    // int objc_sync_exit(id);
    SyncExitFn.init($AddrOf(CGM), $("objc_sync_exit"), IntTy, IdTy, null);
    
    // void objc_enumerationMutation (id)
    EnumerationMutationFn.init($AddrOf(CGM), $("objc_enumerationMutation"), VoidTy, 
        IdTy, null);
    
    // id objc_getProperty(id, SEL, ptrdiff_t, BOOL)
    GetPropertyFn.init($AddrOf(CGM), $("objc_getProperty"), IdTy, IdTy, SelectorTy, 
        PtrDiffTy, BoolTy, null);
    // void objc_setProperty(id, SEL, ptrdiff_t, id, BOOL, BOOL)
    SetPropertyFn.init($AddrOf(CGM), $("objc_setProperty"), VoidTy, IdTy, SelectorTy, 
        PtrDiffTy, IdTy, BoolTy, BoolTy, null);
    // void objc_setPropertyStruct(void*, void*, ptrdiff_t, BOOL, BOOL)
    GetStructPropertyFn.init($AddrOf(CGM), $("objc_getPropertyStruct"), VoidTy, PtrTy, PtrTy, 
        PtrDiffTy, BoolTy, BoolTy, null);
    // void objc_setPropertyStruct(void*, void*, ptrdiff_t, BOOL, BOOL)
    SetStructPropertyFn.init($AddrOf(CGM), $("objc_setPropertyStruct"), VoidTy, PtrTy, PtrTy, 
        PtrDiffTy, BoolTy, BoolTy, null);
    
    // IMP type
    org.llvm.ir.Type /*P*/ IMPArgs[/*2*/] = new org.llvm.ir.Type /*P*/  [/*2*/] {IdTy, SelectorTy};
    IMPTy = org.llvm.ir.PointerType.getUnqual(org.llvm.ir.FunctionType.get(IdTy, new ArrayRef<org.llvm.ir.Type /*P*/ >(IMPArgs, true), 
            true));
    
    final /*const*/ LangOptions /*&*/ Opts = CGM.getLangOpts();
    if ((Opts.getGC() != LangOptions.GCMode.NonGC) || Opts.ObjCAutoRefCount) {
      RuntimeVersion = 10;
    }
    
    // Don't bother initialising the GC stuff unless we're compiling in GC mode
    if (Opts.getGC() != LangOptions.GCMode.NonGC) {
      // This is a bit of an hack.  We should sort this out by having a proper
      // CGObjCGNUstep subclass for GC, but we may want to really support the old
      // ABI and GC added in ObjectiveC2.framework, so we fudge it a bit for now
      // Get selectors needed in GC mode
      RetainSel.$assignMove(GetNullarySelector(new StringRef(/*KEEP_STR*/"retain"), CGM.getContext()));
      ReleaseSel.$assignMove(GetNullarySelector(new StringRef(/*KEEP_STR*/"release"), CGM.getContext()));
      AutoreleaseSel.$assignMove(GetNullarySelector(new StringRef(/*KEEP_STR*/"autorelease"), CGM.getContext()));
      
      // Get functions needed in GC mode
      
      // id objc_assign_ivar(id, id, ptrdiff_t);
      IvarAssignFn.init($AddrOf(CGM), $("objc_assign_ivar"), IdTy, IdTy, IdTy, PtrDiffTy, 
          null);
      // id objc_assign_strongCast (id, id*)
      StrongCastAssignFn.init($AddrOf(CGM), $("objc_assign_strongCast"), IdTy, IdTy, 
          PtrToIdTy, null);
      // id objc_assign_global(id, id*);
      GlobalAssignFn.init($AddrOf(CGM), $("objc_assign_global"), IdTy, IdTy, PtrToIdTy, 
          null);
      // id objc_assign_weak(id, id*);
      WeakAssignFn.init($AddrOf(CGM), $("objc_assign_weak"), IdTy, IdTy, PtrToIdTy, null);
      // id objc_read_weak(id*);
      WeakReadFn.init($AddrOf(CGM), $("objc_read_weak"), IdTy, PtrToIdTy, null);
      // void *objc_memmove_collectable(void*, void *, size_t);
      MemMoveFn.init($AddrOf(CGM), $("objc_memmove_collectable"), PtrTy, PtrTy, PtrTy, 
          SizeTy, null);
    }
  }

  
  
  /// Generate an NSConstantString object.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGObjCGNU::GenerateConstantString">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCGNU.cpp", line = 1248,
   FQN="(anonymous namespace)::CGObjCGNU::GenerateConstantString", NM="_ZN12_GLOBAL__N_19CGObjCGNU22GenerateConstantStringEPKN5clang13StringLiteralE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCGNU.cpp -nm=_ZN12_GLOBAL__N_19CGObjCGNU22GenerateConstantStringEPKN5clang13StringLiteralE")
  //</editor-fold>
  @Override public ConstantAddress GenerateConstantString(/*const*/ StringLiteral /*P*/ SL)/* override*/ {
    std.vector<Constant /*P*/ > Ivars = null;
    try {
      
      std.string Str = SL.getString().str();
      CharUnits Align = CGM.getPointerAlign();
      
      // Look for an existing one
      StringMapIterator<Constant /*P*/ > old = ObjCStrings.find(new StringRef(Str));
      if (old.$noteq(ObjCStrings.end())) {
        return new ConstantAddress(old.$arrow().getValue(), new CharUnits(Align));
      }
      
      StringRef StringClass = new StringRef(CGM.getLangOpts().ObjCConstantStringClass);
      if (StringClass.empty()) {
        StringClass.$assignMove(/*STRINGREF_STR*/"NXConstantString");
      }
      
      std.string Sym = new std.string(JD$T$C$P_T2$C$R.INSTANCE, /*KEEP_STR*/"_OBJC_CLASS_");
      $addassign_string_StringRef(Sym, /*NO_COPY*/StringClass);
      
      Constant /*P*/ isa = TheModule.getNamedGlobal(new StringRef(Sym));
      if (!(isa != null)) {
        isa = /*NEW_EXPR [GlobalVariable::new]*/GlobalVariable.$new_GlobalVariable((type$ptr<?> New$Mem)->{
            return new GlobalVariable(TheModule, IdTy, /* isConstant */ false, 
            GlobalValue.LinkageTypes.ExternalWeakLinkage, (Constant /*P*/ )null, new Twine(Sym));
         });
      } else if (isa.getType() != PtrToIdTy) {
        isa = ConstantExpr.getBitCast(isa, PtrToIdTy);
      }
      
      Ivars/*J*/= new std.vector<Constant /*P*/ >((Constant /*P*/ )null);
      Ivars.push_back_T$C$R(isa);
      Ivars.push_back_T$RR(MakeConstantString(Str));
      Ivars.push_back_T$RR(ConstantInt.get(IntTy, $uint2ulong(Str.size())));
      Constant /*P*/ ObjCStr = MakeGlobal_StructType$P_ArrayRef$Constant$P_CharUnits_StringRef_LinkageTypes(StructType.get(PtrToIdTy, PtrToInt8Ty, IntTy, null), 
          new ArrayRef<Constant /*P*/ >(Ivars, true), new CharUnits(Align), new StringRef(/*KEEP_STR*/".objc_str"));
      ObjCStr = ConstantExpr.getBitCast(ObjCStr, PtrToInt8Ty);
      ObjCStrings.$set(new StringRef(Str), ObjCStr);
      ConstantStrings.push_back_T$C$R(ObjCStr);
      return new ConstantAddress(ObjCStr, new CharUnits(Align));
    } finally {
      if (Ivars != null) { Ivars.$destroy(); }
    }
  }

  
  
  /// Generate code for a message send expression.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGObjCGNU::GenerateMessageSend">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCGNU.cpp", line = 1397,
   FQN="(anonymous namespace)::CGObjCGNU::GenerateMessageSend", NM="_ZN12_GLOBAL__N_19CGObjCGNU19GenerateMessageSendERN5clang7CodeGen15CodeGenFunctionENS2_15ReturnValueSlotENS1_8QualTypeENS1_8SelectorEPN4llvm5ValueERKNS2_11CallArgListEPKNS1_17ObjCInterfaceDeclEPKNS1_14ObjCMethodDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCGNU.cpp -nm=_ZN12_GLOBAL__N_19CGObjCGNU19GenerateMessageSendERN5clang7CodeGen15CodeGenFunctionENS2_15ReturnValueSlotENS1_8QualTypeENS1_8SelectorEPN4llvm5ValueERKNS2_11CallArgListEPKNS1_17ObjCInterfaceDeclEPKNS1_14ObjCMethodDeclE")
  //</editor-fold>
  @Override public RValue GenerateMessageSend(final CodeGenFunction /*&*/ CGF, 
                     ReturnValueSlot Return, 
                     QualType ResultType, 
                     Selector Sel, 
                     Value /*P*/ Receiver, 
                     final /*const*/ CallArgList /*&*/ CallArgs, 
                     /*const*/ ObjCInterfaceDecl /*P*/ Class, 
                     /*const*/ ObjCMethodDecl /*P*/ Method)/* override*/ {
    type$ref<Value> Receiver_ref = create_type$ref(Receiver);
    CallArgList ActualArgs = null;
    try {
      final CGBuilderTy /*&*/ Builder = CGF.Builder;
      
      // Strip out message sends to retain / release in GC mode
      if (CGM.getLangOpts().getGC() == LangOptions.GCMode.GCOnly) {
        if (Sel.$eq(/*NO_COPY*/RetainSel) || Sel.$eq(/*NO_COPY*/AutoreleaseSel)) {
          return RValue.get(EnforceType(Builder, Receiver_ref.$deref(), 
                  CGM.getTypes().ConvertType(new QualType(ResultType))));
        }
        if (Sel.$eq(/*NO_COPY*/ReleaseSel)) {
          return RValue.get((Value /*P*/ )null);
        }
      }
      
      // If the return type is something that goes in an integer register, the
      // runtime will handle 0 returns.  For other cases, we fill in the 0 value
      // ourselves.
      //
      // The language spec says the result of this kind of message send is
      // undefined, but lots of people seem to have forgotten to read that
      // paragraph and insist on sending messages to nil that have structure
      // returns.  With GCC, this generates a random return value (whatever happens
      // to be on the stack / in those registers at the time) on most platforms,
      // and generates an illegal instruction trap on SPARC.  With LLVM it corrupts
      // the stack.  
      boolean isPointerSizedReturn = (ResultType.$arrow().isAnyPointerType()
         || ResultType.$arrow().isIntegralOrEnumerationType() || ResultType.$arrow().isVoidType());
      
      BasicBlock /*P*/ startBB = null;
      BasicBlock /*P*/ messageBB = null;
      BasicBlock /*P*/ continueBB = null;
      if (!isPointerSizedReturn) {
        startBB = Builder.GetInsertBlock();
        messageBB = CGF.createBasicBlock(new Twine(/*KEEP_STR*/"msgSend"));
        continueBB = CGF.createBasicBlock(new Twine(/*KEEP_STR*/$continue));
        
        Value /*P*/ isNil = Builder.CreateICmpEQ(Receiver_ref.$deref(), 
            Constant.getNullValue(Receiver_ref.$deref().getType()));
        Builder.CreateCondBr(isNil, continueBB, messageBB);
        CGF.EmitBlock(messageBB);
      }
      
      IdTy = cast_PointerType(CGM.getTypes().ConvertType(ASTIdTy.$QualType()));
      Value /*P*/ cmd;
      if ((Method != null)) {
        cmd = GetSelector(CGF, Method);
      } else {
        cmd = GetSelector(CGF, new Selector(Sel));
      }
      cmd = EnforceType(Builder, cmd, SelectorTy);
      Receiver_ref.$set(EnforceType(Builder, Receiver_ref.$deref(), IdTy));
      
      Metadata /*P*/ impMD[/*3*/] = new Metadata /*P*/  [/*3*/] {
        MDString.get(VMContext, new StringRef(Sel.getAsString())), 
        MDString.get(VMContext, new StringRef((Class != null) ? Class.getNameAsString() : new std.string(JD$T$C$P_T2$C$R.INSTANCE, /*KEEP_STR*/$EMPTY))), 
        ConstantAsMetadata.get(ConstantInt.get(org.llvm.ir.Type.getInt1Ty(VMContext), ((Class != (/*const*/ ObjCInterfaceDecl /*P*/ )null) ? 1 : 0)))
      };
      MDNode /*P*/ node = MDNode.get(VMContext, new ArrayRef<Metadata /*P*/ >(impMD, true));
      
      ActualArgs/*J*/= new CallArgList();
      ActualArgs.add(RValue.get(Receiver_ref.$deref()), ASTIdTy.$QualType());
      ActualArgs.add(RValue.get(cmd), CGF.getContext().getObjCSelType());
      ActualArgs.addFrom(CallArgs);
      
      CGObjCRuntime.MessageSendInfo MSI = getMessageSendInfo(Method, new QualType(ResultType), ActualArgs);
      
      // Get the IMP to call
      Value /*P*/ imp = null;
      
      // If we have non-legacy dispatch specified, we try using the objc_msgSend()
      // functions.  These are not supported on all platforms (or all runtimes on a
      // given platform), so we 
      switch (CGM.getCodeGenOpts().getObjCDispatchMethod()) {
       case Legacy:
        imp = LookupIMP(CGF, Receiver_ref, cmd, node, MSI);
        break;
       case Mixed:
       case NonLegacy:
        if (CGM.ReturnTypeUsesFPRet(new QualType(ResultType))) {
          imp = CGM.CreateRuntimeFunction(org.llvm.ir.FunctionType.get(IdTy, new ArrayRef<org.llvm.ir.Type /*P*/ >(IdTy, true), true), 
              new StringRef(/*KEEP_STR*/"objc_msgSend_fpret"));
        } else if (CGM.ReturnTypeUsesSRet(MSI.CallInfo)) {
          // The actual types here don't matter - we're going to bitcast the
          // function anyway
          imp = CGM.CreateRuntimeFunction(org.llvm.ir.FunctionType.get(IdTy, new ArrayRef<org.llvm.ir.Type /*P*/ >(IdTy, true), true), 
              new StringRef(/*KEEP_STR*/"objc_msgSend_stret"));
        } else {
          imp = CGM.CreateRuntimeFunction(org.llvm.ir.FunctionType.get(IdTy, new ArrayRef<org.llvm.ir.Type /*P*/ >(IdTy, true), true), 
              new StringRef(/*KEEP_STR*/"objc_msgSend"));
        }
      }
      
      // Reset the receiver in case the lookup modified it
      ActualArgs.$at(0).$assignMove(new CallArg(RValue.get(Receiver_ref.$deref()), ASTIdTy.$QualType(), false));
      
      imp = EnforceType(Builder, imp, MSI.MessengerType);
      
      type$ptr<Instruction /*P*/ > call = create_type$null$ptr();
      RValue msgRet = CGF.EmitCall(MSI.CallInfo, imp, new ReturnValueSlot(Return), ActualArgs, 
          new CGCalleeInfo(), $AddrOf(call));
      call.$star().setMetadata(msgSendMDKind, node);
      if (!isPointerSizedReturn) {
        messageBB = CGF.Builder.GetInsertBlock();
        CGF.Builder.CreateBr(continueBB);
        CGF.EmitBlock(continueBB);
        if (msgRet.isScalar()) {
          Value /*P*/ v = msgRet.getScalarVal();
          PHINode /*P*/ phi = Builder.CreatePHI(v.getType(), 2);
          phi.addIncoming(v, messageBB);
          phi.addIncoming(Constant.getNullValue(v.getType()), startBB);
          msgRet.$assignMove(RValue.get(phi));
        } else if (msgRet.isAggregate()) {
          Address v = msgRet.getAggregateAddress();
          PHINode /*P*/ phi = Builder.CreatePHI(v.getType(), 2);
          org.llvm.ir.Type /*P*/ RetTy = v.getElementType();
          Address NullVal = CGF.CreateTempAlloca(RetTy, v.getAlignment(), new Twine(/*KEEP_STR*/"null"));
          CGF.InitTempAlloca(new Address(NullVal), Constant.getNullValue(RetTy));
          phi.addIncoming(v.getPointer(), messageBB);
          phi.addIncoming(NullVal.getPointer(), startBB);
          msgRet.$assignMove(RValue.getAggregate(new Address(phi, v.getAlignment())));
        } else {
          std.pair<Value /*P*/ , Value /*P*/ > v = msgRet.getComplexVal();
          PHINode /*P*/ phi = Builder.CreatePHI(v.first.getType(), 2);
          phi.addIncoming(v.first, messageBB);
          phi.addIncoming(Constant.getNullValue(v.first.getType()), 
              startBB);
          PHINode /*P*/ phi2 = Builder.CreatePHI(v.second.getType(), 2);
          phi2.addIncoming(v.second, messageBB);
          phi2.addIncoming(Constant.getNullValue(v.second.getType()), 
              startBB);
          msgRet.$assignMove(RValue.getComplex(phi, phi2));
        }
      }
      return msgRet;
    } finally {
      if (ActualArgs != null) { ActualArgs.$destroy(); }
    }
  }

  
  ///Generates a message send where the super is the receiver.  This is a message
  ///send to self with special delivery semantics indicating which class's method
  ///should be called.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGObjCGNU::GenerateMessageSendSuper">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCGNU.cpp", line = 1289,
   FQN="(anonymous namespace)::CGObjCGNU::GenerateMessageSendSuper", NM="_ZN12_GLOBAL__N_19CGObjCGNU24GenerateMessageSendSuperERN5clang7CodeGen15CodeGenFunctionENS2_15ReturnValueSlotENS1_8QualTypeENS1_8SelectorEPKNS1_17ObjCInterfaceDeclEbPN4llvm5ValueEbRKNS2_11CallArgListEPKNS1_14ObjCMethodDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCGNU.cpp -nm=_ZN12_GLOBAL__N_19CGObjCGNU24GenerateMessageSendSuperERN5clang7CodeGen15CodeGenFunctionENS2_15ReturnValueSlotENS1_8QualTypeENS1_8SelectorEPKNS1_17ObjCInterfaceDeclEbPN4llvm5ValueEbRKNS2_11CallArgListEPKNS1_14ObjCMethodDeclE")
  //</editor-fold>
  @Override public RValue GenerateMessageSendSuper(final CodeGenFunction /*&*/ CGF, 
                          ReturnValueSlot Return, 
                          QualType ResultType, 
                          Selector Sel, 
                          /*const*/ ObjCInterfaceDecl /*P*/ Class, 
                          boolean isCategoryImpl, 
                          Value /*P*/ Receiver, 
                          boolean IsClassMessage, 
                          final /*const*/ CallArgList /*&*/ CallArgs, 
                          /*const*/ ObjCMethodDecl /*P*/ Method)/* override*/ {
    CallArgList ActualArgs = null;
    try {
      final CGBuilderTy /*&*/ Builder = CGF.Builder;
      if (CGM.getLangOpts().getGC() == LangOptions.GCMode.GCOnly) {
        if (Sel.$eq(/*NO_COPY*/RetainSel) || Sel.$eq(/*NO_COPY*/AutoreleaseSel)) {
          return RValue.get(EnforceType(Builder, Receiver, 
                  CGM.getTypes().ConvertType(new QualType(ResultType))));
        }
        if (Sel.$eq(/*NO_COPY*/ReleaseSel)) {
          return RValue.get((Value /*P*/ )null);
        }
      }
      
      Value /*P*/ cmd = GetSelector(CGF, new Selector(Sel));
      ActualArgs/*J*/= new CallArgList();
      
      ActualArgs.add(RValue.get(EnforceType(Builder, Receiver, IdTy)), ASTIdTy.$QualType());
      ActualArgs.add(RValue.get(cmd), CGF.getContext().getObjCSelType());
      ActualArgs.addFrom(CallArgs);
      
      CGObjCRuntime.MessageSendInfo MSI = getMessageSendInfo(Method, new QualType(ResultType), ActualArgs);
      
      Value /*P*/ ReceiverClass = null;
      if (isCategoryImpl) {
        Constant /*P*/ classLookupFunction = null;
        if (IsClassMessage) {
          classLookupFunction = CGM.CreateRuntimeFunction(org.llvm.ir.FunctionType.get(IdTy, new ArrayRef<org.llvm.ir.Type /*P*/ >(PtrTy, true), true), new StringRef(/*KEEP_STR*/"objc_get_meta_class"));
        } else {
          classLookupFunction = CGM.CreateRuntimeFunction(org.llvm.ir.FunctionType.get(IdTy, new ArrayRef<org.llvm.ir.Type /*P*/ >(PtrTy, true), true), new StringRef(/*KEEP_STR*/"objc_get_class"));
        }
        ReceiverClass = Builder.CreateCall_Value$P_ArrayRef$Value$P_Twine$C_MDNode$P(classLookupFunction, 
            new ArrayRef<Value /*P*/ >(MakeConstantString(Class.getNameAsString()), true));
      } else {
        // Set up global aliases for the metaclass or class pointer if they do not
        // already exist.  These will are forward-references which will be set to
        // pointers to the class and metaclass structure created for the runtime
        // load function.  To send a message to super, we look up the value of the
        // super_class pointer from either the class or metaclass structure.
        if (IsClassMessage) {
          if (!(MetaClassPtrAlias != null)) {
            MetaClassPtrAlias = GlobalAlias.create(IdTy.getElementType(), 0, GlobalValue.LinkageTypes.InternalLinkage, 
                new Twine($add_T$C$P_string(/*KEEP_STR*/".objc_metaclass_ref", Class.getNameAsString())), $AddrOf(TheModule));
          }
          ReceiverClass = MetaClassPtrAlias;
        } else {
          if (!(ClassPtrAlias != null)) {
            ClassPtrAlias = GlobalAlias.create(IdTy.getElementType(), 0, GlobalValue.LinkageTypes.InternalLinkage, 
                new Twine($add_T$C$P_string(/*KEEP_STR*/".objc_class_ref", Class.getNameAsString())), $AddrOf(TheModule));
          }
          ReceiverClass = ClassPtrAlias;
        }
      }
      // Cast the pointer to a simplified version of the class structure
      org.llvm.ir.Type /*P*/ CastTy = StructType.get(IdTy, IdTy, null);
      ReceiverClass = Builder.CreateBitCast(ReceiverClass, 
          org.llvm.ir.PointerType.getUnqual(CastTy));
      // Get the superclass pointer
      ReceiverClass = Builder.CreateStructGEP(CastTy, ReceiverClass, 1);
      // Load the superclass pointer
      ReceiverClass
         = Builder.CreateAlignedLoad(ReceiverClass, CGF.getPointerAlign());
      // Construct the structure used to look up the IMP
      StructType /*P*/ ObjCSuperTy = StructType.get(Receiver.getType(), IdTy, null);
      
      // FIXME: Is this really supposed to be a dynamic alloca?
      Address ObjCSuper = new Address(Builder.CreateAlloca(ObjCSuperTy), 
          CGF.getPointerAlign());
      
      Builder.CreateStore(Receiver, 
          Builder.CreateStructGEP(new Address(ObjCSuper), 0, CharUnits.Zero()));
      Builder.CreateStore(ReceiverClass, 
          Builder.CreateStructGEP(new Address(ObjCSuper), 1, CGF.getPointerSize()));
      
      ObjCSuper.$assignMove(EnforceType(Builder, new Address(ObjCSuper), PtrToObjCSuperTy));
      
      // Get the IMP
      Value /*P*/ imp = LookupIMPSuper(CGF, new Address(ObjCSuper), cmd, MSI);
      imp = EnforceType(Builder, imp, MSI.MessengerType);
      
      Metadata /*P*/ impMD[/*3*/] = new Metadata /*P*/  [/*3*/] {
        MDString.get(VMContext, new StringRef(Sel.getAsString())), 
        MDString.get(VMContext, new StringRef(Class.getSuperClass().getNameAsString())), 
        ConstantAsMetadata.get(ConstantInt.get(org.llvm.ir.Type.getInt1Ty(VMContext), (IsClassMessage ? 1 : 0)))
      };
      MDNode /*P*/ node = MDNode.get(VMContext, new ArrayRef<Metadata /*P*/ >(impMD, true));
      
      type$ptr<Instruction /*P*/ > call = create_type$null$ptr();
      RValue msgRet = CGF.EmitCall(MSI.CallInfo, imp, new ReturnValueSlot(Return), ActualArgs, 
          new CGCalleeInfo(), $AddrOf(call));
      call.$star().setMetadata(msgSendMDKind, node);
      return msgRet;
    } finally {
      if (ActualArgs != null) { ActualArgs.$destroy(); }
    }
  }

  
  // This has to perform the lookup every time, since posing and related
  // techniques can modify the name -> class mapping.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGObjCGNU::GetClass">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCGNU.cpp", line = 1074,
   FQN="(anonymous namespace)::CGObjCGNU::GetClass", NM="_ZN12_GLOBAL__N_19CGObjCGNU8GetClassERN5clang7CodeGen15CodeGenFunctionEPKNS1_17ObjCInterfaceDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCGNU.cpp -nm=_ZN12_GLOBAL__N_19CGObjCGNU8GetClassERN5clang7CodeGen15CodeGenFunctionEPKNS1_17ObjCInterfaceDeclE")
  //</editor-fold>
  @Override public Value /*P*/ GetClass(final CodeGenFunction /*&*/ CGF, 
          /*const*/ ObjCInterfaceDecl /*P*/ OID)/* override*/ {
    Value /*P*/ $Value = GetClassNamed(CGF, OID.getNameAsString(), OID.isWeakImported());
    if (CGM.getTriple().isOSBinFormatCOFF()) {
      {
        GlobalVariable /*P*/ ClassSymbol = dyn_cast_GlobalVariable($Value);
        if ((ClassSymbol != null)) {
          GlobalValue.DLLStorageClassTypes DLLStorage = GlobalValue.DLLStorageClassTypes.DefaultStorageClass;
          if (OID.hasAttr(DLLExportAttr.class)) {
            DLLStorage = GlobalValue.DLLStorageClassTypes.DLLExportStorageClass;
          } else if (OID.hasAttr(DLLImportAttr.class)) {
            DLLStorage = GlobalValue.DLLStorageClassTypes.DLLImportStorageClass;
          }
          ClassSymbol.setDLLStorageClass(DLLStorage);
        }
      }
    }
    return $Value;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGObjCGNU::GetSelector">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCGNU.cpp", line = 1149,
   FQN="(anonymous namespace)::CGObjCGNU::GetSelector", NM="_ZN12_GLOBAL__N_19CGObjCGNU11GetSelectorERN5clang7CodeGen15CodeGenFunctionENS1_8SelectorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCGNU.cpp -nm=_ZN12_GLOBAL__N_19CGObjCGNU11GetSelectorERN5clang7CodeGen15CodeGenFunctionENS1_8SelectorE")
  //</editor-fold>
  @Override public Value /*P*/ GetSelector(final CodeGenFunction /*&*/ CGF, Selector Sel)/* override*/ {
    return GetSelector(CGF, new Selector(Sel), new std.string());
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGObjCGNU::GetAddrOfSelector">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCGNU.cpp", line = 1138,
   FQN="(anonymous namespace)::CGObjCGNU::GetAddrOfSelector", NM="_ZN12_GLOBAL__N_19CGObjCGNU17GetAddrOfSelectorERN5clang7CodeGen15CodeGenFunctionENS1_8SelectorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCGNU.cpp -nm=_ZN12_GLOBAL__N_19CGObjCGNU17GetAddrOfSelectorERN5clang7CodeGen15CodeGenFunctionENS1_8SelectorE")
  //</editor-fold>
  @Override public Address GetAddrOfSelector(final CodeGenFunction /*&*/ CGF, Selector Sel)/* override*/ {
    Value /*P*/ SelValue = GetSelector(CGF, new Selector(Sel));
    
    // Store it to a temporary.  Does this satisfy the semantics of
    // GetAddrOfSelector?  Hopefully.
    Address tmp = CGF.CreateTempAlloca(SelValue.getType(), 
        CGF.getPointerAlign());
    CGF.Builder.CreateStore(SelValue, new Address(tmp));
    return tmp;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGObjCGNU::GetSelector">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCGNU.cpp", line = 1153,
   FQN="(anonymous namespace)::CGObjCGNU::GetSelector", NM="_ZN12_GLOBAL__N_19CGObjCGNU11GetSelectorERN5clang7CodeGen15CodeGenFunctionEPKNS1_14ObjCMethodDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCGNU.cpp -nm=_ZN12_GLOBAL__N_19CGObjCGNU11GetSelectorERN5clang7CodeGen15CodeGenFunctionEPKNS1_14ObjCMethodDeclE")
  //</editor-fold>
  @Override public Value /*P*/ GetSelector(final CodeGenFunction /*&*/ CGF, 
             /*const*/ ObjCMethodDecl /*P*/ Method)/* override*/ {
    std.string SelTypes/*J*/= new std.string();
    CGM.getContext().getObjCEncodingForMethodDecl(Method, SelTypes);
    return GetSelector(CGF, Method.getSelector(), SelTypes);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGObjCGNU::GetEHType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCGNU.cpp", line = 1160,
   FQN="(anonymous namespace)::CGObjCGNU::GetEHType", NM="_ZN12_GLOBAL__N_19CGObjCGNU9GetEHTypeEN5clang8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCGNU.cpp -nm=_ZN12_GLOBAL__N_19CGObjCGNU9GetEHTypeEN5clang8QualTypeE")
  //</editor-fold>
  @Override public Constant /*P*/ GetEHType(QualType T)/* override*/ {
    if (T.$arrow().isObjCIdType() || T.$arrow().isObjCQualifiedIdType()) {
      // With the old ABI, there was only one kind of catchall, which broke
      // foreign exceptions.  With the new ABI, we use __objc_id_typeinfo as
      // a pointer indicating object catchalls, and NULL to indicate real
      // catchalls
      if (CGM.getLangOpts().ObjCRuntime.isNonFragile()) {
        return MakeConstantString(new std.string(JD$T$C$P_T2$C$R.INSTANCE, /*KEEP_STR*/"@id"));
      } else {
        return null;
      }
    }
    
    // All other types should be Objective-C interface pointer types.
    /*const*/ ObjCObjectPointerType /*P*/ OPT = T.$arrow().getAs(ObjCObjectPointerType.class);
    assert ((OPT != null)) : "Invalid @catch type.";
    /*const*/ ObjCInterfaceDecl /*P*/ IDecl = OPT.getObjectType().getInterface();
    assert ((IDecl != null)) : "Invalid @catch type.";
    return MakeConstantString(IDecl.getIdentifier().getName().$string());
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGObjCGNU::GenerateMethod">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCGNU.cpp", line = 2668,
   FQN="(anonymous namespace)::CGObjCGNU::GenerateMethod", NM="_ZN12_GLOBAL__N_19CGObjCGNU14GenerateMethodEPKN5clang14ObjCMethodDeclEPKNS1_17ObjCContainerDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCGNU.cpp -nm=_ZN12_GLOBAL__N_19CGObjCGNU14GenerateMethodEPKN5clang14ObjCMethodDeclEPKNS1_17ObjCContainerDeclE")
  //</editor-fold>
  @Override public Function /*P*/ GenerateMethod(/*const*/ ObjCMethodDecl /*P*/ OMD, 
                /*const*/ ObjCContainerDecl /*P*/ CD)/* override*/ {
    /*const*/ ObjCCategoryImplDecl /*P*/ OCD = dyn_cast_ObjCCategoryImplDecl(OMD.getDeclContext$Const());
    StringRef CategoryName = (OCD != null) ? OCD.getName() : new StringRef(/*KEEP_STR*/$EMPTY);
    StringRef ClassName = CD.getName();
    Selector MethodName = OMD.getSelector();
    boolean isClassMethod = !OMD.isInstanceMethod();
    
    final CodeGenTypes /*&*/ Types = CGM.getTypes();
    org.llvm.ir.FunctionType /*P*/ MethodTy = Types.GetFunctionType(Types.arrangeObjCMethodDeclaration(OMD));
    std.string FunctionName = SymbolNameForMethod(new StringRef(ClassName), new StringRef(CategoryName), 
        new Selector(MethodName), isClassMethod);
    
    Function /*P*/ Method = Function.Create(MethodTy, 
        GlobalValue.LinkageTypes.InternalLinkage, 
        new Twine(FunctionName), 
        $AddrOf(TheModule));
    return Method;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGObjCGNU::GenerateCategory">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCGNU.cpp", line = 2069,
   FQN="(anonymous namespace)::CGObjCGNU::GenerateCategory", NM="_ZN12_GLOBAL__N_19CGObjCGNU16GenerateCategoryEPKN5clang20ObjCCategoryImplDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCGNU.cpp -nm=_ZN12_GLOBAL__N_19CGObjCGNU16GenerateCategoryEPKN5clang20ObjCCategoryImplDeclE")
  //</editor-fold>
  @Override public void GenerateCategory(/*const*/ ObjCCategoryImplDecl /*P*/ OCD)/* override*/ {
    std.string ClassName = OCD.getClassInterface$Const().getNameAsString();
    std.string CategoryName = OCD.getNameAsString();
    // Collect information about instance methods
    SmallVector<Selector> InstanceMethodSels/*J*/= new SmallVector<Selector>(16, new Selector());
    SmallVector<Constant /*P*/ > InstanceMethodTypes/*J*/= new SmallVector<Constant /*P*/ >(16, (Constant /*P*/ )null);
    for (/*const*/ ObjCMethodDecl /*P*/ I : OCD.instance_methods()) {
      InstanceMethodSels.push_back(I.getSelector());
      std.string TypeStr/*J*/= new std.string();
      CGM.getContext().getObjCEncodingForMethodDecl(I, TypeStr);
      InstanceMethodTypes.push_back(MakeConstantString(TypeStr));
    }
    
    // Collect information about class methods
    SmallVector<Selector> ClassMethodSels/*J*/= new SmallVector<Selector>(16, new Selector());
    SmallVector<Constant /*P*/ > ClassMethodTypes/*J*/= new SmallVector<Constant /*P*/ >(16, (Constant /*P*/ )null);
    for (/*const*/ ObjCMethodDecl /*P*/ I : OCD.class_methods()) {
      ClassMethodSels.push_back(I.getSelector());
      std.string TypeStr/*J*/= new std.string();
      CGM.getContext().getObjCEncodingForMethodDecl(I, TypeStr);
      ClassMethodTypes.push_back(MakeConstantString(TypeStr));
    }
    
    // Collect the names of referenced protocols
    SmallVector<std.string> Protocols/*J*/= new SmallVector<std.string>(16, new std.string());
    /*const*/ ObjCCategoryDecl /*P*/ CatDecl = OCD.getCategoryDecl();
    final /*const*/ ObjCList<ObjCProtocolDecl> /*&*/ Protos = CatDecl.getReferencedProtocols();
    for (type$ptr<ObjCProtocolDecl> I = $tryClone(Protos.begin()), 
        /*P*/ /*const*/ /*P*/ E = $tryClone(Protos.end()); $noteq_ptr(I, E); I.$preInc())  {
      Protocols.push_back_T$RR((I.$star()).getNameAsString());
    }
    
    Constant /*P*/ Elements[/*5*/] = new Constant /*P*/  [/*5*/] {
      MakeConstantString(CategoryName), MakeConstantString(ClassName), 
      // Instance method list
      ConstantExpr.getBitCast(GenerateMethodList(new StringRef(ClassName), new StringRef(CategoryName), new ArrayRef<Selector>(InstanceMethodSels, false), 
              new ArrayRef<Constant /*P*/ >(InstanceMethodTypes, true), false), 
          PtrTy), 
      // Class method list
      ConstantExpr.getBitCast(GenerateMethodList(new StringRef(ClassName), new StringRef(CategoryName), 
              new ArrayRef<Selector>(ClassMethodSels, false), 
              new ArrayRef<Constant /*P*/ >(ClassMethodTypes, true), true), 
          PtrTy), 
      // Protocol list
      ConstantExpr.getBitCast(GenerateProtocolList(new ArrayRef<std.string>(Protocols, false)), PtrTy)};
    Categories.push_back_T$RR(ConstantExpr.getBitCast(MakeGlobal_StructType$P_ArrayRef$Constant$P_CharUnits_StringRef_LinkageTypes(StructType.get(PtrToInt8Ty, PtrToInt8Ty, 
                    PtrTy, PtrTy, PtrTy, null), new ArrayRef<Constant /*P*/ >(Elements, true), CGM.getPointerAlign()), 
            PtrTy));
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGObjCGNU::GenerateClass">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCGNU.cpp", line = 2195,
   FQN="(anonymous namespace)::CGObjCGNU::GenerateClass", NM="_ZN12_GLOBAL__N_19CGObjCGNU13GenerateClassEPKN5clang22ObjCImplementationDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCGNU.cpp -nm=_ZN12_GLOBAL__N_19CGObjCGNU13GenerateClassEPKN5clang22ObjCImplementationDeclE")
  //</editor-fold>
  @Override public void GenerateClass(/*const*/ ObjCImplementationDecl /*P*/ OID)/* override*/ {
    std.vector<Constant /*P*/ > IvarOffsetValues = null;
    try {
      final ASTContext /*&*/ Context = CGM.getContext();
      
      // Get the superclass name.
      /*const*/ ObjCInterfaceDecl /*P*/ SuperClassDecl = OID.getClassInterface$Const().getSuperClass();
      std.string SuperClassName/*J*/= new std.string();
      if ((SuperClassDecl != null)) {
        SuperClassName.$assignMove(SuperClassDecl.getNameAsString());
        EmitClassRef(SuperClassName);
      }
      
      // Get the class name
      ObjCInterfaceDecl /*P*/ ClassDecl = ((/*const_cast*/ObjCInterfaceDecl /*P*/ )(OID.getClassInterface$Const()));
      std.string ClassName = ClassDecl.getNameAsString();
      
      // Emit the symbol that is used to generate linker errors if this class is
      // referenced in other modules but not declared.
      std.string classSymbolName = $add_T$C$P_string$C(/*KEEP_STR*/"__objc_class_name_", ClassName);
      {
        GlobalVariable /*P*/ symbol = TheModule.getGlobalVariable(new StringRef(classSymbolName));
        if ((symbol != null)) {
          symbol.setInitializer(ConstantInt.get(LongTy, $int2ulong(0)));
        } else {
          /*NEW_EXPR [GlobalVariable::new]*/GlobalVariable.$new_GlobalVariable((type$ptr<?> New$Mem)->{
              return new GlobalVariable(TheModule, LongTy, false, 
              GlobalValue.LinkageTypes.ExternalLinkage, 
              ConstantInt.get(LongTy, $int2ulong(0)), 
              new Twine(classSymbolName));
           });
        }
      }
      
      // Get the size of instances.
      int instanceSize = $long2int(Context.getASTObjCImplementationLayout(OID).getSize().getQuantity());
      
      // Collect information about instance variables.
      SmallVector<Constant /*P*/ > IvarNames/*J*/= new SmallVector<Constant /*P*/ >(16, (Constant /*P*/ )null);
      SmallVector<Constant /*P*/ > IvarTypes/*J*/= new SmallVector<Constant /*P*/ >(16, (Constant /*P*/ )null);
      SmallVector<Constant /*P*/ > IvarOffsets/*J*/= new SmallVector<Constant /*P*/ >(16, (Constant /*P*/ )null);
      
      IvarOffsetValues/*J*/= new std.vector<Constant /*P*/ >((Constant /*P*/ )null);
      SmallVectorBool WeakIvars/*J*/= new SmallVectorBool(16, false);
      SmallVectorBool StrongIvars/*J*/= new SmallVectorBool(16, false);
      
      int superInstanceSize = $llong2int(!(SuperClassDecl != null) ? 0 : Context.getASTObjCInterfaceLayout(SuperClassDecl).getSize().getQuantity());
      // For non-fragile ivars, set the instance size to 0 - {the size of just this
      // class}.  The runtime will then set this to the correct value on load.
      if (CGM.getLangOpts().ObjCRuntime.isNonFragile()) {
        instanceSize = 0 - (instanceSize - superInstanceSize);
      }
      
      for (/*const*/ ObjCIvarDecl /*P*/ IVD = ClassDecl.all_declared_ivar_begin(); (IVD != null);
           IVD = IVD.getNextIvar$Const()) {
        // Store the name
        IvarNames.push_back(MakeConstantString(IVD.getNameAsString()));
        // Get the type encoding for this ivar
        std.string TypeStr/*J*/= new std.string();
        Context.getObjCEncodingForType(IVD.getType(), TypeStr);
        IvarTypes.push_back(MakeConstantString(TypeStr));
        // Get the offset
        long/*uint64_t*/ BaseOffset = ComputeIvarBaseOffset(CGM, OID, IVD);
        long/*uint64_t*/ Offset = BaseOffset;
        if (CGM.getLangOpts().ObjCRuntime.isNonFragile()) {
          Offset = BaseOffset - $int2ullong(superInstanceSize);
        }
        Constant /*P*/ OffsetValue = ConstantInt.get(IntTy, Offset);
        // Create the direct offset value
        std.string OffsetName = $add_string($add_string_T$C$P($add_T$C$P_string$C(/*KEEP_STR*/"__objc_ivar_offset_value_", ClassName), /*KEEP_STR*/"."), 
            IVD.getNameAsString());
        GlobalVariable /*P*/ OffsetVar = TheModule.getGlobalVariable(new StringRef(OffsetName));
        if ((OffsetVar != null)) {
          OffsetVar.setInitializer(OffsetValue);
          // If this is the real definition, change its linkage type so that
          // different modules will use this one, rather than their private
          // copy.
          OffsetVar.setLinkage(GlobalValue.LinkageTypes.ExternalLinkage);
        } else {
          ObjCIvarDecl /*P*/ IVD_final = IVD;
          OffsetVar = /*NEW_EXPR [GlobalVariable::new]*/GlobalVariable.$new_GlobalVariable((type$ptr<?> New$Mem)->{
              return new GlobalVariable(TheModule, IntTy, 
              false, GlobalValue.LinkageTypes.ExternalLinkage, 
              OffsetValue, 
              new Twine($add_string($add_string_T$C$P($add_T$C$P_string$C(/*KEEP_STR*/"__objc_ivar_offset_value_", ClassName), /*KEEP_STR*/"."), 
                      IVD_final.getNameAsString())));
           });
        }
        IvarOffsets.push_back(OffsetValue);
        IvarOffsetValues.push_back_T$RR(OffsetVar);
        Qualifiers.ObjCLifetime lt = IVD.getType().getQualifiers().getObjCLifetime();
        switch (lt) {
         case OCL_Strong:
          StrongIvars.push_back(true);
          WeakIvars.push_back(false);
          break;
         case OCL_Weak:
          StrongIvars.push_back(false);
          WeakIvars.push_back(true);
          break;
         default:
          StrongIvars.push_back(false);
          WeakIvars.push_back(false);
        }
      }
      Constant /*P*/ StrongIvarBitmap = MakeBitField(new ArrayRefBool(StrongIvars));
      Constant /*P*/ WeakIvarBitmap = MakeBitField(new ArrayRefBool(WeakIvars));
      GlobalVariable /*P*/ IvarOffsetArray = MakeGlobalArray(PtrToIntTy, new ArrayRef<Constant /*P*/ >(IvarOffsetValues, true), CGM.getPointerAlign(), 
          new StringRef(/*KEEP_STR*/".ivar.offsets"));
      
      // Collect information about instance methods
      SmallVector<Selector> InstanceMethodSels/*J*/= new SmallVector<Selector>(16, new Selector());
      SmallVector<Constant /*P*/ > InstanceMethodTypes/*J*/= new SmallVector<Constant /*P*/ >(16, (Constant /*P*/ )null);
      for (/*const*/ ObjCMethodDecl /*P*/ I : OID.instance_methods()) {
        InstanceMethodSels.push_back(I.getSelector());
        std.string TypeStr/*J*/= new std.string();
        Context.getObjCEncodingForMethodDecl(I, TypeStr);
        InstanceMethodTypes.push_back(MakeConstantString(TypeStr));
      }
      
      Constant /*P*/ Properties = GeneratePropertyList(OID, InstanceMethodSels, 
          InstanceMethodTypes);
      
      // Collect information about class methods
      SmallVector<Selector> ClassMethodSels/*J*/= new SmallVector<Selector>(16, new Selector());
      SmallVector<Constant /*P*/ > ClassMethodTypes/*J*/= new SmallVector<Constant /*P*/ >(16, (Constant /*P*/ )null);
      for (/*const*/ ObjCMethodDecl /*P*/ I : OID.class_methods()) {
        ClassMethodSels.push_back(I.getSelector());
        std.string TypeStr/*J*/= new std.string();
        Context.getObjCEncodingForMethodDecl(I, TypeStr);
        ClassMethodTypes.push_back(MakeConstantString(TypeStr));
      }
      // Collect the names of referenced protocols
      SmallVector<std.string> Protocols/*J*/= new SmallVector<std.string>(16, new std.string());
      for (/*const*/ ObjCProtocolDecl /*P*/ I : ClassDecl.protocols())  {
        Protocols.push_back_T$RR(I.getNameAsString());
      }
      
      // Get the superclass pointer.
      Constant /*P*/ SuperClass;
      if (!SuperClassName.empty()) {
        SuperClass = MakeConstantString(SuperClassName, new std.string(JD$T$C$P_T2$C$R.INSTANCE, /*KEEP_STR*/".super_class_name"));
      } else {
        SuperClass = ConstantPointerNull.get(PtrToInt8Ty);
      }
      // Empty vector used to construct empty method lists
      SmallVector<Constant /*P*/ > empty/*J*/= new SmallVector<Constant /*P*/ >(1, (Constant /*P*/ )null);
      // Generate the method and instance variable lists
      Constant /*P*/ MethodList = GenerateMethodList(new StringRef(ClassName), new StringRef(/*KEEP_STR*/$EMPTY), 
          new ArrayRef<Selector>(InstanceMethodSels, false), new ArrayRef<Constant /*P*/ >(InstanceMethodTypes, true), false);
      Constant /*P*/ ClassMethodList = GenerateMethodList(new StringRef(ClassName), new StringRef(/*KEEP_STR*/$EMPTY), 
          new ArrayRef<Selector>(ClassMethodSels, false), new ArrayRef<Constant /*P*/ >(ClassMethodTypes, true), true);
      Constant /*P*/ IvarList = GenerateIvarList(new ArrayRef<Constant /*P*/ >(IvarNames, true), new ArrayRef<Constant /*P*/ >(IvarTypes, true), 
          new ArrayRef<Constant /*P*/ >(IvarOffsets, true));
      // Irrespective of whether we are compiling for a fragile or non-fragile ABI,
      // we emit a symbol containing the offset for each ivar in the class.  This
      // allows code compiled for the non-Fragile ABI to inherit from code compiled
      // for the legacy ABI, without causing problems.  The converse is also
      // possible, but causes all ivar accesses to be fragile.
      
      // Offset pointer for getting at the correct field in the ivar list when
      // setting up the alias.  These are: The base address for the global, the
      // ivar array (second field), the ivar in this list (set for each ivar), and
      // the offset (third field in ivar structure)
      org.llvm.ir.Type /*P*/ IndexTy = Int32Ty;
      Constant /*P*/ offsetPointerIndexes[/*4*/] = new Constant /*P*/  [/*4*/] {
        Zeros[0], 
        ConstantInt.get(IndexTy, $int2ulong(1)), null, 
        ConstantInt.get(IndexTy, $int2ulong(2))};
      
      /*uint*/int ivarIndex = 0;
      for (/*const*/ ObjCIvarDecl /*P*/ IVD = ClassDecl.all_declared_ivar_begin(); (IVD != null);
           IVD = IVD.getNextIvar$Const()) {
        /*const*/std.string Name = $add_string($add_string_T($add_T$C$P_string$C(/*KEEP_STR*/"__objc_ivar_offset_", ClassName), $$DOT), 
            IVD.getNameAsString());
        offsetPointerIndexes[2] = ConstantInt.get(IndexTy, $uint2ulong(ivarIndex));
        // Get the correct ivar field
        Constant /*P*/ offsetValue = ConstantExpr.getGetElementPtr_Type$P_Constant$P_ArrayRef$Constant$P_bool_Type$P(cast_GlobalVariable(IvarList).getValueType(), IvarList, 
            new ArrayRef<Constant /*P*/ >(offsetPointerIndexes, true));
        // Get the existing variable, if one exists.
        GlobalVariable /*P*/ offset = TheModule.getNamedGlobal(new StringRef(Name));
        if ((offset != null)) {
          offset.setInitializer(offsetValue);
          // If this is the real definition, change its linkage type so that
          // different modules will use this one, rather than their private
          // copy.
          offset.setLinkage(GlobalValue.LinkageTypes.ExternalLinkage);
        } else {
          // Add a new alias if there isn't one already.
          offset = /*NEW_EXPR [GlobalVariable::new]*/GlobalVariable.$new_GlobalVariable((type$ptr<?> New$Mem)->{
              return new GlobalVariable(TheModule, offsetValue.getType(), 
              false, GlobalValue.LinkageTypes.ExternalLinkage, offsetValue, new Twine(Name));
           });
          ///*J:(void)*/offset; // Silence dead store warning.
        }
        ++ivarIndex;
      }
      Constant /*P*/ ZeroPtr = ConstantInt.get(IntPtrTy, $int2ulong(0));
      
      //Generate metaclass for class methods
      Constant /*P*/ MetaClassStruct = GenerateClassStructure(NULLPtr, NULLPtr, (int)0x12L/*L*/, ClassName.c_str(), (Constant /*P*/ )null, Zeros[0], 
          GenerateIvarList(new ArrayRef<Constant /*P*/ >(empty, true), new ArrayRef<Constant /*P*/ >(empty, true), new ArrayRef<Constant /*P*/ >(empty, true)), ClassMethodList, NULLPtr, NULLPtr, 
          NULLPtr, ZeroPtr, ZeroPtr, true);
      if (CGM.getTriple().isOSBinFormatCOFF()) {
        GlobalValue.DLLStorageClassTypes Storage = GlobalValue.DLLStorageClassTypes.DefaultStorageClass;
        if (OID.getClassInterface$Const().hasAttr(DLLImportAttr.class)) {
          Storage = GlobalValue.DLLStorageClassTypes.DLLImportStorageClass;
        } else if (OID.getClassInterface$Const().hasAttr(DLLExportAttr.class)) {
          Storage = GlobalValue.DLLStorageClassTypes.DLLExportStorageClass;
        }
        cast_GlobalValue(MetaClassStruct).setDLLStorageClass(Storage);
      }
      
      // Generate the class structure
      Constant /*P*/ ClassStruct = GenerateClassStructure(MetaClassStruct, SuperClass, (int)0x11L/*L*/, ClassName.c_str(), (Constant /*P*/ )null, 
          ConstantInt.get(LongTy, $int2ulong(instanceSize)), IvarList, MethodList, 
          GenerateProtocolList(new ArrayRef<std.string>(Protocols, false)), IvarOffsetArray, Properties, 
          StrongIvarBitmap, WeakIvarBitmap);
      if (CGM.getTriple().isOSBinFormatCOFF()) {
        GlobalValue.DLLStorageClassTypes Storage = GlobalValue.DLLStorageClassTypes.DefaultStorageClass;
        if (OID.getClassInterface$Const().hasAttr(DLLImportAttr.class)) {
          Storage = GlobalValue.DLLStorageClassTypes.DLLImportStorageClass;
        } else if (OID.getClassInterface$Const().hasAttr(DLLExportAttr.class)) {
          Storage = GlobalValue.DLLStorageClassTypes.DLLExportStorageClass;
        }
        cast_GlobalValue(ClassStruct).setDLLStorageClass(Storage);
      }
      
      // Resolve the class aliases, if they exist.
      if ((ClassPtrAlias != null)) {
        ClassPtrAlias.replaceAllUsesWith(ConstantExpr.getBitCast(ClassStruct, IdTy));
        ClassPtrAlias.eraseFromParent();
        ClassPtrAlias = null;
      }
      if ((MetaClassPtrAlias != null)) {
        MetaClassPtrAlias.replaceAllUsesWith(ConstantExpr.getBitCast(MetaClassStruct, IdTy));
        MetaClassPtrAlias.eraseFromParent();
        MetaClassPtrAlias = null;
      }
      
      // Add class structure to list to be added to the symtab later
      ClassStruct = ConstantExpr.getBitCast(ClassStruct, PtrToInt8Ty);
      Classes.push_back_T$C$R(ClassStruct);
    } finally {
      if (IvarOffsetValues != null) { IvarOffsetValues.$destroy(); }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGObjCGNU::RegisterAlias">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCGNU.cpp", line = 2187,
   FQN="(anonymous namespace)::CGObjCGNU::RegisterAlias", NM="_ZN12_GLOBAL__N_19CGObjCGNU13RegisterAliasEPKN5clang23ObjCCompatibleAliasDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCGNU.cpp -nm=_ZN12_GLOBAL__N_19CGObjCGNU13RegisterAliasEPKN5clang23ObjCCompatibleAliasDeclE")
  //</editor-fold>
  @Override public void RegisterAlias(/*const*/ ObjCCompatibleAliasDecl /*P*/ OAD)/* override*/ {
    // Get the class declaration for which the alias is specified.
    ObjCInterfaceDecl /*P*/ ClassDecl = ((/*const_cast*/ObjCInterfaceDecl /*P*/ )(OAD.getClassInterface$Const()));
    ClassAliases.emplace_back(new std.pairTypeType<std.string, std.string>(ClassDecl.getNameAsString(), OAD.getNameAsString()
    ));
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGObjCGNU::GenerateProtocolRef">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCGNU.cpp", line = 1787,
   FQN="(anonymous namespace)::CGObjCGNU::GenerateProtocolRef", NM="_ZN12_GLOBAL__N_19CGObjCGNU19GenerateProtocolRefERN5clang7CodeGen15CodeGenFunctionEPKNS1_16ObjCProtocolDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCGNU.cpp -nm=_ZN12_GLOBAL__N_19CGObjCGNU19GenerateProtocolRefERN5clang7CodeGen15CodeGenFunctionEPKNS1_16ObjCProtocolDeclE")
  //</editor-fold>
  @Override public Value /*P*/ GenerateProtocolRef(final CodeGenFunction /*&*/ CGF, 
                     /*const*/ ObjCProtocolDecl /*P*/ PD)/* override*/ {
    Value /*P*/ protocol = ExistingProtocols.$at(new StringRef(PD.getNameAsString()));
    org.llvm.ir.Type /*P*/ T = CGM.getTypes().ConvertType(CGM.getContext().getObjCProtoType());
    return CGF.Builder.CreateBitCast(protocol, org.llvm.ir.PointerType.getUnqual(T));
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGObjCGNU::GenerateProtocol">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCGNU.cpp", line = 1824,
   FQN="(anonymous namespace)::CGObjCGNU::GenerateProtocol", NM="_ZN12_GLOBAL__N_19CGObjCGNU16GenerateProtocolEPKN5clang16ObjCProtocolDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCGNU.cpp -nm=_ZN12_GLOBAL__N_19CGObjCGNU16GenerateProtocolEPKN5clang16ObjCProtocolDeclE")
  //</editor-fold>
  @Override public void GenerateProtocol(/*const*/ ObjCProtocolDecl /*P*/ PD)/* override*/ {
    std.vector<Constant /*P*/ > Properties = null;
    std.vector<Constant /*P*/ > OptionalProperties = null;
    try {
      final ASTContext /*&*/ Context = CGM.getContext();
      std.string ProtocolName = PD.getNameAsString();
      {
        
        // Use the protocol definition, if there is one.
        /*const*/ ObjCProtocolDecl /*P*/ Def = PD.getDefinition$Const();
        if ((Def != null)) {
          PD = Def;
        }
      }
      
      SmallVector<std.string> Protocols/*J*/= new SmallVector<std.string>(16, new std.string());
      for (/*const*/ ObjCProtocolDecl /*P*/ PI : PD.protocols())  {
        Protocols.push_back_T$RR(PI.getNameAsString());
      }
      SmallVector<Constant /*P*/ > InstanceMethodNames/*J*/= new SmallVector<Constant /*P*/ >(16, (Constant /*P*/ )null);
      SmallVector<Constant /*P*/ > InstanceMethodTypes/*J*/= new SmallVector<Constant /*P*/ >(16, (Constant /*P*/ )null);
      SmallVector<Constant /*P*/ > OptionalInstanceMethodNames/*J*/= new SmallVector<Constant /*P*/ >(16, (Constant /*P*/ )null);
      SmallVector<Constant /*P*/ > OptionalInstanceMethodTypes/*J*/= new SmallVector<Constant /*P*/ >(16, (Constant /*P*/ )null);
      for (/*const*/ ObjCMethodDecl /*P*/ I : PD.instance_methods()) {
        std.string TypeStr/*J*/= new std.string();
        Context.getObjCEncodingForMethodDecl(I, TypeStr);
        if (I.getImplementationControl() == ObjCMethodDecl.ImplementationControl.Optional) {
          OptionalInstanceMethodNames.push_back(MakeConstantString(I.getSelector().getAsString()));
          OptionalInstanceMethodTypes.push_back(MakeConstantString(TypeStr));
        } else {
          InstanceMethodNames.push_back(MakeConstantString(I.getSelector().getAsString()));
          InstanceMethodTypes.push_back(MakeConstantString(TypeStr));
        }
      }
      // Collect information about class methods:
      SmallVector<Constant /*P*/ > ClassMethodNames/*J*/= new SmallVector<Constant /*P*/ >(16, (Constant /*P*/ )null);
      SmallVector<Constant /*P*/ > ClassMethodTypes/*J*/= new SmallVector<Constant /*P*/ >(16, (Constant /*P*/ )null);
      SmallVector<Constant /*P*/ > OptionalClassMethodNames/*J*/= new SmallVector<Constant /*P*/ >(16, (Constant /*P*/ )null);
      SmallVector<Constant /*P*/ > OptionalClassMethodTypes/*J*/= new SmallVector<Constant /*P*/ >(16, (Constant /*P*/ )null);
      for (/*const*/ ObjCMethodDecl /*P*/ I : PD.class_methods()) {
        std.string TypeStr/*J*/= new std.string();
        Context.getObjCEncodingForMethodDecl(I, TypeStr);
        if (I.getImplementationControl() == ObjCMethodDecl.ImplementationControl.Optional) {
          OptionalClassMethodNames.push_back(MakeConstantString(I.getSelector().getAsString()));
          OptionalClassMethodTypes.push_back(MakeConstantString(TypeStr));
        } else {
          ClassMethodNames.push_back(MakeConstantString(I.getSelector().getAsString()));
          ClassMethodTypes.push_back(MakeConstantString(TypeStr));
        }
      }
      
      Constant /*P*/ ProtocolList = GenerateProtocolList(new ArrayRef<std.string>(Protocols, false));
      Constant /*P*/ InstanceMethodList = GenerateProtocolMethodList(new ArrayRef<Constant /*P*/ >(InstanceMethodNames, true), new ArrayRef<Constant /*P*/ >(InstanceMethodTypes, true));
      Constant /*P*/ ClassMethodList = GenerateProtocolMethodList(new ArrayRef<Constant /*P*/ >(ClassMethodNames, true), new ArrayRef<Constant /*P*/ >(ClassMethodTypes, true));
      Constant /*P*/ OptionalInstanceMethodList = GenerateProtocolMethodList(new ArrayRef<Constant /*P*/ >(OptionalInstanceMethodNames, true), 
          new ArrayRef<Constant /*P*/ >(OptionalInstanceMethodTypes, true));
      Constant /*P*/ OptionalClassMethodList = GenerateProtocolMethodList(new ArrayRef<Constant /*P*/ >(OptionalClassMethodNames, true), 
          new ArrayRef<Constant /*P*/ >(OptionalClassMethodTypes, true));
      
      // Property metadata: name, attributes, isSynthesized, setter name, setter
      // types, getter name, getter types.
      // The isSynthesized value is always set to 0 in a protocol.  It exists to
      // simplify the runtime library by allowing it to use the same data
      // structures for protocol metadata everywhere.
      StructType /*P*/ PropertyMetadataTy = StructType.get(PtrToInt8Ty, Int8Ty, Int8Ty, Int8Ty, Int8Ty, PtrToInt8Ty, 
          PtrToInt8Ty, PtrToInt8Ty, PtrToInt8Ty, null);
      Properties/*J*/= new std.vector<Constant /*P*/ >((Constant /*P*/ )null);
      OptionalProperties/*J*/= new std.vector<Constant /*P*/ >((Constant /*P*/ )null);
      
      // Add all of the property methods need adding to the method list and to the
      // property metadata list.
      for (ObjCPropertyDecl /*P*/ property : PD.instance_properties()) {
        std.vector<Constant /*P*/ > Fields = null;
        try {
          Fields/*J*/= new std.vector<Constant /*P*/ >((Constant /*P*/ )null);
          
          Fields.push_back_T$RR(MakePropertyEncodingString(property, (/*const*/ Decl /*P*/ )null));
          PushPropertyAttributes(Fields, property);
          {
            
            ObjCMethodDecl /*P*/ getter = property.getGetterMethodDecl();
            if ((getter != null)) {
              std.string TypeStr/*J*/= new std.string();
              Context.getObjCEncodingForMethodDecl(getter, TypeStr);
              Constant /*P*/ TypeEncoding = MakeConstantString(TypeStr);
              InstanceMethodTypes.push_back(TypeEncoding);
              Fields.push_back_T$RR(MakeConstantString(getter.getSelector().getAsString()));
              Fields.push_back_T$C$R(TypeEncoding);
            } else {
              Fields.push_back_T$C$R(NULLPtr);
              Fields.push_back_T$C$R(NULLPtr);
            }
          }
          {
            ObjCMethodDecl /*P*/ setter = property.getSetterMethodDecl();
            if ((setter != null)) {
              std.string TypeStr/*J*/= new std.string();
              Context.getObjCEncodingForMethodDecl(setter, TypeStr);
              Constant /*P*/ TypeEncoding = MakeConstantString(TypeStr);
              InstanceMethodTypes.push_back(TypeEncoding);
              Fields.push_back_T$RR(MakeConstantString(setter.getSelector().getAsString()));
              Fields.push_back_T$C$R(TypeEncoding);
            } else {
              Fields.push_back_T$C$R(NULLPtr);
              Fields.push_back_T$C$R(NULLPtr);
            }
          }
          if (property.getPropertyImplementation() == ObjCPropertyDecl.PropertyControl.Optional) {
            OptionalProperties.push_back_T$RR(ConstantStruct.get(PropertyMetadataTy, new ArrayRef<Constant /*P*/ >(Fields, true)));
          } else {
            Properties.push_back_T$RR(ConstantStruct.get(PropertyMetadataTy, new ArrayRef<Constant /*P*/ >(Fields, true)));
          }
        } finally {
          if (Fields != null) { Fields.$destroy(); }
        }
      }
      Constant /*P*/ PropertyArray = ConstantArray.get(org.llvm.ir.ArrayType.get(PropertyMetadataTy, $uint2ulong(Properties.size())), new ArrayRef<Constant /*P*/ >(Properties, true));
      Constant /*P*/ PropertyListInitFields[/*3*/] = new Constant /*P*/  [/*3*/] {ConstantInt.get(IntTy, $uint2ulong(Properties.size())), NULLPtr, PropertyArray};
      
      Constant /*P*/ PropertyListInit = ConstantStruct.getAnon(new ArrayRef<Constant /*P*/ >(PropertyListInitFields, true));
      Constant /*P*/ PropertyList = /*NEW_EXPR [GlobalVariable::new]*/GlobalVariable.$new_GlobalVariable((type$ptr<?> New$Mem)->{
          return new GlobalVariable(TheModule, 
          PropertyListInit.getType(), false, GlobalValue.LinkageTypes.InternalLinkage, 
          PropertyListInit, new Twine(/*KEEP_STR*/".objc_property_list"));
       });
      
      Constant /*P*/ OptionalPropertyArray = ConstantArray.get(org.llvm.ir.ArrayType.get(PropertyMetadataTy, 
              $uint2ulong(OptionalProperties.size())), new ArrayRef<Constant /*P*/ >(OptionalProperties, true));
      Constant /*P*/ OptionalPropertyListInitFields[/*3*/] = new Constant /*P*/  [/*3*/] {
        ConstantInt.get(IntTy, $uint2ulong(OptionalProperties.size())), NULLPtr, 
        OptionalPropertyArray};
      
      Constant /*P*/ OptionalPropertyListInit = ConstantStruct.getAnon(new ArrayRef<Constant /*P*/ >(OptionalPropertyListInitFields, true));
      Constant /*P*/ OptionalPropertyList = /*NEW_EXPR [GlobalVariable::new]*/GlobalVariable.$new_GlobalVariable((type$ptr<?> New$Mem)->{
          return new GlobalVariable(TheModule, 
          OptionalPropertyListInit.getType(), false, 
          GlobalValue.LinkageTypes.InternalLinkage, OptionalPropertyListInit, 
          new Twine(/*KEEP_STR*/".objc_property_list"));
       });
      
      // Protocols are objects containing lists of the methods implemented and
      // protocols adopted.
      StructType /*P*/ ProtocolTy = StructType.get(IdTy, 
          PtrToInt8Ty, 
          ProtocolList.getType(), 
          InstanceMethodList.getType(), 
          ClassMethodList.getType(), 
          OptionalInstanceMethodList.getType(), 
          OptionalClassMethodList.getType(), 
          PropertyList.getType(), 
          OptionalPropertyList.getType(), 
          null);
      // The isa pointer must be set to a magic number so the runtime knows it's
      // the correct layout.
      Constant /*P*/ Elements[/*9*/] = new Constant /*P*/  [/*9*/] {
        ConstantExpr.getIntToPtr(ConstantInt.get(Int32Ty, $int2ulong(ProtocolVersion)), IdTy), 
        MakeConstantString(ProtocolName, new std.string(JD$T$C$P_T2$C$R.INSTANCE, /*KEEP_STR*/".objc_protocol_name")), ProtocolList, 
        InstanceMethodList, ClassMethodList, OptionalInstanceMethodList, 
        OptionalClassMethodList, PropertyList, OptionalPropertyList};
      ExistingProtocols.$set(new StringRef(ProtocolName), 
        ConstantExpr.getBitCast(MakeGlobal_StructType$P_ArrayRef$Constant$P_CharUnits_StringRef_LinkageTypes(ProtocolTy, new ArrayRef<Constant /*P*/ >(Elements, true), 
              CGM.getPointerAlign(), new StringRef(/*KEEP_STR*/".objc_protocol")), IdTy));
    } finally {
      if (OptionalProperties != null) { OptionalProperties.$destroy(); }
      if (Properties != null) { Properties.$destroy(); }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGObjCGNU::ModuleInitFunction">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCGNU.cpp", line = 2433,
   FQN="(anonymous namespace)::CGObjCGNU::ModuleInitFunction", NM="_ZN12_GLOBAL__N_19CGObjCGNU18ModuleInitFunctionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCGNU.cpp -nm=_ZN12_GLOBAL__N_19CGObjCGNU18ModuleInitFunctionEv")
  //</editor-fold>
  @Override public Function /*P*/ ModuleInitFunction()/* override*/ {
    std.vector<Constant /*P*/ > Elements = null;
    std.vector<Constant /*P*/ > Selectors = null;
    std.vector<GlobalAlias /*P*/ > SelectorAliases = null;
    DataLayout td = null;
    CGBuilderTy Builder = null;
    try {
      // Only emit an ObjC load function if no Objective-C stuff has been called
      if (Classes.empty() && Categories.empty() && ConstantStrings.empty()
         && ExistingProtocols.empty() && SelectorTable.empty()) {
        return null;
      }
      
      // Add all referenced protocols to a category.
      GenerateProtocolHolderCategory();
      
      StructType /*P*/ SelStructTy = dyn_cast_StructType(SelectorTy.getElementType());
      org.llvm.ir.Type /*P*/ SelStructPtrTy = SelectorTy;
      if (!(SelStructTy != null)) {
        SelStructTy = StructType.get(PtrToInt8Ty, PtrToInt8Ty, null);
        SelStructPtrTy = org.llvm.ir.PointerType.getUnqual(SelStructTy);
      }
      
      Elements/*J*/= new std.vector<Constant /*P*/ >((Constant /*P*/ )null);
      Constant /*P*/ Statics = NULLPtr;
      // Generate statics list:
      if (!ConstantStrings.empty()) {
        org.llvm.ir.ArrayType /*P*/ StaticsArrayTy = org.llvm.ir.ArrayType.get(PtrToInt8Ty, 
            $uint2ulong(ConstantStrings.size() + 1));
        ConstantStrings.push_back_T$C$R(NULLPtr);
        
        StringRef StringClass = new StringRef(CGM.getLangOpts().ObjCConstantStringClass);
        if (StringClass.empty()) {
          StringClass.$assignMove(/*STRINGREF_STR*/"NXConstantString");
        }
        
        Elements.push_back_T$RR(MakeConstantString(StringClass.$string(), 
                new std.string(JD$T$C$P_T2$C$R.INSTANCE, /*KEEP_STR*/".objc_static_class_name")));
        Elements.push_back_T$RR(ConstantArray.get(StaticsArrayTy, 
                new ArrayRef<Constant /*P*/ >(ConstantStrings, true)));
        StructType /*P*/ StaticsListTy = StructType.get(PtrToInt8Ty, StaticsArrayTy, null);
        org.llvm.ir.Type /*P*/ StaticsListPtrTy = org.llvm.ir.PointerType.getUnqual(StaticsListTy);
        Statics = MakeGlobal_StructType$P_ArrayRef$Constant$P_CharUnits_StringRef_LinkageTypes(StaticsListTy, new ArrayRef<Constant /*P*/ >(Elements, true), CGM.getPointerAlign(), 
            new StringRef(/*KEEP_STR*/".objc_statics"));
        org.llvm.ir.ArrayType /*P*/ StaticsListArrayTy = org.llvm.ir.ArrayType.get(StaticsListPtrTy, $int2ulong(2));
        Elements.clear();
        Elements.push_back_T$C$R(Statics);
        Elements.push_back_T$RR(Constant.getNullValue(StaticsListPtrTy));
        Statics = MakeGlobal_ArrayType$P_ArrayRef$Constant$P_CharUnits_StringRef_LinkageTypes(StaticsListArrayTy, new ArrayRef<Constant /*P*/ >(Elements, true), 
            CGM.getPointerAlign(), new StringRef(/*KEEP_STR*/".objc_statics_ptr"));
        Statics = ConstantExpr.getBitCast(Statics, PtrTy);
      }
      // Array of classes, categories, and constant objects
      org.llvm.ir.ArrayType /*P*/ ClassListTy = org.llvm.ir.ArrayType.get(PtrToInt8Ty, 
          $uint2ulong(Classes.size() + Categories.size() + 2));
      StructType /*P*/ SymTabTy = StructType.get(LongTy, SelStructPtrTy, 
          org.llvm.ir.Type.getInt16Ty(VMContext), 
          org.llvm.ir.Type.getInt16Ty(VMContext), 
          ClassListTy, null);
      
      Elements.clear();
      // Pointer to an array of selectors used in this module.
      Selectors/*J*/= new std.vector<Constant /*P*/ >((Constant /*P*/ )null);
      SelectorAliases/*J*/= new std.vector<GlobalAlias /*P*/ >((GlobalAlias /*P*/ )null);
      for (DenseMapIterator<Selector, SmallVector<std.pairTypePtr<std.string, GlobalAlias /*P*/ >>> iter = SelectorTable.begin(), 
          iterEnd = SelectorTable.end(); iter.$noteq(/*NO_ITER_COPY*/iterEnd); iter.$preInc()) {
        
        std.string SelNameStr = iter.$arrow().first.getAsString();
        Constant /*P*/ SelName = ExportUniqueString(SelNameStr, new std.string(JD$T$C$P_T2$C$R.INSTANCE, /*KEEP_STR*/".objc_sel_name"));
        
        final SmallVectorImpl<std.pairTypePtr<std.string, GlobalAlias /*P*/ > > /*&*/ Types = iter.$arrow().second;
        for (type$ptr<std.pairTypePtr<std.string, GlobalAlias /*P*/ >> i = $tryClone(Types.begin()), 
            /*P*/ e = $tryClone(Types.end()); $noteq_ptr(i, e); i.$postInc()) {
          
          Constant /*P*/ SelectorTypeEncoding = NULLPtr;
          if (!i./*->*/$star().first.empty()) {
            SelectorTypeEncoding = MakeConstantString(i./*->*/$star().first, new std.string(JD$T$C$P_T2$C$R.INSTANCE, /*KEEP_STR*/".objc_sel_types"));
          }
          
          Elements.push_back_T$C$R(SelName);
          Elements.push_back_T$C$R(SelectorTypeEncoding);
          Selectors.push_back_T$RR(ConstantStruct.get(SelStructTy, new ArrayRef<Constant /*P*/ >(Elements, true)));
          Elements.clear();
          
          // Store the selector alias for later replacement
          SelectorAliases.push_back_T$C$R(i./*->*/$star().second);
        }
      }
      /*uint*/int SelectorCount = Selectors.size();
      // NULL-terminate the selector list.  This should not actually be required,
      // because the selector list has a length field.  Unfortunately, the GCC
      // runtime decides to ignore the length field and expects a NULL terminator,
      // and GCC cooperates with this by always setting the length to 0.
      Elements.push_back_T$C$R(NULLPtr);
      Elements.push_back_T$C$R(NULLPtr);
      Selectors.push_back_T$RR(ConstantStruct.get(SelStructTy, new ArrayRef<Constant /*P*/ >(Elements, true)));
      Elements.clear();
      
      // Number of static selectors
      Elements.push_back_T$RR(ConstantInt.get(LongTy, $uint2ulong(SelectorCount)));
      GlobalVariable /*P*/ SelectorList = MakeGlobalArray(SelStructTy, new ArrayRef<Constant /*P*/ >(Selectors, true), CGM.getPointerAlign(), 
          new StringRef(/*KEEP_STR*/".objc_selector_list"));
      Elements.push_back_T$RR(ConstantExpr.getBitCast(SelectorList, 
              SelStructPtrTy));
      
      // Now that all of the static selectors exist, create pointers to them.
      for (/*uint*/int i = 0; $less_uint(i, SelectorCount); i++) {
        
        Constant /*P*/ Idxs[/*3*/] = new Constant /*P*/  [/*3*/] {
          Zeros[0], 
          ConstantInt.get(Int32Ty, $uint2ulong(i)), Zeros[0]};
        // FIXME: We're generating redundant loads and stores here!
        Constant /*P*/ SelPtr = ConstantExpr.getGetElementPtr_Type$P_Constant$P_ArrayRef$Constant$P_bool_Type$P(SelectorList.getValueType(), SelectorList, makeArrayRef(create_type$ptr(Idxs), 2, true));
        // If selectors are defined as an opaque type, cast the pointer to this
        // type.
        SelPtr = ConstantExpr.getBitCast(SelPtr, SelectorTy);
        SelectorAliases.$at(i).replaceAllUsesWith(SelPtr);
        SelectorAliases.$at(i).eraseFromParent();
      }
      
      // Number of classes defined.
      Elements.push_back_T$RR(ConstantInt.get(org.llvm.ir.Type.getInt16Ty(VMContext), 
              $uint2ulong(Classes.size())));
      // Number of categories defined
      Elements.push_back_T$RR(ConstantInt.get(org.llvm.ir.Type.getInt16Ty(VMContext), 
              $uint2ulong(Categories.size())));
      // Create an array of classes, then categories, then static object instances
      Classes.insert$T(new std.vector.iterator</*const*/ Constant /*P*/ >(Classes.end()), Categories.begin(), Categories.end());
      //  NULL-terminated list of static object instances (mainly constant strings)
      Classes.push_back_T$C$R(Statics);
      Classes.push_back_T$C$R(NULLPtr);
      Constant /*P*/ ClassList = ConstantArray.get(ClassListTy, new ArrayRef<Constant /*P*/ >(Classes, true));
      Elements.push_back_T$C$R(ClassList);
      // Construct the symbol table
      Constant /*P*/ SymTab = MakeGlobal_StructType$P_ArrayRef$Constant$P_CharUnits_StringRef_LinkageTypes(SymTabTy, new ArrayRef<Constant /*P*/ >(Elements, true), CGM.getPointerAlign());
      
      // The symbol table is contained in a module which has some version-checking
      // constants
      StructType /*P*/ ModuleTy = StructType.get(LongTy, LongTy, 
          PtrToInt8Ty, org.llvm.ir.PointerType.getUnqual(SymTabTy), 
          (RuntimeVersion >= 10) ? IntTy : (IntegerType /*P*/ )null, null);
      Elements.clear();
      // Runtime version, used for ABI compatibility checking.
      Elements.push_back_T$RR(ConstantInt.get(LongTy, $int2ulong(RuntimeVersion)));
      // sizeof(ModuleTy)
      td/*J*/= new DataLayout($AddrOf(TheModule));
      Elements.push_back_T$RR(ConstantInt.get(LongTy, 
              $div_ulong(td.getTypeSizeInBits(ModuleTy)
                , CGM.getContext().getCharWidth())));
      
      // The path to the source file where this module was declared
      final SourceManager /*&*/ SM = CGM.getContext().getSourceManager();
      /*const*/ FileEntry /*P*/ mainFile = SM.getFileEntryForID(SM.getMainFileID());
      std.string _path = $add_string_T$C$P($add_string_T(new std.string(JD$T$C$P_T2$C$R.INSTANCE, mainFile.getDir().getName()), $$SLASH), mainFile.getName());
      Elements.push_back_T$RR(MakeConstantString(_path, new std.string(JD$T$C$P_T2$C$R.INSTANCE, /*KEEP_STR*/".objc_source_file_name")));
      Elements.push_back_T$C$R(SymTab);
      if (RuntimeVersion >= 10) {
        switch (CGM.getLangOpts().getGC()) {
         case GCOnly:
          Elements.push_back_T$RR(ConstantInt.get(IntTy, $int2ulong(2)));
          break;
         case NonGC:
          if (CGM.getLangOpts().ObjCAutoRefCount) {
            Elements.push_back_T$RR(ConstantInt.get(IntTy, $int2ulong(1)));
          } else {
            Elements.push_back_T$RR(ConstantInt.get(IntTy, $int2ulong(0)));
          }
          break;
         case HybridGC:
          Elements.push_back_T$RR(ConstantInt.get(IntTy, $int2ulong(1)));
          break;
        }
      }
      
      Value /*P*/ Module = MakeGlobal_StructType$P_ArrayRef$Constant$P_CharUnits_StringRef_LinkageTypes(ModuleTy, new ArrayRef<Constant /*P*/ >(Elements, true), CGM.getPointerAlign());
      
      // Create the load function calling the runtime entry point with the module
      // structure
      Function /*P*/ LoadFunction = Function.Create(org.llvm.ir.FunctionType.get(org.llvm.ir.Type.getVoidTy(VMContext), false), 
          GlobalValue.LinkageTypes.InternalLinkage, new Twine(/*KEEP_STR*/".objc_load_function"), 
          $AddrOf(TheModule));
      BasicBlock /*P*/ EntryBB = BasicBlock.Create(VMContext, new Twine(/*KEEP_STR*/"entry"), LoadFunction);
      Builder/*J*/= new CGBuilderTy(CGM, VMContext);
      Builder.SetInsertPoint(EntryBB);
      
      org.llvm.ir.FunctionType /*P*/ FT = org.llvm.ir.FunctionType.get(Builder.getVoidTy(), 
          new ArrayRef<org.llvm.ir.Type /*P*/ >(org.llvm.ir.PointerType.getUnqual(ModuleTy), true), true);
      Value /*P*/ Register = CGM.CreateRuntimeFunction(FT, new StringRef(/*KEEP_STR*/"__objc_exec_class"));
      Builder.CreateCall_Value$P_ArrayRef$Value$P_Twine$C_MDNode$P(Register, new ArrayRef<Value /*P*/ >(Module, true));
      if (!ClassAliases.empty()) {
        org.llvm.ir.Type /*P*/ ArgTypes[/*2*/] = new org.llvm.ir.Type /*P*/  [/*2*/] {PtrTy, PtrToInt8Ty};
        org.llvm.ir.FunctionType /*P*/ RegisterAliasTy = org.llvm.ir.FunctionType.get(Builder.getVoidTy(), 
            new ArrayRef<org.llvm.ir.Type /*P*/ >(ArgTypes, true), false);
        Function /*P*/ RegisterAlias = Function.Create(RegisterAliasTy, 
            GlobalValue.LinkageTypes.ExternalWeakLinkage, new Twine(/*KEEP_STR*/"class_registerAlias_np"), 
            $AddrOf(TheModule));
        BasicBlock /*P*/ AliasBB = BasicBlock.Create(VMContext, new Twine(/*KEEP_STR*/"alias"), LoadFunction);
        BasicBlock /*P*/ NoAliasBB = BasicBlock.Create(VMContext, new Twine(/*KEEP_STR*/"no_alias"), LoadFunction);
        
        // Branch based on whether the runtime provided class_registerAlias_np()
        Value /*P*/ HasRegisterAlias = Builder.CreateICmpNE(RegisterAlias, 
            Constant.getNullValue(RegisterAlias.getType()));
        Builder.CreateCondBr(HasRegisterAlias, AliasBB, NoAliasBB);
        
        // The true branch (has alias registration function):
        Builder.SetInsertPoint(AliasBB);
        // Emit alias registration calls:
        for (std.vector.iterator<std.pairTypeType<std.string, std.string> /*P*/> iter = ClassAliases.begin();
             $noteq___normal_iterator$C(iter, ClassAliases.end()); iter.$preInc()) {
          Constant /*P*/ TheClass = TheModule.getGlobalVariable(new StringRef(($add_T$C$P_string$C(/*KEEP_STR*/"_OBJC_CLASS_", iter.$arrow().first)).c_str()), 
              true);
          if ((TheClass != null)) {
            TheClass = ConstantExpr.getBitCast(TheClass, PtrTy);
            Builder.CreateCall_Function$P_ArrayRef$Value$P_Twine$C_MDNode$P(RegisterAlias, 
                /*{ */new ArrayRef<Value /*P*/ >(new Value /*P*/ /*const*/ [/*2*/] {TheClass, MakeConstantString(iter.$arrow().second)}, true)/* }*/);
          }
        }
        // Jump to end:
        Builder.CreateBr(NoAliasBB);
        
        // Missing alias registration function, just return from the function:
        Builder.SetInsertPoint(NoAliasBB);
      }
      Builder.CreateRetVoid();
      
      return LoadFunction;
    } finally {
      if (Builder != null) { Builder.$destroy(); }
      if (td != null) { td.$destroy(); }
      if (SelectorAliases != null) { SelectorAliases.$destroy(); }
      if (Selectors != null) { Selectors.$destroy(); }
      if (Elements != null) { Elements.$destroy(); }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGObjCGNU::GetPropertyGetFunction">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCGNU.cpp", line = 2691,
   FQN="(anonymous namespace)::CGObjCGNU::GetPropertyGetFunction", NM="_ZN12_GLOBAL__N_19CGObjCGNU22GetPropertyGetFunctionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCGNU.cpp -nm=_ZN12_GLOBAL__N_19CGObjCGNU22GetPropertyGetFunctionEv")
  //</editor-fold>
  @Override public Constant /*P*/ GetPropertyGetFunction()/* override*/ {
    return GetPropertyFn.$Constant$P();
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGObjCGNU::GetPropertySetFunction">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCGNU.cpp", line = 2695,
   FQN="(anonymous namespace)::CGObjCGNU::GetPropertySetFunction", NM="_ZN12_GLOBAL__N_19CGObjCGNU22GetPropertySetFunctionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCGNU.cpp -nm=_ZN12_GLOBAL__N_19CGObjCGNU22GetPropertySetFunctionEv")
  //</editor-fold>
  @Override public Constant /*P*/ GetPropertySetFunction()/* override*/ {
    return SetPropertyFn.$Constant$P();
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGObjCGNU::GetOptimizedPropertySetFunction">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCGNU.cpp", line = 2699,
   FQN="(anonymous namespace)::CGObjCGNU::GetOptimizedPropertySetFunction", NM="_ZN12_GLOBAL__N_19CGObjCGNU31GetOptimizedPropertySetFunctionEbb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCGNU.cpp -nm=_ZN12_GLOBAL__N_19CGObjCGNU31GetOptimizedPropertySetFunctionEbb")
  //</editor-fold>
  @Override public Constant /*P*/ GetOptimizedPropertySetFunction(boolean atomic, 
                                 boolean copy)/* override*/ {
    return null;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGObjCGNU::GetSetStructFunction">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCGNU.cpp", line = 2708,
   FQN="(anonymous namespace)::CGObjCGNU::GetSetStructFunction", NM="_ZN12_GLOBAL__N_19CGObjCGNU20GetSetStructFunctionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCGNU.cpp -nm=_ZN12_GLOBAL__N_19CGObjCGNU20GetSetStructFunctionEv")
  //</editor-fold>
  @Override public Constant /*P*/ GetSetStructFunction()/* override*/ {
    return SetStructPropertyFn.$Constant$P();
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGObjCGNU::GetGetStructFunction">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCGNU.cpp", line = 2704,
   FQN="(anonymous namespace)::CGObjCGNU::GetGetStructFunction", NM="_ZN12_GLOBAL__N_19CGObjCGNU20GetGetStructFunctionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCGNU.cpp -nm=_ZN12_GLOBAL__N_19CGObjCGNU20GetGetStructFunctionEv")
  //</editor-fold>
  @Override public Constant /*P*/ GetGetStructFunction()/* override*/ {
    return GetStructPropertyFn.$Constant$P();
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGObjCGNU::GetCppAtomicObjectGetFunction">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCGNU.cpp", line = 2712,
   FQN="(anonymous namespace)::CGObjCGNU::GetCppAtomicObjectGetFunction", NM="_ZN12_GLOBAL__N_19CGObjCGNU29GetCppAtomicObjectGetFunctionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCGNU.cpp -nm=_ZN12_GLOBAL__N_19CGObjCGNU29GetCppAtomicObjectGetFunctionEv")
  //</editor-fold>
  @Override public Constant /*P*/ GetCppAtomicObjectGetFunction()/* override*/ {
    return null;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGObjCGNU::GetCppAtomicObjectSetFunction">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCGNU.cpp", line = 2716,
   FQN="(anonymous namespace)::CGObjCGNU::GetCppAtomicObjectSetFunction", NM="_ZN12_GLOBAL__N_19CGObjCGNU29GetCppAtomicObjectSetFunctionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCGNU.cpp -nm=_ZN12_GLOBAL__N_19CGObjCGNU29GetCppAtomicObjectSetFunctionEv")
  //</editor-fold>
  @Override public Constant /*P*/ GetCppAtomicObjectSetFunction()/* override*/ {
    return null;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGObjCGNU::EnumerationMutationFunction">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCGNU.cpp", line = 2720,
   FQN="(anonymous namespace)::CGObjCGNU::EnumerationMutationFunction", NM="_ZN12_GLOBAL__N_19CGObjCGNU27EnumerationMutationFunctionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCGNU.cpp -nm=_ZN12_GLOBAL__N_19CGObjCGNU27EnumerationMutationFunctionEv")
  //</editor-fold>
  @Override public Constant /*P*/ EnumerationMutationFunction()/* override*/ {
    return EnumerationMutationFn.$Constant$P();
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGObjCGNU::EmitTryStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCGNU.cpp", line = 2730,
   FQN="(anonymous namespace)::CGObjCGNU::EmitTryStmt", NM="_ZN12_GLOBAL__N_19CGObjCGNU11EmitTryStmtERN5clang7CodeGen15CodeGenFunctionERKNS1_13ObjCAtTryStmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCGNU.cpp -nm=_ZN12_GLOBAL__N_19CGObjCGNU11EmitTryStmtERN5clang7CodeGen15CodeGenFunctionERKNS1_13ObjCAtTryStmtE")
  //</editor-fold>
  @Override public void EmitTryStmt(final CodeGenFunction /*&*/ CGF, 
             final /*const*/ ObjCAtTryStmt /*&*/ S)/* override*/ {
    // Unlike the Apple non-fragile runtimes, which also uses
    // unwind-based zero cost exceptions, the GNU Objective C runtime's
    // EH support isn't a veneer over C++ EH.  Instead, exception
    // objects are created by objc_exception_throw and destroyed by
    // the personality function; this avoids the need for bracketing
    // catch handlers with calls to __blah_begin_catch/__blah_end_catch
    // (or even _Unwind_DeleteException), but probably doesn't
    // interoperate very well with foreign exceptions.
    //
    // In Objective-C++ mode, we actually emit something equivalent to the C++
    // exception handler. 
    EmitTryCatchStmt(CGF, S, EnterCatchFn.$Constant$P(), ExitCatchFn.$Constant$P(), ExceptionReThrowFn.$Constant$P());
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGObjCGNU::EmitSynchronizedStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCGNU.cpp", line = 2724,
   FQN="(anonymous namespace)::CGObjCGNU::EmitSynchronizedStmt", NM="_ZN12_GLOBAL__N_19CGObjCGNU20EmitSynchronizedStmtERN5clang7CodeGen15CodeGenFunctionERKNS1_22ObjCAtSynchronizedStmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCGNU.cpp -nm=_ZN12_GLOBAL__N_19CGObjCGNU20EmitSynchronizedStmtERN5clang7CodeGen15CodeGenFunctionERKNS1_22ObjCAtSynchronizedStmtE")
  //</editor-fold>
  @Override public void EmitSynchronizedStmt(final CodeGenFunction /*&*/ CGF, 
                      final /*const*/ ObjCAtSynchronizedStmt /*&*/ S)/* override*/ {
    EmitAtSynchronizedStmt(CGF, S, SyncEnterFn.$Function$P(), SyncExitFn.$Function$P());
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGObjCGNU::EmitThrowStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCGNU.cpp", line = 2746,
   FQN="(anonymous namespace)::CGObjCGNU::EmitThrowStmt", NM="_ZN12_GLOBAL__N_19CGObjCGNU13EmitThrowStmtERN5clang7CodeGen15CodeGenFunctionERKNS1_15ObjCAtThrowStmtEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCGNU.cpp -nm=_ZN12_GLOBAL__N_19CGObjCGNU13EmitThrowStmtERN5clang7CodeGen15CodeGenFunctionERKNS1_15ObjCAtThrowStmtEb")
  //</editor-fold>
  @Override public void EmitThrowStmt(final CodeGenFunction /*&*/ CGF, 
               final /*const*/ ObjCAtThrowStmt /*&*/ S)/* override*/ {
    EmitThrowStmt(CGF, 
               S, 
               true);
  }
  @Override public void EmitThrowStmt(final CodeGenFunction /*&*/ CGF, 
               final /*const*/ ObjCAtThrowStmt /*&*/ S, 
               boolean ClearInsertionPoint/*= true*/)/* override*/ {
    Value /*P*/ ExceptionAsObject;
    {
      
      /*const*/ Expr /*P*/ ThrowExpr = S.getThrowExpr$Const();
      if ((ThrowExpr != null)) {
        Value /*P*/ Exception = CGF.EmitObjCThrowOperand(ThrowExpr);
        ExceptionAsObject = Exception;
      } else {
        assert ((!CGF.ObjCEHValueStack.empty() && (CGF.ObjCEHValueStack.back() != null))) : "Unexpected rethrow outside @catch block.";
        ExceptionAsObject = CGF.ObjCEHValueStack.back();
      }
    }
    ExceptionAsObject = CGF.Builder.CreateBitCast(ExceptionAsObject, IdTy);
    CallSite Throw = CGF.EmitRuntimeCallOrInvoke(ExceptionThrowFn.$Constant$P(), new ArrayRef<Value /*P*/ >(ExceptionAsObject, true));
    Throw.setDoesNotReturn();
    CGF.Builder.CreateUnreachable();
    if (ClearInsertionPoint) {
      CGF.Builder.ClearInsertionPoint();
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGObjCGNU::EmitObjCWeakRead">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCGNU.cpp", line = 2768,
   FQN="(anonymous namespace)::CGObjCGNU::EmitObjCWeakRead", NM="_ZN12_GLOBAL__N_19CGObjCGNU16EmitObjCWeakReadERN5clang7CodeGen15CodeGenFunctionENS2_7AddressE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCGNU.cpp -nm=_ZN12_GLOBAL__N_19CGObjCGNU16EmitObjCWeakReadERN5clang7CodeGen15CodeGenFunctionENS2_7AddressE")
  //</editor-fold>
  @Override public Value /*P*/ EmitObjCWeakRead(final CodeGenFunction /*&*/ CGF, 
                  Address AddrWeakObj)/* override*/ {
    final CGBuilderTy /*&*/ B = CGF.Builder;
    AddrWeakObj.$assignMove(EnforceType(B, new Address(AddrWeakObj), PtrToIdTy));
    return B.CreateCall(WeakReadFn.getType(), WeakReadFn.$Constant$P(), 
        new ArrayRef<Value /*P*/ >(AddrWeakObj.getPointer(), true));
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGObjCGNU::EmitObjCWeakAssign">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCGNU.cpp", line = 2776,
   FQN="(anonymous namespace)::CGObjCGNU::EmitObjCWeakAssign", NM="_ZN12_GLOBAL__N_19CGObjCGNU18EmitObjCWeakAssignERN5clang7CodeGen15CodeGenFunctionEPN4llvm5ValueENS2_7AddressE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCGNU.cpp -nm=_ZN12_GLOBAL__N_19CGObjCGNU18EmitObjCWeakAssignERN5clang7CodeGen15CodeGenFunctionEPN4llvm5ValueENS2_7AddressE")
  //</editor-fold>
  @Override public void EmitObjCWeakAssign(final CodeGenFunction /*&*/ CGF, 
                    Value /*P*/ src, Address dst)/* override*/ {
    final CGBuilderTy /*&*/ B = CGF.Builder;
    src = EnforceType(B, src, IdTy);
    dst.$assignMove(EnforceType(B, new Address(dst), PtrToIdTy));
    B.CreateCall(WeakAssignFn.getType(), WeakAssignFn.$Constant$P(), 
        /*{ */new ArrayRef<Value /*P*/ >(new Value /*P*/ /*const*/ [/*2*/] {src, dst.getPointer()}, true)/* }*/);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGObjCGNU::EmitObjCGlobalAssign">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCGNU.cpp", line = 2785,
   FQN="(anonymous namespace)::CGObjCGNU::EmitObjCGlobalAssign", NM="_ZN12_GLOBAL__N_19CGObjCGNU20EmitObjCGlobalAssignERN5clang7CodeGen15CodeGenFunctionEPN4llvm5ValueENS2_7AddressEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCGNU.cpp -nm=_ZN12_GLOBAL__N_19CGObjCGNU20EmitObjCGlobalAssignERN5clang7CodeGen15CodeGenFunctionEPN4llvm5ValueENS2_7AddressEb")
  //</editor-fold>
  @Override public void EmitObjCGlobalAssign(final CodeGenFunction /*&*/ CGF, 
                      Value /*P*/ src, Address dst)/* override*/ {
    EmitObjCGlobalAssign(CGF, 
                      src, dst, 
                      false);
  }
  @Override public void EmitObjCGlobalAssign(final CodeGenFunction /*&*/ CGF, 
                      Value /*P*/ src, Address dst, 
                      boolean threadlocal/*= false*/)/* override*/ {
    final CGBuilderTy /*&*/ B = CGF.Builder;
    src = EnforceType(B, src, IdTy);
    dst.$assignMove(EnforceType(B, new Address(dst), PtrToIdTy));
    // FIXME. Add threadloca assign API
    assert (!threadlocal) : "EmitObjCGlobalAssign - Threal Local API NYI";
    B.CreateCall(GlobalAssignFn.getType(), GlobalAssignFn.$Constant$P(), 
        /*{ */new ArrayRef<Value /*P*/ >(new Value /*P*/ /*const*/ [/*2*/] {src, dst.getPointer()}, true)/* }*/);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGObjCGNU::EmitObjCIvarAssign">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCGNU.cpp", line = 2797,
   FQN="(anonymous namespace)::CGObjCGNU::EmitObjCIvarAssign", NM="_ZN12_GLOBAL__N_19CGObjCGNU18EmitObjCIvarAssignERN5clang7CodeGen15CodeGenFunctionEPN4llvm5ValueENS2_7AddressES7_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCGNU.cpp -nm=_ZN12_GLOBAL__N_19CGObjCGNU18EmitObjCIvarAssignERN5clang7CodeGen15CodeGenFunctionEPN4llvm5ValueENS2_7AddressES7_")
  //</editor-fold>
  @Override public void EmitObjCIvarAssign(final CodeGenFunction /*&*/ CGF, 
                    Value /*P*/ src, Address dst, 
                    Value /*P*/ ivarOffset)/* override*/ {
    final CGBuilderTy /*&*/ B = CGF.Builder;
    src = EnforceType(B, src, IdTy);
    dst.$assignMove(EnforceType(B, new Address(dst), IdTy));
    B.CreateCall(IvarAssignFn.getType(), IvarAssignFn.$Constant$P(), 
        /*{ */new ArrayRef<Value /*P*/ >(new Value /*P*/ /*const*/ [/*3*/] {src, dst.getPointer(), ivarOffset}, true)/* }*/);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGObjCGNU::EmitObjCStrongCastAssign">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCGNU.cpp", line = 2807,
   FQN="(anonymous namespace)::CGObjCGNU::EmitObjCStrongCastAssign", NM="_ZN12_GLOBAL__N_19CGObjCGNU24EmitObjCStrongCastAssignERN5clang7CodeGen15CodeGenFunctionEPN4llvm5ValueENS2_7AddressE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCGNU.cpp -nm=_ZN12_GLOBAL__N_19CGObjCGNU24EmitObjCStrongCastAssignERN5clang7CodeGen15CodeGenFunctionEPN4llvm5ValueENS2_7AddressE")
  //</editor-fold>
  @Override public void EmitObjCStrongCastAssign(final CodeGenFunction /*&*/ CGF, 
                          Value /*P*/ src, Address dst)/* override*/ {
    final CGBuilderTy /*&*/ B = CGF.Builder;
    src = EnforceType(B, src, IdTy);
    dst.$assignMove(EnforceType(B, new Address(dst), PtrToIdTy));
    B.CreateCall(StrongCastAssignFn.getType(), StrongCastAssignFn.$Constant$P(), 
        /*{ */new ArrayRef<Value /*P*/ >(new Value /*P*/ /*const*/ [/*2*/] {src, dst.getPointer()}, true)/* }*/);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGObjCGNU::EmitGCMemmoveCollectable">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCGNU.cpp", line = 2816,
   FQN="(anonymous namespace)::CGObjCGNU::EmitGCMemmoveCollectable", NM="_ZN12_GLOBAL__N_19CGObjCGNU24EmitGCMemmoveCollectableERN5clang7CodeGen15CodeGenFunctionENS2_7AddressES5_PN4llvm5ValueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCGNU.cpp -nm=_ZN12_GLOBAL__N_19CGObjCGNU24EmitGCMemmoveCollectableERN5clang7CodeGen15CodeGenFunctionENS2_7AddressES5_PN4llvm5ValueE")
  //</editor-fold>
  @Override public void EmitGCMemmoveCollectable(final CodeGenFunction /*&*/ CGF, 
                          Address DestPtr, 
                          Address SrcPtr, 
                          Value /*P*/ Size)/* override*/ {
    final CGBuilderTy /*&*/ B = CGF.Builder;
    DestPtr.$assignMove(EnforceType(B, new Address(DestPtr), PtrTy));
    SrcPtr.$assignMove(EnforceType(B, new Address(SrcPtr), PtrTy));
    
    B.CreateCall(MemMoveFn.getType(), MemMoveFn.$Constant$P(), 
        /*{ */new ArrayRef<Value /*P*/ >(new Value /*P*/ /*const*/ [/*3*/] {DestPtr.getPointer(), SrcPtr.getPointer(), Size}, true)/* }*/);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGObjCGNU::EmitObjCValueForIvar">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCGNU.cpp", line = 2874,
   FQN="(anonymous namespace)::CGObjCGNU::EmitObjCValueForIvar", NM="_ZN12_GLOBAL__N_19CGObjCGNU20EmitObjCValueForIvarERN5clang7CodeGen15CodeGenFunctionENS1_8QualTypeEPN4llvm5ValueEPKNS1_12ObjCIvarDeclEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCGNU.cpp -nm=_ZN12_GLOBAL__N_19CGObjCGNU20EmitObjCValueForIvarERN5clang7CodeGen15CodeGenFunctionENS1_8QualTypeEPN4llvm5ValueEPKNS1_12ObjCIvarDeclEj")
  //</editor-fold>
  @Override public LValue EmitObjCValueForIvar(final CodeGenFunction /*&*/ CGF, 
                      QualType ObjectTy, 
                      Value /*P*/ BaseValue, 
                      /*const*/ ObjCIvarDecl /*P*/ Ivar, 
                      /*uint*/int CVRQualifiers)/* override*/ {
    /*const*/ ObjCInterfaceDecl /*P*/ ID = ObjectTy.$arrow().getAs(ObjCObjectType.class).getInterface();
    return EmitValueForIvarAtOffset(CGF, ID, BaseValue, Ivar, CVRQualifiers, 
        EmitIvarOffset(CGF, ID, Ivar));
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGObjCGNU::EmitIvarOffset">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCGNU.cpp", line = 2901,
   FQN="(anonymous namespace)::CGObjCGNU::EmitIvarOffset", NM="_ZN12_GLOBAL__N_19CGObjCGNU14EmitIvarOffsetERN5clang7CodeGen15CodeGenFunctionEPKNS1_17ObjCInterfaceDeclEPKNS1_12ObjCIvarDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCGNU.cpp -nm=_ZN12_GLOBAL__N_19CGObjCGNU14EmitIvarOffsetERN5clang7CodeGen15CodeGenFunctionEPKNS1_17ObjCInterfaceDeclEPKNS1_12ObjCIvarDeclE")
  //</editor-fold>
  @Override public Value /*P*/ EmitIvarOffset(final CodeGenFunction /*&*/ CGF, 
                /*const*/ ObjCInterfaceDecl /*P*/ Interface, 
                /*const*/ ObjCIvarDecl /*P*/ Ivar)/* override*/ {
    if (CGM.getLangOpts().ObjCRuntime.isNonFragile()) {
      Interface = CGObjCGNUStatics.FindIvarInterface(CGM.getContext(), Interface, Ivar);
      
      // The MSVC linker cannot have a single global defined as LinkOnceAnyLinkage
      // and ExternalLinkage, so create a reference to the ivar global and rely on
      // the definition being created as part of GenerateClass.
      if (RuntimeVersion < 10
         || CGF.CGM.getTarget().getTriple().isKnownWindowsMSVCEnvironment()) {
        return CGF.Builder.CreateZExtOrBitCast(CGF.Builder.CreateDefaultAlignedLoad(CGF.Builder.CreateAlignedLoad(ObjCIvarOffsetVariable(Interface, Ivar), 
                    CGF.getPointerAlign(), $("ivar"))), 
            PtrDiffTy);
      }
      std.string name = $add_string($add_string_T$C$P($add_T$C$P_string(/*KEEP_STR*/"__objc_ivar_offset_value_", 
                  Interface.getNameAsString()), /*KEEP_STR*/"."), Ivar.getNameAsString());
      CharUnits Align = CGM.getIntAlign();
      Value /*P*/ Offset = TheModule.getGlobalVariable(new StringRef(name));
      if (!(Offset != null)) {
        GlobalVariable /*P*/ GV = /*NEW_EXPR [GlobalVariable::new]*/GlobalVariable.$new_GlobalVariable((type$ptr<?> New$Mem)->{
            return new GlobalVariable(TheModule, IntTy, 
            false, GlobalValue.LinkageTypes.LinkOnceAnyLinkage, 
            Constant.getNullValue(IntTy), new Twine(name));
         });
        GV.setAlignment($long2uint(Align.getQuantity()));
        Offset = GV;
      }
      Offset = CGF.Builder.CreateAlignedLoad(Offset, new CharUnits(Align));
      if (Offset.getType() != PtrDiffTy) {
        Offset = CGF.Builder.CreateZExtOrBitCast(Offset, PtrDiffTy);
      }
      return Offset;
    }
    long/*uint64_t*/ Offset = ComputeIvarBaseOffset_1(CGF.CGM, Interface, Ivar);
    return ConstantInt.get(PtrDiffTy, Offset, /*isSigned*/ true);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGObjCGNU::EmitNSAutoreleasePoolClassRef">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCGNU.cpp", line = 1091,
   FQN="(anonymous namespace)::CGObjCGNU::EmitNSAutoreleasePoolClassRef", NM="_ZN12_GLOBAL__N_19CGObjCGNU29EmitNSAutoreleasePoolClassRefERN5clang7CodeGen15CodeGenFunctionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCGNU.cpp -nm=_ZN12_GLOBAL__N_19CGObjCGNU29EmitNSAutoreleasePoolClassRefERN5clang7CodeGen15CodeGenFunctionE")
  //</editor-fold>
  @Override public Value /*P*/ EmitNSAutoreleasePoolClassRef(final CodeGenFunction /*&*/ CGF)/* override*/ {
    Value /*P*/ $Value = GetClassNamed(CGF, new std.string(JD$T$C$P_T2$C$R.INSTANCE, /*KEEP_STR*/"NSAutoreleasePool"), false);
    if (CGM.getTriple().isOSBinFormatCOFF()) {
      {
        GlobalVariable /*P*/ ClassSymbol = dyn_cast_GlobalVariable($Value);
        if ((ClassSymbol != null)) {
          final IdentifierInfo /*&*/ II = CGF.CGM.getContext().Idents.get(new StringRef(/*KEEP_STR*/"NSAutoreleasePool"));
          TranslationUnitDecl /*P*/ TUDecl = CGM.getContext().getTranslationUnitDecl();
          DeclContext /*P*/ DC = TranslationUnitDecl.castToDeclContext(TUDecl);
          
          /*const*/ VarDecl /*P*/ VD = null;
          for (final NamedDecl /*P*/ /*const*/ /*&*/ Result : DC.lookup(new DeclarationName($AddrOf(II))))  {
            if (((VD = dyn_cast_VarDecl(Result)) != null)) {
              break;
            }
          }
          
          GlobalValue.DLLStorageClassTypes DLLStorage = GlobalValue.DLLStorageClassTypes.DefaultStorageClass;
          if (!(VD != null) || VD.hasAttr(DLLImportAttr.class)) {
            DLLStorage = GlobalValue.DLLStorageClassTypes.DLLImportStorageClass;
          } else if (VD.hasAttr(DLLExportAttr.class)) {
            DLLStorage = GlobalValue.DLLStorageClassTypes.DLLExportStorageClass;
          }
          
          ClassSymbol.setDLLStorageClass(DLLStorage);
        }
      }
    }
    return $Value;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGObjCGNU::BuildGCBlockLayout">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCGNU.cpp", line = 581,
   FQN="(anonymous namespace)::CGObjCGNU::BuildGCBlockLayout", NM="_ZN12_GLOBAL__N_19CGObjCGNU18BuildGCBlockLayoutERN5clang7CodeGen13CodeGenModuleERKNS2_11CGBlockInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCGNU.cpp -nm=_ZN12_GLOBAL__N_19CGObjCGNU18BuildGCBlockLayoutERN5clang7CodeGen13CodeGenModuleERKNS2_11CGBlockInfoE")
  //</editor-fold>
  @Override public Constant /*P*/ BuildGCBlockLayout(final CodeGenModule /*&*/ CGM, 
                    final /*const*/ CGBlockInfo /*&*/ blockInfo)/* override*/ {
    return NULLPtr;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGObjCGNU::BuildRCBlockLayout">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCGNU.cpp", line = 585,
   FQN="(anonymous namespace)::CGObjCGNU::BuildRCBlockLayout", NM="_ZN12_GLOBAL__N_19CGObjCGNU18BuildRCBlockLayoutERN5clang7CodeGen13CodeGenModuleERKNS2_11CGBlockInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCGNU.cpp -nm=_ZN12_GLOBAL__N_19CGObjCGNU18BuildRCBlockLayoutERN5clang7CodeGen13CodeGenModuleERKNS2_11CGBlockInfoE")
  //</editor-fold>
  @Override public Constant /*P*/ BuildRCBlockLayout(final CodeGenModule /*&*/ CGM, 
                    final /*const*/ CGBlockInfo /*&*/ blockInfo)/* override*/ {
    return NULLPtr;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGObjCGNU::BuildByrefLayout">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCGNU.cpp", line = 590,
   FQN="(anonymous namespace)::CGObjCGNU::BuildByrefLayout", NM="_ZN12_GLOBAL__N_19CGObjCGNU16BuildByrefLayoutERN5clang7CodeGen13CodeGenModuleENS1_8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCGNU.cpp -nm=_ZN12_GLOBAL__N_19CGObjCGNU16BuildByrefLayoutERN5clang7CodeGen13CodeGenModuleENS1_8QualTypeE")
  //</editor-fold>
  @Override public Constant /*P*/ BuildByrefLayout(final CodeGenModule /*&*/ CGM, QualType T)/* override*/ {
    return NULLPtr;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGObjCGNU::GetClassGlobal">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCGNU.cpp", line = 594,
   FQN="(anonymous namespace)::CGObjCGNU::GetClassGlobal", NM="_ZN12_GLOBAL__N_19CGObjCGNU14GetClassGlobalEN4llvm9StringRefEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCGNU.cpp -nm=_ZN12_GLOBAL__N_19CGObjCGNU14GetClassGlobalEN4llvm9StringRefEb")
  //</editor-fold>
  @Override public GlobalVariable /*P*/ GetClassGlobal(StringRef Name)/* override*/ {
    return GetClassGlobal(Name, 
                false);
  }
  @Override public GlobalVariable /*P*/ GetClassGlobal(StringRef Name, 
                boolean Weak/*= false*/)/* override*/ {
    return null;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGObjCGNU::~CGObjCGNU">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCGNU.cpp", line = 96,
   FQN="(anonymous namespace)::CGObjCGNU::~CGObjCGNU", NM="_ZN12_GLOBAL__N_19CGObjCGNUD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCGNU.cpp -nm=_ZN12_GLOBAL__N_19CGObjCGNUD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    //START JDestroy
    ClassAliases.$destroy();
    SelectorTable.$destroy();
    ExistingProtocols.$destroy();
    ObjCStrings.$destroy();
    ConstantStrings.$destroy();
    Categories.$destroy();
    Classes.$destroy();
    super.$destroy();
    //END JDestroy
  }

  
  @Override public String toString() {
    return "" + "TheModule=" + TheModule // NOI18N
              + ", ObjCSuperTy=" + ObjCSuperTy // NOI18N
              + ", PtrToObjCSuperTy=" + PtrToObjCSuperTy // NOI18N
              + ", SelectorTy=" + SelectorTy // NOI18N
              + ", Int8Ty=" + Int8Ty // NOI18N
              + ", PtrToInt8Ty=" + PtrToInt8Ty // NOI18N
              + ", IMPTy=" + IMPTy // NOI18N
              + ", IdTy=" + IdTy // NOI18N
              + ", PtrToIdTy=" + PtrToIdTy // NOI18N
              + ", ASTIdTy=" + ASTIdTy // NOI18N
              + ", IntTy=" + IntTy // NOI18N
              + ", PtrTy=" + PtrTy // NOI18N
              + ", LongTy=" + LongTy // NOI18N
              + ", SizeTy=" + SizeTy // NOI18N
              + ", IntPtrTy=" + IntPtrTy // NOI18N
              + ", PtrDiffTy=" + PtrDiffTy // NOI18N
              + ", PtrToIntTy=" + PtrToIntTy // NOI18N
              + ", BoolTy=" + BoolTy // NOI18N
              + ", Int32Ty=" + Int32Ty // NOI18N
              + ", Int64Ty=" + Int64Ty // NOI18N
              + ", msgSendMDKind=" + msgSendMDKind // NOI18N
              + ", Zeros=" + Zeros // NOI18N
              + ", NULLPtr=" + NULLPtr // NOI18N
              + ", VMContext=" + "[LLVMContext]" // NOI18N
              + ", ClassPtrAlias=" + ClassPtrAlias // NOI18N
              + ", MetaClassPtrAlias=" + MetaClassPtrAlias // NOI18N
              + ", Classes=" + Classes // NOI18N
              + ", Categories=" + Categories // NOI18N
              + ", ConstantStrings=" + ConstantStrings // NOI18N
              + ", ObjCStrings=" + ObjCStrings // NOI18N
              + ", ExistingProtocols=" + ExistingProtocols // NOI18N
              + ", SelectorTable=" + SelectorTable // NOI18N
              + ", RetainSel=" + RetainSel // NOI18N
              + ", ReleaseSel=" + ReleaseSel // NOI18N
              + ", AutoreleaseSel=" + AutoreleaseSel // NOI18N
              + ", IvarAssignFn=" + IvarAssignFn // NOI18N
              + ", StrongCastAssignFn=" + StrongCastAssignFn // NOI18N
              + ", MemMoveFn=" + MemMoveFn // NOI18N
              + ", WeakReadFn=" + WeakReadFn // NOI18N
              + ", WeakAssignFn=" + WeakAssignFn // NOI18N
              + ", GlobalAssignFn=" + GlobalAssignFn // NOI18N
              + ", ClassAliases=" + ClassAliases // NOI18N
              + ", ExceptionThrowFn=" + ExceptionThrowFn // NOI18N
              + ", ExceptionReThrowFn=" + ExceptionReThrowFn // NOI18N
              + ", EnterCatchFn=" + EnterCatchFn // NOI18N
              + ", ExitCatchFn=" + ExitCatchFn // NOI18N
              + ", SyncEnterFn=" + SyncEnterFn // NOI18N
              + ", SyncExitFn=" + SyncExitFn // NOI18N
              + ", EnumerationMutationFn=" + EnumerationMutationFn // NOI18N
              + ", GetPropertyFn=" + GetPropertyFn // NOI18N
              + ", SetPropertyFn=" + SetPropertyFn // NOI18N
              + ", GetStructPropertyFn=" + GetStructPropertyFn // NOI18N
              + ", SetStructPropertyFn=" + SetStructPropertyFn // NOI18N
              + ", RuntimeVersion=" + RuntimeVersion // NOI18N
              + ", ProtocolVersion=" + ProtocolVersion // NOI18N
              + super.toString(); // NOI18N
  }
}
