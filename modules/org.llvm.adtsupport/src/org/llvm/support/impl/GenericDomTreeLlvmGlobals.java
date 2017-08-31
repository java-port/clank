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
package org.llvm.support.impl;

import org.clank.support.*;
import org.llvm.support.*;


//<editor-fold defaultstate="collapsed" desc="static type GenericDomTreeLlvmGlobals">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 NM="org.llvm.support.impl.GenericDomTreeLlvmGlobals",
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -empty-body -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=Tpl__ZN4llvm12PrintDomTreeEPKNS_15DomTreeNodeBaseIT_EERNS_11raw_ostreamEj;Tpl__ZN4llvmlsERNS_11raw_ostreamEPKNS_15DomTreeNodeBaseIT_EE; -static-type=GenericDomTreeLlvmGlobals -package=org.llvm.support.impl")
//</editor-fold>
public final class GenericDomTreeLlvmGlobals {

/*template <class NodeT> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::operator<<">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/GenericDomTree.h", line = 157,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/GenericDomTree.h", old_line = 155,
 FQN="llvm::operator<<", NM="Tpl__ZN4llvmlsERNS_11raw_ostreamEPKNS_15DomTreeNodeBaseIT_EE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=Tpl__ZN4llvmlsERNS_11raw_ostreamEPKNS_15DomTreeNodeBaseIT_EE")
//</editor-fold>
public static </*class*/ NodeT> raw_ostream /*&*/ $out_raw_ostream_DomTreeNodeBase$NodeT$C$P(final raw_ostream /*&*/ o, /*const*/ DomTreeNodeBase<NodeT> /*P*/ Node) {
  throw new UnsupportedOperationException("EmptyBody");
}

/*template <class NodeT> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::PrintDomTree">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/GenericDomTree.h", line = 169,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/GenericDomTree.h", old_line = 167,
 FQN="llvm::PrintDomTree", NM="Tpl__ZN4llvm12PrintDomTreeEPKNS_15DomTreeNodeBaseIT_EERNS_11raw_ostreamEj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=Tpl__ZN4llvm12PrintDomTreeEPKNS_15DomTreeNodeBaseIT_EERNS_11raw_ostreamEj")
//</editor-fold>
public static </*class*/ NodeT> void PrintDomTree(/*const*/ DomTreeNodeBase<NodeT> /*P*/ N, final raw_ostream /*&*/ o, 
            /*uint*/int Lev) {
  throw new UnsupportedOperationException("EmptyBody");
}

} // END OF class GenericDomTreeLlvmGlobals
