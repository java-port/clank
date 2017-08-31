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

package org.llvm.ir;

import org.clank.support.*;


/// This class defines the default behavior for configurable aspects of
/// ValueMap<>.  User Configs should inherit from this class to be as compatible
/// as possible with future versions of ValueMap.
/*template <typename KeyT, typename MutexT = sys::Mutex> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::ValueMapConfig">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/ValueMap.h", line = 52,
 FQN="llvm::ValueMapConfig", NM="_ZN4llvm14ValueMapConfigE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Utils/ValueMapper.cpp -nm=_ZN4llvm14ValueMapConfigE")
//</editor-fold>
public class/*struct*/ ValueMapConfig</*typename*/ KeyT/*, typename MutexT = sys::Mutex*/>  {
  /*typedef MutexT mutex_type*/
//  public final class mutex_type extends MutexT{ };
  
  /// If FollowRAUW is true, the ValueMap will update mappings on RAUW. If it's
  /// false, the ValueMap will leave the original mapping in place.
  //<editor-fold defaultstate="collapsed" desc="llvm::ValueMapConfig::(anonymous)">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/ValueMap.h", line = 58,
   FQN="llvm::ValueMapConfig::(anonymous)", NM="_ZN4llvm14ValueMapConfigE_Unnamed_enum",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Utils/ValueMapper.cpp -nm=_ZN4llvm14ValueMapConfigE_Unnamed_enum")
  //</editor-fold>
  /*enum ANONYMOUS_INT_CONSTANTS {*/
    public static final /*<dependent type>*/boolean FollowRAUW = true;
  /*}*/;
  
  // All methods will be called with a first argument of type ExtraData.  The
  // default implementations in this class take a templated first argument so
  // that users' subclasses can use any type they want without having to
  // override all the defaults.
  //<editor-fold defaultstate="collapsed" desc="llvm::ValueMapConfig::ExtraData">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/ValueMap.h", line = 64,
   FQN="llvm::ValueMapConfig::ExtraData", NM="_ZN4llvm14ValueMapConfig9ExtraDataE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Utils/ValueMapper.cpp -nm=_ZN4llvm14ValueMapConfig9ExtraDataE")
  //</editor-fold>
  public static class/*struct*/ ExtraData {
    
    @Override public String toString() {
      return ""; // NOI18N
    }
  };
  
  /*template <typename ExtraDataT> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="llvm::ValueMapConfig::onRAUW">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/ValueMap.h", line = 67,
   FQN="llvm::ValueMapConfig::onRAUW", NM="Tpl__ZN4llvm14ValueMapConfig6onRAUWERKT_T_S4_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Utils/ValueMapper.cpp -nm=Tpl__ZN4llvm14ValueMapConfig6onRAUWERKT_T_S4_")
  //</editor-fold>
  public static </*typename*/ ExtraDataT, KeyT> void onRAUW(final /*const*/ ExtraDataT /*&*/ $Prm0/*Data*/, KeyT $Prm1/*Old*/, KeyT $Prm2/*New*/) {
  }

  /*template <typename ExtraDataT> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="llvm::ValueMapConfig::onDelete">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/ValueMap.h", line = 69,
   FQN="llvm::ValueMapConfig::onDelete", NM="Tpl__ZN4llvm14ValueMapConfig8onDeleteERKT_T_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Utils/ValueMapper.cpp -nm=Tpl__ZN4llvm14ValueMapConfig8onDeleteERKT_T_")
  //</editor-fold>
  public static </*typename*/ ExtraDataT, KeyT> void onDelete(final /*const*/ ExtraDataT /*&*/ $Prm0/*Data*/, KeyT $Prm1/*Old*/) {
  }

  
  /// Returns a mutex that should be acquired around any changes to the map.
  /// This is only acquired from the CallbackVH (and held around calls to onRAUW
  /// and onDelete) and not inside other ValueMap methods.  NULL means that no
  /// mutex is necessary.
  /*template <typename ExtraDataT> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="llvm::ValueMapConfig::getMutex">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/ValueMap.h", line = 76,
   FQN="llvm::ValueMapConfig::getMutex", NM="Tpl__ZN4llvm14ValueMapConfig8getMutexERKT_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Utils/ValueMapper.cpp -nm=Tpl__ZN4llvm14ValueMapConfig8getMutexERKT_")
  //</editor-fold>
  public static  </*typename*/ ExtraDataT, MutexT> MutexT /*P*/ getMutex(final /*const*/ ExtraDataT /*&*/ $Prm0/*Data*/) {
    return null;
  }

  final Class<KeyT> cls;
  
  public ValueMapConfig(Class<KeyT> cls) {
    this.cls = cls;
  }

  
  @Override public String toString() {
    return ""; // NOI18N
  }
}
