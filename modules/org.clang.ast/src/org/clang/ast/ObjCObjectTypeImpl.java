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
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;


/// A class providing a concrete implementation
/// of ObjCObjectType, so as to not increase the footprint of
/// ObjCInterfaceType.  Code outside of ASTContext and the core type
/// system should not reference this type.
//<editor-fold defaultstate="collapsed" desc="clang::ObjCObjectTypeImpl">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 4894,
 FQN="clang::ObjCObjectTypeImpl", NM="_ZN5clang18ObjCObjectTypeImplE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZN5clang18ObjCObjectTypeImplE")
//</editor-fold>
public class ObjCObjectTypeImpl extends /*public*/ ObjCObjectType implements /*public*/ FoldingSetImpl.Node {
  /*friend  class ASTContext*/
  
  // If anyone adds fields here, ObjCObjectType::getProtocolStorage()
  // will need to be modified.
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCObjectTypeImpl::ObjCObjectTypeImpl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 4900,
   FQN="clang::ObjCObjectTypeImpl::ObjCObjectTypeImpl", NM="_ZN5clang18ObjCObjectTypeImplC1ENS_8QualTypeES1_N4llvm8ArrayRefIS1_EENS3_IPNS_16ObjCProtocolDeclEEEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZN5clang18ObjCObjectTypeImplC1ENS_8QualTypeES1_N4llvm8ArrayRefIS1_EENS3_IPNS_16ObjCProtocolDeclEEEb")
  //</editor-fold>
  /*friend*/public/*private*/ ObjCObjectTypeImpl(QualType Canonical, QualType Base, 
      ArrayRef<QualType> typeArgs, 
      ArrayRef<ObjCProtocolDecl /*P*/ > protocols, 
      boolean isKindOf) {
    // : ObjCObjectType(Canonical, Base, typeArgs, protocols, isKindOf), FoldingSetNode() 
    //START JInit
    super(new QualType(Canonical), new QualType(Base), new ArrayRef<QualType>(typeArgs), new ArrayRef<ObjCProtocolDecl /*P*/ >(protocols), isKindOf);
    $Node();
    //END JInit
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCObjectTypeImpl::Profile">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp", line = 3209,
   FQN="clang::ObjCObjectTypeImpl::Profile", NM="_ZN5clang18ObjCObjectTypeImpl7ProfileERN4llvm16FoldingSetNodeIDE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZN5clang18ObjCObjectTypeImpl7ProfileERN4llvm16FoldingSetNodeIDE")
  //</editor-fold>
  public void Profile(final FoldingSetNodeID /*&*/ ID) {
    Profile(ID, getBaseType(), getTypeArgsAsWritten(), 
        llvm.makeArrayRef(qual_begin(), getNumProtocols()), 
        isKindOfTypeAsWritten());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ObjCObjectTypeImpl::Profile">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp", line = 3194,
   FQN="clang::ObjCObjectTypeImpl::Profile", NM="_ZN5clang18ObjCObjectTypeImpl7ProfileERN4llvm16FoldingSetNodeIDENS_8QualTypeENS1_8ArrayRefIS4_EENS5_IPNS_16ObjCProtocolDeclEEEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZN5clang18ObjCObjectTypeImpl7ProfileERN4llvm16FoldingSetNodeIDENS_8QualTypeENS1_8ArrayRefIS4_EENS5_IPNS_16ObjCProtocolDeclEEEb")
  //</editor-fold>
  public static void Profile(final FoldingSetNodeID /*&*/ ID, 
         QualType BaseType, 
         ArrayRef<QualType> typeArgs, 
         ArrayRef<ObjCProtocolDecl /*P*/ > protocols, 
         boolean isKindOf) {
    ID.AddPointer(BaseType.getAsOpaquePtr());
    ID.AddInteger_uint(typeArgs.size());
    for (QualType typeArg : typeArgs)  {
      ID.AddPointer(typeArg.getAsOpaquePtr());
    }
    ID.AddInteger_uint(protocols.size());
    for (ObjCProtocolDecl /*P*/ proto : protocols)  {
      ID.AddPointer(proto);
    }
    ID.AddBoolean(isKindOf);
  }

  
  @Override public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
