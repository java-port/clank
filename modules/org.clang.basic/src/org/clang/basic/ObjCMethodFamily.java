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

package org.clang.basic;

import org.clank.support.*;
import org.clang.basic.*;
import static org.clang.basic.BasicClangGlobals.*;



/// \brief A family of Objective-C methods. 
///
/// These families have no inherent meaning in the language, but are
/// nonetheless central enough in the existing implementations to
/// merit direct AST support.  While, in theory, arbitrary methods can
/// be considered to form families, we focus here on the methods
/// involving allocation and retain-count management, as these are the
/// most "core" and the most likely to be useful to diverse clients
/// without extra information.
///
/// Both selectors and actual method declarations may be classified
/// into families.  Method families may impose additional restrictions
/// beyond their selector name; for example, a method called '_init'
/// that returns void is not considered to be in the 'init' family
/// (but would be if it returned 'id').  It is also possible to
/// explicitly change or remove a method's family.  Therefore the
/// method's family should be considered the single source of truth.
//<editor-fold defaultstate="collapsed" desc="clang::ObjCMethodFamily">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*value for Invalid*/,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/IdentifierTable.h", line = 566,
 old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/IdentifierTable.h", old_line = 551,
 FQN="clang::ObjCMethodFamily", NM="_ZN5clang16ObjCMethodFamilyE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/IdentifierTable.cpp -nm=_ZN5clang16ObjCMethodFamilyE")
//</editor-fold>
public enum ObjCMethodFamily implements Native.NativeUIntEnum {
  /// \brief No particular method family.
  OMF_None(0),
  
  // Selectors in these families may have arbitrary arity, may be
  // written with arbitrary leading underscores, and may have
  // additional CamelCase "words" in their first selector chunk
  // following the family name.
  OMF_alloc(OMF_None.getValue() + 1),
  OMF_copy(OMF_alloc.getValue() + 1),
  OMF_init(OMF_copy.getValue() + 1),
  OMF_mutableCopy(OMF_init.getValue() + 1),
  OMF_new(OMF_mutableCopy.getValue() + 1),
  
  // These families are singletons consisting only of the nullary
  // selector with the given name.
  OMF_autorelease(OMF_new.getValue() + 1),
  OMF_dealloc(OMF_autorelease.getValue() + 1),
  OMF_finalize(OMF_dealloc.getValue() + 1),
  OMF_release(OMF_finalize.getValue() + 1),
  OMF_retain(OMF_release.getValue() + 1),
  OMF_retainCount(OMF_retain.getValue() + 1),
  OMF_self(OMF_retainCount.getValue() + 1),
  OMF_initialize(OMF_self.getValue() + 1),
  
  // performSelector families
  OMF_performSelector(OMF_initialize.getValue() + 1),
  
  // JAVA: Value for Invalid Family
  OMF_INVALID_FAMILY(OMF_performSelector.getValue() + 1); 
  static {
    assert OMF_INVALID_FAMILY.getValue() == InvalidObjCMethodFamily : "must be " + InvalidObjCMethodFamily + " vs. " + OMF_INVALID_FAMILY.getValue();
  }
  
  //<editor-fold defaultstate="collapsed" desc="hidden">
  public static ObjCMethodFamily valueOf(int val) {
    ObjCMethodFamily out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
    assert out != null : "no value for " + val;
    assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
    return out;
  }

  private static final class Values {
    private static final ObjCMethodFamily[] VALUES;
    private static final ObjCMethodFamily[] _VALUES; // [0] not used
    static {
      int max = 0;
      int min = 0;
      for (ObjCMethodFamily kind : ObjCMethodFamily.values()) {
        if (kind.value > max) { max = kind.value; }
        if (kind.value < min) { min = kind.value; }
      }
      _VALUES = new ObjCMethodFamily[min < 0 ? (1-min) : 0];
      VALUES = new ObjCMethodFamily[max >= 0 ? (1+max) : 0];
      for (ObjCMethodFamily kind : ObjCMethodFamily.values()) {
        if (kind.value < 0) {
          _VALUES[-kind.value] = kind;
        } else {
          VALUES[kind.value] = kind;
        }
      }
    }
  }

  private final /*uint*/int value;
  private ObjCMethodFamily(int val) { this.value = (/*uint*/int)val;}
  @Override public final /*uint*/int getValue() { return value;}
  //</editor-fold>
}
