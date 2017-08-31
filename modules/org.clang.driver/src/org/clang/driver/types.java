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
package org.clang.driver;

import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.clank.java.std.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Unsigned.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.driver.*;
import static org.clang.driver.types.*;
import static org.clang.driver.impl.TypesStatics.*;


//<editor-fold defaultstate="collapsed" desc="static type types">
@Converted(kind = Converted.Kind.AUTO,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Types.cpp -nm=_ZN5clang6driver5types11canLipoTypeENS1_2IDE;_ZN5clang6driver5types11getTypeNameENS1_2IDE;_ZN5clang6driver5types16onlyAssembleTypeENS1_2IDE;_ZN5clang6driver5types17getTypeTempSuffixENS1_2IDEb;_ZN5clang6driver5types17isAcceptedByClangENS1_2IDE;_ZN5clang6driver5types18onlyPrecompileTypeENS1_2IDE;_ZN5clang6driver5types19appendSuffixForTypeENS1_2IDE;_ZN5clang6driver5types19getPreprocessedTypeENS1_2IDE;_ZN5clang6driver5types20getCompilationPhasesENS1_2IDERN4llvm15SmallVectorImplINS0_6phases2IDEEE;_ZN5clang6driver5types21lookupCXXTypeForCTypeENS1_2IDE;_ZN5clang6driver5types22canTypeBeUserSpecifiedENS1_2IDE;_ZN5clang6driver5types22lookupTypeForExtensionEPKc;_ZN5clang6driver5types26lookupTypeForTypeSpecifierEPKc;_ZN5clang6driver5types2IDE;_ZN5clang6driver5types5isCXXENS1_2IDE;_ZN5clang6driver5types6isCudaENS1_2IDE;_ZN5clang6driver5types6isObjCENS1_2IDE;_ZN5clang6driver5types8isLLVMIRENS1_2IDE; -static-type=types -package=org.clang.driver")
//</editor-fold>
public final class types {

//<editor-fold defaultstate="collapsed" desc="clang::driver::types::ID">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Driver/Types.h", line = 19,
 FQN="clang::driver::types::ID", NM="_ZN5clang6driver5types2IDE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Types.cpp -nm=_ZN5clang6driver5types2IDE")
//</editor-fold>
public enum ID implements Native.ComparableLower {
  TY_INVALID(0),
  
  // TYPE(NAME, ID, PP_TYPE, TEMP_SUFFIX, FLAGS)
  
  // The first value is the type name as a string; for types which can
  // be user specified this should be the equivalent -x option.
  
  // The second value is the type id, which will result in a
  // clang::driver::types::TY_XX enum constant.
  
  // The third value is that id of the type for preprocessed inputs of
  // this type, or INVALID if this type is not preprocessed.
  
  // The fourth value is the suffix to use when creating temporary files
  // of this type, or null if unspecified.
  
  // The fifth value is a string containing option flags. Valid values:
  //  a - The type should only be assembled.
  //  p - The type should only be precompiled.
  //  u - The type can be user specified (with -x).
  //  A - The type's temporary suffix should be appended when generating
  //      outputs of this type.
  
  // C family source language (with and without preprocessing).
  TY_PP_C(TY_INVALID.getValue() + 1),
  TY_C(TY_PP_C.getValue() + 1),
  TY_CL(TY_C.getValue() + 1),
  TY_PP_CUDA(TY_CL.getValue() + 1),
  TY_CUDA(TY_PP_CUDA.getValue() + 1),
  TY_CUDA_DEVICE(TY_CUDA.getValue() + 1),
  TY_PP_ObjC(TY_CUDA_DEVICE.getValue() + 1),
  TY_PP_ObjC_Alias(TY_PP_ObjC.getValue() + 1),
  TY_ObjC(TY_PP_ObjC_Alias.getValue() + 1),
  TY_PP_CXX(TY_ObjC.getValue() + 1),
  TY_CXX(TY_PP_CXX.getValue() + 1),
  TY_PP_ObjCXX(TY_CXX.getValue() + 1),
  TY_PP_ObjCXX_Alias(TY_PP_ObjCXX.getValue() + 1),
  TY_ObjCXX(TY_PP_ObjCXX_Alias.getValue() + 1),
  TY_RenderScript(TY_ObjCXX.getValue() + 1),
  
  // C family input files to precompile.
  TY_PP_CHeader(TY_RenderScript.getValue() + 1),
  TY_CHeader(TY_PP_CHeader.getValue() + 1),
  TY_CLHeader(TY_CHeader.getValue() + 1),
  TY_PP_ObjCHeader(TY_CLHeader.getValue() + 1),
  TY_ObjCHeader(TY_PP_ObjCHeader.getValue() + 1),
  TY_PP_CXXHeader(TY_ObjCHeader.getValue() + 1),
  TY_CXXHeader(TY_PP_CXXHeader.getValue() + 1),
  TY_PP_ObjCXXHeader(TY_CXXHeader.getValue() + 1),
  TY_ObjCXXHeader(TY_PP_ObjCXXHeader.getValue() + 1),
  
  // Other languages.
  TY_Ada(TY_ObjCXXHeader.getValue() + 1),
  TY_PP_Asm(TY_Ada.getValue() + 1),
  TY_Asm(TY_PP_Asm.getValue() + 1),
  TY_PP_Fortran(TY_Asm.getValue() + 1),
  TY_Fortran(TY_PP_Fortran.getValue() + 1),
  TY_Java(TY_Fortran.getValue() + 1),
  
  // LLVM IR/LTO types. We define separate types for IR and LTO because LTO
  // outputs should use the standard suffixes.
  TY_LLVM_IR(TY_Java.getValue() + 1),
  TY_LLVM_BC(TY_LLVM_IR.getValue() + 1),
  TY_LTO_IR(TY_LLVM_BC.getValue() + 1),
  TY_LTO_BC(TY_LTO_IR.getValue() + 1),
  
  // Misc.
  TY_AST(TY_LTO_BC.getValue() + 1),
  TY_ModuleFile(TY_AST.getValue() + 1),
  TY_Plist(TY_ModuleFile.getValue() + 1),
  TY_RewrittenObjC(TY_Plist.getValue() + 1),
  TY_RewrittenLegacyObjC(TY_RewrittenObjC.getValue() + 1),
  TY_Remap(TY_RewrittenLegacyObjC.getValue() + 1),
  TY_PCH(TY_Remap.getValue() + 1),
  TY_Object(TY_PCH.getValue() + 1),
  TY_Treelang(TY_Object.getValue() + 1),
  TY_Image(TY_Treelang.getValue() + 1),
  TY_dSYM(TY_Image.getValue() + 1),
  TY_Dependencies(TY_dSYM.getValue() + 1),
  TY_CUDA_FATBIN(TY_Dependencies.getValue() + 1),
  TY_Nothing(TY_CUDA_FATBIN.getValue() + 1),
  TY_LAST(TY_Nothing.getValue() + 1);

  //<editor-fold defaultstate="collapsed" desc="hidden">
  public static ID valueOf(int val) {
    ID out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
    assert out != null : "no value for " + val;
    assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
    return out;
  }

  private static final class Values {
    private static final ID[] VALUES;
    private static final ID[] _VALUES; // [0] not used
    static {
      int max = 0;
      int min = 0;
      for (ID kind : ID.values()) {
        if (kind.value > max) { max = kind.value; }
        if (kind.value < min) { min = kind.value; }
      }
      _VALUES = new ID[min < 0 ? (1-min) : 0];
      VALUES = new ID[max >= 0 ? (1+max) : 0];
      for (ID kind : ID.values()) {
        if (kind.value < 0) {
          _VALUES[-kind.value] = kind;
        } else {
          VALUES[kind.value] = kind;
        }
      }
    }
  }

  private final /*uint*/int value;
  private ID(int val) { this.value = (/*uint*/int)val;}
  public /*uint*/int getValue() { return value;}
  @Override public boolean $less(Object obj) { return Unsigned.$less_uint(value, ((ID)obj).value);}
  @Override public boolean $lesseq(Object obj) { return Unsigned.$lesseq_uint(value, ((ID)obj).value);}
  //</editor-fold>
}

/// getTypeName - Return the name of the type for \p Id.
//<editor-fold defaultstate="collapsed" desc="clang::driver::types::getTypeName">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Types.cpp", line = 39,
 FQN="clang::driver::types::getTypeName", NM="_ZN5clang6driver5types11getTypeNameENS1_2IDE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Types.cpp -nm=_ZN5clang6driver5types11getTypeNameENS1_2IDE")
//</editor-fold>
public static /*const*/char$ptr/*char P*/ getTypeName(ID Id) {
  return $(getInfo(Id.getValue()).Name);
}


/// getPreprocessedType - Get the ID of the type for this input when
/// it has been preprocessed, or INVALID if this input is not
/// preprocessed.
//<editor-fold defaultstate="collapsed" desc="clang::driver::types::getPreprocessedType">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Types.cpp", line = 43,
 FQN="clang::driver::types::getPreprocessedType", NM="_ZN5clang6driver5types19getPreprocessedTypeENS1_2IDE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Types.cpp -nm=_ZN5clang6driver5types19getPreprocessedTypeENS1_2IDE")
//</editor-fold>
public static types.ID getPreprocessedType(ID Id) {
  return getInfo(Id.getValue()).PreprocessedType;
}


/// getTypeTempSuffix - Return the suffix to use when creating a
/// temp file of this type, or null if unspecified.
//<editor-fold defaultstate="collapsed" desc="clang::driver::types::getTypeTempSuffix">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Types.cpp", line = 47,
 FQN="clang::driver::types::getTypeTempSuffix", NM="_ZN5clang6driver5types17getTypeTempSuffixENS1_2IDEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Types.cpp -nm=_ZN5clang6driver5types17getTypeTempSuffixENS1_2IDEb")
//</editor-fold>
public static /*const*/char$ptr/*char P*/ getTypeTempSuffix(ID Id) {
  return getTypeTempSuffix(Id, false);
}
public static /*const*/char$ptr/*char P*/ getTypeTempSuffix(ID Id, boolean CLMode/*= false*/) {
  if (Id == ID.TY_Object && CLMode) {
    return $("obj");
  }
  if (Id == ID.TY_Image && CLMode) {
    return $("exe");
  }
  if (Id == ID.TY_PP_Asm && CLMode) {
    return $asm;
  }
  return $(getInfo(Id.getValue()).TempSuffix);
}


/// onlyAssembleType - Should this type only be assembled.
//<editor-fold defaultstate="collapsed" desc="clang::driver::types::onlyAssembleType">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Types.cpp", line = 57,
 FQN="clang::driver::types::onlyAssembleType", NM="_ZN5clang6driver5types16onlyAssembleTypeENS1_2IDE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Types.cpp -nm=_ZN5clang6driver5types16onlyAssembleTypeENS1_2IDE")
//</editor-fold>
public static boolean onlyAssembleType(ID Id) {
  return (strchr(getInfo(Id.getValue()).Flags, $$a) != null);
}


/// onlyPrecompileType - Should this type only be precompiled.
//<editor-fold defaultstate="collapsed" desc="clang::driver::types::onlyPrecompileType">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Types.cpp", line = 61,
 FQN="clang::driver::types::onlyPrecompileType", NM="_ZN5clang6driver5types18onlyPrecompileTypeENS1_2IDE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Types.cpp -nm=_ZN5clang6driver5types18onlyPrecompileTypeENS1_2IDE")
//</editor-fold>
public static boolean onlyPrecompileType(ID Id) {
  return (strchr(getInfo(Id.getValue()).Flags, $$p) != null);
}


/// canTypeBeUserSpecified - Can this type be specified on the
/// command line (by the type name); this is used when forwarding
/// commands to gcc.
//<editor-fold defaultstate="collapsed" desc="clang::driver::types::canTypeBeUserSpecified">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Types.cpp", line = 65,
 FQN="clang::driver::types::canTypeBeUserSpecified", NM="_ZN5clang6driver5types22canTypeBeUserSpecifiedENS1_2IDE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Types.cpp -nm=_ZN5clang6driver5types22canTypeBeUserSpecifiedENS1_2IDE")
//</editor-fold>
public static boolean canTypeBeUserSpecified(ID Id) {
  return (strchr(getInfo(Id.getValue()).Flags, $$u) != null);
}


/// appendSuffixForType - When generating outputs of this type,
/// should the suffix be appended (instead of replacing the existing
/// suffix).
//<editor-fold defaultstate="collapsed" desc="clang::driver::types::appendSuffixForType">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Types.cpp", line = 69,
 FQN="clang::driver::types::appendSuffixForType", NM="_ZN5clang6driver5types19appendSuffixForTypeENS1_2IDE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Types.cpp -nm=_ZN5clang6driver5types19appendSuffixForTypeENS1_2IDE")
//</editor-fold>
public static boolean appendSuffixForType(ID Id) {
  return (strchr(getInfo(Id.getValue()).Flags, $$A) != null);
}


/// canLipoType - Is this type acceptable as the output of a
/// universal build (currently, just the Nothing, Image, and Object
/// types).
//<editor-fold defaultstate="collapsed" desc="clang::driver::types::canLipoType">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Types.cpp", line = 73,
 FQN="clang::driver::types::canLipoType", NM="_ZN5clang6driver5types11canLipoTypeENS1_2IDE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Types.cpp -nm=_ZN5clang6driver5types11canLipoTypeENS1_2IDE")
//</editor-fold>
public static boolean canLipoType(ID Id) {
  return (Id == ID.TY_Nothing
     || Id == ID.TY_Image
     || Id == ID.TY_Object
     || Id == ID.TY_LTO_BC);
}


/// isAcceptedByClang - Can clang handle this input type.
//<editor-fold defaultstate="collapsed" desc="clang::driver::types::isAcceptedByClang">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Types.cpp", line = 80,
 FQN="clang::driver::types::isAcceptedByClang", NM="_ZN5clang6driver5types17isAcceptedByClangENS1_2IDE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Types.cpp -nm=_ZN5clang6driver5types17isAcceptedByClangENS1_2IDE")
//</editor-fold>
public static boolean isAcceptedByClang(ID Id) {
  switch (Id) {
   default:
    return false;
   case TY_Asm:
   case TY_C:
   case TY_PP_C:
   case TY_CL:
   case TY_CUDA:
   case TY_PP_CUDA:
   case TY_CUDA_DEVICE:
   case TY_ObjC:
   case TY_PP_ObjC:
   case TY_PP_ObjC_Alias:
   case TY_CXX:
   case TY_PP_CXX:
   case TY_ObjCXX:
   case TY_PP_ObjCXX:
   case TY_PP_ObjCXX_Alias:
   case TY_CHeader:
   case TY_PP_CHeader:
   case TY_CLHeader:
   case TY_ObjCHeader:
   case TY_PP_ObjCHeader:
   case TY_CXXHeader:
   case TY_PP_CXXHeader:
   case TY_ObjCXXHeader:
   case TY_PP_ObjCXXHeader:
   case TY_AST:
   case TY_ModuleFile:
   case TY_LLVM_IR:
   case TY_LLVM_BC:
    return true;
  }
}


/// isCXX - Is this a "C++" input (C++ and Obj-C++ sources and headers).
//<editor-fold defaultstate="collapsed" desc="clang::driver::types::isCXX">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Types.cpp", line = 117,
 FQN="clang::driver::types::isCXX", NM="_ZN5clang6driver5types5isCXXENS1_2IDE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Types.cpp -nm=_ZN5clang6driver5types5isCXXENS1_2IDE")
//</editor-fold>
public static boolean isCXX(ID Id) {
  switch (Id) {
   default:
    return false;
   case TY_CXX:
   case TY_PP_CXX:
   case TY_ObjCXX:
   case TY_PP_ObjCXX:
   case TY_PP_ObjCXX_Alias:
   case TY_CXXHeader:
   case TY_PP_CXXHeader:
   case TY_ObjCXXHeader:
   case TY_PP_ObjCXXHeader:
   case TY_CUDA:
   case TY_PP_CUDA:
   case TY_CUDA_DEVICE:
    return true;
  }
}


/// Is this LLVM IR.
//<editor-fold defaultstate="collapsed" desc="clang::driver::types::isLLVMIR">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Types.cpp", line = 131,
 FQN="clang::driver::types::isLLVMIR", NM="_ZN5clang6driver5types8isLLVMIRENS1_2IDE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Types.cpp -nm=_ZN5clang6driver5types8isLLVMIRENS1_2IDE")
//</editor-fold>
public static boolean isLLVMIR(ID Id) {
  switch (Id) {
   default:
    return false;
   case TY_LLVM_IR:
   case TY_LLVM_BC:
   case TY_LTO_IR:
   case TY_LTO_BC:
    return true;
  }
}


/// isCuda - Is this a CUDA input.
//<editor-fold defaultstate="collapsed" desc="clang::driver::types::isCuda">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Types.cpp", line = 144,
 FQN="clang::driver::types::isCuda", NM="_ZN5clang6driver5types6isCudaENS1_2IDE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Types.cpp -nm=_ZN5clang6driver5types6isCudaENS1_2IDE")
//</editor-fold>
public static boolean isCuda(ID Id) {
  switch (Id) {
   default:
    return false;
   case TY_CUDA:
   case TY_PP_CUDA:
   case TY_CUDA_DEVICE:
    return true;
  }
}


/// isObjC - Is this an "ObjC" input (Obj-C and Obj-C++ sources and headers).
//<editor-fold defaultstate="collapsed" desc="clang::driver::types::isObjC">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Types.cpp", line = 104,
 FQN="clang::driver::types::isObjC", NM="_ZN5clang6driver5types6isObjCENS1_2IDE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Types.cpp -nm=_ZN5clang6driver5types6isObjCENS1_2IDE")
//</editor-fold>
public static boolean isObjC(ID Id) {
  switch (Id) {
   default:
    return false;
   case TY_ObjC:
   case TY_PP_ObjC:
   case TY_PP_ObjC_Alias:
   case TY_ObjCXX:
   case TY_PP_ObjCXX:
   case TY_ObjCHeader:
   case TY_PP_ObjCHeader:
   case TY_ObjCXXHeader:
   case TY_PP_ObjCXXHeader:
   case TY_PP_ObjCXX_Alias:
    return true;
  }
}


/// lookupTypeForExtension - Lookup the type to use for the file
/// extension \p Ext.
//<editor-fold defaultstate="collapsed" desc="clang::driver::types::lookupTypeForExtension">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Types.cpp", line = 156,
 FQN="clang::driver::types::lookupTypeForExtension", NM="_ZN5clang6driver5types22lookupTypeForExtensionEPKc",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Types.cpp -nm=_ZN5clang6driver5types22lookupTypeForExtensionEPKc")
//</editor-fold>
public static types.ID lookupTypeForExtension(/*const*/char$ptr/*char P*/ Ext) {
  return new StringSwitch<types.ID>(/*STRINGREF_STR*/Ext).
      Case(/*KEEP_STR*/"c", ID.TY_C).
      Case(/*KEEP_STR*/"i", ID.TY_PP_C).
      Case(/*KEEP_STR*/"m", ID.TY_ObjC).
      Case(/*KEEP_STR*/"M", ID.TY_ObjCXX).
      Case(/*KEEP_STR*/"h", ID.TY_CHeader).
      Case(/*KEEP_STR*/"C", ID.TY_CXX).
      Case(/*KEEP_STR*/"H", ID.TY_CXXHeader).
      Case(/*KEEP_STR*/"f", ID.TY_PP_Fortran).
      Case(/*KEEP_STR*/"F", ID.TY_Fortran).
      Case(/*KEEP_STR*/"s", ID.TY_PP_Asm).
      Case(/*KEEP_STR*/"asm", ID.TY_PP_Asm).
      Case(/*KEEP_STR*/"S", ID.TY_Asm).
      Case(/*KEEP_STR*/"o", ID.TY_Object).
      Case(/*KEEP_STR*/"obj", ID.TY_Object).
      Case(/*KEEP_STR*/"lib", ID.TY_Object).
      Case(/*KEEP_STR*/"ii", ID.TY_PP_CXX).
      Case(/*KEEP_STR*/"mi", ID.TY_PP_ObjC).
      Case(/*KEEP_STR*/"mm", ID.TY_ObjCXX).
      Case(/*KEEP_STR*/"bc", ID.TY_LLVM_BC).
      Case(/*KEEP_STR*/"cc", ID.TY_CXX).
      Case(/*KEEP_STR*/"CC", ID.TY_CXX).
      Case(/*KEEP_STR*/"cl", ID.TY_CL).
      Case(/*KEEP_STR*/"cp", ID.TY_CXX).
      Case(/*KEEP_STR*/"cu", ID.TY_CUDA).
      Case(/*KEEP_STR*/"cui", ID.TY_PP_CUDA).
      Case(/*KEEP_STR*/"hh", ID.TY_CXXHeader).
      Case(/*KEEP_STR*/"ll", ID.TY_LLVM_IR).
      Case(/*KEEP_STR*/"hpp", ID.TY_CXXHeader).
      Case(/*KEEP_STR*/"ads", ID.TY_Ada).
      Case(/*KEEP_STR*/"adb", ID.TY_Ada).
      Case(/*KEEP_STR*/"ast", ID.TY_AST).
      Case(/*KEEP_STR*/"c++", ID.TY_CXX).
      Case(/*KEEP_STR*/"C++", ID.TY_CXX).
      Case(/*KEEP_STR*/"cxx", ID.TY_CXX).
      Case(/*KEEP_STR*/"cpp", ID.TY_CXX).
      Case(/*KEEP_STR*/"CPP", ID.TY_CXX).
      Case(/*KEEP_STR*/"CXX", ID.TY_CXX).
      Case(/*KEEP_STR*/"for", ID.TY_PP_Fortran).
      Case(/*KEEP_STR*/"FOR", ID.TY_PP_Fortran).
      Case(/*KEEP_STR*/"fpp", ID.TY_Fortran).
      Case(/*KEEP_STR*/"FPP", ID.TY_Fortran).
      Case(/*KEEP_STR*/"f90", ID.TY_PP_Fortran).
      Case(/*KEEP_STR*/"f95", ID.TY_PP_Fortran).
      Case(/*KEEP_STR*/"F90", ID.TY_Fortran).
      Case(/*KEEP_STR*/"F95", ID.TY_Fortran).
      Case(/*KEEP_STR*/"mii", ID.TY_PP_ObjCXX).
      Case(/*KEEP_STR*/"pcm", ID.TY_ModuleFile).
      Case(/*KEEP_STR*/"pch", ID.TY_PCH).
      Case(/*KEEP_STR*/"gch", ID.TY_PCH).
      Case(/*KEEP_STR*/"rs", ID.TY_RenderScript).
      Default(ID.TY_INVALID);
}


/// lookupTypeForTypSpecifier - Lookup the type to use for a user
/// specified type name.
//<editor-fold defaultstate="collapsed" desc="clang::driver::types::lookupTypeForTypeSpecifier">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Types.cpp", line = 211,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Types.cpp", old_line = 210,
 FQN="clang::driver::types::lookupTypeForTypeSpecifier", NM="_ZN5clang6driver5types26lookupTypeForTypeSpecifierEPKc",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Types.cpp -nm=_ZN5clang6driver5types26lookupTypeForTypeSpecifierEPKc")
//</editor-fold>
public static types.ID lookupTypeForTypeSpecifier(/*const*/char$ptr/*char P*/ Name) {
  for (/*uint*/int i = 0; $less_uint(i, numTypes); ++i) {
    types.ID Id = types.ID.valueOf((i + 1));
    if (canTypeBeUserSpecified(Id)
       && strcmp(Name, getInfo(Id.getValue()).Name) == 0) {
      return Id;
    }
  }
  
  return ID.TY_INVALID;
}


/// getCompilationPhases - Get the list of compilation phases ('Phases') to be
/// done for type 'Id'.

// FIXME: Why don't we just put this list in the defs file, eh.
//<editor-fold defaultstate="collapsed" desc="clang::driver::types::getCompilationPhases">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Types.cpp", line = 223,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Types.cpp", old_line = 222,
 FQN="clang::driver::types::getCompilationPhases", NM="_ZN5clang6driver5types20getCompilationPhasesENS1_2IDERN4llvm15SmallVectorImplINS0_6phases2IDEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Types.cpp -nm=_ZN5clang6driver5types20getCompilationPhasesENS1_2IDERN4llvm15SmallVectorImplINS0_6phases2IDEEE")
//</editor-fold>
public static void getCompilationPhases(ID Id, SmallVectorImpl<phases.ID> /*&*/ P) {
  if (Id != ID.TY_Object) {
    if (getPreprocessedType(Id) != ID.TY_INVALID) {
      P.push_back(phases.ID.Preprocess);
    }
    if (onlyPrecompileType(Id)) {
      P.push_back(phases.ID.Precompile);
    } else {
      if (!onlyAssembleType(Id)) {
        P.push_back(phases.ID.Compile);
        P.push_back(phases.ID.Backend);
      }
      P.push_back(phases.ID.Assemble);
    }
  }
  if (!onlyPrecompileType(Id) && Id != ID.TY_CUDA_DEVICE) {
    P.push_back(phases.ID.Link);
  }
  assert ($less_uint(0, P.size())) : "Not enough phases in list";
  assert ($lesseq_uint(P.size(), phases.MaxNumberOfPhases)) : "Too many phases in list";
}


/// lookupCXXTypeForCType - Lookup CXX input type that corresponds to given
/// C type (used for clang++ emulation of g++ behaviour)
//<editor-fold defaultstate="collapsed" desc="clang::driver::types::lookupCXXTypeForCType">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Types.cpp", line = 247,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Types.cpp", old_line = 248,
 FQN="clang::driver::types::lookupCXXTypeForCType", NM="_ZN5clang6driver5types21lookupCXXTypeForCTypeENS1_2IDE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Types.cpp -nm=_ZN5clang6driver5types21lookupCXXTypeForCTypeENS1_2IDE")
//</editor-fold>
public static ID lookupCXXTypeForCType(ID Id) {
  switch (Id) {
   default:
    return Id;
   case TY_C:
    return types.ID.TY_CXX;
   case TY_PP_C:
    return types.ID.TY_PP_CXX;
   case TY_CHeader:
    return types.ID.TY_CXXHeader;
   case TY_PP_CHeader:
    return types.ID.TY_PP_CXXHeader;
  }
}

} // END OF class types
