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

package org.llvm.transforms.utils;

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
import org.llvm.ir.Value;


/// This is a class that can be implemented by clients to materialize Values on
/// demand.
//<editor-fold defaultstate="collapsed" desc="llvm::ValueMaterializer">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/Transforms/Utils/ValueMapper.h", line = 40,
 FQN="llvm::ValueMaterializer", NM="_ZN4llvm17ValueMaterializerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType ${LLVM_SRC}/llvm/lib/Linker/IRMover.cpp -nm=_ZN4llvm17ValueMaterializerE")
//</editor-fold>
public abstract class ValueMaterializer implements Destructors.ClassWithDestructor {
  //<editor-fold defaultstate="collapsed" desc="llvm::ValueMaterializer::anchor">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Transforms/Utils/ValueMapper.h", line = 41,
   FQN="llvm::ValueMaterializer::anchor", NM="_ZN4llvm17ValueMaterializer6anchorEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType ${LLVM_SRC}/llvm/lib/Linker/IRMover.cpp -nm=_ZN4llvm17ValueMaterializer6anchorEv")
  //</editor-fold>
  protected/*private*/ /*virtual*/ void anchor() {
    throw new UnsupportedOperationException("EmptyBody");
  }
 // Out of line method.

/*protected:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::ValueMaterializer::~ValueMaterializer">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Transforms/Utils/ValueMapper.h", line = 44,
   FQN="llvm::ValueMaterializer::~ValueMaterializer", NM="_ZN4llvm17ValueMaterializerD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType ${LLVM_SRC}/llvm/lib/Linker/IRMover.cpp -nm=_ZN4llvm17ValueMaterializerD0Ev")
  //</editor-fold>
  public/*protected*/ void $destroy()/* = default*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ValueMaterializer::ValueMaterializer">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Transforms/Utils/ValueMapper.h", line = 45,
   FQN="llvm::ValueMaterializer::ValueMaterializer", NM="_ZN4llvm17ValueMaterializerC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType ${LLVM_SRC}/llvm/lib/Linker/IRMover.cpp -nm=_ZN4llvm17ValueMaterializerC1Ev")
  //</editor-fold>
  protected ValueMaterializer()/* = default*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ValueMaterializer::ValueMaterializer">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Transforms/Utils/ValueMapper.h", line = 46,
   FQN="llvm::ValueMaterializer::ValueMaterializer", NM="_ZN4llvm17ValueMaterializerC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType ${LLVM_SRC}/llvm/lib/Linker/IRMover.cpp -nm=_ZN4llvm17ValueMaterializerC1ERKS0_")
  //</editor-fold>
  protected ValueMaterializer(final /*const*/ ValueMaterializer /*&*/ $Prm0)/* = default*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::ValueMaterializer::operator=">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Transforms/Utils/ValueMapper.h", line = 47,
   FQN="llvm::ValueMaterializer::operator=", NM="_ZN4llvm17ValueMaterializeraSERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType ${LLVM_SRC}/llvm/lib/Linker/IRMover.cpp -nm=_ZN4llvm17ValueMaterializeraSERKS0_")
  //</editor-fold>
  protected ValueMaterializer /*&*/ $assign(final /*const*/ ValueMaterializer /*&*/ $Prm0)/* = default*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


/*public:*/
  /// This method can be implemented to generate a mapped Value on demand. For
  /// example, if linking lazily. Returns null if the value is not materialized.
  //<editor-fold defaultstate="collapsed" desc="llvm::ValueMaterializer::materialize">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Transforms/Utils/ValueMapper.h", line = 52,
   FQN="llvm::ValueMaterializer::materialize", NM="_ZN4llvm17ValueMaterializer11materializeEPNS_5ValueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType ${LLVM_SRC}/llvm/lib/Linker/IRMover.cpp -nm=_ZN4llvm17ValueMaterializer11materializeEPNS_5ValueE")
  //</editor-fold>
  public abstract /*virtual*/ Value /*P*/ materialize(Value /*P*/ V)/* = 0*/;

  
  @Override public String toString() {
    return ""; // NOI18N
  }
}
