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
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import org.llvm.ir.*;
import org.clang.codegen.CodeGen.impl.*;
import org.llvm.ir.Type;
import static org.clang.ast.java.AstDeclarationsRTTI.*;


//<editor-fold defaultstate="collapsed" desc="static type CGExprConstantStatics">
@Converted(kind = Converted.Kind.AUTO,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprConstant.cpp -nm=_ZL16EmitNullConstantRN5clang7CodeGen13CodeGenModuleEPKNS_13CXXRecordDeclEb;_ZL23EmitNullConstantForBaseRN5clang7CodeGen13CodeGenModuleEPN4llvm4TypeEPKNS_13CXXRecordDeclE; -static-type=CGExprConstantStatics -package=org.clang.codegen.impl")
//</editor-fold>
public final class CGExprConstantStatics {


/// Emit the null constant for a base subobject.
//<editor-fold defaultstate="collapsed" desc="EmitNullConstantForBase">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprConstant.cpp", line = 1590,
 FQN="EmitNullConstantForBase", NM="_ZL23EmitNullConstantForBaseRN5clang7CodeGen13CodeGenModuleEPN4llvm4TypeEPKNS_13CXXRecordDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprConstant.cpp -nm=_ZL23EmitNullConstantForBaseRN5clang7CodeGen13CodeGenModuleEPN4llvm4TypeEPKNS_13CXXRecordDeclE")
//</editor-fold>
public static Constant /*P*/ EmitNullConstantForBase(final CodeGenModule /*&*/ CGM, 
                       Type /*P*/ baseType, 
                       /*const*/ CXXRecordDecl /*P*/ base) {
  final /*const*/ CGRecordLayout /*&*/ baseLayout = CGM.getTypes().getCGRecordLayout(base);
  
  // Just zero out bases that don't have any pointer to data members.
  if (baseLayout.isZeroInitializableAsBase()) {
    return Constant.getNullValue(baseType);
  }
  
  // Otherwise, we can just use its null constant.
  return EmitNullConstant(CGM, base, /*asCompleteObject=*/ false);
}

//<editor-fold defaultstate="collapsed" desc="EmitNullConstant">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprConstant.cpp", line = 1509,
 FQN="EmitNullConstant", NM="_ZL16EmitNullConstantRN5clang7CodeGen13CodeGenModuleEPKNS_13CXXRecordDeclEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprConstant.cpp -nm=_ZL16EmitNullConstantRN5clang7CodeGen13CodeGenModuleEPKNS_13CXXRecordDeclEb")
//</editor-fold>
public static Constant /*P*/ EmitNullConstant(final CodeGenModule /*&*/ CGM, 
                /*const*/ CXXRecordDecl /*P*/ record, 
                boolean asCompleteObject) {
  std.vector<Constant /*P*/ > elements = null;
  try {
    final /*const*/ CGRecordLayout /*&*/ layout = CGM.getTypes().getCGRecordLayout(record);
    StructType /*P*/ structure = (asCompleteObject ? layout.getLLVMType() : layout.getBaseSubobjectLLVMType());
    
    /*uint*/int numElements = structure.getNumElements();
    elements/*J*/= new std.vector<Constant /*P*/ >(numElements, (Constant /*P*/ )null);
    
    // Fill in all the bases.
    for (final /*const*/ CXXBaseSpecifier /*&*/ I : record.bases$Const()) {
      if (I.isVirtual()) {
        // Ignore virtual bases; if we're laying out for a complete
        // object, we'll lay these out later.
        continue;
      }
      
      /*const*/ CXXRecordDecl /*P*/ base = cast_CXXRecordDecl(I.getType().$arrow().castAs$RecordType().getDecl());
      
      // Ignore empty bases.
      if (base.isEmpty()) {
        continue;
      }
      
      /*uint*/int fieldIndex = layout.getNonVirtualBaseLLVMFieldNo(base);
      Type /*P*/ baseType = structure.getElementType(fieldIndex);
      elements.$set(fieldIndex, EmitNullConstantForBase(CGM, baseType, base));
    }
    
    // Fill in all the fields.
    for (/*const*/ FieldDecl /*P*/ Field : record.fields()) {
      // Fill in non-bitfields. (Bitfields always use a zero pattern, which we
      // will fill in later.)
      if (!Field.isBitField()) {
        /*uint*/int fieldIndex = layout.getLLVMFieldNo(Field);
        elements.$set(fieldIndex, CGM.EmitNullConstant(Field.getType()));
      }
      
      // For unions, stop after the first named field.
      if (record.isUnion()) {
        if ((Field.getIdentifier() != null)) {
          break;
        }
        {
          /*const*/ RecordDecl /*P*/ FieldRD = dyn_cast_or_null_RecordDecl(Field.getType().$arrow().getAsTagDecl());
          if ((FieldRD != null)) {
            if ((FieldRD.findFirstNamedDataMember() != null)) {
              break;
            }
          }
        }
      }
    }
    
    // Fill in the virtual bases, if we're working with the complete object.
    if (asCompleteObject) {
      for (final /*const*/ CXXBaseSpecifier /*&*/ I : record.vbases$Const()) {
        /*const*/ CXXRecordDecl /*P*/ base = cast_CXXRecordDecl(I.getType().$arrow().castAs$RecordType().getDecl());
        
        // Ignore empty bases.
        if (base.isEmpty()) {
          continue;
        }
        
        /*uint*/int fieldIndex = layout.getVirtualBaseIndex(base);
        
        // We might have already laid this field out.
        if ((elements.$at(fieldIndex) != null)) {
          continue;
        }
        
        Type /*P*/ baseType = structure.getElementType(fieldIndex);
        elements.$set(fieldIndex, EmitNullConstantForBase(CGM, baseType, base));
      }
    }
    
    // Now go through all other fields and zero them out.
    for (/*uint*/int i = 0; i != numElements; ++i) {
      if (!(elements.$at(i) != null)) {
        elements.$set(i, Constant.getNullValue(structure.getElementType(i)));
      }
    }
    
    return ConstantStruct.get(structure, new ArrayRef<Constant /*P*/ >(elements, true));
  } finally {
    if (elements != null) { elements.$destroy(); }
  }
}

} // END OF class CGExprConstantStatics
