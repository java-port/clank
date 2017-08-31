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

package org.llvm.object;

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
import org.llvm.java.LlvmJavaDifferentiators.*;

//<editor-fold defaultstate="collapsed" desc="llvm::object::COFFSymbolRef">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/Object/COFF.h", line = 281,
 FQN="llvm::object::COFFSymbolRef", NM="_ZN4llvm6object13COFFSymbolRefE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZN4llvm6object13COFFSymbolRefE")
//</editor-fold>
public class COFFSymbolRef {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::object::COFFSymbolRef::COFFSymbolRef">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/COFF.h", line = 283,
   FQN="llvm::object::COFFSymbolRef::COFFSymbolRef", NM="_ZN4llvm6object13COFFSymbolRefC1EPKNS0_11coff_symbolINS_7support6detail31packed_endian_specific_integralItLNS3_10endiannessE1ELj1EEEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZN4llvm6object13COFFSymbolRefC1EPKNS0_11coff_symbolINS_7support6detail31packed_endian_specific_integralItLNS3_10endiannessE1ELj1EEEEE")
  //</editor-fold>
  public COFFSymbolRef(JD$Coff_symbol$ulittle16_t$C$P _dparam, /*const*/ coff_symbol<llvm.support.ulittle16_t> /*P*/ CS) {
    // : CS16(CS), CS32(null) 
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::object::COFFSymbolRef::COFFSymbolRef">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/COFF.h", line = 284,
   FQN="llvm::object::COFFSymbolRef::COFFSymbolRef", NM="_ZN4llvm6object13COFFSymbolRefC1EPKNS0_11coff_symbolINS_7support6detail31packed_endian_specific_integralIjLNS3_10endiannessE1ELj1EEEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZN4llvm6object13COFFSymbolRefC1EPKNS0_11coff_symbolINS_7support6detail31packed_endian_specific_integralIjLNS3_10endiannessE1ELj1EEEEE")
  //</editor-fold>
  public COFFSymbolRef(JD$Coff_symbol$ulittle32_t$C$P _dparam, /*const*/ coff_symbol<llvm.support.ulittle32_t> /*P*/ CS) {
    // : CS16(null), CS32(CS) 
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::object::COFFSymbolRef::COFFSymbolRef">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/COFF.h", line = 285,
   FQN="llvm::object::COFFSymbolRef::COFFSymbolRef", NM="_ZN4llvm6object13COFFSymbolRefC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZN4llvm6object13COFFSymbolRefC1Ev")
  //</editor-fold>
  public COFFSymbolRef() {
    // : CS16(null), CS32(null) 
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::object::COFFSymbolRef::getRawPtr">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/COFF.h", line = 287,
   FQN="llvm::object::COFFSymbolRef::getRawPtr", NM="_ZNK4llvm6object13COFFSymbolRef9getRawPtrEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZNK4llvm6object13COFFSymbolRef9getRawPtrEv")
  //</editor-fold>
  public /*const*/Object/*void P*/ getRawPtr() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::object::COFFSymbolRef::getGeneric">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/COFF.h", line = 291,
   FQN="llvm::object::COFFSymbolRef::getGeneric", NM="_ZNK4llvm6object13COFFSymbolRef10getGenericEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZNK4llvm6object13COFFSymbolRef10getGenericEv")
  //</editor-fold>
  public /*const*/ coff_symbol_generic /*P*/ getGeneric() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /*friend*///<editor-fold defaultstate="collapsed" desc="llvm::object::operator<">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/COFF.h", line = 297,
   FQN="llvm::object::operator<", NM="_ZN4llvm6objectltENS0_13COFFSymbolRefES1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZN4llvm6objectltENS0_13COFFSymbolRefES1_")
  //</editor-fold>
  public static boolean $less_COFFSymbolRef(COFFSymbolRef A, COFFSymbolRef B) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::object::COFFSymbolRef::isBigObj">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/COFF.h", line = 301,
   FQN="llvm::object::COFFSymbolRef::isBigObj", NM="_ZNK4llvm6object13COFFSymbolRef8isBigObjEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZNK4llvm6object13COFFSymbolRef8isBigObjEv")
  //</editor-fold>
  public boolean isBigObj() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::object::COFFSymbolRef::getShortName">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/COFF.h", line = 309,
   FQN="llvm::object::COFFSymbolRef::getShortName", NM="_ZNK4llvm6object13COFFSymbolRef12getShortNameEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZNK4llvm6object13COFFSymbolRef12getShortNameEv")
  //</editor-fold>
  public /*const*/char$ptr/*char P*/ getShortName() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::object::COFFSymbolRef::getStringTableOffset">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/COFF.h", line = 313,
   FQN="llvm::object::COFFSymbolRef::getStringTableOffset", NM="_ZNK4llvm6object13COFFSymbolRef20getStringTableOffsetEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZNK4llvm6object13COFFSymbolRef20getStringTableOffsetEv")
  //</editor-fold>
  public /*const*/ StringTableOffset /*&*/ getStringTableOffset() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::object::COFFSymbolRef::getValue">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/COFF.h", line = 318,
   FQN="llvm::object::COFFSymbolRef::getValue", NM="_ZNK4llvm6object13COFFSymbolRef8getValueEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZNK4llvm6object13COFFSymbolRef8getValueEv")
  //</editor-fold>
  public /*uint32_t*/int getValue() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::object::COFFSymbolRef::getSectionNumber">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/COFF.h", line = 320,
   FQN="llvm::object::COFFSymbolRef::getSectionNumber", NM="_ZNK4llvm6object13COFFSymbolRef16getSectionNumberEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZNK4llvm6object13COFFSymbolRef16getSectionNumberEv")
  //</editor-fold>
  public int/*int32_t*/ getSectionNumber() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::object::COFFSymbolRef::getType">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/COFF.h", line = 331,
   FQN="llvm::object::COFFSymbolRef::getType", NM="_ZNK4llvm6object13COFFSymbolRef7getTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZNK4llvm6object13COFFSymbolRef7getTypeEv")
  //</editor-fold>
  public /*uint16_t*/char getType() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::object::COFFSymbolRef::getStorageClass">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/COFF.h", line = 336,
   FQN="llvm::object::COFFSymbolRef::getStorageClass", NM="_ZNK4llvm6object13COFFSymbolRef15getStorageClassEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZNK4llvm6object13COFFSymbolRef15getStorageClassEv")
  //</editor-fold>
  public byte/*uint8_t*/ getStorageClass() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::object::COFFSymbolRef::getNumberOfAuxSymbols">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/COFF.h", line = 341,
   FQN="llvm::object::COFFSymbolRef::getNumberOfAuxSymbols", NM="_ZNK4llvm6object13COFFSymbolRef21getNumberOfAuxSymbolsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZNK4llvm6object13COFFSymbolRef21getNumberOfAuxSymbolsEv")
  //</editor-fold>
  public byte/*uint8_t*/ getNumberOfAuxSymbols() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::object::COFFSymbolRef::getBaseType">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/COFF.h", line = 346,
   FQN="llvm::object::COFFSymbolRef::getBaseType", NM="_ZNK4llvm6object13COFFSymbolRef11getBaseTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZNK4llvm6object13COFFSymbolRef11getBaseTypeEv")
  //</editor-fold>
  public byte/*uint8_t*/ getBaseType() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::object::COFFSymbolRef::getComplexType">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/COFF.h", line = 348,
   FQN="llvm::object::COFFSymbolRef::getComplexType", NM="_ZNK4llvm6object13COFFSymbolRef14getComplexTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZNK4llvm6object13COFFSymbolRef14getComplexTypeEv")
  //</editor-fold>
  public byte/*uint8_t*/ getComplexType() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::object::COFFSymbolRef::isAbsolute">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/COFF.h", line = 352,
   FQN="llvm::object::COFFSymbolRef::isAbsolute", NM="_ZNK4llvm6object13COFFSymbolRef10isAbsoluteEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZNK4llvm6object13COFFSymbolRef10isAbsoluteEv")
  //</editor-fold>
  public boolean isAbsolute() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::object::COFFSymbolRef::isExternal">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/COFF.h", line = 356,
   FQN="llvm::object::COFFSymbolRef::isExternal", NM="_ZNK4llvm6object13COFFSymbolRef10isExternalEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZNK4llvm6object13COFFSymbolRef10isExternalEv")
  //</editor-fold>
  public boolean isExternal() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::object::COFFSymbolRef::isCommon">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/COFF.h", line = 360,
   FQN="llvm::object::COFFSymbolRef::isCommon", NM="_ZNK4llvm6object13COFFSymbolRef8isCommonEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZNK4llvm6object13COFFSymbolRef8isCommonEv")
  //</editor-fold>
  public boolean isCommon() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::object::COFFSymbolRef::isUndefined">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/COFF.h", line = 365,
   FQN="llvm::object::COFFSymbolRef::isUndefined", NM="_ZNK4llvm6object13COFFSymbolRef11isUndefinedEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZNK4llvm6object13COFFSymbolRef11isUndefinedEv")
  //</editor-fold>
  public boolean isUndefined() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::object::COFFSymbolRef::isWeakExternal">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/COFF.h", line = 370,
   FQN="llvm::object::COFFSymbolRef::isWeakExternal", NM="_ZNK4llvm6object13COFFSymbolRef14isWeakExternalEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZNK4llvm6object13COFFSymbolRef14isWeakExternalEv")
  //</editor-fold>
  public boolean isWeakExternal() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::object::COFFSymbolRef::isFunctionDefinition">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/COFF.h", line = 374,
   FQN="llvm::object::COFFSymbolRef::isFunctionDefinition", NM="_ZNK4llvm6object13COFFSymbolRef20isFunctionDefinitionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZNK4llvm6object13COFFSymbolRef20isFunctionDefinitionEv")
  //</editor-fold>
  public boolean isFunctionDefinition() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::object::COFFSymbolRef::isFunctionLineInfo">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/COFF.h", line = 380,
   FQN="llvm::object::COFFSymbolRef::isFunctionLineInfo", NM="_ZNK4llvm6object13COFFSymbolRef18isFunctionLineInfoEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZNK4llvm6object13COFFSymbolRef18isFunctionLineInfoEv")
  //</editor-fold>
  public boolean isFunctionLineInfo() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::object::COFFSymbolRef::isAnyUndefined">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/COFF.h", line = 384,
   FQN="llvm::object::COFFSymbolRef::isAnyUndefined", NM="_ZNK4llvm6object13COFFSymbolRef14isAnyUndefinedEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZNK4llvm6object13COFFSymbolRef14isAnyUndefinedEv")
  //</editor-fold>
  public boolean isAnyUndefined() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::object::COFFSymbolRef::isFileRecord">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/COFF.h", line = 388,
   FQN="llvm::object::COFFSymbolRef::isFileRecord", NM="_ZNK4llvm6object13COFFSymbolRef12isFileRecordEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZNK4llvm6object13COFFSymbolRef12isFileRecordEv")
  //</editor-fold>
  public boolean isFileRecord() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::object::COFFSymbolRef::isSection">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/COFF.h", line = 392,
   FQN="llvm::object::COFFSymbolRef::isSection", NM="_ZNK4llvm6object13COFFSymbolRef9isSectionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZNK4llvm6object13COFFSymbolRef9isSectionEv")
  //</editor-fold>
  public boolean isSection() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::object::COFFSymbolRef::isSectionDefinition">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/COFF.h", line = 396,
   FQN="llvm::object::COFFSymbolRef::isSectionDefinition", NM="_ZNK4llvm6object13COFFSymbolRef19isSectionDefinitionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZNK4llvm6object13COFFSymbolRef19isSectionDefinitionEv")
  //</editor-fold>
  public boolean isSectionDefinition() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::object::COFFSymbolRef::isCLRToken">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/COFF.h", line = 408,
   FQN="llvm::object::COFFSymbolRef::isCLRToken", NM="_ZNK4llvm6object13COFFSymbolRef10isCLRTokenEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZNK4llvm6object13COFFSymbolRef10isCLRTokenEv")
  //</editor-fold>
  public boolean isCLRToken() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

/*private:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::object::COFFSymbolRef::isSet">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/COFF.h", line = 413,
   FQN="llvm::object::COFFSymbolRef::isSet", NM="_ZNK4llvm6object13COFFSymbolRef5isSetEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZNK4llvm6object13COFFSymbolRef5isSetEv")
  //</editor-fold>
  private boolean isSet() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  private /*const*/ coff_symbol<llvm.support.ulittle16_t> /*P*/ CS16;
  private /*const*/ coff_symbol<llvm.support.ulittle32_t> /*P*/ CS32;
  //<editor-fold defaultstate="collapsed" desc="llvm::object::COFFSymbolRef::COFFSymbolRef">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/COFF.h", line = 281,
   FQN="llvm::object::COFFSymbolRef::COFFSymbolRef", NM="_ZN4llvm6object13COFFSymbolRefC1EOS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZN4llvm6object13COFFSymbolRefC1EOS1_")
  //</editor-fold>
  public /*inline*/ COFFSymbolRef(JD$Move _dparam, final COFFSymbolRef /*&&*/$Prm0) {
    // : CS16(static_cast<COFFSymbolRef &&>().CS16), CS32(static_cast<COFFSymbolRef &&>().CS32) 
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  @Override public String toString() {
    return "" + "CS16=" + CS16 // NOI18N
              + ", CS32=" + CS32; // NOI18N
  }
}
