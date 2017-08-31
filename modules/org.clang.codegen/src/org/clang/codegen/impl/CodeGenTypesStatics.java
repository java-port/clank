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
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import org.llvm.ir.*;
import org.clang.codegen.CodeGen.impl.*;
import static org.clang.ast.java.AstDeclarationsRTTI.*;


//<editor-fold defaultstate="collapsed" desc="static type CodeGenTypesStatics">
@Converted(kind = Converted.Kind.AUTO,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenTypes.cpp -nm=_ZL15isSafeToConvertN5clang8QualTypeERNS_7CodeGen12CodeGenTypesERN4llvm11SmallPtrSetIPKNS_10RecordDeclELj16EEE;_ZL15isSafeToConvertPKN5clang10RecordDeclERNS_7CodeGen12CodeGenTypesE;_ZL15isSafeToConvertPKN5clang10RecordDeclERNS_7CodeGen12CodeGenTypesERN4llvm11SmallPtrSetIS2_Lj16EEE;_ZL16getTypeForFormatRN4llvm11LLVMContextERKNS_12fltSemanticsEb; -static-type=CodeGenTypesStatics -package=org.clang.codegen.impl")
//</editor-fold>
public final class CodeGenTypesStatics {


/// isSafeToConvert - Return true if it is safe to convert this field type,
/// which requires the structure elements contained by-value to all be
/// recursively safe to convert.
//<editor-fold defaultstate="collapsed" desc="isSafeToConvert">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenTypes.cpp", line = 153,
 FQN="isSafeToConvert", NM="_ZL15isSafeToConvertN5clang8QualTypeERNS_7CodeGen12CodeGenTypesERN4llvm11SmallPtrSetIPKNS_10RecordDeclELj16EEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenTypes.cpp -nm=_ZL15isSafeToConvertN5clang8QualTypeERNS_7CodeGen12CodeGenTypesERN4llvm11SmallPtrSetIPKNS_10RecordDeclELj16EEE")
//</editor-fold>
public static boolean isSafeToConvert(QualType T, final CodeGenTypes /*&*/ CGT, 
               final SmallPtrSet</*const*/ RecordDecl /*P*/ > /*&*/ AlreadyChecked) {
  {
    // Strip off atomic type sugar.
    /*const*/ AtomicType /*P*/ AT = T.$arrow().getAs(AtomicType.class);
    if ((AT != null)) {
      T.$assignMove(AT.getValueType());
    }
  }
  {
    
    // If this is a record, check it.
    /*const*/ RecordType /*P*/ RT = T.$arrow().getAs$RecordType();
    if ((RT != null)) {
      return isSafeToConvert(RT.getDecl(), CGT, AlreadyChecked);
    }
  }
  {
    
    // If this is an array, check the elements, which are embedded inline.
    /*const*/ org.clang.ast.ArrayType /*P*/ AT = CGT.getContext().getAsArrayType(new QualType(T));
    if ((AT != null)) {
      return isSafeToConvert(AT.getElementType(), CGT, AlreadyChecked);
    }
  }
  
  // Otherwise, there is no concern about transforming this.  We only care about
  // things that are contained by-value in a structure that can have another 
  // structure as a member.
  return true;
}


/// isSafeToConvert - Return true if it is safe to convert the specified record
/// decl to IR and lay it out, false if doing so would cause us to get into a
/// recursive compilation mess.
//<editor-fold defaultstate="collapsed" desc="isSafeToConvert">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenTypes.cpp", line = 112,
 FQN="isSafeToConvert", NM="_ZL15isSafeToConvertPKN5clang10RecordDeclERNS_7CodeGen12CodeGenTypesERN4llvm11SmallPtrSetIS2_Lj16EEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenTypes.cpp -nm=_ZL15isSafeToConvertPKN5clang10RecordDeclERNS_7CodeGen12CodeGenTypesERN4llvm11SmallPtrSetIS2_Lj16EEE")
//</editor-fold>
public static boolean isSafeToConvert(/*const*/ RecordDecl /*P*/ RD, final CodeGenTypes /*&*/ CGT, 
               final SmallPtrSet</*const*/ RecordDecl /*P*/ > /*&*/ AlreadyChecked) {
  // If we have already checked this type (maybe the same type is used by-value
  // multiple times in multiple structure fields, don't check again.
  if (!AlreadyChecked.insert(RD).second) {
    return true;
  }
  
  /*const*/ org.clang.ast.Type /*P*/ Key = CGT.getContext().getTagDeclType(RD).getTypePtr();
  
  // If this type is already laid out, converting it is a noop.
  if (CGT.isRecordLayoutComplete(Key)) {
    return true;
  }
  
  // If this type is currently being laid out, we can't recursively compile it.
  if (CGT.isRecordBeingLaidOut(Key)) {
    return false;
  }
  {
    
    // If this type would require laying out bases that are currently being laid
    // out, don't do it.  This includes virtual base classes which get laid out
    // when a class is translated, even though they aren't embedded by-value into
    // the class.
    /*const*/ CXXRecordDecl /*P*/ CRD = dyn_cast_CXXRecordDecl(RD);
    if ((CRD != null)) {
      for (final /*const*/ CXXBaseSpecifier /*&*/ I : CRD.bases$Const())  {
        if (!isSafeToConvert(I.getType().$arrow().getAs$RecordType().getDecl(), 
            CGT, AlreadyChecked)) {
          return false;
        }
      }
    }
  }
  
  // If this type would require laying out members that are currently being laid
  // out, don't do it.
  for (/*const*/ FieldDecl /*P*/ I : RD.fields())  {
    if (!isSafeToConvert(I.getType(), CGT, AlreadyChecked)) {
      return false;
    }
  }
  
  // If there are no problems, lets do it.
  return true;
}


/// isSafeToConvert - Return true if it is safe to convert the specified record
/// decl to IR and lay it out, false if doing so would cause us to get into a
/// recursive compilation mess.
//<editor-fold defaultstate="collapsed" desc="isSafeToConvert">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenTypes.cpp", line = 178,
 FQN="isSafeToConvert", NM="_ZL15isSafeToConvertPKN5clang10RecordDeclERNS_7CodeGen12CodeGenTypesE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenTypes.cpp -nm=_ZL15isSafeToConvertPKN5clang10RecordDeclERNS_7CodeGen12CodeGenTypesE")
//</editor-fold>
public static boolean isSafeToConvert(/*const*/ RecordDecl /*P*/ RD, final CodeGenTypes /*&*/ CGT) {
  // If no structs are being laid out, we can certainly do this one.
  if (CGT.noRecordsBeingLaidOut()) {
    return true;
  }
  
  SmallPtrSet</*const*/ RecordDecl /*P*/ > AlreadyChecked/*J*/= new SmallPtrSet</*const*/ RecordDecl /*P*/ >(DenseMapInfo$LikePtr.$Info(), 16);
  return isSafeToConvert(RD, CGT, AlreadyChecked);
}

//<editor-fold defaultstate="collapsed" desc="getTypeForFormat">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenTypes.cpp", line = 286,
 FQN="getTypeForFormat", NM="_ZL16getTypeForFormatRN4llvm11LLVMContextERKNS_12fltSemanticsEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenTypes.cpp -nm=_ZL16getTypeForFormatRN4llvm11LLVMContextERKNS_12fltSemanticsEb")
//</editor-fold>
public static org.llvm.ir.Type /*P*/ getTypeForFormat(final LLVMContext /*&*/ VMContext, 
                final /*const*/ fltSemantics /*&*/ format) {
  return getTypeForFormat(VMContext, 
                format, 
                false);
}
public static org.llvm.ir.Type /*P*/ getTypeForFormat(final LLVMContext /*&*/ VMContext, 
                final /*const*/ fltSemantics /*&*/ format, 
                boolean UseNativeHalf/*= false*/) {
  if (/*AddrOf*/format == /*AddrOf*/APFloat.IEEEhalf) {
    if (UseNativeHalf) {
      return org.llvm.ir.Type.getHalfTy(VMContext);
    } else {
      return org.llvm.ir.Type.getInt16Ty(VMContext);
    }
  }
  if (/*AddrOf*/format == /*AddrOf*/APFloat.IEEEsingle) {
    return org.llvm.ir.Type.getFloatTy(VMContext);
  }
  if (/*AddrOf*/format == /*AddrOf*/APFloat.IEEEdouble) {
    return org.llvm.ir.Type.getDoubleTy(VMContext);
  }
  if (/*AddrOf*/format == /*AddrOf*/APFloat.IEEEquad) {
    return org.llvm.ir.Type.getFP128Ty(VMContext);
  }
  if (/*AddrOf*/format == /*AddrOf*/APFloat.PPCDoubleDouble) {
    return org.llvm.ir.Type.getPPC_FP128Ty(VMContext);
  }
  if (/*AddrOf*/format == /*AddrOf*/APFloat.x87DoubleExtended) {
    return org.llvm.ir.Type.getX86_FP80Ty(VMContext);
  }
  throw new llvm_unreachable("Unknown float format!");
}

} // END OF class CodeGenTypesStatics
