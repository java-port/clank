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

package org.clang.ast;

import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import org.llvm.adt.aliases.*;

//<editor-fold defaultstate="collapsed" desc="clang::CanProxyAdaptor<clang::FunctionProtoType>">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/CanonicalType.h", line = 481,
 FQN="clang::CanProxyAdaptor<clang::FunctionProtoType>", NM="_ZN5clang15CanProxyAdaptorINS_17FunctionProtoTypeEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZN5clang15CanProxyAdaptorINS_17FunctionProtoTypeEEE")
//</editor-fold>
public class/*struct*/ CanProxyAdaptorFunctionProtoType extends /*public*/ CanProxyBase<FunctionProtoType> implements CanProxyAdaptor<FunctionProtoType> {
  //<editor-fold defaultstate="collapsed" desc="clang::CanProxyAdaptor<clang::FunctionProtoType>::getReturnType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/CanonicalType.h", line = 484,
   FQN="clang::CanProxyAdaptor<clang::FunctionProtoType>::getReturnType", NM="_ZNK5clang15CanProxyAdaptorINS_17FunctionProtoTypeEE13getReturnTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZNK5clang15CanProxyAdaptorINS_17FunctionProtoTypeEE13getReturnTypeEv")
  //</editor-fold>
  public CanQual<Type> getReturnType() /*const*/ {
    return CanQual.<Type>CreateUnsafe(this.getTypePtr().getReturnType());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CanProxyAdaptor<clang::FunctionProtoType>::getExtInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/CanonicalType.h", line = 485,
   FQN="clang::CanProxyAdaptor<clang::FunctionProtoType>::getExtInfo", NM="_ZNK5clang15CanProxyAdaptorINS_17FunctionProtoTypeEE10getExtInfoEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZNK5clang15CanProxyAdaptorINS_17FunctionProtoTypeEE10getExtInfoEv")
  //</editor-fold>
  public FunctionType.ExtInfo getExtInfo() /*const*/ {
    return this.getTypePtr().getExtInfo();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CanProxyAdaptor<clang::FunctionProtoType>::getNumParams">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/CanonicalType.h", line = 486,
   FQN="clang::CanProxyAdaptor<clang::FunctionProtoType>::getNumParams", NM="_ZNK5clang15CanProxyAdaptorINS_17FunctionProtoTypeEE12getNumParamsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZNK5clang15CanProxyAdaptorINS_17FunctionProtoTypeEE12getNumParamsEv")
  //</editor-fold>
  public /*uint*/int getNumParams() /*const*/ {
    return this.getTypePtr().getNumParams();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CanProxyAdaptor<clang::FunctionProtoType>::hasExtParameterInfos">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/CanonicalType.h", line = 487,
   FQN="clang::CanProxyAdaptor<clang::FunctionProtoType>::hasExtParameterInfos", NM="_ZNK5clang15CanProxyAdaptorINS_17FunctionProtoTypeEE20hasExtParameterInfosEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZNK5clang15CanProxyAdaptorINS_17FunctionProtoTypeEE20hasExtParameterInfosEv")
  //</editor-fold>
  public boolean hasExtParameterInfos() /*const*/ {
    return this.getTypePtr().hasExtParameterInfos();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CanProxyAdaptor<clang::FunctionProtoType>::getExtParameterInfos">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/CanonicalType.h", line = 488,
   FQN="clang::CanProxyAdaptor<clang::FunctionProtoType>::getExtParameterInfos", NM="_ZNK5clang15CanProxyAdaptorINS_17FunctionProtoTypeEE20getExtParameterInfosEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZNK5clang15CanProxyAdaptorINS_17FunctionProtoTypeEE20getExtParameterInfosEv")
  //</editor-fold>
  public ArrayRef<FunctionProtoType.ExtParameterInfo> getExtParameterInfos() /*const*/ {
    return this.getTypePtr().getExtParameterInfos();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CanProxyAdaptor<clang::FunctionProtoType>::getParamType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/CanonicalType.h", line = 490,
   FQN="clang::CanProxyAdaptor<clang::FunctionProtoType>::getParamType", NM="_ZNK5clang15CanProxyAdaptorINS_17FunctionProtoTypeEE12getParamTypeEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZNK5clang15CanProxyAdaptorINS_17FunctionProtoTypeEE12getParamTypeEj")
  //</editor-fold>
  public CanQual<Type> getParamType(/*uint*/int i) /*const*/ {
    return CanQual.<Type>CreateUnsafe(this.getTypePtr().getParamType(i));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CanProxyAdaptor<clang::FunctionProtoType>::isVariadic">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/CanonicalType.h", line = 494,
   FQN="clang::CanProxyAdaptor<clang::FunctionProtoType>::isVariadic", NM="_ZNK5clang15CanProxyAdaptorINS_17FunctionProtoTypeEE10isVariadicEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZNK5clang15CanProxyAdaptorINS_17FunctionProtoTypeEE10isVariadicEv")
  //</editor-fold>
  public boolean isVariadic() /*const*/ {
    return this.getTypePtr().isVariadic();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CanProxyAdaptor<clang::FunctionProtoType>::getTypeQuals">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/CanonicalType.h", line = 495,
   FQN="clang::CanProxyAdaptor<clang::FunctionProtoType>::getTypeQuals", NM="_ZNK5clang15CanProxyAdaptorINS_17FunctionProtoTypeEE12getTypeQualsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZNK5clang15CanProxyAdaptorINS_17FunctionProtoTypeEE12getTypeQualsEv")
  //</editor-fold>
  public /*uint*/int getTypeQuals() /*const*/ {
    return this.getTypePtr().getTypeQuals();
  }

  
  /*typedef CanTypeIterator<FunctionProtoType::param_type_iterator> param_type_iterator*/
//  public final class param_type_iterator extends CanTypeIterator<type$ptr<QualType> >{ };
  
  //<editor-fold defaultstate="collapsed" desc="clang::CanProxyAdaptor<FunctionProtoType>::param_type_begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/CanonicalType.h", line = 500,
   FQN="clang::CanProxyAdaptor<FunctionProtoType>::param_type_begin", NM="_ZNK5clang15CanProxyAdaptorINS_17FunctionProtoTypeEE16param_type_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZNK5clang15CanProxyAdaptorINS_17FunctionProtoTypeEE16param_type_beginEv")
  //</editor-fold>
  public CanTypeIterator<type$ptr<QualType> > param_type_begin() /*const*/ {
    return new CanTypeIterator<type$ptr<QualType> >(/*J:ToBase*/super.getTypePtr().param_type_begin());
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CanProxyAdaptor<FunctionProtoType>::param_type_end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/CanonicalType.h", line = 504,
   FQN="clang::CanProxyAdaptor<FunctionProtoType>::param_type_end", NM="_ZNK5clang15CanProxyAdaptorINS_17FunctionProtoTypeEE14param_type_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZNK5clang15CanProxyAdaptorINS_17FunctionProtoTypeEE14param_type_endEv")
  //</editor-fold>
  public CanTypeIterator<type$ptr<QualType> > param_type_end() /*const*/ {
    return new CanTypeIterator<type$ptr<QualType> >(/*J:ToBase*/super.getTypePtr().param_type_end());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CanProxyAdaptor<clang::FunctionProtoType>::CanProxyAdaptor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/CanonicalType.h", line = 482,
   FQN="clang::CanProxyAdaptor<clang::FunctionProtoType>::CanProxyAdaptor", NM="_ZN5clang15CanProxyAdaptorINS_17FunctionProtoTypeEEC1EOS2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZN5clang15CanProxyAdaptorINS_17FunctionProtoTypeEEC1EOS2_")
  //</editor-fold>
  public /*inline*/ CanProxyAdaptorFunctionProtoType(JD$Move _dparam, final CanProxyAdaptorFunctionProtoType /*&&*/$Prm0) {
    // : CanProxyBase<FunctionProtoType>(static_cast<CanProxyAdaptorFunctionProtoType &&>()) 
    //START JInit
    super(JD$Move.INSTANCE, $Prm0);
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CanProxyAdaptor<clang::FunctionProtoType>::CanProxyAdaptor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/CanonicalType.h", line = 482,
   FQN="clang::CanProxyAdaptor<clang::FunctionProtoType>::CanProxyAdaptor", NM="_ZN5clang15CanProxyAdaptorINS_17FunctionProtoTypeEEC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZN5clang15CanProxyAdaptorINS_17FunctionProtoTypeEEC1Ev")
  //</editor-fold>
  public /*inline*/ CanProxyAdaptorFunctionProtoType() {
    // : CanProxyBase<FunctionProtoType>() 
    //START JInit
    super();
    //END JInit
  }

  
  @Override public String toString() {
    return "" + super.toString(); // NOI18N
  }
// Note: canonical function types never have exception specifications
}
