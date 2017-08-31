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

package org.llvm.transforms.utils.SymbolRewriter;

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
import org.llvm.ir.*;
import org.llvm.ir.legacy.*;
import org.llvm.support.yaml.*;
import org.llvm.transforms.*;
import org.llvm.transforms.java.TransformFunctionPointers.*;
import org.llvm.transforms.ipo.*;
import org.llvm.transforms.utils.*;

//<editor-fold defaultstate="collapsed" desc="llvm::SymbolRewriter::RewriteMapParser">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/Transforms/Utils/SymbolRewriter.h", line = 91,
 FQN="llvm::SymbolRewriter::RewriteMapParser", NM="_ZN4llvm14SymbolRewriter16RewriteMapParserE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Utils/SymbolRewriter.cpp -nm=_ZN4llvm14SymbolRewriter16RewriteMapParserE")
//</editor-fold>
public class RewriteMapParser {
/*public:*/
  // namespace
  //<editor-fold defaultstate="collapsed" desc="llvm::SymbolRewriter::RewriteMapParser::parse">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Transforms/Utils/SymbolRewriter.cpp", line = 231,
   FQN="llvm::SymbolRewriter::RewriteMapParser::parse", NM="_ZN4llvm14SymbolRewriter16RewriteMapParser5parseERKSsPNS_6iplistINS0_17RewriteDescriptorENS_12ilist_traitsIS5_EEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Utils/SymbolRewriter.cpp -nm=_ZN4llvm14SymbolRewriter16RewriteMapParser5parseERKSsPNS_6iplistINS0_17RewriteDescriptorENS_12ilist_traitsIS5_EEEE")
  //</editor-fold>
  public boolean parse(final /*const*/std.string/*&*/ MapFile, 
       iplist<RewriteDescriptor> /*P*/ DL) {
    throw new UnsupportedOperationException("EmptyBody");
  }

/*private:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::SymbolRewriter::RewriteMapParser::parse">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Transforms/Utils/SymbolRewriter.cpp", line = 246,
   FQN="llvm::SymbolRewriter::RewriteMapParser::parse", NM="_ZN4llvm14SymbolRewriter16RewriteMapParser5parseERSt10unique_ptrINS_12MemoryBufferESt14default_deleteIS3_EEPNS_6iplistINS0_17RewriteDescriptorENS_12ilist_traitsIS9_EEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Utils/SymbolRewriter.cpp -nm=_ZN4llvm14SymbolRewriter16RewriteMapParser5parseERSt10unique_ptrINS_12MemoryBufferESt14default_deleteIS3_EEPNS_6iplistINS0_17RewriteDescriptorENS_12ilist_traitsIS9_EEEE")
  //</editor-fold>
  private boolean parse(final std.unique_ptr<MemoryBuffer> /*&*/ MapFile, 
       iplist<RewriteDescriptor> /*P*/ DL) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::SymbolRewriter::RewriteMapParser::parseEntry">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Transforms/Utils/SymbolRewriter.cpp", line = 272,
   FQN="llvm::SymbolRewriter::RewriteMapParser::parseEntry", NM="_ZN4llvm14SymbolRewriter16RewriteMapParser10parseEntryERNS_4yaml6StreamERNS2_12KeyValueNodeEPNS_6iplistINS0_17RewriteDescriptorENS_12ilist_traitsIS8_EEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Utils/SymbolRewriter.cpp -nm=_ZN4llvm14SymbolRewriter16RewriteMapParser10parseEntryERNS_4yaml6StreamERNS2_12KeyValueNodeEPNS_6iplistINS0_17RewriteDescriptorENS_12ilist_traitsIS8_EEEE")
  //</editor-fold>
  private boolean parseEntry(final Stream /*&*/ YS, final KeyValueNode /*&*/ Entry, 
            iplist<RewriteDescriptor> /*P*/ DL) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::SymbolRewriter::RewriteMapParser::parseRewriteFunctionDescriptor">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Transforms/Utils/SymbolRewriter.cpp", line = 303,
   FQN="llvm::SymbolRewriter::RewriteMapParser::parseRewriteFunctionDescriptor", NM="_ZN4llvm14SymbolRewriter16RewriteMapParser30parseRewriteFunctionDescriptorERNS_4yaml6StreamEPNS2_10ScalarNodeEPNS2_11MappingNodeEPNS_6iplistINS0_17RewriteDescriptorENS_12ilist_traitsISA_EEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Utils/SymbolRewriter.cpp -nm=_ZN4llvm14SymbolRewriter16RewriteMapParser30parseRewriteFunctionDescriptorERNS_4yaml6StreamEPNS2_10ScalarNodeEPNS2_11MappingNodeEPNS_6iplistINS0_17RewriteDescriptorENS_12ilist_traitsISA_EEEE")
  //</editor-fold>
  private boolean parseRewriteFunctionDescriptor(final Stream /*&*/ YS, ScalarNode /*P*/ K, 
                                MappingNode /*P*/ Descriptor, 
                                iplist<RewriteDescriptor> /*P*/ DL) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::SymbolRewriter::RewriteMapParser::parseRewriteGlobalVariableDescriptor">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Transforms/Utils/SymbolRewriter.cpp", line = 371,
   FQN="llvm::SymbolRewriter::RewriteMapParser::parseRewriteGlobalVariableDescriptor", NM="_ZN4llvm14SymbolRewriter16RewriteMapParser36parseRewriteGlobalVariableDescriptorERNS_4yaml6StreamEPNS2_10ScalarNodeEPNS2_11MappingNodeEPNS_6iplistINS0_17RewriteDescriptorENS_12ilist_traitsISA_EEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Utils/SymbolRewriter.cpp -nm=_ZN4llvm14SymbolRewriter16RewriteMapParser36parseRewriteGlobalVariableDescriptorERNS_4yaml6StreamEPNS2_10ScalarNodeEPNS2_11MappingNodeEPNS_6iplistINS0_17RewriteDescriptorENS_12ilist_traitsISA_EEEE")
  //</editor-fold>
  private boolean parseRewriteGlobalVariableDescriptor(final Stream /*&*/ YS, ScalarNode /*P*/ K, 
                                      MappingNode /*P*/ Descriptor, 
                                      iplist<RewriteDescriptor> /*P*/ DL) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::SymbolRewriter::RewriteMapParser::parseRewriteGlobalAliasDescriptor">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Transforms/Utils/SymbolRewriter.cpp", line = 433,
   FQN="llvm::SymbolRewriter::RewriteMapParser::parseRewriteGlobalAliasDescriptor", NM="_ZN4llvm14SymbolRewriter16RewriteMapParser33parseRewriteGlobalAliasDescriptorERNS_4yaml6StreamEPNS2_10ScalarNodeEPNS2_11MappingNodeEPNS_6iplistINS0_17RewriteDescriptorENS_12ilist_traitsISA_EEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Utils/SymbolRewriter.cpp -nm=_ZN4llvm14SymbolRewriter16RewriteMapParser33parseRewriteGlobalAliasDescriptorERNS_4yaml6StreamEPNS2_10ScalarNodeEPNS2_11MappingNodeEPNS_6iplistINS0_17RewriteDescriptorENS_12ilist_traitsISA_EEEE")
  //</editor-fold>
  private boolean parseRewriteGlobalAliasDescriptor(final Stream /*&*/ YS, ScalarNode /*P*/ K, 
                                   MappingNode /*P*/ Descriptor, 
                                   iplist<RewriteDescriptor> /*P*/ DL) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::SymbolRewriter::RewriteMapParser::RewriteMapParser">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Transforms/Utils/SymbolRewriter.h", line = 91,
   FQN="llvm::SymbolRewriter::RewriteMapParser::RewriteMapParser", NM="_ZN4llvm14SymbolRewriter16RewriteMapParserC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Utils/SymbolRewriter.cpp -nm=_ZN4llvm14SymbolRewriter16RewriteMapParserC1Ev")
  //</editor-fold>
  public /*inline*/ RewriteMapParser() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  @Override public String toString() {
    return ""; // NOI18N
  }
}
